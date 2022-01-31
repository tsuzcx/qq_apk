package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Object;

public class EventData
  implements Releasable
{
  protected V8Object v8Object;
  
  EventData(V8Object paramV8Object)
  {
    this.v8Object = paramV8Object.twin();
  }
  
  public void release()
  {
    if (!this.v8Object.isReleased()) {
      this.v8Object.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.debug.EventData
 * JD-Core Version:    0.7.0.1
 */