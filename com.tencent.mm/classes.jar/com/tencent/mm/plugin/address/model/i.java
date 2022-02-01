package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.protocal.protobuf.cwz;
import com.tencent.mm.protocal.protobuf.cxa;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class i
  extends n
  implements k
{
  private f callback;
  public cxa jrK;
  private com.tencent.mm.al.b rr;
  
  public i(com.tencent.mm.plugin.j.a.b paramb)
  {
    AppMethodBeat.i(20789);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cwz();
    ((b.a)localObject).hNN = new cxa();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
    ((b.a)localObject).funcId = 1180;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cwz)this.rr.hNK.hNQ;
    ((cwz)localObject).dnh = 2;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("{\"user_uin\":");
    ba.aBQ();
    localStringBuilder1.append(c.getUin() + " ,\"user_data_list\": [");
    if (paramb.type.equals("0")) {
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.uJB + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + paramb.uJD + "\"},{\"key\": \"bank_number\",\"value\": \"" + paramb.uJE + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.uJH + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + paramb.uJJ + "\"},{\"key\": \"bank_name\",\"value\": \"" + paramb.uJF + "\"}]}}");
    }
    for (;;)
    {
      localStringBuilder1.append("]}");
      ((cwz)localObject).GEp = localStringBuilder1.toString();
      AppMethodBeat.o(20789);
      return;
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.uJB + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.uJC + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.uJI + "\"},{\"key\": \"email\",\"value\": \"" + paramb.ePn + "\"}]}}");
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20791);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20791);
    return i;
  }
  
  public final int getType()
  {
    return 1180;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20790);
    ad.d("MicroMsg.NetSceneSaveUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.jrK = ((cxa)((com.tencent.mm.al.b)paramq).hNL.hNQ);
      if ((this.jrK != null) && (this.jrK.HoL != null) && (this.jrK.HoL.size() > 0) && (this.jrK.HoL.get(0) != null)) {
        ad.i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + ((bms)this.jrK.HoL.get(0)).Gcn);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.i
 * JD-Core Version:    0.7.0.1
 */