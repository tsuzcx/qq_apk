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
  private static final int[] hY = { 16842912 };
  private ColorStateList fI;
  private final int hZ;
  private float ia;
  private float ib;
  private float ic;
  private int ie;
  private boolean jdField_if;
  private ImageView ig;
  private final TextView ih;
  private final TextView ii;
  private int ij = -1;
  private j ik;
  
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
    LayoutInflater.from(paramContext).inflate(2131493692, this, true);
    setBackgroundResource(2131231891);
    this.hZ = paramAttributeSet.getDimensionPixelSize(2131166101);
    this.ig = ((ImageView)findViewById(2131300874));
    this.ih = ((TextView)findViewById(2131304841));
    this.ii = ((TextView)findViewById(2131301309));
    t.p(this.ih, 2);
    t.p(this.ii, 2);
    setFocusable(true);
    b(this.ih.getTextSize(), this.ii.getTextSize());
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
    this.ia = (paramFloat1 - paramFloat2);
    this.ib = (1.0F * paramFloat2 / paramFloat1);
    this.ic = (1.0F * paramFloat1 / paramFloat2);
  }
  
  public final void a(j paramj)
  {
    this.ik = paramj;
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
  
  public final boolean bl()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.ik;
  }
  
  public int getItemPosition()
  {
    return this.ij;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.ik != null) && (this.ik.isCheckable()) && (this.ik.isChecked())) {
      mergeDrawableStates(arrayOfInt, hY);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.ii.setPivotX(this.ii.getWidth() / 2);
    this.ii.setPivotY(this.ii.getBaseline());
    this.ih.setPivotX(this.ih.getWidth() / 2);
    this.ih.setPivotY(this.ih.getBaseline());
    switch (this.ie)
    {
    }
    for (;;)
    {
      refreshDrawableState();
      setSelected(paramBoolean);
      return;
      if (this.jdField_if)
      {
        if (paramBoolean)
        {
          a(this.ig, this.hZ, 49);
          a(this.ii, 1.0F, 1.0F, 0);
        }
        for (;;)
        {
          this.ih.setVisibility(4);
          break;
          a(this.ig, this.hZ, 17);
          a(this.ii, 0.5F, 0.5F, 4);
        }
      }
      if (paramBoolean)
      {
        a(this.ig, (int)(this.hZ + this.ia), 49);
        a(this.ii, 1.0F, 1.0F, 0);
        a(this.ih, this.ib, this.ib, 4);
      }
      else
      {
        a(this.ig, this.hZ, 49);
        a(this.ii, this.ic, this.ic, 4);
        a(this.ih, 1.0F, 1.0F, 0);
        continue;
        if (paramBoolean)
        {
          a(this.ig, this.hZ, 49);
          a(this.ii, 1.0F, 1.0F, 0);
        }
        for (;;)
        {
          this.ih.setVisibility(4);
          break;
          a(this.ig, this.hZ, 17);
          a(this.ii, 0.5F, 0.5F, 4);
        }
        if (paramBoolean)
        {
          a(this.ig, (int)(this.hZ + this.ia), 49);
          a(this.ii, 1.0F, 1.0F, 0);
          a(this.ih, this.ib, this.ib, 4);
        }
        else
        {
          a(this.ig, this.hZ, 49);
          a(this.ii, this.ic, this.ic, 4);
          a(this.ih, 1.0F, 1.0F, 0);
          continue;
          a(this.ig, this.hZ, 17);
          this.ii.setVisibility(8);
          this.ih.setVisibility(8);
        }
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.ih.setEnabled(paramBoolean);
    this.ii.setEnabled(paramBoolean);
    this.ig.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      t.a(this, r.W(getContext()));
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
      localObject = a.i(paramDrawable).mutate();
      a.a((Drawable)localObject, this.fI);
      this.ig.setImageDrawable((Drawable)localObject);
      return;
      label40:
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
    }
  }
  
  public void setIconSize(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ig.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.ig.setLayoutParams(localLayoutParams);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.fI = paramColorStateList;
    if (this.ik != null) {
      setIcon(this.ik.getIcon());
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
    t.a(this, paramDrawable);
  }
  
  public void setItemPosition(int paramInt)
  {
    this.ij = paramInt;
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.ie != paramInt)
    {
      this.ie = paramInt;
      if (this.ik == null) {
        break label38;
      }
    }
    label38:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        setChecked(this.ik.isChecked());
      }
      return;
    }
  }
  
  public void setShifting(boolean paramBoolean)
  {
    if (this.jdField_if != paramBoolean)
    {
      this.jdField_if = paramBoolean;
      if (this.ik == null) {
        break label38;
      }
    }
    label38:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        setChecked(this.ik.isChecked());
      }
      return;
    }
  }
  
  public void setTextAppearanceActive(int paramInt)
  {
    q.d(this.ii, paramInt);
    b(this.ih.getTextSize(), this.ii.getTextSize());
  }
  
  public void setTextAppearanceInactive(int paramInt)
  {
    q.d(this.ih, paramInt);
    b(this.ih.getTextSize(), this.ii.getTextSize());
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      this.ih.setTextColor(paramColorStateList);
      this.ii.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.ih.setText(paramCharSequence);
    this.ii.setText(paramCharSequence);
    if ((this.ik == null) || (TextUtils.isEmpty(this.ik.getContentDescription()))) {
      setContentDescription(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationItemView
 * JD-Core Version:    0.7.0.1
 */