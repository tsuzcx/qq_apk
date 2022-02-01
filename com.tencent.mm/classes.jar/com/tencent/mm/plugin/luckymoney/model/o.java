package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bn.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class o
  extends c<bn>
{
  public static final String vpe;
  
  static
  {
    AppMethodBeat.i(65222);
    vpe = com.tencent.mm.loader.j.b.arM() + "/luckymoney/";
    AppMethodBeat.o(65222);
  }
  
  public o()
  {
    AppMethodBeat.i(160802);
    this.__eventId = bn.class.getName().hashCode();
    AppMethodBeat.o(160802);
  }
  
  public static String Jj(int paramInt)
  {
    AppMethodBeat.i(65218);
    String str = vpe + paramInt + "/";
    AppMethodBeat.o(65218);
    return str;
  }
  
  public static void dio()
  {
    AppMethodBeat.i(65217);
    com.tencent.mm.pluginsdk.j.a.a.b.faE();
    com.tencent.mm.pluginsdk.j.a.a.b.Yx(58);
    AppMethodBeat.o(65217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.o
 * JD-Core Version:    0.7.0.1
 */