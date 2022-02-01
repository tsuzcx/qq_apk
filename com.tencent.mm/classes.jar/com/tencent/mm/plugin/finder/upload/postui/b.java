package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.webkit.ValueCallback;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.finder.publish.l.h;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.finder.view.FinderJumperView;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderChooseProductWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderJumpWidget;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "chooseView", "Lcom/tencent/mm/plugin/finder/view/FinderJumperView;", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/tencent/mm/plugin/finder/view/FinderJumperView;)V", "TAG", "", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "getChooseView", "()Lcom/tencent/mm/plugin/finder/view/FinderJumperView;", "miniAppReceiver", "com/tencent/mm/plugin/finder/upload/postui/FinderChooseProductWidget$miniAppReceiver$1", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderChooseProductWidget$miniAppReceiver$1;", "onSelectItem", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSelected", "", "getOnSelectItem", "()Lkotlin/jvm/functions/Function1;", "setOnSelectItem", "(Lkotlin/jvm/functions/Function1;)V", "productList", "", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "selectedProduct", "checkSpam", "checkVisible", "getPostData", "gotoStore", "onCreate", "jumpInfo", "refresh", "report21875", "isClick", "hasProduct", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements j
{
  public kotlin.g.a.b<? super Boolean, ah> ETr;
  private final FinderJumperView Gfk;
  FinderJumpInfo Gfl;
  List<? extends FinderJumpInfo> Gfm;
  private final a Gfn;
  final String TAG;
  final AppCompatActivity activity;
  
  public b(AppCompatActivity paramAppCompatActivity, FinderJumperView paramFinderJumperView)
  {
    AppMethodBeat.i(342854);
    this.activity = paramAppCompatActivity;
    this.Gfk = paramFinderJumperView;
    this.TAG = "Finder.FinderChooseProductWidget";
    this.Gfn = new a(this);
    AppMethodBeat.o(342854);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(342877);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/upload/postui/FinderChooseProductWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.al(true, false);
    int i;
    if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0) & 0x400000) != 0)
    {
      i = 1;
      if (i == 0) {
        break label158;
      }
      paramView = com.tencent.mm.kernel.h.baE().ban().b(at.a.adau, "");
      k.a((Context)paramb.activity, paramView, "", paramb.activity.getString(l.i.app_i_know), true, null);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/upload/postui/FinderChooseProductWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(342877);
      return;
      i = 0;
      break;
      label158:
      if (paramb.Gfl != null)
      {
        paramView = com.tencent.mm.plugin.finder.widget.post.d.Haf;
        com.tencent.mm.plugin.finder.widget.post.d.a(paramb.activity, (kotlin.g.a.a)new b(paramb), (kotlin.g.a.a)new c(paramb));
      }
      else
      {
        paramb.feD();
      }
    }
  }
  
  private void uu(boolean paramBoolean)
  {
    AppMethodBeat.i(342865);
    if (paramBoolean) {
      this.Gfk.setVisibility(0);
    }
    for (;;)
    {
      kotlin.g.a.b localb = this.ETr;
      if (localb != null) {
        localb.invoke(Boolean.valueOf(paramBoolean));
      }
      AppMethodBeat.o(342865);
      return;
      this.Gfk.setVisibility(8);
    }
  }
  
  final void al(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(342931);
    String str3 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    String str2 = this.activity.getIntent().getStringExtra("key_context_id");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    long l = System.currentTimeMillis();
    if (paramBoolean2)
    {
      str2 = "{\"if_have_good\":1}";
      if (!paramBoolean1) {
        break label141;
      }
    }
    label141:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(21875, new Object[] { str3, str1, Integer.valueOf(74), Integer.valueOf(i), String.valueOf(l), "post_good_icon", str2 });
      AppMethodBeat.o(342931);
      return;
      str2 = "{\"if_have_good\":2}";
      break;
    }
  }
  
  public final void b(FinderJumpInfo paramFinderJumpInfo)
  {
    AppMethodBeat.i(342909);
    Log.i(this.TAG, s.X("refresh :", this));
    this.Gfl = paramFinderJumpInfo;
    if (paramFinderJumpInfo == null) {
      this.Gfk.fkv();
    }
    do
    {
      uu(false);
      AppMethodBeat.o(342909);
      return;
      localObject = paramFinderJumpInfo.mini_app_info;
    } while ((paramFinderJumpInfo.jumpinfo_type != 1) || (paramFinderJumpInfo.business_type != 1) || (localObject == null));
    FinderJumperView localFinderJumperView = this.Gfk;
    Object localObject = paramFinderJumpInfo.wording;
    paramFinderJumpInfo = (FinderJumpInfo)localObject;
    if (localObject == null) {
      paramFinderJumpInfo = "";
    }
    localFinderJumperView.bX(paramFinderJumpInfo, true);
    uu(true);
    AppMethodBeat.o(342909);
  }
  
  public final void feD()
  {
    AppMethodBeat.i(342902);
    g localg = new g();
    String str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("FinderMiniAppShopAppId");
    String str1 = str2;
    if (str2 == null) {
      str1 = "wx2bff878c51bab23b";
    }
    localg.appId = str1;
    str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("FinderMiniAppShopAppId");
    str1 = str2;
    if (str2 == null) {
      str1 = "/pages/commodityToAdd/index.html?from=post";
    }
    localg.qAF = str1;
    localg.euz = 0;
    localg.idh = ((ValueCallback)this.Gfn);
    localg.scene = 1184;
    localg.qAV = true;
    Log.i(this.TAG, "appId: " + localg.appId + ", enterPath: " + localg.qAF);
    ((t)com.tencent.mm.kernel.h.ax(t.class)).a((Context)this.activity, localg);
    AppMethodBeat.o(342902);
  }
  
  public final boolean feE()
  {
    boolean bool2 = false;
    AppMethodBeat.i(342917);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0);
    if ((0x200000 & i) != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eVR().bmg()).intValue() == 1) {
        bool2 = true;
      }
      Log.i(this.TAG, "extFlag:" + i + ", ret " + bool1 + ", debugOk:" + bool2);
      if (!bool2) {
        break;
      }
      AppMethodBeat.o(342917);
      return true;
    }
    AppMethodBeat.o(342917);
    return bool1;
  }
  
  public final List<FinderJumpInfo> feF()
  {
    AppMethodBeat.i(342925);
    Object localObject = this.Gfm;
    if (localObject == null)
    {
      FinderJumpInfo localFinderJumpInfo = this.Gfl;
      if (localFinderJumpInfo == null) {
        localObject = null;
      }
      for (;;)
      {
        localObject = (List)localObject;
        AppMethodBeat.o(342925);
        return localObject;
        localObject = new ArrayList();
        ((ArrayList)localObject).add(localFinderJumpInfo);
      }
    }
    AppMethodBeat.o(342925);
    return localObject;
  }
  
  public final void hG(List<? extends FinderJumpInfo> paramList)
  {
    AppMethodBeat.i(342893);
    Log.i(this.TAG, s.X("onCreate :", this));
    Object localObject = this.Gfk;
    String str = this.activity.getString(l.i.finder_live_shopping_title);
    s.s(str, "activity.getString(R.str…nder_live_shopping_title)");
    ((FinderJumperView)localObject).setDefaultTitle(str);
    this.Gfk.setDefaultIconId(l.h.icons_outlined_shop);
    this.Gfk.setFilledIconId(l.h.icons_filled_shop);
    this.Gfm = paramList;
    if (paramList == null)
    {
      localObject = null;
      b((FinderJumpInfo)localObject);
      this.Gfk.setOnClickListener(new b..ExternalSyntheticLambda0(this));
      if (this.Gfk.getVisibility() == 0) {
        if (paramList == null) {
          break label142;
        }
      }
    }
    label142:
    for (boolean bool = true;; bool = false)
    {
      al(false, bool);
      AppMethodBeat.o(342893);
      return;
      localObject = (FinderJumpInfo)p.oL(paramList);
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/postui/FinderChooseProductWidget$miniAppReceiver$1", "Landroid/webkit/ValueCallback;", "", "onReceiveValue", "", "value", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ValueCallback<String>
  {
    a(b paramb) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.b
 * JD-Core Version:    0.7.0.1
 */