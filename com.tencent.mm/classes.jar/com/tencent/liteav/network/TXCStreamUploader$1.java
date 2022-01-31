package com.tencent.liteav.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TXCStreamUploader$1
  extends Handler
{
  TXCStreamUploader$1(TXCStreamUploader paramTXCStreamUploader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(67477);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(67477);
      return;
      TXCStreamUploader localTXCStreamUploader = this.a;
      String str = (String)paramMessage.obj;
      if (paramMessage.arg1 == 2) {}
      for (boolean bool = true;; bool = false)
      {
        TXCStreamUploader.access$000(localTXCStreamUploader, str, bool, 0);
        AppMethodBeat.o(67477);
        return;
      }
      TXCStreamUploader.access$100(this.a);
      AppMethodBeat.o(67477);
      return;
      TXCStreamUploader.access$200(this.a);
      if (TXCStreamUploader.access$300(this.a) != null) {
        TXCStreamUploader.access$300(this.a).sendEmptyMessageDelayed(104, 2000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.network.TXCStreamUploader.1
 * JD-Core Version:    0.7.0.1
 */