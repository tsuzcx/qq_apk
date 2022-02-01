package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bn.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class o
  extends c<bn>
{
  public static final String vBj;
  
  static
  {
    AppMethodBeat.i(65222);
    vBj = com.tencent.mm.loader.j.b.asb() + "/luckymoney/";
    AppMethodBeat.o(65222);
  }
  
  public o()
  {
    AppMethodBeat.i(160802);
    this.__eventId = bn.class.getName().hashCode();
    AppMethodBeat.o(160802);
  }
  
  public static String JI(int paramInt)
  {
    AppMethodBeat.i(65218);
    String str = vBj + paramInt + "/";
    AppMethodBeat.o(65218);
    return str;
  }
  
  public static void dln()
  {
    AppMethodBeat.i(65217);
    com.tencent.mm.pluginsdk.j.a.a.b.fes();
    com.tencent.mm.pluginsdk.j.a.a.b.Zd(58);
    AppMethodBeat.o(65217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.o
 * JD-Core Version:    0.7.0.1
 */