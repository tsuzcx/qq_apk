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
import androidx.appcompat.view.menu.p.a;
import androidx.appcompat.widget.ae;
import androidx.core.g.v;
import androidx.core.g.z;
import com.google.android.material.a.d;
import com.google.android.material.a.e;
import com.google.android.material.a.f;
import com.google.android.material.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BottomNavigationItemView
  extends FrameLayout
  implements p.a
{
  private static final int[] xk = { 16842912 };
  private final int dpH;
  private float dpI;
  private float dpJ;
  private float dpK;
  private boolean dpL;
  private ImageView dpM;
  private final TextView dpN;
  private final TextView dpO;
  private int dpP;
  private androidx.appcompat.view.menu.j dpQ;
  private ColorStateList dpR;
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
    AppMethodBeat.i(209682);
    this.dpP = -1;
    paramAttributeSet = getResources();
    LayoutInflater.from(paramContext).inflate(a.h.design_bottom_navigation_item, this, true);
    setBackgroundResource(a.e.design_bottom_navigation_item_background);
    this.dpH = paramAttributeSet.getDimensionPixelSize(a.d.design_bottom_navigation_margin);
    this.dpM = ((ImageView)findViewById(a.f.icon));
    this.dpN = ((TextView)findViewById(a.f.smallLabel));
    this.dpO = ((TextView)findViewById(a.f.largeLabel));
    z.p(this.dpN, 2);
    z.p(this.dpO, 2);
    setFocusable(true);
    V(this.dpN.getTextSize(), this.dpO.getTextSize());
    AppMethodBeat.o(209682);
  }
  
  private void V(float paramFloat1, float paramFloat2)
  {
    this.dpI = (paramFloat1 - paramFloat2);
    this.dpJ = (1.0F * paramFloat2 / paramFloat1);
    this.dpK = (1.0F * paramFloat1 / paramFloat2);
  }
  
  private static void a(View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(209702);
    paramView.setScaleX(paramFloat1);
    paramView.setScaleY(paramFloat2);
    paramView.setVisibility(paramInt);
    AppMethodBeat.o(209702);
  }
  
  private static void n(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209693);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin = paramInt1;
    localLayoutParams.gravity = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(209693);
  }
  
  public final void a(androidx.appcompat.view.menu.j paramj)
  {
    AppMethodBeat.i(209726);
    this.dpQ = paramj;
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
      AppMethodBeat.o(209726);
      return;
    }
  }
  
  public final boolean cE()
  {
    return false;
  }
  
  public androidx.appcompat.view.menu.j getItemData()
  {
    return this.dpQ;
  }
  
  public int getItemPosition()
  {
    return this.dpP;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(209818);
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.dpQ != null) && (this.dpQ.isCheckable()) && (this.dpQ.isChecked())) {
      mergeDrawableStates(arrayOfInt, xk);
    }
    AppMethodBeat.o(209818);
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(209783);
    refreshDrawableState();
    AppMethodBeat.o(209783);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(209801);
    this.dpO.setPivotX(this.dpO.getWidth() / 2);
    this.dpO.setPivotY(this.dpO.getBaseline());
    this.dpN.setPivotX(this.dpN.getWidth() / 2);
    this.dpN.setPivotY(this.dpN.getBaseline());
    switch (this.labelVisibilityMode)
    {
    }
    for (;;)
    {
      refreshDrawableState();
      setSelected(paramBoolean);
      AppMethodBeat.o(209801);
      return;
      if (this.dpL)
      {
        if (paramBoolean)
        {
          n(this.dpM, this.dpH, 49);
          a(this.dpO, 1.0F, 1.0F, 0);
        }
        for (;;)
        {
          this.dpN.setVisibility(4);
          break;
          n(this.dpM, this.dpH, 17);
          a(this.dpO, 0.5F, 0.5F, 4);
        }
      }
      if (paramBoolean)
      {
        n(this.dpM, (int)(this.dpH + this.dpI), 49);
        a(this.dpO, 1.0F, 1.0F, 0);
        a(this.dpN, this.dpJ, this.dpJ, 4);
      }
      else
      {
        n(this.dpM, this.dpH, 49);
        a(this.dpO, this.dpK, this.dpK, 4);
        a(this.dpN, 1.0F, 1.0F, 0);
        continue;
        if (paramBoolean)
        {
          n(this.dpM, this.dpH, 49);
          a(this.dpO, 1.0F, 1.0F, 0);
        }
        for (;;)
        {
          this.dpN.setVisibility(4);
          break;
          n(this.dpM, this.dpH, 17);
          a(this.dpO, 0.5F, 0.5F, 4);
        }
        if (paramBoolean)
        {
          n(this.dpM, (int)(this.dpH + this.dpI), 49);
          a(this.dpO, 1.0F, 1.0F, 0);
          a(this.dpN, this.dpJ, this.dpJ, 4);
        }
        else
        {
          n(this.dpM, this.dpH, 49);
          a(this.dpO, this.dpK, this.dpK, 4);
          a(this.dpN, 1.0F, 1.0F, 0);
          continue;
          n(this.dpM, this.dpH, 17);
          this.dpO.setVisibility(8);
          this.dpN.setVisibility(8);
        }
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(209810);
    super.setEnabled(paramBoolean);
    this.dpN.setEnabled(paramBoolean);
    this.dpO.setEnabled(paramBoolean);
    this.dpM.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      z.a(this, v.aj(getContext()));
      AppMethodBeat.o(209810);
      return;
    }
    z.a(this, null);
    AppMethodBeat.o(209810);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(209827);
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
      localObject = androidx.core.graphics.drawable.a.s(paramDrawable).mutate();
      androidx.core.graphics.drawable.a.a((Drawable)localObject, this.dpR);
      this.dpM.setImageDrawable((Drawable)localObject);
      AppMethodBeat.o(209827);
      return;
      label52:
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
    }
  }
  
  public void setIconSize(int paramInt)
  {
    AppMethodBeat.i(209847);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.dpM.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.dpM.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(209847);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209841);
    this.dpR = paramColorStateList;
    if (this.dpQ != null) {
      setIcon(this.dpQ.getIcon());
    }
    AppMethodBeat.o(209841);
  }
  
  public void setItemBackground(int paramInt)
  {
    AppMethodBeat.i(209874);
    if (paramInt == 0) {}
    for (Drawable localDrawable = null;; localDrawable = androidx.core.content.a.m(getContext(), paramInt))
    {
      setItemBackground(localDrawable);
      AppMethodBeat.o(209874);
      return;
    }
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(209880);
    z.a(this, paramDrawable);
    AppMethodBeat.o(209880);
  }
  
  public void setItemPosition(int paramInt)
  {
    this.dpP = paramInt;
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    AppMethodBeat.i(209760);
    if (this.labelVisibilityMode != paramInt)
    {
      this.labelVisibilityMode = paramInt;
      if (this.dpQ == null) {
        break label50;
      }
    }
    label50:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        setChecked(this.dpQ.isChecked());
      }
      AppMethodBeat.o(209760);
      return;
    }
  }
  
  public void setShifting(boolean paramBoolean)
  {
    AppMethodBeat.i(209752);
    if (this.dpL != paramBoolean)
    {
      this.dpL = paramBoolean;
      if (this.dpQ == null) {
        break label50;
      }
    }
    label50:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        setChecked(this.dpQ.isChecked());
      }
      AppMethodBeat.o(209752);
      return;
    }
  }
  
  public void setTextAppearanceActive(int paramInt)
  {
    AppMethodBeat.i(209861);
    androidx.core.widget.j.a(this.dpO, paramInt);
    V(this.dpN.getTextSize(), this.dpO.getTextSize());
    AppMethodBeat.o(209861);
  }
  
  public void setTextAppearanceInactive(int paramInt)
  {
    AppMethodBeat.i(209851);
    androidx.core.widget.j.a(this.dpN, paramInt);
    V(this.dpN.getTextSize(), this.dpO.getTextSize());
    AppMethodBeat.o(209851);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209866);
    if (paramColorStateList != null)
    {
      this.dpN.setTextColor(paramColorStateList);
      this.dpO.setTextColor(paramColorStateList);
    }
    AppMethodBeat.o(209866);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(209776);
    this.dpN.setText(paramCharSequence);
    this.dpO.setText(paramCharSequence);
    if ((this.dpQ == null) || (TextUtils.isEmpty(this.dpQ.getContentDescription()))) {
      setContentDescription(paramCharSequence);
    }
    AppMethodBeat.o(209776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationItemView
 * JD-Core Version:    0.7.0.1
 */