package com.tencent.mm.an;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.network.l;
import com.tencent.mm.network.s;
import com.tencent.mm.network.t;
import com.tencent.mm.network.t.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.j.e;
import com.tencent.mm.protocal.j.e.a;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class y
  extends t.a
{
  MMHandler handler;
  private s lCW;
  h lDl;
  i lDm;
  
  public y(s params) {}
  
  public y(s params, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(132451);
    this.lCW = params;
    this.lDl = new x(params.getReqObj(), params.getType());
    this.lDm = new z(params.getRespObj(), params.getType());
    this.handler = paramMMHandler;
    AppMethodBeat.o(132451);
  }
  
  public final void a(com.tencent.mm.network.f paramf, final l paraml, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(132460);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132449);
        y localy = new y(new p(), y.this.handler);
        try
        {
          paraml.a(localy, paramInt1, paramInt2, "");
          AppMethodBeat.o(132449);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          Log.e("MicroMsg.RemoteReqResp", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
          AppMethodBeat.o(132449);
        }
      }
    });
    AppMethodBeat.o(132460);
  }
  
  public final void a(final l paraml, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(132459);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132448);
        int j = bi.beN().getInt("key_auth_update_version", 0);
        int i;
        Object localObject;
        label77:
        label98:
        long l;
        if (j <= 637665332) {
          if (com.tencent.mm.protocal.f.RAO)
          {
            i = 252;
            if (j != 0) {
              break label482;
            }
            localObject = MMApplicationContext.getContext().getSharedPreferences("ticket_prefs", g.avK());
            if (!Util.isNullOrNil(((SharedPreferences)localObject).getString("_auth_ticket", ""))) {
              break label440;
            }
            if (!com.tencent.mm.protocal.f.RAO) {
              break label433;
            }
            i = 763;
            Log.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth revise to autoauth");
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 50L, 1L, true);
            Log.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(d.RAD), Integer.valueOf(637665332), Integer.valueOf(i) });
            if ((i != 252) && (i != 701)) {
              break label499;
            }
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 48L, 1L, true);
            localObject = com.tencent.mm.plugin.report.f.Iyx;
            if (!com.tencent.mm.protocal.f.RAO) {
              break label485;
            }
            l = 115L;
            label183:
            ((com.tencent.mm.plugin.report.f)localObject).idkeyStat(148L, l, 1L, true);
            localObject = com.tencent.mm.plugin.report.f.Iyx;
            if (!com.tencent.mm.protocal.f.RAP) {
              break label492;
            }
            l = 117L;
            label209:
            ((com.tencent.mm.plugin.report.f)localObject).idkeyStat(148L, l, 1L, true);
            if (((y.a(y.this).getType() != 702) && (y.a(y.this).getType() != 701) && (y.a(y.this).getType() != 763) && (y.a(y.this).getType() != 252)) || (((j.i)y.a(y.this).getRespObj()).jWd != 2)) {
              break label616;
            }
          }
        }
        label433:
        label440:
        label482:
        label485:
        label616:
        for (j = 1;; j = 0)
        {
          Log.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", new Object[] { Integer.valueOf(y.a(y.this).getType()), Integer.valueOf(i), Integer.valueOf(j) });
          localObject = j.e.a.RBn.dI(i, j);
          if (localObject == null) {}
          for (localObject = null;; localObject = new y((s)localObject, y.this.handler))
          {
            try
            {
              paraml.a((t)localObject, paramInt1, paramInt2, "");
              AppMethodBeat.o(132448);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              label492:
              label499:
              Log.e("MicroMsg.RemoteReqResp", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
              AppMethodBeat.o(132448);
              return;
            }
            i = 701;
            break;
            if (com.tencent.mm.protocal.f.RAO)
            {
              i = 763;
              break;
            }
            i = 702;
            break;
            i = 702;
            break label77;
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 49L, 1L, true);
            Log.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth keep manual as old [%s]", new Object[] { Util.secPrint(((SharedPreferences)localObject).getString("_auth_ticket", "")) });
            break label98;
            l = 116L;
            break label183;
            l = 118L;
            break label209;
            localObject = com.tencent.mm.plugin.report.f.Iyx;
            if (com.tencent.mm.protocal.f.RAO)
            {
              l = 111L;
              ((com.tencent.mm.plugin.report.f)localObject).idkeyStat(148L, l, 1L, true);
              localObject = com.tencent.mm.plugin.report.f.Iyx;
              if (!com.tencent.mm.protocal.f.RAP) {
                break label561;
              }
            }
            for (l = 113L;; l = 114L)
            {
              ((com.tencent.mm.plugin.report.f)localObject).idkeyStat(148L, l, 1L, true);
              break;
              l = 112L;
              break label514;
            }
          }
        }
      }
    });
    AppMethodBeat.o(132459);
  }
  
  public final void a(l paraml, final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(132458);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132447);
        Log.d("MicroMsg.RemoteReqResp", "summerauth doAutoAuthEnd type:%d, stack[%s]", new Object[] { Integer.valueOf(y.a(y.this).getType()), Util.getStack() });
        j.h localh = (j.h)y.a(y.this).getReqObj();
        j.i locali = (j.i)y.a(y.this).getRespObj();
        if (locali == null)
        {
          Log.f("MicroMsg.RemoteReqResp", "null auth.resp");
          AppMethodBeat.o(132447);
          return;
        }
        j.e.a.RBn.a(localh, locali, paramInt1, paramInt2, paramString);
        AppMethodBeat.o(132447);
      }
    });
    AppMethodBeat.o(132458);
  }
  
  public final h biE()
  {
    return this.lDl;
  }
  
  public final i biF()
  {
    return this.lDm;
  }
  
  public final int biG()
  {
    AppMethodBeat.i(132461);
    int j = getType();
    int i = -1;
    Log.d("MicroMsg.RemoteReqResp", "summerauth decodeAndRetriveAccInfo type:%d", new Object[] { Integer.valueOf(j) });
    switch (j)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(132461);
      return i;
      i = bi.a(this.lCW);
      continue;
      i = bk.a(this.lCW);
    }
  }
  
  public final boolean biH()
  {
    AppMethodBeat.i(208113);
    boolean bool = this.lCW.keepAlive();
    AppMethodBeat.o(208113);
    return bool;
  }
  
  public final String getCgiVerifyPrivateKey()
  {
    AppMethodBeat.i(208104);
    String str = this.lCW.getReqObj().getCgiVerifyPrivateKey();
    AppMethodBeat.o(208104);
    return str;
  }
  
  public final String getCgiVerifyPublicKey()
  {
    AppMethodBeat.i(208103);
    String str = this.lCW.getReqObj().getCgiVerifyPublicKey();
    AppMethodBeat.o(208103);
    return str;
  }
  
  public final boolean getIsLongPolling()
  {
    AppMethodBeat.i(208112);
    boolean bool = this.lCW.getIsLongPolling();
    AppMethodBeat.o(208112);
    return bool;
  }
  
  public final boolean getIsUserCmd()
  {
    AppMethodBeat.i(132452);
    boolean bool = this.lCW.getIsUserCmd();
    AppMethodBeat.o(132452);
    return bool;
  }
  
  public final int getLongPollingTimeout()
  {
    AppMethodBeat.i(208115);
    int i = this.lCW.getLongPollingTimeout();
    AppMethodBeat.o(208115);
    return i;
  }
  
  public final int getMMReqRespHash()
  {
    AppMethodBeat.i(132453);
    int i = this.lCW.hashCode();
    AppMethodBeat.o(132453);
    return i;
  }
  
  public final int getNewExtFlags()
  {
    AppMethodBeat.i(208116);
    int i = this.lCW.getNewExtFlags();
    AppMethodBeat.o(208116);
    return i;
  }
  
  public final int getOptions()
  {
    AppMethodBeat.i(132454);
    int i = this.lCW.getOptions();
    AppMethodBeat.o(132454);
    return i;
  }
  
  public final int getTimeOut()
  {
    AppMethodBeat.i(132462);
    int i = this.lCW.getTimeOut();
    AppMethodBeat.o(132462);
    return i;
  }
  
  public final byte[] getTransHeader()
  {
    AppMethodBeat.i(208118);
    byte[] arrayOfByte = this.lCW.getTransHeader();
    AppMethodBeat.o(208118);
    return arrayOfByte;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(132455);
    int i = this.lCW.getType();
    AppMethodBeat.o(132455);
    return i;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(132456);
    String str = this.lCW.getUri();
    AppMethodBeat.o(132456);
    return str;
  }
  
  public final boolean isSingleSession()
  {
    AppMethodBeat.i(132463);
    boolean bool = this.lCW.isSingleSession();
    AppMethodBeat.o(132463);
    return bool;
  }
  
  public final void setConnectionInfo(String paramString)
  {
    AppMethodBeat.i(132457);
    this.lCW.setConnectionInfo(paramString);
    AppMethodBeat.o(132457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.y
 * JD-Core Version:    0.7.0.1
 */