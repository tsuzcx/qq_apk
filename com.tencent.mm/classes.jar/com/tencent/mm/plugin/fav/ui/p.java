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
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
{
  private static int LM(int paramInt)
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
  
  public static void a(final Activity paramActivity, List<g> paramList, final a parama)
  {
    AppMethodBeat.i(107060);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(107060);
      return;
    }
    paramActivity = com.tencent.mm.ui.base.h.a(paramActivity, paramActivity.getString(s.i.favorite_delete_tips), false, null);
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107055);
        com.tencent.mm.plugin.fav.a.b.dJ(this.wJP);
        if (parama != null) {
          parama.dla();
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107053);
            p.1.this.wJe.dismiss();
            AppMethodBeat.o(107053);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(107054);
            String str = super.toString() + "|batchDelFavItems";
            AppMethodBeat.o(107054);
            return str;
          }
        });
        AppMethodBeat.o(107055);
      }
    });
    AppMethodBeat.o(107060);
  }
  
  public static void a(final Activity paramActivity, List<g> paramList, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(107061);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(107061);
      return;
    }
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(107061);
      return;
    }
    k localk = new k();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      g localg = (g)paramList.next();
      if (!localk.u(localg)) {
        localLinkedList.add(localg);
      }
    }
    if (localLinkedList.isEmpty())
    {
      Log.i(paramString3, "after filter, nothing");
      com.tencent.mm.ui.base.h.cO(paramActivity, paramActivity.getString(s.i.favorite_retransmit_tip));
      AppMethodBeat.o(107061);
      return;
    }
    l.a(paramActivity, paramString2, paramString1, localLinkedList, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107056);
        this.wJe.dismiss();
        com.tencent.mm.ui.widget.snackbar.b.r(paramActivity, paramActivity.getString(s.i.fav_finish_sent));
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
      if (!ar.isDarkMode()) {
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
      if (!ar.isDarkMode()) {
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
  
  public static boolean b(Context paramContext, int paramInt, com.tencent.mm.plugin.fav.ui.a.b paramb, g paramg)
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
      if (paramb.dlw() == 1)
      {
        localObject = (g)paramb.nS(false).get(0);
        paramg.putExtra("select_fav_local_id", ((g)localObject).field_localId);
        if (((g)localObject).wGh) {
          paramg.putExtra("select_fav_fake_local_id", ((g)localObject).fDQ);
        }
        if ((localObject != null) && (LM(((g)localObject).field_type) != -1)) {
          paramg.putExtra("Retr_Msg_Type", LM(((g)localObject).field_type));
        }
        if ((paramb.nS(false).get(0) != null) && (((g)paramb.nS(false).get(0)).field_type == 3))
        {
          com.tencent.mm.ui.base.h.cO(paramContext, paramContext.getString(s.i.favorite_retransmit_tip));
          AppMethodBeat.o(107059);
          return false;
        }
      }
      else
      {
        paramg.putExtra("Retr_Msg_Type", 17);
        localObject = new k();
        paramb = paramb.nS(false).iterator();
        paramInt = i;
        while (paramb.hasNext()) {
          if (!((k)localObject).u((g)paramb.next())) {
            paramInt += 1;
          }
        }
        paramg.putExtra("select_fav_select_count", paramInt);
      }
      com.tencent.mm.by.c.d(paramContext, ".ui.transmit.SelectConversationUI", paramg, 4105);
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
        if (paramg.wGh) {
          paramb.putExtra("select_fav_fake_local_id", paramg.fDQ);
        }
        if (paramg.field_type == 19) {
          paramb.putExtra("appbrand_params", c.F(paramg));
        }
      }
      if ((paramg != null) && (LM(paramg.field_type) != -1)) {
        paramb.putExtra("Retr_Msg_Type", LM(paramg.field_type));
      }
      paramb.putExtra("scene_from", 1);
      com.tencent.mm.by.c.d(paramContext, ".ui.transmit.SelectConversationUI", paramb, 4106);
      AppMethodBeat.o(107059);
      return true;
    }
    AppMethodBeat.o(107059);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void dla();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.p
 * JD-Core Version:    0.7.0.1
 */