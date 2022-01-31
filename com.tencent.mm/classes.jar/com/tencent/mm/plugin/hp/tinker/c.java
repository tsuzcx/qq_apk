package com.tencent.mm.plugin.hp.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.x;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.plugin.hp.b.b.a;
import com.tencent.mm.plugin.hp.b.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

public final class c
  extends com.tencent.tinker.lib.b.a
{
  private final int nKH;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(90628);
    this.nKH = ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "application maxMemory:" + this.nKH, new Object[0]);
    AppMethodBeat.o(90628);
  }
  
  public final int eQ(String paramString1, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(90629);
    Object localObject = new File(paramString1);
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "receive a patch file: %s, file size:%d", new Object[] { paramString1, Long.valueOf(SharePatchFileUtil.ap((File)localObject)) });
    int j = super.eQ(paramString1, paramString2);
    int i = j;
    if (j == 0)
    {
      if (this.nKH < 45) {
        i = -23;
      }
    }
    else
    {
      j = i;
      if (i == 0)
      {
        com.tencent.tinker.lib.e.a.jo(this.context);
        j = i;
        if (i == 0)
        {
          paramString1 = ShareTinkerInternals.S((File)localObject);
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
        if (ShareTinkerInternals.dWE())
        {
          i = j;
          if (x.b(new Throwable().getStackTrace())) {
            i = -26;
          }
        }
      }
      localObject = com.tencent.mm.plugin.hp.d.c.S((File)localObject);
      if (localObject == null) {
        break label307;
      }
      paramString1 = f.CLIENT_VERSION;
      paramString2 = ((Properties)localObject).getProperty("patch.client.ver");
      localObject = ((Properties)localObject).getProperty("NEW_TINKER_ID");
      int k = b.b.nKc.value;
      if (i != 0) {
        break label296;
      }
      j = b.a.nJY.value;
      label200:
      b.e(paramString1, paramString2, (String)localObject, k, j);
    }
    for (;;)
    {
      if (i == 0) {
        bool = true;
      }
      b.iu(bool);
      AppMethodBeat.o(90629);
      return i;
      if (!com.tencent.mm.plugin.hp.d.c.bIw())
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
        if (paramString1.equalsIgnoreCase(com.tencent.mm.loader.j.a.CLIENT_VERSION)) {
          break label108;
        }
      }
      j = -25;
      break label108;
      label296:
      j = b.a.nJX.value;
      break label200;
      label307:
      ab.i("Tinker.TinkerPatchListener", "patchCheck properties is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.c
 * JD-Core Version:    0.7.0.1
 */