package com.tencent.litetransfersdk;

import android.os.Handler;
import android.os.Looper;
import com.dataline.util.HttpUtil;
import com.dataline.util.HttpUtil.NetworkProxy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import dbs;
import dbt;
import dbu;
import dbv;
import dbw;
import dbx;
import dby;
import dbz;
import dca;
import dcb;
import dcc;
import dcd;
import dce;
import dcf;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class LiteTransferWrapper
{
  public static final String sTagName = "dataline.LiteTTransferWrapper";
  private LiteTransferListenerCallback mListener;
  private long mLiteTransferOperator = 0L;
  private LiteTransferOperatorCallback mOperator;
  
  static
  {
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getContext(), "xplatform", 0, false);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        try
        {
          SoLoadUtil.a(BaseApplicationImpl.getContext(), "litetransfer", 0, false);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          localUnsatisfiedLinkError2.printStackTrace();
        }
        localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
        localUnsatisfiedLinkError1.printStackTrace();
      }
    }
  }
  
  public LiteTransferWrapper(LiteTransferOperatorCallback paramLiteTransferOperatorCallback, LiteTransferListenerCallback paramLiteTransferListenerCallback)
  {
    this.mOperator = paramLiteTransferOperatorCallback;
    this.mListener = paramLiteTransferListenerCallback;
    this.mLiteTransferOperator = 0L;
  }
  
  public static void OnLog(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    do
    {
      try
      {
        paramArrayOfByte1 = new String(paramArrayOfByte1, "UTF-8");
        paramArrayOfByte2 = new String(paramArrayOfByte2, "UTF-8");
        if ((paramInt == 0) || (paramInt == 1))
        {
          QLog.d(paramArrayOfByte1, 1, paramArrayOfByte2);
          return;
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte1)
      {
        do
        {
          paramArrayOfByte1.printStackTrace();
        } while (!QLog.isDevelopLevel());
        QLog.e("dataline.LiteTTransferWrapper", 4, "native log encoding utf8 failed");
        return;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d(paramArrayOfByte1, 4, paramArrayOfByte2);
  }
  
  public static long getCurrentMillisTime()
  {
    return NetConnInfoCenter.getServerTimeMillis();
  }
  
  public static int getNetType()
  {
    return NetworkCenter.a().a();
  }
  
  public void CancelAll(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "CancelAll " + this.mLiteTransferOperator);
    }
    if (this.mLiteTransferOperator == 0L) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dbz(this, paramInt));
      return;
    }
    CancelAllToJNI(this.mLiteTransferOperator, paramInt);
  }
  
  public native void CancelAllToJNI(long paramLong, int paramInt);
  
  public void CancelGroup(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "CancelGroup " + this.mLiteTransferOperator);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dcd(this, paramInt1, paramLong, paramInt2, paramBoolean));
      return;
    }
    CancelGroupToJNI(this.mLiteTransferOperator, paramInt1, paramLong, paramInt2, paramBoolean);
  }
  
  public native void CancelGroupToJNI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, boolean paramBoolean);
  
  public native void DoGetThumbFilePathReplyToJNI(long paramLong, int paramInt, String paramString);
  
  public native void DoPbMsgReplyToJNI(long paramLong, int paramInt, MsgSCBody paramMsgSCBody);
  
  public void OnGetThumbFilePathReply(int paramInt, String paramString)
  {
    checkTransferAlive();
    DoGetThumbFilePathReplyToJNI(this.mLiteTransferOperator, paramInt, paramString);
  }
  
  public void OnPbMsgReceive(MsgCSBody paramMsgCSBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "_PbMsgRecive " + this.mLiteTransferOperator);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dcf(this, paramMsgCSBody));
      return;
    }
    PbMsgReciveToJNI(this.mLiteTransferOperator, paramMsgCSBody);
  }
  
  public void OnPbMsgReply(int paramInt, MsgSCBody paramMsgSCBody)
  {
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dce(this, paramInt, paramMsgSCBody));
      return;
    }
    DoPbMsgReplyToJNI(this.mLiteTransferOperator, paramInt, paramMsgSCBody);
  }
  
  public native void PbMsgReciveToJNI(long paramLong, MsgCSBody paramMsgCSBody);
  
  public void RecvGroup(Session[] paramArrayOfSession, NFCInfo[] paramArrayOfNFCInfo, FTNInfo[] paramArrayOfFTNInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "RecvGroup " + this.mLiteTransferOperator);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dcc(this, paramArrayOfSession, paramArrayOfNFCInfo, paramArrayOfFTNInfo, paramBoolean));
      return;
    }
    SetProxyToJni();
    RecvGroupToJNI(this.mLiteTransferOperator, paramArrayOfSession, paramArrayOfNFCInfo, paramArrayOfFTNInfo, paramBoolean);
  }
  
  public native void RecvGroupToJNI(long paramLong, Session[] paramArrayOfSession, NFCInfo[] paramArrayOfNFCInfo, FTNInfo[] paramArrayOfFTNInfo, boolean paramBoolean);
  
  public void SendGroup(ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dcb(this, paramArrayList, paramBoolean1, paramBoolean2));
      return;
    }
    SetProxyToJni();
    SendGroupToJNI(this.mLiteTransferOperator, (Session[])paramArrayList.toArray(new Session[paramArrayList.size()]), paramBoolean1, paramBoolean2);
  }
  
  public native void SendGroupToJNI(long paramLong, Session[] paramArrayOfSession, boolean paramBoolean1, boolean paramBoolean2);
  
  public void SetDefaultPath(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "SetDefaultPath " + paramString);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dbt(this, paramString));
      return;
    }
    SetDefaultPathToJNI(this.mLiteTransferOperator, paramString);
  }
  
  public native void SetDefaultPathToJNI(long paramLong, String paramString);
  
  public void SetProxyToJni()
  {
    HttpUtil.NetworkProxy localNetworkProxy = HttpUtil.a();
    if (localNetworkProxy != null)
    {
      setGlobalProxyInfo(1, localNetworkProxy.jdField_a_of_type_JavaLangString, (short)localNetworkProxy.jdField_a_of_type_Int, "", "");
      return;
    }
    setGlobalProxyInfo(0, "", (short)0, "", "");
  }
  
  public void SetServicePath(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "SetServicePath " + paramString1);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dbv(this, paramString1, paramString2));
      return;
    }
    SetServicePathToJNI(this.mLiteTransferOperator, paramString1, paramString2);
  }
  
  public native void SetServicePathToJNI(long paramLong, String paramString1, String paramString2);
  
  public void SetTempPath(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "SetTempPath " + paramString);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dbw(this, paramString));
      return;
    }
    SetTempPathToJNI(this.mLiteTransferOperator, paramString);
  }
  
  public native void SetTempPathToJNI(long paramLong, String paramString);
  
  public void SetThumbPath(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "SetThumbPath " + paramString);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dbu(this, paramString));
      return;
    }
    SetThumbPathToJNI(this.mLiteTransferOperator, paramString);
  }
  
  public native void SetThumbPathToJNI(long paramLong, String paramString);
  
  public void SetThumbTempPath(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "SetThumbTempPath " + paramString);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dbx(this, paramString));
      return;
    }
    SetThumbTempPathToJNI(this.mLiteTransferOperator, paramString);
  }
  
  public native void SetThumbTempPathToJNI(long paramLong, String paramString);
  
  public void SyncGroup(Session[] paramArrayOfSession)
  {
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dca(this, paramArrayOfSession));
      return;
    }
    SyncGroupToJNI(this.mLiteTransferOperator, paramArrayOfSession);
  }
  
  public native void SyncGroupToJNI(long paramLong, Session[] paramArrayOfSession);
  
  public void beginLiteTransfer()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new dbs(this));
    }
    do
    {
      do
      {
        return;
        if ((this.mOperator != null) && (this.mListener != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("dataline.LiteTTransferWrapper", 2, "litetransfer callback is null, do nothing");
      return;
    } while (this.mLiteTransferOperator != 0L);
    this.mLiteTransferOperator = createOperator(this.mOperator, this.mListener);
    checkPathExist();
    SetProxyToJni();
  }
  
  public void checkPathExist()
  {
    File localFile = new File(AppConstants.aP);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    SetDefaultPath(AppConstants.aP);
    localFile = new File(AppConstants.aQ);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    SetThumbPath(AppConstants.aQ);
    localFile = new File(AppConstants.aR);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    SetTempPath(AppConstants.aR);
    localFile = new File(AppConstants.aR);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    SetThumbTempPath(AppConstants.aR);
  }
  
  public void checkTransferAlive()
  {
    if (this.mLiteTransferOperator == 0L) {
      beginLiteTransfer();
    }
  }
  
  public native long createOperator(LiteTransferOperatorCallback paramLiteTransferOperatorCallback, LiteTransferListenerCallback paramLiteTransferListenerCallback);
  
  public native void destryOperator(long paramLong, boolean paramBoolean);
  
  public void endLiteTransfer(boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dby(this, paramBoolean));
      return;
    }
    try
    {
      if (this.mLiteTransferOperator != 0L)
      {
        destryOperator(this.mLiteTransferOperator, paramBoolean);
        this.mLiteTransferOperator = 0L;
      }
      this.mOperator = null;
      this.mListener = null;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("dataline.LiteTTransferWrapper", 2, "cannot endLiteTransfer, load litetranfer library error?" + QLog.getStackTraceString(localUnsatisfiedLinkError));
        }
      }
    }
  }
  
  public native int generateGroupID();
  
  public native long generateSessionID(int paramInt);
  
  public native long generateTaskID(long paramLong, byte paramByte);
  
  public native long initGlobalFunc();
  
  public native void setGlobalProxyInfo(int paramInt, String paramString1, short paramShort, String paramString2, String paramString3);
  
  public native void setWanIP(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper
 * JD-Core Version:    0.7.0.1
 */