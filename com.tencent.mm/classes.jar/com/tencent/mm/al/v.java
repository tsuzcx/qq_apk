package com.tencent.mm.al;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bb;
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
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.czc;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class v
  extends r.a
{
  private q hON;
  h hPc;
  i hPd;
  ap handler;
  
  public v(q paramq) {}
  
  public v(q paramq, ap paramap)
  {
    AppMethodBeat.i(132451);
    this.hON = paramq;
    this.hPc = new u(paramq.getReqObj(), paramq.getType());
    this.hPd = new w(paramq.getRespObj(), paramq.getType());
    this.handler = paramap;
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
          ad.e("MicroMsg.RemoteReqResp", "exception:%s", new Object[] { bt.n(localRemoteException) });
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
        int j = bb.aBV().getInt("key_auth_update_version", 0);
        int i;
        Object localObject;
        label77:
        label98:
        long l;
        if (j <= 637665332) {
          if (f.Fns)
          {
            i = 252;
            if (j != 0) {
              break label482;
            }
            localObject = aj.getContext().getSharedPreferences("ticket_prefs", g.abm());
            if (!bt.isNullOrNil(((SharedPreferences)localObject).getString("_auth_ticket", ""))) {
              break label440;
            }
            if (!f.Fns) {
              break label433;
            }
            i = 763;
            ad.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth revise to autoauth");
            e.ygI.idkeyStat(148L, 50L, 1L, true);
            ad.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(com.tencent.mm.protocal.d.Fnj), Integer.valueOf(637665332), Integer.valueOf(i) });
            if ((i != 252) && (i != 701)) {
              break label499;
            }
            e.ygI.idkeyStat(148L, 48L, 1L, true);
            localObject = e.ygI;
            if (!f.Fns) {
              break label485;
            }
            l = 115L;
            label183:
            ((e)localObject).idkeyStat(148L, l, 1L, true);
            localObject = e.ygI;
            if (!f.Fnt) {
              break label492;
            }
            l = 117L;
            label209:
            ((e)localObject).idkeyStat(148L, l, 1L, true);
            if (((v.a(v.this).getType() != 702) && (v.a(v.this).getType() != 701) && (v.a(v.this).getType() != 763) && (v.a(v.this).getType() != 252)) || (((j.i)v.a(v.this).getRespObj()).gva != 2)) {
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
          ad.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", new Object[] { Integer.valueOf(v.a(v.this).getType()), Integer.valueOf(i), Integer.valueOf(j) });
          localObject = j.e.a.FnO.dc(i, j);
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
              ad.e("MicroMsg.RemoteReqResp", "exception:%s", new Object[] { bt.n(localRemoteException) });
              AppMethodBeat.o(132448);
              return;
            }
            i = 701;
            break;
            if (f.Fns)
            {
              i = 763;
              break;
            }
            i = 702;
            break;
            i = 702;
            break label77;
            e.ygI.idkeyStat(148L, 49L, 1L, true);
            ad.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth keep manual as old [%s]", new Object[] { bt.aRp(((SharedPreferences)localObject).getString("_auth_ticket", "")) });
            break label98;
            l = 116L;
            break label183;
            l = 118L;
            break label209;
            localObject = e.ygI;
            if (f.Fns)
            {
              l = 111L;
              ((e)localObject).idkeyStat(148L, l, 1L, true);
              localObject = e.ygI;
              if (!f.Fnt) {
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
        ad.d("MicroMsg.RemoteReqResp", "summerauth doAutoAuthEnd type:%d, stack[%s]", new Object[] { Integer.valueOf(v.a(v.this).getType()), bt.flS() });
        j.h localh = (j.h)v.a(v.this).getReqObj();
        j.i locali = (j.i)v.a(v.this).getRespObj();
        if (locali == null)
        {
          ad.f("MicroMsg.RemoteReqResp", "null auth.resp");
          AppMethodBeat.o(132447);
          return;
        }
        j.e.a.FnO.a(localh, locali, paramInt1, paramInt2, paramString);
        AppMethodBeat.o(132447);
      }
    });
    AppMethodBeat.o(132458);
  }
  
  public final h aFi()
  {
    return this.hPc;
  }
  
  public final i aFj()
  {
    return this.hPd;
  }
  
  public final int aFk()
  {
    AppMethodBeat.i(132461);
    int j = getType();
    int i = -1;
    ad.d("MicroMsg.RemoteReqResp", "summerauth decodeAndRetriveAccInfo type:%d", new Object[] { Integer.valueOf(j) });
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
        i = bb.a(this.hON);
      }
    }
    Object localObject2 = this.hON;
    Object localObject1 = (x.a)((q)localObject2).getReqObj();
    x.b localb = (x.b)((q)localObject2).getRespObj();
    ad.i("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo type:%d, stack[%s]", new Object[] { Integer.valueOf(((x.a)localObject1).getFuncId()), bt.flS() });
    if (localb.gva != 0) {
      ad.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(localb.gva) });
    }
    for (;;)
    {
      i = localb.gva;
      break;
      Object localObject3 = localb.FoA.GWM;
      if (localObject3 != null)
      {
        j = ((czc)localObject3).Fzi;
        localObject2 = ((czc)localObject3).FyS;
        byte[] arrayOfByte1 = z.a(((czc)localObject3).Fzl);
        byte[] arrayOfByte2 = z.a(((czc)localObject3).Fzm);
        localObject3 = z.a(((czc)localObject3).FyT);
        int k = ((afp)localObject2).FzN.getILen();
        int m = ((afp)localObject2).GdB;
        label276:
        byte[] arrayOfByte4;
        if (localObject3 == null)
        {
          i = -1;
          ad.d("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), bt.aRp(bt.cB((byte[])localObject3)), bt.aRp(bt.cB(arrayOfByte1)), bt.aRp(bt.cB(arrayOfByte2)) });
          byte[] arrayOfByte3 = z.a(((afp)localObject2).FzN);
          arrayOfByte4 = ((x.a)localObject1).FnM;
          localObject1 = null;
          if (bt.cC(arrayOfByte3)) {
            break label688;
          }
          k = arrayOfByte3.length;
          localObject1 = bt.aRp(bt.cB(arrayOfByte3));
          if (arrayOfByte4 != null) {
            break label674;
          }
          i = -1;
          label392:
          ad.d("MicroMsg.MMReqRespReg2", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", new Object[] { Integer.valueOf(k), localObject1, Integer.valueOf(i), bt.aRp(bt.cB(arrayOfByte4)) });
          localObject1 = new PByteArray();
          k = MMProtocalJni.computerKeyWithAllStr(((afp)localObject2).GdB, arrayOfByte3, arrayOfByte4, (PByteArray)localObject1, 0);
          localObject1 = ((PByteArray)localObject1).value;
          if (localObject1 != null) {
            break label681;
          }
          i = -1;
          label472:
          ad.i("MicroMsg.MMReqRespReg2", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), bt.aRp(bt.cB((byte[])localObject1)) });
          label508:
          if (localObject1 == null) {
            break label699;
          }
          localObject2 = localObject1;
          label517:
          localb.FnR = ((byte[])localObject2);
          if ((j & 0x4) == 0) {
            break label779;
          }
          ad.d("MicroMsg.MMReqRespReg2", "summerauth must decode session key");
          if (bt.cC((byte[])localObject1)) {
            break label750;
          }
          localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject3, (byte[])localObject1);
          if (localObject3 != null) {
            break label707;
          }
          i = -1;
          label561:
          localObject2 = bt.cB((byte[])localObject3);
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
          ad.d("MicroMsg.MMReqRespReg2", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", new Object[] { Integer.valueOf(i), localObject2, Integer.valueOf(j), bt.aRp(bt.cB((byte[])localObject1)) });
          if (bt.cC((byte[])localObject1)) {
            break label721;
          }
          ad.d("MicroMsg.MMReqRespReg2", "summerauth decode session key succ session:%s", new Object[] { bt.aRp(bt.cB((byte[])localObject1)) });
          localb.b((byte[])localObject1, arrayOfByte1, arrayOfByte2);
          localb.gva = 1;
          break;
          i = localObject3.length;
          break label276;
          i = arrayOfByte4.length;
          break label392;
          i = localObject1.length;
          break label472;
          ad.w("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key is null!");
          break label508;
          localObject2 = new byte[0];
          break label517;
          i = localObject3.length;
          break label561;
        }
        label721:
        ad.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed ret null!");
        localb.b(new byte[0], arrayOfByte1, arrayOfByte2);
        localb.gva = 2;
        continue;
        label750:
        ad.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed as agreedECDHKey is null!");
        localb.b(new byte[0], arrayOfByte1, arrayOfByte2);
        localb.gva = 2;
        continue;
        label779:
        ad.d("MicroMsg.MMReqRespReg2", "summerauth not need decode session key");
        localb.b((byte[])localObject3, arrayOfByte1, arrayOfByte2);
        localb.gva = 1;
      }
      else
      {
        ad.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo sect null and decode failed!");
        localb.b(new byte[0], new byte[0], new byte[0]);
        localb.gva = 2;
      }
    }
  }
  
  public final boolean getIsLongPolling()
  {
    AppMethodBeat.i(189837);
    boolean bool = this.hON.getIsLongPolling();
    AppMethodBeat.o(189837);
    return bool;
  }
  
  public final boolean getIsUserCmd()
  {
    AppMethodBeat.i(132452);
    boolean bool = this.hON.getIsUserCmd();
    AppMethodBeat.o(132452);
    return bool;
  }
  
  public final int getLongPollingTimeout()
  {
    AppMethodBeat.i(189838);
    int i = this.hON.getLongPollingTimeout();
    AppMethodBeat.o(189838);
    return i;
  }
  
  public final int getMMReqRespHash()
  {
    AppMethodBeat.i(132453);
    int i = this.hON.hashCode();
    AppMethodBeat.o(132453);
    return i;
  }
  
  public final int getNewExtFlags()
  {
    AppMethodBeat.i(189839);
    int i = this.hON.getNewExtFlags();
    AppMethodBeat.o(189839);
    return i;
  }
  
  public final int getOptions()
  {
    AppMethodBeat.i(132454);
    int i = this.hON.getOptions();
    AppMethodBeat.o(132454);
    return i;
  }
  
  public final int getTimeOut()
  {
    AppMethodBeat.i(132462);
    int i = this.hON.getTimeOut();
    AppMethodBeat.o(132462);
    return i;
  }
  
  public final byte[] getTransHeader()
  {
    AppMethodBeat.i(189840);
    byte[] arrayOfByte = this.hON.getTransHeader();
    AppMethodBeat.o(189840);
    return arrayOfByte;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(132455);
    int i = this.hON.getType();
    AppMethodBeat.o(132455);
    return i;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(132456);
    String str = this.hON.getUri();
    AppMethodBeat.o(132456);
    return str;
  }
  
  public final boolean isSingleSession()
  {
    AppMethodBeat.i(132463);
    boolean bool = this.hON.isSingleSession();
    AppMethodBeat.o(132463);
    return bool;
  }
  
  public final void setConnectionInfo(String paramString)
  {
    AppMethodBeat.i(132457);
    this.hON.setConnectionInfo(paramString);
    AppMethodBeat.o(132457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.v
 * JD-Core Version:    0.7.0.1
 */