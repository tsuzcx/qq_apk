package com.tencent.mm.plugin.hp.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.al;
import com.tencent.mm.plugin.hp.model.c.a;
import com.tencent.mm.plugin.hp.model.c.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.Properties;

public final class c
  extends com.tencent.tinker.lib.b.a
{
  private final int JEA;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(117464);
    this.JEA = ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
    ShareTinkerLog.v("Tinker.TinkerPatchListener", "application maxMemory:" + this.JEA, new Object[0]);
    AppMethodBeat.o(117464);
  }
  
  public final int jG(String paramString1, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(117465);
    Object localObject = new File(paramString1);
    ShareTinkerLog.v("Tinker.TinkerPatchListener", "receive a patch file: %s, file size:%d", new Object[] { paramString1, Long.valueOf(SharePatchFileUtil.getFileOrDirectorySize((File)localObject)) });
    int j = super.jG(paramString1, paramString2);
    int i = j;
    if (j == 0)
    {
      if (this.JEA < 45) {
        i = -23;
      }
    }
    else
    {
      j = i;
      if (i == 0)
      {
        com.tencent.tinker.lib.e.a.oy(this.context);
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
          if (al.c(new Throwable().getStackTrace())) {
            i = -26;
          }
        }
      }
      localObject = com.tencent.mm.plugin.hp.b.c.fastGetPatchPackageMeta((File)localObject);
      if (localObject == null) {
        break label307;
      }
      paramString1 = BuildInfo.CLIENT_VERSION;
      paramString2 = ((Properties)localObject).getProperty("patch.client.ver");
      localObject = ((Properties)localObject).getProperty("NEW_TINKER_ID");
      int k = c.b.JDK.value;
      if (i != 0) {
        break label296;
      }
      j = c.a.JDG.value;
      label200:
      com.tencent.mm.plugin.hp.model.c.g(paramString1, paramString2, (String)localObject, k, j);
    }
    for (;;)
    {
      if (i == 0) {
        bool = true;
      }
      com.tencent.mm.plugin.hp.model.c.xw(bool);
      AppMethodBeat.o(117465);
      return i;
      if (!com.tencent.mm.plugin.hp.b.c.fQp())
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
        if (paramString1.equalsIgnoreCase(com.tencent.mm.loader.i.a.CLIENT_VERSION)) {
          break label108;
        }
      }
      j = -25;
      break label108;
      label296:
      j = c.a.JDF.value;
      break label200;
      label307:
      Log.i("Tinker.TinkerPatchListener", "patchCheck properties is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.c
 * JD-Core Version:    0.7.0.1
 */