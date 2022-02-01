package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.in.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private static Map<String, a> qtb = null;
  final com.tencent.mm.ak.g callback;
  private Context mContext;
  private String qsZ;
  private boolean qta;
  
  public c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24372);
    this.qsZ = "";
    this.qta = false;
    this.mContext = null;
    this.callback = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(24371);
        com.tencent.mm.model.az.agi().b(106, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          ac.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
          paramAnonymousString = ((com.tencent.mm.plugin.messenger.a.g)paramAnonymousn).dcj();
          ac.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", new Object[] { Integer.valueOf(paramAnonymousString.ENQ) });
          if (paramAnonymousString.ENQ > 0)
          {
            if (paramAnonymousString.ENR.isEmpty())
            {
              ac.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
              c.a(c.this, paramAnonymousString);
            }
            if (paramAnonymousString.ENR.size() > 1) {
              try
              {
                paramAnonymousn = new Intent();
                paramAnonymousn.putExtra("add_more_friend_search_scene", 3);
                paramAnonymousn.putExtra("result", paramAnonymousString.toByteArray());
                ac.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
                com.tencent.mm.plugin.ext.a.iyx.t(paramAnonymousn, c.a(c.this));
                AppMethodBeat.o(24371);
                return;
              }
              catch (IOException paramAnonymousString)
              {
                ac.printErrStackTrace("MicroMsg.RedirectToChattingByPhoneHelper", paramAnonymousString, "", new Object[0]);
                AppMethodBeat.o(24371);
                return;
              }
            }
            c.a(c.this, (csq)paramAnonymousString.ENR.getFirst());
            AppMethodBeat.o(24371);
            return;
          }
          ac.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: only one result is retrieved. start to chatting directly");
          c.b(c.this, paramAnonymousString);
          AppMethodBeat.o(24371);
          return;
        }
        ac.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: err net.errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        c.a(c.this, null);
        AppMethodBeat.o(24371);
      }
    };
    this.mContext = paramContext;
    this.qsZ = paramString;
    this.qta = true;
    AppMethodBeat.o(24372);
  }
  
  private int a(String paramString, css paramcss, csq paramcsq)
  {
    AppMethodBeat.i(24375);
    if (this.mContext == null)
    {
      ac.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: error param. start redirect param error: context is null");
      AppMethodBeat.o(24375);
      return -1;
    }
    if (!bs.isNullOrNil(paramString))
    {
      com.tencent.mm.model.az.ayM();
      if (com.tencent.mm.model.c.awB().aNo(paramString))
      {
        ac.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
        abU(paramString);
        AppMethodBeat.o(24375);
        return 0;
      }
    }
    if (paramcss != null)
    {
      ac.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
      a(paramcss);
      AppMethodBeat.o(24375);
      return 1;
    }
    if (paramcsq != null)
    {
      ac.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
      a(paramcsq);
      AppMethodBeat.o(24375);
      return 1;
    }
    ac.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
    AppMethodBeat.o(24375);
    return -1;
  }
  
  private void a(csq paramcsq)
  {
    AppMethodBeat.i(24378);
    if (paramcsq == null)
    {
      ac.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
      AppMethodBeat.o(24378);
      return;
    }
    Object localObject = z.a(paramcsq.EuE);
    if (!bs.isNullOrNil((String)localObject))
    {
      a(this.qsZ, new a(z.a(paramcsq.EuE), null, paramcsq));
      com.tencent.mm.model.az.ayM();
      if (com.tencent.mm.model.c.awB().aNo((String)localObject))
      {
        ac.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
        abU((String)localObject);
        AppMethodBeat.o(24378);
        return;
      }
      localObject = new Intent();
      com.tencent.mm.api.d.a((Intent)localObject, paramcsq);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.iyx.c((Intent)localObject, this.mContext);
      AppMethodBeat.o(24378);
      return;
    }
    ac.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
    AppMethodBeat.o(24378);
  }
  
  private void a(css paramcss)
  {
    AppMethodBeat.i(24377);
    if (paramcss == null)
    {
      ac.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
      AppMethodBeat.o(24377);
      return;
    }
    Object localObject = z.a(paramcss.EuE);
    if (!bs.isNullOrNil((String)localObject))
    {
      a(this.qsZ, new a(z.a(paramcss.EuE), paramcss, null));
      com.tencent.mm.model.az.ayM();
      if (com.tencent.mm.model.c.awB().aNo((String)localObject))
      {
        ac.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
        abU((String)localObject);
        AppMethodBeat.o(24377);
        return;
      }
      localObject = new Intent();
      com.tencent.mm.api.d.a((Intent)localObject, paramcss, 15);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.iyx.c((Intent)localObject, this.mContext);
      AppMethodBeat.o(24377);
      return;
    }
    ac.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
    AppMethodBeat.o(24377);
  }
  
  private static void a(String paramString, a parama)
  {
    AppMethodBeat.i(24374);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when put to cache");
      AppMethodBeat.o(24374);
      return;
    }
    if (qtb == null) {
      qtb = new HashMap();
    }
    qtb.put(paramString, parama);
    AppMethodBeat.o(24374);
  }
  
  private void abU(String paramString)
  {
    AppMethodBeat.i(24376);
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", false);
    com.tencent.mm.br.d.e(this.mContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(24376);
  }
  
  public final int cmA()
  {
    AppMethodBeat.i(24373);
    if (this.mContext == null)
    {
      ac.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    if (bs.isNullOrNil(this.qsZ))
    {
      ac.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    Object localObject2 = com.tencent.mm.sdk.platformtools.az.aLc(this.qsZ);
    if (bs.isNullOrNil((String)localObject2))
    {
      ac.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    Object localObject1 = this.qsZ;
    if (bs.isNullOrNil((String)localObject1)) {
      ac.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
    }
    int i;
    for (localObject1 = null; localObject1 != null; localObject1 = (a)qtb.get(localObject1))
    {
      ac.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
      i = a(((a)localObject1).userName, ((a)localObject1).qtd, ((a)localObject1).qte);
      AppMethodBeat.o(24373);
      return i;
      if (qtb == null) {
        qtb = new HashMap();
      }
    }
    localObject1 = new in();
    ((in)localObject1).djL.djN = ((String)localObject2);
    com.tencent.mm.sdk.b.a.GpY.l((b)localObject1);
    localObject1 = ((in)localObject1).djM.userName;
    if (!bs.isNullOrNil((String)localObject1))
    {
      ac.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", new Object[] { localObject1 });
      i = a((String)localObject1, null, null);
      AppMethodBeat.o(24373);
      return i;
    }
    ac.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
    com.tencent.mm.model.az.agi().a(106, this.callback);
    localObject1 = new com.tencent.mm.plugin.messenger.a.g((String)localObject2, 3);
    com.tencent.mm.model.az.agi().a((n)localObject1, 0);
    localObject2 = new Intent();
    ((Intent)localObject2).setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
    ((Intent)localObject2).setFlags(268435456);
    localObject1 = this.mContext;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(24373);
    return 2;
  }
  
  final class a
  {
    css qtd = null;
    csq qte = null;
    String userName = "";
    
    public a(String paramString, css paramcss, csq paramcsq)
    {
      this.userName = paramString;
      this.qtd = paramcss;
      this.qte = paramcsq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.c
 * JD-Core Version:    0.7.0.1
 */