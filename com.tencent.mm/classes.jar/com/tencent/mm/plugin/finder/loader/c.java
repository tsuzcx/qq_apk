package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.d;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.findersdk.a.bp;
import com.tencent.mm.plugin.findersdk.a.ch;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.j.b;
import com.tencent.mm.pluginsdk.ui.j.c;
import com.tencent.mm.storage.au;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements j.a, j.b
{
  final List<WeakReference<AvatarStorage.a>> Exg;
  private final j.a Exh;
  
  public c(j.a parama)
  {
    AppMethodBeat.i(331721);
    this.Exg = new ArrayList();
    this.Exh = parama;
    AppMethodBeat.o(331721);
  }
  
  private static Pair<String, Boolean> ayH(String paramString)
  {
    AppMethodBeat.i(331731);
    if (au.bwV(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(331731);
      return paramString;
    }
    if (au.bwT(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(331731);
      return paramString;
    }
    if (au.bwU(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(331731);
      return paramString;
    }
    paramString = ((bp)h.ax(bp.class)).aAw(paramString);
    if ((au.bwV(paramString)) || (au.bwT(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      paramString = new Pair(paramString, Boolean.valueOf(bool));
      AppMethodBeat.o(331731);
      return paramString;
    }
  }
  
  public final void a(final j paramj)
  {
    AppMethodBeat.i(331777);
    if ((paramj instanceof AvatarStorage.a))
    {
      Object localObject = ayH(paramj.getTag());
      boolean bool = ((Boolean)((Pair)localObject).second).booleanValue();
      localObject = (String)((Pair)localObject).first;
      if (bool)
      {
        paramj = (AvatarStorage.a)paramj;
        this.Exg.add(new WeakReference(paramj));
        AppMethodBeat.o(331777);
        return;
      }
      paramj.XYW = new j.c()
      {
        public final boolean ayJ(String paramAnonymousString)
        {
          AppMethodBeat.i(331652);
          if (this.mae.equals(paramAnonymousString))
          {
            paramj.iKl();
            paramj.XYW = null;
          }
          AppMethodBeat.o(331652);
          return true;
        }
      };
      this.Exh.a(paramj);
    }
    AppMethodBeat.o(331777);
  }
  
  public final Bitmap aCj()
  {
    AppMethodBeat.i(331768);
    Bitmap localBitmap = this.Exh.aCj();
    AppMethodBeat.o(331768);
    return localBitmap;
  }
  
  public final boolean ayI(String paramString)
  {
    AppMethodBeat.i(331785);
    if (!au.bwV(((bp)h.ax(bp.class)).aAw(paramString)))
    {
      AppMethodBeat.o(331785);
      return true;
    }
    AppMethodBeat.o(331785);
    return false;
  }
  
  public final Bitmap b(final String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(331746);
    Object localObject1 = ayH(paramString);
    Object localObject3 = (String)((Pair)localObject1).first;
    if (((Boolean)((Pair)localObject1).second).booleanValue())
    {
      Object localObject2;
      if (au.bwV((String)localObject3))
      {
        localObject1 = ((y)h.ax(y.class)).aAl((String)localObject3);
        if (localObject1 == null) {
          break label265;
        }
        localObject2 = ((ch)localObject1).amx();
        boolean bool = au.bwV((String)localObject3);
        localObject1 = p.ExI;
        if (!bool) {
          break label224;
        }
        localObject1 = p.a.ExM;
        label96:
        localObject3 = p.a((p.a)localObject1);
        if (!bool) {
          break label232;
        }
        localObject1 = p.ExI;
      }
      for (localObject1 = p.eCp();; localObject1 = p.eCq())
      {
        localObject1 = ((d)localObject1).dk(new b((String)localObject2, v.FLF));
        ((com.tencent.mm.loader.a.b)localObject1).a((com.tencent.mm.loader.b.e)localObject3);
        localObject2 = (Bitmap)((com.tencent.mm.loader.a.b)localObject1).bll();
        if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
          break label245;
        }
        AppMethodBeat.o(331746);
        return localObject2;
        if (au.bwU((String)localObject3))
        {
          localObject1 = ((y)h.ax(y.class)).aAn((String)localObject3);
          break;
        }
        localObject1 = ((y)h.ax(y.class)).aAm((String)localObject3);
        break;
        label224:
        localObject1 = p.a.ExO;
        break label96;
        label232:
        localObject1 = p.ExI;
      }
      label245:
      ((com.tencent.mm.loader.a.b)localObject1).a(new com.tencent.mm.loader.e.e() {});
      ((com.tencent.mm.loader.a.b)localObject1).blg();
      label265:
      AppMethodBeat.o(331746);
      return null;
    }
    paramString = this.Exh.b((String)localObject3, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(331746);
    return paramString;
  }
  
  public final Bitmap ik(String paramString)
  {
    AppMethodBeat.i(331759);
    Pair localPair = ayH(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = b(paramString, 0, 0, 0);
      AppMethodBeat.o(331759);
      return paramString;
    }
    paramString = this.Exh.ik((String)localPair.first);
    AppMethodBeat.o(331759);
    return paramString;
  }
  
  public final Bitmap loadBitmap(String paramString)
  {
    AppMethodBeat.i(331752);
    Pair localPair = ayH(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = b(paramString, 0, 0, 0);
      AppMethodBeat.o(331752);
      return paramString;
    }
    paramString = this.Exh.loadBitmap((String)localPair.first);
    AppMethodBeat.o(331752);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.c
 * JD-Core Version:    0.7.0.1
 */