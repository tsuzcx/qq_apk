package com.tencent.mm.plugin.finder.ui;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.bj;
import com.tencent.mm.plugin.finder.report.c;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.report.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bi.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1", "Lcom/tencent/mm/sdk/platformtools/ScreenShotUtil$ScreenShotCallback;", "onScreenShot", "", "path", "", "dateAdded", "", "plugin-finder_release"})
public final class MMFinderUI$b
  implements bi.a
{
  public final void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(204874);
    for (;;)
    {
      try
      {
        paramString = a.KEX;
        c localc = FinderReporterUIC.c((FinderReporterUIC)a.s((MMActivity)this.sTt).get(FinderReporterUIC.class));
        if (!(localc instanceof com.tencent.mm.plugin.finder.report.l)) {
          break label256;
        }
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = ((Map)((com.tencent.mm.plugin.finder.report.l)localc).syY).entrySet().iterator();
        if (localIterator.hasNext())
        {
          paramString = (Map.Entry)localIterator.next();
          aio localaio = new aio();
          localaio.rRn = ((m)paramString.getValue()).duw;
          paramString = ((m)paramString.getValue()).feed;
          if (paramString == null) {
            break label270;
          }
          String str = paramString.getUserName();
          paramString = str;
          if (str == null) {
            break label270;
          }
          localaio.sbR = paramString;
          paramString = i.syT;
          str = i.I(localaio.rRn, localc.rQw.sch);
          paramString = str;
          if (str == null) {
            paramString = "";
          }
          localaio.sessionBuffer = paramString;
          localLinkedList.add(localaio);
          continue;
        }
        paramString = new bj(localLinkedList);
      }
      catch (Throwable paramString)
      {
        ae.printErrStackTrace(MMFinderUI.access$getTAG$cp(), paramString, "onScreenShot", new Object[0]);
        AppMethodBeat.o(204874);
        return;
      }
      g.ajj().b((n)paramString);
      AppMethodBeat.o(204874);
      return;
      label256:
      ae.i(MMFinderUI.access$getTAG$cp(), "onScreenShot: not FinderSingleFeedFlowReporter");
      AppMethodBeat.o(204874);
      return;
      label270:
      paramString = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.MMFinderUI.b
 * JD-Core Version:    0.7.0.1
 */