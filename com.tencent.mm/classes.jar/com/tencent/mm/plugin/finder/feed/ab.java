package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ap;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bks;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderLiveFeedUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveFeedUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "liveInfos", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderObjectAsyncLoadInfo;", "Lkotlin/collections/HashMap;", "getJoinLiveTips", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTips;", "objectId", "onCleared", "", "tryFetchPreloadInfo", "nonceId", "liveId", "context", "Landroid/content/Context;", "updateLiveInfo", "liveInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends UIComponent
  implements ap
{
  private final HashMap<Long, bqy> AWI;
  private final String TAG;
  
  public ab(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(363156);
    this.TAG = "FinderLiveFeedUIC";
    this.AWI = new HashMap();
    AppMethodBeat.o(363156);
  }
  
  public final void a(final long paramLong1, String paramString, long paramLong2, Context paramContext)
  {
    AppMethodBeat.i(363193);
    Log.i(this.TAG, "tryFetchPreloadInfo objectId:" + paramLong1 + " nonceId:" + paramString + " context:" + paramContext);
    Object localObject;
    if (nw(paramLong1) == null)
    {
      ArrayList localArrayList = new ArrayList();
      brr localbrr = new brr();
      localbrr.object_id = paramLong1;
      if (paramString != null) {
        break label207;
      }
      localObject = "";
      localbrr.object_nonce_id = ((String)localObject);
      localbrr.mMJ = paramLong2;
      localObject = ah.aiuX;
      localArrayList.add(localbrr);
      localObject = h.ax(g.class);
      s.s(localObject, "service(IFinderCommonLiveService::class.java)");
      localObject = d.b((com.tencent.mm.vending.g.c)g.a.a((g)localObject, (List)localArrayList, 3, 0, null, null, 60).bFJ(), (kotlin.g.a.b)new a(this, paramLong1, paramString));
      if (!(paramContext instanceof MMActivity)) {
        break label213;
      }
    }
    label207:
    label213:
    for (paramString = (MMActivity)paramContext;; paramString = null)
    {
      if (paramString != null) {
        ((com.tencent.mm.vending.g.c)localObject).b((com.tencent.mm.vending.e.b)paramString);
      }
      AppMethodBeat.o(363193);
      return;
      localObject = paramString;
      break;
    }
  }
  
  public final bcc nw(long paramLong)
  {
    AppMethodBeat.i(363180);
    Object localObject = (bqy)this.AWI.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      AppMethodBeat.o(363180);
      return null;
    }
    localObject = ((bqy)localObject).ZYX;
    if (localObject == null)
    {
      AppMethodBeat.o(363180);
      return null;
    }
    localObject = ((bks)localObject).ZMQ;
    AppMethodBeat.o(363180);
    return localObject;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(363172);
    super.onCleared();
    this.AWI.clear();
    AppMethodBeat.o(363172);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<b.a<aub>, ah>
  {
    a(ab paramab, long paramLong, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ab
 * JD-Core Version:    0.7.0.1
 */