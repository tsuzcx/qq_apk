package com.tencent.mm.plugin.gamelife.f;

import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.j.b;
import com.tencent.mm.pluginsdk.ui.j.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
  implements j.a, j.b
{
  final List<WeakReference<e.a>> sit;
  private final j.a siu;
  
  public d(j.a parama)
  {
    AppMethodBeat.i(211178);
    this.sit = new ArrayList();
    this.siu = parama;
    AppMethodBeat.o(211178);
  }
  
  private static Pair<String, Boolean> amH(String paramString)
  {
    AppMethodBeat.i(211180);
    if (am.aSW(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(211180);
      return paramString;
    }
    paramString = ((com.tencent.mm.plugin.gamelife.a.e)g.ab(com.tencent.mm.plugin.gamelife.a.e.class)).aii(paramString);
    paramString = new Pair(paramString, Boolean.valueOf(am.aSW(paramString)));
    AppMethodBeat.o(211180);
    return paramString;
  }
  
  public final Bitmap LL()
  {
    AppMethodBeat.i(211183);
    Bitmap localBitmap = this.siu.LL();
    AppMethodBeat.o(211183);
    return localBitmap;
  }
  
  public final Bitmap a(final String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(211179);
    Object localObject = amH(paramString);
    final String str = (String)((Pair)localObject).first;
    if (((Boolean)((Pair)localObject).second).booleanValue())
    {
      localObject = ((com.tencent.mm.plugin.gamelife.a.b)g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).amA(str);
      if (localObject != null)
      {
        localObject = bt.nullAsNil(((com.tencent.mm.plugin.gamelife.a.a)localObject).cxL());
        e locale = e.uym;
        localObject = (Bitmap)e.getLoader().bI(new a((String)localObject)).aqJ();
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          AppMethodBeat.o(211179);
          return localObject;
        }
      }
      ((com.tencent.mm.plugin.gamelife.a.b)g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(str, new b.c()
      {
        public final void ab(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramAnonymousMap)
        {
          AppMethodBeat.i(211176);
          paramAnonymousMap = (com.tencent.mm.plugin.gamelife.a.a)paramAnonymousMap.get(str);
          if (paramAnonymousMap == null)
          {
            ad.w("GameLife.AvatarDrawableLoader", "get contact failed");
            AppMethodBeat.o(211176);
            return;
          }
          paramAnonymousMap = paramAnonymousMap.cxL();
          e locale = e.uym;
          paramAnonymousMap = e.getLoader().bI(new a(paramAnonymousMap));
          paramAnonymousMap.a(new com.tencent.mm.loader.f.e() {});
          paramAnonymousMap.aqI();
          AppMethodBeat.o(211176);
        }
      });
      AppMethodBeat.o(211179);
      return null;
    }
    paramString = this.siu.a(str, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(211179);
    return paramString;
  }
  
  public final void a(final j paramj)
  {
    AppMethodBeat.i(211184);
    if ((paramj instanceof e.a))
    {
      Object localObject = amH(paramj.getTag());
      boolean bool = ((Boolean)((Pair)localObject).second).booleanValue();
      localObject = (String)((Pair)localObject).first;
      if (bool)
      {
        paramj = (e.a)paramj;
        this.sit.add(new WeakReference(paramj));
        AppMethodBeat.o(211184);
        return;
      }
      paramj.ESX = new j.c()
      {
        public final boolean ahw(String paramAnonymousString)
        {
          AppMethodBeat.i(211177);
          if (this.geH.equals(paramAnonymousString))
          {
            paramj.fbK();
            paramj.ESX = null;
          }
          AppMethodBeat.o(211177);
          return true;
        }
      };
      this.siu.a(paramj);
    }
    AppMethodBeat.o(211184);
  }
  
  public final boolean ahv(String paramString)
  {
    AppMethodBeat.i(211185);
    if (!am.aSW(((com.tencent.mm.plugin.gamelife.a.e)g.ab(com.tencent.mm.plugin.gamelife.a.e.class)).aii(paramString)))
    {
      AppMethodBeat.o(211185);
      return true;
    }
    AppMethodBeat.o(211185);
    return false;
  }
  
  public final Bitmap fg(String paramString)
  {
    AppMethodBeat.i(211181);
    Pair localPair = amH(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = a(paramString, 0, 0, 0);
      AppMethodBeat.o(211181);
      return paramString;
    }
    paramString = this.siu.fg((String)localPair.first);
    AppMethodBeat.o(211181);
    return paramString;
  }
  
  public final Bitmap fh(String paramString)
  {
    AppMethodBeat.i(211182);
    Pair localPair = amH(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = a(paramString, 0, 0, 0);
      AppMethodBeat.o(211182);
      return paramString;
    }
    paramString = this.siu.fh((String)localPair.first);
    AppMethodBeat.o(211182);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.d
 * JD-Core Version:    0.7.0.1
 */