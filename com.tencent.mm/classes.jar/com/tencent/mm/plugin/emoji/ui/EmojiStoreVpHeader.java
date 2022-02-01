package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMDotView;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreVpHeader
  extends LinearLayout
  implements ViewPager.OnPageChangeListener
{
  private View iCR;
  private View jCI;
  private MMDotView nio;
  private ViewPager pLc;
  private LinkedList<a> pLd;
  private i pLe;
  private float pLf;
  private float pLg;
  private a pLh;
  private volatile boolean pLi;
  private final int pLj;
  private final int pLk;
  
  public EmojiStoreVpHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(109071);
    this.pLj = 5;
    this.pLk = 0;
    setOrientation(1);
    AppMethodBeat.o(109071);
  }
  
  public EmojiStoreVpHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109072);
    this.pLj = 5;
    this.pLk = 0;
    setOrientation(1);
    AppMethodBeat.o(109072);
  }
  
  private void ciu()
  {
    try
    {
      AppMethodBeat.i(109074);
      if (this.pLd == null)
      {
        IllegalAccessError localIllegalAccessError = new IllegalAccessError("must has emoji baner list first");
        AppMethodBeat.o(109074);
        throw localIllegalAccessError;
      }
    }
    finally {}
    int i;
    if (this.iCR == null)
    {
      this.iCR = inflate(getContext(), 2131493831, null);
      this.jCI = this.iCR.findViewById(2131299439);
      this.nio = ((MMDotView)this.iCR.findViewById(2131299438));
      this.pLc = ((ViewPager)this.iCR.findViewById(2131299440));
      this.pLh = new a((byte)0);
      i = eB(getContext())[0] * 3 / 8;
      if (this.jCI != null) {
        this.jCI.setLayoutParams(new LinearLayout.LayoutParams(-1, i + 1));
      }
      addView(this.iCR, new LinearLayout.LayoutParams(-1, -2));
    }
    if (this.nio != null)
    {
      MMDotView localMMDotView = this.nio;
      if (this.pLd == null)
      {
        i = 0;
        localMMDotView.setDotCount(i);
        this.nio.setSelectedDot(0);
        this.nio.setVisibility(8);
      }
    }
    else
    {
      if ((this.pLc != null) && (this.pLd != null)) {
        break label249;
      }
      AppMethodBeat.o(109074);
    }
    for (;;)
    {
      return;
      i = this.pLd.size();
      break;
      label249:
      if (this.pLd.size() <= 0)
      {
        if (this.jCI != null) {
          this.jCI.setVisibility(8);
        }
        AppMethodBeat.o(109074);
      }
      else
      {
        if (this.jCI != null) {
          this.jCI.setVisibility(0);
        }
        this.pLc.setOnPageChangeListener(this);
        if (this.pLe == null)
        {
          this.pLe = new i(getContext(), this.pLd);
          this.pLc.setAdapter(this.pLe);
          this.pLc.setOffscreenPageLimit(1);
          civ();
          AppMethodBeat.o(109074);
        }
        else
        {
          post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(109068);
              if ((EmojiStoreVpHeader.a(EmojiStoreVpHeader.this) != null) && (EmojiStoreVpHeader.b(EmojiStoreVpHeader.this) != null))
              {
                i locali = EmojiStoreVpHeader.a(EmojiStoreVpHeader.this);
                LinkedList localLinkedList = EmojiStoreVpHeader.b(EmojiStoreVpHeader.this);
                locali.pBx.clear();
                locali.pBx.addAll(localLinkedList);
                locali.notifyDataSetChanged();
              }
              AppMethodBeat.o(109068);
            }
          });
          AppMethodBeat.o(109074);
        }
      }
    }
  }
  
  private void civ()
  {
    AppMethodBeat.i(109075);
    if (this.pLc == null)
    {
      AppMethodBeat.o(109075);
      return;
    }
    this.pLc.setCurrentItem(i.pBy / 2 * this.pLd.size(), false);
    AppMethodBeat.o(109075);
  }
  
  public static int[] eB(Context paramContext)
  {
    AppMethodBeat.i(109073);
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
      AppMethodBeat.o(109073);
      return arrayOfInt;
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      arrayOfInt[0] = paramContext.getWidth();
      arrayOfInt[1] = paramContext.getHeight();
    }
  }
  
  private void kt(boolean paramBoolean)
  {
    AppMethodBeat.i(109082);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(109082);
  }
  
  public final void ciw()
  {
    AppMethodBeat.i(109076);
    if (this.pLh == null) {
      this.pLh = new a((byte)0);
    }
    this.pLi = true;
    this.pLh.removeMessages(0);
    this.pLh.sendEmptyMessageDelayed(0, 5000L);
    AppMethodBeat.o(109076);
  }
  
  public final void cix()
  {
    AppMethodBeat.i(109077);
    if (this.pLh == null)
    {
      AppMethodBeat.o(109077);
      return;
    }
    this.pLi = false;
    this.pLh.removeMessages(0);
    AppMethodBeat.o(109077);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(109078);
    if (this.pLe != null)
    {
      this.pLe.clear();
      this.pLe = null;
    }
    this.pLh = null;
    AppMethodBeat.o(109078);
  }
  
  public final void d(LinkedList<EmotionBanner> paramLinkedList, LinkedList<EmotionBannerSet> paramLinkedList1)
  {
    AppMethodBeat.i(109079);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(109079);
      return;
    }
    if (this.pLd == null) {
      this.pLd = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList1 = paramLinkedList1.iterator();
      while (paramLinkedList1.hasNext())
      {
        EmotionBannerSet localEmotionBannerSet = (EmotionBannerSet)paramLinkedList1.next();
        if ((localEmotionBannerSet != null) && (localEmotionBannerSet.BannerImg != null) && (!bt.isNullOrNil(localEmotionBannerSet.BannerImg.StripUrl))) {
          this.pLd.add(new a(null, localEmotionBannerSet, true));
        }
      }
      this.pLd.clear();
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList1 = (EmotionBanner)paramLinkedList.next();
      if ((paramLinkedList1 != null) && (paramLinkedList1.BannerImg != null) && (!bt.isNullOrNil(paramLinkedList1.BannerImg.StripUrl))) {
        this.pLd.add(new a(paramLinkedList1, null, false));
      }
    }
    ciu();
    AppMethodBeat.o(109079);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(109081);
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
      AppMethodBeat.o(109081);
      return bool;
      this.pLf = f1;
      this.pLg = f2;
      break;
      j = (int)(f1 - this.pLf);
      int k = (int)(f2 - this.pLg);
      if (Math.abs(j) <= Math.abs(k)) {
        break;
      }
      kt(true);
      break;
      this.pLf = 0.0F;
      this.pLg = 0.0F;
      kt(false);
      break;
      cix();
      continue;
      ciw();
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(109080);
    if ((this.pLd == null) || (this.pLd.size() <= 1))
    {
      AppMethodBeat.o(109080);
      return;
    }
    if ((paramInt == 0) || (paramInt == this.pLe.getCount() - 1)) {
      this.iCR.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(109069);
          EmojiStoreVpHeader.c(EmojiStoreVpHeader.this);
          AppMethodBeat.o(109069);
        }
      }, 350L);
    }
    AppMethodBeat.o(109080);
  }
  
  final class a
    extends ap
  {
    private a() {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(109070);
      if ((!EmojiStoreVpHeader.d(EmojiStoreVpHeader.this)) && (paramMessage.what != 0))
      {
        AppMethodBeat.o(109070);
        return;
      }
      if ((EmojiStoreVpHeader.b(EmojiStoreVpHeader.this) == null) || (EmojiStoreVpHeader.b(EmojiStoreVpHeader.this).size() <= 1))
      {
        ad.w("MicroMsg.emoji.EmojiStoreVpHeader", "list is null");
        AppMethodBeat.o(109070);
        return;
      }
      if (EmojiStoreVpHeader.a(EmojiStoreVpHeader.this) == null)
      {
        ad.w("MicroMsg.emoji.EmojiStoreVpHeader", "adapter is null");
        AppMethodBeat.o(109070);
        return;
      }
      int j = EmojiStoreVpHeader.e(EmojiStoreVpHeader.this).getCurrentItem() + 1;
      int i = j;
      if (j >= EmojiStoreVpHeader.a(EmojiStoreVpHeader.this).getCount()) {
        i = EmojiStoreVpHeader.b(EmojiStoreVpHeader.this).size() * i.pBy / 2;
      }
      EmojiStoreVpHeader.e(EmojiStoreVpHeader.this).setCurrentItem(i);
      if ((EmojiStoreVpHeader.d(EmojiStoreVpHeader.this)) && (EmojiStoreVpHeader.f(EmojiStoreVpHeader.this) != null)) {
        sendMessageDelayed(EmojiStoreVpHeader.f(EmojiStoreVpHeader.this).obtainMessage(0), 5000L);
      }
      AppMethodBeat.o(109070);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader
 * JD-Core Version:    0.7.0.1
 */