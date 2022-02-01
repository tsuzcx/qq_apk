package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.plugin.i.a.p;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.j.b;
import com.tencent.mm.pluginsdk.ui.j.c;
import com.tencent.mm.storage.am;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements j.a, j.b
{
  final List<WeakReference<e.a>> sit;
  private final j.a siu;
  
  public b(j.a parama)
  {
    AppMethodBeat.i(200902);
    this.sit = new ArrayList();
    this.siu = parama;
    AppMethodBeat.o(200902);
  }
  
  private static Pair<String, Boolean> ahu(String paramString)
  {
    AppMethodBeat.i(200904);
    if (am.aSU(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(200904);
      return paramString;
    }
    if (am.aST(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(200904);
      return paramString;
    }
    paramString = ((p)g.ab(p.class)).aii(paramString);
    if ((am.aSU(paramString)) || (am.aST(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      paramString = new Pair(paramString, Boolean.valueOf(bool));
      AppMethodBeat.o(200904);
      return paramString;
    }
  }
  
  public final Bitmap LL()
  {
    AppMethodBeat.i(200907);
    Bitmap localBitmap = this.siu.LL();
    AppMethodBeat.o(200907);
    return localBitmap;
  }
  
  public final Bitmap a(final String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(200903);
    Object localObject1 = ahu(paramString);
    Object localObject3 = (String)((Pair)localObject1).first;
    if (((Boolean)((Pair)localObject1).second).booleanValue())
    {
      Object localObject2;
      if (am.aSU((String)localObject3))
      {
        localObject1 = ((f)g.ab(f.class)).ahZ((String)localObject3);
        if (localObject1 == null) {
          break label234;
        }
        localObject2 = ((r)localObject1).cxL();
        boolean bool = am.aSU((String)localObject3);
        localObject1 = i.sja;
        if (!bool) {
          break label193;
        }
        localObject1 = i.a.sjd;
        label96:
        localObject3 = i.a((i.a)localObject1);
        if (!bool) {
          break label201;
        }
        localObject1 = i.sja;
      }
      for (localObject1 = i.cCC();; localObject1 = i.cCD())
      {
        localObject1 = ((d)localObject1).bI(new a((String)localObject2));
        ((com.tencent.mm.loader.a.b)localObject1).a((com.tencent.mm.loader.c.e)localObject3);
        localObject2 = (Bitmap)((com.tencent.mm.loader.a.b)localObject1).aqJ();
        if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
          break label214;
        }
        AppMethodBeat.o(200903);
        return localObject2;
        localObject1 = ((f)g.ab(f.class)).aia((String)localObject3);
        break;
        label193:
        localObject1 = i.a.sje;
        break label96;
        label201:
        localObject1 = i.sja;
      }
      label214:
      ((com.tencent.mm.loader.a.b)localObject1).a(new com.tencent.mm.loader.f.e() {});
      ((com.tencent.mm.loader.a.b)localObject1).aqI();
      label234:
      AppMethodBeat.o(200903);
      return null;
    }
    paramString = this.siu.a((String)localObject3, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(200903);
    return paramString;
  }
  
  public final void a(final j paramj)
  {
    AppMethodBeat.i(200908);
    if ((paramj instanceof e.a))
    {
      Object localObject = ahu(paramj.getTag());
      boolean bool = ((Boolean)((Pair)localObject).second).booleanValue();
      localObject = (String)((Pair)localObject).first;
      if (bool)
      {
        paramj = (e.a)paramj;
        this.sit.add(new WeakReference(paramj));
        AppMethodBeat.o(200908);
        return;
      }
      paramj.ESX = new j.c()
      {
        public final boolean ahw(String paramAnonymousString)
        {
          AppMethodBeat.i(200901);
          if (this.geH.equals(paramAnonymousString))
          {
            paramj.fbK();
            paramj.ESX = null;
          }
          AppMethodBeat.o(200901);
          return true;
        }
      };
      this.siu.a(paramj);
    }
    AppMethodBeat.o(200908);
  }
  
  public final boolean ahv(String paramString)
  {
    AppMethodBeat.i(200909);
    if (!am.aSU(((p)g.ab(p.class)).aii(paramString)))
    {
      AppMethodBeat.o(200909);
      return true;
    }
    AppMethodBeat.o(200909);
    return false;
  }
  
  public final Bitmap fg(String paramString)
  {
    AppMethodBeat.i(200905);
    Pair localPair = ahu(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = a(paramString, 0, 0, 0);
      AppMethodBeat.o(200905);
      return paramString;
    }
    paramString = this.siu.fg((String)localPair.first);
    AppMethodBeat.o(200905);
    return paramString;
  }
  
  public final Bitmap fh(String paramString)
  {
    AppMethodBeat.i(200906);
    Pair localPair = ahu(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = a(paramString, 0, 0, 0);
      AppMethodBeat.o(200906);
      return paramString;
    }
    paramString = this.siu.fh((String)localPair.first);
    AppMethodBeat.o(200906);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.b
 * JD-Core Version:    0.7.0.1
 */