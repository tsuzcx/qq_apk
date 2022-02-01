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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMDotView;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreVpHeader
  extends LinearLayout
  implements ViewPager.OnPageChangeListener
{
  private View jBN;
  private View kHq;
  private MMDotView oxc;
  private ViewPager riH;
  private LinkedList<a> riI;
  private i riJ;
  private float riK;
  private float riL;
  private a riM;
  private volatile boolean riN;
  private final int riO;
  private final int riP;
  
  public EmojiStoreVpHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(109071);
    this.riO = 5;
    this.riP = 0;
    setOrientation(1);
    AppMethodBeat.o(109071);
  }
  
  public EmojiStoreVpHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109072);
    this.riO = 5;
    this.riP = 0;
    setOrientation(1);
    AppMethodBeat.o(109072);
  }
  
  private void cHL()
  {
    try
    {
      AppMethodBeat.i(109074);
      if (this.riI == null)
      {
        IllegalAccessError localIllegalAccessError = new IllegalAccessError("must has emoji baner list first");
        AppMethodBeat.o(109074);
        throw localIllegalAccessError;
      }
    }
    finally {}
    int i;
    if (this.jBN == null)
    {
      this.jBN = inflate(getContext(), 2131493985, null);
      this.kHq = this.jBN.findViewById(2131300053);
      this.oxc = ((MMDotView)this.jBN.findViewById(2131300052));
      this.riH = ((ViewPager)this.jBN.findViewById(2131300054));
      this.riM = new a((byte)0);
      i = getScreenWH(getContext())[0] * 3 / 8;
      if (this.kHq != null) {
        this.kHq.setLayoutParams(new LinearLayout.LayoutParams(-1, i + 1));
      }
      addView(this.jBN, new LinearLayout.LayoutParams(-1, -2));
    }
    if (this.oxc != null)
    {
      MMDotView localMMDotView = this.oxc;
      if (this.riI == null)
      {
        i = 0;
        localMMDotView.setDotCount(i);
        this.oxc.setSelectedDot(0);
        this.oxc.setVisibility(8);
      }
    }
    else
    {
      if ((this.riH != null) && (this.riI != null)) {
        break label249;
      }
      AppMethodBeat.o(109074);
    }
    for (;;)
    {
      return;
      i = this.riI.size();
      break;
      label249:
      if (this.riI.size() <= 0)
      {
        if (this.kHq != null) {
          this.kHq.setVisibility(8);
        }
        AppMethodBeat.o(109074);
      }
      else
      {
        if (this.kHq != null) {
          this.kHq.setVisibility(0);
        }
        this.riH.setOnPageChangeListener(this);
        if (this.riJ == null)
        {
          this.riJ = new i(getContext(), this.riI);
          this.riH.setAdapter(this.riJ);
          this.riH.setOffscreenPageLimit(1);
          cHM();
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
                locali.qXN.clear();
                locali.qXN.addAll(localLinkedList);
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
  
  private void cHM()
  {
    AppMethodBeat.i(109075);
    if (this.riH == null)
    {
      AppMethodBeat.o(109075);
      return;
    }
    this.riH.setCurrentItem(i.qXO / 2 * this.riI.size(), false);
    AppMethodBeat.o(109075);
  }
  
  public static int[] getScreenWH(Context paramContext)
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
  
  private void lu(boolean paramBoolean)
  {
    AppMethodBeat.i(109082);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(109082);
  }
  
  public final void cHN()
  {
    AppMethodBeat.i(109076);
    if (this.riM == null) {
      this.riM = new a((byte)0);
    }
    this.riN = true;
    this.riM.removeMessages(0);
    this.riM.sendEmptyMessageDelayed(0, 5000L);
    AppMethodBeat.o(109076);
  }
  
  public final void cHO()
  {
    AppMethodBeat.i(109077);
    if (this.riM == null)
    {
      AppMethodBeat.o(109077);
      return;
    }
    this.riN = false;
    this.riM.removeMessages(0);
    AppMethodBeat.o(109077);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(109078);
    if (this.riJ != null)
    {
      this.riJ.clear();
      this.riJ = null;
    }
    this.riM = null;
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
    if (this.riI == null) {
      this.riI = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList1 = paramLinkedList1.iterator();
      while (paramLinkedList1.hasNext())
      {
        EmotionBannerSet localEmotionBannerSet = (EmotionBannerSet)paramLinkedList1.next();
        if ((localEmotionBannerSet != null) && (localEmotionBannerSet.BannerImg != null) && (!Util.isNullOrNil(localEmotionBannerSet.BannerImg.StripUrl))) {
          this.riI.add(new a(null, localEmotionBannerSet, true));
        }
      }
      this.riI.clear();
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList1 = (EmotionBanner)paramLinkedList.next();
      if ((paramLinkedList1 != null) && (paramLinkedList1.BannerImg != null) && (!Util.isNullOrNil(paramLinkedList1.BannerImg.StripUrl))) {
        this.riI.add(new a(paramLinkedList1, null, false));
      }
    }
    cHL();
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
      this.riK = f1;
      this.riL = f2;
      break;
      j = (int)(f1 - this.riK);
      int k = (int)(f2 - this.riL);
      if (Math.abs(j) <= Math.abs(k)) {
        break;
      }
      lu(true);
      break;
      this.riK = 0.0F;
      this.riL = 0.0F;
      lu(false);
      break;
      cHO();
      continue;
      cHN();
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(109080);
    if ((this.riI == null) || (this.riI.size() <= 1))
    {
      AppMethodBeat.o(109080);
      return;
    }
    if ((paramInt == 0) || (paramInt == this.riJ.getCount() - 1)) {
      this.jBN.postDelayed(new Runnable()
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
    extends MMHandler
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
        Log.w("MicroMsg.emoji.EmojiStoreVpHeader", "list is null");
        AppMethodBeat.o(109070);
        return;
      }
      if (EmojiStoreVpHeader.a(EmojiStoreVpHeader.this) == null)
      {
        Log.w("MicroMsg.emoji.EmojiStoreVpHeader", "adapter is null");
        AppMethodBeat.o(109070);
        return;
      }
      int j = EmojiStoreVpHeader.e(EmojiStoreVpHeader.this).getCurrentItem() + 1;
      int i = j;
      if (j >= EmojiStoreVpHeader.a(EmojiStoreVpHeader.this).getCount()) {
        i = EmojiStoreVpHeader.b(EmojiStoreVpHeader.this).size() * i.qXO / 2;
      }
      EmojiStoreVpHeader.e(EmojiStoreVpHeader.this).setCurrentItem(i);
      if ((EmojiStoreVpHeader.d(EmojiStoreVpHeader.this)) && (EmojiStoreVpHeader.f(EmojiStoreVpHeader.this) != null)) {
        sendMessageDelayed(EmojiStoreVpHeader.f(EmojiStoreVpHeader.this).obtainMessage(0), 5000L);
      }
      AppMethodBeat.o(109070);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader
 * JD-Core Version:    0.7.0.1
 */