package com.tencent.mm.plugin.finder.live.olympic.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.report.q;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/report/OlympicsReportUtil;", "", "()V", "TAG", "", "chnlExtraMap", "", "enterIconType", "", "reportData", "Lcom/tencent/mm/protocal/protobuf/OlympicsLiveEntranceReportData;", "appendChnlExtra", "chnlExtra", "key", "value", "clearOlympicEntranceReportData", "", "genJoinLiveActionResult", "genShareChnlExtra", "getAndClearEnterIconType", "getFeedCommentScene", "pageName", "getOlympicEntranceReportData", "initReportParams", "logInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b CRS;
  public static final Map<String, String> CRT;
  public static dwa CRU;
  public static int CRV;
  public static final String TAG;
  
  static
  {
    AppMethodBeat.i(360631);
    CRS = new b();
    TAG = "Finder.OlympicsReportUtil";
    CRT = (Map)new LinkedHashMap();
    AppMethodBeat.o(360631);
  }
  
  public static String a(dwa paramdwa)
  {
    AppMethodBeat.i(360627);
    s.u(paramdwa, "<this>");
    paramdwa = "entrance:" + paramdwa.abbK + ", finderUsername:" + paramdwa.finderUsername + ", wxUsername:" + paramdwa.hLv + ", pageName:" + paramdwa.hJW + ", isCertType:" + paramdwa.abbL + ", enterIconType:" + paramdwa.CRV;
    AppMethodBeat.o(360627);
    return paramdwa;
  }
  
  public static String awO(String paramString)
  {
    AppMethodBeat.i(360619);
    if ((s.p("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (s.p("com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI", paramString)))
    {
      paramString = (String)((ce)h.ax(ce.class)).etm().Dqg.get(c.zGs);
      Log.i(TAG, s.X("HABBYGE-MALI, pageObj:", c.zGs));
    }
    while (paramString == null)
    {
      AppMethodBeat.o(360619);
      return "";
      String str1 = (String)((ce)h.ax(ce.class)).etm().Dqf.get(paramString);
      paramString = str1;
      if (str1 != null) {
        if (s.p(str1, "27"))
        {
          paramString = c.zGj;
          if (c.dKo()) {
            paramString = "27";
          } else {
            paramString = "9";
          }
        }
        else
        {
          paramString = str1;
          if (s.p(str1, "25"))
          {
            String str2 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLz();
            paramString = c.zGj;
            paramString = str1;
            if (!c.a.arO(str2))
            {
              if (str2 != null) {
                switch (str2.hashCode())
                {
                }
              }
              label224:
              do
              {
                do
                {
                  paramString = "39";
                  break;
                } while (!str2.equals("101"));
                do
                {
                  do
                  {
                    paramString = "25";
                    break;
                    if (!str2.equals("123")) {
                      break label224;
                    }
                    paramString = "38";
                    break;
                  } while (str2.equals("102"));
                  break label224;
                } while (str2.equals("999"));
              } while ((goto 224) || (!str2.equals("150")));
              paramString = "15";
            }
          }
        }
      }
    }
    AppMethodBeat.o(360619);
    return paramString;
  }
  
  public static Map<String, String> eok()
  {
    return CRT;
  }
  
  public static void eol()
  {
    CRU = null;
  }
  
  public static dwa eom()
  {
    return CRU;
  }
  
  public static int eon()
  {
    int i = CRV;
    CRV = 0;
    return i;
  }
  
  public static Map<String, String> eoo()
  {
    AppMethodBeat.i(360608);
    Object localObject = a.CMm;
    localObject = a.emY();
    int i;
    if (localObject != null)
    {
      bj localbj = bj.GlQ;
      if (bj.y((a)localObject) == true)
      {
        i = 1;
        if (i == 0) {
          break label140;
        }
        localObject = a.CMm;
        localObject = a.emY();
        if (localObject == null) {
          break label130;
        }
        localObject = (n)((a)localObject).business(n.class);
        if ((localObject == null) || (((n)localObject).Ehh != true)) {
          break label130;
        }
        i = 1;
        label73:
        if (i == 0) {
          break label135;
        }
        i = 1;
      }
    }
    label79:
    for (localObject = ak.f(new r[] { new r("is_certificate_type", String.valueOf(i)) });; localObject = (Map)new LinkedHashMap())
    {
      Log.i(TAG, s.X("genShareChnlExtra ", localObject));
      AppMethodBeat.o(360608);
      return localObject;
      i = 0;
      break;
      i = 0;
      break label73;
      i = 0;
      break label79;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.report.b
 * JD-Core Version:    0.7.0.1
 */