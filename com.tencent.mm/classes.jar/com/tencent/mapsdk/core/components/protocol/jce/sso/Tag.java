package com.tencent.mapsdk.core.components.protocol.jce.sso;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Tag
  extends MapJceStruct
  implements Cloneable
{
  static byte[] a;
  public String strId = "";
  public byte[] value = null;
  
  static
  {
    AppMethodBeat.i(221276);
    if (!Tag.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      AppMethodBeat.o(221276);
      return;
    }
  }
  
  public Tag() {}
  
  public Tag(String paramString, byte[] paramArrayOfByte)
  {
    this.strId = paramString;
    this.value = paramArrayOfByte;
  }
  
  public final String className()
  {
    return "sosomap.Tag";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(221301);
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
      AppMethodBeat.o(221301);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(221301);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(221320);
    paramStringBuilder = new k(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.strId, "strId");
    paramStringBuilder.a(this.value, "value");
    AppMethodBeat.o(221320);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(221325);
    paramStringBuilder = new k(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.strId, true);
    paramStringBuilder.a(this.value, false);
    AppMethodBeat.o(221325);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(221288);
    if (paramObject == null)
    {
      AppMethodBeat.o(221288);
      return false;
    }
    paramObject = (Tag)paramObject;
    if ((q.a(this.strId, paramObject.strId)) && (q.a(this.value, paramObject.value)))
    {
      AppMethodBeat.o(221288);
      return true;
    }
    AppMethodBeat.o(221288);
    return false;
  }
  
  public final byte[] getValue()
  {
    return this.value;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(221293);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(221293);
      throw localException1;
    }
    catch (Exception localException2)
    {
      AppMethodBeat.o(221293);
    }
    return 0;
  }
  
  public final void readFrom(m paramm)
  {
    AppMethodBeat.i(221313);
    this.strId = paramm.b(0, true);
    if (a == null)
    {
      byte[] arrayOfByte = new byte[1];
      a = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    this.value = paramm.c(1, true);
    AppMethodBeat.o(221313);
  }
  
  public final void writeTo(n paramn)
  {
    AppMethodBeat.i(221307);
    paramn.a(this.strId, 0);
    paramn.a(this.value, 1);
    AppMethodBeat.o(221307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.jce.sso.Tag
 * JD-Core Version:    0.7.0.1
 */