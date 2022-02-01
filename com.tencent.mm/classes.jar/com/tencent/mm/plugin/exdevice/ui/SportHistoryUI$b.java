package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.fhc;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.threadpool.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItem;", "Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;", "(Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SportHistoryUI$b
  extends f<SportHistoryUI.a>
{
  public SportHistoryUI$b()
  {
    AppMethodBeat.i(274743);
    AppMethodBeat.o(274743);
  }
  
  private static final void a(TextView paramTextView, ImageView paramImageView, WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(274747);
    if (paramWxaAttributes != null) {
      com.tencent.threadpool.h.ahAA.bk(new SportHistoryUI.b..ExternalSyntheticLambda4(paramTextView, paramWxaAttributes, paramImageView));
    }
    AppMethodBeat.o(274747);
  }
  
  private static final void a(TextView paramTextView, WxaAttributes paramWxaAttributes, ImageView paramImageView)
  {
    AppMethodBeat.i(274746);
    kotlin.g.b.s.u(paramWxaAttributes, "$info");
    if (paramTextView != null) {
      paramTextView.setText((CharSequence)paramWxaAttributes.field_nickname);
    }
    paramTextView = new c.a();
    paramTextView.nrc = true;
    paramTextView.oKo = true;
    paramTextView = paramTextView.bKx();
    r.bKe().a(paramWxaAttributes.field_smallHeadURL, paramImageView, paramTextView);
    AppMethodBeat.o(274746);
  }
  
  private static final void a(WxaAttributes paramWxaAttributes, fhc paramfhc, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(274768);
    kotlin.g.b.s.u(paramWxaAttributes, "$wxaAttributes");
    kotlin.g.b.s.u(paramfhc, "$sportRecord");
    if (paramBoolean)
    {
      paramString = new zp();
      paramString.icM.userName = paramWxaAttributes.field_username;
      paramString.icM.icO = paramfhc.abHG;
      paramString.icM.scene = 1171;
      paramString.publish();
    }
    AppMethodBeat.o(274768);
  }
  
  private static final void a(SportHistoryUI paramSportHistoryUI, fhc paramfhc, WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(274771);
    kotlin.g.b.s.u(paramSportHistoryUI, "this$0");
    kotlin.g.b.s.u(paramfhc, "$sportRecord");
    if (paramWxaAttributes != null)
    {
      g.a locala = new g.a(MMApplicationContext.getContext());
      locala.bDE(paramSportHistoryUI.getString(R.l.top_story_open_appbrand, new Object[] { paramWxaAttributes.field_nickname })).NF(true);
      locala.aEX(R.l.app_accept);
      locala.c(new SportHistoryUI.b..ExternalSyntheticLambda3(paramWxaAttributes, paramfhc)).show();
    }
    AppMethodBeat.o(274771);
  }
  
  private static final void a(fhc paramfhc, SportHistoryUI paramSportHistoryUI, View paramView)
  {
    AppMethodBeat.i(274773);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramfhc);
    localb.cH(paramSportHistoryUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramfhc, "$sportRecord");
    kotlin.g.b.s.u(paramSportHistoryUI, "this$0");
    ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).b(paramfhc.appId, new SportHistoryUI.b..ExternalSyntheticLambda2(paramSportHistoryUI, paramfhc));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(274773);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(274791);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
    AppMethodBeat.o(274791);
  }
  
  public final int getLayoutId()
  {
    return R.i.gow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.SportHistoryUI.b
 * JD-Core Version:    0.7.0.1
 */