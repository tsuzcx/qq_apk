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
  private static Method agT;
  private static Method agU;
  private static Method agV;
  public int Vw = 0;
  public Rect Xa;
  private boolean aaG;
  public int aaV = -2;
  public y agW;
  private int agX = -2;
  public int agY;
  private int agZ;
  private int aha = 1002;
  private boolean ahb;
  private boolean ahc = true;
  private boolean ahd;
  private boolean ahe = false;
  private boolean ahf = false;
  int ahg = 2147483647;
  private View ahh;
  int ahi = 0;
  public View ahj;
  private Drawable ahk;
  public AdapterView.OnItemClickListener ahl;
  private AdapterView.OnItemSelectedListener ahm;
  final e ahn = new e();
  private final d aho = new d();
  private final c ahp = new c();
  private final a ahq = new a();
  private Runnable ahr;
  public boolean ahs;
  public PopupWindow aht;
  private Context mContext;
  final Handler mHandler;
  private DataSetObserver mObserver;
  private final Rect mTempRect = new Rect();
  private ListAdapter xw;
  
  static
  {
    try
    {
      agT = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
      try
      {
        label20:
        agU = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
        try
        {
          label51:
          agV = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
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
    this(paramContext, null, 2130772198);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772198);
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
    this.agY = localTypedArray.getDimensionPixelOffset(0, 0);
    this.agZ = localTypedArray.getDimensionPixelOffset(1, 0);
    if (this.agZ != 0) {
      this.ahb = true;
    }
    localTypedArray.recycle();
    this.aht = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.aht.setInputMethodMode(1);
  }
  
  private int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    if (agU != null) {
      try
      {
        int i = ((Integer)agU.invoke(this.aht, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
        return i;
      }
      catch (Exception localException) {}
    }
    return this.aht.getMaxAvailableHeight(paramView, paramInt);
  }
  
  private void iC()
  {
    if (this.ahh != null)
    {
      ViewParent localViewParent = this.ahh.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.ahh);
      }
    }
  }
  
  public final void clearListSelection()
  {
    y localy = this.agW;
    if (localy != null)
    {
      localy.setListSelectionHidden(true);
      localy.requestLayout();
    }
  }
  
  public final void dismiss()
  {
    this.aht.dismiss();
    iC();
    this.aht.setContentView(null);
    this.agW = null;
    this.mHandler.removeCallbacks(this.ahn);
  }
  
  public final ListView getListView()
  {
    return this.agW;
  }
  
  public final int getVerticalOffset()
  {
    if (!this.ahb) {
      return 0;
    }
    return this.agZ;
  }
  
  y h(Context paramContext, boolean paramBoolean)
  {
    return new y(paramContext, paramBoolean);
  }
  
  public final void iD()
  {
    this.aht.setInputMethodMode(2);
  }
  
  public final void iE()
  {
    this.ahd = true;
    this.aaG = true;
  }
  
  public final boolean isInputMethodNotNeeded()
  {
    return this.aht.getInputMethodMode() == 2;
  }
  
  public final boolean isShowing()
  {
    return this.aht.isShowing();
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.mObserver == null) {
      this.mObserver = new b();
    }
    for (;;)
    {
      this.xw = paramListAdapter;
      if (paramListAdapter != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.agW != null) {
        this.agW.setAdapter(this.xw);
      }
      return;
      if (this.xw != null) {
        this.xw.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public final void setAnimationStyle(int paramInt)
  {
    this.aht.setAnimationStyle(paramInt);
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.aht.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setContentWidth(int paramInt)
  {
    Drawable localDrawable = this.aht.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.aaV = (this.mTempRect.left + this.mTempRect.right + paramInt);
      return;
    }
    this.aaV = paramInt;
  }
  
  public final void setHeight(int paramInt)
  {
    if ((paramInt < 0) && (-2 != paramInt) && (-1 != paramInt)) {
      throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }
    this.agX = paramInt;
  }
  
  public final void setModal(boolean paramBoolean)
  {
    this.ahs = paramBoolean;
    this.aht.setFocusable(paramBoolean);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.aht.setOnDismissListener(paramOnDismissListener);
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.agZ = paramInt;
    this.ahb = true;
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
    if (this.agW == null)
    {
      localObject2 = this.mContext;
      this.ahr = new Runnable()
      {
        public final void run()
        {
          View localView = ListPopupWindow.this.ahj;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            ListPopupWindow.this.show();
          }
        }
      };
      if (!this.ahs)
      {
        bool1 = true;
        this.agW = h((Context)localObject2, bool1);
        if (this.ahk != null) {
          this.agW.setSelector(this.ahk);
        }
        this.agW.setAdapter(this.xw);
        this.agW.setOnItemClickListener(this.ahl);
        this.agW.setFocusable(true);
        this.agW.setFocusableInTouchMode(true);
        this.agW.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = ListPopupWindow.this.agW;
              if (paramAnonymousAdapterView != null) {
                paramAnonymousAdapterView.setListSelectionHidden(false);
              }
            }
          }
          
          public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.agW.setOnScrollListener(this.ahp);
        if (this.ahm != null) {
          this.agW.setOnItemSelectedListener(this.ahm);
        }
        localObject1 = this.agW;
        localView = this.ahh;
        if (localView == null) {
          break label1351;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.ahi)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.ahi);
          if (this.aaV >= 0)
          {
            j = this.aaV;
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
      this.aht.setContentView((View)localObject1);
      label768:
      label789:
      label921:
      label1050:
      for (;;)
      {
        label310:
        localObject1 = this.aht.getBackground();
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          if (this.ahb) {
            break label1343;
          }
          this.agZ = (-this.mTempRect.top);
        }
        label803:
        label1074:
        label1340:
        label1343:
        for (;;)
        {
          label369:
          if (this.aht.getInputMethodMode() == 2) {}
          int m;
          for (bool1 = true;; bool1 = false)
          {
            m = getMaxAvailableHeight(this.ahj, this.agZ, bool1);
            if ((!this.ahe) && (this.agX != -1)) {
              break label576;
            }
            i = m + j;
            bool1 = isInputMethodNotNeeded();
            n.a(this.aht, this.aha);
            if (!this.aht.isShowing()) {
              break label987;
            }
            if (t.aw(this.ahj)) {
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
            this.aht.getContentView();
            localObject1 = this.ahh;
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
          switch (this.aaV)
          {
          default: 
            k = View.MeasureSpec.makeMeasureSpec(this.aaV, 1073741824);
          }
          for (;;)
          {
            m = this.agW.d(k, 0, -1, m - i, -1);
            k = i;
            if (m > 0) {
              k = i + (this.agW.getPaddingTop() + this.agW.getPaddingBottom() + j);
            }
            i = m + k;
            break;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), -2147483648);
            continue;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
          }
          label745:
          if (this.aaV == -1)
          {
            j = -1;
            if (this.agX != -1) {
              break label964;
            }
            if (!bool1) {
              break label916;
            }
            if (!bool1) {
              break label926;
            }
            localObject1 = this.aht;
            if (this.aaV != -1) {
              break label921;
            }
            k = -1;
            ((PopupWindow)localObject1).setWidth(k);
            this.aht.setHeight(0);
          }
          for (;;)
          {
            for (;;)
            {
              localObject1 = this.aht;
              if ((!this.ahf) && (!this.ahe)) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((PopupWindow)localObject1).setOutsideTouchable(bool1);
                localObject1 = this.aht;
                localObject2 = this.ahj;
                m = this.agY;
                int n = this.agZ;
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
                if (this.aaV == -2)
                {
                  j = this.ahj.getWidth();
                  break;
                }
                j = this.aaV;
                break;
                i = -1;
                break label768;
                k = 0;
                break label789;
                localObject1 = this.aht;
                if (this.aaV == -1) {}
                for (k = -1;; k = 0)
                {
                  ((PopupWindow)localObject1).setWidth(k);
                  this.aht.setHeight(-1);
                  break;
                }
                label964:
                if (this.agX == -2) {
                  break label1340;
                }
                i = this.agX;
                break label803;
              }
              label987:
              if (this.aaV == -1)
              {
                j = -1;
                label997:
                if (this.agX != -1) {
                  break label1262;
                }
                i = -1;
                label1007:
                this.aht.setWidth(j);
                this.aht.setHeight(i);
                if (agT == null) {}
              }
              try
              {
                for (;;)
                {
                  agT.invoke(this.aht, new Object[] { Boolean.TRUE });
                  localObject1 = this.aht;
                  if ((!this.ahf) && (!this.ahe))
                  {
                    bool1 = bool3;
                    ((PopupWindow)localObject1).setOutsideTouchable(bool1);
                    this.aht.setTouchInterceptor(this.aho);
                    if (this.ahd) {
                      n.a(this.aht, this.aaG);
                    }
                    if (agV == null) {}
                  }
                  try
                  {
                    agV.invoke(this.aht, new Object[] { this.Xa });
                    label1138:
                    localObject1 = this.aht;
                    localObject2 = this.ahj;
                    j = this.agY;
                    k = this.agZ;
                    m = this.Vw;
                    if (Build.VERSION.SDK_INT >= 19) {
                      ((PopupWindow)localObject1).showAsDropDown((View)localObject2, j, k, m);
                    }
                    for (;;)
                    {
                      this.agW.setSelection(-1);
                      if ((!this.ahs) || (this.agW.isInTouchMode())) {
                        clearListSelection();
                      }
                      if (this.ahs) {
                        break;
                      }
                      this.mHandler.post(this.ahq);
                      return;
                      if (this.aaV == -2)
                      {
                        j = this.ahj.getWidth();
                        break label997;
                      }
                      j = this.aaV;
                      break label997;
                      label1262:
                      if (this.agX == -2) {
                        break label1007;
                      }
                      i = this.agX;
                      break label1007;
                      bool1 = false;
                      break label1074;
                      i = j;
                      if ((d.getAbsoluteGravity(m, t.T((View)localObject2)) & 0x7) == 5) {
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
      if (ListPopupWindow.this.aht.isShowing()) {
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
      if ((paramInt == 1) && (!ListPopupWindow.this.isInputMethodNotNeeded()) && (ListPopupWindow.this.aht.getContentView() != null))
      {
        ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.ahn);
        ListPopupWindow.this.ahn.run();
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
      if ((i == 0) && (ListPopupWindow.this.aht != null) && (ListPopupWindow.this.aht.isShowing()) && (j >= 0) && (j < ListPopupWindow.this.aht.getWidth()) && (k >= 0) && (k < ListPopupWindow.this.aht.getHeight())) {
        ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.ahn, 250L);
      }
      for (;;)
      {
        return false;
        if (i == 1) {
          ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.ahn);
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
      if ((ListPopupWindow.this.agW != null) && (t.aw(ListPopupWindow.this.agW)) && (ListPopupWindow.this.agW.getCount() > ListPopupWindow.this.agW.getChildCount()) && (ListPopupWindow.this.agW.getChildCount() <= ListPopupWindow.this.ahg))
      {
        ListPopupWindow.this.aht.setInputMethodMode(2);
        ListPopupWindow.this.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow
 * JD-Core Version:    0.7.0.1
 */