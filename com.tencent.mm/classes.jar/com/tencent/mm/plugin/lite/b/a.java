package com.tencent.mm.plugin.lite.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.aj;
import com.tencent.wax.a.a;
import com.tencent.wax.d;
import io.flutter.plugin.a.j;
import java.util.Map;

public final class a
  extends com.tencent.wax.a
{
  private Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final a.a a(j paramj)
  {
    AppMethodBeat.i(208143);
    Object localObject = paramj.method;
    paramj = paramj.fXJ;
    ac.d("MicroMsg.LiteApp.WxaLiteAppUI", "consume method:%s", new Object[] { localObject });
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramj = new a.a(false, null);
        AppMethodBeat.o(208143);
        return paramj;
        if (((String)localObject).equals("publishEvent"))
        {
          i = 0;
          continue;
          if (((String)localObject).equals("setCanOverScroll"))
          {
            i = 1;
            continue;
            if (((String)localObject).equals("generateInputEventData"))
            {
              i = 2;
              continue;
              if (((String)localObject).equals("inputOnKeyboardValueChange"))
              {
                i = 3;
                continue;
                if (((String)localObject).equals("inputLocationChange"))
                {
                  i = 4;
                  continue;
                  if (((String)localObject).equals("hideKeyboard"))
                  {
                    i = 5;
                    continue;
                    if (((String)localObject).equals("showPicker"))
                    {
                      i = 6;
                      continue;
                      if (((String)localObject).equals("getLocalFileData"))
                      {
                        i = 7;
                        continue;
                        if (((String)localObject).equals("onRenderCallback"))
                        {
                          i = 8;
                          continue;
                          if (((String)localObject).equals("exitFullScreen"))
                          {
                            i = 9;
                            continue;
                            if (((String)localObject).equals("enterFullScreen"))
                            {
                              i = 10;
                              continue;
                              if (((String)localObject).equals("hasCutOut"))
                              {
                                i = 11;
                                continue;
                                if (((String)localObject).equals("getCutOutHeight")) {
                                  i = 12;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    paramj = ew(Boolean.TRUE);
    AppMethodBeat.o(208143);
    return paramj;
    paramj = ew(Boolean.TRUE);
    AppMethodBeat.o(208143);
    return paramj;
    paramj = ew(Boolean.TRUE);
    AppMethodBeat.o(208143);
    return paramj;
    paramj = ew(Boolean.TRUE);
    AppMethodBeat.o(208143);
    return paramj;
    localObject = d.fHA().KuF;
    if ((localObject != null) && ((localObject instanceof com.tencent.mm.plugin.lite.ui.a)) && ((paramj instanceof Map))) {
      ((com.tencent.mm.plugin.lite.ui.a)localObject).Hz(((Integer)((Map)paramj).get("offset")).intValue());
    }
    paramj = ew(Boolean.TRUE);
    AppMethodBeat.o(208143);
    return paramj;
    paramj = d.fHA().KuF;
    if ((paramj != null) && ((paramj instanceof com.tencent.mm.plugin.lite.ui.a))) {
      ((com.tencent.mm.plugin.lite.ui.a)paramj).cWx();
    }
    paramj = ew(Boolean.TRUE);
    AppMethodBeat.o(208143);
    return paramj;
    paramj = ew(Boolean.TRUE);
    AppMethodBeat.o(208143);
    return paramj;
    paramj = ew(Boolean.TRUE);
    AppMethodBeat.o(208143);
    return paramj;
    paramj = ew(Boolean.TRUE);
    AppMethodBeat.o(208143);
    return paramj;
    paramj = d.fHA().KuF;
    if ((paramj != null) && ((paramj instanceof com.tencent.mm.plugin.lite.ui.a))) {
      ((com.tencent.mm.plugin.lite.ui.a)paramj).cWw();
    }
    paramj = ew(Boolean.TRUE);
    AppMethodBeat.o(208143);
    return paramj;
    paramj = d.fHA().KuF;
    if ((paramj != null) && ((paramj instanceof com.tencent.mm.plugin.lite.ui.a))) {
      ((com.tencent.mm.plugin.lite.ui.a)paramj).bjx();
    }
    paramj = ew(Boolean.TRUE);
    AppMethodBeat.o(208143);
    return paramj;
    paramj = ew(Boolean.valueOf(aj.E(d.fHA().KuF, true)));
    AppMethodBeat.o(208143);
    return paramj;
    paramj = ew(Double.valueOf(com.tencent.mm.cc.a.ax(this.mContext, aj.aF(this.mContext))));
    AppMethodBeat.o(208143);
    return paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b.a
 * JD-Core Version:    0.7.0.1
 */