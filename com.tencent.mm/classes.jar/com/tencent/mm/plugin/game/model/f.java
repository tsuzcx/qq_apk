package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.gv.a;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static final String nmv;
  
  static
  {
    AppMethodBeat.i(111244);
    nmv = com.tencent.mm.loader.j.b.eQz + "Game/HvMenu/";
    AppMethodBeat.o(111244);
  }
  
  public static void a(gv paramgv)
  {
    AppMethodBeat.i(111239);
    int i = paramgv.cvM.vA;
    ab.i("MicroMsg.GameCommOpertionProcessor", "cmd:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111239);
      return;
      Object localObject2 = paramgv.cvM.context;
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = new JSONObject();
        localObject2 = e.eb((Context)localObject2);
        if (localObject2 == null) {}
      }
      try
      {
        ((JSONObject)localObject1).put("gameRegionName", e.a((GameRegionPreference.a)localObject2));
        label138:
        paramgv.cvN.result = ((JSONObject)localObject1).toString();
        AppMethodBeat.o(111239);
        return;
        paramgv = paramgv.cvM.cvO;
        ab.i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", new Object[] { paramgv });
        if (!bo.isNullOrNil(paramgv))
        {
          com.tencent.mm.kernel.g.Rc().a(1369, new f.1(paramgv));
          paramgv = new as(paramgv);
          com.tencent.mm.kernel.g.Rc().a(paramgv, 0);
        }
        AppMethodBeat.o(111239);
        return;
        localObject1 = paramgv.cvM.cvO;
        ab.i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", new Object[] { localObject1 });
        if (!bo.isNullOrNil((String)localObject1))
        {
          localObject2 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bET().PN("pb_game_hv_menu_".concat(String.valueOf(localObject1)));
          if (!bo.ce((byte[])localObject2)) {
            try
            {
              localObject2 = new String((byte[])localObject2, "ISO-8859-1");
              paramgv.cvN.result = ((String)localObject2);
              ab.i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", new Object[] { localObject1 });
              AppMethodBeat.o(111239);
              return;
            }
            catch (UnsupportedEncodingException paramgv) {}
          }
        }
        AppMethodBeat.o(111239);
        return;
        b(paramgv);
        AppMethodBeat.o(111239);
        return;
        localObject1 = paramgv.cvM.context;
        JSONObject localJSONObject;
        if (localObject1 != null)
        {
          localJSONObject = new JSONObject();
          localObject2 = e.ej((Context)localObject1);
          localObject1 = localObject2;
          if (bo.isNullOrNil((String)localObject2)) {
            localObject1 = e.bFT();
          }
        }
        try
        {
          localJSONObject.put("regionCode", localObject1);
          label394:
          paramgv.cvN.result = localJSONObject.toString();
          AppMethodBeat.o(111239);
          return;
          com.tencent.mm.plugin.game.commlib.b.bFj().hZ(true);
        }
        catch (JSONException localJSONException1)
        {
          break label394;
        }
      }
      catch (JSONException localJSONException2)
      {
        break label138;
      }
    }
  }
  
  private static void a(List<bcz> paramList, f.a parama)
  {
    AppMethodBeat.i(111240);
    if (bo.es(paramList))
    {
      if (parama != null) {
        parama.onComplete();
      }
      AppMethodBeat.o(111240);
      return;
    }
    bcz localbcz = (bcz)paramList.remove(0);
    if ((localbcz == null) || (bo.isNullOrNil(localbcz.ThumbUrl)))
    {
      ab.e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
      AppMethodBeat.o(111240);
      return;
    }
    Object localObject = nmv + com.tencent.mm.a.g.w(localbcz.ThumbUrl.getBytes());
    c.a locala = new c.a();
    locala.eNM = true;
    locala.eNO = ((String)localObject);
    localObject = locala.ahY();
    o.ahG().a(localbcz.ThumbUrl, (c)localObject, new f.3(localbcz, paramList, parama));
    AppMethodBeat.o(111240);
  }
  
  private static void b(gv paramgv)
  {
    AppMethodBeat.i(111241);
    paramgv = paramgv.cvM.cvO;
    if (bo.isNullOrNil(paramgv))
    {
      AppMethodBeat.o(111241);
      return;
    }
    Object localObject;
    int j;
    boolean bool;
    try
    {
      localObject = new JSONObject(paramgv);
      j = bo.getInt(((JSONObject)localObject).getString("game_page_report_id"), 0);
      bool = ((JSONObject)localObject).getBoolean("game_page_report_instantly");
      paramgv = ((JSONObject)localObject).optString("game_page_report_format_data");
      localObject = ((JSONObject)localObject).optString("game_page_report_tabs_format_data");
      ab.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, reportId:%d, reportInstantly:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), paramgv, localObject });
      if (j == 0)
      {
        ab.i("MicroMsg.GameCommOpertionProcessor", "reportId format exception");
        AppMethodBeat.o(111241);
        return;
      }
    }
    catch (JSONException paramgv)
    {
      ab.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err1:%s", new Object[] { paramgv.getMessage() });
      AppMethodBeat.o(111241);
      return;
    }
    if (!bo.isNullOrNil(paramgv))
    {
      if (bool)
      {
        com.tencent.mm.plugin.game.e.a.aL(j, paramgv);
        AppMethodBeat.o(111241);
        return;
      }
      h.qsU.kvStat(j, paramgv);
      AppMethodBeat.o(111241);
      return;
    }
    if (!bo.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      int i;
      try
      {
        paramgv = new JSONArray((String)localObject);
        i = 0;
        if (i >= paramgv.length()) {
          break label293;
        }
        localObject = paramgv.getString(i);
        if (bo.isNullOrNil((String)localObject)) {
          break label300;
        }
        if (bool) {
          com.tencent.mm.plugin.game.e.a.aL(j, (String)localObject);
        } else {
          h.qsU.kvStat(j, (String)localObject);
        }
      }
      catch (JSONException paramgv)
      {
        ab.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err2:%s", new Object[] { paramgv.getMessage() });
      }
      AppMethodBeat.o(111241);
      return;
      label293:
      AppMethodBeat.o(111241);
      return;
      label300:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.f
 * JD-Core Version:    0.7.0.1
 */