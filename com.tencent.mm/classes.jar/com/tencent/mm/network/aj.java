package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.ICallBack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.o;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.i;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class aj
  implements StnLogic.ICallBack
{
  private static WakerLock hMQ = null;
  private static int hMR = 1000000205;
  private static int hMS = 205;
  private static byte[] hMT;
  private static byte[] hMU;
  
  private static int a(ByteArrayOutputStream paramByteArrayOutputStream1, ByteArrayOutputStream paramByteArrayOutputStream2)
  {
    AppMethodBeat.i(132958);
    if (ad.aFo() == null)
    {
      AppMethodBeat.o(132958);
      return 0;
    }
    try
    {
      byte[] arrayOfByte = ad.aFo().aEN();
      if (arrayOfByte != null)
      {
        paramByteArrayOutputStream1.write(arrayOfByte);
        hMT = arrayOfByte;
      }
      arrayOfByte = ad.aFo().gcD;
      if (arrayOfByte != null)
      {
        paramByteArrayOutputStream2.write(arrayOfByte);
        hMU = arrayOfByte;
      }
      int i = ad.aFo().hKZ.getUin();
      AppMethodBeat.o(132958);
      return i;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("StnCallBack", exception2String(localException));
      if ((hMT == null) || (hMU == null)) {}
    }
    try
    {
      paramByteArrayOutputStream1.write(hMT);
      paramByteArrayOutputStream2.write(hMU);
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
    if (ad.aFp() == null)
    {
      AppMethodBeat.o(132953);
      return -1;
    }
    try
    {
      paramInt1 = ad.aFp().a(paramInt1, paramArrayOfByte, paramArrayOfInt1, paramArrayOfInt2);
      AppMethodBeat.o(132953);
      return paramInt1;
    }
    catch (Exception paramObject)
    {
      com.tencent.mm.sdk.platformtools.ad.e("StnCallBack", exception2String(paramObject));
      new StringBuilder().append(paramObject.getClass().getSimpleName()).append(":").append(paramObject.getStackTrace()[0]).append(", ").append(paramObject.getStackTrace()[1]);
      AppMethodBeat.o(132953);
    }
    return -1;
  }
  
  public final int getLongLinkIdentifyCheckBuffer(String paramString, ByteArrayOutputStream paramByteArrayOutputStream1, ByteArrayOutputStream paramByteArrayOutputStream2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(192886);
    paramArrayOfInt[0] = hMS;
    paramArrayOfInt[1] = hMR;
    if ((a(paramByteArrayOutputStream1, paramByteArrayOutputStream2) == 0) || (paramByteArrayOutputStream1.size() == 0) || (paramByteArrayOutputStream2.size() == 0))
    {
      i = StnLogic.ECHECK_NEXT;
      AppMethodBeat.o(192886);
      return i;
    }
    int i = StnLogic.ECHECK_NOW;
    AppMethodBeat.o(192886);
    return i;
  }
  
  public final boolean isLogoned()
  {
    AppMethodBeat.i(132960);
    if (ad.aFo() == null)
    {
      AppMethodBeat.o(132960);
      return false;
    }
    try
    {
      boolean bool = ad.aFo().hKZ.ava();
      AppMethodBeat.o(132960);
      return bool;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("StnCallBack", exception2String(localException));
      new StringBuilder().append(localException.getClass().getSimpleName()).append(":").append(localException.getStackTrace()[0]).append(", ").append(localException.getStackTrace()[1]);
      AppMethodBeat.o(132960);
    }
    return false;
  }
  
  public final boolean makesureAuthed(String paramString)
  {
    AppMethodBeat.i(132950);
    if (ad.aFo() == null)
    {
      AppMethodBeat.o(132950);
      return false;
    }
    try
    {
      boolean bool = ad.aFo().Bb(paramString);
      AppMethodBeat.o(132950);
      return bool;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.e("StnCallBack", exception2String(paramString));
      new StringBuilder().append(paramString.getClass().getSimpleName()).append(":").append(paramString.getStackTrace()[0]).append(", ").append(paramString.getStackTrace()[1]);
      AppMethodBeat.o(132950);
    }
    return false;
  }
  
  public final void networkAnalysisCallBack(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(132961);
    com.tencent.mm.sdk.platformtools.ad.i("StnCallBack", "networkAnalysisCallBack: status:%d, stage:%d, isDetectEnd:%b, kvInfo:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), paramString });
    try
    {
      ad.aFo().hLh.networkAnalysisCallBack(paramInt1, paramInt2, paramBoolean, paramString);
      AppMethodBeat.o(132961);
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("StnCallBack", paramString, "", new Object[0]);
      new StringBuilder().append(paramString.getClass().getSimpleName()).append(":").append(paramString.getStackTrace()[0]).append(", ").append(paramString.getStackTrace()[1]);
      AppMethodBeat.o(132961);
    }
  }
  
  public final boolean onLongLinkIdentifyResp(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(192887);
    ByteArrayOutputStream localByteArrayOutputStream;
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null)) {
      localByteArrayOutputStream = new ByteArrayOutputStream();
    }
    try
    {
      localByteArrayOutputStream.write(paramArrayOfByte1);
      localByteArrayOutputStream.write(paramArrayOfByte2);
      label34:
      onPush(paramString, hMR, 0, localByteArrayOutputStream.toByteArray());
      AppMethodBeat.o(192887);
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
  
  public final void onPush(String paramString, final int paramInt1, int paramInt2, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(192885);
    if (ad.aFq() == null)
    {
      AppMethodBeat.o(192885);
      return;
    }
    try
    {
      if (hMQ == null) {
        hMQ = new WakerLock(ad.getContext(), "StnCallBack");
      }
      hMQ.lock(1000L, "StnLogic.onNotify");
      ad.aFm().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132946);
          ad.aFq().j(paramInt1, paramArrayOfByte);
          AppMethodBeat.o(132946);
        }
      });
      AppMethodBeat.o(192885);
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.e("StnCallBack", exception2String(paramString));
      new StringBuilder().append(paramString.getClass().getSimpleName()).append(":").append(paramString.getStackTrace()[0]).append(", ").append(paramString.getStackTrace()[1]);
      AppMethodBeat.o(192885);
    }
  }
  
  /* Error */
  public final int onTaskEnd(final int paramInt1, final Object paramObject, final int paramInt2, final int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 266
    //   3: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 120	com/tencent/mm/network/ad:aFp	()Lcom/tencent/mm/network/ac;
    //   9: ifnonnull +11 -> 20
    //   12: ldc_w 266
    //   15: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: iconst_0
    //   19: ireturn
    //   20: invokestatic 120	com/tencent/mm/network/ad:aFp	()Lcom/tencent/mm/network/ac;
    //   23: iload_1
    //   24: invokevirtual 270	com/tencent/mm/network/ac:po	(I)I
    //   27: istore 5
    //   29: invokestatic 254	com/tencent/mm/network/ad:aFm	()Lcom/tencent/mm/sdk/platformtools/ap;
    //   32: new 10	com/tencent/mm/network/aj$2
    //   35: dup
    //   36: aload_0
    //   37: iload_1
    //   38: aload_2
    //   39: iload_3
    //   40: iload 4
    //   42: invokespecial 273	com/tencent/mm/network/aj$2:<init>	(Lcom/tencent/mm/network/aj;ILjava/lang/Object;II)V
    //   45: invokevirtual 263	com/tencent/mm/sdk/platformtools/ap:post	(Ljava/lang/Runnable;)Z
    //   48: pop
    //   49: iload 5
    //   51: istore_1
    //   52: ldc_w 266
    //   55: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: iload_1
    //   59: ireturn
    //   60: astore_2
    //   61: iconst_0
    //   62: istore_1
    //   63: ldc 86
    //   65: aload_2
    //   66: invokestatic 90	com/tencent/mm/network/aj:exception2String	(Ljava/lang/Exception;)Ljava/lang/String;
    //   69: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: new 127	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   79: aload_2
    //   80: invokevirtual 132	java/lang/Object:getClass	()Ljava/lang/Class;
    //   83: invokevirtual 137	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   86: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 143
    //   91: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: invokevirtual 147	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   98: iconst_0
    //   99: aaload
    //   100: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: ldc 152
    //   105: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_2
    //   109: invokevirtual 147	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   112: iconst_1
    //   113: aaload
    //   114: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: goto -66 -> 52
    //   121: astore_2
    //   122: iload 5
    //   124: istore_1
    //   125: goto -62 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	aj
    //   0	128	1	paramInt1	int
    //   0	128	2	paramObject	Object
    //   0	128	3	paramInt2	int
    //   0	128	4	paramInt3	int
    //   27	96	5	i	int
    // Exception table:
    //   from	to	target	type
    //   20	29	60	java/lang/Exception
    //   29	49	121	java/lang/Exception
  }
  
  public final void reportConnectInfo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132955);
    try
    {
      ad.aFl().pr(paramInt1);
      com.tencent.mm.aq.a.nR(paramInt1);
      AppMethodBeat.o(132955);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("StnCallBack", "reportConnectInfo :%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132955);
    }
  }
  
  public final boolean req2Buf(int paramInt1, Object paramObject, ByteArrayOutputStream paramByteArrayOutputStream, int[] paramArrayOfInt, int paramInt2, String paramString)
  {
    AppMethodBeat.i(132952);
    if (ad.aFp() == null)
    {
      AppMethodBeat.o(132952);
      return false;
    }
    try
    {
      boolean bool = ad.aFp().a(paramInt1, paramByteArrayOutputStream, paramArrayOfInt, paramInt2, paramString);
      AppMethodBeat.o(132952);
      return bool;
    }
    catch (Exception paramObject)
    {
      com.tencent.mm.sdk.platformtools.ad.e("StnCallBack", exception2String(paramObject));
      new StringBuilder().append(paramObject.getClass().getSimpleName()).append(":").append(paramObject.getStackTrace()[0]).append(", ").append(paramObject.getStackTrace()[1]);
      AppMethodBeat.o(132952);
    }
    return false;
  }
  
  public final void requestDoSync()
  {
    AppMethodBeat.i(132959);
    if (ad.aFq() == null)
    {
      AppMethodBeat.o(132959);
      return;
    }
    try
    {
      ad.aFm().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132948);
          ad.aFq().j(24, o.hr(7));
          AppMethodBeat.o(132948);
        }
      });
      AppMethodBeat.o(132959);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("StnCallBack", exception2String(localException));
      new StringBuilder().append(localException.getClass().getSimpleName()).append(":").append(localException.getStackTrace()[0]).append(", ").append(localException.getStackTrace()[1]);
      AppMethodBeat.o(132959);
    }
  }
  
  public final String[] requestNetCheckShortLinkHosts()
  {
    return new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.aj
 * JD-Core Version:    0.7.0.1
 */