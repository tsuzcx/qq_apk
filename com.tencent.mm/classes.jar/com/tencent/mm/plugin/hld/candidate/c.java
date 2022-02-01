package com.tencent.mm.plugin.hld.candidate;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxhld.info.Candidate;
import java.util.ArrayList;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder;", "candidateList", "Ljava/util/ArrayList;", "Lcom/tencent/wxhld/info/Candidate;", "listener", "Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder$ICandidateListener;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder$ICandidateListener;)V", "mListener", "minTextSize", "", "getMinTextSize", "()F", "minTextSize$delegate", "Lkotlin/Lazy;", "oriTextSize", "getOriTextSize", "oriTextSize$delegate", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "Companion", "plugin-hld_release"})
public final class c
  extends RecyclerView.a<d>
{
  public static final a Dum;
  private final ArrayList<Candidate> DtS;
  private final d.a Duj;
  private final f Duk;
  private final f Dul;
  
  static
  {
    AppMethodBeat.i(209412);
    Dum = new a((byte)0);
    AppMethodBeat.o(209412);
  }
  
  public c(ArrayList<Candidate> paramArrayList, d.a parama)
  {
    AppMethodBeat.i(209411);
    this.DtS = paramArrayList;
    this.Duj = parama;
    this.Duk = g.ar((a)c.Duo);
    this.Dul = g.ar((a)b.Dun);
    AppMethodBeat.o(209411);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(209410);
    int i = this.DtS.size();
    AppMethodBeat.o(209410);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateAdapter$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Float>
  {
    public static final b Dun;
    
    static
    {
      AppMethodBeat.i(217400);
      Dun = new b();
      AppMethodBeat.o(217400);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Float>
  {
    public static final c Duo;
    
    static
    {
      AppMethodBeat.i(211453);
      Duo = new c();
      AppMethodBeat.o(211453);
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