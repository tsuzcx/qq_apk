package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMemberCardHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "offset", "", "reqNum", "latitude", "", "longitude", "sortRule", "(IIDDI)V", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends j<cnh>
{
  private static final String TAG;
  public static final a wvY;
  
  static
  {
    AppMethodBeat.i(294521);
    wvY = new a((byte)0);
    TAG = "MicroMsg.CgiGetMemberCardHomePage";
    AppMethodBeat.o(294521);
  }
  
  public b(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(294518);
    cng localcng = new cng();
    cnh localcnh = new cnh();
    localcng.offset = paramInt1;
    localcng.Zdz = paramInt2;
    localcng.latitude = paramDouble1;
    localcng.longitude = paramDouble2;
    localcng.Zdy = paramInt3;
    a((erp)localcng, (esc)localcnh, 2833, "/cgi-bin/mmpay-bin/mktgetmembercardhomepage");
    Log.i(TAG, "offset: " + paramInt1 + ", reqnum: " + paramInt2);
    Log.d(TAG, "latitude: " + paramDouble1 + ", longitude: " + paramDouble2);
    AppMethodBeat.o(294518);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMemberCardHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.b
 * JD-Core Version:    0.7.0.1
 */