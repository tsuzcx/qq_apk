package com.tencent.mm.console.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class j
  implements a
{
  static
  {
    b.a(new j(), new String[] { "//version" });
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(String.format("[ver  ] %s %08X\n", new Object[] { e.d(paramContext, com.tencent.mm.protocal.d.spa, true), Integer.valueOf(com.tencent.mm.protocal.d.spa) }));
    localStringBuilder1.append(com.tencent.mm.sdk.platformtools.d.ayN());
    localStringBuilder1.append(String.format("[cid  ] %d\n", new Object[] { Integer.valueOf(e.bvj) }));
    localStringBuilder1.append(String.format("[s.ver] %d\n", new Object[] { Integer.valueOf(aa.Bs(0)) }));
    localStringBuilder1.append(String.format("[r.ver] %s\n", new Object[] { "0x26070333" }));
    if (com.tencent.mm.sdk.platformtools.d.EX_DEVICE_LOGIN) {
      try
      {
        Map localMap = bn.s(bk.convertStreamToString(paramContext.getAssets().open("merged_features.xml")), "merged");
        if (localMap != null)
        {
          i = 0;
          StringBuilder localStringBuilder2 = new StringBuilder(".merged.feature");
          if (i > 0) {}
          for (paramArrayOfString = String.valueOf(i);; paramArrayOfString = "")
          {
            paramArrayOfString = (String)localMap.get(paramArrayOfString);
            if (paramArrayOfString == null) {
              break label250;
            }
            localStringBuilder1.append(String.format("[feature#%02d] %s\n", new Object[] { Integer.valueOf(i), paramArrayOfString }));
            i += 1;
            break;
          }
        }
        paramArrayOfString = new TextView(paramContext);
      }
      catch (Exception paramArrayOfString)
      {
        y.printErrStackTrace("MicroMsg.Version", paramArrayOfString, "", new Object[0]);
      }
    }
    label250:
    paramArrayOfString.setText(localStringBuilder1);
    paramArrayOfString.setGravity(19);
    paramArrayOfString.setTextSize(1, 10.0F);
    paramArrayOfString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramArrayOfString.setTextColor(-16777216);
    paramArrayOfString.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(R.f.LargePadding);
    paramArrayOfString.setPadding(i, i, i, i);
    h.a(paramContext, null, paramArrayOfString, null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.a.j
 * JD-Core Version:    0.7.0.1
 */