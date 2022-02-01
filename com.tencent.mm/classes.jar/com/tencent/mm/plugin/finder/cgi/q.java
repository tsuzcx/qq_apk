package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.ayi;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.tp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetBuzzword;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetBuzzwordResponse;", "idList", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "getIdList", "()Ljava/util/LinkedList;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends c<ayj>
{
  public static final q.a Azb;
  private final LinkedList<Long> Adz;
  
  static
  {
    AppMethodBeat.i(336431);
    Azb = new q.a((byte)0);
    AppMethodBeat.o(336431);
  }
  
  public q(LinkedList<Long> paramLinkedList)
  {
    AppMethodBeat.i(336424);
    this.Adz = paramLinkedList;
    paramLinkedList = new ayi();
    Object localObject = bi.ABn;
    paramLinkedList.YIY = bi.a(this.Auc);
    paramLinkedList.ZJc = this.Adz;
    localObject = new ayj();
    ((ayj)localObject).setBaseResponse(new kd());
    ((ayj)localObject).getBaseResponse().akjO = new etl();
    c.a locala = new c.a();
    locala.otE = ((a)paramLinkedList);
    locala.otF = ((a)localObject);
    locala.uri = "/cgi-bin/micromsg-bin/findergetbuzzword";
    locala.funcId = 7327;
    c(locala.bEF());
    Log.d("Finder.CgiFinderGetBuzzword", "init objectIdList = " + p.a((Iterable)this.Adz, null, null, null, 0, null, (b)1.Azc, 31) + ' ');
    AppMethodBeat.o(336424);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/BuzzwordInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<tp, CharSequence>
  {
    public static final b Azd;
    
    static
    {
      AppMethodBeat.i(336239);
      Azd = new b();
      AppMethodBeat.o(336239);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.q
 * JD-Core Version:    0.7.0.1
 */