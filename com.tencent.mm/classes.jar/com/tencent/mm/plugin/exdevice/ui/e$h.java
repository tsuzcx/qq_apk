package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q.a;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "info", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
final class e$h
  implements q.a
{
  e$h(aa.f paramf, ImageView paramImageView) {}
  
  public final void b(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(285479);
    if (paramWxaAttributes != null)
    {
      h.ZvG.bc((Runnable)new a(paramWxaAttributes, this));
      AppMethodBeat.o(285479);
      return;
    }
    AppMethodBeat.o(285479);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$7$1$1$1"})
  static final class a
    implements Runnable
  {
    a(WxaAttributes paramWxaAttributes, e.h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(291124);
      Object localObject = ((View)jdField_this.tDM.aaBC).findViewById(R.h.drn);
      p.j(localObject, "view.findViewById<TextView>(R.id.appbrand_name_tv)");
      ((TextView)localObject).setText((CharSequence)this.vsz.field_nickname);
      localObject = new c.a().bmJ().bmG().bmL();
      q.bml().a(this.vsz.field_smallHeadURL, jdField_this.vsy, (c)localObject);
      AppMethodBeat.o(291124);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.e.h
 * JD-Core Version:    0.7.0.1
 */