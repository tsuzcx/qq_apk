package com.tencent.mm.plugin.finder.video.sticker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "bottomSpace", "Lkotlin/Function0;", "", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lkotlin/jvm/functions/Function0;)V", "TAG", "", "getBottomSpace", "()Lkotlin/jvm/functions/Function0;", "historyCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "iconView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLayout", "()Landroid/view/View;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "moreCallbackHolder", "selectedLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "stickerData", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerData;", "stickerHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "stickerView", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView;", "tipsView", "Landroid/widget/ImageView;", "recordHistory", "", "release", "setOpen", "isOpen", "", "showMore", "plugin-finder_release"})
public final class g
  implements u
{
  final com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  final WeImageView ATn;
  final ImageView ATo;
  final CaptureStickerHint ATp;
  final EditorPanelHolder ATq;
  public cqv ATr;
  StickerEffectView ATs;
  final b ATt;
  final a ATu;
  final a ATv;
  final kotlin.g.a.a<Integer> ATw;
  final String TAG;
  private final View bvK;
  private final com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> xbq;
  
  public g(View paramView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd, kotlin.g.a.a<Integer> parama)
  {
    AppMethodBeat.i(229121);
    this.bvK = paramView;
    this.APl = paramd;
    this.ATw = parama;
    this.TAG = "MicroMsg.StickerEffectPlugin";
    paramView = this.bvK.findViewById(b.f.sticker_effect);
    p.j(paramView, "layout.findViewById(R.id.sticker_effect)");
    this.ATn = ((WeImageView)paramView);
    paramView = this.bvK.findViewById(b.f.sticker_effect_check);
    p.j(paramView, "layout.findViewById(R.id.sticker_effect_check)");
    this.ATo = ((ImageView)paramView);
    paramView = this.bvK.findViewById(b.f.finder_capture_sticker_hint);
    p.j(paramView, "layout.findViewById(R.id…der_capture_sticker_hint)");
    this.ATp = ((CaptureStickerHint)paramView);
    paramView = this.bvK.getContext();
    p.j(paramView, "layout.context");
    this.ATq = new EditorPanelHolder(paramView);
    this.xbq = new com.tencent.mm.vending.e.c();
    this.ATu = new a();
    this.ATv = new a();
    this.ATn.setIconColor(-1);
    this.ATo.setImageDrawable(com.tencent.mm.ci.a.m(this.bvK.getContext(), b.i.popvideo_post_selected_origin));
    this.ATt = new b((com.tencent.mm.vending.e.b)this.xbq, (c)new f((d)this.ATu, (d)this.ATv));
    this.ATn.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(271657);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = this.ATx;
        if (paramAnonymousView.ATs == null)
        {
          paramAnonymousView.ATt.aDi();
          localObject = paramAnonymousView.ATn.getContext();
          p.j(localObject, "iconView.context");
          paramAnonymousView.ATs = new StickerEffectView((Context)localObject);
          localObject = new ViewGroup.MarginLayoutParams(-1, ((Number)paramAnonymousView.ATw.invoke()).intValue() - com.tencent.mm.ci.a.fromDPToPix(paramAnonymousView.ATn.getContext(), 8));
          EditorPanelHolder localEditorPanelHolder = paramAnonymousView.ATq;
          StickerEffectView localStickerEffectView = paramAnonymousView.ATs;
          if (localStickerEffectView == null) {
            p.iCn();
          }
          localEditorPanelHolder.a((View)localStickerEffectView, (ViewGroup.LayoutParams)localObject);
          paramAnonymousView.ATq.setOnVisibleChangeCallback((kotlin.g.a.b)new g.a(paramAnonymousView));
          localObject = paramAnonymousView.ATs;
          if (localObject != null) {
            ((StickerEffectView)localObject).setMoreDiffCallback(paramAnonymousView.ATv);
          }
          localObject = paramAnonymousView.ATs;
          if (localObject != null) {
            ((StickerEffectView)localObject).setHistoryDiffCallback(paramAnonymousView.ATu);
          }
          localObject = paramAnonymousView.ATs;
          if (localObject != null) {
            ((StickerEffectView)localObject).setSelectionCallback((kotlin.g.a.b)new g.b(paramAnonymousView));
          }
          localObject = paramAnonymousView.ATs;
          if (localObject != null) {
            ((StickerEffectView)localObject).setLoadMoreCallback((kotlin.g.a.a)new g.c(paramAnonymousView));
          }
        }
        paramAnonymousView.ATq.setShow(true);
        paramAnonymousView.rl(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(271657);
      }
    });
    AppMethodBeat.o(229121);
  }
  
  public final void bbp() {}
  
  public final String name()
  {
    AppMethodBeat.i(229122);
    String str = getClass().getName();
    AppMethodBeat.o(229122);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(229125);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(229125);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(229114);
    this.xbq.dead();
    StickerEffectView localStickerEffectView = this.ATs;
    if (localStickerEffectView != null)
    {
      e locale = e.Vbx;
      e.b(localStickerEffectView.ATB);
      AppMethodBeat.o(229114);
      return;
    }
    AppMethodBeat.o(229114);
  }
  
  public final void reset() {}
  
  final void rl(boolean paramBoolean)
  {
    AppMethodBeat.i(229113);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_STICKER_PANEL_OPEN", paramBoolean);
    this.APl.a(d.c.HRw, localBundle);
    AppMethodBeat.o(229113);
  }
  
  public final void setVisibility(int paramInt) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    a(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<cqv, x>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.g
 * JD-Core Version:    0.7.0.1
 */