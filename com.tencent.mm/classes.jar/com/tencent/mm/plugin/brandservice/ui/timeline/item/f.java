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
import com.tencent.mm.ah.m;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "cover", "Landroid/widget/ImageView;", "coverContainer", "Landroid/view/View;", "icon", "iconContainer", "playTimeTv", "Landroid/widget/TextView;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "filling", "", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "inflate", "id", "", "refreshFirstItem", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "refreshVideoIcon", "plugin-brandservice_release"})
public final class f
  extends e
{
  private ImageView ka;
  private View oiA;
  private View oiB;
  private ImageView oic;
  private final com.tencent.mm.ah.v oif;
  TextView oiz;
  
  public f(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(208669);
    this.oif = new com.tencent.mm.ah.v();
    AppMethodBeat.o(208669);
  }
  
  private final void a(w paramw, om paramom, final ol paramol)
  {
    AppMethodBeat.i(208667);
    final y.a locala = new y.a();
    locala.NiT = false;
    label106:
    Object localObject;
    int i;
    int j;
    boolean bool;
    switch (paramw.ftk().style)
    {
    default: 
      this.oif.type = paramol.hFR;
      this.oif.hGe = paramol.FYu;
      this.oif.hGv = paramol.FYu;
      this.oif.url = paramol.FYs;
      paramom = this.oiA;
      if (paramom != null)
      {
        paramom = paramom.getLayoutParams();
        if (paramom != null) {
          paramom.height = b.ofU;
        }
        localObject = this.oiA;
        if (localObject != null) {
          ((View)localObject).setLayoutParams(paramom);
        }
        i = a.iu(this.context);
        j = b.ofX;
        this.ohs.ogi.a(paramw.field_msgId, 0, this.oif, paramol.FYu, this.oic, i - j, b.ofU, false, (m.a)new a(this, locala, paramol), false, paramw.ole);
        AppMethodBeat.o(208667);
        return;
      }
      break;
    case 101: 
      if (paramom.Gcu.size() <= 1) {}
      for (bool = true;; bool = false)
      {
        locala.NiT = bool;
        break;
      }
    case 102: 
      paramom = paramw.ftk().HTS.Gal;
      p.g(paramom, "info.tlRecCardWrapper.extraInfo.BizInfo");
      paramom = (Iterable)j.b((Iterable)paramom, 2);
      j = 0;
      paramom = paramom.iterator();
      i = 0;
      label281:
      if (paramom.hasNext())
      {
        localObject = paramom.next();
        if (j < 0) {
          j.gkd();
        }
        if (((om)localObject).FNv != 0) {
          break label362;
        }
        i += 1;
      }
      break;
    }
    label362:
    for (;;)
    {
      j += 1;
      break label281;
      if (i < 2) {}
      for (bool = true;; bool = false)
      {
        locala.NiT = bool;
        break;
      }
      paramom = null;
      break label106;
    }
  }
  
  private final void b(ol paramol)
  {
    AppMethodBeat.i(208668);
    float f = 0.5F;
    Object localObject = this.oip;
    int i;
    if ((localObject != null) && (((MMNeat7extView)localObject).getVisibility() == 0))
    {
      i = a.iu(this.context);
      int j = a.fromDPToPix(this.context, 48);
      localObject = this.oip;
      if (localObject != null) {
        ((MMNeat7extView)localObject).measure(i - j, 0);
      }
      localObject = this.oiA;
      if (localObject == null) {
        p.gkB();
      }
      i = ((View)localObject).getLayoutParams().height;
      localObject = this.oip;
      if (localObject == null) {
        p.gkB();
      }
      j = ((MMNeat7extView)localObject).getMeasuredHeight();
      int k = b.ogd;
      f = 0.56F;
      i = i - j - k;
      if (this.oiB == null) {
        break label234;
      }
      localObject = this.oiB;
      if (localObject == null) {
        break label202;
      }
    }
    label202:
    for (localObject = ((View)localObject).getLayoutParams();; localObject = null)
    {
      if (localObject != null) {
        break label208;
      }
      paramol = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(208668);
      throw paramol;
      localObject = this.oiA;
      if (localObject == null) {
        p.gkB();
      }
      i = ((View)localObject).getLayoutParams().height;
      break;
    }
    label208:
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * f - a.fromDPToPix(this.context, 48) / 2));
    label234:
    paramol = m.ol(paramol.FYG);
    if (!TextUtils.isEmpty((CharSequence)paramol))
    {
      localObject = this.oiz;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.oiz;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramol);
      }
      paramol = this.oiz;
      if (paramol != null) {
        paramol.setTextColor(this.context.getResources().getColor(2131100541));
      }
    }
    for (;;)
    {
      paramol = this.oiz;
      if (paramol == null) {
        break;
      }
      paramol.setShadowLayer(10.0F, 0.0F, 0.0F, this.context.getResources().getColor(2131099662));
      AppMethodBeat.o(208668);
      return;
      paramol = this.oiz;
      if (paramol != null) {
        paramol.setVisibility(8);
      }
    }
    AppMethodBeat.o(208668);
  }
  
  public final void V(View paramView, int paramInt)
  {
    AppMethodBeat.i(208666);
    p.h(paramView, "parent");
    if (this.auu == null)
    {
      super.V(paramView, paramInt);
      Object localObject = this.auu;
      if (localObject != null) {}
      for (localObject = (ImageView)((View)localObject).findViewById(2131298813); localObject == null; localObject = null)
      {
        paramView = new d.v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(208666);
        throw paramView;
      }
      this.oic = ((ImageView)localObject);
      localObject = this.auu;
      if (localObject != null) {}
      for (localObject = (ImageView)((View)localObject).findViewById(2131306344); localObject == null; localObject = null)
      {
        paramView = new d.v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(208666);
        throw paramView;
      }
      this.ka = ((ImageView)localObject);
      localObject = this.auu;
      if (localObject != null) {}
      for (localObject = (TextView)((View)localObject).findViewById(2131303288); localObject == null; localObject = null)
      {
        paramView = new d.v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(208666);
        throw paramView;
      }
      this.oiz = ((TextView)localObject);
      localObject = this.auu;
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131298187);
        this.oiA = ((View)localObject);
        localObject = this.auu;
        if (localObject == null) {
          break label292;
        }
        localObject = ((View)localObject).findViewById(2131306345);
        label224:
        this.oiB = ((View)localObject);
        bPv();
        this.oio = paramView.findViewById(2131298112);
        paramView = this.auu;
        if (paramView == null) {
          break label297;
        }
      }
      label292:
      label297:
      for (paramView = (MMNeat7extView)paramView.findViewById(2131305948);; paramView = null)
      {
        if (paramView != null) {
          break label302;
        }
        paramView = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(208666);
        throw paramView;
        localObject = null;
        break;
        localObject = null;
        break label224;
      }
      label302:
      this.oip = paramView;
      paramView = this.auu;
      if (paramView != null) {}
      for (paramView = (ImageView)paramView.findViewById(2131303387); paramView == null; paramView = null)
      {
        paramView = new d.v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(208666);
        throw paramView;
      }
      this.oiq = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label467;
      }
      paramView = (LinearLayout)paramView.findViewById(2131297367);
      this.oir = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label472;
      }
      paramView = (LinearLayout)paramView.findViewById(2131304832);
      label405:
      this.ois = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label477;
      }
      paramView = (MMNeat7extView)paramView.findViewById(2131304829);
      label430:
      this.oit = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label482;
      }
    }
    label467:
    label472:
    label477:
    label482:
    for (paramView = (MMNeat7extView)paramView.findViewById(2131304827);; paramView = null)
    {
      this.oiu = paramView;
      AppMethodBeat.o(208666);
      return;
      paramView = null;
      break;
      paramView = null;
      break label405;
      paramView = null;
      break label430;
    }
  }
  
  public final void a(View paramView, w paramw, om paramom)
  {
    AppMethodBeat.i(208665);
    p.h(paramView, "parent");
    p.h(paramw, "info");
    p.h(paramom, "bizInfo");
    V(paramView, 2131306455);
    if (this.auu == null)
    {
      AppMethodBeat.o(208665);
      return;
    }
    paramView = this.auu;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    paramView = (ol)paramom.Gcu.get(0);
    p.g(paramView, "appMsg");
    b(paramw, paramom, paramView);
    b(paramView);
    a(paramw, paramom, paramView);
    c(paramw, paramom, paramView);
    AppMethodBeat.o(208665);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo$refreshFirstItem$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class a
    implements m.a
  {
    a(y.a parama, ol paramol) {}
    
    public final void onFinish()
    {
      AppMethodBeat.i(208664);
      Object localObject = this.oiC.oiw;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.oiC.context.getResources().getColor(2131099674));
      }
      localObject = this.oiC.oiq;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (!locala.NiT)
      {
        localObject = this.oiC.oip;
        if (localObject != null) {
          ((MMNeat7extView)localObject).setTextColor(this.oiC.context.getResources().getColor(2131101182));
        }
      }
      this.oiC.a(paramol);
      localObject = this.oiC.oiz;
      if (localObject != null)
      {
        ((TextView)localObject).setTextColor(this.oiC.context.getResources().getColor(2131101182));
        AppMethodBeat.o(208664);
        return;
      }
      AppMethodBeat.o(208664);
    }
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.f
 * JD-Core Version:    0.7.0.1
 */