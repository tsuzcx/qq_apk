package com.tencent.mm.plugin.luckymoney.model;

import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.aan;
import com.tencent.mm.g.a.aan.a;
import com.tencent.mm.g.a.aan.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class bj
  implements com.tencent.mm.ak.i
{
  boolean yXX;
  public bd yXY;
  public ay yXZ;
  private ao yYa;
  public IListener yYb;
  
  public bj()
  {
    AppMethodBeat.i(65315);
    this.yYb = new IListener()
    {
      private boolean a(aan paramAnonymousaan)
      {
        AppMethodBeat.i(65313);
        if ((paramAnonymousaan instanceof aan)) {
          switch (paramAnonymousaan.ehq.action)
          {
          }
        }
        label270:
        for (;;)
        {
          AppMethodBeat.o(65313);
          return false;
          bj localbj = bj.this;
          long l = paramAnonymousaan.ehq.dFm;
          if (!localbj.yXX)
          {
            localbj.yXX = true;
            ca localca = ((l)g.af(l.class)).eiy().Hb(l);
            paramAnonymousaan = localca.field_content;
            if (paramAnonymousaan != null) {}
            for (paramAnonymousaan = k.b.aD(paramAnonymousaan, localca.field_reserved);; paramAnonymousaan = null)
            {
              if (paramAnonymousaan == null) {
                break label270;
              }
              paramAnonymousaan = Util.nullAsNil(paramAnonymousaan.iyr);
              Uri localUri = Uri.parse(paramAnonymousaan);
              String str = localUri.getQueryParameter("sendid");
              int i = Util.getInt(localUri.getQueryParameter("channelid"), 1);
              if (localbj.yXY != null)
              {
                g.aAi();
                g.aAg().hqi.a(localbj.yXY);
                localbj.yXY = null;
              }
              g.aAi();
              g.aAg().hqi.a(1581, localbj);
              localbj.yXY = new bd(i, str, paramAnonymousaan, 3, "v1.0", "");
              localbj.yXY.talker = localca.field_talker;
              localbj.yXY.msgId = l;
              g.aAi();
              g.aAg().hqi.a(localbj.yXY, 0);
              break;
            }
          }
        }
      }
    };
    EventCenter.instance.addListener(this.yYb);
    AppMethodBeat.o(65315);
  }
  
  private static void GZ(long paramLong)
  {
    AppMethodBeat.i(65317);
    aan localaan = new aan();
    localaan.ehq.action = 2;
    localaan.ehr.dFm = paramLong;
    localaan.ehr.eht = 0L;
    localaan.ehr.ehu = "";
    EventCenter.instance.asyncPublish(localaan, Looper.getMainLooper());
    AppMethodBeat.o(65317);
  }
  
  private static void a(q paramq, long paramLong, String paramString)
  {
    AppMethodBeat.i(65318);
    aan localaan = new aan();
    localaan.ehq.action = 2;
    localaan.ehr.dFm = paramLong;
    localaan.ehr.eht = paramq.eht;
    localaan.ehr.ehu = paramq.yVo;
    localaan.ehr.ehv = new ArrayList();
    if (ab.Eq(paramString))
    {
      paramq = paramq.yVw.iterator();
      while (paramq.hasNext())
      {
        paramString = (ad)paramq.next();
        paramString = p.aYD().Mj(paramString.yWE) + "=" + paramString.yWD + "=" + paramString.yWo;
        localaan.ehr.ehv.add(paramString);
      }
    }
    EventCenter.instance.asyncPublish(localaan, Looper.getMainLooper());
    AppMethodBeat.o(65318);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(65316);
    g.aAi();
    g.aAg().hqi.b(1581, this);
    g.aAi();
    g.aAg().hqi.b(1685, this);
    g.aAi();
    g.aAg().hqi.b(1585, this);
    if ((paramq instanceof bd))
    {
      paramString = (bd)paramq;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        this.yXX = false;
        GZ(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      if (paramString.egZ == 4)
      {
        if (this.yYa != null)
        {
          g.aAi();
          g.aAg().hqi.a(this.yYa);
          this.yYa = null;
        }
        g.aAi();
        g.aAg().hqi.a(1585, this);
        this.yYa = new ao(paramString.yQE, 11, 0, paramString.egX, "v1.0");
        this.yYa.talker = paramString.talker;
        this.yYa.msgId = paramString.msgId;
        g.aAi();
        g.aAg().hqi.a(this.yYa, 0);
        Log.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
        AppMethodBeat.o(65316);
        return;
      }
      if ((paramString.eha != 1) && (paramString.egZ != 5) && (paramString.egZ != 1))
      {
        if (this.yXZ != null)
        {
          g.aAi();
          g.aAg().hqi.a(this.yXZ);
          this.yXZ = null;
        }
        g.aAi();
        g.aAg().hqi.a(1685, this);
        this.yXZ = new ay(paramString.msgType, paramString.channelId, paramString.yQE, paramString.egX, af.efj(), z.aUa(), paramString.talker, "v1.0", paramString.yXR);
        this.yXZ.msgId = paramString.msgId;
        g.aAi();
        g.aAg().hqi.a(this.yXZ, 0);
        Log.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
        AppMethodBeat.o(65316);
        return;
      }
      this.yXX = false;
      Log.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
      GZ(paramString.msgId);
      AppMethodBeat.o(65316);
      return;
    }
    if ((paramq instanceof ay))
    {
      this.yXX = false;
      paramString = (ay)paramq;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        GZ(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      paramq = paramString.yWT;
      if (paramq.eha == 2)
      {
        a(paramq, paramString.msgId, paramString.talker);
        AppMethodBeat.o(65316);
        return;
      }
      GZ(paramString.msgId);
      AppMethodBeat.o(65316);
      return;
    }
    if ((paramq instanceof ao))
    {
      this.yXX = false;
      paramString = (ao)paramq;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        GZ(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      a(paramString.yWT, paramString.msgId, paramString.talker);
    }
    AppMethodBeat.o(65316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bj
 * JD-Core Version:    0.7.0.1
 */