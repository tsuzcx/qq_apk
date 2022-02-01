package com.tencent.mm.performance.jni.egl;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class EglResourceMonitor
{
  public String javaStack;
  public long nativeStackHash;
  public long resourceId;
  
  public EglResourceMonitor(long paramLong1, String paramString, long paramLong2)
  {
    this.resourceId = paramLong1;
    this.javaStack = paramString;
    this.nativeStackHash = paramLong2;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(195655);
    if (paramObject == null)
    {
      AppMethodBeat.o(195655);
      return false;
    }
    paramObject = (EglResourceMonitor)paramObject;
    if ((paramObject.nativeStackHash == this.nativeStackHash) && (paramObject.javaStack.equals(this.javaStack)))
    {
      AppMethodBeat.o(195655);
      return true;
    }
    AppMethodBeat.o(195655);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.performance.jni.egl.EglResourceMonitor
 * JD-Core Version:    0.7.0.1
 */