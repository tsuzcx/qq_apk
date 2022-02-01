package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.content.b;
import android.support.v4.graphics.drawable.a;
import android.support.v4.view.r;
import android.support.v4.view.u;
import android.support.v4.widget.q;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p.a;
import android.support.v7.widget.bb;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

public class BottomNavigationItemView
  extends FrameLayout
  implements p.a
{
  private static final int[] jV = { 16842912 };
  private ColorStateList hB;
  private final int jW;
  private float jX;
  private float jY;
  private float jZ;
  private int ka;
  private boolean kb;
  private ImageView kc;
  private final TextView kd;
  private final TextView ke;
  private int kf = -1;
  private j kg;
  
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
    LayoutInflater.from(paramContext).inflate(2131493823, this, true);
    setBackgroundResource(2131231974);
    this.jW = paramAttributeSet.getDimensionPixelSize(2131166142);
    this.kc = ((ImageView)findViewById(2131302468));
    this.kd = ((TextView)findViewById(2131307927));
    this.ke = ((TextView)findViewById(2131303007));
    u.p(this.kd, 2);
    u.p(this.ke, 2);
    setFocusable(true);
    b(this.kd.getTextSize(), this.ke.getTextSize());
  }
  
  private static void a(View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    paramView.setScaleX(paramFloat1);
    paramView.setScaleY(paramFloat2);
    paramView.setVisibility(paramInt);
  }
  
  private static void a(View paramView, int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin = paramInt1;
    localLayoutParams.gravity = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    this.jX = (paramFloat1 - paramFloat2);
    this.jY = (1.0F * paramFloat2 / paramFloat1);
    this.jZ = (1.0F * paramFloat1 / paramFloat2);
  }
  
  public final void a(j paramj)
  {
    this.kg = paramj;
    setCheckable(paramj.isCheckable());
    setChecked(paramj.isChecked());
    setEnabled(paramj.isEnabled());
    setIcon(paramj.getIcon());
    setTitle(paramj.getTitle());
    setId(paramj.getItemId());
    if (!TextUtils.isEmpty(paramj.getContentDescription())) {
      setContentDescription(paramj.getContentDescription());
    }
    bb.a(this, paramj.getTooltipText());
    if (paramj.isVisible()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      return;
    }
  }
  
  public final boolean bC()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.kg;
  }
  
  public int getItemPosition()
  {
    return this.kf;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.kg != null) && (this.kg.isCheckable()) && (this.kg.isChecked())) {
      mergeDrawableStates(arrayOfInt, jV);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.ke.setPivotX(this.ke.getWidth() / 2);
    this.ke.setPivotY(this.ke.getBaseline());
    this.kd.setPivotX(this.kd.getWidth() / 2);
    this.kd.setPivotY(this.kd.getBaseline());
    switch (this.ka)
    {
    }
    for (;;)
    {
      refreshDrawableState();
      setSelected(paramBoolean);
      return;
      if (this.kb)
      {
        if (paramBoolean)
        {
          a(this.kc, this.jW, 49);
          a(this.ke, 1.0F, 1.0F, 0);
        }
        for (;;)
        {
          this.kd.setVisibility(4);
          break;
          a(this.kc, this.jW, 17);
          a(this.ke, 0.5F, 0.5F, 4);
        }
      }
      if (paramBoolean)
      {
        a(this.kc, (int)(this.jW + this.jX), 49);
        a(this.ke, 1.0F, 1.0F, 0);
        a(this.kd, this.jY, this.jY, 4);
      }
      else
      {
        a(this.kc, this.jW, 49);
        a(this.ke, this.jZ, this.jZ, 4);
        a(this.kd, 1.0F, 1.0F, 0);
        continue;
        if (paramBoolean)
        {
          a(this.kc, this.jW, 49);
          a(this.ke, 1.0F, 1.0F, 0);
        }
        for (;;)
        {
          this.kd.setVisibility(4);
          break;
          a(this.kc, this.jW, 17);
          a(this.ke, 0.5F, 0.5F, 4);
        }
        if (paramBoolean)
        {
          a(this.kc, (int)(this.jW + this.jX), 49);
          a(this.ke, 1.0F, 1.0F, 0);
          a(this.kd, this.jY, this.jY, 4);
        }
        else
        {
          a(this.kc, this.jW, 49);
          a(this.ke, this.jZ, this.jZ, 4);
          a(this.kd, 1.0F, 1.0F, 0);
          continue;
          a(this.kc, this.jW, 17);
          this.ke.setVisibility(8);
          this.kd.setVisibility(8);
        }
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.kd.setEnabled(paramBoolean);
    this.ke.setEnabled(paramBoolean);
    this.kc.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      u.a(this, r.Y(getContext()));
      return;
    }
    u.a(this, null);
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
      localObject = a.i(paramDrawable).mutate();
      a.a((Drawable)localObject, this.hB);
      this.kc.setImageDrawable((Drawable)localObject);
      return;
      label40:
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
    }
  }
  
  public void setIconSize(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kc.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.kc.setLayoutParams(localLayoutParams);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.hB = paramColorStateList;
    if (this.kg != null) {
      setIcon(this.kg.getIcon());
    }
  }
  
  public void setItemBackground(int paramInt)
  {
    if (paramInt == 0) {}
    for (Drawable localDrawable = null;; localDrawable = b.l(getContext(), paramInt))
    {
      setItemBackground(localDrawable);
      return;
    }
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    u.a(this, paramDrawable);
  }
  
  public void setItemPosition(int paramInt)
  {
    this.kf = paramInt;
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.ka != paramInt)
    {
      this.ka = paramInt;
      if (this.kg == null) {
        break label38;
      }
    }
    label38:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        setChecked(this.kg.isChecked());
      }
      return;
    }
  }
  
  public void setShifting(boolean paramBoolean)
  {
    if (this.kb != paramBoolean)
    {
      this.kb = paramBoolean;
      if (this.kg == null) {
        break label38;
      }
    }
    label38:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        setChecked(this.kg.isChecked());
      }
      return;
    }
  }
  
  public void setTextAppearanceActive(int paramInt)
  {
    q.d(this.ke, paramInt);
    b(this.kd.getTextSize(), this.ke.getTextSize());
  }
  
  public void setTextAppearanceInactive(int paramInt)
  {
    q.d(this.kd, paramInt);
    b(this.kd.getTextSize(), this.ke.getTextSize());
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      this.kd.setTextColor(paramColorStateList);
      this.ke.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.kd.setText(paramCharSequence);
    this.ke.setText(paramCharSequence);
    if ((this.kg == null) || (TextUtils.isEmpty(this.kg.getContentDescription()))) {
      setContentDescription(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationItemView
 * JD-Core Version:    0.7.0.1
 */