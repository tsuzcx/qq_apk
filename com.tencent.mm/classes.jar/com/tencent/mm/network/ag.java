package com.tencent.mm.network;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.ICallBack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class ag
  implements StnLogic.ICallBack
{
  private static WakerLock geV = null;
  private static int geW = 1000000205;
  private static int geX = 205;
  private static byte[] geY;
  private static byte[] geZ;
  
  private static int a(ByteArrayOutputStream paramByteArrayOutputStream1, ByteArrayOutputStream paramByteArrayOutputStream2)
  {
    AppMethodBeat.i(58708);
    if (ab.anF() == null)
    {
      AppMethodBeat.o(58708);
      return 0;
    }
    try
    {
      byte[] arrayOfByte = ab.anF().ann();
      if (arrayOfByte != null)
      {
        paramByteArrayOutputStream1.write(arrayOfByte);
        geY = arrayOfByte;
      }
      arrayOfByte = ab.anF().eHy;
      if (arrayOfByte != null)
      {
        paramByteArrayOutputStream2.write(arrayOfByte);
        geZ = arrayOfByte;
      }
      int i = ab.anF().gdz.getUin();
      AppMethodBeat.o(58708);
      return i;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.e("StnCallBack", exception2String(localException));
      if ((geY == null) || (geZ == null)) {}
    }
    try
    {
      paramByteArrayOutputStream1.write(geY);
      paramByteArrayOutputStream2.write(geZ);
      label111:
      AppMethodBeat.o(58708);
      return 0;
    }
    catch (IOException paramByteArrayOutputStream1)
    {
      break label111;
    }
  }
  
  private static String exception2String(Exception paramException)
  {
    AppMethodBeat.i(58699);
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    paramException = localStringWriter.toString();
    AppMethodBeat.o(58699);
    return paramException;
  }
  
  public final int buf2Resp(int paramInt1, Object paramObject, byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    AppMethodBeat.i(58703);
    if (ab.anG() == null)
    {
      AppMethodBeat.o(58703);
      return -1;
    }
    try
    {
      paramInt1 = ab.anG().a(paramInt1, paramArrayOfByte, paramArrayOfInt1, paramArrayOfInt2);
      AppMethodBeat.o(58703);
      return paramInt1;
    }
    catch (Exception paramObject)
    {
      com.tencent.mm.sdk.platformtools.ab.e("StnCallBack", exception2String(paramObject));
      new StringBuilder().append(paramObject.getClass().getSimpleName()).append(":").append(paramObject.getStackTrace()[0]).append(", ").append(paramObject.getStackTrace()[1]);
      AppMethodBeat.o(58703);
    }
    return -1;
  }
  
  public final int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream paramByteArrayOutputStream1, ByteArrayOutputStream paramByteArrayOutputStream2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(58706);
    paramArrayOfInt[0] = geX;
    paramArrayOfInt[1] = geW;
    if ((a(paramByteArrayOutputStream1, paramByteArrayOutputStream2) == 0) || (paramByteArrayOutputStream1.size() == 0) || (paramByteArrayOutputStream2.size() == 0))
    {
      i = StnLogic.ECHECK_NEXT;
      AppMethodBeat.o(58706);
      return i;
    }
    int i = StnLogic.ECHECK_NOW;
    AppMethodBeat.o(58706);
    return i;
  }
  
  public final boolean isLogoned()
  {
    AppMethodBeat.i(58710);
    if (ab.anF() == null)
    {
      AppMethodBeat.o(58710);
      return false;
    }
    try
    {
      boolean bool = ab.anF().gdz.adC();
      AppMethodBeat.o(58710);
      return bool;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.e("StnCallBack", exception2String(localException));
      new StringBuilder().append(localException.getClass().getSimpleName()).append(":").append(localException.getStackTrace()[0]).append(", ").append(localException.getStackTrace()[1]);
      AppMethodBeat.o(58710);
    }
    return false;
  }
  
  public final boolean makesureAuthed(String paramString)
  {
    AppMethodBeat.i(154762);
    if (ab.anF() == null)
    {
      AppMethodBeat.o(154762);
      return false;
    }
    try
    {
      boolean bool = ab.anF().wd(paramString);
      AppMethodBeat.o(154762);
      return bool;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ab.e("StnCallBack", exception2String(paramString));
      new StringBuilder().append(paramString.getClass().getSimpleName()).append(":").append(paramString.getStackTrace()[0]).append(", ").append(paramString.getStackTrace()[1]);
      AppMethodBeat.o(154762);
    }
    return false;
  }
  
  public final void networkAnalysisCallBack(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(58711);
    com.tencent.mm.sdk.platformtools.ab.i("StnCallBack", "networkAnalysisCallBack: status:%d, stage:%d, isDetectEnd:%b, kvInfo:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), paramString });
    try
    {
      ab.anF().gdH.networkAnalysisCallBack(paramInt1, paramInt2, paramBoolean, paramString);
      AppMethodBeat.o(58711);
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("StnCallBack", paramString, "", new Object[0]);
      new StringBuilder().append(paramString.getClass().getSimpleName()).append(":").append(paramString.getStackTrace()[0]).append(", ").append(paramString.getStackTrace()[1]);
      AppMethodBeat.o(58711);
    }
  }
  
  public final boolean onLongLinkIdentifyResp(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(58707);
    ByteArrayOutputStream localByteArrayOutputStream;
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null)) {
      localByteArrayOutputStream = new ByteArrayOutputStream();
    }
    try
    {
      localByteArrayOutputStream.write(paramArrayOfByte1);
      localByteArrayOutputStream.write(paramArrayOfByte2);
      label31:
      onPush(geW, localByteArrayOutputStream.toByteArray());
      AppMethodBeat.o(58707);
      return true;
    }
    catch (IOException paramArrayOfByte1)
    {
      break label31;
    }
  }
  
  public final String[] onNewDns(String paramString)
  {
    return new String[0];
  }
  
  public final void onPush(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58701);
    if (ab.anH() == null)
    {
      AppMethodBeat.o(58701);
      return;
    }
    try
    {
      if (geV == null) {
        geV = new WakerLock(ab.getContext(), "StnCallBack");
      }
      geV.lock(1000L, "StnLogic.onNotify");
      ab.anD().post(new ag.1(this, paramInt, paramArrayOfByte));
      AppMethodBeat.o(58701);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      com.tencent.mm.sdk.platformtools.ab.e("StnCallBack", exception2String(paramArrayOfByte));
      new StringBuilder().append(paramArrayOfByte.getClass().getSimpleName()).append(":").append(paramArrayOfByte.getStackTrace()[0]).append(", ").append(paramArrayOfByte.getStackTrace()[1]);
      AppMethodBeat.o(58701);
    }
  }
  
  /* Error */
  public final int onTaskEnd(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 262
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 114	com/tencent/mm/network/ab:anG	()Lcom/tencent/mm/network/aa;
    //   9: ifnonnull +11 -> 20
    //   12: ldc_w 262
    //   15: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: iconst_0
    //   19: ireturn
    //   20: invokestatic 114	com/tencent/mm/network/ab:anG	()Lcom/tencent/mm/network/aa;
    //   23: iload_1
    //   24: invokevirtual 266	com/tencent/mm/network/aa:mz	(I)I
    //   27: istore 5
    //   29: invokestatic 248	com/tencent/mm/network/ab:anD	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   32: new 268	com/tencent/mm/network/ag$2
    //   35: dup
    //   36: aload_0
    //   37: iload_1
    //   38: aload_2
    //   39: iload_3
    //   40: iload 4
    //   42: invokespecial 271	com/tencent/mm/network/ag$2:<init>	(Lcom/tencent/mm/network/ag;ILjava/lang/Object;II)V
    //   45: invokevirtual 259	com/tencent/mm/sdk/platformtools/ak:post	(Ljava/lang/Runnable;)Z
    //   48: pop
    //   49: iload 5
    //   51: istore_1
    //   52: ldc_w 262
    //   55: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: iload_1
    //   59: ireturn
    //   60: astore_2
    //   61: iconst_0
    //   62: istore_1
    //   63: ldc 80
    //   65: aload_2
    //   66: invokestatic 84	com/tencent/mm/network/ag:exception2String	(Ljava/lang/Exception;)Ljava/lang/String;
    //   69: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: new 121	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   79: aload_2
    //   80: invokevirtual 126	java/lang/Object:getClass	()Ljava/lang/Class;
    //   83: invokevirtual 131	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   86: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 137
    //   91: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: invokevirtual 141	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   98: iconst_0
    //   99: aaload
    //   100: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: ldc 146
    //   105: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_2
    //   109: invokevirtual 141	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   112: iconst_1
    //   113: aaload
    //   114: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: goto -66 -> 52
    //   121: astore_2
    //   122: iload 5
    //   124: istore_1
    //   125: goto -62 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	ag
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
    AppMethodBeat.i(58705);
    try
    {
      ab.anC().mC(paramInt1);
      com.tencent.mm.an.a.lk(paramInt1);
      AppMethodBeat.o(58705);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.e("StnCallBack", "reportConnectInfo :%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(58705);
    }
  }
  
  public final boolean req2Buf(int paramInt1, Object paramObject, ByteArrayOutputStream paramByteArrayOutputStream, int[] paramArrayOfInt, int paramInt2, String paramString)
  {
    AppMethodBeat.i(154763);
    if (ab.anG() == null)
    {
      AppMethodBeat.o(154763);
      return false;
    }
    try
    {
      boolean bool = ab.anG().a(paramInt1, paramByteArrayOutputStream, paramArrayOfInt, paramInt2, paramString);
      AppMethodBeat.o(154763);
      return bool;
    }
    catch (Exception paramObject)
    {
      com.tencent.mm.sdk.platformtools.ab.e("StnCallBack", exception2String(paramObject));
      new StringBuilder().append(paramObject.getClass().getSimpleName()).append(":").append(paramObject.getStackTrace()[0]).append(", ").append(paramObject.getStackTrace()[1]);
      AppMethodBeat.o(154763);
    }
    return false;
  }
  
  public final void requestDoSync()
  {
    AppMethodBeat.i(58709);
    if (ab.anH() == null)
    {
      AppMethodBeat.o(58709);
      return;
    }
    try
    {
      ab.anD().post(new ag.3(this));
      AppMethodBeat.o(58709);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.e("StnCallBack", exception2String(localException));
      new StringBuilder().append(localException.getClass().getSimpleName()).append(":").append(localException.getStackTrace()[0]).append(", ").append(localException.getStackTrace()[1]);
      AppMethodBeat.o(58709);
    }
  }
  
  public final String[] requestNetCheckShortLinkHosts()
  {
    return new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.network.ag
 * JD-Core Version:    0.7.0.1
 */