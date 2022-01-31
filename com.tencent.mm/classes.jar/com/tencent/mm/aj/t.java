package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class t
  extends m
  implements k
{
  private f callback;
  private Object data;
  public com.tencent.mm.ai.b rr;
  
  private t(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11447);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ahm();
    ((b.a)localObject).fsY = new ahn();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizjsapiresult";
    ((b.a)localObject).funcId = 1285;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (ahm)this.rr.fsV.fta;
    ((ahm)localObject).wOf = paramString1;
    ((ahm)localObject).vA = 1;
    ((ahm)localObject).data = paramString2;
    this.data = null;
    AppMethodBeat.o(11447);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(11444);
    g.RK().eHt.a(1285, paramf);
    AppMethodBeat.o(11444);
  }
  
  public static void b(f paramf)
  {
    AppMethodBeat.i(11445);
    g.RK().eHt.b(1285, paramf);
    AppMethodBeat.o(11445);
  }
  
  public static boolean o(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(11446);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("brand_user_name", paramString2);
      localJSONObject.put("bizchat_id", paramString3);
      paramString1 = new t(paramString1, localJSONObject.toString());
      boolean bool = g.RK().eHt.a(paramString1, 0);
      AppMethodBeat.o(11446);
      return bool;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(11446);
    }
    return false;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11449);
    this.callback = paramf;
    ab.i("MicroMsg.NetSceneGetBizJsApiResult", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11449);
    return i;
  }
  
  public final int getType()
  {
    return 1285;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11448);
    ab.d("MicroMsg.NetSceneGetBizJsApiResult", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.t
 * JD-Core Version:    0.7.0.1
 */