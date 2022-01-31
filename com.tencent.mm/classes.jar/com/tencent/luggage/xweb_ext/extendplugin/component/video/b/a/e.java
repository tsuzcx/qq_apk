package com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  volatile boolean bIT;
  int bIU;
  Handler bIV;
  e.b bIW;
  e.a bIX;
  
  e(Handler paramHandler)
  {
    AppMethodBeat.i(140000);
    this.bIT = false;
    this.bIU = 1000;
    this.bIX = new e.a(this, (byte)0);
    this.bIV = paramHandler;
    AppMethodBeat.o(140000);
  }
  
  final void start()
  {
    AppMethodBeat.i(140001);
    if (!this.bIT)
    {
      this.bIT = true;
      this.bIX.yg();
    }
    AppMethodBeat.o(140001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a.e
 * JD-Core Version:    0.7.0.1
 */