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
import com.tencent.mm.aj.m;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqc;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "viewVideos", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "BizTLRecCardVideo", "plugin-brandservice_release"})
public final class w
  extends x
{
  private a[] sEO;
  private View sEi;
  
  public w(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(259453);
    AppMethodBeat.o(259453);
  }
  
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(259445);
    p.k(paramz, "info");
    p.k(paramView1, "convertView");
    p.k(paramView2, "parent");
    super.a(paramz, paramInt, paramView1, paramView2);
    paramView2 = paramz.hwK();
    if (paramView2 != null) {}
    for (paramView1 = paramView2.Usy; paramView1 == null; paramView1 = null)
    {
      AppMethodBeat.o(259445);
      return;
    }
    paramView1 = this.sEi;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = paramView2.RXM;
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
          j.iBO();
        }
        Object localObject = (eqc)paramView1;
        if ((localObject != null) && ((((eqc)localObject).RIs & 0x1) == 0))
        {
          paramView1 = this.sEO;
          if (paramView1 != null)
          {
            a locala = paramView1[paramInt];
            if (locala != null)
            {
              p.k(paramz, "info");
              p.k(paramView2, "recCard");
              p.k(localObject, "appMsg");
              String str2 = ((eqc)localObject).fwr;
              String str3 = ((eqc)localObject).RTk;
              int j = ((eqc)localObject).lpx;
              String str1 = ((eqc)localObject).RTm;
              long l = ((eqc)localObject).RXE;
              String str4 = m.uD(((eqc)localObject).RTy);
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
                localTextView = locala.sEQ;
                if (!p.h(paramView1, "")) {
                  break label712;
                }
              }
              label712:
              for (paramView1 = (CharSequence)"";; paramView1 = (CharSequence)locala.sEV.context.getString(d.i.svb, new Object[] { paramView1 }))
              {
                localTextView.setText(paramView1);
                locala.sEQ.setShadowLayer(2.0F, 0.0F, 0.0F, locala.sEV.context.getResources().getColor(d.b.BW_0_Alpha_0_8));
                locala.sER.setText((CharSequence)str4);
                locala.sER.setShadowLayer(2.0F, 0.0F, 0.0F, locala.sEV.context.getResources().getColor(d.b.BW_0_Alpha_0_8));
                locala.sES.setText((CharSequence)str2);
                locala.kJC.setOnClickListener((View.OnClickListener)new w.a.a(locala, paramz, (eqc)localObject, paramInt));
                if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) && (!Util.isNullOrNil(str3))) {
                  ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(str3, j, 90, new Object[0]);
                }
                float f = (com.tencent.mm.plugin.brandservice.ui.timeline.b.sAo * 2.35F - com.tencent.mm.ci.a.fromDPToPix(locala.sEV.context, 40.0F)) / 2.0F;
                j = (int)(f / 1.77D);
                paramView1 = locala.kJC.getLayoutParams();
                localObject = locala.sET.getLayoutParams();
                paramView1.width = ((int)f);
                ((ViewGroup.LayoutParams)localObject).height = j;
                locala.kJC.setLayoutParams(paramView1);
                locala.sET.setLayoutParams((ViewGroup.LayoutParams)localObject);
                locala.sEP.setVisibility(0);
                locala.sEU.lpK = str1;
                locala.sEU.url = str1;
                locala.sEU.type = 5;
                locala.sEV.sCg.sAc.a(paramz.field_msgId, paramInt, locala.sEU, locala.sEU.lpK, locala.sEP, (int)f, j, false, (m.a)new w.a.b(), paramz.sHe + paramInt, com.tencent.mm.ci.a.fromDPToPix(locala.sEV.context, 4.0F));
                paramInt = i;
                break;
                if (l < 100000L)
                {
                  paramView1 = af.aaBG;
                  paramView1 = String.format("%.1f万", Arrays.copyOf(new Object[] { Float.valueOf((float)l / 10000.0F) }, 1));
                  p.j(paramView1, "java.lang.String.format(format, *args)");
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
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1149L, 6L, 1L, false);
          paramInt = i;
        }
      }
    }
    com.tencent.mm.plugin.brandservice.ui.b.c.x(paramz);
    AppMethodBeat.o(259445);
  }
  
  public final void dS(View paramView)
  {
    AppMethodBeat.i(259447);
    p.k(paramView, "parent");
    if (this.sEi == null)
    {
      paramView = ((ViewStub)paramView.findViewById(d.e.stu)).inflate();
      p.j(paramView, "this");
      dT(paramView);
      Object localObject = paramView.findViewById(d.e.spY);
      p.j(localObject, "this.findViewById(R.id.biz_rec_card_finder_video1)");
      localObject = new a((View)localObject);
      View localView = paramView.findViewById(d.e.spZ);
      p.j(localView, "this.findViewById(R.id.biz_rec_card_finder_video2)");
      this.sEO = new a[] { localObject, new a(localView) };
      this.sEi = paramView;
    }
    AppMethodBeat.o(259447);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(259450);
    View localView = this.sEi;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(259450);
      return;
    }
    AppMethodBeat.o(259450);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;Landroid/view/View;)V", "bizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "coverRl", "Landroid/widget/RelativeLayout;", "getCoverRl", "()Landroid/widget/RelativeLayout;", "imgCover", "Landroid/widget/ImageView;", "getImgCover", "()Landroid/widget/ImageView;", "getParent", "()Landroid/view/View;", "txtDesc", "Landroid/widget/TextView;", "getTxtDesc", "()Landroid/widget/TextView;", "txtDuration", "getTxtDuration", "txtTime", "getTxtTime", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "index", "", "plugin-brandservice_release"})
  public final class a
  {
    final View kJC;
    final ImageView sEP;
    final TextView sEQ;
    final TextView sER;
    final TextView sES;
    final RelativeLayout sET;
    final v sEU;
    
    public a()
    {
      AppMethodBeat.i(266076);
      this.kJC = localObject;
      this$1 = this.kJC.findViewById(d.e.sqa);
      p.j(w.this, "parent.findViewById(R.id…_card_finder_video_cover)");
      this.sEP = ((ImageView)w.this);
      this$1 = this.kJC.findViewById(d.e.sqd);
      p.j(w.this, "parent.findViewById(R.id…rd_finder_video_playtime)");
      this.sEQ = ((TextView)w.this);
      this$1 = this.kJC.findViewById(d.e.sqc);
      p.j(w.this, "parent.findViewById(R.id…rd_finder_video_duration)");
      this.sER = ((TextView)w.this);
      this$1 = this.kJC.findViewById(d.e.sqb);
      p.j(w.this, "parent.findViewById(R.id…c_card_finder_video_desc)");
      this.sES = ((TextView)w.this);
      this$1 = this.kJC.findViewById(d.e.spX);
      p.j(w.this, "parent.findViewById(R.id.biz_rec_card_finder_rl)");
      this.sET = ((RelativeLayout)w.this);
      this.sEU = new v();
      AppMethodBeat.o(266076);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(w.a parama, z paramz, eqc parameqc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(265372);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.sEW.sEV.a(this.sAV, this.sEp, this.nmX);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(265372);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      public final void onFinish() {}
      
      public final void onStart() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.w
 * JD-Core Version:    0.7.0.1
 */