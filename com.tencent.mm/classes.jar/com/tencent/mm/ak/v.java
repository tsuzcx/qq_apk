package com.tencent.mm.ak;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.network.j;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r;
import com.tencent.mm.network.r.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.j.e;
import com.tencent.mm.protocal.j.e.a;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

public final class v
  extends r.a
{
  private q hRG;
  h hRV;
  i hRW;
  aq handler;
  
  public v(q paramq) {}
  
  public v(q paramq, aq paramaq)
  {
    AppMethodBeat.i(132451);
    this.hRG = paramq;
    this.hRV = new u(paramq.getReqObj(), paramq.getType());
    this.hRW = new w(paramq.getRespObj(), paramq.getType());
    this.handler = paramaq;
    AppMethodBeat.o(132451);
  }
  
  public final void a(com.tencent.mm.network.d paramd, final j paramj, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(132460);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132449);
        v localv = new v(new m(), v.this.handler);
        try
        {
          paramj.a(localv, paramInt1, paramInt2, "");
          AppMethodBeat.o(132449);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          ae.e("MicroMsg.RemoteReqResp", "exception:%s", new Object[] { bu.o(localRemoteException) });
          AppMethodBeat.o(132449);
        }
      }
    });
    AppMethodBeat.o(132460);
  }
  
  public final void a(final j paramj, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(132459);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132448);
        int j = bd.aCl().getInt("key_auth_update_version", 0);
        int i;
        Object localObject;
        label77:
        label98:
        long l;
        if (j <= 637665332) {
          if (f.FFQ)
          {
            i = 252;
            if (j != 0) {
              break label482;
            }
            localObject = ak.getContext().getSharedPreferences("ticket_prefs", g.abv());
            if (!bu.isNullOrNil(((SharedPreferences)localObject).getString("_auth_ticket", ""))) {
              break label440;
            }
            if (!f.FFQ) {
              break label433;
            }
            i = 763;
            ae.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth revise to autoauth");
            e.ywz.idkeyStat(148L, 50L, 1L, true);
            ae.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(com.tencent.mm.protocal.d.FFH), Integer.valueOf(637665332), Integer.valueOf(i) });
            if ((i != 252) && (i != 701)) {
              break label499;
            }
            e.ywz.idkeyStat(148L, 48L, 1L, true);
            localObject = e.ywz;
            if (!f.FFQ) {
              break label485;
            }
            l = 115L;
            label183:
            ((e)localObject).idkeyStat(148L, l, 1L, true);
            localObject = e.ywz;
            if (!f.FFR) {
              break label492;
            }
            l = 117L;
            label209:
            ((e)localObject).idkeyStat(148L, l, 1L, true);
            if (((v.a(v.this).getType() != 702) && (v.a(v.this).getType() != 701) && (v.a(v.this).getType() != 763) && (v.a(v.this).getType() != 252)) || (((j.i)v.a(v.this).getRespObj()).gxH != 2)) {
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
          ae.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", new Object[] { Integer.valueOf(v.a(v.this).getType()), Integer.valueOf(i), Integer.valueOf(j) });
          localObject = j.e.a.FGm.dc(i, j);
          if (localObject == null) {}
          for (localObject = null;; localObject = new v((q)localObject, v.this.handler))
          {
            try
            {
              paramj.a((r)localObject, paramInt1, paramInt2, "");
              AppMethodBeat.o(132448);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              label492:
              label499:
              ae.e("MicroMsg.RemoteReqResp", "exception:%s", new Object[] { bu.o(localRemoteException) });
              AppMethodBeat.o(132448);
              return;
            }
            i = 701;
            break;
            if (f.FFQ)
            {
              i = 763;
              break;
            }
            i = 702;
            break;
            i = 702;
            break label77;
            e.ywz.idkeyStat(148L, 49L, 1L, true);
            ae.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth keep manual as old [%s]", new Object[] { bu.aSM(((SharedPreferences)localObject).getString("_auth_ticket", "")) });
            break label98;
            l = 116L;
            break label183;
            l = 118L;
            break label209;
            localObject = e.ywz;
            if (f.FFQ)
            {
              l = 111L;
              ((e)localObject).idkeyStat(148L, l, 1L, true);
              localObject = e.ywz;
              if (!f.FFR) {
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
  
  public final void a(j paramj, final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(132458);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132447);
        ae.d("MicroMsg.RemoteReqResp", "summerauth doAutoAuthEnd type:%d, stack[%s]", new Object[] { Integer.valueOf(v.a(v.this).getType()), bu.fpN() });
        j.h localh = (j.h)v.a(v.this).getReqObj();
        j.i locali = (j.i)v.a(v.this).getRespObj();
        if (locali == null)
        {
          ae.f("MicroMsg.RemoteReqResp", "null auth.resp");
          AppMethodBeat.o(132447);
          return;
        }
        j.e.a.FGm.a(localh, locali, paramInt1, paramInt2, paramString);
        AppMethodBeat.o(132447);
      }
    });
    AppMethodBeat.o(132458);
  }
  
  public final int aFA()
  {
    AppMethodBeat.i(132461);
    int j = getType();
    int i = -1;
    ae.d("MicroMsg.RemoteReqResp", "summerauth decodeAndRetriveAccInfo type:%d", new Object[] { Integer.valueOf(j) });
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
        i = bd.a(this.hRG);
      }
    }
    Object localObject2 = this.hRG;
    Object localObject1 = (x.a)((q)localObject2).getReqObj();
    x.b localb = (x.b)((q)localObject2).getRespObj();
    ae.i("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo type:%d, stack[%s]", new Object[] { Integer.valueOf(((x.a)localObject1).getFuncId()), bu.fpN() });
    if (localb.gxH != 0) {
      ae.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(localb.gxH) });
    }
    for (;;)
    {
      i = localb.gxH;
      break;
      Object localObject3 = localb.FGY.Hqm;
      if (localObject3 != null)
      {
        j = ((czw)localObject3).FRG;
        localObject2 = ((czw)localObject3).FRq;
        byte[] arrayOfByte1 = z.a(((czw)localObject3).FRJ);
        byte[] arrayOfByte2 = z.a(((czw)localObject3).FRK);
        localObject3 = z.a(((czw)localObject3).FRr);
        int k = ((afy)localObject2).FSl.getILen();
        int m = ((afy)localObject2).Gwi;
        label276:
        byte[] arrayOfByte4;
        if (localObject3 == null)
        {
          i = -1;
          ae.d("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), bu.aSM(bu.cE((byte[])localObject3)), bu.aSM(bu.cE(arrayOfByte1)), bu.aSM(bu.cE(arrayOfByte2)) });
          byte[] arrayOfByte3 = z.a(((afy)localObject2).FSl);
          arrayOfByte4 = ((x.a)localObject1).FGk;
          localObject1 = null;
          if (bu.cF(arrayOfByte3)) {
            break label687;
          }
          k = arrayOfByte3.length;
          localObject1 = bu.aSM(bu.cE(arrayOfByte3));
          if (arrayOfByte4 != null) {
            break label673;
          }
          i = -1;
          label392:
          ae.d("MicroMsg.MMReqRespReg2", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", new Object[] { Integer.valueOf(k), localObject1, Integer.valueOf(i), bu.aSM(bu.cE(arrayOfByte4)) });
          localObject1 = new PByteArray();
          k = MMProtocalJni.computerKeyWithAllStr(((afy)localObject2).Gwi, arrayOfByte3, arrayOfByte4, (PByteArray)localObject1, 0);
          localObject1 = ((PByteArray)localObject1).value;
          if (localObject1 != null) {
            break label680;
          }
          i = -1;
          label472:
          ae.i("MicroMsg.MMReqRespReg2", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), bu.aSM(bu.cE((byte[])localObject1)) });
          label508:
          if (localObject1 == null) {
            break label698;
          }
          localObject2 = localObject1;
          label517:
          localb.FGp = ((byte[])localObject2);
          if ((j & 0x4) == 0) {
            break label778;
          }
          ae.d("MicroMsg.MMReqRespReg2", "summerauth must decode session key");
          if (bu.cF((byte[])localObject1)) {
            break label749;
          }
          localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject3, (byte[])localObject1);
          if (localObject3 != null) {
            break label706;
          }
          i = -1;
          label561:
          localObject2 = bu.cE((byte[])localObject3);
          if (localObject1 != null) {
            break label713;
          }
        }
        label673:
        label680:
        label687:
        label698:
        label706:
        label713:
        for (j = -1;; j = localObject1.length)
        {
          ae.d("MicroMsg.MMReqRespReg2", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", new Object[] { Integer.valueOf(i), localObject2, Integer.valueOf(j), bu.aSM(bu.cE((byte[])localObject1)) });
          if (bu.cF((byte[])localObject1)) {
            break label720;
          }
          ae.d("MicroMsg.MMReqRespReg2", "summerauth decode session key succ session:%s", new Object[] { bu.aSM(bu.cE((byte[])localObject1)) });
          localb.b((byte[])localObject1, arrayOfByte1, arrayOfByte2);
          localb.gxH = 1;
          break;
          i = localObject3.length;
          break label276;
          i = arrayOfByte4.length;
          break label392;
          i = localObject1.length;
          break label472;
          ae.w("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key is null!");
          break label508;
          localObject2 = new byte[0];
          break label517;
          i = localObject3.length;
          break label561;
        }
        label720:
        ae.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed ret null!");
        localb.b(new byte[0], arrayOfByte1, arrayOfByte2);
        localb.gxH = 2;
        continue;
        label749:
        ae.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed as agreedECDHKey is null!");
        localb.b(new byte[0], arrayOfByte1, arrayOfByte2);
        localb.gxH = 2;
        continue;
        label778:
        ae.d("MicroMsg.MMReqRespReg2", "summerauth not need decode session key");
        localb.b((byte[])localObject3, arrayOfByte1, arrayOfByte2);
        localb.gxH = 1;
      }
      else
      {
        ae.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo sect null and decode failed!");
        localb.b(new byte[0], new byte[0], new byte[0]);
        localb.gxH = 2;
      }
    }
  }
  
  public final h aFy()
  {
    return this.hRV;
  }
  
  public final i aFz()
  {
    return this.hRW;
  }
  
  public final boolean getIsLongPolling()
  {
    AppMethodBeat.i(193555);
    boolean bool = this.hRG.getIsLongPolling();
    AppMethodBeat.o(193555);
    return bool;
  }
  
  public final boolean getIsUserCmd()
  {
    AppMethodBeat.i(132452);
    boolean bool = this.hRG.getIsUserCmd();
    AppMethodBeat.o(132452);
    return bool;
  }
  
  public final int getLongPollingTimeout()
  {
    AppMethodBeat.i(193556);
    int i = this.hRG.getLongPollingTimeout();
    AppMethodBeat.o(193556);
    return i;
  }
  
  public final int getMMReqRespHash()
  {
    AppMethodBeat.i(132453);
    int i = this.hRG.hashCode();
    AppMethodBeat.o(132453);
    return i;
  }
  
  public final int getNewExtFlags()
  {
    AppMethodBeat.i(193557);
    int i = this.hRG.getNewExtFlags();
    AppMethodBeat.o(193557);
    return i;
  }
  
  public final int getOptions()
  {
    AppMethodBeat.i(132454);
    int i = this.hRG.getOptions();
    AppMethodBeat.o(132454);
    return i;
  }
  
  public final int getTimeOut()
  {
    AppMethodBeat.i(132462);
    int i = this.hRG.getTimeOut();
    AppMethodBeat.o(132462);
    return i;
  }
  
  public final byte[] getTransHeader()
  {
    AppMethodBeat.i(193558);
    byte[] arrayOfByte = this.hRG.getTransHeader();
    AppMethodBeat.o(193558);
    return arrayOfByte;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(132455);
    int i = this.hRG.getType();
    AppMethodBeat.o(132455);
    return i;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(132456);
    String str = this.hRG.getUri();
    AppMethodBeat.o(132456);
    return str;
  }
  
  public final boolean isSingleSession()
  {
    AppMethodBeat.i(132463);
    boolean bool = this.hRG.isSingleSession();
    AppMethodBeat.o(132463);
    return bool;
  }
  
  public final void setConnectionInfo(String paramString)
  {
    AppMethodBeat.i(132457);
    this.hRG.setConnectionInfo(paramString);
    AppMethodBeat.o(132457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.v
 * JD-Core Version:    0.7.0.1
 */