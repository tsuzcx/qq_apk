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
import android.support.v4.a.d;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class b
{
  public static Typeface a(Context paramContext, Resources paramResources, TypedValue paramTypedValue, int paramInt1, int paramInt2, a parama)
  {
    if (paramTypedValue.string == null) {
      throw new Resources.NotFoundException("Resource \"" + paramResources.getResourceName(paramInt1) + "\" (" + Integer.toHexString(paramInt1) + ") is not a Font: " + paramTypedValue);
    }
    paramTypedValue = paramTypedValue.string.toString();
    if (!paramTypedValue.startsWith("res/"))
    {
      parama.a(-3, null);
      return null;
    }
    Typeface localTypeface = d.a(paramResources, paramInt1, paramInt2);
    if (localTypeface != null)
    {
      parama.a(localTypeface, null);
      return localTypeface;
    }
    try
    {
      if (paramTypedValue.toLowerCase().endsWith(".xml"))
      {
        paramTypedValue = a.a(paramResources.getXml(paramInt1), paramResources);
        if (paramTypedValue == null)
        {
          parama.a(-3, null);
          return null;
        }
        return d.a(paramContext, paramTypedValue, paramResources, paramInt1, paramInt2, parama);
      }
      paramContext = d.a(paramContext, paramResources, paramInt1, paramTypedValue, paramInt2);
      if (paramContext != null)
      {
        parama.a(paramContext, null);
        return paramContext;
      }
    }
    catch (XmlPullParserException paramContext)
    {
      parama.a(-3, null);
      return null;
      parama.a(-3, null);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      label182:
      break label182;
    }
  }
  
  public static Drawable b(Resources paramResources, int paramInt, Resources.Theme paramTheme)
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
          b.a.this.b(paramTypeface);
        }
      });
    }
    
    public abstract void b(Typeface paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.content.a.b
 * JD-Core Version:    0.7.0.1
 */