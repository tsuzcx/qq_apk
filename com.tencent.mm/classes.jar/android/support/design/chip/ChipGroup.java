package android.support.design.chip;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.a.a;
import android.support.design.internal.FlowLayout;
import android.support.design.internal.f;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ChipGroup
  extends FlowLayout
{
  private boolean gA;
  private b gB;
  private final a gC = new a((byte)0);
  private c gD = new c((byte)0);
  private int gE = -1;
  private boolean gF = false;
  private int gy;
  private int gz;
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968755);
  }
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = f.a(paramContext, paramAttributeSet, a.a.ChipGroup, paramInt, 2131821663, new int[0]);
    paramInt = paramContext.getDimensionPixelOffset(1, 0);
    setChipSpacingHorizontal(paramContext.getDimensionPixelOffset(2, paramInt));
    setChipSpacingVertical(paramContext.getDimensionPixelOffset(3, paramInt));
    setSingleLine(paramContext.getBoolean(4, false));
    setSingleSelection(paramContext.getBoolean(5, false));
    paramInt = paramContext.getResourceId(0, -1);
    if (paramInt != -1) {
      this.gE = paramInt;
    }
    paramContext.recycle();
    super.setOnHierarchyChangeListener(this.gD);
  }
  
  private void c(int paramInt, boolean paramBoolean)
  {
    View localView = findViewById(paramInt);
    if ((localView instanceof Chip))
    {
      this.gF = true;
      ((Chip)localView).setChecked(paramBoolean);
      this.gF = false;
    }
  }
  
  private void setCheckedId(int paramInt)
  {
    this.gE = paramInt;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof Chip))
    {
      Chip localChip = (Chip)paramView;
      if (localChip.isChecked())
      {
        if ((this.gE != -1) && (this.gA)) {
          c(this.gE, false);
        }
        setCheckedId(localChip.getId());
      }
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getCheckedChipId()
  {
    if (this.gA) {
      return this.gE;
    }
    return -1;
  }
  
  public int getChipSpacingHorizontal()
  {
    return this.gy;
  }
  
  public int getChipSpacingVertical()
  {
    return this.gz;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (this.gE != -1)
    {
      c(this.gE, true);
      setCheckedId(this.gE);
    }
  }
  
  public void setChipSpacing(int paramInt)
  {
    setChipSpacingHorizontal(paramInt);
    setChipSpacingVertical(paramInt);
  }
  
  public void setChipSpacingHorizontal(int paramInt)
  {
    if (this.gy != paramInt)
    {
      this.gy = paramInt;
      setItemSpacing(paramInt);
      requestLayout();
    }
  }
  
  public void setChipSpacingHorizontalResource(int paramInt)
  {
    setChipSpacingHorizontal(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setChipSpacingResource(int paramInt)
  {
    setChipSpacing(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setChipSpacingVertical(int paramInt)
  {
    if (this.gz != paramInt)
    {
      this.gz = paramInt;
      setLineSpacing(paramInt);
      requestLayout();
    }
  }
  
  public void setChipSpacingVerticalResource(int paramInt)
  {
    setChipSpacingVertical(getResources().getDimensionPixelOffset(paramInt));
  }
  
  @Deprecated
  public void setDividerDrawableHorizontal(Drawable paramDrawable)
  {
    throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  @Deprecated
  public void setDividerDrawableVertical(Drawable paramDrawable)
  {
    throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  @Deprecated
  public void setFlexWrap(int paramInt)
  {
    throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
  }
  
  public void setOnCheckedChangeListener(b paramb)
  {
    this.gB = paramb;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    c.a(this.gD, paramOnHierarchyChangeListener);
  }
  
  @Deprecated
  public void setShowDividerHorizontal(int paramInt)
  {
    throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  @Deprecated
  public void setShowDividerVertical(int paramInt)
  {
    throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  public void setSingleLine(int paramInt)
  {
    setSingleLine(getResources().getBoolean(paramInt));
  }
  
  public void setSingleSelection(int paramInt)
  {
    setSingleSelection(getResources().getBoolean(paramInt));
  }
  
  public void setSingleSelection(boolean paramBoolean)
  {
    if (this.gA != paramBoolean)
    {
      this.gA = paramBoolean;
      this.gF = true;
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if ((localView instanceof Chip)) {
          ((Chip)localView).setChecked(false);
        }
        i += 1;
      }
      this.gF = false;
      setCheckedId(-1);
    }
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
      if (ChipGroup.a(ChipGroup.this)) {}
      int i;
      do
      {
        return;
        i = paramCompoundButton.getId();
        if (paramBoolean)
        {
          if ((ChipGroup.b(ChipGroup.this) != -1) && (ChipGroup.b(ChipGroup.this) != i) && (ChipGroup.c(ChipGroup.this))) {
            ChipGroup.a(ChipGroup.this, ChipGroup.b(ChipGroup.this));
          }
          ChipGroup.b(ChipGroup.this, i);
          return;
        }
      } while (ChipGroup.b(ChipGroup.this) != i);
      ChipGroup.b(ChipGroup.this, -1);
    }
  }
  
  public static abstract interface b {}
  
  final class c
    implements ViewGroup.OnHierarchyChangeListener
  {
    private ViewGroup.OnHierarchyChangeListener gH;
    
    private c() {}
    
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      if ((paramView1 == ChipGroup.this) && ((paramView2 instanceof Chip))) {
        if (paramView2.getId() == -1) {
          if (Build.VERSION.SDK_INT < 17) {
            break label73;
          }
        }
      }
      label73:
      for (int i = View.generateViewId();; i = paramView2.hashCode())
      {
        paramView2.setId(i);
        ((Chip)paramView2).setOnCheckedChangeListenerInternal(ChipGroup.d(ChipGroup.this));
        if (this.gH != null) {
          this.gH.onChildViewAdded(paramView1, paramView2);
        }
        return;
      }
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      if ((paramView1 == ChipGroup.this) && ((paramView2 instanceof Chip))) {
        ((Chip)paramView2).setOnCheckedChangeListenerInternal(null);
      }
      if (this.gH != null) {
        this.gH.onChildViewRemoved(paramView1, paramView2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.chip.ChipGroup
 * JD-Core Version:    0.7.0.1
 */