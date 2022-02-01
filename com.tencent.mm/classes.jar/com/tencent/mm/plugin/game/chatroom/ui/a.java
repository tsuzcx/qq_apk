package com.tencent.mm.plugin.game.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.chatroom.k.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.widget.a.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/ui/MentionSomeoneDialogUtil;", "", "()V", "initMentionSomeoneDialog", "", "mentionSomeoneDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "context", "Landroid/content/Context;", "fragmentActivity", "Lcom/tencent/mm/ui/MMActivity;", "listener", "Lcom/tencent/mm/plugin/game/chatroom/ui/MentionUserAdapter$OnItemClickListener;", "updateByAllData", "wrapper", "Lcom/tencent/mm/plugin/game/chatroom/data/MentionUserResultWrapper;", "adapter", "Lcom/tencent/mm/plugin/game/chatroom/ui/MentionUserAdapter;", "diff", "", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a InV;
  
  static
  {
    AppMethodBeat.i(276071);
    InV = new a();
    AppMethodBeat.o(276071);
  }
  
  private static void a(com.tencent.mm.plugin.game.chatroom.d.b paramb, b paramb1, boolean paramBoolean)
  {
    AppMethodBeat.i(276036);
    Object localObject = (List)new ArrayList();
    if (!((Collection)paramb.Ikg).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject).addAll((Collection)paramb.Ikg);
      }
      if (((Boolean)paramb.Ikh.bsC).booleanValue()) {
        ((List)localObject).addAll((Collection)paramb.Ikh.bsD);
      }
      if (((Boolean)paramb.Iki.bsC).booleanValue()) {
        ((List)localObject).addAll((Collection)paramb.Iki.bsD);
      }
      if (((Boolean)paramb.Ikj.bsC).booleanValue()) {
        ((List)localObject).addAll((Collection)paramb.Ikj.bsD);
      }
      if (!paramBoolean) {
        break;
      }
      s.u(localObject, "list");
      paramb = com.tencent.mm.plugin.game.chatroom.k.a.Iod;
      paramb = com.tencent.mm.plugin.game.chatroom.k.a.ik((List)localObject);
      localObject = g.a((g.a)new b.a(paramb1.lMl, paramb));
      s.s(localObject, "calculateDiff(DiffCallback(datas, newList))");
      ((g.b)localObject).a((RecyclerView.a)paramb1);
      paramb1.lMl.clear();
      paramb1.lMl.addAll((Collection)paramb);
      AppMethodBeat.o(276036);
      return;
    }
    paramb1.setData((List)localObject);
    AppMethodBeat.o(276036);
  }
  
  private static final void a(com.tencent.mm.plugin.game.chatroom.e.a parama, long paramLong1, long paramLong2, View paramView)
  {
    AppMethodBeat.i(276053);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.hB(paramLong1);
    localb.hB(paramLong2);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/ui/MentionSomeoneDialogUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$binding");
    parama.Ikq.setVisibility(0);
    parama.Ikr.setVisibility(8);
    paramView = c.Iof;
    parama = parama.Ikn;
    s.s(parama, "binding.etInputName");
    c.hv((View)parama);
    parama = d.mty;
    d.a.b(700L, 2L, paramLong1, paramLong2, null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/game/chatroom/ui/MentionSomeoneDialogUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(276053);
  }
  
  private static final void a(b paramb, com.tencent.mm.plugin.game.chatroom.d.b paramb1)
  {
    AppMethodBeat.i(276056);
    s.u(paramb, "$adapter");
    if (paramb1 != null) {
      a(paramb1, paramb, true);
    }
    AppMethodBeat.o(276056);
  }
  
  private static final void a(b paramb, List paramList)
  {
    AppMethodBeat.i(276062);
    s.u(paramb, "$adapter");
    s.s(paramList, "it");
    paramb.setData(paramList);
    AppMethodBeat.o(276062);
  }
  
  public static final void a(j paramj, Context paramContext, MMActivity paramMMActivity, b.b paramb)
  {
    AppMethodBeat.i(276026);
    s.u(paramj, "mentionSomeoneDialog");
    s.u(paramContext, "context");
    s.u(paramMMActivity, "fragmentActivity");
    Object localObject1 = ai.a((FragmentActivity)paramMMActivity, null).q(com.tencent.mm.plugin.game.chatroom.l.b.class);
    s.s(localObject1, "of(fragmentActivity).get…del::class.java\n        )");
    com.tencent.mm.plugin.game.chatroom.l.b localb = (com.tencent.mm.plugin.game.chatroom.l.b)localObject1;
    long l1 = paramMMActivity.getIntent().getLongExtra("game_report_ssid", 0L);
    long l2 = paramMMActivity.getIntent().getLongExtra("game_report_sourceid", 0L);
    localObject1 = LayoutInflater.from(paramContext).inflate(h.f.Iib, null, false);
    int i = h.e.IfB;
    Object localObject2 = (MMClearEditText)androidx.m.a.L((View)localObject1, i);
    if (localObject2 != null)
    {
      i = h.e.IfJ;
      Object localObject3 = (FrameLayout)androidx.m.a.L((View)localObject1, i);
      if (localObject3 != null)
      {
        i = h.e.Ige;
        ImageView localImageView = (ImageView)androidx.m.a.L((View)localObject1, i);
        if (localImageView != null)
        {
          i = h.e.Igr;
          LinearLayout localLinearLayout1 = (LinearLayout)androidx.m.a.L((View)localObject1, i);
          if (localLinearLayout1 != null)
          {
            i = h.e.Igv;
            LinearLayout localLinearLayout2 = (LinearLayout)androidx.m.a.L((View)localObject1, i);
            if (localLinearLayout2 != null)
            {
              i = h.e.IgV;
              RecyclerView localRecyclerView = (RecyclerView)androidx.m.a.L((View)localObject1, i);
              if (localRecyclerView != null)
              {
                localObject3 = new com.tencent.mm.plugin.game.chatroom.e.a((LinearLayout)localObject1, (MMClearEditText)localObject2, (FrameLayout)localObject3, localImageView, localLinearLayout1, localLinearLayout2, localRecyclerView);
                s.s(localObject3, "inflate(LayoutInflater.from(context))");
                ((com.tencent.mm.plugin.game.chatroom.e.a)localObject3).Ikp.setOnClickListener(new a..ExternalSyntheticLambda1(paramj));
                ((com.tencent.mm.plugin.game.chatroom.e.a)localObject3).Iko.setOnClickListener(new a..ExternalSyntheticLambda0((com.tencent.mm.plugin.game.chatroom.e.a)localObject3, l1, l2));
                localObject1 = d.mty;
                d.a.b(700L, 1L, l1, l2, null);
                localObject2 = localb.chatroomName;
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
                localObject1 = new b((String)localObject1, l1, l2);
                ((com.tencent.mm.plugin.game.chatroom.e.a)localObject3).Ikn.addTextChangedListener((TextWatcher)new a.a(localb, (b)localObject1));
                ((b)localObject1).InZ = paramb;
                ((com.tencent.mm.plugin.game.chatroom.e.a)localObject3).Iks.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
                ((com.tencent.mm.plugin.game.chatroom.e.a)localObject3).Iks.setAdapter((RecyclerView.a)localObject1);
                localb.fDO();
                ((LiveData)localb.Isz).a((q)paramMMActivity, new a..ExternalSyntheticLambda2((b)localObject1));
                localb.IsA.a((q)paramMMActivity, new a..ExternalSyntheticLambda3((b)localObject1));
                paramj.F((View)((com.tencent.mm.plugin.game.chatroom.e.a)localObject3).Ikm, 0, 0);
                paramj = ((com.tencent.mm.plugin.game.chatroom.e.a)localObject3).Ikm.getLayoutParams();
                paramj.height = (ao.mX(paramContext).height * 3 / 4);
                ((com.tencent.mm.plugin.game.chatroom.e.a)localObject3).Ikm.setLayoutParams(paramj);
                AppMethodBeat.o(276026);
                return;
              }
            }
          }
        }
      }
    }
    paramj = new NullPointerException("Missing required view with ID: ".concat(((View)localObject1).getResources().getResourceName(i)));
    AppMethodBeat.o(276026);
    throw paramj;
  }
  
  private static final void b(j paramj, View paramView)
  {
    AppMethodBeat.i(276046);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/ui/MentionSomeoneDialogUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$mentionSomeoneDialog");
    paramj.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/game/chatroom/ui/MentionSomeoneDialogUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(276046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.a
 * JD-Core Version:    0.7.0.1
 */