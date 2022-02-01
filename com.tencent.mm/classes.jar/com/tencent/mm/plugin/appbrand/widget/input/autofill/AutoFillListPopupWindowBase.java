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
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.luggage.wxa.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class AutoFillListPopupWindowBase
{
  ListAdapter eP;
  private Context mContext;
  private MMHandler mHandler;
  DataSetObserver mObserver;
  private Rect mTempRect;
  int rj;
  a rzm;
  private final f rzn;
  private final e rzo;
  private final d rzp;
  private final b rzq;
  private boolean rzr;
  int sZ;
  int ta;
  int tb;
  boolean td;
  private boolean tg;
  private boolean th;
  int ti;
  private View tj;
  private int tk;
  View tl;
  private Drawable tn;
  private AdapterView.OnItemClickListener tp;
  private AdapterView.OnItemSelectedListener tq;
  private Runnable tw;
  private boolean tx;
  PopupWindow ty;
  
  public AutoFillListPopupWindowBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.listPopupWindowStyle);
  }
  
  public AutoFillListPopupWindowBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(136663);
    this.sZ = -2;
    this.rj = -2;
    this.tg = false;
    this.th = false;
    this.ti = 2147483647;
    this.tk = 0;
    this.rzn = new f((byte)0);
    this.rzo = new e((byte)0);
    this.rzp = new d((byte)0);
    this.rzq = new b((byte)0);
    this.mHandler = new MMHandler();
    this.mTempRect = new Rect();
    this.rzr = false;
    this.mContext = paramContext;
    this.ty = new PopupWindow(paramContext);
    this.ty.setInputMethodMode(1);
    paramContext = this.mContext.getResources().getConfiguration().locale;
    AppMethodBeat.o(136663);
  }
  
  private void dM()
  {
    AppMethodBeat.i(136667);
    if (this.tj != null)
    {
      ViewParent localViewParent = this.tj.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.tj);
      }
    }
    AppMethodBeat.o(136667);
  }
  
  public final void ah(int paramInt)
  {
    this.tb = paramInt;
    this.td = true;
  }
  
  public final void cpv()
  {
    AppMethodBeat.i(214143);
    this.tx = true;
    this.ty.setFocusable(false);
    AppMethodBeat.o(214143);
  }
  
  public final void cpw()
  {
    this.th = true;
  }
  
  public final void cpx()
  {
    this.tg = false;
  }
  
  public final void dO()
  {
    AppMethodBeat.i(136668);
    a locala = this.rzm;
    if (locala != null)
    {
      a.a(locala, true);
      locala.requestLayout();
    }
    AppMethodBeat.o(136668);
  }
  
  public final boolean dP()
  {
    AppMethodBeat.i(136669);
    if (this.ty.getInputMethodMode() == 2)
    {
      AppMethodBeat.o(136669);
      return true;
    }
    AppMethodBeat.o(136669);
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(136665);
    this.ty.dismiss();
    dM();
    this.ty.setContentView(null);
    this.rzm = null;
    this.mHandler.removeCallbacks(this.rzn);
    AppMethodBeat.o(136665);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(136666);
    this.ty.setOnDismissListener(paramOnDismissListener);
    AppMethodBeat.o(136666);
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
    if (this.rzm == null)
    {
      localObject2 = this.mContext;
      this.tw = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136647);
          View localView = AutoFillListPopupWindowBase.this.tl;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            AutoFillListPopupWindowBase.this.show();
          }
          AppMethodBeat.o(136647);
        }
      };
      if (!this.tx)
      {
        bool1 = true;
        this.rzm = new a((Context)localObject2, bool1);
        if (this.tn != null) {
          this.rzm.setSelector(this.tn);
        }
        this.rzm.setAdapter(this.eP);
        this.rzm.setOnItemClickListener(this.tp);
        this.rzm.setFocusable(true);
        this.rzm.setFocusableInTouchMode(true);
        this.rzm.setDivider(null);
        this.rzm.setDividerHeight(0);
        this.rzm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(136648);
            b localb = new b();
            localb.bn(paramAnonymousAdapterView);
            localb.bn(paramAnonymousView);
            localb.sg(paramAnonymousInt);
            localb.Fs(paramAnonymousLong);
            a.c("com/tencent/mm/plugin/appbrand/widget/input/autofill/AutoFillListPopupWindowBase$2", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
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
        this.rzm.setOnScrollListener(this.rzp);
        if (this.tq != null) {
          this.rzm.setOnItemSelectedListener(this.tq);
        }
        localObject1 = this.rzm;
        localView = this.tj;
        if (localView == null) {
          break label1343;
        }
        dM();
        localObject2 = new FrameLayout((Context)localObject2);
        localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
        localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        switch (this.tk)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.tk);
          label278:
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.rj, -2147483648), 0);
          localObject1 = localObject2;
        }
      }
    }
    label309:
    label1338:
    label1343:
    for (;;)
    {
      this.ty.setContentView((View)localObject1);
      int i = 0;
      for (;;)
      {
        localObject1 = this.ty.getBackground();
        int k;
        label372:
        int i1;
        int m;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          k = j;
          if (!this.td)
          {
            this.tb = (-this.mTempRect.top);
            k = j;
          }
          if (this.ty.getInputMethodMode() != 2) {
            break label757;
          }
          j = 1;
          localObject1 = this.tl;
          i1 = this.tb;
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
          if (this.ty.getBackground() != null)
          {
            this.ty.getBackground().getPadding(this.mTempRect);
            m = j - (this.mTempRect.top + this.mTempRect.bottom);
          }
          if ((this.tg) || (this.sZ == -1))
          {
            i = m + k;
            bool1 = dP();
            if (!this.ty.isShowing()) {
              break label1041;
            }
            if (this.rj != -1) {
              break label910;
            }
            j = -1;
            if (this.sZ != -1) {
              break label979;
            }
            if (!bool1) {
              break label938;
            }
            if (!bool1) {
              break label948;
            }
            localObject1 = this.ty;
            if (this.rj != -1) {
              break label943;
            }
            k = n;
            label580:
            ((PopupWindow)localObject1).setWindowLayoutMode(k, 0);
            label587:
            this.ty.update(j, i);
            localObject1 = this.ty;
            if ((this.th) || (this.tg)) {
              break label996;
            }
          }
          label979:
          label996:
          for (bool1 = bool2;; bool1 = false)
          {
            ((PopupWindow)localObject1).setOutsideTouchable(bool1);
            if (!this.rzr) {
              break label1002;
            }
            this.ty.showAtLocation(this.tl, 17, 0, 0);
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
            this.ty.getContentView();
            localObject1 = this.tj;
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
            switch (this.rj)
            {
            default: 
              j = View.MeasureSpec.makeMeasureSpec(this.rj, 1073741824);
            }
            for (;;)
            {
              m = this.rzm.fk(j, m - i);
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
            if (this.rj == -2)
            {
              j = this.tl.getWidth();
              break label545;
            }
            j = this.rj;
            break label545;
            i = -1;
            break label558;
            k = 0;
            break label580;
            localObject1 = this.ty;
            if (this.rj == -1) {}
            for (k = -1;; k = 0)
            {
              ((PopupWindow)localObject1).setWindowLayoutMode(k, -1);
              break;
            }
            if (this.sZ == -2) {
              break label587;
            }
            i = this.sZ;
            break label587;
          }
          label1002:
          this.ty.update(this.tl, this.ta, this.tb, this.ty.getWidth(), this.ty.getHeight());
          AppMethodBeat.o(136664);
          return;
          if (this.rj == -1)
          {
            j = -1;
            if (this.sZ != -1) {
              break label1232;
            }
            i = -1;
            this.ty.setWindowLayoutMode(j, i);
            localObject1 = this.ty;
            if ((this.th) || (this.tg)) {
              break label1270;
            }
            bool1 = bool3;
            label1094:
            ((PopupWindow)localObject1).setOutsideTouchable(bool1);
            this.ty.setTouchInterceptor(this.rzo);
            if (!this.rzr) {
              break label1276;
            }
            this.ty.showAtLocation(this.tl, 17, 0, 0);
          }
          for (;;)
          {
            this.rzm.setSelection(-1);
            if ((!this.tx) || (this.rzm.isInTouchMode())) {
              dO();
            }
            if (!this.tx) {
              this.mHandler.post(this.rzq);
            }
            AppMethodBeat.o(136664);
            return;
            if (this.rj == -2)
            {
              this.ty.setWidth(this.tl.getWidth());
              j = 0;
              break;
            }
            this.ty.setWidth(this.rj);
            j = 0;
            break;
            label1232:
            if (this.sZ == -2)
            {
              this.ty.setHeight(i);
              i = 0;
              break label1061;
            }
            this.ty.setHeight(this.sZ);
            i = 0;
            break label1061;
            label1270:
            bool1 = false;
            break label1094;
            label1276:
            if (Build.VERSION.SDK_INT >= 19) {
              this.ty.showAsDropDown(this.tl, this.ta, this.tb, 53);
            } else {
              this.ty.showAtLocation(this.tl, 53, this.ta, this.tb);
            }
          }
        }
        i = 0;
      }
    }
  }
  
  static final class a
    extends ListView
  {
    private boolean so;
    private boolean sq;
    
    public a(Context paramContext, boolean paramBoolean)
    {
      super(null, a.b.dropDownListViewStyle);
      AppMethodBeat.i(136649);
      this.sq = paramBoolean;
      setCacheColorHint(0);
      AppMethodBeat.o(136649);
    }
    
    final int fk(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(136654);
      int i = getListPaddingTop();
      int k = getListPaddingBottom();
      getListPaddingLeft();
      getListPaddingRight();
      int j = getDividerHeight();
      Object localObject = getDivider();
      ListAdapter localListAdapter = getAdapter();
      if (localListAdapter == null)
      {
        AppMethodBeat.o(136654);
        return i + k;
      }
      i = k + i;
      int n;
      label92:
      int m;
      if ((j > 0) && (localObject != null))
      {
        int i2 = localListAdapter.getCount();
        k = 0;
        n = 0;
        localObject = null;
        if (k >= i2) {
          break label233;
        }
        int i1 = localListAdapter.getItemViewType(k);
        m = n;
        if (i1 != n)
        {
          m = i1;
          localObject = null;
        }
        localObject = localListAdapter.getView(k, (View)localObject, this);
        n = ((View)localObject).getLayoutParams().height;
        if (n <= 0) {
          break label210;
        }
        n = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
        label166:
        ((View)localObject).measure(paramInt1, n);
        if (k <= 0) {
          break label240;
        }
        i += j;
      }
      label210:
      label233:
      label240:
      for (;;)
      {
        i = ((View)localObject).getMeasuredHeight() + i;
        if (i >= paramInt2)
        {
          AppMethodBeat.o(136654);
          return paramInt2;
          j = 0;
          break;
          n = View.MeasureSpec.makeMeasureSpec(0, 0);
          break label166;
        }
        k += 1;
        n = m;
        break label92;
        AppMethodBeat.o(136654);
        return i;
      }
    }
    
    public final boolean hasFocus()
    {
      AppMethodBeat.i(136653);
      if ((this.sq) || (super.hasFocus()))
      {
        AppMethodBeat.o(136653);
        return true;
      }
      AppMethodBeat.o(136653);
      return false;
    }
    
    public final boolean hasWindowFocus()
    {
      AppMethodBeat.i(136651);
      if ((this.sq) || (super.hasWindowFocus()))
      {
        AppMethodBeat.o(136651);
        return true;
      }
      AppMethodBeat.o(136651);
      return false;
    }
    
    public final boolean isFocused()
    {
      AppMethodBeat.i(136652);
      if ((this.sq) || (super.isFocused()))
      {
        AppMethodBeat.o(136652);
        return true;
      }
      AppMethodBeat.o(136652);
      return false;
    }
    
    public final boolean isInTouchMode()
    {
      AppMethodBeat.i(136650);
      if (((this.sq) && (this.so)) || (super.isInTouchMode()))
      {
        AppMethodBeat.o(136650);
        return true;
      }
      AppMethodBeat.o(136650);
      return false;
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(136656);
      AutoFillListPopupWindowBase.this.dO();
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
      if (AutoFillListPopupWindowBase.this.ty.isShowing()) {
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
      if ((paramInt == 1) && (!AutoFillListPopupWindowBase.this.dP()) && (AutoFillListPopupWindowBase.b(AutoFillListPopupWindowBase.this).getContentView() != null))
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
      if ((AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this) != null) && (AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getCount() > AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getChildCount()) && (AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getChildCount() <= AutoFillListPopupWindowBase.this.ti))
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