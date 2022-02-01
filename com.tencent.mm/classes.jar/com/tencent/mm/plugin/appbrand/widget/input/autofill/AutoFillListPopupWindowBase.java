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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ao;

public class AutoFillListPopupWindowBase
{
  ListAdapter EN;
  int aiV;
  int aoZ;
  int apa;
  int apb;
  boolean apd;
  boolean apg;
  boolean aph;
  int api;
  private View apj;
  private int apk;
  View apl;
  private Drawable apm;
  private AdapterView.OnItemClickListener apn;
  private AdapterView.OnItemSelectedListener apo;
  private Runnable apu;
  boolean apv;
  PopupWindow apw;
  private Context mContext;
  private ao mHandler;
  AutoFillListPopupWindowBase.a mHf;
  private final f mHg;
  private final e mHh;
  private final d mHi;
  private final b mHj;
  private boolean mHk;
  DataSetObserver mObserver;
  private Rect mTempRect;
  
  public AutoFillListPopupWindowBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969239);
  }
  
  public AutoFillListPopupWindowBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(136663);
    this.aoZ = -2;
    this.aiV = -2;
    this.apg = false;
    this.aph = false;
    this.api = 2147483647;
    this.apk = 0;
    this.mHg = new f((byte)0);
    this.mHh = new e((byte)0);
    this.mHi = new d((byte)0);
    this.mHj = new b((byte)0);
    this.mHandler = new ao();
    this.mTempRect = new Rect();
    this.mHk = false;
    this.mContext = paramContext;
    this.apw = new PopupWindow(paramContext);
    this.apw.setInputMethodMode(1);
    paramContext = this.mContext.getResources().getConfiguration().locale;
    AppMethodBeat.o(136663);
  }
  
  private void kf()
  {
    AppMethodBeat.i(136667);
    if (this.apj != null)
    {
      ViewParent localViewParent = this.apj.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.apj);
      }
    }
    AppMethodBeat.o(136667);
  }
  
  public final void clearListSelection()
  {
    AppMethodBeat.i(136668);
    AutoFillListPopupWindowBase.a locala = this.mHf;
    if (locala != null)
    {
      AutoFillListPopupWindowBase.a.a(locala, true);
      locala.requestLayout();
    }
    AppMethodBeat.o(136668);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(136665);
    this.apw.dismiss();
    kf();
    this.apw.setContentView(null);
    this.mHf = null;
    this.mHandler.removeCallbacks(this.mHg);
    AppMethodBeat.o(136665);
  }
  
  public final boolean isInputMethodNotNeeded()
  {
    AppMethodBeat.i(136669);
    if (this.apw.getInputMethodMode() == 2)
    {
      AppMethodBeat.o(136669);
      return true;
    }
    AppMethodBeat.o(136669);
    return false;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(136666);
    this.apw.setOnDismissListener(paramOnDismissListener);
    AppMethodBeat.o(136666);
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.apb = paramInt;
    this.apd = true;
  }
  
  public void show()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    int n = -1;
    AppMethodBeat.i(136664);
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    FrameLayout.LayoutParams localLayoutParams1;
    FrameLayout.LayoutParams localLayoutParams2;
    if (this.mHf == null)
    {
      localObject2 = this.mContext;
      this.apu = new AutoFillListPopupWindowBase.1(this);
      if (!this.apv)
      {
        bool1 = true;
        this.mHf = new AutoFillListPopupWindowBase.a((Context)localObject2, bool1);
        if (this.apm != null) {
          this.mHf.setSelector(this.apm);
        }
        this.mHf.setAdapter(this.EN);
        this.mHf.setOnItemClickListener(this.apn);
        this.mHf.setFocusable(true);
        this.mHf.setFocusableInTouchMode(true);
        this.mHf.setDivider(null);
        this.mHf.setDividerHeight(0);
        this.mHf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(136648);
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this);
              if (paramAnonymousAdapterView != null) {
                AutoFillListPopupWindowBase.a.a(paramAnonymousAdapterView, false);
              }
            }
            AppMethodBeat.o(136648);
          }
          
          public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.mHf.setOnScrollListener(this.mHi);
        if (this.apo != null) {
          this.mHf.setOnItemSelectedListener(this.apo);
        }
        localObject1 = this.mHf;
        localView = this.apj;
        if (localView == null) {
          break label1343;
        }
        kf();
        localObject2 = new FrameLayout((Context)localObject2);
        localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
        localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        switch (this.apk)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.apk);
          label278:
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.aiV, -2147483648), 0);
          localObject1 = localObject2;
        }
      }
    }
    label309:
    label1338:
    label1343:
    for (;;)
    {
      this.apw.setContentView((View)localObject1);
      int i = 0;
      for (;;)
      {
        localObject1 = this.apw.getBackground();
        int k;
        label372:
        int i1;
        int m;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          k = j;
          if (!this.apd)
          {
            this.apb = (-this.mTempRect.top);
            k = j;
          }
          if (this.apw.getInputMethodMode() != 2) {
            break label757;
          }
          j = 1;
          localObject1 = this.apl;
          i1 = this.apb;
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
          if (this.apw.getBackground() != null)
          {
            this.apw.getBackground().getPadding(this.mTempRect);
            m = j - (this.mTempRect.top + this.mTempRect.bottom);
          }
          if ((this.apg) || (this.aoZ == -1))
          {
            i = m + k;
            bool1 = isInputMethodNotNeeded();
            if (!this.apw.isShowing()) {
              break label1041;
            }
            if (this.aiV != -1) {
              break label910;
            }
            j = -1;
            if (this.aoZ != -1) {
              break label979;
            }
            if (!bool1) {
              break label938;
            }
            if (!bool1) {
              break label948;
            }
            localObject1 = this.apw;
            if (this.aiV != -1) {
              break label943;
            }
            k = n;
            label580:
            ((PopupWindow)localObject1).setWindowLayoutMode(k, 0);
            label587:
            this.apw.update(j, i);
            localObject1 = this.apw;
            if ((this.aph) || (this.apg)) {
              break label996;
            }
          }
          label979:
          label996:
          for (bool1 = bool2;; bool1 = false)
          {
            ((PopupWindow)localObject1).setOutsideTouchable(bool1);
            if (!this.mHk) {
              break label1002;
            }
            this.apw.showAtLocation(this.apl, 17, 0, 0);
            AppMethodBeat.o(136664);
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
            this.apw.getContentView();
            localObject1 = this.apj;
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
            switch (this.aiV)
            {
            default: 
              j = View.MeasureSpec.makeMeasureSpec(this.aiV, 1073741824);
            }
            for (;;)
            {
              m = this.mHf.ew(j, m - i);
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
            if (this.aiV == -2)
            {
              j = this.apl.getWidth();
              break label545;
            }
            j = this.aiV;
            break label545;
            i = -1;
            break label558;
            k = 0;
            break label580;
            localObject1 = this.apw;
            if (this.aiV == -1) {}
            for (k = -1;; k = 0)
            {
              ((PopupWindow)localObject1).setWindowLayoutMode(k, -1);
              break;
            }
            if (this.aoZ == -2) {
              break label587;
            }
            i = this.aoZ;
            break label587;
          }
          label1002:
          this.apw.update(this.apl, this.apa, this.apb, this.apw.getWidth(), this.apw.getHeight());
          AppMethodBeat.o(136664);
          return;
          if (this.aiV == -1)
          {
            j = -1;
            if (this.aoZ != -1) {
              break label1232;
            }
            i = -1;
            this.apw.setWindowLayoutMode(j, i);
            localObject1 = this.apw;
            if ((this.aph) || (this.apg)) {
              break label1270;
            }
            bool1 = bool3;
            label1094:
            ((PopupWindow)localObject1).setOutsideTouchable(bool1);
            this.apw.setTouchInterceptor(this.mHh);
            if (!this.mHk) {
              break label1276;
            }
            this.apw.showAtLocation(this.apl, 17, 0, 0);
          }
          for (;;)
          {
            this.mHf.setSelection(-1);
            if ((!this.apv) || (this.mHf.isInTouchMode())) {
              clearListSelection();
            }
            if (!this.apv) {
              this.mHandler.post(this.mHj);
            }
            AppMethodBeat.o(136664);
            return;
            if (this.aiV == -2)
            {
              this.apw.setWidth(this.apl.getWidth());
              j = 0;
              break;
            }
            this.apw.setWidth(this.aiV);
            j = 0;
            break;
            label1232:
            if (this.aoZ == -2)
            {
              this.apw.setHeight(i);
              i = 0;
              break label1061;
            }
            this.apw.setHeight(this.aoZ);
            i = 0;
            break label1061;
            label1270:
            bool1 = false;
            break label1094;
            label1276:
            if (Build.VERSION.SDK_INT >= 19) {
              this.apw.showAsDropDown(this.apl, this.apa, this.apb, 53);
            } else {
              this.apw.showAtLocation(this.apl, 53, this.apa, this.apb);
            }
          }
        }
        i = 0;
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(136656);
      AutoFillListPopupWindowBase.this.clearListSelection();
      AppMethodBeat.o(136656);
    }
  }
  
  final class d
    implements AbsListView.OnScrollListener
  {
    private d() {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(136659);
      if ((AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this) != null) && (AutoFillListPopupWindowBase.e(AutoFillListPopupWindowBase.this) != null) && (AutoFillListPopupWindowBase.f(AutoFillListPopupWindowBase.this) != null) && (AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this) != null))
      {
        if ((AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getLastVisiblePosition() == AutoFillListPopupWindowBase.f(AutoFillListPopupWindowBase.this).getCount() - 1) && (AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getChildAt(AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getChildCount() - 1) != null) && (AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getChildAt(AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getChildCount() - 1).getBottom() <= AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getHeight()))
        {
          AutoFillListPopupWindowBase.e(AutoFillListPopupWindowBase.this).setVisibility(8);
          AppMethodBeat.o(136659);
          return;
        }
        AutoFillListPopupWindowBase.e(AutoFillListPopupWindowBase.this).setVisibility(0);
      }
      AppMethodBeat.o(136659);
    }
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(136660);
      if ((paramInt == 1) && (!AutoFillListPopupWindowBase.this.isInputMethodNotNeeded()) && (AutoFillListPopupWindowBase.b(AutoFillListPopupWindowBase.this).getContentView() != null))
      {
        AutoFillListPopupWindowBase.d(AutoFillListPopupWindowBase.this).removeCallbacks(AutoFillListPopupWindowBase.c(AutoFillListPopupWindowBase.this));
        AutoFillListPopupWindowBase.c(AutoFillListPopupWindowBase.this).run();
      }
      AppMethodBeat.o(136660);
    }
  }
  
  final class e
    implements View.OnTouchListener
  {
    private e() {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(136661);
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (AutoFillListPopupWindowBase.b(AutoFillListPopupWindowBase.this) != null) && (AutoFillListPopupWindowBase.b(AutoFillListPopupWindowBase.this).isShowing()) && (j >= 0) && (j < AutoFillListPopupWindowBase.b(AutoFillListPopupWindowBase.this).getWidth()) && (k >= 0) && (k < AutoFillListPopupWindowBase.b(AutoFillListPopupWindowBase.this).getHeight())) {
        AutoFillListPopupWindowBase.d(AutoFillListPopupWindowBase.this).postDelayed(AutoFillListPopupWindowBase.c(AutoFillListPopupWindowBase.this), 250L);
      }
      for (;;)
      {
        AppMethodBeat.o(136661);
        return false;
        if (i == 1) {
          AutoFillListPopupWindowBase.d(AutoFillListPopupWindowBase.this).removeCallbacks(AutoFillListPopupWindowBase.c(AutoFillListPopupWindowBase.this));
        }
      }
    }
  }
  
  final class f
    implements Runnable
  {
    private f() {}
    
    public final void run()
    {
      AppMethodBeat.i(136662);
      if ((AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this) != null) && (AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getCount() > AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getChildCount()) && (AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getChildCount() <= AutoFillListPopupWindowBase.this.api))
      {
        AutoFillListPopupWindowBase.b(AutoFillListPopupWindowBase.this).setInputMethodMode(2);
        AutoFillListPopupWindowBase.this.show();
      }
      AppMethodBeat.o(136662);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase
 * JD-Core Version:    0.7.0.1
 */