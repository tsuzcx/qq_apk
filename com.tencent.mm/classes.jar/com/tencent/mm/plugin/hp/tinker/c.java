package com.tencent.mm.plugin.hp.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ae;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.plugin.hp.b.b.a;
import com.tencent.mm.plugin.hp.b.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

public final class c
  extends com.tencent.tinker.lib.b.a
{
  private final int syu;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(117464);
    this.syu = ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "application maxMemory:" + this.syu, new Object[0]);
    AppMethodBeat.o(117464);
  }
  
  public final int gR(String paramString1, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(117465);
    Object localObject = new File(paramString1);
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "receive a patch file: %s, file size:%d", new Object[] { paramString1, Long.valueOf(SharePatchFileUtil.getFileOrDirectorySize((File)localObject)) });
    int j = super.gR(paramString1, paramString2);
    int i = j;
    if (j == 0)
    {
      if (this.syu < 45) {
        i = -23;
      }
    }
    else
    {
      j = i;
      if (i == 0)
      {
        com.tencent.tinker.lib.e.a.kI(this.context);
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
          if (ae.b(new Throwable().getStackTrace())) {
            i = -26;
          }
        }
      }
      localObject = com.tencent.mm.plugin.hp.c.c.fastGetPatchPackageMeta((File)localObject);
      if (localObject == null) {
        break label307;
      }
      paramString1 = h.glW;
      paramString2 = ((Properties)localObject).getProperty("patch.client.ver");
      localObject = ((Properties)localObject).getProperty("NEW_TINKER_ID");
      int k = b.b.sxI.value;
      if (i != 0) {
        break label296;
      }
      j = b.a.sxE.value;
      label200:
      b.e(paramString1, paramString2, (String)localObject, k, j);
    }
    for (;;)
    {
      if (i == 0) {
        bool = true;
      }
      b.mj(bool);
      AppMethodBeat.o(117465);
      return i;
      if (!com.tencent.mm.plugin.hp.c.c.cGr())
      {
        i = -21;
        break;
      }
      i = 0;
      break;
      label247:
      paramString1 = paramString1.getProperty("patch.basepack.client.ver");
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "get BASE_CLIENT_VERSION:".concat(String.valueOf(paramString1)), new Object[0]);
      if (paramString1 != null)
      {
        j = i;
        if (paramString1.equalsIgnoreCase(com.tencent.mm.loader.j.a.glW)) {
          break label108;
        }
      }
      j = -25;
      break label108;
      label296:
      j = b.a.sxD.value;
      break label200;
      label307:
      ad.i("Tinker.TinkerPatchListener", "patchCheck properties is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.c
 * JD-Core Version:    0.7.0.1
 */