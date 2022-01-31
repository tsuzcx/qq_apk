package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.fav.a.am.a;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.util.LinkedList;
import java.util.List;

public final class i
{
  public static void a(Context paramContext, String paramString, com.tencent.mm.plugin.fav.a.g paramg, xv paramxv, Runnable paramRunnable)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.FavSendLogic", "want to send fav file, but context is null");
      return;
    }
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.FavSendLogic", "want to send fav file, but to user is null");
      return;
    }
    if (paramg == null) {
      y.w("MicroMsg.FavSendLogic", "want to send fav file, but info is null");
    }
    if (paramxv == null)
    {
      y.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
      return;
    }
    com.tencent.mm.kernel.g.DS().O(new i.4(paramString, paramg, paramxv, paramRunnable));
  }
  
  public static void a(Context paramContext, String paramString, xv paramxv, Runnable paramRunnable)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
      return;
    }
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
      return;
    }
    if (paramxv == null)
    {
      y.w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
      return;
    }
    com.tencent.mm.kernel.g.DS().O(new i.3(paramxv, paramContext, paramString, paramRunnable));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, com.tencent.mm.plugin.fav.a.g paramg, Runnable paramRunnable)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramg);
    a(paramContext, paramString1, paramString2, localLinkedList, paramRunnable);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, List<com.tencent.mm.plugin.fav.a.g> paramList, Runnable paramRunnable)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.FavSendLogic", "want to send fav msg, but context is null");
      ai.d(paramRunnable);
      return;
    }
    if (bk.bl(paramString1))
    {
      y.w("MicroMsg.FavSendLogic", "want to send fav msg, but to user is null");
      ai.d(paramRunnable);
      return;
    }
    if (paramList.isEmpty())
    {
      y.w("MicroMsg.FavSendLogic", "want to send fav msg, but info is null");
      ai.d(paramRunnable);
      return;
    }
    com.tencent.mm.kernel.g.DS().O(new i.1(paramString1, paramList, paramContext, paramString2, paramRunnable));
  }
  
  public static String i(xv paramxv)
  {
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(paramxv));
    if (localb.exists()) {
      return j.n(localb.cLr());
    }
    return com.tencent.mm.plugin.fav.a.b.aPI() + com.tencent.mm.a.g.o(bk.aM(paramxv.bIm, "").getBytes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.i
 * JD-Core Version:    0.7.0.1
 */