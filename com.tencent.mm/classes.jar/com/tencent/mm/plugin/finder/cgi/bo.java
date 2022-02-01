package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.protocal.protobuf.atk;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAdFeedList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "req_username", "", "feedId", "", "encryptedFeedId", "maxId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "getEncryptedFeedId", "()Ljava/lang/String;", "getFeedId", "()J", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "getReq_username", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getAdFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getPrivateLock", "getResponseBuffer", "getType", "getWording", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bo
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final bo.a ABA;
  private final String ABB;
  private final String ABC;
  public boolean ABD;
  private com.tencent.mm.am.h callback;
  private final long feedId;
  public int pullType;
  public c rr;
  
  static
  {
    AppMethodBeat.i(336452);
    ABA = new bo.a((byte)0);
    AppMethodBeat.o(336452);
  }
  
  public bo(String paramString1, long paramLong1, String paramString2, long paramLong2, b paramb, int paramInt, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336446);
    this.ABB = paramString1;
    this.feedId = paramLong1;
    this.ABC = paramString2;
    this.ABD = true;
    paramString1 = d.AwY;
    paramString1 = d.a.auT(this.ABB);
    atk localatk;
    Object localObject;
    if (paramString1 == null)
    {
      paramString1 = "";
      paramString2 = new c.a();
      paramString2.uri = "/cgi-bin/micromsg-bin/finderaduserpage";
      paramString2.funcId = getType();
      localatk = new atk();
      localatk.username = this.ABB;
      localatk.maxId = paramLong2;
      localatk.firstPageMD5 = paramString1;
      localObject = bi.ABn;
      localatk.ZDQ = bi.bTZ();
      localatk.YIZ = z.bAW();
      localObject = bi.ABn;
      localatk.CJv = bi.a(parambui);
      localObject = localatk.CJv;
      if (localObject != null)
      {
        if (parambui != null) {
          break label423;
        }
        i = 0;
        label176:
        ((atz)localObject).scene = i;
      }
      if (n.T(localatk.username, localatk.YIZ, false)) {
        localatk.ZDP = 1;
      }
      parambui = bi.ABn;
      parambui = localatk.CJv;
      localObject = localatk.CJv;
      if (localObject != null) {
        break label433;
      }
    }
    label423:
    label433:
    for (int i = 0;; i = ((atz)localObject).scene)
    {
      bi.a(parambui, kotlin.a.p.listOf(new r(Integer.valueOf(i), Long.valueOf(this.feedId))));
      localatk.ZDR = this.feedId;
      localatk.AUV = this.ABC;
      localatk.lastBuffer = paramb;
      paramb = new atl();
      paramString2.otE = ((a)localatk);
      paramString2.otF = ((a)paramb);
      paramString2 = paramString2.bEF();
      kotlin.g.b.s.s(paramString2, "builder.buildInstance()");
      this.rr = paramString2;
      this.pullType = paramInt;
      Log.i("Finder.NetSceneAdFeedListval", "NetSceneFinderUserPage init maxId " + paramLong2 + " username " + this.ABB + " pullType " + paramInt + " fpMD5 " + paramString1);
      AppMethodBeat.o(336446);
      return;
      paramString1 = paramString1.field_firstPageMD5;
      if (paramString1 == null)
      {
        paramString1 = "";
        break;
      }
      break;
      i = parambui.hLK;
      break label176;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336469);
    Log.i("Finder.NetSceneAdFeedListval", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
        AppMethodBeat.o(336469);
        throw paramString;
      }
      if (((atl)params).continueFlag != 1) {
        break label157;
      }
    }
    label157:
    for (boolean bool = true;; bool = false)
    {
      this.ABD = bool;
      if (this.callback != null)
      {
        params = this.callback;
        kotlin.g.b.s.checkNotNull(params);
        params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      }
      AppMethodBeat.o(336469);
      return;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336457);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(336457);
    return i;
  }
  
  public final int getType()
  {
    return 6692;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bo
 * JD-Core Version:    0.7.0.1
 */