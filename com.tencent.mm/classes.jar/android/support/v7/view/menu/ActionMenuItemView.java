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
  private CharSequence Eo;
  private Drawable Uy;
  j abX;
  h.b abY;
  private ab abZ;
  b aca;
  private boolean acb;
  private boolean acc;
  private int acd;
  private int ace;
  private int mMinWidth;
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    this.acb = hd();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ActionMenuItemView, paramInt, 0);
    this.mMinWidth = paramContext.getDimensionPixelSize(0, 0);
    paramContext.recycle();
    this.ace = ((int)(localResources.getDisplayMetrics().density * 32.0F + 0.5F));
    setOnClickListener(this);
    this.acd = -1;
    setSaveEnabled(false);
  }
  
  private boolean hd()
  {
    Configuration localConfiguration = getContext().getResources().getConfiguration();
    int i = localConfiguration.screenWidthDp;
    int j = localConfiguration.screenHeightDp;
    return (i >= 480) || ((i >= 640) && (j >= 480)) || (localConfiguration.orientation == 2);
  }
  
  private void he()
  {
    int k = 0;
    Object localObject2 = null;
    int i;
    if (!TextUtils.isEmpty(this.Eo))
    {
      i = 1;
      if (this.Uy != null)
      {
        j = k;
        if (!this.abX.hJ()) {
          break label54;
        }
        if (!this.acb)
        {
          j = k;
          if (!this.acc) {
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
      localObject1 = this.Eo;
      label68:
      setText((CharSequence)localObject1);
      localObject1 = this.abX.getContentDescription();
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
      localObject1 = this.abX.getTooltipText();
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
    for (Object localObject1 = localObject2;; localObject1 = this.abX.getTitle())
    {
      bb.a(this, (CharSequence)localObject1);
      return;
      i = 0;
      break;
      localObject1 = null;
      break label68;
      localObject1 = this.abX.getTitle();
      break label98;
      setContentDescription((CharSequence)localObject1);
      break label104;
    }
    label180:
    bb.a(this, (CharSequence)localObject1);
  }
  
  public final void a(j paramj)
  {
    this.abX = paramj;
    setIcon(paramj.getIcon());
    setTitle(paramj.a(this));
    setId(paramj.getItemId());
    if (paramj.isVisible()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      setEnabled(paramj.isEnabled());
      if ((paramj.hasSubMenu()) && (this.abZ == null)) {
        this.abZ = new a();
      }
      return;
    }
  }
  
  public final boolean be()
  {
    return true;
  }
  
  public j getItemData()
  {
    return this.abX;
  }
  
  public final boolean hasText()
  {
    return !TextUtils.isEmpty(getText());
  }
  
  public final boolean hf()
  {
    return (hasText()) && (this.abX.getIcon() == null);
  }
  
  public final boolean hg()
  {
    return hasText();
  }
  
  public void onClick(View paramView)
  {
    if (this.abY != null) {
      this.abY.f(this.abX);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.acb = hd();
    he();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = hasText();
    if ((bool) && (this.acd >= 0)) {
      super.setPadding(this.acd, getPaddingTop(), getPaddingRight(), getPaddingBottom());
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
      if ((!bool) && (this.Uy != null)) {
        super.setPadding((getMeasuredWidth() - this.Uy.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
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
    if ((this.abX.hasSubMenu()) && (this.abZ != null) && (this.abZ.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    if (this.acc != paramBoolean)
    {
      this.acc = paramBoolean;
      if (this.abX != null) {
        this.abX.XT.hw();
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.Uy = paramDrawable;
    if (paramDrawable != null)
    {
      int m = paramDrawable.getIntrinsicWidth();
      int k = paramDrawable.getIntrinsicHeight();
      int j = k;
      int i = m;
      float f;
      if (m > this.ace)
      {
        f = this.ace / m;
        i = this.ace;
        j = (int)(k * f);
      }
      m = j;
      k = i;
      if (j > this.ace)
      {
        f = this.ace / j;
        m = this.ace;
        k = (int)(i * f);
      }
      paramDrawable.setBounds(0, 0, k, m);
    }
    setCompoundDrawables(paramDrawable, null, null, null);
    he();
  }
  
  public void setItemInvoker(h.b paramb)
  {
    this.abY = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.acd = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(b paramb)
  {
    this.aca = paramb;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.Eo = paramCharSequence;
    he();
  }
  
  final class a
    extends ab
  {
    public a()
    {
      super();
    }
    
    public final s hh()
    {
      if (ActionMenuItemView.this.aca != null) {
        return ActionMenuItemView.this.aca.hh();
      }
      return null;
    }
    
    public final boolean hi()
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (ActionMenuItemView.this.abY != null)
      {
        bool1 = bool2;
        if (ActionMenuItemView.this.abY.f(ActionMenuItemView.this.abX))
        {
          s locals = hh();
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
    public abstract s hh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ActionMenuItemView
 * JD-Core Version:    0.7.0.1
 */