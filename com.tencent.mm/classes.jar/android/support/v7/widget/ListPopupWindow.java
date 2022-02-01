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
import android.support.v4.view.u;
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
  private static Method aqZ;
  private static Method ara;
  private static Method arb;
  private ListAdapter GO;
  public int afz = 0;
  public Rect ahd;
  private boolean akK;
  public int akZ = -2;
  public PopupWindow arA;
  public y arc;
  private int ard = -2;
  public int are;
  private int arf;
  private int arg = 1002;
  private boolean arh;
  private boolean ari = true;
  private boolean arj;
  private boolean ark = false;
  private boolean arl = false;
  int arm = 2147483647;
  private View arn;
  int aro = 0;
  public View arp;
  private Drawable arq;
  public AdapterView.OnItemClickListener ars;
  private AdapterView.OnItemSelectedListener art;
  final e aru = new e();
  private final d arv = new d();
  private final c arw = new c();
  private final a arx = new a();
  private Runnable ary;
  public boolean arz;
  private Context mContext;
  final Handler mHandler;
  private DataSetObserver mObserver;
  private final Rect mTempRect = new Rect();
  
  static
  {
    try
    {
      aqZ = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
      try
      {
        label20:
        ara = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
        try
        {
          label51:
          arb = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
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
    this(paramContext, null, 2130969279);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969279);
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
    this.are = localTypedArray.getDimensionPixelOffset(0, 0);
    this.arf = localTypedArray.getDimensionPixelOffset(1, 0);
    if (this.arf != 0) {
      this.arh = true;
    }
    localTypedArray.recycle();
    this.arA = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.arA.setInputMethodMode(1);
  }
  
  private int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    if (ara != null) {
      try
      {
        int i = ((Integer)ara.invoke(this.arA, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
        return i;
      }
      catch (Exception localException) {}
    }
    return this.arA.getMaxAvailableHeight(paramView, paramInt);
  }
  
  private void kB()
  {
    if (this.arn != null)
    {
      ViewParent localViewParent = this.arn.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.arn);
      }
    }
  }
  
  public final void clearListSelection()
  {
    y localy = this.arc;
    if (localy != null)
    {
      localy.setListSelectionHidden(true);
      localy.requestLayout();
    }
  }
  
  public final void dismiss()
  {
    this.arA.dismiss();
    kB();
    this.arA.setContentView(null);
    this.arc = null;
    this.mHandler.removeCallbacks(this.aru);
  }
  
  public final ListView getListView()
  {
    return this.arc;
  }
  
  public final int getVerticalOffset()
  {
    if (!this.arh) {
      return 0;
    }
    return this.arf;
  }
  
  y i(Context paramContext, boolean paramBoolean)
  {
    return new y(paramContext, paramBoolean);
  }
  
  public final boolean isInputMethodNotNeeded()
  {
    return this.arA.getInputMethodMode() == 2;
  }
  
  public final boolean isShowing()
  {
    return this.arA.isShowing();
  }
  
  public final void kC()
  {
    this.arA.setInputMethodMode(2);
  }
  
  public final void kD()
  {
    this.arj = true;
    this.akK = true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.mObserver == null) {
      this.mObserver = new b();
    }
    for (;;)
    {
      this.GO = paramListAdapter;
      if (paramListAdapter != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.arc != null) {
        this.arc.setAdapter(this.GO);
      }
      return;
      if (this.GO != null) {
        this.GO.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public final void setAnimationStyle(int paramInt)
  {
    this.arA.setAnimationStyle(paramInt);
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.arA.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setContentWidth(int paramInt)
  {
    Drawable localDrawable = this.arA.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.akZ = (this.mTempRect.left + this.mTempRect.right + paramInt);
      return;
    }
    this.akZ = paramInt;
  }
  
  public final void setHeight(int paramInt)
  {
    if ((paramInt < 0) && (-2 != paramInt) && (-1 != paramInt)) {
      throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }
    this.ard = paramInt;
  }
  
  public final void setModal(boolean paramBoolean)
  {
    this.arz = paramBoolean;
    this.arA.setFocusable(paramBoolean);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.arA.setOnDismissListener(paramOnDismissListener);
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.arf = paramInt;
    this.arh = true;
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
    if (this.arc == null)
    {
      localObject2 = this.mContext;
      this.ary = new Runnable()
      {
        public final void run()
        {
          View localView = ListPopupWindow.this.arp;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            ListPopupWindow.this.show();
          }
        }
      };
      if (!this.arz)
      {
        bool1 = true;
        this.arc = i((Context)localObject2, bool1);
        if (this.arq != null) {
          this.arc.setSelector(this.arq);
        }
        this.arc.setAdapter(this.GO);
        this.arc.setOnItemClickListener(this.ars);
        this.arc.setFocusable(true);
        this.arc.setFocusableInTouchMode(true);
        this.arc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = ListPopupWindow.this.arc;
              if (paramAnonymousAdapterView != null) {
                paramAnonymousAdapterView.setListSelectionHidden(false);
              }
            }
          }
          
          public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.arc.setOnScrollListener(this.arw);
        if (this.art != null) {
          this.arc.setOnItemSelectedListener(this.art);
        }
        localObject1 = this.arc;
        localView = this.arn;
        if (localView == null) {
          break label1351;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.aro)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.aro);
          if (this.akZ >= 0)
          {
            j = this.akZ;
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
      this.arA.setContentView((View)localObject1);
      label768:
      label789:
      label921:
      label1050:
      for (;;)
      {
        label310:
        localObject1 = this.arA.getBackground();
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          if (this.arh) {
            break label1343;
          }
          this.arf = (-this.mTempRect.top);
        }
        label803:
        label1074:
        label1340:
        label1343:
        for (;;)
        {
          label369:
          if (this.arA.getInputMethodMode() == 2) {}
          int m;
          for (bool1 = true;; bool1 = false)
          {
            m = getMaxAvailableHeight(this.arp, this.arf, bool1);
            if ((!this.ark) && (this.ard != -1)) {
              break label576;
            }
            i = m + j;
            bool1 = isInputMethodNotNeeded();
            n.a(this.arA, this.arg);
            if (!this.arA.isShowing()) {
              break label987;
            }
            if (u.aD(this.arp)) {
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
            this.arA.getContentView();
            localObject1 = this.arn;
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
          switch (this.akZ)
          {
          default: 
            k = View.MeasureSpec.makeMeasureSpec(this.akZ, 1073741824);
          }
          for (;;)
          {
            m = this.arc.e(k, 0, -1, m - i, -1);
            k = i;
            if (m > 0) {
              k = i + (this.arc.getPaddingTop() + this.arc.getPaddingBottom() + j);
            }
            i = m + k;
            break;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), -2147483648);
            continue;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
          }
          label745:
          if (this.akZ == -1)
          {
            j = -1;
            if (this.ard != -1) {
              break label964;
            }
            if (!bool1) {
              break label916;
            }
            if (!bool1) {
              break label926;
            }
            localObject1 = this.arA;
            if (this.akZ != -1) {
              break label921;
            }
            k = -1;
            ((PopupWindow)localObject1).setWidth(k);
            this.arA.setHeight(0);
          }
          for (;;)
          {
            for (;;)
            {
              localObject1 = this.arA;
              if ((!this.arl) && (!this.ark)) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((PopupWindow)localObject1).setOutsideTouchable(bool1);
                localObject1 = this.arA;
                localObject2 = this.arp;
                m = this.are;
                int n = this.arf;
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
                if (this.akZ == -2)
                {
                  j = this.arp.getWidth();
                  break;
                }
                j = this.akZ;
                break;
                i = -1;
                break label768;
                k = 0;
                break label789;
                localObject1 = this.arA;
                if (this.akZ == -1) {}
                for (k = -1;; k = 0)
                {
                  ((PopupWindow)localObject1).setWidth(k);
                  this.arA.setHeight(-1);
                  break;
                }
                label964:
                if (this.ard == -2) {
                  break label1340;
                }
                i = this.ard;
                break label803;
              }
              label987:
              if (this.akZ == -1)
              {
                j = -1;
                label997:
                if (this.ard != -1) {
                  break label1262;
                }
                i = -1;
                label1007:
                this.arA.setWidth(j);
                this.arA.setHeight(i);
                if (aqZ == null) {}
              }
              try
              {
                for (;;)
                {
                  aqZ.invoke(this.arA, new Object[] { Boolean.TRUE });
                  localObject1 = this.arA;
                  if ((!this.arl) && (!this.ark))
                  {
                    bool1 = bool3;
                    ((PopupWindow)localObject1).setOutsideTouchable(bool1);
                    this.arA.setTouchInterceptor(this.arv);
                    if (this.arj) {
                      n.a(this.arA, this.akK);
                    }
                    if (arb == null) {}
                  }
                  try
                  {
                    arb.invoke(this.arA, new Object[] { this.ahd });
                    label1138:
                    localObject1 = this.arA;
                    localObject2 = this.arp;
                    j = this.are;
                    k = this.arf;
                    m = this.afz;
                    if (Build.VERSION.SDK_INT >= 19) {
                      ((PopupWindow)localObject1).showAsDropDown((View)localObject2, j, k, m);
                    }
                    for (;;)
                    {
                      this.arc.setSelection(-1);
                      if ((!this.arz) || (this.arc.isInTouchMode())) {
                        clearListSelection();
                      }
                      if (this.arz) {
                        break;
                      }
                      this.mHandler.post(this.arx);
                      return;
                      if (this.akZ == -2)
                      {
                        j = this.arp.getWidth();
                        break label997;
                      }
                      j = this.akZ;
                      break label997;
                      label1262:
                      if (this.ard == -2) {
                        break label1007;
                      }
                      i = this.ard;
                      break label1007;
                      bool1 = false;
                      break label1074;
                      i = j;
                      if ((d.getAbsoluteGravity(m, u.Z((View)localObject2)) & 0x7) == 5) {
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
      if (ListPopupWindow.this.arA.isShowing()) {
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
      if ((paramInt == 1) && (!ListPopupWindow.this.isInputMethodNotNeeded()) && (ListPopupWindow.this.arA.getContentView() != null))
      {
        ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.aru);
        ListPopupWindow.this.aru.run();
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
      if ((i == 0) && (ListPopupWindow.this.arA != null) && (ListPopupWindow.this.arA.isShowing()) && (j >= 0) && (j < ListPopupWindow.this.arA.getWidth()) && (k >= 0) && (k < ListPopupWindow.this.arA.getHeight())) {
        ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.aru, 250L);
      }
      for (;;)
      {
        return false;
        if (i == 1) {
          ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.aru);
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
      if ((ListPopupWindow.this.arc != null) && (u.aD(ListPopupWindow.this.arc)) && (ListPopupWindow.this.arc.getCount() > ListPopupWindow.this.arc.getChildCount()) && (ListPopupWindow.this.arc.getChildCount() <= ListPopupWindow.this.arm))
      {
        ListPopupWindow.this.arA.setInputMethodMode(2);
        ListPopupWindow.this.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow
 * JD-Core Version:    0.7.0.1
 */