package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.protocal.protobuf.bfh;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$FinderLiveAudienceListFileWrapper;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "onItemClikListener", "Lkotlin/Function0;", "", "getOnItemClikListener", "()Lkotlin/jvm/functions/Function0;", "setOnItemClikListener", "(Lkotlin/jvm/functions/Function0;)V", "bindBottomViewHolder", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$BottomViewHolder;", "position", "", "bindWhiteListViewHolder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$WhiteListViewHolder;", "getItemCount", "getItemData", "pos", "getItemViewType", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateWhiteList", "list", "BottomViewHolder", "Companion", "FinderLiveAudienceListFileWrapper", "WhiteListViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
  extends RecyclerView.a<RecyclerView.v>
{
  public static final b DTR;
  public kotlin.g.a.a<ah> DTS;
  public LinkedList<c> vEn;
  
  static
  {
    AppMethodBeat.i(358801);
    DTR = new b((byte)0);
    AppMethodBeat.o(358801);
  }
  
  public aj()
  {
    AppMethodBeat.i(358783);
    this.vEn = new LinkedList();
    AppMethodBeat.o(358783);
  }
  
  private static final void a(c paramc, d paramd, aj paramaj, View paramView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(358795);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramc);
    localb.cH(paramd);
    localb.cH(paramaj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "$holder");
    s.u(paramaj, "this$0");
    if (paramc != null)
    {
      if ((paramc != null) && (!paramc.CAZ))
      {
        bool1 = true;
        paramc.CAZ = bool1;
      }
    }
    else
    {
      paramd = paramd.DTV;
      if ((paramc == null) || (paramc.CAZ != true)) {
        break label177;
      }
    }
    label177:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramd.setChecked(bool1);
      paramc = paramaj.DTS;
      if (paramc != null) {
        paramc.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(358795);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(358817);
    s.u(paramViewGroup, "parent");
    if (paramInt == 2)
    {
      paramViewGroup = View.inflate(paramViewGroup.getContext(), p.f.Cgk, null);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
      AppMethodBeat.o(358817);
      return paramViewGroup;
    }
    paramViewGroup = View.inflate(paramViewGroup.getContext(), p.f.Cgm, null);
    s.s(paramViewGroup, "itemView");
    paramViewGroup = (RecyclerView.v)new d(paramViewGroup);
    AppMethodBeat.o(358817);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(358842);
    s.u(paramv, "holder");
    int i;
    label60:
    Object localObject1;
    boolean bool;
    if ((paramv instanceof d))
    {
      d locald = (d)paramv;
      if (paramInt < 0) {
        break label163;
      }
      if (paramInt >= this.vEn.size()) {
        break label158;
      }
      i = 1;
      if (i == 0) {
        break label168;
      }
      paramv = (c)this.vEn.get(paramInt);
      localObject1 = locald.DTV;
      if ((paramv == null) || (paramv.CAZ != true)) {
        break label173;
      }
      bool = true;
      label82:
      ((CheckBox)localObject1).setChecked(bool);
      locald.caK.setOnClickListener(new aj..ExternalSyntheticLambda0(paramv, locald, this));
      TextView localTextView = locald.DTW;
      if (paramv != null) {
        break label179;
      }
      localObject1 = null;
      label122:
      localTextView.setText((CharSequence)localObject1);
      localObject1 = locald.DTW;
      if (paramv != null) {
        break label191;
      }
    }
    label158:
    label163:
    label168:
    label173:
    label179:
    label191:
    for (paramv = localObject2;; paramv = paramv.DTU.YPy)
    {
      ((TextView)localObject1).setTag(paramv);
      AppMethodBeat.o(358842);
      return;
      i = 0;
      break;
      i = 0;
      break;
      paramv = null;
      break label60;
      bool = false;
      break label82;
      localObject1 = paramv.DTU.title;
      break label122;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358822);
    int i = this.vEn.size();
    AppMethodBeat.o(358822);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(358828);
    paramInt = ((c)this.vEn.get(paramInt)).type;
    AppMethodBeat.o(358828);
    return paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$BottomViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;Landroid/view/View;)V", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    private TextView dyR;
    
    public a()
    {
      super();
      AppMethodBeat.i(358761);
      this.dyR = ((TextView)localObject.findViewById(p.e.Ccg));
      AppMethodBeat.o(358761);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$Companion;", "", "()V", "TAG", "", "TYPE_BOTTOM", "", "TYPE_NORMAL", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$FinderLiveAudienceListFileWrapper;", "", "choose", "", "audienceFile", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "type", "", "(ZLcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;I)V", "getAudienceFile", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getChoose", "()Z", "setChoose", "(Z)V", "getType", "()I", "setType", "(I)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public boolean CAZ;
    public final bfh DTU;
    int type;
    
    public c(boolean paramBoolean, bfh parambfh, int paramInt)
    {
      AppMethodBeat.i(358747);
      this.CAZ = paramBoolean;
      this.DTU = parambfh;
      this.type = paramInt;
      AppMethodBeat.o(358747);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$WhiteListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;Landroid/view/View;)V", "check", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheck", "()Landroid/widget/CheckBox;", "setCheck", "(Landroid/widget/CheckBox;)V", "detail", "Landroid/widget/TextView;", "getDetail", "()Landroid/widget/TextView;", "setDetail", "(Landroid/widget/TextView;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends RecyclerView.v
  {
    CheckBox DTV;
    TextView DTW;
    
    public d()
    {
      super();
      AppMethodBeat.i(358751);
      this.DTV = ((CheckBox)localObject.findViewById(p.e.Cce));
      this.DTW = ((TextView)localObject.findViewById(p.e.Ccj));
      this.DTV.setClickable(false);
      AppMethodBeat.o(358751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.aj
 * JD-Core Version:    0.7.0.1
 */