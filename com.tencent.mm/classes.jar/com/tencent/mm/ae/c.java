package com.tencent.mm.ae;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/kt/CodeMan;", "", "taskName", "", "(Ljava/lang/String;)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "begin", "", "diff", "getdiff", "", "mark", "toString", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public f.a mHw;
  private final String taskName;
  
  public c(String paramString)
  {
    AppMethodBeat.i(153445);
    this.taskName = paramString;
    this.mHw = new f.a();
    this.mHw.lYS = SystemClock.elapsedRealtime();
    AppMethodBeat.o(153445);
  }
  
  public final void bbW()
  {
    AppMethodBeat.i(153443);
    Log.i("MicroMsg.CodeUtil", toString());
    AppMethodBeat.o(153443);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(153444);
    String str = "CodeMan task " + this.taskName + " cost : " + this.mHw.aPY();
    AppMethodBeat.o(153444);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ae.c
 * JD-Core Version:    0.7.0.1
 */