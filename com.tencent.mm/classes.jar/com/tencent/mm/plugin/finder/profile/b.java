package com.tencent.mm.plugin.finder.profile;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.br;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "", "context", "Landroid/app/Activity;", "outerDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "Lkotlin/collections/ArrayList;", "username", "", "type", "", "(Landroid/app/Activity;Ljava/util/ArrayList;Ljava/lang/String;I)V", "TAG", "getContext", "()Landroid/app/Activity;", "dataList", "Lcom/tencent/mm/plugin/finder/model/FinderTopicInfoFeed;", "getDataList", "()Ljava/util/ArrayList;", "getOuterDataList", "selectListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "selected", "", "getSelectListener", "()Lkotlin/jvm/functions/Function2;", "setSelectListener", "(Lkotlin/jvm/functions/Function2;)V", "getType", "()I", "getUsername", "()Ljava/lang/String;", "view", "Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;", "getView", "()Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;", "setView", "(Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;)V", "genView", "Landroid/view/View;", "refresh", "plugin-finder_release"})
public final class b
{
  private final String TAG;
  private final Activity fDf;
  final ArrayList<br> mXB;
  private final int type;
  private final String username;
  public FinderTopicFilterView zPH;
  public m<? super bkr, ? super Boolean, x> zPI;
  private final ArrayList<bkr> zPJ;
  
  public b(Activity paramActivity, ArrayList<bkr> paramArrayList, String paramString, int paramInt)
  {
    AppMethodBeat.i(228888);
    this.fDf = paramActivity;
    this.zPJ = paramArrayList;
    this.username = paramString;
    this.type = paramInt;
    this.TAG = "Finder.FinderTopicFilterContract";
    this.mXB = new ArrayList();
    AppMethodBeat.o(228888);
  }
  
  public final void bfU()
  {
    AppMethodBeat.i(228882);
    boolean bool = this.mXB.isEmpty();
    this.mXB.clear();
    Object localObject1 = this.mXB;
    Object localObject2 = (Iterable)this.zPJ;
    Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localCollection.add(new br((bkr)((Iterator)localObject2).next(), this.type));
    }
    ((ArrayList)localObject1).addAll((Collection)localCollection);
    if (this.mXB.isEmpty())
    {
      localObject1 = this.zPH;
      if (localObject1 != null) {
        ((FinderTopicFilterView)localObject1).setVisibility(8);
      }
    }
    for (;;)
    {
      localObject1 = this.zPH;
      if (localObject1 != null) {
        ((FinderTopicFilterView)localObject1).bfU();
      }
      Log.i(this.TAG, "refresh, dataList size:" + this.mXB.size());
      if ((bool) && (!this.mXB.isEmpty())) {
        h.IzE.kvStat(21570, this.username + ",1,");
      }
      AppMethodBeat.o(228882);
      return;
      localObject1 = this.zPH;
      if (localObject1 != null) {
        ((FinderTopicFilterView)localObject1).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.b
 * JD-Core Version:    0.7.0.1
 */