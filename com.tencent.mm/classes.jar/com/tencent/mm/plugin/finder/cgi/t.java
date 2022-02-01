package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetMsgSessionId;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetMsgSessionIdResponse;", "scene", "", "username", "", "(ILjava/lang/String;)V", "objectId", "", "commentId", "(ILjava/lang/String;JJ)V", "fansId", "(Ljava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class t
  extends com.tencent.mm.al.a<aod>
{
  public static final a rIP;
  
  static
  {
    AppMethodBeat.i(201087);
    rIP = new a((byte)0);
    AppMethodBeat.o(201087);
  }
  
  public t(int paramInt, String paramString)
  {
    AppMethodBeat.i(201084);
    b.a locala = new b.a();
    Object localObject = new aoc();
    v localv = v.rIR;
    ((aoc)localObject).GmL = v.cxY();
    ((aoc)localObject).scene = paramInt;
    ((aoc)localObject).ovm = paramString;
    locala.c((com.tencent.mm.bx.a)localObject);
    localObject = new aod();
    ((aod)localObject).setBaseResponse(new BaseResponse());
    ((aod)localObject).getBaseResponse().ErrMsg = new cwt();
    locala.d((com.tencent.mm.bx.a)localObject);
    locala.Dl("/cgi-bin/micromsg-bin/findergetmsgsessionid");
    locala.oP(3828);
    c(locala.aDC());
    ad.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + paramInt + " username=" + paramString);
    AppMethodBeat.o(201084);
  }
  
  public t(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(201085);
    b.a locala = new b.a();
    Object localObject = new aoc();
    v localv = v.rIR;
    ((aoc)localObject).GmL = v.cxY();
    ((aoc)localObject).scene = paramInt;
    ((aoc)localObject).GmN = paramLong1;
    ((aoc)localObject).GmO = paramLong2;
    ((aoc)localObject).ovm = paramString;
    locala.c((com.tencent.mm.bx.a)localObject);
    localObject = new aod();
    ((aod)localObject).setBaseResponse(new BaseResponse());
    ((aod)localObject).getBaseResponse().ErrMsg = new cwt();
    locala.d((com.tencent.mm.bx.a)localObject);
    locala.Dl("/cgi-bin/micromsg-bin/findergetmsgsessionid");
    locala.oP(3828);
    c(locala.aDC());
    ad.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + paramInt + " username=" + paramString + " objectId=" + paramLong1 + " commentId=" + paramLong2);
    AppMethodBeat.o(201085);
  }
  
  public t(String paramString)
  {
    AppMethodBeat.i(201086);
    b.a locala = new b.a();
    Object localObject = new aoc();
    v localv = v.rIR;
    ((aoc)localObject).GmL = v.cxY();
    ((aoc)localObject).scene = 1;
    ((aoc)localObject).GmM = paramString;
    locala.c((com.tencent.mm.bx.a)localObject);
    localObject = new aod();
    ((aod)localObject).setBaseResponse(new BaseResponse());
    ((aod)localObject).getBaseResponse().ErrMsg = new cwt();
    locala.d((com.tencent.mm.bx.a)localObject);
    locala.Dl("/cgi-bin/micromsg-bin/findergetmsgsessionid");
    locala.oP(3828);
    c(locala.aDC());
    ad.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] fansId=".concat(String.valueOf(paramString)));
    AppMethodBeat.o(201086);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetMsgSessionId$Companion;", "", "()V", "MSG_SCENE_FINDER", "", "MSG_SCENE_STRANGER", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.t
 * JD-Core Version:    0.7.0.1
 */