package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.bwi;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class i
  extends m
  implements k
{
  private f callback;
  public bwj gKP;
  private com.tencent.mm.ai.b rr;
  
  public i(com.tencent.mm.plugin.j.a.b paramb)
  {
    AppMethodBeat.i(16746);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bwi();
    ((b.a)localObject).fsY = new bwj();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
    ((b.a)localObject).funcId = 1180;
    this.rr = ((b.a)localObject).ado();
    localObject = (bwi)this.rr.fsV.fta;
    ((bwi)localObject).cpt = 2;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("{\"user_uin\":");
    aw.aaz();
    localStringBuilder1.append(c.getUin() + " ,\"user_data_list\": [");
    if (paramb.type.equals("0")) {
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.nLm + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + paramb.nLo + "\"},{\"key\": \"bank_number\",\"value\": \"" + paramb.nLp + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.nLs + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + paramb.nLu + "\"},{\"key\": \"bank_name\",\"value\": \"" + paramb.nLq + "\"}]}}");
    }
    for (;;)
    {
      localStringBuilder1.append("]}");
      ((bwi)localObject).xgu = localStringBuilder1.toString();
      AppMethodBeat.o(16746);
      return;
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.nLm + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.nLn + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.nLt + "\"},{\"key\": \"email\",\"value\": \"" + paramb.dqF + "\"}]}}");
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(16748);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(16748);
    return i;
  }
  
  public final int getType()
  {
    return 1180;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16747);
    ab.d("MicroMsg.NetSceneSaveUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.gKP = ((bwj)((com.tencent.mm.ai.b)paramq).fsW.fta);
      if ((this.gKP != null) && (this.gKP.xJO != null) && (this.gKP.xJO.size() > 0) && (this.gKP.xJO.get(0) != null)) {
        ab.i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + ((atr)this.gKP.xJO.get(0)).wPj);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(16747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.i
 * JD-Core Version:    0.7.0.1
 */