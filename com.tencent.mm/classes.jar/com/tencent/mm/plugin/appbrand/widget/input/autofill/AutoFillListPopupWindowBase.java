package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public class AutoFillListPopupWindowBase
{
  int aaV;
  int agX;
  int agY;
  int agZ;
  boolean ahb;
  boolean ahe;
  boolean ahf;
  int ahg;
  private View ahh;
  private int ahi;
  View ahj;
  private Drawable ahk;
  private AdapterView.OnItemClickListener ahl;
  private AdapterView.OnItemSelectedListener ahm;
  private Runnable ahr;
  boolean ahs;
  PopupWindow aht;
  AutoFillListPopupWindowBase.a jpo;
  private final AutoFillListPopupWindowBase.f jpp;
  private final AutoFillListPopupWindowBase.e jpq;
  private final AutoFillListPopupWindowBase.d jpr;
  private final AutoFillListPopupWindowBase.b jps;
  private boolean jpt;
  private Context mContext;
  private ak mHandler;
  DataSetObserver mObserver;
  private Rect mTempRect;
  ListAdapter xw;
  
  public AutoFillListPopupWindowBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772198);
  }
  
  public AutoFillListPopupWindowBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(123922);
    this.agX = -2;
    this.aaV = -2;
    this.ahe = false;
    this.ahf = false;
    this.ahg = 2147483647;
    this.ahi = 0;
    this.jpp = new AutoFillListPopupWindowBase.f(this, (byte)0);
    this.jpq = new AutoFillListPopupWindowBase.e(this, (byte)0);
    this.jpr = new AutoFillListPopupWindowBase.d(this, (byte)0);
    this.jps = new AutoFillListPopupWindowBase.b(this, (byte)0);
    this.mHandler = new ak();
    this.mTempRect = new Rect();
    this.jpt = false;
    this.mContext = paramContext;
    this.aht = new PopupWindow(paramContext);
    this.aht.setInputMethodMode(1);
    paramContext = this.mContext.getResources().getConfiguration().locale;
    AppMethodBeat.o(123922);
  }
  
  private void iC()
  {
    AppMethodBeat.i(123926);
    if (this.ahh != null)
    {
      ViewParent localViewParent = this.ahh.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.ahh);
      }
    }
    AppMethodBeat.o(123926);
  }
  
  public final void clearListSelection()
  {
    AppMethodBeat.i(123927);
    AutoFillListPopupWindowBase.a locala = this.jpo;
    if (locala != null)
    {
      AutoFillListPopupWindowBase.a.a(locala, true);
      locala.requestLayout();
    }
    AppMethodBeat.o(123927);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(123924);
    this.aht.dismiss();
    iC();
    this.aht.setContentView(null);
    this.jpo = null;
    this.mHandler.removeCallbacks(this.jpp);
    AppMethodBeat.o(123924);
  }
  
  public final boolean isInputMethodNotNeeded()
  {
    AppMethodBeat.i(123928);
    if (this.aht.getInputMethodMode() == 2)
    {
      AppMethodBeat.o(123928);
      return true;
    }
    AppMethodBeat.o(123928);
    return false;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(123925);
    this.aht.setOnDismissListener(paramOnDismissListener);
    AppMethodBeat.o(123925);
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.agZ = paramInt;
    this.ahb = true;
  }
  
  public void show()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    int n = -1;
    AppMethodBeat.i(123923);
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    FrameLayout.LayoutParams localLayoutParams1;
    FrameLayout.LayoutParams localLayoutParams2;
    if (this.jpo == null)
    {
      localObject2 = this.mContext;
      this.ahr = new AutoFillListPopupWindowBase.1(this);
      if (!this.ahs)
      {
        bool1 = true;
        this.jpo = new AutoFillListPopupWindowBase.a((Context)localObject2, bool1);
        if (this.ahk != null) {
          this.jpo.setSelector(this.ahk);
        }
        this.jpo.setAdapter(this.xw);
        this.jpo.setOnItemClickListener(this.ahl);
        this.jpo.setFocusable(true);
        this.jpo.setFocusableInTouchMode(true);
        this.jpo.setDivider(null);
        this.jpo.setDividerHeight(0);
        this.jpo.setOnItemSelectedListener(new AutoFillListPopupWindowBase.2(this));
        this.jpo.setOnScrollListener(this.jpr);
        if (this.ahm != null) {
          this.jpo.setOnItemSelectedListener(this.ahm);
        }
        localObject1 = this.jpo;
        localView = this.ahh;
        if (localView == null) {
          break label1343;
        }
        iC();
        localObject2 = new FrameLayout((Context)localObject2);
        localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
        localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        switch (this.ahi)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.ahi);
          label278:
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.aaV, -2147483648), 0);
          localObject1 = localObject2;
        }
      }
    }
    label309:
    label1338:
    label1343:
    for (;;)
    {
      this.aht.setContentView((View)localObject1);
      int i = 0;
      for (;;)
      {
        localObject1 = this.aht.getBackground();
        int k;
        label372:
        int i1;
        int m;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          k = j;
          if (!this.ahb)
          {
            this.agZ = (-this.mTempRect.top);
            k = j;
          }
          if (this.aht.getInputMethodMode() != 2) {
            break label757;
          }
          j = 1;
          localObject1 = this.ahj;
          i1 = this.agZ;
          localObject2 = new Rect();
          ((View)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
          ((View)localObject1).getLocationOnScreen(new int[2]);
          m = ((Rect)localObject2).bottom;
          if (j == 0) {
            break label1332;
          }
        }
        for (int j = ((View)localObject1).getContext().getResources().getDisplayMetrics().heightPixels;; j = m)
        {
          j -= i1;
          m = j;
          if (this.aht.getBackground() != null)
          {
            this.aht.getBackground().getPadding(this.mTempRect);
            m = j - (this.mTempRect.top + this.mTempRect.bottom);
          }
          if ((this.ahe) || (this.agX == -1))
          {
            i = m + k;
            bool1 = isInputMethodNotNeeded();
            if (!this.aht.isShowing()) {
              break label1041;
            }
            if (this.aaV != -1) {
              break label910;
            }
            j = -1;
            if (this.agX != -1) {
              break label979;
            }
            if (!bool1) {
              break label938;
            }
            if (!bool1) {
              break label948;
            }
            localObject1 = this.aht;
            if (this.aaV != -1) {
              break label943;
            }
            k = n;
            label580:
            ((PopupWindow)localObject1).setWindowLayoutMode(k, 0);
            label587:
            this.aht.update(j, i);
            localObject1 = this.aht;
            if ((this.ahf) || (this.ahe)) {
              break label996;
            }
          }
          label979:
          label996:
          for (bool1 = bool2;; bool1 = false)
          {
            ((PopupWindow)localObject1).setOutsideTouchable(bool1);
            if (!this.jpt) {
              break label1002;
            }
            this.aht.showAtLocation(this.ahj, 17, 0, 0);
            AppMethodBeat.o(123923);
            return;
            bool1 = false;
            break;
            localLayoutParams2.gravity = 80;
            ((FrameLayout)localObject2).addView((View)localObject1, localLayoutParams1);
            ((FrameLayout)localObject2).addView(localView, localLayoutParams2);
            break label278;
            localLayoutParams2.gravity = 48;
            ((FrameLayout)localObject2).addView((View)localObject1, localLayoutParams1);
            ((FrameLayout)localObject2).addView(localView, localLayoutParams2);
            break label278;
            this.aht.getContentView();
            localObject1 = this.ahh;
            if (localObject1 == null) {
              break label1338;
            }
            i = ((View)localObject1).getMeasuredHeight();
            break label309;
            this.mTempRect.setEmpty();
            k = 0;
            break label372;
            label757:
            j = 0;
            break label385;
            switch (this.aaV)
            {
            default: 
              j = View.MeasureSpec.makeMeasureSpec(this.aaV, 1073741824);
            }
            for (;;)
            {
              m = this.jpo.dy(j, m - i);
              j = i;
              if (m > 0) {
                j = i + k;
              }
              i = j + m;
              break;
              j = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), -2147483648);
              continue;
              j = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
            }
            if (this.aaV == -2)
            {
              j = this.ahj.getWidth();
              break label545;
            }
            j = this.aaV;
            break label545;
            i = -1;
            break label558;
            k = 0;
            break label580;
            localObject1 = this.aht;
            if (this.aaV == -1) {}
            for (k = -1;; k = 0)
            {
              ((PopupWindow)localObject1).setWindowLayoutMode(k, -1);
              break;
            }
            if (this.agX == -2) {
              break label587;
            }
            i = this.agX;
            break label587;
          }
          label1002:
          this.aht.update(this.ahj, this.agY, this.agZ, this.aht.getWidth(), this.aht.getHeight());
          AppMethodBeat.o(123923);
          return;
          if (this.aaV == -1)
          {
            j = -1;
            if (this.agX != -1) {
              break label1232;
            }
            i = -1;
            this.aht.setWindowLayoutMode(j, i);
            localObject1 = this.aht;
            if ((this.ahf) || (this.ahe)) {
              break label1270;
            }
            bool1 = bool3;
            label1094:
            ((PopupWindow)localObject1).setOutsideTouchable(bool1);
            this.aht.setTouchInterceptor(this.jpq);
            if (!this.jpt) {
              break label1276;
            }
            this.aht.showAtLocation(this.ahj, 17, 0, 0);
          }
          for (;;)
          {
            this.jpo.setSelection(-1);
            if ((!this.ahs) || (this.jpo.isInTouchMode())) {
              clearListSelection();
            }
            if (!this.ahs) {
              this.mHandler.post(this.jps);
            }
            AppMethodBeat.o(123923);
            return;
            if (this.aaV == -2)
            {
              this.aht.setWidth(this.ahj.getWidth());
              j = 0;
              break;
            }
            this.aht.setWidth(this.aaV);
            j = 0;
            break;
            label1232:
            if (this.agX == -2)
            {
              this.aht.setHeight(i);
              i = 0;
              break label1061;
            }
            this.aht.setHeight(this.agX);
            i = 0;
            break label1061;
            label1270:
            bool1 = false;
            break label1094;
            label1276:
            if (Build.VERSION.SDK_INT >= 19) {
              this.aht.showAsDropDown(this.ahj, this.agY, this.agZ, 53);
            } else {
              this.aht.showAtLocation(this.ahj, 53, this.agY, this.agZ);
            }
          }
        }
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase
 * JD-Core Version:    0.7.0.1
 */