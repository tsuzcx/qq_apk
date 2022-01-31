package android.support.v4.content.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.graphics.d;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class f
{
  public static Typeface a(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, a parama)
  {
    if (paramContext.isRestricted()) {
      paramContext = null;
    }
    do
    {
      do
      {
        return paramContext;
        Resources localResources = paramContext.getResources();
        localResources.getValue(paramInt1, paramTypedValue, true);
        paramTypedValue = a(paramContext, localResources, paramTypedValue, paramInt1, paramInt2, parama);
        paramContext = paramTypedValue;
      } while (paramTypedValue != null);
      paramContext = paramTypedValue;
    } while (parama != null);
    throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(paramInt1) + " could not be retrieved.");
  }
  
  private static Typeface a(Context paramContext, Resources paramResources, TypedValue paramTypedValue, int paramInt1, int paramInt2, a parama)
  {
    if (paramTypedValue.string == null) {
      throw new Resources.NotFoundException("Resource \"" + paramResources.getResourceName(paramInt1) + "\" (" + Integer.toHexString(paramInt1) + ") is not a Font: " + paramTypedValue);
    }
    String str = paramTypedValue.string.toString();
    if (!str.startsWith("res/"))
    {
      if (parama != null) {
        parama.a(-3, null);
      }
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      paramTypedValue = d.a(paramResources, paramInt1, paramInt2);
      if (paramTypedValue != null)
      {
        paramContext = paramTypedValue;
        if (parama != null)
        {
          parama.a(paramTypedValue, null);
          return paramTypedValue;
        }
      }
      else
      {
        try
        {
          if (str.toLowerCase().endsWith(".xml"))
          {
            paramTypedValue = c.a(paramResources.getXml(paramInt1), paramResources);
            if (paramTypedValue == null)
            {
              if (parama != null) {
                parama.a(-3, null);
              }
            }
            else {
              return d.a(paramContext, paramTypedValue, paramResources, paramInt1, paramInt2, parama);
            }
          }
          else
          {
            paramResources = d.a(paramContext, paramResources, paramInt1, str, paramInt2);
            paramContext = paramResources;
            if (parama == null) {
              continue;
            }
            if (paramResources != null)
            {
              parama.a(paramResources, null);
              return paramResources;
            }
          }
        }
        catch (XmlPullParserException paramContext)
        {
          if (parama != null) {
            parama.a(-3, null);
          }
          return null;
          parama.a(-3, null);
          return paramResources;
        }
        catch (IOException paramContext)
        {
          label209:
          break label209;
        }
      }
    }
    return null;
  }
  
  public static Drawable c(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramResources.getDrawable(paramInt, paramTheme);
    }
    return paramResources.getDrawable(paramInt);
  }
  
  public static abstract class a
  {
    public final void a(final int paramInt, Handler paramHandler)
    {
      Handler localHandler = paramHandler;
      if (paramHandler == null) {
        localHandler = new Handler(Looper.getMainLooper());
      }
      localHandler.post(new Runnable()
      {
        public final void run() {}
      });
    }
    
    public final void a(final Typeface paramTypeface, Handler paramHandler)
    {
      Handler localHandler = paramHandler;
      if (paramHandler == null) {
        localHandler = new Handler(Looper.getMainLooper());
      }
      localHandler.post(new Runnable()
      {
        public final void run()
        {
          f.a.this.b(paramTypeface);
        }
      });
    }
    
    public abstract void b(Typeface paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.content.a.f
 * JD-Core Version:    0.7.0.1
 */