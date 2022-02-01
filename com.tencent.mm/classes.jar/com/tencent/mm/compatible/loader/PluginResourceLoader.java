package com.tencent.mm.compatible.loader;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.ZipFile;

public class PluginResourceLoader
  extends Resources
{
  public Resources jve;
  private Method jvf;
  private Method jvg;
  private HashMap<String, ZipFile> jvh;
  
  private Drawable a(TypedValue paramTypedValue, int paramInt)
  {
    AppMethodBeat.i(155838);
    try
    {
      Drawable localDrawable1 = (Drawable)this.jvf.invoke(this.jve, new Object[] { paramTypedValue, Integer.valueOf(paramInt) });
      AppMethodBeat.o(155838);
      return localDrawable1;
    }
    catch (StackOverflowError localStackOverflowError)
    {
      Log.e("MicroMsg.PluginResourceLoader", "load drawable StackOverflowError");
      try
      {
        if ((paramTypedValue.string != null) && (paramTypedValue.string.toString().endsWith(".xml")))
        {
          XmlResourceParser localXmlResourceParser = b(paramTypedValue.string.toString(), paramInt, paramTypedValue.assetCookie, "drawable");
          Drawable localDrawable2 = Drawable.createFromXml(this, localXmlResourceParser);
          localXmlResourceParser.close();
          AppMethodBeat.o(155838);
          return localDrawable2;
        }
      }
      catch (Exception localException1)
      {
        Iterator localIterator = this.jvh.entrySet().iterator();
        while (localIterator.hasNext())
        {
          ((Map.Entry)localIterator.next()).getValue();
          if (paramTypedValue.string != null)
          {
            paramInt = paramTypedValue.assetCookie;
            paramInt = paramTypedValue.data;
            AppMethodBeat.o(155838);
            throw null;
          }
        }
        Log.d("MicroMsg.PluginResourceLoader", "loadFromZipFile null");
        AppMethodBeat.o(155838);
        return null;
      }
    }
    catch (Exception localException2)
    {
      label50:
      break label50;
    }
  }
  
  private static InputStream a(ZipFile paramZipFile, TypedValue paramTypedValue)
  {
    AppMethodBeat.i(155840);
    if (paramTypedValue.string == null)
    {
      AppMethodBeat.o(155840);
      return null;
    }
    paramTypedValue = paramTypedValue.string.toString();
    try
    {
      Log.d("MicroMsg.PluginResourceLoader", "try load stream from zip, entry=%s, file=%s", new Object[] { paramTypedValue, paramZipFile.getName() });
      paramZipFile = paramZipFile.getInputStream(paramZipFile.getEntry(paramTypedValue));
      AppMethodBeat.o(155840);
      return paramZipFile;
    }
    catch (Exception paramZipFile)
    {
      AppMethodBeat.o(155840);
    }
    return null;
  }
  
  private XmlResourceParser b(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(155834);
    try
    {
      paramString1 = (XmlResourceParser)this.jvg.invoke(this.jve, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
      AppMethodBeat.o(155834);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.PluginResourceLoader", paramString1, "", new Object[0]);
      AppMethodBeat.o(155834);
    }
    return null;
  }
  
  Drawable loadDrawable(TypedValue paramTypedValue, int paramInt)
  {
    AppMethodBeat.i(155835);
    paramTypedValue = a(paramTypedValue, paramInt);
    AppMethodBeat.o(155835);
    return paramTypedValue;
  }
  
  Drawable loadDrawable(TypedValue paramTypedValue, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(155836);
    paramTypedValue = a(paramTypedValue, paramInt);
    AppMethodBeat.o(155836);
    return paramTypedValue;
  }
  
  public InputStream openRawResource(int paramInt, TypedValue paramTypedValue)
  {
    InputStream localInputStream2 = null;
    AppMethodBeat.i(155837);
    getValue(paramInt, paramTypedValue, true);
    try
    {
      InputStream localInputStream1 = super.openRawResource(paramInt, paramTypedValue);
      if (localInputStream1 == null)
      {
        Iterator localIterator = this.jvh.entrySet().iterator();
        localInputStream1 = localInputStream2;
        while (localIterator.hasNext())
        {
          localInputStream2 = a((ZipFile)((Map.Entry)localIterator.next()).getValue(), paramTypedValue);
          localInputStream1 = localInputStream2;
          if (localInputStream2 != null) {
            localInputStream1 = localInputStream2;
          }
        }
        AppMethodBeat.o(155837);
        return localInputStream1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.PluginResourceLoader
 * JD-Core Version:    0.7.0.1
 */