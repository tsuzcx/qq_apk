package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.p;
import d.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "", "()V", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "", "isDebug", "", "()Z", "get", "key", "remove", "", "set", "contact", "plugin-finder_release"})
public final class a
{
  private final boolean cFS;
  private final Map<String, g> rPw;
  
  public a()
  {
    AppMethodBeat.i(165128);
    this.rPw = Collections.synchronizedMap((Map)new HashMap());
    if ((j.DEBUG) || (j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE)) {}
    for (boolean bool = true;; bool = false)
    {
      this.cFS = bool;
      AppMethodBeat.o(165128);
      return;
    }
  }
  
  public final void a(String paramString, g paramg)
  {
    Boolean localBoolean = null;
    AppMethodBeat.i(165127);
    p.h(paramString, "key");
    p.h(paramg, "contact");
    if (ahS(paramg.getUsername()) == null) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject1 = (g)this.rPw.get(paramString);
      Object localObject2;
      label91:
      Object localObject3;
      int i;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((g)localObject1).rPG);
        localObject2 = (g)this.rPw.get(paramString);
        if (localObject2 == null) {
          break label440;
        }
        localObject2 = ((g)localObject2).rPH;
        localObject3 = (g)this.rPw.get(paramString);
        if (localObject3 != null) {
          localBoolean = Boolean.valueOf(((g)localObject3).rPI);
        }
        if (!bool)
        {
          i = paramg.field_follow_Flag;
          if (localObject1 != null) {
            break label446;
          }
        }
        label136:
        StringBuilder localStringBuilder = new StringBuilder("contact is change new contact ").append(paramg.czp()).append(" oldFlag :").append(localObject1).append(" isFirstUpdate ").append(bool).append(' ');
        if (!this.cFS) {
          break label458;
        }
        localObject3 = bu.fpN().toString();
        label194:
        ae.i("Finder.Contact", (String)localObject3);
        label209:
        localObject3 = this.rPw;
        p.g(localObject3, "cacheItems");
        ((Map)localObject3).put(paramString, paramg);
        localObject3 = (g)this.rPw.get(paramString);
        if (localObject3 != null) {
          ((g)localObject3).rPG = paramg.field_follow_Flag;
        }
        localObject3 = (g)this.rPw.get(paramString);
        if (localObject3 != null) {
          ((g)localObject3).rPH = paramg.field_avatarUrl;
        }
        paramString = (g)this.rPw.get(paramString);
        if (paramString != null) {
          paramString.rPI = paramg.isNeedShowUnFollow;
        }
        i = paramg.field_follow_Flag;
        if (localObject1 != null) {
          break label465;
        }
      }
      for (;;)
      {
        label326:
        paramString = com.tencent.mm.sdk.b.a.IvT;
        localObject1 = new hb();
        ((hb)localObject1).duy.username = paramg.getUsername();
        ((hb)localObject1).duy.contact = paramg;
        paramString.l((b)localObject1);
        label440:
        label446:
        label458:
        label465:
        do
        {
          if ((p.i(localObject2, paramg.rPH) ^ true))
          {
            paramString = com.tencent.mm.sdk.b.a.IvT;
            localObject1 = new hb();
            ((hb)localObject1).duy.username = paramg.getUsername();
            ((hb)localObject1).duy.contact = paramg;
            paramString.l((b)localObject1);
          }
          AppMethodBeat.o(165127);
          return;
          localObject1 = null;
          break;
          localObject2 = null;
          break label91;
          if (((Integer)localObject1).intValue() == i) {
            break label209;
          }
          break label136;
          localObject3 = "";
          break label194;
          if (((Integer)localObject1).intValue() != i) {
            break label326;
          }
        } while (!(p.i(localBoolean, Boolean.valueOf(paramg.isNeedShowUnFollow)) ^ true));
      }
    }
  }
  
  public final g ahS(String paramString)
  {
    AppMethodBeat.i(165126);
    p.h(paramString, "key");
    paramString = (g)this.rPw.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.czr();
      AppMethodBeat.o(165126);
      return paramString;
    }
    AppMethodBeat.o(165126);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.a
 * JD-Core Version:    0.7.0.1
 */