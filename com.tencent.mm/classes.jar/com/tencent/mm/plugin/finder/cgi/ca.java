package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.bgg;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOplog;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "cmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "isMegaVideo", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "actionExt", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCmdItemList", "getCmdRetList", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ca
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private static final int xdA = 8;
  private static final int xdB = 9;
  private static final int xdC = 10;
  private static final int xdD = 12;
  private static final int xdE = 13;
  private static final int xdF = 14;
  private static final int xdG = 15;
  private static final int xdH = 16;
  private static final int xdI = 17;
  public static final a xdJ;
  private static final int xdv = 1;
  private static final int xdw = 3;
  private static final int xdx = 4;
  private static final int xdy = 5;
  private static final int xdz = 7;
  private final String TAG;
  private i callback;
  private d rr;
  private final JSONObject xbw;
  private final JSONObject xcu;
  
  static
  {
    AppMethodBeat.i(165249);
    xdJ = new a((byte)0);
    xdv = 1;
    xdw = 3;
    xdx = 4;
    xdy = 5;
    xdz = 7;
    xdA = 8;
    xdB = 9;
    xdC = 10;
    xdD = 12;
    xdE = 13;
    xdF = 14;
    xdG = 15;
    xdH = 16;
    xdI = 17;
    AppMethodBeat.o(165249);
  }
  
  public ca(String arg1, List<? extends aqt> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(284943);
    this.TAG = "Finder.NetSceneFinderOplog";
    this.xbw = new JSONObject();
    this.xcu = new JSONObject();
    Object localObject = new d.a();
    ((d.a)localObject).vD(getType());
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/finderoplog");
    bgg localbgg = new bgg();
    localbgg.username = ???;
    localbgg.wqP.addAll((Collection)paramList);
    ??? = ao.xcj;
    localbgg.yjp = ao.dnO();
    ??? = localbgg.yjp;
    if (??? == null) {
      p.iCn();
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ???.scene = i;
      ((d.a)localObject).c((com.tencent.mm.cd.a)localbgg);
      ((d.a)localObject).d((com.tencent.mm.cd.a)new bgh());
      ??? = ((d.a)localObject).bgN();
      p.j(???, "builder.buildInstance()");
      this.rr = ???;
      synchronized ((Iterable)paramList)
      {
        paramList = ???.iterator();
        i = j;
        while (paramList.hasNext())
        {
          localObject = (aqt)paramList.next();
          this.xcu.put("req".concat(String.valueOf(i)), ((aqt)localObject).cmdId);
          i += 1;
        }
        paramList = x.aazN;
        this.xcu.put("isMegaVideo", paramBoolean);
        Log.i(this.TAG, "NetSceneFinderOplog init ");
        AppMethodBeat.o(284943);
        return;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(284942);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Log.i(this.TAG, "retList " + doC().size());
    this.xbw.put("retsize", doC().size());
    params = doC().iterator();
    paramInt1 = 0;
    Object localObject;
    while (params.hasNext())
    {
      localObject = (aqu)params.next();
      this.xbw.put("resp".concat(String.valueOf(paramInt1)), ((aqu)localObject).retCode);
      this.xbw.put("respm".concat(String.valueOf(paramInt1)), ((aqu)localObject).tVH);
      paramInt1 += 1;
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    paramString = doC().iterator();
    while (paramString.hasNext())
    {
      params = (aqu)paramString.next();
      Log.i(this.TAG, "retCode " + params.retCode + " retMsg " + params.tVH);
      localObject = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      paramInt1 = params.retCode;
      params = params.tVH;
      if (!Util.isNullOrNil(params)) {
        if (paramInt1 == -4006)
        {
          if (params != null) {
            com.tencent.mm.plugin.findersdk.c.a.aGP(params);
          }
          f.Iyx.idkeyStat(1264L, 0L, 1L, false);
        }
        else if (paramInt1 == -4007)
        {
          if (params != null) {
            com.tencent.mm.plugin.findersdk.c.a.aGP(params);
          }
          f.Iyx.idkeyStat(1264L, 1L, 1L, false);
        }
        else if (paramInt1 == -4017)
        {
          if (params != null) {
            com.tencent.mm.plugin.findersdk.c.a.aGP(params);
          }
          f.Iyx.idkeyStat(1264L, 2L, 1L, false);
        }
        else if (paramInt1 == -4005)
        {
          if (params != null) {
            com.tencent.mm.plugin.findersdk.c.a.aGP(params);
          }
          f.Iyx.idkeyStat(1264L, 5L, 1L, false);
        }
        else if (paramInt1 == -4019)
        {
          if (params != null) {
            com.tencent.mm.plugin.findersdk.c.a.aGP(params);
          }
          f.Iyx.idkeyStat(1264L, 6L, 1L, false);
        }
        else
        {
          com.tencent.mm.plugin.findersdk.c.a.w(4, paramInt1, params);
        }
      }
    }
    AppMethodBeat.o(284942);
  }
  
  public final b dnF()
  {
    return b.BvU;
  }
  
  public final JSONObject dnI()
  {
    return this.xcu;
  }
  
  public final JSONObject dnJ()
  {
    return this.xbw;
  }
  
  public final List<aqt> doB()
  {
    AppMethodBeat.i(165246);
    Object localObject = this.rr;
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((d)localObject).bhX();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogRequest");
      AppMethodBeat.o(165246);
      throw ((Throwable)localObject);
    }
    localObject = ((bgg)localObject).wqP;
    p.j(localObject, "(rr!!.requestProtoBuf as…nderOplogRequest).cmdList");
    localObject = (List)localObject;
    AppMethodBeat.o(165246);
    return localObject;
  }
  
  public final List<aqu> doC()
  {
    AppMethodBeat.i(165247);
    Object localObject = this.rr;
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((d)localObject).bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogResponse");
      AppMethodBeat.o(165247);
      throw ((Throwable)localObject);
    }
    localObject = ((bgh)localObject).tqf;
    p.j(localObject, "(rr!!.responseProtoBuf a…derOplogResponse).retList");
    localObject = (List)localObject;
    AppMethodBeat.o(165247);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165244);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165244);
    return i;
  }
  
  public final int getType()
  {
    return 3870;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOplog$Companion;", "", "()V", "CmdIdDelFansSetting", "", "getCmdIdDelFansSetting", "()I", "CmdIdModFeedReproduction", "getCmdIdModFeedReproduction", "CmdIdModMsgMuteSetting", "getCmdIdModMsgMuteSetting", "CmdIdModProfileStickySetting", "getCmdIdModProfileStickySetting", "CmdModBlackList", "getCmdModBlackList", "CmdModFeedSetting", "getCmdModFeedSetting", "CmdModMsgSessionMuteSetting", "getCmdModMsgSessionMuteSetting", "CmdModRecommendSetting", "getCmdModRecommendSetting", "CmdModUserInfo", "getCmdModUserInfo", "CmdModWxMsgSessionMuteSetting", "getCmdModWxMsgSessionMuteSetting", "MFinder_Oplog_CmdId_ModBlockPosterSetting", "getMFinder_Oplog_CmdId_ModBlockPosterSetting", "MMFinder_Oplog_CmdId_AcceptProtobuf", "getMMFinder_Oplog_CmdId_AcceptProtobuf", "MMFinder_Oplog_CmdId_Allow_Accept_Phone", "getMMFinder_Oplog_CmdId_Allow_Accept_Phone", "MMFinder_Oplog_CmdId_ModFollowNotifySetting", "getMMFinder_Oplog_CmdId_ModFollowNotifySetting", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ca
 * JD-Core Version:    0.7.0.1
 */