package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class z
  extends n
  implements k
{
  private f callback;
  private Object data;
  public com.tencent.mm.ak.b rr;
  
  private z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124132);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ayl();
    ((b.a)localObject).hQG = new aym();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizjsapiresult";
    ((b.a)localObject).funcId = 1285;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ayl)this.rr.hQD.hQJ;
    ((ayl)localObject).GtF = paramString1;
    ((ayl)localObject).EN = 1;
    ((ayl)localObject).data = paramString2;
    this.data = null;
    AppMethodBeat.o(124132);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(124129);
    g.ajQ().gDv.a(1285, paramf);
    AppMethodBeat.o(124129);
  }
  
  public static void b(f paramf)
  {
    AppMethodBeat.i(124130);
    g.ajQ().gDv.b(1285, paramf);
    AppMethodBeat.o(124130);
  }
  
  public static boolean m(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(124131);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("brand_user_name", paramString2);
      localJSONObject.put("bizchat_id", paramString3);
      paramString1 = new z(paramString1, localJSONObject.toString());
      boolean bool = g.ajQ().gDv.a(paramString1, 0);
      AppMethodBeat.o(124131);
      return bool;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(124131);
    }
    return false;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124134);
    this.callback = paramf;
    ae.i("MicroMsg.NetSceneGetBizJsApiResult", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124134);
    return i;
  }
  
  public final int getType()
  {
    return 1285;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124133);
    ae.d("MicroMsg.NetSceneGetBizJsApiResult", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.z
 * JD-Core Version:    0.7.0.1
 */