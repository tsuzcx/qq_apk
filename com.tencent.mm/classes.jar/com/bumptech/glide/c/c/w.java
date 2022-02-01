package com.bumptech.glide.c.c;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.c.a.a;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class w<Data>
  implements n<Uri, Data>
{
  private static final Set<String> aId;
  private final c<Data> aIe;
  
  static
  {
    AppMethodBeat.i(77322);
    aId = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "file", "android.resource", "content" })));
    AppMethodBeat.o(77322);
  }
  
  public w(c<Data> paramc)
  {
    this.aIe = paramc;
  }
  
  public static final class a
    implements o<Uri, AssetFileDescriptor>, w.c<AssetFileDescriptor>
  {
    private final ContentResolver aCR;
    
    public a(ContentResolver paramContentResolver)
    {
      this.aCR = paramContentResolver;
    }
    
    public final n<Uri, AssetFileDescriptor> a(r paramr)
    {
      AppMethodBeat.i(77314);
      paramr = new w(this);
      AppMethodBeat.o(77314);
      return paramr;
    }
    
    public final d<AssetFileDescriptor> l(Uri paramUri)
    {
      AppMethodBeat.i(77315);
      paramUri = new a(this.aCR, paramUri);
      AppMethodBeat.o(77315);
      return paramUri;
    }
  }
  
  public static final class b
    implements o<Uri, ParcelFileDescriptor>, w.c<ParcelFileDescriptor>
  {
    private final ContentResolver aCR;
    
    public b(ContentResolver paramContentResolver)
    {
      this.aCR = paramContentResolver;
    }
    
    public final n<Uri, ParcelFileDescriptor> a(r paramr)
    {
      AppMethodBeat.i(77317);
      paramr = new w(this);
      AppMethodBeat.o(77317);
      return paramr;
    }
    
    public final d<ParcelFileDescriptor> l(Uri paramUri)
    {
      AppMethodBeat.i(77316);
      paramUri = new i(this.aCR, paramUri);
      AppMethodBeat.o(77316);
      return paramUri;
    }
  }
  
  public static abstract interface c<Data>
  {
    public abstract d<Data> l(Uri paramUri);
  }
  
  public static final class d
    implements o<Uri, InputStream>, w.c<InputStream>
  {
    private final ContentResolver aCR;
    
    public d(ContentResolver paramContentResolver)
    {
      this.aCR = paramContentResolver;
    }
    
    public final n<Uri, InputStream> a(r paramr)
    {
      AppMethodBeat.i(77319);
      paramr = new w(this);
      AppMethodBeat.o(77319);
      return paramr;
    }
    
    public final d<InputStream> l(Uri paramUri)
    {
      AppMethodBeat.i(77318);
      paramUri = new com.bumptech.glide.c.a.n(this.aCR, paramUri);
      AppMethodBeat.o(77318);
      return paramUri;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.c.w
 * JD-Core Version:    0.7.0.1
 */