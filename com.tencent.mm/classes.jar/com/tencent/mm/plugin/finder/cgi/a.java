package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.amc;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiCollectUnreadItem;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCollectUnreadResponse;", "unreadList", "", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.ak.a<amd>
{
  public static final a rPO;
  private final List<asz> rPN;
  
  static
  {
    AppMethodBeat.i(201436);
    rPO = new a((byte)0);
    AppMethodBeat.o(201436);
  }
  
  public a(List<? extends asz> paramList, arn paramarn)
  {
    AppMethodBeat.i(201435);
    this.rPN = paramList;
    paramList = new b.a();
    Object localObject1 = new amc();
    Object localObject2 = v.rRb;
    ((amc)localObject1).GEg = v.a(paramarn);
    ((amc)localObject1).GEw.addAll((Collection)this.rPN);
    paramList.c((com.tencent.mm.bw.a)localObject1);
    paramarn = new amd();
    paramarn.setBaseResponse(new BaseResponse());
    paramarn.getBaseResponse().ErrMsg = new cxn();
    paramList.d((com.tencent.mm.bw.a)paramarn);
    paramList.DN("/cgi-bin/micromsg-bin/findercollectunread");
    paramList.oS(3980);
    c(paramList.aDS());
    paramList = new StringBuilder("unreadList=");
    localObject1 = (Iterable)this.rPN;
    paramarn = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (asz)((Iterator)localObject1).next();
      StringBuilder localStringBuilder = new StringBuilder().append(c.rp(((asz)localObject2).rRn)).append(" sessionBuff=");
      if (((asz)localObject2).sessionBuffer != null) {}
      for (boolean bool = true;; bool = false)
      {
        paramarn.add(bool);
        break;
      }
    }
    ae.i("CgiCollectUnreadItem", (List)paramarn);
    AppMethodBeat.o(201435);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiCollectUnreadItem$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a
 * JD-Core Version:    0.7.0.1
 */