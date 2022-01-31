package com.google.android.gms.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzz<T>
{
  final int what;
  final int zzck;
  final TaskCompletionSource<T> zzcl = new TaskCompletionSource();
  final Bundle zzcm;
  
  zzz(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.zzck = paramInt1;
    this.what = paramInt2;
    this.zzcm = paramBundle;
  }
  
  public String toString()
  {
    int i = this.what;
    int j = this.zzck;
    zzu();
    return 55 + "Request { what=" + i + " id=" + j + " oneWay=false}";
  }
  
  final void zzd(zzaa paramzzaa)
  {
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramzzaa);
      new StringBuilder(String.valueOf(str1).length() + 14 + String.valueOf(str2).length()).append("Failing ").append(str1).append(" with ").append(str2);
    }
    this.zzcl.setException(paramzzaa);
  }
  
  abstract void zzh(Bundle paramBundle);
  
  abstract boolean zzu();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.iid.zzz
 * JD-Core Version:    0.7.0.1
 */