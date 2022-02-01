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
  private Drawable fM;
  j lZ;
  h.b ma;
  private r mb;
  b mc;
  private boolean md;
  private boolean me;
  private int mf;
  private int mg;
  private int mh;
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200759);
    Resources localResources = paramContext.getResources();
    this.md = cD();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ActionMenuItemView, paramInt, 0);
    this.mf = paramContext.getDimensionPixelSize(a.j.ActionMenuItemView_android_minWidth, 0);
    paramContext.recycle();
    this.mh = ((int)(localResources.getDisplayMetrics().density * 32.0F + 0.5F));
    setOnClickListener(this);
    this.mg = -1;
    setSaveEnabled(false);
    AppMethodBeat.o(200759);
  }
  
  private boolean cD()
  {
    AppMethodBeat.i(200770);
    Configuration localConfiguration = getContext().getResources().getConfiguration();
    int i = localConfiguration.screenWidthDp;
    int j = localConfiguration.screenHeightDp;
    if ((i >= 480) || ((i >= 640) && (j >= 480)) || (localConfiguration.orientation == 2))
    {
      AppMethodBeat.o(200770);
      return true;
    }
    AppMethodBeat.o(200770);
    return false;
  }
  
  private void cF()
  {
    int k = 0;
    Object localObject2 = null;
    AppMethodBeat.i(200789);
    int i;
    if (!TextUtils.isEmpty(this.cZ))
    {
      i = 1;
      if (this.fM != null)
      {
        j = k;
        if (!this.lZ.dm()) {
          break label59;
        }
        if (!this.md)
        {
          j = k;
          if (!this.me) {
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
      localObject1 = this.lZ.getContentDescription();
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
      localObject1 = this.lZ.getTooltipText();
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
    for (Object localObject1 = localObject2;; localObject1 = this.lZ.getTitle())
    {
      ae.a(this, (CharSequence)localObject1);
      AppMethodBeat.o(200789);
      return;
      i = 0;
      break;
      localObject1 = null;
      break label73;
      localObject1 = this.lZ.getTitle();
      break label103;
      setContentDescription((CharSequence)localObject1);
      break label109;
    }
    label190:
    ae.a(this, (CharSequence)localObject1);
    AppMethodBeat.o(200789);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(200831);
    this.lZ = paramj;
    setIcon(paramj.getIcon());
    setTitle(paramj.a(this));
    setId(paramj.getItemId());
    if (paramj.isVisible()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      setEnabled(paramj.isEnabled());
      if ((paramj.hasSubMenu()) && (this.mb == null)) {
        this.mb = new a();
      }
      AppMethodBeat.o(200831);
      return;
    }
  }
  
  public final boolean cE()
  {
    return true;
  }
  
  public final boolean cG()
  {
    AppMethodBeat.i(200915);
    if (!TextUtils.isEmpty(getText()))
    {
      AppMethodBeat.o(200915);
      return true;
    }
    AppMethodBeat.o(200915);
    return false;
  }
  
  public final boolean cH()
  {
    AppMethodBeat.i(200933);
    if ((cG()) && (this.lZ.getIcon() == null))
    {
      AppMethodBeat.o(200933);
      return true;
    }
    AppMethodBeat.o(200933);
    return false;
  }
  
  public final boolean cI()
  {
    AppMethodBeat.i(200942);
    boolean bool = cG();
    AppMethodBeat.o(200942);
    return bool;
  }
  
  public j getItemData()
  {
    return this.lZ;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(200848);
    if (this.ma != null) {
      this.ma.e(this.lZ);
    }
    AppMethodBeat.o(200848);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(200800);
    super.onConfigurationChanged(paramConfiguration);
    this.md = cD();
    cF();
    AppMethodBeat.o(200800);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200952);
    boolean bool = cG();
    if ((bool) && (this.mg >= 0)) {
      super.setPadding(this.mg, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = getMeasuredWidth();
    if (i == -2147483648) {}
    for (paramInt1 = Math.min(paramInt1, this.mf);; paramInt1 = this.mf)
    {
      if ((i != 1073741824) && (this.mf > 0) && (j < paramInt1)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
      }
      if ((!bool) && (this.fM != null)) {
        super.setPadding((getMeasuredWidth() - this.fM.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      }
      AppMethodBeat.o(200952);
      return;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(200960);
    super.onRestoreInstanceState(null);
    AppMethodBeat.o(200960);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200840);
    if ((this.lZ.hasSubMenu()) && (this.mb != null) && (this.mb.onTouch(this, paramMotionEvent)))
    {
      AppMethodBeat.o(200840);
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(200840);
    return bool;
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    AppMethodBeat.i(200895);
    if (this.me != paramBoolean)
    {
      this.me = paramBoolean;
      if (this.lZ != null) {
        this.lZ.jo.da();
      }
    }
    AppMethodBeat.o(200895);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(200904);
    this.fM = paramDrawable;
    if (paramDrawable != null)
    {
      int m = paramDrawable.getIntrinsicWidth();
      int k = paramDrawable.getIntrinsicHeight();
      int j = k;
      int i = m;
      float f;
      if (m > this.mh)
      {
        f = this.mh / m;
        i = this.mh;
        j = (int)(k * f);
      }
      m = j;
      k = i;
      if (j > this.mh)
      {
        f = this.mh / j;
        m = this.mh;
        k = (int)(i * f);
      }
      paramDrawable.setBounds(0, 0, k, m);
    }
    setCompoundDrawables(paramDrawable, null, null, null);
    cF();
    AppMethodBeat.o(200904);
  }
  
  public void setItemInvoker(h.b paramb)
  {
    this.ma = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200811);
    this.mg = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(200811);
  }
  
  public void setPopupCallback(b paramb)
  {
    this.mc = paramb;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200924);
    this.cZ = paramCharSequence;
    cF();
    AppMethodBeat.o(200924);
  }
  
  final class a
    extends r
  {
    public a()
    {
      super();
    }
    
    public final s cJ()
    {
      AppMethodBeat.i(200772);
      if (ActionMenuItemView.this.mc != null)
      {
        s locals = ActionMenuItemView.this.mc.cJ();
        AppMethodBeat.o(200772);
        return locals;
      }
      AppMethodBeat.o(200772);
      return null;
    }
    
    public final boolean cK()
    {
      AppMethodBeat.i(200784);
      if ((ActionMenuItemView.this.ma != null) && (ActionMenuItemView.this.ma.e(ActionMenuItemView.this.lZ)))
      {
        s locals = cJ();
        if ((locals != null) && (locals.isShowing()))
        {
          AppMethodBeat.o(200784);
          return true;
        }
        AppMethodBeat.o(200784);
        return false;
      }
      AppMethodBeat.o(200784);
      return false;
    }
  }
  
  public static abstract class b
  {
    public abstract s cJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.menu.ActionMenuItemView
 * JD-Core Version:    0.7.0.1
 */