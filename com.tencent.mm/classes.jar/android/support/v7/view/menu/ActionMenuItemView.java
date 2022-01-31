package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.a.a.j;
import android.support.v7.widget.ActionMenuView.a;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ac;
import android.support.v7.widget.az;
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
  private CharSequence BM;
  h.b Ui;
  private ac Uj;
  b Uk;
  private boolean Ul;
  private boolean Um;
  private int Un;
  private int Uo;
  private int Up;
  j cV;
  private Drawable kc;
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    this.Ul = eT();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ActionMenuItemView, paramInt, 0);
    this.Un = paramContext.getDimensionPixelSize(a.j.ActionMenuItemView_android_minWidth, 0);
    paramContext.recycle();
    this.Up = ((int)(localResources.getDisplayMetrics().density * 32.0F + 0.5F));
    setOnClickListener(this);
    this.Uo = -1;
    setSaveEnabled(false);
  }
  
  private boolean eT()
  {
    Configuration localConfiguration = getContext().getResources().getConfiguration();
    int i = localConfiguration.screenWidthDp;
    int j = localConfiguration.screenHeightDp;
    return (i >= 480) || ((i >= 640) && (j >= 480)) || (localConfiguration.orientation == 2);
  }
  
  private void eU()
  {
    Object localObject2 = null;
    int m = 0;
    int i;
    int j;
    if (!TextUtils.isEmpty(this.BM))
    {
      i = 1;
      if (this.kc != null)
      {
        if ((this.cV.VW & 0x4) != 4) {
          break label153;
        }
        j = 1;
        label40:
        k = m;
        if (j == 0) {
          break label66;
        }
        if (!this.Ul)
        {
          k = m;
          if (!this.Um) {
            break label66;
          }
        }
      }
      int k = 1;
      label66:
      i &= k;
      if (i == 0) {
        break label158;
      }
      localObject1 = this.BM;
      label80:
      setText((CharSequence)localObject1);
      localObject1 = this.cV.getContentDescription();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label176;
      }
      if (i == 0) {
        break label164;
      }
      localObject1 = null;
      label110:
      setContentDescription((CharSequence)localObject1);
      label116:
      localObject1 = this.cV.getTooltipText();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label197;
      }
      if (i == 0) {
        break label185;
      }
    }
    label153:
    label158:
    label164:
    label176:
    label185:
    for (Object localObject1 = localObject2;; localObject1 = this.cV.getTitle())
    {
      az.a(this, (CharSequence)localObject1);
      return;
      i = 0;
      break;
      j = 0;
      break label40;
      localObject1 = null;
      break label80;
      localObject1 = this.cV.getTitle();
      break label110;
      setContentDescription((CharSequence)localObject1);
      break label116;
    }
    label197:
    az.a(this, (CharSequence)localObject1);
  }
  
  public final boolean T()
  {
    return true;
  }
  
  public final void a(j paramj)
  {
    this.cV = paramj;
    setIcon(paramj.getIcon());
    setTitle(paramj.a(this));
    setId(paramj.getItemId());
    if (paramj.isVisible()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      setEnabled(paramj.isEnabled());
      if ((paramj.hasSubMenu()) && (this.Uj == null)) {
        this.Uj = new a();
      }
      return;
    }
  }
  
  public final boolean eV()
  {
    return (hasText()) && (this.cV.getIcon() == null);
  }
  
  public final boolean eW()
  {
    return hasText();
  }
  
  public j getItemData()
  {
    return this.cV;
  }
  
  public final boolean hasText()
  {
    return !TextUtils.isEmpty(getText());
  }
  
  public void onClick(View paramView)
  {
    if (this.Ui != null) {
      this.Ui.f(this.cV);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.Ul = eT();
    eU();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = hasText();
    if ((bool) && (this.Uo >= 0)) {
      super.setPadding(this.Uo, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = getMeasuredWidth();
    if (i == -2147483648) {}
    for (paramInt1 = Math.min(paramInt1, this.Un);; paramInt1 = this.Un)
    {
      if ((i != 1073741824) && (this.Un > 0) && (j < paramInt1)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
      }
      if ((!bool) && (this.kc != null)) {
        super.setPadding((getMeasuredWidth() - this.kc.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
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
    if ((this.cV.hasSubMenu()) && (this.Uj != null) && (this.Uj.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    if (this.Um != paramBoolean)
    {
      this.Um = paramBoolean;
      if (this.cV != null) {
        this.cV.dm.fk();
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.kc = paramDrawable;
    if (paramDrawable != null)
    {
      int m = paramDrawable.getIntrinsicWidth();
      int k = paramDrawable.getIntrinsicHeight();
      int j = k;
      int i = m;
      float f;
      if (m > this.Up)
      {
        f = this.Up / m;
        i = this.Up;
        j = (int)(k * f);
      }
      m = j;
      k = i;
      if (j > this.Up)
      {
        f = this.Up / j;
        m = this.Up;
        k = (int)(i * f);
      }
      paramDrawable.setBounds(0, 0, k, m);
    }
    setCompoundDrawables(paramDrawable, null, null, null);
    eU();
  }
  
  public void setItemInvoker(h.b paramb)
  {
    this.Ui = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.Uo = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(b paramb)
  {
    this.Uk = paramb;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.BM = paramCharSequence;
    eU();
  }
  
  private final class a
    extends ac
  {
    public a()
    {
      super();
    }
    
    public final s eX()
    {
      if (ActionMenuItemView.this.Uk != null) {
        return ActionMenuItemView.this.Uk.eX();
      }
      return null;
    }
    
    protected final boolean eY()
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (ActionMenuItemView.this.Ui != null)
      {
        bool1 = bool2;
        if (ActionMenuItemView.this.Ui.f(ActionMenuItemView.this.cV))
        {
          s locals = eX();
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
    public abstract s eX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ActionMenuItemView
 * JD-Core Version:    0.7.0.1
 */