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
import com.tencent.mm.game.report.e;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMDotView;
import java.util.LinkedList;

public class GameBannerView
  extends LinearLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private Context mContext;
  private MMDotView mfR;
  private ViewPager oEa;
  private float qXK;
  private int rXI;
  private GameBannerView.b seN;
  LinkedList<a> seO;
  av seP;
  private float seQ;
  
  public GameBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41882);
    this.rXI = 0;
    this.seP = new av(new av.a()
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
    this.qXK = 0.0F;
    this.seQ = 0.0F;
    this.mContext = paramContext;
    inflate(paramContext, 2131494241, this);
    this.seO = new LinkedList();
    AppMethodBeat.o(41882);
  }
  
  private void lW(boolean paramBoolean)
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
    if (!(paramView.getTag() instanceof a))
    {
      AppMethodBeat.o(41888);
      return;
    }
    Object localObject = (a)paramView.getTag();
    paramView = ((a)localObject).seS;
    if (!bt.isNullOrNil(((a)localObject).rUV))
    {
      paramView = ((a)localObject).rUV;
      i = c.ax(this.mContext, paramView);
      e.a(this.mContext, 11, 1101, 1, i, this.rXI, null);
      AppMethodBeat.o(41888);
      return;
    }
    ad.i("MicroMsg.GameBannerView", "null or nil url");
    localObject = new Bundle();
    ((Bundle)localObject).putCharSequence("game_app_id", paramView.field_appId);
    ((Bundle)localObject).putInt("game_report_from_scene", 5);
    int i = c.a(this.mContext, paramView.field_appId, null, (Bundle)localObject);
    e.a(this.mContext, 11, 1101, 1, i, this.rXI, null);
    AppMethodBeat.o(41888);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41883);
    super.onFinishInflate();
    this.mfR = ((MMDotView)findViewById(2131300345));
    this.oEa = ((ViewPager)findViewById(2131300346));
    this.oEa.setOnPageChangeListener(this);
    this.seN = new GameBannerView.b(this, (byte)0);
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
      this.qXK = f1;
      this.seQ = f2;
      break;
      i = (int)(f1 - this.qXK);
      int j = (int)(f2 - this.seQ);
      if (Math.abs(i) <= Math.abs(j)) {
        break;
      }
      lW(true);
      break;
      lW(false);
      this.qXK = 0.0F;
      this.seQ = 0.0F;
      break;
      this.seP.stopTimer();
      continue;
      this.seP.av(5000L, 5000L);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(41885);
    int i = paramInt % this.seO.size();
    ad.i("MicroMsg.GameBannerView", "now selected page %d, now exactly positon : %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((((a)this.seO.get(i)).seS != null) && (com.tencent.mm.kernel.g.afw())) {
      e.a(this.mContext, 11, 1101, i + 1, 1, this.rXI, null);
    }
    AppMethodBeat.o(41885);
  }
  
  public void setBannerList(LinkedList<a> paramLinkedList)
  {
    AppMethodBeat.i(41884);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ad.e("MicroMsg.GameBannerView", "Empty banner list");
      setVisibility(8);
      AppMethodBeat.o(41884);
      return;
    }
    ad.i("MicroMsg.GameBannerView", "bannerList size", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    this.seP.stopTimer();
    this.seO.clear();
    this.seO.addAll(paramLinkedList);
    this.oEa.setAdapter(this.seN);
    this.oEa.setCurrentItem(paramLinkedList.size() * 1000, false);
    if (this.seO.size() > 1) {
      this.seP.av(5000L, 5000L);
    }
    this.mfR.setVisibility(8);
    setVisibility(0);
    AppMethodBeat.o(41884);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.rXI = paramInt;
  }
  
  public static final class a
  {
    public String gSG;
    public int index;
    public String rUV;
    public com.tencent.mm.pluginsdk.model.app.g seS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBannerView
 * JD-Core Version:    0.7.0.1
 */