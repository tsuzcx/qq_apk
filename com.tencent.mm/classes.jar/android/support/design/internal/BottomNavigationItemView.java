package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.design.a.d;
import android.support.design.a.e;
import android.support.design.a.f;
import android.support.design.a.h;
import android.support.v4.a.a.a;
import android.support.v4.content.b;
import android.support.v4.view.o;
import android.support.v4.view.q;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p.a;
import android.support.v7.widget.az;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

public class BottomNavigationItemView
  extends FrameLayout
  implements p.a
{
  private static final int[] cL = { 16842912 };
  private final int cM;
  private final int cN;
  private final float cO;
  private final float cP;
  private boolean cQ;
  private ImageView cR;
  private final TextView cS;
  private final TextView cT;
  private int cU = -1;
  private j cV;
  private ColorStateList cW;
  
  public BottomNavigationItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BottomNavigationItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = getResources();
    paramInt = paramAttributeSet.getDimensionPixelSize(a.d.design_bottom_navigation_text_size);
    int i = paramAttributeSet.getDimensionPixelSize(a.d.design_bottom_navigation_active_text_size);
    this.cM = paramAttributeSet.getDimensionPixelSize(a.d.design_bottom_navigation_margin);
    this.cN = (paramInt - i);
    this.cO = (i * 1.0F / paramInt);
    this.cP = (paramInt * 1.0F / i);
    LayoutInflater.from(paramContext).inflate(a.h.design_bottom_navigation_item, this, true);
    setBackgroundResource(a.e.design_bottom_navigation_item_background);
    this.cR = ((ImageView)findViewById(a.f.icon));
    this.cS = ((TextView)findViewById(a.f.smallLabel));
    this.cT = ((TextView)findViewById(a.f.largeLabel));
  }
  
  public final boolean T()
  {
    return false;
  }
  
  public final void a(j paramj)
  {
    this.cV = paramj;
    setCheckable(paramj.isCheckable());
    setChecked(paramj.isChecked());
    setEnabled(paramj.isEnabled());
    setIcon(paramj.getIcon());
    setTitle(paramj.getTitle());
    setId(paramj.getItemId());
    setContentDescription(paramj.getContentDescription());
    az.a(this, paramj.getTooltipText());
  }
  
  public j getItemData()
  {
    return this.cV;
  }
  
  public int getItemPosition()
  {
    return this.cU;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.cV != null) && (this.cV.isCheckable()) && (this.cV.isChecked())) {
      mergeDrawableStates(arrayOfInt, cL);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.cT.setPivotX(this.cT.getWidth() / 2);
    this.cT.setPivotY(this.cT.getBaseline());
    this.cS.setPivotX(this.cS.getWidth() / 2);
    this.cS.setPivotY(this.cS.getBaseline());
    FrameLayout.LayoutParams localLayoutParams;
    if (this.cQ) {
      if (paramBoolean)
      {
        localLayoutParams = (FrameLayout.LayoutParams)this.cR.getLayoutParams();
        localLayoutParams.gravity = 49;
        localLayoutParams.topMargin = this.cM;
        this.cR.setLayoutParams(localLayoutParams);
        this.cT.setVisibility(0);
        this.cT.setScaleX(1.0F);
        this.cT.setScaleY(1.0F);
        this.cS.setVisibility(4);
      }
    }
    for (;;)
    {
      refreshDrawableState();
      return;
      localLayoutParams = (FrameLayout.LayoutParams)this.cR.getLayoutParams();
      localLayoutParams.gravity = 17;
      localLayoutParams.topMargin = this.cM;
      this.cR.setLayoutParams(localLayoutParams);
      this.cT.setVisibility(4);
      this.cT.setScaleX(0.5F);
      this.cT.setScaleY(0.5F);
      break;
      if (paramBoolean)
      {
        localLayoutParams = (FrameLayout.LayoutParams)this.cR.getLayoutParams();
        localLayoutParams.gravity = 49;
        localLayoutParams.topMargin = (this.cM + this.cN);
        this.cR.setLayoutParams(localLayoutParams);
        this.cT.setVisibility(0);
        this.cS.setVisibility(4);
        this.cT.setScaleX(1.0F);
        this.cT.setScaleY(1.0F);
        this.cS.setScaleX(this.cO);
        this.cS.setScaleY(this.cO);
      }
      else
      {
        localLayoutParams = (FrameLayout.LayoutParams)this.cR.getLayoutParams();
        localLayoutParams.gravity = 49;
        localLayoutParams.topMargin = this.cM;
        this.cR.setLayoutParams(localLayoutParams);
        this.cT.setVisibility(4);
        this.cS.setVisibility(0);
        this.cT.setScaleX(this.cP);
        this.cT.setScaleY(this.cP);
        this.cS.setScaleX(1.0F);
        this.cS.setScaleY(1.0F);
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.cS.setEnabled(paramBoolean);
    this.cT.setEnabled(paramBoolean);
    this.cR.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      q.a(this, o.S(getContext()));
      return;
    }
    q.a(this, null);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable.getConstantState();
      if (localObject != null) {
        break label40;
      }
    }
    for (;;)
    {
      localObject = a.f(paramDrawable).mutate();
      a.a((Drawable)localObject, this.cW);
      this.cR.setImageDrawable((Drawable)localObject);
      return;
      label40:
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
    }
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.cW = paramColorStateList;
    if (this.cV != null) {
      setIcon(this.cV.getIcon());
    }
  }
  
  public void setItemBackground(int paramInt)
  {
    if (paramInt == 0) {}
    for (Drawable localDrawable = null;; localDrawable = b.g(getContext(), paramInt))
    {
      q.a(this, localDrawable);
      return;
    }
  }
  
  public void setItemPosition(int paramInt)
  {
    this.cU = paramInt;
  }
  
  public void setShiftingMode(boolean paramBoolean)
  {
    this.cQ = paramBoolean;
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.cS.setTextColor(paramColorStateList);
    this.cT.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.cS.setText(paramCharSequence);
    this.cT.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationItemView
 * JD-Core Version:    0.7.0.1
 */