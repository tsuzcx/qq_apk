package com.tencent.mm.plugin.finder.live.b;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.af;
import com.tencent.d.a.a.a.b.c.a;
import com.tencent.d.a.a.a.b.c.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.cgi.x;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.cy;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.util.ai;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.plugin.finder.live.viewmodel.data.j;
import com.tencent.mm.plugin.finder.view.i;
import com.tencent.mm.plugin.finder.view.i.a;
import com.tencent.mm.plugin.finder.view.i.b;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentActionPresenter;", "", "context", "Landroid/content/Context;", "liveRole", "", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxCommentPlugin;", "(Landroid/content/Context;ILcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxCommentPlugin;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "chosenCommentViewBg", "Landroid/graphics/drawable/Drawable;", "getContext", "()Landroid/content/Context;", "getLiveRole", "()I", "getPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxCommentPlugin;", "anchorAction", "", "msg", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;", "view", "Landroid/view/View;", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "canLikeMessage", "", "canShowVisitorActionUI", "complaintMsg", "disLike", "gotoWxProfile", "username", "like", "notMyselfMsg", "onAction", "isAnchor", "setCommentChoseBg", "visitorAction", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private Drawable CXT;
  private final String TAG;
  private final int Zus;
  private final cy Zut;
  private final Context context;
  
  public a(Context paramContext, cy paramcy)
  {
    AppMethodBeat.i(370934);
    this.context = paramContext;
    this.Zus = 0;
    this.Zut = paramcy;
    this.TAG = "BoxCommentActionPresenter";
    AppMethodBeat.o(370934);
  }
  
  private static final void a(View paramView, a parama)
  {
    AppMethodBeat.i(370983);
    kotlin.g.b.s.u(paramView, "$view");
    kotlin.g.b.s.u(parama, "this$0");
    paramView.setBackground(parama.CXT);
    AppMethodBeat.o(370983);
  }
  
  private static final void a(a parama, com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb, View paramView, MenuItem paramMenuItem, int paramInt)
  {
    Object localObject = null;
    int i = 0;
    AppMethodBeat.i(370977);
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramb, "$msg");
    kotlin.g.b.s.u(paramView, "$view");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      paramView.setBackground(parama.CXT);
      parama = i.GzZ;
      i.fkK();
      AppMethodBeat.o(370977);
      return;
      parama.a(paramb);
      k.Doi.aa(14, paramb.kKZ(), paramb.getContent());
      continue;
      parama.b(paramb);
      k.Doi.aa(17, paramb.kKZ(), paramb.getContent());
      continue;
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
      paramMenuItem = paramb.akfZ.ZOb;
      if (paramMenuItem == null) {}
      for (paramMenuItem = (MenuItem)localObject;; paramMenuItem = paramMenuItem.toByteArray())
      {
        localBundle.putByteArray("PARAM_ENTER_COMMENT_AT_NAME", paramMenuItem);
        localBundle.putBoolean("PARAM_ENTER_COMMENT_HIDE_AT_ENTRANCE", true);
        parama.Zut.nfT.statusChange(b.c.ncO, localBundle);
        k.Doi.aa(4, paramb.kKZ(), paramb.getContent());
        break;
      }
      paramMenuItem = MMApplicationContext.getContext().getSystemService("clipboard");
      if (paramMenuItem == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
        AppMethodBeat.o(370977);
        throw parama;
      }
      ((ClipboardManager)paramMenuItem).setText((CharSequence)paramb.getContent());
      k.Doi.aa(5, paramb.kKZ(), paramb.getContent());
      continue;
      paramMenuItem = new bui();
      localObject = aj.CGT;
      localObject = aj.egD();
      if (localObject == null)
      {
        paramInt = 0;
        label355:
        paramMenuItem.hLK = paramInt;
        localObject = aj.CGT;
        localObject = aj.egD();
        if (localObject != null) {
          break label525;
        }
        paramInt = i;
      }
      for (;;)
      {
        paramMenuItem.AJo = paramInt;
        localObject = x.CvN;
        long l = paramb.akfZ.seq;
        localObject = new bdm();
        ((bdm)localObject).ZNX = l;
        ((bdm)localObject).msg_type = 20008;
        new x((bdm)localObject, parama.Zut.getBuContext(), paramMenuItem, null).bFJ();
        paramMenuItem = parama.context.getResources().getString(p.h.CjB);
        kotlin.g.b.s.s(paramMenuItem, "context.resources.getStr…nder_live_complaint_done)");
        aa.a(parama.context, paramMenuItem, a..ExternalSyntheticLambda1.INSTANCE);
        k.Doi.aa(6, paramb.kKZ(), paramb.getContent());
        break;
        localObject = ((g)localObject).Bwy;
        if (localObject == null)
        {
          paramInt = 0;
          break label355;
        }
        paramInt = ((j)localObject).AJo;
        break label355;
        label525:
        localObject = ((g)localObject).Bwy;
        paramInt = i;
        if (localObject != null) {
          paramInt = ((j)localObject).AJo;
        }
      }
      paramMenuItem = parama.context;
      paramb = paramb.aJO();
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", paramb);
      c.b(paramMenuItem, "profile", ".ui.ContactInfoUI", (Intent)localObject);
    }
  }
  
  private static final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb, View paramView1, a parama, com.tencent.mm.ui.base.s params, View paramView2, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(370968);
    kotlin.g.b.s.u(paramb, "$msg");
    kotlin.g.b.s.u(paramView1, "$view");
    kotlin.g.b.s.u(parama, "this$0");
    if ((paramb.akfZ.seq > 0L) && (params.findItem(165) == null)) {
      if (paramb.akga) {
        params.a(166, (CharSequence)paramView1.getContext().getString(p.h.XMv), paramView1.getContext().getResources().getColor(p.b.finder_live_logo_color), p.g.icons_filled_call_good, paramView1.getContext().getResources().getColor(p.b.finder_live_logo_color));
      }
    }
    for (;;)
    {
      if ((c(paramb)) && (params.findItem(154) == null)) {
        params.a(154, (CharSequence)paramView1.getContext().getString(p.h.Ciy), paramView1.getContext().getResources().getColor(p.b.pop_menu_color), p.g.icons_filled_reply, paramView1.getContext().getResources().getColor(p.b.pop_menu_color));
      }
      if (params.findItem(155) == null) {
        params.a(155, (CharSequence)paramView1.getContext().getString(p.h.Coa), paramView1.getContext().getResources().getColor(p.b.pop_menu_color), p.g.icons_filled_copy, paramView1.getContext().getResources().getColor(p.b.pop_menu_color));
      }
      if (c(paramb))
      {
        parama = b.Zuu;
        if ((b.eGK().contains(Integer.valueOf(paramb.akfZ.msg_type))) && (params.findItem(156) == null)) {
          params.a(156, (CharSequence)paramView1.getContext().getString(p.h.finder_live_more_action_report), paramView1.getContext().getResources().getColor(p.b.pop_menu_color), p.g.icons_filled_report_problem, paramView1.getContext().getResources().getColor(p.b.pop_menu_color));
        }
      }
      AppMethodBeat.o(370968);
      return;
      params.a(165, (CharSequence)paramView1.getContext().getString(p.h.finder_action_like), paramView1.getContext().getResources().getColor(p.b.pop_menu_color), p.g.icons_filled_call_good, paramView1.getContext().getResources().getColor(p.b.pop_menu_color));
      continue;
      Log.e(parama.TAG, "msg " + paramb.akfZ.msg_type + " seq:" + paramb.akfZ.seq);
    }
  }
  
  private <T extends af> T business(Class<T> paramClass)
  {
    AppMethodBeat.i(370940);
    kotlin.g.b.s.u(paramClass, "bu");
    paramClass = this.Zut.getBuContext().business(paramClass);
    AppMethodBeat.o(370940);
    return paramClass;
  }
  
  private static boolean c(com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb)
  {
    AppMethodBeat.i(370945);
    if ((!kotlin.g.b.s.p(paramb.aJO(), z.bAM())) && (!kotlin.g.b.s.p(paramb.aJO(), z.bAW())) && (!kotlin.g.b.s.p(paramb.aJO(), z.bAX())))
    {
      AppMethodBeat.o(370945);
      return true;
    }
    AppMethodBeat.o(370945);
    return false;
  }
  
  private static boolean d(com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb)
  {
    AppMethodBeat.i(370953);
    if (!((d)h.ax(d.class)).aBu())
    {
      b localb = b.Zuu;
      if (b.eFU().contains(Integer.valueOf(paramb.akfZ.msg_type)))
      {
        AppMethodBeat.o(370953);
        return true;
      }
    }
    AppMethodBeat.o(370953);
    return false;
  }
  
  private static final void ga(View paramView)
  {
    AppMethodBeat.i(370986);
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
      if (paramView != null) {
        paramView.setImageResource(p.g.icons_filled_done);
      }
    }
    AppMethodBeat.o(370986);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb, View paramView)
  {
    AppMethodBeat.i(371004);
    kotlin.g.b.s.u(paramb, "msg");
    kotlin.g.b.s.u(paramView, "view");
    if ((!paramBoolean) && (d(paramb)))
    {
      Object localObject = i.GzZ;
      i.fkK();
      this.CXT = paramView.getBackground();
      localObject = i.GzZ;
      i.a(new a..ExternalSyntheticLambda2(paramb, paramView, this), new a..ExternalSyntheticLambda3(this, paramb, paramView), new a..ExternalSyntheticLambda0(paramView, this), new i.a(paramView, paramb.akfZ.ZOb, ((e)business(e.class)).DUe, true, true, paramb.kKZ(), paramb.getContent()), new i.b(true, new t(paramView.getContext(), 167, 0), true));
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.f(paramb))
      {
        localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (!com.tencent.mm.plugin.finder.live.utils.a.e(paramb)) {}
      }
      else
      {
        paramView.setBackground(paramView.getContext().getDrawable(p.d.BzS));
        AppMethodBeat.o(371004);
        return;
      }
      paramView.setBackground(paramView.getContext().getDrawable(p.d.BzV));
    }
    AppMethodBeat.o(371004);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb)
  {
    AppMethodBeat.i(371006);
    kotlin.g.b.s.u(paramb, "msg");
    boolean bool = d(paramb);
    if ((paramb.akfZ.seq > 0L) && (bool))
    {
      Object localObject1 = ai.akfD;
      localObject1 = paramb.akfZ;
      int i = paramb.likeCount;
      Object localObject2 = c.a.akmY;
      localObject1 = ai.a((bdm)localObject1, i, c.a.a.kMH());
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ(this.TAG, "boxCommentLikeTrack like msg seq:" + paramb.akfZ.seq + ",likeCount:" + paramb.likeCount);
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).e((bdm)localObject1);
        AppMethodBeat.o(371006);
        return true;
      }
      Log.w(this.TAG, "like failed, boxId is null");
      AppMethodBeat.o(371006);
      return false;
    }
    Log.e(this.TAG, "like failed,msg " + paramb.akfZ.msg_type + " seq:" + paramb.akfZ.seq + ",canLike:" + bool);
    AppMethodBeat.o(371006);
    return false;
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb)
  {
    AppMethodBeat.i(371010);
    kotlin.g.b.s.u(paramb, "msg");
    boolean bool = d(paramb);
    if ((paramb.akfZ.seq > 0L) && (bool))
    {
      Object localObject1 = ai.akfD;
      localObject1 = paramb.akfZ;
      int i = paramb.likeCount;
      Object localObject2 = c.a.akmY;
      localObject1 = ai.a((bdm)localObject1, i, c.a.a.kMI());
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ(this.TAG, "boxCommentLikeTrack dislike msg seq:" + paramb.akfZ.seq + ",likeCount:" + paramb.likeCount);
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).e((bdm)localObject1);
        AppMethodBeat.o(371010);
        return true;
      }
      Log.w(this.TAG, "dislike failed, boxId is null");
      AppMethodBeat.o(371010);
      return false;
    }
    Log.e(this.TAG, "dislike failed,msg " + paramb.akfZ.msg_type + " seq:" + paramb.akfZ.seq + ",canLike:" + bool);
    AppMethodBeat.o(371010);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.b.a
 * JD-Core Version:    0.7.0.1
 */