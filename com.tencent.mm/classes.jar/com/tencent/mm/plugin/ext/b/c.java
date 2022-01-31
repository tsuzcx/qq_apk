package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ah.p;
import com.tencent.mm.api.i;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.hi;
import com.tencent.mm.h.a.hi.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static Map<String, c.a> mCache = null;
  final com.tencent.mm.ah.f dmL = new c.1(this);
  private String jJJ = "";
  private boolean jJK = false;
  private Context mContext = null;
  
  public c(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.jJJ = paramString;
    this.jJK = true;
  }
  
  private void Cc(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", false);
    d.e(this.mContext, ".ui.chatting.ChattingUI", localIntent);
  }
  
  private int a(String paramString, bnm parambnm, bnk parambnk)
  {
    if (this.mContext == null)
    {
      y.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: error param. start redirect param error: context is null");
      return -1;
    }
    if (!bk.bl(paramString))
    {
      au.Hx();
      if (com.tencent.mm.model.c.Fw().abg(paramString))
      {
        y.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
        Cc(paramString);
        return 0;
      }
    }
    if (parambnm != null)
    {
      y.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
      a(parambnm);
      return 1;
    }
    if (parambnk != null)
    {
      y.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
      a(parambnk);
      return 1;
    }
    y.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
    return -1;
  }
  
  private void a(bnk parambnk)
  {
    if (parambnk == null)
    {
      y.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
      return;
    }
    Object localObject = aa.a(parambnk.sQs);
    if (!bk.bl((String)localObject))
    {
      a(this.jJJ, new c.a(this, aa.a(parambnk.sQs), null, parambnk));
      au.Hx();
      if (com.tencent.mm.model.c.Fw().abg((String)localObject))
      {
        y.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
        Cc((String)localObject);
        return;
      }
      localObject = new Intent();
      ((i)g.r(i.class)).a((Intent)localObject, parambnk, 15);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.eUR.d((Intent)localObject, this.mContext);
      return;
    }
    y.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
  }
  
  private void a(bnm parambnm)
  {
    if (parambnm == null)
    {
      y.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
      return;
    }
    Object localObject = aa.a(parambnm.sQs);
    if (!bk.bl((String)localObject))
    {
      a(this.jJJ, new c.a(this, aa.a(parambnm.sQs), parambnm, null));
      au.Hx();
      if (com.tencent.mm.model.c.Fw().abg((String)localObject))
      {
        y.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
        Cc((String)localObject);
        return;
      }
      localObject = new Intent();
      com.tencent.mm.pluginsdk.ui.tools.c.a((Intent)localObject, parambnm, 15);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.eUR.d((Intent)localObject, this.mContext);
      return;
    }
    y.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
  }
  
  private static void a(String paramString, c.a parama)
  {
    if (bk.bl(paramString))
    {
      y.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when put to cache");
      return;
    }
    if (mCache == null) {
      mCache = new HashMap();
    }
    mCache.put(paramString, parama);
  }
  
  public final int aNw()
  {
    if (this.mContext == null)
    {
      y.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
      return -1;
    }
    if (bk.bl(this.jJJ))
    {
      y.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
      return -1;
    }
    String str = ar.Zt(this.jJJ);
    if (bk.bl(str))
    {
      y.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
      return -1;
    }
    Object localObject = this.jJJ;
    if (bk.bl((String)localObject)) {
      y.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
    }
    for (localObject = null; localObject != null; localObject = (c.a)mCache.get(localObject))
    {
      y.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
      return a(((c.a)localObject).userName, ((c.a)localObject).jJM, ((c.a)localObject).jJN);
      if (mCache == null) {
        mCache = new HashMap();
      }
    }
    localObject = new hi();
    ((hi)localObject).bPj.bPl = str;
    com.tencent.mm.sdk.b.a.udP.m((b)localObject);
    localObject = ((hi)localObject).bPk.userName;
    if (!bk.bl((String)localObject))
    {
      y.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", new Object[] { localObject });
      return a((String)localObject, null, null);
    }
    y.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
    au.Dk().a(106, this.dmL);
    localObject = new com.tencent.mm.plugin.messenger.a.f(str, 3);
    au.Dk().a((com.tencent.mm.ah.m)localObject, 0);
    localObject = new Intent();
    ((Intent)localObject).setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
    ((Intent)localObject).setFlags(268435456);
    this.mContext.startActivity((Intent)localObject);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.c
 * JD-Core Version:    0.7.0.1
 */