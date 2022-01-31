package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;

public final class q
{
  private static ArrayList<cm> fJT;
  private static ArrayList<ad> fJU;
  
  static
  {
    AppMethodBeat.i(16517);
    fJT = new ArrayList();
    fJU = new ArrayList();
    AppMethodBeat.o(16517);
  }
  
  public static void cy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16514);
    aw.RO().ac(new q.1(paramInt1, paramInt2));
    AppMethodBeat.o(16514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelmulti.q
 * JD-Core Version:    0.7.0.1
 */