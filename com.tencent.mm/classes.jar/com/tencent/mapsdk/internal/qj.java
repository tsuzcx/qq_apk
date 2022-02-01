package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;
import java.lang.reflect.Field;

public final class qj
  implements ql.a
{
  public static final String a = "rastermap/handdraw";
  private static final int c = 4;
  private static final int d = 20;
  public TileOverlay b;
  private final Object e;
  private sj f;
  private TileOverlayOptions g;
  
  public qj(sj paramsj)
  {
    AppMethodBeat.i(225989);
    this.e = new Object();
    this.f = null;
    this.b = null;
    this.f = paramsj;
    if (this.f != null)
    {
      qi.a(this.f.G());
      paramsj = new ql(this.f.G(), this);
      new ql.b(paramsj, (byte)0).execute(new Context[] { paramsj.a });
    }
    AppMethodBeat.o(225989);
  }
  
  private void d()
  {
    AppMethodBeat.i(225999);
    if (this.g != null)
    {
      ??? = (qk)this.g.getTileProvider();
      qk.a = qi.a();
      if (((qk)???).b != null) {
        ((qk)???).b.versionInfo(qk.a());
      }
    }
    synchronized (this.e)
    {
      if (this.b != null)
      {
        this.b.clearTileCache();
        this.b.reload();
      }
      AppMethodBeat.o(225999);
      return;
    }
  }
  
  private boolean e()
  {
    return this.b != null;
  }
  
  private void f()
  {
    int i = 0;
    AppMethodBeat.i(226012);
    for (;;)
    {
      synchronized (this.e)
      {
        if (this.b == null)
        {
          AppMethodBeat.o(226012);
          return;
        }
        Field[] arrayOfField = this.b.getClass().getDeclaredFields();
        int j = arrayOfField.length;
        if (i >= j) {
          break;
        }
        ??? = arrayOfField[i];
        if (???.getType() != pz.class) {}
      }
      i += 1;
    }
    AppMethodBeat.o(226012);
  }
  
  public final void a()
  {
    AppMethodBeat.i(226022);
    if ((this.b != null) || (this.f == null) || (this.f.e_ == null))
    {
      AppMethodBeat.o(226022);
      return;
    }
    ??? = (VectorMap)this.f.e_;
    Object localObject2;
    if (this.g == null)
    {
      this.g = new TileOverlayOptions();
      localObject2 = new qk(this.g);
      this.g.tileProvider((TileProvider)localObject2).diskCacheDir("rastermap/handdraw").zIndex(2);
    }
    ((VectorMap)???).b(19);
    this.b = ((VectorMap)???).addTileOverlay(this.g);
    for (;;)
    {
      int i;
      synchronized (this.e)
      {
        if (this.b == null)
        {
          AppMethodBeat.o(226022);
          return;
        }
        localObject2 = this.b.getClass().getDeclaredFields();
        int j = localObject2.length;
        i = 0;
        if (i >= j) {
          break;
        }
        ??? = localObject2[i];
        if (((Field)???).getType() != pz.class) {
          break label233;
        }
      }
      try
      {
        ((Field)???).setAccessible(true);
        ((pz)((Field)???).get(this.b)).a(4, 20);
        ((Field)???).setAccessible(false);
        AppMethodBeat.o(226022);
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        kh.b("SketchOverlayManager set data level with reflect", localIllegalAccessException);
        AppMethodBeat.o(226022);
        return;
      }
      localObject3 = finally;
      AppMethodBeat.o(226022);
      throw localObject3;
      label233:
      i += 1;
    }
    AppMethodBeat.o(226022);
  }
  
  public final void b()
  {
    AppMethodBeat.i(226028);
    synchronized (this.e)
    {
      if (this.b == null)
      {
        AppMethodBeat.o(226028);
        return;
      }
      this.b.remove();
      this.b = null;
      AppMethodBeat.o(226028);
      return;
    }
  }
  
  public final void c()
  {
    AppMethodBeat.i(226032);
    if (this.g != null)
    {
      ??? = (qk)this.g.getTileProvider();
      qk.a = qi.a();
      if (((qk)???).b != null) {
        ((qk)???).b.versionInfo(qk.a());
      }
    }
    synchronized (this.e)
    {
      if (this.b != null)
      {
        this.b.clearTileCache();
        this.b.reload();
      }
      AppMethodBeat.o(226032);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qj
 * JD-Core Version:    0.7.0.1
 */