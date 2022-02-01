package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.d.b.a;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.report.live.s.ar;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "anchorAvatarUrl", "anchorNickname", "authIv", "Landroid/widget/ImageView;", "avatarIcon", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "nameTv", "Landroid/widget/TextView;", "adjustMarginEnd", "", "canClearScreen", "", "goToFinderProfile", "goToFinderProfileImpl", "onPortraitDelayAction", "extraMsg", "Landroid/os/Bundle;", "delayMs", "", "resume", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "updateLiveTitle", "anchorUsername", "Companion", "plugin-finder_release"})
public final class bh
  extends d
{
  private static final String uuf = "PORTRAIT_ACTION_GOTO_PROFILE";
  public static final a uug;
  final String TAG;
  private Context context;
  private final TextView gxs;
  private final com.tencent.mm.live.c.b hOp;
  private int hOw;
  private final ImageView hXu;
  private final bbn reportObj;
  private final ImageView uuc;
  private String uud;
  private String uue;
  
  static
  {
    AppMethodBeat.i(247066);
    uug = new a((byte)0);
    uuf = "PORTRAIT_ACTION_GOTO_PROFILE";
    AppMethodBeat.o(247066);
  }
  
  public bh(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, bbn parambbn)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247065);
    this.hOp = paramb;
    this.reportObj = parambbn;
    this.TAG = "Finder.LiveTitlePlugin";
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131303591);
    p.g(paramb, "root.findViewById(R.id.l…e_title_info_avatar_icon)");
    this.hXu = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131303593);
    p.g(paramb, "root.findViewById(R.id.live_title_info_name_tv)");
    this.gxs = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303594);
    p.g(paramb, "root.findViewById(R.id.live_title_info_tag_iv)");
    this.uuc = ((ImageView)paramb);
    this.hOw = au.aD(paramViewGroup.getContext());
    paramViewGroup = (View.OnClickListener)new b(this);
    this.hXu.setOnClickListener(paramViewGroup);
    paramb = this.hXu;
    parambbn = this.context;
    p.g(parambbn, "context");
    paramb.setImageDrawable(parambbn.getResources().getDrawable(2131231966));
    this.gxs.setOnClickListener(paramViewGroup);
    paramViewGroup = com.tencent.mm.plugin.finder.utils.m.vVH;
    com.tencent.mm.plugin.finder.utils.m.a((d)this, true);
    paramViewGroup = com.tencent.mm.plugin.finder.utils.m.vVH;
    com.tencent.mm.plugin.finder.utils.m.a((d)this);
    AppMethodBeat.o(247065);
  }
  
  private final void dhR()
  {
    AppMethodBeat.i(247059);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_profile_share_scene", 0);
    if (Util.isNullOrNil(getLiveData().hwd))
    {
      localIntent.putExtra("finder_username", "");
      localIntent.putExtra("key_finder_object_Id", getLiveData().hFK);
      localIntent.putExtra("key_finder_object_nonce_id_key", getLiveData().hwg);
    }
    for (;;)
    {
      localIntent.putExtra("key_enter_profile_type", 11);
      Object localObject = this.reportObj;
      if (localObject != null)
      {
        String str = ((bbn)localObject).sGQ;
        localObject = ((bbn)localObject).sGE;
        if (!TextUtils.isEmpty((CharSequence)str)) {
          localIntent.putExtra("key_context_id", str);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localIntent.putExtra("key_click_tab_context_id", (String)localObject);
        }
      }
      ((aj)com.tencent.mm.kernel.g.ah(aj.class)).enterFinderProfileUI(this.hwr.getContext(), localIntent);
      AppMethodBeat.o(247059);
      return;
      localIntent.putExtra("finder_username", getLiveData().hwd);
    }
  }
  
  public final void a(Bundle paramBundle, final long paramLong)
  {
    AppMethodBeat.i(247064);
    if (paramBundle != null)
    {
      String str = paramBundle.getString("POST_PORTRAIT_ACTION", "");
      paramBundle = str;
      if (str != null) {}
    }
    else
    {
      paramBundle = "";
    }
    if (p.j(paramBundle, uuf)) {
      com.tencent.mm.ac.d.a(paramLong, (Runnable)new c(this, paramLong));
    }
    AppMethodBeat.o(247064);
  }
  
  public final void atN(String paramString)
  {
    AppMethodBeat.i(247061);
    p.h(paramString, "anchorUsername");
    Object localObject1 = c.tsp;
    com.tencent.mm.plugin.finder.api.g localg = c.a.asG(paramString);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("updateLiveTitle contact avatarUrl is null:");
    boolean bool;
    if (localg != null)
    {
      localObject1 = localg.cXH();
      if (localObject1 != null) {
        break label358;
      }
      bool = true;
      label58:
      Log.i((String)localObject2, bool + ' ' + paramString + ",liveData username:" + getLiveData().hwd);
      if (localg != null)
      {
        if (!isLandscape())
        {
          paramString = this.hwr.getLayoutParams();
          if (paramString != null)
          {
            if (!getLiveData().djm()) {
              break label363;
            }
            ((ViewGroup.MarginLayoutParams)paramString).setMarginEnd(at.fromDPToPix(this.hwr.getContext(), 160));
          }
        }
        label151:
        this.uud = localg.getNickname();
        this.uue = localg.cXH();
        paramString = com.tencent.mm.plugin.finder.loader.m.uJa;
        paramString = com.tencent.mm.plugin.finder.loader.m.dka();
        localObject1 = new com.tencent.mm.plugin.finder.loader.a(this.uue);
        localObject2 = com.tencent.mm.plugin.finder.loader.m.uJa;
        paramString.a(localObject1, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe)).a((e)new d(this)).vC();
        this.gxs.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(this.context, (CharSequence)this.uud, this.gxs.getTextSize()));
        if (localg.field_authInfo == null) {
          break label426;
        }
        if (localg.field_authInfo.authIconType <= 0) {
          break label385;
        }
        this.gxs.setPadding(this.gxs.getPaddingLeft(), this.gxs.getPaddingTop(), at.fromDPToPix(this.hwr.getContext(), 20), this.gxs.getPaddingBottom());
        this.uuc.setVisibility(0);
        paramString = y.vXH;
        y.a(this.uuc, localg.field_authInfo, 0);
      }
    }
    for (;;)
    {
      this.gxs.requestLayout();
      AppMethodBeat.o(247061);
      return;
      localObject1 = null;
      break;
      label358:
      bool = false;
      break label58;
      label363:
      ((ViewGroup.MarginLayoutParams)paramString).setMarginEnd(at.fromDPToPix(this.hwr.getContext(), 112));
      break label151;
      label385:
      this.gxs.setPadding(this.gxs.getPaddingLeft(), this.gxs.getPaddingTop(), 0, this.gxs.getPaddingBottom());
      this.uuc.setVisibility(8);
      continue;
      label426:
      this.gxs.setPadding(this.gxs.getPaddingLeft(), this.gxs.getPaddingTop(), 0, this.gxs.getPaddingBottom());
      this.uuc.setVisibility(8);
    }
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(247060);
    super.resume();
    int j = au.aD(this.hwr.getContext());
    int i = j;
    if (j == 0) {
      i = at.fromDPToPix(this.hwr.getContext(), 16);
    }
    this.hOw = i;
    AppMethodBeat.o(247060);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247063);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (bi.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247063);
      return;
      rg(4);
      AppMethodBeat.o(247063);
      return;
      paramc = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.m.a((d)this, true);
      paramc = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.m.a((d)this);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$Companion;", "", "()V", "PORTRAIT_ACTION_GOTO_PROFILE", "", "getPORTRAIT_ACTION_GOTO_PROFILE", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(bh parambh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(247055);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$avatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.live.core.core.d.b.hCo;
      if (b.a.aDp())
      {
        bh.e(this.uuh);
        if (bh.f(this.uuh).getLiveRole() == 0)
        {
          paramView = com.tencent.mm.plugin.finder.report.live.m.vli;
          com.tencent.mm.plugin.finder.report.live.m.vkK = true;
          com.tencent.mm.plugin.finder.report.live.m.a(s.ar.vrq, null);
          com.tencent.mm.plugin.finder.report.live.m.vku += 1;
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$avatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247055);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(bh parambh, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(247056);
      if (!this.uuh.isFinished())
      {
        bh.d(this.uuh);
        AppMethodBeat.o(247056);
        return;
      }
      Log.i(this.uuh.TAG, "goToFinderProfileImpl delayMs:" + paramLong + ",isFinished!");
      AppMethodBeat.o(247056);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class d<T, R>
    implements e<o, Bitmap>
  {
    d(bh parambh) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bh
 * JD-Core Version:    0.7.0.1
 */