package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.v;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "cover", "Landroid/widget/ImageView;", "coverContainer", "Landroid/view/View;", "icon", "iconContainer", "playTimeTv", "Landroid/widget/TextView;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "filling", "", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "getVideoViewContainer", "inflate", "id", "", "refreshFirstItem", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "refreshVideoIcon", "plugin-brandservice_release"})
public final class g
  extends f
{
  private ImageView kc;
  private ImageView ptE;
  private final v ptH;
  TextView pub;
  View puc;
  private View pud;
  
  public g(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(195275);
    this.ptH = new v();
    AppMethodBeat.o(195275);
  }
  
  public final void U(View paramView, int paramInt)
  {
    AppMethodBeat.i(195274);
    p.h(paramView, "parent");
    if (this.aus == null)
    {
      super.U(paramView, paramInt);
      Object localObject = this.aus;
      if (localObject != null) {}
      for (localObject = (ImageView)((View)localObject).findViewById(2131299277); localObject == null; localObject = null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(195274);
        throw paramView;
      }
      this.ptE = ((ImageView)localObject);
      localObject = this.aus;
      if (localObject != null) {}
      for (localObject = (ImageView)((View)localObject).findViewById(2131309770); localObject == null; localObject = null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(195274);
        throw paramView;
      }
      this.kc = ((ImageView)localObject);
      localObject = this.aus;
      if (localObject != null) {}
      for (localObject = (TextView)((View)localObject).findViewById(2131305961); localObject == null; localObject = null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(195274);
        throw paramView;
      }
      this.pub = ((TextView)localObject);
      localObject = this.aus;
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131298568);
        this.puc = ((View)localObject);
        localObject = this.aus;
        if (localObject == null) {
          break label275;
        }
        localObject = ((View)localObject).findViewById(2131309771);
        label211:
        this.pud = ((View)localObject);
        cmH();
        this.ptQ = paramView.findViewById(2131298462);
        paramView = this.aus;
        if (paramView == null) {
          break label280;
        }
      }
      label275:
      label280:
      for (paramView = (MMNeat7extView)paramView.findViewById(2131309249);; paramView = null)
      {
        if (paramView != null) {
          break label285;
        }
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(195274);
        throw paramView;
        localObject = null;
        break;
        localObject = null;
        break label211;
      }
      label285:
      this.ptR = paramView;
      paramView = this.aus;
      if (paramView != null) {}
      for (paramView = (ImageView)paramView.findViewById(2131306101); paramView == null; paramView = null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(195274);
        throw paramView;
      }
      this.ptS = paramView;
      paramView = this.aus;
      if (paramView == null) {
        break label442;
      }
      paramView = (LinearLayout)paramView.findViewById(2131297585);
      this.ptT = paramView;
      paramView = this.aus;
      if (paramView == null) {
        break label447;
      }
      paramView = (LinearLayout)paramView.findViewById(2131307918);
      label383:
      this.ptU = paramView;
      paramView = this.aus;
      if (paramView == null) {
        break label452;
      }
      paramView = (MMNeat7extView)paramView.findViewById(2131307915);
      label407:
      this.ptV = paramView;
      paramView = this.aus;
      if (paramView == null) {
        break label457;
      }
    }
    label442:
    label447:
    label452:
    label457:
    for (paramView = (MMNeat7extView)paramView.findViewById(2131307913);; paramView = null)
    {
      this.ptW = paramView;
      AppMethodBeat.o(195274);
      return;
      paramView = null;
      break;
      paramView = null;
      break label383;
      paramView = null;
      break label407;
    }
  }
  
  public final void a(View paramView, final z paramz, pj parampj)
  {
    AppMethodBeat.i(195273);
    p.h(paramView, "parent");
    p.h(paramz, "info");
    p.h(parampj, "bizInfo");
    U(paramView, 2131309898);
    if (this.aus == null)
    {
      AppMethodBeat.o(195273);
      return;
    }
    paramView = this.aus;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    final pi localpi = (pi)parampj.KWy.get(0);
    p.g(localpi, "appMsg");
    a(paramz, parampj, localpi);
    float f = 0.5F;
    paramView = this.ptR;
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      i = a.jn(this.context);
      j = a.fromDPToPix(this.context, 48);
      paramView = this.ptR;
      if (paramView != null) {
        paramView.measure(i - j, 0);
      }
      paramView = this.puc;
      if (paramView == null) {
        p.hyc();
      }
      i = paramView.getLayoutParams().height;
      paramView = this.ptR;
      if (paramView == null) {
        p.hyc();
      }
      j = paramView.getMeasuredHeight();
      int k = b.prC;
      f = 0.56F;
      i = i - j - k;
      if (this.pud == null) {
        break label300;
      }
      paramView = this.pud;
      if (paramView == null) {
        break label268;
      }
    }
    label268:
    for (paramView = paramView.getLayoutParams();; paramView = null)
    {
      if (paramView != null) {
        break label273;
      }
      paramView = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(195273);
      throw paramView;
      paramView = this.puc;
      if (paramView == null) {
        p.hyc();
      }
      i = paramView.getLayoutParams().height;
      break;
    }
    label273:
    ((RelativeLayout.LayoutParams)paramView).topMargin = ((int)(i * f - a.fromDPToPix(this.context, 48) / 2));
    label300:
    paramView = m.rJ(localpi.KSx);
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)paramView))
    {
      localObject1 = this.pub;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.pub;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)paramView);
      }
      paramView = this.pub;
      if (paramView != null) {
        paramView.setTextColor(this.context.getResources().getColor(2131100679));
      }
    }
    label518:
    Object localObject2;
    for (;;)
    {
      paramView = this.pub;
      if (paramView != null) {
        paramView.setShadowLayer(10.0F, 0.0F, 0.0F, this.context.getResources().getColor(2131099665));
      }
      localObject1 = new z.a();
      ((z.a)localObject1).SYB = false;
      switch (paramz.gAD().style)
      {
      default: 
        this.ptH.type = localpi.iAb;
        this.ptH.iAo = localpi.KSl;
        this.ptH.iAD = localpi.KSl;
        this.ptH.url = localpi.KSj;
        paramView = this.puc;
        if (paramView == null) {
          break label823;
        }
        paramView = paramView.getLayoutParams();
        if (paramView != null) {
          paramView.height = b.prs;
        }
        localObject2 = this.puc;
        if (localObject2 != null) {
          ((View)localObject2).setLayoutParams(paramView);
        }
        i = a.jn(this.context);
        j = b.prw;
        this.psQ.prc.a(paramz.field_msgId, 0, this.ptH, localpi.KSl, this.ptE, i - j, b.prs, false, (m.a)new a(this, (z.a)localObject1, paramz, localpi), false, paramz.pxD);
        b(paramz, parampj, localpi);
        paramView = e.pAN;
        e.F(this.ptH.url, this.ptH.type, "");
        AppMethodBeat.o(195273);
        return;
        paramView = this.pub;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        break;
      }
    }
    if (parampj.KWy.size() <= 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((z.a)localObject1).SYB = bool;
      break;
    }
    paramView = paramz.gAD().Nga.KUf;
    p.g(paramView, "info.tlRecCardWrapper.extraInfo.BizInfo");
    paramView = (Iterable)j.b((Iterable)paramView, 2);
    int j = 0;
    paramView = paramView.iterator();
    int i = 0;
    label747:
    if (paramView.hasNext())
    {
      localObject2 = paramView.next();
      if (j < 0) {
        j.hxH();
      }
      if (((pj)localObject2).KHa != 0) {
        break label828;
      }
      i += 1;
    }
    label823:
    label828:
    for (;;)
    {
      j += 1;
      break label747;
      if (i < 2) {}
      for (bool = true;; bool = false)
      {
        ((z.a)localObject1).SYB = bool;
        break;
      }
      paramView = null;
      break label518;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo$refreshFirstItem$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class a
    implements m.a
  {
    a(z.a parama, z paramz, pi parampi) {}
    
    public final void onFinish()
    {
      AppMethodBeat.i(195272);
      Object localObject = this.pue.ptY;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.pue.context.getResources().getColor(2131099681));
      }
      localObject = this.pue.ptS;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (!this.ptJ.SYB)
      {
        localObject = this.pue.ptR;
        if (localObject != null) {
          ((MMNeat7extView)localObject).setTextColor(this.pue.context.getResources().getColor(2131101427));
        }
      }
      this.pue.a(paramz, localpi);
      localObject = this.pue.pub;
      if (localObject != null)
      {
        ((TextView)localObject).setTextColor(this.pue.context.getResources().getColor(2131101427));
        AppMethodBeat.o(195272);
        return;
      }
      AppMethodBeat.o(195272);
    }
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.g
 * JD-Core Version:    0.7.0.1
 */