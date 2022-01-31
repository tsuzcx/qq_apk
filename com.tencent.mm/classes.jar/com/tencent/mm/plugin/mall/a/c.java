package com.tencent.mm.plugin.mall.a;

import android.util.SparseArray;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.protocal.c.aim;
import com.tencent.mm.protocal.c.ain;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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

public final class c
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  private String lYi;
  public ArrayList<MallFunction> lYj = null;
  public ArrayList<MallNews> lYk = null;
  public ArrayList<a> lYl = null;
  public SparseArray<String> lYm = null;
  public int lYn = 0;
  
  public c(int paramInt, String paramString)
  {
    this(paramInt, paramString, null, null);
  }
  
  private c(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.lYn = paramInt;
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new aim();
    ((b.a)localObject1).ecI = new ain();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/getpayfunctionlist";
    ((b.a)localObject1).ecG = 495;
    ((b.a)localObject1).ecJ = 227;
    ((b.a)localObject1).ecK = 1000000227;
    this.dmK = ((b.a)localObject1).Kt();
    aim localaim = (aim)this.dmK.ecE.ecN;
    localaim.tfC = paramString1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    if (!bk.bl(paramString2))
    {
      localObject2 = (MallNews)com.tencent.mm.plugin.wallet_core.model.mall.c.bWg().qzO.get(paramString2);
      if ((localObject2 != null) && (!bk.bl(((MallNews)localObject2).bJY)))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).add(((MallNews)localObject2).bJY);
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
          bml localbml = new bml();
          localbml.YI(str);
          localLinkedList.add(localbml);
          localObject1 = (String)localObject1 + "; + " + str;
          continue;
          localObject1 = null;
          break;
          localObject1 = com.tencent.mm.plugin.wallet_core.model.mall.c.bWg().bWh();
          break;
        }
      }
      y.d("MicroMsg.NetSceneGetPayFunctionList", "post with list : " + (String)localObject1);
    }
    localaim.tfE = localLinkedList;
    localaim.tfD = localLinkedList.size();
    if (bk.bl(paramString3)) {}
    for (localaim.kWx = String.format("tpa_country=%s", new Object[] { Integer.valueOf(paramInt) });; localaim.kWx = String.format("%s&tpa_country=%s", new Object[] { paramString3, Integer.valueOf(paramInt) }))
    {
      this.lYi = paramString2;
      y.d("MicroMsg.NetSceneGetPayFunctionList", "telephonyNetIso " + paramString1 + " ExtInfo: " + localaim.kWx);
      return;
    }
  }
  
  public c(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramInt, paramString1, paramString3, String.format("appid=%s&funcid=%s&url=%s", new Object[] { paramString2, paramString3, URLEncoder.encode(paramString4, "ISO-8859-1").toString() }));
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetPayFunctionList", "errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ain)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      y.i("MicroMsg.NetSceneGetPayFunctionList", "resp.PayFunctionList wallet_regionL " + this.lYn + " " + paramq.tfF);
    }
    try
    {
      if (!bk.bl(paramq.tfF))
      {
        Object localObject = new JSONObject(paramq.tfF);
        paramq = ((JSONObject)localObject).optString("pay_func_list");
        this.lYj = com.tencent.mm.plugin.wallet_core.model.mall.b.C(new JSONArray(paramq));
        paramArrayOfByte = ((JSONObject)localObject).optString("global_activity_list");
        String str = ((JSONObject)localObject).optString("pay_banner_list");
        localObject = ((JSONObject)localObject).optString("type_info_list");
        o.bVx().b(this.lYn, paramq, paramArrayOfByte, str, (String)localObject);
        f.bgz().lYr.clear();
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionList", paramq, "", new Object[0]);
      }
    }
  }
  
  public final int getType()
  {
    return 495;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.c
 * JD-Core Version:    0.7.0.1
 */