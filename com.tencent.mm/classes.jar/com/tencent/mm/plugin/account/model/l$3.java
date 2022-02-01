package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j.a.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

final class l$3
  implements q
{
  l$3(l paraml)
  {
    AppMethodBeat.i(161698);
    AppMethodBeat.o(161698);
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(188401);
    if ((bu.nullAsNil(paramString).equals("ChangeLaunchImage")) && (paramMap != null))
    {
      paramString = (String)paramMap.get(".sysmsg.ChangeLaunchImage.BeginTime");
      parama = (String)paramMap.get(".sysmsg.ChangeLaunchImage.EndTime");
      paramMap = (String)paramMap.get(".sysmsg.ChangeLaunchImage.ResId.SubType");
      ae.i("MicroMsg.SubCoreAccountSync", "beginTime:%s,endTime:%s,subtype:%s", new Object[] { paramString, parama, paramMap });
      if (!bu.V(new String[] { paramString, parama, paramMap }))
      {
        g.yxI.idkeyStat(723L, 5L, 1L, false);
        int i = bu.aSB(paramMap);
        if (i > 0)
        {
          paramMap = ak.getContext().getSharedPreferences("system_config_prefs", 0);
          paramMap.edit().putLong("new_launch_image_begin_time", bu.aSC(paramString)).apply();
          paramMap.edit().putInt("new_launch_image_sub_type", i).apply();
          paramMap.edit().putLong("new_launch_image_end_time", bu.aSC(parama)).commit();
          b.fes();
          l.Kq(b.jq(43, i));
        }
      }
    }
    AppMethodBeat.o(188401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.l.3
 * JD-Core Version:    0.7.0.1
 */