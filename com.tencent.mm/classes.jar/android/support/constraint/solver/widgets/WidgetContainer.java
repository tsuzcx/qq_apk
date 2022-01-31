package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import java.util.ArrayList;

public class WidgetContainer
  extends ConstraintWidget
{
  protected ArrayList<ConstraintWidget> mChildren = new ArrayList();
  
  public WidgetContainer() {}
  
  public WidgetContainer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public WidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static Rectangle getBounds(ArrayList<ConstraintWidget> paramArrayList)
  {
    Rectangle localRectangle = new Rectangle();
    if (paramArrayList.size() == 0) {
      return localRectangle;
    }
    int i4 = paramArrayList.size();
    int j = 0;
    int i = 0;
    int i2 = 2147483647;
    int m = 0;
    int i3 = 2147483647;
    int k;
    int n;
    int i1;
    if (j < i4)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)paramArrayList.get(j);
      k = i3;
      if (localConstraintWidget.getX() < i3) {
        k = localConstraintWidget.getX();
      }
      n = i2;
      if (localConstraintWidget.getY() < i2) {
        n = localConstraintWidget.getY();
      }
      i1 = m;
      if (localConstraintWidget.getRight() > m) {
        i1 = localConstraintWidget.getRight();
      }
      if (localConstraintWidget.getBottom() <= i) {
        break label171;
      }
      i = localConstraintWidget.getBottom();
    }
    label171:
    for (;;)
    {
      j += 1;
      i3 = k;
      i2 = n;
      m = i1;
      break;
      localRectangle.setBounds(i3, i2, m - i3, i - i2);
      return localRectangle;
    }
  }
  
  public void add(ConstraintWidget paramConstraintWidget)
  {
    this.mChildren.add(paramConstraintWidget);
    if (paramConstraintWidget.getParent() != null) {
      ((WidgetContainer)paramConstraintWidget.getParent()).remove(paramConstraintWidget);
    }
    paramConstraintWidget.setParent(this);
  }
  
  public void add(ConstraintWidget... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      add(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public ConstraintWidget findWidget(float paramFloat1, float paramFloat2)
  {
    Object localObject2 = null;
    int i = getDrawX();
    int j = getDrawY();
    int k = getWidth();
    int m = getHeight();
    Object localObject1 = localObject2;
    if (paramFloat1 >= i)
    {
      localObject1 = localObject2;
      if (paramFloat1 <= k + i)
      {
        localObject1 = localObject2;
        if (paramFloat2 >= j)
        {
          localObject1 = localObject2;
          if (paramFloat2 <= m + j) {
            localObject1 = this;
          }
        }
      }
    }
    i = 0;
    j = this.mChildren.size();
    ConstraintWidget localConstraintWidget;
    if (i < j)
    {
      localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      if ((localConstraintWidget instanceof WidgetContainer))
      {
        localObject2 = ((WidgetContainer)localConstraintWidget).findWidget(paramFloat1, paramFloat2);
        if (localObject2 == null) {
          break label247;
        }
        localObject1 = localObject2;
      }
    }
    label247:
    for (;;)
    {
      localObject2 = localObject1;
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        k = localConstraintWidget.getDrawX();
        m = localConstraintWidget.getDrawY();
        int n = localConstraintWidget.getWidth();
        int i1 = localConstraintWidget.getHeight();
        localObject2 = localObject1;
        if (paramFloat1 >= k)
        {
          localObject2 = localObject1;
          if (paramFloat1 <= n + k)
          {
            localObject2 = localObject1;
            if (paramFloat2 >= m)
            {
              localObject2 = localObject1;
              if (paramFloat2 <= i1 + m) {
                localObject2 = localConstraintWidget;
              }
            }
          }
        }
      }
      return localObject1;
    }
  }
  
  public ArrayList<ConstraintWidget> findWidgets(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArrayList localArrayList = new ArrayList();
    Rectangle localRectangle1 = new Rectangle();
    localRectangle1.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = this.mChildren.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(paramInt1);
      Rectangle localRectangle2 = new Rectangle();
      localRectangle2.setBounds(localConstraintWidget.getDrawX(), localConstraintWidget.getDrawY(), localConstraintWidget.getWidth(), localConstraintWidget.getHeight());
      if (localRectangle1.intersects(localRectangle2)) {
        localArrayList.add(localConstraintWidget);
      }
      paramInt1 += 1;
    }
    return localArrayList;
  }
  
  public ArrayList<ConstraintWidget> getChildren()
  {
    return this.mChildren;
  }
  
  public ConstraintWidgetContainer getRootConstraintContainer()
  {
    Object localObject = getParent();
    ConstraintWidgetContainer localConstraintWidgetContainer;
    if ((this instanceof ConstraintWidgetContainer)) {
      localConstraintWidgetContainer = (ConstraintWidgetContainer)this;
    }
    for (;;)
    {
      ConstraintWidget localConstraintWidget;
      if (localObject != null)
      {
        localConstraintWidget = ((ConstraintWidget)localObject).getParent();
        if ((localObject instanceof ConstraintWidgetContainer))
        {
          localConstraintWidgetContainer = (ConstraintWidgetContainer)localObject;
          localObject = localConstraintWidget;
        }
      }
      else
      {
        return localConstraintWidgetContainer;
      }
      localObject = localConstraintWidget;
      continue;
      localConstraintWidgetContainer = null;
    }
  }
  
  public void layout()
  {
    updateDrawPosition();
    if (this.mChildren == null) {}
    for (;;)
    {
      return;
      int j = this.mChildren.size();
      int i = 0;
      while (i < j)
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
        if ((localConstraintWidget instanceof WidgetContainer)) {
          ((WidgetContainer)localConstraintWidget).layout();
        }
        i += 1;
      }
    }
  }
  
  public void remove(ConstraintWidget paramConstraintWidget)
  {
    this.mChildren.remove(paramConstraintWidget);
    paramConstraintWidget.setParent(null);
  }
  
  public void removeAllChildren()
  {
    this.mChildren.clear();
  }
  
  public void reset()
  {
    this.mChildren.clear();
    super.reset();
  }
  
  public void resetSolverVariables(Cache paramCache)
  {
    super.resetSolverVariables(paramCache);
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ((ConstraintWidget)this.mChildren.get(i)).resetSolverVariables(paramCache);
      i += 1;
    }
  }
  
  public void setOffset(int paramInt1, int paramInt2)
  {
    super.setOffset(paramInt1, paramInt2);
    paramInt2 = this.mChildren.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      ((ConstraintWidget)this.mChildren.get(paramInt1)).setOffset(getRootX(), getRootY());
      paramInt1 += 1;
    }
  }
  
  public void updateDrawPosition()
  {
    super.updateDrawPosition();
    if (this.mChildren == null) {}
    for (;;)
    {
      return;
      int j = this.mChildren.size();
      int i = 0;
      while (i < j)
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
        localConstraintWidget.setOffset(getDrawX(), getDrawY());
        if (!(localConstraintWidget instanceof ConstraintWidgetContainer)) {
          localConstraintWidget.updateDrawPosition();
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.WidgetContainer
 * JD-Core Version:    0.7.0.1
 */