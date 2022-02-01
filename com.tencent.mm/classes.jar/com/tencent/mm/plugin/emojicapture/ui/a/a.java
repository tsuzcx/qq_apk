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
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.sticker.c;
import com.tencent.mm.sticker.loader.h;
import d.a.j;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBindListener", "Lkotlin/Function1;", "getOnBindListener", "()Lkotlin/jvm/functions/Function1;", "setOnBindListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "EndViewHolder", "StickerViewHolder", "TitleViewHolder", "plugin-emojicapture_release"})
public final class a
  extends RecyclerView.a<a>
{
  public static final String TAG = "MicroMsg.MoreStickerAdapter";
  public static final a.b prx;
  public final ArrayList<c> pru;
  public m<? super Integer, ? super c, y> prv;
  public d.g.a.b<? super Integer, y> prw;
  private int ta;
  
  static
  {
    AppMethodBeat.i(550);
    prx = new a.b((byte)0);
    TAG = "MicroMsg.MoreStickerAdapter";
    AppMethodBeat.o(550);
  }
  
  public a()
  {
    AppMethodBeat.i(549);
    this.pru = new ArrayList();
    this.ta = -1;
    AppMethodBeat.o(549);
  }
  
  public final c BN(int paramInt)
  {
    AppMethodBeat.i(195160);
    c localc = (c)j.C((List)this.pru, paramInt);
    AppMethodBeat.o(195160);
    return localc;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(545);
    int i = this.pru.size();
    AppMethodBeat.o(545);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(546);
    Object localObject = BN(paramInt);
    if (localObject != null) {}
    for (localObject = ((c)localObject).GzM;; localObject = null)
    {
      locala = f.poo;
      if (!k.g(localObject, f.cfw()))
      {
        locala = f.poo;
        if (!k.g(localObject, f.cfy())) {
          break;
        }
      }
      AppMethodBeat.o(546);
      return 1;
    }
    f.a locala = f.poo;
    if (k.g(localObject, f.cfx()))
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
    if (this.ta != paramInt)
    {
      cj(this.ta);
      this.ta = paramInt;
      cj(this.ta);
    }
    AppMethodBeat.o(543);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public abstract class a
    extends RecyclerView.w
  {
    public a()
    {
      super();
    }
    
    public abstract void c(bpl parambpl);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$EndViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class c
    extends a.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(537);
      AppMethodBeat.o(537);
    }
    
    public final void c(bpl parambpl)
    {
      AppMethodBeat.i(536);
      k.h(parambpl, "info");
      AppMethodBeat.o(536);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "frame", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "kotlin.jvm.PlatformType", "getFrame", "()Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class d
    extends a.a
  {
    private final TextView iWU;
    private final ImageView ig;
    private final StickerSelectFrame prz;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(540);
      this.ig = ((ImageView)localObject.findViewById(2131299351));
      this.iWU = ((TextView)localObject.findViewById(2131299352));
      this.prz = ((StickerSelectFrame)localObject.findViewById(2131299357));
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(538);
          int i = this.prA.lv();
          paramAnonymousView = this.prA.pry.BN(i);
          if (paramAnonymousView != null)
          {
            m localm = this.prA.pry.prv;
            if (localm != null)
            {
              localm.n(Integer.valueOf(i), paramAnonymousView);
              AppMethodBeat.o(538);
              return;
            }
            AppMethodBeat.o(538);
            return;
          }
          AppMethodBeat.o(538);
        }
      });
      AppMethodBeat.o(540);
    }
    
    public final void c(bpl parambpl)
    {
      AppMethodBeat.i(539);
      k.h(parambpl, "info");
      Object localObject = h.GAX;
      localObject = h.getLoader().bG(new com.tencent.mm.sticker.loader.a(parambpl));
      ImageView localImageView = this.ig;
      k.g(localImageView, "icon");
      ((com.tencent.mm.loader.a.b)localObject).c(localImageView);
      localObject = this.iWU;
      k.g(localObject, "text");
      ((TextView)localObject).setText((CharSequence)parambpl.Name);
      this.prz.YK(parambpl.Ewy);
      AppMethodBeat.o(539);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$TitleViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class e
    extends a.a
  {
    public e()
    {
      super(localObject);
      AppMethodBeat.i(542);
      AppMethodBeat.o(542);
    }
    
    public final void c(bpl parambpl)
    {
      AppMethodBeat.i(541);
      k.h(parambpl, "info");
      TextView localTextView = (TextView)this.asD.findViewById(2131299352);
      f.a locala = f.poo;
      if (k.g(parambpl, f.cfw()))
      {
        localTextView.setText(2131758229);
        AppMethodBeat.o(541);
        return;
      }
      locala = f.poo;
      if (k.g(parambpl, f.cfy())) {
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