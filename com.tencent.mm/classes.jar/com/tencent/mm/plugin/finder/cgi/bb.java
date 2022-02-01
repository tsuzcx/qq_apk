package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetMsgSessionId;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetMsgSessionIdResponse;", "scene", "", "username", "", "(ILjava/lang/String;)V", "toLotteryId", "toObjectId", "", "sourceType", "(ILjava/lang/String;Ljava/lang/String;JLjava/lang/Integer;)V", "objectId", "commentId", "(ILjava/lang/String;JJ)V", "fansId", "(Ljava/lang/String;)V", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bb
  extends c<bal>
{
  public static final a ABb;
  private static b ABc;
  
  static
  {
    AppMethodBeat.i(336202);
    ABb = new a((byte)0);
    AppMethodBeat.o(336202);
  }
  
  public bb(int paramInt, String paramString)
  {
    AppMethodBeat.i(336169);
    c.a locala = new c.a();
    Object localObject1 = new bak();
    Object localObject2 = bi.ABn;
    ((bak)localObject1).YIY = bi.dVu();
    ((bak)localObject1).ZLh = paramInt;
    ((bak)localObject1).waL = paramString;
    ((bak)localObject1).ZLm = true;
    ((bak)localObject1).ZLo = ABc;
    localObject2 = av.GiL;
    ((bak)localObject1).ZLp = av.Ur(((bak)localObject1).ZLh);
    locala.otE = ((a)localObject1);
    localObject1 = new bal();
    ((bal)localObject1).setBaseResponse(new kd());
    ((bal)localObject1).getBaseResponse().akjO = new etl();
    locala.otF = ((a)localObject1);
    locala.uri = "/cgi-bin/micromsg-bin/findergetmsgsessionid";
    locala.funcId = 3828;
    c(locala.bEF());
    Log.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + paramInt + " username=" + paramString);
    AppMethodBeat.o(336169);
  }
  
  public bb(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(336185);
    c.a locala = new c.a();
    Object localObject1 = new bak();
    Object localObject2 = bi.ABn;
    ((bak)localObject1).YIY = bi.dVu();
    ((bak)localObject1).ZLh = paramInt;
    ((bak)localObject1).ZLj = paramLong1;
    ((bak)localObject1).ZFJ = 4;
    ((bak)localObject1).ZLk = paramLong2;
    ((bak)localObject1).waL = paramString;
    ((bak)localObject1).ZLm = true;
    ((bak)localObject1).ZLo = ABc;
    localObject2 = av.GiL;
    ((bak)localObject1).ZLp = av.Ur(((bak)localObject1).ZLh);
    locala.otE = ((a)localObject1);
    localObject1 = new bal();
    ((bal)localObject1).setBaseResponse(new kd());
    ((bal)localObject1).getBaseResponse().akjO = new etl();
    locala.otF = ((a)localObject1);
    locala.uri = "/cgi-bin/micromsg-bin/findergetmsgsessionid";
    locala.funcId = 3828;
    c(locala.bEF());
    Log.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + paramInt + " username=" + paramString + " objectId=" + paramLong1 + " commentId=" + paramLong2);
    AppMethodBeat.o(336185);
  }
  
  public bb(int paramInt, String paramString1, String paramString2, long paramLong, Integer paramInteger)
  {
    AppMethodBeat.i(336177);
    c.a locala = new c.a();
    bak localbak = new bak();
    bi localbi = bi.ABn;
    localbak.YIY = bi.dVu();
    localbak.ZLh = paramInt;
    localbak.waL = paramString1;
    localbak.ZLl = paramString2;
    localbak.ZLj = paramLong;
    if (paramInteger == null) {}
    for (int i = 1;; i = paramInteger.intValue())
    {
      localbak.ZFJ = i;
      localbak.ZLm = true;
      localbak.ZLo = ABc;
      paramString2 = av.GiL;
      localbak.ZLp = av.Ur(localbak.ZLh);
      locala.otE = ((a)localbak);
      paramString2 = new bal();
      paramString2.setBaseResponse(new kd());
      paramString2.getBaseResponse().akjO = new etl();
      locala.otF = ((a)paramString2);
      locala.uri = "/cgi-bin/micromsg-bin/findergetmsgsessionid";
      locala.funcId = 3828;
      c(locala.bEF());
      Log.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + paramInt + " username=" + paramString1);
      AppMethodBeat.o(336177);
      return;
    }
  }
  
  public bb(String paramString)
  {
    AppMethodBeat.i(336193);
    c.a locala = new c.a();
    Object localObject1 = new bak();
    Object localObject2 = bi.ABn;
    ((bak)localObject1).YIY = bi.dVu();
    ((bak)localObject1).ZLh = 1;
    ((bak)localObject1).ZLi = paramString;
    ((bak)localObject1).ZLm = true;
    ((bak)localObject1).ZLo = ABc;
    localObject2 = av.GiL;
    ((bak)localObject1).ZLp = av.Ur(((bak)localObject1).ZLh);
    locala.otE = ((a)localObject1);
    localObject1 = new bal();
    ((bal)localObject1).setBaseResponse(new kd());
    ((bal)localObject1).getBaseResponse().akjO = new etl();
    locala.otF = ((a)localObject1);
    locala.uri = "/cgi-bin/micromsg-bin/findergetmsgsessionid";
    locala.funcId = 3828;
    c(locala.bEF());
    Log.i("Finder.CgiGetMsgSessionId", s.X("[CgiGetMsgSessionId] fansId=", paramString));
    AppMethodBeat.o(336193);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetMsgSessionId$Companion;", "", "()V", "FinderComment", "", "FinderCommon", "FinderFans", "FinderLike", "FinderLiveList", "FinderLotteryAudience", "MSG_SCENE_ALIAS", "MSG_SCENE_FINDER", "MSG_SCENE_STRANGER", "MSG_SOURCE_TYPE_FINDER", "MSG_SOURCE_TYPE_FINDER_LIVE_LOTTERY", "TAG", "", "finderLiveContactExtInfo", "Lcom/tencent/mm/protobuf/ByteString;", "getFinderLiveContactExtInfo", "()Lcom/tencent/mm/protobuf/ByteString;", "setFinderLiveContactExtInfo", "(Lcom/tencent/mm/protobuf/ByteString;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bb
 * JD-Core Version:    0.7.0.1
 */