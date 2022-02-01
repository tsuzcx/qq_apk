package com.tencent.mm.am;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
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

public final class x
  extends t.a
{
  MMHandler handler;
  private s ouH;
  h ouW;
  i ouX;
  
  public x(s params) {}
  
  public x(s params, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(132451);
    this.ouH = params;
    this.ouW = new w(params.getReqObj(), params.getType());
    this.ouX = new y(params.getRespObj(), params.getType());
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
        x localx = new x(new o(), x.this.handler);
        try
        {
          paraml.a(localx, paramInt1, paramInt2, "");
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
        int j = bj.bCE().getInt("key_auth_update_version", 0);
        int i;
        Object localObject;
        label77:
        label98:
        long l;
        if (j <= 637665332) {
          if (com.tencent.mm.protocal.f.Yxs)
          {
            i = 252;
            if (j != 0) {
              break label482;
            }
            localObject = MMApplicationContext.getContext().getSharedPreferences("ticket_prefs", g.aQe());
            if (!Util.isNullOrNil(((SharedPreferences)localObject).getString("_auth_ticket", ""))) {
              break label440;
            }
            if (!com.tencent.mm.protocal.f.Yxs) {
              break label433;
            }
            i = 763;
            Log.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth revise to autoauth");
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 50L, 1L, true);
            Log.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(d.Yxh), Integer.valueOf(637665332), Integer.valueOf(i) });
            if ((i != 252) && (i != 701)) {
              break label499;
            }
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 48L, 1L, true);
            localObject = com.tencent.mm.plugin.report.f.Ozc;
            if (!com.tencent.mm.protocal.f.Yxs) {
              break label485;
            }
            l = 115L;
            label183:
            ((com.tencent.mm.plugin.report.f)localObject).idkeyStat(148L, l, 1L, true);
            localObject = com.tencent.mm.plugin.report.f.Ozc;
            if (!com.tencent.mm.protocal.f.Yxt) {
              break label492;
            }
            l = 117L;
            label209:
            ((com.tencent.mm.plugin.report.f)localObject).idkeyStat(148L, l, 1L, true);
            if (((x.a(x.this).getType() != 702) && (x.a(x.this).getType() != 701) && (x.a(x.this).getType() != 763) && (x.a(x.this).getType() != 252)) || (((j.i)x.a(x.this).getRespObj()).mvX != 2)) {
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
          Log.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", new Object[] { Integer.valueOf(x.a(x.this).getType()), Integer.valueOf(i), Integer.valueOf(j) });
          localObject = j.e.a.YxQ.eC(i, j);
          if (localObject == null) {}
          for (localObject = null;; localObject = new x((s)localObject, x.this.handler))
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
            if (com.tencent.mm.protocal.f.Yxs)
            {
              i = 763;
              break;
            }
            i = 702;
            break;
            i = 702;
            break label77;
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 49L, 1L, true);
            Log.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth keep manual as old [%s]", new Object[] { Util.secPrint(((SharedPreferences)localObject).getString("_auth_ticket", "")) });
            break label98;
            l = 116L;
            break label183;
            l = 118L;
            break label209;
            localObject = com.tencent.mm.plugin.report.f.Ozc;
            if (com.tencent.mm.protocal.f.Yxs)
            {
              l = 111L;
              ((com.tencent.mm.plugin.report.f)localObject).idkeyStat(148L, l, 1L, true);
              localObject = com.tencent.mm.plugin.report.f.Ozc;
              if (!com.tencent.mm.protocal.f.Yxt) {
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
        Log.d("MicroMsg.RemoteReqResp", "summerauth doAutoAuthEnd type:%d, stack[%s]", new Object[] { Integer.valueOf(x.a(x.this).getType()), Util.getStack() });
        j.h localh = (j.h)x.a(x.this).getReqObj();
        j.i locali = (j.i)x.a(x.this).getRespObj();
        if (locali == null)
        {
          Log.f("MicroMsg.RemoteReqResp", "null auth.resp");
          AppMethodBeat.o(132447);
          return;
        }
        j.e.a.YxQ.a(localh, locali, paramInt1, paramInt2, paramString);
        AppMethodBeat.o(132447);
      }
    });
    AppMethodBeat.o(132458);
  }
  
  public final h bGo()
  {
    return this.ouW;
  }
  
  public final i bGp()
  {
    return this.ouX;
  }
  
  public final int bGq()
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
      i = bj.a(this.ouH);
      continue;
      i = bl.a(this.ouH);
    }
  }
  
  public final boolean bGr()
  {
    AppMethodBeat.i(236799);
    boolean bool = this.ouH.keepAlive();
    AppMethodBeat.o(236799);
    return bool;
  }
  
  public final String getCgiVerifyPrivateKey()
  {
    AppMethodBeat.i(236792);
    String str = this.ouH.getReqObj().getCgiVerifyPrivateKey();
    AppMethodBeat.o(236792);
    return str;
  }
  
  public final String getCgiVerifyPublicKey()
  {
    AppMethodBeat.i(236790);
    String str = this.ouH.getReqObj().getCgiVerifyPublicKey();
    AppMethodBeat.o(236790);
    return str;
  }
  
  public final boolean getIsLongPolling()
  {
    AppMethodBeat.i(236798);
    boolean bool = this.ouH.getIsLongPolling();
    AppMethodBeat.o(236798);
    return bool;
  }
  
  public final boolean getIsUserCmd()
  {
    AppMethodBeat.i(132452);
    boolean bool = this.ouH.getIsUserCmd();
    AppMethodBeat.o(132452);
    return bool;
  }
  
  public final int getLongPollingTimeout()
  {
    AppMethodBeat.i(236801);
    int i = this.ouH.getLongPollingTimeout();
    AppMethodBeat.o(236801);
    return i;
  }
  
  public final int getMMReqRespHash()
  {
    AppMethodBeat.i(132453);
    int i = this.ouH.hashCode();
    AppMethodBeat.o(132453);
    return i;
  }
  
  public final int getNewExtFlags()
  {
    AppMethodBeat.i(236802);
    int i = this.ouH.getNewExtFlags();
    AppMethodBeat.o(236802);
    return i;
  }
  
  public final int getOptions()
  {
    AppMethodBeat.i(132454);
    int i = this.ouH.getOptions();
    AppMethodBeat.o(132454);
    return i;
  }
  
  public final int getTimeOut()
  {
    AppMethodBeat.i(132462);
    int i = this.ouH.getTimeOut();
    AppMethodBeat.o(132462);
    return i;
  }
  
  public final byte[] getTransHeader()
  {
    AppMethodBeat.i(236803);
    byte[] arrayOfByte = this.ouH.getTransHeader();
    AppMethodBeat.o(236803);
    return arrayOfByte;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(132455);
    int i = this.ouH.getType();
    AppMethodBeat.o(132455);
    return i;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(132456);
    String str = this.ouH.getUri();
    AppMethodBeat.o(132456);
    return str;
  }
  
  public final boolean isSingleSession()
  {
    AppMethodBeat.i(132463);
    boolean bool = this.ouH.isSingleSession();
    AppMethodBeat.o(132463);
    return bool;
  }
  
  public final void setConnectionInfo(String paramString)
  {
    AppMethodBeat.i(132457);
    this.ouH.setConnectionInfo(paramString);
    AppMethodBeat.o(132457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.x
 * JD-Core Version:    0.7.0.1
 */