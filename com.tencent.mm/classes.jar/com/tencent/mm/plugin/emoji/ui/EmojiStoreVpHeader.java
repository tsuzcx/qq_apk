package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.i;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.model.b;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajw;
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
  private View mrI;
  private View nBk;
  private MMDotView uLP;
  private ViewPager uLQ;
  private LinkedList<b> uLR;
  private i uLS;
  private float uLT;
  private float uLU;
  private a uLV;
  private volatile boolean uLW;
  private final int uLX;
  private final int uLY;
  
  public EmojiStoreVpHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(109071);
    this.uLX = 5;
    this.uLY = 0;
    setOrientation(1);
    AppMethodBeat.o(109071);
  }
  
  public EmojiStoreVpHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109072);
    this.uLX = 5;
    this.uLY = 0;
    setOrientation(1);
    AppMethodBeat.o(109072);
  }
  
  private void cWs()
  {
    try
    {
      AppMethodBeat.i(109074);
      if (this.uLR == null)
      {
        IllegalAccessError localIllegalAccessError = new IllegalAccessError("must has emoji baner list first");
        AppMethodBeat.o(109074);
        throw localIllegalAccessError;
      }
    }
    finally {}
    int i;
    if (this.mrI == null)
    {
      this.mrI = inflate(getContext(), i.f.emoji_store_vp_header, null);
      this.nBk = this.mrI.findViewById(i.e.emoji_store_ad_root);
      this.uLP = ((MMDotView)this.mrI.findViewById(i.e.emoji_store_ad_dot));
      this.uLQ = ((ViewPager)this.mrI.findViewById(i.e.emoji_store_ad_viewpager));
      this.uLV = new a((byte)0);
      i = getScreenWH(getContext())[0] * 3 / 8;
      if (this.nBk != null) {
        this.nBk.setLayoutParams(new LinearLayout.LayoutParams(-1, i + 1));
      }
      addView(this.mrI, new LinearLayout.LayoutParams(-1, -2));
    }
    if (this.uLP != null)
    {
      MMDotView localMMDotView = this.uLP;
      if (this.uLR == null)
      {
        i = 0;
        localMMDotView.setDotCount(i);
        this.uLP.setSelectedDot(0);
        this.uLP.setVisibility(8);
      }
    }
    else
    {
      if ((this.uLQ != null) && (this.uLR != null)) {
        break label253;
      }
      AppMethodBeat.o(109074);
    }
    for (;;)
    {
      return;
      i = this.uLR.size();
      break;
      label253:
      if (this.uLR.size() <= 0)
      {
        if (this.nBk != null) {
          this.nBk.setVisibility(8);
        }
        AppMethodBeat.o(109074);
      }
      else
      {
        if (this.nBk != null) {
          this.nBk.setVisibility(0);
        }
        this.uLQ.setOnPageChangeListener(this);
        if (this.uLS == null)
        {
          this.uLS = new i(getContext(), this.uLR);
          this.uLQ.setAdapter(this.uLS);
          this.uLQ.setOffscreenPageLimit(1);
          cWt();
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
                locali.uAC.clear();
                locali.uAC.addAll(localLinkedList);
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
  
  private void cWt()
  {
    AppMethodBeat.i(109075);
    if (this.uLQ == null)
    {
      AppMethodBeat.o(109075);
      return;
    }
    this.uLQ.setCurrentItem(i.uAD / 2 * this.uLR.size(), false);
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
  
  private void mF(boolean paramBoolean)
  {
    AppMethodBeat.i(109082);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(109082);
  }
  
  public final void cWu()
  {
    AppMethodBeat.i(109076);
    if (this.uLV == null) {
      this.uLV = new a((byte)0);
    }
    this.uLW = true;
    this.uLV.removeMessages(0);
    this.uLV.sendEmptyMessageDelayed(0, 5000L);
    AppMethodBeat.o(109076);
  }
  
  public final void cWv()
  {
    AppMethodBeat.i(109077);
    if (this.uLV == null)
    {
      AppMethodBeat.o(109077);
      return;
    }
    this.uLW = false;
    this.uLV.removeMessages(0);
    AppMethodBeat.o(109077);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(109078);
    if (this.uLS != null)
    {
      this.uLS.clear();
      this.uLS = null;
    }
    this.uLV = null;
    AppMethodBeat.o(109078);
  }
  
  public final void d(LinkedList<aju> paramLinkedList, LinkedList<ajw> paramLinkedList1)
  {
    AppMethodBeat.i(109079);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(109079);
      return;
    }
    if (this.uLR == null) {
      this.uLR = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList1 = paramLinkedList1.iterator();
      while (paramLinkedList1.hasNext())
      {
        ajw localajw = (ajw)paramLinkedList1.next();
        if ((localajw != null) && (localajw.Tel != null) && (!Util.isNullOrNil(localajw.Tel.Tem))) {
          this.uLR.add(new b(null, localajw, true));
        }
      }
      this.uLR.clear();
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList1 = (aju)paramLinkedList.next();
      if ((paramLinkedList1 != null) && (paramLinkedList1.Tel != null) && (!Util.isNullOrNil(paramLinkedList1.Tel.Tem))) {
        this.uLR.add(new b(paramLinkedList1, null, false));
      }
    }
    cWs();
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
      this.uLT = f1;
      this.uLU = f2;
      break;
      j = (int)(f1 - this.uLT);
      int k = (int)(f2 - this.uLU);
      if (Math.abs(j) <= Math.abs(k)) {
        break;
      }
      mF(true);
      break;
      this.uLT = 0.0F;
      this.uLU = 0.0F;
      mF(false);
      break;
      cWv();
      continue;
      cWu();
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(109080);
    if ((this.uLR == null) || (this.uLR.size() <= 1))
    {
      AppMethodBeat.o(109080);
      return;
    }
    if ((paramInt == 0) || (paramInt == this.uLS.getCount() - 1)) {
      this.mrI.postDelayed(new Runnable()
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
        i = EmojiStoreVpHeader.b(EmojiStoreVpHeader.this).size() * i.uAD / 2;
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