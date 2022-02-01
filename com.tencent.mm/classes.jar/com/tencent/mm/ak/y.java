package com.tencent.mm.ak;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.l;
import com.tencent.mm.network.s;
import com.tencent.mm.network.t;
import com.tencent.mm.network.t.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.j.e;
import com.tencent.mm.protocal.j.e.a;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.ctp;
import com.tencent.mm.protocal.protobuf.dta;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class y
  extends t.a
{
  MMHandler handler;
  private s iMO;
  h iNd;
  i iNe;
  
  public y(s params) {}
  
  public y(s params, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(132451);
    this.iMO = params;
    this.iNd = new x(params.getReqObj(), params.getType());
    this.iNe = new z(params.getRespObj(), params.getType());
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
        int j = bh.aVK().getInt("key_auth_update_version", 0);
        int i;
        Object localObject;
        label77:
        label98:
        long l;
        if (j <= 637665332) {
          if (com.tencent.mm.protocal.f.KyZ)
          {
            i = 252;
            if (j != 0) {
              break label482;
            }
            localObject = MMApplicationContext.getContext().getSharedPreferences("ticket_prefs", g.aps());
            if (!Util.isNullOrNil(((SharedPreferences)localObject).getString("_auth_ticket", ""))) {
              break label440;
            }
            if (!com.tencent.mm.protocal.f.KyZ) {
              break label433;
            }
            i = 763;
            Log.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth revise to autoauth");
            e.Cxv.idkeyStat(148L, 50L, 1L, true);
            Log.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(d.KyO), Integer.valueOf(637665332), Integer.valueOf(i) });
            if ((i != 252) && (i != 701)) {
              break label499;
            }
            e.Cxv.idkeyStat(148L, 48L, 1L, true);
            localObject = e.Cxv;
            if (!com.tencent.mm.protocal.f.KyZ) {
              break label485;
            }
            l = 115L;
            label183:
            ((e)localObject).idkeyStat(148L, l, 1L, true);
            localObject = e.Cxv;
            if (!com.tencent.mm.protocal.f.Kza) {
              break label492;
            }
            l = 117L;
            label209:
            ((e)localObject).idkeyStat(148L, l, 1L, true);
            if (((y.a(y.this).getType() != 702) && (y.a(y.this).getType() != 701) && (y.a(y.this).getType() != 763) && (y.a(y.this).getType() != 252)) || (((j.i)y.a(y.this).getRespObj()).hku != 2)) {
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
          localObject = j.e.a.Kzx.dm(i, j);
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
            if (com.tencent.mm.protocal.f.KyZ)
            {
              i = 763;
              break;
            }
            i = 702;
            break;
            i = 702;
            break label77;
            e.Cxv.idkeyStat(148L, 49L, 1L, true);
            Log.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth keep manual as old [%s]", new Object[] { Util.secPrint(((SharedPreferences)localObject).getString("_auth_ticket", "")) });
            break label98;
            l = 116L;
            break label183;
            l = 118L;
            break label209;
            localObject = e.Cxv;
            if (com.tencent.mm.protocal.f.KyZ)
            {
              l = 111L;
              ((e)localObject).idkeyStat(148L, l, 1L, true);
              localObject = e.Cxv;
              if (!com.tencent.mm.protocal.f.Kza) {
                break label561;
              }
            }
            for (l = 113L;; l = 114L)
            {
              ((e)localObject).idkeyStat(148L, l, 1L, true);
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
        j.e.a.Kzx.a(localh, locali, paramInt1, paramInt2, paramString);
        AppMethodBeat.o(132447);
      }
    });
    AppMethodBeat.o(132458);
  }
  
  public final h aZo()
  {
    return this.iNd;
  }
  
  public final i aZp()
  {
    return this.iNe;
  }
  
  public final int aZq()
  {
    AppMethodBeat.i(132461);
    int j = getType();
    int i = -1;
    Log.d("MicroMsg.RemoteReqResp", "summerauth decodeAndRetriveAccInfo type:%d", new Object[] { Integer.valueOf(j) });
    switch (j)
    {
    default: 
    case 252: 
    case 701: 
    case 702: 
    case 763: 
      for (;;)
      {
        AppMethodBeat.o(132461);
        return i;
        i = bh.a(this.iMO);
      }
    }
    Object localObject2 = this.iMO;
    Object localObject1 = (x.a)((s)localObject2).getReqObj();
    x.b localb = (x.b)((s)localObject2).getRespObj();
    Log.i("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo type:%d, stack[%s]", new Object[] { Integer.valueOf(((x.a)localObject1).getFuncId()), Util.getStack() });
    if (localb.hku != 0) {
      Log.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(localb.hku) });
    }
    for (;;)
    {
      i = localb.hku;
      break;
      Object localObject3 = localb.KAj.MyS;
      if (localObject3 != null)
      {
        j = ((dta)localObject3).KLn;
        localObject2 = ((dta)localObject3).KKX;
        byte[] arrayOfByte1 = com.tencent.mm.platformtools.z.a(((dta)localObject3).KLq);
        byte[] arrayOfByte2 = com.tencent.mm.platformtools.z.a(((dta)localObject3).KLr);
        localObject3 = com.tencent.mm.platformtools.z.a(((dta)localObject3).KKY);
        int k = ((aif)localObject2).KLU.getILen();
        int m = ((aif)localObject2).LrO;
        label276:
        byte[] arrayOfByte4;
        if (localObject3 == null)
        {
          i = -1;
          Log.d("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Util.secPrint(Util.dumpHex((byte[])localObject3)), Util.secPrint(Util.dumpHex(arrayOfByte1)), Util.secPrint(Util.dumpHex(arrayOfByte2)) });
          byte[] arrayOfByte3 = com.tencent.mm.platformtools.z.a(((aif)localObject2).KLU);
          arrayOfByte4 = ((x.a)localObject1).Kzv;
          localObject1 = null;
          if (Util.isNullOrNil(arrayOfByte3)) {
            break label688;
          }
          k = arrayOfByte3.length;
          localObject1 = Util.secPrint(Util.dumpHex(arrayOfByte3));
          if (arrayOfByte4 != null) {
            break label674;
          }
          i = -1;
          label392:
          Log.d("MicroMsg.MMReqRespReg2", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", new Object[] { Integer.valueOf(k), localObject1, Integer.valueOf(i), Util.secPrint(Util.dumpHex(arrayOfByte4)) });
          localObject1 = new PByteArray();
          k = MMProtocalJni.computerKeyWithAllStr(((aif)localObject2).LrO, arrayOfByte3, arrayOfByte4, (PByteArray)localObject1, 0);
          localObject1 = ((PByteArray)localObject1).value;
          if (localObject1 != null) {
            break label681;
          }
          i = -1;
          label472:
          Log.i("MicroMsg.MMReqRespReg2", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Util.secPrint(Util.dumpHex((byte[])localObject1)) });
          label508:
          if (localObject1 == null) {
            break label699;
          }
          localObject2 = localObject1;
          label517:
          localb.KzA = ((byte[])localObject2);
          if ((j & 0x4) == 0) {
            break label779;
          }
          Log.d("MicroMsg.MMReqRespReg2", "summerauth must decode session key");
          if (Util.isNullOrNil((byte[])localObject1)) {
            break label750;
          }
          localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject3, (byte[])localObject1);
          if (localObject3 != null) {
            break label707;
          }
          i = -1;
          label561:
          localObject2 = Util.dumpHex((byte[])localObject3);
          if (localObject1 != null) {
            break label714;
          }
        }
        label674:
        label681:
        label688:
        label699:
        label707:
        label714:
        for (j = -1;; j = localObject1.length)
        {
          Log.d("MicroMsg.MMReqRespReg2", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", new Object[] { Integer.valueOf(i), localObject2, Integer.valueOf(j), Util.secPrint(Util.dumpHex((byte[])localObject1)) });
          if (Util.isNullOrNil((byte[])localObject1)) {
            break label721;
          }
          Log.d("MicroMsg.MMReqRespReg2", "summerauth decode session key succ session:%s", new Object[] { Util.secPrint(Util.dumpHex((byte[])localObject1)) });
          localb.b((byte[])localObject1, arrayOfByte1, arrayOfByte2);
          localb.hku = 1;
          break;
          i = localObject3.length;
          break label276;
          i = arrayOfByte4.length;
          break label392;
          i = localObject1.length;
          break label472;
          Log.w("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key is null!");
          break label508;
          localObject2 = new byte[0];
          break label517;
          i = localObject3.length;
          break label561;
        }
        label721:
        Log.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed ret null!");
        localb.b(new byte[0], arrayOfByte1, arrayOfByte2);
        localb.hku = 2;
        continue;
        label750:
        Log.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed as agreedECDHKey is null!");
        localb.b(new byte[0], arrayOfByte1, arrayOfByte2);
        localb.hku = 2;
        continue;
        label779:
        Log.d("MicroMsg.MMReqRespReg2", "summerauth not need decode session key");
        localb.b((byte[])localObject3, arrayOfByte1, arrayOfByte2);
        localb.hku = 1;
      }
      else
      {
        Log.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo sect null and decode failed!");
        localb.b(new byte[0], new byte[0], new byte[0]);
        localb.hku = 2;
      }
    }
  }
  
  public final boolean aZr()
  {
    AppMethodBeat.i(197070);
    boolean bool = this.iMO.keepAlive();
    AppMethodBeat.o(197070);
    return bool;
  }
  
  public final String getCgiVerifyPrivateKey()
  {
    AppMethodBeat.i(197068);
    String str = this.iMO.getReqObj().getCgiVerifyPrivateKey();
    AppMethodBeat.o(197068);
    return str;
  }
  
  public final String getCgiVerifyPublicKey()
  {
    AppMethodBeat.i(197067);
    String str = this.iMO.getReqObj().getCgiVerifyPublicKey();
    AppMethodBeat.o(197067);
    return str;
  }
  
  public final boolean getIsLongPolling()
  {
    AppMethodBeat.i(197069);
    boolean bool = this.iMO.getIsLongPolling();
    AppMethodBeat.o(197069);
    return bool;
  }
  
  public final boolean getIsUserCmd()
  {
    AppMethodBeat.i(132452);
    boolean bool = this.iMO.getIsUserCmd();
    AppMethodBeat.o(132452);
    return bool;
  }
  
  public final int getLongPollingTimeout()
  {
    AppMethodBeat.i(197071);
    int i = this.iMO.getLongPollingTimeout();
    AppMethodBeat.o(197071);
    return i;
  }
  
  public final int getMMReqRespHash()
  {
    AppMethodBeat.i(132453);
    int i = this.iMO.hashCode();
    AppMethodBeat.o(132453);
    return i;
  }
  
  public final int getNewExtFlags()
  {
    AppMethodBeat.i(197072);
    int i = this.iMO.getNewExtFlags();
    AppMethodBeat.o(197072);
    return i;
  }
  
  public final int getOptions()
  {
    AppMethodBeat.i(132454);
    int i = this.iMO.getOptions();
    AppMethodBeat.o(132454);
    return i;
  }
  
  public final int getTimeOut()
  {
    AppMethodBeat.i(132462);
    int i = this.iMO.getTimeOut();
    AppMethodBeat.o(132462);
    return i;
  }
  
  public final byte[] getTransHeader()
  {
    AppMethodBeat.i(197073);
    byte[] arrayOfByte = this.iMO.getTransHeader();
    AppMethodBeat.o(197073);
    return arrayOfByte;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(132455);
    int i = this.iMO.getType();
    AppMethodBeat.o(132455);
    return i;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(132456);
    String str = this.iMO.getUri();
    AppMethodBeat.o(132456);
    return str;
  }
  
  public final boolean isSingleSession()
  {
    AppMethodBeat.i(132463);
    boolean bool = this.iMO.isSingleSession();
    AppMethodBeat.o(132463);
    return bool;
  }
  
  public final void setConnectionInfo(String paramString)
  {
    AppMethodBeat.i(132457);
    this.iMO.setConnectionInfo(paramString);
    AppMethodBeat.o(132457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.y
 * JD-Core Version:    0.7.0.1
 */