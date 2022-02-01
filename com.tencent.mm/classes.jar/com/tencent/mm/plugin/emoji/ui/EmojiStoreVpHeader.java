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
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.model.b;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.anj;
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
  private View plc;
  private View qAv;
  private MMDotView xUq;
  private ViewPager xUr;
  private LinkedList<b> xUs;
  i xUt;
  private float xUu;
  private float xUv;
  a xUw;
  private volatile boolean xUx;
  private final int xUy;
  private final int xUz;
  
  public EmojiStoreVpHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(109071);
    this.xUy = 5;
    this.xUz = 0;
    setOrientation(1);
    AppMethodBeat.o(109071);
  }
  
  public EmojiStoreVpHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109072);
    this.xUy = 5;
    this.xUz = 0;
    setOrientation(1);
    AppMethodBeat.o(109072);
  }
  
  private void dBW()
  {
    try
    {
      AppMethodBeat.i(109074);
      if (this.xUs == null)
      {
        IllegalAccessError localIllegalAccessError = new IllegalAccessError("must has emoji baner list first");
        AppMethodBeat.o(109074);
        throw localIllegalAccessError;
      }
    }
    finally {}
    int i;
    if (this.plc == null)
    {
      this.plc = inflate(getContext(), h.f.emoji_store_vp_header, null);
      this.qAv = this.plc.findViewById(h.e.emoji_store_ad_root);
      this.xUq = ((MMDotView)this.plc.findViewById(h.e.emoji_store_ad_dot));
      this.xUr = ((ViewPager)this.plc.findViewById(h.e.emoji_store_ad_viewpager));
      this.xUw = new a((byte)0);
      i = getScreenWH(getContext())[0] * 3 / 8;
      if (this.qAv != null) {
        this.qAv.setLayoutParams(new LinearLayout.LayoutParams(-1, i + 1));
      }
      addView(this.plc, new LinearLayout.LayoutParams(-1, -2));
    }
    if (this.xUq != null)
    {
      MMDotView localMMDotView = this.xUq;
      if (this.xUs == null)
      {
        i = 0;
        localMMDotView.setDotCount(i);
        this.xUq.setSelectedDot(0);
        this.xUq.setVisibility(8);
      }
    }
    else
    {
      if ((this.xUr != null) && (this.xUs != null)) {
        break label253;
      }
      AppMethodBeat.o(109074);
    }
    for (;;)
    {
      return;
      i = this.xUs.size();
      break;
      label253:
      if (this.xUs.size() <= 0)
      {
        if (this.qAv != null) {
          this.qAv.setVisibility(8);
        }
        AppMethodBeat.o(109074);
      }
      else
      {
        if (this.qAv != null) {
          this.qAv.setVisibility(0);
        }
        this.xUr.setOnPageChangeListener(this);
        if (this.xUt == null)
        {
          this.xUt = new i(getContext(), this.xUs);
          this.xUr.setAdapter(this.xUt);
          this.xUr.setOffscreenPageLimit(1);
          dBX();
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
                locali.xHf.clear();
                locali.xHf.addAll(localLinkedList);
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
  
  private void dBX()
  {
    AppMethodBeat.i(109075);
    if (this.xUr == null)
    {
      AppMethodBeat.o(109075);
      return;
    }
    this.xUr.setCurrentItem(i.xHg / 2 * this.xUs.size(), false);
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
  
  private void oc(boolean paramBoolean)
  {
    AppMethodBeat.i(109082);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(109082);
  }
  
  public final void d(LinkedList<anh> paramLinkedList, LinkedList<anj> paramLinkedList1)
  {
    AppMethodBeat.i(109079);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(109079);
      return;
    }
    if (this.xUs == null) {
      this.xUs = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList1 = paramLinkedList1.iterator();
      while (paramLinkedList1.hasNext())
      {
        anj localanj = (anj)paramLinkedList1.next();
        if ((localanj != null) && (localanj.akjS != null) && (!Util.isNullOrNil(localanj.akjS.akjT))) {
          this.xUs.add(new b(null, localanj, true));
        }
      }
      this.xUs.clear();
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList1 = (anh)paramLinkedList.next();
      if ((paramLinkedList1 != null) && (paramLinkedList1.akjS != null) && (!Util.isNullOrNil(paramLinkedList1.akjS.akjT))) {
        this.xUs.add(new b(paramLinkedList1, null, false));
      }
    }
    dBW();
    AppMethodBeat.o(109079);
  }
  
  public final void dBY()
  {
    AppMethodBeat.i(109076);
    if (this.xUw == null) {
      this.xUw = new a((byte)0);
    }
    this.xUx = true;
    this.xUw.removeMessages(0);
    this.xUw.sendEmptyMessageDelayed(0, 5000L);
    AppMethodBeat.o(109076);
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(109077);
    if (this.xUw == null)
    {
      AppMethodBeat.o(109077);
      return;
    }
    this.xUx = false;
    this.xUw.removeMessages(0);
    AppMethodBeat.o(109077);
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
      this.xUu = f1;
      this.xUv = f2;
      break;
      j = (int)(f1 - this.xUu);
      int k = (int)(f2 - this.xUv);
      if (Math.abs(j) <= Math.abs(k)) {
        break;
      }
      oc(true);
      break;
      this.xUu = 0.0F;
      this.xUv = 0.0F;
      oc(false);
      break;
      dBZ();
      continue;
      dBY();
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(109080);
    if ((this.xUs == null) || (this.xUs.size() <= 1))
    {
      AppMethodBeat.o(109080);
      return;
    }
    if ((paramInt == 0) || (paramInt == this.xUt.getCount() - 1)) {
      this.plc.postDelayed(new Runnable()
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
        i = EmojiStoreVpHeader.b(EmojiStoreVpHeader.this).size() * i.xHg / 2;
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