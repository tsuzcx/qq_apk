package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.emoji.a.i;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.model.a;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.MMDotView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreVpHeader
  extends LinearLayout
  implements ViewPager.e
{
  private MMDotView hxP;
  private View iUL;
  private View ipf;
  private LinkedList<a> jeU;
  private i jeV;
  private float jeW;
  private float jeX;
  private EmojiStoreVpHeader.a jeY;
  private volatile boolean jeZ;
  private final int jfa = 5;
  private final int jfb = 0;
  private ViewPager kB;
  
  public EmojiStoreVpHeader(Context paramContext)
  {
    super(paramContext);
    setOrientation(1);
  }
  
  public EmojiStoreVpHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
  }
  
  private void aJp()
  {
    try
    {
      if (this.jeU == null) {
        throw new IllegalAccessError("must has emoji baner list first");
      }
    }
    finally {}
    int i;
    if (this.ipf == null)
    {
      this.ipf = inflate(getContext(), f.f.emoji_store_vp_header, null);
      this.iUL = this.ipf.findViewById(f.e.emoji_store_ad_root);
      this.hxP = ((MMDotView)this.ipf.findViewById(f.e.emoji_store_ad_dot));
      this.kB = ((ViewPager)this.ipf.findViewById(f.e.emoji_store_ad_viewpager));
      this.jeY = new EmojiStoreVpHeader.a(this, (byte)0);
      i = cY(getContext())[0] * 3 / 8;
      if (this.iUL != null) {
        this.iUL.setLayoutParams(new LinearLayout.LayoutParams(-1, i + 1));
      }
      addView(this.ipf, new LinearLayout.LayoutParams(-1, -2));
    }
    Object localObject2;
    if (this.hxP != null)
    {
      localObject2 = this.hxP;
      if (this.jeU == null)
      {
        i = 0;
        ((MMDotView)localObject2).setDotCount(i);
        this.hxP.setSelectedDot(0);
        this.hxP.setVisibility(8);
      }
    }
    else if (this.kB != null)
    {
      localObject2 = this.jeU;
      if (localObject2 != null) {
        break label238;
      }
    }
    for (;;)
    {
      return;
      i = this.jeU.size();
      break;
      label238:
      if (this.jeU.size() <= 0)
      {
        if (this.iUL != null) {
          this.iUL.setVisibility(8);
        }
      }
      else
      {
        if (this.iUL != null) {
          this.iUL.setVisibility(0);
        }
        this.kB.setOnPageChangeListener(this);
        if (this.jeV == null)
        {
          this.jeV = new i(getContext(), this.jeU);
          this.kB.setAdapter(this.jeV);
          this.kB.setOffscreenPageLimit(1);
          aJq();
        }
        else
        {
          post(new EmojiStoreVpHeader.1(this));
        }
      }
    }
  }
  
  private void aJq()
  {
    if (this.kB == null) {
      return;
    }
    this.kB.m(i.iVy / 2 * this.jeU.size(), false);
  }
  
  public static int[] cY(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    if ((paramContext instanceof Activity))
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      arrayOfInt[0] = localDisplayMetrics.widthPixels;
      arrayOfInt[1] = localDisplayMetrics.heightPixels;
      return arrayOfInt;
    }
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    arrayOfInt[0] = paramContext.getWidth();
    arrayOfInt[1] = paramContext.getHeight();
    return arrayOfInt;
  }
  
  private void fg(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public final void Q(int paramInt) {}
  
  public final void R(int paramInt)
  {
    if ((this.jeU == null) || (this.jeU.size() <= 1)) {}
    while ((paramInt != 0) && (paramInt != this.jeV.getCount() - 1)) {
      return;
    }
    this.ipf.postDelayed(new EmojiStoreVpHeader.2(this), 350L);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void aJr()
  {
    if (this.jeY == null) {
      this.jeY = new EmojiStoreVpHeader.a(this, (byte)0);
    }
    this.jeZ = true;
    this.jeY.removeMessages(0);
    this.jeY.sendEmptyMessageDelayed(0, 5000L);
  }
  
  public final void aJs()
  {
    if (this.jeY == null) {
      return;
    }
    this.jeZ = false;
    this.jeY.removeMessages(0);
  }
  
  public final void c(LinkedList<vc> paramLinkedList, LinkedList<ve> paramLinkedList1)
  {
    if (paramLinkedList == null) {
      return;
    }
    if (this.jeU == null) {
      this.jeU = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList1 = paramLinkedList1.iterator();
      while (paramLinkedList1.hasNext())
      {
        ve localve = (ve)paramLinkedList1.next();
        if ((localve != null) && (localve.sRR != null) && (!bk.bl(localve.sRR.sRS))) {
          this.jeU.add(new a(null, localve, true));
        }
      }
      this.jeU.clear();
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList1 = (vc)paramLinkedList.next();
      if ((paramLinkedList1 != null) && (paramLinkedList1.sRR != null) && (!bk.bl(paramLinkedList1.sRR.sRS))) {
        this.jeU.add(new a(paramLinkedList1, null, false));
      }
    }
    aJp();
  }
  
  public final void clear()
  {
    if (this.jeV != null)
    {
      i locali = this.jeV;
      if (locali.iVx != null) {
        locali.iVx.clear();
      }
      if (locali.iVB != null) {
        locali.iVB.clear();
      }
      locali.iVA = true;
      this.jeV = null;
    }
    this.jeY = null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
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
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.jeW = f1;
      this.jeX = f2;
      break;
      j = (int)(f1 - this.jeW);
      int k = (int)(f2 - this.jeX);
      if (Math.abs(j) <= Math.abs(k)) {
        break;
      }
      fg(true);
      break;
      this.jeW = 0.0F;
      this.jeX = 0.0F;
      fg(false);
      break;
      aJs();
      continue;
      aJr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader
 * JD-Core Version:    0.7.0.1
 */