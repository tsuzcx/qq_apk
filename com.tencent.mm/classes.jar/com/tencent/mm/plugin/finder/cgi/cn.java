package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "lastPlayId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "saveCache", "", "(JLcom/tencent/mm/protobuf/ByteString;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IZ)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSaveCache", "()Z", "setSaveCache", "(Z)V", "getTargetUsername", "()Ljava/lang/String;", "setTargetUsername", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getCount", "getLastDisplayId", "getLikedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMaxId", "getMegaVideoCount", "getRespLastBuffer", "getType", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cn
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public List<? extends FinderItem> ACl;
  private String ACm;
  private boolean ACn;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private int hJx;
  public int pullType;
  private c rr;
  
  private cn(long paramLong, b paramb, int paramInt1, String paramString, bui parambui, int paramInt2, boolean paramBoolean)
  {
    super(parambui);
    AppMethodBeat.i(336690);
    this.TAG = "Finder.NetSceneFinderGetLikedList";
    this.ACm = "";
    this.ACn = true;
    c.a locala = new c.a();
    locala.funcId = getType();
    this.pullType = paramInt1;
    this.ACm = paramString;
    this.ACn = paramBoolean;
    azg localazg = new azg();
    localazg.ZJD = paramLong;
    localazg.lastBuffer = paramb;
    localazg.YIZ = z.bAW();
    if (!kotlin.g.b.s.p(paramString, z.bAM())) {
      localazg.ACm = paramString;
    }
    localazg.hJx = paramInt2;
    paramb = bi.ABn;
    localazg.ZDQ = bi.bTZ();
    this.hJx = paramInt2;
    paramb = bi.ABn;
    localazg.CJv = bi.a(parambui);
    locala.otE = ((com.tencent.mm.bx.a)localazg);
    locala.funcId = getType();
    locala.otF = ((com.tencent.mm.bx.a)new azh());
    locala.uri = "/cgi-bin/micromsg-bin/findergetlikedlist";
    paramb = locala.bEF();
    kotlin.g.b.s.s(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetLikedList init: " + paramLong + ' ' + localazg.YIZ + "， targetUsername：" + paramString);
    AppMethodBeat.o(336690);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    boolean bool2 = false;
    AppMethodBeat.i(336714);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(336714);
        throw paramString;
      }
      kotlin.g.b.s.s(((azh)params).ZJE, "rr.responseProtoBuf as F…dListResponse).liked_list");
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(336714);
        throw paramString;
      }
      params = (azh)params;
      Object localObject1 = com.tencent.mm.plugin.finder.preload.a.EUs;
      localObject1 = params.ZDZ;
      Object localObject2 = params.ZJE;
      kotlin.g.b.s.s(localObject2, "resp.liked_list");
      com.tencent.mm.plugin.finder.preload.a.a((btc)localObject1, (List)localObject2, 3965);
      localObject1 = params.ZJE;
      kotlin.g.b.s.s(localObject1, "resp.liked_list");
      if (((LinkedList)localObject1).size() > 0)
      {
        localObject2 = ((LinkedList)localObject1).get(0);
        kotlin.g.b.s.s(localObject2, "list[0]");
        localObject2 = (FinderObject)localObject2;
        Log.i(this.TAG, "onGYNetEnd list:" + ((LinkedList)localObject1).size() + " firstItem:" + f.dg(localObject2));
      }
      localObject2 = this.TAG;
      Object localObject3 = new StringBuilder("onGYNetEnd list:").append(((LinkedList)localObject1).size()).append(", continueFlag:").append(params.continueFlag).append(", maxId:");
      params = (FinderObject)kotlin.a.p.oN((List)localObject1);
      if (params == null) {}
      boolean bool1;
      for (params = null;; params = Long.valueOf(params.displayId))
      {
        Log.i((String)localObject2, params + ' ');
        bool1 = bool2;
        if (this.pullType != 2)
        {
          bool1 = bool2;
          if (Util.isNullOrNil(this.ACm)) {
            bool1 = true;
          }
        }
        localObject1 = (Iterable)localObject1;
        params = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          localObject3 = (FinderObject)localObject2;
          av localav = av.GiL;
          if (av.y((FinderObject)localObject3)) {
            params.add(localObject2);
          }
        }
      }
      params = (List)params;
      localObject1 = d.FND;
      this.ACl = d.a.a(params, 4, getContextObj());
      if ((bool1) && (this.hJx != 1) && (this.ACn))
      {
        params = this.ACl;
        if (params != null)
        {
          localObject1 = d.FND;
          localObject1 = (Iterable)params;
          params = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (FinderItem)((Iterator)localObject1).next();
            localObject3 = d.FND;
            params.add(d.a.a((FinderItem)localObject2));
          }
          d.a.c((List)params, 4, bool1);
        }
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
    }
    AppMethodBeat.o(336714);
  }
  
  public final int dVX()
  {
    AppMethodBeat.i(336730);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(336730);
      throw ((Throwable)localObject);
    }
    int i = ((azh)localObject).EzH;
    AppMethodBeat.o(336730);
    return i;
  }
  
  public final b dVY()
  {
    AppMethodBeat.i(336736);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(336736);
      throw ((Throwable)localObject);
    }
    localObject = ((azh)localObject).lastBuffer;
    AppMethodBeat.o(336736);
    return localObject;
  }
  
  public final int dVZ()
  {
    AppMethodBeat.i(336743);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(336743);
      throw ((Throwable)localObject);
    }
    int i = ((azh)localObject).continueFlag;
    AppMethodBeat.o(336743);
    return i;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165226);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(165226);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(336722);
    Object localObject = this.TAG;
    com.tencent.mm.bx.a locala = c.c.b(this.rr.otC);
    if (locala == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(336722);
      throw ((Throwable)localObject);
    }
    Log.i((String)localObject, kotlin.g.b.s.X("total count = ", Integer.valueOf(((azh)locala).lNX)));
    localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(336722);
      throw ((Throwable)localObject);
    }
    int i = ((azh)localObject).lNX;
    AppMethodBeat.o(336722);
    return i;
  }
  
  public final int getType()
  {
    return 3965;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cn
 * JD-Core Version:    0.7.0.1
 */