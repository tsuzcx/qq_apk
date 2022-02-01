package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter$MusicEditViewHolder;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "curPlayItem", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "getCurPlayItem", "()Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "setCurPlayItem", "(Lcom/tencent/mm/plugin/finder/live/model/MusicItem;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "itemClickListener", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "pos", "musicItem", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function3;", "setItemClickListener", "(Lkotlin/jvm/functions/Function3;)V", "nextPlayItem", "getNextPlayItem", "setNextPlayItem", "songIdList", "Ljava/util/LinkedList;", "getSongIdList", "()Ljava/util/LinkedList;", "setSongIdList", "(Ljava/util/LinkedList;)V", "deleteMusicItems", "getItemCount", "haveSelectMusic", "", "moveMusicItem", "from", "to", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "onItemClickListener", "printInfo", "list", "tag", "resetSelectMusicItems", "selectAllMusicItems", "updateMusicList", "MusicEditViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends RecyclerView.a<a>
{
  public LinkedList<Integer> CDG;
  public q<? super View, ? super Integer, ? super at, ah> DPR;
  private at DPZ;
  public at DQa;
  public final String TAG;
  public ArrayList<at> pUj;
  
  public f()
  {
    AppMethodBeat.i(358574);
    this.TAG = "FinderLiveAnchorMusicEditAdapter";
    this.CDG = new LinkedList();
    this.pUj = new ArrayList();
    this.DQa = this.DPZ;
    AppMethodBeat.o(358574);
  }
  
  private static final void a(f paramf, a parama, int paramInt, at paramat, View paramView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(358605);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramf);
    localb.cH(parama);
    localb.sc(paramInt);
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    s.u(parama, "$holder");
    s.u(paramat, "$musicItem");
    if (!paramat.CIw)
    {
      bool1 = true;
      paramat.CIw = bool1;
      paramView = parama.checkBox;
      if (paramat.CIw != true) {
        break label197;
      }
    }
    label197:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramView.setChecked(bool1);
      paramf = paramf.DPR;
      if (paramf != null)
      {
        parama = parama.caK;
        s.s(parama, "holder.itemView");
        paramf.invoke(parama, Integer.valueOf(paramInt), paramat);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(358605);
      return;
      bool1 = false;
      break;
    }
  }
  
  private final void e(ArrayList<at> paramArrayList, String paramString)
  {
    AppMethodBeat.i(358589);
    Object localObject = aw.Gjk;
    if (aw.bgV())
    {
      paramString = new StringBuilder(s.X(paramString, "(MusicList):"));
      if (paramArrayList != null)
      {
        paramArrayList = ((Iterable)paramArrayList).iterator();
        int i = 0;
        while (paramArrayList.hasNext())
        {
          localObject = paramArrayList.next();
          if (i < 0) {
            p.kkW();
          }
          localObject = (at)localObject;
          paramString.append("[" + i + ',' + localObject + ']');
          i += 1;
        }
      }
      Log.i(this.TAG, paramString.toString());
    }
    AppMethodBeat.o(358589);
  }
  
  public final void a(LinkedList<Integer> paramLinkedList, ArrayList<at> paramArrayList, at paramat)
  {
    AppMethodBeat.i(358620);
    s.u(paramLinkedList, "songIdList");
    s.u(paramArrayList, "dataList");
    this.CDG.clear();
    this.CDG.addAll((Collection)paramLinkedList);
    this.pUj.clear();
    this.pUj.addAll((Collection)paramArrayList);
    this.DPZ = paramat;
    this.DQa = paramat;
    AppMethodBeat.o(358620);
  }
  
  public final void eke()
  {
    AppMethodBeat.i(358635);
    Iterator localIterator = ((Iterable)this.pUj).iterator();
    while (localIterator.hasNext()) {
      ((at)localIterator.next()).CIw = false;
    }
    AppMethodBeat.o(358635);
  }
  
  public final void evJ()
  {
    AppMethodBeat.i(358631);
    Iterator localIterator = ((Iterable)this.pUj).iterator();
    while (localIterator.hasNext()) {
      ((at)localIterator.next()).CIw = true;
    }
    AppMethodBeat.o(358631);
  }
  
  public final ArrayList<Integer> evK()
  {
    AppMethodBeat.i(358651);
    ArrayList localArrayList = new ArrayList();
    label316:
    label319:
    for (;;)
    {
      int i;
      int k;
      try
      {
        Iterator localIterator = this.pUj.iterator();
        s.s(localIterator, "dataList.iterator()");
        int j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          localObject2 = localIterator.next();
          s.s(localObject2, "iterator.next()");
          localObject2 = (at)localObject2;
          if (((at)localObject2).CIw)
          {
            localIterator.remove();
            localArrayList.add(Integer.valueOf(((at)localObject2).CIu.ZTv));
            k = ((at)localObject2).CIu.ZTv;
            localObject2 = this.DQa;
            if (localObject2 == null) {
              break label316;
            }
            localObject2 = ((at)localObject2).CIu;
            if ((localObject2 == null) || (k != ((bkh)localObject2).ZTv)) {
              break label316;
            }
            k = 1;
          }
          else
          {
            if ((i == 0) || (j != 0)) {
              continue;
            }
            this.DQa = ((at)localObject2);
            j = 1;
          }
        }
        else
        {
          if ((i != 0) && (j == 0)) {
            this.DQa = ((at)p.oL((List)this.pUj));
          }
          this.CDG.removeAll((Collection)localArrayList);
          Log.i(this.TAG, "curPlayItem:" + this.DPZ + ", nextPlayItem:" + this.DQa);
          e(this.pUj, "deleteMusicItems");
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = aw.Gjk;
        aw.a(localException, s.X(this.TAG, ",deleteMusicItems:"));
      }
      finally
      {
        AppMethodBeat.o(358651);
        return localArrayList;
      }
      for (;;)
      {
        if (k == 0) {
          break label319;
        }
        i = 1;
        break;
        k = 0;
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358656);
    int i = this.pUj.size();
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.hQ(this.TAG, s.X("getItemCount ", Integer.valueOf(i)));
    AppMethodBeat.o(358656);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter$MusicEditViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter;Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "musicName", "Landroid/widget/TextView;", "getMusicName", "()Landroid/widget/TextView;", "setMusicName", "(Landroid/widget/TextView;)V", "singer", "getSinger", "setSinger", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    TextView DPW;
    TextView DPX;
    CheckBox checkBox;
    
    public a()
    {
      super();
      AppMethodBeat.i(358941);
      this.checkBox = ((CheckBox)localObject.findViewById(p.e.BYh));
      this.DPW = ((TextView)localObject.findViewById(p.e.BYt));
      this.DPX = ((TextView)localObject.findViewById(p.e.Cbi));
      AppMethodBeat.o(358941);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.f
 * JD-Core Version:    0.7.0.1
 */