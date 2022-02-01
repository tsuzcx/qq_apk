package com.tencent.mm.plugin.findersdk.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.d.a.b.b.a;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/storage/config/FinderSdkConfig;", "", "()V", "FINDER_DEBUG_CGI_BLOCK_LIMIT_LOG", "", "getFINDER_DEBUG_CGI_BLOCK_LIMIT_LOG", "()Ljava/lang/String;", "setFINDER_DEBUG_CGI_BLOCK_LIMIT_LOG", "(Ljava/lang/String;)V", "FINDER_DEBUG_CGI_BLOCK_LIST_LOG", "getFINDER_DEBUG_CGI_BLOCK_LIST_LOG", "setFINDER_DEBUG_CGI_BLOCK_LIST_LOG", "FINDER_DEBUG_CGI_LOG", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "getFINDER_DEBUG_CGI_LOG", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "finder-sdk_release"})
public final class b
{
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Bwk;
  private static String Bwl;
  private static String Bwm;
  public static final b Bwn;
  
  static
  {
    AppMethodBeat.i(209526);
    Bwn = new b();
    Bwk = new a(0, "cgi流水").b("FINDER_FINDER_CGI_DEBUG_SWITCH", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "默认", "打开", "关闭" }));
    Bwl = "100, 60, 1000, 60";
    Bwm = "";
    AppMethodBeat.o(209526);
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ent()
  {
    return Bwk;
  }
  
  public static String enu()
  {
    AppMethodBeat.i(209524);
    String str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKv, "200, 60, 1000, 60");
    p.j(str, "MMKernel.service(IExptSe…mit, \"200, 60, 1000, 60\")");
    AppMethodBeat.o(209524);
    return str;
  }
  
  public static String env()
  {
    AppMethodBeat.i(209525);
    String str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKu, "");
    p.j(str, "MMKernel.service(IExptSe…finder_cgi_blocklist, \"\")");
    AppMethodBeat.o(209525);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.d.a.b
 * JD-Core Version:    0.7.0.1
 */