package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.protocal.c.alr;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public b()
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new alq();
    ((b.a)localObject).ecI = new alr();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
    ((b.a)localObject).ecG = 1191;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (alq)this.dmK.ecE.ecN;
    ((alq)localObject).source = 2;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("invoice_info.title");
    localLinkedList.add("invoice_info.tax_number");
    localLinkedList.add("invoice_info.bank_number");
    localLinkedList.add("invoice_info.bank_name");
    localLinkedList.add("invoice_info.type");
    localLinkedList.add("invoice_info.email");
    localLinkedList.add("invoice_info.company_address");
    localLinkedList.add("invoice_info.company_address_detail");
    localLinkedList.add("invoice_info.company_address_postcode");
    localLinkedList.add("invoice_info.phone");
    ((alq)localObject).thF = localLinkedList;
    ((alq)localObject).thE = false;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.address.a.a.YC().fth = new com.tencent.mm.plugin.o.a.a();
      y.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we resetList and parse the json ..");
      paramq = (alr)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      y.i("MicroMsg.NetSceneGetUserAutoFillInfo", "resp json is.." + paramq.thG);
      if (paramq.thG == null) {}
    }
    for (;;)
    {
      int j;
      try
      {
        paramq = new JSONObject(paramq.thG).getJSONArray("user_data_list").getJSONObject(0).getJSONArray("group_info_list");
        if ((paramq == null) || (paramq.length() <= 0)) {
          break label863;
        }
        i = 0;
        paramInt1 = paramq.length();
        if (i >= paramInt1) {
          break label863;
        }
        try
        {
          localObject = paramq.getJSONObject(i);
          paramArrayOfByte = new com.tencent.mm.plugin.o.a.b();
          paramArrayOfByte.lnP = ((JSONObject)localObject).getInt("group_id");
          paramArrayOfByte.lnY = ((JSONObject)localObject).getString("invoice_url");
          y.i("MicroMsg.NetSceneGetUserAutoFillInfo", "get groupid:" + ((JSONObject)localObject).getInt("group_id") + "get invoiceUrl:" + ((JSONObject)localObject).getString("invoice_url"));
          localObject = ((JSONObject)localObject).getJSONArray("field_list");
          if ((localObject == null) || (((JSONArray)localObject).length() <= 0)) {
            continue;
          }
          j = 0;
          if (j >= ((JSONArray)localObject).length()) {
            continue;
          }
          localJSONObject = ((JSONArray)localObject).getJSONObject(j);
          str = localJSONObject.getString("key");
          paramInt1 = -1;
          switch (str.hashCode())
          {
          case 110371416: 
            if (!str.equals("title")) {
              break label878;
            }
            paramInt1 = 0;
          }
        }
        catch (JSONException paramArrayOfByte)
        {
          String str;
          y.e("MicroMsg.NetSceneGetUserAutoFillInfo", "parse error for no." + i);
          i += 1;
        }
        if (!str.equals("tax_number")) {
          break label878;
        }
        paramInt1 = 1;
      }
      catch (JSONException paramq)
      {
        int i;
        Object localObject;
        JSONObject localJSONObject;
        y.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
      }
      if (str.equals("bank_name"))
      {
        paramInt1 = 2;
        break label878;
        if (str.equals("bank_number"))
        {
          paramInt1 = 3;
          break label878;
          if (str.equals("type"))
          {
            paramInt1 = 4;
            break label878;
            if (str.equals("email"))
            {
              paramInt1 = 5;
              break label878;
              if (str.equals("phone"))
              {
                paramInt1 = 6;
                break label878;
                if (str.equals("company_address_detail"))
                {
                  paramInt1 = 7;
                  break label878;
                  paramArrayOfByte.title = localJSONObject.getString("value");
                  break label924;
                  continue;
                  paramArrayOfByte.lnR = localJSONObject.getString("value");
                  break label924;
                  paramArrayOfByte.lnT = localJSONObject.getString("value");
                  break label924;
                  paramArrayOfByte.lnS = localJSONObject.getString("value");
                  break label924;
                  paramArrayOfByte.type = localJSONObject.getString("value");
                  break label924;
                  paramArrayOfByte.cCt = localJSONObject.getString("value");
                  break label924;
                  paramArrayOfByte.lnV = localJSONObject.getString("value");
                  paramArrayOfByte.lnW = localJSONObject.getString("value");
                  break label924;
                  paramArrayOfByte.lnX = localJSONObject.getString("value");
                  break label924;
                  localObject = com.tencent.mm.plugin.address.a.a.YC();
                  if ((paramArrayOfByte.type != null) && (paramArrayOfByte.type.equals("0")))
                  {
                    paramArrayOfByte.lnQ = "";
                    paramArrayOfByte.lnW = "";
                    paramArrayOfByte.cCt = "";
                    ((com.tencent.mm.plugin.address.b.a.a)localObject).fth.lnO.add(paramArrayOfByte);
                    y.i("MicroMsg.InvoiceMgr", "type is error..");
                    continue;
                  }
                  if ((paramArrayOfByte.type == null) || (!paramArrayOfByte.type.equals("1"))) {
                    continue;
                  }
                  paramArrayOfByte.lnQ = paramArrayOfByte.title;
                  paramArrayOfByte.title = "";
                  paramArrayOfByte.lnV = "";
                  paramArrayOfByte.lnR = "";
                  paramArrayOfByte.lnS = "";
                  paramArrayOfByte.lnT = "";
                  paramArrayOfByte.lnX = "";
                  ((com.tencent.mm.plugin.address.b.a.a)localObject).fth.lnO.add(paramArrayOfByte);
                  continue;
                  label863:
                  this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
                  return;
                }
              }
            }
          }
        }
      }
      label878:
      switch (paramInt1)
      {
      }
      label924:
      j += 1;
    }
  }
  
  public final int getType()
  {
    return 1191;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.b
 * JD-Core Version:    0.7.0.1
 */