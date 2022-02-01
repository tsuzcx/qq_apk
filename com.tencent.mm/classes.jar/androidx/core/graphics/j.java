package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.CustomFallbackBuilder;
import android.graphics.fonts.Font;
import android.graphics.fonts.Font.Builder;
import android.graphics.fonts.FontFamily.Builder;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import androidx.core.content.a.c.b;
import androidx.core.content.a.c.c;
import androidx.core.d.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public final class j
  extends k
{
  public final Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(250773);
    try
    {
      paramContext = new Font.Builder(paramResources, paramInt1).build();
      paramResources = new FontFamily.Builder(paramContext).build();
      paramContext = new Typeface.CustomFallbackBuilder(paramResources).setStyle(paramContext.getStyle()).build();
      AppMethodBeat.o(250773);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      AppMethodBeat.o(250773);
    }
    return null;
  }
  
  public final Typeface a(Context paramContext, c.b paramb, Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(250772);
    c.c[] arrayOfc = paramb.Ka;
    int k = arrayOfc.length;
    int i = 0;
    paramContext = null;
    if (i < k) {
      paramb = arrayOfc[i];
    }
    for (;;)
    {
      try
      {
        Font.Builder localBuilder = new Font.Builder(paramResources, paramb.Kf).setWeight(paramb.Kb);
        if (!paramb.Kc) {
          break label215;
        }
        j = 1;
        paramb = localBuilder.setSlant(j).setTtcIndex(paramb.Ke).setFontVariationSettings(paramb.Kd).build();
        if (paramContext == null)
        {
          paramb = new FontFamily.Builder(paramb);
          paramContext = paramb;
        }
        else
        {
          paramContext.addFont(paramb);
        }
      }
      catch (IOException paramb) {}
      if (paramContext == null)
      {
        AppMethodBeat.o(250772);
        return null;
      }
      if ((paramInt & 0x1) != 0)
      {
        i = 700;
        if ((paramInt & 0x2) == 0) {
          break label200;
        }
      }
      label200:
      for (paramInt = 1;; paramInt = 0)
      {
        paramb = new FontStyle(i, paramInt);
        paramContext = new Typeface.CustomFallbackBuilder(paramContext.build()).setStyle(paramb).build();
        AppMethodBeat.o(250772);
        return paramContext;
        i = 400;
        break;
      }
      i += 1;
      break;
      label215:
      int j = 0;
    }
  }
  
  protected final Typeface a(Context paramContext, InputStream paramInputStream)
  {
    AppMethodBeat.i(250769);
    paramContext = new RuntimeException("Do not use this function in API 29 or later.");
    AppMethodBeat.o(250769);
    throw paramContext;
  }
  
  public final Typeface a(Context paramContext, b.b[] paramArrayOfb, int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(250770);
    ContentResolver localContentResolver = paramContext.getContentResolver();
    int m = paramArrayOfb.length;
    int i = 0;
    paramContext = null;
    Object localObject;
    Context localContext;
    for (;;)
    {
      if (i < m)
      {
        localObject = paramArrayOfb[i];
        localContext = paramContext;
        try
        {
          localParcelFileDescriptor = localContentResolver.openFileDescriptor(((b.b)localObject).mUri, "r", null);
          if (localParcelFileDescriptor != null) {
            break label90;
          }
          localContext = paramContext;
          if (localParcelFileDescriptor != null)
          {
            localContext = paramContext;
            localParcelFileDescriptor.close();
            localContext = paramContext;
          }
        }
        catch (IOException paramContext)
        {
          try
          {
            ParcelFileDescriptor localParcelFileDescriptor;
            Font.Builder localBuilder = new Font.Builder(localParcelFileDescriptor).setWeight(((b.b)localObject).Kb);
            localContext = paramContext;
            if (!((b.b)localObject).Kc) {
              break label196;
            }
            int j = 1;
            localContext = paramContext;
            localObject = localBuilder.setSlant(j).setTtcIndex(((b.b)localObject).Ke).build();
            if (paramContext != null) {
              break label202;
            }
            localContext = paramContext;
            localObject = new FontFamily.Builder((Font)localObject);
            paramContext = (Context)localObject;
            for (;;)
            {
              localContext = paramContext;
              if (localParcelFileDescriptor == null) {
                break;
              }
              localContext = paramContext;
              localParcelFileDescriptor.close();
              localContext = paramContext;
              break;
              paramContext = paramContext;
              break;
              j = 0;
              break label126;
              localContext = paramContext;
              paramContext.addFont((Font)localObject);
            }
            try
            {
              localParcelFileDescriptor.close();
              localContext = paramContext;
              AppMethodBeat.o(250770);
              localContext = paramContext;
              throw localThrowable1;
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                localContext = paramContext;
                localThrowable1.addSuppressed(localThrowable2);
              }
            }
          }
          catch (Throwable localThrowable1)
          {
            if (localParcelFileDescriptor == null) {
              break label230;
            }
            localContext = paramContext;
          }
        }
        i += 1;
        paramContext = localContext;
        continue;
        label90:
        localContext = paramContext;
      }
    }
    label126:
    if (paramContext == null)
    {
      AppMethodBeat.o(250770);
      return null;
    }
    label196:
    label202:
    label230:
    if ((paramInt & 0x1) != 0)
    {
      i = 700;
      if ((paramInt & 0x2) == 0) {
        break label335;
      }
    }
    label335:
    for (paramInt = k;; paramInt = 0)
    {
      paramArrayOfb = new FontStyle(i, paramInt);
      paramContext = new Typeface.CustomFallbackBuilder(paramContext.build()).setStyle(paramArrayOfb).build();
      AppMethodBeat.o(250770);
      return paramContext;
      i = 400;
      break;
    }
  }
  
  protected final b.b a(b.b[] paramArrayOfb, int paramInt)
  {
    AppMethodBeat.i(250768);
    paramArrayOfb = new RuntimeException("Do not use this function in API 29 or later.");
    AppMethodBeat.o(250768);
    throw paramArrayOfb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.graphics.j
 * JD-Core Version:    0.7.0.1
 */