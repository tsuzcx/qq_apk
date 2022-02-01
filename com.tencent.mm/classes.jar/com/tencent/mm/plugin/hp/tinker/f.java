package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

public final class f
  extends com.tencent.tinker.lib.d.b
{
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(File paramFile, SharePatchInfo paramSharePatchInfo, String paramString)
  {
    AppMethodBeat.i(117493);
    super.a(paramFile, paramSharePatchInfo, paramString);
    com.tencent.mm.plugin.hp.b.b.dfd();
    AppMethodBeat.o(117493);
  }
  
  public final void a(File paramFile1, File paramFile2, String paramString, int paramInt)
  {
    AppMethodBeat.i(117492);
    super.a(paramFile1, paramFile2, paramString, paramInt);
    com.tencent.mm.plugin.hp.b.b.IQ(paramInt);
    AppMethodBeat.o(117492);
  }
  
  public final void a(File paramFile, Throwable paramThrowable)
  {
    AppMethodBeat.i(117488);
    super.a(paramFile, paramThrowable);
    com.tencent.mm.plugin.hp.b.b.j(paramThrowable);
    AppMethodBeat.o(117488);
  }
  
  public final void a(File paramFile, List<File> paramList, Throwable paramThrowable)
  {
    AppMethodBeat.i(117487);
    super.a(paramFile, paramList, paramThrowable);
    com.tencent.mm.plugin.hp.b.b.k(paramThrowable);
    AppMethodBeat.o(117487);
  }
  
  public final void a(File paramFile, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(117491);
    super.a(paramFile, paramBoolean, paramLong);
    ae.i("Tinker.TinkerPatchReporter", "onPatchResult start");
    com.tencent.mm.plugin.hp.b.b.w(paramLong, paramBoolean);
    ae.fop();
    AppMethodBeat.o(117491);
  }
  
  public final void ax(Intent paramIntent)
  {
    AppMethodBeat.i(117486);
    super.ax(paramIntent);
    com.tencent.mm.plugin.hp.b.b.aw(paramIntent);
    AppMethodBeat.o(117486);
  }
  
  public final void b(File paramFile, String paramString1, String paramString2)
  {
    AppMethodBeat.i(117489);
    super.b(paramFile, paramString1, paramString2);
    com.tencent.mm.plugin.hp.b.b.dfc();
    AppMethodBeat.o(117489);
  }
  
  public final void e(File paramFile, int paramInt)
  {
    AppMethodBeat.i(117490);
    super.e(paramFile, paramInt);
    com.tencent.mm.plugin.hp.b.b.IP(paramInt);
    AppMethodBeat.o(117490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.f
 * JD-Core Version:    0.7.0.1
 */