package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.o;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.a;
import com.tencent.mm.protocal.aa.a;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class j
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  private WakerLock iPs;
  private final s lCW;
  
  public j()
  {
    AppMethodBeat.i(132566);
    this.iPs = new WakerLock(MMApplicationContext.getContext(), "MicroMsg.NetSceneSynCheck");
    this.iPs.lock(3000L, "NetSceneSynCheck");
    this.lCW = new a();
    h.aHH();
    if (h.aHG() != null)
    {
      h.aHH();
      if (h.aHG().aHp() != null)
      {
        h.aHH();
        Object localObject = (String)h.aHG().aHp().b(8195, null);
        ((aa.a)this.lCW.getReqObj()).lTj = Util.decodeHexString((String)localObject);
        localObject = (aa.a)this.lCW.getReqObj();
        h.aHH();
        h.aHE();
        ((aa.a)localObject).setUin(com.tencent.mm.kernel.b.getUin());
        ((aa.a)this.lCW.getReqObj()).netType = a.getNetType(MMApplicationContext.getContext());
        ((aa.a)this.lCW.getReqObj()).RBw = a.hoC();
        Log.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
        AppMethodBeat.o(132566);
        return;
      }
    }
    Log.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
    AppMethodBeat.o(132566);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(132567);
    this.callback = parami;
    int i = dispatch(paramg, this.lCW, this);
    if ((i == -1) && (this.iPs.isLocking())) {
      this.iPs.unLock();
    }
    AppMethodBeat.o(132567);
    return i;
  }
  
  public final long getReturnTimeout()
  {
    return 240000L;
  }
  
  public final int getType()
  {
    return 39;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132568);
    paramArrayOfByte = (aa.b)params.getRespObj();
    Log.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + paramArrayOfByte.RCi);
    if ((h.aHB()) && (!com.tencent.mm.kernel.b.aGE()))
    {
      params = ((aa.a)params.getReqObj()).kci;
      if (Util.isNullOrNil(params)) {
        Log.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
      }
      paramArrayOfByte.kci = params;
      ((com.tencent.mm.plugin.zero.b.b)h.ae(com.tencent.mm.plugin.zero.b.b.class)).bnn().a(paramArrayOfByte.RCi, 2, paramArrayOfByte.hpf());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.iPs.unLock();
    AppMethodBeat.o(132568);
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends o
  {
    private final aa.a lTx;
    private final aa.b lTy;
    
    public a()
    {
      AppMethodBeat.i(132565);
      this.lTx = new aa.a();
      this.lTy = new aa.b();
      AppMethodBeat.o(132565);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.lTx;
    }
    
    public final l.e getRespObj()
    {
      return this.lTy;
    }
    
    public final int getType()
    {
      return 39;
    }
    
    public final String getUri()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.j
 * JD-Core Version:    0.7.0.1
 */