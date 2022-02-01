package com.tencent.mm.plugin.finder.music;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.post.g;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/music/FinderTopicFollowHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "preCheckHelper", "Lcom/tencent/mm/plugin/finder/post/PostPreCheckUIC;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "checkIsCanFollow", "", "whenPreCheckReConnect", "Lkotlin/Function0;", "", "checkUserState", "getFollowBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "init", "isCopyrightRestriction", "flag", "", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "restrictCopyRight", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "showBottomSheet", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements com.tencent.mm.am.h
{
  public static final a EFe;
  private bys AwM;
  g AwN;
  final Context context;
  bqj musicInfo;
  
  static
  {
    AppMethodBeat.i(330915);
    EFe = new a((byte)0);
    AppMethodBeat.o(330915);
  }
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(330879);
    this.context = paramContext;
    AppMethodBeat.o(330879);
  }
  
  public static boolean Qv(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  private static final void a(c paramc, com.tencent.mm.plugin.finder.view.d paramd, View paramView)
  {
    AppMethodBeat.i(330898);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderTopicFollowHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramd, "$bottomSheet");
    if (AndroidContextUtil.castActivityOrNull(paramc.context) != null)
    {
      paramView = new Intent();
      paramView.putExtra("key_create_scene", 12);
      com.tencent.mm.plugin.finder.utils.a.GfO.x(paramc.context, paramView);
    }
    paramd.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderTopicFollowHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330898);
  }
  
  private static final void g(com.tencent.mm.plugin.finder.view.d paramd, View paramView)
  {
    AppMethodBeat.i(330891);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderTopicFollowHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramd, "$bottomSheet");
    paramd.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderTopicFollowHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330891);
  }
  
  private static final void j(com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(330903);
    if (params.jmw())
    {
      params.oh(1001, e.h.app_field_mmsight);
      params.oh(1002, e.h.app_field_select_new_pic);
    }
    AppMethodBeat.o(330903);
  }
  
  public final void cpX()
  {
    AppMethodBeat.i(330959);
    com.tencent.mm.plugin.finder.view.d locald = new com.tencent.mm.plugin.finder.view.d(this.context);
    locald.UD(e.f.finder_follow_topic_header_create_accoutn_bottom_sheet_layout);
    locald.rootView.findViewById(e.e.cancel).setOnClickListener(new c..ExternalSyntheticLambda1(locald));
    locald.rootView.findViewById(e.e.create_account).setOnClickListener(new c..ExternalSyntheticLambda0(this, locald));
    locald.dDn();
    AppMethodBeat.o(330959);
  }
  
  public final f eDW()
  {
    AppMethodBeat.i(330975);
    f localf = new f(this.context, 1, true);
    View localView = af.mU(this.context).inflate(e.f.finder_sheet_header, null);
    Object localObject3 = (TextView)localView.findViewById(e.e.nickname);
    Object localObject1 = (ImageView)localView.findViewById(e.e.avatar);
    Object localObject2 = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject2 = d.a.auT(com.tencent.mm.model.z.bAW());
    if (localObject2 != null)
    {
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(this.context, (CharSequence)((m)localObject2).getNickname()));
      localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject3 = com.tencent.mm.plugin.finder.loader.p.eCp();
      com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(((m)localObject2).field_avatarUrl);
      kotlin.g.b.s.s(localObject1, "avatarIv");
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject3).a(localb, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      localObject1 = av.GiL;
      kotlin.g.b.s.s(localView, "headerView");
      av.a((m)localObject2, localView);
    }
    localObject1 = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localObject1 = com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond();
    localObject2 = v.FrN;
    v.azP((String)localObject1);
    localf.af(localView, true);
    localf.Vtg = c..ExternalSyntheticLambda2.INSTANCE;
    AppMethodBeat.o(330975);
    return localf;
  }
  
  public final void o(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(330943);
    Object localObject;
    if (this.musicInfo != null)
    {
      aa.makeText(this.context, e.h.finder_can_not_follow_music, 0).show();
      localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject = this.context;
      if (paramFinderObject != null) {
        break label73;
      }
    }
    label73:
    for (paramFinderObject = null;; paramFinderObject = Integer.valueOf(paramFinderObject.follow_feed_count))
    {
      com.tencent.mm.plugin.finder.report.z.a((Context)localObject, 2, 4, paramFinderObject);
      AppMethodBeat.o(330943);
      return;
      aa.makeText(this.context, e.h.finder_can_not_follow_feed_bgm, 0).show();
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(330951);
    g localg = this.AwN;
    if (localg != null) {
      localg.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof di))) {
      this.AwM = ((di)paramp).dVy();
    }
    AppMethodBeat.o(330951);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/music/FinderTopicFollowHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.c
 * JD-Core Version:    0.7.0.1
 */