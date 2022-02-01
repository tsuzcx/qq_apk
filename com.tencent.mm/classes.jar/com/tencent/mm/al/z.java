package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class z
  extends q
  implements m
{
  private i callback;
  private Object data;
  public d rr;
  
  private z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124132);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bjv();
    ((d.a)localObject).iLO = new bjw();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizjsapiresult";
    ((d.a)localObject).funcId = 1285;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bjv)this.rr.iLK.iLR;
    ((bjv)localObject).Lpg = paramString1;
    ((bjv)localObject).EX = 1;
    ((bjv)localObject).data = paramString2;
    this.data = null;
    AppMethodBeat.o(124132);
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(124129);
    com.tencent.mm.kernel.g.aAg().hqi.a(1285, parami);
    AppMethodBeat.o(124129);
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(124130);
    com.tencent.mm.kernel.g.aAg().hqi.b(1285, parami);
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
      boolean bool = com.tencent.mm.kernel.g.aAg().hqi.a(paramString1, 0);
      AppMethodBeat.o(124131);
      return bool;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(124131);
    }
    return false;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(124134);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneGetBizJsApiResult", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124134);
    return i;
  }
  
  public final int getType()
  {
    return 1285;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
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
 * Qualified Name:     com.tencent.mm.al.z
 * JD-Core Version:    0.7.0.1
 */