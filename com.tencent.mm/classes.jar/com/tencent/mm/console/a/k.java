package com.tencent.mm.console.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class k
  implements a
{
  static
  {
    AppMethodBeat.i(20188);
    com.tencent.mm.pluginsdk.cmd.b.a(new k(), new String[] { "//version" });
    AppMethodBeat.o(20188);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20187);
    paramString = new StringBuilder();
    paramString.append(String.format("[ver  ] %s %08X\n", new Object[] { ChannelUtil.formatVersion(paramContext, d.KyO, true), Integer.valueOf(d.KyO) }));
    paramString.append(BuildInfo.info());
    paramString.append(String.format("[cid  ] %d\n", new Object[] { Integer.valueOf(ChannelUtil.channelId) }));
    paramString.append(String.format("[s.ver] %d\n", new Object[] { Integer.valueOf(ai.aft(0)) }));
    paramString.append(String.format("[l.ver] %d %s\n", new Object[] { Integer.valueOf(ai.aft(1)), ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType() }));
    paramString.append(String.format("[w.ver] %d\n", new Object[] { Integer.valueOf(ai.aft(3)) }));
    paramString.append(String.format("[b.ver] %d\n", new Object[] { Integer.valueOf(ai.aft(2)) }));
    paramString.append(String.format("[r.ver] %s\n", new Object[] { BuildInfo.CLIENT_VERSION }));
    if (BuildInfo.EX_DEVICE_LOGIN) {
      try
      {
        Map localMap = XmlParser.parseXml(Util.convertStreamToString(paramContext.getAssets().open("merged_features.xml")), "merged", null);
        if (localMap != null)
        {
          i = 0;
          StringBuilder localStringBuilder = new StringBuilder(".merged.feature");
          if (i > 0) {}
          for (paramArrayOfString = String.valueOf(i);; paramArrayOfString = "")
          {
            paramArrayOfString = (String)localMap.get(paramArrayOfString);
            if (paramArrayOfString == null) {
              break label345;
            }
            paramString.append(String.format("[feature#%02d] %s\n", new Object[] { Integer.valueOf(i), paramArrayOfString }));
            i += 1;
            break;
          }
        }
        paramArrayOfString = new TextView(paramContext);
      }
      catch (Exception paramArrayOfString)
      {
        Log.printErrStackTrace("MicroMsg.Version", paramArrayOfString, "", new Object[0]);
      }
    }
    label345:
    paramArrayOfString.setText(paramString);
    paramArrayOfString.setGravity(19);
    paramArrayOfString.setTextSize(1, 10.0F);
    paramArrayOfString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramArrayOfString.setTextColor(paramContext.getResources().getColor(2131099746));
    paramArrayOfString.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(2131165498);
    paramArrayOfString.setPadding(i, i, i, i);
    h.a(paramContext, null, paramArrayOfString, null);
    AppMethodBeat.o(20187);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.a.k
 * JD-Core Version:    0.7.0.1
 */