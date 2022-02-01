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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
  implements j.a, j.b
{
  final List<WeakReference<j>> uIe;
  private final j.a uIf;
  
  public d(j.a parama)
  {
    AppMethodBeat.i(241563);
    this.uIe = new ArrayList();
    this.uIf = parama;
    AppMethodBeat.o(241563);
  }
  
  static Pair<String, Boolean> aBb(String paramString)
  {
    AppMethodBeat.i(241565);
    if (as.bjv(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(241565);
      return paramString;
    }
    paramString = ((f)g.af(f.class)).avi(paramString);
    paramString = new Pair(paramString, Boolean.valueOf(as.bjv(paramString)));
    AppMethodBeat.o(241565);
    return paramString;
  }
  
  public final Bitmap Wg()
  {
    AppMethodBeat.i(241568);
    Bitmap localBitmap = this.uIf.Wg();
    AppMethodBeat.o(241568);
    return localBitmap;
  }
  
  public final Bitmap a(final String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(241564);
    Object localObject = aBb(paramString);
    paramString = (String)((Pair)localObject).first;
    if (((Boolean)((Pair)localObject).second).booleanValue())
    {
      localObject = ((com.tencent.mm.plugin.gamelife.a.b)g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(paramString);
      if (localObject != null)
      {
        localObject = Util.nullAsNil(((com.tencent.mm.plugin.gamelife.a.a)localObject).cXH());
        e locale = e.ycg;
        localObject = (Bitmap)e.getLoader().bQ(new a((String)localObject)).aJx();
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          AppMethodBeat.o(241564);
          return localObject;
        }
      }
      ((com.tencent.mm.plugin.gamelife.a.b)g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, new b.c()
      {
        public final void aj(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramAnonymousMap)
        {
          AppMethodBeat.i(241561);
          paramAnonymousMap = (com.tencent.mm.plugin.gamelife.a.a)paramAnonymousMap.get(paramString);
          if (paramAnonymousMap == null)
          {
            Log.w("GameLife.AvatarDrawableLoader", "get contact failed");
            AppMethodBeat.o(241561);
            return;
          }
          paramAnonymousMap = paramAnonymousMap.cXH();
          e locale = e.ycg;
          paramAnonymousMap = e.getLoader().bQ(new a(paramAnonymousMap));
          paramAnonymousMap.a(new com.tencent.mm.loader.f.e() {});
          paramAnonymousMap.aJw();
          AppMethodBeat.o(241561);
        }
      });
      AppMethodBeat.o(241564);
      return null;
    }
    paramString = this.uIf.a(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(241564);
    return paramString;
  }
  
  public final void a(final j paramj)
  {
    AppMethodBeat.i(241569);
    if ((paramj instanceof e.a))
    {
      Object localObject = aBb(paramj.getTag());
      boolean bool = ((Boolean)((Pair)localObject).second).booleanValue();
      localObject = (String)((Pair)localObject).first;
      if (bool)
      {
        this.uIe.add(new WeakReference(paramj));
        AppMethodBeat.o(241569);
        return;
      }
      paramj.Kcl = new j.c()
      {
        public final boolean auc(String paramAnonymousString)
        {
          AppMethodBeat.i(241562);
          if (this.gMw.equals(paramAnonymousString))
          {
            paramj.goH();
            paramj.Kcl = null;
          }
          AppMethodBeat.o(241562);
          return true;
        }
      };
      this.uIf.a(paramj);
    }
    AppMethodBeat.o(241569);
  }
  
  public final boolean aub(String paramString)
  {
    AppMethodBeat.i(241570);
    if (!as.bjv(((f)g.af(f.class)).avi(paramString)))
    {
      AppMethodBeat.o(241570);
      return true;
    }
    AppMethodBeat.o(241570);
    return false;
  }
  
  public final Bitmap fZ(String paramString)
  {
    AppMethodBeat.i(241566);
    Pair localPair = aBb(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = a(paramString, 0, 0, 0);
      AppMethodBeat.o(241566);
      return paramString;
    }
    paramString = this.uIf.fZ((String)localPair.first);
    AppMethodBeat.o(241566);
    return paramString;
  }
  
  public final Bitmap ga(String paramString)
  {
    AppMethodBeat.i(241567);
    Pair localPair = aBb(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = a(paramString, 0, 0, 0);
      AppMethodBeat.o(241567);
      return paramString;
    }
    paramString = this.uIf.ga((String)localPair.first);
    AppMethodBeat.o(241567);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.d
 * JD-Core Version:    0.7.0.1
 */