package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bwx;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public b()
  {
    AppMethodBeat.i(20768);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bwx();
    ((d.a)localObject).iLO = new bwy();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
    ((d.a)localObject).funcId = 1191;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bwx)this.rr.iLK.iLR;
    ((bwx)localObject).source = 2;
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
    ((bwx)localObject).McG = localLinkedList;
    ((bwx)localObject).McF = false;
    AppMethodBeat.o(20768);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20770);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20770);
    return i;
  }
  
  public final int getType()
  {
    return 1191;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20769);
    Log.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.address.a.a.bqc().ksN = new com.tencent.mm.plugin.j.a.a();
      Log.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we resetList and parse the json ..");
      params = (bwy)((d)params).iLL.iLR;
      Log.i("MicroMsg.NetSceneGetUserAutoFillInfo", "resp json is.." + params.McH);
      if (params.McH == null) {}
    }
    for (;;)
    {
      int j;
      try
      {
        params = new JSONObject(params.McH).getJSONArray("user_data_list").getJSONObject(0).getJSONArray("group_info_list");
        if ((params == null) || (params.length() <= 0)) {
          break label861;
        }
        i = 0;
        paramInt1 = params.length();
        if (i >= paramInt1) {
          break label861;
        }
        try
        {
          localObject = params.getJSONObject(i);
          paramArrayOfByte = new com.tencent.mm.plugin.j.a.b();
          paramArrayOfByte.ynP = ((JSONObject)localObject).getInt("group_id");
          paramArrayOfByte.ynY = ((JSONObject)localObject).getString("invoice_url");
          Log.i("MicroMsg.NetSceneGetUserAutoFillInfo", "get groupid:" + ((JSONObject)localObject).getInt("group_id") + "get invoiceUrl:" + ((JSONObject)localObject).getString("invoice_url"));
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
          Log.e("MicroMsg.NetSceneGetUserAutoFillInfo", "parse error for no.".concat(String.valueOf(i)));
          i += 1;
        }
        if (!str.equals("tax_number")) {
          break label882;
        }
        paramInt1 = 1;
      }
      catch (JSONException params)
      {
        int i;
        Object localObject;
        JSONObject localJSONObject;
        Log.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
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
                  paramArrayOfByte.ynR = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.ynT = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.ynS = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.type = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.fuD = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.ynV = localJSONObject.getString("value");
                  paramArrayOfByte.ynW = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.ynX = localJSONObject.getString("value");
                  break label928;
                  localObject = com.tencent.mm.plugin.address.a.a.bqc();
                  if ((paramArrayOfByte.type != null) && (paramArrayOfByte.type.equals("0")))
                  {
                    paramArrayOfByte.ynQ = "";
                    paramArrayOfByte.ynW = "";
                    paramArrayOfByte.fuD = "";
                    ((com.tencent.mm.plugin.address.b.a.a)localObject).ksN.ynO.add(paramArrayOfByte);
                    Log.i("MicroMsg.InvoiceMgr", "type is error..");
                    continue;
                  }
                  if ((paramArrayOfByte.type == null) || (!paramArrayOfByte.type.equals("1"))) {
                    continue;
                  }
                  paramArrayOfByte.ynQ = paramArrayOfByte.title;
                  paramArrayOfByte.title = "";
                  paramArrayOfByte.ynV = "";
                  paramArrayOfByte.ynR = "";
                  paramArrayOfByte.ynS = "";
                  paramArrayOfByte.ynT = "";
                  paramArrayOfByte.ynX = "";
                  ((com.tencent.mm.plugin.address.b.a.a)localObject).ksN.ynO.add(paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.b
 * JD-Core Version:    0.7.0.1
 */