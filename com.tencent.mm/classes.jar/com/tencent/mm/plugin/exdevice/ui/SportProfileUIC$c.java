package com.tencent.mm.plugin.exdevice.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.protocal.protobuf.ecf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$7$2"})
final class SportProfileUIC$c
  implements View.OnClickListener
{
  SportProfileUIC$c(ecf paramecf, SportProfileUIC paramSportProfileUIC, z.f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(230638);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    ((q)g.af(q.class)).b(this.rMI.appId, (q.a)new q.a()
    {
      public final void b(WxaAttributes paramAnonymousWxaAttributes)
      {
        AppMethodBeat.i(230637);
        if (paramAnonymousWxaAttributes != null)
        {
          f.a locala = new f.a(MMApplicationContext.getContext());
          locala.bow(this.rNd.rMU.getActivity().getString(2131766828, new Object[] { paramAnonymousWxaAttributes.field_nickname })).Dq(true);
          locala.apa(2131755305);
          locala.c((f.c)new f.c()
          {
            public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(230636);
              if (paramAnonymous2Boolean)
              {
                paramAnonymous2String = new wq();
                paramAnonymous2String.ecI.userName = this.rMM.field_username;
                paramAnonymous2String.ecI.ecK = jdField_this.rNd.rMI.Ncv;
                paramAnonymous2String.ecI.scene = 1171;
                EventCenter.instance.publish((IEvent)paramAnonymous2String);
              }
              AppMethodBeat.o(230636);
            }
          }).show();
          AppMethodBeat.o(230637);
          return;
        }
        AppMethodBeat.o(230637);
      }
    });
    a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(230638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.c
 * JD-Core Version:    0.7.0.1
 */