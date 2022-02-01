package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hx;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "", "()V", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "", "isDebug", "", "()Z", "get", "key", "remove", "", "set", "contact", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public final Map<String, m> AwX;
  private final boolean eYL;
  
  public b()
  {
    AppMethodBeat.i(165128);
    this.AwX = Collections.synchronizedMap((Map)new HashMap());
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {}
    for (boolean bool = true;; bool = false)
    {
      this.eYL = bool;
      AppMethodBeat.o(165128);
      return;
    }
  }
  
  public final void a(String paramString, m paramm)
  {
    Boolean localBoolean = null;
    AppMethodBeat.i(165127);
    s.u(paramString, "key");
    s.u(paramm, "contact");
    if (auR(paramm.getUsername()) == null) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject1 = (m)this.AwX.get(paramString);
      Object localObject2;
      label80:
      Object localObject3;
      label100:
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = (m)this.AwX.get(paramString);
        if (localObject2 != null) {
          break label400;
        }
        localObject2 = null;
        localObject3 = (m)this.AwX.get(paramString);
        if (localObject3 != null) {
          break label410;
        }
        if (!bool)
        {
          i = paramm.field_follow_Flag;
          if (localObject1 != null) {
            break label423;
          }
        }
        label115:
        StringBuilder localStringBuilder = new StringBuilder("contact is change new contact ").append(paramm.bRT()).append(" oldFlag :").append(localObject1).append(" isFirstUpdate ").append(bool).append(' ');
        if (!this.eYL) {
          break label435;
        }
        localObject3 = Util.getStack().toString();
        label173:
        Log.i("Finder.Contact", (String)localObject3);
        label188:
        localObject3 = this.AwX;
        s.s(localObject3, "cacheItems");
        ((Map)localObject3).put(paramString, paramm);
        localObject3 = (m)this.AwX.get(paramString);
        if (localObject3 != null) {
          ((m)localObject3).Axn = paramm.field_follow_Flag;
        }
        localObject3 = (m)this.AwX.get(paramString);
        if (localObject3 != null) {
          ((m)localObject3).Axo = paramm.field_avatarUrl;
        }
        paramString = (m)this.AwX.get(paramString);
        if (paramString != null) {
          paramString.Axp = paramm.isNeedShowUnFollow;
        }
        i = paramm.field_follow_Flag;
        if (localObject1 != null) {
          break label442;
        }
      }
      for (;;)
      {
        label305:
        paramString = new hx();
        paramString.hJn.username = paramm.getUsername();
        paramString.hJn.contact = paramm;
        paramString.publish();
        label400:
        label410:
        label423:
        label435:
        label442:
        do
        {
          if (!s.p(localObject2, paramm.Axo))
          {
            paramString = new hx();
            paramString.hJn.username = paramm.getUsername();
            paramString.hJn.contact = paramm;
            paramString.publish();
          }
          AppMethodBeat.o(165127);
          return;
          localObject1 = Integer.valueOf(((m)localObject1).Axn);
          break;
          localObject2 = ((m)localObject2).Axo;
          break label80;
          localBoolean = Boolean.valueOf(((m)localObject3).Axp);
          break label100;
          if (((Integer)localObject1).intValue() == i) {
            break label188;
          }
          break label115;
          localObject3 = "";
          break label173;
          if (((Integer)localObject1).intValue() != i) {
            break label305;
          }
        } while (s.p(localBoolean, Boolean.valueOf(paramm.isNeedShowUnFollow)));
      }
    }
  }
  
  public final m auR(String paramString)
  {
    AppMethodBeat.i(165126);
    s.u(paramString, "key");
    paramString = (m)this.AwX.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(165126);
      return null;
    }
    paramString = paramString.dUE();
    AppMethodBeat.o(165126);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.b
 * JD-Core Version:    0.7.0.1
 */