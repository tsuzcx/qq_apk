package com.tencent.mm.d.a;

import android.util.SparseArray;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Function;

abstract class r$b
{
  l ccm;
  V8Function ccn;
  int id;
  
  r$b(r paramr, l paraml, int paramInt, V8Function paramV8Function)
  {
    this.ccm = paraml;
    this.ccn = paramV8Function;
    this.id = paramInt;
  }
  
  final void a(V8Array paramV8Array)
  {
    if ((!this.ccn.isReleased()) && (!this.ccm.Cu().isReleased())) {
      this.ccn.call(this.ccm.Cu().getGlobalObject(), paramV8Array);
    }
  }
  
  void cancel()
  {
    cleanup();
  }
  
  void cleanup()
  {
    this.cch.cce.remove(this.id);
    this.ccn.release();
  }
  
  final boolean isValid()
  {
    return (!this.ccn.isReleased()) && (!this.ccm.Cu().isReleased());
  }
  
  abstract void schedule();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.d.a.r.b
 * JD-Core Version:    0.7.0.1
 */