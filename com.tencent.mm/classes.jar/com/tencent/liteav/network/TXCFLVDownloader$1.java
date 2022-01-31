package com.tencent.liteav.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TXCFLVDownloader$1
  extends Handler
{
  TXCFLVDownloader$1(TXCFLVDownloader paramTXCFLVDownloader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(67478);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(67478);
      return;
      TXCFLVDownloader.access$000(this.a);
      AppMethodBeat.o(67478);
      return;
      TXCFLVDownloader.access$100(this.a);
      AppMethodBeat.o(67478);
      return;
      TXCFLVDownloader.access$200(this.a);
      AppMethodBeat.o(67478);
      return;
      TXCFLVDownloader.access$300(this.a);
      AppMethodBeat.o(67478);
      return;
      try
      {
        Looper.myLooper().quit();
        AppMethodBeat.o(67478);
        return;
      }
      catch (Exception paramMessage) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.network.TXCFLVDownloader.1
 * JD-Core Version:    0.7.0.1
 */