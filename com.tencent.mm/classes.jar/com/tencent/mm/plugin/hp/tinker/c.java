package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.plugin.hp.b.b.a;
import com.tencent.mm.plugin.hp.b.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.HashMap;

public final class c
  extends com.tencent.tinker.lib.d.a
{
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  private void bbh()
  {
    new a(this.context, new c.1(this));
  }
  
  public final void a(File paramFile, int paramInt)
  {
    super.a(paramFile, paramInt);
    b.sC(paramInt);
  }
  
  public final void a(File paramFile, int paramInt, long paramLong)
  {
    super.a(paramFile, paramInt, paramLong);
    label52:
    Object localObject1;
    Object localObject2;
    int i;
    switch (paramInt)
    {
    default: 
      if (!com.tencent.tinker.lib.e.a.hN(this.context).prD)
      {
        com.tencent.tinker.lib.f.a.w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
        y.d("Tinker.TinkerPatchLoadReporter", "onLoadResult loadcode:%d icost:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        if (paramInt == 0)
        {
          localObject1 = com.tencent.tinker.lib.e.a.hN(this.context).wWq;
          y.i("Tinker.TinkerPatchLoadReporter", "onLoadResult currentVersion:%s", new Object[] { ((com.tencent.tinker.lib.e.d)localObject1).wWv });
          if (!TextUtils.isEmpty(((com.tencent.tinker.lib.e.d)localObject1).wWv))
          {
            paramFile = this.context;
            localObject1 = ((com.tencent.tinker.lib.e.d)localObject1).wWv;
            paramFile.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_version_key", (String)localObject1).apply();
          }
        }
        localObject2 = com.tencent.tinker.lib.e.a.hN(this.context);
        if ((((com.tencent.tinker.lib.e.a)localObject2).wWq == null) || (((com.tencent.tinker.lib.e.a)localObject2).wWq.wWI == null)) {
          break label366;
        }
        paramFile = com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION;
        localObject1 = (String)((com.tencent.tinker.lib.e.a)localObject2).wWq.wWI.get("patch.client.ver");
        localObject2 = (String)((com.tencent.tinker.lib.e.a)localObject2).wWq.wWI.get("NEW_TINKER_ID");
        i = b.b.lmJ.value;
        if (paramInt != 0) {
          break label356;
        }
      }
      break;
    }
    label356:
    for (paramInt = b.a.lmG.value;; paramInt = b.a.lmF.value)
    {
      b.e(paramFile, (String)localObject1, (String)localObject2, i, paramInt);
      return;
      b.o(paramLong, com.tencent.tinker.lib.e.a.hN(this.context).prD);
      break;
      paramFile = new File(SharePatchFileUtil.hY(this.context), "temp.apk").getAbsolutePath();
      if ((paramFile == null) || (!new File(paramFile).exists()))
      {
        com.tencent.tinker.lib.f.a.w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad patch file: %s is not exist, just return", new Object[] { paramFile });
        break label52;
      }
      new a(this.context, new c.2(this));
      break label52;
    }
    label366:
    y.i("Tinker.TinkerPatchLoadReporter", "patchCheck properties is null.");
  }
  
  public final void a(File paramFile, int paramInt, boolean paramBoolean)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType:%d, isDirectory:%b", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramInt == 4) {
      bbh();
    }
    for (;;)
    {
      if (paramInt == 1)
      {
        paramFile = com.tencent.tinker.lib.e.a.hN(this.context).wWq;
        if ((paramFile.wWv != null) && ("00000000000000000000000000000000".equals(paramFile.wWv)))
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
          ShareTinkerInternals.ig(this.context);
        }
      }
      b.sB(paramInt);
      return;
      cQF();
    }
  }
  
  public final void a(String paramString1, String paramString2, File paramFile)
  {
    super.a(paramString1, paramString2, paramFile);
    b.bbd();
  }
  
  public final void a(String paramString1, String paramString2, File paramFile, String paramString3)
  {
    super.a(paramString1, paramString2, paramFile, paramString3);
    b.bbe();
  }
  
  public final void a(Throwable paramThrowable, int paramInt)
  {
    super.a(paramThrowable, paramInt);
    b.a(paramThrowable, paramInt);
  }
  
  public final void b(int paramInt, Throwable paramThrowable)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret: type: %d, throwable: %s", new Object[] { Integer.valueOf(paramInt), paramThrowable });
    switch (paramInt)
    {
    }
    for (;;)
    {
      bbh();
      b.a(paramInt, paramThrowable);
      return;
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, can get instruction set from existed oat file", new Object[0]);
      continue;
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, command line to interpret return error", new Object[0]);
      continue;
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret ok", new Object[0]);
    }
  }
  
  public final void b(File paramFile, int paramInt)
  {
    super.b(paramFile, paramInt);
    b.m(ae.ufk, paramInt);
  }
  
  public final void c(File paramFile, int paramInt)
  {
    super.c(paramFile, paramInt);
    if ((paramInt == -26) || (paramInt == -5))
    {
      ShareTinkerInternals.ic(this.context);
      com.tencent.tinker.lib.e.a.hN(this.context).tinkerFlags = 0;
    }
    b.sy(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.c
 * JD-Core Version:    0.7.0.1
 */