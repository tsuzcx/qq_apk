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
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.tencent.luggage.l.a.a.b;
import com.tencent.mm.sdk.platformtools.ah;

public class AutoFillListPopupWindowBase
{
  ListAdapter NK;
  int aal = -2;
  int aeI = -2;
  int aeJ;
  int aeK;
  boolean aeM;
  boolean aeP = false;
  boolean aeQ = false;
  int aeR = 2147483647;
  private View aeS;
  private int aeT = 0;
  View aeU;
  private Drawable aeV;
  private AdapterView.OnItemClickListener aeW;
  private AdapterView.OnItemSelectedListener aeX;
  private Runnable afc;
  boolean afd;
  PopupWindow afe;
  private Rect ec = new Rect();
  AutoFillListPopupWindowBase.a hxe;
  private final AutoFillListPopupWindowBase.f hxf = new AutoFillListPopupWindowBase.f(this, (byte)0);
  private final AutoFillListPopupWindowBase.e hxg = new AutoFillListPopupWindowBase.e(this, (byte)0);
  private final AutoFillListPopupWindowBase.d hxh = new AutoFillListPopupWindowBase.d(this, (byte)0);
  private final AutoFillListPopupWindowBase.b hxi = new AutoFillListPopupWindowBase.b(this, (byte)0);
  private boolean hxj = false;
  private Context mContext;
  private ah mHandler = new ah();
  DataSetObserver mObserver;
  
  public AutoFillListPopupWindowBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.listPopupWindowStyle);
  }
  
  public AutoFillListPopupWindowBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.mContext = paramContext;
    this.afe = new PopupWindow(paramContext);
    this.afe.setInputMethodMode(1);
    paramContext = this.mContext.getResources().getConfiguration().locale;
  }
  
  private void asA()
  {
    if (this.aeS != null)
    {
      ViewParent localViewParent = this.aeS.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.aeS);
      }
    }
  }
  
  public final void clearListSelection()
  {
    AutoFillListPopupWindowBase.a locala = this.hxe;
    if (locala != null)
    {
      AutoFillListPopupWindowBase.a.a(locala, true);
      locala.requestLayout();
    }
  }
  
  public final void dismiss()
  {
    this.afe.dismiss();
    asA();
    this.afe.setContentView(null);
    this.hxe = null;
    this.mHandler.removeCallbacks(this.hxf);
  }
  
  public final boolean isInputMethodNotNeeded()
  {
    return this.afe.getInputMethodMode() == 2;
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
    int n = -1;
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    FrameLayout.LayoutParams localLayoutParams1;
    FrameLayout.LayoutParams localLayoutParams2;
    if (this.hxe == null)
    {
      localObject2 = this.mContext;
      this.afc = new AutoFillListPopupWindowBase.1(this);
      if (!this.afd)
      {
        bool1 = true;
        this.hxe = new AutoFillListPopupWindowBase.a((Context)localObject2, bool1);
        if (this.aeV != null) {
          this.hxe.setSelector(this.aeV);
        }
        this.hxe.setAdapter(this.NK);
        this.hxe.setOnItemClickListener(this.aeW);
        this.hxe.setFocusable(true);
        this.hxe.setFocusableInTouchMode(true);
        this.hxe.setDivider(null);
        this.hxe.setDividerHeight(0);
        this.hxe.setOnItemSelectedListener(new AutoFillListPopupWindowBase.2(this));
        this.hxe.setOnScrollListener(this.hxh);
        if (this.aeX != null) {
          this.hxe.setOnItemSelectedListener(this.aeX);
        }
        localObject1 = this.hxe;
        localView = this.aeS;
        if (localView == null) {
          break label1325;
        }
        asA();
        localObject2 = new FrameLayout((Context)localObject2);
        localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
        localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        switch (this.aeT)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.aeT);
          label274:
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.aal, -2147483648), 0);
          localObject1 = localObject2;
        }
      }
    }
    label541:
    label554:
    label940:
    label1325:
    for (;;)
    {
      this.afe.setContentView((View)localObject1);
      int i = 0;
      for (;;)
      {
        label305:
        localObject1 = this.afe.getBackground();
        int k;
        label368:
        label381:
        int i1;
        int m;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.ec);
          j = this.ec.top + this.ec.bottom;
          k = j;
          if (!this.aeM)
          {
            this.aeK = (-this.ec.top);
            k = j;
          }
          if (this.afe.getInputMethodMode() != 2) {
            break label748;
          }
          j = 1;
          localObject1 = this.aeU;
          i1 = this.aeK;
          localObject2 = new Rect();
          ((View)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
          ((View)localObject1).getLocationOnScreen(new int[2]);
          m = ((Rect)localObject2).bottom;
          if (j == 0) {
            break label1314;
          }
        }
        for (int j = ((View)localObject1).getContext().getResources().getDisplayMetrics().heightPixels;; j = m)
        {
          j -= i1;
          m = j;
          if (this.afe.getBackground() != null)
          {
            this.afe.getBackground().getPadding(this.ec);
            m = j - (this.ec.top + this.ec.bottom);
          }
          if ((this.aeP) || (this.aeI == -1))
          {
            i = m + k;
            bool1 = isInputMethodNotNeeded();
            if (!this.afe.isShowing()) {
              break label1028;
            }
            if (this.aal != -1) {
              break label902;
            }
            j = -1;
            if (this.aeI != -1) {
              break label971;
            }
            if (!bool1) {
              break label930;
            }
            if (!bool1) {
              break label940;
            }
            localObject1 = this.afe;
            if (this.aal != -1) {
              break label935;
            }
            k = n;
            label576:
            ((PopupWindow)localObject1).setWindowLayoutMode(k, 0);
            label583:
            this.afe.update(j, i);
            localObject1 = this.afe;
            if ((this.aeQ) || (this.aeP)) {
              break label988;
            }
          }
          label971:
          label988:
          for (bool1 = bool2;; bool1 = false)
          {
            ((PopupWindow)localObject1).setOutsideTouchable(bool1);
            if (!this.hxj) {
              break label994;
            }
            this.afe.showAtLocation(this.aeU, 17, 0, 0);
            return;
            bool1 = false;
            break;
            localLayoutParams2.gravity = 80;
            ((FrameLayout)localObject2).addView((View)localObject1, localLayoutParams1);
            ((FrameLayout)localObject2).addView(localView, localLayoutParams2);
            break label274;
            localLayoutParams2.gravity = 48;
            ((FrameLayout)localObject2).addView((View)localObject1, localLayoutParams1);
            ((FrameLayout)localObject2).addView(localView, localLayoutParams2);
            break label274;
            this.afe.getContentView();
            localObject1 = this.aeS;
            if (localObject1 == null) {
              break label1320;
            }
            i = ((View)localObject1).getMeasuredHeight();
            break label305;
            this.ec.setEmpty();
            k = 0;
            break label368;
            label748:
            j = 0;
            break label381;
            switch (this.aal)
            {
            default: 
              j = View.MeasureSpec.makeMeasureSpec(this.aal, 1073741824);
            }
            for (;;)
            {
              m = this.hxe.ck(j, m - i);
              j = i;
              if (m > 0) {
                j = i + k;
              }
              i = j + m;
              break;
              j = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.ec.left + this.ec.right), -2147483648);
              continue;
              j = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.ec.left + this.ec.right), 1073741824);
            }
            if (this.aal == -2)
            {
              j = this.aeU.getWidth();
              break label541;
            }
            j = this.aal;
            break label541;
            i = -1;
            break label554;
            k = 0;
            break label576;
            localObject1 = this.afe;
            if (this.aal == -1) {}
            for (k = -1;; k = 0)
            {
              ((PopupWindow)localObject1).setWindowLayoutMode(k, -1);
              break;
            }
            if (this.aeI == -2) {
              break label583;
            }
            i = this.aeI;
            break label583;
          }
          label994:
          this.afe.update(this.aeU, this.aeJ, this.aeK, this.afe.getWidth(), this.afe.getHeight());
          return;
          if (this.aal == -1)
          {
            j = -1;
            if (this.aeI != -1) {
              break label1214;
            }
            i = -1;
            this.afe.setWindowLayoutMode(j, i);
            localObject1 = this.afe;
            if ((this.aeQ) || (this.aeP)) {
              break label1252;
            }
            bool1 = bool3;
            label1081:
            ((PopupWindow)localObject1).setOutsideTouchable(bool1);
            this.afe.setTouchInterceptor(this.hxg);
            if (!this.hxj) {
              break label1258;
            }
            this.afe.showAtLocation(this.aeU, 17, 0, 0);
          }
          for (;;)
          {
            this.hxe.setSelection(-1);
            if ((!this.afd) || (this.hxe.isInTouchMode())) {
              clearListSelection();
            }
            if (this.afd) {
              break;
            }
            this.mHandler.post(this.hxi);
            return;
            if (this.aal == -2)
            {
              this.afe.setWidth(this.aeU.getWidth());
              j = 0;
              break label1038;
            }
            this.afe.setWidth(this.aal);
            j = 0;
            break label1038;
            label1214:
            if (this.aeI == -2)
            {
              this.afe.setHeight(i);
              i = 0;
              break label1048;
            }
            this.afe.setHeight(this.aeI);
            i = 0;
            break label1048;
            label1252:
            bool1 = false;
            break label1081;
            label1258:
            if (Build.VERSION.SDK_INT >= 19) {
              this.afe.showAsDropDown(this.aeU, this.aeJ, this.aeK, 53);
            } else {
              this.afe.showAtLocation(this.aeU, 53, this.aeJ, this.aeK);
            }
          }
        }
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase
 * JD-Core Version:    0.7.0.1
 */