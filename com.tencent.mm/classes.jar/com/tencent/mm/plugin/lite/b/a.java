package com.tencent.mm.plugin.lite.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.al;
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
    AppMethodBeat.i(214608);
    Object localObject = paramj.method;
    paramj = paramj.grf;
    ad.d("MicroMsg.LiteApp.WxaLiteAppUI", "consume method:%s", new Object[] { localObject });
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
        AppMethodBeat.o(214608);
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
    paramj = ez(Boolean.TRUE);
    AppMethodBeat.o(214608);
    return paramj;
    paramj = ez(Boolean.TRUE);
    AppMethodBeat.o(214608);
    return paramj;
    paramj = ez(Boolean.TRUE);
    AppMethodBeat.o(214608);
    return paramj;
    paramj = ez(Boolean.TRUE);
    AppMethodBeat.o(214608);
    return paramj;
    localObject = d.fYR().MkG;
    if ((localObject != null) && ((localObject instanceof com.tencent.mm.plugin.lite.ui.a)) && ((paramj instanceof Map))) {
      ((com.tencent.mm.plugin.lite.ui.a)localObject).IV(((Integer)((Map)paramj).get("offset")).intValue());
    }
    paramj = ez(Boolean.TRUE);
    AppMethodBeat.o(214608);
    return paramj;
    paramj = d.fYR().MkG;
    if ((paramj != null) && ((paramj instanceof com.tencent.mm.plugin.lite.ui.a))) {
      ((com.tencent.mm.plugin.lite.ui.a)paramj).dfJ();
    }
    paramj = ez(Boolean.TRUE);
    AppMethodBeat.o(214608);
    return paramj;
    paramj = ez(Boolean.TRUE);
    AppMethodBeat.o(214608);
    return paramj;
    paramj = ez(Boolean.TRUE);
    AppMethodBeat.o(214608);
    return paramj;
    paramj = ez(Boolean.TRUE);
    AppMethodBeat.o(214608);
    return paramj;
    paramj = d.fYR().MkG;
    if ((paramj != null) && ((paramj instanceof com.tencent.mm.plugin.lite.ui.a))) {
      ((com.tencent.mm.plugin.lite.ui.a)paramj).dfI();
    }
    paramj = ez(Boolean.TRUE);
    AppMethodBeat.o(214608);
    return paramj;
    paramj = d.fYR().MkG;
    if ((paramj != null) && ((paramj instanceof com.tencent.mm.plugin.lite.ui.a))) {
      ((com.tencent.mm.plugin.lite.ui.a)paramj).bnj();
    }
    paramj = ez(Boolean.TRUE);
    AppMethodBeat.o(214608);
    return paramj;
    paramj = ez(Boolean.valueOf(al.G(d.fYR().MkG, true)));
    AppMethodBeat.o(214608);
    return paramj;
    paramj = ez(Double.valueOf(com.tencent.mm.cc.a.aA(this.mContext, al.aF(this.mContext))));
    AppMethodBeat.o(214608);
    return paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b.a
 * JD-Core Version:    0.7.0.1
 */