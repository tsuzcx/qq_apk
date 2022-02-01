package com.google.android.material.snackbar;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.material.a.b;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>>
{
  private static final boolean bEx;
  private static final int[] bEy;
  static final Handler handler;
  
  static
  {
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT <= 19)) {}
    for (boolean bool = true;; bool = false)
    {
      bEx = bool;
      bEy = new int[] { a.b.snackbarStyle };
      handler = new Handler(Looper.getMainLooper(), new Handler.Callback()
      {
        public final boolean handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return false;
          case 0: 
            paramAnonymousMessage = paramAnonymousMessage.obj;
            throw null;
          }
          Object localObject = paramAnonymousMessage.obj;
          int i = paramAnonymousMessage.arg1;
          throw null;
        }
      });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar
 * JD-Core Version:    0.7.0.1
 */