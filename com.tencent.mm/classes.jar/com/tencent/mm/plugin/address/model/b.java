package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfo;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.ak.b rr;
  
  public b()
  {
    AppMethodBeat.i(20768);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bfo();
    ((b.a)localObject).hvu = new bfp();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
    ((b.a)localObject).funcId = 1191;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bfo)this.rr.hvr.hvw;
    ((bfo)localObject).dbL = 2;
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
    ((bfo)localObject).EUR = localLinkedList;
    ((bfo)localObject).EUQ = false;
    AppMethodBeat.o(20768);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20770);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.address.a.a.aRG().iYw = new com.tencent.mm.plugin.j.a.a();
      ac.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we resetList and parse the json ..");
      paramq = (bfp)((com.tencent.mm.ak.b)paramq).hvs.hvw;
      ac.i("MicroMsg.NetSceneGetUserAutoFillInfo", "resp json is.." + paramq.EUS);
      if (paramq.EUS == null) {}
    }
    for (;;)
    {
      int j;
      try
      {
        paramq = new JSONObject(paramq.EUS).getJSONArray("user_data_list").getJSONObject(0).getJSONArray("group_info_list");
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
          paramArrayOfByte.tGO = ((JSONObject)localObject).getInt("group_id");
          paramArrayOfByte.tGX = ((JSONObject)localObject).getString("invoice_url");
          ac.i("MicroMsg.NetSceneGetUserAutoFillInfo", "get groupid:" + ((JSONObject)localObject).getInt("group_id") + "get invoiceUrl:" + ((JSONObject)localObject).getString("invoice_url"));
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
          ac.e("MicroMsg.NetSceneGetUserAutoFillInfo", "parse error for no.".concat(String.valueOf(i)));
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
        ac.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
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
                  paramArrayOfByte.tGQ = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.tGS = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.tGR = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.type = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.exO = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.tGU = localJSONObject.getString("value");
                  paramArrayOfByte.tGV = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.tGW = localJSONObject.getString("value");
                  break label928;
                  localObject = com.tencent.mm.plugin.address.a.a.aRG();
                  if ((paramArrayOfByte.type != null) && (paramArrayOfByte.type.equals("0")))
                  {
                    paramArrayOfByte.tGP = "";
                    paramArrayOfByte.tGV = "";
                    paramArrayOfByte.exO = "";
                    ((com.tencent.mm.plugin.address.b.a.a)localObject).iYw.tGN.add(paramArrayOfByte);
                    ac.i("MicroMsg.InvoiceMgr", "type is error..");
                    continue;
                  }
                  if ((paramArrayOfByte.type == null) || (!paramArrayOfByte.type.equals("1"))) {
                    continue;
                  }
                  paramArrayOfByte.tGP = paramArrayOfByte.title;
                  paramArrayOfByte.title = "";
                  paramArrayOfByte.tGU = "";
                  paramArrayOfByte.tGQ = "";
                  paramArrayOfByte.tGR = "";
                  paramArrayOfByte.tGS = "";
                  paramArrayOfByte.tGW = "";
                  ((com.tencent.mm.plugin.address.b.a.a)localObject).iYw.tGN.add(paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.b
 * JD-Core Version:    0.7.0.1
 */