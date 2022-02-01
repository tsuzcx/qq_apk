package com.tencent.mm.plugin.finder.upload;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker;", "", "()V", "CHECK_TIME_INTV", "", "REPORT_VERSION", "", "TAG", "", "checkList", "", "Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker$CheckInfo;", "queuedTask", "", "cameraCheck", "context", "Landroid/content/Context;", "check", "", "localId", "progress", "checkAndReport", "waitingList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "checkInfo", "printRemoveList", "removeList", "start", "CheckInfo", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d GbA;
  static final List<Object> GbB;
  static final long GbC;
  private static final int GbD;
  static final String TAG;
  
  static
  {
    AppMethodBeat.i(342943);
    GbA = new d();
    TAG = "Finder.FinderPostChecker";
    GbB = (List)new ArrayList();
    GbC = 60000L;
    GbD = 1;
    AppMethodBeat.o(342943);
  }
  
  public static boolean cameraCheck(Context paramContext)
  {
    AppMethodBeat.i(342940);
    s.u(paramContext, "context");
    if ((a.p(paramContext, true)) || (a.dm(paramContext)) || (a.dl(paramContext)) || (a.u(paramContext, true)))
    {
      Log.i(TAG, "camera check false");
      AppMethodBeat.o(342940);
      return false;
    }
    AppMethodBeat.o(342940);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.d
 * JD-Core Version:    0.7.0.1
 */