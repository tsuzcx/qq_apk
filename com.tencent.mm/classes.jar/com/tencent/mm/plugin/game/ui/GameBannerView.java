package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMDotView;
import java.util.LinkedList;

public class GameBannerView
  extends LinearLayout
  implements ViewPager.e, View.OnClickListener
{
  private float hZz = 0.0F;
  private MMDotView hxP;
  private ViewPager kB;
  private int kQh = 0;
  private GameBannerView.b kXh;
  LinkedList<GameBannerView.a> kXi;
  am kXj = new am(new GameBannerView.1(this), true);
  private float kXk = 0.0F;
  private Context mContext;
  
  public GameBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    inflate(paramContext, g.f.game_banner_view, this);
    this.kXi = new LinkedList();
  }
  
  private void gA(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public final void Q(int paramInt) {}
  
  public final void R(int paramInt)
  {
    int i = paramInt % this.kXi.size();
    y.i("MicroMsg.GameBannerView", "now selected page %d, now exactly positon : %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((((GameBannerView.a)this.kXi.get(i)).kXm != null) && (g.DK())) {
      b.a(this.mContext, 11, 1101, i + 1, 1, this.kQh, null);
    }
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof GameBannerView.a)) {
      return;
    }
    Object localObject = (GameBannerView.a)paramView.getTag();
    paramView = ((GameBannerView.a)localObject).kXm;
    if (!bk.bl(((GameBannerView.a)localObject).kNZ))
    {
      paramView = ((GameBannerView.a)localObject).kNZ;
      i = c.an(this.mContext, paramView);
      b.a(this.mContext, 11, 1101, 1, i, this.kQh, null);
      return;
    }
    y.i("MicroMsg.GameBannerView", "null or nil url");
    localObject = new Bundle();
    ((Bundle)localObject).putCharSequence("game_app_id", paramView.field_appId);
    ((Bundle)localObject).putInt("game_report_from_scene", 5);
    int i = c.b(this.mContext, paramView.field_appId, null, (Bundle)localObject);
    b.a(this.mContext, 11, 1101, 1, i, this.kQh, null);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.hxP = ((MMDotView)findViewById(g.e.game_ad_dot));
    this.kB = ((ViewPager)findViewById(g.e.game_ad_flipper));
    this.kB.setOnPageChangeListener(this);
    this.kXh = new GameBannerView.b(this, (byte)0);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
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
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.kXk = f1;
      this.hZz = f2;
      break;
      i = (int)(f1 - this.kXk);
      int j = (int)(f2 - this.hZz);
      if (Math.abs(i) <= Math.abs(j)) {
        break;
      }
      gA(true);
      break;
      gA(false);
      this.kXk = 0.0F;
      this.hZz = 0.0F;
      break;
      this.kXj.stopTimer();
      continue;
      this.kXj.S(5000L, 5000L);
    }
  }
  
  public void setBannerList(LinkedList<GameBannerView.a> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      y.e("MicroMsg.GameBannerView", "Empty banner list");
      setVisibility(8);
      return;
    }
    y.i("MicroMsg.GameBannerView", "bannerList size", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    this.kXj.stopTimer();
    this.kXi.clear();
    this.kXi.addAll(paramLinkedList);
    this.kB.setAdapter(this.kXh);
    this.kB.m(paramLinkedList.size() * 1000, false);
    if (this.kXi.size() > 1) {
      this.kXj.S(5000L, 5000L);
    }
    this.hxP.setVisibility(8);
    setVisibility(0);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.kQh = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBannerView
 * JD-Core Version:    0.7.0.1
 */