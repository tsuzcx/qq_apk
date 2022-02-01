package com.tencent.mm.opensdk.channel.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static byte[] a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(3826);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramString1 != null) {
      localStringBuffer.append(paramString1);
    }
    localStringBuffer.append(paramInt);
    localStringBuffer.append(paramString2);
    localStringBuffer.append("mMcShCsTr");
    paramString1 = com.tencent.mm.opensdk.utils.b.c(localStringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    AppMethodBeat.o(3826);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.channel.a.b
 * JD-Core Version:    0.7.0.1
 */