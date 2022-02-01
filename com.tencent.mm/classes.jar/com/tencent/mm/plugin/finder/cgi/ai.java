package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetMsgSessionId;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetMsgSessionIdResponse;", "scene", "", "username", "", "(ILjava/lang/String;)V", "toLotteryId", "toObjectId", "", "sourceType", "(ILjava/lang/String;Ljava/lang/String;JLjava/lang/Integer;)V", "objectId", "commentId", "(ILjava/lang/String;JJ)V", "fansId", "(Ljava/lang/String;)V", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class ai
  extends c<avl>
{
  private static b xbZ;
  public static final a xca;
  
  static
  {
    AppMethodBeat.i(276160);
    xca = new a((byte)0);
    AppMethodBeat.o(276160);
  }
  
  public ai(int paramInt, String paramString)
  {
    AppMethodBeat.i(276156);
    d.a locala = new d.a();
    Object localObject1 = new avk();
    Object localObject2 = ao.xcj;
    ((avk)localObject1).RLM = ao.dnO();
    ((avk)localObject1).SFD = paramInt;
    ((avk)localObject1).sWA = paramString;
    ((avk)localObject1).SFE = true;
    ((avk)localObject1).SHN = xbZ;
    localObject2 = aj.AGc;
    ((avk)localObject1).SHO = aj.Rn(((avk)localObject1).SFD);
    locala.c((a)localObject1);
    localObject1 = new avl();
    ((avl)localObject1).setBaseResponse(new jh());
    ((avl)localObject1).getBaseResponse().Tef = new eaf();
    locala.d((a)localObject1);
    locala.TW("/cgi-bin/micromsg-bin/findergetmsgsessionid");
    locala.vD(3828);
    c(locala.bgN());
    Log.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + paramInt + " username=" + paramString);
    AppMethodBeat.o(276156);
  }
  
  public ai(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(276158);
    d.a locala = new d.a();
    Object localObject1 = new avk();
    Object localObject2 = ao.xcj;
    ((avk)localObject1).RLM = ao.dnO();
    ((avk)localObject1).SFD = paramInt;
    ((avk)localObject1).SHJ = paramLong1;
    ((avk)localObject1).SHK = paramLong2;
    ((avk)localObject1).sWA = paramString;
    ((avk)localObject1).SFE = true;
    ((avk)localObject1).SHN = xbZ;
    localObject2 = aj.AGc;
    ((avk)localObject1).SHO = aj.Rn(((avk)localObject1).SFD);
    locala.c((a)localObject1);
    localObject1 = new avl();
    ((avl)localObject1).setBaseResponse(new jh());
    ((avl)localObject1).getBaseResponse().Tef = new eaf();
    locala.d((a)localObject1);
    locala.TW("/cgi-bin/micromsg-bin/findergetmsgsessionid");
    locala.vD(3828);
    c(locala.bgN());
    Log.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + paramInt + " username=" + paramString + " objectId=" + paramLong1 + " commentId=" + paramLong2);
    AppMethodBeat.o(276158);
  }
  
  public ai(int paramInt, String paramString1, String paramString2, long paramLong, Integer paramInteger)
  {
    AppMethodBeat.i(276157);
    d.a locala = new d.a();
    avk localavk = new avk();
    ao localao = ao.xcj;
    localavk.RLM = ao.dnO();
    localavk.SFD = paramInt;
    localavk.sWA = paramString1;
    localavk.SHL = paramString2;
    localavk.SHJ = paramLong;
    if (paramInteger != null) {}
    for (int i = paramInteger.intValue();; i = 1)
    {
      localavk.SEl = i;
      localavk.SFE = true;
      localavk.SHN = xbZ;
      paramString2 = aj.AGc;
      localavk.SHO = aj.Rn(localavk.SFD);
      locala.c((a)localavk);
      paramString2 = new avl();
      paramString2.setBaseResponse(new jh());
      paramString2.getBaseResponse().Tef = new eaf();
      locala.d((a)paramString2);
      locala.TW("/cgi-bin/micromsg-bin/findergetmsgsessionid");
      locala.vD(3828);
      c(locala.bgN());
      Log.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + paramInt + " username=" + paramString1);
      AppMethodBeat.o(276157);
      return;
    }
  }
  
  public ai(String paramString)
  {
    AppMethodBeat.i(276159);
    d.a locala = new d.a();
    Object localObject1 = new avk();
    Object localObject2 = ao.xcj;
    ((avk)localObject1).RLM = ao.dnO();
    ((avk)localObject1).SFD = 1;
    ((avk)localObject1).SHI = paramString;
    ((avk)localObject1).SFE = true;
    ((avk)localObject1).SHN = xbZ;
    localObject2 = aj.AGc;
    ((avk)localObject1).SHO = aj.Rn(((avk)localObject1).SFD);
    locala.c((a)localObject1);
    localObject1 = new avl();
    ((avl)localObject1).setBaseResponse(new jh());
    ((avl)localObject1).getBaseResponse().Tef = new eaf();
    locala.d((a)localObject1);
    locala.TW("/cgi-bin/micromsg-bin/findergetmsgsessionid");
    locala.vD(3828);
    c(locala.bgN());
    Log.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] fansId=".concat(String.valueOf(paramString)));
    AppMethodBeat.o(276159);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetMsgSessionId$Companion;", "", "()V", "FinderComment", "", "FinderCommon", "FinderFans", "FinderLike", "FinderLiveList", "FinderLotteryAudience", "MSG_SCENE_ALIAS", "MSG_SCENE_FINDER", "MSG_SCENE_STRANGER", "MSG_SOURCE_TYPE_FINDER", "MSG_SOURCE_TYPE_FINDER_LIVE_LOTTERY", "TAG", "", "finderLiveContactExtInfo", "Lcom/tencent/mm/protobuf/ByteString;", "getFinderLiveContactExtInfo", "()Lcom/tencent/mm/protobuf/ByteString;", "setFinderLiveContactExtInfo", "(Lcom/tencent/mm/protobuf/ByteString;)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ai
 * JD-Core Version:    0.7.0.1
 */