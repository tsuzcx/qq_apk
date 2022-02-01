package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.k;
import d.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "", "()V", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "", "isDebug", "", "()Z", "get", "key", "remove", "", "set", "contact", "plugin-finder_release"})
public final class a
{
  private final boolean cuo;
  private final Map<String, f> qWq;
  
  public a()
  {
    AppMethodBeat.i(165128);
    this.qWq = Collections.synchronizedMap((Map)new HashMap());
    if ((h.DEBUG) || (h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE)) {}
    for (boolean bool = true;; bool = false)
    {
      this.cuo = bool;
      AppMethodBeat.o(165128);
      return;
    }
  }
  
  public final void a(String paramString, f paramf)
  {
    Boolean localBoolean = null;
    AppMethodBeat.i(165127);
    k.h(paramString, "key");
    k.h(paramf, "contact");
    if (adg(paramf.getUsername()) == null) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject1 = (f)this.qWq.get(paramString);
      Object localObject2;
      label91:
      Object localObject3;
      int i;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((f)localObject1).qWA);
        localObject2 = (f)this.qWq.get(paramString);
        if (localObject2 == null) {
          break label440;
        }
        localObject2 = ((f)localObject2).qWB;
        localObject3 = (f)this.qWq.get(paramString);
        if (localObject3 != null) {
          localBoolean = Boolean.valueOf(((f)localObject3).qWC);
        }
        if (!bool)
        {
          i = paramf.field_follow_Flag;
          if (localObject1 != null) {
            break label446;
          }
        }
        label136:
        StringBuilder localStringBuilder = new StringBuilder("contact is change new contact ").append(paramf.csa()).append(" oldFlag :").append(localObject1).append(" isFirstUpdate ").append(bool).append(' ');
        if (!this.cuo) {
          break label458;
        }
        localObject3 = bs.eWi().toString();
        label194:
        ac.i("Finder.Contact", (String)localObject3);
        label209:
        localObject3 = this.qWq;
        k.g(localObject3, "cacheItems");
        ((Map)localObject3).put(paramString, paramf);
        localObject3 = (f)this.qWq.get(paramString);
        if (localObject3 != null) {
          ((f)localObject3).qWA = paramf.field_follow_Flag;
        }
        localObject3 = (f)this.qWq.get(paramString);
        if (localObject3 != null) {
          ((f)localObject3).qWB = paramf.field_avatarUrl;
        }
        paramString = (f)this.qWq.get(paramString);
        if (paramString != null) {
          paramString.qWC = paramf.isNeedShowUnFollow;
        }
        i = paramf.field_follow_Flag;
        if (localObject1 != null) {
          break label465;
        }
      }
      for (;;)
      {
        label326:
        paramString = com.tencent.mm.sdk.b.a.GpY;
        localObject1 = new gw();
        ((gw)localObject1).dhR.username = paramf.getUsername();
        ((gw)localObject1).dhR.contact = paramf;
        paramString.l((b)localObject1);
        label440:
        label446:
        label458:
        label465:
        do
        {
          if ((k.g(localObject2, paramf.qWB) ^ true))
          {
            paramString = com.tencent.mm.sdk.b.a.GpY;
            localObject1 = new gw();
            ((gw)localObject1).dhR.username = paramf.getUsername();
            ((gw)localObject1).dhR.contact = paramf;
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
        } while (!(k.g(localBoolean, Boolean.valueOf(paramf.isNeedShowUnFollow)) ^ true));
      }
    }
  }
  
  public final f adg(String paramString)
  {
    AppMethodBeat.i(165126);
    k.h(paramString, "key");
    paramString = (f)this.qWq.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.csc();
      AppMethodBeat.o(165126);
      return paramString;
    }
    AppMethodBeat.o(165126);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.a
 * JD-Core Version:    0.7.0.1
 */