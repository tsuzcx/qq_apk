package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.lib.d.b;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

public final class f
  extends b
{
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(File paramFile, SharePatchInfo paramSharePatchInfo, String paramString)
  {
    AppMethodBeat.i(117493);
    super.a(paramFile, paramSharePatchInfo, paramString);
    c.fPN();
    AppMethodBeat.o(117493);
  }
  
  public final void a(File paramFile1, File paramFile2, String paramString, int paramInt)
  {
    AppMethodBeat.i(117492);
    super.a(paramFile1, paramFile2, paramString, paramInt);
    c.YW(paramInt);
    AppMethodBeat.o(117492);
  }
  
  public final void a(File paramFile, Throwable paramThrowable)
  {
    AppMethodBeat.i(117488);
    super.a(paramFile, paramThrowable);
    c.x(paramThrowable);
    AppMethodBeat.o(117488);
  }
  
  public final void a(File paramFile, List<File> paramList, Throwable paramThrowable)
  {
    AppMethodBeat.i(117487);
    super.a(paramFile, paramList, paramThrowable);
    c.y(paramThrowable);
    AppMethodBeat.o(117487);
  }
  
  public final void a(File paramFile, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(117491);
    super.a(paramFile, paramBoolean, paramLong);
    Log.i("Tinker.TinkerPatchReporter", "onPatchResult start");
    c.L(paramLong, paramBoolean);
    Log.appenderFlushSync();
    AppMethodBeat.o(117491);
  }
  
  public final void aW(Intent paramIntent)
  {
    AppMethodBeat.i(117486);
    super.aW(paramIntent);
    c.aV(paramIntent);
    AppMethodBeat.o(117486);
  }
  
  public final void b(File paramFile, String paramString1, String paramString2)
  {
    AppMethodBeat.i(117489);
    super.b(paramFile, paramString1, paramString2);
    c.fPM();
    AppMethodBeat.o(117489);
  }
  
  public final void h(File paramFile, int paramInt)
  {
    AppMethodBeat.i(117490);
    super.h(paramFile, paramInt);
    c.YV(paramInt);
    AppMethodBeat.o(117490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.f
 * JD-Core Version:    0.7.0.1
 */