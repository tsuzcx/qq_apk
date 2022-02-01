package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.cuq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public b()
  {
    AppMethodBeat.i(20768);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cup();
    ((c.a)localObject).otF = new cuq();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
    ((c.a)localObject).funcId = 1191;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cup)c.b.b(this.rr.otB);
    ((cup)localObject).source = 2;
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
    ((cup)localObject).aaAe = localLinkedList;
    ((cup)localObject).aaAd = false;
    AppMethodBeat.o(20768);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(20770);
    this.callback = paramh;
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
      com.tencent.mm.plugin.address.a.a.bZf().qhF = new com.tencent.mm.plugin.o.a.a();
      Log.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we resetList and parse the json ..");
      params = (cuq)c.c.b(((c)params).otC);
      Log.i("MicroMsg.NetSceneGetUserAutoFillInfo", "resp json is.." + params.aaAf);
      if (params.aaAf == null) {}
    }
    for (;;)
    {
      int j;
      try
      {
        params = new JSONObject(params.aaAf).getJSONArray("user_data_list").getJSONObject(0).getJSONArray("group_info_list");
        if ((params == null) || (params.length() <= 0)) {
          break label871;
        }
        i = 0;
        paramInt1 = params.length();
        if (i >= paramInt1) {
          break label871;
        }
        try
        {
          localObject = params.getJSONObject(i);
          paramArrayOfByte = new com.tencent.mm.plugin.o.a.b();
          paramArrayOfByte.JFg = ((JSONObject)localObject).getInt("group_id");
          paramArrayOfByte.JFp = ((JSONObject)localObject).getString("invoice_url");
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
              break label892;
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
          break label892;
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
        break label892;
        if (str.equals("bank_number"))
        {
          paramInt1 = 3;
          break label892;
          if (str.equals("type"))
          {
            paramInt1 = 4;
            break label892;
            if (str.equals("email"))
            {
              paramInt1 = 5;
              break label892;
              if (str.equals("phone"))
              {
                paramInt1 = 6;
                break label892;
                if (str.equals("company_address_detail"))
                {
                  paramInt1 = 7;
                  break label892;
                  paramArrayOfByte.title = localJSONObject.getString("value");
                  break label940;
                  continue;
                  paramArrayOfByte.JFi = localJSONObject.getString("value");
                  break label940;
                  paramArrayOfByte.JFk = localJSONObject.getString("value");
                  break label940;
                  paramArrayOfByte.JFj = localJSONObject.getString("value");
                  break label940;
                  paramArrayOfByte.type = localJSONObject.getString("value");
                  break label940;
                  paramArrayOfByte.kab = localJSONObject.getString("value");
                  break label940;
                  paramArrayOfByte.JFm = localJSONObject.getString("value");
                  paramArrayOfByte.JFn = localJSONObject.getString("value");
                  break label940;
                  paramArrayOfByte.JFo = localJSONObject.getString("value");
                  break label940;
                  localObject = com.tencent.mm.plugin.address.a.a.bZf();
                  if ((paramArrayOfByte.type != null) && (paramArrayOfByte.type.equals("0")))
                  {
                    paramArrayOfByte.JFh = "";
                    paramArrayOfByte.JFn = "";
                    paramArrayOfByte.kab = "";
                    ((com.tencent.mm.plugin.address.b.a.a)localObject).qhF.JFf.add(paramArrayOfByte);
                    Log.i("MicroMsg.InvoiceMgr", "type is error..");
                    continue;
                  }
                  if ((paramArrayOfByte.type == null) || (!paramArrayOfByte.type.equals("1"))) {
                    continue;
                  }
                  paramArrayOfByte.JFh = paramArrayOfByte.title;
                  paramArrayOfByte.title = "";
                  paramArrayOfByte.JFm = "";
                  paramArrayOfByte.JFi = "";
                  paramArrayOfByte.JFj = "";
                  paramArrayOfByte.JFk = "";
                  paramArrayOfByte.JFo = "";
                  ((com.tencent.mm.plugin.address.b.a.a)localObject).qhF.JFf.add(paramArrayOfByte);
                  continue;
                  label871:
                  this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
                  AppMethodBeat.o(20769);
                  return;
                }
              }
            }
          }
        }
      }
      label892:
      switch (paramInt1)
      {
      }
      label940:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.b
 * JD-Core Version:    0.7.0.1
 */