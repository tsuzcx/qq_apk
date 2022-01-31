package com.tencent.mm.modelmulti;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.azf;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.s.a;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Queue;

final class o$e
  extends m
  implements o.c, k
{
  private q edR;
  com.tencent.mm.ah.f etX;
  boolean etY;
  private boolean etZ = false;
  int scene;
  int selector;
  
  public o$e(o paramo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.scene = paramInt1;
    this.selector = paramInt2;
    this.etY = paramBoolean;
  }
  
  public final boolean KA()
  {
    return false;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.etX = paramf;
    return a(parame, this.edR, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramq == null) || (paramq.getType() != 138))
    {
      com.tencent.mm.plugin.report.f.nEG.a(99L, 44L, 1L, false);
      if (paramq == null) {}
      for (paramInt1 = -2;; paramInt1 = paramq.getType())
      {
        y.e("MicroMsg.SyncService", "%s onGYNetEnd error type:%d", new Object[] { this, Integer.valueOf(paramInt1) });
        return;
      }
    }
    if (this.etZ)
    {
      y.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", new Object[] { this });
      return;
    }
    this.etZ = true;
    if (paramq == this.edR)
    {
      bool1 = true;
      o.G("Check rr failed.", bool1);
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label440;
      }
      y.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", new Object[] { this, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq });
      if ((paramInt2 != 4) || (paramInt3 != -2006)) {
        break label316;
      }
      y.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", new Object[] { this });
      com.tencent.mm.plugin.report.f.nEG.a(99L, 42L, 1L, false);
    }
    label440:
    for (boolean bool1 = false;; bool1 = true)
    {
      paramString = ((s.b)paramq.HF()).sqj;
      boolean bool2 = WXHardCoderJNI.hcReceiveMsgEnable;
      paramInt2 = WXHardCoderJNI.hcReceiveMsgDelay;
      paramInt3 = WXHardCoderJNI.hcReceiveMsgCPU;
      int i = WXHardCoderJNI.hcReceiveMsgIO;
      if (WXHardCoderJNI.hcReceiveMsgThr) {}
      for (paramInt1 = g.DS().crd();; paramInt1 = 0)
      {
        paramInt1 = WXHardCoderJNI.startPerformance(bool2, paramInt2, paramInt3, i, paramInt1, WXHardCoderJNI.hcReceiveMsgTimeout, 201, WXHardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncService");
        new o.a(this.etN, this, bool1, paramString, new o.e.1(this, paramString, paramInt1), (byte)0);
        return;
        bool1 = false;
        break;
        label316:
        com.tencent.mm.plugin.report.f.nEG.f(11098, new Object[] { Integer.valueOf(3501), this.scene + ";" + paramInt2 + ";" + paramInt3 + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + o.Pp() });
        com.tencent.mm.plugin.report.f.nEG.a(99L, 43L, 1L, false);
        this.etX.onSceneEnd(paramInt2, paramInt3, paramString, this);
        o.a(this.etN, this);
        return;
      }
    }
  }
  
  public final boolean c(Queue<o.c> paramQueue)
  {
    int i = this.scene;
    int j = this.selector;
    boolean bool1 = this.etY;
    Object localObject;
    boolean bool2;
    label80:
    boolean bool3;
    if (paramQueue == null)
    {
      localObject = "null";
      y.i("MicroMsg.SyncService", "%s begin run scene:%s selector:%s isContinue:%s List:%s", new Object[] { this, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), localObject });
      if (paramQueue == null) {
        break label266;
      }
      o.b(paramQueue);
      bool1 = false;
      bool2 = false;
      if (paramQueue.isEmpty()) {
        break label256;
      }
      localObject = (e)paramQueue.poll();
      this.selector |= ((e)localObject).selector;
      if (((e)localObject).scene != 3) {
        break label234;
      }
      bool3 = true;
    }
    for (;;)
    {
      y.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", new Object[] { this, Integer.valueOf(paramQueue.size()), localObject, Integer.valueOf(((e)localObject).scene), Integer.valueOf(((e)localObject).selector), Boolean.valueOf(((e)localObject).etY), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      bool1 = bool3;
      break label80;
      localObject = Integer.valueOf(paramQueue.size());
      break;
      label234:
      bool3 = bool1;
      if (((e)localObject).etY)
      {
        bool2 = true;
        bool3 = bool1;
      }
    }
    label256:
    if (bool1) {
      this.scene = 3;
    }
    for (;;)
    {
      label266:
      if ((g.DK()) && (!a.CW()))
      {
        g.DQ();
        if (g.DP() != null)
        {
          g.DQ();
          if (g.DP().Dz() != null) {
            break;
          }
        }
      }
      bool1 = g.DK();
      bool2 = a.CW();
      g.DQ();
      y.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", new Object[] { this, Boolean.valueOf(bool1), Boolean.valueOf(bool2), g.DP() });
      return false;
      if (bool2) {
        this.scene = 6;
      }
    }
    g.DQ();
    long l = bk.a((Long)g.DP().Dz().get(8196, null), 0L);
    if (l != 0L)
    {
      g.DQ();
      g.DP().Dz().o(8196, Long.valueOf(0L));
      this.selector = ((int)(this.selector | l));
      this.selector &= 0x5F;
    }
    if (this.scene == 3)
    {
      i = 1;
      if (this.scene != 1010) {
        break label813;
      }
      this.selector |= 0x10;
      this.scene = 7;
    }
    for (;;)
    {
      if (this.etY) {
        this.scene = 6;
      }
      this.edR = new j.a();
      paramQueue = ((s.a)this.edR.Kv()).sqi;
      paramQueue.tvv = i;
      paramQueue.sIh = this.selector;
      paramQueue.pyo = this.scene;
      g.DQ();
      localObject = bk.pm((String)g.DP().Dz().get(8195, new byte[0]));
      paramQueue.sIi = aa.I(bk.ZM((String)localObject));
      paramQueue.tvu = new qw();
      paramQueue.syI = d.dOM;
      y.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", new Object[] { this, Long.valueOf(l), Integer.valueOf(paramQueue.tvv), Integer.valueOf(paramQueue.sIh), Integer.valueOf(this.scene), paramQueue.syI });
      y.i("MicroMsg.SyncService", "%s Req synckey %s", new Object[] { this, com.tencent.mm.protocal.z.br(bk.ZM((String)localObject)) });
      o.a(this);
      g.DQ();
      if (g.DO().dJT.a(this, 0)) {
        break label871;
      }
      com.tencent.mm.plugin.report.f.nEG.f(11098, new Object[] { Integer.valueOf(3500), this.scene + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + o.Pp() });
      y.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", new Object[] { this });
      com.tencent.mm.plugin.report.f.nEG.a(99L, 41L, 1L, false);
      return false;
      i = 0;
      break;
      label813:
      if (this.scene == 1011)
      {
        this.selector |= 0x40;
        this.scene = 7;
      }
      else if (this.scene == 3)
      {
        this.selector |= 0x40000;
        this.scene = 3;
      }
    }
    label871:
    return true;
  }
  
  public final int getType()
  {
    return 138;
  }
  
  public final String toString()
  {
    return "NetSync[" + hashCode() + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.e
 * JD-Core Version:    0.7.0.1
 */