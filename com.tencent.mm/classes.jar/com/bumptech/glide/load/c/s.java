package com.bumptech.glide.load.c;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class s<Data>
  implements n<Integer, Data>
{
  private final n<Uri, Data> aKx;
  private final Resources aKy;
  
  public s(Resources paramResources, n<Uri, Data> paramn)
  {
    this.aKy = paramResources;
    this.aKx = paramn;
  }
  
  private Uri b(Integer paramInteger)
  {
    AppMethodBeat.i(77299);
    try
    {
      Uri localUri = Uri.parse("android.resource://" + this.aKy.getResourcePackageName(paramInteger.intValue()) + '/' + this.aKy.getResourceTypeName(paramInteger.intValue()) + '/' + this.aKy.getResourceEntryName(paramInteger.intValue()));
      AppMethodBeat.o(77299);
      return localUri;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      if (Log.isLoggable("ResourceLoader", 5)) {
        new StringBuilder("Received invalid resource id: ").append(paramInteger);
      }
      AppMethodBeat.o(77299);
    }
    return null;
  }
  
  public static final class a
    implements o<Integer, AssetFileDescriptor>
  {
    private final Resources aKy;
    
    public a(Resources paramResources)
    {
      this.aKy = paramResources;
    }
    
    public final n<Integer, AssetFileDescriptor> a(r paramr)
    {
      AppMethodBeat.i(77295);
      paramr = new s(this.aKy, paramr.b(Uri.class, AssetFileDescriptor.class));
      AppMethodBeat.o(77295);
      return paramr;
    }
  }
  
  public static final class b
    implements o<Integer, ParcelFileDescriptor>
  {
    private final Resources aKy;
    
    public b(Resources paramResources)
    {
      this.aKy = paramResources;
    }
    
    public final n<Integer, ParcelFileDescriptor> a(r paramr)
    {
      AppMethodBeat.i(77296);
      paramr = new s(this.aKy, paramr.b(Uri.class, ParcelFileDescriptor.class));
      AppMethodBeat.o(77296);
      return paramr;
    }
  }
  
  public static final class c
    implements o<Integer, InputStream>
  {
    private final Resources aKy;
    
    public c(Resources paramResources)
    {
      this.aKy = paramResources;
    }
    
    public final n<Integer, InputStream> a(r paramr)
    {
      AppMethodBeat.i(77297);
      paramr = new s(this.aKy, paramr.b(Uri.class, InputStream.class));
      AppMethodBeat.o(77297);
      return paramr;
    }
  }
  
  public static final class d
    implements o<Integer, Uri>
  {
    private final Resources aKy;
    
    public d(Resources paramResources)
    {
      this.aKy = paramResources;
    }
    
    public final n<Integer, Uri> a(r paramr)
    {
      AppMethodBeat.i(77298);
      paramr = new s(this.aKy, v.pv());
      AppMethodBeat.o(77298);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.s
 * JD-Core Version:    0.7.0.1
 */