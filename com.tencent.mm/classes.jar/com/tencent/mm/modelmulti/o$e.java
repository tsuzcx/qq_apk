package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.protocal.t.a;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.Queue;

final class o$e
  extends m
  implements o.c, k
{
  int fHY;
  f fJK;
  boolean fJL;
  private boolean fJM = false;
  private q ftU;
  int scene;
  
  public o$e(o paramo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.scene = paramInt1;
    this.fHY = paramInt2;
    this.fJL = paramBoolean;
  }
  
  public final boolean c(Queue<o.c> paramQueue)
  {
    AppMethodBeat.i(58405);
    int i = this.scene;
    int j = this.fHY;
    boolean bool1 = this.fJL;
    Object localObject;
    boolean bool2;
    label85:
    boolean bool3;
    if (paramQueue == null)
    {
      localObject = "null";
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SyncService", "%s begin run scene:%s selector:%s isContinue:%s List:%s", new Object[] { this, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), localObject });
      if (paramQueue == null) {
        break label271;
      }
      o.b(paramQueue);
      bool1 = false;
      bool2 = false;
      if (paramQueue.isEmpty()) {
        break label261;
      }
      localObject = (e)paramQueue.poll();
      this.fHY |= ((e)localObject).fHY;
      if (((e)localObject).scene != 3) {
        break label239;
      }
      bool3 = true;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", new Object[] { this, Integer.valueOf(paramQueue.size()), localObject, Integer.valueOf(((e)localObject).scene), Integer.valueOf(((e)localObject).fHY), Boolean.valueOf(((e)localObject).fJL), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      bool1 = bool3;
      break label85;
      localObject = Integer.valueOf(paramQueue.size());
      break;
      label239:
      bool3 = bool1;
      if (((e)localObject).fJL)
      {
        bool2 = true;
        bool3 = bool1;
      }
    }
    label261:
    if (bool1) {
      this.scene = 3;
    }
    for (;;)
    {
      label271:
      if ((g.RG()) && (!a.QP()))
      {
        g.RM();
        if (g.RL() != null)
        {
          g.RM();
          if (g.RL().Ru() != null) {
            break;
          }
        }
      }
      bool1 = g.RG();
      bool2 = a.QP();
      g.RM();
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", new Object[] { this, Boolean.valueOf(bool1), Boolean.valueOf(bool2), g.RL() });
      AppMethodBeat.o(58405);
      return false;
      if (bool2) {
        this.scene = 6;
      }
    }
    g.RM();
    long l = bo.a((Long)g.RL().Ru().get(8196, null), 0L);
    if (l != 0L)
    {
      g.RM();
      g.RL().Ru().set(8196, Long.valueOf(0L));
      this.fHY = ((int)(this.fHY | l));
      this.fHY &= 0x5F;
    }
    if (this.scene == 3)
    {
      i = 1;
      if (this.scene != 1010) {
        break label824;
      }
      this.fHY |= 0x10;
      this.scene = 7;
    }
    for (;;)
    {
      if (this.fJL) {
        this.scene = 6;
      }
      this.ftU = new j.a();
      paramQueue = ((t.a)this.ftU.getReqObj()).wiM;
      paramQueue.xvG = i;
      paramQueue.wFQ = this.fHY;
      paramQueue.Scene = this.scene;
      g.RM();
      localObject = bo.nullAsNil((String)g.RL().Ru().get(8195, ""));
      paramQueue.wFR = aa.ac(bo.apQ((String)localObject));
      paramQueue.xvF = new ue();
      paramQueue.wsq = d.eQs;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", new Object[] { this, Long.valueOf(l), Integer.valueOf(paramQueue.xvG), Integer.valueOf(paramQueue.wFQ), Integer.valueOf(this.scene), paramQueue.wsq });
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SyncService", "%s Req synckey %s", new Object[] { this, com.tencent.mm.protocal.ab.bS(bo.apQ((String)localObject)) });
      o.a(this);
      g.RM();
      if (g.RK().eHt.a(this, 0)) {
        break label882;
      }
      com.tencent.mm.plugin.report.e.qrI.e(11098, new Object[] { Integer.valueOf(3500), this.scene + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + o.air() });
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", new Object[] { this });
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(99L, 41L, 1L, false);
      AppMethodBeat.o(58405);
      return false;
      i = 0;
      break;
      label824:
      if (this.scene == 1011)
      {
        this.fHY |= 0x40;
        this.scene = 7;
      }
      else if (this.scene == 3)
      {
        this.fHY |= 0x40000;
        this.scene = 3;
      }
    }
    label882:
    AppMethodBeat.o(58405);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(58407);
    this.fJK = paramf;
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(58407);
    return i;
  }
  
  public final int getType()
  {
    return 138;
  }
  
  public final boolean needCheckCallback()
  {
    return false;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58408);
    if ((paramq == null) || (paramq.getType() != 138))
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(99L, 44L, 1L, false);
      if (paramq == null) {}
      for (paramInt1 = -2;; paramInt1 = paramq.getType())
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SyncService", "%s onGYNetEnd error type:%d", new Object[] { this, Integer.valueOf(paramInt1) });
        AppMethodBeat.o(58408);
        return;
      }
    }
    if (this.fJM)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", new Object[] { this });
      AppMethodBeat.o(58408);
      return;
    }
    this.fJM = true;
    if (paramq == this.ftU)
    {
      bool1 = true;
      o.K("Check rr failed.", bool1);
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label475;
      }
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", new Object[] { this, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq });
      if ((paramInt2 != 4) || (paramInt3 != -2006)) {
        break label345;
      }
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", new Object[] { this });
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(99L, 42L, 1L, false);
    }
    label345:
    label475:
    for (boolean bool1 = false;; bool1 = true)
    {
      paramString = ((t.b)paramq.getRespObj()).wiN;
      boolean bool2 = WXHardCoderJNI.hcReceiveMsgEnable;
      paramInt2 = WXHardCoderJNI.hcReceiveMsgDelay;
      paramInt3 = WXHardCoderJNI.hcReceiveMsgCPU;
      int i = WXHardCoderJNI.hcReceiveMsgIO;
      if (WXHardCoderJNI.hcReceiveMsgThr) {}
      for (paramInt1 = g.RO().dtc();; paramInt1 = 0)
      {
        paramInt1 = WXHardCoderJNI.startPerformance(bool2, paramInt2, paramInt3, i, paramInt1, WXHardCoderJNI.hcReceiveMsgTimeout, 201, WXHardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncService");
        new o.a(this.fJA, this, bool1, paramString, new o.e.1(this, paramString, paramInt1), (byte)0);
        AppMethodBeat.o(58408);
        return;
        bool1 = false;
        break;
        com.tencent.mm.plugin.report.e.qrI.e(11098, new Object[] { Integer.valueOf(3501), this.scene + ";" + paramInt2 + ";" + paramInt3 + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + o.air() });
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(99L, 43L, 1L, false);
        this.fJK.onSceneEnd(paramInt2, paramInt3, paramString, this);
        o.a(this.fJA, this);
        AppMethodBeat.o(58408);
        return;
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58406);
    String str = "NetSync[" + hashCode() + "]";
    AppMethodBeat.o(58406);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.e
 * JD-Core Version:    0.7.0.1
 */