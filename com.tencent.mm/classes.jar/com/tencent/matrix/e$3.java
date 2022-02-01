package com.tencent.matrix;

import android.os.Build;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

final class e$3
  implements Runnable
{
  public final void run()
  {
    boolean bool = true;
    if ((Build.BRAND.toLowerCase().contains("lenovo")) && (q.aPo().toLowerCase().contains("tb"))) {
      bool = false;
    }
    for (;;)
    {
      Log.i("MatrixDelegate", "cameraCacheDevice = ".concat(String.valueOf(bool)));
      if (!bool)
      {
        MultiProcessMMKV.getDefault().encode("clicfg_camera_util_use_cache_new", false);
        MultiProcessMMKV.getDefault().encode("clicfg_voip_camera_info_use_cache_new", false);
      }
      return;
      if (Build.BRAND.toLowerCase().contains("royole")) {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.e.3
 * JD-Core Version:    0.7.0.1
 */