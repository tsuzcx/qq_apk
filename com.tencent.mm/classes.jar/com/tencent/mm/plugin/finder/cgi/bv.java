package com.tencent.mm.plugin.finder.cgi;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.storage.data.r;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aya;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderMVUserPage;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "finderUserName", "", "finderSelfUserName", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFinderUserName", "()Ljava/lang/String;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFinderItems", "getFinderObjects", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLastBuffer", "getType", "hasMore", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bv
  extends ax
{
  public static final a tvI;
  private i callback;
  public d iUB;
  public int pullType;
  public final String sBN;
  private final String tvH;
  private List<? extends FinderItem> tvo;
  
  static
  {
    AppMethodBeat.i(242476);
    tvI = new a((byte)0);
    AppMethodBeat.o(242476);
  }
  
  public bv(String paramString1, String paramString2, b paramb, int paramInt, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242475);
    this.sBN = paramString1;
    this.tvH = paramString2;
    paramString1 = new d.a();
    paramString1.sG(getType());
    paramString1.MB("/cgi-bin/micromsg-bin/findermvuserpage");
    paramString2 = new aya();
    paramString2.finderUsername = this.tvH;
    paramString2.userName = this.sBN;
    paramString2.lastBuffer = paramb;
    this.pullType = paramInt;
    paramb = am.tuw;
    paramString2.LBM = am.a(parambbn);
    paramb = am.tuw;
    paramString2.LAv = am.cXZ();
    paramString1.c((a)paramString2);
    paramString1.d((a)new ayb());
    paramString1 = paramString1.aXF();
    p.g(paramString1, "builder.buildInstance()");
    this.iUB = paramString1;
    Log.i("Finder.NetSceneFinderMVUserPage", "NetSceneFinderMVUserPage init finderUserName " + this.sBN + " finderSelfUserName: " + this.tvH);
    AppMethodBeat.o(242475);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242474);
    Log.i("Finder.NetSceneFinderMVUserPage", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject;
    LinkedList localLinkedList;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (this.iUB.aYK() == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
        AppMethodBeat.o(242474);
        throw paramString;
      }
      params = c.vGN;
      params = this.iUB.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
        AppMethodBeat.o(242474);
        throw paramString;
      }
      params = ((ayb)params).object;
      p.g(params, "(commReqResp.responsePro…serPageResponse).`object`");
      this.tvo = c.a.a((List)params, 33280, this.ttO);
      if (this.pullType != 2) {
        paramInt1 = 1;
      }
      while (paramInt1 != 0)
      {
        localObject = this.sBN;
        params = (s)localObject;
        if (localObject == null) {
          params = z.aUg();
        }
        localObject = this.tvo;
        if (localObject != null)
        {
          localLinkedList = new LinkedList();
          localObject = ((Iterable)localObject).iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
              localLinkedList.add(new r(0, localFinderItem.getFinderObject().id, localFinderItem.getFinderObject(), 33280));
              continue;
              paramInt1 = 0;
              break;
            }
          }
          if (localLinkedList.size() > 0)
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            if (!TextUtils.isEmpty((CharSequence)params)) {
              break label368;
            }
            localObject = z.aUg();
          }
        }
      }
    }
    for (;;)
    {
      p.g(localObject, "if (TextUtils.isEmpty(us…sername() else userName!!");
      l.a.a(17, (String)localObject, localLinkedList);
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.hyc();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(242474);
      return;
      label368:
      localObject = params;
      if (params == null)
      {
        p.hyc();
        localObject = params;
      }
    }
  }
  
  public final List<FinderItem> cYL()
  {
    List localList2 = this.tvo;
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = (List)v.SXr;
    }
    return localList1;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242473);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (m)this);
    AppMethodBeat.o(242473);
    return i;
  }
  
  public final int getType()
  {
    return 6628;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderMVUserPage$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bv
 * JD-Core Version:    0.7.0.1
 */