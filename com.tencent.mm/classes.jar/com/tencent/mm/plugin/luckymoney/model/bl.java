package com.tencent.mm.plugin.luckymoney.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.adr;
import com.tencent.mm.autogen.a.adr.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class bl
  implements com.tencent.mm.am.h
{
  private boolean Kve;
  public bf Kvf;
  public ba Kvg;
  private aq Kvh;
  public IListener Kvi;
  
  public bl()
  {
    AppMethodBeat.i(65315);
    this.Kvi = new WearLuckyLogic.1(this, f.hfK);
    this.Kvi.alive();
    AppMethodBeat.o(65315);
  }
  
  private static void a(q paramq, long paramLong, String paramString)
  {
    AppMethodBeat.i(65318);
    adr localadr = new adr();
    localadr.ihS.action = 2;
    localadr.ihT.hCz = paramLong;
    localadr.ihT.ihV = paramq.ihV;
    localadr.ihT.ihW = paramq.KrY;
    localadr.ihT.ihX = new ArrayList();
    if (au.bwE(paramString))
    {
      paramq = paramq.Ksg.iterator();
      while (paramq.hasNext())
      {
        paramString = (af)paramq.next();
        paramString = com.tencent.mm.modelavatar.q.bFG().LF(paramString.KtD) + "=" + paramString.KtC + "=" + paramString.Kth;
        localadr.ihT.ihX.add(paramString);
      }
    }
    localadr.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(65318);
  }
  
  private static void sj(long paramLong)
  {
    AppMethodBeat.i(65317);
    adr localadr = new adr();
    localadr.ihS.action = 2;
    localadr.ihT.hCz = paramLong;
    localadr.ihT.ihV = 0L;
    localadr.ihT.ihW = "";
    localadr.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(65317);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(65316);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1581, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1685, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1585, this);
    if ((paramp instanceof bf))
    {
      paramString = (bf)paramp;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        this.Kve = false;
        sj(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      if (paramString.ihz == 4)
      {
        if (this.Kvh != null)
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(this.Kvh);
          this.Kvh = null;
        }
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(1585, this);
        this.Kvh = new aq(paramString.CAf, 11, 0, paramString.ihx, "v1.0");
        this.Kvh.talker = paramString.talker;
        this.Kvh.msgId = paramString.msgId;
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(this.Kvh, 0);
        Log.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
        AppMethodBeat.o(65316);
        return;
      }
      if ((paramString.ihA != 1) && (paramString.ihz != 5) && (paramString.ihz != 1))
      {
        if (this.Kvg != null)
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(this.Kvg);
          this.Kvg = null;
        }
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(1685, this);
        this.Kvg = new ba(paramString.msgType, paramString.channelId, paramString.CAf, paramString.ihx, ah.fXi(), z.bAO(), paramString.talker, "v1.0", paramString.KuX);
        this.Kvg.msgId = paramString.msgId;
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(this.Kvg, 0);
        Log.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
        AppMethodBeat.o(65316);
        return;
      }
      this.Kve = false;
      Log.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
      sj(paramString.msgId);
      AppMethodBeat.o(65316);
      return;
    }
    if ((paramp instanceof ba))
    {
      this.Kve = false;
      paramString = (ba)paramp;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        sj(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      paramp = paramString.KtU;
      if (paramp.ihA == 2)
      {
        a(paramp, paramString.msgId, paramString.talker);
        AppMethodBeat.o(65316);
        return;
      }
      sj(paramString.msgId);
      AppMethodBeat.o(65316);
      return;
    }
    if ((paramp instanceof aq))
    {
      this.Kve = false;
      paramString = (aq)paramp;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        sj(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      a(paramString.KtU, paramString.msgId, paramString.talker);
    }
    AppMethodBeat.o(65316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bl
 * JD-Core Version:    0.7.0.1
 */