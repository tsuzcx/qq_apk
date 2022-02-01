package com.tencent.mm.plugin.finder.cgi;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.data.r;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderMVUserPage;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "finderUserName", "", "finderSelfUserName", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFinderUserName", "()Ljava/lang/String;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFinderItems", "getFinderObjects", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLastBuffer", "getType", "hasMore", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cw
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final cw.a ACM;
  private final String ACN;
  private List<? extends FinderItem> ACl;
  private com.tencent.mm.am.h callback;
  public c oDw;
  public int pullType;
  public final String zDJ;
  
  static
  {
    AppMethodBeat.i(336625);
    ACM = new cw.a((byte)0);
    AppMethodBeat.o(336625);
  }
  
  public cw(String paramString1, String paramString2, b paramb, int paramInt, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336621);
    this.zDJ = paramString1;
    this.ACN = paramString2;
    paramString1 = new c.a();
    paramString1.funcId = getType();
    paramString1.uri = "/cgi-bin/micromsg-bin/findermvuserpage";
    paramString2 = new bos();
    paramString2.finderUsername = this.ACN;
    paramString2.userName = this.zDJ;
    paramString2.lastBuffer = paramb;
    this.pullType = paramInt;
    paramb = bi.ABn;
    paramString2.YIY = bi.a(parambui);
    paramb = bi.ABn;
    paramString2.ZDQ = bi.bTZ();
    paramString1.otE = ((a)paramString2);
    paramString1.otF = ((a)new bot());
    paramString1 = paramString1.bEF();
    kotlin.g.b.s.s(paramString1, "builder.buildInstance()");
    this.oDw = paramString1;
    Log.i("Finder.NetSceneFinderMVUserPage", "NetSceneFinderMVUserPage init finderUserName " + this.zDJ + " finderSelfUserName: " + this.ACN);
    AppMethodBeat.o(336621);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336641);
    Log.i("Finder.NetSceneFinderMVUserPage", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (c.c.b(this.oDw.otC) == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
        AppMethodBeat.o(336641);
        throw paramString;
      }
      params = d.FND;
      params = c.c.b(this.oDw.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
        AppMethodBeat.o(336641);
        throw paramString;
      }
      params = ((bot)params).object;
      kotlin.g.b.s.s(params, "commReqResp.responseProt…serPageResponse).`object`");
      this.ACl = d.a.a((List)params, 33280, getContextObj());
      if (this.pullType != 2) {
        paramInt1 = 1;
      }
      while (paramInt1 != 0)
      {
        localObject1 = this.zDJ;
        params = (com.tencent.mm.network.s)localObject1;
        if (localObject1 == null) {
          params = z.bAW();
        }
        Object localObject2 = this.ACl;
        if (localObject2 != null)
        {
          localObject1 = new LinkedList();
          localObject2 = ((Iterable)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              FinderItem localFinderItem = (FinderItem)((Iterator)localObject2).next();
              ((LinkedList)localObject1).add(new r(0, localFinderItem.getFinderObject().id, localFinderItem.getFinderObject(), 33280));
              continue;
              paramInt1 = 0;
              break;
            }
          }
          if (((LinkedList)localObject1).size() > 0)
          {
            localObject2 = k.FNg;
            if (!TextUtils.isEmpty((CharSequence)params)) {
              break label371;
            }
            params = z.bAW();
          }
        }
      }
    }
    for (;;)
    {
      kotlin.g.b.s.s(params, "if (TextUtils.isEmpty(us…sername() else userName!!");
      k.a.a(17, params, (LinkedList)localObject1);
      if (this.callback != null)
      {
        params = this.callback;
        kotlin.g.b.s.checkNotNull(params);
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(336641);
      return;
      label371:
      kotlin.g.b.s.checkNotNull(params);
    }
  }
  
  public final List<FinderItem> dWn()
  {
    List localList2 = this.ACl;
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = (List)ab.aivy;
    }
    return localList1;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336630);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(336630);
    return i;
  }
  
  public final int getType()
  {
    return 6628;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cw
 * JD-Core Version:    0.7.0.1
 */