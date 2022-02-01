package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alq;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiCollectUnreadItem;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCollectUnreadResponse;", "unreadList", "", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.al.a<alr>
{
  public static final a rHD;
  private final List<ask> rHC;
  
  static
  {
    AppMethodBeat.i(201014);
    rHD = new a((byte)0);
    AppMethodBeat.o(201014);
  }
  
  public a(List<? extends ask> paramList, aqy paramaqy)
  {
    AppMethodBeat.i(201013);
    this.rHC = paramList;
    paramList = new b.a();
    Object localObject1 = new alq();
    Object localObject2 = v.rIR;
    ((alq)localObject1).Gle = v.a(paramaqy);
    ((alq)localObject1).Glt.addAll((Collection)this.rHC);
    paramList.c((com.tencent.mm.bx.a)localObject1);
    paramaqy = new alr();
    paramaqy.setBaseResponse(new BaseResponse());
    paramaqy.getBaseResponse().ErrMsg = new cwt();
    paramList.d((com.tencent.mm.bx.a)paramaqy);
    paramList.Dl("/cgi-bin/micromsg-bin/findercollectunread");
    paramList.oP(3980);
    c(paramList.aDC());
    paramList = new StringBuilder("unreadList=");
    localObject1 = (Iterable)this.rHC;
    paramaqy = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ask)((Iterator)localObject1).next();
      StringBuilder localStringBuilder = new StringBuilder().append(c.rc(((ask)localObject2).rIZ)).append(" sessionBuff=");
      if (((ask)localObject2).sessionBuffer != null) {}
      for (boolean bool = true;; bool = false)
      {
        paramaqy.add(bool);
        break;
      }
    }
    ad.i("CgiCollectUnreadItem", (List)paramaqy);
    AppMethodBeat.o(201013);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiCollectUnreadItem$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a
 * JD-Core Version:    0.7.0.1
 */