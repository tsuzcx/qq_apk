package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMDotView;
import java.util.LinkedList;

public class GameBannerView
  extends LinearLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private float aTL;
  private float aTM;
  private Context mContext;
  private MMDotView nnw;
  private ViewPager pRH;
  private int uoy;
  private GameBannerView.b uwC;
  LinkedList<a> uwD;
  aw uwE;
  
  public GameBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41882);
    this.uoy = 0;
    this.uwE = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41878);
        if ((GameBannerView.a(GameBannerView.this) != null) && (GameBannerView.b(GameBannerView.this).size() > 1))
        {
          GameBannerView.a(GameBannerView.this).setCurrentItem(GameBannerView.a(GameBannerView.this).getCurrentItem() + 1, true);
          AppMethodBeat.o(41878);
          return true;
        }
        GameBannerView.c(GameBannerView.this).stopTimer();
        AppMethodBeat.o(41878);
        return false;
      }
    }, true);
    this.aTL = 0.0F;
    this.aTM = 0.0F;
    this.mContext = paramContext;
    inflate(paramContext, 2131494241, this);
    this.uwD = new LinkedList();
    AppMethodBeat.o(41882);
  }
  
  private void nn(boolean paramBoolean)
  {
    AppMethodBeat.i(41887);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(41887);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41888);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameBannerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    if (!(paramView.getTag() instanceof a))
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GameBannerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41888);
      return;
    }
    localObject = (a)paramView.getTag();
    paramView = ((a)localObject).uwG;
    int i;
    if (!bu.isNullOrNil(((a)localObject).ulF))
    {
      paramView = ((a)localObject).ulF;
      i = c.aD(this.mContext, paramView);
      f.a(this.mContext, 11, 1101, 1, i, this.uoy, null);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GameBannerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41888);
      return;
      ae.i("MicroMsg.GameBannerView", "null or nil url");
      localObject = new Bundle();
      ((Bundle)localObject).putCharSequence("game_app_id", paramView.field_appId);
      ((Bundle)localObject).putInt("game_report_from_scene", 5);
      i = c.a(this.mContext, paramView.field_appId, null, (Bundle)localObject);
      f.a(this.mContext, 11, 1101, 1, i, this.uoy, null);
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41883);
    super.onFinishInflate();
    this.nnw = ((MMDotView)findViewById(2131300345));
    this.pRH = ((ViewPager)findViewById(2131300346));
    this.pRH.setOnPageChangeListener(this);
    this.uwC = new GameBannerView.b(this, (byte)0);
    AppMethodBeat.o(41883);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(41886);
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    switch (i)
    {
    default: 
      switch (paramMotionEvent.getAction())
      {
      }
      break;
    }
    for (;;)
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(41886);
      return bool;
      this.aTL = f1;
      this.aTM = f2;
      break;
      i = (int)(f1 - this.aTL);
      int j = (int)(f2 - this.aTM);
      if (Math.abs(i) <= Math.abs(j)) {
        break;
      }
      nn(true);
      break;
      nn(false);
      this.aTL = 0.0F;
      this.aTM = 0.0F;
      break;
      this.uwE.stopTimer();
      continue;
      this.uwE.ay(5000L, 5000L);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(41885);
    int i = paramInt % this.uwD.size();
    ae.i("MicroMsg.GameBannerView", "now selected page %d, now exactly positon : %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((((a)this.uwD.get(i)).uwG != null) && (com.tencent.mm.kernel.g.ajM())) {
      f.a(this.mContext, 11, 1101, i + 1, 1, this.uoy, null);
    }
    AppMethodBeat.o(41885);
  }
  
  public void setBannerList(LinkedList<a> paramLinkedList)
  {
    AppMethodBeat.i(41884);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ae.e("MicroMsg.GameBannerView", "Empty banner list");
      setVisibility(8);
      AppMethodBeat.o(41884);
      return;
    }
    ae.i("MicroMsg.GameBannerView", "bannerList size", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    this.uwE.stopTimer();
    this.uwD.clear();
    this.uwD.addAll(paramLinkedList);
    this.pRH.setAdapter(this.uwC);
    this.pRH.setCurrentItem(paramLinkedList.size() * 1000, false);
    if (this.uwD.size() > 1) {
      this.uwE.ay(5000L, 5000L);
    }
    this.nnw.setVisibility(8);
    setVisibility(0);
    AppMethodBeat.o(41884);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.uoy = paramInt;
  }
  
  public static final class a
  {
    public String hOr;
    public int index;
    public String ulF;
    public com.tencent.mm.pluginsdk.model.app.g uwG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBannerView
 * JD-Core Version:    0.7.0.1
 */