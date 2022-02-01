package com.tencent.mm.plugin.emojicapture.ui.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.model.a.f;
import com.tencent.mm.plugin.emojicapture.model.a.f.a;
import com.tencent.mm.plugin.emojicapture.ui.capture.StickerSelectFrame;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.sticker.c;
import com.tencent.mm.sticker.loader.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBindListener", "Lkotlin/Function1;", "getOnBindListener", "()Lkotlin/jvm/functions/Function1;", "setOnBindListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "EndViewHolder", "StickerViewHolder", "TitleViewHolder", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends RecyclerView.a<a>
{
  public static final String TAG;
  public static final a.b ykv;
  private int dyx;
  public final ArrayList<c> ykw;
  public m<? super Integer, ? super c, ah> ykx;
  public kotlin.g.a.b<? super Integer, ah> yky;
  
  static
  {
    AppMethodBeat.i(550);
    ykv = new a.b((byte)0);
    TAG = "MicroMsg.MoreStickerAdapter";
    AppMethodBeat.o(550);
  }
  
  public a()
  {
    AppMethodBeat.i(549);
    this.ykw = new ArrayList();
    this.dyx = -1;
    AppMethodBeat.o(549);
  }
  
  public final c KX(int paramInt)
  {
    AppMethodBeat.i(269430);
    c localc = (c)p.ae((List)this.ykw, paramInt);
    AppMethodBeat.o(269430);
    return localc;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(545);
    int i = this.ykw.size();
    AppMethodBeat.o(545);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(546);
    Object localObject = KX(paramInt);
    if (localObject == null)
    {
      localObject = null;
      locala = f.yhn;
      if (!s.p(localObject, f.dEp())) {
        break label55;
      }
    }
    for (boolean bool = true;; bool = s.p(localObject, f.dEr()))
    {
      if (!bool) {
        break label71;
      }
      AppMethodBeat.o(546);
      return 1;
      localObject = ((c)localObject).acBO;
      break;
      label55:
      locala = f.yhn;
    }
    label71:
    f.a locala = f.yhn;
    if (s.p(localObject, f.dEq()))
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
    if (this.dyx != paramInt)
    {
      fV(this.dyx);
      this.dyx = paramInt;
      fV(this.dyx);
    }
    AppMethodBeat.o(543);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public abstract class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
    }
    
    public abstract void c(dhp paramdhp);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$EndViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends a.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(537);
      AppMethodBeat.o(537);
    }
    
    public final void c(dhp paramdhp)
    {
      AppMethodBeat.i(536);
      s.u(paramdhp, "info");
      AppMethodBeat.o(536);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "frame", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "kotlin.jvm.PlatformType", "getFrame", "()Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends a.a
  {
    private final ImageView dpM;
    private final TextView wdg;
    private final StickerSelectFrame ykA;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(540);
      this.dpM = ((ImageView)localObject.findViewById(a.f.yeI));
      this.wdg = ((TextView)localObject.findViewById(a.f.yeJ));
      this.ykA = ((StickerSelectFrame)localObject.findViewById(a.f.yeO));
      localObject.setOnClickListener(new a.d..ExternalSyntheticLambda0(this, a.this));
      AppMethodBeat.o(540);
    }
    
    private static final void a(d paramd, a parama, View paramView)
    {
      AppMethodBeat.i(269425);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramd);
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$StickerViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramd, "this$0");
      s.u(parama, "this$1");
      int i = paramd.KJ();
      paramd = parama.KX(i);
      if (paramd != null)
      {
        parama = parama.ykx;
        if (parama != null) {
          parama.invoke(Integer.valueOf(i), paramd);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$StickerViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269425);
    }
    
    public final void c(dhp paramdhp)
    {
      AppMethodBeat.i(539);
      s.u(paramdhp, "info");
      Object localObject = h.acCW;
      localObject = h.getLoader().dk(new com.tencent.mm.sticker.loader.a(paramdhp));
      ImageView localImageView = this.dpM;
      s.s(localImageView, "icon");
      ((com.tencent.mm.loader.a.b)localObject).d(localImageView);
      this.wdg.setText((CharSequence)paramdhp.IGU);
      this.ykA.app(paramdhp.LensId);
      AppMethodBeat.o(539);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$TitleViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class e
    extends a.a
  {
    public e()
    {
      super(localObject);
      AppMethodBeat.i(542);
      AppMethodBeat.o(542);
    }
    
    public final void c(dhp paramdhp)
    {
      AppMethodBeat.i(541);
      s.u(paramdhp, "info");
      TextView localTextView = (TextView)this.caK.findViewById(a.f.yeJ);
      f.a locala = f.yhn;
      if (s.p(paramdhp, f.dEp()))
      {
        localTextView.setText(a.i.yfP);
        AppMethodBeat.o(541);
        return;
      }
      locala = f.yhn;
      if (s.p(paramdhp, f.dEr())) {
        localTextView.setText(a.i.yfS);
      }
      AppMethodBeat.o(541);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.a
 * JD-Core Version:    0.7.0.1
 */