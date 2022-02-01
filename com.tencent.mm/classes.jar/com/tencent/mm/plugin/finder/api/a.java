package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import d.g.b.p;
import d.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "", "()V", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "", "isDebug", "", "()Z", "get", "key", "remove", "", "set", "contact", "plugin-finder_release"})
public final class a
{
  private final boolean cFj;
  private final Map<String, g> rHl;
  
  public a()
  {
    AppMethodBeat.i(165128);
    this.rHl = Collections.synchronizedMap((Map)new HashMap());
    if ((i.DEBUG) || (i.IS_FLAVOR_RED) || (i.IS_FLAVOR_PURPLE)) {}
    for (boolean bool = true;; bool = false)
    {
      this.cFj = bool;
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
    if (agV(paramg.getUsername()) == null) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject1 = (g)this.rHl.get(paramString);
      Object localObject2;
      label91:
      Object localObject3;
      int i;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((g)localObject1).rHv);
        localObject2 = (g)this.rHl.get(paramString);
        if (localObject2 == null) {
          break label440;
        }
        localObject2 = ((g)localObject2).rHw;
        localObject3 = (g)this.rHl.get(paramString);
        if (localObject3 != null) {
          localBoolean = Boolean.valueOf(((g)localObject3).rHx);
        }
        if (!bool)
        {
          i = paramg.field_follow_Flag;
          if (localObject1 != null) {
            break label446;
          }
        }
        label136:
        StringBuilder localStringBuilder = new StringBuilder("contact is change new contact ").append(paramg.cxO()).append(" oldFlag :").append(localObject1).append(" isFirstUpdate ").append(bool).append(' ');
        if (!this.cFj) {
          break label458;
        }
        localObject3 = bt.flS().toString();
        label194:
        ad.i("Finder.Contact", (String)localObject3);
        label209:
        localObject3 = this.rHl;
        p.g(localObject3, "cacheItems");
        ((Map)localObject3).put(paramString, paramg);
        localObject3 = (g)this.rHl.get(paramString);
        if (localObject3 != null) {
          ((g)localObject3).rHv = paramg.field_follow_Flag;
        }
        localObject3 = (g)this.rHl.get(paramString);
        if (localObject3 != null) {
          ((g)localObject3).rHw = paramg.field_avatarUrl;
        }
        paramString = (g)this.rHl.get(paramString);
        if (paramString != null) {
          paramString.rHx = paramg.isNeedShowUnFollow;
        }
        i = paramg.field_follow_Flag;
        if (localObject1 != null) {
          break label465;
        }
      }
      for (;;)
      {
        label326:
        paramString = com.tencent.mm.sdk.b.a.IbL;
        localObject1 = new ha();
        ((ha)localObject1).dtt.username = paramg.getUsername();
        ((ha)localObject1).dtt.contact = paramg;
        paramString.l((b)localObject1);
        label440:
        label446:
        label458:
        label465:
        do
        {
          if ((p.i(localObject2, paramg.rHw) ^ true))
          {
            paramString = com.tencent.mm.sdk.b.a.IbL;
            localObject1 = new ha();
            ((ha)localObject1).dtt.username = paramg.getUsername();
            ((ha)localObject1).dtt.contact = paramg;
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
  
  public final g agV(String paramString)
  {
    AppMethodBeat.i(165126);
    p.h(paramString, "key");
    paramString = (g)this.rHl.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.cxQ();
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