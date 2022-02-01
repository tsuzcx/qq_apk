package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.core.core.model.j;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveDefinitionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveDefinitionAdapter$DefinitionViewHolder;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveDefinitionAdapter$DefinitionInfo;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "itemClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/live/core/core/model/LiveUrlInfo;", "Lkotlin/ParameterName;", "name", "liveUrlInfo", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetChooser", "Companion", "DefinitionInfo", "DefinitionViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends RecyclerView.a<c>
{
  public static final l.a DQu;
  public kotlin.g.a.b<? super j, ah> nod;
  public LinkedList<b> vEn;
  
  static
  {
    AppMethodBeat.i(358569);
    DQu = new l.a((byte)0);
    AppMethodBeat.o(358569);
  }
  
  public l()
  {
    AppMethodBeat.i(358546);
    this.vEn = new LinkedList();
    AppMethodBeat.o(358546);
  }
  
  private static final void a(b paramb, l paraml, View paramView)
  {
    AppMethodBeat.i(358560);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paraml);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveDefinitionAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$definitionInfo");
    s.u(paraml, "this$0");
    Log.i("FinderLiveDefinitionAdapter", s.X("item click:", paramb));
    if (!paramb.DQw)
    {
      paraml = paraml.nod;
      if (paraml != null) {
        paraml.invoke(paramb.DQv);
      }
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveDefinitionAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358560);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358587);
    int i = this.vEn.size();
    AppMethodBeat.o(358587);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveDefinitionAdapter$DefinitionInfo;", "", "liveUrlInfo", "Lcom/tencent/mm/live/core/core/model/LiveUrlInfo;", "chooser", "", "(Lcom/tencent/mm/live/core/core/model/LiveUrlInfo;Z)V", "getChooser", "()Z", "setChooser", "(Z)V", "getLiveUrlInfo", "()Lcom/tencent/mm/live/core/core/model/LiveUrlInfo;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public final j DQv;
    boolean DQw;
    
    public b(j paramj, boolean paramBoolean)
    {
      AppMethodBeat.i(358861);
      this.DQv = paramj;
      this.DQw = paramBoolean;
      AppMethodBeat.o(358861);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(358878);
      if (this == paramObject)
      {
        AppMethodBeat.o(358878);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(358878);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.DQv, paramObject.DQv))
      {
        AppMethodBeat.o(358878);
        return false;
      }
      if (this.DQw != paramObject.DQw)
      {
        AppMethodBeat.o(358878);
        return false;
      }
      AppMethodBeat.o(358878);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(358867);
      String str = "liveUrlInfo:" + this.DQv + ", chooser:" + this.DQw;
      AppMethodBeat.o(358867);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveDefinitionAdapter$DefinitionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveDefinitionAdapter;Landroid/view/View;)V", "chooser", "Landroid/widget/ImageView;", "getChooser", "()Landroid/widget/ImageView;", "setChooser", "(Landroid/widget/ImageView;)V", "definition", "Landroid/widget/TextView;", "getDefinition", "()Landroid/widget/TextView;", "setDefinition", "(Landroid/widget/TextView;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.v
  {
    TextView DQx;
    ImageView DQy;
    
    public c()
    {
      super();
      AppMethodBeat.i(358866);
      this$1 = localObject.findViewById(p.e.BCE);
      s.s(l.this, "itemView.findViewById(R.id.definition_tv)");
      this.DQx = ((TextView)l.this);
      this$1 = localObject.findViewById(p.e.BCB);
      s.s(l.this, "itemView.findViewById(R.id.definition_choose)");
      this.DQy = ((ImageView)l.this);
      AppMethodBeat.o(358866);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.l
 * JD-Core Version:    0.7.0.1
 */