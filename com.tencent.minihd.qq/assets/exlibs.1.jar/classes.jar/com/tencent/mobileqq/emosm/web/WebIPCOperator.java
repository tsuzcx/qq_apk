package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class WebIPCOperator
{
  private static WebIPCOperator _instance;
  static final String tag = "Q.emoji.web.EmoWebIPCOperator";
  EmojiIPCAlarmer alarm = null;
  private Client mClient = new Client();
  private Handler mHandler = new Handler();
  private ArrayList mObservers = new ArrayList();
  private EmojiIPCAlarmer.TimeoutObserver mTimeoutObserver = new WebIPCOperator.5(this);
  private Vector requetQueue = new Vector();
  private int seq = 0;
  
  private void checkTimerInit()
  {
    if (this.alarm == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "alarm init");
      }
      this.alarm = new EmojiIPCAlarmer(this.mTimeoutObserver);
      this.alarm.init();
    }
  }
  
  private void dispatchBindToClient()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchBindToClient suc");
    }
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((Client.onRemoteRespObserver)localIterator.next()).onBindedToClient();
    }
  }
  
  private void dispatchDisconnectWithService()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchBindToClient suc");
    }
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((Client.onRemoteRespObserver)localIterator.next()).onDisconnectWithService();
    }
  }
  
  private void dispatchPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchPushMsg suc");
    }
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((Client.onRemoteRespObserver)localIterator.next()).onPushMsg(paramBundle);
    }
  }
  
  public static WebIPCOperator getInstance()
  {
    if (_instance == null) {}
    try
    {
      if (_instance == null) {
        _instance = new WebIPCOperator();
      }
      return _instance;
    }
    finally {}
  }
  
  public void addTimeoutTask(Runnable paramRunnable, long paramLong)
  {
    checkTimerInit();
    this.alarm.addTimoutRunnable(paramRunnable, paramLong);
  }
  
  public WebIPCOperator.RequestItem addToRequest(Bundle paramBundle)
  {
    synchronized (this.requetQueue)
    {
      int i = this.seq;
      this.seq = (i + 1);
      paramBundle = new WebIPCOperator.RequestItem(i, paramBundle);
      checkTimerInit();
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "add to req queue seq: " + paramBundle.seq);
      }
      paramBundle.timeoutTask = this.alarm.addTimeoutCheck(paramBundle.seq, 30000L);
      this.requetQueue.add(paramBundle);
      return paramBundle;
    }
  }
  
  void dispatchResp(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchResp suc:" + paramBundle.getString("cmd"));
    }
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((Client.onRemoteRespObserver)localIterator.next()).onResponse(paramBundle);
    }
  }
  
  public Client getClient()
  {
    return this.mClient;
  }
  
  public boolean isServiceClientBinded()
  {
    if (this.mClient != null) {
      return this.mClient.isClientBinded();
    }
    return false;
  }
  
  public void onBindSuc()
  {
    dispatchBindToClient();
  }
  
  public void onDisconnectWithService()
  {
    dispatchDisconnectWithService();
  }
  
  public void onPushMsgFromServer(Bundle paramBundle)
  {
    dispatchPushMsg(paramBundle);
  }
  
  public void onRespFromClient(Bundle paramBundle)
  {
    Object localObject;
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("seq");
      localObject = removeRequest(i);
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchResp seq:" + i);
      }
      if (localObject == null) {
        break label74;
      }
      setRespFailCode(paramBundle, 1000);
      runOnUiThread(new WebIPCOperator.3(this, paramBundle));
    }
    label74:
    do
    {
      return;
      localObject = paramBundle.getString("cmd");
    } while ((localObject == null) || ((!((String)localObject).equals("startDownloadEmoji")) && (!((String)localObject).equals("startDownloadTheme")) && (!((String)localObject).equals("pausedownload")) && (!((String)localObject).equals("stopdownload")) && (!((String)localObject).equals("qwalletOpenOpenid")) && (!((String)localObject).equals("qwalletOpenToken")) && (!((String)localObject).equals("openEquipmentLock")) && (!((String)localObject).equals("card_setSummaryCard")) && (!((String)localObject).equals("card_getVipInfo")) && (!((String)localObject).equals("closeWeb")) && (!((String)localObject).equals("setMobileResult")) && (!((String)localObject).equals("setWaitingResponse")) && (!((String)localObject).equals("openEmojiMall")) && (!((String)localObject).equals("openProfileCard")) && (!((String)localObject).equals("close_version")) && (!((String)localObject).equals("openEmojiDetail")) && (!((String)localObject).equals("openFontSetting")) && (!((String)localObject).equals("startDownloadColorRing")) && (!((String)localObject).equals("stopDownloadColorRing")) && (!((String)localObject).equals("funcall_download")) && (!((String)localObject).equals("funcall_set")) && (!((String)localObject).equals("getA2"))));
    setRespFailCode(paramBundle, 1000);
    runOnUiThread(new WebIPCOperator.4(this, paramBundle));
  }
  
  public void registerObserver(Client.onRemoteRespObserver paramonRemoteRespObserver)
  {
    if (paramonRemoteRespObserver == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "RegisterObserver key:" + paramonRemoteRespObserver.key);
      }
    } while (this.mObservers.contains(paramonRemoteRespObserver));
    this.mObservers.add(paramonRemoteRespObserver);
  }
  
  public WebIPCOperator.RequestItem removeRequest(int paramInt)
  {
    synchronized (this.requetQueue)
    {
      Iterator localIterator = this.requetQueue.iterator();
      while (localIterator.hasNext())
      {
        WebIPCOperator.RequestItem localRequestItem = (WebIPCOperator.RequestItem)localIterator.next();
        if (localRequestItem.seq == paramInt)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "remove req queue seq:" + paramInt);
          }
          this.alarm.removeTimeoutCheck(localRequestItem.timeoutTask);
          this.requetQueue.remove(localRequestItem);
          if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "after remove req queue size:" + this.requetQueue.size());
          }
          return localRequestItem;
        }
      }
      return null;
    }
  }
  
  public void removeTimeoutTask(Runnable paramRunnable)
  {
    checkTimerInit();
    this.alarm.removeTimeoutCheck(paramRunnable);
  }
  
  void runOnUiThread(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.mHandler.post(paramRunnable);
    }
  }
  
  public void sendServiceIpcReq(Bundle paramBundle)
  {
    Object localObject = addToRequest(paramBundle);
    if ((localObject != null) && ((this.mClient == null) || (!this.mClient.onReqToServer(((WebIPCOperator.RequestItem)localObject).reqbundle))))
    {
      paramBundle = removeRequest(paramBundle.getInt("seq"));
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "sendServiceIpcReq unbind fail seq:" + this.seq);
      }
      if (paramBundle != null)
      {
        localObject = new Bundle();
        setRespFailCode((Bundle)localObject, 1002);
        paramBundle.reqbundle.putBundle("response", (Bundle)localObject);
        runOnUiThread(new WebIPCOperator.1(this, paramBundle));
      }
    }
  }
  
  public void sendServiceIpcReqWithoutTimeout(Bundle paramBundle)
  {
    if ((paramBundle != null) && ((this.mClient == null) || (!this.mClient.onReqToServer(paramBundle))))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "sendServiceIpcReq unbind fail seq:" + this.seq);
      }
      Bundle localBundle = new Bundle();
      setRespFailCode(localBundle, 1002);
      paramBundle.putBundle("response", localBundle);
      runOnUiThread(new WebIPCOperator.2(this, paramBundle));
    }
  }
  
  void setRespFailCode(Bundle paramBundle, int paramInt)
  {
    if (paramBundle != null) {
      paramBundle.putInt("failcode", paramInt);
    }
  }
  
  public void unRegisterObserver(Client.onRemoteRespObserver paramonRemoteRespObserver)
  {
    if (paramonRemoteRespObserver != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "unRegisterObserver key:" + paramonRemoteRespObserver.key);
      }
      if (this.mObservers.contains(paramonRemoteRespObserver)) {
        this.mObservers.remove(paramonRemoteRespObserver);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.WebIPCOperator
 * JD-Core Version:    0.7.0.1
 */