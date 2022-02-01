package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.protocal.protobuf.bkp;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.ak.b rr;
  
  public b()
  {
    AppMethodBeat.i(20768);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bko();
    ((b.a)localObject).hQG = new bkp();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
    ((b.a)localObject).funcId = 1191;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bko)this.rr.hQD.hQJ;
    ((bko)localObject).doj = 2;
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
    ((bko)localObject).GXR = localLinkedList;
    ((bko)localObject).GXQ = false;
    AppMethodBeat.o(20768);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20770);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20770);
    return i;
  }
  
  public final int getType()
  {
    return 1191;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20769);
    ae.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.address.a.a.aVr().juy = new com.tencent.mm.plugin.j.a.a();
      ae.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we resetList and parse the json ..");
      paramq = (bkp)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
      ae.i("MicroMsg.NetSceneGetUserAutoFillInfo", "resp json is.." + paramq.GXS);
      if (paramq.GXS == null) {}
    }
    for (;;)
    {
      int j;
      try
      {
        paramq = new JSONObject(paramq.GXS).getJSONArray("user_data_list").getJSONObject(0).getJSONArray("group_info_list");
        if ((paramq == null) || (paramq.length() <= 0)) {
          break label861;
        }
        i = 0;
        paramInt1 = paramq.length();
        if (i >= paramInt1) {
          break label861;
        }
        try
        {
          localObject = paramq.getJSONObject(i);
          paramArrayOfByte = new com.tencent.mm.plugin.j.a.b();
          paramArrayOfByte.uVo = ((JSONObject)localObject).getInt("group_id");
          paramArrayOfByte.uVx = ((JSONObject)localObject).getString("invoice_url");
          ae.i("MicroMsg.NetSceneGetUserAutoFillInfo", "get groupid:" + ((JSONObject)localObject).getInt("group_id") + "get invoiceUrl:" + ((JSONObject)localObject).getString("invoice_url"));
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
              break label882;
            }
            paramInt1 = 0;
          }
        }
        catch (JSONException paramArrayOfByte)
        {
          String str;
          ae.e("MicroMsg.NetSceneGetUserAutoFillInfo", "parse error for no.".concat(String.valueOf(i)));
          i += 1;
        }
        if (!str.equals("tax_number")) {
          break label882;
        }
        paramInt1 = 1;
      }
      catch (JSONException paramq)
      {
        int i;
        Object localObject;
        JSONObject localJSONObject;
        ae.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
      }
      if (str.equals("bank_name"))
      {
        paramInt1 = 2;
        break label882;
        if (str.equals("bank_number"))
        {
          paramInt1 = 3;
          break label882;
          if (str.equals("type"))
          {
            paramInt1 = 4;
            break label882;
            if (str.equals("email"))
            {
              paramInt1 = 5;
              break label882;
              if (str.equals("phone"))
              {
                paramInt1 = 6;
                break label882;
                if (str.equals("company_address_detail"))
                {
                  paramInt1 = 7;
                  break label882;
                  paramArrayOfByte.title = localJSONObject.getString("value");
                  break label928;
                  continue;
                  paramArrayOfByte.uVq = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.uVs = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.uVr = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.type = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.eQY = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.uVu = localJSONObject.getString("value");
                  paramArrayOfByte.uVv = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.uVw = localJSONObject.getString("value");
                  break label928;
                  localObject = com.tencent.mm.plugin.address.a.a.aVr();
                  if ((paramArrayOfByte.type != null) && (paramArrayOfByte.type.equals("0")))
                  {
                    paramArrayOfByte.uVp = "";
                    paramArrayOfByte.uVv = "";
                    paramArrayOfByte.eQY = "";
                    ((com.tencent.mm.plugin.address.b.a.a)localObject).juy.uVn.add(paramArrayOfByte);
                    ae.i("MicroMsg.InvoiceMgr", "type is error..");
                    continue;
                  }
                  if ((paramArrayOfByte.type == null) || (!paramArrayOfByte.type.equals("1"))) {
                    continue;
                  }
                  paramArrayOfByte.uVp = paramArrayOfByte.title;
                  paramArrayOfByte.title = "";
                  paramArrayOfByte.uVu = "";
                  paramArrayOfByte.uVq = "";
                  paramArrayOfByte.uVr = "";
                  paramArrayOfByte.uVs = "";
                  paramArrayOfByte.uVw = "";
                  ((com.tencent.mm.plugin.address.b.a.a)localObject).juy.uVn.add(paramArrayOfByte);
                  continue;
                  label861:
                  this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
                  AppMethodBeat.o(20769);
                  return;
                }
              }
            }
          }
        }
      }
      label882:
      switch (paramInt1)
      {
      }
      label928:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.b
 * JD-Core Version:    0.7.0.1
 */