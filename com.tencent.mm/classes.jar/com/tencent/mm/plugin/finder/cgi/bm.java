package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.protocal.protobuf.aso;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastPlayId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "saveCache", "", "(JLcom/tencent/mm/protobuf/ByteString;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IZ)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSaveCache", "()Z", "setSaveCache", "(Z)V", "getTargetUsername", "()Ljava/lang/String;", "setTargetUsername", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getCount", "getLastDisplayId", "getLikedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMaxId", "getMegaVideoCount", "getRespLastBuffer", "getType", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bm
  extends ax
{
  private final String TAG;
  private i callback;
  private int dLS;
  public int pullType;
  private d rr;
  public List<? extends FinderItem> tvo;
  private String tvp;
  private boolean tvq;
  
  private bm(long paramLong, b paramb, int paramInt1, String paramString, bbn parambbn, int paramInt2, boolean paramBoolean)
  {
    super(parambbn);
    AppMethodBeat.i(242432);
    this.TAG = "Finder.NetSceneFinderGetLikedList";
    this.tvp = "";
    this.tvq = true;
    d.a locala = new d.a();
    locala.sG(getType());
    this.pullType = paramInt1;
    this.tvp = paramString;
    this.tvq = paramBoolean;
    asn localasn = new asn();
    localasn.LDu = paramLong;
    localasn.lastBuffer = paramb;
    localasn.LAt = z.aUg();
    if ((p.j(paramString, z.aTY()) ^ true)) {
      localasn.tvp = paramString;
    }
    localasn.dLS = paramInt2;
    paramb = am.tuw;
    localasn.LAv = am.cXZ();
    this.dLS = paramInt2;
    paramb = am.tuw;
    localasn.uli = am.a(parambbn);
    locala.c((com.tencent.mm.bw.a)localasn);
    locala.sG(getType());
    locala.d((com.tencent.mm.bw.a)new aso());
    locala.MB("/cgi-bin/micromsg-bin/findergetlikedlist");
    paramb = locala.aXF();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetLikedList init: " + paramLong + ' ' + localasn.LAt + "， targetUsername：" + paramString);
    AppMethodBeat.o(242432);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    boolean bool2 = false;
    AppMethodBeat.i(242427);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(242427);
        throw paramString;
      }
      p.g(((aso)params).LDv, "(rr.responseProtoBuf as …dListResponse).liked_list");
      params = this.rr.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(242427);
        throw paramString;
      }
      params = (aso)params;
      Object localObject1 = com.tencent.mm.plugin.finder.preload.a.uTO;
      localObject1 = params.LAF;
      Object localObject2 = params.LDv;
      p.g(localObject2, "resp.liked_list");
      com.tencent.mm.plugin.finder.preload.a.a((baw)localObject1, (List)localObject2, 3965);
      localObject1 = params.LDv;
      p.g(localObject1, "resp.liked_list");
      if (((LinkedList)localObject1).size() > 0)
      {
        localObject2 = ((LinkedList)localObject1).get(0);
        p.g(localObject2, "list[0]");
        localObject2 = (FinderObject)localObject2;
        Log.i(this.TAG, "onGYNetEnd list:" + ((LinkedList)localObject1).size() + " firstItem:" + com.tencent.mm.ac.g.bN(localObject2));
      }
      localObject2 = this.TAG;
      Object localObject3 = new StringBuilder("onGYNetEnd list:").append(((LinkedList)localObject1).size()).append(", continueFlag:").append(params.continueFlag).append(", maxId:");
      params = (FinderObject)j.kv((List)localObject1);
      if (params != null) {}
      boolean bool1;
      for (params = Long.valueOf(params.displayId);; params = null)
      {
        Log.i((String)localObject2, params + ' ');
        bool1 = bool2;
        if (this.pullType != 2)
        {
          bool1 = bool2;
          if (Util.isNullOrNil(this.tvp)) {
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
          y localy = y.vXH;
          if (y.r((FinderObject)localObject3)) {
            params.add(localObject2);
          }
        }
      }
      params = (List)params;
      localObject1 = c.vGN;
      this.tvo = c.a.a(params, 4, this.ttO);
      if ((bool1) && (this.dLS != 1) && (this.tvq))
      {
        params = this.tvo;
        if (params != null)
        {
          localObject1 = c.vGN;
          localObject1 = (Iterable)params;
          params = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (FinderItem)((Iterator)localObject1).next();
            localObject3 = c.vGN;
            params.add(c.a.s((FinderItem)localObject2));
          }
          c.a.b((List)params, 4, bool1);
        }
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(242427);
  }
  
  public final boolean cXQ()
  {
    return true;
  }
  
  public final int cYA()
  {
    AppMethodBeat.i(242431);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(242431);
      throw ((Throwable)localObject);
    }
    int i = ((aso)localObject).continueFlag;
    AppMethodBeat.o(242431);
    return i;
  }
  
  public final int cYy()
  {
    AppMethodBeat.i(242429);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(242429);
      throw ((Throwable)localObject);
    }
    int i = ((aso)localObject).uKM;
    AppMethodBeat.o(242429);
    return i;
  }
  
  public final b cYz()
  {
    AppMethodBeat.i(242430);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(242430);
      throw ((Throwable)localObject);
    }
    localObject = ((aso)localObject).lastBuffer;
    AppMethodBeat.o(242430);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165226);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165226);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(242428);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("total count = ");
    com.tencent.mm.bw.a locala = this.rr.aYK();
    if (locala == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(242428);
      throw ((Throwable)localObject);
    }
    Log.i((String)localObject, ((aso)locala).gAZ);
    localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(242428);
      throw ((Throwable)localObject);
    }
    int i = ((aso)localObject).gAZ;
    AppMethodBeat.o(242428);
    return i;
  }
  
  public final int getType()
  {
    return 3965;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bm
 * JD-Core Version:    0.7.0.1
 */