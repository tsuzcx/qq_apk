package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.bh;
import com.tencent.mm.plugin.finder.live.report.q.bi;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.plugin.findersdk.a.cf.a;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemRedPacket;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveCommentItem;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "handleRecvLuckyMoneyErr", "", "errCode", "", "onSpanClick", "context", "Landroid/content/Context;", "clickSendId", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class r
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.b
{
  final a CBK;
  private final String TAG;
  
  public r(a parama)
  {
    super(parama);
    this.CBK = parama;
    this.TAG = "CommentItemRedPacket";
  }
  
  protected final void aC(Context paramContext, String paramString)
  {
    Object localObject1 = null;
    s.u(paramContext, "context");
    s.u(paramString, "clickSendId");
    Object localObject2 = ((e)this.CBK.business(e.class)).EdS;
    s.s(localObject2, "liveContext.business(Liv…lass.java).luckyMoneyList");
    Object localObject3 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = ((Iterator)localObject3).next();
      if (Util.isEqual(((bls)localObject2).ZOX, paramString))
      {
        paramString = (String)localObject2;
        localObject2 = (bls)paramString;
        if (localObject2 != null)
        {
          localObject3 = (cf)k.Doi;
          q.bi localbi = q.bi.DAW;
          if (!TextUtils.isEmpty((CharSequence)((bls)localObject2).ZPd)) {
            break label258;
          }
          paramString = q.bh.DAR;
          label129:
          cf.a.a((cf)localObject3, localbi, paramString);
          paramString = aj.CGT;
          paramString = aj.getFinderLiveAssistant();
          if (paramString != null) {
            paramString.a((Activity)paramContext, (bls)localObject2, (ResultReceiver)new CommentItemRedPacket.onSpanClick.1.1(this, (bls)localObject2, MMHandler.createFreeHandler(Looper.getMainLooper())), (kotlin.g.a.b)new a(this));
          }
        }
        paramString = this.TAG;
        localObject3 = new StringBuilder("click lucky money item :[");
        if (localObject2 != null) {
          break label265;
        }
        paramContext = null;
        label214:
        localObject3 = ((StringBuilder)localObject3).append(paramContext).append(", ");
        if (localObject2 != null) {
          break label274;
        }
      }
    }
    label258:
    label265:
    label274:
    for (paramContext = localObject1;; paramContext = ((bls)localObject2).ZSV)
    {
      Log.i(paramString, paramContext + ']');
      return;
      paramString = null;
      break;
      paramString = q.bh.DAS;
      break label129;
      paramContext = ((bls)localObject2).ZOX;
      break label214;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errCode", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    a(r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.r
 * JD-Core Version:    0.7.0.1
 */