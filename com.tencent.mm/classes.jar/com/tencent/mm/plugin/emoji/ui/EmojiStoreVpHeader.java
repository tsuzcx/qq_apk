package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.i;
import com.tencent.mm.plugin.emoji.model.a;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerImg;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMDotView;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreVpHeader
  extends LinearLayout
  implements ViewPager.OnPageChangeListener
{
  private View iCk;
  private MMDotView jpZ;
  private View ldP;
  private LinkedList<a> lnK;
  private i lnL;
  private float lnM;
  private float lnN;
  private EmojiStoreVpHeader.a lnO;
  private volatile boolean lnP;
  private final int lnQ;
  private final int lnR;
  private ViewPager lz;
  
  public EmojiStoreVpHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(53511);
    this.lnQ = 5;
    this.lnR = 0;
    setOrientation(1);
    AppMethodBeat.o(53511);
  }
  
  public EmojiStoreVpHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(53512);
    this.lnQ = 5;
    this.lnR = 0;
    setOrientation(1);
    AppMethodBeat.o(53512);
  }
  
  private void bmU()
  {
    try
    {
      AppMethodBeat.i(53514);
      if (this.lnK == null)
      {
        IllegalAccessError localIllegalAccessError = new IllegalAccessError("must has emoji baner list first");
        AppMethodBeat.o(53514);
        throw localIllegalAccessError;
      }
    }
    finally {}
    int i;
    if (this.iCk == null)
    {
      this.iCk = inflate(getContext(), 2130969419, null);
      this.ldP = this.iCk.findViewById(2131823713);
      this.jpZ = ((MMDotView)this.iCk.findViewById(2131823715));
      this.lz = ((ViewPager)this.iCk.findViewById(2131823714));
      this.lnO = new EmojiStoreVpHeader.a(this, (byte)0);
      i = dh(getContext())[0] * 3 / 8;
      if (this.ldP != null) {
        this.ldP.setLayoutParams(new LinearLayout.LayoutParams(-1, i + 1));
      }
      addView(this.iCk, new LinearLayout.LayoutParams(-1, -2));
    }
    if (this.jpZ != null)
    {
      MMDotView localMMDotView = this.jpZ;
      if (this.lnK == null)
      {
        i = 0;
        localMMDotView.setDotCount(i);
        this.jpZ.setSelectedDot(0);
        this.jpZ.setVisibility(8);
      }
    }
    else
    {
      if ((this.lz != null) && (this.lnK != null)) {
        break label249;
      }
      AppMethodBeat.o(53514);
    }
    for (;;)
    {
      return;
      i = this.lnK.size();
      break;
      label249:
      if (this.lnK.size() <= 0)
      {
        if (this.ldP != null) {
          this.ldP.setVisibility(8);
        }
        AppMethodBeat.o(53514);
      }
      else
      {
        if (this.ldP != null) {
          this.ldP.setVisibility(0);
        }
        this.lz.setOnPageChangeListener(this);
        if (this.lnL == null)
        {
          this.lnL = new i(getContext(), this.lnK);
          this.lz.setAdapter(this.lnL);
          this.lz.setOffscreenPageLimit(1);
          bmV();
          AppMethodBeat.o(53514);
        }
        else
        {
          post(new EmojiStoreVpHeader.1(this));
          AppMethodBeat.o(53514);
        }
      }
    }
  }
  
  private void bmV()
  {
    AppMethodBeat.i(53515);
    if (this.lz == null)
    {
      AppMethodBeat.o(53515);
      return;
    }
    this.lz.setCurrentItem(i.leD / 2 * this.lnK.size(), false);
    AppMethodBeat.o(53515);
  }
  
  public static int[] dh(Context paramContext)
  {
    AppMethodBeat.i(53513);
    int[] arrayOfInt = new int[2];
    if ((paramContext instanceof Activity))
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      arrayOfInt[0] = localDisplayMetrics.widthPixels;
      arrayOfInt[1] = localDisplayMetrics.heightPixels;
    }
    for (;;)
    {
      AppMethodBeat.o(53513);
      return arrayOfInt;
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      arrayOfInt[0] = paramContext.getWidth();
      arrayOfInt[1] = paramContext.getHeight();
    }
  }
  
  private void gH(boolean paramBoolean)
  {
    AppMethodBeat.i(53522);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(53522);
  }
  
  public final void bmW()
  {
    AppMethodBeat.i(53516);
    if (this.lnO == null) {
      this.lnO = new EmojiStoreVpHeader.a(this, (byte)0);
    }
    this.lnP = true;
    this.lnO.removeMessages(0);
    this.lnO.sendEmptyMessageDelayed(0, 5000L);
    AppMethodBeat.o(53516);
  }
  
  public final void bmX()
  {
    AppMethodBeat.i(53517);
    if (this.lnO == null)
    {
      AppMethodBeat.o(53517);
      return;
    }
    this.lnP = false;
    this.lnO.removeMessages(0);
    AppMethodBeat.o(53517);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(53518);
    if (this.lnL != null)
    {
      this.lnL.clear();
      this.lnL = null;
    }
    this.lnO = null;
    AppMethodBeat.o(53518);
  }
  
  public final void d(LinkedList<EmotionBanner> paramLinkedList, LinkedList<EmotionBannerSet> paramLinkedList1)
  {
    AppMethodBeat.i(53519);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(53519);
      return;
    }
    if (this.lnK == null) {
      this.lnK = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList1 = paramLinkedList1.iterator();
      while (paramLinkedList1.hasNext())
      {
        EmotionBannerSet localEmotionBannerSet = (EmotionBannerSet)paramLinkedList1.next();
        if ((localEmotionBannerSet != null) && (localEmotionBannerSet.BannerImg != null) && (!bo.isNullOrNil(localEmotionBannerSet.BannerImg.StripUrl))) {
          this.lnK.add(new a(null, localEmotionBannerSet, true));
        }
      }
      this.lnK.clear();
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList1 = (EmotionBanner)paramLinkedList.next();
      if ((paramLinkedList1 != null) && (paramLinkedList1.BannerImg != null) && (!bo.isNullOrNil(paramLinkedList1.BannerImg.StripUrl))) {
        this.lnK.add(new a(paramLinkedList1, null, false));
      }
    }
    bmU();
    AppMethodBeat.o(53519);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(53521);
    int i = paramMotionEvent.getAction();
    int j = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    switch (j)
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(53521);
      return bool;
      this.lnM = f1;
      this.lnN = f2;
      break;
      j = (int)(f1 - this.lnM);
      int k = (int)(f2 - this.lnN);
      if (Math.abs(j) <= Math.abs(k)) {
        break;
      }
      gH(true);
      break;
      this.lnM = 0.0F;
      this.lnN = 0.0F;
      gH(false);
      break;
      bmX();
      continue;
      bmW();
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(53520);
    if ((this.lnK == null) || (this.lnK.size() <= 1))
    {
      AppMethodBeat.o(53520);
      return;
    }
    if ((paramInt == 0) || (paramInt == this.lnL.getCount() - 1)) {
      this.iCk.postDelayed(new EmojiStoreVpHeader.2(this), 350L);
    }
    AppMethodBeat.o(53520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader
 * JD-Core Version:    0.7.0.1
 */