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
import com.tencent.mm.ag.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "viewVideos", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "BizTLRecCardVideo", "plugin-brandservice_release"})
public final class v
  extends w
{
  private View puO;
  private a[] pvx;
  
  public v(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(195393);
    AppMethodBeat.o(195393);
  }
  
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(195390);
    p.h(paramz, "info");
    p.h(paramView1, "convertView");
    p.h(paramView2, "parent");
    super.a(paramz, paramInt, paramView1, paramView2);
    paramView2 = paramz.gAC();
    if (paramView2 != null) {}
    for (paramView1 = paramView2.NfT; paramView1 == null; paramView1 = null)
    {
      AppMethodBeat.o(195390);
      return;
    }
    paramView1 = this.puO;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = paramView2.KWy;
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
          j.hxH();
        }
        Object localObject = (ega)paramView1;
        if ((localObject != null) && ((((ega)localObject).KHa & 0x1) == 0))
        {
          paramView1 = this.pvx;
          if (paramView1 != null)
          {
            a locala = paramView1[paramInt];
            if (locala != null)
            {
              p.h(paramz, "info");
              p.h(paramView2, "recCard");
              p.h(localObject, "appMsg");
              String str2 = ((ega)localObject).Title;
              String str3 = ((ega)localObject).KSj;
              int j = ((ega)localObject).iAb;
              String str1 = ((ega)localObject).KSl;
              long l = ((ega)localObject).KWq;
              String str4 = m.rJ(((ega)localObject).KSx);
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
                localTextView = locala.pvz;
                if (!p.j(paramView1, "")) {
                  break label708;
                }
              }
              label708:
              for (paramView1 = (CharSequence)"";; paramView1 = (CharSequence)locala.pvE.context.getString(2131756798, new Object[] { paramView1 }))
              {
                localTextView.setText(paramView1);
                locala.pvz.setShadowLayer(2.0F, 0.0F, 0.0F, locala.pvE.context.getResources().getColor(2131099667));
                locala.pvA.setText((CharSequence)str4);
                locala.pvA.setShadowLayer(2.0F, 0.0F, 0.0F, locala.pvE.context.getResources().getColor(2131099667));
                locala.pvB.setText((CharSequence)str2);
                locala.hVd.setOnClickListener((View.OnClickListener)new v.a.a(locala, paramz, (ega)localObject, paramInt));
                if ((((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) && (!Util.isNullOrNil(str3))) {
                  ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(str3, j, 90, new Object[0]);
                }
                float f = (com.tencent.mm.plugin.brandservice.ui.timeline.b.prq * 2.35F - com.tencent.mm.cb.a.fromDPToPix(locala.pvE.context, 40.0F)) / 2.0F;
                j = (int)(f / 1.77D);
                paramView1 = locala.hVd.getLayoutParams();
                localObject = locala.pvC.getLayoutParams();
                paramView1.width = ((int)f);
                ((ViewGroup.LayoutParams)localObject).height = j;
                locala.hVd.setLayoutParams(paramView1);
                locala.pvC.setLayoutParams((ViewGroup.LayoutParams)localObject);
                locala.pvy.setVisibility(0);
                locala.pvD.iAo = str1;
                locala.pvD.url = str1;
                locala.pvD.type = 5;
                locala.pvE.psQ.prc.a(paramz.field_msgId, paramInt, locala.pvD, locala.pvD.iAo, locala.pvy, (int)f, j, false, (m.a)new v.a.b(), paramz.pxD + paramInt, com.tencent.mm.cb.a.fromDPToPix(locala.pvE.context, 4.0F));
                paramInt = i;
                break;
                if (l < 100000L)
                {
                  paramView1 = ae.SYK;
                  paramView1 = String.format("%.1f万", Arrays.copyOf(new Object[] { Float.valueOf((float)l / 10000.0F) }, 1));
                  p.g(paramView1, "java.lang.String.format(format, *args)");
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
          h.CyF.idkeyStat(1149L, 6L, 1L, false);
          paramInt = i;
        }
      }
    }
    c.x(paramz);
    AppMethodBeat.o(195390);
  }
  
  public final void du(View paramView)
  {
    AppMethodBeat.i(195391);
    p.h(paramView, "parent");
    if (this.puO == null)
    {
      paramView = ((ViewStub)paramView.findViewById(2131309879)).inflate();
      p.g(paramView, "this");
      dv(paramView);
      Object localObject = paramView.findViewById(2131297489);
      p.g(localObject, "this.findViewById(R.id.biz_rec_card_finder_video1)");
      localObject = new a((View)localObject);
      View localView = paramView.findViewById(2131297490);
      p.g(localView, "this.findViewById(R.id.biz_rec_card_finder_video2)");
      this.pvx = new a[] { localObject, new a(localView) };
      this.puO = paramView;
    }
    AppMethodBeat.o(195391);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(195392);
    View localView = this.puO;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(195392);
      return;
    }
    AppMethodBeat.o(195392);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;Landroid/view/View;)V", "bizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "coverRl", "Landroid/widget/RelativeLayout;", "getCoverRl", "()Landroid/widget/RelativeLayout;", "imgCover", "Landroid/widget/ImageView;", "getImgCover", "()Landroid/widget/ImageView;", "getParent", "()Landroid/view/View;", "txtDesc", "Landroid/widget/TextView;", "getTxtDesc", "()Landroid/widget/TextView;", "txtDuration", "getTxtDuration", "txtTime", "getTxtTime", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "index", "", "plugin-brandservice_release"})
  public final class a
  {
    final View hVd;
    final TextView pvA;
    final TextView pvB;
    final RelativeLayout pvC;
    final com.tencent.mm.ag.v pvD;
    final ImageView pvy;
    final TextView pvz;
    
    public a()
    {
      AppMethodBeat.i(195389);
      this.hVd = localObject;
      this$1 = this.hVd.findViewById(2131297491);
      p.g(v.this, "parent.findViewById(R.id…_card_finder_video_cover)");
      this.pvy = ((ImageView)v.this);
      this$1 = this.hVd.findViewById(2131297494);
      p.g(v.this, "parent.findViewById(R.id…rd_finder_video_playtime)");
      this.pvz = ((TextView)v.this);
      this$1 = this.hVd.findViewById(2131297493);
      p.g(v.this, "parent.findViewById(R.id…rd_finder_video_duration)");
      this.pvA = ((TextView)v.this);
      this$1 = this.hVd.findViewById(2131297492);
      p.g(v.this, "parent.findViewById(R.id…c_card_finder_video_desc)");
      this.pvB = ((TextView)v.this);
      this$1 = this.hVd.findViewById(2131297488);
      p.g(v.this, "parent.findViewById(R.id.biz_rec_card_finder_rl)");
      this.pvC = ((RelativeLayout)v.this);
      this.pvD = new com.tencent.mm.ag.v();
      AppMethodBeat.o(195389);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(v.a parama, z paramz, ega paramega, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(195388);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.pvF.pvE.a(this.prL, this.puV, paramView, this.puW);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(195388);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      public final void onFinish() {}
      
      public final void onStart() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.v
 * JD-Core Version:    0.7.0.1
 */