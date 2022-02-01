package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.bab;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOplog;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "cmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "isMegaVideo", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "actionExt", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCmdItemList", "getCmdRetList", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bx
  extends ax
  implements m
{
  private static final int tvL = 1;
  private static final int tvM = 3;
  private static final int tvN = 4;
  private static final int tvO = 5;
  private static final int tvP = 7;
  private static final int tvQ = 8;
  private static final int tvR = 9;
  private static final int tvS = 10;
  private static final int tvT = 12;
  private static final int tvU = 13;
  private static final int tvV = 14;
  public static final a tvW;
  private final String TAG;
  private i callback;
  private d rr;
  private final JSONObject ttQ;
  private final JSONObject tuL;
  
  static
  {
    AppMethodBeat.i(165249);
    tvW = new a((byte)0);
    tvL = 1;
    tvM = 3;
    tvN = 4;
    tvO = 5;
    tvP = 7;
    tvQ = 8;
    tvR = 9;
    tvS = 10;
    tvT = 12;
    tvU = 13;
    tvV = 14;
    AppMethodBeat.o(165249);
  }
  
  public bx(String arg1, List<? extends apf> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(242482);
    this.TAG = "Finder.NetSceneFinderOplog";
    this.ttQ = new JSONObject();
    this.tuL = new JSONObject();
    Object localObject = new d.a();
    ((d.a)localObject).sG(getType());
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/finderoplog");
    baa localbaa = new baa();
    localbaa.username = ???;
    localbaa.sKS.addAll((Collection)paramList);
    ??? = am.tuw;
    localbaa.uli = am.cXY();
    ??? = localbaa.uli;
    if (??? == null) {
      p.hyc();
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ???.scene = i;
      ((d.a)localObject).c((com.tencent.mm.bw.a)localbaa);
      ((d.a)localObject).d((com.tencent.mm.bw.a)new bab());
      ??? = ((d.a)localObject).aXF();
      p.g(???, "builder.buildInstance()");
      this.rr = ???;
      synchronized ((Iterable)paramList)
      {
        paramList = ???.iterator();
        i = j;
        while (paramList.hasNext())
        {
          localObject = (apf)paramList.next();
          this.tuL.put("req".concat(String.valueOf(i)), ((apf)localObject).cmdId);
          i += 1;
        }
        paramList = x.SXb;
        this.tuL.put("isMegaVideo", paramBoolean);
        Log.i(this.TAG, "NetSceneFinderOplog init ");
        AppMethodBeat.o(242482);
        return;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242481);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Log.i(this.TAG, "retList " + cYN().size());
    this.ttQ.put("retsize", cYN().size());
    params = cYN().iterator();
    paramInt1 = 0;
    Object localObject;
    while (params.hasNext())
    {
      localObject = (apg)params.next();
      this.ttQ.put("resp".concat(String.valueOf(paramInt1)), ((apg)localObject).retCode);
      this.ttQ.put("respm".concat(String.valueOf(paramInt1)), ((apg)localObject).qwG);
      paramInt1 += 1;
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    paramString = cYN().iterator();
    while (paramString.hasNext())
    {
      params = (apg)paramString.next();
      Log.i(this.TAG, "retCode " + params.retCode + " retMsg " + params.qwG);
      localObject = com.tencent.mm.plugin.finder.spam.a.vwk;
      paramInt1 = params.retCode;
      params = params.qwG;
      if (!Util.isNullOrNil(params)) {
        if (paramInt1 == -4006)
        {
          if (params != null) {
            com.tencent.mm.plugin.finder.spam.a.avm(params);
          }
          e.Cxv.idkeyStat(1264L, 0L, 1L, false);
        }
        else if (paramInt1 == -4007)
        {
          if (params != null) {
            com.tencent.mm.plugin.finder.spam.a.avm(params);
          }
          e.Cxv.idkeyStat(1264L, 1L, 1L, false);
        }
        else if (paramInt1 == -4017)
        {
          if (params != null) {
            com.tencent.mm.plugin.finder.spam.a.avm(params);
          }
          e.Cxv.idkeyStat(1264L, 2L, 1L, false);
        }
        else if (paramInt1 == -4005)
        {
          if (params != null) {
            com.tencent.mm.plugin.finder.spam.a.avm(params);
          }
          e.Cxv.idkeyStat(1264L, 5L, 1L, false);
        }
        else if (paramInt1 == -4019)
        {
          if (params != null) {
            com.tencent.mm.plugin.finder.spam.a.avm(params);
          }
          e.Cxv.idkeyStat(1264L, 6L, 1L, false);
        }
        else
        {
          com.tencent.mm.plugin.finder.spam.a.u(4, paramInt1, params);
        }
      }
    }
    AppMethodBeat.o(242481);
  }
  
  public final b cXS()
  {
    return b.tye;
  }
  
  public final JSONObject cXV()
  {
    return this.tuL;
  }
  
  public final JSONObject cXW()
  {
    return this.ttQ;
  }
  
  public final List<apf> cYM()
  {
    AppMethodBeat.i(165246);
    Object localObject = this.rr;
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((d)localObject).aYJ();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogRequest");
      AppMethodBeat.o(165246);
      throw ((Throwable)localObject);
    }
    localObject = ((baa)localObject).sKS;
    p.g(localObject, "(rr!!.requestProtoBuf as…nderOplogRequest).cmdList");
    localObject = (List)localObject;
    AppMethodBeat.o(165246);
    return localObject;
  }
  
  public final List<apg> cYN()
  {
    AppMethodBeat.i(165247);
    Object localObject = this.rr;
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((d)localObject).aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogResponse");
      AppMethodBeat.o(165247);
      throw ((Throwable)localObject);
    }
    localObject = ((bab)localObject).pUe;
    p.g(localObject, "(rr!!.responseProtoBuf a…derOplogResponse).retList");
    localObject = (List)localObject;
    AppMethodBeat.o(165247);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOplog$Companion;", "", "()V", "CmdIdDelFansSetting", "", "getCmdIdDelFansSetting", "()I", "CmdIdModFeedReproduction", "getCmdIdModFeedReproduction", "CmdIdModMsgMuteSetting", "getCmdIdModMsgMuteSetting", "CmdIdModProfileStickySetting", "getCmdIdModProfileStickySetting", "CmdModBlackList", "getCmdModBlackList", "CmdModFeedSetting", "getCmdModFeedSetting", "CmdModMsgSessionMuteSetting", "getCmdModMsgSessionMuteSetting", "CmdModRecommendSetting", "getCmdModRecommendSetting", "CmdModUserInfo", "getCmdModUserInfo", "CmdModWxMsgSessionMuteSetting", "getCmdModWxMsgSessionMuteSetting", "MFinder_Oplog_CmdId_ModBlockPosterSetting", "getMFinder_Oplog_CmdId_ModBlockPosterSetting", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bx
 * JD-Core Version:    0.7.0.1
 */