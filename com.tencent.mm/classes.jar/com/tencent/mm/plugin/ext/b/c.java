package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.api.d;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.jl.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private static Map<String, a> iGj = null;
  final i callback;
  private Context mContext;
  private boolean sMA;
  private String sMz;
  
  public c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24372);
    this.sMz = "";
    this.sMA = false;
    this.mContext = null;
    this.callback = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(24371);
        bg.azz().b(106, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
          paramAnonymousString = ((f)paramAnonymousq).eiq();
          Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", new Object[] { Integer.valueOf(paramAnonymousString.LUB) });
          if (paramAnonymousString.LUB > 0)
          {
            if (paramAnonymousString.LUC.isEmpty())
            {
              Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
              c.a(c.this, paramAnonymousString);
            }
            if (paramAnonymousString.LUC.size() > 1) {
              try
              {
                paramAnonymousq = new Intent();
                paramAnonymousq.putExtra("add_more_friend_search_scene", 3);
                paramAnonymousq.putExtra("result", paramAnonymousString.toByteArray());
                Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
                com.tencent.mm.plugin.ext.a.jRt.s(paramAnonymousq, c.a(c.this));
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
            c.a(c.this, (drr)paramAnonymousString.LUC.getFirst());
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
    this.sMz = paramString;
    this.sMA = true;
    AppMethodBeat.o(24372);
  }
  
  private int a(String paramString, drt paramdrt, drr paramdrr)
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
      bg.aVF();
      if (com.tencent.mm.model.c.aSN().bjG(paramString))
      {
        Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
        arp(paramString);
        AppMethodBeat.o(24375);
        return 0;
      }
    }
    if (paramdrt != null)
    {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
      a(paramdrt);
      AppMethodBeat.o(24375);
      return 1;
    }
    if (paramdrr != null)
    {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
      a(paramdrr);
      AppMethodBeat.o(24375);
      return 1;
    }
    Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
    AppMethodBeat.o(24375);
    return -1;
  }
  
  private void a(drr paramdrr)
  {
    AppMethodBeat.i(24378);
    if (paramdrr == null)
    {
      Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
      AppMethodBeat.o(24378);
      return;
    }
    Object localObject = z.a(paramdrr.Lqk);
    if (!Util.isNullOrNil((String)localObject))
    {
      a(this.sMz, new a(z.a(paramdrr.Lqk), null, paramdrr));
      bg.aVF();
      if (com.tencent.mm.model.c.aSN().bjG((String)localObject))
      {
        Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
        arp((String)localObject);
        AppMethodBeat.o(24378);
        return;
      }
      localObject = new Intent();
      d.a((Intent)localObject, paramdrr);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.jRt.c((Intent)localObject, this.mContext);
      AppMethodBeat.o(24378);
      return;
    }
    Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
    AppMethodBeat.o(24378);
  }
  
  private void a(drt paramdrt)
  {
    AppMethodBeat.i(24377);
    if (paramdrt == null)
    {
      Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
      AppMethodBeat.o(24377);
      return;
    }
    Object localObject = z.a(paramdrt.Lqk);
    if (!Util.isNullOrNil((String)localObject))
    {
      a(this.sMz, new a(z.a(paramdrt.Lqk), paramdrt, null));
      bg.aVF();
      if (com.tencent.mm.model.c.aSN().bjG((String)localObject))
      {
        Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
        arp((String)localObject);
        AppMethodBeat.o(24377);
        return;
      }
      localObject = new Intent();
      d.a((Intent)localObject, paramdrt, 15);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.jRt.c((Intent)localObject, this.mContext);
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
    if (iGj == null) {
      iGj = new HashMap();
    }
    iGj.put(paramString, parama);
    AppMethodBeat.o(24374);
  }
  
  private void arp(String paramString)
  {
    AppMethodBeat.i(24376);
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", false);
    com.tencent.mm.br.c.f(this.mContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(24376);
  }
  
  public final int cSp()
  {
    AppMethodBeat.i(24373);
    if (this.mContext == null)
    {
      Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    if (Util.isNullOrNil(this.sMz))
    {
      Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    Object localObject2 = PhoneFormater.pureNumber(this.sMz);
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    Object localObject1 = this.sMz;
    if (Util.isNullOrNil((String)localObject1)) {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
    }
    int i;
    for (localObject1 = null; localObject1 != null; localObject1 = (a)iGj.get(localObject1))
    {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
      i = a(((a)localObject1).userName, ((a)localObject1).sMC, ((a)localObject1).sMD);
      AppMethodBeat.o(24373);
      return i;
      if (iGj == null) {
        iGj = new HashMap();
      }
    }
    localObject1 = new jl();
    ((jl)localObject1).dOk.dOm = ((String)localObject2);
    EventCenter.instance.publish((IEvent)localObject1);
    localObject1 = ((jl)localObject1).dOl.userName;
    if (!Util.isNullOrNil((String)localObject1))
    {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", new Object[] { localObject1 });
      i = a((String)localObject1, null, null);
      AppMethodBeat.o(24373);
      return i;
    }
    Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
    bg.azz().a(106, this.callback);
    localObject1 = new f((String)localObject2, 3);
    bg.azz().a((q)localObject1, 0);
    localObject2 = new Intent();
    ((Intent)localObject2).setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
    ((Intent)localObject2).setFlags(268435456);
    localObject1 = this.mContext;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(24373);
    return 2;
  }
  
  final class a
  {
    drt sMC = null;
    drr sMD = null;
    String userName = "";
    
    public a(String paramString, drt paramdrt, drr paramdrr)
    {
      this.userName = paramString;
      this.sMC = paramdrt;
      this.sMD = paramdrr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.c
 * JD-Core Version:    0.7.0.1
 */