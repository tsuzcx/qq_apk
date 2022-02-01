package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.protocal.protobuf.cnn;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMktCardHomePageV3;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "offset", "", "reqNum", "(II)V", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends j<cnn>
{
  private static final String TAG;
  public static final a wvZ;
  
  static
  {
    AppMethodBeat.i(294517);
    wvZ = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktCardHomePageV3";
    AppMethodBeat.o(294517);
  }
  
  public c(int paramInt)
  {
    AppMethodBeat.i(294514);
    cnm localcnm = new cnm();
    cnn localcnn = new cnn();
    localcnm.offset = paramInt;
    localcnm.Zdz = 10;
    a((erp)localcnm, (esc)localcnn, 1701, "/cgi-bin/mmpay-bin/mktgetmktcardhomepagev2");
    Log.i(TAG, "offset: " + paramInt + ", reqnum: 10");
    AppMethodBeat.o(294514);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMktCardHomePageV3$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.c
 * JD-Core Version:    0.7.0.1
 */