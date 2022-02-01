package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.findersdk.a.ab;
import com.tencent.mm.plugin.findersdk.a.ai;
import com.tencent.mm.plugin.findersdk.a.m;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.j.b;
import com.tencent.mm.pluginsdk.ui.j.c;
import com.tencent.mm.storage.as;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class g
  implements j.a, j.b
{
  final List<WeakReference<f.a>> ztn;
  private final j.a zto;
  
  public g(j.a parama)
  {
    AppMethodBeat.i(222876);
    this.ztn = new ArrayList();
    this.zto = parama;
    AppMethodBeat.o(222876);
  }
  
  private static Pair<String, Boolean> aDm(String paramString)
  {
    AppMethodBeat.i(222889);
    if (as.bvP(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(222889);
      return paramString;
    }
    if (as.bvN(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(222889);
      return paramString;
    }
    if (as.bvO(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(222889);
      return paramString;
    }
    paramString = ((ab)h.ae(ab.class)).aED(paramString);
    if ((as.bvP(paramString)) || (as.bvN(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      paramString = new Pair(paramString, Boolean.valueOf(bool));
      AppMethodBeat.o(222889);
      return paramString;
    }
  }
  
  public final void a(final j paramj)
  {
    AppMethodBeat.i(222900);
    if ((paramj instanceof f.a))
    {
      Object localObject = aDm(paramj.getTag());
      boolean bool = ((Boolean)((Pair)localObject).second).booleanValue();
      localObject = (String)((Pair)localObject).first;
      if (bool)
      {
        paramj = (f.a)paramj;
        this.ztn.add(new WeakReference(paramj));
        AppMethodBeat.o(222900);
        return;
      }
      paramj.RcQ = new j.c()
      {
        public final boolean aDo(String paramAnonymousString)
        {
          AppMethodBeat.i(288172);
          if (this.jwL.equals(paramAnonymousString))
          {
            paramj.hjt();
            paramj.RcQ = null;
          }
          AppMethodBeat.o(288172);
          return true;
        }
      };
      this.zto.a(paramj);
    }
    AppMethodBeat.o(222900);
  }
  
  public final boolean aDn(String paramString)
  {
    AppMethodBeat.i(222903);
    if (!as.bvP(((ab)h.ae(ab.class)).aED(paramString)))
    {
      AppMethodBeat.o(222903);
      return true;
    }
    AppMethodBeat.o(222903);
    return false;
  }
  
  public final Bitmap aaC()
  {
    AppMethodBeat.i(222894);
    Bitmap localBitmap = this.zto.aaC();
    AppMethodBeat.o(222894);
    return localBitmap;
  }
  
  public final Bitmap b(final String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(222885);
    Object localObject1 = aDm(paramString);
    Object localObject3 = (String)((Pair)localObject1).first;
    if (((Boolean)((Pair)localObject1).second).booleanValue())
    {
      Object localObject2;
      if (as.bvP((String)localObject3))
      {
        localObject1 = ((m)h.ae(m.class)).aEs((String)localObject3);
        if (localObject1 == null) {
          break label265;
        }
        localObject2 = ((ai)localObject1).Mm();
        boolean bool = as.bvP((String)localObject3);
        localObject1 = t.ztT;
        if (!bool) {
          break label224;
        }
        localObject1 = t.a.ztX;
        label96:
        localObject3 = t.a((t.a)localObject1);
        if (!bool) {
          break label232;
        }
        localObject1 = t.ztT;
      }
      for (localObject1 = t.dJh();; localObject1 = t.dJi())
      {
        localObject1 = ((d)localObject1).bQ(new e((String)localObject2, u.AlP));
        ((b)localObject1).a((com.tencent.mm.loader.c.e)localObject3);
        localObject2 = (Bitmap)((b)localObject1).aRw();
        if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
          break label245;
        }
        AppMethodBeat.o(222885);
        return localObject2;
        if (as.bvO((String)localObject3))
        {
          localObject1 = ((m)h.ae(m.class)).aEu((String)localObject3);
          break;
        }
        localObject1 = ((m)h.ae(m.class)).aEt((String)localObject3);
        break;
        label224:
        localObject1 = t.a.ztZ;
        break label96;
        label232:
        localObject1 = t.ztT;
      }
      label245:
      ((b)localObject1).a(new com.tencent.mm.loader.f.e() {});
      ((b)localObject1).aRr();
      label265:
      AppMethodBeat.o(222885);
      return null;
    }
    paramString = this.zto.b((String)localObject3, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(222885);
    return paramString;
  }
  
  public final Bitmap gJ(String paramString)
  {
    AppMethodBeat.i(222891);
    Pair localPair = aDm(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = b(paramString, 0, 0, 0);
      AppMethodBeat.o(222891);
      return paramString;
    }
    paramString = this.zto.gJ((String)localPair.first);
    AppMethodBeat.o(222891);
    return paramString;
  }
  
  public final Bitmap gK(String paramString)
  {
    AppMethodBeat.i(222893);
    Pair localPair = aDm(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = b(paramString, 0, 0, 0);
      AppMethodBeat.o(222893);
      return paramString;
    }
    paramString = this.zto.gK((String)localPair.first);
    AppMethodBeat.o(222893);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.g
 * JD-Core Version:    0.7.0.1
 */