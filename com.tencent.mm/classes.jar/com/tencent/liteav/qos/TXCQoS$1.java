package com.tencent.liteav.qos;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TXCQoS$1
  implements Runnable
{
  TXCQoS$1(TXCQoS paramTXCQoS) {}
  
  public void run()
  {
    AppMethodBeat.i(66822);
    int i;
    int j;
    int k;
    Bundle localBundle;
    if (TXCQoS.access$000(this.a) != null)
    {
      i = TXCQoS.access$000(this.a).onGetEncoderRealBitrate();
      j = TXCQoS.access$000(this.a).onGetQueueInputSize();
      k = TXCQoS.access$000(this.a).onGetQueueOutputSize();
      int m = TXCQoS.access$000(this.a).onGetVideoQueueMaxCount();
      int n = TXCQoS.access$000(this.a).onGetVideoQueueCurrentCount();
      int i1 = TXCQoS.access$000(this.a).onGetVideoDropCount();
      TXCQoS.access$200(this.a, TXCQoS.access$100(this.a), i);
      TXCQoS.access$300(this.a, TXCQoS.access$100(this.a), m, n, i1, k, j);
      boolean bool = TXCQoS.access$400(this.a, TXCQoS.access$100(this.a));
      if (TXCQoS.access$500(this.a) != bool)
      {
        TXCQoS.access$502(this.a, bool);
        TXCQoS.access$000(this.a).onEnableDropStatusChanged(bool);
      }
      i = TXCQoS.access$600(this.a, TXCQoS.access$100(this.a));
      j = TXCQoS.access$700(this.a, TXCQoS.access$100(this.a));
      k = TXCQoS.access$800(this.a, TXCQoS.access$100(this.a));
      if ((j == TXCQoS.access$900(this.a)) && (k == TXCQoS.access$1000(this.a))) {
        break label428;
      }
      if ((TXCQoS.access$1100(this.a) == 1) || (TXCQoS.access$1100(this.a) == 5))
      {
        TXCQoS.access$000(this.a).onEncoderParamsChanged(i, j, k);
        if (TXCQoS.access$1200(this.a) != null)
        {
          localBundle = new Bundle();
          localBundle.putCharSequence("EVT_MSG", "调整分辨率:new bitrate:" + i + " new resolution:" + j + "*" + k);
          localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
          TXCQoS.access$1200(this.a).onNotifyEvent(1005, localBundle);
        }
      }
    }
    for (;;)
    {
      TXCQoS.access$1302(this.a, i);
      TXCQoS.access$902(this.a, j);
      TXCQoS.access$1002(this.a, k);
      TXCQoS.access$1600(this.a).postDelayed(this, TXCQoS.access$1500(this.a));
      AppMethodBeat.o(66822);
      return;
      label428:
      if (i != TXCQoS.access$1300(this.a))
      {
        TXCQoS.access$000(this.a).onEncoderParamsChanged(i, 0, 0);
        if (TXCQoS.access$1200(this.a) != null)
        {
          localBundle = new Bundle();
          localBundle.putCharSequence("EVT_MSG", "调整编码码率:new bitrate:".concat(String.valueOf(i)));
          localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
          localBundle.putString("EVT_USERID", TXCQoS.access$1400(this.a));
          TXCQoS.access$1200(this.a).onNotifyEvent(1006, localBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.qos.TXCQoS.1
 * JD-Core Version:    0.7.0.1
 */