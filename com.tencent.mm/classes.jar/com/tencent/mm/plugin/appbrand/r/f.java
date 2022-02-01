package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.cev;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneOperateWxDataHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class f
{
  public static final f.a nhA;
  
  static
  {
    AppMethodBeat.i(229058);
    nhA = new f.a((byte)0);
    AppMethodBeat.o(229058);
  }
  
  public static final d.a id(boolean paramBoolean)
  {
    AppMethodBeat.i(229059);
    d.a locala = new d.a();
    locala.c((a)new ceu());
    locala.d((a)new cev());
    locala.setKeepAlive(paramBoolean);
    String str;
    if (paramBoolean)
    {
      str = "/cgi-bin/mmbiz-bin/js-operatewxdata-keepalive";
      locala.MB(str);
      if (!paramBoolean) {
        break label94;
      }
    }
    label94:
    for (int i = 4602;; i = 1133)
    {
      locala.sG(i);
      locala.sI(0);
      locala.sJ(0);
      AppMethodBeat.o(229059);
      return locala;
      str = "/cgi-bin/mmbiz-bin/js-operatewxdata";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.f
 * JD-Core Version:    0.7.0.1
 */