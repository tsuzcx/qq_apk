package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class ar<C>
{
  private Set<C> MS = new HashSet();
  
  public final void addAll(List<C> paramList)
  {
    this.MS.addAll(paramList);
  }
  
  public abstract ar<C> fY();
  
  public final List<C> kt()
  {
    return Collections.unmodifiableList(new ArrayList(this.MS));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.ar
 * JD-Core Version:    0.7.0.1
 */