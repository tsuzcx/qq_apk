package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider;
import java.net.MalformedURLException;
import java.net.URL;

public final class qk
  extends UrlTileProvider
{
  static int a = 0;
  private static final int c = 256;
  TileOverlayOptions b;
  
  public qk(TileOverlayOptions paramTileOverlayOptions)
  {
    super(256, 256);
    AppMethodBeat.i(225953);
    this.b = paramTileOverlayOptions;
    a = qi.a();
    if (this.b != null) {
      this.b.versionInfo(Integer.toString(a));
    }
    AppMethodBeat.o(225953);
  }
  
  static String a()
  {
    AppMethodBeat.i(225972);
    String str = Integer.toString(a);
    AppMethodBeat.o(225972);
    return str;
  }
  
  private void b()
  {
    AppMethodBeat.i(225962);
    a = qi.a();
    if (this.b != null) {
      this.b.versionInfo(Integer.toString(a));
    }
    AppMethodBeat.o(225962);
  }
  
  public final URL getTileUrl(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(225983);
    paramInt2 = (int)(Math.pow(2.0D, paramInt3) - 1.0D - paramInt2);
    Object localObject = ((cz)((dn)cj.a(dn.class)).h()).sketchTileUrl(paramInt1, paramInt2, paramInt3, a);
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new URL((String)localObject);
        AppMethodBeat.o(225983);
        return localObject;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      AppMethodBeat.o(225983);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qk
 * JD-Core Version:    0.7.0.1
 */