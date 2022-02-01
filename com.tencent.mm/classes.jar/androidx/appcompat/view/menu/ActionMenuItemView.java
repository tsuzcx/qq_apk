package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import androidx.appcompat.a.j;
import androidx.appcompat.widget.ActionMenuView.a;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ae;
import androidx.appcompat.widget.r;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ActionMenuItemView
  extends AppCompatTextView
  implements View.OnClickListener, p.a, ActionMenuView.a
{
  private CharSequence cZ;
  private Drawable eK;
  j ld;
  h.b le;
  private r lf;
  b lg;
  private boolean lh;
  private boolean li;
  private int lj;
  private int lk;
  private int ll;
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(239102);
    Resources localResources = paramContext.getResources();
    this.lh = bK();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ActionMenuItemView, paramInt, 0);
    this.lj = paramContext.getDimensionPixelSize(a.j.ActionMenuItemView_android_minWidth, 0);
    paramContext.recycle();
    this.ll = ((int)(localResources.getDisplayMetrics().density * 32.0F + 0.5F));
    setOnClickListener(this);
    this.lk = -1;
    setSaveEnabled(false);
    AppMethodBeat.o(239102);
  }
  
  private boolean bK()
  {
    AppMethodBeat.i(239106);
    Configuration localConfiguration = getContext().getResources().getConfiguration();
    int i = localConfiguration.screenWidthDp;
    int j = localConfiguration.screenHeightDp;
    if ((i >= 480) || ((i >= 640) && (j >= 480)) || (localConfiguration.orientation == 2))
    {
      AppMethodBeat.o(239106);
      return true;
    }
    AppMethodBeat.o(239106);
    return false;
  }
  
  private void bM()
  {
    int k = 0;
    Object localObject2 = null;
    AppMethodBeat.i(239119);
    int i;
    if (!TextUtils.isEmpty(this.cZ))
    {
      i = 1;
      if (this.eK != null)
      {
        j = k;
        if (!this.ld.ct()) {
          break label59;
        }
        if (!this.lh)
        {
          j = k;
          if (!this.li) {
            break label59;
          }
        }
      }
      int j = 1;
      label59:
      i &= j;
      if (i == 0) {
        break label151;
      }
      localObject1 = this.cZ;
      label73:
      setText((CharSequence)localObject1);
      localObject1 = this.ld.getContentDescription();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label169;
      }
      if (i == 0) {
        break label157;
      }
      localObject1 = null;
      label103:
      setContentDescription((CharSequence)localObject1);
      label109:
      localObject1 = this.ld.getTooltipText();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label190;
      }
      if (i == 0) {
        break label178;
      }
    }
    label151:
    label157:
    label169:
    label178:
    for (Object localObject1 = localObject2;; localObject1 = this.ld.getTitle())
    {
      ae.a(this, (CharSequence)localObject1);
      AppMethodBeat.o(239119);
      return;
      i = 0;
      break;
      localObject1 = null;
      break label73;
      localObject1 = this.ld.getTitle();
      break label103;
      setContentDescription((CharSequence)localObject1);
      break label109;
    }
    label190:
    ae.a(this, (CharSequence)localObject1);
    AppMethodBeat.o(239119);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(239112);
    this.ld = paramj;
    setIcon(paramj.getIcon());
    setTitle(paramj.a(this));
    setId(paramj.getItemId());
    if (paramj.isVisible()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      setEnabled(paramj.isEnabled());
      if ((paramj.hasSubMenu()) && (this.lf == null)) {
        this.lf = new a();
      }
      AppMethodBeat.o(239112);
      return;
    }
  }
  
  public final boolean bL()
  {
    return true;
  }
  
  public final boolean bN()
  {
    AppMethodBeat.i(239121);
    if (!TextUtils.isEmpty(getText()))
    {
      AppMethodBeat.o(239121);
      return true;
    }
    AppMethodBeat.o(239121);
    return false;
  }
  
  public final boolean bO()
  {
    AppMethodBeat.i(239123);
    if ((bN()) && (this.ld.getIcon() == null))
    {
      AppMethodBeat.o(239123);
      return true;
    }
    AppMethodBeat.o(239123);
    return false;
  }
  
  public final boolean bP()
  {
    AppMethodBeat.i(239124);
    boolean bool = bN();
    AppMethodBeat.o(239124);
    return bool;
  }
  
  public j getItemData()
  {
    return this.ld;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(239115);
    if (this.le != null) {
      this.le.e(this.ld);
    }
    AppMethodBeat.o(239115);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(239104);
    super.onConfigurationChanged(paramConfiguration);
    this.lh = bK();
    bM();
    AppMethodBeat.o(239104);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239125);
    boolean bool = bN();
    if ((bool) && (this.lk >= 0)) {
      super.setPadding(this.lk, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = getMeasuredWidth();
    if (i == -2147483648) {}
    for (paramInt1 = Math.min(paramInt1, this.lj);; paramInt1 = this.lj)
    {
      if ((i != 1073741824) && (this.lj > 0) && (j < paramInt1)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
      }
      if ((!bool) && (this.eK != null)) {
        super.setPadding((getMeasuredWidth() - this.eK.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      }
      AppMethodBeat.o(239125);
      return;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(239127);
    super.onRestoreInstanceState(null);
    AppMethodBeat.o(239127);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(239113);
    if ((this.ld.hasSubMenu()) && (this.lf != null) && (this.lf.onTouch(this, paramMotionEvent)))
    {
      AppMethodBeat.o(239113);
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(239113);
    return bool;
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    AppMethodBeat.i(239118);
    if (this.li != paramBoolean)
    {
      this.li = paramBoolean;
      if (this.ld != null) {
        this.ld.is.ch();
      }
    }
    AppMethodBeat.o(239118);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(239120);
    this.eK = paramDrawable;
    if (paramDrawable != null)
    {
      int m = paramDrawable.getIntrinsicWidth();
      int k = paramDrawable.getIntrinsicHeight();
      int j = k;
      int i = m;
      float f;
      if (m > this.ll)
      {
        f = this.ll / m;
        i = this.ll;
        j = (int)(k * f);
      }
      m = j;
      k = i;
      if (j > this.ll)
      {
        f = this.ll / j;
        m = this.ll;
        k = (int)(i * f);
      }
      paramDrawable.setBounds(0, 0, k, m);
    }
    setCompoundDrawables(paramDrawable, null, null, null);
    bM();
    AppMethodBeat.o(239120);
  }
  
  public void setItemInvoker(h.b paramb)
  {
    this.le = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(239108);
    this.lk = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(239108);
  }
  
  public void setPopupCallback(b paramb)
  {
    this.lg = paramb;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239122);
    this.cZ = paramCharSequence;
    bM();
    AppMethodBeat.o(239122);
  }
  
  final class a
    extends r
  {
    public a()
    {
      super();
    }
    
    public final s bQ()
    {
      AppMethodBeat.i(239097);
      if (ActionMenuItemView.this.lg != null)
      {
        s locals = ActionMenuItemView.this.lg.bQ();
        AppMethodBeat.o(239097);
        return locals;
      }
      AppMethodBeat.o(239097);
      return null;
    }
    
    public final boolean bR()
    {
      AppMethodBeat.i(239098);
      if ((ActionMenuItemView.this.le != null) && (ActionMenuItemView.this.le.e(ActionMenuItemView.this.ld)))
      {
        s locals = bQ();
        if ((locals != null) && (locals.isShowing()))
        {
          AppMethodBeat.o(239098);
          return true;
        }
        AppMethodBeat.o(239098);
        return false;
      }
      AppMethodBeat.o(239098);
      return false;
    }
  }
  
  public static abstract class b
  {
    public abstract s bQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.ActionMenuItemView
 * JD-Core Version:    0.7.0.1
 */