package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.atx;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class y
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private Object data;
  public com.tencent.mm.ak.b rr;
  
  private y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124132);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new atx();
    ((b.a)localObject).hvu = new aty();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizjsapiresult";
    ((b.a)localObject).funcId = 1285;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (atx)this.rr.hvr.hvw;
    ((atx)localObject).EtG = paramString1;
    ((atx)localObject).CW = 1;
    ((atx)localObject).data = paramString2;
    this.data = null;
    AppMethodBeat.o(124132);
  }
  
  public static void a(com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(124129);
    com.tencent.mm.kernel.g.agQ().ghe.a(1285, paramg);
    AppMethodBeat.o(124129);
  }
  
  public static void b(com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(124130);
    com.tencent.mm.kernel.g.agQ().ghe.b(1285, paramg);
    AppMethodBeat.o(124130);
  }
  
  public static boolean n(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(124131);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("brand_user_name", paramString2);
      localJSONObject.put("bizchat_id", paramString3);
      paramString1 = new y(paramString1, localJSONObject.toString());
      boolean bool = com.tencent.mm.kernel.g.agQ().ghe.a(paramString1, 0);
      AppMethodBeat.o(124131);
      return bool;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(124131);
    }
    return false;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(124134);
    this.callback = paramg;
    ac.i("MicroMsg.NetSceneGetBizJsApiResult", "do scene");
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
    ac.d("MicroMsg.NetSceneGetBizJsApiResult", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.y
 * JD-Core Version:    0.7.0.1
 */