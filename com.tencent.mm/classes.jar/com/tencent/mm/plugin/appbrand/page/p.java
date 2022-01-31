package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.ui.aj;
import java.util.List;

public class p
  implements f.b, f.c
{
  v bBK;
  com.tencent.mm.ui.widget.b.d iwc;
  List<q> iwd;
  String mAppId;
  
  public p(v paramv, List<q> paramList)
  {
    AppMethodBeat.i(87073);
    this.mAppId = paramv.getAppId();
    this.bBK = paramv;
    this.iwd = paramList;
    this.iwc = new com.tencent.mm.ui.widget.b.d(paramv.getContext());
    paramv = this.bBK.wl();
    if (paramv != null) {
      this.iwc.G(paramv, false);
    }
    this.iwc.sao = new p.1(this);
    this.iwc.sap = new p.2(this);
    if (this.bBK.ixo)
    {
      paramList = this.iwc;
      int i = Color.parseColor("#000000");
      if (paramList.iDS != null) {
        paramList.iDS.setBackgroundColor(i);
      }
      paramList.AGU = Boolean.valueOf(aj.Ow(i));
      if ((paramList.AGU.booleanValue()) && (paramList.AHc != null)) {
        paramList.AHc.setImageDrawable(paramList.mContext.getResources().getDrawable(2131689919));
      }
    }
    if ((paramv != null) && (this.bBK.aJx())) {
      paramv.addOnAttachStateChangeListener(new p.3(this));
    }
    AppMethodBeat.o(87073);
  }
  
  private boolean aIY()
  {
    AppMethodBeat.i(87075);
    try
    {
      this.iwc.cre();
      this.bBK.b(this);
      this.bBK.b(this);
      AppMethodBeat.o(87075);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.luggage.g.d.e("MicroMsg.AppBrandPageActionSheet", "hide exception = %s", new Object[] { localException });
      AppMethodBeat.o(87075);
    }
    return false;
  }
  
  protected void a(com.tencent.mm.ui.widget.b.d paramd) {}
  
  protected final boolean aIX()
  {
    AppMethodBeat.i(87074);
    try
    {
      this.iwc.vnU = this.bBK.aJx();
      this.iwc.vnV = this.bBK.aJx();
      a(this.iwc);
      this.iwc.crd();
      this.bBK.a(this);
      this.bBK.a(this);
      AppMethodBeat.o(87074);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.luggage.g.d.e("MicroMsg.AppBrandPageActionSheet", "show exception = %s", new Object[] { localException });
      AppMethodBeat.o(87074);
    }
    return false;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(141662);
    aIY();
    AppMethodBeat.o(141662);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(141661);
    aIY();
    AppMethodBeat.o(141661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.p
 * JD-Core Version:    0.7.0.1
 */