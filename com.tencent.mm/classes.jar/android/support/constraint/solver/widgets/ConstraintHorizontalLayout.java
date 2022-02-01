package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import java.util.ArrayList;

public class ConstraintHorizontalLayout
  extends ConstraintWidgetContainer
{
  private ConstraintHorizontalLayout.ContentAlignment mAlignment = ConstraintHorizontalLayout.ContentAlignment.MIDDLE;
  
  public ConstraintHorizontalLayout() {}
  
  public ConstraintHorizontalLayout(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintHorizontalLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void addToSolver(LinearSystem paramLinearSystem)
  {
    if (this.mChildren.size() != 0)
    {
      int j = this.mChildren.size();
      int i = 0;
      Object localObject = this;
      ConstraintAnchor.Strength localStrength;
      if (i < j)
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
        if (localObject != this)
        {
          localConstraintWidget.connect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)localObject, ConstraintAnchor.Type.RIGHT);
          ((ConstraintWidget)localObject).connect(ConstraintAnchor.Type.RIGHT, localConstraintWidget, ConstraintAnchor.Type.LEFT);
        }
        for (;;)
        {
          localConstraintWidget.connect(ConstraintAnchor.Type.TOP, this, ConstraintAnchor.Type.TOP);
          localConstraintWidget.connect(ConstraintAnchor.Type.BOTTOM, this, ConstraintAnchor.Type.BOTTOM);
          i += 1;
          localObject = localConstraintWidget;
          break;
          localStrength = ConstraintAnchor.Strength.STRONG;
          if (this.mAlignment == ConstraintHorizontalLayout.ContentAlignment.END) {
            localStrength = ConstraintAnchor.Strength.WEAK;
          }
          localConstraintWidget.connect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)localObject, ConstraintAnchor.Type.LEFT, 0, localStrength);
        }
      }
      if (localObject != this)
      {
        localStrength = ConstraintAnchor.Strength.STRONG;
        if (this.mAlignment == ConstraintHorizontalLayout.ContentAlignment.BEGIN) {
          localStrength = ConstraintAnchor.Strength.WEAK;
        }
        ((ConstraintWidget)localObject).connect(ConstraintAnchor.Type.RIGHT, this, ConstraintAnchor.Type.RIGHT, 0, localStrength);
      }
    }
    super.addToSolver(paramLinearSystem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.constraint.solver.widgets.ConstraintHorizontalLayout
 * JD-Core Version:    0.7.0.1
 */