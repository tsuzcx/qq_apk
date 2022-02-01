package com.tencent.mm.plugin.biz;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.ad;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.m;
import com.tencent.mm.api.n;
import com.tencent.mm.api.o;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.i;
import com.tencent.mm.model.r;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.t;
import com.tencent.mm.storagebase.h.b;
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
    if (paramg.aBb())
    {
      com.tencent.mm.kernel.g.a(com.tencent.mm.al.q.class, new e(new m()));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.biz.a.a.class, new a());
      paramg = com.tencent.mm.msgsubscription.api.b.jza;
      com.tencent.mm.msgsubscription.api.b.a("name_biz", new com.tencent.mm.msgsubscription.b.a(com.tencent.mm.msgsubscription.d.c.jAF)
      {
        public final void a(Context paramAnonymousContext, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(212210);
          Intent localIntent = new Intent(paramAnonymousContext, BizSubscribeMsgManagerUI.class);
          localIntent.putExtra("key_biz_username", paramAnonymousString1);
          localIntent.putExtra("key_biz_nickname", paramAnonymousString2);
          localIntent.putExtra("key_biz_presenter_class", com.tencent.mm.al.b.a.class.getName());
          localIntent.putExtra("key_need_update", true);
          localIntent.putExtra("key_need_load_from_remote", true);
          localIntent.putExtra("key_enter_scene", paramAnonymousInt);
          com.tencent.mm.br.c.f(paramAnonymousContext, "com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI", localIntent);
          AppMethodBeat.o(212210);
        }
      });
      com.tencent.mm.vfs.y.a("bizimg/", "bizimg/", 536870912L, 75);
      Log.i("VFS.Debug", "bizimg FS registered");
      com.tencent.mm.vfs.y.b("brandicon/", "brandicon/", 7776000000L, 3);
      com.tencent.mm.vfs.y.b("bizcache/", "bizcache/", 2592000000L, 67);
      com.tencent.mm.vfs.y.b("webcanvascache/", "webcanvascache/", 2592000000L, 67);
      com.tencent.mm.vfs.y.at("openapi/", "openapi/", 3);
      com.tencent.mm.vfs.y.b("openapi_cache/", "openapi_cache/", 7776000000L, 67);
      EventCenter.instance.add(new ad());
    }
    com.tencent.mm.pluginsdk.ui.applet.x.a.Kge = new d();
    AppMethodBeat.o(124340);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(124339);
    dependsOn(s.class);
    dependsOn(com.tencent.mm.plugin.teenmode.a.a.class);
    AppMethodBeat.o(124339);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(124341);
    if (paramg.aBb())
    {
      pin(new com.tencent.mm.model.y(ag.class));
      com.tencent.mm.kernel.g.b(com.tencent.mm.api.k.class, new com.tencent.mm.model.g());
      com.tencent.mm.kernel.g.b(com.tencent.mm.api.l.class, new i());
      com.tencent.mm.kernel.g.b(n.class, new com.tencent.mm.model.k());
      com.tencent.mm.kernel.g.a(o.class, new e(new com.tencent.mm.model.l()));
      com.tencent.mm.kernel.g.b(com.tencent.mm.api.q.class, com.tencent.mm.model.q.iCq);
    }
    if ((paramg.FY(":tools")) || (paramg.FY(":toolsmp")) || (paramg.FZ(":appbrand"))) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.api.q.class, new r());
    }
    if ((paramg.FY(":tools")) || (paramg.FY(":toolsmp"))) {
      com.tencent.mm.kernel.g.b(ISubscribeMsgService.class, new com.tencent.mm.msgsubscription.b.a.b());
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
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(212211);
    paramc = com.tencent.mm.model.q.iCq;
    com.tencent.mm.model.q.init();
    AppMethodBeat.o(212211);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(212212);
    com.tencent.mm.model.q localq = com.tencent.mm.model.q.iCq;
    com.tencent.mm.model.q.release();
    AppMethodBeat.o(212212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.biz.PluginBiz
 * JD-Core Version:    0.7.0.1
 */