package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.abk;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiCheckPrefetch;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCheckPrefetchResponse;", "tabType", "", "feedIdList", "", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(ILjava/util/List;Lcom/tencent/mm/protobuf/ByteString;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCheckPrefetchRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c<aup>
{
  public static final a Ayk;
  private final List<Long> Ayl;
  private auo Aym;
  private final int hJx;
  private final com.tencent.mm.bx.b lastBuffer;
  
  static
  {
    AppMethodBeat.i(336313);
    Ayk = new a((byte)0);
    AppMethodBeat.o(336313);
  }
  
  public b(int paramInt, List<Long> paramList, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(336293);
    this.hJx = paramInt;
    this.Ayl = paramList;
    this.lastBuffer = paramb;
    this.Aym = new auo();
    this.Aym.ZEV = this.lastBuffer;
    paramList = this.Aym;
    paramb = new LinkedList();
    paramb.addAll((Collection)this.Ayl);
    ah localah = ah.aiuX;
    paramList.hrX = paramb;
    Log.i("CgiCheckPrefetch", "initCommReqResp: tabType = " + this.hJx + ", feedIds:" + p.a((Iterable)this.Ayl, (CharSequence)";", null, null, 0, null, null, 62) + " lastBuffer " + this.lastBuffer);
    paramList = new c.a();
    paramList.otE = ((com.tencent.mm.bx.a)this.Aym);
    paramb = new aup();
    paramb.setBaseResponse(new kd());
    paramb.getBaseResponse().akjO = new etl();
    paramList.otF = ((com.tencent.mm.bx.a)paramb);
    paramList.uri = "/cgi-bin/micromsg-bin/findercheckprefetch";
    paramList.funcId = 6658;
    c(paramList.bEF());
    AppMethodBeat.o(336293);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiCheckPrefetch$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/CheckResult;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<abk, CharSequence>
  {
    public static final b Ayn;
    
    static
    {
      AppMethodBeat.i(336882);
      Ayn = new b();
      AppMethodBeat.o(336882);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(List<? extends abk> paramList, b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.b
 * JD-Core Version:    0.7.0.1
 */