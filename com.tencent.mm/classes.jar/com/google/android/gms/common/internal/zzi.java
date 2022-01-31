package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.google.android.gms.internal.zzabf;

public abstract class zzi
  implements DialogInterface.OnClickListener
{
  public static zzi zza(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    return new zzi.1(paramIntent, paramActivity, paramInt);
  }
  
  public static zzi zza(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    return new zzi.2(paramIntent, paramFragment, paramInt);
  }
  
  public static zzi zza(zzabf paramzzabf, Intent paramIntent, int paramInt)
  {
    return new zzi.3(paramIntent, paramzzabf, paramInt);
  }
  
  /* Error */
  public void onClick(android.content.DialogInterface paramDialogInterface, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 37	com/google/android/gms/common/internal/zzi:zzxT	()V
    //   4: aload_1
    //   5: invokeinterface 42 1 0
    //   10: return
    //   11: astore_3
    //   12: aload_1
    //   13: invokeinterface 42 1 0
    //   18: return
    //   19: astore_3
    //   20: aload_1
    //   21: invokeinterface 42 1 0
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	zzi
    //   0	28	1	paramDialogInterface	android.content.DialogInterface
    //   0	28	2	paramInt	int
    //   11	1	3	localActivityNotFoundException	android.content.ActivityNotFoundException
    //   19	8	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	11	android/content/ActivityNotFoundException
    //   0	4	19	finally
  }
  
  protected abstract void zzxT();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzi
 * JD-Core Version:    0.7.0.1
 */