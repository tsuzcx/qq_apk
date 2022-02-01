package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aph;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiCollectUnreadItem;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCollectUnreadResponse;", "unreadList", "", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class a
  extends an<api>
{
  public static final a tsF;
  private final List<bdv> tsE;
  
  static
  {
    AppMethodBeat.i(242197);
    tsF = new a((byte)0);
    AppMethodBeat.o(242197);
  }
  
  public a(List<? extends bdv> paramList, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242196);
    this.tsE = paramList;
    paramList = new d.a();
    Object localObject1 = new aph();
    Object localObject2 = am.tuw;
    ((aph)localObject1).LAI = am.a(parambbn);
    ((aph)localObject1).LBq.addAll((Collection)this.tsE);
    paramList.c((com.tencent.mm.bw.a)localObject1);
    parambbn = new api();
    parambbn.setBaseResponse(new BaseResponse());
    parambbn.getBaseResponse().ErrMsg = new dqi();
    paramList.d((com.tencent.mm.bw.a)parambbn);
    paramList.MB("/cgi-bin/micromsg-bin/findercollectunread");
    paramList.sG(3980);
    c(paramList.aXF());
    paramList = new StringBuilder("unreadList=");
    localObject1 = (Iterable)this.tsE;
    parambbn = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bdv)((Iterator)localObject1).next();
      StringBuilder localStringBuilder = new StringBuilder().append(d.zs(((bdv)localObject2).hFK)).append(" sessionBuff=");
      if (((bdv)localObject2).sessionBuffer != null) {}
      for (boolean bool = true;; bool = false)
      {
        parambbn.add(bool);
        break;
      }
    }
    Log.i("CgiCollectUnreadItem", (List)parambbn);
    AppMethodBeat.o(242196);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiCollectUnreadItem$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a
 * JD-Core Version:    0.7.0.1
 */