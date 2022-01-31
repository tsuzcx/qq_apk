package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.content.b;
import android.support.v4.graphics.drawable.a;
import android.support.v4.view.r;
import android.support.v4.view.t;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p.a;
import android.support.v7.widget.bb;
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
  private static final int[] dP = { 16842912 };
  private final int dQ;
  private final int dR;
  private final float dS;
  private final float dT;
  private boolean dU;
  private ImageView dV;
  private final TextView dW;
  private final TextView dX;
  private int dY = -1;
  private j dZ;
  private ColorStateList ea;
  
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
    paramInt = paramAttributeSet.getDimensionPixelSize(2131428286);
    int i = paramAttributeSet.getDimensionPixelSize(2131428279);
    this.dQ = paramAttributeSet.getDimensionPixelSize(2131428284);
    this.dR = (paramInt - i);
    this.dS = (i * 1.0F / paramInt);
    this.dT = (paramInt * 1.0F / i);
    LayoutInflater.from(paramContext).inflate(2130969304, this, true);
    setBackgroundResource(2130838505);
    this.dV = ((ImageView)findViewById(2131820929));
    this.dW = ((TextView)findViewById(2131823371));
    this.dX = ((TextView)findViewById(2131823372));
  }
  
  public final void a(j paramj)
  {
    this.dZ = paramj;
    setCheckable(paramj.isCheckable());
    setChecked(paramj.isChecked());
    setEnabled(paramj.isEnabled());
    setIcon(paramj.getIcon());
    setTitle(paramj.getTitle());
    setId(paramj.getItemId());
    setContentDescription(paramj.getContentDescription());
    bb.a(this, paramj.getTooltipText());
  }
  
  public final boolean aE()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.dZ;
  }
  
  public int getItemPosition()
  {
    return this.dY;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.dZ != null) && (this.dZ.isCheckable()) && (this.dZ.isChecked())) {
      mergeDrawableStates(arrayOfInt, dP);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.dX.setPivotX(this.dX.getWidth() / 2);
    this.dX.setPivotY(this.dX.getBaseline());
    this.dW.setPivotX(this.dW.getWidth() / 2);
    this.dW.setPivotY(this.dW.getBaseline());
    FrameLayout.LayoutParams localLayoutParams;
    if (this.dU) {
      if (paramBoolean)
      {
        localLayoutParams = (FrameLayout.LayoutParams)this.dV.getLayoutParams();
        localLayoutParams.gravity = 49;
        localLayoutParams.topMargin = this.dQ;
        this.dV.setLayoutParams(localLayoutParams);
        this.dX.setVisibility(0);
        this.dX.setScaleX(1.0F);
        this.dX.setScaleY(1.0F);
        this.dW.setVisibility(4);
      }
    }
    for (;;)
    {
      refreshDrawableState();
      return;
      localLayoutParams = (FrameLayout.LayoutParams)this.dV.getLayoutParams();
      localLayoutParams.gravity = 17;
      localLayoutParams.topMargin = this.dQ;
      this.dV.setLayoutParams(localLayoutParams);
      this.dX.setVisibility(4);
      this.dX.setScaleX(0.5F);
      this.dX.setScaleY(0.5F);
      break;
      if (paramBoolean)
      {
        localLayoutParams = (FrameLayout.LayoutParams)this.dV.getLayoutParams();
        localLayoutParams.gravity = 49;
        localLayoutParams.topMargin = (this.dQ + this.dR);
        this.dV.setLayoutParams(localLayoutParams);
        this.dX.setVisibility(0);
        this.dW.setVisibility(4);
        this.dX.setScaleX(1.0F);
        this.dX.setScaleY(1.0F);
        this.dW.setScaleX(this.dS);
        this.dW.setScaleY(this.dS);
      }
      else
      {
        localLayoutParams = (FrameLayout.LayoutParams)this.dV.getLayoutParams();
        localLayoutParams.gravity = 49;
        localLayoutParams.topMargin = this.dQ;
        this.dV.setLayoutParams(localLayoutParams);
        this.dX.setVisibility(4);
        this.dW.setVisibility(0);
        this.dX.setScaleX(this.dT);
        this.dX.setScaleY(this.dT);
        this.dW.setScaleX(1.0F);
        this.dW.setScaleY(1.0F);
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.dW.setEnabled(paramBoolean);
    this.dX.setEnabled(paramBoolean);
    this.dV.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      t.a(this, r.T(getContext()));
      return;
    }
    t.a(this, null);
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
      localObject = a.e(paramDrawable).mutate();
      a.a((Drawable)localObject, this.ea);
      this.dV.setImageDrawable((Drawable)localObject);
      return;
      label40:
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
    }
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.ea = paramColorStateList;
    if (this.dZ != null) {
      setIcon(this.dZ.getIcon());
    }
  }
  
  public void setItemBackground(int paramInt)
  {
    if (paramInt == 0) {}
    for (Drawable localDrawable = null;; localDrawable = b.k(getContext(), paramInt))
    {
      t.a(this, localDrawable);
      return;
    }
  }
  
  public void setItemPosition(int paramInt)
  {
    this.dY = paramInt;
  }
  
  public void setShiftingMode(boolean paramBoolean)
  {
    this.dU = paramBoolean;
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.dW.setTextColor(paramColorStateList);
    this.dX.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.dW.setText(paramCharSequence);
    this.dX.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationItemView
 * JD-Core Version:    0.7.0.1
 */