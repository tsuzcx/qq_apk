package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;

final class af$2
  implements Runnable
{
  af$2(af paramaf, int paramInt1, Object paramObject, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    z localz = aa.Uv();
    int i2 = this.ePp;
    int j = this.bEf;
    int m = this.bEg;
    for (;;)
    {
      int i3;
      int i;
      int k;
      r localr;
      l locall;
      int n;
      synchronized (localz.eOG)
      {
        i3 = localz.jF(i2);
        if (-1 == i3)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onGYNetEnd GET FROM QUEUE failed. native:[%d,%d] taskId:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(i2) });
          return;
          com.tencent.mm.sdk.platformtools.y.f("MicroMsg.MMNativeNetTaskAdapter", "c2JavaErrorType not exits c_errType:%d", new Object[] { Integer.valueOf(j) });
          break label2019;
          j = m;
          k = i;
          if (!aa.Uq().eOY)
          {
            j = m;
            k = i;
            if (i == 1)
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMNativeNetTaskAdapter", "network not available");
              k = 2;
              j = -1;
            }
          }
          localr = localz.eOG[i3].eOK;
          locall = localz.eOG[i3].eOL;
          long l = localz.eOG[i3].startTime;
          localz.eOG[i3] = null;
          if (k == 0)
          {
            m = k;
            try
            {
              if (localr.Ld().Lh() == 0) {
                break label1954;
              }
              m = 4;
              i = localr.Ld().Lh();
              j = i;
              i = 4;
            }
            catch (RemoteException localRemoteException5)
            {
              t localt;
              byte[] arrayOfByte;
              h localh;
              k = -1;
              i = j;
              j = k;
              k = m;
              continue;
            }
            try
            {
              k = localr.getType();
              try
              {
                localt = aa.Uu();
                arrayOfByte = localr.Ld().KM();
                try
                {
                  com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AutoAuth", "summerauth onGYNetEnd threadId: 0 errType: " + i + " errCode: " + j + " errMsg: " + null + " rr: " + localr + " type: " + localr.getType() + " netIdGetCertBeforeAutoAuth: " + localt.eNP);
                  if (j == 0) {
                    continue;
                  }
                  localt.eNG += 1;
                  localh = localr.Ld();
                  m = localr.getType();
                  switch (m)
                  {
                  }
                }
                catch (RemoteException localRemoteException1)
                {
                  int i1;
                  com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AutoAuth", "exception:%s", new Object[] { bk.j(localRemoteException1) });
                  continue;
                }
                m = localr.KC();
                n = j;
                i1 = i;
                j = k;
                i = n;
                k = i1;
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onTaskEnd type:%d time:%d hash[%d,%d] [%d,%d]", new Object[] { Integer.valueOf(j), Long.valueOf(bk.co(l)), Integer.valueOf(i2), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i) });
                if ((4 == k) && ((-1 == i) || (-2 == i) || (-24 == i) || (-34 == i))) {
                  aa.Us().post(new z.1(localz, j, i));
                }
                try
                {
                  String str1 = localr.Ld().Lg();
                  if ((str1 == null) || (str1.length() <= 0)) {
                    break label1889;
                  }
                  locall.a(i3, k, i, str1, localr, localr.Ld().KM());
                  return;
                }
                catch (Exception localException)
                {
                  com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMNativeNetTaskAdapter", "onGYNetEnd cb %s", new Object[] { localException.getMessage() });
                  com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", new Object[] { bk.j(localException), Integer.valueOf(i2) });
                  return;
                }
                i = 0;
              }
              catch (RemoteException localRemoteException2)
              {
                m = k;
                n = j;
                k = i;
                j = m;
                i = n;
              }
              i = 2;
            }
            catch (RemoteException localRemoteException6)
            {
              m = -1;
              k = i;
              i = j;
              j = m;
              continue;
              m = j;
              n = i;
              break label1852;
            }
            i = 2;
            break label2019;
            i = 1;
            break label2019;
            i = 1;
            break label2019;
            i = 1;
            break label2019;
            i = 1;
            break label2019;
            if ((-3002 == m) || (-3003 == m))
            {
              i = 4;
              break label2019;
            }
            if (-10001 == m)
            {
              i = 6;
              break label2019;
            }
            i = 5;
            break label2019;
            i = 4;
            break label2019;
            i = 1;
            break label2019;
            if (localr.getType() == 10) {
              continue;
            }
            localt.eNG = 0;
            continue;
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", new Object[] { bk.j(localRemoteException2), Integer.valueOf(i2) });
            m = 0;
            continue;
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoAuth", "summerauth end type: %d, ret:[%d,%d][%s]", new Object[] { Integer.valueOf(localr.getType()), Integer.valueOf(i), Integer.valueOf(j), null });
            if ((localh.Lh() != 0) || (i != 0) || (j != 0)) {
              if (localr.getType() == 126) {
                com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AutoAuth", "net.end: reg err: type=" + localr.getType() + " err=" + i + "," + j + " errmsg=" + null);
              }
            }
          }
        }
      }
      switch (j)
      {
      default: 
        break;
      case -213: 
      case -205: 
      case -100: 
        com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
        if (j == -213)
        {
          f.nEG.a(148L, 31L, 1L, false);
        }
        else if (j == -100)
        {
          f.nEG.a(148L, 32L, 1L, false);
        }
        else if (j == -205)
        {
          f.nEG.a(148L, 33L, 1L, false);
          continue;
          m = localr.Le();
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoAuth", "summerauth accinfo doAuthEnd type:%d, ret:%d loginDecodeFailedTry:%d", new Object[] { Integer.valueOf(localr.getType()), Integer.valueOf(m), Integer.valueOf(localt.ezJ) });
          String str2;
          Object localObject3;
          if (m == 2)
          {
            if (localr.getType() == 702)
            {
              f.nEG.a(148L, 34L, 1L, false);
              localt.ezJ += 1;
              if (localt.ezJ > 1)
              {
                com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AutoAuth", "summerauth loginDecodeFailedTry beyond 1 no more try!");
                localt.f(i, j, "auth_decode_failed_" + bk.aM(null, ""));
              }
              else
              {
                for (;;)
                {
                  try
                  {
                    m = localh.CK();
                    Object localObject2 = localh.Li();
                    if (bk.bE((byte[])localObject2))
                    {
                      localObject2 = "";
                      if (!bk.bE(arrayOfByte)) {
                        break label1386;
                      }
                      str2 = "";
                      if (!localt.h((String)localObject2, str2, m)) {
                        break label1396;
                      }
                      localt.eNL.cbM = arrayOfByte;
                      localr.a(localt.eNM, 0, 0);
                    }
                  }
                  catch (RemoteException localRemoteException3)
                  {
                    com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.AutoAuth", localRemoteException3, "summerauth save serverid aak failed 1 cookie:" + bk.bG(arrayOfByte), new Object[0]);
                    com.tencent.mm.sdk.platformtools.y.cqL();
                    throw localRemoteException3;
                  }
                  localObject3 = bk.bG(localRemoteException3);
                  continue;
                  label1386:
                  str2 = bk.bG(arrayOfByte);
                  continue;
                  label1396:
                  com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AutoAuth", "summerauth save serverid aak failed 1");
                }
              }
            }
          }
          else
          {
            localt.ezJ = 0;
            g localg = localr.Lc();
            try
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoAuth", "summerauth accinfo %d: username:%s, wxusername:%s, ticket:%s, session:%s, uin:%d", new Object[] { Integer.valueOf(localr.getType()), localg.getUserName(), localh.Lm(), bk.aac(bk.bD(localh.Li())), bk.aac(bk.bD(localh.Dj())), Integer.valueOf(localh.CK()) });
              m = localh.CK();
              localObject3 = localh.Li();
              if (bk.bE((byte[])localObject3))
              {
                localObject3 = "";
                label1544:
                if (!bk.bE(arrayOfByte)) {
                  break label1680;
                }
                str2 = "";
                label1557:
                if (!localt.h((String)localObject3, str2, m)) {
                  break label1690;
                }
                localt.eNL.cbM = arrayOfByte;
                localt.eNL.username = localg.getUserName();
                localt.eNL.eNw = localh.Lm();
                localt.eNL.w(localh.Dj(), localh.CK());
                localt.eNL.eNv = localh.KO();
                o.getString(localh.CK());
              }
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoAuth", "summerauth decode and save ok!");
                break;
                localObject3 = bk.bG((byte[])localObject3);
                break label1544;
                label1680:
                str2 = bk.bG(arrayOfByte);
                break label1557;
                label1690:
                f.nEG.a(148L, 35L, 1L, false);
                com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AutoAuth", "summerauth save serverid aak failed 2");
              }
              if (i != 0) {
                break label1810;
              }
            }
            catch (RemoteException localRemoteException4)
            {
              com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.AutoAuth", localRemoteException4, "summerauth save serverid aak failed 2 cookie:" + bk.bG(arrayOfByte), new Object[0]);
              com.tencent.mm.sdk.platformtools.y.cqL();
              throw localRemoteException4;
            }
            if (j == 0)
            {
              com.tencent.mm.protocal.y.K(localr.Ld().Lj(), localr.Ld().Lk(), localr.Ld().Ll());
              localt.eNO = SystemClock.elapsedRealtime();
            }
            label1810:
            if ((com.tencent.mm.platformtools.ae.eSP == 10003) && (com.tencent.mm.platformtools.ae.eSQ > 0))
            {
              if (com.tencent.mm.platformtools.ae.eSQ <= 1) {
                com.tencent.mm.platformtools.ae.eSQ = 0;
              }
              n = 4;
              m = 0;
              com.tencent.mm.protocal.y.K("", "", 0);
              label1852:
              if (localt.eNP != -1)
              {
                if ((n == 0) && (m == 0)) {
                  localt.a(localr, 0, 0);
                }
                localt.eNP = -1;
                continue;
                label1889:
                locall.a(i3, k, i, null, localr, localr.Ld().KM());
              }
            }
            else
            {
              label1954:
              i = k;
              continue;
              i = 0;
              switch (j)
              {
              }
              continue;
              label2019:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.af.2
 * JD-Core Version:    0.7.0.1
 */