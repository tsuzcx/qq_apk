package com.tencent.mm.emoji.panel.a;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.b.ag;
import com.tencent.mm.emoji.a.b.i;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;)V", "mData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/PanelTab;", "onItemClickListener", "Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$OnItemClickListener;", "selectedPosition", "", "getItem", "position", "getItemCount", "getItemId", "", "getItemViewType", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "setSelection", "update", "data", "", "Companion", "OnItemClickListener", "ViewHolder", "plugin-emojisdk_release"})
public final class x
  extends RecyclerView.a<x.c>
{
  public static final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyTabAdapter";
  public static final x.a gqD;
  private final i gni;
  public x.b gqC;
  public final ArrayList<ag> mData;
  private int uT;
  
  static
  {
    AppMethodBeat.i(105703);
    gqD = new x.a((byte)0);
    TAG = "MicroMsg.emoji.SmileyPanel.SmileyTabAdapter";
    AppMethodBeat.o(105703);
  }
  
  public x(i parami)
  {
    AppMethodBeat.i(105702);
    this.gni = parami;
    this.mData = new ArrayList();
    this.uT = -1;
    AppMethodBeat.o(105702);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105698);
    int i = this.mData.size();
    AppMethodBeat.o(105698);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105699);
    ag localag = mh(paramInt);
    if (localag == null) {
      p.gkB();
    }
    paramInt = localag.type;
    AppMethodBeat.o(105699);
    return paramInt;
  }
  
  public final ag mh(int paramInt)
  {
    AppMethodBeat.i(105697);
    if ((this.mData.isEmpty()) || (this.mData.size() < paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(105697);
      return null;
    }
    ag localag = (ag)this.mData.get(paramInt);
    AppMethodBeat.o(105697);
    return localag;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(105696);
    ae.i(TAG, "setSelection: %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.uT != paramInt)
    {
      cj(this.uT);
      this.uT = paramInt;
      cj(this.uT);
    }
    AppMethodBeat.o(105696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.x
 * JD-Core Version:    0.7.0.1
 */