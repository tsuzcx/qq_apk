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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMDotView;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreVpHeader
  extends LinearLayout
  implements ViewPager.OnPageChangeListener
{
  private View ijA;
  private View jja;
  private MMDotView mHQ;
  private ViewPager phA;
  private LinkedList<a> phB;
  private i phC;
  private float phD;
  private float phE;
  private a phF;
  private volatile boolean phG;
  private final int phH;
  private final int phI;
  
  public EmojiStoreVpHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(109071);
    this.phH = 5;
    this.phI = 0;
    setOrientation(1);
    AppMethodBeat.o(109071);
  }
  
  public EmojiStoreVpHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109072);
    this.phH = 5;
    this.phI = 0;
    setOrientation(1);
    AppMethodBeat.o(109072);
  }
  
  private void cdR()
  {
    try
    {
      AppMethodBeat.i(109074);
      if (this.phB == null)
      {
        IllegalAccessError localIllegalAccessError = new IllegalAccessError("must has emoji baner list first");
        AppMethodBeat.o(109074);
        throw localIllegalAccessError;
      }
    }
    finally {}
    int i;
    if (this.ijA == null)
    {
      this.ijA = inflate(getContext(), 2131493831, null);
      this.jja = this.ijA.findViewById(2131299439);
      this.mHQ = ((MMDotView)this.ijA.findViewById(2131299438));
      this.phA = ((ViewPager)this.ijA.findViewById(2131299440));
      this.phF = new a((byte)0);
      i = eB(getContext())[0] * 3 / 8;
      if (this.jja != null) {
        this.jja.setLayoutParams(new LinearLayout.LayoutParams(-1, i + 1));
      }
      addView(this.ijA, new LinearLayout.LayoutParams(-1, -2));
    }
    if (this.mHQ != null)
    {
      MMDotView localMMDotView = this.mHQ;
      if (this.phB == null)
      {
        i = 0;
        localMMDotView.setDotCount(i);
        this.mHQ.setSelectedDot(0);
        this.mHQ.setVisibility(8);
      }
    }
    else
    {
      if ((this.phA != null) && (this.phB != null)) {
        break label249;
      }
      AppMethodBeat.o(109074);
    }
    for (;;)
    {
      return;
      i = this.phB.size();
      break;
      label249:
      if (this.phB.size() <= 0)
      {
        if (this.jja != null) {
          this.jja.setVisibility(8);
        }
        AppMethodBeat.o(109074);
      }
      else
      {
        if (this.jja != null) {
          this.jja.setVisibility(0);
        }
        this.phA.setOnPageChangeListener(this);
        if (this.phC == null)
        {
          this.phC = new i(getContext(), this.phB);
          this.phA.setAdapter(this.phC);
          this.phA.setOffscreenPageLimit(1);
          cdS();
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
                locali.oXN.clear();
                locali.oXN.addAll(localLinkedList);
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
  
  private void cdS()
  {
    AppMethodBeat.i(109075);
    if (this.phA == null)
    {
      AppMethodBeat.o(109075);
      return;
    }
    this.phA.setCurrentItem(i.oXO / 2 * this.phB.size(), false);
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
  
  private void ki(boolean paramBoolean)
  {
    AppMethodBeat.i(109082);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(109082);
  }
  
  public final void cdT()
  {
    AppMethodBeat.i(109076);
    if (this.phF == null) {
      this.phF = new a((byte)0);
    }
    this.phG = true;
    this.phF.removeMessages(0);
    this.phF.sendEmptyMessageDelayed(0, 5000L);
    AppMethodBeat.o(109076);
  }
  
  public final void cdU()
  {
    AppMethodBeat.i(109077);
    if (this.phF == null)
    {
      AppMethodBeat.o(109077);
      return;
    }
    this.phG = false;
    this.phF.removeMessages(0);
    AppMethodBeat.o(109077);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(109078);
    if (this.phC != null)
    {
      this.phC.clear();
      this.phC = null;
    }
    this.phF = null;
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
    if (this.phB == null) {
      this.phB = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList1 = paramLinkedList1.iterator();
      while (paramLinkedList1.hasNext())
      {
        EmotionBannerSet localEmotionBannerSet = (EmotionBannerSet)paramLinkedList1.next();
        if ((localEmotionBannerSet != null) && (localEmotionBannerSet.BannerImg != null) && (!bs.isNullOrNil(localEmotionBannerSet.BannerImg.StripUrl))) {
          this.phB.add(new a(null, localEmotionBannerSet, true));
        }
      }
      this.phB.clear();
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList1 = (EmotionBanner)paramLinkedList.next();
      if ((paramLinkedList1 != null) && (paramLinkedList1.BannerImg != null) && (!bs.isNullOrNil(paramLinkedList1.BannerImg.StripUrl))) {
        this.phB.add(new a(paramLinkedList1, null, false));
      }
    }
    cdR();
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
      this.phD = f1;
      this.phE = f2;
      break;
      j = (int)(f1 - this.phD);
      int k = (int)(f2 - this.phE);
      if (Math.abs(j) <= Math.abs(k)) {
        break;
      }
      ki(true);
      break;
      this.phD = 0.0F;
      this.phE = 0.0F;
      ki(false);
      break;
      cdU();
      continue;
      cdT();
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(109080);
    if ((this.phB == null) || (this.phB.size() <= 1))
    {
      AppMethodBeat.o(109080);
      return;
    }
    if ((paramInt == 0) || (paramInt == this.phC.getCount() - 1)) {
      this.ijA.postDelayed(new Runnable()
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
    extends ao
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
        ac.w("MicroMsg.emoji.EmojiStoreVpHeader", "list is null");
        AppMethodBeat.o(109070);
        return;
      }
      if (EmojiStoreVpHeader.a(EmojiStoreVpHeader.this) == null)
      {
        ac.w("MicroMsg.emoji.EmojiStoreVpHeader", "adapter is null");
        AppMethodBeat.o(109070);
        return;
      }
      int j = EmojiStoreVpHeader.e(EmojiStoreVpHeader.this).getCurrentItem() + 1;
      int i = j;
      if (j >= EmojiStoreVpHeader.a(EmojiStoreVpHeader.this).getCount()) {
        i = EmojiStoreVpHeader.b(EmojiStoreVpHeader.this).size() * i.oXO / 2;
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