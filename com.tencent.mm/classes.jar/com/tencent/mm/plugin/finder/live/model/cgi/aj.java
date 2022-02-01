package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.bjq;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.bpo;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBasicInfo;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModBasicInfoResponse;", "liveId", "", "objectId", "scene", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "(JJILcom/tencent/mm/protocal/protobuf/FinderCmdItem;)V", "getCmdItem", "()Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "getLiveId", "()J", "getObjectId", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModBasicInfoRequest;", "getScene", "()I", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
  extends c<bjr>
{
  public static final a CKd;
  private bjq CKe;
  private final long hKN;
  private final auw hLi;
  private final long liveId;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(360301);
    CKd = new a((byte)0);
    AppMethodBeat.o(360301);
  }
  
  public aj(long paramLong1, long paramLong2, int paramInt, auw paramauw)
  {
    AppMethodBeat.i(360293);
    this.liveId = paramLong1;
    this.hKN = paramLong2;
    this.scene = paramInt;
    this.hLi = paramauw;
    this.CKe = new bjq();
    this.CKe.mMJ = this.liveId;
    this.CKe.object_id = this.hKN;
    this.CKe.scene = this.scene;
    paramauw = this.CKe;
    Object localObject = bi.ABn;
    paramauw.YIY = bi.a(null);
    this.CKe.ZTf.add(this.hLi);
    paramauw = new c.a();
    paramauw.otE = ((a)this.CKe);
    localObject = new bjr();
    ((bjr)localObject).setBaseResponse(new kd());
    ((bjr)localObject).getBaseResponse().akjO = new etl();
    paramauw.otF = ((a)localObject);
    paramauw.uri = "/cgi-bin/micromsg-bin/finderlivemodbasicinfo";
    paramauw.funcId = 4175;
    c(paramauw.bEF());
    Log.i("Finder.CgiFinderLiveModBasicInfo", "liveId " + this.liveId + ", objectId " + d.hF(this.hKN) + ",scene:" + this.scene);
    AppMethodBeat.o(360293);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBasicInfo$Companion;", "", "()V", "GAME_TEAM_UP_NEWS_ACCEPT", "", "GAME_TEAM_UP_NEWS_NOT_ACCEPT", "TAG", "", "makeCmdItemForAcceptTeamUpNews", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "finderUsername", "accept", "", "makeCmdItemForFastComment", "commentDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "makeCmdItemForGameRank", "appid", "turnOn", "makeCmdItemForModeLiveDesc", "desc", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static auw ah(ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(360148);
      s.u(paramArrayList, "commentDataList");
      auw localauw = new auw();
      localauw.cmdId = 5;
      bqc localbqc = new bqc();
      bmw localbmw = new bmw();
      paramArrayList = ((Iterable)paramArrayList).iterator();
      label107:
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if (((CharSequence)str).length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label107;
          }
          localbmw.YVU.add(str);
          break;
        }
      }
      paramArrayList = ah.aiuX;
      localbqc.ZYd = localbmw;
      paramArrayList = ah.aiuX;
      localauw.ZFn = b.cX(localbqc.toByteArray());
      AppMethodBeat.o(360148);
      return localauw;
    }
    
    public static auw awF(String paramString)
    {
      AppMethodBeat.i(360141);
      s.u(paramString, "desc");
      auw localauw = new auw();
      localauw.cmdId = 3;
      bju localbju = new bju();
      localbju.ZNe = paramString;
      paramString = ah.aiuX;
      localauw.ZFn = b.cX(localbju.toByteArray());
      AppMethodBeat.o(360141);
      return localauw;
    }
    
    public static auw bx(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(360155);
      s.u(paramString, "finderUsername");
      auw localauw = new auw();
      localauw.cmdId = 4;
      bpo localbpo = new bpo();
      localbpo.ZQW = paramString;
      if (paramBoolean) {}
      for (int i = 2;; i = 1)
      {
        localbpo.YAN = i;
        paramString = ah.aiuX;
        localauw.ZFn = b.cX(localbpo.toByteArray());
        AppMethodBeat.o(360155);
        return localauw;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.aj
 * JD-Core Version:    0.7.0.1
 */