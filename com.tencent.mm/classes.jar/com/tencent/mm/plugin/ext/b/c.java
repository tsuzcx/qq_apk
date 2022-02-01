package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.g.a.iv.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private static Map<String, a> rcP = null;
  final com.tencent.mm.al.f callback;
  private Context mContext;
  private String rcN;
  private boolean rcO;
  
  public c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24372);
    this.rcN = "";
    this.rcO = false;
    this.mContext = null;
    this.callback = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(24371);
        com.tencent.mm.model.ba.aiU().b(106, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
          paramAnonymousString = ((com.tencent.mm.plugin.messenger.a.f)paramAnonymousn).dlC();
          ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", new Object[] { Integer.valueOf(paramAnonymousString.GwU) });
          if (paramAnonymousString.GwU > 0)
          {
            if (paramAnonymousString.GwV.isEmpty())
            {
              ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
              c.a(c.this, paramAnonymousString);
            }
            if (paramAnonymousString.GwV.size() > 1) {
              try
              {
                paramAnonymousn = new Intent();
                paramAnonymousn.putExtra("add_more_friend_search_scene", 3);
                paramAnonymousn.putExtra("result", paramAnonymousString.toByteArray());
                ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
                com.tencent.mm.plugin.ext.a.iRG.t(paramAnonymousn, c.a(c.this));
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
            c.a(c.this, (cya)paramAnonymousString.GwV.getFirst());
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
    this.rcN = paramString;
    this.rcO = true;
    AppMethodBeat.o(24372);
  }
  
  private int a(String paramString, cyc paramcyc, cya paramcya)
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
      com.tencent.mm.model.ba.aBQ();
      if (com.tencent.mm.model.c.azp().aTg(paramString))
      {
        ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
        afJ(paramString);
        AppMethodBeat.o(24375);
        return 0;
      }
    }
    if (paramcyc != null)
    {
      ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
      a(paramcyc);
      AppMethodBeat.o(24375);
      return 1;
    }
    if (paramcya != null)
    {
      ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
      a(paramcya);
      AppMethodBeat.o(24375);
      return 1;
    }
    ad.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
    AppMethodBeat.o(24375);
    return -1;
  }
  
  private void a(cya paramcya)
  {
    AppMethodBeat.i(24378);
    if (paramcya == null)
    {
      ad.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
      AppMethodBeat.o(24378);
      return;
    }
    Object localObject = z.a(paramcya.GbY);
    if (!bt.isNullOrNil((String)localObject))
    {
      a(this.rcN, new a(z.a(paramcya.GbY), null, paramcya));
      com.tencent.mm.model.ba.aBQ();
      if (com.tencent.mm.model.c.azp().aTg((String)localObject))
      {
        ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
        afJ((String)localObject);
        AppMethodBeat.o(24378);
        return;
      }
      localObject = new Intent();
      com.tencent.mm.api.d.a((Intent)localObject, paramcya);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.iRG.c((Intent)localObject, this.mContext);
      AppMethodBeat.o(24378);
      return;
    }
    ad.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
    AppMethodBeat.o(24378);
  }
  
  private void a(cyc paramcyc)
  {
    AppMethodBeat.i(24377);
    if (paramcyc == null)
    {
      ad.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
      AppMethodBeat.o(24377);
      return;
    }
    Object localObject = z.a(paramcyc.GbY);
    if (!bt.isNullOrNil((String)localObject))
    {
      a(this.rcN, new a(z.a(paramcyc.GbY), paramcyc, null));
      com.tencent.mm.model.ba.aBQ();
      if (com.tencent.mm.model.c.azp().aTg((String)localObject))
      {
        ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
        afJ((String)localObject);
        AppMethodBeat.o(24377);
        return;
      }
      localObject = new Intent();
      com.tencent.mm.api.d.a((Intent)localObject, paramcyc, 15);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.iRG.c((Intent)localObject, this.mContext);
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
    if (rcP == null) {
      rcP = new HashMap();
    }
    rcP.put(paramString, parama);
    AppMethodBeat.o(24374);
  }
  
  private void afJ(String paramString)
  {
    AppMethodBeat.i(24376);
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", false);
    com.tencent.mm.bs.d.f(this.mContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(24376);
  }
  
  public final int csf()
  {
    AppMethodBeat.i(24373);
    if (this.mContext == null)
    {
      ad.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    if (bt.isNullOrNil(this.rcN))
    {
      ad.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    Object localObject2 = com.tencent.mm.sdk.platformtools.ba.aQI(this.rcN);
    if (bt.isNullOrNil((String)localObject2))
    {
      ad.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    Object localObject1 = this.rcN;
    if (bt.isNullOrNil((String)localObject1)) {
      ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
    }
    int i;
    for (localObject1 = null; localObject1 != null; localObject1 = (a)rcP.get(localObject1))
    {
      ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
      i = a(((a)localObject1).userName, ((a)localObject1).rcR, ((a)localObject1).rcS);
      AppMethodBeat.o(24373);
      return i;
      if (rcP == null) {
        rcP = new HashMap();
      }
    }
    localObject1 = new iv();
    ((iv)localObject1).dvy.dvA = ((String)localObject2);
    com.tencent.mm.sdk.b.a.IbL.l((b)localObject1);
    localObject1 = ((iv)localObject1).dvz.userName;
    if (!bt.isNullOrNil((String)localObject1))
    {
      ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", new Object[] { localObject1 });
      i = a((String)localObject1, null, null);
      AppMethodBeat.o(24373);
      return i;
    }
    ad.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
    com.tencent.mm.model.ba.aiU().a(106, this.callback);
    localObject1 = new com.tencent.mm.plugin.messenger.a.f((String)localObject2, 3);
    com.tencent.mm.model.ba.aiU().a((n)localObject1, 0);
    localObject2 = new Intent();
    ((Intent)localObject2).setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
    ((Intent)localObject2).setFlags(268435456);
    localObject1 = this.mContext;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(24373);
    return 2;
  }
  
  final class a
  {
    cyc rcR = null;
    cya rcS = null;
    String userName = "";
    
    public a(String paramString, cyc paramcyc, cya paramcya)
    {
      this.userName = paramString;
      this.rcR = paramcyc;
      this.rcS = paramcya;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.c
 * JD-Core Version:    0.7.0.1
 */