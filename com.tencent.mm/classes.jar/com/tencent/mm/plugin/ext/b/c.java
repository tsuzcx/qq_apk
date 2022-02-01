package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.api.d;
import com.tencent.mm.f.a.kb;
import com.tencent.mm.f.a.kb.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.ebp;
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
  private static Map<String, a> lwl = null;
  final i callback;
  private Context mContext;
  private String wsu;
  private boolean wsv;
  
  public c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24372);
    this.wsu = "";
    this.wsv = false;
    this.mContext = null;
    this.callback = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(24371);
        bh.aGY().b(106, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
          paramAnonymousString = ((f)paramAnonymousq).eRV();
          Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", new Object[] { Integer.valueOf(paramAnonymousString.Tdj) });
          if (paramAnonymousString.Tdj > 0)
          {
            if (paramAnonymousString.Tdk.isEmpty())
            {
              Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
              c.a(c.this, paramAnonymousString);
            }
            if (paramAnonymousString.Tdk.size() > 1) {
              try
              {
                paramAnonymousq = new Intent();
                paramAnonymousq.putExtra("add_more_friend_search_scene", 3);
                paramAnonymousq.putExtra("result", paramAnonymousString.toByteArray());
                Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
                com.tencent.mm.plugin.ext.a.dhe().r(paramAnonymousq, c.a(c.this));
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
            c.a(c.this, (ebn)paramAnonymousString.Tdk.getFirst());
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
    this.wsu = paramString;
    this.wsv = true;
    AppMethodBeat.o(24372);
  }
  
  private int a(String paramString, ebp paramebp, ebn paramebn)
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
      bh.beI();
      if (com.tencent.mm.model.c.bbL().bwd(paramString))
      {
        Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
        azq(paramString);
        AppMethodBeat.o(24375);
        return 0;
      }
    }
    if (paramebp != null)
    {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
      a(paramebp);
      AppMethodBeat.o(24375);
      return 1;
    }
    if (paramebn != null)
    {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
      a(paramebn);
      AppMethodBeat.o(24375);
      return 1;
    }
    Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
    AppMethodBeat.o(24375);
    return -1;
  }
  
  private void a(ebn paramebn)
  {
    AppMethodBeat.i(24378);
    if (paramebn == null)
    {
      Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
      AppMethodBeat.o(24378);
      return;
    }
    Object localObject = z.a(paramebn.SrH);
    if (!Util.isNullOrNil((String)localObject))
    {
      a(this.wsu, new a(z.a(paramebn.SrH), null, paramebn));
      bh.beI();
      if (com.tencent.mm.model.c.bbL().bwd((String)localObject))
      {
        Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
        azq((String)localObject);
        AppMethodBeat.o(24378);
        return;
      }
      localObject = new Intent();
      d.a((Intent)localObject, paramebn);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.dhe().c((Intent)localObject, this.mContext);
      AppMethodBeat.o(24378);
      return;
    }
    Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
    AppMethodBeat.o(24378);
  }
  
  private void a(ebp paramebp)
  {
    AppMethodBeat.i(24377);
    if (paramebp == null)
    {
      Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
      AppMethodBeat.o(24377);
      return;
    }
    Object localObject = z.a(paramebp.SrH);
    if (!Util.isNullOrNil((String)localObject))
    {
      a(this.wsu, new a(z.a(paramebp.SrH), paramebp, null));
      bh.beI();
      if (com.tencent.mm.model.c.bbL().bwd((String)localObject))
      {
        Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
        azq((String)localObject);
        AppMethodBeat.o(24377);
        return;
      }
      localObject = new Intent();
      d.a((Intent)localObject, paramebp, 15);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.dhe().c((Intent)localObject, this.mContext);
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
    if (lwl == null) {
      lwl = new HashMap();
    }
    lwl.put(paramString, parama);
    AppMethodBeat.o(24374);
  }
  
  private void azq(String paramString)
  {
    AppMethodBeat.i(24376);
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", false);
    com.tencent.mm.by.c.f(this.mContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(24376);
  }
  
  public final int dhp()
  {
    AppMethodBeat.i(24373);
    if (this.mContext == null)
    {
      Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    if (Util.isNullOrNil(this.wsu))
    {
      Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    Object localObject2 = PhoneFormater.pureNumber(this.wsu);
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
      AppMethodBeat.o(24373);
      return -1;
    }
    Object localObject1 = this.wsu;
    if (Util.isNullOrNil((String)localObject1)) {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
    }
    int i;
    for (localObject1 = null; localObject1 != null; localObject1 = (a)lwl.get(localObject1))
    {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
      i = a(((a)localObject1).userName, ((a)localObject1).wsx, ((a)localObject1).wsy);
      AppMethodBeat.o(24373);
      return i;
      if (lwl == null) {
        lwl = new HashMap();
      }
    }
    localObject1 = new kb();
    ((kb)localObject1).fHv.fHx = ((String)localObject2);
    EventCenter.instance.publish((IEvent)localObject1);
    localObject1 = ((kb)localObject1).fHw.userName;
    if (!Util.isNullOrNil((String)localObject1))
    {
      Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", new Object[] { localObject1 });
      i = a((String)localObject1, null, null);
      AppMethodBeat.o(24373);
      return i;
    }
    Log.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
    bh.aGY().a(106, this.callback);
    localObject1 = new f((String)localObject2, 3);
    bh.aGY().a((q)localObject1, 0);
    localObject2 = new Intent();
    ((Intent)localObject2).setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
    ((Intent)localObject2).setFlags(268435456);
    localObject1 = this.mContext;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/ext/model/RedirectToChattingByPhoneHelper", "startDialogUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(24373);
    return 2;
  }
  
  final class a
  {
    String userName = "";
    ebp wsx = null;
    ebn wsy = null;
    
    public a(String paramString, ebp paramebp, ebn paramebn)
    {
      this.userName = paramString;
      this.wsx = paramebp;
      this.wsy = paramebn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.c
 * JD-Core Version:    0.7.0.1
 */