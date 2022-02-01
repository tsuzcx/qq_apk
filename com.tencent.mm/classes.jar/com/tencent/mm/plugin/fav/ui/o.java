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
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o
{
  private static int MJ(int paramInt)
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
    paramActivity = com.tencent.mm.ui.base.k.a(paramActivity, paramActivity.getString(q.i.favorite_delete_tips), false, null);
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107055);
        com.tencent.mm.plugin.fav.a.b.fE(o.this);
        if (parama != null) {
          parama.dRQ();
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107053);
            o.1.this.Afz.dismiss();
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
    com.tencent.mm.plugin.fav.a.k localk = new com.tencent.mm.plugin.fav.a.k();
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
      com.tencent.mm.ui.base.k.cZ(paramActivity, paramActivity.getString(q.i.favorite_retransmit_tip));
      AppMethodBeat.o(107061);
      return;
    }
    l.a(paramActivity, paramString2, paramString1, localLinkedList, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107056);
        o.this.dismiss();
        com.tencent.mm.ui.widget.snackbar.b.u(paramActivity, paramActivity.getString(q.i.fav_finish_sent));
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
      if (!aw.isDarkMode()) {
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
      if (!aw.isDarkMode()) {
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
  
  public static boolean b(Context paramContext, int paramInt, com.tencent.mm.plugin.fav.ui.adapter.b paramb, g paramg)
  {
    AppMethodBeat.i(107059);
    if (paramInt == 4105)
    {
      paramg = new Intent();
      paramg.putExtra("Select_Conv_Type", 3);
      paramg.putExtra("scene_from", 1);
      paramg.putExtra("mutil_select_is_ret", true);
      Object localObject;
      if (paramb.dSm() == 1)
      {
        localObject = (g)paramb.ps(false).get(0);
        paramg.putExtra("select_fav_local_id", ((g)localObject).field_localId);
        if (((g)localObject).Acq) {
          paramg.putExtra("select_fav_fake_local_id", ((g)localObject).hIG);
        }
        if ((localObject != null) && (MJ(((g)localObject).field_type) != -1)) {
          paramg.putExtra("Retr_Msg_Type", MJ(((g)localObject).field_type));
        }
        if (localObject != null) {
          ((ab)h.ax(ab.class)).c(Long.valueOf(((g)localObject).field_localId));
        }
        if ((paramb.ps(false).get(0) != null) && (((g)paramb.ps(false).get(0)).field_type == 3))
        {
          com.tencent.mm.ui.base.k.cZ(paramContext, paramContext.getString(q.i.favorite_retransmit_tip));
          AppMethodBeat.o(107059);
          return false;
        }
      }
      else
      {
        paramg.putExtra("Retr_Msg_Type", 17);
        localObject = new com.tencent.mm.plugin.fav.a.k();
        paramb = paramb.ps(false).iterator();
        paramInt = 0;
        while (paramb.hasNext())
        {
          g localg = (g)paramb.next();
          if (!((com.tencent.mm.plugin.fav.a.k)localObject).u(localg))
          {
            if (localg != null) {
              ((ab)h.ax(ab.class)).c(Long.valueOf(localg.field_localId));
            }
            paramInt += 1;
          }
        }
        paramg.putExtra("select_fav_select_count", paramInt);
      }
      c.d(paramContext, ".ui.transmit.SelectConversationUI", paramg, 4105);
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
        if (paramg.Acq) {
          paramb.putExtra("select_fav_fake_local_id", paramg.hIG);
        }
        if (paramg.field_type == 19) {
          paramb.putExtra("appbrand_params", b.F(paramg));
        }
        ((ab)h.ax(ab.class)).c(Long.valueOf(paramg.field_localId));
      }
      if ((paramg != null) && (MJ(paramg.field_type) != -1)) {
        paramb.putExtra("Retr_Msg_Type", MJ(paramg.field_type));
      }
      paramb.putExtra("scene_from", 1);
      c.d(paramContext, ".ui.transmit.SelectConversationUI", paramb, 4106);
      AppMethodBeat.o(107059);
      return true;
    }
    AppMethodBeat.o(107059);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void dRQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.o
 * JD-Core Version:    0.7.0.1
 */