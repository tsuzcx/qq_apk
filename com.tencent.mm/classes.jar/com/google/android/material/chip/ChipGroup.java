package com.google.android.material.chip;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.android.material.a.b;
import com.google.android.material.a.j;
import com.google.android.material.a.k;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ChipGroup
  extends FlowLayout
{
  private int chipSpacingHorizontal;
  private int chipSpacingVertical;
  private boolean dsN;
  private b dsO;
  private final a dsP;
  private c dsQ;
  private int dsR;
  private boolean dsS;
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.chipGroupStyle);
  }
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208988);
    this.dsP = new a((byte)0);
    this.dsQ = new c((byte)0);
    this.dsR = -1;
    this.dsS = false;
    paramContext = k.a(paramContext, paramAttributeSet, a.k.ChipGroup, paramInt, a.j.Widget_MaterialComponents_ChipGroup, new int[0]);
    paramInt = paramContext.getDimensionPixelOffset(a.k.ChipGroup_chipSpacing, 0);
    setChipSpacingHorizontal(paramContext.getDimensionPixelOffset(a.k.ChipGroup_chipSpacingHorizontal, paramInt));
    setChipSpacingVertical(paramContext.getDimensionPixelOffset(a.k.ChipGroup_chipSpacingVertical, paramInt));
    setSingleLine(paramContext.getBoolean(a.k.ChipGroup_singleLine, false));
    setSingleSelection(paramContext.getBoolean(a.k.ChipGroup_singleSelection, false));
    paramInt = paramContext.getResourceId(a.k.ChipGroup_checkedChip, -1);
    if (paramInt != -1) {
      this.dsR = paramInt;
    }
    paramContext.recycle();
    super.setOnHierarchyChangeListener(this.dsQ);
    AppMethodBeat.o(208988);
  }
  
  private void F(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(209002);
    View localView = findViewById(paramInt);
    if ((localView instanceof Chip))
    {
      this.dsS = true;
      ((Chip)localView).setChecked(paramBoolean);
      this.dsS = false;
    }
    AppMethodBeat.o(209002);
  }
  
  private void setCheckedId(int paramInt)
  {
    this.dsR = paramInt;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(209081);
    if ((paramView instanceof Chip))
    {
      Chip localChip = (Chip)paramView;
      if (localChip.isChecked())
      {
        if ((this.dsR != -1) && (this.dsN)) {
          F(this.dsR, false);
        }
        setCheckedId(localChip.getId());
      }
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(209081);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(209065);
    if ((super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams)))
    {
      AppMethodBeat.o(209065);
      return true;
    }
    AppMethodBeat.o(209065);
    return false;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(209058);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(209058);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(209039);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(209039);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(209050);
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(209050);
    return paramLayoutParams;
  }
  
  public int getCheckedChipId()
  {
    if (this.dsN) {
      return this.dsR;
    }
    return -1;
  }
  
  public int getChipSpacingHorizontal()
  {
    return this.chipSpacingHorizontal;
  }
  
  public int getChipSpacingVertical()
  {
    return this.chipSpacingVertical;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(209076);
    super.onFinishInflate();
    if (this.dsR != -1)
    {
      F(this.dsR, true);
      setCheckedId(this.dsR);
    }
    AppMethodBeat.o(209076);
  }
  
  public void setChipSpacing(int paramInt)
  {
    AppMethodBeat.i(209133);
    setChipSpacingHorizontal(paramInt);
    setChipSpacingVertical(paramInt);
    AppMethodBeat.o(209133);
  }
  
  public void setChipSpacingHorizontal(int paramInt)
  {
    AppMethodBeat.i(209159);
    if (this.chipSpacingHorizontal != paramInt)
    {
      this.chipSpacingHorizontal = paramInt;
      setItemSpacing(paramInt);
      requestLayout();
    }
    AppMethodBeat.o(209159);
  }
  
  public void setChipSpacingHorizontalResource(int paramInt)
  {
    AppMethodBeat.i(209167);
    setChipSpacingHorizontal(getResources().getDimensionPixelOffset(paramInt));
    AppMethodBeat.o(209167);
  }
  
  public void setChipSpacingResource(int paramInt)
  {
    AppMethodBeat.i(209141);
    setChipSpacing(getResources().getDimensionPixelOffset(paramInt));
    AppMethodBeat.o(209141);
  }
  
  public void setChipSpacingVertical(int paramInt)
  {
    AppMethodBeat.i(209183);
    if (this.chipSpacingVertical != paramInt)
    {
      this.chipSpacingVertical = paramInt;
      setLineSpacing(paramInt);
      requestLayout();
    }
    AppMethodBeat.o(209183);
  }
  
  public void setChipSpacingVerticalResource(int paramInt)
  {
    AppMethodBeat.i(209191);
    setChipSpacingVertical(getResources().getDimensionPixelOffset(paramInt));
    AppMethodBeat.o(209191);
  }
  
  @Deprecated
  public void setDividerDrawableHorizontal(Drawable paramDrawable)
  {
    AppMethodBeat.i(209088);
    paramDrawable = new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    AppMethodBeat.o(209088);
    throw paramDrawable;
  }
  
  @Deprecated
  public void setDividerDrawableVertical(Drawable paramDrawable)
  {
    AppMethodBeat.i(209094);
    paramDrawable = new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    AppMethodBeat.o(209094);
    throw paramDrawable;
  }
  
  @Deprecated
  public void setFlexWrap(int paramInt)
  {
    AppMethodBeat.i(209111);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    AppMethodBeat.o(209111);
    throw localUnsupportedOperationException;
  }
  
  public void setOnCheckedChangeListener(b paramb)
  {
    this.dsO = paramb;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    AppMethodBeat.i(209071);
    c.a(this.dsQ, paramOnHierarchyChangeListener);
    AppMethodBeat.o(209071);
  }
  
  @Deprecated
  public void setShowDividerHorizontal(int paramInt)
  {
    AppMethodBeat.i(209097);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    AppMethodBeat.o(209097);
    throw localUnsupportedOperationException;
  }
  
  @Deprecated
  public void setShowDividerVertical(int paramInt)
  {
    AppMethodBeat.i(209105);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    AppMethodBeat.o(209105);
    throw localUnsupportedOperationException;
  }
  
  public void setSingleLine(int paramInt)
  {
    AppMethodBeat.i(209199);
    setSingleLine(getResources().getBoolean(paramInt));
    AppMethodBeat.o(209199);
  }
  
  public void setSingleSelection(int paramInt)
  {
    AppMethodBeat.i(209220);
    setSingleSelection(getResources().getBoolean(paramInt));
    AppMethodBeat.o(209220);
  }
  
  public void setSingleSelection(boolean paramBoolean)
  {
    AppMethodBeat.i(209209);
    if (this.dsN != paramBoolean)
    {
      this.dsN = paramBoolean;
      this.dsS = true;
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if ((localView instanceof Chip)) {
          ((Chip)localView).setChecked(false);
        }
        i += 1;
      }
      this.dsS = false;
      setCheckedId(-1);
    }
    AppMethodBeat.o(209209);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams()
    {
      super(-2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    private a() {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(208975);
      if (ChipGroup.a(ChipGroup.this))
      {
        AppMethodBeat.o(208975);
        return;
      }
      int i = paramCompoundButton.getId();
      if (paramBoolean)
      {
        if ((ChipGroup.b(ChipGroup.this) != -1) && (ChipGroup.b(ChipGroup.this) != i) && (ChipGroup.c(ChipGroup.this))) {
          ChipGroup.a(ChipGroup.this, ChipGroup.b(ChipGroup.this));
        }
        ChipGroup.b(ChipGroup.this, i);
        AppMethodBeat.o(208975);
        return;
      }
      if (ChipGroup.b(ChipGroup.this) == i) {
        ChipGroup.b(ChipGroup.this, -1);
      }
      AppMethodBeat.o(208975);
    }
  }
  
  public static abstract interface b {}
  
  final class c
    implements ViewGroup.OnHierarchyChangeListener
  {
    private ViewGroup.OnHierarchyChangeListener dsU;
    
    private c() {}
    
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      AppMethodBeat.i(208974);
      if ((paramView1 == ChipGroup.this) && ((paramView2 instanceof Chip))) {
        if (paramView2.getId() == -1) {
          if (Build.VERSION.SDK_INT < 17) {
            break label83;
          }
        }
      }
      label83:
      for (int i = View.generateViewId();; i = paramView2.hashCode())
      {
        paramView2.setId(i);
        ((Chip)paramView2).setOnCheckedChangeListenerInternal(ChipGroup.d(ChipGroup.this));
        if (this.dsU != null) {
          this.dsU.onChildViewAdded(paramView1, paramView2);
        }
        AppMethodBeat.o(208974);
        return;
      }
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      AppMethodBeat.i(208978);
      if ((paramView1 == ChipGroup.this) && ((paramView2 instanceof Chip))) {
        ((Chip)paramView2).setOnCheckedChangeListenerInternal(null);
      }
      if (this.dsU != null) {
        this.dsU.onChildViewRemoved(paramView1, paramView2);
      }
      AppMethodBeat.o(208978);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.chip.ChipGroup
 * JD-Core Version:    0.7.0.1
 */