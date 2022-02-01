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
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "bottomSpace", "Lkotlin/Function0;", "", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lkotlin/jvm/functions/Function0;)V", "TAG", "", "getBottomSpace", "()Lkotlin/jvm/functions/Function0;", "historyCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "iconView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLayout", "()Landroid/view/View;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "moreCallbackHolder", "selectedLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "stickerData", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerData;", "stickerHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "stickerView", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView;", "tipsView", "Landroid/widget/ImageView;", "recordHistory", "", "release", "setOpen", "isOpen", "", "showMore", "plugin-finder_release"})
public final class g
  implements t
{
  final String TAG;
  private final com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> rIh;
  private final View rY;
  final com.tencent.mm.plugin.recordvideo.plugin.parent.d sQE;
  public bty sRA;
  StickerEffectView sRB;
  final b sRC;
  final a sRD;
  final a sRE;
  final d.g.a.a<Integer> sRF;
  final WeImageView sRw;
  final ImageView sRx;
  final CaptureStickerHint sRy;
  final EditorPanelHolder sRz;
  
  public g(View paramView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd, d.g.a.a<Integer> parama)
  {
    AppMethodBeat.i(205024);
    this.rY = paramView;
    this.sQE = paramd;
    this.sRF = parama;
    this.TAG = "MicroMsg.StickerEffectPlugin";
    paramView = this.rY.findViewById(2131308009);
    p.g(paramView, "layout.findViewById(R.id.sticker_effect)");
    this.sRw = ((WeImageView)paramView);
    paramView = this.rY.findViewById(2131308010);
    p.g(paramView, "layout.findViewById(R.id.sticker_effect_check)");
    this.sRx = ((ImageView)paramView);
    paramView = this.rY.findViewById(2131307390);
    p.g(paramView, "layout.findViewById(R.id…der_capture_sticker_hint)");
    this.sRy = ((CaptureStickerHint)paramView);
    paramView = this.rY.getContext();
    p.g(paramView, "layout.context");
    this.sRz = new EditorPanelHolder(paramView);
    this.rIh = new com.tencent.mm.vending.e.c();
    this.sRD = new a();
    this.sRE = new a();
    this.sRw.setIconColor(-1);
    this.sRx.setImageDrawable(com.tencent.mm.cc.a.l(this.rY.getContext(), 2131691551));
    this.sRC = new b((com.tencent.mm.vending.e.b)this.rIh, (c)new f((d)this.sRD, (d)this.sRE));
    this.sRw.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205017);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = this.sRG;
        if (paramAnonymousView.sRB == null)
        {
          paramAnonymousView.sRC.cjS();
          localObject = paramAnonymousView.sRw.getContext();
          p.g(localObject, "iconView.context");
          paramAnonymousView.sRB = new StickerEffectView((Context)localObject);
          localObject = new ViewGroup.MarginLayoutParams(-1, ((Number)paramAnonymousView.sRF.invoke()).intValue() - com.tencent.mm.cc.a.fromDPToPix(paramAnonymousView.sRw.getContext(), 8));
          EditorPanelHolder localEditorPanelHolder = paramAnonymousView.sRz;
          StickerEffectView localStickerEffectView = paramAnonymousView.sRB;
          if (localStickerEffectView == null) {
            p.gfZ();
          }
          localEditorPanelHolder.a((View)localStickerEffectView, (ViewGroup.LayoutParams)localObject);
          paramAnonymousView.sRz.setOnVisibleChangeCallback((d.g.a.b)new g.a(paramAnonymousView));
          localObject = paramAnonymousView.sRB;
          if (localObject != null) {
            ((StickerEffectView)localObject).setMoreDiffCallback(paramAnonymousView.sRE);
          }
          localObject = paramAnonymousView.sRB;
          if (localObject != null) {
            ((StickerEffectView)localObject).setHistoryDiffCallback(paramAnonymousView.sRD);
          }
          localObject = paramAnonymousView.sRB;
          if (localObject != null) {
            ((StickerEffectView)localObject).setSelectionCallback((d.g.a.b)new g.b(paramAnonymousView));
          }
          localObject = paramAnonymousView.sRB;
          if (localObject != null) {
            ((StickerEffectView)localObject).setLoadMoreCallback((d.g.a.a)new g.c(paramAnonymousView));
          }
        }
        paramAnonymousView.sRz.setShow(true);
        paramAnonymousView.mm(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(205017);
      }
    });
    AppMethodBeat.o(205024);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  final void mm(boolean paramBoolean)
  {
    AppMethodBeat.i(205022);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_STICKER_PANEL_OPEN", paramBoolean);
    this.sQE.a(d.c.xEp, localBundle);
    AppMethodBeat.o(205022);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(205025);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(205025);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(205023);
    this.rIh.dead();
    StickerEffectView localStickerEffectView = this.sRB;
    if (localStickerEffectView != null)
    {
      e locale = e.ImJ;
      e.b(localStickerEffectView.sRK);
      AppMethodBeat.o(205023);
      return;
    }
    AppMethodBeat.o(205023);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<Boolean, z>
  {
    a(g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<bty, z>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
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