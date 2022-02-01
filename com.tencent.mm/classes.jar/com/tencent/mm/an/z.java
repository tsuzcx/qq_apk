package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cfv;
import com.tencent.mm.protocal.protobuf.cfw;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class z
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private Object cpt;
  public com.tencent.mm.am.c rr;
  
  private z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124132);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cfv();
    ((c.a)localObject).otF = new cfw();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizjsapiresult";
    ((c.a)localObject).funcId = 1285;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cfv)c.b.b(this.rr.otB);
    ((cfv)localObject).ZpC = paramString1;
    ((cfv)localObject).bUl = 1;
    ((cfv)localObject).data = paramString2;
    this.cpt = null;
    AppMethodBeat.o(124132);
  }
  
  public static void a(com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(124129);
    com.tencent.mm.kernel.h.baD().mCm.a(1285, paramh);
    AppMethodBeat.o(124129);
  }
  
  public static void b(com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(124130);
    com.tencent.mm.kernel.h.baD().mCm.b(1285, paramh);
    AppMethodBeat.o(124130);
  }
  
  public static boolean t(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(124131);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("brand_user_name", paramString2);
      localJSONObject.put("bizchat_id", paramString3);
      paramString1 = new z(paramString1, localJSONObject.toString());
      boolean bool = com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
      AppMethodBeat.o(124131);
      return bool;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(124131);
    }
    return false;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(124134);
    this.callback = paramh;
    Log.i("MicroMsg.NetSceneGetBizJsApiResult", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124134);
    return i;
  }
  
  public final int getType()
  {
    return 1285;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124133);
    Log.d("MicroMsg.NetSceneGetBizJsApiResult", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.z
 * JD-Core Version:    0.7.0.1
 */