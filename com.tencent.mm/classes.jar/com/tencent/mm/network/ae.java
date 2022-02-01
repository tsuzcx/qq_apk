package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mars.Mars;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

public final class ae
{
  final a[] mwd;
  
  public ae()
  {
    AppMethodBeat.i(132894);
    this.mwd = new a[100];
    AppMethodBeat.o(132894);
  }
  
  static boolean xB(int paramInt)
  {
    return (paramInt == 10) || (paramInt == 268369922);
  }
  
  final int a(int paramInt, byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(132906);
    synchronized (this.mwd)
    {
      m = xD(paramInt);
      if (-1 == m)
      {
        AppMethodBeat.o(132906);
        return -1;
      }
      j = StnLogic.RESP_FAIL_HANDLE_DEFAULT;
      paramInt = j;
      i = j;
      try
      {
        byte[] arrayOfByte = this.mwd[m].mwh.biE().getPassKey();
        paramInt = j;
        i = j;
        l = this.mwd[m].mwh.biE().getECDHEngine();
        paramInt = j;
        i = j;
        locali = this.mwd[m].mwh.biF();
        paramInt = j;
        i = j;
        bool = locali.a(this.mwd[m].mwh.getType(), paramArrayOfByte, arrayOfByte, l);
        paramInt = j;
        i = j;
        if (!this.mwd[m].mwh.biE().useAxSession()) {
          break label877;
        }
        paramInt = j;
        i = j;
        Log.d("MicroMsg.MMNativeNetTaskAdapter", "axauth cgi is axcgi");
      }
      catch (RemoteException paramArrayOfByte)
      {
        for (;;)
        {
          try
          {
            boolean bool;
            paramArrayOfInt1[0] = locali.getRetCode();
            paramInt = j;
            i = j;
            paramArrayOfInt2 = this.mwd[m].mwh.getUri();
            int k = j;
            paramInt = j;
            i = j;
            if (locali.getRetCode() == -3800)
            {
              k = j;
              paramInt = j;
              i = j;
              if (this.mwd[m].mwh.biE().biD())
              {
                paramInt = j;
                i = j;
                Log.e("MicroMsg.MMNativeNetTaskAdapter", "ecdh decode failed 3800, ".concat(String.valueOf(paramArrayOfInt2)));
                paramInt = j;
                i = j;
                MMLogic.clearMMtlsForbidenHostAndPsk();
                paramInt = j;
                i = j;
                j = StnLogic.RESP_FAIL_HANDLE_ECDH_VERSON_MISMATCH;
                paramInt = j;
                i = j;
                paramArrayOfInt1[0] = locali.getRetCode();
                paramInt = j;
                i = j;
                f.Iyx.idkeyStat(148L, 58L, 1L, false);
                k = j;
              }
            }
            j = k;
            paramInt = k;
            i = k;
            if (!v.muG.isEmpty())
            {
              j = k;
              paramInt = k;
              i = k;
              if (paramArrayOfInt2.contains(v.muG))
              {
                paramInt = k;
                i = k;
                Log.i("MicroMsg.MMNativeNetTaskAdapter", "axauth cgi %s session time", new Object[] { paramArrayOfInt2 });
                paramInt = k;
                i = k;
                v.muG = "";
                paramInt = k;
                i = k;
                k = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                paramArrayOfInt1[0] = -13;
                j = k;
                paramInt = k;
                i = k;
                if (af.btU() != null)
                {
                  paramInt = k;
                  i = k;
                  af.btU().btp();
                  j = k;
                }
              }
            }
            paramInt = j;
            i = j;
            if (af.btY() != null)
            {
              paramInt = j;
              i = j;
              paramArrayOfInt1 = af.btY();
              paramInt = j;
              i = j;
              paramArrayOfInt2 = Util.nullAs(paramArrayOfInt2, "null");
              if (paramArrayOfByte == null) {
                break;
              }
              paramInt = j;
              i = j;
              l = paramArrayOfByte.length;
              paramInt = j;
              i = j;
              paramArrayOfInt1.J(paramArrayOfInt2, l);
            }
            paramInt = j;
            AppMethodBeat.o(132906);
            return paramInt;
            paramInt = j;
            i = j;
            Log.d("MicroMsg.MMNativeNetTaskAdapter", "axauth cgi is not axcgi");
            continue;
            paramArrayOfByte = paramArrayOfByte;
            f.Iyx.idkeyStat(162L, 5L, 1L, false);
            Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
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
              break label1117;
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
          f.Iyx.idkeyStat(162L, 7L, 1L, false);
          Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
          paramInt = i;
          continue;
          paramInt = j;
          i = j;
          j = StnLogic.RESP_FAIL_HANDLE_NORMAL;
        }
        paramInt = j;
        i = j;
        f.Iyx.idkeyStat(162L, 4L, 1L, false);
        paramInt = j;
        i = j;
        Log.e("MicroMsg.MMNativeNetTaskAdapter", "buf to resp failed, change server and try again");
        paramInt = j;
        i = j;
        if (af.btY() == null) {
          break label1224;
        }
        paramInt = j;
        i = j;
        paramArrayOfInt1 = af.btY();
        if (paramArrayOfByte == null) {
          break label1230;
        }
        paramInt = j;
        i = j;
        for (l = paramArrayOfByte.length;; l = 0L)
        {
          paramInt = j;
          i = j;
          paramArrayOfInt1.J("resp_fail", l);
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
        k = locali.getHeadExtFlags();
        paramArrayOfInt2[0] = 0;
        paramInt = j;
        i = j;
        j = locali.getRetCode();
        if ((k & 0x2) == 0)
        {
          paramArrayOfInt2[0] |= 0x2;
          paramInt = j;
          i = j;
          f.Iyx.idkeyStat(656L, 0L, 1L, false);
        }
        if ((k & 0x4) == 0)
        {
          paramArrayOfInt2[0] |= 0x4;
          paramInt = j;
          i = j;
          f.Iyx.idkeyStat(656L, 1L, 1L, false);
        }
        paramInt = j;
        i = j;
        if (locali.bip() != null)
        {
          paramInt = j;
          i = j;
          if (-13 == locali.getRetCode())
          {
            paramInt = j;
            i = j;
            if (this.mwd[m].mwh.biE().useAxSession())
            {
              paramInt = j;
              i = j;
              Log.w("MicroMsg.MMNativeNetTaskAdapter", "axsession cgi sessionkey timeout");
              paramInt = j;
              i = j;
              f.Iyx.idkeyStat(162L, 9L, 1L, false);
            }
            paramInt = j;
            i = j;
            if (af.btU() != null)
            {
              paramInt = j;
              i = j;
              af.btU().btp();
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
  
  public final int a(t paramt, n paramn, e parame, int paramInt)
  {
    AppMethodBeat.i(132901);
    if (paramt == null)
    {
      Log.e("MicroMsg.MMNativeNetTaskAdapter", "startTask  rr is null");
      AppMethodBeat.o(132901);
      return -1;
    }
    paramt.hashCode();
    StnLogic.Task localTask = new StnLogic.Task();
    a[] arrayOfa = this.mwd;
    int i = 0;
    if (i < 100) {}
    for (;;)
    {
      int j;
      try
      {
        if (this.mwd[i] == null)
        {
          this.mwd[i] = new a(0);
          this.mwd[i].mwh = paramt;
          this.mwd[i].mwi = paramn;
          this.mwd[i].mwj = parame;
          this.mwd[i].startTime = Util.nowMilliSecond();
          this.mwd[i].taskId = localTask.taskID;
          localTask.cmdID = paramt.biE().getCmdId();
          localTask.cgi = paramt.getUri();
          if (paramt.biH())
          {
            Log.i("MicroMsg.MMNativeNetTaskAdapter", "keep-alive for cgi=" + localTask.cgi);
            localTask.headers.put("Connection", "Keep-Alive");
          }
          j = paramt.getType();
          if ((paramt.getOptions() & 0x1) != 1)
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
            if ((j != 149) && (j != 193) && (j != 110) && (j != 220) && (j != 323) && (j != 324) && (j != 326) && (j != 327) && (j != 703) && (j != 2580) && (j != 3767) && (j != 4302) && (j != 4316) && (j != 4989)) {
              break label925;
            }
            localTask.limitFlow = false;
            break label925;
            localTask.limitFrequency = false;
            localTask.channelStrategy = 0;
            if ((j == 233) || (j == 835) || (j == 238)) {
              localTask.channelStrategy = 1;
            }
            localTask.sendOnly = false;
            if (xB(j)) {
              localTask.sendOnly = true;
            }
            if ((paramt.biE().getShortSupport()) && (paramt.getUri() != null) && (paramt.getUri().length() > 0)) {
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
              j = paramt.getTimeOut();
              if (j != 0) {
                localTask.totalTimeout = j;
              }
            }
            if (paramt.getIsLongPolling())
            {
              Log.i("MicroMsg.MMNativeNetTaskAdapter", "this is long-polling cgi");
              localTask.longPolling = true;
              localTask.longPollingTimeout = paramt.getLongPollingTimeout();
              j = paramt.getTimeOut();
              if (j != 0) {
                localTask.totalTimeout = j;
              }
              localTask.retryCount = 0;
            }
            Log.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi startTask inQueue netid:%d hash[%d,%d] net:%d cgi:%s needAuthed:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(localTask.taskID), Integer.valueOf(paramt.getMMReqRespHash()), Integer.valueOf(localTask.channelSelect), localTask.cgi, Boolean.valueOf(localTask.needAuthed) });
            if (-1 == i) {
              break label908;
            }
            if (paramInt == 1) {
              localTask.retryCount = 0;
            }
            StnLogic.startTask(localTask);
            Log.d("MicroMsg.MMNativeNetTaskAdapter", "startTask retsult=".concat(String.valueOf(i)));
            AppMethodBeat.o(132901);
            return i;
          }
          boolean bool = false;
          continue;
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
        i += 1;
        break;
      }
      finally
      {
        AppMethodBeat.o(132901);
      }
      label908:
      Log.e("MicroMsg.MMNativeNetTaskAdapter", "startTask err");
      continue;
      i = -1;
      continue;
      label925:
      if ((j != 703) && (j != 3767) && (j != 4302) && (j != 4316)) {
        if (j != 4989) {}
      }
    }
  }
  
  final boolean a(int paramInt1, ByteArrayOutputStream paramByteArrayOutputStream, int[] paramArrayOfInt, int paramInt2, String paramString)
  {
    AppMethodBeat.i(132905);
    for (;;)
    {
      int i;
      synchronized (this.mwd)
      {
        i = xD(paramInt1);
        if (-1 == i)
        {
          AppMethodBeat.o(132905);
          return false;
        }
        try
        {
          bool = this.mwd[i].mwj.Ub(paramString);
          Log.i("MicroMsg.MMNativeNetTaskAdapter", "link: %d req2Buf somr isfg:%b  cookie: %s, type: %d host[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(this.mwd[i].mwj.isForeground()), Util.encodeHexString(this.mwd[i].mwj.bip()), Integer.valueOf(this.mwd[i].mwh.getType()), paramString });
          paramInt1 = 1;
          if (!this.mwd[i].mwh.isSingleSession())
          {
            paramInt1 = 2;
            this.mwd[i].mwh.biE().setPassKey(this.mwd[i].mwj.sE(3));
            Log.i("MicroMsg.MMNativeNetTaskAdapter", "summerauths isSingleSession false type:[%s]", new Object[] { Integer.valueOf(this.mwd[i].mwh.getType()) });
          }
          if (!bool) {
            continue;
          }
          Log.i("MicroMsg.MMNativeNetTaskAdapter", "set axauth sessionkey ".concat(String.valueOf(paramString)));
          this.mwd[i].mwh.biE().setPassKey(this.mwd[i].mwj.Ua(paramString));
          localObject1 = this.mwd[i].mwj.TZ(paramString);
          localObject2 = this.mwd[i].mwj.TY(paramString);
          this.mwd[i].mwh.biE().setUseAxsession(true);
          if (localObject1 == null) {
            continue;
          }
          Log.i("MicroMsg.MMNativeNetTaskAdapter", "axauth sessionkey length[%d]", new Object[] { Integer.valueOf(localObject1.length) });
          if (localObject2 == null) {
            continue;
          }
          Log.i("MicroMsg.MMNativeNetTaskAdapter", "axauth cookie length[%d]", new Object[] { Integer.valueOf(localObject2.length) });
        }
        catch (RemoteException paramString)
        {
          Object localObject2;
          paramArrayOfInt[0] = 1;
          f.Iyx.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
          Log.e("MicroMsg.MMNativeNetTaskAdapter", "RemoteException:%s", new Object[] { Util.stackTraceToString(paramString) });
          bool = false;
          continue;
          Log.w("MicroMsg.MMNativeNetTaskAdapter", "axauth cookie is null");
          continue;
        }
        catch (IOException paramString)
        {
          paramArrayOfInt[0] = 2;
          f.Iyx.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
          Log.e("MicroMsg.MMNativeNetTaskAdapter", "IOException:%s", new Object[] { Util.stackTraceToString(paramString) });
          bool = false;
          continue;
          paramString = this.mwd[i].mwj.sE(paramInt1);
          Object localObject1 = this.mwd[i].mwj.bip();
          continue;
          paramArrayOfInt[0] = 0;
          f.Iyx.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
          Log.e("MicroMsg.MMNativeNetTaskAdapter", "request to buffer using jni failed");
          continue;
        }
        catch (Exception paramString)
        {
          paramArrayOfInt[0] = 3;
          f.Iyx.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
          Log.e("MicroMsg.MMNativeNetTaskAdapter", "Exception:%s", new Object[] { Util.stackTraceToString(paramString) });
          boolean bool = false;
          continue;
        }
        f.Iyx.idkeyStat(148L, 123L, 1L, false);
        paramString = (String)localObject1;
        localObject1 = localObject2;
        paramInt1 = 2;
        this.mwd[i].mwh.biE().setSessionKey(paramString);
        if (paramInt1 == 1)
        {
          paramInt2 = this.mwd[i].mwh.getType();
          if ((paramInt2 == 1000) || (paramInt2 == 502) || (paramInt2 == 930) || (paramInt2 == 503) || (paramInt2 == 654) || (paramInt2 == 755) || (paramInt2 == 931) || (paramInt2 == 733) || (paramInt2 == 784) || (paramInt2 == 722)) {
            break label1184;
          }
          if (paramInt2 != 627) {
            break label1190;
          }
          break label1184;
          if (paramInt2 == 0) {
            this.mwd[i].mwh.biE().setPassKey(null);
          }
        }
        if (this.mwd[i].mwh.getNewExtFlags() != 0)
        {
          paramInt2 = this.mwd[i].mwh.getNewExtFlags();
          this.mwd[i].mwh.biE().vI(paramInt2);
          localObject2 = this.mwd[i].mwh.getTransHeader();
          this.mwd[i].mwh.biE().ax((byte[])localObject2);
        }
        this.mwd[i].mwh.biE().setUin(this.mwd[i].mwj.getUin());
        localObject2 = this.mwd[i].mwh.biE();
        paramInt2 = this.mwd[i].mwh.getType();
        if (paramInt1 != 2) {
          break label1196;
        }
        paramInt1 = 13;
        bool = ((h)localObject2).a(paramInt2, paramString, paramInt1, (byte[])localObject1, this.mwd[i].mwj.bir(), 0, this.mwd[i].mwj.isForeground());
        if (bool) {
          paramByteArrayOutputStream.write(this.mwd[i].mwh.biE().biB());
        }
        try
        {
          if (af.btY() != null)
          {
            paramArrayOfInt = af.btY();
            paramInt1 = this.mwd[i].mwh.getType();
            if (paramByteArrayOutputStream == null) {
              break label1201;
            }
            l = paramByteArrayOutputStream.size();
            paramArrayOfInt.F(paramInt1, l);
          }
        }
        catch (Exception paramByteArrayOutputStream)
        {
          Log.e("MicroMsg.MMNativeNetTaskAdapter", "iDataPackageReporter Exception:%s", new Object[] { Util.stackTraceToString(paramByteArrayOutputStream) });
          continue;
        }
        Log.d("MicroMsg.MMNativeNetTaskAdapter", "req2Buf bOk: %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(132905);
        return bool;
        Log.w("MicroMsg.MMNativeNetTaskAdapter", "axauth axsessionkey is null");
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
  
  final boolean btH()
  {
    AppMethodBeat.i(132896);
    a[] arrayOfa = this.mwd;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      try
      {
        if (this.mwd[i] != null)
        {
          boolean bool = this.mwd[i].mwh.biE().isAxAuth();
          if (bool) {
            return true;
          }
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.mwd[i] = null;
        Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { Util.stackTraceToString(localRemoteException), Integer.valueOf(i) });
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
  
  final boolean btI()
  {
    AppMethodBeat.i(132897);
    a[] arrayOfa = this.mwd;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      try
      {
        if ((this.mwd[i] != null) && ((252 == this.mwd[i].mwh.getType()) || (701 == this.mwd[i].mwh.getType()) || (702 == this.mwd[i].mwh.getType()) || (763 == this.mwd[i].mwh.getType()) || (3941 == this.mwd[i].mwh.getType())))
        {
          Log.w("MicroMsg.MMNativeNetTaskAdapter", "hasAuthCmd Auth inQueue: netid=" + i + " type=" + this.mwd[i].mwh.getType());
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.mwd[i] = null;
        Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { Util.stackTraceToString(localRemoteException), Integer.valueOf(i) });
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
  
  final boolean btJ()
  {
    AppMethodBeat.i(132898);
    a[] arrayOfa = this.mwd;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      try
      {
        if ((this.mwd[i] != null) && (1000 == this.mwd[i].mwh.getType()))
        {
          Log.w("MicroMsg.MMNativeNetTaskAdapter", "hasWithoutLoginCmd inQueue: netid=" + i + " type=" + this.mwd[i].mwh.getType());
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.mwd[i] = null;
        Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { Util.stackTraceToString(localRemoteException), Integer.valueOf(i) });
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
  
  public final int btK()
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
        if (this.mwd[i] != null)
        {
          this.mwd[i].mwh.getType();
          k = j;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { Util.stackTraceToString(localRemoteException), Integer.valueOf(i) });
          k = j + 1;
          this.mwd[i] = null;
        }
      }
      i += 1;
    }
    label96:
    AppMethodBeat.o(132900);
    return j;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(132895);
    reset();
    super.finalize();
    AppMethodBeat.o(132895);
  }
  
  final t gN(boolean paramBoolean)
  {
    AppMethodBeat.i(132899);
    a[] arrayOfa = this.mwd;
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
          a locala = this.mwd[i];
          Object localObject3 = localObject1;
          if (locala == null) {
            break label315;
          }
          if (paramBoolean) {
            localObject3 = localObject1;
          }
          try
          {
            if ((this.mwd[i].mwh instanceof t.a)) {
              break label315;
            }
            if ((!paramBoolean) && (!(this.mwd[i].mwh instanceof t.a)))
            {
              localObject3 = localObject1;
              break label315;
            }
            if ((252 == this.mwd[i].mwh.getType()) || (701 == this.mwd[i].mwh.getType()) || (763 == this.mwd[i].mwh.getType()) || (702 == this.mwd[i].mwh.getType()) || (3941 == this.mwd[i].mwh.getType()))
            {
              Log.e("MicroMsg.MMNativeNetTaskAdapter", "getAutoAuthRR Auth inQueue: netid=" + i + " type=" + this.mwd[i].mwh.getType());
              return null;
            }
          }
          catch (RemoteException localRemoteException)
          {
            Log.w("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
            localObject4 = localObject1;
          }
          localObject4 = localt;
        }
        finally
        {
          AppMethodBeat.o(132899);
        }
        if (localt == null) {
          localObject4 = this.mwd[i].mwh;
        }
      }
      else
      {
        AppMethodBeat.o(132899);
        return localt;
      }
      i += 1;
    }
  }
  
  /* Error */
  public final void m(int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: ldc_w 554
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 86
    //   8: new 281	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 556
    //   15: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: iload_1
    //   19: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc_w 558
    //   25: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_2
    //   29: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc_w 560
    //   35: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_3
    //   39: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: invokestatic 563	com/tencent/mars/stn/StnLogic:clearTask	()V
    //   51: invokestatic 568	com/tencent/mars/Mars:currentCertVer	()I
    //   54: invokestatic 571	com/tencent/mars/stn/StnLogic:resetAndInitEncoderVersion	(I)V
    //   57: bipush 100
    //   59: anewarray 8	com/tencent/mm/network/ae$a
    //   62: astore 5
    //   64: aload_0
    //   65: getfield 24	com/tencent/mm/network/ae:mwd	[Lcom/tencent/mm/network/ae$a;
    //   68: astore 6
    //   70: aload 6
    //   72: monitorenter
    //   73: iconst_0
    //   74: istore 4
    //   76: iload 4
    //   78: bipush 100
    //   80: if_icmpge +32 -> 112
    //   83: aload 5
    //   85: iload 4
    //   87: aload_0
    //   88: getfield 24	com/tencent/mm/network/ae:mwd	[Lcom/tencent/mm/network/ae$a;
    //   91: iload 4
    //   93: aaload
    //   94: aastore
    //   95: aload_0
    //   96: getfield 24	com/tencent/mm/network/ae:mwd	[Lcom/tencent/mm/network/ae$a;
    //   99: iload 4
    //   101: aconst_null
    //   102: aastore
    //   103: iload 4
    //   105: iconst_1
    //   106: iadd
    //   107: istore 4
    //   109: goto -33 -> 76
    //   112: aload 6
    //   114: monitorexit
    //   115: iconst_0
    //   116: istore 4
    //   118: iload 4
    //   120: bipush 100
    //   122: if_icmpge +141 -> 263
    //   125: aload 5
    //   127: iload 4
    //   129: aaload
    //   130: ifnull +88 -> 218
    //   133: ldc 86
    //   135: ldc_w 573
    //   138: iconst_3
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: iload 4
    //   146: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload 5
    //   154: iload 4
    //   156: aaload
    //   157: getfield 51	com/tencent/mm/network/ae$a:mwh	Lcom/tencent/mm/network/t;
    //   160: invokeinterface 75 1 0
    //   165: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: aastore
    //   169: dup
    //   170: iconst_2
    //   171: aload 5
    //   173: iload 4
    //   175: aaload
    //   176: getfield 51	com/tencent/mm/network/ae$a:mwh	Lcom/tencent/mm/network/t;
    //   179: invokeinterface 385 1 0
    //   184: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   187: aastore
    //   188: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: aload 5
    //   193: iload 4
    //   195: aaload
    //   196: getfield 251	com/tencent/mm/network/ae$a:mwi	Lcom/tencent/mm/network/n;
    //   199: iload 4
    //   201: iload_1
    //   202: iload_2
    //   203: aload_3
    //   204: aload 5
    //   206: iload 4
    //   208: aaload
    //   209: getfield 51	com/tencent/mm/network/ae$a:mwh	Lcom/tencent/mm/network/t;
    //   212: aconst_null
    //   213: invokeinterface 578 7 0
    //   218: iload 4
    //   220: iconst_1
    //   221: iadd
    //   222: istore 4
    //   224: goto -106 -> 118
    //   227: astore_3
    //   228: aload 6
    //   230: monitorexit
    //   231: ldc_w 554
    //   234: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_3
    //   238: athrow
    //   239: astore 6
    //   241: ldc 86
    //   243: ldc 214
    //   245: iconst_1
    //   246: anewarray 4	java/lang/Object
    //   249: dup
    //   250: iconst_0
    //   251: aload 6
    //   253: invokestatic 218	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   256: aastore
    //   257: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: goto -42 -> 218
    //   263: ldc_w 554
    //   266: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	ae
    //   0	270	1	paramInt1	int
    //   0	270	2	paramInt2	int
    //   0	270	3	paramString	String
    //   74	149	4	i	int
    //   62	143	5	arrayOfa1	a[]
    //   68	161	6	arrayOfa2	a[]
    //   239	13	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   83	103	227	finally
    //   112	115	227	finally
    //   133	218	239	java/lang/Exception
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132902);
    Log.i("MicroMsg.MMNativeNetTaskAdapter", "reset");
    StnLogic.resetAndInitEncoderVersion(Mars.currentCertVer());
    a[] arrayOfa = this.mwd;
    int i = 0;
    while (i < 100) {
      try
      {
        a locala = this.mwd[i];
        if (locala != null) {}
        try
        {
          Log.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi reset outQueue: netId:%d hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mwd[i].mwh.getType()), Integer.valueOf(this.mwd[i].mwh.getMMReqRespHash()) });
          this.mwd[i] = null;
          i += 1;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
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
  
  final int xC(int paramInt)
  {
    AppMethodBeat.i(132904);
    synchronized (this.mwd)
    {
      paramInt = xD(paramInt);
      if (-1 == paramInt)
      {
        Log.e("MicroMsg.MMNativeNetTaskAdapter", "-1 == index");
        AppMethodBeat.o(132904);
        return 0;
      }
      try
      {
        paramInt = this.mwd[paramInt].mwh.biF().getRetCode();
        AppMethodBeat.o(132904);
        return paramInt;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        AppMethodBeat.o(132904);
        return 0;
      }
    }
  }
  
  final int xD(int paramInt)
  {
    int i = 0;
    while ((i < 100) && ((this.mwd[i] == null) || (paramInt != this.mwd[i].taskId))) {
      i += 1;
    }
    paramInt = i;
    if (100 <= i) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  static final class a
  {
    t mwh;
    n mwi;
    e mwj;
    long startTime;
    int taskId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.ae
 * JD-Core Version:    0.7.0.1
 */