package com.tencent.mm.plugin.hp.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.af;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.plugin.hp.b.b.a;
import com.tencent.mm.plugin.hp.b.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.Properties;

public final class c
  extends com.tencent.tinker.lib.b.a
{
  private final int tGk;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(117464);
    this.tGk = ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
    ShareTinkerLog.v("Tinker.TinkerPatchListener", "application maxMemory:" + this.tGk, new Object[0]);
    AppMethodBeat.o(117464);
  }
  
  public final int hi(String paramString1, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(117465);
    Object localObject = new File(paramString1);
    ShareTinkerLog.v("Tinker.TinkerPatchListener", "receive a patch file: %s, file size:%d", new Object[] { paramString1, Long.valueOf(SharePatchFileUtil.getFileOrDirectorySize((File)localObject)) });
    int j = super.hi(paramString1, paramString2);
    int i = j;
    if (j == 0)
    {
      if (this.tGk < 45) {
        i = -23;
      }
    }
    else
    {
      j = i;
      if (i == 0)
      {
        com.tencent.tinker.lib.e.a.kX(this.context);
        j = i;
        if (i == 0)
        {
          paramString1 = ShareTinkerInternals.fastGetPatchPackageMeta((File)localObject);
          if (paramString1 != null) {
            break label247;
          }
          j = -24;
        }
      }
      label108:
      i = j;
      if (j == 0)
      {
        i = j;
        if (ShareTinkerInternals.isVmArt())
        {
          i = j;
          if (af.b(new Throwable().getStackTrace())) {
            i = -26;
          }
        }
      }
      localObject = com.tencent.mm.plugin.hp.c.c.fastGetPatchPackageMeta((File)localObject);
      if (localObject == null) {
        break label307;
      }
      paramString1 = h.gMJ;
      paramString2 = ((Properties)localObject).getProperty("patch.client.ver");
      localObject = ((Properties)localObject).getProperty("NEW_TINKER_ID");
      int k = b.b.tFx.value;
      if (i != 0) {
        break label296;
      }
      j = b.a.tFt.value;
      label200:
      b.e(paramString1, paramString2, (String)localObject, k, j);
    }
    for (;;)
    {
      if (i == 0) {
        bool = true;
      }
      b.nc(bool);
      AppMethodBeat.o(117465);
      return i;
      if (!com.tencent.mm.plugin.hp.c.c.cTB())
      {
        i = -21;
        break;
      }
      i = 0;
      break;
      label247:
      paramString1 = paramString1.getProperty("patch.basepack.client.ver");
      ShareTinkerLog.v("Tinker.TinkerPatchListener", "get BASE_CLIENT_VERSION:".concat(String.valueOf(paramString1)), new Object[0]);
      if (paramString1 != null)
      {
        j = i;
        if (paramString1.equalsIgnoreCase(com.tencent.mm.loader.j.a.gMJ)) {
          break label108;
        }
      }
      j = -25;
      break label108;
      label296:
      j = b.a.tFs.value;
      break label200;
      label307:
      ac.i("Tinker.TinkerPatchListener", "patchCheck properties is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.c
 * JD-Core Version:    0.7.0.1
 */