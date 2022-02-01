package com.tencent.matrix;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Iterator;
import java.util.List;

final class e$8
  implements Runnable
{
  e$8(e parame) {}
  
  public final void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Log.i("MatrixDelegate", "Save AccInfo To MMKV");
        i = 0;
        StringBuilder localStringBuilder = new StringBuilder("");
        Iterator localIterator = ((AccessibilityManager)MMApplicationContext.getContext().getSystemService("accessibility")).getEnabledAccessibilityServiceList(-1).iterator();
        if (localIterator.hasNext())
        {
          String str = ((AccessibilityServiceInfo)localIterator.next()).getId();
          if (!localStringBuilder.toString().contains(str))
          {
            localStringBuilder.append(str).append(";");
            i += 1;
          }
        }
        else
        {
          MultiProcessMMKV.getDefault().encode("Matrix-AccInfo", localStringBuilder.toString());
          return;
        }
      }
      finally
      {
        Log.e("MatrixDelegate", "get accessibilityInfo error : " + localObject.getMessage());
        return;
      }
      while (i <= 3) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.e.8
 * JD-Core Version:    0.7.0.1
 */