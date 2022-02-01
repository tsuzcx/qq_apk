package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.plugin.hp.b.b.a;
import com.tencent.mm.plugin.hp.b.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.tinker.lib.f.c;
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
  
  private void cGf()
  {
    AppMethodBeat.i(117477);
    new a(this.context, new a.a()
    {
      public final void cGc()
      {
        AppMethodBeat.i(117466);
        if (d.this.fpb()) {
          b.cFS();
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
      if (!com.tencent.tinker.lib.e.a.kI(this.context).xZI)
      {
        com.tencent.tinker.lib.f.a.w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
        ad.d("Tinker.TinkerPatchLoadReporter", "onLoadResult loadcode:%d icost:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        if (paramInt == 0) {
          ad.i("Tinker.TinkerPatchLoadReporter", "onLoadResult currentVersion:%s", new Object[] { com.tencent.tinker.lib.e.a.kI(this.context).IEQ.IEV });
        }
        localObject = com.tencent.tinker.lib.e.a.kI(this.context);
        if ((((com.tencent.tinker.lib.e.a)localObject).IEQ == null) || (((com.tencent.tinker.lib.e.a)localObject).IEQ.IFg == null)) {
          break label322;
        }
        paramFile = h.glW;
        str = (String)((com.tencent.tinker.lib.e.a)localObject).IEQ.IFg.get("patch.client.ver");
        localObject = (String)((com.tencent.tinker.lib.e.a)localObject).IEQ.IFg.get("NEW_TINKER_ID");
        i = b.b.sxH.value;
        if (paramInt != 0) {
          break label312;
        }
      }
      break;
    }
    label312:
    for (paramInt = b.a.sxE.value;; paramInt = b.a.sxD.value)
    {
      b.e(paramFile, str, (String)localObject, i, paramInt);
      AppMethodBeat.o(117475);
      return;
      b.x(paramLong, com.tencent.tinker.lib.e.a.kI(this.context).xZI);
      break;
      paramFile = new File(SharePatchFileUtil.getPatchTempDirectory(this.context), "temp.apk").getAbsolutePath();
      if ((paramFile == null) || (!new File(paramFile).exists()))
      {
        com.tencent.tinker.lib.f.a.w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad patch file: %s is not exist, just return", new Object[] { paramFile });
        break label56;
      }
      new a(this.context, new a.a()
      {
        public final void cGc()
        {
          AppMethodBeat.i(117467);
          if (c.kN(d.this.context).fpd()) {
            b.cFS();
          }
          AppMethodBeat.o(117467);
        }
      });
      break label56;
    }
    label322:
    ad.i("Tinker.TinkerPatchLoadReporter", "patchCheck properties is null.");
    AppMethodBeat.o(117475);
  }
  
  public final void a(File paramFile, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117470);
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType:%d, isDirectory:%b", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramInt == 4) {
      cGf();
    }
    for (;;)
    {
      if (paramInt == 1)
      {
        paramFile = com.tencent.tinker.lib.e.a.kI(this.context).IEQ;
        if ((paramFile.IEV != null) && ("00000000000000000000000000000000".equals(paramFile.IEV)))
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
          ShareTinkerInternals.killAllOtherProcess(this.context);
        }
      }
      b.Fc(paramInt);
      AppMethodBeat.o(117470);
      return;
      fpa();
    }
  }
  
  public final void a(String paramString1, String paramString2, File paramFile, String paramString3)
  {
    AppMethodBeat.i(117474);
    super.a(paramString1, paramString2, paramFile, paramString3);
    b.cFW();
    AppMethodBeat.o(117474);
  }
  
  public final void a(Throwable paramThrowable, int paramInt)
  {
    AppMethodBeat.i(117468);
    super.a(paramThrowable, paramInt);
    b.a(paramThrowable, paramInt);
    AppMethodBeat.o(117468);
  }
  
  public final void b(int paramInt, Throwable paramThrowable)
  {
    AppMethodBeat.i(117471);
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret: type: %d, throwable: %s", new Object[] { Integer.valueOf(paramInt), paramThrowable });
    switch (paramInt)
    {
    }
    for (;;)
    {
      cGf();
      b.a(paramInt, paramThrowable);
      AppMethodBeat.o(117471);
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
    AppMethodBeat.i(117469);
    super.b(paramFile, paramInt);
    b.Fd(paramInt);
    AppMethodBeat.o(117469);
  }
  
  public final void b(String paramString1, String paramString2, File paramFile)
  {
    AppMethodBeat.i(117473);
    super.b(paramString1, paramString2, paramFile);
    b.cFV();
    AppMethodBeat.o(117473);
  }
  
  public final void c(File paramFile, int paramInt)
  {
    AppMethodBeat.i(117472);
    super.c(paramFile, paramInt);
    b.E(aj.EUA, paramInt);
    AppMethodBeat.o(117472);
  }
  
  public final void d(File paramFile, int paramInt)
  {
    AppMethodBeat.i(117476);
    super.d(paramFile, paramInt);
    if ((paramInt == -26) || (paramInt == -5))
    {
      ShareTinkerInternals.setTinkerDisableWithSharedPreferences(this.context);
      com.tencent.tinker.lib.e.a.kI(this.context).tinkerFlags = 0;
    }
    b.EZ(paramInt);
    AppMethodBeat.o(117476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.d
 * JD-Core Version:    0.7.0.1
 */