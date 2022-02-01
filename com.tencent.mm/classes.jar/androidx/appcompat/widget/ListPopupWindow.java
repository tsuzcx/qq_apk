package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
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
import androidx.core.g.e;
import androidx.core.g.w;
import androidx.core.widget.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class ListPopupWindow
  implements s
{
  private static Method sV;
  private static Method sW;
  private static Method sX;
  private ListAdapter eP;
  public int lI;
  private Context mContext;
  final Handler mHandler;
  private DataSetObserver mObserver;
  private final Rect mTempRect;
  public Rect nq;
  private boolean qU;
  public int rj;
  public p sY;
  private int sZ;
  public int ta;
  private int tb;
  private int tc;
  private boolean td;
  private boolean te;
  private boolean tf;
  private boolean tg;
  private boolean th;
  int ti;
  private View tj;
  private int tk;
  public View tl;
  private Drawable tn;
  public AdapterView.OnItemClickListener tp;
  private AdapterView.OnItemSelectedListener tq;
  final e tr;
  private final d tt;
  private final c tu;
  private final a tv;
  private Runnable tw;
  public boolean tx;
  public PopupWindow ty;
  
  static
  {
    AppMethodBeat.i(241427);
    try
    {
      sV = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
      try
      {
        label25:
        sW = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
        try
        {
          label56:
          sX = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
          AppMethodBeat.o(241427);
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException1)
        {
          AppMethodBeat.o(241427);
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
    AppMethodBeat.i(241408);
    this.sZ = -2;
    this.rj = -2;
    this.tc = 1002;
    this.te = true;
    this.lI = 0;
    this.tg = false;
    this.th = false;
    this.ti = 2147483647;
    this.tk = 0;
    this.tr = new e();
    this.tt = new d();
    this.tu = new c();
    this.tv = new a();
    this.mTempRect = new Rect();
    this.mContext = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ListPopupWindow, paramInt1, paramInt2);
    this.ta = localTypedArray.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    this.tb = localTypedArray.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (this.tb != 0) {
      this.td = true;
    }
    localTypedArray.recycle();
    this.ty = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.ty.setInputMethodMode(1);
    AppMethodBeat.o(241408);
  }
  
  private int a(View paramView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(241426);
    if (sW != null) {
      try
      {
        int i = ((Integer)sW.invoke(this.ty, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
        AppMethodBeat.o(241426);
        return i;
      }
      catch (Exception localException) {}
    }
    paramInt = this.ty.getMaxAvailableHeight(paramView, paramInt);
    AppMethodBeat.o(241426);
    return paramInt;
  }
  
  private void dM()
  {
    AppMethodBeat.i(241420);
    if (this.tj != null)
    {
      ViewParent localViewParent = this.tj.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.tj);
      }
    }
    AppMethodBeat.o(241420);
  }
  
  public final void P(boolean paramBoolean)
  {
    AppMethodBeat.i(241412);
    this.tx = paramBoolean;
    this.ty.setFocusable(paramBoolean);
    AppMethodBeat.o(241412);
  }
  
  public final void ah(int paramInt)
  {
    this.tb = paramInt;
    this.td = true;
  }
  
  public final void ax(int paramInt)
  {
    AppMethodBeat.i(241414);
    this.ty.setAnimationStyle(paramInt);
    AppMethodBeat.o(241414);
  }
  
  public final void dK()
  {
    this.tk = 0;
  }
  
  public final int dL()
  {
    if (!this.td) {
      return 0;
    }
    return this.tb;
  }
  
  public final void dN()
  {
    AppMethodBeat.i(241421);
    this.ty.setInputMethodMode(2);
    AppMethodBeat.o(241421);
  }
  
  public final void dO()
  {
    AppMethodBeat.i(241422);
    p localp = this.sY;
    if (localp != null)
    {
      localp.setListSelectionHidden(true);
      localp.requestLayout();
    }
    AppMethodBeat.o(241422);
  }
  
  public final boolean dP()
  {
    AppMethodBeat.i(241424);
    if (this.ty.getInputMethodMode() == 2)
    {
      AppMethodBeat.o(241424);
      return true;
    }
    AppMethodBeat.o(241424);
    return false;
  }
  
  public final void dQ()
  {
    this.tf = true;
    this.qU = true;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(241418);
    this.ty.dismiss();
    dM();
    this.ty.setContentView(null);
    this.sY = null;
    this.mHandler.removeCallbacks(this.tr);
    AppMethodBeat.o(241418);
  }
  
  public final ListView getListView()
  {
    return this.sY;
  }
  
  p h(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(241425);
    paramContext = new p(paramContext, paramBoolean);
    AppMethodBeat.o(241425);
    return paramContext;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(292988);
    boolean bool = this.ty.isShowing();
    AppMethodBeat.o(292988);
    return bool;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(241410);
    if (this.mObserver == null) {
      this.mObserver = new b();
    }
    for (;;)
    {
      this.eP = paramListAdapter;
      if (paramListAdapter != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.sY != null) {
        this.sY.setAdapter(this.eP);
      }
      AppMethodBeat.o(241410);
      return;
      if (this.eP != null) {
        this.eP.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(241413);
    this.ty.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(241413);
  }
  
  public final void setContentWidth(int paramInt)
  {
    AppMethodBeat.i(241415);
    Drawable localDrawable = this.ty.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.rj = (this.mTempRect.left + this.mTempRect.right + paramInt);
      AppMethodBeat.o(241415);
      return;
    }
    this.rj = paramInt;
    AppMethodBeat.o(241415);
  }
  
  public final void setHeight(int paramInt)
  {
    AppMethodBeat.i(241416);
    if ((paramInt < 0) && (-2 != paramInt) && (-1 != paramInt))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
      AppMethodBeat.o(241416);
      throw localIllegalArgumentException;
    }
    this.sZ = paramInt;
    AppMethodBeat.o(241416);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(241419);
    this.ty.setOnDismissListener(paramOnDismissListener);
    AppMethodBeat.o(241419);
  }
  
  public void show()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(241417);
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    label250:
    int i;
    int j;
    if (this.sY == null)
    {
      localObject2 = this.mContext;
      this.tw = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(241370);
          View localView = ListPopupWindow.this.tl;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            ListPopupWindow.this.show();
          }
          AppMethodBeat.o(241370);
        }
      };
      if (!this.tx)
      {
        bool1 = true;
        this.sY = h((Context)localObject2, bool1);
        if (this.tn != null) {
          this.sY.setSelector(this.tn);
        }
        this.sY.setAdapter(this.eP);
        this.sY.setOnItemClickListener(this.tp);
        this.sY.setFocusable(true);
        this.sY.setFocusableInTouchMode(true);
        this.sY.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(241372);
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = ListPopupWindow.this.sY;
              if (paramAnonymousAdapterView != null) {
                paramAnonymousAdapterView.setListSelectionHidden(false);
              }
            }
            AppMethodBeat.o(241372);
          }
          
          public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.sY.setOnScrollListener(this.tu);
        if (this.tq != null) {
          this.sY.setOnItemSelectedListener(this.tq);
        }
        localObject1 = this.sY;
        localView = this.tj;
        if (localView == null) {
          break label1375;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.tk)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.tk);
          if (this.rj >= 0)
          {
            i = -2147483648;
            j = this.rj;
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
      this.ty.setContentView((View)localObject1);
      label780:
      label801:
      label934:
      label939:
      label1068:
      for (;;)
      {
        label318:
        localObject1 = this.ty.getBackground();
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          if (this.td) {
            break label1367;
          }
          this.tb = (-this.mTempRect.top);
        }
        label590:
        label982:
        label1367:
        for (;;)
        {
          label377:
          if (this.ty.getInputMethodMode() == 2) {}
          int m;
          for (bool1 = true;; bool1 = false)
          {
            m = a(this.tl, this.tb, bool1);
            if ((!this.tg) && (this.sZ != -1)) {
              break label590;
            }
            i = m + j;
            bool1 = dP();
            g.a(this.ty, this.tc);
            if (!this.ty.isShowing()) {
              break label1005;
            }
            if (w.al(this.tl)) {
              break label757;
            }
            AppMethodBeat.o(241417);
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
            this.ty.getContentView();
            localObject1 = this.tj;
            if (localObject1 == null) {
              break label1370;
            }
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            i = ((View)localObject1).getMeasuredHeight() + ((LinearLayout.LayoutParams)localObject2).topMargin + ((LinearLayout.LayoutParams)localObject2).bottomMargin;
            break label318;
            this.mTempRect.setEmpty();
            j = 0;
            break label377;
          }
          int k;
          switch (this.rj)
          {
          default: 
            k = View.MeasureSpec.makeMeasureSpec(this.rj, 1073741824);
          }
          for (;;)
          {
            m = this.sY.d(k, 0, -1, m - i, -1);
            k = i;
            if (m > 0) {
              k = i + (this.sY.getPaddingTop() + this.sY.getPaddingBottom() + j);
            }
            i = m + k;
            break;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), -2147483648);
            continue;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
          }
          label757:
          if (this.rj == -1)
          {
            j = -1;
            if (this.sZ != -1) {
              break label982;
            }
            if (!bool1) {
              break label934;
            }
            if (!bool1) {
              break label944;
            }
            localObject1 = this.ty;
            if (this.rj != -1) {
              break label939;
            }
            k = -1;
            ((PopupWindow)localObject1).setWidth(k);
            this.ty.setHeight(0);
          }
          for (;;)
          {
            localObject1 = this.ty;
            if ((!this.th) && (!this.tg)) {}
            for (bool1 = bool2;; bool1 = false)
            {
              ((PopupWindow)localObject1).setOutsideTouchable(bool1);
              localObject1 = this.ty;
              localObject2 = this.tl;
              m = this.ta;
              int n = this.tb;
              k = j;
              if (j < 0) {
                k = -1;
              }
              j = i;
              if (i < 0) {
                j = -1;
              }
              ((PopupWindow)localObject1).update((View)localObject2, m, n, k, j);
              AppMethodBeat.o(241417);
              return;
              if (this.rj == -2)
              {
                j = this.tl.getWidth();
                break;
              }
              j = this.rj;
              break;
              i = -1;
              break label780;
              k = 0;
              break label801;
              localObject1 = this.ty;
              if (this.rj == -1) {}
              for (k = -1;; k = 0)
              {
                ((PopupWindow)localObject1).setWidth(k);
                this.ty.setHeight(-1);
                break;
              }
              if (this.sZ == -2) {
                break label1364;
              }
              i = this.sZ;
              break label815;
            }
            label1005:
            if (this.rj == -1) {
              j = -1;
            }
            for (;;)
            {
              if (this.sZ == -1)
              {
                i = -1;
                this.ty.setWidth(j);
                this.ty.setHeight(i);
                if (sV == null) {}
              }
              try
              {
                sV.invoke(this.ty, new Object[] { Boolean.TRUE });
                localObject1 = this.ty;
                if ((!this.th) && (!this.tg))
                {
                  bool1 = bool3;
                  ((PopupWindow)localObject1).setOutsideTouchable(bool1);
                  this.ty.setTouchInterceptor(this.tt);
                  if (this.tf) {
                    g.a(this.ty, this.qU);
                  }
                  if (sX == null) {}
                }
                try
                {
                  sX.invoke(this.ty, new Object[] { this.nq });
                  localObject1 = this.ty;
                  localObject2 = this.tl;
                  j = this.ta;
                  k = this.tb;
                  m = this.lI;
                  if (Build.VERSION.SDK_INT >= 19) {
                    ((PopupWindow)localObject1).showAsDropDown((View)localObject2, j, k, m);
                  }
                  for (;;)
                  {
                    this.sY.setSelection(-1);
                    if ((!this.tx) || (this.sY.isInTouchMode())) {
                      dO();
                    }
                    if (!this.tx) {
                      this.mHandler.post(this.tv);
                    }
                    AppMethodBeat.o(241417);
                    return;
                    if (this.rj == -2)
                    {
                      j = this.tl.getWidth();
                      break;
                    }
                    j = this.rj;
                    break;
                    if (this.sZ == -2) {
                      break label1025;
                    }
                    i = this.sZ;
                    break label1025;
                    bool1 = false;
                    break label1092;
                    i = j;
                    if ((e.D(m, w.I((View)localObject2)) & 0x7) == 5) {
                      i = j - (((PopupWindow)localObject1).getWidth() - ((View)localObject2).getWidth());
                    }
                    ((PopupWindow)localObject1).showAsDropDown((View)localObject2, i, k);
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
        label815:
        label944:
        label1092:
        label1364:
        label1370:
        i = 0;
      }
      label1025:
      label1156:
      label1375:
      i = 0;
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(241373);
      ListPopupWindow.this.dO();
      AppMethodBeat.o(241373);
    }
  }
  
  final class b
    extends DataSetObserver
  {
    b() {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(241376);
      if (ListPopupWindow.this.ty.isShowing()) {
        ListPopupWindow.this.show();
      }
      AppMethodBeat.o(241376);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(241378);
      ListPopupWindow.this.dismiss();
      AppMethodBeat.o(241378);
    }
  }
  
  final class c
    implements AbsListView.OnScrollListener
  {
    c() {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(241385);
      if ((paramInt == 1) && (!ListPopupWindow.this.dP()) && (ListPopupWindow.this.ty.getContentView() != null))
      {
        ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.tr);
        ListPopupWindow.this.tr.run();
      }
      AppMethodBeat.o(241385);
    }
  }
  
  final class d
    implements View.OnTouchListener
  {
    d() {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(241389);
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (ListPopupWindow.this.ty != null) && (ListPopupWindow.this.ty.isShowing()) && (j >= 0) && (j < ListPopupWindow.this.ty.getWidth()) && (k >= 0) && (k < ListPopupWindow.this.ty.getHeight())) {
        ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.tr, 250L);
      }
      for (;;)
      {
        AppMethodBeat.o(241389);
        return false;
        if (i == 1) {
          ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.tr);
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
      AppMethodBeat.i(241392);
      if ((ListPopupWindow.this.sY != null) && (w.al(ListPopupWindow.this.sY)) && (ListPopupWindow.this.sY.getCount() > ListPopupWindow.this.sY.getChildCount()) && (ListPopupWindow.this.sY.getChildCount() <= ListPopupWindow.this.ti))
      {
        ListPopupWindow.this.ty.setInputMethodMode(2);
        ListPopupWindow.this.show();
      }
      AppMethodBeat.o(241392);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.ListPopupWindow
 * JD-Core Version:    0.7.0.1
 */