package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
{
  private static int Cq(int paramInt)
  {
    if (paramInt == 1) {
      return 4;
    }
    if (paramInt == 2) {
      return 0;
    }
    if (paramInt == 16) {
      return 11;
    }
    if (paramInt == 4) {
      return 1;
    }
    if (paramInt == 14) {
      return 13;
    }
    if (paramInt == 6) {
      return 9;
    }
    if (paramInt == 8) {
      return 3;
    }
    return 2;
  }
  
  public static void a(Activity paramActivity, List<com.tencent.mm.plugin.fav.a.g> paramList, p.a parama)
  {
    AppMethodBeat.i(107060);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(107060);
      return;
    }
    paramActivity = h.b(paramActivity, paramActivity.getString(2131758855), false, null);
    com.tencent.mm.kernel.g.afE().ax(new p.1(paramList, parama, paramActivity));
    AppMethodBeat.o(107060);
  }
  
  public static void a(final Activity paramActivity, List<com.tencent.mm.plugin.fav.a.g> paramList, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(107061);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(107061);
      return;
    }
    if (bt.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(107061);
      return;
    }
    k localk = new k();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)paramList.next();
      if (!localk.u(localg)) {
        localLinkedList.add(localg);
      }
    }
    if (localLinkedList.isEmpty())
    {
      ad.i(paramString3, "after filter, nothing");
      h.cf(paramActivity, paramActivity.getString(2131758987));
      AppMethodBeat.o(107061);
      return;
    }
    l.a(paramActivity, paramString2, paramString1, localLinkedList, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107056);
        this.qcu.dismiss();
        com.tencent.mm.ui.widget.snackbar.b.n(paramActivity, paramActivity.getString(2131758834));
        AppMethodBeat.o(107056);
      }
    });
    AppMethodBeat.o(107061);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(107057);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = localObject2;
      if (!ai.Eq()) {
        localObject1 = ActivityOptions.makeSceneTransitionAnimation(paramActivity, new Pair[0]).toBundle();
      }
    }
    if (paramBoolean)
    {
      paramIntent.putExtra("key_search_type", 2);
      com.tencent.mm.plugin.fav.a.b.a(paramActivity, ".ui.FavSearchUI", paramIntent, 4103, (Bundle)localObject1);
      AppMethodBeat.o(107057);
      return;
    }
    com.tencent.mm.plugin.fav.a.b.a(paramActivity, ".ui.FavSearchUI", paramIntent, (Bundle)localObject1);
    AppMethodBeat.o(107057);
  }
  
  public static void b(Activity paramActivity, boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(107058);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = localObject2;
      if (!ai.Eq()) {
        localObject1 = ActivityOptions.makeSceneTransitionAnimation(paramActivity, new Pair[0]).toBundle();
      }
    }
    if (paramBoolean)
    {
      paramIntent.putExtra("key_search_type", 2);
      com.tencent.mm.plugin.fav.a.b.a(paramActivity, ".ui.FavFilterUI", paramIntent, 4103, (Bundle)localObject1);
      AppMethodBeat.o(107058);
      return;
    }
    com.tencent.mm.plugin.fav.a.b.a(paramActivity, ".ui.FavFilterUI", paramIntent, (Bundle)localObject1);
    AppMethodBeat.o(107058);
  }
  
  public static boolean b(Context paramContext, int paramInt, com.tencent.mm.plugin.fav.ui.a.b paramb, com.tencent.mm.plugin.fav.a.g paramg)
  {
    int i = 0;
    AppMethodBeat.i(107059);
    if (paramInt == 4105)
    {
      paramg = new Intent();
      paramg.putExtra("Select_Conv_Type", 3);
      paramg.putExtra("scene_from", 1);
      paramg.putExtra("mutil_select_is_ret", true);
      Object localObject;
      if (paramb.cjt() == 1)
      {
        localObject = (com.tencent.mm.plugin.fav.a.g)paramb.kE(false).get(0);
        paramg.putExtra("select_fav_local_id", ((com.tencent.mm.plugin.fav.a.g)localObject).field_localId);
        if (((com.tencent.mm.plugin.fav.a.g)localObject).pZE) {
          paramg.putExtra("select_fav_fake_local_id", ((com.tencent.mm.plugin.fav.a.g)localObject).djR);
        }
        if ((localObject != null) && (Cq(((com.tencent.mm.plugin.fav.a.g)localObject).field_type) != -1)) {
          paramg.putExtra("Retr_Msg_Type", Cq(((com.tencent.mm.plugin.fav.a.g)localObject).field_type));
        }
        if ((paramb.kE(false).get(0) != null) && (((com.tencent.mm.plugin.fav.a.g)paramb.kE(false).get(0)).field_type == 3))
        {
          h.cf(paramContext, paramContext.getString(2131758987));
          AppMethodBeat.o(107059);
          return false;
        }
      }
      else
      {
        paramg.putExtra("Retr_Msg_Type", 17);
        localObject = new k();
        paramb = paramb.kE(false).iterator();
        paramInt = i;
        while (paramb.hasNext()) {
          if (!((k)localObject).u((com.tencent.mm.plugin.fav.a.g)paramb.next())) {
            paramInt += 1;
          }
        }
        paramg.putExtra("select_fav_select_count", paramInt);
      }
      d.c(paramContext, ".ui.transmit.SelectConversationUI", paramg, 4105);
      AppMethodBeat.o(107059);
      return true;
    }
    if (paramInt == 4106)
    {
      paramb = new Intent();
      paramb.putExtra("Select_Conv_Type", 3);
      paramb.putExtra("scene_from", 1);
      paramb.putExtra("mutil_select_is_ret", true);
      if (paramg != null)
      {
        paramb.putExtra("select_fav_local_id", paramg.field_localId);
        if (paramg.pZE) {
          paramb.putExtra("select_fav_fake_local_id", paramg.djR);
        }
        if (paramg.field_type == 19) {
          paramb.putExtra("appbrand_params", c.F(paramg));
        }
      }
      if ((paramg != null) && (Cq(paramg.field_type) != -1)) {
        paramb.putExtra("Retr_Msg_Type", Cq(paramg.field_type));
      }
      d.c(paramContext, ".ui.transmit.SelectConversationUI", paramb, 4106);
      AppMethodBeat.o(107059);
      return true;
    }
    AppMethodBeat.o(107059);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.p
 * JD-Core Version:    0.7.0.1
 */