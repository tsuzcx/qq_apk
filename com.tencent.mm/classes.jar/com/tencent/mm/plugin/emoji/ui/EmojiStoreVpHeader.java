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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMDotView;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreVpHeader
  extends LinearLayout
  implements ViewPager.OnPageChangeListener
{
  private View iFK;
  private View jFG;
  private MMDotView nnw;
  private ViewPager pRH;
  private LinkedList<a> pRI;
  private i pRJ;
  private float pRK;
  private float pRL;
  private a pRM;
  private volatile boolean pRN;
  private final int pRO;
  private final int pRP;
  
  public EmojiStoreVpHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(109071);
    this.pRO = 5;
    this.pRP = 0;
    setOrientation(1);
    AppMethodBeat.o(109071);
  }
  
  public EmojiStoreVpHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109072);
    this.pRO = 5;
    this.pRP = 0;
    setOrientation(1);
    AppMethodBeat.o(109072);
  }
  
  private void cjK()
  {
    try
    {
      AppMethodBeat.i(109074);
      if (this.pRI == null)
      {
        IllegalAccessError localIllegalAccessError = new IllegalAccessError("must has emoji baner list first");
        AppMethodBeat.o(109074);
        throw localIllegalAccessError;
      }
    }
    finally {}
    int i;
    if (this.iFK == null)
    {
      this.iFK = inflate(getContext(), 2131493831, null);
      this.jFG = this.iFK.findViewById(2131299439);
      this.nnw = ((MMDotView)this.iFK.findViewById(2131299438));
      this.pRH = ((ViewPager)this.iFK.findViewById(2131299440));
      this.pRM = new a((byte)0);
      i = eF(getContext())[0] * 3 / 8;
      if (this.jFG != null) {
        this.jFG.setLayoutParams(new LinearLayout.LayoutParams(-1, i + 1));
      }
      addView(this.iFK, new LinearLayout.LayoutParams(-1, -2));
    }
    if (this.nnw != null)
    {
      MMDotView localMMDotView = this.nnw;
      if (this.pRI == null)
      {
        i = 0;
        localMMDotView.setDotCount(i);
        this.nnw.setSelectedDot(0);
        this.nnw.setVisibility(8);
      }
    }
    else
    {
      if ((this.pRH != null) && (this.pRI != null)) {
        break label249;
      }
      AppMethodBeat.o(109074);
    }
    for (;;)
    {
      return;
      i = this.pRI.size();
      break;
      label249:
      if (this.pRI.size() <= 0)
      {
        if (this.jFG != null) {
          this.jFG.setVisibility(8);
        }
        AppMethodBeat.o(109074);
      }
      else
      {
        if (this.jFG != null) {
          this.jFG.setVisibility(0);
        }
        this.pRH.setOnPageChangeListener(this);
        if (this.pRJ == null)
        {
          this.pRJ = new i(getContext(), this.pRI);
          this.pRH.setAdapter(this.pRJ);
          this.pRH.setOffscreenPageLimit(1);
          cjL();
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
                locali.pIb.clear();
                locali.pIb.addAll(localLinkedList);
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
  
  private void cjL()
  {
    AppMethodBeat.i(109075);
    if (this.pRH == null)
    {
      AppMethodBeat.o(109075);
      return;
    }
    this.pRH.setCurrentItem(i.pIc / 2 * this.pRI.size(), false);
    AppMethodBeat.o(109075);
  }
  
  public static int[] eF(Context paramContext)
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
  
  private void ks(boolean paramBoolean)
  {
    AppMethodBeat.i(109082);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(109082);
  }
  
  public final void cjM()
  {
    AppMethodBeat.i(109076);
    if (this.pRM == null) {
      this.pRM = new a((byte)0);
    }
    this.pRN = true;
    this.pRM.removeMessages(0);
    this.pRM.sendEmptyMessageDelayed(0, 5000L);
    AppMethodBeat.o(109076);
  }
  
  public final void cjN()
  {
    AppMethodBeat.i(109077);
    if (this.pRM == null)
    {
      AppMethodBeat.o(109077);
      return;
    }
    this.pRN = false;
    this.pRM.removeMessages(0);
    AppMethodBeat.o(109077);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(109078);
    if (this.pRJ != null)
    {
      this.pRJ.clear();
      this.pRJ = null;
    }
    this.pRM = null;
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
    if (this.pRI == null) {
      this.pRI = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList1 = paramLinkedList1.iterator();
      while (paramLinkedList1.hasNext())
      {
        EmotionBannerSet localEmotionBannerSet = (EmotionBannerSet)paramLinkedList1.next();
        if ((localEmotionBannerSet != null) && (localEmotionBannerSet.BannerImg != null) && (!bu.isNullOrNil(localEmotionBannerSet.BannerImg.StripUrl))) {
          this.pRI.add(new a(null, localEmotionBannerSet, true));
        }
      }
      this.pRI.clear();
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList1 = (EmotionBanner)paramLinkedList.next();
      if ((paramLinkedList1 != null) && (paramLinkedList1.BannerImg != null) && (!bu.isNullOrNil(paramLinkedList1.BannerImg.StripUrl))) {
        this.pRI.add(new a(paramLinkedList1, null, false));
      }
    }
    cjK();
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
      this.pRK = f1;
      this.pRL = f2;
      break;
      j = (int)(f1 - this.pRK);
      int k = (int)(f2 - this.pRL);
      if (Math.abs(j) <= Math.abs(k)) {
        break;
      }
      ks(true);
      break;
      this.pRK = 0.0F;
      this.pRL = 0.0F;
      ks(false);
      break;
      cjN();
      continue;
      cjM();
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(109080);
    if ((this.pRI == null) || (this.pRI.size() <= 1))
    {
      AppMethodBeat.o(109080);
      return;
    }
    if ((paramInt == 0) || (paramInt == this.pRJ.getCount() - 1)) {
      this.iFK.postDelayed(new Runnable()
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
    extends aq
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
        ae.w("MicroMsg.emoji.EmojiStoreVpHeader", "list is null");
        AppMethodBeat.o(109070);
        return;
      }
      if (EmojiStoreVpHeader.a(EmojiStoreVpHeader.this) == null)
      {
        ae.w("MicroMsg.emoji.EmojiStoreVpHeader", "adapter is null");
        AppMethodBeat.o(109070);
        return;
      }
      int j = EmojiStoreVpHeader.e(EmojiStoreVpHeader.this).getCurrentItem() + 1;
      int i = j;
      if (j >= EmojiStoreVpHeader.a(EmojiStoreVpHeader.this).getCount()) {
        i = EmojiStoreVpHeader.b(EmojiStoreVpHeader.this).size() * i.pIc / 2;
      }
      EmojiStoreVpHeader.e(EmojiStoreVpHeader.this).setCurrentItem(i);
      if ((EmojiStoreVpHeader.d(EmojiStoreVpHeader.this)) && (EmojiStoreVpHeader.f(EmojiStoreVpHeader.this) != null)) {
        sendMessageDelayed(EmojiStoreVpHeader.f(EmojiStoreVpHeader.this).obtainMessage(0), 5000L);
      }
      AppMethodBeat.o(109070);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader
 * JD-Core Version:    0.7.0.1
 */