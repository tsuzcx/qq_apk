package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.bp.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class t
  extends IListener<bp>
{
  public static final String yWf;
  
  static
  {
    AppMethodBeat.i(65222);
    yWf = com.tencent.mm.loader.j.b.aKB() + "/luckymoney/";
    AppMethodBeat.o(65222);
  }
  
  public t()
  {
    AppMethodBeat.i(160802);
    this.__eventId = bp.class.getName().hashCode();
    AppMethodBeat.o(160802);
  }
  
  public static String PK(int paramInt)
  {
    AppMethodBeat.i(65218);
    String str = yWf + paramInt + "/";
    AppMethodBeat.o(65218);
    return str;
  }
  
  public static void efh()
  {
    AppMethodBeat.i(65217);
    com.tencent.mm.pluginsdk.j.a.a.b.gnC();
    com.tencent.mm.pluginsdk.j.a.a.b.ahP(58);
    AppMethodBeat.o(65217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.t
 * JD-Core Version:    0.7.0.1
 */