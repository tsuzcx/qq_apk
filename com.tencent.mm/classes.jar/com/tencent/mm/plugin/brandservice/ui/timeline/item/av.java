package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.brandservice.d.a;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ah;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTlRecFeedCard;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BaseBizTimeViewHolder;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "topLine", "Landroid/view/View;", "getTopLine", "()Landroid/view/View;", "topLine$delegate", "Lkotlin/Lazy;", "viewBizCanvas", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedCanvas;", "viewBizContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;", "viewBizTag", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;", "viewItemList", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "viewParent", "doInsertAnimation", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "filling", "preInfo", "pos", "", "convertView", "getView", "hideAll", "initGapLine", "isSupportStyle", "", "style", "showGap", "showLine", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
  extends a
{
  public static final av.a vND;
  private final Context context;
  private final b vHY;
  public final View vLv;
  private final ad vNE;
  private final ae vNF;
  private final ac vNG;
  private final ab[] vNH;
  private final j vNI;
  
  static
  {
    AppMethodBeat.i(302843);
    vND = new av.a((byte)0);
    AppMethodBeat.o(302843);
  }
  
  public av(Context paramContext, b paramb)
  {
    AppMethodBeat.i(302829);
    this.context = paramContext;
    this.vHY = paramb;
    this.vNE = new ad(this.vHY, this.context);
    this.vNF = new ae(this.vHY, this.context);
    this.vNG = new ac(this.vHY, this.context);
    this.vNH = new ab[] { (ab)this.vNE, (ab)this.vNF, (ab)this.vNG };
    paramContext = View.inflate(this.context, d.f.biz_time_line_rec_feed_layout, null);
    s.s(paramContext, "inflate(context, R.layou…ne_rec_feed_layout, null)");
    this.vLv = paramContext;
    this.vNI = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(302829);
  }
  
  private final View ddW()
  {
    AppMethodBeat.i(302833);
    View localView = (View)this.vNI.getValue();
    AppMethodBeat.o(302833);
    return localView;
  }
  
  private final void ddX()
  {
    AppMethodBeat.i(302835);
    ab[] arrayOfab = this.vNH;
    int j = arrayOfab.length;
    int i = 0;
    while (i < j)
    {
      arrayOfab[i].ddv();
      i += 1;
    }
    AppMethodBeat.o(302835);
  }
  
  public final void a(com.tencent.mm.storage.ab paramab1, com.tencent.mm.storage.ab paramab2, int paramInt, View paramView)
  {
    int j = 1;
    AppMethodBeat.i(302851);
    s.u(paramab1, "info");
    s.u(paramView, "convertView");
    if (paramab1.acFJ == null)
    {
      Log.i("MicroMsg.BizTlRecFeedCard", "[TRACE_BIZRECFEED] recFeed is null");
      ddX();
      AppMethodBeat.o(302851);
      return;
    }
    if (!ah.ayM(paramab1.acFJ.bcb))
    {
      Log.i("MicroMsg.BizTlRecFeedCard", "[TRACE_BIZRECFEED] style = " + paramab1.acFJ.bcb + " not support");
      ddX();
      AppMethodBeat.o(302851);
      return;
    }
    ene localene = paramab1.acFJ;
    s.s(localene, "info.recFeed");
    if (!ah.c(localene))
    {
      Log.i("MicroMsg.BizTlRecFeedCard", "[TRACE_BIZRECFEED] recFeed is illegal");
      ddX();
      AppMethodBeat.o(302851);
      return;
    }
    paramab1.field_isRead = 1;
    int i;
    if (paramab1.acFJ.abrI == 0) {
      if ((paramab2 != null) && (paramab2.iYd() == true))
      {
        i = 1;
        if (i == 0) {
          break label305;
        }
        paramab2 = paramab2.acFJ;
        if ((paramab2 == null) || (paramab2.abrI != 0)) {
          break label299;
        }
        i = j;
        label193:
        if (i == 0) {
          break label305;
        }
        ddW().setVisibility(0);
        this.vLv.setPadding(0, 0, 0, 0);
        label217:
        paramab2 = o.ojb;
        o.ir(20L);
        paramab2 = this.vNH;
        int k = paramab2.length;
        i = 0;
        label239:
        if (i >= k) {
          break label363;
        }
        localene = paramab2[i];
        if ((paramab1.iYd()) && (paramab1.acFJ != null)) {
          break label330;
        }
        j = -1;
        label269:
        if (j == localene.TY()) {
          break label342;
        }
        localene.ddv();
      }
    }
    for (;;)
    {
      i += 1;
      break label239;
      i = 0;
      break;
      label299:
      i = 0;
      break label193;
      label305:
      ddW().setVisibility(8);
      this.vLv.setPadding(0, b.vGm, 0, 0);
      break label217;
      label330:
      j = paramab1.acFJ.bcb;
      break label269;
      label342:
      localene.show();
      localene.a(paramab1, paramInt, paramView, this.vLv);
    }
    label363:
    if (paramab1.acFC)
    {
      paramab1.acFC = false;
      this.vLv.setBackgroundColor(com.tencent.mm.cd.a.w(this.context, d.b.white));
      this.vLv.findViewById(d.e.rec_feed_anim_view).startAnimation(AnimationUtils.loadAnimation(this.context, d.a.biz_faded_in));
    }
    AppMethodBeat.o(302851);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<View>
  {
    b(av paramav)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.av
 * JD-Core Version:    0.7.0.1
 */