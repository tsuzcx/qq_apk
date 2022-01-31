package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.ReferenceHandler;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Locker;
import com.eclipsesource.v8.V8Value;
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
    AppMethodBeat.i(75035);
    this.references = new ArrayList();
    this.releasing = false;
    this.released = false;
    this.v8 = paramV8;
    this.memoryManagerReferenceHandler = new MemoryManagerReferenceHandler(null);
    paramV8.addReferenceHandler(this.memoryManagerReferenceHandler);
    AppMethodBeat.o(75035);
  }
  
  private void checkReleased()
  {
    AppMethodBeat.i(75039);
    if (this.released)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Memory manager released");
      AppMethodBeat.o(75039);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(75039);
  }
  
  public int getObjectReferenceCount()
  {
    AppMethodBeat.i(75036);
    checkReleased();
    int i = this.references.size();
    AppMethodBeat.o(75036);
    return i;
  }
  
  public boolean isReleased()
  {
    return this.released;
  }
  
  public void persist(V8Value paramV8Value)
  {
    AppMethodBeat.i(75037);
    this.v8.getLocker().checkThread();
    checkReleased();
    this.references.remove(paramV8Value);
    AppMethodBeat.o(75037);
  }
  
  public void release()
  {
    AppMethodBeat.i(75038);
    this.v8.getLocker().checkThread();
    if (this.released)
    {
      AppMethodBeat.o(75038);
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
      AppMethodBeat.o(75038);
    }
    this.references.clear();
    this.releasing = false;
    this.released = true;
    AppMethodBeat.o(75038);
  }
  
  class MemoryManagerReferenceHandler
    implements ReferenceHandler
  {
    private MemoryManagerReferenceHandler() {}
    
    public void v8HandleCreated(V8Value paramV8Value)
    {
      AppMethodBeat.i(75033);
      MemoryManager.this.references.add(paramV8Value);
      AppMethodBeat.o(75033);
    }
    
    public void v8HandleDisposed(V8Value paramV8Value)
    {
      AppMethodBeat.i(75034);
      if (!MemoryManager.this.releasing)
      {
        Iterator localIterator = MemoryManager.this.references.iterator();
        while (localIterator.hasNext()) {
          if (localIterator.next() == paramV8Value)
          {
            localIterator.remove();
            AppMethodBeat.o(75034);
            return;
          }
        }
      }
      AppMethodBeat.o(75034);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.eclipsesource.v8.utils.MemoryManager
 * JD-Core Version:    0.7.0.1
 */