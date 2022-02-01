package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q.a;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "info", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
final class SportProfileUIC$h
  implements q.a
{
  SportProfileUIC$h(z.f paramf, ImageView paramImageView) {}
  
  public final void b(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(230644);
    if (paramWxaAttributes != null)
    {
      h.RTc.aV((Runnable)new a(paramWxaAttributes, this));
      AppMethodBeat.o(230644);
      return;
    }
    AppMethodBeat.o(230644);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$7$1$1$1"})
  static final class a
    implements Runnable
  {
    a(WxaAttributes paramWxaAttributes, SportProfileUIC.h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(230643);
      Object localObject = ((View)jdField_this.qhQ.SYG).findViewById(2131296992);
      p.g(localObject, "view.findViewById<TextView>(R.id.appbrand_name_tv)");
      ((TextView)localObject).setText((CharSequence)this.rMP.field_nickname);
      localObject = new c.a().bdt().bdq().bdv();
      q.bcV().a(this.rMP.field_smallHeadURL, jdField_this.rMO, (c)localObject);
      AppMethodBeat.o(230643);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.h
 * JD-Core Version:    0.7.0.1
 */