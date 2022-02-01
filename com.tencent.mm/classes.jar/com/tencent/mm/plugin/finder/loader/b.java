package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.plugin.i.a.p;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.j.b;
import com.tencent.mm.pluginsdk.ui.j.c;
import com.tencent.mm.storage.an;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements j.a, j.b
{
  final List<WeakReference<e.a>> sro;
  private final j.a srp;
  
  public b(j.a parama)
  {
    AppMethodBeat.i(201323);
    this.sro = new ArrayList();
    this.srp = parama;
    AppMethodBeat.o(201323);
  }
  
  private static Pair<String, Boolean> air(String paramString)
  {
    AppMethodBeat.i(201325);
    if (an.aUu(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(201325);
      return paramString;
    }
    if (an.aUt(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(201325);
      return paramString;
    }
    paramString = ((p)g.ab(p.class)).ajf(paramString);
    if ((an.aUu(paramString)) || (an.aUt(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      paramString = new Pair(paramString, Boolean.valueOf(bool));
      AppMethodBeat.o(201325);
      return paramString;
    }
  }
  
  public final Bitmap LT()
  {
    AppMethodBeat.i(201328);
    Bitmap localBitmap = this.srp.LT();
    AppMethodBeat.o(201328);
    return localBitmap;
  }
  
  public final Bitmap a(final String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(201324);
    Object localObject1 = air(paramString);
    Object localObject3 = (String)((Pair)localObject1).first;
    if (((Boolean)((Pair)localObject1).second).booleanValue())
    {
      Object localObject2;
      if (an.aUu((String)localObject3))
      {
        localObject1 = ((f)g.ab(f.class)).aiX((String)localObject3);
        if (localObject1 == null) {
          break label234;
        }
        localObject2 = ((r)localObject1).czm();
        boolean bool = an.aUu((String)localObject3);
        localObject1 = i.srW;
        if (!bool) {
          break label193;
        }
        localObject1 = i.a.srZ;
        label96:
        localObject3 = i.a((i.a)localObject1);
        if (!bool) {
          break label201;
        }
        localObject1 = i.srW;
      }
      for (localObject1 = i.cEo();; localObject1 = i.cEp())
      {
        localObject1 = ((d)localObject1).bI(new a((String)localObject2));
        ((com.tencent.mm.loader.a.b)localObject1).a((com.tencent.mm.loader.c.e)localObject3);
        localObject2 = (Bitmap)((com.tencent.mm.loader.a.b)localObject1).aqY();
        if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
          break label214;
        }
        AppMethodBeat.o(201324);
        return localObject2;
        localObject1 = ((f)g.ab(f.class)).aiY((String)localObject3);
        break;
        label193:
        localObject1 = i.a.ssb;
        break label96;
        label201:
        localObject1 = i.srW;
      }
      label214:
      ((com.tencent.mm.loader.a.b)localObject1).a(new com.tencent.mm.loader.f.e() {});
      ((com.tencent.mm.loader.a.b)localObject1).aqX();
      label234:
      AppMethodBeat.o(201324);
      return null;
    }
    paramString = this.srp.a((String)localObject3, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(201324);
    return paramString;
  }
  
  public final void a(final j paramj)
  {
    AppMethodBeat.i(201329);
    if ((paramj instanceof e.a))
    {
      Object localObject = air(paramj.getTag());
      boolean bool = ((Boolean)((Pair)localObject).second).booleanValue();
      localObject = (String)((Pair)localObject).first;
      if (bool)
      {
        paramj = (e.a)paramj;
        this.sro.add(new WeakReference(paramj));
        AppMethodBeat.o(201329);
        return;
      }
      paramj.Fls = new j.c()
      {
        public final boolean ait(String paramAnonymousString)
        {
          AppMethodBeat.i(201322);
          if (this.ggQ.equals(paramAnonymousString))
          {
            paramj.ffy();
            paramj.Fls = null;
          }
          AppMethodBeat.o(201322);
          return true;
        }
      };
      this.srp.a(paramj);
    }
    AppMethodBeat.o(201329);
  }
  
  public final boolean ais(String paramString)
  {
    AppMethodBeat.i(201330);
    if (!an.aUu(((p)g.ab(p.class)).ajf(paramString)))
    {
      AppMethodBeat.o(201330);
      return true;
    }
    AppMethodBeat.o(201330);
    return false;
  }
  
  public final Bitmap fl(String paramString)
  {
    AppMethodBeat.i(201326);
    Pair localPair = air(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = a(paramString, 0, 0, 0);
      AppMethodBeat.o(201326);
      return paramString;
    }
    paramString = this.srp.fl((String)localPair.first);
    AppMethodBeat.o(201326);
    return paramString;
  }
  
  public final Bitmap fm(String paramString)
  {
    AppMethodBeat.i(201327);
    Pair localPair = air(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = a(paramString, 0, 0, 0);
      AppMethodBeat.o(201327);
      return paramString;
    }
    paramString = this.srp.fm((String)localPair.first);
    AppMethodBeat.o(201327);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.b
 * JD-Core Version:    0.7.0.1
 */