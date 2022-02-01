package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.v;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import d.a.j;
import d.g.b.ad;
import d.l;
import java.util.Arrays;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "viewVideos", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "BizTLRecCardVideo", "plugin-brandservice_release"})
public final class o
  extends p
{
  private View oiV;
  private a[] ojB;
  
  public o(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(208741);
    AppMethodBeat.o(208741);
  }
  
  public final void a(w paramw, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(208738);
    d.g.b.p.h(paramw, "info");
    d.g.b.p.h(paramView1, "convertView");
    d.g.b.p.h(paramView2, "parent");
    super.a(paramw, paramInt, paramView1, paramView2);
    paramView2 = paramw.ftj();
    if (paramView2 != null) {}
    for (paramView1 = paramView2.HTL; paramView1 == null; paramView1 = null)
    {
      AppMethodBeat.o(208738);
      return;
    }
    paramView1 = this.oiV;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = paramView2.Gcu;
    if (paramView1 != null)
    {
      paramView1 = (Iterable)paramView1;
      paramInt = 0;
      Iterator localIterator = paramView1.iterator();
      while (localIterator.hasNext())
      {
        paramView1 = localIterator.next();
        int i = paramInt + 1;
        if (paramInt < 0) {
          j.gkd();
        }
        Object localObject = (dmm)paramView1;
        if ((localObject != null) && ((((dmm)localObject).FNv & 0x1) == 0))
        {
          paramView1 = this.ojB;
          if (paramView1 != null)
          {
            a locala = paramView1[paramInt];
            if (locala != null)
            {
              d.g.b.p.h(paramw, "info");
              d.g.b.p.h(paramView2, "recCard");
              d.g.b.p.h(localObject, "appMsg");
              String str2 = ((dmm)localObject).Title;
              String str3 = ((dmm)localObject).FYs;
              int j = ((dmm)localObject).hFR;
              String str1 = ((dmm)localObject).FYu;
              long l = ((dmm)localObject).Gcl;
              String str4 = m.ol(((dmm)localObject).FYG);
              paramView1 = "";
              label264:
              TextView localTextView;
              if (l > 0L)
              {
                if (l < 10000L) {
                  paramView1 = String.valueOf(l);
                }
              }
              else
              {
                localTextView = locala.ojD;
                if (!d.g.b.p.i(paramView1, "")) {
                  break label708;
                }
              }
              label708:
              for (paramView1 = (CharSequence)"";; paramView1 = (CharSequence)locala.ojI.context.getString(2131760255, new Object[] { paramView1 }))
              {
                localTextView.setText(paramView1);
                locala.ojD.setShadowLayer(2.0F, 0.0F, 0.0F, locala.ojI.context.getResources().getColor(2131099663));
                locala.ojE.setText((CharSequence)str4);
                locala.ojE.setShadowLayer(2.0F, 0.0F, 0.0F, locala.ojI.context.getResources().getColor(2131099663));
                locala.ojF.setText((CharSequence)str2);
                locala.hcj.setOnClickListener((View.OnClickListener)new o.a.a(locala, paramw, (dmm)localObject, paramInt));
                if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(1)) && (!bu.isNullOrNil(str3))) {
                  ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(str3, j, 90, new Object[0]);
                }
                float f = (com.tencent.mm.plugin.brandservice.ui.timeline.b.ofT * 2.35F - com.tencent.mm.cb.a.h(locala.ojI.context, 40.0F)) / 2.0F;
                j = (int)(f / 1.77D);
                paramView1 = locala.hcj.getLayoutParams();
                localObject = locala.ojG.getLayoutParams();
                paramView1.width = ((int)f);
                ((ViewGroup.LayoutParams)localObject).height = j;
                locala.hcj.setLayoutParams(paramView1);
                locala.ojG.setLayoutParams((ViewGroup.LayoutParams)localObject);
                locala.ojC.setVisibility(0);
                locala.ojH.hGe = str1;
                locala.ojH.url = str1;
                locala.ojH.type = 5;
                locala.ojI.ohs.ogi.a(paramw.field_msgId, paramInt, locala.ojH, locala.ojH.hGe, locala.ojC, (int)f, j, false, (m.a)new o.a.b(), paramw.ole + paramInt, com.tencent.mm.cb.a.h(locala.ojI.context, 4.0F));
                paramInt = i;
                break;
                if (l < 100000L)
                {
                  paramView1 = ad.Njc;
                  paramView1 = String.format("%.1f万", Arrays.copyOf(new Object[] { Float.valueOf((float)l / 10000.0F) }, 1));
                  d.g.b.p.g(paramView1, "java.lang.String.format(format, *args)");
                  break label264;
                }
                paramView1 = "10万+";
                break label264;
              }
            }
          }
          paramInt = i;
        }
        else
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1149L, 6L, 1L, false);
          paramInt = i;
        }
      }
    }
    com.tencent.mm.plugin.brandservice.ui.b.c.m(paramw);
    AppMethodBeat.o(208738);
  }
  
  public final void dD(View paramView)
  {
    AppMethodBeat.i(208739);
    d.g.b.p.h(paramView, "parent");
    if (this.oiV == null)
    {
      paramView = ((ViewStub)paramView.findViewById(2131307257)).inflate();
      d.g.b.p.g(paramView, "this");
      dE(paramView);
      Object localObject = paramView.findViewById(2131307156);
      d.g.b.p.g(localObject, "this.findViewById(R.id.biz_rec_card_finder_video1)");
      localObject = new a((View)localObject);
      View localView = paramView.findViewById(2131307157);
      d.g.b.p.g(localView, "this.findViewById(R.id.biz_rec_card_finder_video2)");
      this.ojB = new a[] { localObject, new a(localView) };
      this.oiV = paramView;
    }
    AppMethodBeat.o(208739);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(208740);
    View localView = this.oiV;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(208740);
      return;
    }
    AppMethodBeat.o(208740);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;Landroid/view/View;)V", "bizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "coverRl", "Landroid/widget/RelativeLayout;", "getCoverRl", "()Landroid/widget/RelativeLayout;", "imgCover", "Landroid/widget/ImageView;", "getImgCover", "()Landroid/widget/ImageView;", "getParent", "()Landroid/view/View;", "txtDesc", "Landroid/widget/TextView;", "getTxtDesc", "()Landroid/widget/TextView;", "txtDuration", "getTxtDuration", "txtTime", "getTxtTime", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "index", "", "plugin-brandservice_release"})
  public final class a
  {
    final View hcj;
    final ImageView ojC;
    final TextView ojD;
    final TextView ojE;
    final TextView ojF;
    final RelativeLayout ojG;
    final v ojH;
    
    public a()
    {
      AppMethodBeat.i(208737);
      this.hcj = localObject;
      this$1 = this.hcj.findViewById(2131307158);
      d.g.b.p.g(o.this, "parent.findViewById(R.id…_card_finder_video_cover)");
      this.ojC = ((ImageView)o.this);
      this$1 = this.hcj.findViewById(2131307161);
      d.g.b.p.g(o.this, "parent.findViewById(R.id…rd_finder_video_playtime)");
      this.ojD = ((TextView)o.this);
      this$1 = this.hcj.findViewById(2131307160);
      d.g.b.p.g(o.this, "parent.findViewById(R.id…rd_finder_video_duration)");
      this.ojE = ((TextView)o.this);
      this$1 = this.hcj.findViewById(2131307159);
      d.g.b.p.g(o.this, "parent.findViewById(R.id…c_card_finder_video_desc)");
      this.ojF = ((TextView)o.this);
      this$1 = this.hcj.findViewById(2131307155);
      d.g.b.p.g(o.this, "parent.findViewById(R.id.biz_rec_card_finder_rl)");
      this.ojG = ((RelativeLayout)o.this);
      this.ojH = new v();
      AppMethodBeat.o(208737);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(o.a parama, w paramw, dmm paramdmm, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(208736);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        this.ojJ.ojI.a(this.oiy, this.ojc, paramView, this.ojd);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208736);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      public final void onFinish() {}
      
      public final void onStart() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.o
 * JD-Core Version:    0.7.0.1
 */