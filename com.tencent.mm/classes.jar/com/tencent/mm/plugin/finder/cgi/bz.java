package com.tencent.mm.plugin.finder.cgi;

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
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.protocal.protobuf.bae;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginalUserFeeds;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "refObjectId", "", "refObjectNonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "TAG", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "getRefObjectId", "()J", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderOriginalUserFeedsResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bz
  extends q
  implements m
{
  private final String TAG;
  private i callback;
  private final b lastBuffer;
  public final int pullType;
  public final long refObjectId;
  private d rr;
  public List<? extends FinderItem> tvo;
  private final String username;
  
  public bz(String paramString1, long paramLong, String paramString2, b paramb, int paramInt)
  {
    AppMethodBeat.i(165253);
    this.username = paramString1;
    this.refObjectId = paramLong;
    this.lastBuffer = paramb;
    this.pullType = paramInt;
    this.TAG = "Finder.NetSceneFinderOriginalUserFeeds";
    paramString1 = new d.a();
    paramString1.sG(getType());
    paramb = new bad();
    paramb.username = this.username;
    paramb.refObjectId = this.refObjectId;
    paramb.refObjectNonceId = paramString2;
    paramb.finderUsername = z.aUg();
    paramb.lastBuffer = this.lastBuffer;
    paramString2 = am.tuw;
    paramb.uli = am.cXY();
    paramString1.c((a)paramb);
    paramString1.sG(getType());
    paramString1.d((a)new bae());
    paramString1.MB("/cgi-bin/micromsg-bin/finderoriginaluserfeeds");
    paramString1 = paramString1.aXF();
    p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    Log.i(this.TAG, "NetSceneFinderOriginalUserFeeds " + this.refObjectId);
    AppMethodBeat.o(165253);
  }
  
  public final bae cYZ()
  {
    AppMethodBeat.i(165252);
    Object localObject = this.rr;
    if (localObject != null) {}
    for (localObject = ((d)localObject).aYK(); localObject == null; localObject = null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOriginalUserFeedsResponse");
      AppMethodBeat.o(165252);
      throw ((Throwable)localObject);
    }
    localObject = (bae)localObject;
    AppMethodBeat.o(165252);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(165250);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165250);
    return i;
  }
  
  public final int getType()
  {
    return 3581;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165251);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOriginalUserFeedsResponse");
        AppMethodBeat.o(165251);
        throw paramString;
      }
      params = ((bae)params).object;
      if (params == null) {
        p.hyc();
      }
      Log.i(this.TAG, "onGYNetEnd list:" + params.size());
      if (this.pullType != 2) {}
      Object localObject1;
      Object localObject2;
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfByte = c.vGN;
        paramArrayOfByte = (Iterable)params;
        params = (Collection)new ArrayList();
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = paramArrayOfByte.next();
          localObject2 = (FinderObject)localObject1;
          y localy = y.vXH;
          if (y.r((FinderObject)localObject2)) {
            params.add(localObject1);
          }
        }
      }
      this.tvo = c.a.s((List)params, 2);
      if (bool)
      {
        params = this.tvo;
        if (params != null)
        {
          paramArrayOfByte = c.vGN;
          paramArrayOfByte = (Iterable)params;
          params = (Collection)new ArrayList(j.a(paramArrayOfByte, 10));
          paramArrayOfByte = paramArrayOfByte.iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (FinderItem)paramArrayOfByte.next();
            localObject2 = c.vGN;
            params.add(c.a.s((FinderItem)localObject1));
          }
          c.a.a((List)params, 2, this.username, bool);
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
    AppMethodBeat.o(165251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bz
 * JD-Core Version:    0.7.0.1
 */