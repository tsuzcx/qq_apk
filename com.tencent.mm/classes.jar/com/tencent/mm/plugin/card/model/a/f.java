package com.tencent.mm.plugin.card.model.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.ahx;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "()V", "Companion", "plugin-card_release"})
public final class f
  extends k<ahx>
{
  private static final String TAG = "MicroMsg.CgiGetCardEntranceStyle";
  public static final f.a kpw;
  
  static
  {
    AppMethodBeat.i(89166);
    kpw = new f.a((byte)0);
    TAG = "MicroMsg.CgiGetCardEntranceStyle";
    AppMethodBeat.o(89166);
  }
  
  public f()
  {
    AppMethodBeat.i(89165);
    ahw localahw = new ahw();
    ahx localahx = new ahx();
    a((buy)localahw, (bvk)localahx, 2793, "/cgi-bin/mmpay-bin/mktgetcardentrancestyle");
    ab.i(TAG, "do get card entrance style");
    AppMethodBeat.o(89165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.f
 * JD-Core Version:    0.7.0.1
 */