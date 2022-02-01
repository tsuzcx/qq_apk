package com.tencent.mm.plugin.gamelife.f;

import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.j.b;
import com.tencent.mm.pluginsdk.ui.j.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
  implements j.a, j.b
{
  final List<WeakReference<j>> sro;
  private final j.a srp;
  
  public d(j.a parama)
  {
    AppMethodBeat.i(211941);
    this.sro = new ArrayList();
    this.srp = parama;
    AppMethodBeat.o(211941);
  }
  
  static Pair<String, Boolean> anI(String paramString)
  {
    AppMethodBeat.i(211943);
    if (an.aUw(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(211943);
      return paramString;
    }
    paramString = ((f)g.ab(f.class)).ajf(paramString);
    paramString = new Pair(paramString, Boolean.valueOf(an.aUw(paramString)));
    AppMethodBeat.o(211943);
    return paramString;
  }
  
  public final Bitmap LT()
  {
    AppMethodBeat.i(211946);
    Bitmap localBitmap = this.srp.LT();
    AppMethodBeat.o(211946);
    return localBitmap;
  }
  
  public final Bitmap a(final String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(211942);
    Object localObject = anI(paramString);
    paramString = (String)((Pair)localObject).first;
    if (((Boolean)((Pair)localObject).second).booleanValue())
    {
      localObject = ((com.tencent.mm.plugin.gamelife.a.b)g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).any(paramString);
      if (localObject != null)
      {
        localObject = bu.nullAsNil(((com.tencent.mm.plugin.gamelife.a.a)localObject).czm());
        e locale = e.uJP;
        localObject = (Bitmap)e.getLoader().bI(new a((String)localObject)).aqY();
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          AppMethodBeat.o(211942);
          return localObject;
        }
      }
      ((com.tencent.mm.plugin.gamelife.a.b)g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, new b.c()
      {
        public final void ah(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramAnonymousMap)
        {
          AppMethodBeat.i(211939);
          paramAnonymousMap = (com.tencent.mm.plugin.gamelife.a.a)paramAnonymousMap.get(paramString);
          if (paramAnonymousMap == null)
          {
            ae.w("GameLife.AvatarDrawableLoader", "get contact failed");
            AppMethodBeat.o(211939);
            return;
          }
          paramAnonymousMap = paramAnonymousMap.czm();
          e locale = e.uJP;
          paramAnonymousMap = e.getLoader().bI(new a(paramAnonymousMap));
          paramAnonymousMap.a(new com.tencent.mm.loader.f.e() {});
          paramAnonymousMap.aqX();
          AppMethodBeat.o(211939);
        }
      });
      AppMethodBeat.o(211942);
      return null;
    }
    paramString = this.srp.a(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(211942);
    return paramString;
  }
  
  public final void a(final j paramj)
  {
    AppMethodBeat.i(211947);
    if ((paramj instanceof e.a))
    {
      Object localObject = anI(paramj.getTag());
      boolean bool = ((Boolean)((Pair)localObject).second).booleanValue();
      localObject = (String)((Pair)localObject).first;
      if (bool)
      {
        this.sro.add(new WeakReference(paramj));
        AppMethodBeat.o(211947);
        return;
      }
      paramj.Fls = new j.c()
      {
        public final boolean ait(String paramAnonymousString)
        {
          AppMethodBeat.i(211940);
          if (this.ggQ.equals(paramAnonymousString))
          {
            paramj.ffy();
            paramj.Fls = null;
          }
          AppMethodBeat.o(211940);
          return true;
        }
      };
      this.srp.a(paramj);
    }
    AppMethodBeat.o(211947);
  }
  
  public final boolean ais(String paramString)
  {
    AppMethodBeat.i(211948);
    if (!an.aUw(((f)g.ab(f.class)).ajf(paramString)))
    {
      AppMethodBeat.o(211948);
      return true;
    }
    AppMethodBeat.o(211948);
    return false;
  }
  
  public final Bitmap fl(String paramString)
  {
    AppMethodBeat.i(211944);
    Pair localPair = anI(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = a(paramString, 0, 0, 0);
      AppMethodBeat.o(211944);
      return paramString;
    }
    paramString = this.srp.fl((String)localPair.first);
    AppMethodBeat.o(211944);
    return paramString;
  }
  
  public final Bitmap fm(String paramString)
  {
    AppMethodBeat.i(211945);
    Pair localPair = anI(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = a(paramString, 0, 0, 0);
      AppMethodBeat.o(211945);
      return paramString;
    }
    paramString = this.srp.fm((String)localPair.first);
    AppMethodBeat.o(211945);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.d
 * JD-Core Version:    0.7.0.1
 */