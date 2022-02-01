package com.tencent.mm.plugin.mall.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.protobuf.axu;
import com.tencent.mm.protocal.protobuf.axv;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private com.tencent.mm.al.b rr;
  private String tsj;
  public ArrayList<MallFunction> tsk;
  public ArrayList<MallNews> tsl;
  public ArrayList<a> tsm;
  public SparseArray<String> tsn;
  public int tso;
  
  public f(int paramInt1, String paramString, int paramInt2)
  {
    this(paramInt1, paramString, null, null, paramInt2);
  }
  
  private f(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(65994);
    this.tsk = null;
    this.tsl = null;
    this.tsm = null;
    this.tsn = null;
    this.tso = 0;
    this.tso = paramInt1;
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new axu();
    ((b.a)localObject1).gUV = new axv();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/getpayfunctionlist";
    ((b.a)localObject1).funcId = 495;
    ((b.a)localObject1).reqCmdId = 227;
    ((b.a)localObject1).respCmdId = 1000000227;
    this.rr = ((b.a)localObject1).atI();
    axu localaxu = (axu)this.rr.gUS.gUX;
    localaxu.DwA = paramString1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    if (!bt.isNullOrNil(paramString2))
    {
      localObject2 = (MallNews)c.eds().AiT.get(paramString2);
      if ((localObject2 != null) && (!bt.isNullOrNil(((MallNews)localObject2).dgo)))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).add(((MallNews)localObject2).dgo);
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
          cmf localcmf = new cmf();
          localcmf.aEE(str);
          localLinkedList.add(localcmf);
          localObject1 = (String)localObject1 + "; + " + str;
          continue;
          localObject1 = null;
          break;
          localObject1 = c.eds().edt();
          break;
        }
      }
      ad.d("MicroMsg.NetSceneGetPayFunctionList", "post with list : ".concat(String.valueOf(localObject1)));
    }
    localaxu.DwC = localLinkedList;
    localaxu.DwB = localLinkedList.size();
    if (bt.isNullOrNil(paramString3)) {}
    for (localaxu.sed = String.format("tpa_country=%s", new Object[] { Integer.valueOf(paramInt1) });; localaxu.sed = String.format("%s&tpa_country=%s", new Object[] { paramString3, Integer.valueOf(paramInt1) }))
    {
      localaxu.DwD = paramInt2;
      this.tsj = paramString2;
      ad.d("MicroMsg.NetSceneGetPayFunctionList", "telephonyNetIso " + paramString1 + " ExtInfo: " + localaxu.sed);
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
    ad.i("MicroMsg.NetSceneGetPayFunctionList", "errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (axv)((com.tencent.mm.al.b)paramq).gUT.gUX;
      ad.i("MicroMsg.NetSceneGetPayFunctionList", "resp.PayFunctionList wallet_regionL " + this.tso + " " + paramq.DwE);
    }
    try
    {
      if (!bt.isNullOrNil(paramq.DwE))
      {
        Object localObject = new JSONObject(paramq.DwE);
        paramArrayOfByte = ((JSONObject)localObject).optString("pay_func_list");
        this.tsk = com.tencent.mm.plugin.wallet_core.model.mall.b.K(new JSONArray(paramArrayOfByte));
        String str1 = ((JSONObject)localObject).optString("global_activity_list");
        String str2 = ((JSONObject)localObject).optString("pay_banner_list");
        localObject = ((JSONObject)localObject).optString("type_info_list");
        s.ech().b(this.tso, paramArrayOfByte, str1, str2, (String)localObject, paramq.DwG);
        j.cNg().tsx.clear();
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(65995);
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionList", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.f
 * JD-Core Version:    0.7.0.1
 */