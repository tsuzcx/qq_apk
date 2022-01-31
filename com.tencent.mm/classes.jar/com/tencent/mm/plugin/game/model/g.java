package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.gr;
import com.tencent.mm.h.a.gr.a;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
{
  private static final String kOy = com.tencent.mm.loader.a.b.bkH + "Game/HvMenu/";
  
  public static void a(gr paramgr)
  {
    int i = paramgr.bOv.uC;
    y.i("MicroMsg.GameCommOpertionProcessor", "cmd:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      return;
      Object localObject2 = paramgr.bOv.context;
      if (localObject2 == null) {
        continue;
      }
      Object localObject1 = new JSONObject();
      localObject2 = f.jdMethod_do((Context)localObject2);
      if (localObject2 != null) {}
      try
      {
        ((JSONObject)localObject1).put("gameRegionName", f.a((GameRegionPreference.a)localObject2));
        label125:
        paramgr.bOw.result = ((JSONObject)localObject1).toString();
        return;
        paramgr = paramgr.bOv.bOx;
        y.i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", new Object[] { paramgr });
        if (bk.bl(paramgr)) {
          continue;
        }
        com.tencent.mm.kernel.g.Dk().a(1369, new g.1(paramgr));
        paramgr = new at(paramgr);
        com.tencent.mm.kernel.g.Dk().a(paramgr, 0);
        return;
        localObject1 = paramgr.bOv.bOx;
        y.i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", new Object[] { localObject1 });
        if (bk.bl((String)localObject1)) {
          continue;
        }
        localObject2 = ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYg().Ey("pb_game_hv_menu_" + (String)localObject1);
        if (bk.bE((byte[])localObject2)) {
          continue;
        }
        try
        {
          localObject2 = new String((byte[])localObject2, "ISO-8859-1");
          paramgr.bOw.result = ((String)localObject2);
          y.i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", new Object[] { localObject1 });
          return;
        }
        catch (UnsupportedEncodingException paramgr)
        {
          return;
        }
        b(paramgr);
        return;
        localObject1 = paramgr.bOv.context;
        if (localObject1 == null) {
          continue;
        }
        JSONObject localJSONObject = new JSONObject();
        localObject2 = f.dw((Context)localObject1);
        localObject1 = localObject2;
        if (bk.bl((String)localObject2)) {
          localObject1 = f.aYU();
        }
        try
        {
          localJSONObject.put("regionCode", localObject1);
          label363:
          paramgr.bOw.result = localJSONObject.toString();
          return;
          com.tencent.mm.plugin.game.commlib.b.aYr().gu(true);
          return;
        }
        catch (JSONException localJSONException1)
        {
          break label363;
        }
      }
      catch (JSONException localJSONException2)
      {
        break label125;
      }
    }
  }
  
  private static void a(List<awk> paramList, g.a parama)
  {
    if (bk.dk(paramList))
    {
      if (parama != null) {
        parama.onComplete();
      }
      return;
    }
    awk localawk = (awk)paramList.remove(0);
    if ((localawk == null) || (bk.bl(localawk.mQp)))
    {
      y.e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
      return;
    }
    Object localObject = kOy + com.tencent.mm.a.g.o(localawk.mQp.getBytes());
    c.a locala = new c.a();
    locala.erf = true;
    locala.erh = ((String)localObject);
    localObject = locala.OV();
    o.ON().a(localawk.mQp, (com.tencent.mm.as.a.a.c)localObject, new g.3(localawk, paramList, parama));
  }
  
  private static void b(gr paramgr)
  {
    paramgr = paramgr.bOv.bOx;
    if (bk.bl(paramgr)) {}
    Object localObject;
    int j;
    boolean bool;
    do
    {
      return;
      try
      {
        localObject = new JSONObject(paramgr);
        j = bk.getInt(((JSONObject)localObject).getString("game_page_report_id"), 0);
        bool = ((JSONObject)localObject).getBoolean("game_page_report_instantly");
        paramgr = ((JSONObject)localObject).optString("game_page_report_format_data");
        localObject = ((JSONObject)localObject).optString("game_page_report_tabs_format_data");
        y.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, reportId:%d, reportInstantly:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), paramgr, localObject });
        if (j == 0)
        {
          y.i("MicroMsg.GameCommOpertionProcessor", "reportId format exception");
          return;
        }
      }
      catch (JSONException paramgr)
      {
        y.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err1:%s", new Object[] { paramgr.getMessage() });
        return;
      }
      if (!bk.bl(paramgr))
      {
        if (bool)
        {
          com.tencent.mm.plugin.game.e.a.ar(j, paramgr);
          return;
        }
        h.nFQ.aC(j, paramgr);
        return;
      }
    } while (bk.bl((String)localObject));
    for (;;)
    {
      int i;
      try
      {
        paramgr = new JSONArray((String)localObject);
        i = 0;
        if (i >= paramgr.length()) {
          break;
        }
        localObject = paramgr.getString(i);
        if (!bk.bl((String)localObject)) {
          if (bool) {
            com.tencent.mm.plugin.game.e.a.ar(j, (String)localObject);
          } else {
            h.nFQ.aC(j, (String)localObject);
          }
        }
      }
      catch (JSONException paramgr)
      {
        y.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err2:%s", new Object[] { paramgr.getMessage() });
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.g
 * JD-Core Version:    0.7.0.1
 */