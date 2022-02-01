package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.f.c;
import com.tencent.mm.pluginsdk.ui.applet.j;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.d.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherDebugUtils;", "", "()V", "TAG", "", "getA8KeyUrlForDebug", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "httpGetForDebug", "", "savedFile", "Lcom/tencent/mm/vfs/VFSFile;", "receiveHeaders", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "headers", "", "plugin-brandservice_release"})
public final class u
{
  public static final u sPI;
  
  static
  {
    AppMethodBeat.i(266768);
    sPI = new u();
    AppMethodBeat.o(266768);
  }
  
  public static final Object a(String paramString, kotlin.d.d<? super String> paramd)
  {
    AppMethodBeat.i(266767);
    kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.k(paramd));
    kotlin.d.d locald = (kotlin.d.d)localh;
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label104;
      }
      localObject = paramString;
      if (paramString == null) {
        localObject = "";
      }
      paramString = Result.Companion;
      locald.resumeWith(Result.constructor-impl(localObject));
    }
    for (;;)
    {
      paramString = localh.iBS();
      if (paramString == a.aaAA) {
        p.k(paramd, "frame");
      }
      AppMethodBeat.o(266767);
      return paramString;
      i = 0;
      break;
      label104:
      new c().a(paramString, 0, (IPCRunCgi.a)new a(locald));
    }
  }
  
  private static boolean a(String paramString, com.tencent.mm.vfs.q paramq, kotlin.g.a.b<? super Map<String, ? extends List<String>>, x> paramb)
  {
    AppMethodBeat.i(266765);
    p.k(paramString, "url");
    p.k(paramq, "savedFile");
    p.k(paramb, "receiveHeaders");
    Object localObject = com.tencent.mm.pluginsdk.ui.applet.h.Rfk;
    localObject = com.tencent.mm.pluginsdk.ui.applet.h.a(paramString, false, (j)new k(0), paramb);
    if (localObject != null)
    {
      paramb = ((com.tencent.mm.ay.a.d.b)localObject).data;
      paramString = paramb;
      if (paramb != null) {}
    }
    else
    {
      paramString = new byte[0];
    }
    paramb = new String(paramString, kotlin.n.d.UTF_8);
    if (localObject != null)
    {
      paramString = ((com.tencent.mm.ay.a.d.b)localObject).data;
      if (paramString == null) {}
    }
    for (paramString = Integer.valueOf(paramString.length);; paramString = null)
    {
      Log.i("MicroMsg.WebPrefetcherDebugUtils", "httpGetForDebug response.data: %s, %s", new Object[] { paramb, paramString });
      if (localObject == null) {
        break label179;
      }
      try
      {
        paramString = com.tencent.mm.vfs.u.an(paramq);
        p.j(paramString, "VFSFileOp.openWrite(savedFile)");
        paramString.write(((com.tencent.mm.ay.a.d.b)localObject).data, 0, ((com.tencent.mm.ay.a.d.b)localObject).data.length);
        paramString.flush();
        paramString.close();
        AppMethodBeat.o(266765);
        return true;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.WebPrefetcherDebugUtils", (Throwable)paramString, "httpGet exception", new Object[0]);
      }
    }
    label179:
    AppMethodBeat.o(266765);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(kotlin.d.d paramd) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd)
    {
      AppMethodBeat.i(266073);
      Log.d("MicroMsg.WebPrefetcherDebugUtils", "getA8KeyUrlForDebug callback errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramd != null) {}
        for (paramString = paramd.bhY();; paramString = null)
        {
          paramd = paramString;
          if (!(paramString instanceof bot)) {
            paramd = null;
          }
          paramString = (bot)paramd;
          kotlin.d.d locald = this.sOD;
          if (paramString != null)
          {
            paramd = paramString.Tao;
            paramString = paramd;
            if (paramd != null) {}
          }
          else
          {
            paramString = "";
          }
          paramd = Result.Companion;
          locald.resumeWith(Result.constructor-impl(paramString));
          AppMethodBeat.o(266073);
          return;
        }
      }
      paramString = this.sOD;
      paramd = Result.Companion;
      paramString.resumeWith(Result.constructor-impl(""));
      AppMethodBeat.o(266073);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Map<String, ? extends List<? extends String>>, x>
  {
    public static final b sPJ;
    
    static
    {
      AppMethodBeat.i(267010);
      sPJ = new b();
      AppMethodBeat.o(267010);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.u
 * JD-Core Version:    0.7.0.1
 */