package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ath;
import com.tencent.mm.protocal.protobuf.ati;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetMsgSessionId;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetMsgSessionIdResponse;", "scene", "", "username", "", "(ILjava/lang/String;)V", "toLotteryId", "toObjectId", "", "(ILjava/lang/String;Ljava/lang/String;J)V", "objectId", "commentId", "(ILjava/lang/String;JJ)V", "fansId", "(Ljava/lang/String;)V", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class ai
  extends an<ati>
{
  public static final a tuq;
  
  static
  {
    AppMethodBeat.i(242312);
    tuq = new a((byte)0);
    AppMethodBeat.o(242312);
  }
  
  public ai(int paramInt, String paramString)
  {
    AppMethodBeat.i(242308);
    d.a locala = new d.a();
    Object localObject = new ath();
    am localam = am.tuw;
    ((ath)localObject).LBM = am.cXY();
    ((ath)localObject).scene = paramInt;
    ((ath)localObject).pPz = paramString;
    locala.c((a)localObject);
    localObject = new ati();
    ((ati)localObject).setBaseResponse(new BaseResponse());
    ((ati)localObject).getBaseResponse().ErrMsg = new dqi();
    locala.d((a)localObject);
    locala.MB("/cgi-bin/micromsg-bin/findergetmsgsessionid");
    locala.sG(3828);
    c(locala.aXF());
    Log.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + paramInt + " username=" + paramString);
    AppMethodBeat.o(242308);
  }
  
  public ai(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(242310);
    d.a locala = new d.a();
    Object localObject = new ath();
    am localam = am.tuw;
    ((ath)localObject).LBM = am.cXY();
    ((ath)localObject).scene = paramInt;
    ((ath)localObject).LEd = paramLong1;
    ((ath)localObject).LEe = paramLong2;
    ((ath)localObject).pPz = paramString;
    locala.c((a)localObject);
    localObject = new ati();
    ((ati)localObject).setBaseResponse(new BaseResponse());
    ((ati)localObject).getBaseResponse().ErrMsg = new dqi();
    locala.d((a)localObject);
    locala.MB("/cgi-bin/micromsg-bin/findergetmsgsessionid");
    locala.sG(3828);
    c(locala.aXF());
    Log.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + paramInt + " username=" + paramString + " objectId=" + paramLong1 + " commentId=" + paramLong2);
    AppMethodBeat.o(242310);
  }
  
  public ai(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(242309);
    d.a locala = new d.a();
    ath localath = new ath();
    am localam = am.tuw;
    localath.LBM = am.cXY();
    localath.scene = paramInt;
    localath.pPz = paramString1;
    localath.LEf = paramString2;
    localath.LEd = paramLong;
    localath.LEg = 1;
    locala.c((a)localath);
    paramString2 = new ati();
    paramString2.setBaseResponse(new BaseResponse());
    paramString2.getBaseResponse().ErrMsg = new dqi();
    locala.d((a)paramString2);
    locala.MB("/cgi-bin/micromsg-bin/findergetmsgsessionid");
    locala.sG(3828);
    c(locala.aXF());
    Log.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + paramInt + " username=" + paramString1);
    AppMethodBeat.o(242309);
  }
  
  public ai(String paramString)
  {
    AppMethodBeat.i(242311);
    d.a locala = new d.a();
    Object localObject = new ath();
    am localam = am.tuw;
    ((ath)localObject).LBM = am.cXY();
    ((ath)localObject).scene = 1;
    ((ath)localObject).LEc = paramString;
    locala.c((a)localObject);
    localObject = new ati();
    ((ati)localObject).setBaseResponse(new BaseResponse());
    ((ati)localObject).getBaseResponse().ErrMsg = new dqi();
    locala.d((a)localObject);
    locala.MB("/cgi-bin/micromsg-bin/findergetmsgsessionid");
    locala.sG(3828);
    c(locala.aXF());
    Log.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] fansId=".concat(String.valueOf(paramString)));
    AppMethodBeat.o(242311);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetMsgSessionId$Companion;", "", "()V", "MSG_SCENE_FINDER", "", "MSG_SCENE_STRANGER", "MSG_SOURCE_TYPE_FINDER", "MSG_SOURCE_TYPE_FINDER_LIVE_LOTTERY", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ai
 * JD-Core Version:    0.7.0.1
 */