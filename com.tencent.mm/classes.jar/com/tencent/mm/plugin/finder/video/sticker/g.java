package com.tencent.mm.plugin.finder.video.sticker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.h;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "bottomSpace", "Lkotlin/Function0;", "", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lkotlin/jvm/functions/Function0;)V", "TAG", "", "getBottomSpace", "()Lkotlin/jvm/functions/Function0;", "historyCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "iconView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLayout", "()Landroid/view/View;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "moreCallbackHolder", "selectedLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "stickerData", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerData;", "stickerHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "stickerView", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView;", "tipsView", "Landroid/widget/ImageView;", "recordHistory", "", "release", "setOpen", "isOpen", "", "showMore", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements v
{
  private final com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> AAh;
  final com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private final kotlin.g.a.a<Integer> Gvj;
  final ImageView Gvk;
  final CaptureStickerHint Gvl;
  private final EditorPanelHolder Gvm;
  public dhp Gvn;
  private StickerEffectView Gvo;
  final b Gvp;
  private final a Gvq;
  private final a Gvr;
  final String TAG;
  private final View doN;
  private final WeImageView ukO;
  
  public g(View paramView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, kotlin.g.a.a<Integer> parama1)
  {
    AppMethodBeat.i(335920);
    this.doN = paramView;
    this.GrC = parama;
    this.Gvj = parama1;
    this.TAG = "MicroMsg.StickerEffectPlugin";
    paramView = this.doN.findViewById(l.e.sticker_effect);
    s.s(paramView, "layout.findViewById(R.id.sticker_effect)");
    this.ukO = ((WeImageView)paramView);
    paramView = this.doN.findViewById(l.e.sticker_effect_check);
    s.s(paramView, "layout.findViewById(R.id.sticker_effect_check)");
    this.Gvk = ((ImageView)paramView);
    paramView = this.doN.findViewById(l.e.finder_capture_sticker_hint);
    s.s(paramView, "layout.findViewById(R.id…der_capture_sticker_hint)");
    this.Gvl = ((CaptureStickerHint)paramView);
    paramView = this.doN.getContext();
    s.s(paramView, "layout.context");
    this.Gvm = new EditorPanelHolder(paramView);
    this.AAh = new com.tencent.mm.vending.e.c();
    this.Gvq = new a();
    this.Gvr = new a();
    this.ukO.setIconColor(-1);
    this.Gvk.setImageDrawable(com.tencent.mm.cd.a.m(this.doN.getContext(), l.h.popvideo_post_selected_origin));
    this.Gvp = new b((com.tencent.mm.vending.e.b)this.AAh, (c)new f((d)this.Gvq, (d)this.Gvr));
    this.ukO.setOnClickListener(new g..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(335920);
  }
  
  private static final void a(g paramg, View paramView)
  {
    AppMethodBeat.i(335941);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramg);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramg, "this$0");
    if (paramg.Gvo == null)
    {
      paramg.Gvp.aWi();
      paramView = paramg.ukO.getContext();
      s.s(paramView, "iconView.context");
      paramg.Gvo = new StickerEffectView(paramView);
      paramView = new ViewGroup.MarginLayoutParams(-1, ((Number)paramg.Gvj.invoke()).intValue() - com.tencent.mm.cd.a.fromDPToPix(paramg.ukO.getContext(), 8));
      localObject1 = paramg.Gvm;
      localObject2 = paramg.Gvo;
      s.checkNotNull(localObject2);
      ((EditorPanelHolder)localObject1).a((View)localObject2, (ViewGroup.LayoutParams)paramView);
      paramg.Gvm.setOnVisibleChangeCallback((kotlin.g.a.b)new g.a(paramg));
      paramView = paramg.Gvo;
      if (paramView != null) {
        paramView.setMoreDiffCallback(paramg.Gvr);
      }
      paramView = paramg.Gvo;
      if (paramView != null) {
        paramView.setHistoryDiffCallback(paramg.Gvq);
      }
      paramView = paramg.Gvo;
      if (paramView != null) {
        paramView.setSelectionCallback((kotlin.g.a.b)new b(paramg));
      }
      paramView = paramg.Gvo;
      if (paramView != null) {
        paramView.setLoadMoreCallback((kotlin.g.a.a)new c(paramg));
      }
    }
    paramg.Gvm.setShow(true);
    paramg.uM(true);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(335941);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(335978);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(335978);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(336002);
    s.u(this, "this");
    AppMethodBeat.o(336002);
  }
  
  public final String name()
  {
    AppMethodBeat.i(335984);
    String str = v.a.b(this);
    AppMethodBeat.o(335984);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(335993);
    s.u(this, "this");
    AppMethodBeat.o(335993);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(336011);
    s.u(this, "this");
    AppMethodBeat.o(336011);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(336021);
    s.u(this, "this");
    AppMethodBeat.o(336021);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(336033);
    s.u(this, "this");
    AppMethodBeat.o(336033);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(336050);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(336050);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(336061);
    s.u(this, "this");
    AppMethodBeat.o(336061);
  }
  
  public final void release()
  {
    AppMethodBeat.i(335972);
    this.AAh.dead();
    StickerEffectView localStickerEffectView = this.Gvo;
    if (localStickerEffectView != null)
    {
      e locale = e.acCJ;
      e.b(localStickerEffectView.Gvv);
    }
    s.u((v)this, "this");
    AppMethodBeat.o(335972);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(336073);
    s.u(this, "this");
    AppMethodBeat.o(336073);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(336083);
    s.u(this, "this");
    AppMethodBeat.o(336083);
  }
  
  final void uM(boolean paramBoolean)
  {
    AppMethodBeat.i(335963);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_STICKER_PANEL_OPEN", paramBoolean);
    this.GrC.a(a.c.NOc, localBundle);
    AppMethodBeat.o(335963);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/LensInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<dhp, ah>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.g
 * JD-Core Version:    0.7.0.1
 */