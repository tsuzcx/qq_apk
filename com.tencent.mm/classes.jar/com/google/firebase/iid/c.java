package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class c<T>
{
  final int bfg;
  final TaskCompletionSource<T> bfh = new TaskCompletionSource();
  final Bundle bfi;
  final int what;
  
  c(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.bfg = paramInt1;
    this.what = paramInt2;
    this.bfi = paramBundle;
  }
  
  final void a(d paramd)
  {
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramd);
      new StringBuilder(String.valueOf(str1).length() + 14 + String.valueOf(str2).length()).append("Failing ").append(str1).append(" with ").append(str2);
    }
    this.bfh.setException(paramd);
  }
  
  final void n(T paramT)
  {
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramT);
      new StringBuilder(String.valueOf(str1).length() + 16 + String.valueOf(str2).length()).append("Finishing ").append(str1).append(" with ").append(str2);
    }
    this.bfh.setResult(paramT);
  }
  
  public String toString()
  {
    int i = this.what;
    int j = this.bfg;
    boolean bool = zzw();
    return 55 + "Request { what=" + i + " id=" + j + " oneWay=" + bool + "}";
  }
  
  abstract void zzb(Bundle paramBundle);
  
  abstract boolean zzw();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.c
 * JD-Core Version:    0.7.0.1
 */