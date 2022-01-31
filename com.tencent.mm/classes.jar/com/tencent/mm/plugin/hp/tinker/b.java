package com.tencent.mm.plugin.hp.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.mm.app.s;
import com.tencent.mm.plugin.hp.b.b.a;
import com.tencent.mm.plugin.hp.b.b.b;
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

public final class b
  extends com.tencent.tinker.lib.b.a
{
  private final int lno;
  
  public b(Context paramContext)
  {
    super(paramContext);
    this.lno = ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "application maxMemory:" + this.lno, new Object[0]);
  }
  
  public final int dz(String paramString1, String paramString2)
  {
    boolean bool = false;
    Object localObject = new File(paramString1);
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "receive a patch file: %s, file size:%d", new Object[] { paramString1, Long.valueOf(SharePatchFileUtil.ag((File)localObject)) });
    int j = super.dz(paramString1, paramString2);
    int i = j;
    if (j == 0)
    {
      if (this.lno < 45) {
        i = -23;
      }
    }
    else
    {
      j = i;
      if (i == 0)
      {
        com.tencent.tinker.lib.e.a.hN(this.context);
        j = i;
        if (i == 0)
        {
          paramString1 = ShareTinkerInternals.K((File)localObject);
          if (paramString1 != null) {
            break label237;
          }
          j = -24;
        }
      }
      label103:
      i = j;
      if (j == 0)
      {
        i = j;
        if (ShareTinkerInternals.cQP())
        {
          i = j;
          if (s.a(new Throwable().getStackTrace())) {
            i = -26;
          }
        }
      }
      localObject = c.K((File)localObject);
      if (localObject == null) {
        break label304;
      }
      paramString1 = d.CLIENT_VERSION;
      paramString2 = ((Properties)localObject).getProperty("patch.client.ver");
      localObject = ((Properties)localObject).getProperty("NEW_TINKER_ID");
      int k = b.b.lmK.value;
      if (i != 0) {
        break label293;
      }
      j = b.a.lmG.value;
      label195:
      com.tencent.mm.plugin.hp.b.b.e(paramString1, paramString2, (String)localObject, k, j);
    }
    for (;;)
    {
      if (i == 0) {
        bool = true;
      }
      com.tencent.mm.plugin.hp.b.b.gM(bool);
      return i;
      if (!c.bbr())
      {
        i = -21;
        break;
      }
      i = 0;
      break;
      label237:
      paramString1 = paramString1.getProperty("patch.basepack.client.ver");
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "get BASE_CLIENT_VERSION:" + paramString1, new Object[0]);
      if (paramString1 != null)
      {
        j = i;
        if (paramString1.equalsIgnoreCase(com.tencent.mm.loader.a.a.CLIENT_VERSION)) {
          break label103;
        }
      }
      j = -25;
      break label103;
      label293:
      j = b.a.lmF.value;
      break label195;
      label304:
      y.i("Tinker.TinkerPatchListener", "patchCheck properties is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.b
 * JD-Core Version:    0.7.0.1
 */