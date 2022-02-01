package com.tencent.mm.plugin.finder.cgi;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bdu;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderMVUserPage;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "finderUserName", "", "finderSelfUserName", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFinderUserName", "()Ljava/lang/String;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFinderItems", "getFinderObjects", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLastBuffer", "getType", "hasMore", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class by
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xds;
  private i callback;
  public d lKU;
  public int pullType;
  public final String whH;
  private List<? extends FinderItem> xcV;
  private final String xdr;
  
  static
  {
    AppMethodBeat.i(267539);
    xds = new a((byte)0);
    AppMethodBeat.o(267539);
  }
  
  public by(String paramString1, String paramString2, b paramb, int paramInt, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(267538);
    this.whH = paramString1;
    this.xdr = paramString2;
    paramString1 = new d.a();
    paramString1.vD(getType());
    paramString1.TW("/cgi-bin/micromsg-bin/findermvuserpage");
    paramString2 = new bdu();
    paramString2.finderUsername = this.xdr;
    paramString2.userName = this.whH;
    paramString2.lastBuffer = paramb;
    this.pullType = paramInt;
    paramb = ao.xcj;
    paramString2.RLM = ao.a(parambid);
    paramb = ao.xcj;
    paramString2.SCW = ao.dnP();
    paramString1.c((a)paramString2);
    paramString1.d((a)new bdv());
    paramString1 = paramString1.bgN();
    p.j(paramString1, "builder.buildInstance()");
    this.lKU = paramString1;
    Log.i("Finder.NetSceneFinderMVUserPage", "NetSceneFinderMVUserPage init finderUserName " + this.whH + " finderSelfUserName: " + this.xdr);
    AppMethodBeat.o(267538);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(267537);
    Log.i("Finder.NetSceneFinderMVUserPage", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject;
    LinkedList localLinkedList;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (this.lKU.bhY() == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
        AppMethodBeat.o(267537);
        throw paramString;
      }
      params = c.AnK;
      params = this.lKU.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
        AppMethodBeat.o(267537);
        throw paramString;
      }
      params = ((bdv)params).object;
      p.j(params, "(commReqResp.responsePro…serPageResponse).`object`");
      this.xcV = c.a.a((List)params, 33280, this.xbu);
      if (this.pullType != 2) {
        paramInt1 = 1;
      }
      while (paramInt1 != 0)
      {
        localObject = this.whH;
        params = (s)localObject;
        if (localObject == null) {
          params = z.bdh();
        }
        localObject = this.xcV;
        if (localObject != null)
        {
          localLinkedList = new LinkedList();
          localObject = ((Iterable)localObject).iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
              localLinkedList.add(new com.tencent.mm.plugin.finder.storage.data.q(0, localFinderItem.getFinderObject().id, localFinderItem.getFinderObject(), 33280));
              continue;
              paramInt1 = 0;
              break;
            }
          }
          if (localLinkedList.size() > 0)
          {
            localObject = k.Anu;
            if (!TextUtils.isEmpty((CharSequence)params)) {
              break label368;
            }
            localObject = z.bdh();
          }
        }
      }
    }
    for (;;)
    {
      p.j(localObject, "if (TextUtils.isEmpty(us…sername() else userName!!");
      k.a.a(17, (String)localObject, localLinkedList);
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.iCn();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.an.q)this);
      }
      AppMethodBeat.o(267537);
      return;
      label368:
      localObject = params;
      if (params == null)
      {
        p.iCn();
        localObject = params;
      }
    }
  }
  
  public final List<FinderItem> doA()
  {
    List localList2 = this.xcV;
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = (List)v.aaAd;
    }
    return localList1;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(267536);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(267536);
    return i;
  }
  
  public final int getType()
  {
    return 6628;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderMVUserPage$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.by
 * JD-Core Version:    0.7.0.1
 */