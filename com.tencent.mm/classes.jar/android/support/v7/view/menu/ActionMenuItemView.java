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
  private CharSequence Hn;
  private Drawable Xw;
  j aeV;
  h.b aeW;
  private ab aeX;
  b aeY;
  private boolean aeZ;
  private boolean afa;
  private int afb;
  private int afc;
  private int mMinWidth;
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    this.aeZ = hK();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ActionMenuItemView, paramInt, 0);
    this.mMinWidth = paramContext.getDimensionPixelSize(0, 0);
    paramContext.recycle();
    this.afc = ((int)(localResources.getDisplayMetrics().density * 32.0F + 0.5F));
    setOnClickListener(this);
    this.afb = -1;
    setSaveEnabled(false);
  }
  
  private boolean hK()
  {
    Configuration localConfiguration = getContext().getResources().getConfiguration();
    int i = localConfiguration.screenWidthDp;
    int j = localConfiguration.screenHeightDp;
    return (i >= 480) || ((i >= 640) && (j >= 480)) || (localConfiguration.orientation == 2);
  }
  
  private void hL()
  {
    int k = 0;
    Object localObject2 = null;
    int i;
    if (!TextUtils.isEmpty(this.Hn))
    {
      i = 1;
      if (this.Xw != null)
      {
        j = k;
        if (!this.aeV.is()) {
          break label54;
        }
        if (!this.aeZ)
        {
          j = k;
          if (!this.afa) {
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
      localObject1 = this.Hn;
      label68:
      setText((CharSequence)localObject1);
      localObject1 = this.aeV.getContentDescription();
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
      localObject1 = this.aeV.getTooltipText();
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
    for (Object localObject1 = localObject2;; localObject1 = this.aeV.getTitle())
    {
      bb.a(this, (CharSequence)localObject1);
      return;
      i = 0;
      break;
      localObject1 = null;
      break label68;
      localObject1 = this.aeV.getTitle();
      break label98;
      setContentDescription((CharSequence)localObject1);
      break label104;
    }
    label180:
    bb.a(this, (CharSequence)localObject1);
  }
  
  public final void a(j paramj)
  {
    this.aeV = paramj;
    setIcon(paramj.getIcon());
    setTitle(paramj.a(this));
    setId(paramj.getItemId());
    if (paramj.isVisible()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      setEnabled(paramj.isEnabled());
      if ((paramj.hasSubMenu()) && (this.aeX == null)) {
        this.aeX = new a();
      }
      return;
    }
  }
  
  public final boolean bC()
  {
    return true;
  }
  
  public j getItemData()
  {
    return this.aeV;
  }
  
  public final boolean hM()
  {
    return (hasText()) && (this.aeV.getIcon() == null);
  }
  
  public final boolean hN()
  {
    return hasText();
  }
  
  public final boolean hasText()
  {
    return !TextUtils.isEmpty(getText());
  }
  
  public void onClick(View paramView)
  {
    if (this.aeW != null) {
      this.aeW.f(this.aeV);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.aeZ = hK();
    hL();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = hasText();
    if ((bool) && (this.afb >= 0)) {
      super.setPadding(this.afb, getPaddingTop(), getPaddingRight(), getPaddingBottom());
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
      if ((!bool) && (this.Xw != null)) {
        super.setPadding((getMeasuredWidth() - this.Xw.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
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
    if ((this.aeV.hasSubMenu()) && (this.aeX != null) && (this.aeX.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    if (this.afa != paramBoolean)
    {
      this.afa = paramBoolean;
      if (this.aeV != null) {
        this.aeV.aaQ.ie();
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.Xw = paramDrawable;
    if (paramDrawable != null)
    {
      int m = paramDrawable.getIntrinsicWidth();
      int k = paramDrawable.getIntrinsicHeight();
      int j = k;
      int i = m;
      float f;
      if (m > this.afc)
      {
        f = this.afc / m;
        i = this.afc;
        j = (int)(k * f);
      }
      m = j;
      k = i;
      if (j > this.afc)
      {
        f = this.afc / j;
        m = this.afc;
        k = (int)(i * f);
      }
      paramDrawable.setBounds(0, 0, k, m);
    }
    setCompoundDrawables(paramDrawable, null, null, null);
    hL();
  }
  
  public void setItemInvoker(h.b paramb)
  {
    this.aeW = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.afb = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(b paramb)
  {
    this.aeY = paramb;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.Hn = paramCharSequence;
    hL();
  }
  
  final class a
    extends ab
  {
    public a()
    {
      super();
    }
    
    public final s hO()
    {
      if (ActionMenuItemView.this.aeY != null) {
        return ActionMenuItemView.this.aeY.hO();
      }
      return null;
    }
    
    public final boolean hP()
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (ActionMenuItemView.this.aeW != null)
      {
        bool1 = bool2;
        if (ActionMenuItemView.this.aeW.f(ActionMenuItemView.this.aeV))
        {
          s locals = hO();
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
    public abstract s hO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ActionMenuItemView
 * JD-Core Version:    0.7.0.1
 */