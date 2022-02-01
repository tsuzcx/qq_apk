package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.d;
import android.support.v4.view.t;
import android.support.v4.widget.n;
import android.support.v7.a.a.a;
import android.support.v7.view.menu.s;
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
import java.lang.reflect.Method;

public class ListPopupWindow
  implements s
{
  private static Method aoa;
  private static Method aob;
  private static Method aoc;
  private ListAdapter DP;
  public int acB = 0;
  public Rect aef;
  private boolean ahM;
  public int aib = -2;
  public PopupWindow aoA;
  public y aod;
  private int aoe = -2;
  public int aof;
  private int aog;
  private int aoh = 1002;
  private boolean aoi;
  private boolean aoj = true;
  private boolean aok;
  private boolean aol = false;
  private boolean aom = false;
  int aon = 2147483647;
  private View aoo;
  int aop = 0;
  public View aoq;
  private Drawable aor;
  public AdapterView.OnItemClickListener aos;
  private AdapterView.OnItemSelectedListener aot;
  final e aou = new e();
  private final d aov = new d();
  private final c aow = new c();
  private final a aox = new a();
  private Runnable aoy;
  public boolean aoz;
  private Context mContext;
  final Handler mHandler;
  private DataSetObserver mObserver;
  private final Rect mTempRect = new Rect();
  
  static
  {
    try
    {
      aoa = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
      try
      {
        label20:
        aob = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
        try
        {
          label51:
          aoc = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException1) {}
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        break label51;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      break label20;
    }
  }
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, 2130969239);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969239);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ListPopupWindow, paramInt1, paramInt2);
    this.aof = localTypedArray.getDimensionPixelOffset(0, 0);
    this.aog = localTypedArray.getDimensionPixelOffset(1, 0);
    if (this.aog != 0) {
      this.aoi = true;
    }
    localTypedArray.recycle();
    this.aoA = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.aoA.setInputMethodMode(1);
  }
  
  private int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    if (aob != null) {
      try
      {
        int i = ((Integer)aob.invoke(this.aoA, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
        return i;
      }
      catch (Exception localException) {}
    }
    return this.aoA.getMaxAvailableHeight(paramView, paramInt);
  }
  
  private void jX()
  {
    if (this.aoo != null)
    {
      ViewParent localViewParent = this.aoo.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.aoo);
      }
    }
  }
  
  public final void clearListSelection()
  {
    y localy = this.aod;
    if (localy != null)
    {
      localy.setListSelectionHidden(true);
      localy.requestLayout();
    }
  }
  
  public final void dismiss()
  {
    this.aoA.dismiss();
    jX();
    this.aoA.setContentView(null);
    this.aod = null;
    this.mHandler.removeCallbacks(this.aou);
  }
  
  public final ListView getListView()
  {
    return this.aod;
  }
  
  public final int getVerticalOffset()
  {
    if (!this.aoi) {
      return 0;
    }
    return this.aog;
  }
  
  y i(Context paramContext, boolean paramBoolean)
  {
    return new y(paramContext, paramBoolean);
  }
  
  public final boolean isInputMethodNotNeeded()
  {
    return this.aoA.getInputMethodMode() == 2;
  }
  
  public final boolean isShowing()
  {
    return this.aoA.isShowing();
  }
  
  public final void jY()
  {
    this.aoA.setInputMethodMode(2);
  }
  
  public final void jZ()
  {
    this.aok = true;
    this.ahM = true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.mObserver == null) {
      this.mObserver = new b();
    }
    for (;;)
    {
      this.DP = paramListAdapter;
      if (paramListAdapter != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.aod != null) {
        this.aod.setAdapter(this.DP);
      }
      return;
      if (this.DP != null) {
        this.DP.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public final void setAnimationStyle(int paramInt)
  {
    this.aoA.setAnimationStyle(paramInt);
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.aoA.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setContentWidth(int paramInt)
  {
    Drawable localDrawable = this.aoA.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.aib = (this.mTempRect.left + this.mTempRect.right + paramInt);
      return;
    }
    this.aib = paramInt;
  }
  
  public final void setHeight(int paramInt)
  {
    if ((paramInt < 0) && (-2 != paramInt) && (-1 != paramInt)) {
      throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }
    this.aoe = paramInt;
  }
  
  public final void setModal(boolean paramBoolean)
  {
    this.aoz = paramBoolean;
    this.aoA.setFocusable(paramBoolean);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.aoA.setOnDismissListener(paramOnDismissListener);
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
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    label242:
    int j;
    int i;
    if (this.aod == null)
    {
      localObject2 = this.mContext;
      this.aoy = new Runnable()
      {
        public final void run()
        {
          View localView = ListPopupWindow.this.aoq;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            ListPopupWindow.this.show();
          }
        }
      };
      if (!this.aoz)
      {
        bool1 = true;
        this.aod = i((Context)localObject2, bool1);
        if (this.aor != null) {
          this.aod.setSelector(this.aor);
        }
        this.aod.setAdapter(this.DP);
        this.aod.setOnItemClickListener(this.aos);
        this.aod.setFocusable(true);
        this.aod.setFocusableInTouchMode(true);
        this.aod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = ListPopupWindow.this.aod;
              if (paramAnonymousAdapterView != null) {
                paramAnonymousAdapterView.setListSelectionHidden(false);
              }
            }
          }
          
          public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.aod.setOnScrollListener(this.aow);
        if (this.aot != null) {
          this.aod.setOnItemSelectedListener(this.aot);
        }
        localObject1 = this.aod;
        localView = this.aoo;
        if (localView == null) {
          break label1351;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.aop)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.aop);
          if (this.aib >= 0)
          {
            j = this.aib;
            i = -2147483648;
            label258:
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
      this.aoA.setContentView((View)localObject1);
      label768:
      label789:
      label921:
      label1050:
      for (;;)
      {
        label310:
        localObject1 = this.aoA.getBackground();
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          if (this.aoi) {
            break label1343;
          }
          this.aog = (-this.mTempRect.top);
        }
        label803:
        label1074:
        label1340:
        label1343:
        for (;;)
        {
          label369:
          if (this.aoA.getInputMethodMode() == 2) {}
          int m;
          for (bool1 = true;; bool1 = false)
          {
            m = getMaxAvailableHeight(this.aoq, this.aog, bool1);
            if ((!this.aol) && (this.aoe != -1)) {
              break label576;
            }
            i = m + j;
            bool1 = isInputMethodNotNeeded();
            n.a(this.aoA, this.aoh);
            if (!this.aoA.isShowing()) {
              break label987;
            }
            if (t.aC(this.aoq)) {
              break label745;
            }
            return;
            bool1 = false;
            break;
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            ((LinearLayout)localObject2).addView(localView);
            break label242;
            ((LinearLayout)localObject2).addView(localView);
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            break label242;
            i = 0;
            j = 0;
            break label258;
            this.aoA.getContentView();
            localObject1 = this.aoo;
            if (localObject1 == null) {
              break label1346;
            }
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            i = ((View)localObject1).getMeasuredHeight() + ((LinearLayout.LayoutParams)localObject2).topMargin + ((LinearLayout.LayoutParams)localObject2).bottomMargin;
            break label310;
            this.mTempRect.setEmpty();
            j = 0;
            break label369;
          }
          label576:
          int k;
          switch (this.aib)
          {
          default: 
            k = View.MeasureSpec.makeMeasureSpec(this.aib, 1073741824);
          }
          for (;;)
          {
            m = this.aod.d(k, 0, -1, m - i, -1);
            k = i;
            if (m > 0) {
              k = i + (this.aod.getPaddingTop() + this.aod.getPaddingBottom() + j);
            }
            i = m + k;
            break;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), -2147483648);
            continue;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
          }
          label745:
          if (this.aib == -1)
          {
            j = -1;
            if (this.aoe != -1) {
              break label964;
            }
            if (!bool1) {
              break label916;
            }
            if (!bool1) {
              break label926;
            }
            localObject1 = this.aoA;
            if (this.aib != -1) {
              break label921;
            }
            k = -1;
            ((PopupWindow)localObject1).setWidth(k);
            this.aoA.setHeight(0);
          }
          for (;;)
          {
            for (;;)
            {
              localObject1 = this.aoA;
              if ((!this.aom) && (!this.aol)) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((PopupWindow)localObject1).setOutsideTouchable(bool1);
                localObject1 = this.aoA;
                localObject2 = this.aoq;
                m = this.aof;
                int n = this.aog;
                k = j;
                if (j < 0) {
                  k = -1;
                }
                j = i;
                if (i < 0) {
                  j = -1;
                }
                ((PopupWindow)localObject1).update((View)localObject2, m, n, k, j);
                return;
                if (this.aib == -2)
                {
                  j = this.aoq.getWidth();
                  break;
                }
                j = this.aib;
                break;
                i = -1;
                break label768;
                k = 0;
                break label789;
                localObject1 = this.aoA;
                if (this.aib == -1) {}
                for (k = -1;; k = 0)
                {
                  ((PopupWindow)localObject1).setWidth(k);
                  this.aoA.setHeight(-1);
                  break;
                }
                label964:
                if (this.aoe == -2) {
                  break label1340;
                }
                i = this.aoe;
                break label803;
              }
              label987:
              if (this.aib == -1)
              {
                j = -1;
                label997:
                if (this.aoe != -1) {
                  break label1262;
                }
                i = -1;
                label1007:
                this.aoA.setWidth(j);
                this.aoA.setHeight(i);
                if (aoa == null) {}
              }
              try
              {
                for (;;)
                {
                  aoa.invoke(this.aoA, new Object[] { Boolean.TRUE });
                  localObject1 = this.aoA;
                  if ((!this.aom) && (!this.aol))
                  {
                    bool1 = bool3;
                    ((PopupWindow)localObject1).setOutsideTouchable(bool1);
                    this.aoA.setTouchInterceptor(this.aov);
                    if (this.aok) {
                      n.a(this.aoA, this.ahM);
                    }
                    if (aoc == null) {}
                  }
                  try
                  {
                    aoc.invoke(this.aoA, new Object[] { this.aef });
                    label1138:
                    localObject1 = this.aoA;
                    localObject2 = this.aoq;
                    j = this.aof;
                    k = this.aog;
                    m = this.acB;
                    if (Build.VERSION.SDK_INT >= 19) {
                      ((PopupWindow)localObject1).showAsDropDown((View)localObject2, j, k, m);
                    }
                    for (;;)
                    {
                      this.aod.setSelection(-1);
                      if ((!this.aoz) || (this.aod.isInTouchMode())) {
                        clearListSelection();
                      }
                      if (this.aoz) {
                        break;
                      }
                      this.mHandler.post(this.aox);
                      return;
                      if (this.aib == -2)
                      {
                        j = this.aoq.getWidth();
                        break label997;
                      }
                      j = this.aib;
                      break label997;
                      label1262:
                      if (this.aoe == -2) {
                        break label1007;
                      }
                      i = this.aoe;
                      break label1007;
                      bool1 = false;
                      break label1074;
                      i = j;
                      if ((d.getAbsoluteGravity(m, t.Y((View)localObject2)) & 0x7) == 5) {
                        i = j - (((PopupWindow)localObject1).getWidth() - ((View)localObject2).getWidth());
                      }
                      ((PopupWindow)localObject1).showAsDropDown((View)localObject2, i, k);
                    }
                  }
                  catch (Exception localException1)
                  {
                    break label1138;
                  }
                }
              }
              catch (Exception localException2)
              {
                break label1050;
              }
            }
          }
        }
        label926:
        label1346:
        i = 0;
      }
      label916:
      label1351:
      i = 0;
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      ListPopupWindow.this.clearListSelection();
    }
  }
  
  final class b
    extends DataSetObserver
  {
    b() {}
    
    public final void onChanged()
    {
      if (ListPopupWindow.this.aoA.isShowing()) {
        ListPopupWindow.this.show();
      }
    }
    
    public final void onInvalidated()
    {
      ListPopupWindow.this.dismiss();
    }
  }
  
  final class c
    implements AbsListView.OnScrollListener
  {
    c() {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!ListPopupWindow.this.isInputMethodNotNeeded()) && (ListPopupWindow.this.aoA.getContentView() != null))
      {
        ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.aou);
        ListPopupWindow.this.aou.run();
      }
    }
  }
  
  final class d
    implements View.OnTouchListener
  {
    d() {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (ListPopupWindow.this.aoA != null) && (ListPopupWindow.this.aoA.isShowing()) && (j >= 0) && (j < ListPopupWindow.this.aoA.getWidth()) && (k >= 0) && (k < ListPopupWindow.this.aoA.getHeight())) {
        ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.aou, 250L);
      }
      for (;;)
      {
        return false;
        if (i == 1) {
          ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.aou);
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
      if ((ListPopupWindow.this.aod != null) && (t.aC(ListPopupWindow.this.aod)) && (ListPopupWindow.this.aod.getCount() > ListPopupWindow.this.aod.getChildCount()) && (ListPopupWindow.this.aod.getChildCount() <= ListPopupWindow.this.aon))
      {
        ListPopupWindow.this.aoA.setInputMethodMode(2);
        ListPopupWindow.this.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow
 * JD-Core Version:    0.7.0.1
 */