package com.tencent.midas.control;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;

public class APCallBackResultReceiver
  extends ResultReceiver
{
  private Receiver mReceiver;
  
  public APCallBackResultReceiver(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(252830);
    APLog.i("APCallBackResultReceiver", "onReceiveResult resultCode:" + paramInt + " mReceiver:" + this.mReceiver);
    if (this.mReceiver != null) {
      this.mReceiver.onReceiveResult(paramInt, paramBundle);
    }
    AppMethodBeat.o(252830);
  }
  
  public void setReceiver(Receiver paramReceiver)
  {
    this.mReceiver = paramReceiver;
  }
  
  public static abstract interface Receiver
  {
    public abstract void onReceiveResult(int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.control.APCallBackResultReceiver
 * JD-Core Version:    0.7.0.1
 */