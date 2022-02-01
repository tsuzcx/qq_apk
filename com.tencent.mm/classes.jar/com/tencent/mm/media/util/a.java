package com.tencent.mm.media.util;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/util/CodeMan;", "", "taskName", "", "(Ljava/lang/String;)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "begin", "", "diff", "getdiff", "", "mark", "toString", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public f.a mHw;
  private final String taskName;
  
  public a(String paramString)
  {
    AppMethodBeat.i(93870);
    this.taskName = paramString;
    this.mHw = new f.a();
    this.mHw.lYS = SystemClock.elapsedRealtime();
    AppMethodBeat.o(93870);
  }
  
  public final void bbW()
  {
    AppMethodBeat.i(93868);
    Log.i("MicroMsg.CodeUtil", toString());
    AppMethodBeat.o(93868);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93869);
    String str = "CodeMan task " + this.taskName + " cost : " + this.mHw.aPY();
    AppMethodBeat.o(93869);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.util.a
 * JD-Core Version:    0.7.0.1
 */