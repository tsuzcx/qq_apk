package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.protocal.protobuf.cxt;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class i
  extends n
  implements k
{
  private f callback;
  public cxu juD;
  private com.tencent.mm.ak.b rr;
  
  public i(com.tencent.mm.plugin.j.a.b paramb)
  {
    AppMethodBeat.i(20789);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cxt();
    ((b.a)localObject).hQG = new cxu();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
    ((b.a)localObject).funcId = 1180;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cxt)this.rr.hQD.hQJ;
    ((cxt)localObject).doj = 2;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("{\"user_uin\":");
    bc.aCg();
    localStringBuilder1.append(c.getUin() + " ,\"user_data_list\": [");
    if (paramb.type.equals("0")) {
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.uVo + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + paramb.uVq + "\"},{\"key\": \"bank_number\",\"value\": \"" + paramb.uVr + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.uVu + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + paramb.uVw + "\"},{\"key\": \"bank_name\",\"value\": \"" + paramb.uVs + "\"}]}}");
    }
    for (;;)
    {
      localStringBuilder1.append("]}");
      ((cxt)localObject).GXS = localStringBuilder1.toString();
      AppMethodBeat.o(20789);
      return;
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.uVo + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.uVp + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.uVv + "\"},{\"key\": \"email\",\"value\": \"" + paramb.eQY + "\"}]}}");
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
    ae.d("MicroMsg.NetSceneSaveUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.juD = ((cxu)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
      if ((this.juD != null) && (this.juD.HIn != null) && (this.juD.HIn.size() > 0) && (this.juD.HIn.get(0) != null)) {
        ae.i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + ((bnk)this.juD.HIn.get(0)).GuU);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.i
 * JD-Core Version:    0.7.0.1
 */