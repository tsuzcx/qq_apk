package com.tencent.mm.plugin.finder.live.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.bu;
import com.tencent.mm.plugin.finder.live.utils.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLivePauseReportHelper;", "", "()V", "FINISH", "", "PAUSE", "RECOVERY", "TAG", "", "getTAG", "()Ljava/lang/String;", "curType", "getCurType", "()I", "setCurType", "(I)V", "report", "", "type", "time", "uiState", "miniWindow", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
{
  private static int Aje;
  public static final ao CAQ;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(352778);
    CAQ = new ao();
    TAG = "FinderLivePauseReportHelper";
    AppMethodBeat.o(352778);
  }
  
  public static void c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(352765);
    Object localObject = a.DJT;
    boolean bool = a.bUx();
    Log.i(TAG, "report curType:" + Aje + " type:" + paramInt1 + ",time:" + paramInt2 + ", uiState:" + paramInt3 + ", miniWindow:" + paramBoolean + ", isAnchor:" + bool);
    if ((bool) || (paramInt1 == Aje))
    {
      AppMethodBeat.o(352765);
      return;
    }
    if ((paramInt1 == 3) && (!d.ee(paramInt3, 524288)) && (!d.ee(paramInt3, 32)) && (!d.ee(paramInt3, 64)) && (!d.ee(paramInt3, 262144)))
    {
      AppMethodBeat.o(352765);
      return;
    }
    Aje = paramInt1;
    localObject = new JSONObject();
    ((JSONObject)localObject).put("type", paramInt1);
    ((JSONObject)localObject).put("times", paramInt2);
    k localk = k.Doi;
    localObject = ((JSONObject)localObject).toString();
    s.s(localObject, "js.toString()");
    s.u(localObject, "actionResult");
    k.a(q.bu.DCI, (String)localObject, 0L, null, null, null, 60);
    AppMethodBeat.o(352765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ao
 * JD-Core Version:    0.7.0.1
 */