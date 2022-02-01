package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class c<T>
{
  final int bIX;
  final TaskCompletionSource<T> bIY = new TaskCompletionSource();
  final Bundle bIZ;
  final int what;
  
  c(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.bIX = paramInt1;
    this.what = paramInt2;
    this.bIZ = paramBundle;
  }
  
  final void P(T paramT)
  {
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramT);
      new StringBuilder(String.valueOf(str1).length() + 16 + String.valueOf(str2).length()).append("Finishing ").append(str1).append(" with ").append(str2);
    }
    this.bIY.setResult(paramT);
  }
  
  final void a(d paramd)
  {
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramd);
      new StringBuilder(String.valueOf(str1).length() + 14 + String.valueOf(str2).length()).append("Failing ").append(str1).append(" with ").append(str2);
    }
    this.bIY.setException(paramd);
  }
  
  public String toString()
  {
    int i = this.what;
    int j = this.bIX;
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