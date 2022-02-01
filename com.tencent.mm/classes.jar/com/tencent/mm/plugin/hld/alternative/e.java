package com.tencent.mm.plugin.hld.alternative;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.view.f;
import com.tencent.mm.plugin.hld.view.g;
import com.tencent.wxhld.info.Candidate;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mm/plugin/hld/view/ImeOnClickListener;", "itemView", "Landroid/view/View;", "mListener", "Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder$IAlternativeWordViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder$IAlternativeWordViewListener;)V", "candidate", "Lcom/tencent/wxhld/info/Candidate;", "order", "", "symbolKeyBt", "Landroid/widget/TextView;", "fillContent", "", "fillFooter", "footView", "onClick", "v", "pressTime", "", "(Landroid/view/View;Ljava/lang/Long;)V", "IAlternativeWordViewListener", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends RecyclerView.v
  implements g
{
  Candidate JnA;
  private final a Jnt;
  TextView Jnz;
  int order;
  
  public e(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(311671);
    this.Jnt = parama;
    parama = paramView.findViewById(a.f.s5_grid_key_text);
    s.s(parama, "itemView.findViewById(R.id.s5_grid_key_text)");
    this.Jnz = ((TextView)parama);
    this.order = -1;
    f.JzR.a(paramView, (View.OnClickListener)this);
    AppMethodBeat.o(311671);
  }
  
  public final void k(Long paramLong)
  {
    AppMethodBeat.i(311683);
    a locala = this.Jnt;
    Object localObject1;
    Object localObject2;
    label45:
    Object localObject3;
    int i;
    if (locala != null)
    {
      localObject1 = this.JnA;
      if (localObject1 != null) {
        break label89;
      }
      localObject1 = "";
      localObject2 = this.JnA;
      if (localObject2 != null) {
        break label112;
      }
      localObject2 = null;
      localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = new byte[0];
      }
      i = this.order;
      if (paramLong != null) {
        break label122;
      }
    }
    label89:
    label112:
    label122:
    for (long l = 0L;; l = paramLong.longValue())
    {
      locala.a((String)localObject1, (byte[])localObject3, i, l);
      AppMethodBeat.o(311683);
      return;
      localObject2 = ((Candidate)localObject1).text;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      localObject2 = ((Candidate)localObject2).id;
      break label45;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(311697);
    k(Long.valueOf(0L));
    AppMethodBeat.o(311697);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder$IAlternativeWordViewListener;", "", "onClick", "", "text", "", "id", "", "order", "", "pressTime", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(String paramString, byte[] paramArrayOfByte, int paramInt, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.alternative.e
 * JD-Core Version:    0.7.0.1
 */