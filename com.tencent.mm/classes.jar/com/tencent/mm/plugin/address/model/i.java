package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.ets;
import com.tencent.mm.protocal.protobuf.ett;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class i
  extends p
  implements m
{
  private h callback;
  public ett qhI;
  private com.tencent.mm.am.c rr;
  
  public i(b paramb)
  {
    AppMethodBeat.i(20789);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ets();
    ((c.a)localObject).otF = new ett();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
    ((c.a)localObject).funcId = 1180;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ets)c.b.b(this.rr.otB);
    ((ets)localObject).source = 2;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("{\"user_uin\":");
    bh.bCz();
    localStringBuilder1.append(com.tencent.mm.model.c.getUin() + " ,\"user_data_list\": [");
    if (paramb.type.equals("0")) {
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.JFg + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + paramb.JFi + "\"},{\"key\": \"bank_number\",\"value\": \"" + paramb.JFj + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.JFm + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + paramb.JFo + "\"},{\"key\": \"bank_name\",\"value\": \"" + paramb.JFk + "\"}]}}");
    }
    for (;;)
    {
      localStringBuilder1.append("]}");
      ((ets)localObject).aaAf = localStringBuilder1.toString();
      AppMethodBeat.o(20789);
      return;
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.JFg + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.JFh + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.JFn + "\"},{\"key\": \"email\",\"value\": \"" + paramb.kab + "\"}]}}");
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(20791);
    this.callback = paramh;
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
      this.qhI = ((ett)c.c.b(((com.tencent.mm.am.c)params).otC));
      if ((this.qhI != null) && (this.qhI.abwX != null) && (this.qhI.abwX.size() > 0) && (this.qhI.abwX.get(0) != null)) {
        Log.i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + ((cxw)this.qhI.abwX.get(0)).group_id);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.i
 * JD-Core Version:    0.7.0.1
 */