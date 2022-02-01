package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMDotView;
import java.util.LinkedList;

public class GameBannerView
  extends LinearLayout
  implements View.OnClickListener, ViewPager.OnPageChangeListener
{
  private int IFc;
  private b INd;
  LinkedList<a> INe;
  MTimerHandler INf;
  private float cxM;
  private float cxN;
  private Context mContext;
  private MMDotView xUq;
  private ViewPager xUr;
  
  public GameBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41882);
    this.IFc = 0;
    this.INf = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.cxM = 0.0F;
    this.cxN = 0.0F;
    this.mContext = paramContext;
    inflate(paramContext, h.f.HYt, this);
    this.INe = new LinkedList();
    AppMethodBeat.o(41882);
  }
  
  private void ww(boolean paramBoolean)
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
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameBannerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    if (!(paramView.getTag() instanceof a))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBannerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41888);
      return;
    }
    localObject = (a)paramView.getTag();
    paramView = ((a)localObject).INh;
    int i;
    if (!Util.isNullOrNil(((a)localObject).ICi))
    {
      paramView = ((a)localObject).ICi;
      i = c.ba(this.mContext, paramView);
      com.tencent.mm.game.report.g.a(this.mContext, 11, 1101, 1, i, this.IFc, null);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBannerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41888);
      return;
      Log.i("MicroMsg.GameBannerView", "null or nil url");
      localObject = new Bundle();
      ((Bundle)localObject).putCharSequence("game_app_id", paramView.field_appId);
      ((Bundle)localObject).putInt("game_report_from_scene", 5);
      i = c.b(this.mContext, paramView.field_appId, null, (Bundle)localObject);
      com.tencent.mm.game.report.g.a(this.mContext, 11, 1101, 1, i, this.IFc, null);
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41883);
    super.onFinishInflate();
    this.xUq = ((MMDotView)findViewById(h.e.HTU));
    this.xUr = ((ViewPager)findViewById(h.e.HTV));
    this.xUr.setOnPageChangeListener(this);
    this.INd = new b((byte)0);
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
      this.cxM = f1;
      this.cxN = f2;
      break;
      i = (int)(f1 - this.cxM);
      int j = (int)(f2 - this.cxN);
      if (Math.abs(i) <= Math.abs(j)) {
        break;
      }
      ww(true);
      break;
      ww(false);
      this.cxM = 0.0F;
      this.cxN = 0.0F;
      break;
      this.INf.stopTimer();
      continue;
      this.INf.startTimer(5000L);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(41885);
    int i = paramInt % this.INe.size();
    Log.i("MicroMsg.GameBannerView", "now selected page %d, now exactly positon : %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((((a)this.INe.get(i)).INh != null) && (h.baz())) {
      com.tencent.mm.game.report.g.a(this.mContext, 11, 1101, i + 1, 1, this.IFc, null);
    }
    AppMethodBeat.o(41885);
  }
  
  public void setBannerList(LinkedList<a> paramLinkedList)
  {
    AppMethodBeat.i(41884);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      Log.e("MicroMsg.GameBannerView", "Empty banner list");
      setVisibility(8);
      AppMethodBeat.o(41884);
      return;
    }
    Log.i("MicroMsg.GameBannerView", "bannerList size", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    this.INf.stopTimer();
    this.INe.clear();
    this.INe.addAll(paramLinkedList);
    this.xUr.setAdapter(this.INd);
    this.xUr.setCurrentItem(paramLinkedList.size() * 1000, false);
    if (this.INe.size() > 1) {
      this.INf.startTimer(5000L);
    }
    this.xUq.setVisibility(8);
    setVisibility(0);
    AppMethodBeat.o(41884);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.IFc = paramInt;
  }
  
  public static final class a
  {
    public String ICi;
    public com.tencent.mm.pluginsdk.model.app.g INh;
    public int index;
    public String orc;
  }
  
  final class b
    extends androidx.viewpager.widget.a
  {
    private b() {}
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(41879);
      int i = GameBannerView.b(GameBannerView.this).size();
      paramViewGroup.removeView((View)paramObject);
      Log.i("MicroMsg.GameBannerView", "destroyItem : new positon = %d, now position = %d", new Object[] { Integer.valueOf(paramInt % i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(41879);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(41881);
      if (GameBannerView.b(GameBannerView.this).size() <= 1)
      {
        i = GameBannerView.b(GameBannerView.this).size();
        AppMethodBeat.o(41881);
        return i;
      }
      int i = GameBannerView.b(GameBannerView.this).size();
      AppMethodBeat.o(41881);
      return i * 1000 * 2;
    }
    
    public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(41880);
      int i = paramInt % GameBannerView.b(GameBannerView.this).size();
      View localView = View.inflate(GameBannerView.d(GameBannerView.this), h.f.HYu, null);
      localView.setTag(GameBannerView.b(GameBannerView.this).get(i));
      localView.setOnClickListener(GameBannerView.this);
      ImageView localImageView = (ImageView)localView.findViewById(h.e.HTW);
      String str = ((GameBannerView.a)GameBannerView.b(GameBannerView.this).get(i)).orc;
      Drawable localDrawable = localImageView.getDrawable();
      if ((localDrawable != null) && ((localDrawable instanceof j))) {
        ((j)localDrawable).setUrl(str);
      }
      try
      {
        for (;;)
        {
          paramViewGroup.addView(localView, 0);
          Log.i("MicroMsg.GameBannerView", "instantiateItem : new positon = %d, now position = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
          AppMethodBeat.o(41880);
          return localView;
          localImageView.setImageDrawable(new j(str, (byte)0));
        }
      }
      catch (Exception paramViewGroup)
      {
        for (;;)
        {
          Log.e("MicroMsg.GameBannerView", "add view failed, " + paramViewGroup.getMessage());
        }
      }
    }
    
    public final boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBannerView
 * JD-Core Version:    0.7.0.1
 */