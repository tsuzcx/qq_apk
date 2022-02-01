package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.m;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "viewVideos", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "BizTLRecCardVideo", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends BizTLRecCardItem
{
  private View vJU;
  private a[] vKv;
  
  public v(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(302658);
    AppMethodBeat.o(302658);
  }
  
  public final void a(ab paramab, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(302671);
    s.u(paramab, "info");
    s.u(paramView1, "convertView");
    s.u(paramView2, "parent");
    super.a(paramab, paramInt, paramView1, paramView2);
    paramView2 = paramab.iYo();
    if (paramView2 == null) {}
    for (paramView1 = null; paramView1 == null; paramView1 = paramView2.abLF)
    {
      AppMethodBeat.o(302671);
      return;
    }
    paramView1 = this.vJU;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = paramView2.YVI;
    if (paramView1 != null)
    {
      paramView1 = (Iterable)paramView1;
      paramInt = 0;
      paramView1 = paramView1.iterator();
      while (paramView1.hasNext())
      {
        Object localObject1 = paramView1.next();
        int i = paramInt + 1;
        if (paramInt < 0) {
          p.kkW();
        }
        localObject1 = (flf)localObject1;
        if ((localObject1 != null) && ((((flf)localObject1).YFu & 0x1) == 0))
        {
          Object localObject2 = this.vKv;
          if (localObject2 != null)
          {
            localObject2 = localObject2[paramInt];
            if (localObject2 != null)
            {
              s.s(paramView2, "recCard");
              ((a)localObject2).a(paramab, paramView2, (flf)localObject1, paramInt);
              paramInt = i;
            }
          }
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1149L, 6L, 1L, false);
        }
        paramInt = i;
      }
    }
    com.tencent.mm.plugin.brandservice.ui.b.d.w(paramab);
    AppMethodBeat.o(302671);
  }
  
  public final void eF(View paramView)
  {
    AppMethodBeat.i(302678);
    s.u(paramView, "parent");
    if (this.vJU == null)
    {
      paramView = ((ViewStub)paramView.findViewById(d.e.viewstub_finder)).inflate();
      s.s(paramView, "this");
      eG(paramView);
      Object localObject = paramView.findViewById(d.e.biz_rec_card_finder_video1);
      s.s(localObject, "this.findViewById(R.id.biz_rec_card_finder_video1)");
      localObject = new a((View)localObject);
      View localView = paramView.findViewById(d.e.biz_rec_card_finder_video2);
      s.s(localView, "this.findViewById(R.id.biz_rec_card_finder_video2)");
      this.vKv = new a[] { localObject, new a(localView) };
      localObject = ah.aiuX;
      this.vJU = paramView;
    }
    AppMethodBeat.o(302678);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(302684);
    View localView = this.vJU;
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(302684);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;Landroid/view/View;)V", "bizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "coverRl", "Landroid/widget/RelativeLayout;", "getCoverRl", "()Landroid/widget/RelativeLayout;", "imgCover", "Landroid/widget/ImageView;", "getImgCover", "()Landroid/widget/ImageView;", "getParent", "()Landroid/view/View;", "txtDesc", "Landroid/widget/TextView;", "getTxtDesc", "()Landroid/widget/TextView;", "txtDuration", "getTxtDuration", "txtTime", "getTxtTime", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "index", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
  {
    private final View nma;
    private final RelativeLayout vKA;
    private final com.tencent.mm.message.v vKB;
    private final ImageView vKw;
    private final TextView vKx;
    private final TextView vKy;
    private final TextView vKz;
    
    public a()
    {
      AppMethodBeat.i(302797);
      this.nma = localObject;
      this$1 = this.nma.findViewById(d.e.biz_rec_card_finder_video_cover);
      s.s(v.this, "parent.findViewById(R.id…_card_finder_video_cover)");
      this.vKw = ((ImageView)v.this);
      this$1 = this.nma.findViewById(d.e.biz_rec_card_finder_video_playtime);
      s.s(v.this, "parent.findViewById(R.id…rd_finder_video_playtime)");
      this.vKx = ((TextView)v.this);
      this$1 = this.nma.findViewById(d.e.biz_rec_card_finder_video_duration);
      s.s(v.this, "parent.findViewById(R.id…rd_finder_video_duration)");
      this.vKy = ((TextView)v.this);
      this$1 = this.nma.findViewById(d.e.biz_rec_card_finder_video_desc);
      s.s(v.this, "parent.findViewById(R.id…c_card_finder_video_desc)");
      this.vKz = ((TextView)v.this);
      this$1 = this.nma.findViewById(d.e.biz_rec_card_finder_rl);
      s.s(v.this, "parent.findViewById(R.id.biz_rec_card_finder_rl)");
      this.vKA = ((RelativeLayout)v.this);
      this.vKB = new com.tencent.mm.message.v();
      AppMethodBeat.o(302797);
    }
    
    private static final void a(v paramv, ab paramab, flf paramflf, int paramInt, View paramView)
    {
      AppMethodBeat.i(302807);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramv);
      localb.cH(paramab);
      localb.cH(paramflf);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramv, "this$0");
      s.u(paramab, "$info");
      s.u(paramflf, "$appMsg");
      paramv.a(paramab, paramflf, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(302807);
    }
    
    public final void a(ab paramab, fle paramfle, flf paramflf, int paramInt)
    {
      AppMethodBeat.i(302821);
      s.u(paramab, "info");
      s.u(paramfle, "recCard");
      s.u(paramflf, "appMsg");
      String str2 = paramflf.hAP;
      String str3 = paramflf.YQK;
      int i = paramflf.nUA;
      String str1 = paramflf.YQM;
      long l = paramflf.YVz;
      String str4 = m.uD(paramflf.YQY);
      paramfle = "";
      TextView localTextView;
      if (l > 0L)
      {
        if (l < 10000L) {
          paramfle = String.valueOf(l);
        }
      }
      else
      {
        localTextView = this.vKx;
        if (!s.p(paramfle, "")) {
          break label503;
        }
      }
      label503:
      for (paramfle = (CharSequence)"";; paramfle = (CharSequence)v.this.context.getString(d.i.biz_timeline_rec_card_video_time, new Object[] { paramfle }))
      {
        localTextView.setText(paramfle);
        this.vKx.setShadowLayer(2.0F, 0.0F, 0.0F, v.this.context.getResources().getColor(d.b.BW_0_Alpha_0_8));
        this.vKy.setText((CharSequence)str4);
        this.vKy.setShadowLayer(2.0F, 0.0F, 0.0F, v.this.context.getResources().getColor(d.b.BW_0_Alpha_0_8));
        this.vKz.setText((CharSequence)str2);
        this.nma.setOnClickListener(new v.a..ExternalSyntheticLambda0(v.this, paramab, paramflf, paramInt));
        if ((((c)com.tencent.mm.kernel.h.ax(c.class)).GV(1)) && (!Util.isNullOrNil(str3))) {
          ((c)com.tencent.mm.kernel.h.ax(c.class)).a(str3, i, 90, new Object[0]);
        }
        float f = (com.tencent.mm.plugin.brandservice.ui.timeline.b.vGa * 2.35F - com.tencent.mm.cd.a.fromDPToPix(v.this.context, 40.0F)) / 2.0F;
        i = (int)(f / 1.77D);
        paramfle = this.nma.getLayoutParams();
        paramflf = this.vKA.getLayoutParams();
        paramfle.width = ((int)f);
        paramflf.height = i;
        this.nma.setLayoutParams(paramfle);
        this.vKA.setLayoutParams(paramflf);
        this.vKw.setVisibility(0);
        this.vKB.nUM = str1;
        this.vKB.url = str1;
        this.vKB.type = 5;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a(paramab.field_msgId, paramInt, this.vKB, this.vKB.nUM, this.vKw, (int)f, i, false, (m.a)new a(), paramab.vMB + paramInt, com.tencent.mm.cd.a.fromDPToPix(v.this.context, 4.0F));
        AppMethodBeat.o(302821);
        return;
        if (l < 100000L)
        {
          paramfle = am.aixg;
          paramfle = String.format("%.1f万", Arrays.copyOf(new Object[] { Float.valueOf((float)l / 10000.0F) }, 1));
          s.s(paramfle, "java.lang.String.format(format, *args)");
          break;
        }
        paramfle = "10万+";
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements m.a
    {
      public final void onFinish() {}
      
      public final void onStart() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.v
 * JD-Core Version:    0.7.0.1
 */