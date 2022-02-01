package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderPoiFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderPoiFeedLoader.b;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiFeedUI;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.eee;
import com.tencent.mm.protocal.protobuf.eef;
import com.tencent.mm.protocal.protobuf.eel;
import com.tencent.mm.protocal.protobuf.een;
import com.tencent.mm.protocal.protobuf.eeo;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.protocal.protobuf.fes;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI;IIZ)V", "dynamicState", "", "getDynamicState", "()J", "setDynamicState", "(J)V", "iconUrl", "", "getIconUrl", "()Ljava/lang/String;", "poiCategories", "getPoiCategories", "setPoiCategories", "(Ljava/lang/String;)V", "poiDetailReportStr", "getPoiDetailReportStr", "setPoiDetailReportStr", "poiHeader", "Landroid/view/View;", "poiLatitude", "", "poiLongitude", "poiName", "getPoiName", "setPoiName", "poiSourceFlag", "getPoiSourceFlag", "()I", "setPoiSourceFlag", "(I)V", "videoCount", "getVideoCount", "setVideoCount", "bindFinderContact", "", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "ivFinderAvatar", "Landroid/widget/ImageView;", "tvFinderName", "Landroid/widget/TextView;", "ivFinderAuthIcon", "configureTextView", "textView", "info", "resId", "onClick", "Lkotlin/Function0;", "(Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "generatePhoneTextView", "phone", "tvTel", "getActivity", "Lcom/tencent/mm/ui/MMActivity;", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "onPoiOnRefreshEnd", "refreshHeader", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "reportPoiAction", "eventCode", "finderUsername", "setClickSpan", "tv", "strAll", "strHighLight", "setTitleExposedListener", "title", "showHeaderOnDataEmpty", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai$b
  extends c.b
{
  public static final a AXk;
  private View AXl;
  public String AXm;
  private int AXn;
  public long AXo;
  public String AXp;
  private float AXq;
  private float AXr;
  public int AXs;
  public String poiName;
  
  static
  {
    AppMethodBeat.i(362614);
    AXk = new a((byte)0);
    AppMethodBeat.o(362614);
  }
  
  private ai$b(FinderPoiFeedUI paramFinderPoiFeedUI, int paramInt)
  {
    super((MMActivity)paramFinderPoiFeedUI, 2, 81, false);
    AppMethodBeat.i(362541);
    this.AXm = "";
    this.AXp = "";
    this.poiName = "";
    AppMethodBeat.o(362541);
  }
  
  private final void B(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(362576);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("poi_name", paramString1);
    localJSONObject.put("finderusername", paramString2);
    paramString1 = com.tencent.mm.plugin.finder.report.z.FrZ;
    paramString1 = localJSONObject.toString();
    s.s(paramString1, "kvJson.toString()");
    paramString2 = n.bV(paramString1, ",", ";");
    paramString1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramString1 = as.a.hu((Context)this.lzt);
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = paramString1.fou())
    {
      com.tencent.mm.plugin.finder.report.z.b(paramInt, "poi_channelaccount", paramString2, paramString1);
      AppMethodBeat.o(362576);
      return;
    }
  }
  
  private final void a(TextView paramTextView, String paramString, Integer paramInteger, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(362552);
    if (Util.isNullOrNil(paramString))
    {
      if (paramTextView != null) {
        paramTextView.setVisibility(8);
      }
      AppMethodBeat.o(362552);
      return;
    }
    if (paramTextView != null) {
      paramTextView.setVisibility(0);
    }
    if (paramTextView != null)
    {
      if (paramInteger != null) {
        break label91;
      }
      paramInteger = (CharSequence)paramString;
    }
    for (;;)
    {
      paramTextView.setText(paramInteger);
      if ((parama != null) && (paramTextView != null) && (paramString != null)) {
        a(paramTextView, paramTextView.getText().toString(), paramString, parama);
      }
      AppMethodBeat.o(362552);
      return;
      label91:
      int i = ((Number)paramInteger).intValue();
      paramInteger = this.lzt.getString(i, new Object[] { paramString });
      if (paramInteger == null) {
        paramInteger = (CharSequence)paramString;
      } else {
        paramInteger = (CharSequence)paramInteger;
      }
    }
  }
  
  private static void a(TextView paramTextView, String paramString1, String paramString2, kotlin.g.a.a<ah> parama)
  {
    int i = 0;
    AppMethodBeat.i(362566);
    int k = n.a((CharSequence)paramString1, paramString2, 0, false, 6);
    int j = paramString2.length() + k;
    if ((k <= 0) || (j > paramString1.length())) {
      j = paramString1.length();
    }
    for (;;)
    {
      paramString1 = new SpannableString((CharSequence)paramString1);
      paramString1.setSpan(new ai.b.f(parama, paramTextView), i, j, 33);
      paramTextView.setHighlightColor(paramTextView.getContext().getResources().getColor(17170445));
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)paramString1);
      AppMethodBeat.o(362566);
      return;
      i = k;
    }
  }
  
  private static final void a(m paramm, b paramb, View paramView)
  {
    AppMethodBeat.i(362585);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramm);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramm, "$contact");
    s.u(paramb, "this$0");
    localObject2 = new Intent();
    localObject1 = paramm.getUsername();
    paramView = (View)localObject1;
    if (localObject1 == null) {
      paramView = "";
    }
    ((Intent)localObject2).putExtra("finder_username", paramView);
    ((com.tencent.mm.plugin.f)h.ax(com.tencent.mm.plugin.f.class)).enterFinderProfileUI((Context)paramb.lzt, (Intent)localObject2);
    paramb.B(1, paramb.poiName, paramm.getUsername());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(362585);
  }
  
  private static final void d(kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(362580);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$addressOnClickListener");
    parama.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(362580);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(362676);
    s.u(parama, "adapter");
    s.u(paramView, "view");
    paramInt -= ((i)parama).agOb.size();
    cc localcc;
    Object localObject1;
    long l;
    if ((paramInt >= 0) && (paramInt < ebL().ALH.getSize()))
    {
      localcc = (cc)ebL().ALH.getDataListJustForAdapter().get(paramInt);
      if (!(localcc instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(362676);
        return;
      }
      Log.i("Finder.FinderPoiFeedUIContract.PoiFeedViewCallback", "onGridItemClick " + paramInt + " id:" + ((BaseFinderFeed)localcc).feedObject.getId() + ", pos:" + paramInt + ", nonceId:" + ((BaseFinderFeed)localcc).feedObject.getObjectNonceId());
      parama = aw.Gjk;
      if (aw.s((BaseFinderFeed)localcc))
      {
        Context localContext;
        Object localObject2;
        if (Util.isEqual(((BaseFinderFeed)localcc).feedObject.getUserName(), com.tencent.mm.model.z.bAW()))
        {
          parama = h.ax(com.tencent.mm.plugin.f.class);
          s.s(parama, "service(IActivityRouter::class.java)");
          localObject1 = (com.tencent.mm.plugin.f)parama;
          localContext = (Context)this.lzt;
          l = ((BaseFinderFeed)localcc).feedObject.getId();
          localObject2 = ((BaseFinderFeed)localcc).feedObject.getObjectNonceId();
          paramView = ((BaseFinderFeed)localcc).feedObject.getLiveInfo();
          parama = paramView;
          if (paramView == null) {
            parama = new bip();
          }
          f.a.a((com.tencent.mm.plugin.f)localObject1, localContext, l, (String)localObject2, parama, null, null, null, null, null, ((BaseFinderFeed)localcc).getSessionBuffer(), null, null, 7152);
        }
        for (;;)
        {
          Log.i("Finder.FinderPoiFeedUIContract.PoiFeedViewCallback", s.X("onGridItemClick return for live feed, commentScene:", Integer.valueOf(getCommentScene())));
          AppMethodBeat.o(362676);
          return;
          parama = new ArrayList();
          parama.add(localcc);
          paramView = new Intent();
          localObject1 = h.ax(com.tencent.mm.plugin.f.class);
          s.s(localObject1, "service(IActivityRouter::class.java)");
          localObject1 = (com.tencent.mm.plugin.f)localObject1;
          localContext = (Context)this.lzt;
          localObject2 = h.ax(g.class);
          s.s(localObject2, "service(IFinderCommonLiveService::class.java)");
          f.a.a((com.tencent.mm.plugin.f)localObject1, localContext, g.a.a((g)localObject2, parama, localcc, getCommentScene()), "", "", paramView, false, 32);
        }
      }
      localObject1 = new Intent();
      parama = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!((Boolean)com.tencent.mm.plugin.finder.storage.d.eVW().bmg()).booleanValue()) {
        break label753;
      }
      parama = ebL().ALH;
      if (!(parama instanceof FinderPoiFeedLoader)) {
        break label740;
      }
      parama = (FinderPoiFeedLoader)parama;
      if (parama != null)
      {
        paramView = parama.BhH;
        if (paramView != null) {
          break label745;
        }
        paramView = null;
        label498:
        ((Intent)localObject1).putExtra("key_location", paramView);
        ((Intent)localObject1).putExtra("key_from_type", (Serializable)parama.BhJ);
        ((Intent)localObject1).putExtra("key_from_scene", (Serializable)parama.BhK);
      }
      BaseFeedLoader.saveCache$default((BaseFeedLoader)ebL().ALH, (Intent)localObject1, paramInt, null, 4, null);
      ((com.tencent.mm.plugin.f)h.ax(com.tencent.mm.plugin.f.class)).l((Context)this.lzt, (Intent)localObject1);
    }
    for (;;)
    {
      parama = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      parama = as.a.hu((Context)this.lzt);
      if (parama != null)
      {
        parama = parama.fou();
        if (parama != null)
        {
          paramView = new JSONObject();
          if (((BaseFinderFeed)localcc).msgEventFriendLikeCount > 0)
          {
            localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.eYF().bmg()).intValue() == 1) {
              paramView.put("friends_like_total", ((BaseFinderFeed)localcc).msgEventFriendLikeCount);
            }
          }
          localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
          l = ((BaseFinderFeed)localcc).feedObject.getId();
          localObject1 = this.ATx.getRecyclerView();
          paramView = paramView.toString();
          s.s(paramView, "kvJson.toString()");
          com.tencent.mm.plugin.finder.report.z.a(parama, l, (RecyclerView)localObject1, 0, n.bV(paramView, ",", ";"), 8);
          paramView = k.Fpu;
          k.a(parama, localcc);
        }
      }
      AppMethodBeat.o(362676);
      return;
      label740:
      parama = null;
      break;
      label745:
      paramView = paramView.toByteArray();
      break label498;
      label753:
      ((Intent)localObject1).putExtra("FEED_ID", ((BaseFinderFeed)localcc).feedObject.getId());
      ((Intent)localObject1).putExtra("FEED_NONCE_ID", ((BaseFinderFeed)localcc).feedObject.getObjectNonceId());
      ((Intent)localObject1).putExtra("TITLE_WORDING", "");
      ((Intent)localObject1).putExtra("GET_REL_SCENE", 17);
      ((Intent)localObject1).putExtra("POI_LATITUDE", this.AXq);
      ((Intent)localObject1).putExtra("POI_LONGITUDE", this.AXr);
      BaseFeedLoader.saveCacheToIntent$default((BaseFeedLoader)ebL().ALH, (Intent)localObject1, kotlin.a.p.listOf(localcc), ebL().ALH.getLastBuffer(), 0, null, 16, null);
      ((com.tencent.mm.plugin.f)h.ax(com.tencent.mm.plugin.f.class)).m((Context)this.lzt, (Intent)localObject1);
    }
  }
  
  public final void a(final IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(362784);
    s.u(paramIResponse, "response");
    if (!(paramIResponse instanceof FinderPoiFeedLoader.b))
    {
      AppMethodBeat.o(362784);
      return;
    }
    Object localObject1 = ((FinderPoiFeedLoader.b)paramIResponse).BhL;
    final eel localeel;
    label92:
    Object localObject2;
    Object localObject15;
    label134:
    label148:
    label162:
    Object localObject12;
    label176:
    Object localObject7;
    label190:
    LinearLayout localLinearLayout;
    label204:
    Object localObject5;
    label218:
    Object localObject8;
    label232:
    label246:
    Object localObject4;
    label260:
    label274:
    Object localObject6;
    label288:
    Object localObject9;
    label302:
    Object localObject10;
    label316:
    Object localObject11;
    label330:
    label494:
    label631:
    label894:
    float f;
    label518:
    label656:
    label925:
    label1447:
    if (localObject1 != null)
    {
      localeel = ((fes)localObject1).abEh;
      label1321:
      if (localeel != null)
      {
        localObject1 = this.AXl;
        Object localObject13;
        Object localObject14;
        Object localObject3;
        StringBuilder localStringBuilder1;
        Object localObject16;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).setVisibility(0);
          }
          localObject1 = this.AXl;
          if (localObject1 != null) {
            break label1161;
          }
          localObject1 = null;
          localObject2 = (View)localObject1;
          if (localObject2 != null) {
            com.tencent.mm.view.f.a((View)localObject2, (com.tencent.mm.view.e.b)new g(this));
          }
          localObject2 = this.AXl;
          if (localObject2 != null) {
            break label1177;
          }
          localObject15 = null;
          localObject2 = this.AXl;
          if (localObject2 != null) {
            break label1193;
          }
          localObject13 = null;
          localObject2 = this.AXl;
          if (localObject2 != null) {
            break label1209;
          }
          localObject14 = null;
          localObject2 = this.AXl;
          if (localObject2 != null) {
            break label1225;
          }
          localObject12 = null;
          localObject2 = this.AXl;
          if (localObject2 != null) {
            break label1241;
          }
          localObject7 = null;
          localObject2 = this.AXl;
          if (localObject2 != null) {
            break label1257;
          }
          localLinearLayout = null;
          localObject2 = this.AXl;
          if (localObject2 != null) {
            break label1273;
          }
          localObject5 = null;
          localObject2 = this.AXl;
          if (localObject2 != null) {
            break label1289;
          }
          localObject8 = null;
          localObject2 = this.AXl;
          if (localObject2 != null) {
            break label1305;
          }
          localObject2 = null;
          localObject3 = this.AXl;
          if (localObject3 != null) {
            break label1321;
          }
          localObject3 = null;
          localObject4 = this.AXl;
          if (localObject4 != null) {
            break label1334;
          }
          localObject4 = null;
          localObject6 = this.AXl;
          if (localObject6 != null) {
            break label1350;
          }
          localObject6 = null;
          localObject9 = this.AXl;
          if (localObject9 != null) {
            break label1366;
          }
          localObject9 = null;
          localObject10 = this.AXl;
          if (localObject10 != null) {
            break label1382;
          }
          localObject10 = null;
          localObject11 = this.AXl;
          if (localObject11 != null) {
            break label1398;
          }
          localObject11 = null;
          localStringBuilder1 = new StringBuilder();
          localObject16 = ((FinderPoiFeedLoader.b)paramIResponse).BhL;
          if (localObject16 != null)
          {
            i = ((fes)localObject16).abEi;
            this.AXn = i;
            Log.i("Finder.FinderPoiFeedUIContract.PoiFeedViewCallback", s.X("refreshHeader poiSourceFlag:", Integer.valueOf(i)));
            localObject16 = ah.aiuX;
            localObject16 = ah.aiuX;
          }
          localObject16 = localeel.abjy;
          if (localObject16 != null)
          {
            localObject16 = ((eee)localObject16).abja;
            if (localObject16 != null)
            {
              this.AXq = ((een)localObject16).ZaH;
              this.AXr = ((een)localObject16).ZaG;
              localObject16 = ah.aiuX;
              localObject16 = ah.aiuX;
            }
          }
          localObject16 = localeel.abjy;
          if (localObject16 != null) {
            break label1414;
          }
          localObject16 = null;
          label457:
          a(this, (TextView)localObject1, (String)localObject16, null, 12);
          StringBuilder localStringBuilder2 = localStringBuilder1.append("Name=");
          localObject1 = localeel.abjy;
          if (localObject1 != null) {
            break label1424;
          }
          localObject1 = "";
          localStringBuilder2.append((String)localObject1);
          localObject1 = localeel.abjy;
          if (localObject1 != null) {
            break label1447;
          }
          localObject1 = "";
          s.u(localObject1, "<set-?>");
          this.poiName = ((String)localObject1);
          if (((FinderPoiFeedLoader.b)paramIResponse).BhO) {
            break label2253;
          }
          localObject1 = localeel.abjy;
          if (localObject1 != null) {
            break label1470;
          }
          localObject1 = null;
          label557:
          a(this, (TextView)localObject15, (String)localObject1, null, 12);
          localObject1 = localeel.abjy;
          if (localObject1 != null) {
            break label1480;
          }
          localObject1 = "";
          label584:
          s.u(localObject1, "<set-?>");
          this.AXm = ((String)localObject1);
          localObject16 = new StringBuilder();
          if (this.AXn != 4)
          {
            localObject1 = localeel.abjy;
            if (localObject1 != null) {
              break label1503;
            }
            localObject1 = "";
            localStringBuilder2 = ((StringBuilder)localObject16).append((String)localObject1);
            localObject1 = localeel.abjy;
            if (localObject1 != null) {
              break label1526;
            }
            localObject1 = "";
            localStringBuilder2 = localStringBuilder2.append((String)localObject1);
            localObject1 = localeel.abjy;
            if (localObject1 != null) {
              break label1549;
            }
            localObject1 = "";
            label681:
            localStringBuilder2.append((String)localObject1);
          }
          localObject1 = localeel.abjy;
          if (localObject1 != null) {
            break label1572;
          }
          localObject1 = "";
          label705:
          ((StringBuilder)localObject16).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject16).toString();
          s.s(localObject1, "sb.toString()");
          localObject15 = (kotlin.g.a.a)new d(this, paramIResponse);
          a((TextView)localObject13, (String)localObject1, Integer.valueOf(e.h.finder_poi_feed_header_address), (kotlin.g.a.a)localObject15);
          if (localObject14 != null)
          {
            if (localObject13 != null) {
              break label1595;
            }
            i = 8;
            ((WeImageView)localObject14).setVisibility(i);
          }
          if (localObject14 != null)
          {
            ((WeImageView)localObject14).setOnClickListener(new ai.b..ExternalSyntheticLambda1((kotlin.g.a.a)localObject15));
            localObject1 = ah.aiuX;
          }
          localObject14 = localStringBuilder1.append('|').append("Nation=");
          localObject1 = localeel.abjy;
          if (localObject1 != null) {
            break label1604;
          }
          localObject1 = "";
          label832:
          ((StringBuilder)localObject14).append((String)localObject1);
          localObject14 = localStringBuilder1.append('|').append("Province=");
          localObject1 = localeel.abjy;
          if (localObject1 != null) {
            break label1627;
          }
          localObject1 = "";
          label871:
          ((StringBuilder)localObject14).append((String)localObject1);
          localObject1 = localeel.abjF;
          if (localObject1 != null) {
            break label1650;
          }
          localObject1 = null;
          a(this, (TextView)localObject12, (String)localObject1, Integer.valueOf(e.h.finder_poi_feed_header_open_time), 8);
          localObject1 = localeel.abjz;
          if (localObject1 != null) {
            break label1684;
          }
          localObject1 = null;
          localObject12 = (kotlin.g.a.b)new e(this);
          if (localObject1 != null) {
            break label1726;
          }
          i = 0;
        }
        label1193:
        for (;;)
        {
          label945:
          if (i > 1)
          {
            if (localObject7 != null) {
              ((TextView)localObject7).setText((CharSequence)this.lzt.getString(e.h.finder_poi_feed_header_telephone, new Object[] { "" }));
            }
            if (localObject7 != null) {
              ((TextView)localObject7).setVisibility(0);
            }
            if (localLinearLayout != null) {
              localLinearLayout.setVisibility(0);
            }
            if (localLinearLayout != null)
            {
              localLinearLayout.removeAllViews();
              localObject13 = ah.aiuX;
            }
            if (localObject1 != null)
            {
              localObject1 = ((Iterable)localObject1).iterator();
              for (;;)
              {
                if (((Iterator)localObject1).hasNext())
                {
                  localObject13 = (String)((Iterator)localObject1).next();
                  localObject14 = new TextView((Context)this.lzt);
                  ((TextView)localObject14).setText((CharSequence)localObject13);
                  if (localObject7 != null) {
                    ((TextView)localObject14).setLayoutParams(((TextView)localObject7).getLayoutParams());
                  }
                  if (localLinearLayout != null)
                  {
                    localLinearLayout.addView((View)localObject14);
                    localObject15 = ah.aiuX;
                  }
                  a((TextView)localObject14, (String)localObject13, (String)localObject13, (kotlin.g.a.a)new b((kotlin.g.a.b)localObject12, (String)localObject13));
                  continue;
                  localObject1 = (LinearLayout)((View)localObject1).findViewById(e.e.ll_header_root);
                  break;
                  localObject1 = (TextView)((View)localObject1).findViewById(e.e.poi_title);
                  break label92;
                  localObject15 = (TextView)((View)localObject2).findViewById(e.e.poi_type);
                  break label134;
                  localObject13 = (TextView)((View)localObject2).findViewById(e.e.poi_address);
                  break label148;
                  label1209:
                  localObject14 = (WeImageView)((View)localObject2).findViewById(e.e.poi_navigation_icon);
                  break label162;
                  label1225:
                  localObject12 = (TextView)((View)localObject2).findViewById(e.e.poi_open_time);
                  break label176;
                  label1241:
                  localObject7 = (TextView)((View)localObject2).findViewById(e.e.poi_tel);
                  break label190;
                  label1257:
                  localLinearLayout = (LinearLayout)((View)localObject2).findViewById(e.e.ll_tel_list);
                  break label204;
                  label1273:
                  localObject5 = (TextView)((View)localObject2).findViewById(e.e.poi_average_price);
                  break label218;
                  localObject8 = (TextView)((View)localObject2).findViewById(e.e.poi_special_source);
                  break label232;
                  localObject2 = (TextView)((View)localObject2).findViewById(e.e.poi_video);
                  break label246;
                  localObject3 = ((View)localObject3).findViewById(e.e.divider);
                  break label260;
                  label1334:
                  localObject4 = (TextView)((View)localObject4).findViewById(e.e.video_count);
                  break label274;
                  label1350:
                  localObject6 = (LinearLayout)((View)localObject6).findViewById(e.e.bind_finder_profile);
                  break label288;
                  label1366:
                  localObject9 = (ImageView)((View)localObject9).findViewById(e.e.iv_finder_avatar);
                  break label302;
                  label1382:
                  localObject10 = (TextView)((View)localObject10).findViewById(e.e.tv_finder_name);
                  break label316;
                  label1398:
                  localObject11 = (ImageView)((View)localObject11).findViewById(e.e.iv_finder_auth_icon);
                  break label330;
                  localObject16 = ((eee)localObject16).IGU;
                  break label457;
                  localObject16 = ((eee)localObject1).IGU;
                  localObject1 = localObject16;
                  if (localObject16 != null) {
                    break label494;
                  }
                  localObject1 = "";
                  break label494;
                  localObject16 = ((eee)localObject1).IGU;
                  localObject1 = localObject16;
                  if (localObject16 != null) {
                    break label518;
                  }
                  localObject1 = "";
                  break label518;
                  label1470:
                  localObject1 = ((eee)localObject1).abjc;
                  break label557;
                  label1480:
                  localObject15 = ((eee)localObject1).abjc;
                  localObject1 = localObject15;
                  if (localObject15 != null) {
                    break label584;
                  }
                  localObject1 = "";
                  break label584;
                  label1503:
                  localObject15 = ((eee)localObject1).pSg;
                  localObject1 = localObject15;
                  if (localObject15 != null) {
                    break label631;
                  }
                  localObject1 = "";
                  break label631;
                  label1526:
                  localObject15 = ((eee)localObject1).pSh;
                  localObject1 = localObject15;
                  if (localObject15 != null) {
                    break label656;
                  }
                  localObject1 = "";
                  break label656;
                  localObject15 = ((eee)localObject1).abjf;
                  localObject1 = localObject15;
                  if (localObject15 != null) {
                    break label681;
                  }
                  localObject1 = "";
                  break label681;
                  localObject15 = ((eee)localObject1).abjg;
                  localObject1 = localObject15;
                  if (localObject15 != null) {
                    break label705;
                  }
                  localObject1 = "";
                  break label705;
                  label1595:
                  i = ((TextView)localObject13).getVisibility();
                  break label771;
                  label1604:
                  localObject13 = ((eee)localObject1).pSo;
                  localObject1 = localObject13;
                  if (localObject13 != null) {
                    break label832;
                  }
                  localObject1 = "";
                  break label832;
                  label1627:
                  localObject13 = ((eee)localObject1).pSg;
                  localObject1 = localObject13;
                  if (localObject13 != null) {
                    break label871;
                  }
                  localObject1 = "";
                  break label871;
                  label1650:
                  localObject1 = ((eef)localObject1).abjj;
                  if (localObject1 == null)
                  {
                    localObject1 = null;
                    break label894;
                  }
                  localObject1 = n.bV((String)localObject1, "\n", " ");
                  break label894;
                  localObject1 = ((eeo)localObject1).abjY;
                  if (localObject1 == null)
                  {
                    localObject1 = null;
                    break label925;
                  }
                  localObject1 = n.a((CharSequence)localObject1, new char[] { ';' }, 0, 6);
                  break label925;
                  label1726:
                  i = ((List)localObject1).size();
                  break label945;
                }
              }
              localObject1 = ah.aiuX;
            }
            localObject1 = localeel.abjz;
            if (localObject1 != null) {
              break label2227;
            }
            f = 0.0F;
            label1756:
            if (f <= 0.0F) {
              break label2246;
            }
            localObject1 = localeel.abjz;
            if (localObject1 != null) {
              break label2236;
            }
            localObject1 = null;
            label1777:
            a(this, (TextView)localObject5, (String)localObject1, Integer.valueOf(e.h.finder_poi_feed_header_price_without_unit), 8);
            localObject1 = localStringBuilder1.toString();
            s.s(localObject1, "sbReport.toString()");
            s.u(localObject1, "<set-?>");
            this.AXp = ((String)localObject1);
            if (!Util.isNullOrNil(((FinderPoiFeedLoader.b)paramIResponse).BhN)) {
              break label2346;
            }
            if (localObject8 != null) {
              ((TextView)localObject8).setVisibility(8);
            }
            label1847:
            if (this.AXn != 8)
            {
              localObject1 = this.lzt;
              if (!(localObject1 instanceof FinderPoiFeedUI)) {
                break label2380;
              }
              localObject1 = (FinderPoiFeedUI)localObject1;
              label1877:
              if (localObject1 != null)
              {
                ((FinderPoiFeedUI)localObject1).efI();
                localObject1 = ah.aiuX;
              }
            }
            if (localObject6 != null)
            {
              localObject1 = ((FinderPoiFeedLoader.b)paramIResponse).BhP;
              if (localObject1 != null) {
                break label2386;
              }
              i = 8;
              label1914:
              ((LinearLayout)localObject6).setVisibility(i);
            }
            if (localObject2 != null)
            {
              if (!((FinderPoiFeedLoader.b)paramIResponse).BhM) {
                break label2626;
              }
              this.AXo = 1L;
              if (((FinderPoiFeedLoader.b)paramIResponse).AXs > 0)
              {
                this.AXs = ((FinderPoiFeedLoader.b)paramIResponse).AXs;
                if (localObject3 != null) {
                  ((View)localObject3).setVisibility(0);
                }
                if (localObject4 != null) {
                  ((TextView)localObject4).setVisibility(0);
                }
                localObject1 = r.TQ(((FinderPoiFeedLoader.b)paramIResponse).AXs);
                localObject3 = com.tencent.mm.plugin.finder.storage.d.FAy;
                if (((Number)com.tencent.mm.plugin.finder.storage.d.eYF().bmg()).intValue() != 1) {
                  break label2578;
                }
                i = 1;
                label2018:
                if ((((FinderPoiFeedLoader.b)paramIResponse).friendLikeCount <= 0) || (i == 0)) {
                  break label2591;
                }
                if (localObject4 != null)
                {
                  ((TextView)localObject4).setTextColor(((TextView)localObject4).getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.BW_0_Alpha_0_5));
                  ((TextView)localObject4).setText((CharSequence)((TextView)localObject4).getContext().getString(e.h.finder_poi_feed_header_video_count_two, new Object[] { localObject1, Integer.valueOf(((FinderPoiFeedLoader.b)paramIResponse).friendLikeCount) }));
                  paramIResponse = ah.aiuX;
                }
                paramIResponse = com.tencent.mm.plugin.finder.report.z.FrZ;
                paramIResponse = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
                paramIResponse = as.a.hu((Context)this.lzt);
                if (paramIResponse != null) {
                  break label2583;
                }
                paramIResponse = null;
                label2126:
                com.tencent.mm.plugin.finder.report.z.b(0, "friends_like_tag", "", paramIResponse);
              }
            }
          }
        }
      }
    }
    label771:
    label1161:
    label1177:
    label1572:
    label2136:
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject2).setVisibility(i);
      paramIResponse = ah.aiuX;
      paramIResponse = ah.aiuX;
      AppMethodBeat.o(362784);
      return;
      if (localLinearLayout != null) {
        localLinearLayout.setVisibility(8);
      }
      localObject1 = localeel.abjz;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((eeo)localObject1).abjY)
      {
        a((TextView)localObject7, (String)localObject1, Integer.valueOf(e.h.finder_poi_feed_header_telephone), (kotlin.g.a.a)new c((kotlin.g.a.b)localObject12, localeel));
        break;
      }
      f = ((eeo)localObject1).MpJ;
      break label1756;
      localObject1 = ((eeo)localObject1).abkg;
      break label1777;
      localObject1 = "";
      break label1777;
      if (localObject15 != null) {
        ((TextView)localObject15).setVisibility(8);
      }
      localObject1 = this.AXl;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = (RelativeLayout)((View)localObject1).findViewById(e.e.rl_address))
      {
        if (localObject1 != null) {
          ((RelativeLayout)localObject1).setVisibility(8);
        }
        if (localObject12 != null) {
          ((TextView)localObject12).setVisibility(8);
        }
        if (localObject7 != null) {
          ((TextView)localObject7).setVisibility(8);
        }
        if (localObject5 == null) {
          break;
        }
        ((TextView)localObject5).setVisibility(8);
        break;
      }
      if (localObject8 != null) {
        ((TextView)localObject8).setText((CharSequence)((FinderPoiFeedLoader.b)paramIResponse).BhN);
      }
      if (localObject8 == null) {
        break label1847;
      }
      ((TextView)localObject8).setVisibility(0);
      break label1847;
      localObject1 = null;
      break label1877;
      localObject1 = c.a((FinderContact)localObject1);
      if (localObject1 == null)
      {
        i = 8;
        break label1914;
      }
      if (localObject9 != null)
      {
        localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject5 = com.tencent.mm.plugin.finder.loader.p.eCp();
        localObject7 = new com.tencent.mm.plugin.finder.loader.b(((m)localObject1).amx());
        localObject8 = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject5).a(localObject7, (ImageView)localObject9, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      }
      if (localObject10 != null) {
        ((TextView)localObject10).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)this.lzt, (CharSequence)((m)localObject1).getNickname()));
      }
      if (localObject11 != null)
      {
        localObject5 = ((m)localObject1).field_authInfo;
        if (localObject5 != null) {
          break label2554;
        }
      }
      for (i = 8;; i = 0)
      {
        ((ImageView)localObject11).setVisibility(i);
        if (localObject6 != null)
        {
          ((LinearLayout)localObject6).setOnClickListener(new ai.b..ExternalSyntheticLambda0((m)localObject1, this));
          localObject5 = ah.aiuX;
        }
        B(0, this.poiName, ((m)localObject1).getUsername());
        i = 0;
        break;
        label2554:
        localObject7 = av.GiL;
        av.a((ImageView)localObject11, (FinderAuthInfo)localObject5, 0, c.b((m)localObject1), 4);
      }
      i = 0;
      break label2018;
      paramIResponse = paramIResponse.fou();
      break label2126;
      if (localObject4 == null) {
        break label2136;
      }
      ((TextView)localObject4).setText((CharSequence)this.lzt.getString(e.h.finder_poi_feed_header_video_count, new Object[] { localObject1 }));
      break label2136;
      this.AXo = 0L;
    }
  }
  
  public final String b(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362732);
    s.u(paramd, "reason");
    AppMethodBeat.o(362732);
    return null;
  }
  
  public final String c(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362737);
    s.u(paramd, "reason");
    AppMethodBeat.o(362737);
    return null;
  }
  
  public final void d(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362647);
    s.u(paramd, "reason");
    super.d(paramd);
    Log.i("Finder.FinderPoiFeedUIContract.PoiFeedViewCallback", "onPoiOnRefreshEnd");
    paramd = ((ai.a)ebL()).AXh;
    if (paramd != null) {
      paramd.eES();
    }
    AppMethodBeat.o(362647);
  }
  
  public final void dUO() {}
  
  public final boolean ebN()
  {
    return true;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(362683);
    s.u(paramContext, "context");
    paramContext = dUN().fT(paramContext);
    AppMethodBeat.o(362683);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(362699);
    View localView = this.lzt.findViewById(e.e.empty_view);
    AppMethodBeat.o(362699);
    return localView;
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(362707);
    this.AXl = View.inflate((Context)this.lzt, e.f.finder_poi_feed_header, null);
    View localView = this.AXl;
    AppMethodBeat.o(362707);
    return localView;
  }
  
  public final String getIconUrl()
  {
    AppMethodBeat.i(362638);
    Object localObject = ebL().ALH.getListOfType(BaseFinderFeed.class);
    int i;
    if (!((Collection)localObject).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      localObject = (dji)kotlin.a.p.ae((List)((BaseFinderFeed)((List)localObject).get(0)).feedObject.getMediaList(), 0);
      if (localObject != null) {
        if (!Util.isNullOrNil(((dji)localObject).thumb_url_token))
        {
          localObject = s.X(((dji)localObject).thumbUrl, ((dji)localObject).thumb_url_token);
          AppMethodBeat.o(362638);
          return localObject;
          i = 0;
        }
        else
        {
          localObject = String.valueOf(((dji)localObject).thumbUrl);
          AppMethodBeat.o(362638);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(362638);
    return "";
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(362692);
    RecyclerView.h localh = dUN().getItemDecoration();
    AppMethodBeat.o(362692);
    return localh;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(kotlin.g.a.b<? super String, ah> paramb, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(kotlin.g.a.b<? super String, ah> paramb, eel parameel)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(ai.b paramb, IResponse<cc> paramIResponse)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "phone", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    e(ai.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$setTitleExposedListener$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends com.tencent.mm.view.e.b
  {
    g(ai.b paramb) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(362723);
      s.u(paramView, "view");
      if (ai.b.a(this.AXw) == null)
      {
        AppMethodBeat.o(362723);
        return;
      }
      if (paramBoolean)
      {
        this.AXw.lzt.setMMTitle("");
        AppMethodBeat.o(362723);
        return;
      }
      this.AXw.lzt.setMMTitle(this.AXw.poiName);
      AppMethodBeat.o(362723);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ai.b
 * JD-Core Version:    0.7.0.1
 */