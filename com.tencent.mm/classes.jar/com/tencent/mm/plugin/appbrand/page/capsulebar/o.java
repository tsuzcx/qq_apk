package com.tencent.mm.plugin.appbrand.page.capsulebar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public abstract class o
  extends h
{
  private final LinkedList<o.a> tCE = new LinkedList()
  {
    public final boolean remove(Object paramAnonymousObject)
    {
      AppMethodBeat.i(135289);
      boolean bool = super.remove(paramAnonymousObject);
      o.a(o.this);
      AppMethodBeat.o(135289);
      return bool;
    }
  };
  
  protected final void afb(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    while (this.tCE.peekFirst() != null) {
      if (((o.a)this.tCE.peekFirst()).tag.equals(paramString)) {
        this.tCE.remove(this.tCE.peekFirst());
      } else {
        localLinkedList.addLast((o.a)this.tCE.pollFirst());
      }
    }
    this.tCE.addAll(localLinkedList);
  }
  
  public final m.a kA(boolean paramBoolean)
  {
    o.a locala = new o.a(this, paramBoolean);
    LinkedList localLinkedList = new LinkedList();
    if (paramBoolean) {
      this.tCE.addFirst(locala);
    }
    for (;;)
    {
      return locala;
      while ((this.tCE.peekFirst() != null) && (((o.a)this.tCE.peekFirst()).tCG)) {
        localLinkedList.addFirst((o.a)this.tCE.pollFirst());
      }
      this.tCE.addFirst(locala);
      while (localLinkedList.peekFirst() != null) {
        this.tCE.addFirst((o.a)localLinkedList.pollFirst());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.o
 * JD-Core Version:    0.7.0.1
 */