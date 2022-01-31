package com.tencent.mm.ai;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.network.j;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r;
import com.tencent.mm.network.r.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.j.e;
import com.tencent.mm.protocal.j.e.a;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bgg;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class u
  extends r.a
{
  private q ftU;
  com.tencent.mm.protocal.h fug;
  i fuh;
  ak handler;
  
  public u(q paramq) {}
  
  public u(q paramq, ak paramak)
  {
    AppMethodBeat.i(58275);
    this.ftU = paramq;
    this.fug = new t(paramq.getReqObj(), paramq.getType());
    this.fuh = new v(paramq.getRespObj(), paramq.getType());
    this.handler = paramak;
    AppMethodBeat.o(58275);
  }
  
  public final void a(com.tencent.mm.network.d paramd, final j paramj, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(58283);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(58273);
        u localu = new u(new l(), u.this.handler);
        try
        {
          paramj.a(localu, paramInt1, paramInt2, "");
          AppMethodBeat.o(58273);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          ab.e("MicroMsg.RemoteReqResp", "exception:%s", new Object[] { bo.l(localRemoteException) });
          AppMethodBeat.o(58273);
        }
      }
    });
    AppMethodBeat.o(58283);
  }
  
  public final void a(final j paramj, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(58282);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(58272);
        int j = ax.aaF().getInt("key_auth_update_version", 0);
        int i;
        Object localObject;
        label77:
        label98:
        long l;
        if (j <= 637665332) {
          if (f.whQ)
          {
            i = 252;
            if (j != 0) {
              break label482;
            }
            localObject = ah.getContext().getSharedPreferences("ticket_prefs", com.tencent.mm.compatible.util.h.Mp());
            if (!bo.isNullOrNil(((SharedPreferences)localObject).getString("_auth_ticket", ""))) {
              break label440;
            }
            if (!f.whQ) {
              break label433;
            }
            i = 763;
            ab.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth revise to autoauth");
            e.qrI.idkeyStat(148L, 50L, 1L, true);
            ab.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(com.tencent.mm.protocal.d.whH), Integer.valueOf(637665332), Integer.valueOf(i) });
            if ((i != 252) && (i != 701)) {
              break label499;
            }
            e.qrI.idkeyStat(148L, 48L, 1L, true);
            localObject = e.qrI;
            if (!f.whQ) {
              break label485;
            }
            l = 115L;
            label183:
            ((e)localObject).idkeyStat(148L, l, 1L, true);
            localObject = e.qrI;
            if (!f.whR) {
              break label492;
            }
            l = 117L;
            label209:
            ((e)localObject).idkeyStat(148L, l, 1L, true);
            if (((u.a(u.this).getType() != 702) && (u.a(u.this).getType() != 701) && (u.a(u.this).getType() != 763) && (u.a(u.this).getType() != 252)) || (((j.i)u.a(u.this).getRespObj()).eBe != 2)) {
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
          ab.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", new Object[] { Integer.valueOf(u.a(u.this).getType()), Integer.valueOf(i), Integer.valueOf(j) });
          localObject = j.e.a.wim.cr(i, j);
          if (localObject == null) {}
          for (localObject = null;; localObject = new u((q)localObject, u.this.handler))
          {
            try
            {
              paramj.a((r)localObject, paramInt1, paramInt2, "");
              AppMethodBeat.o(58272);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              label492:
              label499:
              ab.e("MicroMsg.RemoteReqResp", "exception:%s", new Object[] { bo.l(localRemoteException) });
              AppMethodBeat.o(58272);
              return;
            }
            i = 701;
            break;
            if (f.whQ)
            {
              i = 763;
              break;
            }
            i = 702;
            break;
            i = 702;
            break label77;
            e.qrI.idkeyStat(148L, 49L, 1L, true);
            ab.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth keep manual as old [%s]", new Object[] { bo.aqg(((SharedPreferences)localObject).getString("_auth_ticket", "")) });
            break label98;
            l = 116L;
            break label183;
            l = 118L;
            break label209;
            localObject = e.qrI;
            if (f.whQ)
            {
              l = 111L;
              ((e)localObject).idkeyStat(148L, l, 1L, true);
              localObject = e.qrI;
              if (!f.whR) {
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
    AppMethodBeat.o(58282);
  }
  
  public final void a(j paramj, final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(58281);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(58271);
        ab.d("MicroMsg.RemoteReqResp", "summerauth doAutoAuthEnd type:%d, stack[%s]", new Object[] { Integer.valueOf(u.a(u.this).getType()), bo.dtY() });
        j.h localh = (j.h)u.a(u.this).getReqObj();
        j.i locali = (j.i)u.a(u.this).getRespObj();
        if (locali == null)
        {
          ab.f("MicroMsg.RemoteReqResp", "null auth.resp");
          AppMethodBeat.o(58271);
          return;
        }
        j.e.a.wim.a(localh, locali, paramInt1, paramInt2, paramString);
        AppMethodBeat.o(58271);
      }
    });
    AppMethodBeat.o(58281);
  }
  
  public final com.tencent.mm.protocal.h adO()
  {
    return this.fug;
  }
  
  public final i adP()
  {
    return this.fuh;
  }
  
  public final int adQ()
  {
    AppMethodBeat.i(58284);
    int j = getType();
    int i = -1;
    ab.d("MicroMsg.RemoteReqResp", "summerauth decodeAndRetriveAccInfo type:%d", new Object[] { Integer.valueOf(j) });
    switch (j)
    {
    default: 
    case 252: 
    case 701: 
    case 702: 
    case 763: 
      for (;;)
      {
        AppMethodBeat.o(58284);
        return i;
        i = ax.a(this.ftU);
      }
    }
    Object localObject2 = this.ftU;
    Object localObject1 = (v.a)((q)localObject2).getReqObj();
    v.b localb = (v.b)((q)localObject2).getRespObj();
    ab.i("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo type:%d, stack[%s]", new Object[] { Integer.valueOf(((v.a)localObject1).getFuncId()), bo.dtY() });
    if (localb.eBe != 0) {
      ab.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(localb.eBe) });
    }
    for (;;)
    {
      i = localb.eBe;
      break;
      Object localObject3 = localb.wiP.xvy;
      if (localObject3 != null)
      {
        j = ((byj)localObject3).wrZ;
        localObject2 = ((byj)localObject3).wrJ;
        byte[] arrayOfByte1 = aa.a(((byj)localObject3).wsc);
        byte[] arrayOfByte2 = aa.a(((byj)localObject3).wsd);
        localObject3 = aa.a(((byj)localObject3).wrK);
        int k = ((zd)localObject2).wsu.getILen();
        int m = ((zd)localObject2).wQb;
        label276:
        byte[] arrayOfByte4;
        if (localObject3 == null)
        {
          i = -1;
          ab.d("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), bo.aqg(bo.cd((byte[])localObject3)), bo.aqg(bo.cd(arrayOfByte1)), bo.aqg(bo.cd(arrayOfByte2)) });
          byte[] arrayOfByte3 = aa.a(((zd)localObject2).wsu);
          arrayOfByte4 = ((v.a)localObject1).wik;
          localObject1 = null;
          if (bo.ce(arrayOfByte3)) {
            break label688;
          }
          k = arrayOfByte3.length;
          localObject1 = bo.aqg(bo.cd(arrayOfByte3));
          if (arrayOfByte4 != null) {
            break label674;
          }
          i = -1;
          label392:
          ab.d("MicroMsg.MMReqRespReg2", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", new Object[] { Integer.valueOf(k), localObject1, Integer.valueOf(i), bo.aqg(bo.cd(arrayOfByte4)) });
          localObject1 = new PByteArray();
          k = MMProtocalJni.computerKeyWithAllStr(((zd)localObject2).wQb, arrayOfByte3, arrayOfByte4, (PByteArray)localObject1, 0);
          localObject1 = ((PByteArray)localObject1).value;
          if (localObject1 != null) {
            break label681;
          }
          i = -1;
          label472:
          ab.i("MicroMsg.MMReqRespReg2", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), bo.aqg(bo.cd((byte[])localObject1)) });
          label508:
          if (localObject1 == null) {
            break label699;
          }
          localObject2 = localObject1;
          label517:
          localb.wip = ((byte[])localObject2);
          if ((j & 0x4) == 0) {
            break label779;
          }
          ab.d("MicroMsg.MMReqRespReg2", "summerauth must decode session key");
          if (bo.ce((byte[])localObject1)) {
            break label750;
          }
          localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject3, (byte[])localObject1);
          if (localObject3 != null) {
            break label707;
          }
          i = -1;
          label561:
          localObject2 = bo.cd((byte[])localObject3);
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
          ab.d("MicroMsg.MMReqRespReg2", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", new Object[] { Integer.valueOf(i), localObject2, Integer.valueOf(j), bo.aqg(bo.cd((byte[])localObject1)) });
          if (bo.ce((byte[])localObject1)) {
            break label721;
          }
          ab.d("MicroMsg.MMReqRespReg2", "summerauth decode session key succ session:%s", new Object[] { bo.aqg(bo.cd((byte[])localObject1)) });
          localb.b((byte[])localObject1, arrayOfByte1, arrayOfByte2);
          localb.eBe = 1;
          break;
          i = localObject3.length;
          break label276;
          i = arrayOfByte4.length;
          break label392;
          i = localObject1.length;
          break label472;
          ab.w("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key is null!");
          break label508;
          localObject2 = new byte[0];
          break label517;
          i = localObject3.length;
          break label561;
        }
        label721:
        ab.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed ret null!");
        localb.b(new byte[0], arrayOfByte1, arrayOfByte2);
        localb.eBe = 2;
        continue;
        label750:
        ab.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed as agreedECDHKey is null!");
        localb.b(new byte[0], arrayOfByte1, arrayOfByte2);
        localb.eBe = 2;
        continue;
        label779:
        ab.d("MicroMsg.MMReqRespReg2", "summerauth not need decode session key");
        localb.b((byte[])localObject3, arrayOfByte1, arrayOfByte2);
        localb.eBe = 1;
      }
      else
      {
        ab.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo sect null and decode failed!");
        localb.b(new byte[0], new byte[0], new byte[0]);
        localb.eBe = 2;
      }
    }
  }
  
  public final boolean getIsUserCmd()
  {
    AppMethodBeat.i(58276);
    boolean bool = this.ftU.getIsUserCmd();
    AppMethodBeat.o(58276);
    return bool;
  }
  
  public final int getMMReqRespHash()
  {
    AppMethodBeat.i(58277);
    int i = this.ftU.hashCode();
    AppMethodBeat.o(58277);
    return i;
  }
  
  public final int getOptions()
  {
    AppMethodBeat.i(58278);
    int i = this.ftU.getOptions();
    AppMethodBeat.o(58278);
    return i;
  }
  
  public final int getTimeOut()
  {
    AppMethodBeat.i(58285);
    int i = this.ftU.getTimeOut();
    AppMethodBeat.o(58285);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(58279);
    int i = this.ftU.getType();
    AppMethodBeat.o(58279);
    return i;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(58280);
    String str = this.ftU.getUri();
    AppMethodBeat.o(58280);
    return str;
  }
  
  public final boolean isSingleSession()
  {
    AppMethodBeat.i(58286);
    boolean bool = this.ftU.isSingleSession();
    AppMethodBeat.o(58286);
    return bool;
  }
  
  public final void setConnectionInfo(String paramString)
  {
    AppMethodBeat.i(146135);
    this.ftU.setConnectionInfo(paramString);
    AppMethodBeat.o(146135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ai.u
 * JD-Core Version:    0.7.0.1
 */