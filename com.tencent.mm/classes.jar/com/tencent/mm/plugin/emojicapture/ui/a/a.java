package com.tencent.mm.plugin.emojicapture.ui.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.emojicapture.model.a.f;
import com.tencent.mm.plugin.emojicapture.model.a.f.a;
import com.tencent.mm.plugin.emojicapture.ui.capture.StickerSelectFrame;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sticker.c;
import com.tencent.mm.sticker.loader.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBindListener", "Lkotlin/Function1;", "getOnBindListener", "()Lkotlin/jvm/functions/Function1;", "setOnBindListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "EndViewHolder", "StickerViewHolder", "TitleViewHolder", "plugin-emojicapture_release"})
public final class a
  extends RecyclerView.a<a>
{
  public static final String TAG = "MicroMsg.MoreStickerAdapter";
  public static final a.b rsF;
  public final ArrayList<c> rsC;
  public m<? super Integer, ? super c, x> rsD;
  public kotlin.g.a.b<? super Integer, x> rsE;
  private int va;
  
  static
  {
    AppMethodBeat.i(550);
    rsF = new a.b((byte)0);
    TAG = "MicroMsg.MoreStickerAdapter";
    AppMethodBeat.o(550);
  }
  
  public a()
  {
    AppMethodBeat.i(549);
    this.rsC = new ArrayList();
    this.va = -1;
    AppMethodBeat.o(549);
  }
  
  public final c Gs(int paramInt)
  {
    AppMethodBeat.i(256437);
    c localc = (c)j.L((List)this.rsC, paramInt);
    AppMethodBeat.o(256437);
    return localc;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(545);
    int i = this.rsC.size();
    AppMethodBeat.o(545);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(546);
    Object localObject = Gs(paramInt);
    if (localObject != null) {}
    for (localObject = ((c)localObject).NMJ;; localObject = null)
    {
      locala = f.rpr;
      if (!p.j(localObject, f.cJr()))
      {
        locala = f.rpr;
        if (!p.j(localObject, f.cJt())) {
          break;
        }
      }
      AppMethodBeat.o(546);
      return 1;
    }
    f.a locala = f.rpr;
    if (p.j(localObject, f.cJs()))
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
    if (this.va != paramInt)
    {
      ci(this.va);
      this.va = paramInt;
      ci(this.va);
    }
    AppMethodBeat.o(543);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public abstract class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
    }
    
    public abstract void c(chz paramchz);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$EndViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class c
    extends a.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(537);
      AppMethodBeat.o(537);
    }
    
    public final void c(chz paramchz)
    {
      AppMethodBeat.i(536);
      p.h(paramchz, "info");
      AppMethodBeat.o(536);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "frame", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "kotlin.jvm.PlatformType", "getFrame", "()Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class d
    extends a.a
  {
    private final ImageView kc;
    private final TextView krl;
    private final StickerSelectFrame rsH;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(540);
      this.kc = ((ImageView)localObject.findViewById(2131299963));
      this.krl = ((TextView)localObject.findViewById(2131299964));
      this.rsH = ((StickerSelectFrame)localObject.findViewById(2131299969));
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(538);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$StickerViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          int i = this.rsI.lR();
          paramAnonymousView = this.rsI.rsG.Gs(i);
          if (paramAnonymousView != null)
          {
            localObject = this.rsI.rsG.rsD;
            if (localObject != null) {
              ((m)localObject).invoke(Integer.valueOf(i), paramAnonymousView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$StickerViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(538);
        }
      });
      AppMethodBeat.o(540);
    }
    
    public final void c(chz paramchz)
    {
      AppMethodBeat.i(539);
      p.h(paramchz, "info");
      Object localObject = h.NNV;
      localObject = h.getLoader().bQ(new com.tencent.mm.sticker.loader.a(paramchz));
      ImageView localImageView = this.kc;
      p.g(localImageView, "icon");
      ((com.tencent.mm.loader.a.b)localObject).c(localImageView);
      localObject = this.krl;
      p.g(localObject, "text");
      ((TextView)localObject).setText((CharSequence)paramchz.Name);
      this.rsH.anq(paramchz.Lso);
      AppMethodBeat.o(539);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$TitleViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class e
    extends a.a
  {
    public e()
    {
      super(localObject);
      AppMethodBeat.i(542);
      AppMethodBeat.o(542);
    }
    
    public final void c(chz paramchz)
    {
      AppMethodBeat.i(541);
      p.h(paramchz, "info");
      TextView localTextView = (TextView)this.aus.findViewById(2131299964);
      f.a locala = f.rpr;
      if (p.j(paramchz, f.cJr()))
      {
        localTextView.setText(2131758517);
        AppMethodBeat.o(541);
        return;
      }
      locala = f.rpr;
      if (p.j(paramchz, f.cJt())) {
        localTextView.setText(2131758520);
      }
      AppMethodBeat.o(541);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.a
 * JD-Core Version:    0.7.0.1
 */