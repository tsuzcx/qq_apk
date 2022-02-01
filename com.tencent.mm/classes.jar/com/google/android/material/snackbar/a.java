package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
{
  private static a dxJ;
  a dxK;
  private final Handler handler;
  final Object lock;
  
  private a()
  {
    AppMethodBeat.i(209808);
    this.lock = new Object();
    this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default: 
          return false;
        }
        a locala = a.this;
        paramAnonymousMessage = paramAnonymousMessage.obj;
        paramAnonymousMessage = locala.lock;
        return true;
      }
    });
    AppMethodBeat.o(209808);
  }
  
  static a WU()
  {
    AppMethodBeat.i(209802);
    if (dxJ == null) {
      dxJ = new a();
    }
    a locala = dxJ;
    AppMethodBeat.o(209802);
    return locala;
  }
  
  final boolean WV()
  {
    if (this.dxK != null) {
      throw null;
    }
    return false;
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.snackbar.a
 * JD-Core Version:    0.7.0.1
 */