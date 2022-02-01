package com.tencent.mm.plugin.emojicapture.ui.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.emojicapture.model.a.f;
import com.tencent.mm.plugin.emojicapture.model.a.f.a;
import com.tencent.mm.plugin.emojicapture.ui.capture.StickerSelectFrame;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.sticker.c;
import com.tencent.mm.sticker.loader.h;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBindListener", "Lkotlin/Function1;", "getOnBindListener", "()Lkotlin/jvm/functions/Function1;", "setOnBindListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "EndViewHolder", "StickerViewHolder", "TitleViewHolder", "plugin-emojicapture_release"})
public final class a
  extends RecyclerView.a<a>
{
  public static final String TAG = "MicroMsg.MoreStickerAdapter";
  public static final a.b pVd;
  public final ArrayList<c> pVa;
  public m<? super Integer, ? super c, z> pVb;
  public d.g.a.b<? super Integer, z> pVc;
  private int uT;
  
  static
  {
    AppMethodBeat.i(550);
    pVd = new a.b((byte)0);
    TAG = "MicroMsg.MoreStickerAdapter";
    AppMethodBeat.o(550);
  }
  
  public a()
  {
    AppMethodBeat.i(549);
    this.pVa = new ArrayList();
    this.uT = -1;
    AppMethodBeat.o(549);
  }
  
  public final c Cv(int paramInt)
  {
    AppMethodBeat.i(195136);
    c localc = (c)j.E((List)this.pVa, paramInt);
    AppMethodBeat.o(195136);
    return localc;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(545);
    int i = this.pVa.size();
    AppMethodBeat.o(545);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(546);
    Object localObject = Cv(paramInt);
    if (localObject != null) {}
    for (localObject = ((c)localObject).IlG;; localObject = null)
    {
      locala = f.pRO;
      if (!p.i(localObject, f.cjZ()))
      {
        locala = f.pRO;
        if (!p.i(localObject, f.ckb())) {
          break;
        }
      }
      AppMethodBeat.o(546);
      return 1;
    }
    f.a locala = f.pRO;
    if (p.i(localObject, f.cka()))
    {
      AppMethodBeat.o(546);
      return 2;
    }
    AppMethodBeat.o(546);
    return 0;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(543);
    if (this.uT != paramInt)
    {
      cj(this.uT);
      this.uT = paramInt;
      cj(this.uT);
    }
    AppMethodBeat.o(543);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public abstract class a
    extends RecyclerView.w
  {
    public a()
    {
      super();
    }
    
    public abstract void c(bty parambty);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$EndViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class c
    extends a.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(537);
      AppMethodBeat.o(537);
    }
    
    public final void c(bty parambty)
    {
      AppMethodBeat.i(536);
      p.h(parambty, "info");
      AppMethodBeat.o(536);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "frame", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "kotlin.jvm.PlatformType", "getFrame", "()Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class d
    extends a.a
  {
    private final TextView jqd;
    private final ImageView ka;
    private final StickerSelectFrame pVf;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(540);
      this.ka = ((ImageView)localObject.findViewById(2131299351));
      this.jqd = ((TextView)localObject.findViewById(2131299352));
      this.pVf = ((StickerSelectFrame)localObject.findViewById(2131299357));
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(538);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$StickerViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          int i = this.pVg.lN();
          paramAnonymousView = this.pVg.pVe.Cv(i);
          if (paramAnonymousView != null)
          {
            localObject = this.pVg.pVe.pVb;
            if (localObject != null) {
              ((m)localObject).p(Integer.valueOf(i), paramAnonymousView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$StickerViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(538);
        }
      });
      AppMethodBeat.o(540);
    }
    
    public final void c(bty parambty)
    {
      AppMethodBeat.i(539);
      p.h(parambty, "info");
      Object localObject = h.ImR;
      localObject = h.getLoader().bI(new com.tencent.mm.sticker.loader.a(parambty));
      ImageView localImageView = this.ka;
      p.g(localImageView, "icon");
      ((com.tencent.mm.loader.a.b)localObject).c(localImageView);
      localObject = this.jqd;
      p.g(localObject, "text");
      ((TextView)localObject).setText((CharSequence)parambty.Name);
      this.pVf.acq(parambty.Geb);
      AppMethodBeat.o(539);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$TitleViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class e
    extends a.a
  {
    public e()
    {
      super(localObject);
      AppMethodBeat.i(542);
      AppMethodBeat.o(542);
    }
    
    public final void c(bty parambty)
    {
      AppMethodBeat.i(541);
      p.h(parambty, "info");
      TextView localTextView = (TextView)this.auu.findViewById(2131299352);
      f.a locala = f.pRO;
      if (p.i(parambty, f.cjZ()))
      {
        localTextView.setText(2131758229);
        AppMethodBeat.o(541);
        return;
      }
      locala = f.pRO;
      if (p.i(parambty, f.ckb())) {
        localTextView.setText(2131758232);
      }
      AppMethodBeat.o(541);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.a
 * JD-Core Version:    0.7.0.1
 */