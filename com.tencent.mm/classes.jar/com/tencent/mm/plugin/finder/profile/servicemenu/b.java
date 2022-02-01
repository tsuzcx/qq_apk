package com.tencent.mm.plugin.finder.profile.servicemenu;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.jumper.r;
import com.tencent.mm.plugin.finder.profile.uic.l;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.Html5Info;
import com.tencent.mm.protocal.protobuf.MiniAppInfo;
import com.tencent.mm.protocal.protobuf.NativeInfo;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/servicemenu/ProfileMenuConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/profile/servicemenu/ProfileJumpInfo;", "()V", "buildReportJson", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "jumpInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "getLayoutId", "", "getMenuUrl", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f<a>
{
  public static final a Fcq;
  
  static
  {
    AppMethodBeat.i(349221);
    Fcq = new a((byte)0);
    AppMethodBeat.o(349221);
  }
  
  private static final void a(j paramj, a parama, b paramb, View paramView)
  {
    AppMethodBeat.i(349202);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(parama);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/servicemenu/ProfileMenuConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(parama, "$item");
    s.u(paramb, "this$0");
    paramb = r.Bej;
    paramView = paramj.context;
    s.s(paramView, "holder.context");
    r.a(paramb, paramView, parama.Fcp);
    paramb = as.GSQ;
    paramb = paramj.context;
    s.s(paramb, "holder.context");
    paramb = as.a.hu(paramb);
    if (paramb == null)
    {
      paramb = null;
      paramj = paramj.context;
      s.s(paramj, "holder.context");
      paramView = b(paramj, parama.Fcp.hVf);
      paramj = parama.Fcp.contact;
      if (paramj != null) {
        break label223;
      }
      paramj = "";
    }
    for (;;)
    {
      paramView.put("finderusername", paramj);
      paramj = bb.FuK;
      bb.a(paramb, "menu", 1, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/servicemenu/ProfileMenuConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349202);
      return;
      paramb = paramb.fou();
      break;
      label223:
      parama = paramj.getUsername();
      paramj = parama;
      if (parama == null) {
        paramj = "";
      }
    }
  }
  
  private static JSONObject b(Context paramContext, FinderJumpInfo paramFinderJumpInfo)
  {
    Object localObject3 = null;
    localObject2 = null;
    AppMethodBeat.i(349168);
    int i = paramFinderJumpInfo.jumpinfo_type;
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("iconname", paramFinderJumpInfo.wording);
    localJSONObject1.put("iconurl", c(paramContext, paramFinderJumpInfo));
    JSONObject localJSONObject2 = new JSONObject();
    switch (i)
    {
    }
    for (;;)
    {
      paramContext = localJSONObject2.toString();
      s.s(paramContext, "utf_kv.toString()");
      localJSONObject1.put("utf_kv", n.bV(paramContext, ",", ";"));
      AppMethodBeat.o(349168);
      return localJSONObject1;
      localJSONObject1.put("icontype", 1);
      paramContext = paramFinderJumpInfo.mini_app_info;
      if (paramContext == null)
      {
        paramContext = "";
        label145:
        localJSONObject2.put("appid", paramContext);
        paramContext = paramFinderJumpInfo.mini_app_info;
        if (paramContext != null) {
          break label195;
        }
        paramContext = "";
      }
      Object localObject1;
      for (;;)
      {
        localJSONObject2.put("path", paramContext);
        break;
        localObject1 = paramContext.app_id;
        paramContext = (Context)localObject1;
        if (localObject1 != null) {
          break label145;
        }
        paramContext = "";
        break label145;
        label195:
        paramFinderJumpInfo = paramContext.path;
        paramContext = paramFinderJumpInfo;
        if (paramFinderJumpInfo == null) {
          paramContext = "";
        }
      }
      localJSONObject1.put("icontype", 3);
      paramContext = paramFinderJumpInfo.html5_info;
      if (paramContext == null) {
        paramContext = "";
      }
      for (;;)
      {
        localJSONObject2.put("url", paramContext);
        break;
        paramFinderJumpInfo = paramContext.url;
        paramContext = paramFinderJumpInfo;
        if (paramFinderJumpInfo == null) {
          paramContext = "";
        }
      }
      paramContext = paramFinderJumpInfo.native_info;
      if (paramContext == null)
      {
        localObject1 = null;
        label274:
        paramContext = paramFinderJumpInfo.native_info;
        if (paramContext != null) {
          break label396;
        }
        paramContext = "";
      }
      try
      {
        for (;;)
        {
          paramContext = new JSONObject(paramContext);
          paramFinderJumpInfo = paramContext;
          if (paramContext == null) {
            paramFinderJumpInfo = new JSONObject();
          }
          if (localObject1 != null) {
            break label429;
          }
          if ((localObject1 == null) || (((Integer)localObject1).intValue() != 7)) {
            break;
          }
          localJSONObject1.put("icontype", 4);
          try
          {
            if (paramFinderJumpInfo.has("kf_url") != true) {
              break label524;
            }
            i = 1;
            paramContext = localObject2;
            if (i != 0) {
              paramContext = paramFinderJumpInfo.getString("kf_url");
            }
          }
          catch (Exception paramContext)
          {
            for (;;)
            {
              Log.printDebugStack("safeGetString", "", new Object[] { paramContext });
              paramContext = localObject2;
            }
          }
          paramFinderJumpInfo = paramContext;
          if (paramContext == null) {
            paramFinderJumpInfo = "";
          }
          localJSONObject2.put("kf_url", paramFinderJumpInfo);
          break;
          localObject1 = Integer.valueOf(paramContext.native_type);
          break label274;
          label396:
          paramFinderJumpInfo = paramContext.necessary_params;
          paramContext = paramFinderJumpInfo;
          if (paramFinderJumpInfo == null) {
            paramContext = "";
          }
        }
      }
      catch (JSONException paramContext)
      {
        label524:
        for (;;)
        {
          Log.e("ProfileMenuConvert", paramContext.getMessage());
          paramContext = null;
          continue;
          label429:
          if (((Integer)localObject1).intValue() == 2)
          {
            localJSONObject1.put("icontype", 2);
            for (;;)
            {
              try
              {
                if (paramFinderJumpInfo.has("cardId") != true) {
                  continue;
                }
                i = 1;
                paramContext = localObject3;
                if (i != 0) {
                  paramContext = paramFinderJumpInfo.getString("cardId");
                }
              }
              catch (Exception paramContext)
              {
                Log.printDebugStack("safeGetString", "", new Object[] { paramContext });
                paramContext = localObject3;
                continue;
              }
              paramFinderJumpInfo = paramContext;
              if (paramContext == null) {
                paramFinderJumpInfo = "";
              }
              localJSONObject2.put("cardId", paramFinderJumpInfo);
              break;
              i = 0;
            }
            i = 0;
          }
        }
      }
    }
  }
  
  private static String c(Context paramContext, FinderJumpInfo paramFinderJumpInfo)
  {
    AppMethodBeat.i(349183);
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    boolean bool1 = ((l)com.tencent.mm.ui.component.k.nq(paramContext).q(l.class)).Ffq;
    boolean bool2 = aw.isDarkMode();
    if (bool1)
    {
      paramContext = paramFinderJumpInfo.icon_url_bg;
      if (paramContext == null)
      {
        AppMethodBeat.o(349183);
        return "";
      }
      AppMethodBeat.o(349183);
      return paramContext;
    }
    if (bool2)
    {
      paramContext = paramFinderJumpInfo.icon_url_dark;
      if (paramContext == null)
      {
        AppMethodBeat.o(349183);
        return "";
      }
      AppMethodBeat.o(349183);
      return paramContext;
    }
    paramContext = paramFinderJumpInfo.icon_url;
    if (paramContext == null)
    {
      AppMethodBeat.o(349183);
      return "";
    }
    AppMethodBeat.o(349183);
    return paramContext;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(349261);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(349261);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_profile_service_menu_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/servicemenu/ProfileMenuConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/servicemenu/ProfileMenuConvert$onBindViewHolder$3", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends e.b
  {
    b(j paramj, b paramb, a parama) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(349124);
      s.u(paramView, "view");
      bui localbui;
      JSONObject localJSONObject;
      if (paramBoolean)
      {
        paramView = as.GSQ;
        paramView = this.wHm.context;
        s.s(paramView, "holder.context");
        paramView = as.a.hu(paramView);
        if (paramView != null) {
          break label123;
        }
        localbui = null;
        paramView = this.wHm.context;
        s.s(paramView, "holder.context");
        localJSONObject = b.d(paramView, this.Fcs.Fcp.hVf);
        paramView = this.Fcs.Fcp.contact;
        if (paramView != null) {
          break label132;
        }
        paramView = "";
      }
      for (;;)
      {
        localJSONObject.put("finderusername", paramView);
        paramView = bb.FuK;
        bb.a(localbui, "menu", 0, localJSONObject);
        AppMethodBeat.o(349124);
        return;
        label123:
        localbui = paramView.fou();
        break;
        label132:
        String str = paramView.getUsername();
        paramView = str;
        if (str == null) {
          paramView = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.servicemenu.b
 * JD-Core Version:    0.7.0.1
 */