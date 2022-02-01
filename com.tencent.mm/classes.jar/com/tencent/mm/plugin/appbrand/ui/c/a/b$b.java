package com.tencent.mm.plugin.appbrand.ui.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "", "()V", "ALL", "EQUAL", "LESS", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$ALL;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$LESS;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$EQUAL;", "plugin-appbrand-integration_release"})
public abstract class b$b
{
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$ALL;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "()V", "plugin-appbrand-integration_release"})
  public static final class a
    extends b.b
  {
    public static final a mNX;
    
    static
    {
      AppMethodBeat.i(189651);
      mNX = new a();
      AppMethodBeat.o(189651);
    }
    
    private a()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$EQUAL;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "version", "", "(I)V", "getVersion", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
  public static final class b
    extends b.b
  {
    final int version;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if (this.version != paramObject.version) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.version;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(189652);
      String str = "EQUAL(version=" + this.version + ")";
      AppMethodBeat.o(189652);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$LESS;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "version", "", "(I)V", "getVersion", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
  public static final class c
    extends b.b
  {
    final int version;
    
    public c(int paramInt)
    {
      super();
      this.version = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if (this.version != paramObject.version) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.version;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(189653);
      String str = "LESS(version=" + this.version + ")";
      AppMethodBeat.o(189653);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.a.b.b
 * JD-Core Version:    0.7.0.1
 */