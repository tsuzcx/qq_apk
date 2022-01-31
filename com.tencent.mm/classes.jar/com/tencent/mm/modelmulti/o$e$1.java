package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

final class o$e$1
  implements o.b
{
  o$e$1(o.e parame, bgj parambgj, int paramInt) {}
  
  public final boolean lM(int paramInt)
  {
    AppMethodBeat.i(58404);
    g.RM();
    g.RL().Ru().set(8196, Long.valueOf(this.fJN.wBX));
    boolean bool;
    if ((this.fJN.wBX & this.fJP.fHY) != 0)
    {
      bool = true;
      ab.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s StorySyncKey:%s  NetSceneMinSync.this.selecto:%s", new Object[] { this.fJP, Integer.valueOf(this.fJN.wBX), Boolean.valueOf(bool), Integer.valueOf(this.fJN.wBX & 0x100), Integer.valueOf(this.fJN.wBX & 0x80), Integer.valueOf(this.fJP.fHY) });
      Object localObject;
      if ((!bool) && ((this.fJN.wBX & 0x100) != 0))
      {
        localObject = new sf();
        ((sf)localObject).cIz.cpG = 3;
        a.ymk.l((b)localObject);
      }
      if ((!bool) && ((this.fJN.wBX & 0x200000) != 0))
      {
        localObject = new mc();
        a.ymk.l((b)localObject);
      }
      if ((!bool) && ((this.fJN.wBX & 0x80) != 0))
      {
        localObject = new sz();
        a.ymk.l((b)localObject);
      }
      if (bool)
      {
        if ((paramInt != 0) || (!this.fJP.fJL)) {
          break label340;
        }
        ab.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", new Object[] { this.fJP });
      }
    }
    for (;;)
    {
      this.fJP.fJK.onSceneEnd(0, 0, "", this.fJP);
      o.a(this.fJP.fJA, this.fJP);
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcReceiveMsgEnable, this.fJO);
      AppMethodBeat.o(58404);
      return true;
      bool = false;
      break;
      label340:
      o.a(this.fJP.fJA, this.fJP.scene, this.fJP.fHY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.e.1
 * JD-Core Version:    0.7.0.1
 */