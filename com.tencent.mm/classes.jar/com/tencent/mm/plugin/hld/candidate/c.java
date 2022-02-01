package com.tencent.mm.plugin.hld.candidate;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxhld.info.Candidate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder;", "candidateList", "Ljava/util/ArrayList;", "Lcom/tencent/wxhld/info/Candidate;", "listener", "Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder$ICandidateListener;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder$ICandidateListener;)V", "mListener", "minTextSize", "", "getMinTextSize", "()F", "minTextSize$delegate", "Lkotlin/Lazy;", "oriTextSize", "getOriTextSize", "oriTextSize$delegate", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.a<d>
{
  public static final c.a JnH;
  private final d.a JnI;
  private final j JnJ;
  private final j JnK;
  private final ArrayList<Candidate> Jns;
  
  static
  {
    AppMethodBeat.i(312869);
    JnH = new c.a((byte)0);
    AppMethodBeat.o(312869);
  }
  
  public c(ArrayList<Candidate> paramArrayList, d.a parama)
  {
    AppMethodBeat.i(312858);
    this.Jns = paramArrayList;
    this.JnI = parama;
    this.JnJ = k.cm((a)c.JnM);
    this.JnK = k.cm((a)b.JnL);
    AppMethodBeat.o(312858);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(312877);
    int i = this.Jns.size();
    AppMethodBeat.o(312877);
    return i;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Float>
  {
    public static final b JnL;
    
    static
    {
      AppMethodBeat.i(312861);
      JnL = new b();
      AppMethodBeat.o(312861);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<Float>
  {
    public static final c JnM;
    
    static
    {
      AppMethodBeat.i(312851);
      JnM = new c();
      AppMethodBeat.o(312851);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.candidate.c
 * JD-Core Version:    0.7.0.1
 */