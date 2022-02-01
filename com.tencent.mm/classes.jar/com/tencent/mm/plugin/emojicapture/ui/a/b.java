package com.tencent.mm.plugin.emojicapture.ui.a;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.sticker.loader.h;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "getSelection", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "EmptyStickerViewHolder", "MoreStickerViewHolder", "StickerViewHolder", "plugin-emojicapture_release"})
public final class b
  extends RecyclerView.a<a>
{
  public static final String TAG = "MicroMsg.StickerAdapter";
  public static final b.b qbM;
  public final ArrayList<com.tencent.mm.sticker.c> qbF;
  public m<? super Integer, ? super com.tencent.mm.sticker.c, z> qbG;
  public int uT;
  
  static
  {
    AppMethodBeat.i(564);
    qbM = new b.b((byte)0);
    TAG = "MicroMsg.StickerAdapter";
    AppMethodBeat.o(564);
  }
  
  public b()
  {
    AppMethodBeat.i(563);
    this.qbF = new ArrayList();
    this.uT = -1;
    AppMethodBeat.o(563);
  }
  
  public final com.tencent.mm.sticker.c CH(int paramInt)
  {
    AppMethodBeat.i(221769);
    com.tencent.mm.sticker.c localc = (com.tencent.mm.sticker.c)j.F((List)this.qbF, paramInt);
    AppMethodBeat.o(221769);
    return localc;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(559);
    int i = this.qbF.size();
    AppMethodBeat.o(559);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(560);
    Object localObject = CH(paramInt);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.sticker.c)localObject).IFR;; localObject = null)
    {
      locala = f.pYt;
      if (!p.i(localObject, f.clm())) {
        break;
      }
      AppMethodBeat.o(560);
      return 1;
    }
    f.a locala = f.pYt;
    if (!p.i(localObject, f.clo()))
    {
      locala = f.pYt;
      if (!p.i(localObject, f.cln())) {}
    }
    else
    {
      AppMethodBeat.o(560);
      return 2;
    }
    AppMethodBeat.o(560);
    return 0;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public abstract class a
    extends RecyclerView.w
  {
    final TextView jsW;
    final ImageView ka;
    
    public a()
    {
      super();
      this.ka = ((ImageView)localObject.findViewById(2131299351));
      this.jsW = ((TextView)localObject.findViewById(2131299352));
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(551);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          int i = this.qbO.lN();
          paramAnonymousView = this.qbO.qbN.CH(i);
          if (paramAnonymousView != null)
          {
            localObject = this.qbO.qbN.qbG;
            if (localObject != null) {
              ((m)localObject).p(Integer.valueOf(i), paramAnonymousView);
            }
          }
          localObject.requestFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(551);
        }
      });
    }
    
    public abstract void c(bus parambus);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class c
    extends b.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(553);
      AppMethodBeat.o(553);
    }
    
    public final void c(bus parambus)
    {
      AppMethodBeat.i(552);
      p.h(parambus, "info");
      parambus = this.ka;
      p.g(parambus, "icon");
      Object localObject = this.ka;
      p.g(localObject, "icon");
      localObject = ((ImageView)localObject).getContext();
      p.g(localObject, "icon.context");
      com.tencent.mm.plugin.emojicapture.ui.c.a(parambus, 2131690610, ((Context)localObject).getResources().getColor(2131099732));
      this.jsW.setText(2131758231);
      AppMethodBeat.o(552);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$MoreStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class d
    extends b.a
  {
    public d()
    {
      super(localObject);
      AppMethodBeat.i(555);
      AppMethodBeat.o(555);
    }
    
    public final void c(bus parambus)
    {
      AppMethodBeat.i(554);
      p.h(parambus, "info");
      Object localObject = f.pYt;
      if (p.i(parambus, f.clo()))
      {
        parambus = this.auu;
        p.g(parambus, "itemView");
        parambus.setVisibility(4);
        AppMethodBeat.o(554);
        return;
      }
      parambus = this.auu;
      p.g(parambus, "itemView");
      parambus.setVisibility(0);
      parambus = this.ka;
      p.g(parambus, "icon");
      localObject = this.ka;
      p.g(localObject, "icon");
      localObject = ((ImageView)localObject).getContext();
      p.g(localObject, "icon.context");
      com.tencent.mm.plugin.emojicapture.ui.c.a(parambus, 2131690436, ((Context)localObject).getResources().getColor(2131099732));
      this.jsW.setText(2131758230);
      AppMethodBeat.o(554);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class e
    extends b.a
  {
    public e()
    {
      super(localObject);
      AppMethodBeat.i(557);
      AppMethodBeat.o(557);
    }
    
    public final void c(bus parambus)
    {
      AppMethodBeat.i(556);
      p.h(parambus, "info");
      Object localObject = h.IHc;
      localObject = h.getLoader().bI(new com.tencent.mm.sticker.loader.a(parambus));
      ImageView localImageView = this.ka;
      p.g(localImageView, "icon");
      ((com.tencent.mm.loader.a.b)localObject).c(localImageView);
      localObject = this.jsW;
      p.g(localObject, "text");
      ((TextView)localObject).setText((CharSequence)parambus.Name);
      AppMethodBeat.o(556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.b
 * JD-Core Version:    0.7.0.1
 */