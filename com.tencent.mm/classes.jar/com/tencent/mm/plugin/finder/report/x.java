package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.un;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderReport21874InFinder;", "", "()V", "TAG", "", "report", "", "context", "Landroid/content/Context;", "udfKv", "Lorg/json/JSONObject;", "isEnter", "", "stayTime", "", "startTime", "outerContextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
{
  public static final x FrX;
  
  static
  {
    AppMethodBeat.i(331559);
    FrX = new x();
    AppMethodBeat.o(331559);
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject, boolean paramBoolean, long paramLong1, long paramLong2, bui parambui)
  {
    int j = 0;
    AppMethodBeat.i(331531);
    s.u(paramContext, "context");
    s.u(paramJSONObject, "udfKv");
    label55:
    un localun;
    String str;
    label105:
    label120:
    int i;
    if (parambui == null)
    {
      parambui = null;
      if (parambui != null) {
        break label255;
      }
      parambui = k.aeZF;
      parambui = ((as)k.nq(paramContext).q(as.class)).fou();
      localun = new un();
      str = ((d)h.ax(d.class)).dHN();
      paramContext = str;
      if (str == null) {
        paramContext = "";
      }
      localun.Ak(paramContext);
      if (parambui != null) {
        break label258;
      }
      paramContext = "";
      localun.Al(paramContext);
      if (parambui != null) {
        break label279;
      }
      paramContext = "";
      localun.Ap(paramContext);
      if (parambui != null) {
        break label300;
      }
      i = 0;
      label135:
      localun.Aq(String.valueOf(i));
      localun.Am("59");
      paramContext = paramJSONObject.toString();
      s.s(paramContext, "udfKv.toString()");
      localun.Ao(n.m(paramContext, ",", ";", false));
      if (!paramBoolean) {
        break label310;
      }
      i = j;
      label188:
      localun.iGK = i;
      if (paramLong2 == -1L) {
        break label316;
      }
      localun.An(String.valueOf(paramLong2));
    }
    for (;;)
    {
      localun.iGM = paramLong1;
      localun.bMH();
      Log.i("report21874", "下面是我本次做的上报");
      paramContext = z.FrZ;
      z.a((a)localun);
      AppMethodBeat.o(331531);
      return;
      break;
      label255:
      break label55;
      label258:
      str = parambui.zIO;
      paramContext = str;
      if (str != null) {
        break label105;
      }
      paramContext = "";
      break label105;
      label279:
      str = parambui.zIB;
      paramContext = str;
      if (str != null) {
        break label120;
      }
      paramContext = "";
      break label120;
      label300:
      i = parambui.hLK;
      break label135;
      label310:
      i = 1;
      break label188;
      label316:
      localun.An(String.valueOf(cn.bDw()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.x
 * JD-Core Version:    0.7.0.1
 */