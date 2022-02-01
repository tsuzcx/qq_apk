package com.tencent.mm.plugin.finder.video.sticker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "bottomSpace", "Lkotlin/Function0;", "", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lkotlin/jvm/functions/Function0;)V", "TAG", "", "getBottomSpace", "()Lkotlin/jvm/functions/Function0;", "historyCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "holder", "Lcom/tencent/mm/plugin/finder/video/sticker/EditorPanelHolder;", "iconView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLayout", "()Landroid/view/View;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "moreCallbackHolder", "selectedLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "stickerData", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerData;", "stickerHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "stickerView", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView;", "tipsView", "Landroid/widget/ImageView;", "recordHistory", "", "release", "setOpen", "isOpen", "", "showMore", "plugin-finder_release"})
public final class g
  implements t
{
  final String TAG;
  private final com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> qXf;
  private final View qe;
  final com.tencent.mm.plugin.recordvideo.plugin.parent.d rTT;
  final WeImageView rUO;
  final ImageView rUP;
  final CaptureStickerHint rUQ;
  final EditorPanelHolder rUR;
  public bpl rUS;
  StickerEffectView rUT;
  final b rUU;
  final a rUV;
  final a rUW;
  final d.g.a.a<Integer> rUX;
  
  public g(View paramView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd, d.g.a.a<Integer> parama)
  {
    AppMethodBeat.i(204071);
    this.qe = paramView;
    this.rTT = paramd;
    this.rUX = parama;
    this.TAG = "MicroMsg.StickerEffectPlugin";
    paramView = this.qe.findViewById(2131308009);
    k.g(paramView, "layout.findViewById(R.id.sticker_effect)");
    this.rUO = ((WeImageView)paramView);
    paramView = this.qe.findViewById(2131308010);
    k.g(paramView, "layout.findViewById(R.id.sticker_effect_check)");
    this.rUP = ((ImageView)paramView);
    paramView = this.qe.findViewById(2131307390);
    k.g(paramView, "layout.findViewById(R.id…der_capture_sticker_hint)");
    this.rUQ = ((CaptureStickerHint)paramView);
    paramView = this.qe.getContext();
    k.g(paramView, "layout.context");
    this.rUR = new EditorPanelHolder(paramView);
    this.qXf = new com.tencent.mm.vending.e.c();
    this.rUV = new a();
    this.rUW = new a();
    this.rUO.setIconColor(-1);
    this.rUP.setImageDrawable(com.tencent.mm.cc.a.l(this.qe.getContext(), 2131691551));
    this.rUU = new b((com.tencent.mm.vending.e.b)this.qXf, (c)new f((d)this.rUV, (d)this.rUW));
    this.rUO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(204064);
        paramAnonymousView = this.rUY;
        if (paramAnonymousView.rUT == null)
        {
          paramAnonymousView.rUU.cfp();
          Object localObject1 = paramAnonymousView.rUO.getContext();
          k.g(localObject1, "iconView.context");
          paramAnonymousView.rUT = new StickerEffectView((Context)localObject1);
          Object localObject3 = new ViewGroup.MarginLayoutParams(-1, ((Number)paramAnonymousView.rUX.invoke()).intValue() - com.tencent.mm.cc.a.fromDPToPix(paramAnonymousView.rUO.getContext(), 8));
          localObject1 = paramAnonymousView.rUR;
          Object localObject2 = paramAnonymousView.rUT;
          if (localObject2 == null) {
            k.fOy();
          }
          localObject2 = (View)localObject2;
          localObject3 = (ViewGroup.LayoutParams)localObject3;
          k.h(localObject2, "view");
          ((EditorPanelHolder)localObject1).rUv = ((View)localObject2);
          localObject3 = new FrameLayout.LayoutParams((ViewGroup.LayoutParams)localObject3);
          ((FrameLayout.LayoutParams)localObject3).gravity = 80;
          ((EditorPanelHolder)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          paramAnonymousView.rUR.setOnVisibleChangeCallback((d.g.a.b)new g.a(paramAnonymousView));
          localObject1 = paramAnonymousView.rUT;
          if (localObject1 != null) {
            ((StickerEffectView)localObject1).setMoreDiffCallback(paramAnonymousView.rUW);
          }
          localObject1 = paramAnonymousView.rUT;
          if (localObject1 != null) {
            ((StickerEffectView)localObject1).setHistoryDiffCallback(paramAnonymousView.rUV);
          }
          localObject1 = paramAnonymousView.rUT;
          if (localObject1 != null) {
            ((StickerEffectView)localObject1).setSelectionCallback((d.g.a.b)new g.b(paramAnonymousView));
          }
          localObject1 = paramAnonymousView.rUT;
          if (localObject1 != null) {
            ((StickerEffectView)localObject1).setLoadMoreCallback((d.g.a.a)new g.c(paramAnonymousView));
          }
        }
        paramAnonymousView.rUR.setShow(true);
        paramAnonymousView.lU(true);
        AppMethodBeat.o(204064);
      }
    });
    AppMethodBeat.o(204071);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  final void lU(boolean paramBoolean)
  {
    AppMethodBeat.i(204069);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_STICKER_PANEL_OPEN", paramBoolean);
    this.rTT.a(d.c.wwh, localBundle);
    AppMethodBeat.o(204069);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(204070);
    this.qXf.dead();
    StickerEffectView localStickerEffectView = this.rUT;
    if (localStickerEffectView != null)
    {
      e locale = e.GAP;
      e.b(localStickerEffectView.rVc);
      AppMethodBeat.o(204070);
      return;
    }
    AppMethodBeat.o(204070);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    a(g paramg)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<bpl, y>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.g
 * JD-Core Version:    0.7.0.1
 */