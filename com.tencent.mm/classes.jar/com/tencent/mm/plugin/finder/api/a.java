package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "", "()V", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "", "isDebug", "", "()Z", "get", "key", "remove", "", "set", "contact", "plugin-finder_release"})
public final class a
{
  private final boolean cWq;
  public final Map<String, g> tsn;
  
  public a()
  {
    AppMethodBeat.i(165128);
    this.tsn = Collections.synchronizedMap((Map)new HashMap());
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {}
    for (boolean bool = true;; bool = false)
    {
      this.cWq = bool;
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
    if (asE(paramg.getUsername()) == null) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject1 = (g)this.tsn.get(paramString);
      Object localObject2;
      label91:
      Object localObject3;
      int i;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((g)localObject1).tsx);
        localObject2 = (g)this.tsn.get(paramString);
        if (localObject2 == null) {
          break label440;
        }
        localObject2 = ((g)localObject2).tsy;
        localObject3 = (g)this.tsn.get(paramString);
        if (localObject3 != null) {
          localBoolean = Boolean.valueOf(((g)localObject3).tsz);
        }
        if (!bool)
        {
          i = paramg.field_follow_Flag;
          if (localObject1 != null) {
            break label446;
          }
        }
        label136:
        StringBuilder localStringBuilder = new StringBuilder("contact is change new contact ").append(paramg.cXK()).append(" oldFlag :").append(localObject1).append(" isFirstUpdate ").append(bool).append(' ');
        if (!this.cWq) {
          break label458;
        }
        localObject3 = Util.getStack().toString();
        label194:
        Log.i("Finder.Contact", (String)localObject3);
        label209:
        localObject3 = this.tsn;
        p.g(localObject3, "cacheItems");
        ((Map)localObject3).put(paramString, paramg);
        localObject3 = (g)this.tsn.get(paramString);
        if (localObject3 != null) {
          ((g)localObject3).tsx = paramg.field_follow_Flag;
        }
        localObject3 = (g)this.tsn.get(paramString);
        if (localObject3 != null) {
          ((g)localObject3).tsy = paramg.field_avatarUrl;
        }
        paramString = (g)this.tsn.get(paramString);
        if (paramString != null) {
          paramString.tsz = paramg.isNeedShowUnFollow;
        }
        i = paramg.field_follow_Flag;
        if (localObject1 != null) {
          break label465;
        }
      }
      for (;;)
      {
        label326:
        paramString = EventCenter.instance;
        localObject1 = new hf();
        ((hf)localObject1).dLI.username = paramg.getUsername();
        ((hf)localObject1).dLI.contact = paramg;
        paramString.publish((IEvent)localObject1);
        label440:
        label446:
        label458:
        label465:
        do
        {
          if ((p.j(localObject2, paramg.tsy) ^ true))
          {
            paramString = EventCenter.instance;
            localObject1 = new hf();
            ((hf)localObject1).dLI.username = paramg.getUsername();
            ((hf)localObject1).dLI.contact = paramg;
            paramString.publish((IEvent)localObject1);
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
        } while (!(p.j(localBoolean, Boolean.valueOf(paramg.isNeedShowUnFollow)) ^ true));
      }
    }
  }
  
  public final g asE(String paramString)
  {
    AppMethodBeat.i(165126);
    p.h(paramString, "key");
    paramString = (g)this.tsn.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.cXM();
      AppMethodBeat.o(165126);
      return paramString;
    }
    AppMethodBeat.o(165126);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.a
 * JD-Core Version:    0.7.0.1
 */