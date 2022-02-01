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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ap;

public class AutoFillListPopupWindowBase
{
  ListAdapter GE;
  int akM;
  int aqR;
  int aqS;
  int aqT;
  boolean aqV;
  boolean aqY;
  boolean aqZ;
  int ara;
  private View arb;
  private int arc;
  View ard;
  private Drawable are;
  private AdapterView.OnItemClickListener arf;
  private AdapterView.OnItemSelectedListener arg;
  private Runnable arl;
  boolean arm;
  PopupWindow arn;
  private Context mContext;
  private ap mHandler;
  DataSetObserver mObserver;
  private Rect mTempRect;
  AutoFillListPopupWindowBase.a nhD;
  private final f nhE;
  private final e nhF;
  private final d nhG;
  private final b nhH;
  private boolean nhI;
  
  public AutoFillListPopupWindowBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969239);
  }
  
  public AutoFillListPopupWindowBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(136663);
    this.aqR = -2;
    this.akM = -2;
    this.aqY = false;
    this.aqZ = false;
    this.ara = 2147483647;
    this.arc = 0;
    this.nhE = new f((byte)0);
    this.nhF = new e((byte)0);
    this.nhG = new d((byte)0);
    this.nhH = new b((byte)0);
    this.mHandler = new ap();
    this.mTempRect = new Rect();
    this.nhI = false;
    this.mContext = paramContext;
    this.arn = new PopupWindow(paramContext);
    this.arn.setInputMethodMode(1);
    paramContext = this.mContext.getResources().getConfiguration().locale;
    AppMethodBeat.o(136663);
  }
  
  private void kv()
  {
    AppMethodBeat.i(136667);
    if (this.arb != null)
    {
      ViewParent localViewParent = this.arb.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.arb);
      }
    }
    AppMethodBeat.o(136667);
  }
  
  public final void clearListSelection()
  {
    AppMethodBeat.i(136668);
    AutoFillListPopupWindowBase.a locala = this.nhD;
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
    this.arn.dismiss();
    kv();
    this.arn.setContentView(null);
    this.nhD = null;
    this.mHandler.removeCallbacks(this.nhE);
    AppMethodBeat.o(136665);
  }
  
  public final boolean isInputMethodNotNeeded()
  {
    AppMethodBeat.i(136669);
    if (this.arn.getInputMethodMode() == 2)
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
    this.arn.setOnDismissListener(paramOnDismissListener);
    AppMethodBeat.o(136666);
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.aqT = paramInt;
    this.aqV = true;
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
    if (this.nhD == null)
    {
      localObject2 = this.mContext;
      this.arl = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136647);
          View localView = AutoFillListPopupWindowBase.this.ard;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            AutoFillListPopupWindowBase.this.show();
          }
          AppMethodBeat.o(136647);
        }
      };
      if (!this.arm)
      {
        bool1 = true;
        this.nhD = new AutoFillListPopupWindowBase.a((Context)localObject2, bool1);
        if (this.are != null) {
          this.nhD.setSelector(this.are);
        }
        this.nhD.setAdapter(this.GE);
        this.nhD.setOnItemClickListener(this.arf);
        this.nhD.setFocusable(true);
        this.nhD.setFocusableInTouchMode(true);
        this.nhD.setDivider(null);
        this.nhD.setDividerHeight(0);
        this.nhD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(136648);
            b localb = new b();
            localb.bd(paramAnonymousAdapterView);
            localb.bd(paramAnonymousView);
            localb.mr(paramAnonymousInt);
            localb.qY(paramAnonymousLong);
            a.b("com/tencent/mm/plugin/appbrand/widget/input/autofill/AutoFillListPopupWindowBase$2", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this);
              if (paramAnonymousAdapterView != null) {
                AutoFillListPopupWindowBase.a.a(paramAnonymousAdapterView, false);
              }
            }
            a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/autofill/AutoFillListPopupWindowBase$2", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(136648);
          }
          
          public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.nhD.setOnScrollListener(this.nhG);
        if (this.arg != null) {
          this.nhD.setOnItemSelectedListener(this.arg);
        }
        localObject1 = this.nhD;
        localView = this.arb;
        if (localView == null) {
          break label1343;
        }
        kv();
        localObject2 = new FrameLayout((Context)localObject2);
        localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
        localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        switch (this.arc)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.arc);
          label278:
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.akM, -2147483648), 0);
          localObject1 = localObject2;
        }
      }
    }
    label309:
    label1338:
    label1343:
    for (;;)
    {
      this.arn.setContentView((View)localObject1);
      int i = 0;
      for (;;)
      {
        localObject1 = this.arn.getBackground();
        int k;
        label372:
        int i1;
        int m;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          k = j;
          if (!this.aqV)
          {
            this.aqT = (-this.mTempRect.top);
            k = j;
          }
          if (this.arn.getInputMethodMode() != 2) {
            break label757;
          }
          j = 1;
          localObject1 = this.ard;
          i1 = this.aqT;
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
          if (this.arn.getBackground() != null)
          {
            this.arn.getBackground().getPadding(this.mTempRect);
            m = j - (this.mTempRect.top + this.mTempRect.bottom);
          }
          if ((this.aqY) || (this.aqR == -1))
          {
            i = m + k;
            bool1 = isInputMethodNotNeeded();
            if (!this.arn.isShowing()) {
              break label1041;
            }
            if (this.akM != -1) {
              break label910;
            }
            j = -1;
            if (this.aqR != -1) {
              break label979;
            }
            if (!bool1) {
              break label938;
            }
            if (!bool1) {
              break label948;
            }
            localObject1 = this.arn;
            if (this.akM != -1) {
              break label943;
            }
            k = n;
            label580:
            ((PopupWindow)localObject1).setWindowLayoutMode(k, 0);
            label587:
            this.arn.update(j, i);
            localObject1 = this.arn;
            if ((this.aqZ) || (this.aqY)) {
              break label996;
            }
          }
          label979:
          label996:
          for (bool1 = bool2;; bool1 = false)
          {
            ((PopupWindow)localObject1).setOutsideTouchable(bool1);
            if (!this.nhI) {
              break label1002;
            }
            this.arn.showAtLocation(this.ard, 17, 0, 0);
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
            this.arn.getContentView();
            localObject1 = this.arb;
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
            switch (this.akM)
            {
            default: 
              j = View.MeasureSpec.makeMeasureSpec(this.akM, 1073741824);
            }
            for (;;)
            {
              m = this.nhD.ey(j, m - i);
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
            if (this.akM == -2)
            {
              j = this.ard.getWidth();
              break label545;
            }
            j = this.akM;
            break label545;
            i = -1;
            break label558;
            k = 0;
            break label580;
            localObject1 = this.arn;
            if (this.akM == -1) {}
            for (k = -1;; k = 0)
            {
              ((PopupWindow)localObject1).setWindowLayoutMode(k, -1);
              break;
            }
            if (this.aqR == -2) {
              break label587;
            }
            i = this.aqR;
            break label587;
          }
          label1002:
          this.arn.update(this.ard, this.aqS, this.aqT, this.arn.getWidth(), this.arn.getHeight());
          AppMethodBeat.o(136664);
          return;
          if (this.akM == -1)
          {
            j = -1;
            if (this.aqR != -1) {
              break label1232;
            }
            i = -1;
            this.arn.setWindowLayoutMode(j, i);
            localObject1 = this.arn;
            if ((this.aqZ) || (this.aqY)) {
              break label1270;
            }
            bool1 = bool3;
            label1094:
            ((PopupWindow)localObject1).setOutsideTouchable(bool1);
            this.arn.setTouchInterceptor(this.nhF);
            if (!this.nhI) {
              break label1276;
            }
            this.arn.showAtLocation(this.ard, 17, 0, 0);
          }
          for (;;)
          {
            this.nhD.setSelection(-1);
            if ((!this.arm) || (this.nhD.isInTouchMode())) {
              clearListSelection();
            }
            if (!this.arm) {
              this.mHandler.post(this.nhH);
            }
            AppMethodBeat.o(136664);
            return;
            if (this.akM == -2)
            {
              this.arn.setWidth(this.ard.getWidth());
              j = 0;
              break;
            }
            this.arn.setWidth(this.akM);
            j = 0;
            break;
            label1232:
            if (this.aqR == -2)
            {
              this.arn.setHeight(i);
              i = 0;
              break label1061;
            }
            this.arn.setHeight(this.aqR);
            i = 0;
            break label1061;
            label1270:
            bool1 = false;
            break label1094;
            label1276:
            if (Build.VERSION.SDK_INT >= 19) {
              this.arn.showAsDropDown(this.ard, this.aqS, this.aqT, 53);
            } else {
              this.arn.showAtLocation(this.ard, 53, this.aqS, this.aqT);
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
      if (AutoFillListPopupWindowBase.this.arn.isShowing()) {
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
      b localb = new b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      a.b("com/tencent/mm/plugin/appbrand/widget/input/autofill/AutoFillListPopupWindowBase$PopupTouchInterceptor", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (AutoFillListPopupWindowBase.b(AutoFillListPopupWindowBase.this) != null) && (AutoFillListPopupWindowBase.b(AutoFillListPopupWindowBase.this).isShowing()) && (j >= 0) && (j < AutoFillListPopupWindowBase.b(AutoFillListPopupWindowBase.this).getWidth()) && (k >= 0) && (k < AutoFillListPopupWindowBase.b(AutoFillListPopupWindowBase.this).getHeight())) {
        AutoFillListPopupWindowBase.d(AutoFillListPopupWindowBase.this).postDelayed(AutoFillListPopupWindowBase.c(AutoFillListPopupWindowBase.this), 250L);
      }
      for (;;)
      {
        a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/input/autofill/AutoFillListPopupWindowBase$PopupTouchInterceptor", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
      if ((AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this) != null) && (AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getCount() > AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getChildCount()) && (AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getChildCount() <= AutoFillListPopupWindowBase.this.ara))
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