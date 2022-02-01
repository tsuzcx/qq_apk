package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hm;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "", "()V", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "", "isDebug", "", "()Z", "get", "key", "remove", "", "set", "contact", "finder-sdk_release"})
public final class b
{
  private final boolean dal;
  public final Map<String, i> wZM;
  
  public b()
  {
    AppMethodBeat.i(165128);
    this.wZM = Collections.synchronizedMap((Map)new HashMap());
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {}
    for (boolean bool = true;; bool = false)
    {
      this.dal = bool;
      AppMethodBeat.o(165128);
      return;
    }
  }
  
  public final void a(String paramString, i parami)
  {
    Boolean localBoolean = null;
    AppMethodBeat.i(165127);
    p.k(paramString, "key");
    p.k(parami, "contact");
    if (aAI(parami.getUsername()) == null) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject1 = (i)this.wZM.get(paramString);
      Object localObject2;
      label91:
      Object localObject3;
      int i;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((i)localObject1).xac);
        localObject2 = (i)this.wZM.get(paramString);
        if (localObject2 == null) {
          break label440;
        }
        localObject2 = ((i)localObject2).xad;
        localObject3 = (i)this.wZM.get(paramString);
        if (localObject3 != null) {
          localBoolean = Boolean.valueOf(((i)localObject3).xae);
        }
        if (!bool)
        {
          i = parami.field_follow_Flag;
          if (localObject1 != null) {
            break label446;
          }
        }
        label136:
        StringBuilder localStringBuilder = new StringBuilder("contact is change new contact ").append(parami.dnp()).append(" oldFlag :").append(localObject1).append(" isFirstUpdate ").append(bool).append(' ');
        if (!this.dal) {
          break label458;
        }
        localObject3 = Util.getStack().toString();
        label194:
        Log.i("Finder.Contact", (String)localObject3);
        label209:
        localObject3 = this.wZM;
        p.j(localObject3, "cacheItems");
        ((Map)localObject3).put(paramString, parami);
        localObject3 = (i)this.wZM.get(paramString);
        if (localObject3 != null) {
          ((i)localObject3).xac = parami.field_follow_Flag;
        }
        localObject3 = (i)this.wZM.get(paramString);
        if (localObject3 != null) {
          ((i)localObject3).xad = parami.field_avatarUrl;
        }
        paramString = (i)this.wZM.get(paramString);
        if (paramString != null) {
          paramString.xae = parami.isNeedShowUnFollow;
        }
        i = parami.field_follow_Flag;
        if (localObject1 != null) {
          break label465;
        }
      }
      for (;;)
      {
        label326:
        paramString = EventCenter.instance;
        localObject1 = new hm();
        ((hm)localObject1).fEx.username = parami.getUsername();
        ((hm)localObject1).fEx.contact = parami;
        paramString.publish((IEvent)localObject1);
        label440:
        label446:
        label458:
        label465:
        do
        {
          if ((p.h(localObject2, parami.xad) ^ true))
          {
            paramString = EventCenter.instance;
            localObject1 = new hm();
            ((hm)localObject1).fEx.username = parami.getUsername();
            ((hm)localObject1).fEx.contact = parami;
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
        } while (!(p.h(localBoolean, Boolean.valueOf(parami.isNeedShowUnFollow)) ^ true));
      }
    }
  }
  
  public final i aAI(String paramString)
  {
    AppMethodBeat.i(165126);
    p.k(paramString, "key");
    paramString = (i)this.wZM.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.dnw();
      AppMethodBeat.o(165126);
      return paramString;
    }
    AppMethodBeat.o(165126);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.b
 * JD-Core Version:    0.7.0.1
 */