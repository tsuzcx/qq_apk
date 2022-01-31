package com.tencent.mm.aj;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class m
{
  public static Bitmap aE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11429);
    if (!g.RL().isSDCardAvailable())
    {
      paramString1 = afb();
      AppMethodBeat.o(11429);
      return paramString1;
    }
    if ((paramString1 == null) || (!g.RJ().QU()))
    {
      AppMethodBeat.o(11429);
      return null;
    }
    String str = paramString2;
    if (paramString2 == null)
    {
      paramString2 = aF(paramString1, null);
      str = paramString2;
      if (paramString2 == null)
      {
        AppMethodBeat.o(11429);
        return null;
      }
    }
    paramString2 = z.afs();
    Object localObject;
    if (paramString2.fwK.containsKey(paramString1))
    {
      localObject = (Bitmap)((WeakReference)paramString2.fwK.get(paramString1)).get();
      if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
      {
        localObject = aF(paramString1, str);
        localObject = com.tencent.mm.sdk.platformtools.d.aoV(m.a.sh(paramString1 + (String)localObject));
        if (localObject == null)
        {
          ab.i("MicroMsg.BrandLogic", "not found brand icon local");
          paramString2 = null;
          label166:
          if (paramString2 == null) {
            break label267;
          }
          AppMethodBeat.o(11429);
          return paramString2;
        }
        paramString2.g(paramString1, (Bitmap)localObject);
      }
    }
    for (;;)
    {
      paramString2 = (WeakReference)paramString2.fwK.get(paramString1);
      if (paramString2 == null) {
        break;
      }
      paramString2 = (Bitmap)paramString2.get();
      break label166;
      localObject = aF(paramString1, str);
      localObject = com.tencent.mm.sdk.platformtools.d.aoV(m.a.sh(paramString1 + (String)localObject));
      if (localObject == null)
      {
        ab.i("MicroMsg.BrandLogic", "not found brand icon local");
        break;
      }
      paramString2.g(paramString1, (Bitmap)localObject);
    }
    label267:
    al.d(new m.1(paramString1, str));
    AppMethodBeat.o(11429);
    return null;
  }
  
  static String aF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11431);
    if ((paramString1 == null) || (!g.RJ().QU()))
    {
      AppMethodBeat.o(11431);
      return null;
    }
    paramString1 = z.afi().rK(paramString1);
    if (paramString1.field_brandIconURL != null)
    {
      paramString1 = paramString1.field_brandIconURL;
      AppMethodBeat.o(11431);
      return paramString1;
    }
    AppMethodBeat.o(11431);
    return paramString2;
  }
  
  private static Bitmap afb()
  {
    localObject1 = null;
    AppMethodBeat.i(11430);
    Object localObject4 = new BitmapFactory.Options();
    com.tencent.mm.sdk.platformtools.d.dsm();
    try
    {
      Object localObject2 = ah.getContext().getResources().openRawResource(2130839823);
      localObject1 = localObject2;
      localObject4 = BitmapFactory.decodeStream((InputStream)localObject2, null, (BitmapFactory.Options)localObject4);
      localObject1 = localObject4;
      if (localObject2 != null) {}
      try
      {
        ((InputStream)localObject2).close();
        localObject2 = localObject1;
        if (localObject1 != null) {
          localObject2 = com.tencent.mm.sdk.platformtools.d.a(localObject1, false, localObject1.getWidth() >> 1);
        }
        AppMethodBeat.o(11430);
        return localObject2;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.BrandLogic", localIOException2, "", new Object[0]);
        }
      }
      try
      {
        localObject1.close();
        AppMethodBeat.o(11430);
        throw localObject3;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.BrandLogic", localIOException1, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  public static Bitmap sf(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(11428);
    if ((bo.isNullOrNil(paramString)) || (!g.RL().isSDCardAvailable()) || (!g.RJ().QU()))
    {
      AppMethodBeat.o(11428);
      return null;
    }
    Bitmap localBitmap = z.afs().sg(paramString);
    if (localBitmap == null) {
      bool = true;
    }
    ab.i("MicroMsg.BrandLogic", "get verify user icon = %s, is null ? %s", new Object[] { paramString, String.valueOf(bool) });
    AppMethodBeat.o(11428);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.m
 * JD-Core Version:    0.7.0.1
 */