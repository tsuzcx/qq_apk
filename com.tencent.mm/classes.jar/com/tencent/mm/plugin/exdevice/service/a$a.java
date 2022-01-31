package com.tencent.mm.plugin.exdevice.service;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class a$a
  extends ah
{
  public a$a(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 6: 
    case 7: 
    default: 
      return;
    case 2: 
      a.a(this.jyC).a(2, 0, null, null, null, 0, null);
      return;
    case 1: 
      paramMessage = (a.c)paramMessage.obj;
      a.a(this.jyC).a(1, 0, null, paramMessage.hXy, paramMessage.gnO, paramMessage.goh, paramMessage.hXz);
      return;
    case 3: 
      paramMessage = (a.e)paramMessage.obj;
      a.a(this.jyC).c(paramMessage.jyG, paramMessage.jtf, paramMessage.jsT, paramMessage.ghs);
      return;
    case 4: 
      paramMessage = (a.d)paramMessage.obj;
      a.a(this.jyC).b(paramMessage.hXu, paramMessage.jyE, paramMessage.jyF, paramMessage.jsT);
      return;
    case 5: 
      ??? = (a.b)paramMessage.obj;
      a.a(this.jyC).a(paramMessage.arg1, ((a.b)???).hXu, ((a.b)???).jta, ((a.b)???).jyD, ((a.b)???).jsU);
      return;
    case 10: 
      paramMessage = (a.f)paramMessage.obj;
      a.a(this.jyC, paramMessage.hXu, paramMessage.mData);
      return;
    case 8: 
      paramMessage = (a.g)paramMessage.obj;
      a.a(this.jyC, paramMessage.jyG, paramMessage.jyH);
      return;
    case 9: 
      a.dQ(((Long)paramMessage.obj).longValue());
      return;
    case 11: 
      synchronized (a.b(this.jyC))
      {
        a.a(this.jyC, ((Long)paramMessage.obj).longValue());
        return;
      }
    }
    synchronized (a.b(this.jyC))
    {
      a.b(this.jyC, ((Long)paramMessage.obj).longValue());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.a.a
 * JD-Core Version:    0.7.0.1
 */