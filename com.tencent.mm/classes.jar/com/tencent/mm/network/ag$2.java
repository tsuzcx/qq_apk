package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class ag$2
  implements Runnable
{
  ag$2(ag paramag, int paramInt1, Object paramObject, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(58697);
    aa localaa = ab.anG();
    int i1 = this.gfc;
    int j = this.val$errType;
    int m = this.val$errCode;
    for (;;)
    {
      int i2;
      int i;
      int k;
      r localr;
      l locall;
      int n;
      synchronized (localaa.get)
      {
        i2 = localaa.mA(i1);
        if (-1 == i2)
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onGYNetEnd GET FROM QUEUE failed. native:[%d,%d] taskId:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(i1) });
          AppMethodBeat.o(58697);
          return;
        }
        i = 0;
        long l;
        switch (j)
        {
        default: 
          com.tencent.mm.sdk.platformtools.ab.f("MicroMsg.MMNativeNetTaskAdapter", "c2JavaErrorType not exits c_errType:%d", new Object[] { Integer.valueOf(j) });
          break label2156;
          k = i;
          j = m;
          if (!ab.anB().geL)
          {
            k = i;
            j = m;
            if (i == 1)
            {
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMNativeNetTaskAdapter", "network not available");
              k = 2;
              j = -1;
            }
          }
          localr = localaa.get[i2].gex;
          locall = localaa.get[i2].gey;
          l = localaa.get[i2].startTime;
          localaa.get[i2] = null;
          if (k == 0) {
            i = k;
          }
          break;
        case 0: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
          try
          {
            if (aa.my(localr.getType())) {
              break;
            }
            i = k;
            if (localr.adP().getRetCode() == 0) {
              break;
            }
            i = 4;
            k = localr.adP().getRetCode();
            j = 4;
            i = k;
          }
          catch (RemoteException localRemoteException5)
          {
            t localt;
            byte[] arrayOfByte;
            i locali;
            m = -1;
            k = i;
            i = m;
            continue;
          }
          try
          {
            k = localr.getType();
            try
            {
              localt = ab.anF();
              arrayOfByte = localr.adP().adB();
              try
              {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.MMAutoAuth", "summerauth onGYNetEnd threadId: 0 errType: " + j + " errCode: " + i + " errMsg: " + null + " rr: " + localr + " type: " + localr.getType() + " netIdGetCertBeforeAutoAuth: " + localt.gdD);
                if (i == 0) {
                  continue;
                }
                localt.gdu += 1;
                locali = localr.adP();
                m = localr.getType();
                switch (m)
                {
                }
              }
              catch (RemoteException localRemoteException1)
              {
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MMAutoAuth", "exception:%s", new Object[] { bo.l(localRemoteException1) });
                continue;
              }
              m = localr.getMMReqRespHash();
              n = i;
              i = k;
              k = n;
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onTaskEnd type:%d time:%d hash[%d,%d] [%d,%d]", new Object[] { Integer.valueOf(i), Long.valueOf(bo.hl(l)), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k) });
              if ((4 == j) && ((-1 == k) || (-2 == k) || (-24 == k) || (-34 == k))) {
                ab.anD().post(new aa.1(localaa, i, k));
              }
              try
              {
                String str1 = localr.adP().getErrMsg();
                if ((str1 == null) || (str1.length() <= 0)) {
                  break label2078;
                }
                locall.a(i2, j, k, str1, localr, localr.adP().adB());
                AppMethodBeat.o(58697);
                return;
              }
              catch (Exception localException)
              {
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MMNativeNetTaskAdapter", "onGYNetEnd cb %s", new Object[] { localException.getMessage() });
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", new Object[] { bo.l(localException), Integer.valueOf(i1) });
                AppMethodBeat.o(58697);
                return;
              }
              i = 0;
            }
            catch (RemoteException localRemoteException2)
            {
              m = k;
              k = j;
              j = i;
              i = m;
            }
            i = 2;
          }
          catch (RemoteException localRemoteException6)
          {
            k = -1;
            m = i;
            i = k;
            k = j;
            j = m;
            continue;
            m = j;
            n = i;
            break label2041;
          }
          i = 2;
          break label2156;
          i = 1;
          break label2156;
          i = 1;
          break label2156;
          i = 1;
          break label2156;
          i = 1;
          break label2156;
          if ((-3002 == m) || (-3003 == m))
          {
            i = 4;
          }
          else if (-10001 == m)
          {
            i = 6;
          }
          else
          {
            i = 5;
            break label2156;
            i = 4;
            break label2156;
            i = 1;
            break label2156;
            if (localr.getType() == 10) {
              continue;
            }
            localt.gdu = 0;
            continue;
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", new Object[] { bo.l(localRemoteException2), Integer.valueOf(i1) });
            m = 0;
            n = j;
            j = k;
            k = n;
            continue;
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMAutoAuth", "summerauth end type: %d, ret:[%d,%d][%s]", new Object[] { Integer.valueOf(localr.getType()), Integer.valueOf(j), Integer.valueOf(i), null });
            if ((locali.getRetCode() != 0) || (j != 0) || (i != 0)) {
              if (localr.getType() == 126) {
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MMAutoAuth", "net.end: reg err: type=" + localr.getType() + " err=" + j + "," + i + " errmsg=" + null);
              }
            }
          }
          break;
        }
      }
      switch (i)
      {
      default: 
        break;
      case -213: 
      case -205: 
      case -100: 
        ah.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
        if (i == -213)
        {
          e.qrI.idkeyStat(148L, 31L, 1L, false);
        }
        else if (i == -100)
        {
          e.qrI.idkeyStat(148L, 32L, 1L, false);
        }
        else if (i == -205)
        {
          e.qrI.idkeyStat(148L, 33L, 1L, false);
          continue;
          m = localr.adQ();
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMAutoAuth", "summerauth accinfo doAuthEnd type:%d, ret:%d loginDecodeFailedTry:%d", new Object[] { Integer.valueOf(localr.getType()), Integer.valueOf(m), Integer.valueOf(localt.fPz) });
          String str2;
          Object localObject3;
          label2078:
          if (m == 2)
          {
            if ((localr.getType() == 702) || (localr.getType() == 763))
            {
              e.qrI.idkeyStat(148L, 34L, 1L, false);
              localt.fPz += 1;
              if (localt.fPz > 1)
              {
                com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.MMAutoAuth", "summerauth loginDecodeFailedTry beyond 1 no more try!");
                localt.j(j, i, "auth_decode_failed_" + bo.bf(null, ""));
              }
              else
              {
                for (;;)
                {
                  try
                  {
                    m = locali.getUin();
                    Object localObject2 = locali.adR();
                    if (bo.ce((byte[])localObject2))
                    {
                      localObject2 = "";
                      if (!bo.ce(arrayOfByte)) {
                        break label1513;
                      }
                      str2 = "";
                      if (!localt.j((String)localObject2, str2, m)) {
                        break label1523;
                      }
                      localt.gdz.cKp = arrayOfByte;
                      localr.a(localt.gdA, 0, 0);
                    }
                  }
                  catch (RemoteException localRemoteException3)
                  {
                    com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.MMAutoAuth", localRemoteException3, "summerauth save serverid aak failed 1 cookie:" + bo.cg(arrayOfByte), new Object[0]);
                    com.tencent.mm.sdk.platformtools.ab.dsI();
                    AppMethodBeat.o(58697);
                    throw localRemoteException3;
                  }
                  localObject3 = bo.cg(localRemoteException3);
                  continue;
                  label1513:
                  str2 = bo.cg(arrayOfByte);
                  continue;
                  label1523:
                  com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.MMAutoAuth", "summerauth save serverid aak failed 1");
                }
              }
            }
          }
          else
          {
            localt.fPz = 0;
            h localh = localr.adO();
            try
            {
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMAutoAuth", "summerauth accinfo %d: username:%s, wxusername:%s, ticket:%s, single session: %s client session:%s, server session:%s uin:%d", new Object[] { Integer.valueOf(localr.getType()), localh.getUserName(), locali.adE(), bo.aqg(bo.cd(locali.adR())), bo.aqg(bo.cd(locali.jN(1))), bo.aqg(bo.cd(locali.jN(2))), bo.aqg(bo.cd(locali.jN(3))), Integer.valueOf(locali.getUin()) });
              m = locali.getUin();
              localObject3 = locali.adR();
              if (bo.ce((byte[])localObject3))
              {
                localObject3 = "";
                label1708:
                if (!bo.ce(arrayOfByte)) {
                  break label1864;
                }
                str2 = "";
                label1721:
                if (!localt.j((String)localObject3, str2, m)) {
                  break label1874;
                }
                localt.gdz.cKp = arrayOfByte;
                localt.gdz.username = localh.getUserName();
                localt.gdz.gde = locali.adE();
                localt.gdz.a(locali.jN(1), locali.jN(2), locali.jN(3), locali.getUin());
                localt.gdz.gdd = locali.adD();
                p.getString(locali.getUin());
                b.dsc();
              }
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMAutoAuth", "summerauth decode and save ok!");
                break;
                localObject3 = bo.cg((byte[])localObject3);
                break label1708;
                label1864:
                str2 = bo.cg(arrayOfByte);
                break label1721;
                label1874:
                e.qrI.idkeyStat(148L, 35L, 1L, false);
                com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.MMAutoAuth", "summerauth save serverid aak failed 2");
              }
              if (j != 0) {
                break label1999;
              }
            }
            catch (RemoteException localRemoteException4)
            {
              com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.MMAutoAuth", localRemoteException4, "summerauth save serverid aak failed 2 cookie:" + bo.cg(arrayOfByte), new Object[0]);
              com.tencent.mm.sdk.platformtools.ab.dsI();
              AppMethodBeat.o(58697);
              throw localRemoteException4;
            }
            if (i == 0)
            {
              com.tencent.mm.protocal.aa.T(localr.adP().adS(), localr.adP().adT(), localr.adP().adU());
              localt.gdC = SystemClock.elapsedRealtime();
            }
            label1999:
            if ((ae.gkK == 10003) && (ae.gkL > 0))
            {
              if (ae.gkL <= 1) {
                ae.gkL = 0;
              }
              m = 4;
              n = 0;
              com.tencent.mm.protocal.aa.T("", "", 0);
              label2041:
              if (localt.gdD != -1)
              {
                if ((m == 0) && (n == 0)) {
                  localt.a(localr, 0, 0);
                }
                localt.gdD = -1;
                continue;
                locall.a(i2, j, k, null, localr, localr.adP().adB());
                AppMethodBeat.o(58697);
              }
            }
            else
            {
              i = j;
              j = k;
              continue;
              label2156:
              if (i == 0) {
                m = 0;
              }
              if (i == 3) {
                m = -1;
              }
            }
          }
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.network.ag.2
 * JD-Core Version:    0.7.0.1
 */