package com.tencent.mm.plugin.facedetect.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class d$1
  extends ah
{
  d$1(d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    y.i("MicroMsg.NumberFaceMotion", "hy: refresh number");
    this.jPM.aOR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.d.1
 * JD-Core Version:    0.7.0.1
 */