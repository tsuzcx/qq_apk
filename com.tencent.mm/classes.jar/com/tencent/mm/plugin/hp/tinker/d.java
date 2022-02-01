package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.model.c;
import com.tencent.mm.plugin.hp.model.c.a;
import com.tencent.mm.plugin.hp.model.c.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.HashMap;

public final class d
  extends com.tencent.tinker.lib.d.a
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  private void fQb()
  {
    AppMethodBeat.i(117477);
    new a(this.context, new a.a()
    {
      public final void fPW()
      {
        AppMethodBeat.i(117466);
        if (d.this.kcd()) {
          c.fPL();
        }
        AppMethodBeat.o(117466);
      }
    });
    AppMethodBeat.o(117477);
  }
  
  public final void a(File paramFile, int paramInt, long paramLong)
  {
    AppMethodBeat.i(117475);
    super.a(paramFile, paramInt, paramLong);
    label56:
    Object localObject;
    String str;
    int i;
    switch (paramInt)
    {
    default: 
      if (!com.tencent.tinker.lib.e.a.oy(this.context).rgc)
      {
        ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
        Log.d("Tinker.TinkerPatchLoadReporter", "onLoadResult loadcode:%d icost:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        if (paramInt == 0) {
          Log.i("Tinker.TinkerPatchLoadReporter", "onLoadResult currentVersion:%s", new Object[] { com.tencent.tinker.lib.e.a.oy(this.context).ahRM.ahRR });
        }
        localObject = com.tencent.tinker.lib.e.a.oy(this.context);
        if ((((com.tencent.tinker.lib.e.a)localObject).ahRM == null) || (((com.tencent.tinker.lib.e.a)localObject).ahRM.ahSc == null)) {
          break label322;
        }
        paramFile = BuildInfo.CLIENT_VERSION;
        str = (String)((com.tencent.tinker.lib.e.a)localObject).ahRM.ahSc.get("patch.client.ver");
        localObject = (String)((com.tencent.tinker.lib.e.a)localObject).ahRM.ahSc.get("NEW_TINKER_ID");
        i = c.b.JDJ.value;
        if (paramInt != 0) {
          break label312;
        }
      }
      break;
    }
    label312:
    for (paramInt = c.a.JDG.value;; paramInt = c.a.JDF.value)
    {
      c.g(paramFile, str, (String)localObject, i, paramInt);
      AppMethodBeat.o(117475);
      return;
      c.M(paramLong, com.tencent.tinker.lib.e.a.oy(this.context).rgc);
      break;
      paramFile = new File(SharePatchFileUtil.getPatchTempDirectory(this.context), "temp.apk").getAbsolutePath();
      if ((paramFile == null) || (!new File(paramFile).exists()))
      {
        ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad patch file: %s is not exist, just return", new Object[] { paramFile });
        break label56;
      }
      new a(this.context, new a.a()
      {
        public final void fPW()
        {
          AppMethodBeat.i(117467);
          if (com.tencent.tinker.lib.f.d.oD(d.this.context).kch()) {
            c.fPL();
          }
          AppMethodBeat.o(117467);
        }
      });
      break label56;
    }
    label322:
    Log.i("Tinker.TinkerPatchLoadReporter", "patchCheck properties is null.");
    AppMethodBeat.o(117475);
  }
  
  public final void a(File paramFile, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117470);
    ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType:%d, isDirectory:%b", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramInt == 4) {
      fQb();
    }
    for (;;)
    {
      if (paramInt == 1)
      {
        paramFile = com.tencent.tinker.lib.e.a.oy(this.context).ahRM;
        if ((paramFile.ahRR != null) && ("00000000000000000000000000000000".equals(paramFile.ahRR)))
        {
          ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
          ShareTinkerInternals.killAllOtherProcess(this.context);
        }
      }
      c.YX(paramInt);
      AppMethodBeat.o(117470);
      return;
      kcc();
    }
  }
  
  public final void a(String paramString1, String paramString2, File paramFile, String paramString3)
  {
    AppMethodBeat.i(117474);
    super.a(paramString1, paramString2, paramFile, paramString3);
    c.fPP();
    AppMethodBeat.o(117474);
  }
  
  public final void a(Throwable paramThrowable, int paramInt)
  {
    AppMethodBeat.i(117468);
    super.a(paramThrowable, paramInt);
    c.a(paramThrowable, paramInt);
    AppMethodBeat.o(117468);
  }
  
  public final void b(String paramString1, String paramString2, File paramFile)
  {
    AppMethodBeat.i(117473);
    super.b(paramString1, paramString2, paramFile);
    c.fPO();
    AppMethodBeat.o(117473);
  }
  
  public final void c(int paramInt, Throwable paramThrowable)
  {
    AppMethodBeat.i(117471);
    ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret: type: %d, throwable: %s", new Object[] { Integer.valueOf(paramInt), paramThrowable });
    switch (paramInt)
    {
    }
    for (;;)
    {
      fQb();
      c.b(paramInt, paramThrowable);
      AppMethodBeat.o(117471);
      return;
      ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, can get instruction set from existed oat file", new Object[0]);
      continue;
      ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, command line to interpret return error", new Object[0]);
      continue;
      ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret ok", new Object[0]);
    }
  }
  
  public final void e(File paramFile, int paramInt)
  {
    AppMethodBeat.i(117469);
    super.e(paramFile, paramInt);
    c.YY(paramInt);
    AppMethodBeat.o(117469);
  }
  
  public final void f(File paramFile, int paramInt)
  {
    AppMethodBeat.i(117472);
    super.f(paramFile, paramInt);
    c.Y(MMApplicationContext.sIsRevChange, paramInt);
    AppMethodBeat.o(117472);
  }
  
  public final void g(File paramFile, int paramInt)
  {
    AppMethodBeat.i(117476);
    super.g(paramFile, paramInt);
    if ((paramInt == -26) || (paramInt == -5))
    {
      ShareTinkerInternals.setTinkerDisableWithSharedPreferences(this.context);
      com.tencent.tinker.lib.e.a.oy(this.context).tinkerFlags = 0;
    }
    c.YU(paramInt);
    AppMethodBeat.o(117476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.d
 * JD-Core Version:    0.7.0.1
 */