package com.tencent.mm.plugin.exdevice.ui;

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

final class b$2
  implements q.a
{
  b$2(b paramb, TextView paramTextView, ImageView paramImageView) {}
  
  public final void b(final WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(231713);
    if (paramWxaAttributes != null) {
      h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231712);
          b.2.this.rJP.setText(paramWxaAttributes.field_nickname);
          Object localObject = new c.a();
          ((c.a)localObject).iaT = true;
          ((c.a)localObject).jbe = true;
          localObject = ((c.a)localObject).bdv();
          q.bcV().a(paramWxaAttributes.field_smallHeadURL, b.2.this.rJQ, (c)localObject);
          AppMethodBeat.o(231712);
        }
      });
    }
    AppMethodBeat.o(231713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.b.2
 * JD-Core Version:    0.7.0.1
 */