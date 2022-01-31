package com.tencent.kinda.framework.module.impl;

import android.content.Intent;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidITransmitKvDataCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.g.a.vk.a;
import com.tencent.mm.sdk.b.c;

class KindaWalletMixManagerImpl$1
  extends c<vk>
{
  KindaWalletMixManagerImpl$1(KindaWalletMixManagerImpl paramKindaWalletMixManagerImpl)
  {
    AppMethodBeat.i(144542);
    this.__eventId = vk.class.getName().hashCode();
    AppMethodBeat.o(144542);
  }
  
  public boolean callback(vk paramvk)
  {
    AppMethodBeat.i(144543);
    int i = paramvk.cMA.result;
    if (i == 0) {
      if (KindaWalletMixManagerImpl.access$000(this.this$0) != null) {
        KindaWalletMixManagerImpl.access$000(this.this$0).call();
      }
    }
    for (;;)
    {
      KindaWalletMixManagerImpl.access$200(this.this$0).dead();
      AppMethodBeat.o(144543);
      return false;
      if ((i == -1) && (KindaWalletMixManagerImpl.access$100(this.this$0) != null))
      {
        ITransmitKvData localITransmitKvData = ITransmitKvData.create();
        paramvk = paramvk.cMA.intent;
        if (paramvk != null) {
          localITransmitKvData.putBool("is_jsapi_close_page", "1".equals(paramvk.getStringExtra("is_jsapi_close_page")));
        }
        KindaWalletMixManagerImpl.access$100(this.this$0).call(localITransmitKvData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaWalletMixManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */