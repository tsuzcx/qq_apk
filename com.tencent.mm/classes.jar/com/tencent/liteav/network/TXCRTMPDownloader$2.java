package com.tencent.liteav.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class TXCRTMPDownloader$2
  extends Handler
{
  TXCRTMPDownloader$2(TXCRTMPDownloader paramTXCRTMPDownloader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 101) {
      TXCRTMPDownloader.access$600(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.network.TXCRTMPDownloader.2
 * JD-Core Version:    0.7.0.1
 */