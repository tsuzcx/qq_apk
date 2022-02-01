package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.CgiProfile;
import com.tencent.mars.stn.StnLogic.ICallBack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.o;
import com.tencent.mm.b.p;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class am
  implements StnLogic.ICallBack
{
  private static WakerLock pqe = null;
  private static int pqf = 1000000205;
  private static int pqg = 205;
  private static byte[] pqh;
  private static byte[] pqi;
  
  private static int a(ByteArrayOutputStream paramByteArrayOutputStream1, ByteArrayOutputStream paramByteArrayOutputStream2)
  {
    AppMethodBeat.i(132958);
    if (ag.bRx() == null)
    {
      AppMethodBeat.o(132958);
      return 0;
    }
    try
    {
      byte[] arrayOfByte = ag.bRx().bRa();
      if (arrayOfByte != null)
      {
        paramByteArrayOutputStream1.write(arrayOfByte);
        pqh = arrayOfByte;
      }
      arrayOfByte = ag.bRx().mCq;
      if (arrayOfByte != null)
      {
        paramByteArrayOutputStream2.write(arrayOfByte);
        pqi = arrayOfByte;
      }
      int i = ag.bRx().poh.getUin();
      AppMethodBeat.o(132958);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("StnCallBack", exception2String(localException));
      if ((pqh == null) || (pqi == null)) {}
    }
    try
    {
      paramByteArrayOutputStream1.write(pqh);
      paramByteArrayOutputStream2.write(pqi);
      label111:
      AppMethodBeat.o(132958);
      return 0;
    }
    catch (IOException paramByteArrayOutputStream1)
    {
      break label111;
    }
  }
  
  private static String exception2String(Exception paramException)
  {
    AppMethodBeat.i(132949);
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    paramException = localStringWriter.toString();
    AppMethodBeat.o(132949);
    return paramException;
  }
  
  public final int buf2Resp(int paramInt1, Object paramObject, byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    AppMethodBeat.i(132953);
    if (ag.bRy() == null)
    {
      AppMethodBeat.o(132953);
      return -1;
    }
    try
    {
      paramInt1 = ag.bRy().a(paramInt1, paramArrayOfByte, paramArrayOfInt1, paramArrayOfInt2);
      AppMethodBeat.o(132953);
      return paramInt1;
    }
    catch (Exception paramObject)
    {
      Log.e("StnCallBack", exception2String(paramObject));
      new StringBuilder().append(paramObject.getClass().getSimpleName()).append(":").append(paramObject.getStackTrace()[0]).append(", ").append(paramObject.getStackTrace()[1]);
      AppMethodBeat.o(132953);
    }
    return -1;
  }
  
  public final int getLongLinkIdentifyCheckBuffer(String paramString, ByteArrayOutputStream paramByteArrayOutputStream1, ByteArrayOutputStream paramByteArrayOutputStream2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(241132);
    paramArrayOfInt[0] = pqg;
    paramArrayOfInt[1] = pqf;
    if ((a(paramByteArrayOutputStream1, paramByteArrayOutputStream2) == 0) || (paramByteArrayOutputStream1.size() == 0) || (paramByteArrayOutputStream2.size() == 0))
    {
      i = StnLogic.ECHECK_NEXT;
      AppMethodBeat.o(241132);
      return i;
    }
    int i = StnLogic.ECHECK_NOW;
    AppMethodBeat.o(241132);
    return i;
  }
  
  public final boolean isLogoned()
  {
    AppMethodBeat.i(132960);
    if (ag.bRx() == null)
    {
      AppMethodBeat.o(132960);
      return false;
    }
    try
    {
      boolean bool = ag.bRx().poh.bGa();
      AppMethodBeat.o(132960);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("StnCallBack", exception2String(localException));
      new StringBuilder().append(localException.getClass().getSimpleName()).append(":").append(localException.getStackTrace()[0]).append(", ").append(localException.getStackTrace()[1]);
      AppMethodBeat.o(132960);
    }
    return false;
  }
  
  public final boolean makesureAuthed(String paramString)
  {
    AppMethodBeat.i(132950);
    if (ag.bRx() == null)
    {
      AppMethodBeat.o(132950);
      return false;
    }
    try
    {
      boolean bool = ag.bRx().Rw(paramString);
      AppMethodBeat.o(132950);
      return bool;
    }
    catch (Exception paramString)
    {
      Log.e("StnCallBack", exception2String(paramString));
      new StringBuilder().append(paramString.getClass().getSimpleName()).append(":").append(paramString.getStackTrace()[0]).append(", ").append(paramString.getStackTrace()[1]);
      AppMethodBeat.o(132950);
    }
    return false;
  }
  
  public final void networkAnalysisCallBack(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(132961);
    Log.i("StnCallBack", "networkAnalysisCallBack: status:%d, stage:%d, isDetectEnd:%b, kvInfo:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), paramString });
    try
    {
      ag.bRx().pop.networkAnalysisCallBack(paramInt1, paramInt2, paramBoolean, paramString);
      AppMethodBeat.o(132961);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("StnCallBack", paramString, "", new Object[0]);
      new StringBuilder().append(paramString.getClass().getSimpleName()).append(":").append(paramString.getStackTrace()[0]).append(", ").append(paramString.getStackTrace()[1]);
      AppMethodBeat.o(132961);
    }
  }
  
  public final boolean onLongLinkIdentifyResp(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(241136);
    ByteArrayOutputStream localByteArrayOutputStream;
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null)) {
      localByteArrayOutputStream = new ByteArrayOutputStream();
    }
    try
    {
      localByteArrayOutputStream.write(paramArrayOfByte1);
      localByteArrayOutputStream.write(paramArrayOfByte2);
      label34:
      onPush(paramString, pqf, 0, localByteArrayOutputStream.toByteArray());
      paramString = localByteArrayOutputStream.toByteArray();
      ag.bRx();
      w.aL(paramString);
      AppMethodBeat.o(241136);
      return true;
    }
    catch (IOException paramArrayOfByte1)
    {
      break label34;
    }
  }
  
  public final String[] onNewDns(String paramString)
  {
    return new String[0];
  }
  
  /* Error */
  public final void onPush(String paramString, final int paramInt1, int paramInt2, final byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 232
    //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 236	com/tencent/mm/network/ag:bRz	()Lcom/tencent/mm/network/ae;
    //   8: ifnonnull +9 -> 17
    //   11: ldc 232
    //   13: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: return
    //   17: getstatic 24	com/tencent/mm/network/am:pqe	Lcom/tencent/mars/comm/WakerLock;
    //   20: ifnonnull +18 -> 38
    //   23: new 238	com/tencent/mars/comm/WakerLock
    //   26: dup
    //   27: invokestatic 242	com/tencent/mm/network/ag:getContext	()Landroid/content/Context;
    //   30: ldc 86
    //   32: invokespecial 245	com/tencent/mars/comm/WakerLock:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   35: putstatic 24	com/tencent/mm/network/am:pqe	Lcom/tencent/mars/comm/WakerLock;
    //   38: getstatic 24	com/tencent/mm/network/am:pqe	Lcom/tencent/mars/comm/WakerLock;
    //   41: ldc2_w 246
    //   44: ldc 249
    //   46: invokevirtual 253	com/tencent/mars/comm/WakerLock:lock	(JLjava/lang/String;)V
    //   49: invokestatic 257	com/tencent/mm/network/ag:getHandler	()Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   52: new 8	com/tencent/mm/network/am$1
    //   55: dup
    //   56: aload_0
    //   57: iload_2
    //   58: aload 4
    //   60: invokespecial 260	com/tencent/mm/network/am$1:<init>	(Lcom/tencent/mm/network/am;I[B)V
    //   63: invokevirtual 266	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   66: pop
    //   67: invokestatic 270	com/tencent/mm/network/ag:bRB	()Lcom/tencent/mm/network/ag$a;
    //   70: ifnull +29 -> 99
    //   73: invokestatic 270	com/tencent/mm/network/ag:bRB	()Lcom/tencent/mm/network/ag$a;
    //   76: astore_1
    //   77: aload 4
    //   79: ifnull +88 -> 167
    //   82: aload 4
    //   84: arraylength
    //   85: i2l
    //   86: lstore 5
    //   88: aload_1
    //   89: ldc_w 272
    //   92: lload 5
    //   94: invokeinterface 278 4 0
    //   99: ldc 232
    //   101: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: return
    //   105: astore_1
    //   106: ldc 86
    //   108: aload_1
    //   109: invokestatic 90	com/tencent/mm/network/am:exception2String	(Ljava/lang/Exception;)Ljava/lang/String;
    //   112: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: new 127	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   122: aload_1
    //   123: invokevirtual 132	java/lang/Object:getClass	()Ljava/lang/Class;
    //   126: invokevirtual 137	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   129: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 143
    //   134: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 147	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   141: iconst_0
    //   142: aaload
    //   143: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: ldc 152
    //   148: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_1
    //   152: invokevirtual 147	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   155: iconst_1
    //   156: aaload
    //   157: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: ldc 232
    //   163: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: return
    //   167: lconst_0
    //   168: lstore 5
    //   170: goto -82 -> 88
    //   173: astore_1
    //   174: ldc 86
    //   176: ldc_w 280
    //   179: iconst_1
    //   180: anewarray 4	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload_1
    //   186: invokestatic 286	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   189: aastore
    //   190: invokestatic 288	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: ldc 232
    //   195: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	am
    //   0	199	1	paramString	String
    //   0	199	2	paramInt1	int
    //   0	199	3	paramInt2	int
    //   0	199	4	paramArrayOfByte	byte[]
    //   86	83	5	l	long
    // Exception table:
    //   from	to	target	type
    //   17	38	105	java/lang/Exception
    //   38	67	105	java/lang/Exception
    //   99	104	105	java/lang/Exception
    //   174	193	105	java/lang/Exception
    //   67	77	173	java/lang/Exception
    //   82	88	173	java/lang/Exception
    //   88	99	173	java/lang/Exception
  }
  
  public final int onTaskEnd(final int paramInt1, final Object paramObject, final int paramInt2, final int paramInt3, final StnLogic.CgiProfile paramCgiProfile)
  {
    AppMethodBeat.i(241124);
    if (ag.bRy() == null)
    {
      AppMethodBeat.o(241124);
      return 0;
    }
    Log.d("StnCallBack", "onTaskEnd " + paramCgiProfile.startConnectTime + " " + paramCgiProfile.readPacketFinishedTime + " " + paramCgiProfile.rtt + " " + paramCgiProfile.channelType + " " + paramCgiProfile.taskStartTime);
    i = 0;
    try
    {
      j = ag.bRy().xA(paramInt1);
      i = j;
      ag.getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132947);
          af localaf = ag.bRy();
          int i1 = paramInt1;
          int j = paramInt2;
          int m = paramInt3;
          Object localObject1 = paramCgiProfile;
          int i2;
          int i;
          int k;
          t localt;
          n localn;
          long l;
          Object localObject5;
          label452:
          break label1341;
          label572:
          int n;
          for (;;)
          {
            synchronized (localaf.ppC)
            {
              i2 = localaf.xB(i1);
              if (-1 == i2)
              {
                Log.e("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onGYNetEnd GET FROM QUEUE failed. native:[%d,%d] taskId:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(i1) });
                AppMethodBeat.o(132947);
                return;
              }
              i = 0;
              switch (j)
              {
              default: 
                Log.f("MicroMsg.MMNativeNetTaskAdapter", "c2JavaErrorType not exits c_errType:%d", new Object[] { Integer.valueOf(j) });
                break;
                k = i;
                j = m;
                if (!ag.bRu().ppU)
                {
                  k = i;
                  j = m;
                  if (i == 1)
                  {
                    Log.i("MicroMsg.MMNativeNetTaskAdapter", "network not available");
                    k = 2;
                    j = -1;
                  }
                }
                localt = localaf.ppC[i2].ppG;
                localn = localaf.ppC[i2].ppH;
                l = localaf.ppC[i2].startTime;
                localaf.ppC[i2] = null;
                localObject5 = new yf();
                ((yf)localObject5).taskStartTime = ((StnLogic.CgiProfile)localObject1).taskStartTime;
                ((yf)localObject5).startConnectTime = ((StnLogic.CgiProfile)localObject1).startConnectTime;
                ((yf)localObject5).connectSuccessfulTime = ((StnLogic.CgiProfile)localObject1).connectSuccessfulTime;
                ((yf)localObject5).startHandshakeTime = ((StnLogic.CgiProfile)localObject1).startHandshakeTime;
                ((yf)localObject5).handshakeSuccessfulTime = ((StnLogic.CgiProfile)localObject1).handshakeSuccessfulTime;
                ((yf)localObject5).startSendPacketTime = ((StnLogic.CgiProfile)localObject1).startSendPacketTime;
                ((yf)localObject5).startReadPacketTime = ((StnLogic.CgiProfile)localObject1).startReadPacketTime;
                ((yf)localObject5).readPacketFinishedTime = ((StnLogic.CgiProfile)localObject1).readPacketFinishedTime;
                ((yf)localObject5).rtt = ((StnLogic.CgiProfile)localObject1).rtt;
                ((yf)localObject5).channelType = ((StnLogic.CgiProfile)localObject1).channelType;
                ((yf)localObject5).getData();
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
                  localt.bGp().ay(((yf)localObject5).toByteArray());
                  if (k != 0) {
                    break label2558;
                  }
                  i = k;
                  try
                  {
                    if (af.xz(localt.getType())) {
                      break label2558;
                    }
                    i = k;
                    if (localt.bGp().getRetCode() == 0) {
                      break label2558;
                    }
                    i = 4;
                    k = localt.bGp().getRetCode();
                    j = 4;
                    i = k;
                  }
                  catch (RemoteException localRemoteException5)
                  {
                    for (;;)
                    {
                      w localw;
                      byte[] arrayOfByte;
                      i locali;
                      label651:
                      label652:
                      label791:
                      m = -1;
                      k = i;
                      i = m;
                    }
                  }
                  try
                  {
                    k = localt.getType();
                    try
                    {
                      localw = ag.bRx();
                      arrayOfByte = localt.bGp().bFZ();
                      try
                      {
                        Log.d("MicroMsg.MMAutoAuth", "summerauth onGYNetEnd threadId: 0 errType: " + j + " errCode: " + i + " errMsg: " + null + " rr: " + localt + " type: " + localt.getType() + " netIdGetCertBeforeAutoAuth: " + localw.pol);
                        if (i == 0) {
                          break label1036;
                        }
                        localw.poc += 1;
                        locali = localt.bGp();
                        m = localt.getType();
                        switch (m)
                        {
                        }
                      }
                      catch (RemoteException localRemoteException1)
                      {
                        Log.e("MicroMsg.MMAutoAuth", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException1) });
                        continue;
                      }
                      m = localt.getMMReqRespHash();
                      n = i;
                      i = k;
                      k = n;
                      Log.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi onTaskEnd type:%d time:%d hash[%d,%d] [%d,%d]", new Object[] { Integer.valueOf(i), Long.valueOf(Util.milliSecondsToNow(l)), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k) });
                      if ((4 == j) && ((-1 == k) || (-2 == k) || (-24 == k) || (-34 == k))) {
                        ag.getHandler().post(new af.1(localaf, i, k));
                      }
                      if (localt != null) {
                        break label2260;
                      }
                      Log.w("MicroMsg.MMNativeNetTaskAdapter", "rr is null");
                      try
                      {
                        localObject1 = localt.bGp().getErrMsg();
                        if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
                          break label2487;
                        }
                        localn.a(i2, j, k, (String)localObject1, localt, localt.bGp().bFZ());
                        AppMethodBeat.o(132947);
                        return;
                      }
                      catch (Exception localException1)
                      {
                        Log.e("MicroMsg.MMNativeNetTaskAdapter", "onGYNetEnd cb %s", new Object[] { localException1.getMessage() });
                        Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", new Object[] { Util.stackTraceToString(localException1), Integer.valueOf(i1) });
                        AppMethodBeat.o(132947);
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
                    break label1094;
                    m = i;
                    n = j;
                    break label2223;
                  }
                  i = 2;
                  break;
                  i = 1;
                  break;
                  i = 1;
                  break;
                  i = 1;
                  break;
                  i = 1;
                  break;
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
                    break;
                    i = 4;
                    break;
                    i = 1;
                  }
                }
                catch (Exception localException2)
                {
                  for (;;)
                  {
                    Log.e("MicroMsg.MMNativeNetTaskAdapter", "set profile failed " + localException2.getLocalizedMessage());
                  }
                }
              }
            }
            label1036:
            if (localt.getType() == 10) {
              break label572;
            }
            localw.poc = 0;
            break label572;
            label1094:
            Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s taskid:%d", new Object[] { Util.stackTraceToString(localRemoteException2), Integer.valueOf(i1) });
            m = 0;
            n = j;
            j = k;
            k = n;
            continue;
            Log.i("MicroMsg.MMAutoAuth", "summerauth end type: %d, ret:[%d,%d][%s]", new Object[] { Integer.valueOf(localt.getType()), Integer.valueOf(j), Integer.valueOf(i), null });
            if ((locali.getRetCode() == 0) && (j == 0) && (i == 0)) {
              break label1365;
            }
            if (localt.getType() != 126) {
              break label2583;
            }
            Log.e("MicroMsg.MMAutoAuth", "net.end: reg err: type=" + localt.getType() + " err=" + j + "," + i + " errmsg=" + null);
            continue;
            MMApplicationContext.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
            if (i != -213) {
              break label2631;
            }
            f.Ozc.idkeyStat(148L, 31L, 1L, false);
          }
          for (;;)
          {
            for (;;)
            {
              f.Ozc.idkeyStat(148L, 32L, 1L, false);
              break;
              label1341:
              if (i != -205) {
                break;
              }
              f.Ozc.idkeyStat(148L, 33L, 1L, false);
              break;
              label1365:
              m = localt.bGq();
              Log.i("MicroMsg.MMAutoAuth", "summerauth accinfo doAuthEnd type:%d, ret:%d loginDecodeFailedTry:%d", new Object[] { Integer.valueOf(localt.getType()), Integer.valueOf(m), Integer.valueOf(localw.oSL) });
              Object localObject4;
              if (m == 2)
              {
                if ((localt.getType() != 702) && (localt.getType() != 763)) {
                  break;
                }
                f.Ozc.idkeyStat(148L, 34L, 1L, false);
                localw.oSL += 1;
                if (localw.oSL > 1)
                {
                  Log.w("MicroMsg.MMAutoAuth", "summerauth loginDecodeFailedTry beyond 1 no more try!");
                  localw.m(j, i, "auth_decode_failed_" + Util.nullAs(null, ""));
                  break;
                }
                for (;;)
                {
                  try
                  {
                    m = locali.getUin();
                    Object localObject3 = locali.bGs();
                    if (Util.isNullOrNil((byte[])localObject3))
                    {
                      localObject3 = "";
                      if (!Util.isNullOrNil(arrayOfByte)) {
                        break label1666;
                      }
                      localObject5 = "";
                      if (!localw.t((String)localObject3, (String)localObject5, m)) {
                        break label1676;
                      }
                      localw.poh.ieJ = arrayOfByte;
                      localt.a(localw.poi, 0, 0);
                    }
                  }
                  catch (RemoteException localRemoteException3)
                  {
                    Log.printErrStackTrace("MicroMsg.MMAutoAuth", localRemoteException3, "summerauth save serverid aak failed 1 cookie:" + Util.encodeHexString(arrayOfByte), new Object[0]);
                    Log.appenderFlush();
                    AppMethodBeat.o(132947);
                    throw localRemoteException3;
                  }
                  localObject4 = Util.encodeHexString(localRemoteException3);
                  continue;
                  label1666:
                  localObject5 = Util.encodeHexString(arrayOfByte);
                  continue;
                  label1676:
                  Log.w("MicroMsg.MMAutoAuth", "summerauth save serverid aak failed 1");
                }
              }
              localw.oSL = 0;
              h localh = localt.bGo();
              for (;;)
              {
                try
                {
                  for (;;)
                  {
                    Log.i("MicroMsg.MMAutoAuth", "summerauth accinfo %d: username:%s, wxusername:%s, ticket:%s, single session: %s client session:%s, server session:%s uin:%d", new Object[] { Integer.valueOf(localt.getType()), localh.getUserName(), locali.bGc(), Util.secPrint(Util.dumpHex(locali.bGs())), Util.secPrint(Util.dumpHex(locali.sA(1))), Util.secPrint(Util.dumpHex(locali.sA(2))), Util.secPrint(Util.dumpHex(locali.sA(3))), Integer.valueOf(locali.getUin()) });
                    m = locali.getUin();
                    localObject4 = locali.bGs();
                    if (Util.isNullOrNil((byte[])localObject4))
                    {
                      localObject4 = "";
                      label1861:
                      if (!Util.isNullOrNil(arrayOfByte)) {
                        break label2031;
                      }
                      localObject5 = "";
                      if (!localw.t((String)localObject4, (String)localObject5, m)) {
                        break label2101;
                      }
                      localw.poh.ieJ = arrayOfByte;
                      localw.poh.username = localh.getUserName();
                      localw.poh.hLv = locali.bGc();
                      localw.poh.a(locali.sA(1), locali.sA(2), locali.sA(3), locali.getUin());
                      localw.poh.pnp = locali.bGb();
                    }
                    try
                    {
                      localw.aM(locali.getAuthResponse());
                      CrashReportFactory.setReportID(p.getString(locali.getUin()));
                      StnLogic.touchTasks();
                      Log.i("MicroMsg.MMAutoAuth", "summerauth decode and save ok!");
                      break;
                      localObject4 = Util.encodeHexString((byte[])localObject4);
                      break label1861;
                      label2031:
                      localObject5 = Util.encodeHexString(arrayOfByte);
                    }
                    catch (Exception localException3)
                    {
                      for (;;)
                      {
                        Log.e("MicroMsg.MMAutoAuth", localException3.getLocalizedMessage());
                      }
                    }
                  }
                  f.Ozc.idkeyStat(148L, 35L, 1L, false);
                }
                catch (RemoteException localRemoteException4)
                {
                  Log.printErrStackTrace("MicroMsg.MMAutoAuth", localRemoteException4, "summerauth save serverid aak failed 2 cookie:" + Util.encodeHexString(arrayOfByte), new Object[0]);
                  Log.appenderFlush();
                  AppMethodBeat.o(132947);
                  throw localRemoteException4;
                }
                label2101:
                Log.w("MicroMsg.MMAutoAuth", "summerauth save serverid aak failed 2");
              }
              if ((j == 0) && (i == 0))
              {
                ac.aM(localt.bGp().bGt(), localt.bGp().bGu(), localt.bGp().bGv());
                localw.pok = SystemClock.elapsedRealtime();
              }
              if ((z.pCm != 10003) || (z.pCn <= 0)) {
                break label2549;
              }
              if (z.pCn <= 1) {
                z.pCn = 0;
              }
              n = 4;
              m = 0;
              ac.aM("", "", 0);
              label2223:
              if (localw.pol == -1) {
                break;
              }
              if ((n == 0) && (m == 0)) {
                localw.a(localt, 0, 0);
              }
              localw.pol = -1;
              break;
              try
              {
                label2260:
                i = localt.getType();
                if ((i != 763) && (i != 702) && (i != 252) && (i != 701) && (i != 3941) && (i != 126)) {
                  break label791;
                }
                String str = localt.getCgiVerifyPublicKey();
                localObject5 = localt.getCgiVerifyPrivateKey();
                if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject5))) {
                  break label2417;
                }
                Log.w("MicroMsg.MMNativeNetTaskAdapter", "public or private key is null " + TextUtils.isEmpty(str) + " " + TextUtils.isEmpty((CharSequence)localObject5));
              }
              catch (Exception localException4)
              {
                Log.w("MicroMsg.MMNativeNetTaskAdapter", "save cgi verify key error " + localException4.getLocalizedMessage());
              }
            }
            break label791;
            label2417:
            if (ag.bRx() != null)
            {
              Log.i("MicroMsg.MMNativeNetTaskAdapter", "save cgi key " + localException4.length() + " " + ((String)localObject5).length());
              ag.bRx().bY(localException4, (String)localObject5);
              break label791;
            }
            Log.w("MicroMsg.MMNativeNetTaskAdapter", "MMPushCore.getAutoAuth() is null");
            break label791;
            label2487:
            localn.a(i2, j, k, null, localt, localt.bGp().bFZ());
            AppMethodBeat.o(132947);
            return;
            label2549:
            label2558:
            i = j;
            j = k;
            break label452;
            if (i == 0) {
              m = 0;
            }
            if (i != 3) {
              break;
            }
            m = -1;
            break;
            label2583:
            switch (i)
            {
            }
            break label652;
            label2631:
            if (i != -100) {
              if (i != -2023) {
                break label651;
              }
            }
          }
        }
      });
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        Log.e("StnCallBack", exception2String(paramObject));
        new StringBuilder().append(paramObject.getClass().getSimpleName()).append(":").append(paramObject.getStackTrace()[0]).append(", ").append(paramObject.getStackTrace()[1]);
        int j = i;
      }
    }
    AppMethodBeat.o(241124);
    return j;
  }
  
  public final void reportConnectInfo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132955);
    try
    {
      ag.bRv().networkChange(paramInt1);
      com.tencent.mm.aq.a.wc(paramInt1);
      AppMethodBeat.o(132955);
      return;
    }
    catch (Exception localException)
    {
      Log.e("StnCallBack", "reportConnectInfo :%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132955);
    }
  }
  
  public final boolean req2Buf(int paramInt1, Object paramObject, ByteArrayOutputStream paramByteArrayOutputStream, int[] paramArrayOfInt, int paramInt2, String paramString)
  {
    AppMethodBeat.i(132952);
    if (ag.bRy() == null)
    {
      AppMethodBeat.o(132952);
      return false;
    }
    try
    {
      boolean bool = ag.bRy().a(paramInt1, paramByteArrayOutputStream, paramArrayOfInt, paramInt2, paramString);
      AppMethodBeat.o(132952);
      return bool;
    }
    catch (Exception paramObject)
    {
      Log.e("StnCallBack", exception2String(paramObject));
      new StringBuilder().append(paramObject.getClass().getSimpleName()).append(":").append(paramObject.getStackTrace()[0]).append(", ").append(paramObject.getStackTrace()[1]);
      AppMethodBeat.o(132952);
    }
    return false;
  }
  
  public final void requestDoSync()
  {
    AppMethodBeat.i(132959);
    if (ag.bRz() == null)
    {
      AppMethodBeat.o(132959);
      return;
    }
    try
    {
      ag.getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132948);
          ag.bRz().k(24, o.nE(7));
          AppMethodBeat.o(132948);
        }
      });
      AppMethodBeat.o(132959);
      return;
    }
    catch (Exception localException)
    {
      Log.e("StnCallBack", exception2String(localException));
      new StringBuilder().append(localException.getClass().getSimpleName()).append(":").append(localException.getStackTrace()[0]).append(", ").append(localException.getStackTrace()[1]);
      AppMethodBeat.o(132959);
    }
  }
  
  public final String[] requestNetCheckShortLinkHosts()
  {
    return new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.am
 * JD-Core Version:    0.7.0.1
 */