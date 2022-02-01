package com.tencent.mm.plugin.exdevice.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItem;", "Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;", "(Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "app_release"})
public final class SportHistoryUI$b
  extends e<SportHistoryUI.a>
{
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(230627);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(230627);
  }
  
  public final int getLayoutId()
  {
    return 2131496540;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert$onBindViewHolder$4$2"})
  static final class a
    implements View.OnClickListener
  {
    a(ecf paramecf, SportHistoryUI.b paramb, ViewGroup paramViewGroup) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230624);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert$onBindViewHolder$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      ((q)g.af(q.class)).b(this.rMI.appId, (q.a)new q.a()
      {
        public final void b(WxaAttributes paramAnonymousWxaAttributes)
        {
          AppMethodBeat.i(230623);
          if (paramAnonymousWxaAttributes != null)
          {
            f.a locala = new f.a(MMApplicationContext.getContext());
            locala.bow(this.rML.rMJ.rMH.getString(2131766828, new Object[] { paramAnonymousWxaAttributes.field_nickname })).Dq(true);
            locala.apa(2131755305);
            locala.c((f.c)new f.c()
            {
              public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(230622);
                if (paramAnonymous2Boolean)
                {
                  paramAnonymous2String = new wq();
                  paramAnonymous2String.ecI.userName = this.rMM.field_username;
                  paramAnonymous2String.ecI.ecK = jdField_this.rML.rMI.Ncv;
                  paramAnonymous2String.ecI.scene = 1171;
                  EventCenter.instance.publish((IEvent)paramAnonymous2String);
                }
                AppMethodBeat.o(230622);
              }
            }).show();
            AppMethodBeat.o(230623);
            return;
          }
          AppMethodBeat.o(230623);
        }
      });
      a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert$onBindViewHolder$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230624);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.SportHistoryUI.b
 * JD-Core Version:    0.7.0.1
 */