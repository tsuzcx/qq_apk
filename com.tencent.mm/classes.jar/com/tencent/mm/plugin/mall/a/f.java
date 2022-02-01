package com.tencent.mm.plugin.mall.a;

import android.util.SparseArray;
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
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.bsc;
import com.tencent.mm.protocal.protobuf.bsd;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  extends q
  implements m
{
  private i callback;
  private d rr;
  private String zjn;
  public ArrayList<MallFunction> zjo;
  public ArrayList<MallNews> zjp;
  public ArrayList<a> zjq;
  public SparseArray<String> zjr;
  public int zjs;
  
  public f(int paramInt1, String paramString, int paramInt2)
  {
    this(paramInt1, paramString, null, null, paramInt2);
  }
  
  private f(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(65994);
    this.zjo = null;
    this.zjp = null;
    this.zjq = null;
    this.zjr = null;
    this.zjs = 0;
    this.zjs = paramInt1;
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new bsc();
    ((d.a)localObject1).iLO = new bsd();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/getpayfunctionlist";
    ((d.a)localObject1).funcId = 495;
    ((d.a)localObject1).iLP = 227;
    ((d.a)localObject1).respCmdId = 1000000227;
    this.rr = ((d.a)localObject1).aXF();
    bsc localbsc = (bsc)this.rr.iLK.iLR;
    localbsc.LZf = paramString1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    if (!Util.isNullOrNil(paramString2))
    {
      localObject2 = (MallNews)c.fSg().Icv.get(paramString2);
      if ((localObject2 != null) && (!Util.isNullOrNil(((MallNews)localObject2).dHx)))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).add(((MallNews)localObject2).dHx);
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
          dqi localdqi = new dqi();
          localdqi.bhy(str);
          localLinkedList.add(localdqi);
          localObject1 = (String)localObject1 + "; + " + str;
          continue;
          localObject1 = null;
          break;
          localObject1 = c.fSg().fSh();
          break;
        }
      }
      Log.d("MicroMsg.NetSceneGetPayFunctionList", "post with list : ".concat(String.valueOf(localObject1)));
    }
    localbsc.LZh = localLinkedList;
    localbsc.LZg = localLinkedList.size();
    if (Util.isNullOrNil(paramString3)) {}
    for (localbsc.xNU = String.format("tpa_country=%s", new Object[] { Integer.valueOf(paramInt1) });; localbsc.xNU = String.format("%s&tpa_country=%s", new Object[] { paramString3, Integer.valueOf(paramInt1) }))
    {
      localbsc.LZi = paramInt2;
      this.zjn = paramString2;
      Log.d("MicroMsg.NetSceneGetPayFunctionList", "telephonyNetIso " + paramString1 + " ExtInfo: " + localbsc.xNU);
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
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(65996);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(65996);
    return i;
  }
  
  public final int getType()
  {
    return 495;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65995);
    Log.i("MicroMsg.NetSceneGetPayFunctionList", "errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (bsd)((d)params).iLL.iLR;
      Log.i("MicroMsg.NetSceneGetPayFunctionList", "resp.PayFunctionList wallet_regionL " + this.zjs + " " + params.LZj);
    }
    try
    {
      if (!Util.isNullOrNil(params.LZj))
      {
        Object localObject = new JSONObject(params.LZj);
        paramArrayOfByte = ((JSONObject)localObject).optString("pay_func_list");
        this.zjo = b.R(new JSONArray(paramArrayOfByte));
        String str1 = ((JSONObject)localObject).optString("global_activity_list");
        String str2 = ((JSONObject)localObject).optString("pay_banner_list");
        localObject = ((JSONObject)localObject).optString("type_info_list");
        t.fQN().b(this.zjs, paramArrayOfByte, str1, str2, (String)localObject, params.LZl);
        k.egL().zjD.clear();
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(65995);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.f
 * JD-Core Version:    0.7.0.1
 */