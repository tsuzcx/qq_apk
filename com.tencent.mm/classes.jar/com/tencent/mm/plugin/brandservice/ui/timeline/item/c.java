package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.a.j;
import d.g.b.p;
import d.g.b.y.a;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "cover", "Landroid/widget/ImageView;", "getCover", "()Landroid/widget/ImageView;", "setCover", "(Landroid/widget/ImageView;)V", "coverLayout", "Landroid/view/View;", "getCoverLayout", "()Landroid/view/View;", "setCoverLayout", "(Landroid/view/View;)V", "coverMask", "getCoverMask", "setCoverMask", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "filling", "", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "inflate", "id", "", "refreshFirstItem", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "refreshHeight", "v", "plugin-brandservice_release"})
public final class c
  extends e
{
  private ImageView oic;
  private View oid;
  private ImageView oie;
  private final com.tencent.mm.ah.v oif;
  
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(208656);
    this.oif = new com.tencent.mm.ah.v();
    AppMethodBeat.o(208656);
  }
  
  private final void a(w paramw, om paramom, final ol paramol)
  {
    AppMethodBeat.i(208654);
    final y.a locala = new y.a();
    locala.NiT = false;
    boolean bool;
    switch (paramw.ftk().style)
    {
    default: 
      this.oif.type = paramol.hFR;
      this.oif.hGe = paramol.FYu;
      this.oif.hGv = paramol.FYu;
      this.oif.url = paramol.FYs;
      i = a.iu(this.context);
      j = b.ofX;
      this.ohs.ogi.a(paramw.field_msgId, 0, this.oif, paramol.FYu, this.oic, i - j, b.ofT, false, (m.a)new a(this, locala, paramol), false, paramw.ole);
      AppMethodBeat.o(208654);
      return;
    case 101: 
      if (paramom.Gcu.size() <= 1) {}
      for (bool = true;; bool = false)
      {
        locala.NiT = bool;
        break;
      }
    }
    paramom = paramw.ftk().HTS.Gal;
    p.g(paramom, "info.tlRecCardWrapper.extraInfo.BizInfo");
    paramom = (Iterable)j.b((Iterable)paramom, 2);
    int j = 0;
    paramom = paramom.iterator();
    int i = 0;
    label239:
    if (paramom.hasNext())
    {
      Object localObject = paramom.next();
      if (j < 0) {
        j.gkd();
      }
      if (((om)localObject).FNv != 0) {
        break label315;
      }
      i += 1;
    }
    label315:
    for (;;)
    {
      j += 1;
      break label239;
      if (i < 2) {}
      for (bool = true;; bool = false)
      {
        locala.NiT = bool;
        break;
      }
    }
  }
  
  private static void dC(View paramView)
  {
    AppMethodBeat.i(208655);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = b.ofT;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(208655);
  }
  
  public final void V(View paramView, int paramInt)
  {
    AppMethodBeat.i(208653);
    p.h(paramView, "parent");
    if (this.auu == null)
    {
      super.V(paramView, paramInt);
      this.oic = ((ImageView)paramView.findViewById(2131298824));
      this.oid = paramView.findViewById(2131298825);
      this.oie = ((ImageView)paramView.findViewById(2131298826));
      bPv();
      this.oio = paramView.findViewById(2131305993);
      paramView = this.auu;
      if (paramView != null) {}
      for (paramView = (MMNeat7extView)paramView.findViewById(2131305948); paramView == null; paramView = null)
      {
        paramView = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(208653);
        throw paramView;
      }
      this.oip = paramView;
      paramView = this.auu;
      if (paramView != null) {}
      for (paramView = (ImageView)paramView.findViewById(2131303387); paramView == null; paramView = null)
      {
        paramView = new d.v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(208653);
        throw paramView;
      }
      this.oiq = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label288;
      }
      paramView = (LinearLayout)paramView.findViewById(2131297367);
      this.oir = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label293;
      }
      paramView = (LinearLayout)paramView.findViewById(2131304831);
      label227:
      this.ois = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label298;
      }
      paramView = (MMNeat7extView)paramView.findViewById(2131304829);
      label252:
      this.oit = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label303;
      }
    }
    label288:
    label293:
    label298:
    label303:
    for (paramView = (MMNeat7extView)paramView.findViewById(2131304827);; paramView = null)
    {
      this.oiu = paramView;
      AppMethodBeat.o(208653);
      return;
      paramView = null;
      break;
      paramView = null;
      break label227;
      paramView = null;
      break label252;
    }
  }
  
  public final void a(View paramView, w paramw, om paramom)
  {
    AppMethodBeat.i(208652);
    p.h(paramView, "parent");
    p.h(paramw, "info");
    p.h(paramom, "bizInfo");
    V(paramView, 2131308227);
    if (this.auu == null)
    {
      AppMethodBeat.o(208652);
      return;
    }
    paramView = this.auu;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    paramView = (ol)paramom.Gcu.get(0);
    p.g(paramView, "appMsg");
    b(paramw, paramom, paramView);
    Object localObject = this.oid;
    if (localObject == null) {
      p.gkB();
    }
    dC((View)localObject);
    localObject = this.oic;
    if (localObject == null) {
      p.gkB();
    }
    dC((View)localObject);
    a(paramw, paramom, paramView);
    c(paramw, paramom, paramView);
    AppMethodBeat.o(208652);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle$refreshFirstItem$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class a
    implements m.a
  {
    a(y.a parama, ol paramol) {}
    
    public final void onFinish()
    {
      AppMethodBeat.i(208651);
      Object localObject = this.oig.oiw;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.oig.context.getResources().getColor(2131099674));
      }
      localObject = this.oig.oiq;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (!locala.NiT)
      {
        localObject = this.oig.oip;
        if (localObject != null) {
          ((MMNeat7extView)localObject).setTextColor(this.oig.context.getResources().getColor(2131101182));
        }
      }
      this.oig.a(paramol);
      AppMethodBeat.o(208651);
    }
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.c
 * JD-Core Version:    0.7.0.1
 */