package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.fav.a.am.a;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.g.a.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.util.LinkedList;
import java.util.List;

public final class i
{
  public static void a(Context paramContext, String paramString, com.tencent.mm.plugin.fav.a.g paramg, aca paramaca, Runnable paramRunnable)
  {
    AppMethodBeat.i(74132);
    if (paramContext == null)
    {
      ab.w("MicroMsg.FavSendLogic", "want to send fav file, but context is null");
      AppMethodBeat.o(74132);
      return;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.FavSendLogic", "want to send fav file, but to user is null");
      AppMethodBeat.o(74132);
      return;
    }
    if (paramg == null) {
      ab.w("MicroMsg.FavSendLogic", "want to send fav file, but info is null");
    }
    if (paramaca == null)
    {
      ab.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
      AppMethodBeat.o(74132);
      return;
    }
    com.tencent.mm.kernel.g.RO().ac(new i.4(paramString, paramg, paramaca, paramRunnable));
    AppMethodBeat.o(74132);
  }
  
  public static void a(Context paramContext, String paramString, aca paramaca, Runnable paramRunnable)
  {
    AppMethodBeat.i(74131);
    if (paramContext == null)
    {
      ab.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
      AppMethodBeat.o(74131);
      return;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
      AppMethodBeat.o(74131);
      return;
    }
    if (paramaca == null)
    {
      ab.w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
      AppMethodBeat.o(74131);
      return;
    }
    com.tencent.mm.kernel.g.RO().ac(new i.3(paramaca, paramContext, paramString, paramRunnable));
    AppMethodBeat.o(74131);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, com.tencent.mm.plugin.fav.a.g paramg, Runnable paramRunnable)
  {
    AppMethodBeat.i(74129);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramg);
    a(paramContext, paramString1, paramString2, localLinkedList, paramRunnable);
    AppMethodBeat.o(74129);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, List<com.tencent.mm.plugin.fav.a.g> paramList, Runnable paramRunnable)
  {
    AppMethodBeat.i(74130);
    if (paramContext == null)
    {
      ab.w("MicroMsg.FavSendLogic", "want to send fav msg, but context is null");
      al.d(paramRunnable);
      AppMethodBeat.o(74130);
      return;
    }
    if (bo.isNullOrNil(paramString1))
    {
      ab.w("MicroMsg.FavSendLogic", "want to send fav msg, but to user is null");
      al.d(paramRunnable);
      AppMethodBeat.o(74130);
      return;
    }
    if (paramList.isEmpty())
    {
      ab.w("MicroMsg.FavSendLogic", "want to send fav msg, but info is null");
      al.d(paramRunnable);
      AppMethodBeat.o(74130);
      return;
    }
    d.ysn.aj(new i.1(paramString1, paramList, paramContext, paramString2, paramRunnable));
    AppMethodBeat.o(74130);
  }
  
  public static String i(aca paramaca)
  {
    AppMethodBeat.i(74133);
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(paramaca));
    if (localb.exists()) {}
    for (paramaca = j.p(localb.dQJ());; paramaca = com.tencent.mm.plugin.fav.a.b.bvW() + com.tencent.mm.a.g.w(bo.bf(paramaca.cpH, "").getBytes()))
    {
      AppMethodBeat.o(74133);
      return paramaca;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.i
 * JD-Core Version:    0.7.0.1
 */