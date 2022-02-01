package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dyg;
import com.tencent.mm.protocal.protobuf.dyh;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzy;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiCollectUnreadItem;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCollectUnreadResponse;", "unreadList", "", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class k
  extends com.tencent.mm.al.a<dyh>
{
  public static final a KJk;
  private final List<dzy> KJj;
  
  static
  {
    AppMethodBeat.i(197245);
    KJk = new a((byte)0);
    AppMethodBeat.o(197245);
  }
  
  public k(List<? extends dzy> paramList, dzp paramdzp)
  {
    AppMethodBeat.i(197244);
    this.KJj = paramList;
    paramList = new b.a();
    Object localObject = new dyg();
    am localam = am.KJy;
    ((dyg)localObject).DlF = am.a(paramdzp);
    ((dyg)localObject).Lxn.addAll((Collection)this.KJj);
    paramList.c((com.tencent.mm.bx.a)localObject);
    paramdzp = new dyh();
    paramdzp.setBaseResponse(new BaseResponse());
    paramdzp.getBaseResponse().ErrMsg = new cmf();
    paramList.d((com.tencent.mm.bx.a)paramdzp);
    paramList.wg("/cgi-bin/micromsg-bin/findercollectunread");
    paramList.nB(3980);
    c(paramList.atI());
    paramList = new StringBuilder("unreadList=");
    localObject = (Iterable)this.KJj;
    paramdzp = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramdzp.add(c.ly(((dzy)((Iterator)localObject).next()).objectId));
    }
    ad.i("CgiCollectUnreadItem", (List)paramdzp);
    AppMethodBeat.o(197244);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiCollectUnreadItem$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.k
 * JD-Core Version:    0.7.0.1
 */