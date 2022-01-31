package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aob;
import com.tencent.mm.protocal.c.bmr;
import com.tencent.mm.protocal.c.bms;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class i
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public bms ftn;
  
  public i(com.tencent.mm.plugin.o.a.b paramb)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bmr();
    ((b.a)localObject).ecI = new bms();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
    ((b.a)localObject).ecG = 1180;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bmr)this.dmK.ecE.ecN;
    ((bmr)localObject).source = 2;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("{\"user_uin\":");
    au.Hx();
    localStringBuilder1.append(c.CK() + " ,\"user_data_list\": [");
    if (paramb.type.equals("0")) {
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.lnP + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + paramb.lnR + "\"},{\"key\": \"bank_number\",\"value\": \"" + paramb.lnS + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.lnV + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + paramb.lnX + "\"},{\"key\": \"bank_name\",\"value\": \"" + paramb.lnT + "\"}]}}");
    }
    for (;;)
    {
      localStringBuilder1.append("]}");
      ((bmr)localObject).thG = localStringBuilder1.toString();
      return;
      localStringBuilder1.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + paramb.lnP + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + paramb.type + "\"},{\"key\": \"title\",\"value\": \"" + paramb.lnQ + "\"},{\"key\": \"phone\",\"value\": \"" + paramb.lnW + "\"},{\"key\": \"email\",\"value\": \"" + paramb.cCt + "\"}]}}");
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneSaveUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.ftn = ((bms)((com.tencent.mm.ah.b)paramq).ecF.ecN);
      if ((this.ftn != null) && (this.ftn.tFY != null) && (this.ftn.tFY.size() > 0) && (this.ftn.tFY.get(0) != null)) {
        y.i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + ((aob)this.ftn.tFY.get(0)).group_id);
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1180;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.i
 * JD-Core Version:    0.7.0.1
 */