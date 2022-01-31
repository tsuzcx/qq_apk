package com.tencent.mm.plugin.card.model.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.protocal.protobuf.hw;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/model/v2/CgiBatchDeleteCardInInvalid;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/BatchDeleteCardInInvalidListResponse;", "cardIds", "", "", "(Ljava/util/List;)V", "Companion", "plugin-card_release"})
public final class b
  extends k<hw>
{
  private static String TAG;
  public static final b.a kps;
  
  static
  {
    AppMethodBeat.i(89155);
    kps = new b.a((byte)0);
    TAG = "MicroMsg.CgiBatchDeleteCardInInvalid";
    AppMethodBeat.o(89155);
  }
  
  public b(List<String> paramList)
  {
    AppMethodBeat.i(89154);
    hv localhv = new hv();
    hw localhw = new hw();
    localhv.wuw = new LinkedList((Collection)paramList);
    a((buy)localhv, (bvk)localhw, 2850, "/cgi-bin/mmpay-bin/mktbatchdeletecardininvalidlist");
    ab.i(TAG, "cardIds: %s", new Object[] { Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(89154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.b
 * JD-Core Version:    0.7.0.1
 */