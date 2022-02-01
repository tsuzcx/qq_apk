package com.tencent.mm.plugin.finder.live.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bf;
import com.tencent.mm.plugin.finder.live.utils.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLivePauseReportHelper;", "", "()V", "FINISH", "", "PAUSE", "RECOVERY", "TAG", "", "getTAG", "()Ljava/lang/String;", "curType", "getCurType", "()I", "setCurType", "(I)V", "report", "", "type", "time", "uiState", "miniWindow", "", "plugin-finder_release"})
public final class aa
{
  private static final String TAG = "FinderLivePauseReportHelper";
  private static int wMH;
  public static final aa ycv;
  
  static
  {
    AppMethodBeat.i(274589);
    ycv = new aa();
    TAG = "FinderLivePauseReportHelper";
    AppMethodBeat.o(274589);
  }
  
  public static void c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(274587);
    Object localObject = a.yRm;
    boolean bool = a.dEy();
    Log.i(TAG, "report curType:" + wMH + " type:" + paramInt1 + ",time:" + paramInt2 + ", uiState:" + paramInt3 + ", miniWindow:" + paramBoolean + ", isAnchor:" + bool);
    if ((bool) || (paramInt1 == wMH))
    {
      AppMethodBeat.o(274587);
      return;
    }
    if ((paramInt1 == 3) && (!d.dr(paramInt3, 524288)) && (!d.dr(paramInt3, 32)) && (!d.dr(paramInt3, 64)) && (!d.dr(paramInt3, 262144)))
    {
      AppMethodBeat.o(274587);
      return;
    }
    wMH = paramInt1;
    localObject = new JSONObject();
    ((JSONObject)localObject).put("type", paramInt1);
    ((JSONObject)localObject).put("times", paramInt2);
    m localm = m.yCt;
    localObject = ((JSONObject)localObject).toString();
    p.j(localObject, "js.toString()");
    p.k(localObject, "actionResult");
    m.a(s.bf.yLz, (String)localObject);
    AppMethodBeat.o(274587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.aa
 * JD-Core Version:    0.7.0.1
 */