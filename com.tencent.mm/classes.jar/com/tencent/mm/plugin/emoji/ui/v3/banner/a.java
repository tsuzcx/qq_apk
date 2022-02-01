package com.tencent.mm.plugin.emoji.ui.v3.banner;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.mgr.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerViewHolder;", "context", "Landroid/content/Context;", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/emoji/model/BaseEmotionBanner;", "(Landroid/content/Context;Ljava/util/LinkedList;)V", "TAG", "", "adUrlList", "Ljava/util/ArrayList;", "getContext", "()Landroid/content/Context;", "getData", "()Ljava/util/LinkedList;", "setData", "(Ljava/util/LinkedList;)V", "mIImageLoaderListener", "Lcom/tencent/mm/plugin/emoji/ui/v3/banner/ImageLoaderListener;", "clear", "", "getItemCount", "", "handleBannerData", "", "emotionBannerList", "Lcom/tencent/mm/protocal/protobuf/EmotionBanner;", "emotionBannerSetList", "Lcom/tencent/mm/protocal/protobuf/EmotionBannerSet;", "onBannerClick", "banner", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "group", "Landroid/view/ViewGroup;", "setBannerData", "newData", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends RecyclerView.a<d>
{
  public final String TAG;
  private final Context context;
  public LinkedList<com.tencent.mm.plugin.emoji.model.b> yaU;
  public final ArrayList<String> yaV;
  public final e yaW;
  
  public a(Context paramContext, LinkedList<com.tencent.mm.plugin.emoji.model.b> paramLinkedList)
  {
    AppMethodBeat.i(270573);
    this.context = paramContext;
    this.yaU = paramLinkedList;
    this.TAG = "MicroMsg.EmojiStoreV3BannerAdapter";
    this.yaV = new ArrayList();
    this.yaW = new e();
    this.yaW.ybz = this;
    AppMethodBeat.o(270573);
  }
  
  private static final void a(a parama, int paramInt, View paramView)
  {
    AppMethodBeat.i(270595);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    Log.d(parama.TAG, s.X("click banner item pos: ", Integer.valueOf(paramInt)));
    paramView = (com.tencent.mm.plugin.emoji.model.b)parama.yaU.get(paramInt);
    if (paramView != null)
    {
      if (!paramView.xMp) {
        break label138;
      }
      k.a(parama.context, paramView.xMn, true);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(270595);
      return;
      label138:
      paramView = paramView.xMo.akjR;
      s.s(paramView, "banner.banner.BannerSummary");
      Log.d(parama.TAG, s.X("banner productId: ", paramView.ProductID));
      h.OAn.b(11929, new Object[] { Integer.valueOf(0) });
      k.a(parama.context, paramView, 15, -1, -1, "", 8);
    }
  }
  
  public static List<com.tencent.mm.plugin.emoji.model.b> s(List<? extends anh> paramList, List<? extends anj> paramList1)
  {
    AppMethodBeat.i(270583);
    LinkedList localLinkedList = new LinkedList();
    Object localObject;
    if (paramList != null)
    {
      localObject = paramList.iterator();
      label95:
      while (((Iterator)localObject).hasNext())
      {
        anh localanh = (anh)((Iterator)localObject).next();
        if (localanh == null) {}
        for (paramList = null;; paramList = localanh.akjS)
        {
          if ((paramList == null) || (Util.isNullOrNil(localanh.akjS.akjT))) {
            break label95;
          }
          localLinkedList.add(new com.tencent.mm.plugin.emoji.model.b(localanh, null, false));
          break;
        }
      }
    }
    if (paramList1 != null)
    {
      paramList1 = paramList1.iterator();
      label174:
      while (paramList1.hasNext())
      {
        localObject = (anj)paramList1.next();
        if (localObject == null) {}
        for (paramList = null;; paramList = ((anj)localObject).akjS)
        {
          if ((paramList == null) || (Util.isNullOrNil(((anj)localObject).akjS.akjT))) {
            break label174;
          }
          localLinkedList.add(new com.tencent.mm.plugin.emoji.model.b(null, (anj)localObject, true));
          break;
        }
      }
    }
    paramList = (List)localLinkedList;
    AppMethodBeat.o(270583);
    return paramList;
  }
  
  public final void fh(List<? extends com.tencent.mm.plugin.emoji.model.b> paramList)
  {
    AppMethodBeat.i(270617);
    s.u(paramList, "newData");
    int i;
    Object localObject1;
    Collection localCollection;
    label79:
    Object localObject3;
    com.tencent.mm.plugin.emoji.model.b localb;
    label133:
    Object localObject2;
    if (!((Collection)this.yaU).isEmpty())
    {
      i = 1;
      if ((i == 0) || (paramList.size() != this.yaU.size())) {
        break label472;
      }
      localObject1 = (Iterable)paramList;
      localCollection = (Collection)new ArrayList();
      Iterator localIterator = ((Iterable)localObject1).iterator();
      i = 0;
      if (!localIterator.hasNext()) {
        break label407;
      }
      localObject3 = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      localb = (com.tencent.mm.plugin.emoji.model.b)localObject3;
      localObject1 = (com.tencent.mm.plugin.emoji.model.b)this.yaU.get(i);
      if (localObject1 != null) {
        break label218;
      }
      localObject1 = null;
      if (localb != null) {
        break label264;
      }
      localObject2 = null;
      label141:
      if (s.p(localObject1, localObject2))
      {
        localObject1 = (com.tencent.mm.plugin.emoji.model.b)this.yaU.get(i);
        if (localObject1 != null) {
          break label310;
        }
        localObject1 = null;
        label172:
        if (localb != null) {
          break label356;
        }
        localObject2 = null;
        label180:
        if (s.p(localObject1, localObject2)) {
          break label402;
        }
      }
    }
    label264:
    label402:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        localCollection.add(localObject3);
      }
      i += 1;
      break label79;
      i = 0;
      break;
      label218:
      localObject1 = ((com.tencent.mm.plugin.emoji.model.b)localObject1).xMo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label133;
      }
      localObject1 = ((anh)localObject1).akjS;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label133;
      }
      localObject1 = ((ani)localObject1).akjT;
      break label133;
      localObject2 = localb.xMo;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label141;
      }
      localObject2 = ((anh)localObject2).akjS;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label141;
      }
      localObject2 = ((ani)localObject2).akjT;
      break label141;
      label310:
      localObject1 = ((com.tencent.mm.plugin.emoji.model.b)localObject1).xMn;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label172;
      }
      localObject1 = ((anj)localObject1).akjS;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label172;
      }
      localObject1 = ((ani)localObject1).akjT;
      break label172;
      label356:
      localObject2 = localb.xMn;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label180;
      }
      localObject2 = ((anj)localObject2).akjS;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label180;
      }
      localObject2 = ((ani)localObject2).akjT;
      break label180;
    }
    label407:
    if (!((Collection)localCollection).isEmpty()) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        this.yaU.clear();
        this.yaU.addAll((Collection)paramList);
        by(0, this.yaU.size());
      }
      AppMethodBeat.o(270617);
      return;
      i = 0;
      continue;
      label472:
      if (!((Collection)paramList).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label500;
        }
        i = 1;
        break;
      }
      label500:
      i = 0;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(270603);
    int i = this.yaU.size();
    AppMethodBeat.o(270603);
    return i;
  }
  
  public final void r(List<? extends anh> paramList, List<? extends anj> paramList1)
  {
    AppMethodBeat.i(270609);
    if ((paramList == null) && (paramList1 == null))
    {
      AppMethodBeat.o(270609);
      return;
    }
    fh(s(paramList, paramList1));
    AppMethodBeat.o(270609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.banner.a
 * JD-Core Version:    0.7.0.1
 */