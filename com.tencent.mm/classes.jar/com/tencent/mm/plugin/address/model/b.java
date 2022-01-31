package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends m
  implements k
{
  private f callback;
  private com.tencent.mm.ai.b rr;
  
  public b()
  {
    AppMethodBeat.i(16725);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ard();
    ((b.a)localObject).fsY = new are();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
    ((b.a)localObject).funcId = 1191;
    this.rr = ((b.a)localObject).ado();
    localObject = (ard)this.rr.fsV.fta;
    ((ard)localObject).cpt = 2;
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
    ((ard)localObject).xgt = localLinkedList;
    ((ard)localObject).xgs = false;
    AppMethodBeat.o(16725);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(16727);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(16727);
    return i;
  }
  
  public final int getType()
  {
    return 1191;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16726);
    ab.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.address.a.a.asm().gKJ = new com.tencent.mm.plugin.j.a.a();
      ab.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we resetList and parse the json ..");
      paramq = (are)((com.tencent.mm.ai.b)paramq).fsW.fta;
      ab.i("MicroMsg.NetSceneGetUserAutoFillInfo", "resp json is.." + paramq.xgu);
      if (paramq.xgu == null) {}
    }
    for (;;)
    {
      int j;
      try
      {
        paramq = new JSONObject(paramq.xgu).getJSONArray("user_data_list").getJSONObject(0).getJSONArray("group_info_list");
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
          paramArrayOfByte.nLm = ((JSONObject)localObject).getInt("group_id");
          paramArrayOfByte.nLv = ((JSONObject)localObject).getString("invoice_url");
          ab.i("MicroMsg.NetSceneGetUserAutoFillInfo", "get groupid:" + ((JSONObject)localObject).getInt("group_id") + "get invoiceUrl:" + ((JSONObject)localObject).getString("invoice_url"));
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
          ab.e("MicroMsg.NetSceneGetUserAutoFillInfo", "parse error for no.".concat(String.valueOf(i)));
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
        ab.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
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
                  paramArrayOfByte.nLo = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.nLq = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.nLp = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.type = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.dqF = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.nLs = localJSONObject.getString("value");
                  paramArrayOfByte.nLt = localJSONObject.getString("value");
                  break label928;
                  paramArrayOfByte.nLu = localJSONObject.getString("value");
                  break label928;
                  localObject = com.tencent.mm.plugin.address.a.a.asm();
                  if ((paramArrayOfByte.type != null) && (paramArrayOfByte.type.equals("0")))
                  {
                    paramArrayOfByte.nLn = "";
                    paramArrayOfByte.nLt = "";
                    paramArrayOfByte.dqF = "";
                    ((com.tencent.mm.plugin.address.b.a.a)localObject).gKJ.nLl.add(paramArrayOfByte);
                    ab.i("MicroMsg.InvoiceMgr", "type is error..");
                    continue;
                  }
                  if ((paramArrayOfByte.type == null) || (!paramArrayOfByte.type.equals("1"))) {
                    continue;
                  }
                  paramArrayOfByte.nLn = paramArrayOfByte.title;
                  paramArrayOfByte.title = "";
                  paramArrayOfByte.nLs = "";
                  paramArrayOfByte.nLo = "";
                  paramArrayOfByte.nLp = "";
                  paramArrayOfByte.nLq = "";
                  paramArrayOfByte.nLu = "";
                  ((com.tencent.mm.plugin.address.b.a.a)localObject).gKJ.nLl.add(paramArrayOfByte);
                  continue;
                  label861:
                  this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
                  AppMethodBeat.o(16726);
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