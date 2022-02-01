package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "BizRecCardCommonSlot", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends BizTLRecCardItem
{
  private View vJU;
  private LinearLayout vJV;
  private LinkedList<a> vJW;
  private final i<a> vJX;
  
  public s(final com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, final Context paramContext)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(302651);
    this.vJW = new LinkedList();
    this.vJX = new i((kotlin.g.a.a)new b(this, paramb, paramContext));
    AppMethodBeat.o(302651);
  }
  
  public final void a(ab paramab, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(302664);
    kotlin.g.b.s.u(paramab, "info");
    kotlin.g.b.s.u(paramView1, "convertView");
    kotlin.g.b.s.u(paramView2, "parent");
    super.a(paramab, paramInt, paramView1, paramView2);
    paramView2 = paramab.iYo();
    if (paramView2 == null) {}
    for (paramView1 = null; paramView1 == null; paramView1 = paramView2.abLF)
    {
      AppMethodBeat.o(302664);
      return;
    }
    paramView1 = this.vJU;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = ((Iterable)this.vJW).iterator();
    Object localObject1;
    Object localObject2;
    while (paramView1.hasNext())
    {
      localObject1 = (a)paramView1.next();
      localObject2 = this.vJV;
      if (localObject2 != null) {
        ((LinearLayout)localObject2).removeView(((a)localObject1).vJY);
      }
      this.vJX.et(localObject1);
    }
    this.vJW.clear();
    paramView1 = paramView2.YVI;
    if (paramView1 != null)
    {
      paramView1 = ((Iterable)paramView1).iterator();
      paramInt = 0;
      while (paramView1.hasNext())
      {
        localObject1 = paramView1.next();
        int i = paramInt + 1;
        if (paramInt < 0) {
          p.kkW();
        }
        localObject1 = (flf)localObject1;
        if ((localObject1 != null) && ((((flf)localObject1).YFu & 0x1) == 0))
        {
          localObject2 = (a)this.vJX.get();
          LinearLayout localLinearLayout = this.vJV;
          if (localLinearLayout != null) {
            localLinearLayout.addView(((a)localObject2).vJY);
          }
          this.vJW.add(localObject2);
          kotlin.g.b.s.s(paramView2, "recCard");
          ((a)localObject2).a(paramab, paramView2, (flf)localObject1, paramInt);
          paramInt = i;
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1149L, 6L, 1L, false);
          paramInt = i;
        }
      }
    }
    com.tencent.mm.plugin.brandservice.ui.b.d.w(paramab);
    AppMethodBeat.o(302664);
  }
  
  public final void eF(View paramView)
  {
    AppMethodBeat.i(302673);
    kotlin.g.b.s.u(paramView, "parent");
    if (this.vJU == null)
    {
      paramView = ((ViewStub)paramView.findViewById(d.e.viewstub_bizcontent)).inflate();
      kotlin.g.b.s.s(paramView, "this");
      eG(paramView);
      this.vJV = ((LinearLayout)paramView.findViewById(d.e.biz_rec_card_common_slot));
      ah localah = ah.aiuX;
      this.vJU = paramView;
    }
    AppMethodBeat.o(302673);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(302677);
    View localView = this.vJU;
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(302677);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "index", "", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends ag
  {
    private final Context context;
    final v vIN;
    final View vJY;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(302764);
      this.context = localObject;
      this.vJY = View.inflate(this.context, d.f.biz_time_line_rec_card_common_slot, null);
      this.vIN = new v();
      this.plj = this.vJY.findViewById(d.e.top_line);
      this.uoA = ((ViewGroup)this.vJY.findViewById(d.e.content_ll));
      this$1 = this.vJY.findViewById(d.e.title_neat_tv);
      if (s.this == null)
      {
        this$1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(302764);
        throw s.this;
      }
      this.vMn = ((MMNeat7extView)s.this);
      this.vMo = ((TextView)this.vJY.findViewById(d.e.summary));
      this.vMp = this.vJY.findViewById(d.e.cover_area);
      this.vIK = ((ImageView)this.vJY.findViewById(d.e.cover_iv));
      this.vMq = this.vJY.findViewById(d.e.biz_slot_voice_layout);
      this.vMr = ((ImageView)this.vJY.findViewById(d.e.biz_time_line_voice_play_icon));
      this.vMs = ((ImageView)this.vJY.findViewById(d.e.play_icon));
      this.vJc = this.vJY.findViewById(d.e.stat_layout);
      this$1 = this.vJY.findViewById(d.e.friends_read_tv);
      if (s.this == null)
      {
        this$1 = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(302764);
        throw s.this;
      }
      this.vJd = ((TextView)s.this);
      this.vMt = this.vJY.findViewById(d.e.pic_cover_mask_layout);
      this.vMu = this.vJY.findViewById(d.e.pic_cover_mask);
      this.vJJ = ((TextView)this.vJY.findViewById(d.e.pic_num));
      AppMethodBeat.o(302764);
    }
    
    private static final void a(a parama, View paramView)
    {
      AppMethodBeat.i(302782);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(parama, "this$0");
      ((com.tencent.mm.plugin.brandservice.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).eA((View)parama.vMr);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(302782);
    }
    
    private static final void a(s params, ab paramab, flf paramflf, int paramInt, View paramView)
    {
      AppMethodBeat.i(302773);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(params);
      localb.cH(paramab);
      localb.cH(paramflf);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(params, "this$0");
      kotlin.g.b.s.u(paramab, "$info");
      kotlin.g.b.s.u(paramflf, "$appMsg");
      params.a(paramab, paramflf, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(302773);
    }
    
    public final void a(final ab paramab, fle paramfle, flf paramflf, final int paramInt)
    {
      AppMethodBeat.i(302808);
      kotlin.g.b.s.u(paramab, "info");
      kotlin.g.b.s.u(paramfle, "recCard");
      kotlin.g.b.s.u(paramflf, "appMsg");
      Object localObject2 = paramflf.hAP;
      paramfle = paramflf.YQK;
      int j = paramflf.nUA;
      Object localObject1 = paramflf.YQM;
      String str = paramflf.YQN;
      this.vMn.aZ((CharSequence)localObject2);
      localObject2 = this.vJY;
      if (paramInt == 0) {}
      for (int i = d.d.biz_time_line_item_middle_bg;; i = d.d.biz_time_line_item_bottom_bg)
      {
        ((View)localObject2).setBackgroundResource(i);
        this.vJY.setOnClickListener(new s.a..ExternalSyntheticLambda1(s.this, paramab, paramflf, paramInt));
        if ((((c)com.tencent.mm.kernel.h.ax(c.class)).GV(1)) && (!Util.isNullOrNil(paramfle))) {
          ((c)com.tencent.mm.kernel.h.ax(c.class)).a(paramfle, j, 90, new Object[0]);
        }
        this.vIN.type = j;
        this.vIN.nUM = ((String)localObject1);
        this.vIN.nVd = str;
        this.vIN.url = paramfle;
        a(this.vJc, this.vJd, paramab, this.vIN);
        this.vMs.setVisibility(8);
        this.vMq.setVisibility(8);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ajs(paramab.getId());
        if (this.vIN.type != 7) {
          break label586;
        }
        this.vIK.setVisibility(8);
        kotlin.g.b.s.u(paramab, "info");
        kotlin.g.b.s.u(paramflf, "appMsg");
        this.vMs.setVisibility(8);
        this.vMq.setVisibility(0);
        paramfle = this.vMr.getDrawable();
        if (((paramfle instanceof AnimationDrawable)) && (((AnimationDrawable)paramfle).isRunning())) {
          ((AnimationDrawable)paramfle).stop();
        }
        if (!kotlin.g.b.s.p(paramab.field_msgId + '_' + paramInt, com.tencent.mm.plugin.brandservice.ui.b.d.dhS())) {
          break label495;
        }
        this.vMr.setImageResource(d.d.biz_time_line_item_voice_playing_selector);
        if (!(this.vMr.getDrawable() instanceof AnimationDrawable)) {
          break label428;
        }
        paramfle = this.vMr.getDrawable();
        if (paramfle != null) {
          break;
        }
        paramab = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(302808);
        throw paramab;
      }
      ((AnimationDrawable)paramfle).start();
      label428:
      paramfle = paramflf.YVC;
      if (Util.isNullOrNil(paramfle))
      {
        Log.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
        label449:
        paramab = (m)s.a.b.vKc;
        paramfle = (kotlin.g.a.s)s.a.c.vKd;
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(302808);
        return;
        label495:
        this.vMr.setImageResource(d.d.biz_time_line_item_voice_play_selector);
        break;
        ((com.tencent.mm.plugin.brandservice.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).a((View)this.vMr, paramab.field_msgId + '_' + paramInt, paramflf.hAP, paramfle, "", paramflf.YQM);
        this.vMr.setOnClickListener(new s.a..ExternalSyntheticLambda0(this));
        break label449;
        label586:
        if (!Util.isNullOrNil(this.vIN.nUM))
        {
          this.vIK.setVisibility(0);
          if (Util.isNullOrNil(this.vIN.nVd)) {}
          for (paramfle = this.vIN.nUM;; paramfle = this.vIN.nVd)
          {
            long l = paramab.field_orderFlag;
            paramflf = this.vIN;
            localObject1 = this.vIK;
            i = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGe;
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a(l, paramInt, paramflf, paramfle, (ImageView)localObject1, i, i, false, (m.a)new a(this, paramab, paramInt), paramab.vMB + 1, 2.0F);
            break;
          }
        }
        if ((this.vIN.type == 5) || (this.vIN.type == 6))
        {
          this.vIK.setVisibility(0);
          paramfle = d.d.chatting_item_biz_play_icon_bg;
          paramflf = this.vIK;
          i = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGe;
          com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a(paramfle, paramflf, i, i, paramab.vMB + 1);
          break label449;
        }
        this.vMp.setVisibility(8);
        break label449;
        paramflf = this.uoA;
        kotlin.g.b.s.s(paramflf, "content");
        paramfle.a(paramflf, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGf), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi));
        paramfle = this.plj;
        kotlin.g.b.s.s(paramfle, "topLine");
        paramab.invoke(paramfle, Integer.valueOf(com.tencent.mm.cd.a.fromDPToPix(this.context, 16.0F)));
        AppMethodBeat.o(302808);
        return;
        paramflf = this.uoA;
        kotlin.g.b.s.s(paramflf, "content");
        paramfle.a(paramflf, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGf));
        paramfle = this.plj;
        kotlin.g.b.s.s(paramfle, "topLine");
        paramab.invoke(paramfle, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGj));
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements m.a
    {
      a(s.a parama, ab paramab, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(302444);
        this.vKa.a(this.vKa.vIN, true);
        this.vKa.vMC.vFN.y(paramab.field_msgId, paramInt);
        AppMethodBeat.o(302444);
      }
      
      public final void onStart() {}
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<s.a>
  {
    b(s params, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.s
 * JD-Core Version:    0.7.0.1
 */