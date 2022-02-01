package com.tencent.mm.plugin.luckymoney.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.e;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.abu;
import com.tencent.mm.f.a.abu.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class bk
  implements i
{
  private boolean ECd;
  public be ECe;
  public az ECf;
  private ap ECg;
  public IListener ECh;
  
  public bk()
  {
    AppMethodBeat.i(65315);
    this.ECh = new bk.1(this);
    EventCenter.instance.addListener(this.ECh);
    AppMethodBeat.o(65315);
  }
  
  private static void Oo(long paramLong)
  {
    AppMethodBeat.i(65317);
    abu localabu = new abu();
    localabu.gbG.action = 2;
    localabu.gbH.fxU = paramLong;
    localabu.gbH.gbJ = 0L;
    localabu.gbH.gbK = "";
    EventCenter.instance.asyncPublish(localabu, Looper.getMainLooper());
    AppMethodBeat.o(65317);
  }
  
  private static void a(q paramq, long paramLong, String paramString)
  {
    AppMethodBeat.i(65318);
    abu localabu = new abu();
    localabu.gbG.action = 2;
    localabu.gbH.fxU = paramLong;
    localabu.gbH.gbJ = paramq.gbJ;
    localabu.gbH.gbK = paramq.Ezl;
    localabu.gbH.gbL = new ArrayList();
    if (ab.Lj(paramString))
    {
      paramq = paramq.Ezu.iterator();
      while (paramq.hasNext())
      {
        paramString = (ae)paramq.next();
        paramString = com.tencent.mm.am.q.bhR().TD(paramString.EAH) + "=" + paramString.EAG + "=" + paramString.EAr;
        localabu.gbH.gbL.add(paramString);
      }
    }
    EventCenter.instance.asyncPublish(localabu, Looper.getMainLooper());
    AppMethodBeat.o(65318);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(65316);
    h.aHH();
    h.aHF().kcd.b(1581, this);
    h.aHH();
    h.aHF().kcd.b(1685, this);
    h.aHH();
    h.aHF().kcd.b(1585, this);
    if ((paramq instanceof be))
    {
      paramString = (be)paramq;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        this.ECd = false;
        Oo(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      if (paramString.gbp == 4)
      {
        if (this.ECg != null)
        {
          h.aHH();
          h.aHF().kcd.a(this.ECg);
          this.ECg = null;
        }
        h.aHH();
        h.aHF().kcd.a(1585, this);
        this.ECg = new ap(paramString.ybP, 11, 0, paramString.gbn, "v1.0");
        this.ECg.talker = paramString.talker;
        this.ECg.msgId = paramString.msgId;
        h.aHH();
        h.aHF().kcd.a(this.ECg, 0);
        Log.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
        AppMethodBeat.o(65316);
        return;
      }
      if ((paramString.gbq != 1) && (paramString.gbp != 5) && (paramString.gbp != 1))
      {
        if (this.ECf != null)
        {
          h.aHH();
          h.aHF().kcd.a(this.ECf);
          this.ECf = null;
        }
        h.aHH();
        h.aHF().kcd.a(1685, this);
        this.ECf = new az(paramString.msgType, paramString.channelId, paramString.ybP, paramString.gbn, ag.eOH(), z.bdb(), paramString.talker, "v1.0", paramString.EBW);
        this.ECf.msgId = paramString.msgId;
        h.aHH();
        h.aHF().kcd.a(this.ECf, 0);
        Log.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
        AppMethodBeat.o(65316);
        return;
      }
      this.ECd = false;
      Log.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
      Oo(paramString.msgId);
      AppMethodBeat.o(65316);
      return;
    }
    if ((paramq instanceof az))
    {
      this.ECd = false;
      paramString = (az)paramq;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Oo(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      paramq = paramString.EAX;
      if (paramq.gbq == 2)
      {
        a(paramq, paramString.msgId, paramString.talker);
        AppMethodBeat.o(65316);
        return;
      }
      Oo(paramString.msgId);
      AppMethodBeat.o(65316);
      return;
    }
    if ((paramq instanceof ap))
    {
      this.ECd = false;
      paramString = (ap)paramq;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Oo(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      a(paramString.EAX, paramString.msgId, paramString.talker);
    }
    AppMethodBeat.o(65316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bk
 * JD-Core Version:    0.7.0.1
 */