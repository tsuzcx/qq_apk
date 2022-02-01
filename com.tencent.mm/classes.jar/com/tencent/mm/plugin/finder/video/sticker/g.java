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
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "bottomSpace", "Lkotlin/Function0;", "", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lkotlin/jvm/functions/Function0;)V", "TAG", "", "getBottomSpace", "()Lkotlin/jvm/functions/Function0;", "historyCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "iconView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLayout", "()Landroid/view/View;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "moreCallbackHolder", "selectedLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "stickerData", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerData;", "stickerHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "stickerView", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView;", "tipsView", "Landroid/widget/ImageView;", "recordHistory", "", "release", "setOpen", "isOpen", "", "showMore", "plugin-finder_release"})
public final class g
  implements t
{
  final String TAG;
  private final View sc;
  private final com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> ttK;
  final com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
  final WeImageView wjf;
  final ImageView wjg;
  final CaptureStickerHint wjh;
  final EditorPanelHolder wji;
  public chz wjj;
  StickerEffectView wjk;
  final b wjl;
  final a wjm;
  final a wjn;
  final kotlin.g.a.a<Integer> wjo;
  
  public g(View paramView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd, kotlin.g.a.a<Integer> parama)
  {
    AppMethodBeat.i(254601);
    this.sc = paramView;
    this.wgr = paramd;
    this.wjo = parama;
    this.TAG = "MicroMsg.StickerEffectPlugin";
    paramView = this.sc.findViewById(2131308419);
    p.g(paramView, "layout.findViewById(R.id.sticker_effect)");
    this.wjf = ((WeImageView)paramView);
    paramView = this.sc.findViewById(2131308420);
    p.g(paramView, "layout.findViewById(R.id.sticker_effect_check)");
    this.wjg = ((ImageView)paramView);
    paramView = this.sc.findViewById(2131300786);
    p.g(paramView, "layout.findViewById(R.id…der_capture_sticker_hint)");
    this.wjh = ((CaptureStickerHint)paramView);
    paramView = this.sc.getContext();
    p.g(paramView, "layout.context");
    this.wji = new EditorPanelHolder(paramView);
    this.ttK = new com.tencent.mm.vending.e.c();
    this.wjm = new a();
    this.wjn = new a();
    this.wjf.setIconColor(-1);
    this.wjg.setImageDrawable(com.tencent.mm.cb.a.l(this.sc.getContext(), 2131691337));
    this.wjl = new b((com.tencent.mm.vending.e.b)this.ttK, (c)new f((d)this.wjm, (d)this.wjn));
    this.wjf.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(254594);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = this.wjp;
        if (paramAnonymousView.wjk == null)
        {
          paramAnonymousView.wjl.cJk();
          localObject = paramAnonymousView.wjf.getContext();
          p.g(localObject, "iconView.context");
          paramAnonymousView.wjk = new StickerEffectView((Context)localObject);
          localObject = new ViewGroup.MarginLayoutParams(-1, ((Number)paramAnonymousView.wjo.invoke()).intValue() - com.tencent.mm.cb.a.fromDPToPix(paramAnonymousView.wjf.getContext(), 8));
          EditorPanelHolder localEditorPanelHolder = paramAnonymousView.wji;
          StickerEffectView localStickerEffectView = paramAnonymousView.wjk;
          if (localStickerEffectView == null) {
            p.hyc();
          }
          localEditorPanelHolder.a((View)localStickerEffectView, (ViewGroup.LayoutParams)localObject);
          paramAnonymousView.wji.setOnVisibleChangeCallback((kotlin.g.a.b)new g.a(paramAnonymousView));
          localObject = paramAnonymousView.wjk;
          if (localObject != null) {
            ((StickerEffectView)localObject).setMoreDiffCallback(paramAnonymousView.wjn);
          }
          localObject = paramAnonymousView.wjk;
          if (localObject != null) {
            ((StickerEffectView)localObject).setHistoryDiffCallback(paramAnonymousView.wjm);
          }
          localObject = paramAnonymousView.wjk;
          if (localObject != null) {
            ((StickerEffectView)localObject).setSelectionCallback((kotlin.g.a.b)new g.b(paramAnonymousView));
          }
          localObject = paramAnonymousView.wjk;
          if (localObject != null) {
            ((StickerEffectView)localObject).setLoadMoreCallback((kotlin.g.a.a)new g.c(paramAnonymousView));
          }
        }
        paramAnonymousView.wji.setShow(true);
        paramAnonymousView.oT(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(254594);
      }
    });
    AppMethodBeat.o(254601);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
  }
  
  final void oT(boolean paramBoolean)
  {
    AppMethodBeat.i(254599);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_STICKER_PANEL_OPEN", paramBoolean);
    this.wgr.a(d.c.BUJ, localBundle);
    AppMethodBeat.o(254599);
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
    AppMethodBeat.i(254602);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(254602);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(254600);
    this.ttK.dead();
    StickerEffectView localStickerEffectView = this.wjk;
    if (localStickerEffectView != null)
    {
      e locale = e.NNN;
      e.b(localStickerEffectView.wjt);
      AppMethodBeat.o(254600);
      return;
    }
    AppMethodBeat.o(254600);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    a(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<chz, x>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.g
 * JD-Core Version:    0.7.0.1
 */