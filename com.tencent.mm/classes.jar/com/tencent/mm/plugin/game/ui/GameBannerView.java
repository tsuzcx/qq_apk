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
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMDotView;
import java.util.LinkedList;

public class GameBannerView
  extends LinearLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private MMDotView jpZ;
  private ViewPager lz;
  private Context mContext;
  private int nok;
  private GameBannerView.b nvi;
  LinkedList<GameBannerView.a> nvj;
  ap nvk;
  private float nvl;
  private float nvm;
  
  public GameBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111722);
    this.nok = 0;
    this.nvk = new ap(new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(111718);
        if ((GameBannerView.a(GameBannerView.this) != null) && (GameBannerView.b(GameBannerView.this).size() > 1))
        {
          GameBannerView.a(GameBannerView.this).setCurrentItem(GameBannerView.a(GameBannerView.this).getCurrentItem() + 1, true);
          AppMethodBeat.o(111718);
          return true;
        }
        GameBannerView.c(GameBannerView.this).stopTimer();
        AppMethodBeat.o(111718);
        return false;
      }
    }, true);
    this.nvl = 0.0F;
    this.nvm = 0.0F;
    this.mContext = paramContext;
    inflate(paramContext, 2130969689, this);
    this.nvj = new LinkedList();
    AppMethodBeat.o(111722);
  }
  
  private void ij(boolean paramBoolean)
  {
    AppMethodBeat.i(111727);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(111727);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111728);
    if (!(paramView.getTag() instanceof GameBannerView.a))
    {
      AppMethodBeat.o(111728);
      return;
    }
    Object localObject = (GameBannerView.a)paramView.getTag();
    paramView = ((GameBannerView.a)localObject).nvo;
    if (!bo.isNullOrNil(((GameBannerView.a)localObject).nlW))
    {
      paramView = ((GameBannerView.a)localObject).nlW;
      i = com.tencent.mm.plugin.game.f.c.ax(this.mContext, paramView);
      com.tencent.mm.game.report.c.a(this.mContext, 11, 1101, 1, i, this.nok, null);
      AppMethodBeat.o(111728);
      return;
    }
    ab.i("MicroMsg.GameBannerView", "null or nil url");
    localObject = new Bundle();
    ((Bundle)localObject).putCharSequence("game_app_id", paramView.field_appId);
    ((Bundle)localObject).putInt("game_report_from_scene", 5);
    int i = com.tencent.mm.plugin.game.f.c.b(this.mContext, paramView.field_appId, null, (Bundle)localObject);
    com.tencent.mm.game.report.c.a(this.mContext, 11, 1101, 1, i, this.nok, null);
    AppMethodBeat.o(111728);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111723);
    super.onFinishInflate();
    this.jpZ = ((MMDotView)findViewById(2131824422));
    this.lz = ((ViewPager)findViewById(2131824421));
    this.lz.setOnPageChangeListener(this);
    this.nvi = new GameBannerView.b(this, (byte)0);
    AppMethodBeat.o(111723);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(111726);
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
      AppMethodBeat.o(111726);
      return bool;
      this.nvl = f1;
      this.nvm = f2;
      break;
      i = (int)(f1 - this.nvl);
      int j = (int)(f2 - this.nvm);
      if (Math.abs(i) <= Math.abs(j)) {
        break;
      }
      ij(true);
      break;
      ij(false);
      this.nvl = 0.0F;
      this.nvm = 0.0F;
      break;
      this.nvk.stopTimer();
      continue;
      this.nvk.ag(5000L, 5000L);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(111725);
    int i = paramInt % this.nvj.size();
    ab.i("MicroMsg.GameBannerView", "now selected page %d, now exactly positon : %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((((GameBannerView.a)this.nvj.get(i)).nvo != null) && (g.RG())) {
      com.tencent.mm.game.report.c.a(this.mContext, 11, 1101, i + 1, 1, this.nok, null);
    }
    AppMethodBeat.o(111725);
  }
  
  public void setBannerList(LinkedList<GameBannerView.a> paramLinkedList)
  {
    AppMethodBeat.i(111724);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ab.e("MicroMsg.GameBannerView", "Empty banner list");
      setVisibility(8);
      AppMethodBeat.o(111724);
      return;
    }
    ab.i("MicroMsg.GameBannerView", "bannerList size", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    this.nvk.stopTimer();
    this.nvj.clear();
    this.nvj.addAll(paramLinkedList);
    this.lz.setAdapter(this.nvi);
    this.lz.setCurrentItem(paramLinkedList.size() * 1000, false);
    if (this.nvj.size() > 1) {
      this.nvk.ag(5000L, 5000L);
    }
    this.jpZ.setVisibility(8);
    setVisibility(0);
    AppMethodBeat.o(111724);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.nok = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBannerView
 * JD-Core Version:    0.7.0.1
 */