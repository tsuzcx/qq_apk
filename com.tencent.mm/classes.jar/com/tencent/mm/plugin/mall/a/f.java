package com.tencent.mm.plugin.mall.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.protocal.protobuf.cph;
import com.tencent.mm.protocal.protobuf.cpi;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.w;
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
  extends w
{
  private String KJc;
  public ArrayList<MallFunction> KJd;
  public ArrayList<MallNews> KJe;
  public ArrayList<a> KJf;
  public SparseArray<String> KJg;
  public int KJh;
  private h callback;
  private com.tencent.mm.am.c rr;
  
  public f(int paramInt1, String paramString, int paramInt2)
  {
    this(paramInt1, paramString, null, null, paramInt2);
  }
  
  private f(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(65994);
    this.KJd = null;
    this.KJe = null;
    this.KJf = null;
    this.KJg = null;
    this.KJh = 0;
    this.KJh = paramInt1;
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = new cph();
    ((c.a)localObject1).otF = new cpi();
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/getpayfunctionlist";
    ((c.a)localObject1).funcId = 495;
    ((c.a)localObject1).otG = 227;
    ((c.a)localObject1).respCmdId = 1000000227;
    this.rr = ((c.a)localObject1).bEF();
    cph localcph = (cph)c.b.b(this.rr.otB);
    localcph.aavX = paramString1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    if (!Util.isNullOrNil(paramString2))
    {
      localObject2 = (MallNews)com.tencent.mm.plugin.wallet_core.model.mall.c.ikd().VKY.get(paramString2);
      if ((localObject2 != null) && (!Util.isNullOrNil(((MallNews)localObject2).hFb)))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).add(((MallNews)localObject2).hFb);
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
          etl localetl = new etl();
          localetl.btH(str);
          localLinkedList.add(localetl);
          localObject1 = (String)localObject1 + "; + " + str;
          continue;
          localObject1 = null;
          break;
          localObject1 = com.tencent.mm.plugin.wallet_core.model.mall.c.ikd().ike();
          break;
        }
      }
      Log.d("MicroMsg.NetSceneGetPayFunctionList", "post with list : ".concat(String.valueOf(localObject1)));
    }
    localcph.aavZ = localLinkedList;
    localcph.aavY = localLinkedList.size();
    if (Util.isNullOrNil(paramString3)) {}
    for (localcph.IMu = String.format("tpa_country=%s", new Object[] { Integer.valueOf(paramInt1) });; localcph.IMu = String.format("%s&tpa_country=%s", new Object[] { paramString3, Integer.valueOf(paramInt1) }))
    {
      localcph.aawa = paramInt2;
      this.KJc = paramString2;
      Log.d("MicroMsg.NetSceneGetPayFunctionList", "telephonyNetIso " + paramString1 + " ExtInfo: " + localcph.IMu);
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
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(65996);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(65996);
    return i;
  }
  
  public final int getType()
  {
    return 495;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(262386);
    Log.i("MicroMsg.NetSceneGetPayFunctionList", "errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cpi)c.c.b(((com.tencent.mm.am.c)params).otC);
      Log.i("MicroMsg.NetSceneGetPayFunctionList", "resp.PayFunctionList wallet_regionL " + this.KJh + " " + params.aawb);
    }
    try
    {
      if (!Util.isNullOrNil(params.aawb))
      {
        Object localObject = new JSONObject(params.aawb);
        paramArrayOfByte = ((JSONObject)localObject).optString("pay_func_list");
        this.KJd = b.Y(new JSONArray(paramArrayOfByte));
        String str1 = ((JSONObject)localObject).optString("global_activity_list");
        String str2 = ((JSONObject)localObject).optString("pay_banner_list");
        localObject = ((JSONObject)localObject).optString("type_info_list");
        u.iiH().c(this.KJh, paramArrayOfByte, str1, str2, (String)localObject, params.aawd);
        k.fZb().KJs.clear();
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(262386);
      return;
    }
    catch (JSONException params)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionList", params, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.f
 * JD-Core Version:    0.7.0.1
 */