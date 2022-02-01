package com.tencent.mm.plugin.mall.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.protobuf.bbm;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.ak.b rr;
  private String uAC;
  public ArrayList<MallFunction> uAD;
  public ArrayList<MallNews> uAE;
  public ArrayList<a> uAF;
  public SparseArray<String> uAG;
  public int uAH;
  
  public f(int paramInt1, String paramString, int paramInt2)
  {
    this(paramInt1, paramString, null, null, paramInt2);
  }
  
  private f(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(65994);
    this.uAD = null;
    this.uAE = null;
    this.uAF = null;
    this.uAG = null;
    this.uAH = 0;
    this.uAH = paramInt1;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hvt = new bbm();
    ((b.a)localObject1).hvu = new bbn();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/getpayfunctionlist";
    ((b.a)localObject1).funcId = 495;
    ((b.a)localObject1).reqCmdId = 227;
    ((b.a)localObject1).respCmdId = 1000000227;
    this.rr = ((b.a)localObject1).aAz();
    bbm localbbm = (bbm)this.rr.hvr.hvw;
    localbbm.ERV = paramString1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    if (!bs.isNullOrNil(paramString2))
    {
      localObject2 = (MallNews)c.esN().BBo.get(paramString2);
      if ((localObject2 != null) && (!bs.isNullOrNil(((MallNews)localObject2).ddJ)))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).add(((MallNews)localObject2).ddJ);
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
          crm localcrm = new crm();
          localcrm.aJV(str);
          localLinkedList.add(localcrm);
          localObject1 = (String)localObject1 + "; + " + str;
          continue;
          localObject1 = null;
          break;
          localObject1 = c.esN().esO();
          break;
        }
      }
      ac.d("MicroMsg.NetSceneGetPayFunctionList", "post with list : ".concat(String.valueOf(localObject1)));
    }
    localbbm.ERX = localLinkedList;
    localbbm.ERW = localLinkedList.size();
    if (bs.isNullOrNil(paramString3)) {}
    for (localbbm.tlX = String.format("tpa_country=%s", new Object[] { Integer.valueOf(paramInt1) });; localbbm.tlX = String.format("%s&tpa_country=%s", new Object[] { paramString3, Integer.valueOf(paramInt1) }))
    {
      localbbm.ERY = paramInt2;
      this.uAC = paramString2;
      ac.d("MicroMsg.NetSceneGetPayFunctionList", "telephonyNetIso " + paramString1 + " ExtInfo: " + localbbm.tlX);
      AppMethodBeat.o(65994);
      return;
    }
  }
  
  public f(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramInt, paramString1, paramString3, String.format("appid=%s&funcid=%s&url=%s", new Object[] { paramString2, paramString3, URLEncoder.encode(paramString4, "ISO-8859-1").toString() }), 0);
    AppMethodBeat.i(65993);
    AppMethodBeat.o(65993);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(65996);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(65996);
    return i;
  }
  
  public final int getType()
  {
    return 495;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65995);
    ac.i("MicroMsg.NetSceneGetPayFunctionList", "errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bbn)((com.tencent.mm.ak.b)paramq).hvs.hvw;
      ac.i("MicroMsg.NetSceneGetPayFunctionList", "resp.PayFunctionList wallet_regionL " + this.uAH + " " + paramq.ERZ);
    }
    try
    {
      if (!bs.isNullOrNil(paramq.ERZ))
      {
        Object localObject = new JSONObject(paramq.ERZ);
        paramArrayOfByte = ((JSONObject)localObject).optString("pay_func_list");
        this.uAD = com.tencent.mm.plugin.wallet_core.model.mall.b.K(new JSONArray(paramArrayOfByte));
        String str1 = ((JSONObject)localObject).optString("global_activity_list");
        String str2 = ((JSONObject)localObject).optString("pay_banner_list");
        localObject = ((JSONObject)localObject).optString("type_info_list");
        s.erD().b(this.uAH, paramArrayOfByte, str1, str2, (String)localObject, paramq.ESb);
        j.daN().uAQ.clear();
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(65995);
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionList", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.f
 * JD-Core Version:    0.7.0.1
 */