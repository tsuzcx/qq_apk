package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.apm;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelsimple/CgiExtDeviceOplog;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ExtDeviceOpLogResp;", "extDeviceId", "Lcom/tencent/mm/protobuf/ByteString;", "extDeviceClientVersion", "", "setting", "Lcom/tencent/mm/modelsimple/PushLoginUrlAutoLoginSetting;", "(Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/modelsimple/PushLoginUrlAutoLoginSetting;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-messenger_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.am.b<apn>
{
  public static final a oRY;
  
  static
  {
    AppMethodBeat.i(236709);
    oRY = new a((byte)0);
    AppMethodBeat.o(236709);
  }
  
  public b(com.tencent.mm.bx.b paramb, int paramInt, ak paramak)
  {
    AppMethodBeat.i(236706);
    c.a locala = new c.a();
    apm localapm = new apm();
    localapm.ZwK = paramb;
    localapm.ZwL = paramInt;
    localapm.hId = c.oSa.value;
    localapm.ZwM = paramak.value;
    paramb = new apn();
    paramb.setBaseResponse(new kd());
    paramb.getBaseResponse().akjO = new etl();
    locala.otE = ((a)localapm);
    locala.otF = ((a)paramb);
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceoplog";
    locala.funcId = 4048;
    c(locala.bEF());
    Log.i("MicroMsg.CgiExtDeviceOplog", "opcode:" + localapm.hId + " setting:" + paramak.value);
    AppMethodBeat.o(236706);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/modelsimple/CgiExtDeviceOplog$Companion;", "", "()V", "TAG", "", "plugin-messenger_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.b
 * JD-Core Version:    0.7.0.1
 */