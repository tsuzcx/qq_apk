package com.bumptech.glide.load.c;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.h;
import com.bumptech.glide.load.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class a<Data>
  implements n<Uri, Data>
{
  private static final int aJE = 22;
  private final AssetManager aFb;
  private final a<Data> aJF;
  
  public a(AssetManager paramAssetManager, a<Data> parama)
  {
    this.aFb = paramAssetManager;
    this.aJF = parama;
  }
  
  public static abstract interface a<Data>
  {
    public abstract d<Data> b(AssetManager paramAssetManager, String paramString);
  }
  
  public static final class b
    implements a.a<ParcelFileDescriptor>, o<Uri, ParcelFileDescriptor>
  {
    private final AssetManager aFb;
    
    public b(AssetManager paramAssetManager)
    {
      this.aFb = paramAssetManager;
    }
    
    public final n<Uri, ParcelFileDescriptor> a(r paramr)
    {
      AppMethodBeat.i(77199);
      paramr = new a(this.aFb, this);
      AppMethodBeat.o(77199);
      return paramr;
    }
    
    public final d<ParcelFileDescriptor> b(AssetManager paramAssetManager, String paramString)
    {
      AppMethodBeat.i(77200);
      paramAssetManager = new h(paramAssetManager, paramString);
      AppMethodBeat.o(77200);
      return paramAssetManager;
    }
  }
  
  public static final class c
    implements a.a<InputStream>, o<Uri, InputStream>
  {
    private final AssetManager aFb;
    
    public c(AssetManager paramAssetManager)
    {
      this.aFb = paramAssetManager;
    }
    
    public final n<Uri, InputStream> a(r paramr)
    {
      AppMethodBeat.i(77201);
      paramr = new a(this.aFb, this);
      AppMethodBeat.o(77201);
      return paramr;
    }
    
    public final d<InputStream> b(AssetManager paramAssetManager, String paramString)
    {
      AppMethodBeat.i(77202);
      paramAssetManager = new m(paramAssetManager, paramString);
      AppMethodBeat.o(77202);
      return paramAssetManager;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.a
 * JD-Core Version:    0.7.0.1
 */