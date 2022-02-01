package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderPoiFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.dma;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI;IIZ)V", "dynamicState", "", "getDynamicState", "()J", "setDynamicState", "(J)V", "iconUrl", "", "getIconUrl", "()Ljava/lang/String;", "poiCategories", "getPoiCategories", "setPoiCategories", "(Ljava/lang/String;)V", "poiDetailReportStr", "getPoiDetailReportStr", "setPoiDetailReportStr", "poiHeader", "Landroid/view/View;", "poiLatitude", "", "poiLongitude", "poiName", "getPoiName", "setPoiName", "poiSourceFlag", "getPoiSourceFlag", "()I", "setPoiSourceFlag", "(I)V", "videoCount", "getVideoCount", "setVideoCount", "configureTextView", "", "textView", "Landroid/widget/TextView;", "info", "resId", "onClick", "Lkotlin/Function0;", "(Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "generatePhoneTextView", "phone", "tvTel", "getActivity", "Lcom/tencent/mm/ui/MMActivity;", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshHeader", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setClickSpan", "tv", "strAll", "strHighLight", "showHeaderOnDataEmpty", "Companion", "plugin-finder_release"})
public final class ae$b
  extends c.b
{
  public static final a xzU;
  public String poiName;
  View xzM;
  public String xzN;
  int xzO;
  public long xzP;
  public String xzQ;
  float xzR;
  float xzS;
  public int xzT;
  
  static
  {
    AppMethodBeat.i(231153);
    xzU = new a((byte)0);
    AppMethodBeat.o(231153);
  }
  
  private ae$b(FinderPoiFeedUI paramFinderPoiFeedUI, int paramInt)
  {
    super((MMActivity)paramFinderPoiFeedUI, 2, 81, false);
    AppMethodBeat.i(231150);
    this.xzN = "";
    this.xzQ = "";
    this.poiName = "";
    AppMethodBeat.o(231150);
  }
  
  static void a(final TextView paramTextView, String paramString1, String paramString2, kotlin.g.a.a<x> parama)
  {
    int i = 0;
    AppMethodBeat.i(231147);
    int k = kotlin.n.n.a((CharSequence)paramString1, paramString2, 0, false, 6);
    int j = paramString2.length() + k;
    if ((k <= 0) || (j > paramString1.length())) {
      j = paramString1.length();
    }
    for (;;)
    {
      paramString1 = new SpannableString((CharSequence)paramString1);
      paramString1.setSpan(new g(parama, paramTextView), i, j, 33);
      paramString2 = paramTextView.getContext();
      p.j(paramString2, "tv.context");
      paramTextView.setHighlightColor(paramString2.getResources().getColor(17170445));
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)paramString1);
      AppMethodBeat.o(231147);
      return;
      i = k;
    }
  }
  
  final void a(TextView paramTextView, String paramString, Integer paramInteger, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(231144);
    if (Util.isNullOrNil(paramString))
    {
      if (paramTextView != null)
      {
        paramTextView.setVisibility(8);
        AppMethodBeat.o(231144);
        return;
      }
      AppMethodBeat.o(231144);
      return;
    }
    if (paramTextView != null) {
      paramTextView.setVisibility(0);
    }
    if (paramTextView != null)
    {
      if (paramInteger == null) {
        break label125;
      }
      int i = ((Number)paramInteger).intValue();
      paramInteger = this.iXq.getString(i, new Object[] { paramString });
      if (paramInteger == null) {
        break label125;
      }
    }
    label125:
    for (paramInteger = (CharSequence)paramInteger;; paramInteger = (CharSequence)paramString)
    {
      paramTextView.setText(paramInteger);
      if (parama == null) {
        break;
      }
      if ((paramTextView != null) && (paramString != null)) {
        a(paramTextView, paramTextView.getText().toString(), paramString, parama);
      }
      AppMethodBeat.o(231144);
      return;
    }
    AppMethodBeat.o(231144);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(231131);
    p.k(parama, "adapter");
    p.k(paramView, "view");
    paramInt -= ((h)parama).YSk.size();
    if ((paramInt >= 0) && (paramInt < dsG().xnX.getSize()))
    {
      bu localbu = (bu)dsG().xnX.getDataListJustForAdapter().get(paramInt);
      if (!(localbu instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(231131);
        return;
      }
      Log.i("Finder.FinderPoiFeedUIContract.PoiFeedViewCallback", "onClick " + paramInt + " id:" + ((BaseFinderFeed)localbu).feedObject.getId() + ", pos:" + paramInt + ", nonceId:" + ((BaseFinderFeed)localbu).feedObject.getObjectNonceId());
      Intent localIntent = new Intent();
      parama = d.AjH;
      if (((Boolean)d.dXh().aSr()).booleanValue())
      {
        paramView = dsG().xnX;
        parama = paramView;
        if (!(paramView instanceof FinderPoiFeedLoader)) {
          parama = null;
        }
        paramView = (FinderPoiFeedLoader)parama;
        if (paramView != null)
        {
          parama = paramView.xIr;
          if (parama != null)
          {
            parama = parama.toByteArray();
            localIntent.putExtra("key_location", parama);
            localIntent.putExtra("key_from_type", (Serializable)paramView.xIs);
            localIntent.putExtra("key_from_scene", (Serializable)paramView.xIt);
          }
        }
        else
        {
          BaseFeedLoader.saveCache$default(dsG().xnX, localIntent, paramInt, null, 4, null);
          parama = com.tencent.mm.plugin.finder.utils.a.ACH;
          com.tencent.mm.plugin.finder.utils.a.ar((Context)this.iXq, localIntent);
        }
      }
      for (;;)
      {
        parama = aj.Bnu;
        parama = aj.a.fZ((Context)this.iXq);
        if (parama == null) {
          break label507;
        }
        parama = parama.ekY();
        if (parama == null) {
          break label507;
        }
        paramView = com.tencent.mm.plugin.finder.report.n.zWF;
        com.tencent.mm.plugin.finder.report.n.a(parama, ((BaseFinderFeed)localbu).feedObject.getId(), this.xvJ.getRecyclerView());
        AppMethodBeat.o(231131);
        return;
        parama = null;
        break;
        localIntent.putExtra("FEED_ID", ((BaseFinderFeed)localbu).feedObject.getId());
        localIntent.putExtra("FEED_NONCE_ID", ((BaseFinderFeed)localbu).feedObject.getObjectNonceId());
        localIntent.putExtra("TITLE_WORDING", "");
        localIntent.putExtra("GET_REL_SCENE", 17);
        localIntent.putExtra("POI_LATITUDE", this.xzR);
        localIntent.putExtra("POI_LONGITUDE", this.xzS);
        BaseFeedLoader.saveCacheToIntent$default(dsG().xnX, localIntent, j.listOf(localbu), dsG().xnX.getLastBuffer(), 0, null, 16, null);
        parama = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.W((Context)this.iXq, localIntent);
      }
    }
    label507:
    AppMethodBeat.o(231131);
  }
  
  public final boolean dsK()
  {
    return true;
  }
  
  public final void dsL() {}
  
  public final RecyclerView.LayoutManager eW(Context paramContext)
  {
    AppMethodBeat.i(231132);
    p.k(paramContext, "context");
    paramContext = dsI().eW(paramContext);
    AppMethodBeat.o(231132);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(231140);
    p.k(paramc, "reason");
    AppMethodBeat.o(231140);
    return null;
  }
  
  public final String g(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(231141);
    p.k(paramc, "reason");
    AppMethodBeat.o(231141);
    return null;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(231137);
    View localView = this.iXq.findViewById(b.f.empty_view);
    AppMethodBeat.o(231137);
    return localView;
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(231138);
    this.xzM = View.inflate((Context)this.iXq, b.g.finder_poi_feed_header, null);
    View localView = this.xzM;
    AppMethodBeat.o(231138);
    return localView;
  }
  
  public final String getIconUrl()
  {
    AppMethodBeat.i(231126);
    Object localObject = dsH().xnX.getListOfType(BaseFinderFeed.class);
    int i;
    if (!((Collection)localObject).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      localObject = (csg)j.M((List)((BaseFinderFeed)((List)localObject).get(0)).feedObject.getMediaList(), 0);
      if (localObject != null) {
        if (!Util.isNullOrNil(((csg)localObject).thumb_url_token))
        {
          localObject = ((csg)localObject).thumbUrl + ((csg)localObject).thumb_url_token;
          AppMethodBeat.o(231126);
          return localObject;
          i = 0;
        }
        else
        {
          localObject = String.valueOf(((csg)localObject).thumbUrl);
          AppMethodBeat.o(231126);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(231126);
    return "";
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(231133);
    RecyclerView.h localh = dsI().getItemDecoration();
    AppMethodBeat.o(231133);
    return localh;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$refreshHeader$1$addressOnClickListener$1"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(ae.b paramb, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "phone", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$refreshHeader$1$phoneOnClickListener$1"})
  static final class c
    extends q
    implements kotlin.g.a.b<String, x>
  {
    c(ae.b paramb, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$refreshHeader$1$4$1", "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$$special$$inlined$forEach$lambda$1"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(String paramString, TextView paramTextView, LinearLayout paramLinearLayout, kotlin.g.a.b paramb, ae.b paramb1, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(kotlin.g.a.b paramb, dma paramdma)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$setClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class g
    extends ClickableSpan
  {
    g(kotlin.g.a.a parama, TextView paramTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(221567);
      p.k(paramView, "widget");
      this.xAe.invoke();
      AppMethodBeat.o(221567);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(221570);
      p.k(paramTextPaint, "ds");
      Context localContext = paramTextView.getContext();
      p.j(localContext, "tv.context");
      paramTextPaint.setColor(localContext.getResources().getColor(b.c.Link_100));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(221570);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ae.b
 * JD-Core Version:    0.7.0.1
 */