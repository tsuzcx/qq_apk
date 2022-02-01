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
import com.tencent.mm.sdk.platformtools.ap;

public class AutoFillListPopupWindowBase
{
  ListAdapter DP;
  int aib;
  PopupWindow aoA;
  int aoe;
  int aof;
  int aog;
  boolean aoi;
  boolean aol;
  boolean aom;
  int aon;
  private View aoo;
  private int aop;
  View aoq;
  private Drawable aor;
  private AdapterView.OnItemClickListener aos;
  private AdapterView.OnItemSelectedListener aot;
  private Runnable aoy;
  boolean aoz;
  private Context mContext;
  private ap mHandler;
  DataSetObserver mObserver;
  private Rect mTempRect;
  AutoFillListPopupWindowBase.a mfg;
  private final f mfh;
  private final e mfi;
  private final d mfj;
  private final b mfk;
  private boolean mfl;
  
  public AutoFillListPopupWindowBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969239);
  }
  
  public AutoFillListPopupWindowBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(136663);
    this.aoe = -2;
    this.aib = -2;
    this.aol = false;
    this.aom = false;
    this.aon = 2147483647;
    this.aop = 0;
    this.mfh = new f((byte)0);
    this.mfi = new e((byte)0);
    this.mfj = new d((byte)0);
    this.mfk = new b((byte)0);
    this.mHandler = new ap();
    this.mTempRect = new Rect();
    this.mfl = false;
    this.mContext = paramContext;
    this.aoA = new PopupWindow(paramContext);
    this.aoA.setInputMethodMode(1);
    paramContext = this.mContext.getResources().getConfiguration().locale;
    AppMethodBeat.o(136663);
  }
  
  private void jX()
  {
    AppMethodBeat.i(136667);
    if (this.aoo != null)
    {
      ViewParent localViewParent = this.aoo.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.aoo);
      }
    }
    AppMethodBeat.o(136667);
  }
  
  public final void clearListSelection()
  {
    AppMethodBeat.i(136668);
    AutoFillListPopupWindowBase.a locala = this.mfg;
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
    this.aoA.dismiss();
    jX();
    this.aoA.setContentView(null);
    this.mfg = null;
    this.mHandler.removeCallbacks(this.mfh);
    AppMethodBeat.o(136665);
  }
  
  public final boolean isInputMethodNotNeeded()
  {
    AppMethodBeat.i(136669);
    if (this.aoA.getInputMethodMode() == 2)
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
    this.aoA.setOnDismissListener(paramOnDismissListener);
    AppMethodBeat.o(136666);
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.aog = paramInt;
    this.aoi = true;
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
    if (this.mfg == null)
    {
      localObject2 = this.mContext;
      this.aoy = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136647);
          View localView = AutoFillListPopupWindowBase.this.aoq;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            AutoFillListPopupWindowBase.this.show();
          }
          AppMethodBeat.o(136647);
        }
      };
      if (!this.aoz)
      {
        bool1 = true;
        this.mfg = new AutoFillListPopupWindowBase.a((Context)localObject2, bool1);
        if (this.aor != null) {
          this.mfg.setSelector(this.aor);
        }
        this.mfg.setAdapter(this.DP);
        this.mfg.setOnItemClickListener(this.aos);
        this.mfg.setFocusable(true);
        this.mfg.setFocusableInTouchMode(true);
        this.mfg.setDivider(null);
        this.mfg.setDividerHeight(0);
        this.mfg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
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
        this.mfg.setOnScrollListener(this.mfj);
        if (this.aot != null) {
          this.mfg.setOnItemSelectedListener(this.aot);
        }
        localObject1 = this.mfg;
        localView = this.aoo;
        if (localView == null) {
          break label1343;
        }
        jX();
        localObject2 = new FrameLayout((Context)localObject2);
        localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
        localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        switch (this.aop)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.aop);
          label278:
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.aib, -2147483648), 0);
          localObject1 = localObject2;
        }
      }
    }
    label309:
    label1338:
    label1343:
    for (;;)
    {
      this.aoA.setContentView((View)localObject1);
      int i = 0;
      for (;;)
      {
        localObject1 = this.aoA.getBackground();
        int k;
        label372:
        int i1;
        int m;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          k = j;
          if (!this.aoi)
          {
            this.aog = (-this.mTempRect.top);
            k = j;
          }
          if (this.aoA.getInputMethodMode() != 2) {
            break label757;
          }
          j = 1;
          localObject1 = this.aoq;
          i1 = this.aog;
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
          if (this.aoA.getBackground() != null)
          {
            this.aoA.getBackground().getPadding(this.mTempRect);
            m = j - (this.mTempRect.top + this.mTempRect.bottom);
          }
          if ((this.aol) || (this.aoe == -1))
          {
            i = m + k;
            bool1 = isInputMethodNotNeeded();
            if (!this.aoA.isShowing()) {
              break label1041;
            }
            if (this.aib != -1) {
              break label910;
            }
            j = -1;
            if (this.aoe != -1) {
              break label979;
            }
            if (!bool1) {
              break label938;
            }
            if (!bool1) {
              break label948;
            }
            localObject1 = this.aoA;
            if (this.aib != -1) {
              break label943;
            }
            k = n;
            label580:
            ((PopupWindow)localObject1).setWindowLayoutMode(k, 0);
            label587:
            this.aoA.update(j, i);
            localObject1 = this.aoA;
            if ((this.aom) || (this.aol)) {
              break label996;
            }
          }
          label979:
          label996:
          for (bool1 = bool2;; bool1 = false)
          {
            ((PopupWindow)localObject1).setOutsideTouchable(bool1);
            if (!this.mfl) {
              break label1002;
            }
            this.aoA.showAtLocation(this.aoq, 17, 0, 0);
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
            this.aoA.getContentView();
            localObject1 = this.aoo;
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
            switch (this.aib)
            {
            default: 
              j = View.MeasureSpec.makeMeasureSpec(this.aib, 1073741824);
            }
            for (;;)
            {
              m = this.mfg.et(j, m - i);
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
            if (this.aib == -2)
            {
              j = this.aoq.getWidth();
              break label545;
            }
            j = this.aib;
            break label545;
            i = -1;
            break label558;
            k = 0;
            break label580;
            localObject1 = this.aoA;
            if (this.aib == -1) {}
            for (k = -1;; k = 0)
            {
              ((PopupWindow)localObject1).setWindowLayoutMode(k, -1);
              break;
            }
            if (this.aoe == -2) {
              break label587;
            }
            i = this.aoe;
            break label587;
          }
          label1002:
          this.aoA.update(this.aoq, this.aof, this.aog, this.aoA.getWidth(), this.aoA.getHeight());
          AppMethodBeat.o(136664);
          return;
          if (this.aib == -1)
          {
            j = -1;
            if (this.aoe != -1) {
              break label1232;
            }
            i = -1;
            this.aoA.setWindowLayoutMode(j, i);
            localObject1 = this.aoA;
            if ((this.aom) || (this.aol)) {
              break label1270;
            }
            bool1 = bool3;
            label1094:
            ((PopupWindow)localObject1).setOutsideTouchable(bool1);
            this.aoA.setTouchInterceptor(this.mfi);
            if (!this.mfl) {
              break label1276;
            }
            this.aoA.showAtLocation(this.aoq, 17, 0, 0);
          }
          for (;;)
          {
            this.mfg.setSelection(-1);
            if ((!this.aoz) || (this.mfg.isInTouchMode())) {
              clearListSelection();
            }
            if (!this.aoz) {
              this.mHandler.post(this.mfk);
            }
            AppMethodBeat.o(136664);
            return;
            if (this.aib == -2)
            {
              this.aoA.setWidth(this.aoq.getWidth());
              j = 0;
              break;
            }
            this.aoA.setWidth(this.aib);
            j = 0;
            break;
            label1232:
            if (this.aoe == -2)
            {
              this.aoA.setHeight(i);
              i = 0;
              break label1061;
            }
            this.aoA.setHeight(this.aoe);
            i = 0;
            break label1061;
            label1270:
            bool1 = false;
            break label1094;
            label1276:
            if (Build.VERSION.SDK_INT >= 19) {
              this.aoA.showAsDropDown(this.aoq, this.aof, this.aog, 53);
            } else {
              this.aoA.showAtLocation(this.aoq, 53, this.aof, this.aog);
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
  
  final class c
    extends DataSetObserver
  {
    private c() {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(136657);
      if (AutoFillListPopupWindowBase.this.aoA.isShowing()) {
        AutoFillListPopupWindowBase.this.show();
      }
      AppMethodBeat.o(136657);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(136658);
      AutoFillListPopupWindowBase.this.dismiss();
      AppMethodBeat.o(136658);
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
      if ((AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this) != null) && (AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getCount() > AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getChildCount()) && (AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getChildCount() <= AutoFillListPopupWindowBase.this.aon))
      {
        AutoFillListPopupWindowBase.b(AutoFillListPopupWindowBase.this).setInputMethodMode(2);
        AutoFillListPopupWindowBase.this.show();
      }
      AppMethodBeat.o(136662);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase
 * JD-Core Version:    0.7.0.1
 */