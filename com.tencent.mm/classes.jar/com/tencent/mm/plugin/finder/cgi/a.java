package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aja;
import com.tencent.mm.protocal.protobuf.ajb;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiCollectUnreadItem;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCollectUnreadResponse;", "unreadList", "", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.ak.a<ajb>
{
  public static final a.a qWH;
  private final List<aot> qWG;
  
  static
  {
    AppMethodBeat.i(201098);
    qWH = new a.a((byte)0);
    AppMethodBeat.o(201098);
  }
  
  public a(List<? extends aot> paramList, anm paramanm)
  {
    AppMethodBeat.i(201097);
    this.qWG = paramList;
    paramList = new b.a();
    Object localObject1 = new aja();
    Object localObject2 = q.qXH;
    ((aja)localObject1).EDu = q.a(paramanm);
    ((aja)localObject1).EDJ.addAll((Collection)this.qWG);
    paramList.c((com.tencent.mm.bw.a)localObject1);
    paramanm = new ajb();
    paramanm.setBaseResponse(new BaseResponse());
    paramanm.getBaseResponse().ErrMsg = new crm();
    paramList.d((com.tencent.mm.bw.a)paramanm);
    paramList.Am("/cgi-bin/micromsg-bin/findercollectunread");
    paramList.op(3980);
    c(paramList.aAz());
    paramList = new StringBuilder("unreadList=");
    localObject1 = (Iterable)this.qWG;
    paramanm = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aot)((Iterator)localObject1).next();
      StringBuilder localStringBuilder = new StringBuilder().append(c.pb(((aot)localObject2).qXP)).append(" sessionBuff=");
      if (((aot)localObject2).sessionBuffer != null) {}
      for (boolean bool = true;; bool = false)
      {
        paramanm.add(bool);
        break;
      }
    }
    ac.i("CgiCollectUnreadItem", (List)paramanm);
    AppMethodBeat.o(201097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a
 * JD-Core Version:    0.7.0.1
 */