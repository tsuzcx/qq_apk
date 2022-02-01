package com.tencent.mm.plugin.hld.alternative;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.view.g;
import com.tencent.mm.plugin.hld.view.h;
import com.tencent.wxhld.info.Candidate;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mm/plugin/hld/view/ImeOnClickListener;", "itemView", "Landroid/view/View;", "mListener", "Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder$IAlternativeWordViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder$IAlternativeWordViewListener;)V", "candidate", "Lcom/tencent/wxhld/info/Candidate;", "order", "", "symbolKeyBt", "Landroid/widget/TextView;", "fillContent", "", "fillFooter", "footView", "onClick", "v", "pressTime", "", "(Landroid/view/View;Ljava/lang/Long;)V", "IAlternativeWordViewListener", "plugin-hld_release"})
public final class e
  extends RecyclerView.v
  implements h
{
  private final a DtR;
  TextView Dub;
  Candidate Duc;
  int order;
  
  public e(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(211066);
    this.DtR = parama;
    parama = paramView.findViewById(a.f.s5_grid_key_text);
    p.j(parama, "itemView.findViewById(R.id.s5_grid_key_text)");
    this.Dub = ((TextView)parama);
    this.order = -1;
    parama = g.DIP;
    g.a(paramView, (View.OnClickListener)this);
    AppMethodBeat.o(211066);
  }
  
  public final void j(Long paramLong)
  {
    AppMethodBeat.i(211064);
    a locala = this.DtR;
    if (locala != null)
    {
      Object localObject1 = this.Duc;
      if (localObject1 != null)
      {
        localObject2 = ((Candidate)localObject1).text;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      Object localObject2 = this.Duc;
      if (localObject2 != null)
      {
        byte[] arrayOfByte = ((Candidate)localObject2).id;
        localObject2 = arrayOfByte;
        if (arrayOfByte != null) {}
      }
      else
      {
        localObject2 = new byte[0];
      }
      int i = this.order;
      if (paramLong != null) {}
      for (long l = paramLong.longValue();; l = 0L)
      {
        locala.a((String)localObject1, (byte[])localObject2, i, l);
        AppMethodBeat.o(211064);
        return;
      }
    }
    AppMethodBeat.o(211064);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(211065);
    j(Long.valueOf(0L));
    AppMethodBeat.o(211065);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder$IAlternativeWordViewListener;", "", "onClick", "", "text", "", "id", "", "order", "", "pressTime", "", "plugin-hld_release"})
  public static abstract interface a
  {
    public abstract void a(String paramString, byte[] paramArrayOfByte, int paramInt, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.alternative.e
 * JD-Core Version:    0.7.0.1
 */