package com.tencent.mm.plugin.biz;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.ad;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.m;
import com.tencent.mm.api.n;
import com.tencent.mm.api.o;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.i;
import com.tencent.mm.model.y;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.t;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.ab;
import java.util.HashMap;

public class PluginBiz
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.biz.a.b
{
  public static long startTime = 0L;
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(124342);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("BIZ_MESSAGE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return t.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("BIZ_TIME_LINE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return aa.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("BIZ_TIME_LINE_SINGLE_MSG_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ae.SQL_CREATE;
      }
    });
    AppMethodBeat.o(124342);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(124340);
    if (paramg.aIE())
    {
      h.a(com.tencent.mm.ao.q.class, new e(new m()));
      h.b(com.tencent.mm.plugin.biz.a.a.class, new a());
      paramg = com.tencent.mm.msgsubscription.api.b.moG;
      com.tencent.mm.msgsubscription.api.b.a("name_biz", new com.tencent.mm.msgsubscription.b.a(com.tencent.mm.msgsubscription.d.c.mqn)
      {
        public final void a(Context paramAnonymousContext, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(206553);
          Intent localIntent = new Intent(paramAnonymousContext, BizSubscribeMsgManagerUI.class);
          localIntent.putExtra("key_biz_username", paramAnonymousString1);
          localIntent.putExtra("key_biz_nickname", paramAnonymousString2);
          localIntent.putExtra("key_biz_presenter_class", com.tencent.mm.ao.b.a.class.getName());
          localIntent.putExtra("key_need_update", true);
          localIntent.putExtra("key_need_load_from_remote", true);
          localIntent.putExtra("key_enter_scene", paramAnonymousInt);
          com.tencent.mm.by.c.f(paramAnonymousContext, "com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI", localIntent);
          AppMethodBeat.o(206553);
        }
      });
      ab.a("bizimg/", "bizimg/", 536870912L, 604800000L, 73);
      Log.i("VFS.Debug", "bizimg FS registered");
      ab.a("brandicon/", "brandicon/", 7776000000L, 1);
      ab.a("bizcache/", "bizcache/", 2592000000L, 65);
      ab.a("webcanvascache/", "webcanvascache/", 2592000000L, 65);
      ab.aE("openapi/", "openapi/", 1);
      ab.a("openapi_cache/", "openapi_cache/", 7776000000L, 65);
      ab.a("share_img_tmp/", "share_img_tmp/", 86400000L, 65);
      EventCenter.instance.add(new ad());
    }
    com.tencent.mm.pluginsdk.ui.applet.x.a.RgS = new d();
    AppMethodBeat.o(124340);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(124339);
    dependsOn(v.class);
    dependsOn(com.tencent.mm.plugin.teenmode.a.a.class);
    AppMethodBeat.o(124339);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(124341);
    if (paramg.aIE())
    {
      pin(new y(af.class));
      h.b(com.tencent.mm.api.k.class, new com.tencent.mm.model.g());
      h.b(com.tencent.mm.api.l.class, new i());
      h.b(n.class, new com.tencent.mm.model.k());
      h.a(o.class, new e(new com.tencent.mm.model.l()));
    }
    if ((!paramg.MY(":tools")) && (!paramg.MY(":toolsmp"))) {
      paramg.MZ(":appbrand");
    }
    if ((paramg.MY(":tools")) || (paramg.MY(":toolsmp"))) {
      h.b(ISubscribeMsgService.class, new com.tencent.mm.msgsubscription.b.a.b());
    }
    startTime = System.currentTimeMillis();
    AppMethodBeat.o(124341);
  }
  
  public void installed()
  {
    AppMethodBeat.i(124338);
    alias(com.tencent.mm.plugin.biz.a.b.class);
    AppMethodBeat.o(124338);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(208782);
    paramc = com.tencent.mm.model.q.lsl;
    com.tencent.mm.model.q.init();
    AppMethodBeat.o(208782);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(208784);
    com.tencent.mm.model.q localq = com.tencent.mm.model.q.lsl;
    com.tencent.mm.model.q.release();
    AppMethodBeat.o(208784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.biz.PluginBiz
 * JD-Core Version:    0.7.0.1
 */