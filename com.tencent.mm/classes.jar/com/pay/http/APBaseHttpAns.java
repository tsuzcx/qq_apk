package com.pay.http;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class APBaseHttpAns
  implements IAPHttpAns
{
  private final int REQUESTMAX;
  public String errorMsg;
  private APBaseHttpReq httpClient;
  private APHttpHandle httpHandler;
  public String httpReqKey;
  private HashMap<String, APBaseHttpReq> httpReqMap;
  private IAPHttpAnsObserver observer;
  private int requestAgainCount;
  public int resultCode;
  public String resultMsg;
  
  public APBaseHttpAns(APHttpHandle paramAPHttpHandle, IAPHttpAnsObserver paramIAPHttpAnsObserver, HashMap<String, APBaseHttpReq> paramHashMap, String paramString)
  {
    AppMethodBeat.i(253666);
    this.REQUESTMAX = 1;
    this.resultCode = -1;
    this.resultMsg = "";
    this.errorMsg = "";
    this.httpReqKey = "";
    this.requestAgainCount = 0;
    this.httpHandler = paramAPHttpHandle;
    this.httpReqMap = paramHashMap;
    this.httpReqKey = paramString;
    this.observer = paramIAPHttpAnsObserver;
    this.httpHandler.register(this.httpReqKey, paramIAPHttpAnsObserver);
    AppMethodBeat.o(253666);
  }
  
  private void register(APBaseHttpReq paramAPBaseHttpReq)
  {
    AppMethodBeat.i(253683);
    this.httpReqMap.put(this.httpReqKey, paramAPBaseHttpReq);
    AppMethodBeat.o(253683);
  }
  
  private void sendErrorMessage()
  {
    AppMethodBeat.i(253679);
    Message localMessage = new Message();
    localMessage.what = 4;
    localMessage.obj = this;
    this.httpHandler.sendMessage(localMessage);
    AppMethodBeat.o(253679);
  }
  
  private void sendFinishMessage(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(253678);
    paramArrayOfByte = new Message();
    paramArrayOfByte.what = 3;
    paramArrayOfByte.obj = this;
    this.httpHandler.sendMessage(paramArrayOfByte);
    AppMethodBeat.o(253678);
  }
  
  private void sendStopMessage()
  {
    AppMethodBeat.i(253680);
    Message localMessage = new Message();
    localMessage.what = 5;
    localMessage.obj = this;
    this.httpHandler.sendMessage(localMessage);
    AppMethodBeat.o(253680);
  }
  
  private void unRegister()
  {
    AppMethodBeat.i(253684);
    this.httpReqMap.remove(this.httpReqKey);
    AppMethodBeat.o(253684);
  }
  
  public String getErrorMessage()
  {
    return this.errorMsg;
  }
  
  public String getHttpReqKey()
  {
    return this.httpReqKey;
  }
  
  public int getResultCode()
  {
    return this.resultCode;
  }
  
  public String getResultMessage()
  {
    return this.resultMsg;
  }
  
  public void onError(APBaseHttpReq paramAPBaseHttpReq, int paramInt, String paramString)
  {
    AppMethodBeat.i(253677);
    this.errorMsg = paramString;
    this.resultMsg = paramString;
    this.resultCode = paramInt;
    unRegister();
    onErrorAns(paramAPBaseHttpReq);
    sendErrorMessage();
    AppMethodBeat.o(253677);
  }
  
  public void onErrorAns(APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void onFinish(APBaseHttpReq paramAPBaseHttpReq)
  {
    AppMethodBeat.i(253676);
    unRegister();
    if (paramAPBaseHttpReq.getContent() == null)
    {
      this.resultCode = -1;
      this.resultMsg = "";
      sendErrorMessage();
      AppMethodBeat.o(253676);
      return;
    }
    this.httpClient = paramAPBaseHttpReq;
    onFinishAns(paramAPBaseHttpReq.getContent(), paramAPBaseHttpReq);
    sendFinishMessage(paramAPBaseHttpReq.getContent());
    AppMethodBeat.o(253676);
  }
  
  public void onFinishAns(byte[] paramArrayOfByte, APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void onReceive(byte[] paramArrayOfByte, int paramInt, long paramLong, APBaseHttpReq paramAPBaseHttpReq)
  {
    AppMethodBeat.i(253672);
    onReceiveAns(paramArrayOfByte, paramInt, paramLong, paramAPBaseHttpReq);
    AppMethodBeat.o(253672);
  }
  
  public void onReceiveAns(byte[] paramArrayOfByte, int paramInt, long paramLong, APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void onStart(APBaseHttpReq paramAPBaseHttpReq)
  {
    AppMethodBeat.i(253671);
    register(paramAPBaseHttpReq);
    onStartAns(paramAPBaseHttpReq);
    AppMethodBeat.o(253671);
  }
  
  public void onStartAns(APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void onStop(APBaseHttpReq paramAPBaseHttpReq)
  {
    AppMethodBeat.i(253674);
    unRegister();
    onStopAns(paramAPBaseHttpReq);
    sendStopMessage();
    AppMethodBeat.o(253674);
  }
  
  public void onStopAns(APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void reRegister()
  {
    AppMethodBeat.i(253669);
    this.httpHandler.register(this.httpReqKey, this.observer);
    AppMethodBeat.o(253669);
  }
  
  public void requestAgain()
  {
    AppMethodBeat.i(253685);
    if ((this.httpClient != null) && (this.requestAgainCount <= 1))
    {
      this.requestAgainCount += 1;
      reRegister();
      new Thread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(253663);
          APBaseHttpAns.this.httpClient.requestAgain();
          AppMethodBeat.o(253663);
        }
      }).start();
      AppMethodBeat.o(253685);
      return;
    }
    reRegister();
    onError(this.httpClient, -1, "");
    AppMethodBeat.o(253685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.pay.http.APBaseHttpAns
 * JD-Core Version:    0.7.0.1
 */