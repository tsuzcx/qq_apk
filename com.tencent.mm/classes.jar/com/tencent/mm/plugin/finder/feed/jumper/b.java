package com.tencent.mm.plugin.finder.feed.jumper;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.webview.h;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.recyclerview.j;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/AdMutualJumperViewHandler;", "Lcom/tencent/mm/plugin/finder/feed/jumper/BaseJumperEventHandler;", "()V", "adCache", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderMutualJumpInfoCache;", "adLinkVisibleRunnable", "Ljava/lang/Runnable;", "context", "Landroid/content/Context;", "hasPreloadH5", "", "source", "", "doPreload", "", "getAdSize", "Lkotlin/Pair;", "", "jumpView", "Landroid/view/View;", "getLoadUrl", "url", "uxInfo", "getUxInfo", "Lcom/tencent/mm/json/JSONObject;", "cache", "onClickDo", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "infoEx", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "onDataUpdate", "onExposed", "isExposed", "reportAdExpose", "id", "", "reportClick", "clickPosX", "clickPosY", "reportExpose", "setAdSize", "shouldPreload", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends d
{
  public static final b.a Bdo;
  private l Bdp;
  private boolean Bdq;
  private final Runnable Bdr;
  private Context context;
  private String source;
  
  static
  {
    AppMethodBeat.i(364257);
    Bdo = new b.a((byte)0);
    AppMethodBeat.o(364257);
  }
  
  public b()
  {
    AppMethodBeat.i(364198);
    this.source = "";
    this.Bdr = new b..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(364198);
  }
  
  private static i a(l paraml)
  {
    AppMethodBeat.i(364230);
    i locali = new i();
    locali.m("uxinfo", paraml.mdG);
    AppMethodBeat.o(364230);
    return locali;
  }
  
  private static void a(View paramView, l paraml)
  {
    AppMethodBeat.i(364223);
    if ((paraml.Beg <= 0) || (paraml.Beh <= 0))
    {
      paramView = fH(paramView);
      if (paramView != null)
      {
        paraml.Beg = ((Number)paramView.bsC).intValue();
        paraml.Beh = ((Number)paramView.bsD).intValue();
      }
    }
    AppMethodBeat.o(364223);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(364242);
    s.u(paramb, "this$0");
    l locall = paramb.Bdp;
    Object localObject1;
    if ((locall != null) && (paramb.context != null))
    {
      localObject1 = as.GSQ;
      localObject1 = paramb.context;
      s.checkNotNull(localObject1);
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 != null) {
        break label150;
      }
      localObject1 = "";
    }
    for (;;)
    {
      Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = paramb.context;
      s.checkNotNull(localObject2);
      long l = ((com.tencent.mm.plugin.finder.feed.component.e)com.tencent.mm.ui.component.k.nq((Context)localObject2).q(com.tencent.mm.plugin.finder.feed.component.e.class)).enterTime;
      localObject2 = e.BdD;
      int i = e.avS(paramb.source);
      paramb = z.FrZ;
      z.a((String)localObject1, true, locall.Bed, locall.Beg, locall.Beh, locall.Bef, locall.Bee, l, i);
      AppMethodBeat.o(364242);
      return;
      label150:
      localObject2 = ((as)localObject1).zIO;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
  }
  
  private static final void a(b paramb, View paramView, l paraml, j paramj, String paramString)
  {
    AppMethodBeat.i(364252);
    s.u(paramb, "this$0");
    s.u(paramView, "$jumpView");
    s.u(paraml, "$cache");
    s.u(paramj, "$holder");
    a(paramView, paraml);
    paramView = as.GSQ;
    paramView = paramj.context;
    s.s(paramView, "holder.context");
    paramView = as.a.hu(paramView);
    if (paramView == null) {
      paramView = "";
    }
    for (;;)
    {
      paramj = com.tencent.mm.ui.component.k.aeZF;
      paramb = paramb.context;
      s.checkNotNull(paramb);
      long l = ((com.tencent.mm.plugin.finder.feed.component.e)com.tencent.mm.ui.component.k.nq(paramb).q(com.tencent.mm.plugin.finder.feed.component.e.class)).enterTime;
      paramb = e.BdD;
      int i = e.avS(paramString);
      if (!paraml.AMQ)
      {
        paramb = z.FrZ;
        z.a(paramView, false, paraml.Bed, paraml.Beg, paraml.Beh, paraml.Bef, paraml.Bee, l, i);
        paraml.AMQ = true;
      }
      AppMethodBeat.o(364252);
      return;
      paramj = paramView.zIO;
      paramView = paramj;
      if (paramj == null) {
        paramView = "";
      }
    }
  }
  
  private static String f(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = null;
    AppMethodBeat.i(364213);
    s.u(paramContext, "context");
    s.u(paramString2, "uxInfo");
    String str = URLEncoder.encode(paramString2, "UTF-8");
    StringBuilder localStringBuilder = new StringBuilder();
    paramString2 = paramString1;
    if (paramString1 == null) {
      paramString2 = "";
    }
    paramString1 = paramString2 + "&uxinfo=" + str;
    paramString2 = as.GSQ;
    paramContext = as.a.hu(paramContext);
    int i;
    if (paramContext == null)
    {
      paramContext = localObject;
      paramString2 = (CharSequence)paramContext;
      if ((paramString2 != null) && (paramString2.length() != 0)) {
        break label215;
      }
      i = 1;
      label108:
      if (i != 0) {
        break label221;
      }
    }
    label215:
    label221:
    for (paramContext = paramString1 + "&context_id=" + paramContext;; paramContext = paramString1)
    {
      paramString1 = e.BdD;
      i = e.avS(paramString3);
      paramContext = paramContext + "&pos=" + i;
      Log.i("Finder.AdMutualJumperViewHandler", s.X("loadUrl: ", paramContext));
      AppMethodBeat.o(364213);
      return paramContext;
      paramString2 = paramContext.fou();
      paramContext = localObject;
      if (paramString2 == null) {
        break;
      }
      paramContext = paramString2.zIO;
      break;
      i = 0;
      break label108;
    }
  }
  
  private static kotlin.r<Integer, Integer> fH(View paramView)
  {
    AppMethodBeat.i(364219);
    paramView = new kotlin.r(Integer.valueOf(paramView.getWidth()), Integer.valueOf(paramView.getHeight()));
    AppMethodBeat.o(364219);
    return paramView;
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(364345);
    s.u(paramk, "infoEx");
    super.a(paramk);
    if (this.Bdq) {
      edu();
    }
    AppMethodBeat.o(364345);
  }
  
  public final void a(j paramj, View paramView, k paramk)
  {
    AppMethodBeat.i(364298);
    s.u(paramj, "holder");
    s.u(paramView, "jumpView");
    s.u(paramk, "infoEx");
    Object localObject2 = edw();
    Object localObject1;
    Object localObject3;
    label121:
    long l1;
    label141:
    int k;
    int m;
    long l2;
    label225:
    int i;
    if (localObject2 != null) {
      switch (((k)localObject2).hVf.jumpinfo_type)
      {
      case 1: 
      default: 
        localObject1 = r.Bej;
        localObject3 = paramj.context;
        s.s(localObject3, "holder.context");
        r.a((r)localObject1, (Context)localObject3, (k)localObject2);
        localObject1 = ((k)localObject2).Bea;
        if ((localObject1 instanceof l))
        {
          localObject1 = (l)localObject1;
          if (localObject1 != null)
          {
            localObject2 = ((k)localObject2).AUZ;
            if (localObject2 != null) {
              break label628;
            }
            l1 = 0L;
            localObject2 = TouchableLayout.agKp;
            k = TouchableLayout.jMn();
            localObject2 = TouchableLayout.agKp;
            m = TouchableLayout.jMo();
            paramk = paramk.source;
            Log.i("Finder.AdMutualJumperViewHandler", "reportClick id:" + l1 + ", cache:" + localObject1);
            a(paramView, (l)localObject1);
            paramj = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
            if (paramj != null) {
              break label656;
            }
            l2 = 0L;
            int j = (int)(l2 / 1000L);
            if (paramj != null) {
              break label665;
            }
            i = 0;
            label241:
            if (edA()) {
              j = i;
            }
            paramj = z.FrZ;
            localObject2 = a((l)localObject1).toString();
            s.s(localObject2, "getUxInfo(cache).toString()");
            paramj = as.GSQ;
            paramj = paramView.getContext();
            s.s(paramj, "jumpView.context");
            paramj = as.a.hu(paramj);
            if (paramj != null) {
              break label674;
            }
            paramj = null;
            label301:
            z.a(l1, 1, 2, j, i, (String)localObject2, paramj);
            paramj = as.GSQ;
            paramj = paramView.getContext();
            s.s(paramj, "jumpView.context");
            paramj = as.a.hu(paramj);
            if (paramj != null) {
              break label682;
            }
            paramj = "";
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramView = com.tencent.mm.ui.component.k.aeZF;
      paramView = this.context;
      s.checkNotNull(paramView);
      l1 = ((com.tencent.mm.plugin.finder.feed.component.e)com.tencent.mm.ui.component.k.nq(paramView).q(com.tencent.mm.plugin.finder.feed.component.e.class)).enterTime;
      paramView = e.BdD;
      i = e.avS(paramk);
      paramView = z.FrZ;
      z.a(paramj, false, true, ((l)localObject1).Bed, ((l)localObject1).Beg, ((l)localObject1).Beh, k, m, ((l)localObject1).Bef, ((l)localObject1).Bee, l1, i);
      AppMethodBeat.o(364298);
      return;
      localObject1 = ((k)localObject2).Bea;
      if ((localObject1 instanceof l)) {}
      for (localObject1 = (l)localObject1; localObject1 != null; localObject1 = null)
      {
        localObject3 = paramj.context;
        s.s(localObject3, "holder.context");
        localObject1 = f((Context)localObject3, ((l)localObject1).url, ((l)localObject1).mdG, ((k)localObject2).source);
        localObject3 = paramj.context;
        s.s(localObject3, "holder.context");
        h.a((Context)localObject3, (String)localObject1, paramk);
        break;
      }
      localObject1 = ((k)localObject2).Bea;
      if ((localObject1 instanceof l)) {}
      for (localObject1 = (l)localObject1;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label620;
        }
        localObject3 = paramj.context;
        s.s(localObject3, "holder.context");
        localObject1 = f((Context)localObject3, ((l)localObject1).url, ((l)localObject1).mdG, ((k)localObject2).source);
        localObject3 = r.Bej;
        localObject3 = paramj.context;
        s.s(localObject3, "holder.context");
        r.a((Context)localObject3, paramk, (String)localObject1);
        break;
      }
      label620:
      break;
      localObject1 = null;
      break label121;
      label628:
      localObject2 = ((BaseFinderFeed)localObject2).feedObject;
      if (localObject2 == null)
      {
        l1 = 0L;
        break label141;
      }
      l1 = ((FinderItem)localObject2).getId();
      break label141;
      label656:
      l2 = paramj.getCurrentPosMs();
      break label225;
      label665:
      i = paramj.getVideoDurationSec();
      break label241;
      label674:
      paramj = paramj.fou();
      break label301;
      label682:
      paramView = paramj.zIO;
      paramj = paramView;
      if (paramView == null) {
        paramj = "";
      }
    }
  }
  
  public final void a(boolean paramBoolean, j paramj, View paramView, k paramk)
  {
    String str = null;
    AppMethodBeat.i(364315);
    s.u(paramj, "holder");
    s.u(paramView, "jumpView");
    s.u(paramk, "infoEx");
    super.a(paramBoolean, paramj, paramView, paramk);
    this.source = paramk.source;
    if (paramBoolean)
    {
      this.context = paramj.context;
      localObject = paramk.Bea;
      if (!(localObject instanceof l)) {
        break label123;
      }
    }
    l locall;
    label123:
    for (Object localObject = (l)localObject;; localObject = null)
    {
      this.Bdp = ((l)localObject);
      locall = this.Bdp;
      if (locall != null) {
        break;
      }
      paramj = str;
      if (paramj == null) {
        paramView.removeCallbacks(this.Bdr);
      }
      AppMethodBeat.o(364315);
      return;
    }
    localObject = paramk.AUZ;
    long l;
    if (localObject == null)
    {
      l = 0L;
      label144:
      Log.i("Finder.AdMutualJumperViewHandler", "reportExpose id:" + l + ", cache:" + locall);
      localObject = z.FrZ;
      str = a(locall).toString();
      s.s(str, "getUxInfo(cache).toString()");
      localObject = as.GSQ;
      localObject = paramj.context;
      s.s(localObject, "holder.context");
      localObject = as.a.hu((Context)localObject);
      if (localObject != null) {
        break label375;
      }
      localObject = null;
      label235:
      z.a(l, 1, 1, 0, 0, str, (bui)localObject);
      paramk = paramk.AUZ;
      if (paramk != null)
      {
        paramk = paramk.feedObject;
        if (paramk != null) {
          paramk.getId();
        }
      }
      paramk = this.source;
      a(paramView, locall);
      paramj = new b..ExternalSyntheticLambda1(this, paramView, locall, paramj, paramk);
      if (locall.Beg != 0) {
        break label385;
      }
      paramView.post(paramj);
    }
    for (;;)
    {
      paramView.removeCallbacks(this.Bdr);
      paramView.postDelayed(this.Bdr, 1000L);
      paramj = ah.aiuX;
      break;
      localObject = ((BaseFinderFeed)localObject).feedObject;
      if (localObject == null)
      {
        l = 0L;
        break label144;
      }
      l = ((FinderItem)localObject).getId();
      break label144;
      label375:
      localObject = ((as)localObject).fou();
      break label235;
      label385:
      paramj.run();
    }
  }
  
  public final boolean ape()
  {
    return true;
  }
  
  public final void edu()
  {
    AppMethodBeat.i(364336);
    Log.i("Finder.AdMutualJumperViewHandler", "doPreload");
    Object localObject2 = edw();
    if (localObject2 != null) {}
    switch (((k)localObject2).hVf.jumpinfo_type)
    {
    default: 
      Log.i("Finder.AdMutualJumperViewHandler", s.X("[doPreload] not support jumpinfo_type: ", Integer.valueOf(((k)localObject2).hVf.jumpinfo_type)));
      AppMethodBeat.o(364336);
      return;
    case 0: 
    case 2: 
      localObject1 = ((k)localObject2).Bea;
      if ((localObject1 instanceof l)) {}
      for (localObject1 = (l)localObject1; localObject1 != null; localObject1 = null)
      {
        Object localObject3 = edv();
        if (localObject3 != null)
        {
          localObject3 = ((j)localObject3).context;
          if (localObject3 != null)
          {
            localObject1 = f((Context)localObject3, ((l)localObject1).url, ((l)localObject1).mdG, ((k)localObject2).source);
            localObject2 = r.Bej;
            r.avT((String)localObject1);
            this.Bdq = true;
          }
        }
        AppMethodBeat.o(364336);
        return;
      }
    }
    Object localObject1 = r.Bej;
    r.b((k)localObject2);
    AppMethodBeat.o(364336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.b
 * JD-Core Version:    0.7.0.1
 */