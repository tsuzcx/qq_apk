package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.g.a.iw.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private static Map<String, a> rkV = null;
  final com.tencent.mm.ak.f callback;
  private Context mContext;
  private String rkT;
  private boolean rkU;
  
  public c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24372);
    this.rkT = "";
    this.rkU = false;
    this.mContext = null;
    this.callback = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(24371);
        bc.ajj().b(106, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          ae.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
          paramAnonymousString = ((com.tencent.mm.plugin.messenger.a.f)paramAnonymousn).doB();
          ae.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", new Object[] { Integer.valueOf(paramAnonymousString.GQu) });
          if (paramAnonymousString.GQu > 0)
          {
            if (paramAnonymousString.GQv.isEmpty())
            {
              ae.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
              c.a(c.this, paramAnonymousString);
            }
            if (paramAnonymousString.GQv.size() > 1) {
              try
              {
                paramAnonymousn = new Intent();
                paramAnonymousn.putExtra("add_more_friend_search_scene", 3);
                paramAnonymousn.putExtra("result", paramAnonymousString.toByteArray());
                ae.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
                com.tencent.mm.plugin.ext.a.iUz.t(paramAnonymousn, c.a(c.this));
                AppMethodBeat.o(24371);
                return;
              }
              catch (IOException paramAnonymousString)
              {
                ae.printErrStackTrace("MicroMsg.RedirectToChattingByPhoneHelper", paramAnonymousString, "", new Object[0]);
                AppMethodBeat.o(24371);
                return;
              }
            }
            c.a(c.this, (cyu)paramAnonymousString.GQv.getFirst());
            AppMethodBeat.o(24371);
            return;
          }
          ae.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: only one result is retrieved. start to chatting directly");
          c.b(c.this, paramAnonymousString);
          AppMethodBeat.o(24371);
          return;
        }
        ae.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: err net.errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        c.a(c.this, null);
        AppMethodBeat.o(24371);
      }
    };
    this.mContext = paramContext;
    this.rkT = paramString;
    this.rkU = true;
    AppMethodBeat.o(24372);
  }
  
  private int a(String paramString, cyw paramcyw, cyu paramcyu)
  {
    AppMethodBeat.i(24375);
    if (this.mContext == null)
    {
      ae.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: error param. start redirect param error: context is null");
      AppMethodBeat.o(24375);
      return -1;
    }
    if (!bu.isNullOrNil(paramString))
    {
      bc.aCg();
      if (com.tencent.mm.model.c.azF().aUH(paramString))
      {
        ae.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
        agF(paramString);
        AppMethodBeat.o(24375);
        return 0;
      }
    }
    if (paramcyw != null)
    {
      ae.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
      a(paramcyw);
      AppMethodBeat.o(24375);
      return 1;
    }
    if (paramcyu != null)
    {
      ae.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
      a(paramcyu);
      AppMethodBeat.o(24375);
      return 1;
    }
    ae.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
    AppMethodBeat.o(24375);
    return -1;
  }
  
  private void a(cyu paramcyu)
  {
    AppMethodBeat.i(24378);
    if (paramcyu == null)
    {
      ae.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
      AppMethodBeat.o(24378);
      return;
    }
    Object localObject = z.a(paramcyu.GuF);
    if (!bu.isNullOrNil((String)localObject))
    {
      a(this.rkT, new a(z.a(paramcyu.GuF), null, paramcyu));
      bc.aCg();
      if (com.tencent.mm.model.c.azF().aUH((String)localObject))
      {
        ae.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
        agF((String)localObject);
        AppMethodBeat.o(24378);
        return;
      }
      localObject = new Intent();
      com.tencent.mm.api.d.a((Intent)localObject, paramcyu);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.iUz.c((Intent)localObject, this.mContext);
      AppMethodBeat.o(24378);
      return;
    }
    ae.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
    AppMethodBeat.o(24378);
  }
  
  private void a(cyw paramcyw)
  {
    AppMethodBeat.i(24377);
    if (paramcyw == null)
    {
      ae.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
      AppMethodBeat.o(24377);
      return;
    }
    Object localObject = z.a(paramcyw.GuF);
    if (!bu.isNullOrNil((String)localObject))
    {
      a(this.rkT, new a(z.a(paramcyw.GuF), paramcyw, null));
      bc.aCg();
      if (com.tencent.mm.model.c.azF().aUH((String)localObject))
      {
        ae.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
        agF((String)localObject);
        AppMethodBeat.o(24377);
        return;
      }
      localObject = new Intent();
      com.tencent.mm.api.d.a((Intent)localObject, paramcyw, 15);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.iUz.c((Intent)localObject, this.mContext);
      AppMethodBeat.o(24377);
      return;
    }
    ae.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
    AppMethodBeat.o(24377);
  }
  
  private static void a(String paramString, a parama)
  {
    AppMethodBeat.i(24374);
    if (bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when put to cache");
      AppMethodBeat.o(24374);
      return;
    }
    if (rkV == null) {
      rkV = new HashMap();
    }
    rkV.put(paramString, parama);
    AppMethodBeat.o(24374);
  }
  
  private void agF(String paramString)
  {
    AppMethodBeat.i(24376);
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", false);
    com.tencent.mm.br.d.f(this.mContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(24376);
  }
  
  public final int ctH()
  {
    AppMethodBeat.i(24373);
    if (this.mContext == null)
    {
      ae.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    if (bu.isNullOrNil(this.rkT))
    {
      ae.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    Object localObject2 = bb.aSf(this.rkT);
    if (bu.isNullOrNil((String)localObject2))
    {
      ae.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    Object localObject1 = this.rkT;
    if (bu.isNullOrNil((String)localObject1)) {
      ae.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
    }
    int i;
    for (localObject1 = null; localObject1 != null; localObject1 = (a)rkV.get(localObject1))
    {
      ae.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
      i = a(((a)localObject1).userName, ((a)localObject1).rkX, ((a)localObject1).rkY);
      AppMethodBeat.o(24373);
      return i;
      if (rkV == null) {
        rkV = new HashMap();
      }
    }
    localObject1 = new iw();
    ((iw)localObject1).dwD.dwF = ((String)localObject2);
    com.tencent.mm.sdk.b.a.IvT.l((b)localObject1);
    localObject1 = ((iw)localObject1).dwE.userName;
    if (!bu.isNullOrNil((String)localObject1))
    {
      ae.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", new Object[] { localObject1 });
      i = a((String)localObject1, null, null);
      AppMethodBeat.o(24373);
      return i;
    }
    ae.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
    bc.ajj().a(106, this.callback);
    localObject1 = new com.tencent.mm.plugin.messenger.a.f((String)localObject2, 3);
    bc.ajj().a((n)localObject1, 0);
    localObject2 = new Intent();
    ((Intent)localObject2).setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
    ((Intent)localObject2).setFlags(268435456);
    localObject1 = this.mContext;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(24373);
    return 2;
  }
  
  final class a
  {
    cyw rkX = null;
    cyu rkY = null;
    String userName = "";
    
    public a(String paramString, cyw paramcyw, cyu paramcyu)
    {
      this.userName = paramString;
      this.rkX = paramcyw;
      this.rkY = paramcyu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.c
 * JD-Core Version:    0.7.0.1
 */