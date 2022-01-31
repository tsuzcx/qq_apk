package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.g.a.hm.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static Map<String, c.a> mCache = null;
  final com.tencent.mm.ai.f callback;
  private Context mContext;
  private String mdN;
  private boolean mdO;
  
  public c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(20299);
    this.mdN = "";
    this.mdO = false;
    this.mContext = null;
    this.callback = new c.1(this);
    this.mContext = paramContext;
    this.mdN = paramString;
    this.mdO = true;
    AppMethodBeat.o(20299);
  }
  
  private void Nd(String paramString)
  {
    AppMethodBeat.i(20303);
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", false);
    d.f(this.mContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(20303);
  }
  
  private int a(String paramString, bxh parambxh, bxf parambxf)
  {
    AppMethodBeat.i(20302);
    if (this.mContext == null)
    {
      ab.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: error param. start redirect param error: context is null");
      AppMethodBeat.o(20302);
      return -1;
    }
    if (!bo.isNullOrNil(paramString))
    {
      aw.aaz();
      if (com.tencent.mm.model.c.YA().arr(paramString))
      {
        ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
        Nd(paramString);
        AppMethodBeat.o(20302);
        return 0;
      }
    }
    if (parambxh != null)
    {
      ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
      a(parambxh);
      AppMethodBeat.o(20302);
      return 1;
    }
    if (parambxf != null)
    {
      ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
      a(parambxf);
      AppMethodBeat.o(20302);
      return 1;
    }
    ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
    AppMethodBeat.o(20302);
    return -1;
  }
  
  private void a(bxf parambxf)
  {
    AppMethodBeat.i(20305);
    if (parambxf == null)
    {
      ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
      AppMethodBeat.o(20305);
      return;
    }
    Object localObject = aa.a(parambxf.wOT);
    if (!bo.isNullOrNil((String)localObject))
    {
      a(this.mdN, new c.a(this, aa.a(parambxf.wOT), null, parambxf));
      aw.aaz();
      if (com.tencent.mm.model.c.YA().arr((String)localObject))
      {
        ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
        Nd((String)localObject);
        AppMethodBeat.o(20305);
        return;
      }
      localObject = new Intent();
      com.tencent.mm.api.b.a((Intent)localObject, parambxf);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.gmO.c((Intent)localObject, this.mContext);
      AppMethodBeat.o(20305);
      return;
    }
    ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
    AppMethodBeat.o(20305);
  }
  
  private void a(bxh parambxh)
  {
    AppMethodBeat.i(20304);
    if (parambxh == null)
    {
      ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
      AppMethodBeat.o(20304);
      return;
    }
    Object localObject = aa.a(parambxh.wOT);
    if (!bo.isNullOrNil((String)localObject))
    {
      a(this.mdN, new c.a(this, aa.a(parambxh.wOT), parambxh, null));
      aw.aaz();
      if (com.tencent.mm.model.c.YA().arr((String)localObject))
      {
        ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
        Nd((String)localObject);
        AppMethodBeat.o(20304);
        return;
      }
      localObject = new Intent();
      com.tencent.mm.api.b.a((Intent)localObject, parambxh, 15);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.gmO.c((Intent)localObject, this.mContext);
      AppMethodBeat.o(20304);
      return;
    }
    ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
    AppMethodBeat.o(20304);
  }
  
  private static void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(20301);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when put to cache");
      AppMethodBeat.o(20301);
      return;
    }
    if (mCache == null) {
      mCache = new HashMap();
    }
    mCache.put(paramString, parama);
    AppMethodBeat.o(20301);
  }
  
  public final int btz()
  {
    AppMethodBeat.i(20300);
    if (this.mContext == null)
    {
      ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
      AppMethodBeat.o(20300);
      return -1;
    }
    if (bo.isNullOrNil(this.mdN))
    {
      ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
      AppMethodBeat.o(20300);
      return -1;
    }
    String str = av.apy(this.mdN);
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
      AppMethodBeat.o(20300);
      return -1;
    }
    Object localObject = this.mdN;
    if (bo.isNullOrNil((String)localObject)) {
      ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
    }
    int i;
    for (localObject = null; localObject != null; localObject = (c.a)mCache.get(localObject))
    {
      ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
      i = a(((c.a)localObject).userName, ((c.a)localObject).mdQ, ((c.a)localObject).mdR);
      AppMethodBeat.o(20300);
      return i;
      if (mCache == null) {
        mCache = new HashMap();
      }
    }
    localObject = new hm();
    ((hm)localObject).cwC.cwE = str;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((hm)localObject).cwD.userName;
    if (!bo.isNullOrNil((String)localObject))
    {
      ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", new Object[] { localObject });
      i = a((String)localObject, null, null);
      AppMethodBeat.o(20300);
      return i;
    }
    ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
    aw.Rc().a(106, this.callback);
    localObject = new com.tencent.mm.plugin.messenger.a.f(str, 3);
    aw.Rc().a((m)localObject, 0);
    localObject = new Intent();
    ((Intent)localObject).setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
    ((Intent)localObject).setFlags(268435456);
    this.mContext.startActivity((Intent)localObject);
    AppMethodBeat.o(20300);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.c
 * JD-Core Version:    0.7.0.1
 */