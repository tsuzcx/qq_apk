package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
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
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.a.a;
import androidx.appcompat.a.j;
import androidx.appcompat.view.menu.s;
import androidx.core.g.z;
import androidx.core.widget.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class ListPopupWindow
  implements s
{
  private static Method tU;
  private static Method tV;
  private static Method tW;
  private ListAdapter fR;
  private Context mContext;
  public int mE;
  final Handler mHandler;
  private DataSetObserver mObserver;
  private final Rect mTempRect;
  public Rect om;
  private boolean rR;
  private int sh;
  public p tX;
  private int tY;
  public int tZ;
  private int ua;
  private int ub;
  private boolean uc;
  private boolean ud;
  private boolean ue;
  private boolean uf;
  private boolean ug;
  int uh;
  private View uj;
  private int uk;
  public View ul;
  private Drawable um;
  public AdapterView.OnItemClickListener un;
  private AdapterView.OnItemSelectedListener uo;
  final e uq;
  private final d ur;
  private final c ut;
  private final a uu;
  private Runnable uv;
  public boolean uw;
  public PopupWindow ux;
  
  static
  {
    AppMethodBeat.i(199734);
    try
    {
      tU = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
      try
      {
        label25:
        tV = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
        try
        {
          label56:
          tW = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
          AppMethodBeat.o(199734);
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException1)
        {
          AppMethodBeat.o(199734);
          return;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        break label56;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      break label25;
    }
  }
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, a.a.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199694);
    this.tY = -2;
    this.sh = -2;
    this.ub = 1002;
    this.ud = true;
    this.mE = 0;
    this.uf = false;
    this.ug = false;
    this.uh = 2147483647;
    this.uk = 0;
    this.uq = new e();
    this.ur = new d();
    this.ut = new c();
    this.uu = new a();
    this.mTempRect = new Rect();
    this.mContext = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ListPopupWindow, paramInt1, paramInt2);
    this.tZ = localTypedArray.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    this.ua = localTypedArray.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (this.ua != 0) {
      this.uc = true;
    }
    localTypedArray.recycle();
    this.ux = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.ux.setInputMethodMode(1);
    AppMethodBeat.o(199694);
  }
  
  private int a(View paramView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(199723);
    if (tV != null) {
      try
      {
        int i = ((Integer)tV.invoke(this.ux, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
        AppMethodBeat.o(199723);
        return i;
      }
      catch (Exception localException) {}
    }
    paramInt = this.ux.getMaxAvailableHeight(paramView, paramInt);
    AppMethodBeat.o(199723);
    return paramInt;
  }
  
  private void eM()
  {
    AppMethodBeat.i(199709);
    if (this.uj != null)
    {
      ViewParent localViewParent = this.uj.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.uj);
      }
    }
    AppMethodBeat.o(199709);
  }
  
  public final void ad(int paramInt)
  {
    this.ua = paramInt;
    this.uc = true;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(199906);
    this.ux.dismiss();
    eM();
    this.ux.setContentView(null);
    this.tX = null;
    this.mHandler.removeCallbacks(this.uq);
    AppMethodBeat.o(199906);
  }
  
  public final void eJ()
  {
    this.uk = 0;
  }
  
  public final void eK()
  {
    AppMethodBeat.i(199770);
    this.uw = true;
    this.ux.setFocusable(true);
    AppMethodBeat.o(199770);
  }
  
  public final int eL()
  {
    if (!this.uc) {
      return 0;
    }
    return this.ua;
  }
  
  public final void eN()
  {
    AppMethodBeat.i(199929);
    this.ux.setInputMethodMode(2);
    AppMethodBeat.o(199929);
  }
  
  public final void eO()
  {
    AppMethodBeat.i(199941);
    p localp = this.tX;
    if (localp != null)
    {
      localp.setListSelectionHidden(true);
      localp.requestLayout();
    }
    AppMethodBeat.o(199941);
  }
  
  public final boolean eP()
  {
    AppMethodBeat.i(199966);
    if (this.ux.getInputMethodMode() == 2)
    {
      AppMethodBeat.o(199966);
      return true;
    }
    AppMethodBeat.o(199966);
    return false;
  }
  
  public final void eQ()
  {
    this.ue = true;
    this.rR = true;
  }
  
  public final ListView getListView()
  {
    return this.tX;
  }
  
  public final int getWidth()
  {
    return this.sh;
  }
  
  p h(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(199992);
    paramContext = new p(paramContext, paramBoolean);
    AppMethodBeat.o(199992);
    return paramContext;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(369509);
    boolean bool = this.ux.isShowing();
    AppMethodBeat.o(369509);
    return bool;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(199745);
    if (this.mObserver == null) {
      this.mObserver = new b();
    }
    for (;;)
    {
      this.fR = paramListAdapter;
      if (paramListAdapter != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.tX != null) {
        this.tX.setAdapter(this.fR);
      }
      AppMethodBeat.o(199745);
      return;
      if (this.fR != null) {
        this.fR.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(199782);
    this.ux.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(199782);
  }
  
  public final void setContentWidth(int paramInt)
  {
    AppMethodBeat.i(199838);
    Drawable localDrawable = this.ux.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.sh = (this.mTempRect.left + this.mTempRect.right + paramInt);
      AppMethodBeat.o(199838);
      return;
    }
    this.sh = paramInt;
    AppMethodBeat.o(199838);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(199920);
    this.ux.setOnDismissListener(paramOnDismissListener);
    AppMethodBeat.o(199920);
  }
  
  public void show()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(199894);
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    label250:
    int i;
    int j;
    if (this.tX == null)
    {
      localObject2 = this.mContext;
      this.uv = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199385);
          View localView = ListPopupWindow.this.ul;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            ListPopupWindow.this.show();
          }
          AppMethodBeat.o(199385);
        }
      };
      if (!this.uw)
      {
        bool1 = true;
        this.tX = h((Context)localObject2, bool1);
        if (this.um != null) {
          this.tX.setSelector(this.um);
        }
        this.tX.setAdapter(this.fR);
        this.tX.setOnItemClickListener(this.un);
        this.tX.setFocusable(true);
        this.tX.setFocusableInTouchMode(true);
        this.tX.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(199410);
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = ListPopupWindow.this.tX;
              if (paramAnonymousAdapterView != null) {
                paramAnonymousAdapterView.setListSelectionHidden(false);
              }
            }
            AppMethodBeat.o(199410);
          }
          
          public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.tX.setOnScrollListener(this.ut);
        if (this.uo != null) {
          this.tX.setOnItemSelectedListener(this.uo);
        }
        localObject1 = this.tX;
        localView = this.uj;
        if (localView == null) {
          break label1306;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.uk)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.uk);
          if (this.sh >= 0)
          {
            i = -2147483648;
            j = this.sh;
            label266:
            localView.measure(View.MeasureSpec.makeMeasureSpec(j, i), 0);
            localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
            i = localView.getMeasuredHeight() + ((LinearLayout.LayoutParams)localObject1).topMargin + ((LinearLayout.LayoutParams)localObject1).bottomMargin;
            localObject1 = localObject2;
          }
          break;
        }
      }
    }
    for (;;)
    {
      this.ux.setContentView((View)localObject1);
      for (;;)
      {
        label318:
        localObject1 = this.ux.getBackground();
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          if (this.uc) {
            break label1298;
          }
          this.ua = (-this.mTempRect.top);
        }
        label780:
        label1295:
        label1298:
        for (;;)
        {
          label377:
          if (this.ux.getInputMethodMode() == 2) {}
          int m;
          for (bool1 = true;; bool1 = false)
          {
            m = a(this.ul, this.ua, bool1);
            if ((!this.uf) && (this.tY != -1)) {
              break label590;
            }
            i = m + j;
            bool1 = eP();
            h.a(this.ux, this.ub);
            if (!this.ux.isShowing()) {
              break label1005;
            }
            if (z.ay(this.ul)) {
              break label757;
            }
            AppMethodBeat.o(199894);
            return;
            bool1 = false;
            break;
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            ((LinearLayout)localObject2).addView(localView);
            break label250;
            ((LinearLayout)localObject2).addView(localView);
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            break label250;
            i = 0;
            j = 0;
            break label266;
            this.ux.getContentView();
            localObject1 = this.uj;
            if (localObject1 == null) {
              break label1301;
            }
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            i = ((View)localObject1).getMeasuredHeight() + ((LinearLayout.LayoutParams)localObject2).topMargin + ((LinearLayout.LayoutParams)localObject2).bottomMargin;
            break label318;
            this.mTempRect.setEmpty();
            j = 0;
            break label377;
          }
          label590:
          int k;
          switch (this.sh)
          {
          default: 
            k = View.MeasureSpec.makeMeasureSpec(this.sh, 1073741824);
          }
          for (;;)
          {
            m = this.tX.d(k, 0, -1, m - i, -1);
            k = i;
            if (m > 0) {
              k = i + (this.tX.getPaddingTop() + this.tX.getPaddingBottom() + j);
            }
            i = m + k;
            break;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), -2147483648);
            continue;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
          }
          label757:
          if (this.sh == -1)
          {
            j = -1;
            if (this.tY != -1) {
              break label982;
            }
            if (!bool1) {
              break label934;
            }
            if (!bool1) {
              break label944;
            }
            localObject1 = this.ux;
            if (this.sh != -1) {
              break label939;
            }
            k = -1;
            ((PopupWindow)localObject1).setWidth(k);
            this.ux.setHeight(0);
          }
          for (;;)
          {
            label801:
            label815:
            localObject1 = this.ux;
            if ((!this.ug) && (!this.uf)) {}
            for (bool1 = bool2;; bool1 = false)
            {
              ((PopupWindow)localObject1).setOutsideTouchable(bool1);
              localObject1 = this.ux;
              localObject2 = this.ul;
              m = this.tZ;
              int n = this.ua;
              k = j;
              if (j < 0) {
                k = -1;
              }
              j = i;
              if (i < 0) {
                j = -1;
              }
              ((PopupWindow)localObject1).update((View)localObject2, m, n, k, j);
              AppMethodBeat.o(199894);
              return;
              if (this.sh == -2)
              {
                j = this.ul.getWidth();
                break;
              }
              j = this.sh;
              break;
              label934:
              i = -1;
              break label780;
              label939:
              k = 0;
              break label801;
              label944:
              localObject1 = this.ux;
              if (this.sh == -1) {}
              for (k = -1;; k = 0)
              {
                ((PopupWindow)localObject1).setWidth(k);
                this.ux.setHeight(-1);
                break;
              }
              label982:
              if (this.tY == -2) {
                break label1295;
              }
              i = this.tY;
              break label815;
            }
            label1005:
            if (this.sh == -1) {
              j = -1;
            }
            for (;;)
            {
              if (this.tY == -1)
              {
                i = -1;
                this.ux.setWidth(j);
                this.ux.setHeight(i);
                if (tU == null) {}
              }
              try
              {
                tU.invoke(this.ux, new Object[] { Boolean.TRUE });
                label1068:
                localObject1 = this.ux;
                if ((!this.ug) && (!this.uf))
                {
                  bool1 = bool3;
                  ((PopupWindow)localObject1).setOutsideTouchable(bool1);
                  this.ux.setTouchInterceptor(this.ur);
                  if (this.ue) {
                    h.a(this.ux, this.rR);
                  }
                  if (tW == null) {}
                }
                try
                {
                  tW.invoke(this.ux, new Object[] { this.om });
                  h.a(this.ux, this.ul, this.tZ, this.ua, this.mE);
                  this.tX.setSelection(-1);
                  if ((!this.uw) || (this.tX.isInTouchMode())) {
                    eO();
                  }
                  if (!this.uw) {
                    this.mHandler.post(this.uu);
                  }
                  AppMethodBeat.o(199894);
                  return;
                  if (this.sh == -2)
                  {
                    j = this.ul.getWidth();
                  }
                  else
                  {
                    j = this.sh;
                    continue;
                    if (this.tY == -2) {
                      break label1025;
                    }
                    i = this.tY;
                    break label1025;
                    bool1 = false;
                  }
                }
                catch (Exception localException1)
                {
                  break label1156;
                }
              }
              catch (Exception localException2)
              {
                break label1068;
              }
            }
          }
        }
        label1025:
        label1156:
        label1301:
        i = 0;
      }
      label1306:
      i = 0;
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(200262);
      ListPopupWindow.this.eO();
      AppMethodBeat.o(200262);
    }
  }
  
  final class b
    extends DataSetObserver
  {
    b() {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(200258);
      if (ListPopupWindow.this.ux.isShowing()) {
        ListPopupWindow.this.show();
      }
      AppMethodBeat.o(200258);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(200263);
      ListPopupWindow.this.dismiss();
      AppMethodBeat.o(200263);
    }
  }
  
  final class c
    implements AbsListView.OnScrollListener
  {
    c() {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(200267);
      if ((paramInt == 1) && (!ListPopupWindow.this.eP()) && (ListPopupWindow.this.ux.getContentView() != null))
      {
        ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.uq);
        ListPopupWindow.this.uq.run();
      }
      AppMethodBeat.o(200267);
    }
  }
  
  final class d
    implements View.OnTouchListener
  {
    d() {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200251);
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (ListPopupWindow.this.ux != null) && (ListPopupWindow.this.ux.isShowing()) && (j >= 0) && (j < ListPopupWindow.this.ux.getWidth()) && (k >= 0) && (k < ListPopupWindow.this.ux.getHeight())) {
        ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.uq, 250L);
      }
      for (;;)
      {
        AppMethodBeat.o(200251);
        return false;
        if (i == 1) {
          ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.uq);
        }
      }
    }
  }
  
  final class e
    implements Runnable
  {
    e() {}
    
    public final void run()
    {
      AppMethodBeat.i(200244);
      if ((ListPopupWindow.this.tX != null) && (z.ay(ListPopupWindow.this.tX)) && (ListPopupWindow.this.tX.getCount() > ListPopupWindow.this.tX.getChildCount()) && (ListPopupWindow.this.tX.getChildCount() <= ListPopupWindow.this.uh))
      {
        ListPopupWindow.this.ux.setInputMethodMode(2);
        ListPopupWindow.this.show();
      }
      AppMethodBeat.o(200244);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.ListPopupWindow
 * JD-Core Version:    0.7.0.1
 */