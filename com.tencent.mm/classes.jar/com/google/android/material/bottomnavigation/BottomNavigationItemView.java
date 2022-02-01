package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.p.a;
import androidx.appcompat.widget.ae;
import androidx.core.g.t;
import androidx.core.g.w;
import androidx.core.widget.i;
import com.google.android.material.a.d;
import com.google.android.material.a.e;
import com.google.android.material.a.f;
import com.google.android.material.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BottomNavigationItemView
  extends FrameLayout
  implements p.a
{
  private static final int[] wo = { 16842912 };
  private final int bwE;
  private float bwF;
  private float bwG;
  private float bwH;
  private boolean bwI;
  private ImageView bwJ;
  private final TextView bwK;
  private final TextView bwL;
  private int bwM;
  private j bwN;
  private ColorStateList bwO;
  private int labelVisibilityMode;
  
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
    AppMethodBeat.i(235072);
    this.bwM = -1;
    paramAttributeSet = getResources();
    LayoutInflater.from(paramContext).inflate(a.h.design_bottom_navigation_item, this, true);
    setBackgroundResource(a.e.design_bottom_navigation_item_background);
    this.bwE = paramAttributeSet.getDimensionPixelSize(a.d.design_bottom_navigation_margin);
    this.bwJ = ((ImageView)findViewById(a.f.icon));
    this.bwK = ((TextView)findViewById(a.f.smallLabel));
    this.bwL = ((TextView)findViewById(a.f.largeLabel));
    w.p(this.bwK, 2);
    w.p(this.bwL, 2);
    setFocusable(true);
    p(this.bwK.getTextSize(), this.bwL.getTextSize());
    AppMethodBeat.o(235072);
  }
  
  private static void a(View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(235093);
    paramView.setScaleX(paramFloat1);
    paramView.setScaleY(paramFloat2);
    paramView.setVisibility(paramInt);
    AppMethodBeat.o(235093);
  }
  
  private static void n(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235090);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin = paramInt1;
    localLayoutParams.gravity = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(235090);
  }
  
  private void p(float paramFloat1, float paramFloat2)
  {
    this.bwF = (paramFloat1 - paramFloat2);
    this.bwG = (1.0F * paramFloat2 / paramFloat1);
    this.bwH = (1.0F * paramFloat1 / paramFloat2);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(235073);
    this.bwN = paramj;
    setCheckable(paramj.isCheckable());
    setChecked(paramj.isChecked());
    setEnabled(paramj.isEnabled());
    setIcon(paramj.getIcon());
    setTitle(paramj.getTitle());
    setId(paramj.getItemId());
    if (!TextUtils.isEmpty(paramj.getContentDescription())) {
      setContentDescription(paramj.getContentDescription());
    }
    ae.a(this, paramj.getTooltipText());
    if (paramj.isVisible()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      AppMethodBeat.o(235073);
      return;
    }
  }
  
  public final boolean bL()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.bwN;
  }
  
  public int getItemPosition()
  {
    return this.bwM;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(235096);
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.bwN != null) && (this.bwN.isCheckable()) && (this.bwN.isChecked())) {
      mergeDrawableStates(arrayOfInt, wo);
    }
    AppMethodBeat.o(235096);
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(235083);
    refreshDrawableState();
    AppMethodBeat.o(235083);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(235086);
    this.bwL.setPivotX(this.bwL.getWidth() / 2);
    this.bwL.setPivotY(this.bwL.getBaseline());
    this.bwK.setPivotX(this.bwK.getWidth() / 2);
    this.bwK.setPivotY(this.bwK.getBaseline());
    switch (this.labelVisibilityMode)
    {
    }
    for (;;)
    {
      refreshDrawableState();
      setSelected(paramBoolean);
      AppMethodBeat.o(235086);
      return;
      if (this.bwI)
      {
        if (paramBoolean)
        {
          n(this.bwJ, this.bwE, 49);
          a(this.bwL, 1.0F, 1.0F, 0);
        }
        for (;;)
        {
          this.bwK.setVisibility(4);
          break;
          n(this.bwJ, this.bwE, 17);
          a(this.bwL, 0.5F, 0.5F, 4);
        }
      }
      if (paramBoolean)
      {
        n(this.bwJ, (int)(this.bwE + this.bwF), 49);
        a(this.bwL, 1.0F, 1.0F, 0);
        a(this.bwK, this.bwG, this.bwG, 4);
      }
      else
      {
        n(this.bwJ, this.bwE, 49);
        a(this.bwL, this.bwH, this.bwH, 4);
        a(this.bwK, 1.0F, 1.0F, 0);
        continue;
        if (paramBoolean)
        {
          n(this.bwJ, this.bwE, 49);
          a(this.bwL, 1.0F, 1.0F, 0);
        }
        for (;;)
        {
          this.bwK.setVisibility(4);
          break;
          n(this.bwJ, this.bwE, 17);
          a(this.bwL, 0.5F, 0.5F, 4);
        }
        if (paramBoolean)
        {
          n(this.bwJ, (int)(this.bwE + this.bwF), 49);
          a(this.bwL, 1.0F, 1.0F, 0);
          a(this.bwK, this.bwG, this.bwG, 4);
        }
        else
        {
          n(this.bwJ, this.bwE, 49);
          a(this.bwL, this.bwH, this.bwH, 4);
          a(this.bwK, 1.0F, 1.0F, 0);
          continue;
          n(this.bwJ, this.bwE, 17);
          this.bwL.setVisibility(8);
          this.bwK.setVisibility(8);
        }
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(235095);
    super.setEnabled(paramBoolean);
    this.bwK.setEnabled(paramBoolean);
    this.bwL.setEnabled(paramBoolean);
    this.bwJ.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      w.a(this, t.U(getContext()));
      AppMethodBeat.o(235095);
      return;
    }
    w.a(this, null);
    AppMethodBeat.o(235095);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(235098);
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable.getConstantState();
      if (localObject != null) {
        break label52;
      }
    }
    for (;;)
    {
      localObject = androidx.core.graphics.drawable.a.p(paramDrawable).mutate();
      androidx.core.graphics.drawable.a.a((Drawable)localObject, this.bwO);
      this.bwJ.setImageDrawable((Drawable)localObject);
      AppMethodBeat.o(235098);
      return;
      label52:
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
    }
  }
  
  public void setIconSize(int paramInt)
  {
    AppMethodBeat.i(235101);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.bwJ.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.bwJ.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(235101);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235099);
    this.bwO = paramColorStateList;
    if (this.bwN != null) {
      setIcon(this.bwN.getIcon());
    }
    AppMethodBeat.o(235099);
  }
  
  public void setItemBackground(int paramInt)
  {
    AppMethodBeat.i(235110);
    if (paramInt == 0) {}
    for (Drawable localDrawable = null;; localDrawable = androidx.core.content.a.m(getContext(), paramInt))
    {
      setItemBackground(localDrawable);
      AppMethodBeat.o(235110);
      return;
    }
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(235112);
    w.a(this, paramDrawable);
    AppMethodBeat.o(235112);
  }
  
  public void setItemPosition(int paramInt)
  {
    this.bwM = paramInt;
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    AppMethodBeat.i(235078);
    if (this.labelVisibilityMode != paramInt)
    {
      this.labelVisibilityMode = paramInt;
      if (this.bwN == null) {
        break label50;
      }
    }
    label50:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        setChecked(this.bwN.isChecked());
      }
      AppMethodBeat.o(235078);
      return;
    }
  }
  
  public void setShifting(boolean paramBoolean)
  {
    AppMethodBeat.i(235076);
    if (this.bwI != paramBoolean)
    {
      this.bwI = paramBoolean;
      if (this.bwN == null) {
        break label50;
      }
    }
    label50:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        setChecked(this.bwN.isChecked());
      }
      AppMethodBeat.o(235076);
      return;
    }
  }
  
  public void setTextAppearanceActive(int paramInt)
  {
    AppMethodBeat.i(235104);
    i.a(this.bwL, paramInt);
    p(this.bwK.getTextSize(), this.bwL.getTextSize());
    AppMethodBeat.o(235104);
  }
  
  public void setTextAppearanceInactive(int paramInt)
  {
    AppMethodBeat.i(235102);
    i.a(this.bwK, paramInt);
    p(this.bwK.getTextSize(), this.bwL.getTextSize());
    AppMethodBeat.o(235102);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235107);
    if (paramColorStateList != null)
    {
      this.bwK.setTextColor(paramColorStateList);
      this.bwL.setTextColor(paramColorStateList);
    }
    AppMethodBeat.o(235107);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(235081);
    this.bwK.setText(paramCharSequence);
    this.bwL.setText(paramCharSequence);
    if ((this.bwN == null) || (TextUtils.isEmpty(this.bwN.getContentDescription()))) {
      setContentDescription(paramCharSequence);
    }
    AppMethodBeat.o(235081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationItemView
 * JD-Core Version:    0.7.0.1
 */