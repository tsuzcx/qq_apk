package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.g.a.ig.b;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private static Map<String, a> pKu = null;
  final com.tencent.mm.al.g callback;
  private Context mContext;
  private String pKs;
  private boolean pKt;
  
  public c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24372);
    this.pKs = "";
    this.pKt = false;
    this.mContext = null;
    this.callback = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(24371);
        az.aeS().b(106, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
          paramAnonymousString = ((com.tencent.mm.plugin.messenger.a.g)paramAnonymousn).cOA();
          ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", new Object[] { Integer.valueOf(paramAnonymousString.DsM) });
          if (paramAnonymousString.DsM > 0)
          {
            if (paramAnonymousString.DsN.isEmpty())
            {
              ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
              c.a(c.this, paramAnonymousString);
            }
            if (paramAnonymousString.DsN.size() > 1) {
              try
              {
                paramAnonymousn = new Intent();
                paramAnonymousn.putExtra("add_more_friend_search_scene", 3);
                paramAnonymousn.putExtra("result", paramAnonymousString.toByteArray());
                ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
                com.tencent.mm.plugin.ext.a.hYt.t(paramAnonymousn, c.a(c.this));
                AppMethodBeat.o(24371);
                return;
              }
              catch (IOException paramAnonymousString)
              {
                ad.printErrStackTrace("MicroMsg.RedirectToChattingByPhoneHelper", paramAnonymousString, "", new Object[0]);
                AppMethodBeat.o(24371);
                return;
              }
            }
            c.a(c.this, (cnj)paramAnonymousString.DsN.getFirst());
            AppMethodBeat.o(24371);
            return;
          }
          ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: only one result is retrieved. start to chatting directly");
          c.b(c.this, paramAnonymousString);
          AppMethodBeat.o(24371);
          return;
        }
        ad.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: err net.errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        c.a(c.this, null);
        AppMethodBeat.o(24371);
      }
    };
    this.mContext = paramContext;
    this.pKs = paramString;
    this.pKt = true;
    AppMethodBeat.o(24372);
  }
  
  private void Xx(String paramString)
  {
    AppMethodBeat.i(24376);
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", false);
    com.tencent.mm.bs.d.e(this.mContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(24376);
  }
  
  private int a(String paramString, cnl paramcnl, cnj paramcnj)
  {
    AppMethodBeat.i(24375);
    if (this.mContext == null)
    {
      ad.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: error param. start redirect param error: context is null");
      AppMethodBeat.o(24375);
      return -1;
    }
    if (!bt.isNullOrNil(paramString))
    {
      az.arV();
      if (com.tencent.mm.model.c.apM().aHT(paramString))
      {
        ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
        Xx(paramString);
        AppMethodBeat.o(24375);
        return 0;
      }
    }
    if (paramcnl != null)
    {
      ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
      a(paramcnl);
      AppMethodBeat.o(24375);
      return 1;
    }
    if (paramcnj != null)
    {
      ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
      a(paramcnj);
      AppMethodBeat.o(24375);
      return 1;
    }
    ad.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
    AppMethodBeat.o(24375);
    return -1;
  }
  
  private void a(cnj paramcnj)
  {
    AppMethodBeat.i(24378);
    if (paramcnj == null)
    {
      ad.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
      AppMethodBeat.o(24378);
      return;
    }
    Object localObject = z.a(paramcnj.Dby);
    if (!bt.isNullOrNil((String)localObject))
    {
      a(this.pKs, new a(z.a(paramcnj.Dby), null, paramcnj));
      az.arV();
      if (com.tencent.mm.model.c.apM().aHT((String)localObject))
      {
        ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
        Xx((String)localObject);
        AppMethodBeat.o(24378);
        return;
      }
      localObject = new Intent();
      com.tencent.mm.api.d.a((Intent)localObject, paramcnj);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.hYt.c((Intent)localObject, this.mContext);
      AppMethodBeat.o(24378);
      return;
    }
    ad.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
    AppMethodBeat.o(24378);
  }
  
  private void a(cnl paramcnl)
  {
    AppMethodBeat.i(24377);
    if (paramcnl == null)
    {
      ad.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
      AppMethodBeat.o(24377);
      return;
    }
    Object localObject = z.a(paramcnl.Dby);
    if (!bt.isNullOrNil((String)localObject))
    {
      a(this.pKs, new a(z.a(paramcnl.Dby), paramcnl, null));
      az.arV();
      if (com.tencent.mm.model.c.apM().aHT((String)localObject))
      {
        ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
        Xx((String)localObject);
        AppMethodBeat.o(24377);
        return;
      }
      localObject = new Intent();
      com.tencent.mm.api.d.a((Intent)localObject, paramcnl, 15);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.hYt.c((Intent)localObject, this.mContext);
      AppMethodBeat.o(24377);
      return;
    }
    ad.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
    AppMethodBeat.o(24377);
  }
  
  private static void a(String paramString, a parama)
  {
    AppMethodBeat.i(24374);
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when put to cache");
      AppMethodBeat.o(24374);
      return;
    }
    if (pKu == null) {
      pKu = new HashMap();
    }
    pKu.put(paramString, parama);
    AppMethodBeat.o(24374);
  }
  
  public final int ceT()
  {
    AppMethodBeat.i(24373);
    if (this.mContext == null)
    {
      ad.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    if (bt.isNullOrNil(this.pKs))
    {
      ad.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    Object localObject2 = ba.aFL(this.pKs);
    if (bt.isNullOrNil((String)localObject2))
    {
      ad.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    Object localObject1 = this.pKs;
    if (bt.isNullOrNil((String)localObject1)) {
      ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
    }
    int i;
    for (localObject1 = null; localObject1 != null; localObject1 = (a)pKu.get(localObject1))
    {
      ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
      i = a(((a)localObject1).userName, ((a)localObject1).pKw, ((a)localObject1).pKx);
      AppMethodBeat.o(24373);
      return i;
      if (pKu == null) {
        pKu = new HashMap();
      }
    }
    localObject1 = new ig();
    ((ig)localObject1).dmd.dmf = ((String)localObject2);
    com.tencent.mm.sdk.b.a.ESL.l((b)localObject1);
    localObject1 = ((ig)localObject1).dme.userName;
    if (!bt.isNullOrNil((String)localObject1))
    {
      ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", new Object[] { localObject1 });
      i = a((String)localObject1, null, null);
      AppMethodBeat.o(24373);
      return i;
    }
    ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
    az.aeS().a(106, this.callback);
    localObject1 = new com.tencent.mm.plugin.messenger.a.g((String)localObject2, 3);
    az.aeS().a((n)localObject1, 0);
    localObject2 = new Intent();
    ((Intent)localObject2).setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
    ((Intent)localObject2).setFlags(268435456);
    localObject1 = this.mContext;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(24373);
    return 2;
  }
  
  final class a
  {
    cnl pKw = null;
    cnj pKx = null;
    String userName = "";
    
    public a(String paramString, cnl paramcnl, cnj paramcnj)
    {
      this.userName = paramString;
      this.pKw = paramcnl;
      this.pKx = paramcnj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.c
 * JD-Core Version:    0.7.0.1
 */