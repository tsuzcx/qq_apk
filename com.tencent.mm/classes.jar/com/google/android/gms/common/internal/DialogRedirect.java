package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleFragment;

public abstract class DialogRedirect
  implements DialogInterface.OnClickListener
{
  public static DialogRedirect getInstance(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    return new zzb(paramIntent, paramActivity, paramInt);
  }
  
  public static DialogRedirect getInstance(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    return new zzc(paramIntent, paramFragment, paramInt);
  }
  
  public static DialogRedirect getInstance(LifecycleFragment paramLifecycleFragment, Intent paramIntent, int paramInt)
  {
    return new zzd(paramIntent, paramLifecycleFragment, paramInt);
  }
  
  /* Error */
  public void onClick(android.content.DialogInterface paramDialogInterface, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 37	com/google/android/gms/common/internal/DialogRedirect:redirect	()V
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
    //   0	28	0	this	DialogRedirect
    //   0	28	1	paramDialogInterface	android.content.DialogInterface
    //   0	28	2	paramInt	int
    //   11	1	3	localActivityNotFoundException	android.content.ActivityNotFoundException
    //   19	8	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	11	android/content/ActivityNotFoundException
    //   0	4	19	finally
  }
  
  protected abstract void redirect();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.DialogRedirect
 * JD-Core Version:    0.7.0.1
 */