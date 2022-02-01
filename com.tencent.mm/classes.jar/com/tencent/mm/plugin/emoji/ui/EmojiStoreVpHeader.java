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
  private View hIZ;
  private View iIW;
  private MMDotView mfR;
  private ViewPager oEa;
  private LinkedList<a> oEb;
  private i oEc;
  private float oEd;
  private float oEe;
  private a oEf;
  private volatile boolean oEg;
  private final int oEh;
  private final int oEi;
  
  public EmojiStoreVpHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(109071);
    this.oEh = 5;
    this.oEi = 0;
    setOrientation(1);
    AppMethodBeat.o(109071);
  }
  
  public EmojiStoreVpHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109072);
    this.oEh = 5;
    this.oEi = 0;
    setOrientation(1);
    AppMethodBeat.o(109072);
  }
  
  private void bWE()
  {
    try
    {
      AppMethodBeat.i(109074);
      if (this.oEb == null)
      {
        IllegalAccessError localIllegalAccessError = new IllegalAccessError("must has emoji baner list first");
        AppMethodBeat.o(109074);
        throw localIllegalAccessError;
      }
    }
    finally {}
    int i;
    if (this.hIZ == null)
    {
      this.hIZ = inflate(getContext(), 2131493831, null);
      this.iIW = this.hIZ.findViewById(2131299439);
      this.mfR = ((MMDotView)this.hIZ.findViewById(2131299438));
      this.oEa = ((ViewPager)this.hIZ.findViewById(2131299440));
      this.oEf = new a((byte)0);
      i = et(getContext())[0] * 3 / 8;
      if (this.iIW != null) {
        this.iIW.setLayoutParams(new LinearLayout.LayoutParams(-1, i + 1));
      }
      addView(this.hIZ, new LinearLayout.LayoutParams(-1, -2));
    }
    if (this.mfR != null)
    {
      MMDotView localMMDotView = this.mfR;
      if (this.oEb == null)
      {
        i = 0;
        localMMDotView.setDotCount(i);
        this.mfR.setSelectedDot(0);
        this.mfR.setVisibility(8);
      }
    }
    else
    {
      if ((this.oEa != null) && (this.oEb != null)) {
        break label249;
      }
      AppMethodBeat.o(109074);
    }
    for (;;)
    {
      return;
      i = this.oEb.size();
      break;
      label249:
      if (this.oEb.size() <= 0)
      {
        if (this.iIW != null) {
          this.iIW.setVisibility(8);
        }
        AppMethodBeat.o(109074);
      }
      else
      {
        if (this.iIW != null) {
          this.iIW.setVisibility(0);
        }
        this.oEa.setOnPageChangeListener(this);
        if (this.oEc == null)
        {
          this.oEc = new i(getContext(), this.oEb);
          this.oEa.setAdapter(this.oEc);
          this.oEa.setOffscreenPageLimit(1);
          bWF();
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
                locali.oum.clear();
                locali.oum.addAll(localLinkedList);
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
  
  private void bWF()
  {
    AppMethodBeat.i(109075);
    if (this.oEa == null)
    {
      AppMethodBeat.o(109075);
      return;
    }
    this.oEa.setCurrentItem(i.oun / 2 * this.oEb.size(), false);
    AppMethodBeat.o(109075);
  }
  
  public static int[] et(Context paramContext)
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
  
  private void jF(boolean paramBoolean)
  {
    AppMethodBeat.i(109082);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(109082);
  }
  
  public final void bWG()
  {
    AppMethodBeat.i(109076);
    if (this.oEf == null) {
      this.oEf = new a((byte)0);
    }
    this.oEg = true;
    this.oEf.removeMessages(0);
    this.oEf.sendEmptyMessageDelayed(0, 5000L);
    AppMethodBeat.o(109076);
  }
  
  public final void bWH()
  {
    AppMethodBeat.i(109077);
    if (this.oEf == null)
    {
      AppMethodBeat.o(109077);
      return;
    }
    this.oEg = false;
    this.oEf.removeMessages(0);
    AppMethodBeat.o(109077);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(109078);
    if (this.oEc != null)
    {
      this.oEc.clear();
      this.oEc = null;
    }
    this.oEf = null;
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
    if (this.oEb == null) {
      this.oEb = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList1 = paramLinkedList1.iterator();
      while (paramLinkedList1.hasNext())
      {
        EmotionBannerSet localEmotionBannerSet = (EmotionBannerSet)paramLinkedList1.next();
        if ((localEmotionBannerSet != null) && (localEmotionBannerSet.BannerImg != null) && (!bt.isNullOrNil(localEmotionBannerSet.BannerImg.StripUrl))) {
          this.oEb.add(new a(null, localEmotionBannerSet, true));
        }
      }
      this.oEb.clear();
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList1 = (EmotionBanner)paramLinkedList.next();
      if ((paramLinkedList1 != null) && (paramLinkedList1.BannerImg != null) && (!bt.isNullOrNil(paramLinkedList1.BannerImg.StripUrl))) {
        this.oEb.add(new a(paramLinkedList1, null, false));
      }
    }
    bWE();
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
      this.oEd = f1;
      this.oEe = f2;
      break;
      j = (int)(f1 - this.oEd);
      int k = (int)(f2 - this.oEe);
      if (Math.abs(j) <= Math.abs(k)) {
        break;
      }
      jF(true);
      break;
      this.oEd = 0.0F;
      this.oEe = 0.0F;
      jF(false);
      break;
      bWH();
      continue;
      bWG();
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(109080);
    if ((this.oEb == null) || (this.oEb.size() <= 1))
    {
      AppMethodBeat.o(109080);
      return;
    }
    if ((paramInt == 0) || (paramInt == this.oEc.getCount() - 1)) {
      this.hIZ.postDelayed(new Runnable()
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
        i = EmojiStoreVpHeader.b(EmojiStoreVpHeader.this).size() * i.oun / 2;
      }
      EmojiStoreVpHeader.e(EmojiStoreVpHeader.this).setCurrentItem(i);
      if ((EmojiStoreVpHeader.d(EmojiStoreVpHeader.this)) && (EmojiStoreVpHeader.f(EmojiStoreVpHeader.this) != null)) {
        sendMessageDelayed(EmojiStoreVpHeader.f(EmojiStoreVpHeader.this).obtainMessage(0), 5000L);
      }
      AppMethodBeat.o(109070);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader
 * JD-Core Version:    0.7.0.1
 */