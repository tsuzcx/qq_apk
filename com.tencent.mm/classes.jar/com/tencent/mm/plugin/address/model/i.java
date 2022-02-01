package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.eal;
import com.tencent.mm.protocal.protobuf.eam;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.an.i callback;
  public eam nkz;
  private d rr;
  
  public i(b paramb)
  {
    AppMethodBeat.i(20789);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new eal();
    ((d.a)localObject).lBV = new eam();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
    ((d.a)localObject).funcId = 1180;
    this.rr = ((d.a)localObject).bgN();
    localObject = (eal)d.b.b(this.rr.lBR);
    ((eal)localObject).source = 2;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("{\"user_uin\":");
    bh.beI();
    localStringBuilder1.append(c.getUin() + " ,\"user_data_list\": [");
    if (paramb.type.equals("0")) {
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.DNR + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + paramb.DNT + "\"},{\"key\": \"bank_number\",\"value\": \"" + paramb.DNU + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.DNX + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + paramb.DNZ + "\"},{\"key\": \"bank_name\",\"value\": \"" + paramb.DNV + "\"}]}}");
    }
    for (;;)
    {
      localStringBuilder1.append("]}");
      ((eal)localObject).Tmg = localStringBuilder1.toString();
      AppMethodBeat.o(20789);
      return;
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.DNR + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.DNS + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.DNY + "\"},{\"key\": \"email\",\"value\": \"" + paramb.hDf + "\"}]}}");
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(20791);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20791);
    return i;
  }
  
  public final int getType()
  {
    return 1180;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20790);
    Log.d("MicroMsg.NetSceneSaveUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.nkz = ((eam)d.c.b(((d)params).lBS));
      if ((this.nkz != null) && (this.nkz.UfI != null) && (this.nkz.UfI.size() > 0) && (this.nkz.UfI.get(0) != null)) {
        Log.i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + ((chw)this.nkz.UfI.get(0)).group_id);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.i
 * JD-Core Version:    0.7.0.1
 */