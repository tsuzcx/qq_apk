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
  private static Method aqN;
  private static Method aqO;
  private static Method aqP;
  private ListAdapter GE;
  public int afm = 0;
  public Rect agQ;
  public int akM = -2;
  private boolean akx;
  public y aqQ;
  private int aqR = -2;
  public int aqS;
  private int aqT;
  private int aqU = 1002;
  private boolean aqV;
  private boolean aqW = true;
  private boolean aqX;
  private boolean aqY = false;
  private boolean aqZ = false;
  int ara = 2147483647;
  private View arb;
  int arc = 0;
  public View ard;
  private Drawable are;
  public AdapterView.OnItemClickListener arf;
  private AdapterView.OnItemSelectedListener arg;
  final e arh = new e();
  private final d ari = new d();
  private final c arj = new c();
  private final a ark = new a();
  private Runnable arl;
  public boolean arm;
  public PopupWindow arn;
  private Context mContext;
  final Handler mHandler;
  private DataSetObserver mObserver;
  private final Rect mTempRect = new Rect();
  
  static
  {
    try
    {
      aqN = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
      try
      {
        label20:
        aqO = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
        try
        {
          label51:
          aqP = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
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
    this.aqS = localTypedArray.getDimensionPixelOffset(0, 0);
    this.aqT = localTypedArray.getDimensionPixelOffset(1, 0);
    if (this.aqT != 0) {
      this.aqV = true;
    }
    localTypedArray.recycle();
    this.arn = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.arn.setInputMethodMode(1);
  }
  
  private int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    if (aqO != null) {
      try
      {
        int i = ((Integer)aqO.invoke(this.arn, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
        return i;
      }
      catch (Exception localException) {}
    }
    return this.arn.getMaxAvailableHeight(paramView, paramInt);
  }
  
  private void kv()
  {
    if (this.arb != null)
    {
      ViewParent localViewParent = this.arb.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.arb);
      }
    }
  }
  
  public final void clearListSelection()
  {
    y localy = this.aqQ;
    if (localy != null)
    {
      localy.setListSelectionHidden(true);
      localy.requestLayout();
    }
  }
  
  public final void dismiss()
  {
    this.arn.dismiss();
    kv();
    this.arn.setContentView(null);
    this.aqQ = null;
    this.mHandler.removeCallbacks(this.arh);
  }
  
  public final ListView getListView()
  {
    return this.aqQ;
  }
  
  public final int getVerticalOffset()
  {
    if (!this.aqV) {
      return 0;
    }
    return this.aqT;
  }
  
  y i(Context paramContext, boolean paramBoolean)
  {
    return new y(paramContext, paramBoolean);
  }
  
  public final boolean isInputMethodNotNeeded()
  {
    return this.arn.getInputMethodMode() == 2;
  }
  
  public final boolean isShowing()
  {
    return this.arn.isShowing();
  }
  
  public final void kw()
  {
    this.arn.setInputMethodMode(2);
  }
  
  public final void kx()
  {
    this.aqX = true;
    this.akx = true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.mObserver == null) {
      this.mObserver = new b();
    }
    for (;;)
    {
      this.GE = paramListAdapter;
      if (paramListAdapter != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.aqQ != null) {
        this.aqQ.setAdapter(this.GE);
      }
      return;
      if (this.GE != null) {
        this.GE.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public final void setAnimationStyle(int paramInt)
  {
    this.arn.setAnimationStyle(paramInt);
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.arn.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setContentWidth(int paramInt)
  {
    Drawable localDrawable = this.arn.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.akM = (this.mTempRect.left + this.mTempRect.right + paramInt);
      return;
    }
    this.akM = paramInt;
  }
  
  public final void setHeight(int paramInt)
  {
    if ((paramInt < 0) && (-2 != paramInt) && (-1 != paramInt)) {
      throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }
    this.aqR = paramInt;
  }
  
  public final void setModal(boolean paramBoolean)
  {
    this.arm = paramBoolean;
    this.arn.setFocusable(paramBoolean);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.arn.setOnDismissListener(paramOnDismissListener);
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
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    label242:
    int j;
    int i;
    if (this.aqQ == null)
    {
      localObject2 = this.mContext;
      this.arl = new Runnable()
      {
        public final void run()
        {
          View localView = ListPopupWindow.this.ard;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            ListPopupWindow.this.show();
          }
        }
      };
      if (!this.arm)
      {
        bool1 = true;
        this.aqQ = i((Context)localObject2, bool1);
        if (this.are != null) {
          this.aqQ.setSelector(this.are);
        }
        this.aqQ.setAdapter(this.GE);
        this.aqQ.setOnItemClickListener(this.arf);
        this.aqQ.setFocusable(true);
        this.aqQ.setFocusableInTouchMode(true);
        this.aqQ.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = ListPopupWindow.this.aqQ;
              if (paramAnonymousAdapterView != null) {
                paramAnonymousAdapterView.setListSelectionHidden(false);
              }
            }
          }
          
          public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.aqQ.setOnScrollListener(this.arj);
        if (this.arg != null) {
          this.aqQ.setOnItemSelectedListener(this.arg);
        }
        localObject1 = this.aqQ;
        localView = this.arb;
        if (localView == null) {
          break label1351;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.arc)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.arc);
          if (this.akM >= 0)
          {
            j = this.akM;
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
      this.arn.setContentView((View)localObject1);
      label768:
      label789:
      label921:
      label1050:
      for (;;)
      {
        label310:
        localObject1 = this.arn.getBackground();
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          if (this.aqV) {
            break label1343;
          }
          this.aqT = (-this.mTempRect.top);
        }
        label803:
        label1074:
        label1340:
        label1343:
        for (;;)
        {
          label369:
          if (this.arn.getInputMethodMode() == 2) {}
          int m;
          for (bool1 = true;; bool1 = false)
          {
            m = getMaxAvailableHeight(this.ard, this.aqT, bool1);
            if ((!this.aqY) && (this.aqR != -1)) {
              break label576;
            }
            i = m + j;
            bool1 = isInputMethodNotNeeded();
            n.a(this.arn, this.aqU);
            if (!this.arn.isShowing()) {
              break label987;
            }
            if (t.aC(this.ard)) {
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
            this.arn.getContentView();
            localObject1 = this.arb;
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
          switch (this.akM)
          {
          default: 
            k = View.MeasureSpec.makeMeasureSpec(this.akM, 1073741824);
          }
          for (;;)
          {
            m = this.aqQ.e(k, 0, -1, m - i, -1);
            k = i;
            if (m > 0) {
              k = i + (this.aqQ.getPaddingTop() + this.aqQ.getPaddingBottom() + j);
            }
            i = m + k;
            break;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), -2147483648);
            continue;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
          }
          label745:
          if (this.akM == -1)
          {
            j = -1;
            if (this.aqR != -1) {
              break label964;
            }
            if (!bool1) {
              break label916;
            }
            if (!bool1) {
              break label926;
            }
            localObject1 = this.arn;
            if (this.akM != -1) {
              break label921;
            }
            k = -1;
            ((PopupWindow)localObject1).setWidth(k);
            this.arn.setHeight(0);
          }
          for (;;)
          {
            for (;;)
            {
              localObject1 = this.arn;
              if ((!this.aqZ) && (!this.aqY)) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((PopupWindow)localObject1).setOutsideTouchable(bool1);
                localObject1 = this.arn;
                localObject2 = this.ard;
                m = this.aqS;
                int n = this.aqT;
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
                if (this.akM == -2)
                {
                  j = this.ard.getWidth();
                  break;
                }
                j = this.akM;
                break;
                i = -1;
                break label768;
                k = 0;
                break label789;
                localObject1 = this.arn;
                if (this.akM == -1) {}
                for (k = -1;; k = 0)
                {
                  ((PopupWindow)localObject1).setWidth(k);
                  this.arn.setHeight(-1);
                  break;
                }
                label964:
                if (this.aqR == -2) {
                  break label1340;
                }
                i = this.aqR;
                break label803;
              }
              label987:
              if (this.akM == -1)
              {
                j = -1;
                label997:
                if (this.aqR != -1) {
                  break label1262;
                }
                i = -1;
                label1007:
                this.arn.setWidth(j);
                this.arn.setHeight(i);
                if (aqN == null) {}
              }
              try
              {
                for (;;)
                {
                  aqN.invoke(this.arn, new Object[] { Boolean.TRUE });
                  localObject1 = this.arn;
                  if ((!this.aqZ) && (!this.aqY))
                  {
                    bool1 = bool3;
                    ((PopupWindow)localObject1).setOutsideTouchable(bool1);
                    this.arn.setTouchInterceptor(this.ari);
                    if (this.aqX) {
                      n.a(this.arn, this.akx);
                    }
                    if (aqP == null) {}
                  }
                  try
                  {
                    aqP.invoke(this.arn, new Object[] { this.agQ });
                    label1138:
                    localObject1 = this.arn;
                    localObject2 = this.ard;
                    j = this.aqS;
                    k = this.aqT;
                    m = this.afm;
                    if (Build.VERSION.SDK_INT >= 19) {
                      ((PopupWindow)localObject1).showAsDropDown((View)localObject2, j, k, m);
                    }
                    for (;;)
                    {
                      this.aqQ.setSelection(-1);
                      if ((!this.arm) || (this.aqQ.isInTouchMode())) {
                        clearListSelection();
                      }
                      if (this.arm) {
                        break;
                      }
                      this.mHandler.post(this.ark);
                      return;
                      if (this.akM == -2)
                      {
                        j = this.ard.getWidth();
                        break label997;
                      }
                      j = this.akM;
                      break label997;
                      label1262:
                      if (this.aqR == -2) {
                        break label1007;
                      }
                      i = this.aqR;
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
      if (ListPopupWindow.this.arn.isShowing()) {
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
      if ((paramInt == 1) && (!ListPopupWindow.this.isInputMethodNotNeeded()) && (ListPopupWindow.this.arn.getContentView() != null))
      {
        ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.arh);
        ListPopupWindow.this.arh.run();
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
      if ((i == 0) && (ListPopupWindow.this.arn != null) && (ListPopupWindow.this.arn.isShowing()) && (j >= 0) && (j < ListPopupWindow.this.arn.getWidth()) && (k >= 0) && (k < ListPopupWindow.this.arn.getHeight())) {
        ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.arh, 250L);
      }
      for (;;)
      {
        return false;
        if (i == 1) {
          ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.arh);
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
      if ((ListPopupWindow.this.aqQ != null) && (t.aC(ListPopupWindow.this.aqQ)) && (ListPopupWindow.this.aqQ.getCount() > ListPopupWindow.this.aqQ.getChildCount()) && (ListPopupWindow.this.aqQ.getChildCount() <= ListPopupWindow.this.ara))
      {
        ListPopupWindow.this.arn.setInputMethodMode(2);
        ListPopupWindow.this.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow
 * JD-Core Version:    0.7.0.1
 */