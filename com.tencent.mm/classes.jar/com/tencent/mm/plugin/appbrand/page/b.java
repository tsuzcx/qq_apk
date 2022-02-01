package com.tencent.mm.plugin.appbrand.page;

import java.util.Iterator;
import java.util.LinkedList;

abstract class b
  implements ce
{
  protected final LinkedList<cd> ttz = new LinkedList();
  
  public final void a(cd paramcd)
  {
    this.ttz.addLast(paramcd);
  }
  
  public final boolean aom()
  {
    if (this.ttz.size() > 0)
    {
      this.ttz.removeLast();
      return true;
    }
    return false;
  }
  
  public final cd cDM()
  {
    return (cd)this.ttz.peekLast();
  }
  
  public final void clear()
  {
    this.ttz.clear();
  }
  
  public final boolean isEmpty()
  {
    return this.ttz.isEmpty();
  }
  
  public Iterator<cd> iterator()
  {
    return this.ttz.iterator();
  }
  
  public final int size()
  {
    return this.ttz.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b
 * JD-Core Version:    0.7.0.1
 */