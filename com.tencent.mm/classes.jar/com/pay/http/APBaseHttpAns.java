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
    AppMethodBeat.i(193284);
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
    AppMethodBeat.o(193284);
  }
  
  private void register(APBaseHttpReq paramAPBaseHttpReq)
  {
    AppMethodBeat.i(193294);
    this.httpReqMap.put(this.httpReqKey, paramAPBaseHttpReq);
    AppMethodBeat.o(193294);
  }
  
  private void sendErrorMessage()
  {
    AppMethodBeat.i(193292);
    Message localMessage = new Message();
    localMessage.what = 4;
    localMessage.obj = this;
    this.httpHandler.sendMessage(localMessage);
    AppMethodBeat.o(193292);
  }
  
  private void sendFinishMessage(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193291);
    paramArrayOfByte = new Message();
    paramArrayOfByte.what = 3;
    paramArrayOfByte.obj = this;
    this.httpHandler.sendMessage(paramArrayOfByte);
    AppMethodBeat.o(193291);
  }
  
  private void sendStopMessage()
  {
    AppMethodBeat.i(193293);
    Message localMessage = new Message();
    localMessage.what = 5;
    localMessage.obj = this;
    this.httpHandler.sendMessage(localMessage);
    AppMethodBeat.o(193293);
  }
  
  private void unRegister()
  {
    AppMethodBeat.i(193295);
    this.httpReqMap.remove(this.httpReqKey);
    AppMethodBeat.o(193295);
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
    AppMethodBeat.i(193290);
    this.errorMsg = paramString;
    this.resultMsg = paramString;
    this.resultCode = paramInt;
    unRegister();
    onErrorAns(paramAPBaseHttpReq);
    sendErrorMessage();
    AppMethodBeat.o(193290);
  }
  
  public void onErrorAns(APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void onFinish(APBaseHttpReq paramAPBaseHttpReq)
  {
    AppMethodBeat.i(193289);
    unRegister();
    if (paramAPBaseHttpReq.getContent() == null)
    {
      this.resultCode = -1;
      this.resultMsg = "";
      sendErrorMessage();
      AppMethodBeat.o(193289);
      return;
    }
    this.httpClient = paramAPBaseHttpReq;
    onFinishAns(paramAPBaseHttpReq.getContent(), paramAPBaseHttpReq);
    sendFinishMessage(paramAPBaseHttpReq.getContent());
    AppMethodBeat.o(193289);
  }
  
  public void onFinishAns(byte[] paramArrayOfByte, APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void onReceive(byte[] paramArrayOfByte, int paramInt, long paramLong, APBaseHttpReq paramAPBaseHttpReq)
  {
    AppMethodBeat.i(193287);
    onReceiveAns(paramArrayOfByte, paramInt, paramLong, paramAPBaseHttpReq);
    AppMethodBeat.o(193287);
  }
  
  public void onReceiveAns(byte[] paramArrayOfByte, int paramInt, long paramLong, APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void onStart(APBaseHttpReq paramAPBaseHttpReq)
  {
    AppMethodBeat.i(193286);
    register(paramAPBaseHttpReq);
    onStartAns(paramAPBaseHttpReq);
    AppMethodBeat.o(193286);
  }
  
  public void onStartAns(APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void onStop(APBaseHttpReq paramAPBaseHttpReq)
  {
    AppMethodBeat.i(193288);
    unRegister();
    onStopAns(paramAPBaseHttpReq);
    sendStopMessage();
    AppMethodBeat.o(193288);
  }
  
  public void onStopAns(APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void reRegister()
  {
    AppMethodBeat.i(193285);
    this.httpHandler.register(this.httpReqKey, this.observer);
    AppMethodBeat.o(193285);
  }
  
  public void requestAgain()
  {
    AppMethodBeat.i(193296);
    if ((this.httpClient != null) && (this.requestAgainCount <= 1))
    {
      this.requestAgainCount += 1;
      reRegister();
      new Thread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(193258);
          APBaseHttpAns.this.httpClient.requestAgain();
          AppMethodBeat.o(193258);
        }
      }).start();
      AppMethodBeat.o(193296);
      return;
    }
    reRegister();
    onError(this.httpClient, -1, "");
    AppMethodBeat.o(193296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.pay.http.APBaseHttpAns
 * JD-Core Version:    0.7.0.1
 */