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
  private boolean bzM;
  private b bzN;
  private final a bzO;
  private c bzP;
  private int bzQ;
  private boolean bzR;
  private int chipSpacingHorizontal;
  private int chipSpacingVertical;
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.chipGroupStyle);
  }
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(236298);
    this.bzO = new a((byte)0);
    this.bzP = new c((byte)0);
    this.bzQ = -1;
    this.bzR = false;
    paramContext = k.a(paramContext, paramAttributeSet, a.k.ChipGroup, paramInt, a.j.Widget_MaterialComponents_ChipGroup, new int[0]);
    paramInt = paramContext.getDimensionPixelOffset(a.k.ChipGroup_chipSpacing, 0);
    setChipSpacingHorizontal(paramContext.getDimensionPixelOffset(a.k.ChipGroup_chipSpacingHorizontal, paramInt));
    setChipSpacingVertical(paramContext.getDimensionPixelOffset(a.k.ChipGroup_chipSpacingVertical, paramInt));
    setSingleLine(paramContext.getBoolean(a.k.ChipGroup_singleLine, false));
    setSingleSelection(paramContext.getBoolean(a.k.ChipGroup_singleSelection, false));
    paramInt = paramContext.getResourceId(a.k.ChipGroup_checkedChip, -1);
    if (paramInt != -1) {
      this.bzQ = paramInt;
    }
    paramContext.recycle();
    super.setOnHierarchyChangeListener(this.bzP);
    AppMethodBeat.o(236298);
  }
  
  private void r(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(236321);
    View localView = findViewById(paramInt);
    if ((localView instanceof Chip))
    {
      this.bzR = true;
      ((Chip)localView).setChecked(paramBoolean);
      this.bzR = false;
    }
    AppMethodBeat.o(236321);
  }
  
  private void setCheckedId(int paramInt)
  {
    this.bzQ = paramInt;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(236311);
    if ((paramView instanceof Chip))
    {
      Chip localChip = (Chip)paramView;
      if (localChip.isChecked())
      {
        if ((this.bzQ != -1) && (this.bzM)) {
          r(this.bzQ, false);
        }
        setCheckedId(localChip.getId());
      }
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(236311);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(236303);
    if ((super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams)))
    {
      AppMethodBeat.o(236303);
      return true;
    }
    AppMethodBeat.o(236303);
    return false;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(236302);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(236302);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(236300);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(236300);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(236301);
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(236301);
    return paramLayoutParams;
  }
  
  public int getCheckedChipId()
  {
    if (this.bzM) {
      return this.bzQ;
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
    AppMethodBeat.i(236307);
    super.onFinishInflate();
    if (this.bzQ != -1)
    {
      r(this.bzQ, true);
      setCheckedId(this.bzQ);
    }
    AppMethodBeat.o(236307);
  }
  
  public void setChipSpacing(int paramInt)
  {
    AppMethodBeat.i(236322);
    setChipSpacingHorizontal(paramInt);
    setChipSpacingVertical(paramInt);
    AppMethodBeat.o(236322);
  }
  
  public void setChipSpacingHorizontal(int paramInt)
  {
    AppMethodBeat.i(236325);
    if (this.chipSpacingHorizontal != paramInt)
    {
      this.chipSpacingHorizontal = paramInt;
      setItemSpacing(paramInt);
      requestLayout();
    }
    AppMethodBeat.o(236325);
  }
  
  public void setChipSpacingHorizontalResource(int paramInt)
  {
    AppMethodBeat.i(236327);
    setChipSpacingHorizontal(getResources().getDimensionPixelOffset(paramInt));
    AppMethodBeat.o(236327);
  }
  
  public void setChipSpacingResource(int paramInt)
  {
    AppMethodBeat.i(236323);
    setChipSpacing(getResources().getDimensionPixelOffset(paramInt));
    AppMethodBeat.o(236323);
  }
  
  public void setChipSpacingVertical(int paramInt)
  {
    AppMethodBeat.i(236329);
    if (this.chipSpacingVertical != paramInt)
    {
      this.chipSpacingVertical = paramInt;
      setLineSpacing(paramInt);
      requestLayout();
    }
    AppMethodBeat.o(236329);
  }
  
  public void setChipSpacingVerticalResource(int paramInt)
  {
    AppMethodBeat.i(236331);
    setChipSpacingVertical(getResources().getDimensionPixelOffset(paramInt));
    AppMethodBeat.o(236331);
  }
  
  @Deprecated
  public void setDividerDrawableHorizontal(Drawable paramDrawable)
  {
    AppMethodBeat.i(236314);
    paramDrawable = new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    AppMethodBeat.o(236314);
    throw paramDrawable;
  }
  
  @Deprecated
  public void setDividerDrawableVertical(Drawable paramDrawable)
  {
    AppMethodBeat.i(236315);
    paramDrawable = new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    AppMethodBeat.o(236315);
    throw paramDrawable;
  }
  
  @Deprecated
  public void setFlexWrap(int paramInt)
  {
    AppMethodBeat.i(236319);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    AppMethodBeat.o(236319);
    throw localUnsupportedOperationException;
  }
  
  public void setOnCheckedChangeListener(b paramb)
  {
    this.bzN = paramb;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    AppMethodBeat.i(236305);
    c.a(this.bzP, paramOnHierarchyChangeListener);
    AppMethodBeat.o(236305);
  }
  
  @Deprecated
  public void setShowDividerHorizontal(int paramInt)
  {
    AppMethodBeat.i(236316);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    AppMethodBeat.o(236316);
    throw localUnsupportedOperationException;
  }
  
  @Deprecated
  public void setShowDividerVertical(int paramInt)
  {
    AppMethodBeat.i(236318);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    AppMethodBeat.o(236318);
    throw localUnsupportedOperationException;
  }
  
  public void setSingleLine(int paramInt)
  {
    AppMethodBeat.i(236332);
    setSingleLine(getResources().getBoolean(paramInt));
    AppMethodBeat.o(236332);
  }
  
  public void setSingleSelection(int paramInt)
  {
    AppMethodBeat.i(236335);
    setSingleSelection(getResources().getBoolean(paramInt));
    AppMethodBeat.o(236335);
  }
  
  public void setSingleSelection(boolean paramBoolean)
  {
    AppMethodBeat.i(236333);
    if (this.bzM != paramBoolean)
    {
      this.bzM = paramBoolean;
      this.bzR = true;
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if ((localView instanceof Chip)) {
          ((Chip)localView).setChecked(false);
        }
        i += 1;
      }
      this.bzR = false;
      setCheckedId(-1);
    }
    AppMethodBeat.o(236333);
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
      AppMethodBeat.i(236182);
      if (ChipGroup.a(ChipGroup.this))
      {
        AppMethodBeat.o(236182);
        return;
      }
      int i = paramCompoundButton.getId();
      if (paramBoolean)
      {
        if ((ChipGroup.b(ChipGroup.this) != -1) && (ChipGroup.b(ChipGroup.this) != i) && (ChipGroup.c(ChipGroup.this))) {
          ChipGroup.a(ChipGroup.this, ChipGroup.b(ChipGroup.this));
        }
        ChipGroup.b(ChipGroup.this, i);
        AppMethodBeat.o(236182);
        return;
      }
      if (ChipGroup.b(ChipGroup.this) == i) {
        ChipGroup.b(ChipGroup.this, -1);
      }
      AppMethodBeat.o(236182);
    }
  }
  
  public static abstract interface b {}
  
  final class c
    implements ViewGroup.OnHierarchyChangeListener
  {
    private ViewGroup.OnHierarchyChangeListener bzT;
    
    private c() {}
    
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      AppMethodBeat.i(236260);
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
        if (this.bzT != null) {
          this.bzT.onChildViewAdded(paramView1, paramView2);
        }
        AppMethodBeat.o(236260);
        return;
      }
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      AppMethodBeat.i(236263);
      if ((paramView1 == ChipGroup.this) && ((paramView2 instanceof Chip))) {
        ((Chip)paramView2).setOnCheckedChangeListenerInternal(null);
      }
      if (this.bzT != null) {
        this.bzT.onChildViewRemoved(paramView1, paramView2);
      }
      AppMethodBeat.o(236263);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.chip.ChipGroup
 * JD-Core Version:    0.7.0.1
 */