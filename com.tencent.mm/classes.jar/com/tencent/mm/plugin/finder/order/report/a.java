package com.tencent.mm.plugin.finder.order.report;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.iu;
import com.tencent.mm.plugin.findersdk.a.e;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/report/FinderLiveOrderReportUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "orderReportStruct", "Lcom/tencent/mm/protocal/protobuf/OrderReportStruct;", "getOrderReportStruct", "()Lcom/tencent/mm/protocal/protobuf/OrderReportStruct;", "setOrderReportStruct", "(Lcom/tencent/mm/protocal/protobuf/OrderReportStruct;)V", "genParams", "map", "", "onCreateBefore", "", "savedInstanceState", "Landroid/os/Bundle;", "report", "event", "params", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
{
  private dzi ESC;
  private final String TAG;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(332280);
    this.TAG = "Finder.FinderLiveOrderReportUIC";
    AppMethodBeat.o(332280);
  }
  
  private static String an(Map<String, String> paramMap)
  {
    AppMethodBeat.i(332309);
    s.u(paramMap, "map");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Iterator localIterator = ((Iterable)paramMap.keySet()).iterator();
      while (localIterator.hasNext())
      {
        String str3 = (String)localIterator.next();
        String str2 = (String)paramMap.get(str3);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localJSONObject.put(str3, str1);
      }
      return paramMap;
    }
    finally
    {
      paramMap = localJSONObject.toString();
      s.s(paramMap, "json.toString()");
      AppMethodBeat.o(332309);
    }
  }
  
  private void report(String paramString1, String paramString2)
  {
    AppMethodBeat.i(332297);
    s.u(paramString1, "event");
    s.u(paramString2, "params");
    iu localiu = new iu();
    Object localObject = this.ESC;
    label64:
    label87:
    label110:
    int i;
    if (localObject == null)
    {
      localObject = "";
      localiu.rU((String)localObject);
      localObject = this.ESC;
      if (localObject != null) {
        break label390;
      }
      localObject = "";
      localiu.rV((String)localObject);
      localObject = this.ESC;
      if (localObject != null) {
        break label413;
      }
      localObject = "";
      localiu.rW((String)localObject);
      localObject = this.ESC;
      if (localObject != null) {
        break label436;
      }
      localObject = "";
      localiu.iqO = localiu.F("SessionID", (String)localObject, true);
      localObject = this.ESC;
      if (localObject != null) {
        break label459;
      }
      localObject = "";
      label140:
      localiu.iwO = localiu.F("CommentScene", (String)localObject, true);
      localObject = this.ESC;
      if (localObject != null) {
        break label482;
      }
      localObject = "";
      label170:
      localiu.ipT = localiu.F("ContextId", (String)localObject, true);
      localObject = this.ESC;
      if (localObject != null) {
        break label505;
      }
      localObject = "";
      label200:
      localiu.iqp = localiu.F("SessionBuffer", (String)localObject, true);
      localObject = this.ESC;
      if (localObject != null) {
        break label528;
      }
      i = 0;
      label228:
      localiu.iQQ = i;
      localObject = this.ESC;
      if (localObject != null) {
        break label537;
      }
      localObject = "";
    }
    for (;;)
    {
      localiu.ixf = localiu.F("chnl_extra", (String)localObject, true);
      localiu.rX(paramString1);
      localiu.rY(n.m(paramString2, ",", ";", false));
      localiu.bMH();
      localObject = (com.tencent.mm.plugin.report.a)localiu;
      paramString1 = this.TAG;
      paramString2 = new StringBuilder("report").append(((com.tencent.mm.plugin.report.a)localObject).getId()).append(' ');
      localObject = ((com.tencent.mm.plugin.report.a)localObject).aIF();
      s.s(localObject, "struct.toShowString()");
      Log.i(paramString1, n.bV((String)localObject, "\r\n", " "));
      AppMethodBeat.o(332297);
      return;
      String str = ((dzi)localObject).abed;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      label390:
      str = ((dzi)localObject).feedID;
      localObject = str;
      if (str != null) {
        break label64;
      }
      localObject = "";
      break label64;
      label413:
      str = ((dzi)localObject).userName;
      localObject = str;
      if (str != null) {
        break label87;
      }
      localObject = "";
      break label87;
      label436:
      str = ((dzi)localObject).FUP;
      localObject = str;
      if (str != null) {
        break label110;
      }
      localObject = "";
      break label110;
      label459:
      str = ((dzi)localObject).Dol;
      localObject = str;
      if (str != null) {
        break label140;
      }
      localObject = "";
      break label140;
      label482:
      str = ((dzi)localObject).zIO;
      localObject = str;
      if (str != null) {
        break label170;
      }
      localObject = "";
      break label170;
      label505:
      str = ((dzi)localObject).sessionBuffer;
      localObject = str;
      if (str != null) {
        break label200;
      }
      localObject = "";
      break label200;
      label528:
      i = ((dzi)localObject).CRV;
      break label228;
      label537:
      str = ((dzi)localObject).abee;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(332318);
    super.onCreateBefore(paramBundle);
    paramBundle = (com.tencent.mm.bx.a)new dzi();
    Object localObject = getIntent();
    a.e locale = a.e.HbQ;
    localObject = ((Intent)localObject).getByteArrayExtra(a.e.fro());
    try
    {
      paramBundle.parseFrom((byte[])localObject);
      this.ESC = ((dzi)paramBundle);
      AppMethodBeat.o(332318);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
      }
    }
  }
  
  public final void w(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(332327);
    s.u(paramString, "event");
    s.u(paramMap, "map");
    report(paramString, an(paramMap));
    AppMethodBeat.o(332327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.report.a
 * JD-Core Version:    0.7.0.1
 */