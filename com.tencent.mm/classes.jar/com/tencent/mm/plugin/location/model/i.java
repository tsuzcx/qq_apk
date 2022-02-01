package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.location.ui.impl.f;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.brw;
import com.tencent.mm.protocal.protobuf.brx;
import com.tencent.mm.protocal.protobuf.cxt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  public int dJY;
  public int errCode;
  public String errMsg;
  public int errType;
  public String hes;
  public boolean idt;
  private Runnable jkz;
  public List<f> list;
  public final d rr;
  public byte[] yFH;
  public byte[] yFI;
  public String yFJ;
  public int yFK;
  
  public i(byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, double paramDouble4, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(55694);
    this.list = new ArrayList();
    this.yFI = null;
    this.idt = false;
    this.yFJ = "";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new brw();
    ((d.a)localObject).iLO = new brx();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getpoilist";
    ((d.a)localObject).funcId = 457;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    brw localbrw = (brw)this.rr.iLK.iLR;
    if (paramArrayOfByte == null)
    {
      localObject = new SKBuiltinBuffer_t();
      localbrw.LXm = ((SKBuiltinBuffer_t)localObject);
      localbrw.LPT = paramString2;
      localbrw.KUu = paramDouble1;
      localbrw.KUt = paramDouble2;
      localbrw.Scene = paramInt1;
      localbrw.OpCode = paramInt2;
      localbrw.LZa = paramDouble4;
      localbrw.LYZ = paramDouble3;
      if (!paramBoolean) {
        break label320;
      }
    }
    label320:
    for (int i = 1;; i = 0)
    {
      localbrw.LXo = i;
      this.dJY = localbrw.OpCode;
      this.yFJ = paramString1;
      this.yFH = paramArrayOfByte;
      Log.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f isAutoQuery %s buffer ".concat(String.valueOf(paramArrayOfByte)), new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Double.valueOf(paramDouble4), Double.valueOf(paramDouble3), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(55694);
      return;
      localObject = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
      break;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(55695);
    Log.i("MicroMsg.NetSceneGetPoiList", "NetSceneGetPoiList done.");
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(55695);
    return i;
  }
  
  public final int getType()
  {
    return 457;
  }
  
  public final boolean isFirst()
  {
    return this.yFH == null;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55696);
    Log.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + "errMsg:" + paramString);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.errMsg = paramString;
    params = (brx)this.rr.iLL.iLR;
    this.list.clear();
    Log.d("MicroMsg.NetSceneGetPoiList", "url " + params.LXv + " " + params.KTg + " " + params.Url + " " + params.KZj);
    Log.d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", new Object[] { Integer.valueOf(params.LXw) });
    this.hes = params.KZj;
    this.yFK = params.LXw;
    if (params.LZc != null)
    {
      Log.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", new Object[] { Integer.valueOf(params.LZc.size()) });
      if (params.LZc.size() > 0) {
        Log.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", new Object[] { ((cxt)params.LZc.get(0)).MCE, ((cxt)params.LZc.get(0)).kdZ, ((cxt)params.LZc.get(0)).LpK, ((cxt)params.LZc.get(0)).kea });
      }
      paramArrayOfByte = params.LZc.iterator();
      while (paramArrayOfByte.hasNext())
      {
        f localf = new f((cxt)paramArrayOfByte.next(), this.hes);
        Log.d("MicroMsg.NetSceneGetPoiList", "lat %s lng %s", new Object[] { Double.valueOf(localf.cik), Double.valueOf(localf.cil) });
        this.list.add(localf);
      }
    }
    if (params.LXm != null) {
      this.yFI = z.a(params.LXm);
    }
    if (params.KWa == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.idt = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.jkz != null) {
        this.jkz.run();
      }
      AppMethodBeat.o(55696);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.i
 * JD-Core Version:    0.7.0.1
 */