package com.tencent.mm.plugin.lite.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.al;
import com.tencent.wax.a.a;
import com.tencent.wax.b.b;
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
    int i = 0;
    AppMethodBeat.i(212361);
    Object localObject = paramj.method;
    paramj = paramj.gtF;
    ae.d("MicroMsg.LiteApp.WxaLiteAppUI", "consume method:%s", new Object[] { localObject });
    switch (((String)localObject).hashCode())
    {
    default: 
      label152:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramj = gdq();
        AppMethodBeat.o(212361);
        return paramj;
        if (!((String)localObject).equals("publishEvent")) {
          break label152;
        }
        continue;
        if (!((String)localObject).equals("setCanOverScroll")) {
          break label152;
        }
        i = 1;
        continue;
        if (!((String)localObject).equals("generateInputEventData")) {
          break label152;
        }
        i = 2;
        continue;
        if (!((String)localObject).equals("inputOnKeyboardValueChange")) {
          break label152;
        }
        i = 3;
        continue;
        if (!((String)localObject).equals("inputLocationChange")) {
          break label152;
        }
        i = 4;
        continue;
        if (!((String)localObject).equals("hideKeyboard")) {
          break label152;
        }
        i = 5;
        continue;
        if (!((String)localObject).equals("showPicker")) {
          break label152;
        }
        i = 6;
        continue;
        if (!((String)localObject).equals("getLocalFileData")) {
          break label152;
        }
        i = 7;
        continue;
        if (!((String)localObject).equals("onRenderCallback")) {
          break label152;
        }
        i = 8;
        continue;
        if (!((String)localObject).equals("exitFullScreen")) {
          break label152;
        }
        i = 9;
        continue;
        if (!((String)localObject).equals("enterFullScreen")) {
          break label152;
        }
        i = 10;
        continue;
        if (!((String)localObject).equals("hasCutOut")) {
          break label152;
        }
        i = 11;
        continue;
        if (!((String)localObject).equals("getCutOutHeight")) {
          break label152;
        }
        i = 12;
      }
    }
    paramj = eC(Boolean.TRUE);
    AppMethodBeat.o(212361);
    return paramj;
    paramj = eC(Boolean.TRUE);
    AppMethodBeat.o(212361);
    return paramj;
    paramj = eC(Boolean.TRUE);
    AppMethodBeat.o(212361);
    return paramj;
    paramj = eC(Boolean.TRUE);
    AppMethodBeat.o(212361);
    return paramj;
    localObject = d.gdr().MHD.getActivity();
    if ((localObject != null) && ((localObject instanceof com.tencent.mm.plugin.lite.ui.a)) && ((paramj instanceof Map))) {
      ((com.tencent.mm.plugin.lite.ui.a)localObject).Jt(((Integer)((Map)paramj).get("offset")).intValue());
    }
    paramj = eC(Boolean.TRUE);
    AppMethodBeat.o(212361);
    return paramj;
    paramj = d.gdr().MHD.getActivity();
    if ((paramj != null) && ((paramj instanceof com.tencent.mm.plugin.lite.ui.a))) {
      ((com.tencent.mm.plugin.lite.ui.a)paramj).diG();
    }
    paramj = eC(Boolean.TRUE);
    AppMethodBeat.o(212361);
    return paramj;
    paramj = eC(Boolean.TRUE);
    AppMethodBeat.o(212361);
    return paramj;
    paramj = eC(Boolean.TRUE);
    AppMethodBeat.o(212361);
    return paramj;
    paramj = eC(Boolean.TRUE);
    AppMethodBeat.o(212361);
    return paramj;
    paramj = d.gdr().MHD.getActivity();
    if ((paramj != null) && ((paramj instanceof com.tencent.mm.plugin.lite.ui.a))) {
      ((com.tencent.mm.plugin.lite.ui.a)paramj).diF();
    }
    paramj = eC(Boolean.TRUE);
    AppMethodBeat.o(212361);
    return paramj;
    paramj = d.gdr().MHD.getActivity();
    if ((paramj != null) && ((paramj instanceof com.tencent.mm.plugin.lite.ui.a))) {
      ((com.tencent.mm.plugin.lite.ui.a)paramj).bnT();
    }
    paramj = eC(Boolean.TRUE);
    AppMethodBeat.o(212361);
    return paramj;
    paramj = eC(Boolean.valueOf(al.G(d.gdr().MHD.getActivity(), true)));
    AppMethodBeat.o(212361);
    return paramj;
    paramj = eC(Double.valueOf(com.tencent.mm.cb.a.aA(this.mContext, al.aG(this.mContext))));
    AppMethodBeat.o(212361);
    return paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b.a
 * JD-Core Version:    0.7.0.1
 */