package com.tencent.mm.plugin.hld.candidate;

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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mm/plugin/hld/view/ImeOnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder$ICandidateListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder$ICandidateListener;)V", "candidateTv", "Landroid/widget/TextView;", "imeCandidate", "Lcom/tencent/wxhld/info/Candidate;", "mListener", "order", "", "fillContent", "", "oriTextSize", "", "minTextSize", "onClick", "v", "pressTime", "", "(Landroid/view/View;Ljava/lang/Long;)V", "ICandidateListener", "plugin-hld_release"})
public final class d
  extends RecyclerView.v
  implements h
{
  TextView DuP;
  Candidate DuQ;
  final a Duj;
  int order;
  
  public d(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(210174);
    View localView = paramView.findViewById(a.f.candidate_item_tv);
    p.j(localView, "itemView.findViewById(R.id.candidate_item_tv)");
    this.DuP = ((TextView)localView);
    this.Duj = parama;
    this.order = -1;
    parama = g.DIP;
    g.a(paramView, (View.OnClickListener)this);
    AppMethodBeat.o(210174);
  }
  
  public final void j(Long paramLong)
  {
    AppMethodBeat.i(210170);
    if (this.Duj != null)
    {
      Object localObject = this.DuQ;
      if (localObject != null)
      {
        a locala = this.Duj;
        String str = ((Candidate)localObject).text;
        p.j(str, "it.text");
        localObject = ((Candidate)localObject).id;
        p.j(localObject, "it.id");
        int i = this.order;
        if (paramLong != null) {}
        for (long l = paramLong.longValue();; l = 0L)
        {
          locala.a(str, (byte[])localObject, i, l);
          AppMethodBeat.o(210170);
          return;
        }
      }
    }
    AppMethodBeat.o(210170);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(210172);
    j(Long.valueOf(0L));
    AppMethodBeat.o(210172);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder$ICandidateListener;", "", "onClick", "", "text", "", "id", "", "order", "", "pressTime", "", "scrollBy", "distance", "plugin-hld_release"})
  public static abstract interface a
  {
    public abstract void Ur(int paramInt);
    
    public abstract void a(String paramString, byte[] paramArrayOfByte, int paramInt, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.candidate.d
 * JD-Core Version:    0.7.0.1
 */