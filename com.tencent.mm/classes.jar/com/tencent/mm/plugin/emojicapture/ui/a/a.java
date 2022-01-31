package com.tencent.mm.plugin.emojicapture.ui.a;

import a.a.j;
import a.f.a.m;
import a.l;
import a.y;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.a.b;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "getSelection", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "audios", "", "BaseViewHolder", "Companion", "EmptyStickerViewHolder", "StickerViewHolder", "plugin-emojicapture_release"})
public final class a
  extends RecyclerView.a<a.a>
{
  public static final String TAG = "MicroMsg.StickerAdapter";
  private static final int lxS = 1;
  private static final int lxT = 2;
  public static final a.b lxU;
  public final ArrayList<b> lxP;
  public int lxQ;
  public m<? super Integer, ? super b, y> lxR;
  
  static
  {
    AppMethodBeat.i(2943);
    lxU = new a.b((byte)0);
    TAG = "MicroMsg.StickerAdapter";
    lxS = 1;
    lxT = 2;
    AppMethodBeat.o(2943);
  }
  
  public a()
  {
    AppMethodBeat.i(2942);
    this.lxP = new ArrayList();
    this.lxQ = -1;
    AppMethodBeat.o(2942);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(2939);
    int i = this.lxP.size();
    AppMethodBeat.o(2939);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return lxT;
    }
    return lxS;
  }
  
  public final b uQ(int paramInt)
  {
    AppMethodBeat.i(2938);
    b localb = (b)j.w((List)this.lxP, paramInt);
    AppMethodBeat.o(2938);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.a
 * JD-Core Version:    0.7.0.1
 */