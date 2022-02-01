package com.tencent.mm.plugin.finder.profile;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.by;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "", "context", "Landroid/app/Activity;", "outerDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "Lkotlin/collections/ArrayList;", "username", "", "type", "", "(Landroid/app/Activity;Ljava/util/ArrayList;Ljava/lang/String;I)V", "TAG", "getContext", "()Landroid/app/Activity;", "dataList", "Lcom/tencent/mm/plugin/finder/model/FinderTopicInfoFeed;", "getDataList", "()Ljava/util/ArrayList;", "getOuterDataList", "selectListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "selected", "", "getSelectListener", "()Lkotlin/jvm/functions/Function2;", "setSelectListener", "(Lkotlin/jvm/functions/Function2;)V", "getType", "()I", "getUsername", "()Ljava/lang/String;", "view", "Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;", "getView", "()Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;", "setView", "(Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;)V", "genView", "Landroid/view/View;", "refresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private final ArrayList<bxv> FaD;
  public FinderTopicFilterView FaE;
  public m<? super bxv, ? super Boolean, ah> FaF;
  private final String TAG;
  private final Activity hHU;
  final ArrayList<by> pUj;
  final int type;
  private final String username;
  
  public e(Activity paramActivity, ArrayList<bxv> paramArrayList, String paramString, int paramInt)
  {
    AppMethodBeat.i(348193);
    this.hHU = paramActivity;
    this.FaD = paramArrayList;
    this.username = paramString;
    this.type = paramInt;
    this.TAG = "Finder.FinderTopicFilterContract";
    this.pUj = new ArrayList();
    AppMethodBeat.o(348193);
  }
  
  public final void bDL()
  {
    AppMethodBeat.i(348233);
    boolean bool = this.pUj.isEmpty();
    this.pUj.clear();
    Object localObject1 = this.pUj;
    Object localObject2 = (Iterable)this.FaD;
    Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localCollection.add(new by((bxv)((Iterator)localObject2).next(), this.type));
    }
    ((ArrayList)localObject1).addAll((Collection)localCollection);
    if (this.pUj.isEmpty())
    {
      localObject1 = this.FaE;
      if (localObject1 != null) {
        ((FinderTopicFilterView)localObject1).setVisibility(8);
      }
    }
    for (;;)
    {
      localObject1 = this.FaE;
      if (localObject1 != null) {
        ((FinderTopicFilterView)localObject1).bDL();
      }
      Log.i(this.TAG, s.X("refresh, dataList size:", Integer.valueOf(this.pUj.size())));
      if ((bool) && (!this.pUj.isEmpty())) {
        h.OAn.kvStat(21570, s.X(this.username, ",1,"));
      }
      AppMethodBeat.o(348233);
      return;
      localObject1 = this.FaE;
      if (localObject1 != null) {
        ((FinderTopicFilterView)localObject1).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.e
 * JD-Core Version:    0.7.0.1
 */