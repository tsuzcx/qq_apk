package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.ReferenceHandler;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Locker;
import com.eclipsesource.v8.V8Value;
import java.util.ArrayList;
import java.util.Iterator;

public class MemoryManager
{
  private MemoryManagerReferenceHandler memoryManagerReferenceHandler;
  private ArrayList<V8Value> references = new ArrayList();
  private boolean released = false;
  private boolean releasing = false;
  private V8 v8;
  
  public MemoryManager(V8 paramV8)
  {
    this.v8 = paramV8;
    this.memoryManagerReferenceHandler = new MemoryManagerReferenceHandler(null);
    paramV8.addReferenceHandler(this.memoryManagerReferenceHandler);
  }
  
  private void checkReleased()
  {
    if (this.released) {
      throw new IllegalStateException("Memory manager released");
    }
  }
  
  public int getObjectReferenceCount()
  {
    checkReleased();
    return this.references.size();
  }
  
  public boolean isReleased()
  {
    return this.released;
  }
  
  public void persist(V8Value paramV8Value)
  {
    this.v8.getLocker().checkThread();
    checkReleased();
    this.references.remove(paramV8Value);
  }
  
  public void release()
  {
    this.v8.getLocker().checkThread();
    if (this.released) {
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
    }
    this.references.clear();
    this.releasing = false;
    this.released = true;
  }
  
  private class MemoryManagerReferenceHandler
    implements ReferenceHandler
  {
    private MemoryManagerReferenceHandler() {}
    
    public void v8HandleCreated(V8Value paramV8Value)
    {
      MemoryManager.this.references.add(paramV8Value);
    }
    
    public void v8HandleDisposed(V8Value paramV8Value)
    {
      if (!MemoryManager.this.releasing)
      {
        Iterator localIterator = MemoryManager.this.references.iterator();
        while (localIterator.hasNext()) {
          if (localIterator.next() == paramV8Value) {
            localIterator.remove();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.eclipsesource.v8.utils.MemoryManager
 * JD-Core Version:    0.7.0.1
 */