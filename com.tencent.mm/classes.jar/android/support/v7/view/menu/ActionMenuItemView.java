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
  private CharSequence Hd;
  private Drawable Xj;
  j aeI;
  h.b aeJ;
  private ab aeK;
  b aeL;
  private boolean aeM;
  private boolean aeN;
  private int aeO;
  private int aeP;
  private int mMinWidth;
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    this.aeM = hB();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ActionMenuItemView, paramInt, 0);
    this.mMinWidth = paramContext.getDimensionPixelSize(0, 0);
    paramContext.recycle();
    this.aeP = ((int)(localResources.getDisplayMetrics().density * 32.0F + 0.5F));
    setOnClickListener(this);
    this.aeO = -1;
    setSaveEnabled(false);
  }
  
  private boolean hB()
  {
    Configuration localConfiguration = getContext().getResources().getConfiguration();
    int i = localConfiguration.screenWidthDp;
    int j = localConfiguration.screenHeightDp;
    return (i >= 480) || ((i >= 640) && (j >= 480)) || (localConfiguration.orientation == 2);
  }
  
  private void hC()
  {
    int k = 0;
    Object localObject2 = null;
    int i;
    if (!TextUtils.isEmpty(this.Hd))
    {
      i = 1;
      if (this.Xj != null)
      {
        j = k;
        if (!this.aeI.ii()) {
          break label54;
        }
        if (!this.aeM)
        {
          j = k;
          if (!this.aeN) {
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
      localObject1 = this.Hd;
      label68:
      setText((CharSequence)localObject1);
      localObject1 = this.aeI.getContentDescription();
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
      localObject1 = this.aeI.getTooltipText();
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
    for (Object localObject1 = localObject2;; localObject1 = this.aeI.getTitle())
    {
      bb.a(this, (CharSequence)localObject1);
      return;
      i = 0;
      break;
      localObject1 = null;
      break label68;
      localObject1 = this.aeI.getTitle();
      break label98;
      setContentDescription((CharSequence)localObject1);
      break label104;
    }
    label180:
    bb.a(this, (CharSequence)localObject1);
  }
  
  public final void a(j paramj)
  {
    this.aeI = paramj;
    setIcon(paramj.getIcon());
    setTitle(paramj.a(this));
    setId(paramj.getItemId());
    if (paramj.isVisible()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      setEnabled(paramj.isEnabled());
      if ((paramj.hasSubMenu()) && (this.aeK == null)) {
        this.aeK = new a();
      }
      return;
    }
  }
  
  public final boolean bA()
  {
    return true;
  }
  
  public j getItemData()
  {
    return this.aeI;
  }
  
  public final boolean hD()
  {
    return (hasText()) && (this.aeI.getIcon() == null);
  }
  
  public final boolean hE()
  {
    return hasText();
  }
  
  public final boolean hasText()
  {
    return !TextUtils.isEmpty(getText());
  }
  
  public void onClick(View paramView)
  {
    if (this.aeJ != null) {
      this.aeJ.f(this.aeI);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.aeM = hB();
    hC();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = hasText();
    if ((bool) && (this.aeO >= 0)) {
      super.setPadding(this.aeO, getPaddingTop(), getPaddingRight(), getPaddingBottom());
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
      if ((!bool) && (this.Xj != null)) {
        super.setPadding((getMeasuredWidth() - this.Xj.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
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
    if ((this.aeI.hasSubMenu()) && (this.aeK != null) && (this.aeK.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    if (this.aeN != paramBoolean)
    {
      this.aeN = paramBoolean;
      if (this.aeI != null) {
        this.aeI.aaD.hU();
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.Xj = paramDrawable;
    if (paramDrawable != null)
    {
      int m = paramDrawable.getIntrinsicWidth();
      int k = paramDrawable.getIntrinsicHeight();
      int j = k;
      int i = m;
      float f;
      if (m > this.aeP)
      {
        f = this.aeP / m;
        i = this.aeP;
        j = (int)(k * f);
      }
      m = j;
      k = i;
      if (j > this.aeP)
      {
        f = this.aeP / j;
        m = this.aeP;
        k = (int)(i * f);
      }
      paramDrawable.setBounds(0, 0, k, m);
    }
    setCompoundDrawables(paramDrawable, null, null, null);
    hC();
  }
  
  public void setItemInvoker(h.b paramb)
  {
    this.aeJ = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.aeO = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(b paramb)
  {
    this.aeL = paramb;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.Hd = paramCharSequence;
    hC();
  }
  
  final class a
    extends ab
  {
    public a()
    {
      super();
    }
    
    public final s hF()
    {
      if (ActionMenuItemView.this.aeL != null) {
        return ActionMenuItemView.this.aeL.hF();
      }
      return null;
    }
    
    public final boolean hG()
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (ActionMenuItemView.this.aeJ != null)
      {
        bool1 = bool2;
        if (ActionMenuItemView.this.aeJ.f(ActionMenuItemView.this.aeI))
        {
          s locals = hF();
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
    public abstract s hF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ActionMenuItemView
 * JD-Core Version:    0.7.0.1
 */