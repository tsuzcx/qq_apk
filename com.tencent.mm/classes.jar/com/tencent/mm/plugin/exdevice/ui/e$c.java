package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.protocal.protobuf.emg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.aa.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$7$2"})
final class e$c
  implements View.OnClickListener
{
  e$c(emg paramemg, e parame, aa.f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(287730);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    ((q)h.ae(q.class)).b(this.vss.appId, (q.a)new q.a()
    {
      public final void b(WxaAttributes paramAnonymousWxaAttributes)
      {
        AppMethodBeat.i(253212);
        if (paramAnonymousWxaAttributes != null)
        {
          f.a locala = new f.a(MMApplicationContext.getContext());
          locala.bBl(this.vsN.vsE.getActivity().getString(R.l.top_story_open_appbrand, new Object[] { paramAnonymousWxaAttributes.field_nickname })).HL(true);
          locala.ayp(R.l.app_accept);
          locala.c((f.c)new f.c()
          {
            public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(243748);
              if (paramAnonymous2Boolean)
              {
                paramAnonymous2String = new xw();
                paramAnonymous2String.fWN.userName = this.vsw.field_username;
                paramAnonymous2String.fWN.fWP = jdField_this.vsN.vss.UoS;
                paramAnonymous2String.fWN.scene = 1171;
                EventCenter.instance.publish((IEvent)paramAnonymous2String);
              }
              AppMethodBeat.o(243748);
            }
          }).show();
          AppMethodBeat.o(253212);
          return;
        }
        AppMethodBeat.o(253212);
      }
    });
    a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(287730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.e.c
 * JD-Core Version:    0.7.0.1
 */