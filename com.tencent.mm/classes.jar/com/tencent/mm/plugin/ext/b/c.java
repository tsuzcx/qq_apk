package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.api.d;
import com.tencent.mm.autogen.a.le;
import com.tencent.mm.autogen.a.le.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.eve;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private static Map<String, a> onK = null;
  final h callback;
  private Context mContext;
  private String zOA;
  private boolean zOB;
  
  public c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24372);
    this.zOA = "";
    this.zOB = false;
    this.mContext = null;
    this.callback = new h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(24371);
        bh.aZW().b(106, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
          paramAnonymousString = ((f)paramAnonymousp).gaH();
          Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", new Object[] { Integer.valueOf(paramAnonymousString.aaqy) });
          if (paramAnonymousString.aaqy > 0)
          {
            if (paramAnonymousString.aaqz.isEmpty())
            {
              Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
              c.a(c.this, paramAnonymousString);
            }
            if (paramAnonymousString.aaqz.size() > 1) {
              try
              {
                paramAnonymousp = new Intent();
                paramAnonymousp.putExtra("add_more_friend_search_scene", 3);
                paramAnonymousp.putExtra("result", paramAnonymousString.toByteArray());
                Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
                com.tencent.mm.plugin.ext.a.dNP().r(paramAnonymousp, c.a(c.this));
                AppMethodBeat.o(24371);
                return;
              }
              catch (IOException paramAnonymousString)
              {
                Log.printErrStackTrace("MicroMsg.RedirectToChattingByPhoneHelper", paramAnonymousString, "", new Object[0]);
                AppMethodBeat.o(24371);
                return;
              }
            }
            c.a(c.this, (eve)paramAnonymousString.aaqz.getFirst());
            AppMethodBeat.o(24371);
            return;
          }
          Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: only one result is retrieved. start to chatting directly");
          c.b(c.this, paramAnonymousString);
          AppMethodBeat.o(24371);
          return;
        }
        Log.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: err net.errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        c.a(c.this, null);
        AppMethodBeat.o(24371);
      }
    };
    this.mContext = paramContext;
    this.zOA = paramString;
    this.zOB = true;
    AppMethodBeat.o(24372);
  }
  
  private int a(String paramString, evg paramevg, eve parameve)
  {
    AppMethodBeat.i(24375);
    if (this.mContext == null)
    {
      Log.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: error param. start redirect param error: context is null");
      AppMethodBeat.o(24375);
      return -1;
    }
    if (!Util.isNullOrNil(paramString))
    {
      bh.bCz();
      if (com.tencent.mm.model.c.bzA().bxr(paramString))
      {
        Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
        atx(paramString);
        AppMethodBeat.o(24375);
        return 0;
      }
    }
    if (paramevg != null)
    {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
      a(paramevg);
      AppMethodBeat.o(24375);
      return 1;
    }
    if (parameve != null)
    {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
      a(parameve);
      AppMethodBeat.o(24375);
      return 1;
    }
    Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
    AppMethodBeat.o(24375);
    return -1;
  }
  
  private void a(eve parameve)
  {
    AppMethodBeat.i(24378);
    if (parameve == null)
    {
      Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
      AppMethodBeat.o(24378);
      return;
    }
    Object localObject = w.a(parameve.ZqL);
    if (!Util.isNullOrNil((String)localObject))
    {
      a(this.zOA, new a(w.a(parameve.ZqL), null, parameve));
      bh.bCz();
      if (com.tencent.mm.model.c.bzA().bxr((String)localObject))
      {
        Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
        atx((String)localObject);
        AppMethodBeat.o(24378);
        return;
      }
      localObject = new Intent();
      d.a((Intent)localObject, parameve);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.dNP().c((Intent)localObject, this.mContext);
      AppMethodBeat.o(24378);
      return;
    }
    Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
    AppMethodBeat.o(24378);
  }
  
  private void a(evg paramevg)
  {
    AppMethodBeat.i(24377);
    if (paramevg == null)
    {
      Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
      AppMethodBeat.o(24377);
      return;
    }
    Object localObject = w.a(paramevg.ZqL);
    if (!Util.isNullOrNil((String)localObject))
    {
      a(this.zOA, new a(w.a(paramevg.ZqL), paramevg, null));
      bh.bCz();
      if (com.tencent.mm.model.c.bzA().bxr((String)localObject))
      {
        Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
        atx((String)localObject);
        AppMethodBeat.o(24377);
        return;
      }
      localObject = new Intent();
      d.a((Intent)localObject, paramevg, 15);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.dNP().c((Intent)localObject, this.mContext);
      AppMethodBeat.o(24377);
      return;
    }
    Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
    AppMethodBeat.o(24377);
  }
  
  private static void a(String paramString, a parama)
  {
    AppMethodBeat.i(24374);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when put to cache");
      AppMethodBeat.o(24374);
      return;
    }
    if (onK == null) {
      onK = new HashMap();
    }
    onK.put(paramString, parama);
    AppMethodBeat.o(24374);
  }
  
  private void atx(String paramString)
  {
    AppMethodBeat.i(24376);
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", false);
    com.tencent.mm.br.c.g(this.mContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(24376);
  }
  
  public final int dOa()
  {
    AppMethodBeat.i(24373);
    if (this.mContext == null)
    {
      Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    if (Util.isNullOrNil(this.zOA))
    {
      Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    Object localObject2 = PhoneFormater.pureNumber(this.zOA);
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    Object localObject1 = this.zOA;
    if (Util.isNullOrNil((String)localObject1)) {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
    }
    int i;
    for (localObject1 = null; localObject1 != null; localObject1 = (a)onK.get(localObject1))
    {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
      i = a(((a)localObject1).userName, ((a)localObject1).zOD, ((a)localObject1).zOE);
      AppMethodBeat.o(24373);
      return i;
      if (onK == null) {
        onK = new HashMap();
      }
    }
    localObject1 = new le();
    ((le)localObject1).hMU.hMW = ((String)localObject2);
    ((le)localObject1).publish();
    localObject1 = ((le)localObject1).hMV.userName;
    if (!Util.isNullOrNil((String)localObject1))
    {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", new Object[] { localObject1 });
      i = a((String)localObject1, null, null);
      AppMethodBeat.o(24373);
      return i;
    }
    Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
    bh.aZW().a(106, this.callback);
    localObject1 = new f((String)localObject2, 3);
    bh.aZW().a((p)localObject1, 0);
    localObject2 = new Intent();
    ((Intent)localObject2).setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
    ((Intent)localObject2).setFlags(268435456);
    localObject1 = this.mContext;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(24373);
    return 2;
  }
  
  final class a
  {
    String userName = "";
    evg zOD = null;
    eve zOE = null;
    
    public a(String paramString, evg paramevg, eve parameve)
    {
      this.userName = paramString;
      this.zOD = paramevg;
      this.zOE = parameve;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.c
 * JD-Core Version:    0.7.0.1
 */