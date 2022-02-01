package com.tencent.mm.plugin.gamelife.g;

import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.j.b;
import com.tencent.mm.pluginsdk.ui.j.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
  implements j.a, j.b
{
  final List<WeakReference<j>> Exg;
  private final j.a Exh;
  
  public d(j.a parama)
  {
    AppMethodBeat.i(268139);
    this.Exg = new ArrayList();
    this.Exh = parama;
    AppMethodBeat.o(268139);
  }
  
  static Pair<String, Boolean> aHF(String paramString)
  {
    AppMethodBeat.i(268148);
    if (au.bwX(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(268148);
      return paramString;
    }
    paramString = ((f)h.ax(f.class)).aAw(paramString);
    paramString = new Pair(paramString, Boolean.valueOf(au.bwX(paramString)));
    AppMethodBeat.o(268148);
    return paramString;
  }
  
  public final void a(final j paramj)
  {
    AppMethodBeat.i(268202);
    if ((paramj instanceof AvatarStorage.a))
    {
      Object localObject = aHF(paramj.getTag());
      boolean bool = ((Boolean)((Pair)localObject).second).booleanValue();
      localObject = (String)((Pair)localObject).first;
      if (bool)
      {
        this.Exg.add(new WeakReference(paramj));
        AppMethodBeat.o(268202);
        return;
      }
      paramj.XYW = new j.c()
      {
        public final boolean ayJ(String paramAnonymousString)
        {
          AppMethodBeat.i(268161);
          if (this.mae.equals(paramAnonymousString))
          {
            paramj.iKl();
            paramj.XYW = null;
          }
          AppMethodBeat.o(268161);
          return true;
        }
      };
      this.Exh.a(paramj);
    }
    AppMethodBeat.o(268202);
  }
  
  public final Bitmap aCj()
  {
    AppMethodBeat.i(268191);
    Bitmap localBitmap = this.Exh.aCj();
    AppMethodBeat.o(268191);
    return localBitmap;
  }
  
  public final boolean ayI(String paramString)
  {
    AppMethodBeat.i(268214);
    if (!au.bwX(((f)h.ax(f.class)).aAw(paramString)))
    {
      AppMethodBeat.o(268214);
      return true;
    }
    AppMethodBeat.o(268214);
    return false;
  }
  
  public final Bitmap b(final String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(268164);
    Object localObject = aHF(paramString);
    paramString = (String)((Pair)localObject).first;
    if (((Boolean)((Pair)localObject).second).booleanValue())
    {
      localObject = ((com.tencent.mm.plugin.gamelife.a.b)h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHu(paramString);
      if (localObject != null)
      {
        localObject = Util.nullAsNil(((com.tencent.mm.plugin.gamelife.a.a)localObject).amx());
        e locale = e.JbE;
        localObject = (Bitmap)e.getLoader().dk(new a((String)localObject)).bll();
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          AppMethodBeat.o(268164);
          return localObject;
        }
      }
      ((com.tencent.mm.plugin.gamelife.a.b)h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, new b.c()
      {
        public final void onDone(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramAnonymousMap)
        {
          AppMethodBeat.i(268174);
          paramAnonymousMap = (com.tencent.mm.plugin.gamelife.a.a)paramAnonymousMap.get(paramString);
          if (paramAnonymousMap == null)
          {
            Log.w("GameLife.AvatarDrawableLoader", "get contact failed");
            AppMethodBeat.o(268174);
            return;
          }
          paramAnonymousMap = paramAnonymousMap.amx();
          e locale = e.JbE;
          paramAnonymousMap = e.getLoader().dk(new a(paramAnonymousMap));
          paramAnonymousMap.a(new com.tencent.mm.loader.e.e() {});
          paramAnonymousMap.blg();
          AppMethodBeat.o(268174);
        }
      });
      AppMethodBeat.o(268164);
      return null;
    }
    paramString = this.Exh.b(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(268164);
    return paramString;
  }
  
  public final Bitmap ik(String paramString)
  {
    AppMethodBeat.i(268184);
    Pair localPair = aHF(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = b(paramString, 0, 0, 0);
      AppMethodBeat.o(268184);
      return paramString;
    }
    paramString = this.Exh.ik((String)localPair.first);
    AppMethodBeat.o(268184);
    return paramString;
  }
  
  public final Bitmap loadBitmap(String paramString)
  {
    AppMethodBeat.i(268176);
    Pair localPair = aHF(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = b(paramString, 0, 0, 0);
      AppMethodBeat.o(268176);
      return paramString;
    }
    paramString = this.Exh.loadBitmap((String)localPair.first);
    AppMethodBeat.o(268176);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.g.d
 * JD-Core Version:    0.7.0.1
 */