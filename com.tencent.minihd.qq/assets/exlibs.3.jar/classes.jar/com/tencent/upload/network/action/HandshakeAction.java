package com.tencent.upload.network.action;

import FileUpload.FileUploadHandShakeRsp;
import FileUpload.IpInfo;
import FileUpload.SvcResponsePacket;
import android.util.Log;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.network.IUploadSessionService;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.protocol.utils.ProtocolUtil;
import com.tencent.upload.uinterface.IUploadAction;
import java.util.ArrayList;

public class HandshakeAction
  implements IUploadAction
{
  private final int mActionSequence;
  private String mClientIp;
  private long mCurrentTime;
  private final IHandshakeListener mHandshakeListener;
  private final int mRedirect;
  private UploadRoute mRedirectRoute;
  private final int mRequestSequence;
  private int mSendState;
  private long mServerTime;
  
  public HandshakeAction(int paramInt1, int paramInt2, IHandshakeListener paramIHandshakeListener)
  {
    this.mHandshakeListener = paramIHandshakeListener;
    this.mActionSequence = paramInt1;
    this.mRequestSequence = paramInt1;
    this.mRedirect = paramInt2;
    this.mSendState = 0;
  }
  
  private final boolean decodeContent(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return true;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      FileUploadHandShakeRsp localFileUploadHandShakeRsp = (FileUploadHandShakeRsp)ProtocolUtil.unpack(FileUploadHandShakeRsp.class.getSimpleName(), paramArrayOfByte);
      localObject2 = localFileUploadHandShakeRsp;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = Log.getStackTraceString(localException);
        UploadLog.w(HandshakeAction.class.getSimpleName(), localException);
      }
      paramArrayOfByte = ((FileUploadHandShakeRsp)localObject2).vRedirectIp;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
        break label226;
      }
      paramArrayOfByte = (IpInfo)paramArrayOfByte.get(0);
      localObject1 = new StringBuffer();
      ((StringBuffer)localObject1).append(paramArrayOfByte.ip >> 24 & 0xFF).append(".");
      ((StringBuffer)localObject1).append(paramArrayOfByte.ip >> 16 & 0xFF).append(".");
      ((StringBuffer)localObject1).append(paramArrayOfByte.ip >> 8 & 0xFF).append(".");
      ((StringBuffer)localObject1).append(paramArrayOfByte.ip & 0xFF);
      this.mRedirectRoute = new UploadRoute(((StringBuffer)localObject1).toString(), paramArrayOfByte.port, null, 0, ((FileUploadHandShakeRsp)localObject2).iProtocal, 2);
      if (((FileUploadHandShakeRsp)localObject2).iClientIP == 0L) {
        break label327;
      }
      paramArrayOfByte = new StringBuffer();
      paramArrayOfByte.append(((FileUploadHandShakeRsp)localObject2).iClientIP >> 24 & 0xFF).append(".");
      paramArrayOfByte.append(((FileUploadHandShakeRsp)localObject2).iClientIP >> 16 & 0xFF).append(".");
      paramArrayOfByte.append(((FileUploadHandShakeRsp)localObject2).iClientIP >> 8 & 0xFF).append(".");
      paramArrayOfByte.append(((FileUploadHandShakeRsp)localObject2).iClientIP & 0xFF);
      this.mClientIp = paramArrayOfByte.toString();
      if (((FileUploadHandShakeRsp)localObject2).iServerTime <= 0L) {
        break label355;
      }
      this.mServerTime = ((FileUploadHandShakeRsp)localObject2).iServerTime;
      this.mCurrentTime = (System.currentTimeMillis() / 1000L);
    }
    if (localObject2 == null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "decodeContent() unpack FileUploadHandShakeRsp=null. " + paramArrayOfByte;
      }
      UploadLog.e(HandshakeAction.class.getSimpleName(), (String)localObject2);
      return false;
    }
    label226:
    label355:
    return true;
  }
  
  public int getActionSequence()
  {
    return this.mActionSequence;
  }
  
  public String getClientIp()
  {
    return this.mClientIp;
  }
  
  public UploadRoute getRedirectRoute()
  {
    return this.mRedirectRoute;
  }
  
  public int getSendState()
  {
    return this.mSendState;
  }
  
  public int getServerCategory()
  {
    return 0;
  }
  
  public long[] getUploadServerTimePair()
  {
    if (this.mServerTime <= 0L) {
      return null;
    }
    return new long[] { this.mServerTime, this.mCurrentTime };
  }
  
  public void onCancel(int paramInt)
  {
    this.mSendState = 0;
  }
  
  public void onConnecting() {}
  
  public void onError(IUploadSession paramIUploadSession, int paramInt, String paramString, boolean paramBoolean)
  {
    paramBoolean = false;
    this.mSendState = 0;
    if (this.mHandshakeListener != null)
    {
      if (30300 == paramInt) {
        this.mHandshakeListener.onFailtoUnpackHandshake(this);
      }
    }
    else {
      return;
    }
    paramIUploadSession = this.mHandshakeListener;
    if (paramInt == 35000) {
      paramBoolean = true;
    }
    paramIUploadSession.onFailtoShakeHands(this, paramBoolean);
  }
  
  public void onRequest(IUploadSession paramIUploadSession, IActionRequest paramIActionRequest)
  {
    if (paramIActionRequest.getCommandId() != 1000) {
      return;
    }
    this.mSendState = 2;
  }
  
  public void onResponse(IUploadSession paramIUploadSession, ActionResponse paramActionResponse)
  {
    int j = 0;
    int i = j;
    if (this.mSendState == 2)
    {
      if (paramActionResponse == null) {
        i = j;
      }
    }
    else
    {
      if (i != 0) {
        break label90;
      }
      if (this.mHandshakeListener != null) {
        this.mHandshakeListener.onFailtoUnpackHandshake(this);
      }
    }
    label90:
    do
    {
      return;
      paramIUploadSession = paramActionResponse.getReponsePacket();
      i = j;
      if (paramIUploadSession == null) {
        break;
      }
      i = j;
      if (paramIUploadSession.iCmdID != 1000) {
        break;
      }
      i = j;
      if (!decodeContent(paramActionResponse.getReponsePacket().vRspData)) {
        break;
      }
      i = 1;
      break;
      this.mSendState = 3;
    } while (this.mHandshakeListener == null);
    this.mHandshakeListener.onShakeHands(this);
  }
  
  public boolean onSend(IUploadSession paramIUploadSession)
  {
    if (this.mSendState != 0) {}
    while (!paramIUploadSession.send(new HandshakeRequest(this.mActionSequence, this.mRequestSequence, this.mRedirect))) {
      return false;
    }
    this.mSendState = 1;
    return true;
  }
  
  public void onTimeout(IUploadSession paramIUploadSession, IActionRequest paramIActionRequest)
  {
    if (this.mHandshakeListener != null) {
      this.mHandshakeListener.onFailtoShakeHands(this, false);
    }
  }
  
  public void setSessionService(IUploadSessionService paramIUploadSessionService) {}
  
  public static abstract interface IHandshakeListener
  {
    public abstract void onFailtoShakeHands(HandshakeAction paramHandshakeAction, boolean paramBoolean);
    
    public abstract void onFailtoUnpackHandshake(HandshakeAction paramHandshakeAction);
    
    public abstract void onShakeHands(HandshakeAction paramHandshakeAction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.action.HandshakeAction
 * JD-Core Version:    0.7.0.1
 */