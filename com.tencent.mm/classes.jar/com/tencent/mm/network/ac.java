package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class ac
{
  final a[] iIW;
  
  public ac()
  {
    AppMethodBeat.i(132894);
    this.iIW = new a[100];
    AppMethodBeat.o(132894);
  }
  
  static boolean qG(int paramInt)
  {
    return (paramInt == 10) || (paramInt == 268369922);
  }
  
  final int a(int paramInt, byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(132906);
    synchronized (this.iIW)
    {
      k = qI(paramInt);
      if (-1 == k)
      {
        AppMethodBeat.o(132906);
        return -1;
      }
      j = StnLogic.RESP_FAIL_HANDLE_DEFAULT;
      paramInt = j;
      i = j;
      try
      {
        byte[] arrayOfByte = this.iIW[k].iJa.aFy().getPassKey();
        paramInt = j;
        i = j;
        l = this.iIW[k].iJa.aFy().getECDHEngine();
        paramInt = j;
        i = j;
        locali = this.iIW[k].iJa.aFz();
        paramInt = j;
        i = j;
        bool = locali.a(this.iIW[k].iJa.getType(), paramArrayOfByte, arrayOfByte, l);
        paramInt = j;
        i = j;
        if (!this.iIW[k].iJa.aFy().useAxSession()) {
          break label733;
        }
        paramInt = j;
        i = j;
        ae.d("MicroMsg.MMNativeNetTaskAdapter", "axauth cgi is axcgi");
      }
      catch (RemoteException paramArrayOfByte)
      {
        for (;;)
        {
          try
          {
            boolean bool;
            int m;
            paramArrayOfInt1[0] = locali.getRetCode();
            paramInt = j;
            i = j;
            paramArrayOfInt2 = this.iIW[k].iJa.getUri();
            k = j;
            paramInt = j;
            i = j;
            if (!t.iHz.isEmpty())
            {
              k = j;
              paramInt = j;
              i = j;
              if (paramArrayOfInt2.contains(t.iHz))
              {
                paramInt = j;
                i = j;
                ae.i("MicroMsg.MMNativeNetTaskAdapter", "axauth cgi %s session time", new Object[] { paramArrayOfInt2 });
                paramInt = j;
                i = j;
                t.iHz = "";
                paramInt = j;
                i = j;
                j = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                paramArrayOfInt1[0] = -13;
                k = j;
                paramInt = j;
                i = j;
                if (ad.aPK() != null)
                {
                  paramInt = j;
                  i = j;
                  ad.aPK().aPk();
                  k = j;
                }
              }
            }
            paramInt = k;
            i = k;
            if (ad.aPO() != null)
            {
              paramInt = k;
              i = k;
              paramArrayOfInt1 = ad.aPO();
              paramInt = k;
              i = k;
              paramArrayOfInt2 = bu.bI(paramArrayOfInt2, "null");
              if (paramArrayOfByte == null) {
                break;
              }
              paramInt = k;
              i = k;
              l = paramArrayOfByte.length;
              paramInt = k;
              i = k;
              paramArrayOfInt1.K(paramArrayOfInt2, l);
            }
            paramInt = k;
            AppMethodBeat.o(132906);
            return paramInt;
            paramInt = j;
            i = j;
            ae.d("MicroMsg.MMNativeNetTaskAdapter", "axauth cgi is not axcgi");
            continue;
            paramArrayOfByte = paramArrayOfByte;
            e.ywz.idkeyStat(162L, 5L, 1L, false);
            ae.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bu.o(paramArrayOfByte) });
            continue;
            paramInt = j;
            i = j;
            if (-3002 != locali.getRetCode())
            {
              paramInt = j;
              i = j;
              if (-3003 != locali.getRetCode())
              {
                paramInt = j;
                i = j;
                if (-3006 != locali.getRetCode()) {
                  continue;
                }
              }
            }
            paramInt = j;
            i = j;
            j = StnLogic.RESP_FAIL_HANDLE_TASK_END;
            paramInt = j;
            i = j;
            paramArrayOfInt1[0] = locali.getRetCode();
            continue;
          }
          catch (RemoteException paramArrayOfByte)
          {
            i locali;
            continue;
            paramInt = j;
            i = j;
            if (-3001 != locali.getRetCode()) {
              break label973;
            }
            paramInt = j;
            i = j;
            j = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
            paramInt = j;
            i = j;
            paramArrayOfInt1[0] = locali.getRetCode();
            continue;
          }
          catch (Exception paramArrayOfByte) {}
          e.ywz.idkeyStat(162L, 7L, 1L, false);
          ae.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bu.o(paramArrayOfByte) });
          paramInt = i;
          continue;
          paramInt = j;
          i = j;
          j = StnLogic.RESP_FAIL_HANDLE_NORMAL;
        }
        paramInt = j;
        i = j;
        e.ywz.idkeyStat(162L, 4L, 1L, false);
        paramInt = j;
        i = j;
        ae.e("MicroMsg.MMNativeNetTaskAdapter", "buf to resp failed, change server and try again");
        paramInt = j;
        i = j;
        if (ad.aPO() == null) {
          break label1080;
        }
        paramInt = j;
        i = j;
        paramArrayOfInt1 = ad.aPO();
        if (paramArrayOfByte == null) {
          break label1086;
        }
        paramInt = j;
        i = j;
        for (l = paramArrayOfByte.length;; l = 0L)
        {
          paramInt = j;
          i = j;
          paramArrayOfInt1.K("resp_fail", l);
          paramInt = j;
          break;
        }
        paramArrayOfByte = finally;
        AppMethodBeat.o(132906);
        throw paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          continue;
          long l = 0L;
        }
      }
      if (bool)
      {
        paramInt = j;
        i = j;
        m = locali.getHeadExtFlags();
        paramArrayOfInt2[0] = 0;
        paramInt = j;
        i = j;
        j = locali.getRetCode();
        if ((m & 0x2) == 0)
        {
          paramArrayOfInt2[0] |= 0x2;
          paramInt = j;
          i = j;
          e.ywz.idkeyStat(656L, 0L, 1L, false);
        }
        if ((m & 0x4) == 0)
        {
          paramArrayOfInt2[0] |= 0x4;
          paramInt = j;
          i = j;
          e.ywz.idkeyStat(656L, 1L, 1L, false);
        }
        paramInt = j;
        i = j;
        if (locali.aFl() != null)
        {
          paramInt = j;
          i = j;
          if (-13 == locali.getRetCode())
          {
            paramInt = j;
            i = j;
            if (this.iIW[k].iJa.aFy().useAxSession())
            {
              paramInt = j;
              i = j;
              ae.w("MicroMsg.MMNativeNetTaskAdapter", "axsession cgi sessionkey timeout");
              paramInt = j;
              i = j;
              e.ywz.idkeyStat(162L, 9L, 1L, false);
            }
            paramInt = j;
            i = j;
            if (ad.aPK() != null)
            {
              paramInt = j;
              i = j;
              ad.aPK().aPk();
            }
          }
        }
        paramInt = j;
        i = j;
        if (-13 == locali.getRetCode())
        {
          paramInt = j;
          i = j;
          j = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
          paramInt = j;
          i = j;
        }
      }
    }
  }
  
  public final int a(r paramr, l paraml, c paramc, int paramInt)
  {
    AppMethodBeat.i(132901);
    if (paramr == null)
    {
      ae.e("MicroMsg.MMNativeNetTaskAdapter", "startTask  rr is null");
      AppMethodBeat.o(132901);
      return -1;
    }
    paramr.hashCode();
    StnLogic.Task localTask = new StnLogic.Task();
    a[] arrayOfa = this.iIW;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      for (;;)
      {
        int j;
        try
        {
          if (this.iIW[i] != null) {
            break;
          }
          this.iIW[i] = new a(0);
          this.iIW[i].iJa = paramr;
          this.iIW[i].iJb = paraml;
          this.iIW[i].iJc = paramc;
          this.iIW[i].startTime = bu.fpO();
          this.iIW[i].taskId = localTask.taskID;
          localTask.cmdID = paramr.aFy().getCmdId();
          localTask.cgi = paramr.getUri();
          j = paramr.getType();
          boolean bool;
          if ((paramr.getOptions() & 0x1) != 1)
          {
            bool = true;
            localTask.needAuthed = bool;
            if ((j == 126) || (j == 252) || (j == 701) || (j == 702) || (j == 763) || (j == 3941))
            {
              localTask.needAuthed = false;
              if ((j == 701) || (j == 252)) {
                localTask.retryCount = 1;
              }
            }
            if (j == 2962) {
              localTask.retryCount = 2;
            }
            localTask.limitFlow = true;
            if ((j != 149) && (j != 193) && (j != 110) && (j != 220) && (j != 323) && (j != 324) && (j != 326) && (j != 327) && (j != 703) && (j != 2580) && (j != 3767)) {
              break label843;
            }
            localTask.limitFlow = false;
            break label843;
            localTask.limitFrequency = false;
            localTask.channelStrategy = 0;
            if ((j == 233) || (j == 835) || (j == 238)) {
              localTask.channelStrategy = 1;
            }
            localTask.sendOnly = false;
            if (qG(j)) {
              localTask.sendOnly = true;
            }
            if ((paramr.aFy().getShortSupport()) && (paramr.getUri() != null) && (paramr.getUri().length() > 0)) {
              localTask.channelSelect |= 0x1;
            }
            if (localTask.cmdID != 0) {
              localTask.channelSelect |= 0x2;
            }
            localTask.reportArg = String.valueOf(j);
            if (j == 522)
            {
              localTask.totalTimeout = 300000;
              localTask.priority = 0;
            }
            if (j == 710)
            {
              localTask.totalTimeout = 15000;
              localTask.serverProcessCost = 0;
            }
            if (j == 2632)
            {
              j = paramr.getTimeOut();
              if (j != 0) {
                localTask.totalTimeout = j;
              }
            }
            if (paramr.getIsLongPolling())
            {
              ae.i("MicroMsg.MMNativeNetTaskAdapter", "this is long-polling cgi");
              localTask.longPolling = true;
              localTask.longPollingTimeout = paramr.getLongPollingTimeout();
              j = paramr.getTimeOut();
              if (j != 0) {
                localTask.totalTimeout = j;
              }
              localTask.retryCount = 0;
            }
            ae.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi startTask inQueue netid:%d hash[%d,%d] net:%d cgi:%s needAuthed:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(localTask.taskID), Integer.valueOf(paramr.getMMReqRespHash()), Integer.valueOf(localTask.channelSelect), localTask.cgi, Boolean.valueOf(localTask.needAuthed) });
            if (-1 != i)
            {
              if (paramInt == 1) {
                localTask.retryCount = 0;
              }
              StnLogic.startTask(localTask);
              ae.d("MicroMsg.MMNativeNetTaskAdapter", "startTask retsult=".concat(String.valueOf(i)));
              AppMethodBeat.o(132901);
              return i;
            }
          }
          else
          {
            bool = false;
            continue;
          }
          ae.e("MicroMsg.MMNativeNetTaskAdapter", "startTask err");
        }
        catch (RemoteException localRemoteException)
        {
          ae.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bu.o(localRemoteException) });
        }
        finally
        {
          AppMethodBeat.o(132901);
        }
        continue;
        i = -1;
        continue;
        label843:
        if (j != 703) {
          if (j != 3767) {}
        }
      }
      i += 1;
    }
  }
  
  final boolean a(int paramInt1, ByteArrayOutputStream paramByteArrayOutputStream, int[] paramArrayOfInt, int paramInt2, String paramString)
  {
    AppMethodBeat.i(132905);
    for (;;)
    {
      int i;
      synchronized (this.iIW)
      {
        i = qI(paramInt1);
        if (-1 == i)
        {
          AppMethodBeat.o(132905);
          return false;
        }
        try
        {
          bool = this.iIW[i].iJc.DS(paramString);
          ae.i("MicroMsg.MMNativeNetTaskAdapter", "link: %d req2Buf somr isfg:%b  cookie: %s, type: %d host[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(this.iIW[i].iJc.isForeground()), bu.cH(this.iIW[i].iJc.aFl()), Integer.valueOf(this.iIW[i].iJa.getType()), paramString });
          paramInt1 = 1;
          if (!this.iIW[i].iJa.isSingleSession())
          {
            paramInt1 = 2;
            this.iIW[i].iJa.aFy().setPassKey(this.iIW[i].iJc.mR(3));
            ae.i("MicroMsg.MMNativeNetTaskAdapter", "summerauths isSingleSession false type:[%s]", new Object[] { Integer.valueOf(this.iIW[i].iJa.getType()) });
          }
          if (!bool) {
            continue;
          }
          ae.i("MicroMsg.MMNativeNetTaskAdapter", "set axauth sessionkey ".concat(String.valueOf(paramString)));
          this.iIW[i].iJa.aFy().setPassKey(this.iIW[i].iJc.DR(paramString));
          localObject1 = this.iIW[i].iJc.DQ(paramString);
          localObject2 = this.iIW[i].iJc.DP(paramString);
          this.iIW[i].iJa.aFy().setUseAxsession(true);
          if (localObject1 == null) {
            continue;
          }
          ae.i("MicroMsg.MMNativeNetTaskAdapter", "axauth sessionkey length[%d]", new Object[] { Integer.valueOf(localObject1.length) });
          if (localObject2 == null) {
            continue;
          }
          ae.i("MicroMsg.MMNativeNetTaskAdapter", "axauth cookie length[%d]", new Object[] { Integer.valueOf(localObject2.length) });
        }
        catch (RemoteException paramString)
        {
          Object localObject2;
          paramArrayOfInt[0] = 1;
          e.ywz.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
          ae.e("MicroMsg.MMNativeNetTaskAdapter", "RemoteException:%s", new Object[] { bu.o(paramString) });
          bool = false;
          continue;
          ae.w("MicroMsg.MMNativeNetTaskAdapter", "axauth cookie is null");
          continue;
        }
        catch (IOException paramString)
        {
          paramArrayOfInt[0] = 2;
          e.ywz.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
          ae.e("MicroMsg.MMNativeNetTaskAdapter", "IOException:%s", new Object[] { bu.o(paramString) });
          bool = false;
          continue;
          paramString = this.iIW[i].iJc.mR(paramInt1);
          Object localObject1 = this.iIW[i].iJc.aFl();
          continue;
          paramArrayOfInt[0] = 0;
          e.ywz.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
          ae.e("MicroMsg.MMNativeNetTaskAdapter", "request to buffer using jni failed");
          continue;
        }
        catch (Exception paramString)
        {
          paramArrayOfInt[0] = 3;
          e.ywz.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
          ae.e("MicroMsg.MMNativeNetTaskAdapter", "Exception:%s", new Object[] { bu.o(paramString) });
          boolean bool = false;
          continue;
        }
        e.ywz.idkeyStat(148L, 123L, 1L, false);
        paramString = (String)localObject1;
        localObject1 = localObject2;
        paramInt1 = 2;
        this.iIW[i].iJa.aFy().setSessionKey(paramString);
        if (paramInt1 == 1)
        {
          paramInt2 = this.iIW[i].iJa.getType();
          if ((paramInt2 == 1000) || (paramInt2 == 502) || (paramInt2 == 930) || (paramInt2 == 503) || (paramInt2 == 654) || (paramInt2 == 755) || (paramInt2 == 931) || (paramInt2 == 733) || (paramInt2 == 784) || (paramInt2 == 722)) {
            break label1184;
          }
          if (paramInt2 != 627) {
            break label1190;
          }
          break label1184;
          if (paramInt2 == 0) {
            this.iIW[i].iJa.aFy().setPassKey(null);
          }
        }
        if (this.iIW[i].iJa.getNewExtFlags() != 0)
        {
          paramInt2 = this.iIW[i].iJa.getNewExtFlags();
          this.iIW[i].iJa.aFy().oX(paramInt2);
          localObject2 = this.iIW[i].iJa.getTransHeader();
          this.iIW[i].iJa.aFy().Y((byte[])localObject2);
        }
        this.iIW[i].iJa.aFy().setUin(this.iIW[i].iJc.getUin());
        localObject2 = this.iIW[i].iJa.aFy();
        paramInt2 = this.iIW[i].iJa.getType();
        if (paramInt1 != 2) {
          break label1196;
        }
        paramInt1 = 13;
        bool = ((h)localObject2).a(paramInt2, paramString, paramInt1, (byte[])localObject1, this.iIW[i].iJc.aFn(), 0, this.iIW[i].iJc.isForeground());
        if (bool) {
          paramByteArrayOutputStream.write(this.iIW[i].iJa.aFy().aFw());
        }
        try
        {
          if (ad.aPO() != null)
          {
            paramArrayOfInt = ad.aPO();
            paramInt1 = this.iIW[i].iJa.getType();
            if (paramByteArrayOutputStream == null) {
              break label1201;
            }
            l = paramByteArrayOutputStream.size();
            paramArrayOfInt.C(paramInt1, l);
          }
        }
        catch (Exception paramByteArrayOutputStream)
        {
          ae.e("MicroMsg.MMNativeNetTaskAdapter", "iDataPackageReporter Exception:%s", new Object[] { bu.o(paramByteArrayOutputStream) });
          continue;
        }
        ae.d("MicroMsg.MMNativeNetTaskAdapter", "req2Buf bOk: %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(132905);
        return bool;
        ae.w("MicroMsg.MMNativeNetTaskAdapter", "axauth axsessionkey is null");
      }
      label1184:
      paramInt2 = 1;
      continue;
      label1190:
      paramInt2 = 0;
      continue;
      label1196:
      paramInt1 = 0;
      continue;
      label1201:
      long l = 0L;
    }
  }
  
  public final int aPA()
  {
    AppMethodBeat.i(132900);
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      if (i >= 100) {
        break label96;
      }
      k = j;
      try
      {
        if (this.iIW[i] != null)
        {
          this.iIW[i].iJa.getType();
          k = j;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ae.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bu.o(localRemoteException), Integer.valueOf(i) });
          k = j + 1;
          this.iIW[i] = null;
        }
      }
      i += 1;
    }
    label96:
    AppMethodBeat.o(132900);
    return j;
  }
  
  final boolean aPx()
  {
    AppMethodBeat.i(132896);
    a[] arrayOfa = this.iIW;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      try
      {
        if (this.iIW[i] != null)
        {
          boolean bool = this.iIW[i].iJa.aFy().isAxAuth();
          if (bool) {
            return true;
          }
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.iIW[i] = null;
        ae.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bu.o(localRemoteException), Integer.valueOf(i) });
        break label126;
        return false;
      }
      finally
      {
        AppMethodBeat.o(132896);
      }
      label126:
      i += 1;
    }
  }
  
  final boolean aPy()
  {
    AppMethodBeat.i(132897);
    a[] arrayOfa = this.iIW;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      try
      {
        if ((this.iIW[i] != null) && ((252 == this.iIW[i].iJa.getType()) || (701 == this.iIW[i].iJa.getType()) || (702 == this.iIW[i].iJa.getType()) || (763 == this.iIW[i].iJa.getType()) || (3941 == this.iIW[i].iJa.getType())))
        {
          ae.w("MicroMsg.MMNativeNetTaskAdapter", "hasAuthCmd Auth inQueue: netid=" + i + " type=" + this.iIW[i].iJa.getType());
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.iIW[i] = null;
        ae.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bu.o(localRemoteException), Integer.valueOf(i) });
        break label243;
        return false;
      }
      finally
      {
        AppMethodBeat.o(132897);
      }
      label243:
      i += 1;
    }
  }
  
  final boolean aPz()
  {
    AppMethodBeat.i(132898);
    a[] arrayOfa = this.iIW;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      try
      {
        if ((this.iIW[i] != null) && (1000 == this.iIW[i].iJa.getType()))
        {
          ae.w("MicroMsg.MMNativeNetTaskAdapter", "hasWithoutLoginCmd inQueue: netid=" + i + " type=" + this.iIW[i].iJa.getType());
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.iIW[i] = null;
        ae.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bu.o(localRemoteException), Integer.valueOf(i) });
        break label163;
        return false;
      }
      finally
      {
        AppMethodBeat.o(132898);
      }
      label163:
      i += 1;
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(132895);
    reset();
    super.finalize();
    AppMethodBeat.o(132895);
  }
  
  final r fk(boolean paramBoolean)
  {
    AppMethodBeat.i(132899);
    a[] arrayOfa = this.iIW;
    int i = 0;
    Object localObject4;
    label315:
    Object localObject2;
    for (Object localObject1 = null;; localObject2 = localObject4)
    {
      if (i < 100)
      {
        try
        {
          a locala = this.iIW[i];
          Object localObject3 = localObject1;
          if (locala == null) {
            break label315;
          }
          if (paramBoolean) {
            localObject3 = localObject1;
          }
          try
          {
            if ((this.iIW[i].iJa instanceof r.a)) {
              break label315;
            }
            if ((!paramBoolean) && (!(this.iIW[i].iJa instanceof r.a)))
            {
              localObject3 = localObject1;
              break label315;
            }
            if ((252 == this.iIW[i].iJa.getType()) || (701 == this.iIW[i].iJa.getType()) || (763 == this.iIW[i].iJa.getType()) || (702 == this.iIW[i].iJa.getType()) || (3941 == this.iIW[i].iJa.getType()))
            {
              ae.e("MicroMsg.MMNativeNetTaskAdapter", "getAutoAuthRR Auth inQueue: netid=" + i + " type=" + this.iIW[i].iJa.getType());
              return null;
            }
          }
          catch (RemoteException localRemoteException)
          {
            ae.w("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bu.o(localRemoteException) });
            localObject4 = localObject1;
          }
          localObject4 = localr;
        }
        finally
        {
          AppMethodBeat.o(132899);
        }
        if (localr == null) {
          localObject4 = this.iIW[i].iJa;
        }
      }
      else
      {
        AppMethodBeat.o(132899);
        return localr;
      }
      i += 1;
    }
  }
  
  /* Error */
  public final void m(int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: ldc_w 518
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 84
    //   8: new 478	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 520
    //   15: invokespecial 483	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: iload_1
    //   19: invokevirtual 487	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc_w 522
    //   25: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_2
    //   29: invokevirtual 487	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc_w 524
    //   35: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_3
    //   39: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 495	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 309	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: invokestatic 527	com/tencent/mars/stn/StnLogic:clearTask	()V
    //   51: invokestatic 528	com/tencent/mars/stn/StnLogic:reset	()V
    //   54: bipush 100
    //   56: anewarray 6	com/tencent/mm/network/ac$a
    //   59: astore 5
    //   61: aload_0
    //   62: getfield 22	com/tencent/mm/network/ac:iIW	[Lcom/tencent/mm/network/ac$a;
    //   65: astore 6
    //   67: aload 6
    //   69: monitorenter
    //   70: iconst_0
    //   71: istore 4
    //   73: iload 4
    //   75: bipush 100
    //   77: if_icmpge +32 -> 109
    //   80: aload 5
    //   82: iload 4
    //   84: aload_0
    //   85: getfield 22	com/tencent/mm/network/ac:iIW	[Lcom/tencent/mm/network/ac$a;
    //   88: iload 4
    //   90: aaload
    //   91: aastore
    //   92: aload_0
    //   93: getfield 22	com/tencent/mm/network/ac:iIW	[Lcom/tencent/mm/network/ac$a;
    //   96: iload 4
    //   98: aconst_null
    //   99: aastore
    //   100: iload 4
    //   102: iconst_1
    //   103: iadd
    //   104: istore 4
    //   106: goto -33 -> 73
    //   109: aload 6
    //   111: monitorexit
    //   112: iconst_0
    //   113: istore 4
    //   115: iload 4
    //   117: bipush 100
    //   119: if_icmpge +141 -> 260
    //   122: aload 5
    //   124: iload 4
    //   126: aaload
    //   127: ifnull +88 -> 215
    //   130: ldc 84
    //   132: ldc_w 530
    //   135: iconst_3
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: iload 4
    //   143: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: aload 5
    //   151: iload 4
    //   153: aaload
    //   154: getfield 49	com/tencent/mm/network/ac$a:iJa	Lcom/tencent/mm/network/r;
    //   157: invokeinterface 73 1 0
    //   162: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aastore
    //   166: dup
    //   167: iconst_2
    //   168: aload 5
    //   170: iload 4
    //   172: aaload
    //   173: getfield 49	com/tencent/mm/network/ac$a:iJa	Lcom/tencent/mm/network/r;
    //   176: invokeinterface 328 1 0
    //   181: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: invokestatic 158	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload 5
    //   190: iload 4
    //   192: aaload
    //   193: getfield 223	com/tencent/mm/network/ac$a:iJb	Lcom/tencent/mm/network/l;
    //   196: iload 4
    //   198: iload_1
    //   199: iload_2
    //   200: aload_3
    //   201: aload 5
    //   203: iload 4
    //   205: aaload
    //   206: getfield 49	com/tencent/mm/network/ac$a:iJa	Lcom/tencent/mm/network/r;
    //   209: aconst_null
    //   210: invokeinterface 535 7 0
    //   215: iload 4
    //   217: iconst_1
    //   218: iadd
    //   219: istore 4
    //   221: goto -106 -> 115
    //   224: astore_3
    //   225: aload 6
    //   227: monitorexit
    //   228: ldc_w 518
    //   231: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_3
    //   235: athrow
    //   236: astore 6
    //   238: ldc 84
    //   240: ldc 184
    //   242: iconst_1
    //   243: anewarray 4	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: aload 6
    //   250: invokestatic 187	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   253: aastore
    //   254: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: goto -42 -> 215
    //   260: ldc_w 518
    //   263: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	ac
    //   0	267	1	paramInt1	int
    //   0	267	2	paramInt2	int
    //   0	267	3	paramString	String
    //   71	149	4	i	int
    //   59	143	5	arrayOfa1	a[]
    //   65	161	6	arrayOfa2	a[]
    //   236	13	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   80	100	224	finally
    //   109	112	224	finally
    //   225	228	224	finally
    //   130	215	236	java/lang/Exception
  }
  
  final int qH(int paramInt)
  {
    AppMethodBeat.i(132904);
    synchronized (this.iIW)
    {
      paramInt = qI(paramInt);
      if (-1 == paramInt)
      {
        ae.e("MicroMsg.MMNativeNetTaskAdapter", "-1 == index");
        AppMethodBeat.o(132904);
        return 0;
      }
      try
      {
        paramInt = this.iIW[paramInt].iJa.aFz().getRetCode();
        AppMethodBeat.o(132904);
        return paramInt;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bu.o(localException) });
        AppMethodBeat.o(132904);
        return 0;
      }
    }
  }
  
  final int qI(int paramInt)
  {
    int i = 0;
    while ((i < 100) && ((this.iIW[i] == null) || (paramInt != this.iIW[i].taskId))) {
      i += 1;
    }
    paramInt = i;
    if (100 <= i) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132902);
    ae.i("MicroMsg.MMNativeNetTaskAdapter", "reset");
    StnLogic.reset();
    a[] arrayOfa = this.iIW;
    int i = 0;
    while (i < 100) {
      try
      {
        a locala = this.iIW[i];
        if (locala != null) {}
        try
        {
          ae.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi reset outQueue: netId:%d hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.iIW[i].iJa.getType()), Integer.valueOf(this.iIW[i].iJa.getMMReqRespHash()) });
          this.iIW[i] = null;
          i += 1;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            ae.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bu.o(localRemoteException) });
          }
        }
      }
      finally
      {
        AppMethodBeat.o(132902);
      }
    }
    AppMethodBeat.o(132902);
  }
  
  static final class a
  {
    r iJa;
    l iJb;
    c iJc;
    long startTime;
    int taskId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.ac
 * JD-Core Version:    0.7.0.1
 */