package com.eclipsesource.mmv8.utils;

import com.eclipsesource.mmv8.ReferenceHandler;
import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8Locker;
import com.eclipsesource.mmv8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class MemoryManager
{
  private MemoryManagerReferenceHandler memoryManagerReferenceHandler;
  private ArrayList<V8Value> references;
  private boolean released;
  private boolean releasing;
  private V8 v8;
  
  public MemoryManager(V8 paramV8)
  {
    AppMethodBeat.i(61659);
    this.references = new ArrayList();
    this.releasing = false;
    this.released = false;
    this.v8 = paramV8;
    this.memoryManagerReferenceHandler = new MemoryManagerReferenceHandler(null);
    paramV8.addReferenceHandler(this.memoryManagerReferenceHandler);
    AppMethodBeat.o(61659);
  }
  
  private void checkReleased()
  {
    AppMethodBeat.i(61663);
    if (this.released)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Memory manager released");
      AppMethodBeat.o(61663);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(61663);
  }
  
  public int getObjectReferenceCount()
  {
    AppMethodBeat.i(61660);
    checkReleased();
    int i = this.references.size();
    AppMethodBeat.o(61660);
    return i;
  }
  
  public boolean isReleased()
  {
    return this.released;
  }
  
  public void persist(V8Value paramV8Value)
  {
    AppMethodBeat.i(61661);
    this.v8.getLocker().checkThread();
    checkReleased();
    this.references.remove(paramV8Value);
    AppMethodBeat.o(61661);
  }
  
  public void release()
  {
    AppMethodBeat.i(61662);
    this.v8.getLocker().checkThread();
    if (this.released)
    {
      AppMethodBeat.o(61662);
      return;
    }
    this.releasing = true;
    try
    {
      Iterator localIterator = this.references.iterator();
      while (localIterator.hasNext()) {
        ((V8Value)localIterator.next()).release();
      }
      this.v8.removeReferenceHandler(this.memoryManagerReferenceHandler);
    }
    finally
    {
      this.releasing = false;
      AppMethodBeat.o(61662);
    }
    this.references.clear();
    this.releasing = false;
    this.released = true;
    AppMethodBeat.o(61662);
  }
  
  class MemoryManagerReferenceHandler
    implements ReferenceHandler
  {
    private MemoryManagerReferenceHandler() {}
    
    public void v8HandleCreated(V8Value paramV8Value)
    {
      AppMethodBeat.i(61657);
      MemoryManager.this.references.add(paramV8Value);
      AppMethodBeat.o(61657);
    }
    
    public void v8HandleDisposed(V8Value paramV8Value)
    {
      AppMethodBeat.i(61658);
      if (!MemoryManager.this.releasing)
      {
        Iterator localIterator = MemoryManager.this.references.iterator();
        while (localIterator.hasNext()) {
          if (localIterator.next() == paramV8Value)
          {
            localIterator.remove();
            AppMethodBeat.o(61658);
            return;
          }
        }
      }
      AppMethodBeat.o(61658);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.MemoryManager
 * JD-Core Version:    0.7.0.1
 */