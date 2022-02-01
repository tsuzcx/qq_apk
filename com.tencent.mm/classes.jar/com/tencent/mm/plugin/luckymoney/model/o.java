package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.bk.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class o
  extends c<bk>
{
  public static final String umy;
  
  static
  {
    AppMethodBeat.i(65222);
    umy = com.tencent.mm.loader.j.b.aoZ() + "/luckymoney/";
    AppMethodBeat.o(65222);
  }
  
  public o()
  {
    AppMethodBeat.i(160802);
    this.__eventId = bk.class.getName().hashCode();
    AppMethodBeat.o(160802);
  }
  
  public static String HN(int paramInt)
  {
    AppMethodBeat.i(65218);
    String str = umy + paramInt + "/";
    AppMethodBeat.o(65218);
    return str;
  }
  
  public static void cZc()
  {
    AppMethodBeat.i(65217);
    com.tencent.mm.pluginsdk.h.a.a.b.eLH();
    com.tencent.mm.pluginsdk.h.a.a.b.WB(58);
    AppMethodBeat.o(65217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.o
 * JD-Core Version:    0.7.0.1
 */