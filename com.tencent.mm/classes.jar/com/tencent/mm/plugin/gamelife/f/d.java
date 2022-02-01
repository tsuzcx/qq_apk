package com.tencent.mm.plugin.gamelife.f;

import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f.a;
import com.tencent.mm.kernel.h;
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
  final List<WeakReference<j>> ztn;
  private final j.a zto;
  
  public d(j.a parama)
  {
    AppMethodBeat.i(203356);
    this.ztn = new ArrayList();
    this.zto = parama;
    AppMethodBeat.o(203356);
  }
  
  static Pair<String, Boolean> aKO(String paramString)
  {
    AppMethodBeat.i(203359);
    if (as.bvR(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(203359);
      return paramString;
    }
    paramString = ((f)h.ae(f.class)).aED(paramString);
    paramString = new Pair(paramString, Boolean.valueOf(as.bvR(paramString)));
    AppMethodBeat.o(203359);
    return paramString;
  }
  
  public final void a(final j paramj)
  {
    AppMethodBeat.i(203366);
    if ((paramj instanceof f.a))
    {
      Object localObject = aKO(paramj.getTag());
      boolean bool = ((Boolean)((Pair)localObject).second).booleanValue();
      localObject = (String)((Pair)localObject).first;
      if (bool)
      {
        this.ztn.add(new WeakReference(paramj));
        AppMethodBeat.o(203366);
        return;
      }
      paramj.RcQ = new j.c()
      {
        public final boolean aDo(String paramAnonymousString)
        {
          AppMethodBeat.i(202670);
          if (this.jwL.equals(paramAnonymousString))
          {
            paramj.hjt();
            paramj.RcQ = null;
          }
          AppMethodBeat.o(202670);
          return true;
        }
      };
      this.zto.a(paramj);
    }
    AppMethodBeat.o(203366);
  }
  
  public final boolean aDn(String paramString)
  {
    AppMethodBeat.i(203367);
    if (!as.bvR(((f)h.ae(f.class)).aED(paramString)))
    {
      AppMethodBeat.o(203367);
      return true;
    }
    AppMethodBeat.o(203367);
    return false;
  }
  
  public final Bitmap aaC()
  {
    AppMethodBeat.i(203365);
    Bitmap localBitmap = this.zto.aaC();
    AppMethodBeat.o(203365);
    return localBitmap;
  }
  
  public final Bitmap b(final String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(203357);
    Object localObject = aKO(paramString);
    paramString = (String)((Pair)localObject).first;
    if (((Boolean)((Pair)localObject).second).booleanValue())
    {
      localObject = ((com.tencent.mm.plugin.gamelife.a.b)h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).aKE(paramString);
      if (localObject != null)
      {
        localObject = Util.nullAsNil(((com.tencent.mm.plugin.gamelife.a.a)localObject).Mm());
        e locale = e.DhM;
        localObject = (Bitmap)e.getLoader().bQ(new a((String)localObject)).aRw();
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          AppMethodBeat.o(203357);
          return localObject;
        }
      }
      ((com.tencent.mm.plugin.gamelife.a.b)h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, new b.c()
      {
        public final void ac(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramAnonymousMap)
        {
          AppMethodBeat.i(204149);
          paramAnonymousMap = (com.tencent.mm.plugin.gamelife.a.a)paramAnonymousMap.get(paramString);
          if (paramAnonymousMap == null)
          {
            Log.w("GameLife.AvatarDrawableLoader", "get contact failed");
            AppMethodBeat.o(204149);
            return;
          }
          paramAnonymousMap = paramAnonymousMap.Mm();
          e locale = e.DhM;
          paramAnonymousMap = e.getLoader().bQ(new a(paramAnonymousMap));
          paramAnonymousMap.a(new com.tencent.mm.loader.f.e() {});
          paramAnonymousMap.aRr();
          AppMethodBeat.o(204149);
        }
      });
      AppMethodBeat.o(203357);
      return null;
    }
    paramString = this.zto.b(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(203357);
    return paramString;
  }
  
  public final Bitmap gJ(String paramString)
  {
    AppMethodBeat.i(203362);
    Pair localPair = aKO(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = b(paramString, 0, 0, 0);
      AppMethodBeat.o(203362);
      return paramString;
    }
    paramString = this.zto.gJ((String)localPair.first);
    AppMethodBeat.o(203362);
    return paramString;
  }
  
  public final Bitmap gK(String paramString)
  {
    AppMethodBeat.i(203364);
    Pair localPair = aKO(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = b(paramString, 0, 0, 0);
      AppMethodBeat.o(203364);
      return paramString;
    }
    paramString = this.zto.gK((String)localPair.first);
    AppMethodBeat.o(203364);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.d
 * JD-Core Version:    0.7.0.1
 */