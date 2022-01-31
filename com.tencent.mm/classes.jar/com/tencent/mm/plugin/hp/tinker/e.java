package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

public final class e
  extends com.tencent.tinker.lib.d.b
{
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void J(Intent paramIntent)
  {
    super.J(paramIntent);
    com.tencent.mm.plugin.hp.b.b.I(paramIntent);
  }
  
  public final void a(File paramFile, SharePatchInfo paramSharePatchInfo, String paramString)
  {
    super.a(paramFile, paramSharePatchInfo, paramString);
    com.tencent.mm.plugin.hp.b.b.bbc();
  }
  
  public final void a(File paramFile1, File paramFile2, String paramString, int paramInt)
  {
    super.a(paramFile1, paramFile2, paramString, paramInt);
    com.tencent.mm.plugin.hp.b.b.sA(paramInt);
  }
  
  public final void a(File paramFile, String paramString1, String paramString2)
  {
    super.a(paramFile, paramString1, paramString2);
    com.tencent.mm.plugin.hp.b.b.bbb();
  }
  
  public final void a(File paramFile, Throwable paramThrowable)
  {
    super.a(paramFile, paramThrowable);
    com.tencent.mm.plugin.hp.b.b.d(paramThrowable);
  }
  
  public final void a(File paramFile, List<File> paramList, Throwable paramThrowable)
  {
    super.a(paramFile, paramList, paramThrowable);
    com.tencent.mm.plugin.hp.b.b.f(paramThrowable);
  }
  
  public final void a(File paramFile, boolean paramBoolean, long paramLong)
  {
    super.a(paramFile, paramBoolean, paramLong);
    y.i("Tinker.TinkerPatchReporter", "onPatchResult start");
    com.tencent.mm.plugin.hp.b.b.n(paramLong, paramBoolean);
    y.cqM();
  }
  
  public final void d(File paramFile, int paramInt)
  {
    super.d(paramFile, paramInt);
    com.tencent.mm.plugin.hp.b.b.sz(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.e
 * JD-Core Version:    0.7.0.1
 */