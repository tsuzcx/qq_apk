package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.openapi.a;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.protocal.protobuf.avf;
import com.tencent.mm.protocal.protobuf.eus;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.fqh;
import com.tencent.mm.protocal.protobuf.fqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ad
  extends p
  implements m
{
  private h callback;
  private String oTs;
  private final c rr;
  
  public ad(String paramString, int paramInt, LinkedList<ez> paramLinkedList)
  {
    AppMethodBeat.i(150960);
    Log.i("MicroMsg.NetSceneTranslateLink", "ticket link = " + paramString + "; scene = " + paramInt);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fqh();
    ((c.a)localObject).otF = new fqi();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/translatelink";
    ((c.a)localObject).funcId = 1200;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fqh)c.b.b(this.rr.otB);
    ((fqh)localObject).link = paramString;
    ((fqh)localObject).scene = paramInt;
    ((fqh)localObject).abQd = paramLinkedList;
    AppMethodBeat.o(150960);
  }
  
  private static JSONObject a(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(236699);
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("jumpType", paramInt);
      localJSONObject1.put("wording", paramJSONObject.optString("wording"));
      localJSONObject1.put("extra", paramJSONObject.optString("extra"));
      JSONObject localJSONObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(236699);
        return null;
      case 1: 
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("appusername", paramJSONObject.optString("username") + "@app");
        localJSONObject2.put("path", paramJSONObject.optString("path"));
        localJSONObject1.put("miniAppInfo", localJSONObject2);
      }
      for (;;)
      {
        AppMethodBeat.o(236699);
        return localJSONObject1;
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("url", paramJSONObject.optString("url"));
        localJSONObject1.put("html5Info", localJSONObject2);
      }
      return null;
    }
    catch (Exception paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneTranslateLink", paramJSONObject, "parseFinderComponentJumpInfo exception", new Object[0]);
      AppMethodBeat.o(236699);
    }
  }
  
  public final void Pd(String paramString)
  {
    AppMethodBeat.i(236702);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      int i = localJSONObject.optInt("jumpType");
      localJSONObject.remove("jumpType");
      localJSONObject = a(i, localJSONObject);
      if (localJSONObject == null)
      {
        Log.w("MicroMsg.NetSceneTranslateLink", "setFinderJumpInfo jumpInfo invalid");
        AppMethodBeat.o(236702);
        return;
      }
      this.oTs = localJSONObject.toString();
      localJSONObject.remove("jumpType");
      Log.i("MicroMsg.NetSceneTranslateLink", "setFinderJumpInfo finderJumpInfo: %s, jumpInfo: %s", new Object[] { paramString, localJSONObject });
      paramString = new eus();
      paramString.abxt = new avf();
      paramString.abxt.jump_type = i;
      paramString.abxt.ZFy = localJSONObject.toString();
      ((fqh)c.b.b(this.rr.otB)).abQe = paramString;
      AppMethodBeat.o(236702);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneTranslateLink", paramString, "setFinderComponentInfo exception", new Object[0]);
      AppMethodBeat.o(236702);
    }
  }
  
  public final String Pe(String paramString)
  {
    AppMethodBeat.i(236720);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(236720);
      return null;
    }
    try
    {
      if (!Util.isNullOrNil(this.oTs))
      {
        a.gxn();
        if ((paramString == null) || (paramString.length() == 0)) {
          Log.e("MicroMsg.AppInfoStorage", "hasIconUrl, appId is null");
        }
        for (String str1 = null;; str1 = j.a(a.gxn().bpR(paramString), paramString))
        {
          String str2 = str1;
          if (Util.isNullOrNil(str1))
          {
            a.gxm();
            com.tencent.mm.pluginsdk.model.app.g localg = i.bpQ(paramString);
            str2 = str1;
            if (localg != null)
            {
              a.gxn();
              str2 = j.a(localg, paramString);
            }
          }
          paramString = new JSONObject(this.oTs);
          paramString.put("iconurl", Util.nullAs(str2, ""));
          paramString = paramString.toString();
          AppMethodBeat.o(236720);
          return paramString;
        }
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneTranslateLink", paramString, "getFinderJumpInfo exception", new Object[0]);
      AppMethodBeat.o(236720);
    }
  }
  
  public final fqi bMA()
  {
    AppMethodBeat.i(236715);
    if ((this.rr != null) && (c.c.b(this.rr.otC) != null))
    {
      fqi localfqi = (fqi)c.c.b(this.rr.otC);
      AppMethodBeat.o(236715);
      return localfqi;
    }
    AppMethodBeat.o(236715);
    return null;
  }
  
  public final String bMz()
  {
    AppMethodBeat.i(236711);
    Object localObject = (fqi)c.c.b(this.rr.otC);
    if (localObject == null)
    {
      AppMethodBeat.o(236711);
      return null;
    }
    localObject = ((fqi)localObject).abQf;
    AppMethodBeat.o(236711);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(150961);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150961);
    return i;
  }
  
  public final int getType()
  {
    return 1200;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150962);
    Log.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ad
 * JD-Core Version:    0.7.0.1
 */