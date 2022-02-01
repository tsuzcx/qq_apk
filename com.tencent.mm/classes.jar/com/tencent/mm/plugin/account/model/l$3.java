package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.h.a.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

final class l$3
  implements p
{
  l$3(l paraml)
  {
    AppMethodBeat.i(161698);
    AppMethodBeat.o(161698);
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(210373);
    if ((bs.nullAsNil(paramString).equals("ChangeLaunchImage")) && (paramMap != null))
    {
      paramString = (String)paramMap.get(".sysmsg.ChangeLaunchImage.BeginTime");
      parama = (String)paramMap.get(".sysmsg.ChangeLaunchImage.EndTime");
      paramMap = (String)paramMap.get(".sysmsg.ChangeLaunchImage.ResId.SubType");
      ac.i("MicroMsg.SubCoreAccountSync", "beginTime:%s,endTime:%s,subtype:%s", new Object[] { paramString, parama, paramMap });
      if (!bs.T(new String[] { paramString, parama, paramMap }))
      {
        h.wUl.idkeyStat(723L, 5L, 1L, false);
        int i = bs.aLy(paramMap);
        if (i > 0)
        {
          paramMap = ai.getContext().getSharedPreferences("system_config_prefs", 0);
          paramMap.edit().putLong("new_launch_image_begin_time", bs.aLz(paramString)).apply();
          paramMap.edit().putInt("new_launch_image_sub_type", i).apply();
          paramMap.edit().putLong("new_launch_image_end_time", bs.aLz(parama)).commit();
          b.eLH();
          l.GC(b.ja(43, i));
        }
      }
    }
    AppMethodBeat.o(210373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.l.3
 * JD-Core Version:    0.7.0.1
 */