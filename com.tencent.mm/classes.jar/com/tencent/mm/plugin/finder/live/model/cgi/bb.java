package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.adc;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiTestClientSpeed;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/ClientSpeedTestResp;", "sceneCode", "", "opCode", "uploadSize", "downloadSize", "concurrentNum", "(IIIII)V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/ClientSpeedTestReq;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bb
  extends o<add>
{
  private adc CKQ;
  private final String TAG;
  
  public bb()
  {
    AppMethodBeat.i(360150);
    this.TAG = "Finder.CgiTestClientSpeed";
    this.CKQ = new adc();
    this.CKQ.ZlD = 1;
    this.CKQ.ZlE = 1;
    this.CKQ.PWK = 524288;
    this.CKQ.ZlF = 1024;
    this.CKQ.ZlG = 6;
    Log.i(this.TAG, "sceneCode:1 opCode:1 uploadSize:524288" + " downloadSize:1024 concurrentNum:6");
    c.a locala = new c.a();
    locala.otE = ((a)this.CKQ);
    add localadd = new add();
    localadd.setBaseResponse(new kd());
    localadd.getBaseResponse().akjO = new etl();
    locala.otF = ((a)localadd);
    locala.uri = " /cgi-bin/micromsg-bin/clientspeedtest";
    locala.funcId = 4138;
    c(locala.bEF());
    AppMethodBeat.o(360150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.bb
 * JD-Core Version:    0.7.0.1
 */