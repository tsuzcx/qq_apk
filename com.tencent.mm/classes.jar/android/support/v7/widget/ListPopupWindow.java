package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.q;
import android.support.v4.widget.l;
import android.support.v7.a.a.a;
import android.support.v7.a.a.j;
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
  private static Method aeE;
  private static Method aeF;
  private static Method aeG;
  private ListAdapter NK;
  public int UJ = 0;
  public Rect Wn;
  public boolean ZW;
  public int aal = -2;
  public z aeH;
  private int aeI = -2;
  public int aeJ;
  private int aeK;
  private int aeL = 1002;
  private boolean aeM;
  private boolean aeN = true;
  public boolean aeO;
  private boolean aeP = false;
  private boolean aeQ = false;
  int aeR = 2147483647;
  private View aeS;
  int aeT = 0;
  public View aeU;
  private Drawable aeV;
  public AdapterView.OnItemClickListener aeW;
  private AdapterView.OnItemSelectedListener aeX;
  final e aeY = new e();
  private final d aeZ = new d();
  private final c afa = new c();
  private final a afb = new a();
  private Runnable afc;
  public boolean afd;
  public PopupWindow afe;
  private final Rect ec = new Rect();
  private Context mContext;
  final Handler mHandler;
  private DataSetObserver mObserver;
  
  static
  {
    try
    {
      aeE = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
      try
      {
        label20:
        aeF = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
        try
        {
          label51:
          aeG = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
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
    this.mContext = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ListPopupWindow, paramInt1, paramInt2);
    this.aeJ = localTypedArray.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    this.aeK = localTypedArray.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (this.aeK != 0) {
      this.aeM = true;
    }
    localTypedArray.recycle();
    this.afe = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.afe.setInputMethodMode(1);
  }
  
  private int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    if (aeF != null) {
      try
      {
        int i = ((Integer)aeF.invoke(this.afe, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
        return i;
      }
      catch (Exception localException) {}
    }
    return this.afe.getMaxAvailableHeight(paramView, paramInt);
  }
  
  public final void clearListSelection()
  {
    z localz = this.aeH;
    if (localz != null)
    {
      localz.setListSelectionHidden(true);
      localz.requestLayout();
    }
  }
  
  public final void dismiss()
  {
    this.afe.dismiss();
    if (this.aeS != null)
    {
      ViewParent localViewParent = this.aeS.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.aeS);
      }
    }
    this.afe.setContentView(null);
    this.aeH = null;
    this.mHandler.removeCallbacks(this.aeY);
  }
  
  z g(Context paramContext, boolean paramBoolean)
  {
    return new z(paramContext, paramBoolean);
  }
  
  public final ListView getListView()
  {
    return this.aeH;
  }
  
  public final int getVerticalOffset()
  {
    if (!this.aeM) {
      return 0;
    }
    return this.aeK;
  }
  
  public final void hf()
  {
    this.afe.setInputMethodMode(2);
  }
  
  public final boolean isInputMethodNotNeeded()
  {
    return this.afe.getInputMethodMode() == 2;
  }
  
  public final boolean isShowing()
  {
    return this.afe.isShowing();
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.mObserver == null) {
      this.mObserver = new b();
    }
    for (;;)
    {
      this.NK = paramListAdapter;
      if (paramListAdapter != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.aeH != null) {
        this.aeH.setAdapter(this.NK);
      }
      return;
      if (this.NK != null) {
        this.NK.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public final void setAnimationStyle(int paramInt)
  {
    this.afe.setAnimationStyle(paramInt);
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.afe.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setContentWidth(int paramInt)
  {
    Drawable localDrawable = this.afe.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.ec);
      this.aal = (this.ec.left + this.ec.right + paramInt);
      return;
    }
    this.aal = paramInt;
  }
  
  public final void setHeight(int paramInt)
  {
    if ((paramInt < 0) && (-2 != paramInt) && (-1 != paramInt)) {
      throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }
    this.aeI = paramInt;
  }
  
  public final void setModal(boolean paramBoolean)
  {
    this.afd = paramBoolean;
    this.afe.setFocusable(paramBoolean);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.afe.setOnDismissListener(paramOnDismissListener);
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.aeK = paramInt;
    this.aeM = true;
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
    if (this.aeH == null)
    {
      localObject2 = this.mContext;
      this.afc = new Runnable()
      {
        public final void run()
        {
          View localView = ListPopupWindow.this.aeU;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            ListPopupWindow.this.show();
          }
        }
      };
      if (!this.afd)
      {
        bool1 = true;
        this.aeH = g((Context)localObject2, bool1);
        if (this.aeV != null) {
          this.aeH.setSelector(this.aeV);
        }
        this.aeH.setAdapter(this.NK);
        this.aeH.setOnItemClickListener(this.aeW);
        this.aeH.setFocusable(true);
        this.aeH.setFocusableInTouchMode(true);
        this.aeH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = ListPopupWindow.this.aeH;
              if (paramAnonymousAdapterView != null) {
                paramAnonymousAdapterView.setListSelectionHidden(false);
              }
            }
          }
          
          public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.aeH.setOnScrollListener(this.afa);
        if (this.aeX != null) {
          this.aeH.setOnItemSelectedListener(this.aeX);
        }
        localObject1 = this.aeH;
        localView = this.aeS;
        if (localView == null) {
          break label1291;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.aeT)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.aeT);
          if (this.aal >= 0)
          {
            j = this.aal;
            i = -2147483648;
            label258:
            localView.measure(View.MeasureSpec.makeMeasureSpec(j, i), 0);
            localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
            i = localView.getMeasuredHeight();
            j = ((LinearLayout.LayoutParams)localObject1).topMargin;
            i = ((LinearLayout.LayoutParams)localObject1).bottomMargin + (i + j);
            localObject1 = localObject2;
          }
          break;
        }
      }
    }
    for (;;)
    {
      this.afe.setContentView((View)localObject1);
      for (;;)
      {
        label314:
        localObject1 = this.afe.getBackground();
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.ec);
          j = this.ec.top + this.ec.bottom;
          if (this.aeM) {
            break label1283;
          }
          this.aeK = (-this.ec.top);
        }
        label1280:
        label1283:
        for (;;)
        {
          label373:
          if (this.afe.getInputMethodMode() == 2) {}
          int m;
          for (bool1 = true;; bool1 = false)
          {
            m = getMaxAvailableHeight(this.aeU, this.aeK, bool1);
            if ((!this.aeP) && (this.aeI != -1)) {
              break label584;
            }
            i = m + j;
            bool1 = isInputMethodNotNeeded();
            l.a(this.afe, this.aeL);
            if (!this.afe.isShowing()) {
              break label995;
            }
            if (q.ao(this.aeU)) {
              break label753;
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
            this.afe.getContentView();
            localObject1 = this.aeS;
            if (localObject1 == null) {
              break label1286;
            }
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            i = ((View)localObject1).getMeasuredHeight();
            j = ((LinearLayout.LayoutParams)localObject2).topMargin;
            i = ((LinearLayout.LayoutParams)localObject2).bottomMargin + (i + j);
            break label314;
            this.ec.setEmpty();
            j = 0;
            break label373;
          }
          label584:
          int k;
          switch (this.aal)
          {
          default: 
            k = View.MeasureSpec.makeMeasureSpec(this.aal, 1073741824);
          }
          for (;;)
          {
            m = this.aeH.d(k, 0, -1, m - i, -1);
            k = i;
            if (m > 0) {
              k = i + (this.aeH.getPaddingTop() + this.aeH.getPaddingBottom() + j);
            }
            i = m + k;
            break;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.ec.left + this.ec.right), -2147483648);
            continue;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.ec.left + this.ec.right), 1073741824);
          }
          label753:
          if (this.aal == -1)
          {
            j = -1;
            if (this.aeI != -1) {
              break label972;
            }
            if (!bool1) {
              break label924;
            }
            if (!bool1) {
              break label934;
            }
            localObject1 = this.afe;
            if (this.aal != -1) {
              break label929;
            }
            k = -1;
            ((PopupWindow)localObject1).setWidth(k);
            this.afe.setHeight(0);
          }
          for (;;)
          {
            for (;;)
            {
              label776:
              label797:
              label811:
              localObject1 = this.afe;
              if ((!this.aeQ) && (!this.aeP)) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((PopupWindow)localObject1).setOutsideTouchable(bool1);
                localObject1 = this.afe;
                localObject2 = this.aeU;
                m = this.aeJ;
                int n = this.aeK;
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
                if (this.aal == -2)
                {
                  j = this.aeU.getWidth();
                  break;
                }
                j = this.aal;
                break;
                label924:
                i = -1;
                break label776;
                label929:
                k = 0;
                break label797;
                label934:
                localObject1 = this.afe;
                if (this.aal == -1) {}
                for (k = -1;; k = 0)
                {
                  ((PopupWindow)localObject1).setWidth(k);
                  this.afe.setHeight(-1);
                  break;
                }
                label972:
                if (this.aeI == -2) {
                  break label1280;
                }
                i = this.aeI;
                break label811;
              }
              label995:
              if (this.aal == -1)
              {
                j = -1;
                label1005:
                if (this.aeI != -1) {
                  break label1247;
                }
                i = -1;
                label1015:
                this.afe.setWidth(j);
                this.afe.setHeight(i);
                if (aeE == null) {}
              }
              try
              {
                for (;;)
                {
                  aeE.invoke(this.afe, new Object[] { Boolean.valueOf(true) });
                  label1059:
                  localObject1 = this.afe;
                  if ((!this.aeQ) && (!this.aeP))
                  {
                    bool1 = bool3;
                    ((PopupWindow)localObject1).setOutsideTouchable(bool1);
                    this.afe.setTouchInterceptor(this.aeZ);
                    if (this.aeO) {
                      l.a(this.afe, this.ZW);
                    }
                    if (aeG == null) {}
                  }
                  try
                  {
                    aeG.invoke(this.afe, new Object[] { this.Wn });
                    label1147:
                    l.a(this.afe, this.aeU, this.aeJ, this.aeK, this.UJ);
                    this.aeH.setSelection(-1);
                    if ((!this.afd) || (this.aeH.isInTouchMode())) {
                      clearListSelection();
                    }
                    if (this.afd) {
                      break;
                    }
                    this.mHandler.post(this.afb);
                    return;
                    if (this.aal == -2)
                    {
                      j = this.aeU.getWidth();
                      break label1005;
                    }
                    j = this.aal;
                    break label1005;
                    label1247:
                    if (this.aeI == -2) {
                      break label1015;
                    }
                    i = this.aeI;
                    break label1015;
                    bool1 = false;
                  }
                  catch (Exception localException1)
                  {
                    break label1147;
                  }
                }
              }
              catch (Exception localException2)
              {
                break label1059;
              }
            }
          }
        }
        label1286:
        i = 0;
      }
      label1291:
      i = 0;
    }
  }
  
  private final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      ListPopupWindow.this.clearListSelection();
    }
  }
  
  private final class b
    extends DataSetObserver
  {
    b() {}
    
    public final void onChanged()
    {
      if (ListPopupWindow.this.afe.isShowing()) {
        ListPopupWindow.this.show();
      }
    }
    
    public final void onInvalidated()
    {
      ListPopupWindow.this.dismiss();
    }
  }
  
  private final class c
    implements AbsListView.OnScrollListener
  {
    c() {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!ListPopupWindow.this.isInputMethodNotNeeded()) && (ListPopupWindow.this.afe.getContentView() != null))
      {
        ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.aeY);
        ListPopupWindow.this.aeY.run();
      }
    }
  }
  
  private final class d
    implements View.OnTouchListener
  {
    d() {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (ListPopupWindow.this.afe != null) && (ListPopupWindow.this.afe.isShowing()) && (j >= 0) && (j < ListPopupWindow.this.afe.getWidth()) && (k >= 0) && (k < ListPopupWindow.this.afe.getHeight())) {
        ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.aeY, 250L);
      }
      for (;;)
      {
        return false;
        if (i == 1) {
          ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.aeY);
        }
      }
    }
  }
  
  private final class e
    implements Runnable
  {
    e() {}
    
    public final void run()
    {
      if ((ListPopupWindow.this.aeH != null) && (q.ao(ListPopupWindow.this.aeH)) && (ListPopupWindow.this.aeH.getCount() > ListPopupWindow.this.aeH.getChildCount()) && (ListPopupWindow.this.aeH.getChildCount() <= ListPopupWindow.this.aeR))
      {
        ListPopupWindow.this.afe.setInputMethodMode(2);
        ListPopupWindow.this.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow
 * JD-Core Version:    0.7.0.1
 */