package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.plugin.finder.cgi.g;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.video.FinderLiveAnchorMicFeedView;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.g.c;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderLiveFeedDecorator;", "", "scene", "", "decorateView", "Landroid/view/ViewGroup;", "(ILandroid/view/ViewGroup;)V", "anchorData", "Lcom/tencent/mm/plugin/finder/feed/FinderLiveFeedDecorator$AnchorData;", "enable", "", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "isFetching", "micMode", "micUserCache", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "Lkotlin/collections/HashMap;", "onLinkMicCallback", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMLiveSEIMsgConnectMicUserInfo;", "Lkotlin/ParameterName;", "name", "micUserList", "", "getOnLinkMicCallback", "()Lkotlin/jvm/functions/Function1;", "setOnLinkMicCallback", "(Lkotlin/jvm/functions/Function1;)V", "pkAnchorData", "visitorMicData", "Lcom/tencent/mm/protocal/protobuf/MMLiveSEIMsgConnectMicData;", "checkAnchorViewWhenAudioMode", "isPkAnchor", "checkDecorateInfo", "msgType", "seiMsg", "checkLinkMicMode", "videoW", "videoH", "diffMicSei", "micSEIMsg", "handleAnchorSei", "handleMicSei", "handleSeiMessage", "seiData", "", "onVideoPlayBegin", "resetSeiData", "setFeedData", "tryFetchMicUserInfo", "updateMicView", "AnchorData", "Companion", "plugin-finder_release"})
public final class z
{
  public static final z.b xzs;
  public boolean enable;
  private final int scene;
  public boolean xzj;
  public boolean xzk;
  public z.a xzl;
  public z.a xzm;
  public cud xzn;
  public HashMap<String, aza> xzo;
  private FeedData xzp;
  public kotlin.g.a.b<? super LinkedList<cue>, x> xzq;
  private final ViewGroup xzr;
  
  static
  {
    AppMethodBeat.i(278532);
    xzs = new z.b((byte)0);
    AppMethodBeat.o(278532);
  }
  
  public z(int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(278531);
    this.scene = paramInt;
    this.xzr = paramViewGroup;
    this.xzl = new z.a();
    this.xzm = new z.a();
    this.xzn = new cud();
    this.xzo = new HashMap();
    this.enable = true;
    paramViewGroup = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dXW().aSr()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.enable = bool;
      Log.i("FinderLiveFeedDecorator", "feedDecorate enable:" + this.enable);
      AppMethodBeat.o(278531);
      return;
    }
  }
  
  private final void a(z.a parama, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(278524);
    ViewGroup localViewGroup = this.xzr;
    Object localObject1;
    Object localObject4;
    Object localObject3;
    if (localViewGroup != null)
    {
      localObject1 = this.xzp;
      if (localObject1 != null)
      {
        localObject1 = ((FeedData)localObject1).getMediaList();
        if (localObject1 != null)
        {
          localObject1 = (csg)j.lp((List)localObject1);
          if (localObject1 != null)
          {
            localObject1 = ((csg)localObject1).coverUrl;
            if (!Util.isNullOrNil((String)localObject1)) {
              break label729;
            }
            Log.i("FinderLiveFeedDecorator", "coverUrl is null, try thumbUrl");
            localObject4 = new StringBuilder();
            localObject1 = this.xzp;
            if (localObject1 != null)
            {
              localObject1 = ((FeedData)localObject1).getMediaList();
              if (localObject1 != null)
              {
                localObject1 = (csg)j.lp((List)localObject1);
                if (localObject1 != null)
                {
                  localObject3 = ((csg)localObject1).thumbUrl;
                  localObject1 = localObject3;
                  if (localObject3 != null) {
                    break label152;
                  }
                }
              }
            }
            localObject1 = "";
            label152:
            localObject4 = ((StringBuilder)localObject4).append((String)localObject1);
            localObject1 = this.xzp;
            if (localObject1 != null)
            {
              localObject1 = ((FeedData)localObject1).getMediaList();
              if (localObject1 != null)
              {
                localObject1 = (csg)j.lp((List)localObject1);
                if (localObject1 != null)
                {
                  localObject3 = ((csg)localObject1).thumb_url_token;
                  localObject1 = localObject3;
                  if (localObject3 != null) {
                    break label222;
                  }
                }
              }
            }
            localObject1 = "";
            label222:
            localObject1 = localObject1;
          }
        }
      }
    }
    label526:
    label729:
    for (;;)
    {
      if (parama.xzt)
      {
        if (paramBoolean)
        {
          localObject1 = localViewGroup.getContext();
          p.j(localObject1, "it.context");
          localObject3 = new FinderLiveAnchorMicFeedView((Context)localObject1);
          localObject1 = new RelativeLayout.LayoutParams(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight());
          localViewGroup.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
          localObject4 = (aza)this.xzo.get(parama.ktR);
          localObject1 = localObject2;
          if (localObject4 != null) {
            localObject1 = ((aza)localObject4).SKa;
          }
          ((FinderLiveAnchorMicFeedView)localObject3).aGi((String)localObject1);
          ((FinderLiveAnchorMicFeedView)localObject3).setTranslationX(localViewGroup.getMeasuredWidth() / 2.0F);
          ((FinderLiveAnchorMicFeedView)localObject3).setTag(parama.ktR);
          AppMethodBeat.o(278524);
          return;
          localObject1 = null;
          break;
        }
        int i = this.xzn.SKD.size();
        if ((1 > i) || (2 < i))
        {
          localObject2 = (CharSequence)this.xzm.ktR;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label526;
          }
        }
        for (i = 1; i == 0; i = 0)
        {
          localObject2 = localViewGroup.getContext();
          p.j(localObject2, "it.context");
          localObject2 = new FinderLiveAnchorMicFeedView((Context)localObject2);
          localObject3 = new RelativeLayout.LayoutParams(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight());
          localViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          ((FinderLiveAnchorMicFeedView)localObject2).aGi((String)localObject1);
          ((FinderLiveAnchorMicFeedView)localObject2).setTranslationX(-localViewGroup.getMeasuredWidth() / 2.0F);
          ((FinderLiveAnchorMicFeedView)localObject2).setTag(parama.ktR);
          AppMethodBeat.o(278524);
          return;
        }
        if (this.xzn.SKD.size() == 3)
        {
          localObject2 = localViewGroup.getContext();
          p.j(localObject2, "it.context");
          localObject2 = new FinderLiveAnchorMicFeedView((Context)localObject2);
          localObject3 = new RelativeLayout.LayoutParams(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight() / 2);
          localViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          ((FinderLiveAnchorMicFeedView)localObject2).aGi((String)localObject1);
          ((FinderLiveAnchorMicFeedView)localObject2).setTranslationX(-localViewGroup.getMeasuredWidth() / 2.0F);
          ((FinderLiveAnchorMicFeedView)localObject2).setTag(parama.ktR);
          AppMethodBeat.o(278524);
          return;
        }
        localObject2 = localViewGroup.getContext();
        p.j(localObject2, "it.context");
        localObject2 = new FinderLiveAnchorMicFeedView((Context)localObject2);
        localObject3 = new RelativeLayout.LayoutParams(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight());
        localViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        ((FinderLiveAnchorMicFeedView)localObject2).aGi((String)localObject1);
        ((FinderLiveAnchorMicFeedView)localObject2).setTag(parama.ktR);
      }
      AppMethodBeat.o(278524);
      return;
      AppMethodBeat.o(278524);
      return;
    }
  }
  
  private final boolean a(cud paramcud)
  {
    AppMethodBeat.i(278522);
    Object localObject1 = this.xzn.SKD;
    p.j(localObject1, "visitorMicData.infos");
    Object localObject3;
    for (;;)
    {
      synchronized ((Iterable)localObject1)
      {
        localObject3 = ((Iterable)???).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = ((Iterator)localObject3).next();
          boolean bool = Util.isEqual(((cue)localObject1).RUq, this.xzl.ktR);
          if (!bool) {
            continue;
          }
          if (localObject1 != null) {
            break label441;
          }
          if (!this.xzn.SKD.isEmpty()) {
            break;
          }
          localObject1 = paramcud.SKD;
          p.j(localObject1, "micSEIMsg.infos");
          if (!((Collection)localObject1).isEmpty())
          {
            i = 1;
            if (i == 0) {
              break;
            }
            AppMethodBeat.o(278522);
            return true;
          }
        }
        else
        {
          localObject1 = null;
        }
      }
      i = 0;
    }
    localObject1 = this.xzn.SKD;
    p.j(localObject1, "visitorMicData.infos");
    if (!((Collection)localObject1).isEmpty()) {}
    for (int i = 1; (i != 0) && (paramcud.SKD.isEmpty()); i = 0)
    {
      AppMethodBeat.o(278522);
      return true;
    }
    localObject1 = new StringBuilder();
    ??? = this.xzn.SKD;
    p.j(???, "visitorMicData.infos");
    ??? = ((Iterable)???).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (cue)((Iterator)???).next();
      ((StringBuilder)localObject1).append(((cue)localObject3).RUq).append(((cue)localObject3).TBT);
    }
    ??? = new StringBuilder();
    paramcud = paramcud.SKD;
    p.j(paramcud, "micSEIMsg.infos");
    paramcud = ((Iterable)paramcud).iterator();
    while (paramcud.hasNext())
    {
      localObject3 = (cue)paramcud.next();
      ((StringBuilder)???).append(((cue)localObject3).RUq).append(((cue)localObject3).TBT);
    }
    Log.d("FinderLiveFeedDecorator", "localStr:" + localObject1 + " remoteStr:" + ???);
    if (!Util.isEqual(((StringBuilder)localObject1).toString(), ((StringBuilder)???).toString()))
    {
      AppMethodBeat.o(278522);
      return true;
    }
    label441:
    AppMethodBeat.o(278522);
    return false;
  }
  
  private final void dtk()
  {
    AppMethodBeat.i(278527);
    com.tencent.mm.ae.d.uiThread((a)new e(this));
    AppMethodBeat.o(278527);
  }
  
  private final void dtl()
  {
    AppMethodBeat.i(278529);
    if (this.xzk)
    {
      Log.i("FinderLiveFeedDecorator", "isFetching, skip!");
      AppMethodBeat.o(278529);
      return;
    }
    this.xzk = true;
    Object localObject3 = new ArrayList();
    Object localObject1 = this.xzp;
    long l;
    Object localObject2;
    if (localObject1 != null)
    {
      l = ((FeedData)localObject1).getFeedId();
      localObject1 = this.xzp;
      if (localObject1 != null)
      {
        localObject2 = ((FeedData)localObject1).getNonceId();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ((ArrayList)localObject3).add(new o(Long.valueOf(l), localObject1));
      localObject3 = com.tencent.mm.ae.d.b((c)new g((List)localObject3, 3, 0, null, null, 60).bhW(), (kotlin.g.a.b)new d(this));
      localObject1 = this.xzr;
      if (localObject1 == null) {
        break label201;
      }
    }
    label201:
    for (localObject1 = ((ViewGroup)localObject1).getContext();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof MMActivity)) {
        localObject2 = null;
      }
      localObject1 = (MMActivity)localObject2;
      if (localObject1 == null) {
        break label206;
      }
      ((c)localObject3).b((com.tencent.mm.vending.e.b)localObject1);
      AppMethodBeat.o(278529);
      return;
      l = 0L;
      break;
    }
    label206:
    AppMethodBeat.o(278529);
  }
  
  public final void a(FeedData paramFeedData)
  {
    if (!this.enable) {
      return;
    }
    this.xzp = paramFeedData;
  }
  
  public final void bT(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(278520);
    if (!this.enable)
    {
      AppMethodBeat.o(278520);
      return;
    }
    h.ZvG.d((Runnable)new z.c(this, paramArrayOfByte), "Sei_Message_Handler");
    AppMethodBeat.o(278520);
  }
  
  public final void dtj()
  {
    AppMethodBeat.i(278519);
    if (!this.enable)
    {
      AppMethodBeat.o(278519);
      return;
    }
    this.xzk = false;
    this.xzl = new z.a();
    this.xzm = new z.a();
    this.xzn = new cud();
    this.xzo.clear();
    ViewGroup localViewGroup = this.xzr;
    if (localViewGroup != null) {
      localViewGroup.removeAllViews();
    }
    this.xzj = false;
    this.xzq = null;
    AppMethodBeat.o(278519);
  }
  
  public final void gB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(278521);
    if (!this.enable)
    {
      AppMethodBeat.o(278521);
      return;
    }
    label218:
    for (;;)
    {
      try
      {
        Log.i("FinderLiveFeedDecorator", "videoW:" + paramInt1 + " videoH:" + paramInt2);
        if ((paramInt1 > 0) && (paramInt2 > 0))
        {
          Object localObject = new DecimalFormat("0.0");
          ((DecimalFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
          localObject = ((DecimalFormat)localObject).format(Float.valueOf(paramInt1 / paramInt2));
          p.j(localObject, "floatFormat.format(video…oat() / videoH.toFloat())");
          float f = Float.parseFloat((String)localObject);
          if (f == 1.1F) {
            break label218;
          }
          if (f == 1.0F)
          {
            break label218;
            this.xzj = bool;
            if (!this.xzj)
            {
              this.xzm = new z.a();
              this.xzn = new cud();
            }
            dtl();
            AppMethodBeat.o(278521);
            return;
          }
          bool = false;
          continue;
        }
        boolean bool = true;
      }
      catch (Exception localException)
      {
        this.xzj = false;
        Log.w("FinderLiveFeedDecorator", "checkLinkMicMode exception. " + localException.getMessage());
        AppMethodBeat.o(278521);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<c.a<aqg>, x>
  {
    d(z paramz)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(z paramz)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.z
 * JD-Core Version:    0.7.0.1
 */