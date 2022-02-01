package com.tencent.mm.plugin.brandservice.ui.timeline.a;

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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.t;
import d.a.j;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "viewVideos", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "BizTLRecCardVideo", "plugin-brandservice_release"})
public final class f
  extends g
{
  private View nBh;
  private a[] nBw;
  
  public f(com.tencent.mm.plugin.brandservice.ui.timeline.c paramc, Context paramContext)
  {
    super(paramContext, paramc);
    AppMethodBeat.i(198853);
    AppMethodBeat.o(198853);
  }
  
  public final void a(t paramt, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(198850);
    k.h(paramt, "info");
    k.h(paramView1, "convertView");
    k.h(paramView2, "parent");
    super.a(paramt, paramInt, paramView1, paramView2);
    paramView2 = paramt.eZp();
    if (paramView2 != null) {}
    for (paramView1 = paramView2.FPo; paramView1 == null; paramView1 = null)
    {
      AppMethodBeat.o(198850);
      return;
    }
    paramView1 = this.nBh;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = paramView2.FPq;
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
          j.fOc();
        }
        Object localObject = (dgc)paramView1;
        if ((localObject != null) && ((((dgc)localObject).DPI & 0x1) == 0))
        {
          paramView1 = this.nBw;
          if (paramView1 != null)
          {
            a locala = paramView1[paramInt];
            if (locala != null)
            {
              k.h(paramt, "info");
              k.h(paramView2, "recCard");
              k.h(localObject, "appMsg");
              String str2 = ((dgc)localObject).Title;
              String str3 = ((dgc)localObject).Ean;
              int j = ((dgc)localObject).hkQ;
              String str1 = ((dgc)localObject).Eap;
              long l = ((dgc)localObject).FPu;
              String str4 = m.nJ(((dgc)localObject).EaB);
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
                localTextView = locala.nBy;
                if (!k.g(paramView1, "")) {
                  break label708;
                }
              }
              label708:
              for (paramView1 = (CharSequence)"";; paramView1 = (CharSequence)locala.nBD.context.getString(2131760255, new Object[] { paramView1 }))
              {
                localTextView.setText(paramView1);
                locala.nBy.setShadowLayer(2.0F, 0.0F, 0.0F, locala.nBD.context.getResources().getColor(2131099663));
                locala.nBz.setText((CharSequence)str4);
                locala.nBz.setShadowLayer(2.0F, 0.0F, 0.0F, locala.nBD.context.getResources().getColor(2131099663));
                locala.nBA.setText((CharSequence)str2);
                locala.gFM.setOnClickListener((View.OnClickListener)new f.a.a(locala, paramt, (dgc)localObject, paramInt));
                if ((((b)com.tencent.mm.kernel.g.ab(b.class)).ys(1)) && (!bs.isNullOrNil(str3))) {
                  ((b)com.tencent.mm.kernel.g.ab(b.class)).a(str3, j, 90, new Object[0]);
                }
                float f = (com.tencent.mm.plugin.brandservice.ui.timeline.c.nyY * 2.35F - a.g(locala.nBD.context, 40.0F)) / 2.0F;
                j = (int)(f / 1.77D);
                paramView1 = locala.gFM.getLayoutParams();
                localObject = locala.nBB.getLayoutParams();
                paramView1.width = ((int)f);
                ((ViewGroup.LayoutParams)localObject).height = j;
                locala.gFM.setLayoutParams(paramView1);
                locala.nBB.setLayoutParams((ViewGroup.LayoutParams)localObject);
                locala.nBx.setVisibility(0);
                locala.nBC.hld = str1;
                locala.nBC.url = str1;
                locala.nBC.type = 5;
                locala.nBD.nAv.nzn.a(paramt.field_msgId, paramInt, locala.nBC, locala.nBC.hld, locala.nBx, (int)f, j, false, (m.a)new f.a.b(), paramt.nCF + paramInt, a.g(locala.nBD.context, 4.0F));
                paramInt = i;
                break;
                if (l < 100000L)
                {
                  paramView1 = z.KUT;
                  paramView1 = String.format("%.1f万", Arrays.copyOf(new Object[] { Float.valueOf((float)l / 10000.0F) }, 1));
                  k.g(paramView1, "java.lang.String.format(format, *args)");
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
          h.wUl.idkeyStat(1149L, 6L, 1L, false);
          paramInt = i;
        }
      }
    }
    com.tencent.mm.plugin.brandservice.ui.b.c.h(paramt);
    AppMethodBeat.o(198850);
  }
  
  public final void dA(View paramView)
  {
    AppMethodBeat.i(198851);
    k.h(paramView, "parent");
    if (this.nBh == null)
    {
      paramView = ((ViewStub)paramView.findViewById(2131307257)).inflate();
      k.g(paramView, "this");
      dB(paramView);
      Object localObject = paramView.findViewById(2131307156);
      k.g(localObject, "this.findViewById(R.id.biz_rec_card_finder_video1)");
      localObject = new a((View)localObject);
      View localView = paramView.findViewById(2131307157);
      k.g(localView, "this.findViewById(R.id.biz_rec_card_finder_video2)");
      this.nBw = new a[] { localObject, new a(localView) };
      this.nBh = paramView;
    }
    AppMethodBeat.o(198851);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(198852);
    View localView = this.nBh;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(198852);
      return;
    }
    AppMethodBeat.o(198852);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;Landroid/view/View;)V", "bizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "coverRl", "Landroid/widget/RelativeLayout;", "getCoverRl", "()Landroid/widget/RelativeLayout;", "imgCover", "Landroid/widget/ImageView;", "getImgCover", "()Landroid/widget/ImageView;", "getParent", "()Landroid/view/View;", "txtDesc", "Landroid/widget/TextView;", "getTxtDesc", "()Landroid/widget/TextView;", "txtDuration", "getTxtDuration", "txtTime", "getTxtTime", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "index", "", "plugin-brandservice_release"})
  public final class a
  {
    final View gFM;
    final TextView nBA;
    final RelativeLayout nBB;
    final v nBC;
    final ImageView nBx;
    final TextView nBy;
    final TextView nBz;
    
    public a()
    {
      AppMethodBeat.i(198849);
      this.gFM = localObject;
      this$1 = this.gFM.findViewById(2131307158);
      k.g(f.this, "parent.findViewById(R.id…_card_finder_video_cover)");
      this.nBx = ((ImageView)f.this);
      this$1 = this.gFM.findViewById(2131307161);
      k.g(f.this, "parent.findViewById(R.id…rd_finder_video_playtime)");
      this.nBy = ((TextView)f.this);
      this$1 = this.gFM.findViewById(2131307160);
      k.g(f.this, "parent.findViewById(R.id…rd_finder_video_duration)");
      this.nBz = ((TextView)f.this);
      this$1 = this.gFM.findViewById(2131307159);
      k.g(f.this, "parent.findViewById(R.id…c_card_finder_video_desc)");
      this.nBA = ((TextView)f.this);
      this$1 = this.gFM.findViewById(2131307155);
      k.g(f.this, "parent.findViewById(R.id.biz_rec_card_finder_rl)");
      this.nBB = ((RelativeLayout)f.this);
      this.nBC = new v();
      AppMethodBeat.o(198849);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(f.a parama, t paramt, dgc paramdgc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(198848);
        this.nBE.nBD.a(this.nBp, this.nBq, paramView, this.nBr);
        AppMethodBeat.o(198848);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      public final void onFinish() {}
      
      public final void onStart() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.f
 * JD-Core Version:    0.7.0.1
 */