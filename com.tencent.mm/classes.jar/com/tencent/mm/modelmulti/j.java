package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.protocal.aa.a;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class j
  extends com.tencent.mm.ak.q
  implements m
{
  private i callback;
  private WakerLock gll;
  private final s iMO;
  
  public j()
  {
    AppMethodBeat.i(132566);
    this.gll = new WakerLock(MMApplicationContext.getContext(), "MicroMsg.NetSceneSynCheck");
    this.gll.lock(3000L, "NetSceneSynCheck");
    this.iMO = new a();
    com.tencent.mm.kernel.g.aAi();
    if (com.tencent.mm.kernel.g.aAh() != null)
    {
      com.tencent.mm.kernel.g.aAi();
      if (com.tencent.mm.kernel.g.aAh().azQ() != null)
      {
        com.tencent.mm.kernel.g.aAi();
        Object localObject = (String)com.tencent.mm.kernel.g.aAh().azQ().get(8195, null);
        ((aa.a)this.iMO.getReqObj()).jcK = Util.decodeHexString((String)localObject);
        localObject = (aa.a)this.iMO.getReqObj();
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAf();
        ((aa.a)localObject).setUin(com.tencent.mm.kernel.a.getUin());
        ((aa.a)this.iMO.getReqObj()).netType = com.tencent.mm.protocal.a.getNetType(MMApplicationContext.getContext());
        ((aa.a)this.iMO.getReqObj()).KzG = com.tencent.mm.protocal.a.gtq();
        Log.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
        AppMethodBeat.o(132566);
        return;
      }
    }
    Log.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
    AppMethodBeat.o(132566);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(132567);
    this.callback = parami;
    int i = dispatch(paramg, this.iMO, this);
    if ((i == -1) && (this.gll.isLocking())) {
      this.gll.unLock();
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
    Log.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + paramArrayOfByte.KAs);
    if ((com.tencent.mm.kernel.g.aAc()) && (!com.tencent.mm.kernel.a.azj()))
    {
      params = ((aa.a)params.getReqObj()).hqn;
      if (Util.isNullOrNil(params)) {
        Log.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
      }
      paramArrayOfByte.hqn = params;
      ((b)com.tencent.mm.kernel.g.af(b.class)).bdS().a(paramArrayOfByte.KAs, 2, paramArrayOfByte.gtP());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.gll.unLock();
    AppMethodBeat.o(132568);
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends o
  {
    private final aa.a jcY;
    private final aa.b jcZ;
    
    public a()
    {
      AppMethodBeat.i(132565);
      this.jcY = new aa.a();
      this.jcZ = new aa.b();
      AppMethodBeat.o(132565);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.jcY;
    }
    
    public final l.e getRespObj()
    {
      return this.jcZ;
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
 * Qualified Name:     com.tencent.mm.modelmulti.j
 * JD-Core Version:    0.7.0.1
 */