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
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "bottomSpace", "Lkotlin/Function0;", "", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lkotlin/jvm/functions/Function0;)V", "TAG", "", "getBottomSpace", "()Lkotlin/jvm/functions/Function0;", "historyCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "iconView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLayout", "()Landroid/view/View;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "moreCallbackHolder", "selectedLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "stickerData", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerData;", "stickerHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "stickerView", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView;", "tipsView", "Landroid/widget/ImageView;", "recordHistory", "", "release", "setOpen", "isOpen", "", "showMore", "plugin-finder_release"})
public final class g
  implements t
{
  final String TAG;
  private final com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> rQs;
  private final View rY;
  final com.tencent.mm.plugin.recordvideo.plugin.parent.d tbP;
  final WeImageView tcH;
  final ImageView tcI;
  final CaptureStickerHint tcJ;
  final EditorPanelHolder tcK;
  public bus tcL;
  StickerEffectView tcM;
  final b tcN;
  final a tcO;
  final a tcP;
  final d.g.a.a<Integer> tcQ;
  
  public g(View paramView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd, d.g.a.a<Integer> parama)
  {
    AppMethodBeat.i(205649);
    this.rY = paramView;
    this.tbP = paramd;
    this.tcQ = parama;
    this.TAG = "MicroMsg.StickerEffectPlugin";
    paramView = this.rY.findViewById(2131308009);
    p.g(paramView, "layout.findViewById(R.id.sticker_effect)");
    this.tcH = ((WeImageView)paramView);
    paramView = this.rY.findViewById(2131308010);
    p.g(paramView, "layout.findViewById(R.id.sticker_effect_check)");
    this.tcI = ((ImageView)paramView);
    paramView = this.rY.findViewById(2131307390);
    p.g(paramView, "layout.findViewById(R.id…der_capture_sticker_hint)");
    this.tcJ = ((CaptureStickerHint)paramView);
    paramView = this.rY.getContext();
    p.g(paramView, "layout.context");
    this.tcK = new EditorPanelHolder(paramView);
    this.rQs = new com.tencent.mm.vending.e.c();
    this.tcO = new a();
    this.tcP = new a();
    this.tcH.setIconColor(-1);
    this.tcI.setImageDrawable(com.tencent.mm.cb.a.l(this.rY.getContext(), 2131691551));
    this.tcN = new b((com.tencent.mm.vending.e.b)this.rQs, (c)new f((d)this.tcO, (d)this.tcP));
    this.tcH.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205642);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = this.tcR;
        if (paramAnonymousView.tcM == null)
        {
          paramAnonymousView.tcN.cli();
          localObject = paramAnonymousView.tcH.getContext();
          p.g(localObject, "iconView.context");
          paramAnonymousView.tcM = new StickerEffectView((Context)localObject);
          localObject = new ViewGroup.MarginLayoutParams(-1, ((Number)paramAnonymousView.tcQ.invoke()).intValue() - com.tencent.mm.cb.a.fromDPToPix(paramAnonymousView.tcH.getContext(), 8));
          EditorPanelHolder localEditorPanelHolder = paramAnonymousView.tcK;
          StickerEffectView localStickerEffectView = paramAnonymousView.tcM;
          if (localStickerEffectView == null) {
            p.gkB();
          }
          localEditorPanelHolder.a((View)localStickerEffectView, (ViewGroup.LayoutParams)localObject);
          paramAnonymousView.tcK.setOnVisibleChangeCallback((d.g.a.b)new g.a(paramAnonymousView));
          localObject = paramAnonymousView.tcM;
          if (localObject != null) {
            ((StickerEffectView)localObject).setMoreDiffCallback(paramAnonymousView.tcP);
          }
          localObject = paramAnonymousView.tcM;
          if (localObject != null) {
            ((StickerEffectView)localObject).setHistoryDiffCallback(paramAnonymousView.tcO);
          }
          localObject = paramAnonymousView.tcM;
          if (localObject != null) {
            ((StickerEffectView)localObject).setSelectionCallback((d.g.a.b)new g.b(paramAnonymousView));
          }
          localObject = paramAnonymousView.tcM;
          if (localObject != null) {
            ((StickerEffectView)localObject).setLoadMoreCallback((d.g.a.a)new g.c(paramAnonymousView));
          }
        }
        paramAnonymousView.tcK.setShow(true);
        paramAnonymousView.mr(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(205642);
      }
    });
    AppMethodBeat.o(205649);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  final void mr(boolean paramBoolean)
  {
    AppMethodBeat.i(205647);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_STICKER_PANEL_OPEN", paramBoolean);
    this.tbP.a(d.c.xUk, localBundle);
    AppMethodBeat.o(205647);
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
    AppMethodBeat.i(205650);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(205650);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(205648);
    this.rQs.dead();
    StickerEffectView localStickerEffectView = this.tcM;
    if (localStickerEffectView != null)
    {
      e locale = e.IGU;
      e.b(localStickerEffectView.tcV);
      AppMethodBeat.o(205648);
      return;
    }
    AppMethodBeat.o(205648);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<Boolean, z>
  {
    a(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<bus, z>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.g
 * JD-Core Version:    0.7.0.1
 */