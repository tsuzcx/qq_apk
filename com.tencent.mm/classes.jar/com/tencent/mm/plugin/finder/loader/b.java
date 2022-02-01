package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.ah;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.j.b;
import com.tencent.mm.pluginsdk.ui.j.c;
import com.tencent.mm.storage.as;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements j.a, j.b
{
  final List<WeakReference<e.a>> uIe;
  private final j.a uIf;
  
  public b(j.a parama)
  {
    AppMethodBeat.i(241790);
    this.uIe = new ArrayList();
    this.uIf = parama;
    AppMethodBeat.o(241790);
  }
  
  private static Pair<String, Boolean> aua(String paramString)
  {
    AppMethodBeat.i(241792);
    if (as.bjt(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(241792);
      return paramString;
    }
    if (as.bjs(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(241792);
      return paramString;
    }
    paramString = ((aa)g.af(aa.class)).avi(paramString);
    if ((as.bjt(paramString)) || (as.bjs(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      paramString = new Pair(paramString, Boolean.valueOf(bool));
      AppMethodBeat.o(241792);
      return paramString;
    }
  }
  
  public final Bitmap Wg()
  {
    AppMethodBeat.i(241795);
    Bitmap localBitmap = this.uIf.Wg();
    AppMethodBeat.o(241795);
    return localBitmap;
  }
  
  public final Bitmap a(final String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(241791);
    Object localObject1 = aua(paramString);
    Object localObject3 = (String)((Pair)localObject1).first;
    if (((Boolean)((Pair)localObject1).second).booleanValue())
    {
      Object localObject2;
      if (as.bjt((String)localObject3))
      {
        localObject1 = ((com.tencent.mm.plugin.i.a.m)g.af(com.tencent.mm.plugin.i.a.m.class)).ava((String)localObject3);
        if (localObject1 == null) {
          break label234;
        }
        localObject2 = ((ah)localObject1).cXH();
        boolean bool = as.bjt((String)localObject3);
        localObject1 = m.uJa;
        if (!bool) {
          break label193;
        }
        localObject1 = m.a.uJe;
        label96:
        localObject3 = m.a((m.a)localObject1);
        if (!bool) {
          break label201;
        }
        localObject1 = m.uJa;
      }
      for (localObject1 = m.dka();; localObject1 = m.dkb())
      {
        localObject1 = ((d)localObject1).bQ(new a((String)localObject2));
        ((com.tencent.mm.loader.a.b)localObject1).a((com.tencent.mm.loader.c.e)localObject3);
        localObject2 = (Bitmap)((com.tencent.mm.loader.a.b)localObject1).aJx();
        if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
          break label214;
        }
        AppMethodBeat.o(241791);
        return localObject2;
        localObject1 = ((com.tencent.mm.plugin.i.a.m)g.af(com.tencent.mm.plugin.i.a.m.class)).avb((String)localObject3);
        break;
        label193:
        localObject1 = m.a.uJg;
        break label96;
        label201:
        localObject1 = m.uJa;
      }
      label214:
      ((com.tencent.mm.loader.a.b)localObject1).a(new com.tencent.mm.loader.f.e() {});
      ((com.tencent.mm.loader.a.b)localObject1).aJw();
      label234:
      AppMethodBeat.o(241791);
      return null;
    }
    paramString = this.uIf.a((String)localObject3, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(241791);
    return paramString;
  }
  
  public final void a(final j paramj)
  {
    AppMethodBeat.i(241796);
    if ((paramj instanceof e.a))
    {
      Object localObject = aua(paramj.getTag());
      boolean bool = ((Boolean)((Pair)localObject).second).booleanValue();
      localObject = (String)((Pair)localObject).first;
      if (bool)
      {
        paramj = (e.a)paramj;
        this.uIe.add(new WeakReference(paramj));
        AppMethodBeat.o(241796);
        return;
      }
      paramj.Kcl = new j.c()
      {
        public final boolean auc(String paramAnonymousString)
        {
          AppMethodBeat.i(241789);
          if (this.gMw.equals(paramAnonymousString))
          {
            paramj.goH();
            paramj.Kcl = null;
          }
          AppMethodBeat.o(241789);
          return true;
        }
      };
      this.uIf.a(paramj);
    }
    AppMethodBeat.o(241796);
  }
  
  public final boolean aub(String paramString)
  {
    AppMethodBeat.i(241797);
    if (!as.bjt(((aa)g.af(aa.class)).avi(paramString)))
    {
      AppMethodBeat.o(241797);
      return true;
    }
    AppMethodBeat.o(241797);
    return false;
  }
  
  public final Bitmap fZ(String paramString)
  {
    AppMethodBeat.i(241793);
    Pair localPair = aua(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = a(paramString, 0, 0, 0);
      AppMethodBeat.o(241793);
      return paramString;
    }
    paramString = this.uIf.fZ((String)localPair.first);
    AppMethodBeat.o(241793);
    return paramString;
  }
  
  public final Bitmap ga(String paramString)
  {
    AppMethodBeat.i(241794);
    Pair localPair = aua(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = a(paramString, 0, 0, 0);
      AppMethodBeat.o(241794);
      return paramString;
    }
    paramString = this.uIf.ga((String)localPair.first);
    AppMethodBeat.o(241794);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.b
 * JD-Core Version:    0.7.0.1
 */