package android.support.constraint.solver.widgets;

import java.util.HashSet;
import java.util.Iterator;

public class ResolutionNode
{
  public static final int REMOVED = 2;
  public static final int RESOLVED = 1;
  public static final int UNRESOLVED = 0;
  HashSet<ResolutionNode> dependents = new HashSet(2);
  int state = 0;
  
  public void addDependent(ResolutionNode paramResolutionNode)
  {
    this.dependents.add(paramResolutionNode);
  }
  
  public void didResolve()
  {
    this.state = 1;
    Iterator localIterator = this.dependents.iterator();
    while (localIterator.hasNext()) {
      ((ResolutionNode)localIterator.next()).resolve();
    }
  }
  
  public void invalidate()
  {
    this.state = 0;
    Iterator localIterator = this.dependents.iterator();
    while (localIterator.hasNext()) {
      ((ResolutionNode)localIterator.next()).invalidate();
    }
  }
  
  public void invalidateAnchors()
  {
    if ((this instanceof ResolutionAnchor)) {
      this.state = 0;
    }
    Iterator localIterator = this.dependents.iterator();
    while (localIterator.hasNext()) {
      ((ResolutionNode)localIterator.next()).invalidateAnchors();
    }
  }
  
  public boolean isResolved()
  {
    return this.state == 1;
  }
  
  public void remove(ResolutionDimension paramResolutionDimension) {}
  
  public void reset()
  {
    this.state = 0;
    this.dependents.clear();
  }
  
  public void resolve() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.ResolutionNode
 * JD-Core Version:    0.7.0.1
 */