package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class o$1
  extends ah
{
  o$1(o paramo, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage == null) {
      return;
    }
    o localo = this.lEk;
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localo.beg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.o.1
 * JD-Core Version:    0.7.0.1
 */