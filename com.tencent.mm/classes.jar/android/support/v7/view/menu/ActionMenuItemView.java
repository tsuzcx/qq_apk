package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.a.a.a;
import android.support.v7.widget.ActionMenuView.a;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ab;
import android.support.v7.widget.bb;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;

public class ActionMenuItemView
  extends AppCompatTextView
  implements p.a, ActionMenuView.a, View.OnClickListener
{
  private CharSequence Cv;
  h.b UU;
  private ab UV;
  b UW;
  private boolean UX;
  private boolean UY;
  private int UZ;
  private int Va;
  j dZ;
  private Drawable la;
  private int mMinWidth;
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    this.UX = fH();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ActionMenuItemView, paramInt, 0);
    this.mMinWidth = paramContext.getDimensionPixelSize(0, 0);
    paramContext.recycle();
    this.Va = ((int)(localResources.getDisplayMetrics().density * 32.0F + 0.5F));
    setOnClickListener(this);
    this.UZ = -1;
    setSaveEnabled(false);
  }
  
  private boolean fH()
  {
    Configuration localConfiguration = getContext().getResources().getConfiguration();
    int i = localConfiguration.screenWidthDp;
    int j = localConfiguration.screenHeightDp;
    return (i >= 480) || ((i >= 640) && (j >= 480)) || (localConfiguration.orientation == 2);
  }
  
  private void fI()
  {
    int k = 0;
    Object localObject2 = null;
    int i;
    if (!TextUtils.isEmpty(this.Cv))
    {
      i = 1;
      if (this.la != null)
      {
        j = k;
        if (!this.dZ.go()) {
          break label54;
        }
        if (!this.UX)
        {
          j = k;
          if (!this.UY) {
            break label54;
          }
        }
      }
      int j = 1;
      label54:
      i &= j;
      if (i == 0) {
        break label141;
      }
      localObject1 = this.Cv;
      label68:
      setText((CharSequence)localObject1);
      localObject1 = this.dZ.getContentDescription();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label159;
      }
      if (i == 0) {
        break label147;
      }
      localObject1 = null;
      label98:
      setContentDescription((CharSequence)localObject1);
      label104:
      localObject1 = this.dZ.getTooltipText();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label180;
      }
      if (i == 0) {
        break label168;
      }
    }
    label141:
    label147:
    label159:
    label168:
    for (Object localObject1 = localObject2;; localObject1 = this.dZ.getTitle())
    {
      bb.a(this, (CharSequence)localObject1);
      return;
      i = 0;
      break;
      localObject1 = null;
      break label68;
      localObject1 = this.dZ.getTitle();
      break label98;
      setContentDescription((CharSequence)localObject1);
      break label104;
    }
    label180:
    bb.a(this, (CharSequence)localObject1);
  }
  
  public final void a(j paramj)
  {
    this.dZ = paramj;
    setIcon(paramj.getIcon());
    setTitle(paramj.a(this));
    setId(paramj.getItemId());
    if (paramj.isVisible()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      setEnabled(paramj.isEnabled());
      if ((paramj.hasSubMenu()) && (this.UV == null)) {
        this.UV = new a();
      }
      return;
    }
  }
  
  public final boolean aE()
  {
    return true;
  }
  
  public final boolean fJ()
  {
    return (hasText()) && (this.dZ.getIcon() == null);
  }
  
  public final boolean fK()
  {
    return hasText();
  }
  
  public j getItemData()
  {
    return this.dZ;
  }
  
  public final boolean hasText()
  {
    return !TextUtils.isEmpty(getText());
  }
  
  public void onClick(View paramView)
  {
    if (this.UU != null) {
      this.UU.f(this.dZ);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.UX = fH();
    fI();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = hasText();
    if ((bool) && (this.UZ >= 0)) {
      super.setPadding(this.UZ, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = getMeasuredWidth();
    if (i == -2147483648) {}
    for (paramInt1 = Math.min(paramInt1, this.mMinWidth);; paramInt1 = this.mMinWidth)
    {
      if ((i != 1073741824) && (this.mMinWidth > 0) && (j < paramInt1)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
      }
      if ((!bool) && (this.la != null)) {
        super.setPadding((getMeasuredWidth() - this.la.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      }
      return;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(null);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.dZ.hasSubMenu()) && (this.UV != null) && (this.UV.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    if (this.UY != paramBoolean)
    {
      this.UY = paramBoolean;
      if (this.dZ != null) {
        this.dZ.eq.ga();
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.la = paramDrawable;
    if (paramDrawable != null)
    {
      int m = paramDrawable.getIntrinsicWidth();
      int k = paramDrawable.getIntrinsicHeight();
      int j = k;
      int i = m;
      float f;
      if (m > this.Va)
      {
        f = this.Va / m;
        i = this.Va;
        j = (int)(k * f);
      }
      m = j;
      k = i;
      if (j > this.Va)
      {
        f = this.Va / j;
        m = this.Va;
        k = (int)(i * f);
      }
      paramDrawable.setBounds(0, 0, k, m);
    }
    setCompoundDrawables(paramDrawable, null, null, null);
    fI();
  }
  
  public void setItemInvoker(h.b paramb)
  {
    this.UU = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.UZ = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(b paramb)
  {
    this.UW = paramb;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.Cv = paramCharSequence;
    fI();
  }
  
  final class a
    extends ab
  {
    public a()
    {
      super();
    }
    
    public final s fL()
    {
      if (ActionMenuItemView.this.UW != null) {
        return ActionMenuItemView.this.UW.fL();
      }
      return null;
    }
    
    public final boolean fM()
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (ActionMenuItemView.this.UU != null)
      {
        bool1 = bool2;
        if (ActionMenuItemView.this.UU.f(ActionMenuItemView.this.dZ))
        {
          s locals = fL();
          bool1 = bool2;
          if (locals != null)
          {
            bool1 = bool2;
            if (locals.isShowing()) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
  }
  
  public static abstract class b
  {
    public abstract s fL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ActionMenuItemView
 * JD-Core Version:    0.7.0.1
 */