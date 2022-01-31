package com.tencent.mm.ah;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.RemoteException;
import com.tencent.mm.model.av;
import com.tencent.mm.network.j;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r;
import com.tencent.mm.network.r.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.azd;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bom;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.i.c.a;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.u.a;
import com.tencent.mm.protocal.u.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class u
  extends r.a
{
  private q edR;
  g eee;
  h eef;
  ah handler;
  
  public u(q paramq) {}
  
  public u(q paramq, ah paramah)
  {
    this.edR = paramq;
    this.eee = new t(paramq.Kv(), paramq.getType());
    this.eef = new v(paramq.HF(), paramq.getType());
    this.handler = paramah;
  }
  
  public final int KC()
  {
    return this.edR.hashCode();
  }
  
  public final int Kp()
  {
    return this.edR.Kp();
  }
  
  public final int Kq()
  {
    return this.edR.Kq();
  }
  
  public final boolean Kw()
  {
    return this.edR.Kw();
  }
  
  public final g Lc()
  {
    return this.eee;
  }
  
  public final h Ld()
  {
    return this.eef;
  }
  
  public final int Le()
  {
    int j = -1;
    int i = getType();
    y.d("MicroMsg.RemoteReqResp", "summerauth decodeAndRetriveAccInfo type:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      return -1;
    case 701: 
    case 702: 
      return av.a(this.edR);
    }
    Object localObject2 = this.edR;
    Object localObject1 = (u.a)((q)localObject2).Kv();
    u.b localb = (u.b)((q)localObject2).HF();
    y.i("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo type:%d, stack[%s]", new Object[] { Integer.valueOf(126), bk.csb() });
    if (localb.dDD != 0) {
      y.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(localb.dDD) });
    }
    for (;;)
    {
      return localb.dDD;
      Object localObject3 = localb.sqm.tvn;
      if (localObject3 != null)
      {
        int k = ((bom)localObject3).syw;
        localObject2 = ((bom)localObject3).syg;
        localObject3 = aa.a(((bom)localObject3).syh);
        int m = ((uq)localObject2).syK.tFK;
        int n = ((uq)localObject2).sRn;
        label223:
        byte[] arrayOfByte2;
        if (localObject3 == null)
        {
          i = -1;
          y.d("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), bk.aac(bk.bD((byte[])localObject3)) });
          byte[] arrayOfByte1 = aa.a(((uq)localObject2).syK);
          arrayOfByte2 = ((u.a)localObject1).spy;
          localObject1 = null;
          if (bk.bE(arrayOfByte1)) {
            break label610;
          }
          m = arrayOfByte1.length;
          localObject1 = bk.aac(bk.bD(arrayOfByte1));
          if (arrayOfByte2 != null) {
            break label596;
          }
          i = -1;
          label318:
          y.d("MicroMsg.MMReqRespReg2", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", new Object[] { Integer.valueOf(m), localObject1, Integer.valueOf(i), bk.aac(bk.bD(arrayOfByte2)) });
          localObject1 = new PByteArray();
          m = MMProtocalJni.computerKeyWithAllStr(((uq)localObject2).sRn, arrayOfByte1, arrayOfByte2, (PByteArray)localObject1, 0);
          localObject1 = ((PByteArray)localObject1).value;
          if (localObject1 != null) {
            break label603;
          }
          i = -1;
          label400:
          y.i("MicroMsg.MMReqRespReg2", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), bk.aac(bk.bD((byte[])localObject1)) });
          label437:
          if (localObject1 == null) {
            break label620;
          }
          localObject2 = localObject1;
          label446:
          localb.spA = ((byte[])localObject2);
          if ((k & 0x4) == 0) {
            break label690;
          }
          y.d("MicroMsg.MMReqRespReg2", "summerauth must decode session key");
          if (bk.bE((byte[])localObject1)) {
            break label666;
          }
          localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject3, (byte[])localObject1);
          if (localObject3 != null) {
            break label628;
          }
          i = -1;
          label490:
          localObject2 = bk.bD((byte[])localObject3);
          if (localObject1 != null) {
            break label635;
          }
        }
        for (;;)
        {
          y.d("MicroMsg.MMReqRespReg2", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", new Object[] { Integer.valueOf(i), localObject2, Integer.valueOf(j), bk.aac(bk.bD((byte[])localObject1)) });
          if (bk.bE((byte[])localObject1)) {
            break label642;
          }
          y.d("MicroMsg.MMReqRespReg2", "summerauth decode session key succ session:%s", new Object[] { bk.aac(bk.bD((byte[])localObject1)) });
          localb.bn((byte[])localObject1);
          localb.dDD = 1;
          break;
          i = localObject3.length;
          break label223;
          label596:
          i = arrayOfByte2.length;
          break label318;
          label603:
          i = localObject1.length;
          break label400;
          label610:
          y.w("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key is null!");
          break label437;
          label620:
          localObject2 = new byte[0];
          break label446;
          label628:
          i = localObject3.length;
          break label490;
          label635:
          j = localObject1.length;
        }
        label642:
        y.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed ret null!");
        localb.bn(new byte[0]);
        localb.dDD = 2;
        continue;
        label666:
        y.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed as agreedECDHKey is null!");
        localb.bn(new byte[0]);
        localb.dDD = 2;
        continue;
        label690:
        y.d("MicroMsg.MMReqRespReg2", "summerauth not need decode session key");
        localb.bn((byte[])localObject3);
        localb.dDD = 1;
      }
      else
      {
        y.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo sect null and decode failed!");
        localb.bn(new byte[0]);
        localb.dDD = 2;
      }
    }
  }
  
  public final void a(com.tencent.mm.network.d paramd, final j paramj, final int paramInt1, final int paramInt2)
  {
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        u localu = new u(new l(), u.this.handler);
        try
        {
          paramj.a(localu, paramInt1, paramInt2, "");
          return;
        }
        catch (RemoteException localRemoteException)
        {
          y.e("MicroMsg.RemoteReqResp", "exception:%s", new Object[] { bk.j(localRemoteException) });
        }
      }
    });
  }
  
  public final void a(final j paramj, final int paramInt1, final int paramInt2)
  {
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        int k = av.HD().getInt("key_auth_update_version", 0);
        int j;
        Object localObject;
        if (k <= 637665332)
        {
          i = 701;
          j = i;
          if (k == 0)
          {
            localObject = ae.getContext().getSharedPreferences("ticket_prefs", 4);
            if (!bk.bl(((SharedPreferences)localObject).getString("_auth_ticket", ""))) {
              break label296;
            }
            y.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth revise to autoauth");
            f.nEG.a(148L, 50L, 1L, true);
            j = 702;
          }
          label81:
          y.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(com.tencent.mm.protocal.d.spa), Integer.valueOf(637665332), Integer.valueOf(j) });
          if (j == 701) {
            f.nEG.a(148L, 48L, 1L, true);
          }
          if (((u.a(u.this).getType() != 702) && (u.a(u.this).getType() != 701)) || (((i.g)u.a(u.this).HF()).dDD != 2)) {
            break label386;
          }
        }
        label386:
        for (int i = 1;; i = 0)
        {
          y.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", new Object[] { Integer.valueOf(u.a(u.this).getType()), Integer.valueOf(j), Integer.valueOf(i) });
          localObject = i.c.a.spv.bh(j, i);
          if (localObject == null) {}
          for (localObject = null;; localObject = new u((q)localObject, u.this.handler))
          {
            try
            {
              paramj.a((r)localObject, paramInt1, paramInt2, "");
              return;
            }
            catch (RemoteException localRemoteException)
            {
              label296:
              y.e("MicroMsg.RemoteReqResp", "exception:%s", new Object[] { bk.j(localRemoteException) });
              return;
            }
            i = 702;
            break;
            f.nEG.a(148L, 49L, 1L, true);
            y.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth keep manual as old [%s]", new Object[] { bk.aac(((SharedPreferences)localObject).getString("_auth_ticket", "")) });
            j = i;
            break label81;
          }
        }
      }
    });
  }
  
  public final void a(j paramj, final int paramInt1, final int paramInt2, final String paramString)
  {
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        y.d("MicroMsg.RemoteReqResp", "summerauth doAutoAuthEnd type:%d, stack[%s]", new Object[] { Integer.valueOf(u.a(u.this).getType()), bk.csb() });
        i.f localf = (i.f)u.a(u.this).Kv();
        i.g localg = (i.g)u.a(u.this).HF();
        if (localg == null)
        {
          y.f("MicroMsg.RemoteReqResp", "null auth.resp");
          return;
        }
        i.c.a.spv.a(localf, localg, paramInt1, paramInt2, paramString);
      }
    });
  }
  
  public final int getType()
  {
    return this.edR.getType();
  }
  
  public final String getUri()
  {
    return this.edR.getUri();
  }
  
  public final void kx(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.u
 * JD-Core Version:    0.7.0.1
 */