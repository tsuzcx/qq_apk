package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.protocal.protobuf.emg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItem;", "Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;", "(Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "app_release"})
public final class SportHistoryUI$b
  extends e<SportHistoryUI.a>
{
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(272815);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(272815);
  }
  
  public final int getLayoutId()
  {
    return R.i.elr;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert$onBindViewHolder$4$2"})
  static final class a
    implements View.OnClickListener
  {
    a(emg paramemg, SportHistoryUI.b paramb, ViewGroup paramViewGroup) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(288521);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert$onBindViewHolder$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).b(this.vss.appId, (q.a)new q.a()
      {
        public final void b(WxaAttributes paramAnonymousWxaAttributes)
        {
          AppMethodBeat.i(266068);
          if (paramAnonymousWxaAttributes != null)
          {
            f.a locala = new f.a(MMApplicationContext.getContext());
            locala.bBl(this.vsv.vst.vsr.getString(R.l.top_story_open_appbrand, new Object[] { paramAnonymousWxaAttributes.field_nickname })).HL(true);
            locala.ayp(R.l.app_accept);
            locala.c((f.c)new f.c()
            {
              public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(282267);
                if (paramAnonymous2Boolean)
                {
                  paramAnonymous2String = new xw();
                  paramAnonymous2String.fWN.userName = this.vsw.field_username;
                  paramAnonymous2String.fWN.fWP = jdField_this.vsv.vss.UoS;
                  paramAnonymous2String.fWN.scene = 1171;
                  EventCenter.instance.publish((IEvent)paramAnonymous2String);
                }
                AppMethodBeat.o(282267);
              }
            }).show();
            AppMethodBeat.o(266068);
            return;
          }
          AppMethodBeat.o(266068);
        }
      });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert$onBindViewHolder$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(288521);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "info", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
  static final class b
    implements q.a
  {
    b(aa.f paramf, ImageView paramImageView) {}
    
    public final void b(WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(268333);
      if (paramWxaAttributes != null)
      {
        com.tencent.e.h.ZvG.bc((Runnable)new a(paramWxaAttributes, this));
        AppMethodBeat.o(268333);
        return;
      }
      AppMethodBeat.o(268333);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert$onBindViewHolder$4$1$1$1"})
    static final class a
      implements Runnable
    {
      a(WxaAttributes paramWxaAttributes, SportHistoryUI.b.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(268536);
        Object localObject = ((View)jdField_this.tDM.aaBC).findViewById(R.h.drn);
        p.j(localObject, "view.findViewById<TextView>(R.id.appbrand_name_tv)");
        ((TextView)localObject).setText((CharSequence)this.vsz.field_nickname);
        localObject = new c.a().bmJ().bmG().bmL();
        com.tencent.mm.ay.q.bml().a(this.vsz.field_smallHeadURL, jdField_this.vsy, (c)localObject);
        AppMethodBeat.o(268536);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.SportHistoryUI.b
 * JD-Core Version:    0.7.0.1
 */