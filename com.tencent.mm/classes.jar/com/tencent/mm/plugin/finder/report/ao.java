package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.hc;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bui;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderVstReporter;", "", "()V", "enterTimestamp", "", "notifyAllFinderUIInVisible", "", "finderUi", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "notifyEnterFromSystemUI", "report23898", "isEnterFromSystemUI", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
{
  public static long AxK;
  public static final ao FtO;
  
  static
  {
    AppMethodBeat.i(331327);
    FtO = new ao();
    AppMethodBeat.o(331327);
  }
  
  public static void a(MMFinderUI paramMMFinderUI, boolean paramBoolean)
  {
    AppMethodBeat.i(331318);
    if ((!paramBoolean) && (AxK <= 0L))
    {
      AppMethodBeat.o(331318);
      return;
    }
    Object localObject = as.GSQ;
    paramMMFinderUI = as.a.hu((Context)paramMMFinderUI);
    hc localhc;
    if (paramMMFinderUI == null)
    {
      localObject = null;
      localhc = new hc();
      if (localObject != null) {
        break label207;
      }
      paramMMFinderUI = "";
      label60:
      localhc.inx = localhc.F("sessionid", paramMMFinderUI, true);
      if (localObject != null) {
        break label228;
      }
      paramMMFinderUI = "";
      label82:
      localhc.iny = localhc.F("contextid", paramMMFinderUI, true);
      if (!paramBoolean) {
        break label249;
      }
      paramMMFinderUI = "1";
      label103:
      localhc.iLS = localhc.F("event_id", paramMMFinderUI, true);
      localhc.iNf = cn.bDw();
      localhc.iNg = localhc.F("vst_type", "3", true);
      if ((paramBoolean) || (AxK <= 0L)) {
        break label255;
      }
    }
    label207:
    label228:
    label249:
    label255:
    for (long l = cn.bDw() - AxK;; l = 0L)
    {
      localhc.iNh = l;
      localhc.bMH();
      paramMMFinderUI = z.FrZ;
      z.a((a)localhc);
      if (!paramBoolean) {
        AxK = 0L;
      }
      AppMethodBeat.o(331318);
      return;
      localObject = paramMMFinderUI.fou();
      break;
      String str = ((bui)localObject).sessionId;
      paramMMFinderUI = str;
      if (str != null) {
        break label60;
      }
      paramMMFinderUI = "";
      break label60;
      localObject = ((bui)localObject).zIO;
      paramMMFinderUI = (MMFinderUI)localObject;
      if (localObject != null) {
        break label82;
      }
      paramMMFinderUI = "";
      break label82;
      paramMMFinderUI = "2";
      break label103;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ao
 * JD-Core Version:    0.7.0.1
 */