package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "cover", "Landroid/widget/ImageView;", "getCover", "()Landroid/widget/ImageView;", "setCover", "(Landroid/widget/ImageView;)V", "coverLayout", "Landroid/view/View;", "getCoverLayout", "()Landroid/view/View;", "setCoverLayout", "(Landroid/view/View;)V", "coverMask", "getCoverMask", "setCoverMask", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "filling", "", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "inflate", "id", "", "refreshFirstItem", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "refreshHeight", "v", "plugin-brandservice_release"})
public final class d
  extends f
{
  private ImageView ptE;
  private View ptF;
  private ImageView ptG;
  private final v ptH;
  
  public d(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(195264);
    this.ptH = new v();
    AppMethodBeat.o(195264);
  }
  
  private static void dt(View paramView)
  {
    AppMethodBeat.i(195263);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = b.prq;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(195263);
  }
  
  public final void U(View paramView, int paramInt)
  {
    AppMethodBeat.i(195262);
    p.h(paramView, "parent");
    if (this.aus == null)
    {
      super.U(paramView, paramInt);
      this.ptE = ((ImageView)paramView.findViewById(2131299289));
      this.ptF = paramView.findViewById(2131299290);
      this.ptG = ((ImageView)paramView.findViewById(2131299291));
      cmH();
      this.ptQ = paramView.findViewById(2131309300);
      paramView = this.aus;
      if (paramView != null) {}
      for (paramView = (MMNeat7extView)paramView.findViewById(2131309249); paramView == null; paramView = null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(195262);
        throw paramView;
      }
      this.ptR = paramView;
      paramView = this.aus;
      if (paramView != null) {}
      for (paramView = (ImageView)paramView.findViewById(2131306101); paramView == null; paramView = null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(195262);
        throw paramView;
      }
      this.ptS = paramView;
      paramView = this.aus;
      if (paramView == null) {
        break label276;
      }
      paramView = (LinearLayout)paramView.findViewById(2131297585);
      this.ptT = paramView;
      paramView = this.aus;
      if (paramView == null) {
        break label281;
      }
      paramView = (LinearLayout)paramView.findViewById(2131307917);
      label217:
      this.ptU = paramView;
      paramView = this.aus;
      if (paramView == null) {
        break label286;
      }
      paramView = (MMNeat7extView)paramView.findViewById(2131307915);
      label241:
      this.ptV = paramView;
      paramView = this.aus;
      if (paramView == null) {
        break label291;
      }
    }
    label276:
    label281:
    label286:
    label291:
    for (paramView = (MMNeat7extView)paramView.findViewById(2131307913);; paramView = null)
    {
      this.ptW = paramView;
      AppMethodBeat.o(195262);
      return;
      paramView = null;
      break;
      paramView = null;
      break label217;
      paramView = null;
      break label241;
    }
  }
  
  public final void a(final View paramView, final z paramz, pj parampj)
  {
    AppMethodBeat.i(195261);
    p.h(paramView, "parent");
    p.h(paramz, "info");
    p.h(parampj, "bizInfo");
    U(paramView, 2131309892);
    if (this.aus == null)
    {
      AppMethodBeat.o(195261);
      return;
    }
    paramView = this.aus;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    paramView = (pi)parampj.KWy.get(0);
    p.g(paramView, "appMsg");
    a(paramz, parampj, paramView);
    Object localObject1 = this.ptF;
    if (localObject1 == null) {
      p.hyc();
    }
    dt((View)localObject1);
    localObject1 = this.ptE;
    if (localObject1 == null) {
      p.hyc();
    }
    dt((View)localObject1);
    localObject1 = new z.a();
    ((z.a)localObject1).SYB = false;
    boolean bool;
    switch (paramz.gAD().style)
    {
    default: 
      this.ptH.type = paramView.iAb;
      this.ptH.iAo = paramView.KSl;
      this.ptH.iAD = paramView.KSl;
      this.ptH.url = paramView.KSj;
      i = a.jn(this.context);
      j = b.prw;
      this.psQ.prc.a(paramz.field_msgId, 0, this.ptH, paramView.KSl, this.ptE, i - j, b.prq, false, (m.a)new a(this, (z.a)localObject1, paramz, paramView), false, paramz.pxD);
      b(paramz, parampj, paramView);
      AppMethodBeat.o(195261);
      return;
    case 101: 
      if (parampj.KWy.size() <= 1) {}
      for (bool = true;; bool = false)
      {
        ((z.a)localObject1).SYB = bool;
        break;
      }
    }
    Object localObject2 = paramz.gAD().Nga.KUf;
    p.g(localObject2, "info.tlRecCardWrapper.extraInfo.BizInfo");
    localObject2 = (Iterable)j.b((Iterable)localObject2, 2);
    int j = 0;
    localObject2 = ((Iterable)localObject2).iterator();
    int i = 0;
    label374:
    if (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (j < 0) {
        j.hxH();
      }
      if (((pj)localObject3).KHa != 0) {
        break label452;
      }
      i += 1;
    }
    label452:
    for (;;)
    {
      j += 1;
      break label374;
      if (i < 2) {}
      for (bool = true;; bool = false)
      {
        ((z.a)localObject1).SYB = bool;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle$refreshFirstItem$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class a
    implements m.a
  {
    a(z.a parama, z paramz, pi parampi) {}
    
    public final void onFinish()
    {
      AppMethodBeat.i(195260);
      Object localObject = this.ptI.ptY;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.ptI.context.getResources().getColor(2131099681));
      }
      localObject = this.ptI.ptS;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (!this.ptJ.SYB)
      {
        localObject = this.ptI.ptR;
        if (localObject != null) {
          ((MMNeat7extView)localObject).setTextColor(this.ptI.context.getResources().getColor(2131101427));
        }
      }
      this.ptI.a(paramz, paramView);
      AppMethodBeat.o(195260);
    }
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.d
 * JD-Core Version:    0.7.0.1
 */