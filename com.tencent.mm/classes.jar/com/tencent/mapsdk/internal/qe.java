package com.tencent.mapsdk.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.Tile;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;
import java.io.File;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class qe
{
  public static final String a = "tileOverlay";
  public static final String b = "getTile";
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 100;
  private static final String j = "x";
  private static final String k = "y";
  private static final String l = "z";
  public sc f;
  public Map<Integer, pz> g;
  public mk h;
  String i;
  private qg m;
  private Context n;
  
  public qe(Context paramContext, mk parammk)
  {
    AppMethodBeat.i(226038);
    this.g = new Hashtable(4);
    this.n = paramContext;
    this.h = parammk;
    this.f = parammk.g;
    this.i = mf.a(paramContext, null).b().getPath();
    AppMethodBeat.o(226038);
  }
  
  private static int a(Uri paramUri)
  {
    AppMethodBeat.i(226094);
    if (paramUri == null)
    {
      AppMethodBeat.o(226094);
      return -1;
    }
    paramUri = paramUri.getLastPathSegment();
    if (paramUri == null)
    {
      AppMethodBeat.o(226094);
      return -1;
    }
    try
    {
      int i1 = Integer.parseInt(paramUri);
      AppMethodBeat.o(226094);
      return i1;
    }
    catch (NumberFormatException paramUri)
    {
      kh.c(Log.getStackTraceString(paramUri));
      AppMethodBeat.o(226094);
    }
    return -1;
  }
  
  private static int a(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(226099);
    if (paramUri == null)
    {
      AppMethodBeat.o(226099);
      return -1;
    }
    paramUri = paramUri.getQueryParameter(paramString);
    try
    {
      int i1 = Integer.parseInt(paramUri);
      AppMethodBeat.o(226099);
      return i1;
    }
    catch (NumberFormatException paramUri)
    {
      kh.c(Log.getStackTraceString(paramUri));
      AppMethodBeat.o(226099);
    }
    return -1;
  }
  
  private int a(TileOverlayCallback paramTileOverlayCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(226082);
    if (this.f == null)
    {
      AppMethodBeat.o(226082);
      return -1;
    }
    kl.c("TTO");
    int i1 = this.f.a(paramTileOverlayCallback, paramBoolean);
    AppMethodBeat.o(226082);
    return i1;
  }
  
  private Context a()
  {
    return this.n;
  }
  
  private static void a(Context paramContext)
  {
    AppMethodBeat.i(226106);
    if (paramContext == null)
    {
      AppMethodBeat.o(226106);
      return;
    }
    paramContext = new File(mf.a(paramContext, null).b().getPath() + "/tile/");
    if (!paramContext.exists())
    {
      AppMethodBeat.o(226106);
      return;
    }
    paramContext = paramContext.listFiles();
    if ((paramContext == null) || (paramContext.length == 0))
    {
      AppMethodBeat.o(226106);
      return;
    }
    long l1 = System.currentTimeMillis();
    int i2 = paramContext.length;
    int i1 = 0;
    while (i1 < i2)
    {
      File localFile = paramContext[i1];
      if (l1 - localFile.lastModified() > TimeUnit.DAYS.toMillis(7L)) {
        ka.b(localFile);
      }
      i1 += 1;
    }
    AppMethodBeat.o(226106);
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(226068);
    this.f.h(paramBoolean);
    AppMethodBeat.o(226068);
  }
  
  private mk b()
  {
    return this.h;
  }
  
  private void c(int paramInt)
  {
    AppMethodBeat.i(226088);
    if (this.f == null)
    {
      AppMethodBeat.o(226088);
      return;
    }
    this.g.remove(Integer.valueOf(paramInt));
    this.f.d(paramInt);
    kl.d("TTO");
    AppMethodBeat.o(226088);
  }
  
  private boolean c()
  {
    AppMethodBeat.i(226058);
    boolean bool = this.f.t();
    AppMethodBeat.o(226058);
    return bool;
  }
  
  private void d()
  {
    AppMethodBeat.i(226075);
    if ((this.g == null) || (this.g.isEmpty()))
    {
      AppMethodBeat.o(226075);
      return;
    }
    pz[] arrayOfpz = (pz[])this.g.values().toArray(new pz[this.g.keySet().size()]);
    int i1 = 0;
    while (i1 < arrayOfpz.length)
    {
      arrayOfpz[i1].remove();
      i1 += 1;
    }
    AppMethodBeat.o(226075);
  }
  
  public final pz a(int paramInt)
  {
    AppMethodBeat.i(226111);
    if (paramInt >= 0)
    {
      pz localpz = (pz)this.g.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(226111);
      return localpz;
    }
    AppMethodBeat.o(226111);
    return null;
  }
  
  public final pz a(TileOverlayOptions paramTileOverlayOptions)
  {
    AppMethodBeat.i(226124);
    if (this.m == null) {
      this.m = new qg(this);
    }
    paramTileOverlayOptions = this.m.a(paramTileOverlayOptions);
    AppMethodBeat.o(226124);
    return paramTileOverlayOptions;
  }
  
  final void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(226142);
    if (this.f == null)
    {
      AppMethodBeat.o(226142);
      return;
    }
    this.f.b(paramInt1, paramInt2);
    AppMethodBeat.o(226142);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(226150);
    if (this.f == null)
    {
      AppMethodBeat.o(226150);
      return;
    }
    this.f.a(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(226150);
  }
  
  public final void a(pz parampz)
  {
    AppMethodBeat.i(226116);
    if ((parampz != null) && (parampz.n > 0)) {
      this.g.put(Integer.valueOf(parampz.n), parampz);
    }
    AppMethodBeat.o(226116);
  }
  
  public final byte[] a(String paramString)
  {
    AppMethodBeat.i(226168);
    int i1;
    int i2;
    int i3;
    try
    {
      localObject1 = Uri.parse(paramString);
      boolean bool = gz.a(((Uri)localObject1).getAuthority(), "getTile");
      if (!bool)
      {
        AppMethodBeat.o(226168);
        return null;
      }
      i1 = a((Uri)localObject1);
      if (i1 == -1)
      {
        AppMethodBeat.o(226168);
        return null;
      }
      paramString = (pz)this.g.get(Integer.valueOf(i1));
      if (paramString == null)
      {
        AppMethodBeat.o(226168);
        return null;
      }
      i1 = a((Uri)localObject1, "x");
      i2 = a((Uri)localObject1, "y");
      i3 = a((Uri)localObject1, "z");
      if ((paramString.p == null) || (paramString.p.getTileProvider() == null) || (i3 < 0))
      {
        kh.d("TTO", "无效坐标，返回空瓦块");
        paramString = gv.a();
        AppMethodBeat.o(226168);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      kh.c(Log.getStackTraceString(paramString));
      AppMethodBeat.o(226168);
      return null;
    }
    Object localObject1 = ka.b(paramString.p.getVersionInfo());
    localObject1 = String.format(pz.a, new Object[] { localObject1, Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3) });
    Object localObject2 = paramString.p.getTileProvider().getTile(i1, i2, i3);
    if (localObject2 == null)
    {
      kh.d("TTO", "Provider没有瓦片数据，返回空瓦块");
      paramString = gv.a();
      AppMethodBeat.o(226168);
      return paramString;
    }
    localObject2 = ((Tile)localObject2).mData;
    qb localqb;
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      kl.b("TTO", "cacheId", localObject1);
      localqb = new qb((byte[])localObject2);
      if (paramString.q != null)
      {
        jn localjn = jk.a(paramString.q);
        if (localjn == null) {
          break label343;
        }
        localjn.b((String)localObject1, localqb);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(226168);
      return localObject2;
      label343:
      paramString.q.a((String)localObject1, localqb);
    }
  }
  
  public final TileOverlay b(TileOverlayOptions paramTileOverlayOptions)
  {
    AppMethodBeat.i(226136);
    paramTileOverlayOptions = a(paramTileOverlayOptions);
    kl.b("TTO");
    paramTileOverlayOptions = new ay(paramTileOverlayOptions);
    AppMethodBeat.o(226136);
    return paramTileOverlayOptions;
  }
  
  final void b(int paramInt)
  {
    AppMethodBeat.i(226158);
    if (this.f == null)
    {
      AppMethodBeat.o(226158);
      return;
    }
    this.f.e(paramInt);
    AppMethodBeat.o(226158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qe
 * JD-Core Version:    0.7.0.1
 */