package com.tencent.mm.plugin.exdevice.ui;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q.a;

final class b$2
  implements q.a
{
  b$2(b paramb, TextView paramTextView, ImageView paramImageView) {}
  
  public final void b(final WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(292380);
    if (paramWxaAttributes != null) {
      h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(289529);
          b.2.this.vpx.setText(paramWxaAttributes.field_nickname);
          Object localObject = new c.a();
          ((c.a)localObject).kPz = true;
          ((c.a)localObject).lRC = true;
          localObject = ((c.a)localObject).bmL();
          q.bml().a(paramWxaAttributes.field_smallHeadURL, b.2.this.vpy, (c)localObject);
          AppMethodBeat.o(289529);
        }
      });
    }
    AppMethodBeat.o(292380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.b.2
 * JD-Core Version:    0.7.0.1
 */