package com.bumptech.glide.c.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Thumbnails;
import android.util.Log;
import com.bumptech.glide.c.a;
import com.bumptech.glide.c.a.d.a;
import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class c
  implements com.bumptech.glide.c.a.d<InputStream>
{
  private final Uri aFB;
  private final e aFC;
  private InputStream inputStream;
  
  private c(Uri paramUri, e parame)
  {
    this.aFB = paramUri;
    this.aFC = parame;
  }
  
  public static c a(Context paramContext, Uri paramUri, d paramd)
  {
    AppMethodBeat.i(76907);
    b localb = com.bumptech.glide.c.ae(paramContext).aCp;
    paramContext = new c(paramUri, new e(com.bumptech.glide.c.ae(paramContext).aCo.nL(), paramd, localb, paramContext.getContentResolver()));
    AppMethodBeat.o(76907);
    return paramContext;
  }
  
  public final void a(com.bumptech.glide.g paramg, d.a<? super InputStream> parama)
  {
    AppMethodBeat.i(76908);
    for (;;)
    {
      try
      {
        paramg = this.aFC.j(this.aFB);
        if (paramg == null) {
          break label93;
        }
        i = this.aFC.i(this.aFB);
        if (i != -1)
        {
          paramg = new com.bumptech.glide.c.a.g(paramg, i);
          this.inputStream = paramg;
          parama.S(this.inputStream);
          AppMethodBeat.o(76908);
          return;
        }
      }
      catch (FileNotFoundException paramg)
      {
        Log.isLoggable("MediaStoreThumbFetcher", 3);
        parama.e(paramg);
        AppMethodBeat.o(76908);
        return;
      }
      continue;
      label93:
      int i = -1;
    }
  }
  
  public final void cancel() {}
  
  public final void cleanup()
  {
    AppMethodBeat.i(76909);
    if (this.inputStream != null) {
      try
      {
        this.inputStream.close();
        AppMethodBeat.o(76909);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(76909);
  }
  
  public final Class<InputStream> om()
  {
    return InputStream.class;
  }
  
  public final a on()
  {
    return a.aEG;
  }
  
  public static final class a
    implements d
  {
    private static final String[] aFD = { "_data" };
    private final ContentResolver aFz;
    
    public a(ContentResolver paramContentResolver)
    {
      this.aFz = paramContentResolver;
    }
    
    public final Cursor h(Uri paramUri)
    {
      AppMethodBeat.i(76905);
      paramUri = paramUri.getLastPathSegment();
      paramUri = this.aFz.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, aFD, "kind = 1 AND image_id = ?", new String[] { paramUri }, null);
      AppMethodBeat.o(76905);
      return paramUri;
    }
  }
  
  public static final class b
    implements d
  {
    private static final String[] aFD = { "_data" };
    private final ContentResolver aFz;
    
    public b(ContentResolver paramContentResolver)
    {
      this.aFz = paramContentResolver;
    }
    
    public final Cursor h(Uri paramUri)
    {
      AppMethodBeat.i(76906);
      paramUri = paramUri.getLastPathSegment();
      paramUri = this.aFz.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, aFD, "kind = 1 AND video_id = ?", new String[] { paramUri }, null);
      AppMethodBeat.o(76906);
      return paramUri;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.a.a.c
 * JD-Core Version:    0.7.0.1
 */