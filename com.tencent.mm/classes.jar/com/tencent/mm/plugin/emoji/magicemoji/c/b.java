package com.tencent.mm.plugin.emoji.magicemoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.mm.plugin.appbrand.jsapi.file.aa;
import com.tencent.mm.plugin.appbrand.jsapi.file.ab;
import com.tencent.mm.plugin.appbrand.jsapi.file.ag;
import com.tencent.mm.plugin.appbrand.jsapi.file.ah;
import com.tencent.mm.plugin.appbrand.jsapi.file.ai;
import com.tencent.mm.plugin.appbrand.jsapi.file.aj;
import com.tencent.mm.plugin.appbrand.jsapi.file.al;
import com.tencent.mm.plugin.appbrand.jsapi.file.am;
import com.tencent.mm.plugin.appbrand.jsapi.file.an;
import com.tencent.mm.plugin.appbrand.jsapi.file.ao;
import com.tencent.mm.plugin.appbrand.jsapi.file.ap;
import com.tencent.mm.plugin.appbrand.jsapi.file.aq;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.jsapi.file.as;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.jsapi.file.au;
import com.tencent.mm.plugin.appbrand.jsapi.file.av;
import com.tencent.mm.plugin.appbrand.jsapi.file.aw;
import com.tencent.mm.plugin.appbrand.jsapi.file.m;
import com.tencent.mm.plugin.appbrand.jsapi.file.n;
import com.tencent.mm.plugin.appbrand.jsapi.file.o;
import com.tencent.mm.plugin.appbrand.jsapi.file.q;
import com.tencent.mm.plugin.appbrand.jsapi.file.r;
import com.tencent.mm.plugin.appbrand.jsapi.file.t;
import com.tencent.mm.plugin.appbrand.jsapi.file.u;
import com.tencent.mm.plugin.emoji.magicemoji.c.a.a;
import com.tencent.mm.plugin.emoji.magicemoji.c.a.d;
import com.tencent.mm.plugin.emoji.magicemoji.c.a.e;
import com.tencent.mm.plugin.emoji.magicemoji.c.a.g;
import com.tencent.mm.plugin.emoji.magicemoji.c.a.h;
import com.tencent.mm.plugin.emoji.magicemoji.c.a.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/MagicEmojiJsApiPool;", "", "()V", "TAG", "", "chattingJsApiMap", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "createJsApiPool", "mAppId", "printEntry", "", "entry", "", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b xJb;
  private static final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> xJc;
  
  static
  {
    AppMethodBeat.i(270216);
    xJb = new b();
    Object localObject = (Iterable)kotlin.a.p.listOf(new com.tencent.mm.plugin.appbrand.jsapi.p[] { (com.tencent.mm.plugin.appbrand.jsapi.p)new aq(), (com.tencent.mm.plugin.appbrand.jsapi.p)new ar(), (com.tencent.mm.plugin.appbrand.jsapi.p)new r(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.appbrand.jsapi.file.s(), (com.tencent.mm.plugin.appbrand.jsapi.p)new t(), (com.tencent.mm.plugin.appbrand.jsapi.p)new al(), (com.tencent.mm.plugin.appbrand.jsapi.p)new aj(), (com.tencent.mm.plugin.appbrand.jsapi.p)new aw(), (com.tencent.mm.plugin.appbrand.jsapi.p)new ab(), (com.tencent.mm.plugin.appbrand.jsapi.p)new ah(), (com.tencent.mm.plugin.appbrand.jsapi.p)new ap(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.appbrand.jsapi.file.k(), (com.tencent.mm.plugin.appbrand.jsapi.p)new at(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.appbrand.jsapi.file.v(), (com.tencent.mm.plugin.appbrand.jsapi.p)new q(), (com.tencent.mm.plugin.appbrand.jsapi.p)new ai(), (com.tencent.mm.plugin.appbrand.jsapi.p)new av(), (com.tencent.mm.plugin.appbrand.jsapi.p)new aa(), (com.tencent.mm.plugin.appbrand.jsapi.p)new ag(), (com.tencent.mm.plugin.appbrand.jsapi.p)new ao(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.appbrand.jsapi.file.j(), (com.tencent.mm.plugin.appbrand.jsapi.p)new as(), (com.tencent.mm.plugin.appbrand.jsapi.p)new u(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.appbrand.jsapi.file.p(), (com.tencent.mm.plugin.appbrand.jsapi.p)new au(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.appbrand.jsapi.file.ak(), (com.tencent.mm.plugin.appbrand.jsapi.p)new n(), (com.tencent.mm.plugin.appbrand.jsapi.p)new o(), (com.tencent.mm.plugin.appbrand.jsapi.p)new am(), (com.tencent.mm.plugin.appbrand.jsapi.p)new an(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.appbrand.jsapi.file.l(), (com.tencent.mm.plugin.appbrand.jsapi.p)new m(), (com.tencent.mm.plugin.appbrand.jsapi.p)new e(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.emoji.magicemoji.c.a.f(), (com.tencent.mm.plugin.appbrand.jsapi.p)new JsApiGetABTestConfig(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.emoji.magicemoji.c.a.c(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.appbrand.jsapi.aa.f(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.emoji.magicemoji.c.a.l(), (com.tencent.mm.plugin.appbrand.jsapi.p)new a(), (com.tencent.mm.plugin.appbrand.jsapi.p)new d(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.emoji.magicemoji.c.a.j(), (com.tencent.mm.plugin.appbrand.jsapi.p)new g(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.emoji.magicemoji.c.a.k(), (com.tencent.mm.plugin.appbrand.jsapi.p)new i(), (com.tencent.mm.plugin.appbrand.jsapi.p)new h() });
    Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.appbrand.jsapi.p localp = (com.tencent.mm.plugin.appbrand.jsapi.p)((Iterator)localObject).next();
      localCollection.add(kotlin.v.Y(localp.getName(), localp));
    }
    xJc = kotlin.a.ak.F((Iterable)localCollection);
    AppMethodBeat.o(270216);
  }
  
  public static Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> anV(String paramString)
  {
    AppMethodBeat.i(270195);
    kotlin.g.b.s.u(paramString, "mAppId");
    com.tencent.mm.ipcinvoker.h.c.d("MicroMsg.MagicEmojiJsApiPool", kotlin.g.b.s.X("stevecai: createJsApiPool() called with: mAppId = ", paramString), new Object[0]);
    paramString = xJc.entrySet().iterator();
    while (paramString.hasNext()) {
      com.tencent.mm.ipcinvoker.h.c.d("MicroMsg.MagicEmojiJsApiPool", kotlin.g.b.s.X("magic emoji js api entry: ", ((Map.Entry)paramString.next()).getKey()), new Object[0]);
    }
    paramString = xJc;
    AppMethodBeat.o(270195);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.c.b
 * JD-Core Version:    0.7.0.1
 */