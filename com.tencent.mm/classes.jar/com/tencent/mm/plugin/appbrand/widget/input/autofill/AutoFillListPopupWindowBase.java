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
  ListAdapter fR;
  private Context mContext;
  private MMHandler mHandler;
  DataSetObserver mObserver;
  private Rect mTempRect;
  int sh;
  int tY;
  int tZ;
  a uKp;
  private final f uKq;
  private final e uKr;
  private final d uKs;
  private final b uKt;
  private boolean uKu;
  int ua;
  boolean uc;
  private boolean uf;
  private boolean ug;
  int uh;
  private View uj;
  private int uk;
  View ul;
  private Drawable um;
  private AdapterView.OnItemClickListener un;
  private AdapterView.OnItemSelectedListener uo;
  private Runnable uv;
  private boolean uw;
  PopupWindow ux;
  
  public AutoFillListPopupWindowBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.listPopupWindowStyle);
  }
  
  public AutoFillListPopupWindowBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(136663);
    this.tY = -2;
    this.sh = -2;
    this.uf = false;
    this.ug = false;
    this.uh = 2147483647;
    this.uk = 0;
    this.uKq = new f((byte)0);
    this.uKr = new e((byte)0);
    this.uKs = new d((byte)0);
    this.uKt = new b((byte)0);
    this.mHandler = new MMHandler();
    this.mTempRect = new Rect();
    this.uKu = false;
    this.mContext = paramContext;
    this.ux = new PopupWindow(paramContext);
    this.ux.setInputMethodMode(1);
    paramContext = this.mContext.getResources().getConfiguration().locale;
    AppMethodBeat.o(136663);
  }
  
  private void eM()
  {
    AppMethodBeat.i(136667);
    if (this.uj != null)
    {
      ViewParent localViewParent = this.uj.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.uj);
      }
    }
    AppMethodBeat.o(136667);
  }
  
  public final void ad(int paramInt)
  {
    this.ua = paramInt;
    this.uc = true;
  }
  
  public final void cRZ()
  {
    this.ug = true;
  }
  
  public final void cSa()
  {
    this.uf = false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(136665);
    this.ux.dismiss();
    eM();
    this.ux.setContentView(null);
    this.uKp = null;
    this.mHandler.removeCallbacks(this.uKq);
    AppMethodBeat.o(136665);
  }
  
  public final void eK()
  {
    AppMethodBeat.i(324657);
    this.uw = true;
    this.ux.setFocusable(false);
    AppMethodBeat.o(324657);
  }
  
  public final void eO()
  {
    AppMethodBeat.i(136668);
    a locala = this.uKp;
    if (locala != null)
    {
      a.a(locala, true);
      locala.requestLayout();
    }
    AppMethodBeat.o(136668);
  }
  
  public final boolean eP()
  {
    AppMethodBeat.i(136669);
    if (this.ux.getInputMethodMode() == 2)
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
    this.ux.setOnDismissListener(paramOnDismissListener);
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
    if (this.uKp == null)
    {
      localObject2 = this.mContext;
      this.uv = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136647);
          View localView = AutoFillListPopupWindowBase.this.ul;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            AutoFillListPopupWindowBase.this.show();
          }
          AppMethodBeat.o(136647);
        }
      };
      if (!this.uw)
      {
        bool1 = true;
        this.uKp = new a((Context)localObject2, bool1);
        if (this.um != null) {
          this.uKp.setSelector(this.um);
        }
        this.uKp.setAdapter(this.fR);
        this.uKp.setOnItemClickListener(this.un);
        this.uKp.setFocusable(true);
        this.uKp.setFocusableInTouchMode(true);
        this.uKp.setDivider(null);
        this.uKp.setDividerHeight(0);
        this.uKp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(136648);
            b localb = new b();
            localb.cH(paramAnonymousAdapterView);
            localb.cH(paramAnonymousView);
            localb.sc(paramAnonymousInt);
            localb.hB(paramAnonymousLong);
            a.c("com/tencent/mm/plugin/appbrand/widget/input/autofill/AutoFillListPopupWindowBase$2", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
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
        this.uKp.setOnScrollListener(this.uKs);
        if (this.uo != null) {
          this.uKp.setOnItemSelectedListener(this.uo);
        }
        localObject1 = this.uKp;
        localView = this.uj;
        if (localView == null) {
          break label1343;
        }
        eM();
        localObject2 = new FrameLayout((Context)localObject2);
        localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
        localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        switch (this.uk)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.uk);
          label278:
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.sh, -2147483648), 0);
          localObject1 = localObject2;
        }
      }
    }
    label309:
    label1338:
    label1343:
    for (;;)
    {
      this.ux.setContentView((View)localObject1);
      int i = 0;
      for (;;)
      {
        localObject1 = this.ux.getBackground();
        int k;
        label372:
        int i1;
        int m;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          k = j;
          if (!this.uc)
          {
            this.ua = (-this.mTempRect.top);
            k = j;
          }
          if (this.ux.getInputMethodMode() != 2) {
            break label757;
          }
          j = 1;
          localObject1 = this.ul;
          i1 = this.ua;
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
          if (this.ux.getBackground() != null)
          {
            this.ux.getBackground().getPadding(this.mTempRect);
            m = j - (this.mTempRect.top + this.mTempRect.bottom);
          }
          if ((this.uf) || (this.tY == -1))
          {
            i = m + k;
            bool1 = eP();
            if (!this.ux.isShowing()) {
              break label1041;
            }
            if (this.sh != -1) {
              break label910;
            }
            j = -1;
            if (this.tY != -1) {
              break label979;
            }
            if (!bool1) {
              break label938;
            }
            if (!bool1) {
              break label948;
            }
            localObject1 = this.ux;
            if (this.sh != -1) {
              break label943;
            }
            k = n;
            label580:
            ((PopupWindow)localObject1).setWindowLayoutMode(k, 0);
            label587:
            this.ux.update(j, i);
            localObject1 = this.ux;
            if ((this.ug) || (this.uf)) {
              break label996;
            }
          }
          label979:
          label996:
          for (bool1 = bool2;; bool1 = false)
          {
            ((PopupWindow)localObject1).setOutsideTouchable(bool1);
            if (!this.uKu) {
              break label1002;
            }
            this.ux.showAtLocation(this.ul, 17, 0, 0);
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
            this.ux.getContentView();
            localObject1 = this.uj;
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
            switch (this.sh)
            {
            default: 
              j = View.MeasureSpec.makeMeasureSpec(this.sh, 1073741824);
            }
            for (;;)
            {
              m = this.uKp.gd(j, m - i);
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
            if (this.sh == -2)
            {
              j = this.ul.getWidth();
              break label545;
            }
            j = this.sh;
            break label545;
            i = -1;
            break label558;
            k = 0;
            break label580;
            localObject1 = this.ux;
            if (this.sh == -1) {}
            for (k = -1;; k = 0)
            {
              ((PopupWindow)localObject1).setWindowLayoutMode(k, -1);
              break;
            }
            if (this.tY == -2) {
              break label587;
            }
            i = this.tY;
            break label587;
          }
          label1002:
          this.ux.update(this.ul, this.tZ, this.ua, this.ux.getWidth(), this.ux.getHeight());
          AppMethodBeat.o(136664);
          return;
          if (this.sh == -1)
          {
            j = -1;
            if (this.tY != -1) {
              break label1232;
            }
            i = -1;
            this.ux.setWindowLayoutMode(j, i);
            localObject1 = this.ux;
            if ((this.ug) || (this.uf)) {
              break label1270;
            }
            bool1 = bool3;
            label1094:
            ((PopupWindow)localObject1).setOutsideTouchable(bool1);
            this.ux.setTouchInterceptor(this.uKr);
            if (!this.uKu) {
              break label1276;
            }
            this.ux.showAtLocation(this.ul, 17, 0, 0);
          }
          for (;;)
          {
            this.uKp.setSelection(-1);
            if ((!this.uw) || (this.uKp.isInTouchMode())) {
              eO();
            }
            if (!this.uw) {
              this.mHandler.post(this.uKt);
            }
            AppMethodBeat.o(136664);
            return;
            if (this.sh == -2)
            {
              this.ux.setWidth(this.ul.getWidth());
              j = 0;
              break;
            }
            this.ux.setWidth(this.sh);
            j = 0;
            break;
            label1232:
            if (this.tY == -2)
            {
              this.ux.setHeight(i);
              i = 0;
              break label1061;
            }
            this.ux.setHeight(this.tY);
            i = 0;
            break label1061;
            label1270:
            bool1 = false;
            break label1094;
            label1276:
            if (Build.VERSION.SDK_INT >= 19) {
              this.ux.showAsDropDown(this.ul, this.tZ, this.ua, 53);
            } else {
              this.ux.showAtLocation(this.ul, 53, this.tZ, this.ua);
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
    private boolean tn;
    private boolean tp;
    
    public a(Context paramContext, boolean paramBoolean)
    {
      super(null, a.b.dropDownListViewStyle);
      AppMethodBeat.i(136649);
      this.tp = paramBoolean;
      setCacheColorHint(0);
      AppMethodBeat.o(136649);
    }
    
    final int gd(int paramInt1, int paramInt2)
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
      if ((this.tp) || (super.hasFocus()))
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
      if ((this.tp) || (super.hasWindowFocus()))
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
      if ((this.tp) || (super.isFocused()))
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
      if (((this.tp) && (this.tn)) || (super.isInTouchMode()))
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
      AutoFillListPopupWindowBase.this.eO();
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
      if (AutoFillListPopupWindowBase.this.ux.isShowing()) {
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
      if ((paramInt == 1) && (!AutoFillListPopupWindowBase.this.eP()) && (AutoFillListPopupWindowBase.b(AutoFillListPopupWindowBase.this).getContentView() != null))
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
      if ((AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this) != null) && (AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getCount() > AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getChildCount()) && (AutoFillListPopupWindowBase.a(AutoFillListPopupWindowBase.this).getChildCount() <= AutoFillListPopupWindowBase.this.uh))
      {
        AutoFillListPopupWindowBase.b(AutoFillListPopupWindowBase.this).setInputMethodMode(2);
        AutoFillListPopupWindowBase.this.show();
      }
      AppMethodBeat.o(136662);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase
 * JD-Core Version:    0.7.0.1
 */