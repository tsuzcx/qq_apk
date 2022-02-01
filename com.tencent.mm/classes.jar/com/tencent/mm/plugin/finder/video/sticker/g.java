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
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "bottomSpace", "Lkotlin/Function0;", "", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lkotlin/jvm/functions/Function0;)V", "TAG", "", "getBottomSpace", "()Lkotlin/jvm/functions/Function0;", "historyCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "holder", "Lcom/tencent/mm/plugin/finder/video/sticker/EditorPanelHolder;", "iconView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLayout", "()Landroid/view/View;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "moreCallbackHolder", "selectedLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "stickerData", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerData;", "stickerHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "stickerView", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView;", "tipsView", "Landroid/widget/ImageView;", "recordHistory", "", "release", "setOpen", "isOpen", "", "showMore", "plugin-finder_release"})
public final class g
  implements t
{
  private final com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> KJT;
  final WeImageView LdW;
  final ImageView LdX;
  final CaptureStickerHint LdY;
  final EditorPanelHolder LdZ;
  public blp Lea;
  StickerEffectView Leb;
  final b Lec;
  final a Led;
  final a Lee;
  final d.g.a.a<Integer> Lef;
  final String TAG;
  private final View pf;
  final com.tencent.mm.plugin.recordvideo.plugin.parent.d vjo;
  
  public g(View paramView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd, d.g.a.a<Integer> parama)
  {
    AppMethodBeat.i(200003);
    this.pf = paramView;
    this.vjo = paramd;
    this.Lef = parama;
    this.TAG = "MicroMsg.StickerEffectPlugin";
    paramView = this.pf.findViewById(2131307876);
    k.g(paramView, "layout.findViewById(R.id.sticker_effect)");
    this.LdW = ((WeImageView)paramView);
    paramView = this.pf.findViewById(2131307877);
    k.g(paramView, "layout.findViewById(R.id.sticker_effect_check)");
    this.LdX = ((ImageView)paramView);
    paramView = this.pf.findViewById(2131307321);
    k.g(paramView, "layout.findViewById(R.id…der_capture_sticker_hint)");
    this.LdY = ((CaptureStickerHint)paramView);
    paramView = this.pf.getContext();
    k.g(paramView, "layout.context");
    this.LdZ = new EditorPanelHolder(paramView);
    this.KJT = new com.tencent.mm.vending.e.c();
    this.Led = new a();
    this.Lee = new a();
    this.LdW.setIconColor(-1);
    this.LdX.setImageDrawable(com.tencent.mm.cd.a.l(this.pf.getContext(), 2131691536));
    this.Lec = new b((com.tencent.mm.vending.e.b)this.KJT, (c)new f((d)this.Led, (d)this.Lee));
    this.LdW.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(199996);
        paramAnonymousView = this.Leg;
        if (paramAnonymousView.Leb == null)
        {
          paramAnonymousView.Lec.bYc();
          Object localObject1 = paramAnonymousView.LdW.getContext();
          k.g(localObject1, "iconView.context");
          paramAnonymousView.Leb = new StickerEffectView((Context)localObject1);
          Object localObject3 = new ViewGroup.MarginLayoutParams(-1, ((Number)paramAnonymousView.Lef.invoke()).intValue() - com.tencent.mm.cd.a.fromDPToPix(paramAnonymousView.LdW.getContext(), 8));
          localObject1 = paramAnonymousView.LdZ;
          Object localObject2 = paramAnonymousView.Leb;
          if (localObject2 == null) {
            k.fvU();
          }
          localObject2 = (View)localObject2;
          localObject3 = (ViewGroup.LayoutParams)localObject3;
          k.h(localObject2, "view");
          ((EditorPanelHolder)localObject1).LdD = ((View)localObject2);
          localObject3 = new FrameLayout.LayoutParams((ViewGroup.LayoutParams)localObject3);
          ((FrameLayout.LayoutParams)localObject3).gravity = 80;
          ((EditorPanelHolder)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          paramAnonymousView.LdZ.setOnVisibleChangeCallback((d.g.a.b)new g.a(paramAnonymousView));
          localObject1 = paramAnonymousView.Leb;
          if (localObject1 != null) {
            ((StickerEffectView)localObject1).setMoreDiffCallback(paramAnonymousView.Lee);
          }
          localObject1 = paramAnonymousView.Leb;
          if (localObject1 != null) {
            ((StickerEffectView)localObject1).setHistoryDiffCallback(paramAnonymousView.Led);
          }
          localObject1 = paramAnonymousView.Leb;
          if (localObject1 != null) {
            ((StickerEffectView)localObject1).setSelectionCallback((d.g.a.b)new g.b(paramAnonymousView));
          }
          localObject1 = paramAnonymousView.Leb;
          if (localObject1 != null) {
            ((StickerEffectView)localObject1).setLoadMoreCallback((d.g.a.a)new g.c(paramAnonymousView));
          }
        }
        paramAnonymousView.LdZ.setShow(true);
        paramAnonymousView.yO(true);
        AppMethodBeat.o(199996);
      }
    });
    AppMethodBeat.o(200003);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
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
    AppMethodBeat.i(200002);
    this.KJT.dead();
    StickerEffectView localStickerEffectView = this.Leb;
    if (localStickerEffectView != null)
    {
      e locale = e.Fds;
      e.b(localStickerEffectView.Lek);
      AppMethodBeat.o(200002);
      return;
    }
    AppMethodBeat.o(200002);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  final void yO(boolean paramBoolean)
  {
    AppMethodBeat.i(200001);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_STICKER_PANEL_OPEN", paramBoolean);
    this.vjo.a(d.c.Low, localBundle);
    AppMethodBeat.o(200001);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    a(g paramg)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<blp, y>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.g
 * JD-Core Version:    0.7.0.1
 */