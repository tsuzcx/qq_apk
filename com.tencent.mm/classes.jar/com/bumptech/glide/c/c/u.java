package com.bumptech.glide.c.c;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;

public final class u<Data>
  implements n<String, Data>
{
  private final n<Uri, Data> aIO;
  
  public u(n<Uri, Data> paramn)
  {
    this.aIO = paramn;
  }
  
  private static Uri S(String paramString)
  {
    AppMethodBeat.i(77306);
    paramString = Uri.fromFile(new File(paramString));
    AppMethodBeat.o(77306);
    return paramString;
  }
  
  public static final class a
    implements o<String, AssetFileDescriptor>
  {
    public final n<String, AssetFileDescriptor> a(r paramr)
    {
      AppMethodBeat.i(77303);
      paramr = new u(paramr.b(Uri.class, AssetFileDescriptor.class));
      AppMethodBeat.o(77303);
      return paramr;
    }
  }
  
  public static final class b
    implements o<String, ParcelFileDescriptor>
  {
    public final n<String, ParcelFileDescriptor> a(r paramr)
    {
      AppMethodBeat.i(77304);
      paramr = new u(paramr.b(Uri.class, ParcelFileDescriptor.class));
      AppMethodBeat.o(77304);
      return paramr;
    }
  }
  
  public static final class c
    implements o<String, InputStream>
  {
    public final n<String, InputStream> a(r paramr)
    {
      AppMethodBeat.i(77305);
      paramr = new u(paramr.b(Uri.class, InputStream.class));
      AppMethodBeat.o(77305);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.c.u
 * JD-Core Version:    0.7.0.1
 */