package com.tencent.mm.plugin.findersdk.storage.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.storage.config.a.b.a;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/storage/config/FinderSdkConfig;", "", "()V", "FINDER_DEBUG_CGI_BLOCK_LIMIT_LOG", "", "getFINDER_DEBUG_CGI_BLOCK_LIMIT_LOG", "()Ljava/lang/String;", "setFINDER_DEBUG_CGI_BLOCK_LIMIT_LOG", "(Ljava/lang/String;)V", "FINDER_DEBUG_CGI_BLOCK_LIST_LOG", "getFINDER_DEBUG_CGI_BLOCK_LIST_LOG", "setFINDER_DEBUG_CGI_BLOCK_LIST_LOG", "FINDER_DEBUG_CGI_LOG", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "getFINDER_DEBUG_CGI_LOG", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Hdw;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> Hdx;
  private static String Hdy;
  private static String Hdz;
  
  static
  {
    AppMethodBeat.i(273781);
    Hdw = new b();
    Hdx = new a(0, "cgi流水").c("FINDER_FINDER_CGI_DEBUG_SWITCH", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), p.listOf(new String[] { "默认", "打开", "关闭" }));
    Hdy = "100, 60, 1000, 60";
    Hdz = "";
    AppMethodBeat.o(273781);
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> fsf()
  {
    return Hdx;
  }
  
  public static String fsg()
  {
    AppMethodBeat.i(273763);
    String str = ((c)h.ax(c.class)).a(c.a.zaP, "200, 60, 1000, 60");
    s.s(str, "service(IExptService::cl…mit, \"200, 60, 1000, 60\")");
    AppMethodBeat.o(273763);
    return str;
  }
  
  public static String fsh()
  {
    AppMethodBeat.i(273771);
    String str = ((c)h.ax(c.class)).a(c.a.zaO, "");
    s.s(str, "service(IExptService::cl…finder_cgi_blocklist, \"\")");
    AppMethodBeat.o(273771);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.storage.config.b
 * JD-Core Version:    0.7.0.1
 */