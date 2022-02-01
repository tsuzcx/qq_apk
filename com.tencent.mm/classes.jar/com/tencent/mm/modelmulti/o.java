package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
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
import com.tencent.mm.storage.aq;

public final class o
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private WakerLock lro;
  private final s ouH;
  
  public o()
  {
    AppMethodBeat.i(132566);
    this.lro = new WakerLock(MMApplicationContext.getContext(), "MicroMsg.NetSceneSynCheck");
    this.lro.lock(3000L, "NetSceneSynCheck");
    this.ouH = new a();
    com.tencent.mm.kernel.h.baF();
    if (com.tencent.mm.kernel.h.baE() != null)
    {
      com.tencent.mm.kernel.h.baF();
      if (com.tencent.mm.kernel.h.baE().ban() != null)
      {
        com.tencent.mm.kernel.h.baF();
        Object localObject = (String)com.tencent.mm.kernel.h.baE().ban().d(8195, null);
        ((aa.a)this.ouH.getReqObj()).oMc = Util.decodeHexString((String)localObject);
        localObject = (aa.a)this.ouH.getReqObj();
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baC();
        ((aa.a)localObject).setUin(com.tencent.mm.kernel.b.getUin());
        localObject = (aa.a)this.ouH.getReqObj();
        MMApplicationContext.getContext();
        ((aa.a)localObject).netType = a.ibq();
        ((aa.a)this.ouH.getReqObj()).YxZ = a.iPy();
        Log.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
        AppMethodBeat.o(132566);
        return;
      }
    }
    Log.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
    AppMethodBeat.o(132566);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(132567);
    this.callback = paramh;
    int i = dispatch(paramg, this.ouH, this);
    if ((i == -1) && (this.lro.isLocking())) {
      this.lro.unLock();
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
    Log.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + paramArrayOfByte.YyK);
    if ((com.tencent.mm.kernel.h.baz()) && (!com.tencent.mm.kernel.b.aZG()))
    {
      params = ((aa.a)params.getReqObj()).mCq;
      if (Util.isNullOrNil(params)) {
        Log.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
      }
      paramArrayOfByte.mCq = params;
      ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.b.class)).bKY().a(paramArrayOfByte.YyK, 2, paramArrayOfByte.iQa());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.lro.unLock();
    AppMethodBeat.o(132568);
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends n
  {
    private final aa.a oMq;
    private final aa.b oMr;
    
    public a()
    {
      AppMethodBeat.i(132565);
      this.oMq = new aa.a();
      this.oMr = new aa.b();
      AppMethodBeat.o(132565);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.oMq;
    }
    
    public final l.e getRespObj()
    {
      return this.oMr;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o
 * JD-Core Version:    0.7.0.1
 */