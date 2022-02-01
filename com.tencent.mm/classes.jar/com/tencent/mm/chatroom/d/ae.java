package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.as;
import com.tencent.mm.model.ab;

public final class ae
{
  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(184787);
    if (ab.Jf(paramString)) {}
    for (int i = 2;; i = 1)
    {
      as localas = new as();
      localas.ipq = localas.F("roomusrname", paramString, true);
      localas.ipr = paramInt1;
      localas.ips = i;
      localas.ipt = paramInt2;
      localas.ipu = paramInt3;
      localas.bMH();
      AppMethodBeat.o(184787);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.ae
 * JD-Core Version:    0.7.0.1
 */