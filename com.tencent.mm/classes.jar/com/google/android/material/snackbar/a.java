package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
{
  private static a bEJ;
  a bEK;
  private final Handler handler;
  final Object lock;
  
  private a()
  {
    AppMethodBeat.i(239461);
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
    AppMethodBeat.o(239461);
  }
  
  static a xx()
  {
    AppMethodBeat.i(239459);
    if (bEJ == null) {
      bEJ = new a();
    }
    a locala = bEJ;
    AppMethodBeat.o(239459);
    return locala;
  }
  
  final boolean xy()
  {
    if (this.bEK != null) {
      throw null;
    }
    return false;
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.snackbar.a
 * JD-Core Version:    0.7.0.1
 */