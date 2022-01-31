package com.tencent.mm.plugin.collect.model.voice;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  extends Handler
{
  b$1(b paramb) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(41025);
    if (this.kOz.kOs != null) {
      switch (paramMessage.what)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(41025);
      return;
      paramMessage = paramMessage.getData().getByteArray("data");
      this.kOz.kOs.m(0, paramMessage);
      AppMethodBeat.o(41025);
      return;
      this.kOz.kOs.m(-203, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.b.1
 * JD-Core Version:    0.7.0.1
 */