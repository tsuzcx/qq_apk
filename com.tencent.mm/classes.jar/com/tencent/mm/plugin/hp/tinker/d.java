package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.plugin.hp.b.b.a;
import com.tencent.mm.plugin.hp.b.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.HashMap;

public final class d
  extends com.tencent.tinker.lib.d.a
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  private void bIm()
  {
    AppMethodBeat.i(90641);
    new a(this.context, new d.1(this));
    AppMethodBeat.o(90641);
  }
  
  public final void a(File paramFile, int paramInt, long paramLong)
  {
    AppMethodBeat.i(90639);
    super.a(paramFile, paramInt, paramLong);
    label56:
    Object localObject1;
    Object localObject2;
    int i;
    switch (paramInt)
    {
    default: 
      if (!com.tencent.tinker.lib.e.a.jo(this.context).snC)
      {
        com.tencent.tinker.lib.f.a.w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
        ab.d("Tinker.TinkerPatchLoadReporter", "onLoadResult loadcode:%d icost:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        if (paramInt == 0)
        {
          localObject1 = com.tencent.tinker.lib.e.a.jo(this.context).BsT;
          ab.i("Tinker.TinkerPatchLoadReporter", "onLoadResult currentVersion:%s", new Object[] { ((com.tencent.tinker.lib.e.d)localObject1).BsY });
          if (!TextUtils.isEmpty(((com.tencent.tinker.lib.e.d)localObject1).BsY))
          {
            paramFile = this.context;
            localObject1 = ((com.tencent.tinker.lib.e.d)localObject1).BsY;
            paramFile.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_version_key", (String)localObject1).apply();
          }
        }
        localObject2 = com.tencent.tinker.lib.e.a.jo(this.context);
        if ((((com.tencent.tinker.lib.e.a)localObject2).BsT == null) || (((com.tencent.tinker.lib.e.a)localObject2).BsT.Btl == null)) {
          break label375;
        }
        paramFile = f.CLIENT_VERSION;
        localObject1 = (String)((com.tencent.tinker.lib.e.a)localObject2).BsT.Btl.get("patch.client.ver");
        localObject2 = (String)((com.tencent.tinker.lib.e.a)localObject2).BsT.Btl.get("NEW_TINKER_ID");
        i = b.b.nKb.value;
        if (paramInt != 0) {
          break label365;
        }
      }
      break;
    }
    label365:
    for (paramInt = b.a.nJY.value;; paramInt = b.a.nJX.value)
    {
      b.e(paramFile, (String)localObject1, (String)localObject2, i, paramInt);
      AppMethodBeat.o(90639);
      return;
      b.t(paramLong, com.tencent.tinker.lib.e.a.jo(this.context).snC);
      break;
      paramFile = new File(SharePatchFileUtil.jz(this.context), "temp.apk").getAbsolutePath();
      if ((paramFile == null) || (!new File(paramFile).exists()))
      {
        com.tencent.tinker.lib.f.a.w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad patch file: %s is not exist, just return", new Object[] { paramFile });
        break label56;
      }
      new a(this.context, new d.2(this));
      break label56;
    }
    label375:
    ab.i("Tinker.TinkerPatchLoadReporter", "patchCheck properties is null.");
    AppMethodBeat.o(90639);
  }
  
  public final void a(File paramFile, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(90634);
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType:%d, isDirectory:%b", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramInt == 4) {
      bIm();
    }
    for (;;)
    {
      if (paramInt == 1)
      {
        paramFile = com.tencent.tinker.lib.e.a.jo(this.context).BsT;
        if ((paramFile.BsY != null) && ("00000000000000000000000000000000".equals(paramFile.BsY)))
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
          ShareTinkerInternals.jJ(this.context);
        }
      }
      b.xA(paramInt);
      AppMethodBeat.o(90634);
      return;
      dWv();
    }
  }
  
  public final void a(String paramString1, String paramString2, File paramFile)
  {
    AppMethodBeat.i(90637);
    super.a(paramString1, paramString2, paramFile);
    b.bIe();
    AppMethodBeat.o(90637);
  }
  
  public final void a(String paramString1, String paramString2, File paramFile, String paramString3)
  {
    AppMethodBeat.i(90638);
    super.a(paramString1, paramString2, paramFile, paramString3);
    b.bIf();
    AppMethodBeat.o(90638);
  }
  
  public final void a(Throwable paramThrowable, int paramInt)
  {
    AppMethodBeat.i(90632);
    super.a(paramThrowable, paramInt);
    b.a(paramThrowable, paramInt);
    AppMethodBeat.o(90632);
  }
  
  public final void b(int paramInt, Throwable paramThrowable)
  {
    AppMethodBeat.i(90635);
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret: type: %d, throwable: %s", new Object[] { Integer.valueOf(paramInt), paramThrowable });
    switch (paramInt)
    {
    }
    for (;;)
    {
      bIm();
      b.a(paramInt, paramThrowable);
      AppMethodBeat.o(90635);
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
    AppMethodBeat.i(90633);
    super.b(paramFile, paramInt);
    b.xB(paramInt);
    AppMethodBeat.o(90633);
  }
  
  public final void c(File paramFile, int paramInt)
  {
    AppMethodBeat.i(90636);
    super.c(paramFile, paramInt);
    b.w(ah.ynK, paramInt);
    AppMethodBeat.o(90636);
  }
  
  public final void d(File paramFile, int paramInt)
  {
    AppMethodBeat.i(90640);
    super.d(paramFile, paramInt);
    if ((paramInt == -26) || (paramInt == -5))
    {
      ShareTinkerInternals.jD(this.context);
      com.tencent.tinker.lib.e.a.jo(this.context).tinkerFlags = 0;
    }
    b.xx(paramInt);
    AppMethodBeat.o(90640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.d
 * JD-Core Version:    0.7.0.1
 */