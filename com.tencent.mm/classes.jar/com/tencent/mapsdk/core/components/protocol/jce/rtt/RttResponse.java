package com.tencent.mapsdk.core.components.protocol.jce.rtt;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class RttResponse
  extends MapJceStruct
  implements Cloneable
{
  static byte[] a;
  public byte[] result = null;
  
  static
  {
    AppMethodBeat.i(221201);
    if (!RttResponse.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      byte[] arrayOfByte = (byte[])new byte[1];
      a = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
      AppMethodBeat.o(221201);
      return;
    }
  }
  
  public RttResponse() {}
  
  public RttResponse(byte[] paramArrayOfByte)
  {
    this.result = paramArrayOfByte;
  }
  
  public final String className()
  {
    return "navsns.RttResponse";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(221240);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (b) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(221240);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(221240);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(221265);
    new k(paramStringBuilder, paramInt).a(this.result, "result");
    AppMethodBeat.o(221265);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(221271);
    new k(paramStringBuilder, paramInt).a(this.result, false);
    AppMethodBeat.o(221271);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(221225);
    if (paramObject == null)
    {
      AppMethodBeat.o(221225);
      return false;
    }
    paramObject = (RttResponse)paramObject;
    boolean bool = q.a(this.result, paramObject.result);
    AppMethodBeat.o(221225);
    return bool;
  }
  
  public final byte[] getResult()
  {
    return this.result;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(221232);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(221232);
      throw localException1;
    }
    catch (Exception localException2)
    {
      AppMethodBeat.o(221232);
    }
    return 0;
  }
  
  public final void readFrom(m paramm)
  {
    AppMethodBeat.i(221257);
    this.result = ((byte[])paramm.c(0, true));
    AppMethodBeat.o(221257);
  }
  
  public final void setResult(byte[] paramArrayOfByte)
  {
    this.result = paramArrayOfByte;
  }
  
  public final void writeTo(n paramn)
  {
    AppMethodBeat.i(221249);
    paramn.a(this.result, 0);
    AppMethodBeat.o(221249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.jce.rtt.RttResponse
 * JD-Core Version:    0.7.0.1
 */