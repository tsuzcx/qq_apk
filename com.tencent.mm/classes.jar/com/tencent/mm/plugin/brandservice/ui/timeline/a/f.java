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
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.v;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.s;
import d.a.j;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "viewVideos", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "BizTLRecCardVideo", "plugin-brandservice_release"})
public final class f
  extends g
{
  private View mYI;
  private a[] mYX;
  
  public f(com.tencent.mm.plugin.brandservice.ui.timeline.c paramc, Context paramContext)
  {
    super(paramContext, paramc);
    AppMethodBeat.i(193059);
    AppMethodBeat.o(193059);
  }
  
  public final void a(s params, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(193056);
    k.h(params, "info");
    k.h(paramView1, "convertView");
    k.h(paramView2, "parent");
    super.a(params, paramInt, paramView1, paramView2);
    paramView2 = params.eJR();
    if (paramView2 != null) {}
    for (paramView1 = paramView2.Esm; paramView1 == null; paramView1 = null)
    {
      AppMethodBeat.o(193056);
      return;
    }
    paramView1 = this.mYI;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = paramView2.Eso;
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
          j.fvx();
        }
        Object localObject = (daq)paramView1;
        if ((localObject != null) && ((((daq)localObject).Cxm & 0x1) == 0))
        {
          paramView1 = this.mYX;
          if (paramView1 != null)
          {
            a locala = paramView1[paramInt];
            if (locala != null)
            {
              k.h(params, "info");
              k.h(paramView2, "recCard");
              k.h(localObject, "appMsg");
              String str2 = ((daq)localObject).Title;
              String str3 = ((daq)localObject).CHL;
              int j = ((daq)localObject).gKq;
              String str1 = ((daq)localObject).CHN;
              long l = ((daq)localObject).Ess;
              String str4 = m.mV(((daq)localObject).CHZ);
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
                localTextView = locala.mYZ;
                if (!k.g(paramView1, "")) {
                  break label708;
                }
              }
              label708:
              for (paramView1 = (CharSequence)"";; paramView1 = (CharSequence)locala.mZf.context.getString(2131760255, new Object[] { paramView1 }))
              {
                localTextView.setText(paramView1);
                locala.mYZ.setShadowLayer(2.0F, 0.0F, 0.0F, locala.mZf.context.getResources().getColor(2131099663));
                locala.mZa.setText((CharSequence)str4);
                locala.mZa.setShadowLayer(2.0F, 0.0F, 0.0F, locala.mZf.context.getResources().getColor(2131099663));
                locala.mZb.setText((CharSequence)str2);
                locala.mZe.setOnClickListener((View.OnClickListener)new f.a.a(locala, params, (daq)localObject, paramInt));
                if ((((b)com.tencent.mm.kernel.g.ab(b.class)).xA(1)) && (!bt.isNullOrNil(str3))) {
                  ((b)com.tencent.mm.kernel.g.ab(b.class)).a(str3, j, 90, new Object[0]);
                }
                float f = (com.tencent.mm.plugin.brandservice.ui.timeline.c.mWz * 2.35F - a.g(locala.mZf.context, 40.0F)) / 2.0F;
                j = (int)(f / 1.77D);
                paramView1 = locala.mZe.getLayoutParams();
                localObject = locala.mZc.getLayoutParams();
                paramView1.width = ((int)f);
                ((ViewGroup.LayoutParams)localObject).height = j;
                locala.mZe.setLayoutParams(paramView1);
                locala.mZc.setLayoutParams((ViewGroup.LayoutParams)localObject);
                locala.mYY.setVisibility(0);
                locala.mZd.gKD = str1;
                locala.mZd.url = str1;
                locala.mZd.type = 5;
                locala.mZf.mXW.mWO.a(params.field_msgId, paramInt, locala.mZd, m.a(locala.mZd), locala.mYY, (int)f, j, false, (m.a)new f.a.b(), params.nah + paramInt, a.g(locala.mZf.context, 4.0F));
                paramInt = i;
                break;
                if (l < 100000L)
                {
                  paramView1 = z.Jhz;
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
          h.vKh.idkeyStat(1149L, 6L, 1L, false);
          paramInt = i;
        }
      }
    }
    com.tencent.mm.plugin.brandservice.ui.b.c.h(params);
    AppMethodBeat.o(193056);
  }
  
  public final void dy(View paramView)
  {
    AppMethodBeat.i(193057);
    k.h(paramView, "parent");
    if (this.mYI == null)
    {
      paramView = ((ViewStub)paramView.findViewById(2131307257)).inflate();
      k.g(paramView, "this");
      dz(paramView);
      Object localObject = paramView.findViewById(2131307156);
      k.g(localObject, "this.findViewById(R.id.biz_rec_card_finder_video1)");
      localObject = new a((View)localObject);
      View localView = paramView.findViewById(2131307157);
      k.g(localView, "this.findViewById(R.id.biz_rec_card_finder_video2)");
      this.mYX = new a[] { localObject, new a(localView) };
      this.mYI = paramView;
    }
    AppMethodBeat.o(193057);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(193058);
    View localView = this.mYI;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(193058);
      return;
    }
    AppMethodBeat.o(193058);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;Landroid/view/View;)V", "bizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "coverRl", "Landroid/widget/RelativeLayout;", "getCoverRl", "()Landroid/widget/RelativeLayout;", "imgCover", "Landroid/widget/ImageView;", "getImgCover", "()Landroid/widget/ImageView;", "getParent", "()Landroid/view/View;", "txtDesc", "Landroid/widget/TextView;", "getTxtDesc", "()Landroid/widget/TextView;", "txtDuration", "getTxtDuration", "txtTime", "getTxtTime", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "index", "", "plugin-brandservice_release"})
  public final class a
  {
    final ImageView mYY;
    final TextView mYZ;
    final TextView mZa;
    final TextView mZb;
    final RelativeLayout mZc;
    final v mZd;
    final View mZe;
    
    public a()
    {
      AppMethodBeat.i(193055);
      this.mZe = localObject;
      this$1 = this.mZe.findViewById(2131307158);
      k.g(f.this, "parent.findViewById(R.id…_card_finder_video_cover)");
      this.mYY = ((ImageView)f.this);
      this$1 = this.mZe.findViewById(2131307161);
      k.g(f.this, "parent.findViewById(R.id…rd_finder_video_playtime)");
      this.mYZ = ((TextView)f.this);
      this$1 = this.mZe.findViewById(2131307160);
      k.g(f.this, "parent.findViewById(R.id…rd_finder_video_duration)");
      this.mZa = ((TextView)f.this);
      this$1 = this.mZe.findViewById(2131307159);
      k.g(f.this, "parent.findViewById(R.id…c_card_finder_video_desc)");
      this.mZb = ((TextView)f.this);
      this$1 = this.mZe.findViewById(2131307155);
      k.g(f.this, "parent.findViewById(R.id.biz_rec_card_finder_rl)");
      this.mZc = ((RelativeLayout)f.this);
      this.mZd = new v();
      AppMethodBeat.o(193055);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(f.a parama, s params, daq paramdaq, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(193054);
        this.mZg.mZf.a(this.mYQ, this.mYR, paramView, this.mYS);
        AppMethodBeat.o(193054);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      public final void onFinish() {}
      
      public final void onStart() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.f
 * JD-Core Version:    0.7.0.1
 */