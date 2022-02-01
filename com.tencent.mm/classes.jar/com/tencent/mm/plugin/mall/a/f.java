package com.tencent.mm.plugin.mall.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.bgg;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.f callback;
  private com.tencent.mm.ak.b rr;
  private String vPj;
  public ArrayList<MallFunction> vPk;
  public ArrayList<MallNews> vPl;
  public ArrayList<a> vPm;
  public SparseArray<String> vPn;
  public int vPo;
  
  public f(int paramInt1, String paramString, int paramInt2)
  {
    this(paramInt1, paramString, null, null, paramInt2);
  }
  
  private f(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(65994);
    this.vPk = null;
    this.vPl = null;
    this.vPm = null;
    this.vPn = null;
    this.vPo = 0;
    this.vPo = paramInt1;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hQF = new bgg();
    ((b.a)localObject1).hQG = new bgh();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/getpayfunctionlist";
    ((b.a)localObject1).funcId = 495;
    ((b.a)localObject1).hQH = 227;
    ((b.a)localObject1).respCmdId = 1000000227;
    this.rr = ((b.a)localObject1).aDS();
    bgg localbgg = (bgg)this.rr.hQD.hQJ;
    localbgg.GUN = paramString1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    if (!bu.isNullOrNil(paramString2))
    {
      localObject2 = (MallNews)c.eKB().Dtk.get(paramString2);
      if ((localObject2 != null) && (!bu.isNullOrNil(((MallNews)localObject2).dqk)))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).add(((MallNews)localObject2).dqk);
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
          cxn localcxn = new cxn();
          localcxn.aQV(str);
          localLinkedList.add(localcxn);
          localObject1 = (String)localObject1 + "; + " + str;
          continue;
          localObject1 = null;
          break;
          localObject1 = c.eKB().eKC();
          break;
        }
      }
      ae.d("MicroMsg.NetSceneGetPayFunctionList", "post with list : ".concat(String.valueOf(localObject1)));
    }
    localbgg.GUP = localLinkedList;
    localbgg.GUO = localLinkedList.size();
    if (bu.isNullOrNil(paramString3)) {}
    for (localbgg.uvT = String.format("tpa_country=%s", new Object[] { Integer.valueOf(paramInt1) });; localbgg.uvT = String.format("%s&tpa_country=%s", new Object[] { paramString3, Integer.valueOf(paramInt1) }))
    {
      localbgg.GUQ = paramInt2;
      this.vPj = paramString2;
      ae.d("MicroMsg.NetSceneGetPayFunctionList", "telephonyNetIso " + paramString1 + " ExtInfo: " + localbgg.uvT);
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
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(65996);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneGetPayFunctionList", "errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bgh)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
      ae.i("MicroMsg.NetSceneGetPayFunctionList", "resp.PayFunctionList wallet_regionL " + this.vPo + " " + paramq.GUR);
    }
    try
    {
      if (!bu.isNullOrNil(paramq.GUR))
      {
        Object localObject = new JSONObject(paramq.GUR);
        paramArrayOfByte = ((JSONObject)localObject).optString("pay_func_list");
        this.vPk = com.tencent.mm.plugin.wallet_core.model.mall.b.M(new JSONArray(paramArrayOfByte));
        String str1 = ((JSONObject)localObject).optString("global_activity_list");
        String str2 = ((JSONObject)localObject).optString("pay_banner_list");
        localObject = ((JSONObject)localObject).optString("type_info_list");
        t.eJk().b(this.vPo, paramArrayOfByte, str1, str2, (String)localObject, paramq.GUT);
        k.dmZ().vPz.clear();
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(65995);
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionList", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.f
 * JD-Core Version:    0.7.0.1
 */