package com.tencent.mm.network;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.ICallBack;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class af
  implements StnLogic.ICallBack
{
  private static WakerLock ePi = null;
  private static int ePj = 1000000205;
  private static int ePk = 205;
  private static byte[] ePl;
  private static byte[] ePm;
  
  private static int a(ByteArrayOutputStream paramByteArrayOutputStream1, ByteArrayOutputStream paramByteArrayOutputStream2)
  {
    if (aa.Uu() == null) {}
    do
    {
      return 0;
      try
      {
        byte[] arrayOfByte = aa.Uu().Ua();
        if (arrayOfByte != null)
        {
          paramByteArrayOutputStream1.write(arrayOfByte);
          ePl = arrayOfByte;
        }
        arrayOfByte = aa.Uu().dKa;
        if (arrayOfByte != null)
        {
          paramByteArrayOutputStream2.write(arrayOfByte);
          ePm = arrayOfByte;
        }
        int i = aa.Uu().eNL.CK();
        return i;
      }
      catch (Exception localException)
      {
        y.e("StnCallBack", exception2String(localException));
      }
    } while ((ePl == null) || (ePm == null));
    try
    {
      paramByteArrayOutputStream1.write(ePl);
      paramByteArrayOutputStream2.write(ePm);
      return 0;
    }
    catch (IOException paramByteArrayOutputStream1) {}
    return 0;
  }
  
  private static String exception2String(Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public final int buf2Resp(int paramInt1, Object paramObject, byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    if (aa.Uv() == null) {
      return -1;
    }
    try
    {
      paramInt1 = aa.Uv().a(paramInt1, paramArrayOfByte, paramArrayOfInt1, paramArrayOfInt2);
      return paramInt1;
    }
    catch (Exception paramObject)
    {
      y.e("StnCallBack", exception2String(paramObject));
      new StringBuilder().append(paramObject.getClass().getSimpleName()).append(":").append(paramObject.getStackTrace()[0]).append(", ").append(paramObject.getStackTrace()[1]);
    }
    return -1;
  }
  
  public final int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream paramByteArrayOutputStream1, ByteArrayOutputStream paramByteArrayOutputStream2, int[] paramArrayOfInt)
  {
    paramArrayOfInt[0] = ePk;
    paramArrayOfInt[1] = ePj;
    if ((a(paramByteArrayOutputStream1, paramByteArrayOutputStream2) == 0) || (paramByteArrayOutputStream1.size() == 0) || (paramByteArrayOutputStream2.size() == 0))
    {
      requestDoSync();
      return StnLogic.ECHECK_NEXT;
    }
    return StnLogic.ECHECK_NOW;
  }
  
  public final boolean isLogoned()
  {
    if (aa.Uu() == null) {
      return false;
    }
    try
    {
      boolean bool = aa.Uu().eNL.KN();
      return bool;
    }
    catch (Exception localException)
    {
      y.e("StnCallBack", exception2String(localException));
      new StringBuilder().append(localException.getClass().getSimpleName()).append(":").append(localException.getStackTrace()[0]).append(", ").append(localException.getStackTrace()[1]);
    }
    return false;
  }
  
  public final boolean makesureAuthed()
  {
    if (aa.Uu() == null) {
      return false;
    }
    try
    {
      boolean bool = aa.Uu().TZ();
      return bool;
    }
    catch (Exception localException)
    {
      y.e("StnCallBack", exception2String(localException));
      new StringBuilder().append(localException.getClass().getSimpleName()).append(":").append(localException.getStackTrace()[0]).append(", ").append(localException.getStackTrace()[1]);
    }
    return false;
  }
  
  public final void networkAnalysisCallBack(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    y.i("StnCallBack", "networkAnalysisCallBack: status:%d, stage:%d, isDetectEnd:%b, kvInfo:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), paramString });
    try
    {
      aa.Uu().eNT.networkAnalysisCallBack(paramInt1, paramInt2, paramBoolean, paramString);
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("StnCallBack", paramString, "", new Object[0]);
      new StringBuilder().append(paramString.getClass().getSimpleName()).append(":").append(paramString.getStackTrace()[0]).append(", ").append(paramString.getStackTrace()[1]);
    }
  }
  
  public final boolean onLongLinkIdentifyResp(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null)) {
      localByteArrayOutputStream = new ByteArrayOutputStream();
    }
    try
    {
      localByteArrayOutputStream.write(paramArrayOfByte1);
      localByteArrayOutputStream.write(paramArrayOfByte2);
      label26:
      onPush(ePj, localByteArrayOutputStream.toByteArray());
      return true;
    }
    catch (IOException paramArrayOfByte1)
    {
      break label26;
    }
  }
  
  public final String[] onNewDns(String paramString)
  {
    return new String[0];
  }
  
  public final void onPush(int paramInt, byte[] paramArrayOfByte)
  {
    if (aa.Uw() == null) {
      return;
    }
    try
    {
      if (ePi == null) {
        ePi = new WakerLock(aa.getContext(), "StnCallBack");
      }
      ePi.lock(1000L, "StnLogic.onNotify");
      aa.Us().post(new af.1(this, paramInt, paramArrayOfByte));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("StnCallBack", exception2String(paramArrayOfByte));
      new StringBuilder().append(paramArrayOfByte.getClass().getSimpleName()).append(":").append(paramArrayOfByte.getStackTrace()[0]).append(", ").append(paramArrayOfByte.getStackTrace()[1]);
    }
  }
  
  public final int onTaskEnd(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    if (aa.Uv() == null) {
      return 0;
    }
    try
    {
      i = aa.Uv().jE(paramInt1);
      y.e("StnCallBack", exception2String(paramObject));
    }
    catch (Exception paramObject)
    {
      try
      {
        aa.Us().post(new af.2(this, paramInt1, paramObject, paramInt2, paramInt3));
        return i;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          int i;
          paramInt1 = i;
        }
      }
      paramObject = paramObject;
      paramInt1 = 0;
    }
    new StringBuilder().append(paramObject.getClass().getSimpleName()).append(":").append(paramObject.getStackTrace()[0]).append(", ").append(paramObject.getStackTrace()[1]);
    return paramInt1;
  }
  
  public final void reportConnectInfo(int paramInt1, int paramInt2)
  {
    try
    {
      aa.Ur().jG(paramInt1);
      com.tencent.mm.am.a.iw(paramInt1);
      return;
    }
    catch (Exception localException)
    {
      y.e("StnCallBack", "reportConnectInfo :%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final boolean req2Buf(int paramInt1, Object paramObject, ByteArrayOutputStream paramByteArrayOutputStream, int[] paramArrayOfInt, int paramInt2)
  {
    if (aa.Uv() == null) {
      return false;
    }
    try
    {
      boolean bool = aa.Uv().a(paramInt1, paramByteArrayOutputStream, paramArrayOfInt, paramInt2);
      return bool;
    }
    catch (Exception paramObject)
    {
      y.e("StnCallBack", exception2String(paramObject));
      new StringBuilder().append(paramObject.getClass().getSimpleName()).append(":").append(paramObject.getStackTrace()[0]).append(", ").append(paramObject.getStackTrace()[1]);
    }
    return false;
  }
  
  public final void requestDoSync()
  {
    if (aa.Uw() == null) {
      return;
    }
    try
    {
      aa.Us().post(new af.3(this));
      return;
    }
    catch (Exception localException)
    {
      y.e("StnCallBack", exception2String(localException));
      new StringBuilder().append(localException.getClass().getSimpleName()).append(":").append(localException.getStackTrace()[0]).append(", ").append(localException.getStackTrace()[1]);
    }
  }
  
  public final String[] requestNetCheckShortLinkHosts()
  {
    return new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.af
 * JD-Core Version:    0.7.0.1
 */