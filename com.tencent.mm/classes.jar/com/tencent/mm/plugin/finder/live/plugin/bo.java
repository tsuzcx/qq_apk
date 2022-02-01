package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "anchorAuthIcon", "Landroid/widget/ImageView;", "anchorExtAuthTv", "Landroid/widget/TextView;", "anchorExtFriendFollowCountTv", "anchorExtInfoLayout", "Landroid/widget/LinearLayout;", "anchorName", "anchorProfile", "avatar", "backBtn", "loadingProgressBar", "Landroid/widget/ProgressBar;", "needAnimation", "", "getNeedAnimation", "()Z", "setNeedAnimation", "(Z)V", "okBtn", "Landroid/widget/Button;", "rootContent", "Landroid/widget/RelativeLayout;", "title", "fillAnchorInfo", "", "authProfession", "friendFollowCount", "", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "show", "unMount", "updateBg", "bgUrl", "contactUsername", "updateFinishInfo", "plugin-finder_release"})
public final class bo
  extends d
  implements i
{
  public final String TAG;
  private final ImageView hNZ;
  public final RelativeLayout hOm;
  final com.tencent.mm.live.c.b hOy;
  private final Button hPX;
  private final TextView hbb;
  private final ImageView keC;
  private final TextView uuO;
  private final TextView uuP;
  private final LinearLayout uuQ;
  private final TextView uuR;
  private final TextView uuS;
  private final ImageView uuT;
  public final ProgressBar uuU;
  public boolean uuV;
  
  public bo(final ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247121);
    this.hOy = paramb;
    this.TAG = "Finder.LiveVisitorAfterPlugin";
    paramb = paramViewGroup.findViewById(2131309195);
    p.g(paramb, "root.findViewById(R.id.title)");
    this.hbb = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131296746);
    p.g(paramb, "root.findViewById(R.id.anchor_avatar)");
    this.keC = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131296753);
    p.g(paramb, "root.findViewById(R.id.anchor_name)");
    this.uuO = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131309904);
    p.g(paramb, "root.findViewById(R.id.visit_anchor_profile)");
    this.uuP = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303251);
    p.g(paramb, "root.findViewById(R.id.live_after_finish_btn)");
    this.hPX = ((Button)paramb);
    paramb = paramViewGroup.findViewById(2131303308);
    p.g(paramb, "root.findViewById(R.id.live_after_ui_root_group)");
    this.hOm = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131296751);
    p.g(paramb, "root.findViewById(R.id.anchor_ext_info_layout)");
    this.uuQ = ((LinearLayout)paramb);
    paramb = paramViewGroup.findViewById(2131296749);
    p.g(paramb, "root.findViewById(R.id.anchor_ext_info_auth)");
    this.uuR = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131296750);
    p.g(paramb, "root.findViewById(R.id.a…_info_friend_floow_count)");
    this.uuS = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131296745);
    p.g(paramb, "root.findViewById(R.id.anchor_auth_icon)");
    this.uuT = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131297167);
    p.g(paramb, "root.findViewById(R.id.back_icon)");
    this.hNZ = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131303694);
    p.g(paramb, "root.findViewById(R.id.loading_bar)");
    this.uuU = ((ProgressBar)paramb);
    this.uuV = true;
    this.hPX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(247113);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.uuW.hOy.statusChange(b.c.hLD, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(247113);
      }
    });
    this.uuP.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(247114);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = this.uuW.getLiveData().hwd;
        localObject = new Intent();
        ((Intent)localObject).putExtra("finder_username", paramAnonymousView);
        ((Intent)localObject).putExtra("key_enter_profile_type", 11);
        ((aj)com.tencent.mm.kernel.g.ah(aj.class)).enterFinderProfileUI(paramViewGroup.getContext(), (Intent)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(247114);
      }
    });
    paramb = this.hbb;
    if (paramb != null) {}
    for (paramb = paramb.getLayoutParams(); paramb == null; paramb = null)
    {
      paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(247121);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.topMargin += au.getStatusBarHeight(MMApplicationContext.getContext());
    paramb = this.hPX;
    if (paramb != null) {}
    for (paramb = paramb.getLayoutParams(); paramb == null; paramb = null)
    {
      paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(247121);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.bottomMargin += au.aD(MMApplicationContext.getContext());
    ao.a((Paint)this.hbb.getPaint(), 0.8F);
    ao.a((Paint)this.uuO.getPaint(), 0.8F);
    ao.a((Paint)this.hPX.getPaint(), 0.8F);
    this.hOm.setVisibility(8);
    this.uuU.setVisibility(8);
    this.hNZ.setImageDrawable(ar.m(paramViewGroup.getContext(), 2131690485, -1));
    this.hNZ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(247115);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.uuW.hOy.statusChange(b.c.hLD, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(247115);
      }
    });
    paramViewGroup.setTranslationX(au.az(paramViewGroup.getContext()).x);
    AppMethodBeat.o(247121);
  }
  
  public final void a(String paramString, int paramInt, FinderAuthInfo paramFinderAuthInfo)
  {
    AppMethodBeat.i(247118);
    if ((Util.isNullOrNil(paramString)) && (paramInt <= 0)) {
      this.uuQ.setVisibility(8);
    }
    for (;;)
    {
      if (paramFinderAuthInfo != null)
      {
        paramString = y.vXH;
        y.a(this.uuT, paramFinderAuthInfo, 0);
      }
      AppMethodBeat.o(247118);
      return;
      Log.i(this.TAG, "authProfession:" + paramString + ", friendFollowCount:" + paramInt);
      this.uuQ.setVisibility(0);
      Object localObject1;
      if (!Util.isNullOrNil(paramString))
      {
        localObject1 = this.hwr.getContext();
        p.g(localObject1, "root.context");
        paramString = ((Context)localObject1).getResources().getString(2131759608, new Object[] { paramString });
        p.g(paramString, "root.context.resources.g…act_auth, authProfession)");
        this.uuR.setText((CharSequence)paramString);
        this.uuR.setVisibility(0);
        label162:
        localObject1 = "";
        if (paramInt <= 0) {
          break label424;
        }
        localObject1 = this.hwr.getContext();
        p.g(localObject1, "root.context");
        localObject1 = ((Context)localObject1).getResources().getString(2131759795, new Object[] { k.Lv(paramInt) });
        p.g(localObject1, "root.context.resources.g…umber(friendFollowCount))");
        this.uuS.setText((CharSequence)localObject1);
        this.uuS.setVisibility(0);
      }
      for (;;)
      {
        Object localObject2 = this.hwr.getContext();
        p.g(localObject2, "root.context");
        localObject2 = ((Context)localObject2).getResources();
        p.g(localObject2, "root.context.resources");
        paramInt = ((Resources)localObject2).getDisplayMetrics().widthPixels;
        localObject2 = this.hwr.getContext();
        p.g(localObject2, "root.context");
        int i = ((Context)localObject2).getResources().getDimensionPixelOffset(2131165289);
        localObject2 = this.uuR.getPaint();
        float f1 = ((TextPaint)localObject2).measureText((String)localObject1);
        float f2 = ((TextPaint)localObject2).measureText(paramString);
        float f3 = i;
        paramString = this.hwr.getContext();
        p.g(paramString, "root.context");
        if (f1 + f2 + f3 + paramString.getResources().getDimensionPixelOffset(2131165299) * 2 >= paramInt) {
          break label436;
        }
        this.uuS.setPadding(i, 0, 0, 0);
        this.uuQ.setOrientation(0);
        break;
        this.uuR.setVisibility(8);
        paramString = "";
        break label162;
        label424:
        this.uuS.setVisibility(8);
      }
      label436:
      this.uuS.setPadding(0, 0, 0, 0);
      this.uuQ.setOrientation(1);
    }
  }
  
  public final void gL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(247117);
    Object localObject = com.tencent.mm.plugin.finder.live.util.g.uwd;
    com.tencent.mm.plugin.finder.live.util.g.a(paramString2, getLiveData().uEu, (View)this.hOm);
    localObject = m.uJa;
    localObject = m.dka();
    paramString1 = new com.tencent.mm.plugin.finder.loader.a(paramString1);
    ImageView localImageView = this.keC;
    m localm = m.uJa;
    ((com.tencent.mm.loader.d)localObject).a(paramString1, localImageView, m.a(m.a.uJe));
    paramString1 = y.vXH;
    localObject = getLiveData().uDz;
    paramString1 = paramString2;
    if (localObject != null)
    {
      localObject = ((FinderObject)localObject).contact;
      paramString1 = paramString2;
      if (localObject != null)
      {
        paramString1 = ((FinderContact)localObject).username;
        if (paramString1 != null) {
          break label194;
        }
        paramString1 = paramString2;
      }
    }
    label194:
    for (;;)
    {
      paramString2 = getLiveData().uDz;
      if (paramString2 != null)
      {
        paramString2 = paramString2.contact;
        if (paramString2 == null) {}
      }
      for (paramString2 = paramString2.nickname;; paramString2 = null)
      {
        paramString1 = y.hf(paramString1, paramString2);
        this.uuO.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.hwr.getContext(), (CharSequence)paramString1));
        this.hOm.setVisibility(0);
        this.uuU.setVisibility(8);
        AppMethodBeat.o(247117);
        return;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Object localObject = null;
    AppMethodBeat.i(247119);
    Log.i(this.TAG, "onSceneEnd errType:" + paramInt1 + ", errCode:" + paramInt2 + ", scene:" + paramq);
    FinderContact localFinderContact;
    if ((paramq instanceof cn))
    {
      localFinderContact = ((cn)paramq).cZk();
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("update bg,user page isOnlyFetchUserInfo:").append(((cn)paramq).twC).append(", local username:").append(getLiveData().hwd).append(",contact username:");
      if (localFinderContact == null) {
        break label319;
      }
      paramString = localFinderContact.username;
      Log.i(str, paramString);
      if ((((cn)paramq).twC) && (p.j(((cn)paramq).tuH, getLiveData().hwd)))
      {
        paramString = com.tencent.mm.kernel.g.aAg();
        p.g(paramString, "MMKernel.network()");
        paramString.azz().b(3736, (i)this);
        if (localFinderContact != null)
        {
          str = localFinderContact.headUrl;
          if (str != null)
          {
            p.g(str, "it");
            paramq = localFinderContact.username;
            paramString = paramq;
            if (paramq == null) {
              paramString = getLiveData().hwd;
            }
            gL(str, paramString);
          }
        }
        if (localFinderContact == null) {
          break label324;
        }
        paramString = localFinderContact.authInfo;
        if (paramString == null) {
          break label324;
        }
      }
    }
    label319:
    label324:
    for (paramString = paramString.authProfession;; paramString = null)
    {
      paramInt1 = getLiveData().friendFollowCount;
      paramq = localObject;
      if (localFinderContact != null) {
        paramq = localFinderContact.authInfo;
      }
      a(paramString, paramInt1, paramq);
      AppMethodBeat.o(247119);
      return;
      paramString = null;
      break;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(247120);
    super.unMount();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(3736, (i)this);
    AppMethodBeat.o(247120);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class a
    implements Runnable
  {
    public a(bo parambo) {}
    
    public final void run()
    {
      AppMethodBeat.i(247116);
      this.uuW.rg(0);
      AppMethodBeat.o(247116);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bo
 * JD-Core Version:    0.7.0.1
 */