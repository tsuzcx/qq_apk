package com.tencent.mm.console.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class j
  implements a
{
  static
  {
    AppMethodBeat.i(20188);
    com.tencent.mm.pluginsdk.cmd.b.a(new j(), new String[] { "//version" });
    AppMethodBeat.o(20188);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20187);
    paramString = new StringBuilder();
    paramString.append(String.format("[ver  ] %s %08X\n", new Object[] { k.c(paramContext, d.FFH, true), Integer.valueOf(d.FFH) }));
    paramString.append(com.tencent.mm.sdk.platformtools.j.info());
    paramString.append(String.format("[cid  ] %d\n", new Object[] { Integer.valueOf(k.cSM) }));
    paramString.append(String.format("[s.ver] %d\n", new Object[] { Integer.valueOf(ad.WL(0)) }));
    paramString.append(String.format("[l.ver] %d %s\n", new Object[] { Integer.valueOf(ad.WL(1)), ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType() }));
    paramString.append(String.format("[w.ver] %d\n", new Object[] { Integer.valueOf(ad.WL(3)) }));
    paramString.append(String.format("[b.ver] %d\n", new Object[] { Integer.valueOf(ad.WL(2)) }));
    paramString.append(String.format("[r.ver] %s\n", new Object[] { com.tencent.mm.sdk.platformtools.j.hju }));
    if (com.tencent.mm.sdk.platformtools.j.EX_DEVICE_LOGIN) {
      try
      {
        Map localMap = bx.M(bu.convertStreamToString(paramContext.getAssets().open("merged_features.xml")), "merged");
        if (localMap != null)
        {
          i = 0;
          StringBuilder localStringBuilder = new StringBuilder(".merged.feature");
          if (i > 0) {}
          for (paramArrayOfString = String.valueOf(i);; paramArrayOfString = "")
          {
            paramArrayOfString = (String)localMap.get(paramArrayOfString);
            if (paramArrayOfString == null) {
              break label344;
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
        ae.printErrStackTrace("MicroMsg.Version", paramArrayOfString, "", new Object[0]);
      }
    }
    label344:
    paramArrayOfString.setText(paramString);
    paramArrayOfString.setGravity(19);
    paramArrayOfString.setTextSize(1, 10.0F);
    paramArrayOfString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramArrayOfString.setTextColor(paramContext.getResources().getColor(2131099732));
    paramArrayOfString.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(2131165480);
    paramArrayOfString.setPadding(i, i, i, i);
    h.a(paramContext, null, paramArrayOfString, null);
    AppMethodBeat.o(20187);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.a.j
 * JD-Core Version:    0.7.0.1
 */