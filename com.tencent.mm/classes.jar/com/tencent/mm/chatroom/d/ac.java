package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mj;
import com.tencent.mm.autogen.mmdata.rpt.mk;
import com.tencent.mm.autogen.mmdata.rpt.ml;
import com.tencent.mm.model.ab;

public final class ac
{
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    AppMethodBeat.i(241443);
    int i = 1;
    if (ab.Jf(paramString1)) {
      i = 2;
    }
    ml localml = new ml();
    localml.uU(paramString1);
    localml.ips = i;
    localml.jbD = paramInt1;
    localml.iLz = paramInt2;
    localml.ila = paramInt3;
    localml.jbG = paramInt4;
    localml.uV(paramString2);
    localml.uW(paramString3);
    localml.bMH();
    AppMethodBeat.o(241443);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(241446);
    int i = 0;
    if (ab.Jf(paramString1)) {
      i = 2;
    }
    for (;;)
    {
      mk localmk = new mk();
      localmk.uR(paramString1);
      localmk.ips = i;
      localmk.iLz = paramInt1;
      localmk.ila = paramInt2;
      localmk.jbD = paramInt3;
      localmk.uS(paramString2);
      localmk.uT(paramString3);
      localmk.bMH();
      AppMethodBeat.o(241446);
      return;
      if (ab.Je(paramString1)) {
        i = 1;
      }
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(241444);
    int i = 0;
    if (ab.Jf(paramString1)) {
      i = 2;
    }
    for (;;)
    {
      mj localmj = new mj();
      localmj.uO(paramString1);
      localmj.ips = i;
      localmj.iLz = paramInt1;
      localmj.iuA = paramInt2;
      localmj.aIS();
      localmj.uP(paramString2);
      localmj.uQ(paramString3);
      localmj.bMH();
      AppMethodBeat.o(241444);
      return;
      if (ab.Je(paramString1)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.ac
 * JD-Core Version:    0.7.0.1
 */