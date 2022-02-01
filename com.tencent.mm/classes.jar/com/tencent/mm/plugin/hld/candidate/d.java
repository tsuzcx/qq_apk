package com.tencent.mm.plugin.hld.candidate;

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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mm/plugin/hld/view/ImeOnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder$ICandidateListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder$ICandidateListener;)V", "candidateTv", "Landroid/widget/TextView;", "imeCandidate", "Lcom/tencent/wxhld/info/Candidate;", "mListener", "order", "", "fillContent", "", "oriTextSize", "", "minTextSize", "onClick", "v", "pressTime", "", "(Landroid/view/View;Ljava/lang/Long;)V", "ICandidateListener", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends RecyclerView.v
  implements g
{
  final a JnI;
  TextView Jol;
  Candidate Jom;
  int order;
  
  public d(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(312844);
    View localView = paramView.findViewById(a.f.candidate_item_tv);
    s.s(localView, "itemView.findViewById(R.id.candidate_item_tv)");
    this.Jol = ((TextView)localView);
    this.JnI = parama;
    this.order = -1;
    f.JzR.a(paramView, (View.OnClickListener)this);
    AppMethodBeat.o(312844);
  }
  
  public final void k(Long paramLong)
  {
    AppMethodBeat.i(312850);
    Object localObject;
    a locala;
    String str;
    int i;
    if (this.JnI != null)
    {
      localObject = this.Jom;
      if (localObject != null)
      {
        locala = this.JnI;
        str = ((Candidate)localObject).text;
        s.s(str, "it.text");
        localObject = ((Candidate)localObject).id;
        s.s(localObject, "it.id");
        i = this.order;
        if (paramLong != null) {
          break label87;
        }
      }
    }
    label87:
    for (long l = 0L;; l = paramLong.longValue())
    {
      locala.a(str, (byte[])localObject, i, l);
      AppMethodBeat.o(312850);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(312856);
    k(Long.valueOf(0L));
    AppMethodBeat.o(312856);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder$ICandidateListener;", "", "onClick", "", "text", "", "id", "", "order", "", "pressTime", "", "scrollBy", "distance", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void Yn(int paramInt);
    
    public abstract void a(String paramString, byte[] paramArrayOfByte, int paramInt, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.candidate.d
 * JD-Core Version:    0.7.0.1
 */