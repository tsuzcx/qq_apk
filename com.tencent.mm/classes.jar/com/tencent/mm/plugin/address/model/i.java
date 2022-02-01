package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.protocal.protobuf.dqo;
import com.tencent.mm.protocal.protobuf.dqp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  public dqp ksS;
  private d rr;
  
  public i(b paramb)
  {
    AppMethodBeat.i(20789);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dqo();
    ((d.a)localObject).iLO = new dqp();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
    ((d.a)localObject).funcId = 1180;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dqo)this.rr.iLK.iLR;
    ((dqo)localObject).source = 2;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("{\"user_uin\":");
    bg.aVF();
    localStringBuilder1.append(c.getUin() + " ,\"user_data_list\": [");
    if (paramb.type.equals("0")) {
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.ynP + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + paramb.ynR + "\"},{\"key\": \"bank_number\",\"value\": \"" + paramb.ynS + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.ynV + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + paramb.ynX + "\"},{\"key\": \"bank_name\",\"value\": \"" + paramb.ynT + "\"}]}}");
    }
    for (;;)
    {
      localStringBuilder1.append("]}");
      ((dqo)localObject).McH = localStringBuilder1.toString();
      AppMethodBeat.o(20789);
      return;
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.ynP + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.ynQ + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.ynW + "\"},{\"key\": \"email\",\"value\": \"" + paramb.fuD + "\"}]}}");
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
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
      this.ksS = ((dqp)((d)params).iLL.iLR);
      if ((this.ksS != null) && (this.ksS.MTy != null) && (this.ksS.MTy.size() > 0) && (this.ksS.MTy.get(0) != null)) {
        Log.i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + ((cab)this.ksS.MTy.get(0)).Lqz);
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