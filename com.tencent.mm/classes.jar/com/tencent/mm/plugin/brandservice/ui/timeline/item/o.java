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
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.v;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.w;
import d.a.j;
import d.g.b.ad;
import d.l;
import java.util.Arrays;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "viewVideos", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "BizTLRecCardVideo", "plugin-brandservice_release"})
public final class o
  extends p
{
  private a[] odL;
  private View odh;
  
  public o(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(209767);
    AppMethodBeat.o(209767);
  }
  
  public final void a(w paramw, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(209764);
    d.g.b.p.h(paramw, "info");
    d.g.b.p.h(paramView1, "convertView");
    d.g.b.p.h(paramView2, "parent");
    super.a(paramw, paramInt, paramView1, paramView2);
    paramView2 = paramw.fpl();
    if (paramView2 != null) {}
    for (paramView1 = paramView2.HzY; paramView1 == null; paramView1 = null)
    {
      AppMethodBeat.o(209764);
      return;
    }
    paramView1 = this.odh;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = paramView2.FJV;
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
          j.gfB();
        }
        Object localObject = (dlp)paramView1;
        if ((localObject != null) && ((((dlp)localObject).FuX & 0x1) == 0))
        {
          paramView1 = this.odL;
          if (paramView1 != null)
          {
            a locala = paramView1[paramInt];
            if (locala != null)
            {
              d.g.b.p.h(paramw, "info");
              d.g.b.p.h(paramView2, "recCard");
              d.g.b.p.h(localObject, "appMsg");
              String str2 = ((dlp)localObject).Title;
              String str3 = ((dlp)localObject).FFW;
              int j = ((dlp)localObject).hCZ;
              String str1 = ((dlp)localObject).FFY;
              long l = ((dlp)localObject).FJM;
              String str4 = m.oi(((dlp)localObject).FGk);
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
                localTextView = locala.odN;
                if (!d.g.b.p.i(paramView1, "")) {
                  break label708;
                }
              }
              label708:
              for (paramView1 = (CharSequence)"";; paramView1 = (CharSequence)locala.odS.context.getString(2131760255, new Object[] { paramView1 }))
              {
                localTextView.setText(paramView1);
                locala.odN.setShadowLayer(2.0F, 0.0F, 0.0F, locala.odS.context.getResources().getColor(2131099663));
                locala.odO.setText((CharSequence)str4);
                locala.odO.setShadowLayer(2.0F, 0.0F, 0.0F, locala.odS.context.getResources().getColor(2131099663));
                locala.odP.setText((CharSequence)str2);
                locala.gZw.setOnClickListener((View.OnClickListener)new o.a.a(locala, paramw, (dlp)localObject, paramInt));
                if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(1)) && (!bt.isNullOrNil(str3))) {
                  ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(str3, j, 90, new Object[0]);
                }
                float f = (com.tencent.mm.plugin.brandservice.ui.timeline.b.oad * 2.35F - com.tencent.mm.cc.a.g(locala.odS.context, 40.0F)) / 2.0F;
                j = (int)(f / 1.77D);
                paramView1 = locala.gZw.getLayoutParams();
                localObject = locala.odQ.getLayoutParams();
                paramView1.width = ((int)f);
                ((ViewGroup.LayoutParams)localObject).height = j;
                locala.gZw.setLayoutParams(paramView1);
                locala.odQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
                locala.odM.setVisibility(0);
                locala.odR.hDm = str1;
                locala.odR.url = str1;
                locala.odR.type = 5;
                locala.odS.obC.oas.a(paramw.field_msgId, paramInt, locala.odR, locala.odR.hDm, locala.odM, (int)f, j, false, (m.a)new o.a.b(), paramw.ofe + paramInt, com.tencent.mm.cc.a.g(locala.odS.context, 4.0F));
                paramInt = i;
                break;
                if (l < 100000L)
                {
                  paramView1 = ad.MLZ;
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
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1149L, 6L, 1L, false);
          paramInt = i;
        }
      }
    }
    com.tencent.mm.plugin.brandservice.ui.b.c.l(paramw);
    AppMethodBeat.o(209764);
  }
  
  public final void dD(View paramView)
  {
    AppMethodBeat.i(209765);
    d.g.b.p.h(paramView, "parent");
    if (this.odh == null)
    {
      paramView = ((ViewStub)paramView.findViewById(2131307257)).inflate();
      d.g.b.p.g(paramView, "this");
      dE(paramView);
      Object localObject = paramView.findViewById(2131307156);
      d.g.b.p.g(localObject, "this.findViewById(R.id.biz_rec_card_finder_video1)");
      localObject = new a((View)localObject);
      View localView = paramView.findViewById(2131307157);
      d.g.b.p.g(localView, "this.findViewById(R.id.biz_rec_card_finder_video2)");
      this.odL = new a[] { localObject, new a(localView) };
      this.odh = paramView;
    }
    AppMethodBeat.o(209765);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(209766);
    View localView = this.odh;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(209766);
      return;
    }
    AppMethodBeat.o(209766);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;Landroid/view/View;)V", "bizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "coverRl", "Landroid/widget/RelativeLayout;", "getCoverRl", "()Landroid/widget/RelativeLayout;", "imgCover", "Landroid/widget/ImageView;", "getImgCover", "()Landroid/widget/ImageView;", "getParent", "()Landroid/view/View;", "txtDesc", "Landroid/widget/TextView;", "getTxtDesc", "()Landroid/widget/TextView;", "txtDuration", "getTxtDuration", "txtTime", "getTxtTime", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "index", "", "plugin-brandservice_release"})
  public final class a
  {
    final View gZw;
    final ImageView odM;
    final TextView odN;
    final TextView odO;
    final TextView odP;
    final RelativeLayout odQ;
    final v odR;
    
    public a()
    {
      AppMethodBeat.i(209763);
      this.gZw = localObject;
      this$1 = this.gZw.findViewById(2131307158);
      d.g.b.p.g(o.this, "parent.findViewById(R.id…_card_finder_video_cover)");
      this.odM = ((ImageView)o.this);
      this$1 = this.gZw.findViewById(2131307161);
      d.g.b.p.g(o.this, "parent.findViewById(R.id…rd_finder_video_playtime)");
      this.odN = ((TextView)o.this);
      this$1 = this.gZw.findViewById(2131307160);
      d.g.b.p.g(o.this, "parent.findViewById(R.id…rd_finder_video_duration)");
      this.odO = ((TextView)o.this);
      this$1 = this.gZw.findViewById(2131307159);
      d.g.b.p.g(o.this, "parent.findViewById(R.id…c_card_finder_video_desc)");
      this.odP = ((TextView)o.this);
      this$1 = this.gZw.findViewById(2131307155);
      d.g.b.p.g(o.this, "parent.findViewById(R.id.biz_rec_card_finder_rl)");
      this.odQ = ((RelativeLayout)o.this);
      this.odR = new v();
      AppMethodBeat.o(209763);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(o.a parama, w paramw, dlp paramdlp, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(209762);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.odT.odS.a(this.ocJ, this.odo, paramView, this.odp);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(209762);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
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