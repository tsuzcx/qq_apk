package com.tencent.mm.ah;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public final class c
  implements com.tencent.mm.ai.f
{
  boolean frp;
  Set<String> frq;
  com.tencent.mm.a.f<String, c.d> frr;
  Stack<h> frs;
  private az frt;
  private az fru;
  String frv;
  com.tencent.mm.a.f<String, String> frw;
  ap frx;
  
  public c()
  {
    AppMethodBeat.i(77862);
    this.frp = false;
    this.frq = Collections.synchronizedSet(new HashSet());
    this.frr = new com.tencent.mm.memory.a.c(400);
    this.frs = new Stack();
    this.frt = null;
    this.fru = null;
    this.frv = null;
    this.frw = new com.tencent.mm.memory.a.c(200);
    this.frx = new ap(Looper.getMainLooper(), new c.3(this), false);
    g.Rc().a(123, this);
    this.frp = false;
    this.frv = r.Zn();
    AppMethodBeat.o(77862);
  }
  
  static d acQ()
  {
    AppMethodBeat.i(77870);
    if (g.RJ().QU())
    {
      d locald = o.acQ();
      AppMethodBeat.o(77870);
      return locald;
    }
    AppMethodBeat.o(77870);
    return null;
  }
  
  static h qW(String paramString)
  {
    AppMethodBeat.i(77866);
    Object localObject1 = o.adg().rj(paramString);
    if ((localObject1 != null) && (((h)localObject1).getUsername().equals(paramString)))
    {
      ab.i("MicroMsg.AvatarService", "[isFlagNeed] getSmallUrl:%s username:%s", new Object[] { ((h)localObject1).acY(), paramString });
      AppMethodBeat.o(77866);
      return localObject1;
    }
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString);
    if ((localObject1 == null) || (!((aq)localObject1).field_username.equals(paramString)))
    {
      if (localObject1 == null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.d("MicroMsg.AvatarService", "ct == null? :%s", new Object[] { Boolean.valueOf(bool), paramString });
        AppMethodBeat.o(77866);
        return null;
      }
    }
    if (((aq)localObject1).dqB == 4)
    {
      b.U(paramString, ((aq)localObject1).dqB);
      ab.d("MicroMsg.AvatarService", "ct imgFlag :%s", new Object[] { Integer.valueOf(((aq)localObject1).dqB) });
      AppMethodBeat.o(77866);
      return null;
    }
    localObject1 = new h();
    ((h)localObject1).username = paramString;
    ((h)localObject1).dqB = 3;
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arA(paramString);
    if (bo.ce((byte[])localObject2))
    {
      ab.i("MicroMsg.AvatarService", "[isFlagNeed] cmdBuf is null! username:%s", new Object[] { paramString });
      AppMethodBeat.o(77866);
      return localObject1;
    }
    try
    {
      localObject2 = b.a(paramString, (bdt)new bdt().parseFrom((byte[])localObject2));
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AvatarService", "exception:%s", new Object[] { bo.l(localException) });
      }
    }
    ab.i("MicroMsg.AvatarService", "[isFlagNeed] finally! getSmallUrl:%s getBigUrl:%s username:%s", new Object[] { ((h)localObject1).acY(), ((h)localObject1).acX(), paramString });
    AppMethodBeat.o(77866);
    return localObject1;
  }
  
  final int a(az.a parama)
  {
    AppMethodBeat.i(77868);
    com.tencent.mm.sdk.g.a.c localc = com.tencent.mm.sdk.g.d.ysn;
    com.tencent.mm.sdk.g.d.ysn.aj(new c.2(this, parama));
    AppMethodBeat.o(77868);
    return 1;
  }
  
  public final Bitmap c(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(77863);
    d locald = acQ();
    Object localObject2;
    if (locald != null) {
      if ((paramInt >= 0) && (paramInt > 5))
      {
        localObject2 = d.qY(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
        if (localObject2 != null)
        {
          ab.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
          AppMethodBeat.o(77863);
          return localObject2;
        }
        ab.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
    }
    for (Object localObject1 = d.qY(paramString);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (paramInt >= 0)
        {
          localObject2 = localObject1;
          if (paramInt > 5)
          {
            ab.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
            localObject2 = com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject1, false, paramInt);
            locald.e(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }), (Bitmap)localObject2);
          }
        }
        AppMethodBeat.o(77863);
        return localObject2;
      }
      if (paramBoolean)
      {
        AppMethodBeat.o(77863);
        return null;
      }
      ab.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", new Object[] { paramString });
      if (this.frq.contains(paramString))
      {
        AppMethodBeat.o(77863);
        return null;
      }
      this.frq.add(paramString);
      a(new c.c(this, paramString));
      AppMethodBeat.o(77863);
      return null;
      localObject2 = null;
      break;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(77867);
    while (this.frs.size() > 0) {
      this.frq.remove(this.frs.pop());
    }
    AppMethodBeat.o(77867);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(77869);
    if (paramm == null)
    {
      AppMethodBeat.o(77869);
      return;
    }
    if (paramm.getType() != 123)
    {
      AppMethodBeat.o(77869);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 12L, 1L, true);
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 45L, 1L, true);
    Object localObject;
    awg localawg;
    try
    {
      paramm = (j)paramm;
      paramString = new HashSet();
      if (paramm.fsq != null)
      {
        localObject = paramm.fsq.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localawg = (awg)((Iterator)localObject).next();
            if ((localawg == null) || (localawg.xlF == null))
            {
              ab.i("MicroMsg.AvatarService", "error p is null or username is null %s", new Object[] { localawg });
              continue;
              this.frp = false;
            }
          }
        }
      }
    }
    catch (NullPointerException paramString)
    {
      ab.e("MicroMsg.AvatarService", "[onSceneEnd] NullPointerException:%s", new Object[] { paramString });
    }
    for (;;)
    {
      if (this.frs.size() > 0) {
        this.frx.ag(0L, 0L);
      }
      AppMethodBeat.o(77869);
      return;
      String str = localawg.xlF.xJE;
      if ((localawg.woT == null) || (localawg.woT.getBuffer() == null) || (localawg.woT.getBuffer().pW == null))
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 11L, 1L, true);
        break;
      }
      paramString.add(str);
      h localh = new h();
      localh.username = str;
      localh.dqB = 3;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 43L, 1L, true);
      a(new c.e(this, localh, localawg.woT.getBuffer().pW));
      break;
      if (paramm.fsp != null)
      {
        paramm = paramm.fsp.iterator();
        while (paramm.hasNext())
        {
          localObject = (bwc)paramm.next();
          if (localObject != null)
          {
            localObject = ((bwc)localObject).xJE;
            if (!paramString.contains(localObject)) {
              this.frq.remove(localObject);
            }
          }
        }
      }
    }
  }
  
  public final void qU(String paramString)
  {
    AppMethodBeat.i(77864);
    a(new c.c(this, paramString));
    AppMethodBeat.o(77864);
  }
  
  public final void qV(String paramString)
  {
    AppMethodBeat.i(77865);
    com.tencent.mm.sdk.g.d.ysn.aj(new c.1(this, paramString));
    AppMethodBeat.o(77865);
  }
  
  public final String qX(String paramString)
  {
    AppMethodBeat.i(77871);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77871);
      return "";
    }
    try
    {
      String str1 = String.format("%s%x_%s", new Object[] { "ammURL_", Integer.valueOf(paramString.hashCode()), paramString.substring(paramString.length() - 24, paramString.length() - 4) });
      this.frw.put(str1, paramString);
      AppMethodBeat.o(77871);
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = String.format("%s%x_", new Object[] { "ammURL_", Integer.valueOf(paramString.hashCode()) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ah.c
 * JD-Core Version:    0.7.0.1
 */