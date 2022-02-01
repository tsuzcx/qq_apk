package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jq
  extends jh
{
  public String a;
  
  public jq() {}
  
  private jq(String paramString)
  {
    this.a = paramString;
  }
  
  public final int a()
  {
    AppMethodBeat.i(224171);
    int i = b().length;
    AppMethodBeat.o(224171);
    return i;
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224190);
    this.a = new String(paramArrayOfByte);
    AppMethodBeat.o(224190);
  }
  
  public final byte[] b()
  {
    AppMethodBeat.i(224181);
    if (this.a != null)
    {
      byte[] arrayOfByte = this.a.getBytes();
      AppMethodBeat.o(224181);
      return arrayOfByte;
    }
    AppMethodBeat.o(224181);
    return new byte[0];
  }
  
  public final String toString()
  {
    AppMethodBeat.i(224196);
    String str = "StringData{strData='" + this.a + '\'' + '}';
    AppMethodBeat.o(224196);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jq
 * JD-Core Version:    0.7.0.1
 */