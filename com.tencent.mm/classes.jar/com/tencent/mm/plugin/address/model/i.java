package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.cml;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class i
  extends n
  implements k
{
  private g callback;
  public cmm iyy;
  private com.tencent.mm.al.b rr;
  
  public i(com.tencent.mm.plugin.j.a.b paramb)
  {
    AppMethodBeat.i(20789);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cml();
    ((b.a)localObject).gUV = new cmm();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
    ((b.a)localObject).funcId = 1180;
    this.rr = ((b.a)localObject).atI();
    localObject = (cml)this.rr.gUS.gUX;
    ((cml)localObject).dep = 2;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("{\"user_uin\":");
    az.arV();
    localStringBuilder1.append(c.getUin() + " ,\"user_data_list\": [");
    if (paramb.type.equals("0")) {
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.sze + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + paramb.szg + "\"},{\"key\": \"bank_number\",\"value\": \"" + paramb.szh + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.szk + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + paramb.szm + "\"},{\"key\": \"bank_name\",\"value\": \"" + paramb.szi + "\"}]}}");
    }
    for (;;)
    {
      localStringBuilder1.append("]}");
      ((cml)localObject).Dzw = localStringBuilder1.toString();
      AppMethodBeat.o(20789);
      return;
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.sze + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.szf + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.szl + "\"},{\"key\": \"email\",\"value\": \"" + paramb.evs + "\"}]}}");
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
    ad.d("MicroMsg.NetSceneSaveUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.iyy = ((cmm)((com.tencent.mm.al.b)paramq).gUT.gUX);
      if ((this.iyy != null) && (this.iyy.Ehx != null) && (this.iyy.Ehx.size() > 0) && (this.iyy.Ehx.get(0) != null)) {
        ad.i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + ((bes)this.iyy.Ehx.get(0)).DbN);
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