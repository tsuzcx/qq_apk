package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bik;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class i
  extends n
  implements k
{
  private g callback;
  public crt iYB;
  private com.tencent.mm.ak.b rr;
  
  public i(com.tencent.mm.plugin.j.a.b paramb)
  {
    AppMethodBeat.i(20789);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new crs();
    ((b.a)localObject).hvu = new crt();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
    ((b.a)localObject).funcId = 1180;
    this.rr = ((b.a)localObject).aAz();
    localObject = (crs)this.rr.hvr.hvw;
    ((crs)localObject).dbL = 2;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("{\"user_uin\":");
    az.ayM();
    localStringBuilder1.append(c.getUin() + " ,\"user_data_list\": [");
    if (paramb.type.equals("0")) {
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.tGO + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + paramb.tGQ + "\"},{\"key\": \"bank_number\",\"value\": \"" + paramb.tGR + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.tGU + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + paramb.tGW + "\"},{\"key\": \"bank_name\",\"value\": \"" + paramb.tGS + "\"}]}}");
    }
    for (;;)
    {
      localStringBuilder1.append("]}");
      ((crs)localObject).EUS = localStringBuilder1.toString();
      AppMethodBeat.o(20789);
      return;
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.tGO + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.tGP + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.tGV + "\"},{\"key\": \"email\",\"value\": \"" + paramb.exO + "\"}]}}");
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20791);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneSaveUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.iYB = ((crt)((com.tencent.mm.ak.b)paramq).hvs.hvw);
      if ((this.iYB != null) && (this.iYB.FEw != null) && (this.iYB.FEw.size() > 0) && (this.iYB.FEw.get(0) != null)) {
        ac.i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + ((bik)this.iYB.FEw.get(0)).EuT);
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