package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter$MusicEditViewHolder;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "curPlayItem", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "getCurPlayItem", "()Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "setCurPlayItem", "(Lcom/tencent/mm/plugin/finder/live/model/MusicItem;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "itemClickListener", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "pos", "musicItem", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function3;", "setItemClickListener", "(Lkotlin/jvm/functions/Function3;)V", "nextPlayItem", "getNextPlayItem", "setNextPlayItem", "songIdList", "Ljava/util/LinkedList;", "getSongIdList", "()Ljava/util/LinkedList;", "setSongIdList", "(Ljava/util/LinkedList;)V", "deleteMusicItems", "getItemCount", "haveSelectMusic", "", "moveMusicItem", "from", "to", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "onItemClickListener", "printInfo", "list", "tag", "resetSelectMusicItems", "selectAllMusicItems", "updateMusicList", "MusicEditViewHolder", "plugin-finder_release"})
public final class f
  extends RecyclerView.a<a>
{
  public final String TAG;
  public ArrayList<aq> mXB;
  public q<? super View, ? super Integer, ? super aq, x> yWa;
  private aq yWi;
  public aq yWj;
  public LinkedList<Integer> ydh;
  
  public f()
  {
    AppMethodBeat.i(282658);
    this.TAG = "FinderLiveAnchorMusicEditAdapter";
    this.ydh = new LinkedList();
    this.mXB = new ArrayList();
    this.yWj = this.yWi;
    AppMethodBeat.o(282658);
  }
  
  private final void d(ArrayList<aq> paramArrayList, String paramString)
  {
    AppMethodBeat.i(282652);
    Object localObject = aj.AGc;
    if (aj.eej())
    {
      paramString = new StringBuilder(paramString + "(MusicList):");
      if (paramArrayList != null)
      {
        paramArrayList = ((Iterable)paramArrayList).iterator();
        int i = 0;
        while (paramArrayList.hasNext())
        {
          localObject = paramArrayList.next();
          if (i < 0) {
            j.iBO();
          }
          localObject = (aq)localObject;
          paramString.append("[" + i + ',' + localObject + ']');
          i += 1;
        }
      }
      Log.i(this.TAG, paramString.toString());
    }
    AppMethodBeat.o(282652);
  }
  
  public final void a(LinkedList<Integer> paramLinkedList, ArrayList<aq> paramArrayList, aq paramaq)
  {
    AppMethodBeat.i(282648);
    p.k(paramLinkedList, "songIdList");
    p.k(paramArrayList, "dataList");
    this.ydh.clear();
    this.ydh.addAll((Collection)paramLinkedList);
    this.mXB.clear();
    this.mXB.addAll((Collection)paramArrayList);
    this.yWi = paramaq;
    this.yWj = paramaq;
    AppMethodBeat.o(282648);
  }
  
  public final void dFm()
  {
    AppMethodBeat.i(282649);
    Iterator localIterator = ((Iterable)this.mXB).iterator();
    while (localIterator.hasNext()) {
      ((aq)localIterator.next()).yip = true;
    }
    AppMethodBeat.o(282649);
  }
  
  public final ArrayList<Integer> dFn()
  {
    AppMethodBeat.i(282651);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.mXB.iterator();
        p.j(localIterator, "dataList.iterator()");
        int i = 0;
        int j = 0;
        if (localIterator.hasNext())
        {
          localObject2 = localIterator.next();
          p.j(localObject2, "iterator.next()");
          localObject2 = (aq)localObject2;
          if (((aq)localObject2).yip)
          {
            localIterator.remove();
            localArrayList.add(Integer.valueOf(((aq)localObject2).yin.SMT));
            int k = ((aq)localObject2).yin.SMT;
            localObject2 = this.yWj;
            if (localObject2 != null)
            {
              localObject2 = ((aq)localObject2).yin;
              if (localObject2 != null) {
                if (k == ((bbg)localObject2).SMT) {
                  j = 1;
                }
              }
            }
          }
          else if ((j != 0) && (i == 0))
          {
            this.yWj = ((aq)localObject2);
            i = 1;
          }
        }
        else
        {
          if ((j != 0) && (i == 0)) {
            this.yWj = ((aq)j.lp((List)this.mXB));
          }
          this.ydh.removeAll((Collection)localArrayList);
          Log.i(this.TAG, "curPlayItem:" + this.yWi + ", nextPlayItem:" + this.yWj);
          d(this.mXB, "deleteMusicItems");
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = aj.AGc;
        aj.a(localException, this.TAG + ",deleteMusicItems:");
      }
      finally
      {
        AppMethodBeat.o(282651);
        return localArrayList;
      }
    }
  }
  
  public final void dxP()
  {
    AppMethodBeat.i(282650);
    Iterator localIterator = ((Iterable)this.mXB).iterator();
    while (localIterator.hasNext()) {
      ((aq)localIterator.next()).yip = false;
    }
    AppMethodBeat.o(282650);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(282655);
    int i = this.mXB.size();
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.ha(this.TAG, "getItemCount ".concat(String.valueOf(i)));
    AppMethodBeat.o(282655);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter$MusicEditViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter;Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "musicName", "Landroid/widget/TextView;", "getMusicName", "()Landroid/widget/TextView;", "setMusicName", "(Landroid/widget/TextView;)V", "singer", "getSinger", "setSinger", "plugin-finder_release"})
  public final class a
    extends RecyclerView.v
  {
    CheckBox checkBox;
    TextView yWf;
    TextView yWg;
    
    public a()
    {
      super();
      AppMethodBeat.i(220701);
      this.checkBox = ((CheckBox)localObject.findViewById(b.f.music_edit_checkbox));
      this.yWf = ((TextView)localObject.findViewById(b.f.music_name));
      this.yWg = ((TextView)localObject.findViewById(b.f.singer));
      AppMethodBeat.o(220701);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(f paramf, f.a parama, int paramInt, aq paramaq) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(274690);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      f.a(this.yWk, this.yWl, this.jEN, this.xZa);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(274690);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.f
 * JD-Core Version:    0.7.0.1
 */