package com.tencent.mm.plugin.finder.profile;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bl;
import com.tencent.mm.protocal.protobuf.bds;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "", "context", "Landroid/app/Activity;", "outerDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "Lkotlin/collections/ArrayList;", "username", "", "(Landroid/app/Activity;Ljava/util/ArrayList;Ljava/lang/String;)V", "TAG", "getContext", "()Landroid/app/Activity;", "dataList", "Lcom/tencent/mm/plugin/finder/model/FinderTopicInfoFeed;", "getDataList", "()Ljava/util/ArrayList;", "getOuterDataList", "selectListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "selected", "", "getSelectListener", "()Lkotlin/jvm/functions/Function2;", "setSelectListener", "(Lkotlin/jvm/functions/Function2;)V", "getUsername", "()Ljava/lang/String;", "view", "Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;", "getView", "()Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;", "setView", "(Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;)V", "genView", "Landroid/view/View;", "refresh", "plugin-finder_release"})
public final class b
{
  public final String TAG;
  public final Activity dKq;
  public final ArrayList<bl> kgc;
  public FinderTopicFilterView uZn;
  public m<? super bds, ? super Boolean, x> uZo;
  public final ArrayList<bds> uZp;
  public final String username;
  
  public b(Activity paramActivity, ArrayList<bds> paramArrayList, String paramString)
  {
    AppMethodBeat.i(249992);
    this.dKq = paramActivity;
    this.uZp = paramArrayList;
    this.username = paramString;
    this.TAG = "Finder.FinderTopicFilterContract";
    this.kgc = new ArrayList();
    AppMethodBeat.o(249992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.b
 * JD-Core Version:    0.7.0.1
 */