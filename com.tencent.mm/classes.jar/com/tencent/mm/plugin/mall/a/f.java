package com.tencent.mm.plugin.mall.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private String oxJ;
  public ArrayList<MallFunction> oxK;
  public ArrayList<MallNews> oxL;
  public ArrayList<a> oxM;
  public SparseArray<String> oxN;
  public int oxO;
  private com.tencent.mm.ai.b rr;
  
  public f(int paramInt1, String paramString, int paramInt2)
  {
    this(paramInt1, paramString, null, null, paramInt2);
  }
  
  private f(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(43099);
    this.oxK = null;
    this.oxL = null;
    this.oxM = null;
    this.oxN = null;
    this.oxO = 0;
    this.oxO = paramInt1;
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new anp();
    ((b.a)localObject1).fsY = new anq();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/getpayfunctionlist";
    ((b.a)localObject1).funcId = 495;
    ((b.a)localObject1).reqCmdId = 227;
    ((b.a)localObject1).respCmdId = 1000000227;
    this.rr = ((b.a)localObject1).ado();
    anp localanp = (anp)this.rr.fsV.fta;
    localanp.xdO = paramString1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    if (!bo.isNullOrNil(paramString2))
    {
      localObject2 = (MallNews)c.cUX().umy.get(paramString2);
      if ((localObject2 != null) && (!bo.isNullOrNil(((MallNews)localObject2).crs)))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).add(((MallNews)localObject2).crs);
      }
    }
    while ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject2 = ((List)localObject1).iterator();
      localObject1 = "";
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          bwc localbwc = new bwc();
          localbwc.aoF(str);
          localLinkedList.add(localbwc);
          localObject1 = (String)localObject1 + "; + " + str;
          continue;
          localObject1 = null;
          break;
          localObject1 = c.cUX().cUY();
          break;
        }
      }
      ab.d("MicroMsg.NetSceneGetPayFunctionList", "post with list : ".concat(String.valueOf(localObject1)));
    }
    localanp.xdQ = localLinkedList;
    localanp.xdP = localLinkedList.size();
    if (bo.isNullOrNil(paramString3)) {}
    for (localanp.nuz = String.format("tpa_country=%s", new Object[] { Integer.valueOf(paramInt1) });; localanp.nuz = String.format("%s&tpa_country=%s", new Object[] { paramString3, Integer.valueOf(paramInt1) }))
    {
      localanp.xdR = paramInt2;
      this.oxJ = paramString2;
      ab.d("MicroMsg.NetSceneGetPayFunctionList", "telephonyNetIso " + paramString1 + " ExtInfo: " + localanp.nuz);
      AppMethodBeat.o(43099);
      return;
    }
  }
  
  public f(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramInt, paramString1, paramString3, String.format("appid=%s&funcid=%s&url=%s", new Object[] { paramString2, paramString3, URLEncoder.encode(paramString4, "ISO-8859-1").toString() }), 0);
    AppMethodBeat.i(43098);
    AppMethodBeat.o(43098);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(43101);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(43101);
    return i;
  }
  
  public final int getType()
  {
    return 495;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43100);
    ab.i("MicroMsg.NetSceneGetPayFunctionList", "errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (anq)((com.tencent.mm.ai.b)paramq).fsW.fta;
      ab.i("MicroMsg.NetSceneGetPayFunctionList", "resp.PayFunctionList wallet_regionL " + this.oxO + " " + paramq.xdS);
    }
    try
    {
      if (!bo.isNullOrNil(paramq.xdS))
      {
        Object localObject = new JSONObject(paramq.xdS);
        paramArrayOfByte = ((JSONObject)localObject).optString("pay_func_list");
        this.oxK = com.tencent.mm.plugin.wallet_core.model.mall.b.I(new JSONArray(paramArrayOfByte));
        String str1 = ((JSONObject)localObject).optString("global_activity_list");
        String str2 = ((JSONObject)localObject).optString("pay_banner_list");
        localObject = ((JSONObject)localObject).optString("type_info_list");
        t.cTS().b(this.oxO, paramArrayOfByte, str1, str2, (String)localObject, paramq.xdU);
        j.bOs().oxW.clear();
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(43100);
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionList", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.f
 * JD-Core Version:    0.7.0.1
 */