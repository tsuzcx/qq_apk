package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetMsgSessionId;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetMsgSessionIdResponse;", "scene", "", "username", "", "(ILjava/lang/String;)V", "objectId", "", "commentId", "(ILjava/lang/String;JJ)V", "fansId", "(Ljava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class t
  extends com.tencent.mm.ak.a<aoq>
{
  public static final a rQZ;
  
  static
  {
    AppMethodBeat.i(201505);
    rQZ = new a((byte)0);
    AppMethodBeat.o(201505);
  }
  
  public t(int paramInt, String paramString)
  {
    AppMethodBeat.i(201502);
    b.a locala = new b.a();
    Object localObject = new aop();
    v localv = v.rRb;
    ((aop)localObject).GFS = v.czz();
    ((aop)localObject).scene = paramInt;
    ((aop)localObject).oBN = paramString;
    locala.c((com.tencent.mm.bw.a)localObject);
    localObject = new aoq();
    ((aoq)localObject).setBaseResponse(new BaseResponse());
    ((aoq)localObject).getBaseResponse().ErrMsg = new cxn();
    locala.d((com.tencent.mm.bw.a)localObject);
    locala.DN("/cgi-bin/micromsg-bin/findergetmsgsessionid");
    locala.oS(3828);
    c(locala.aDS());
    ae.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + paramInt + " username=" + paramString);
    AppMethodBeat.o(201502);
  }
  
  public t(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(201503);
    b.a locala = new b.a();
    Object localObject = new aop();
    v localv = v.rRb;
    ((aop)localObject).GFS = v.czz();
    ((aop)localObject).scene = paramInt;
    ((aop)localObject).GFU = paramLong1;
    ((aop)localObject).GFV = paramLong2;
    ((aop)localObject).oBN = paramString;
    locala.c((com.tencent.mm.bw.a)localObject);
    localObject = new aoq();
    ((aoq)localObject).setBaseResponse(new BaseResponse());
    ((aoq)localObject).getBaseResponse().ErrMsg = new cxn();
    locala.d((com.tencent.mm.bw.a)localObject);
    locala.DN("/cgi-bin/micromsg-bin/findergetmsgsessionid");
    locala.oS(3828);
    c(locala.aDS());
    ae.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + paramInt + " username=" + paramString + " objectId=" + paramLong1 + " commentId=" + paramLong2);
    AppMethodBeat.o(201503);
  }
  
  public t(String paramString)
  {
    AppMethodBeat.i(201504);
    b.a locala = new b.a();
    Object localObject = new aop();
    v localv = v.rRb;
    ((aop)localObject).GFS = v.czz();
    ((aop)localObject).scene = 1;
    ((aop)localObject).GFT = paramString;
    locala.c((com.tencent.mm.bw.a)localObject);
    localObject = new aoq();
    ((aoq)localObject).setBaseResponse(new BaseResponse());
    ((aoq)localObject).getBaseResponse().ErrMsg = new cxn();
    locala.d((com.tencent.mm.bw.a)localObject);
    locala.DN("/cgi-bin/micromsg-bin/findergetmsgsessionid");
    locala.oS(3828);
    c(locala.aDS());
    ae.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] fansId=".concat(String.valueOf(paramString)));
    AppMethodBeat.o(201504);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetMsgSessionId$Companion;", "", "()V", "MSG_SCENE_FINDER", "", "MSG_SCENE_STRANGER", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.t
 * JD-Core Version:    0.7.0.1
 */