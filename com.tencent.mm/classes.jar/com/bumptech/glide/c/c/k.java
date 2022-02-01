package com.bumptech.glide.c.c;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.c.a;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.a.d.a;
import com.bumptech.glide.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;

public final class k
  implements n<Uri, File>
{
  private final Context context;
  
  public k(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static final class a
    implements o<Uri, File>
  {
    private final Context context;
    
    public a(Context paramContext)
    {
      this.context = paramContext;
    }
    
    public final n<Uri, File> a(r paramr)
    {
      AppMethodBeat.i(77255);
      paramr = new k(this.context);
      AppMethodBeat.o(77255);
      return paramr;
    }
  }
  
  static final class b
    implements d<File>
  {
    private static final String[] aIt = { "_data" };
    private final Context context;
    private final Uri uri;
    
    b(Context paramContext, Uri paramUri)
    {
      this.context = paramContext;
      this.uri = paramUri;
    }
    
    public final void a(g paramg, d.a<? super File> parama)
    {
      paramg = null;
      Object localObject = null;
      AppMethodBeat.i(77256);
      Cursor localCursor = this.context.getContentResolver().query(this.uri, aIt, null, null, null);
      if (localCursor != null) {
        paramg = localObject;
      }
      try
      {
        if (localCursor.moveToFirst()) {
          paramg = localCursor.getString(localCursor.getColumnIndexOrThrow("_data"));
        }
        localCursor.close();
        if (TextUtils.isEmpty(paramg))
        {
          parama.e(new FileNotFoundException("Failed to find file path for: " + this.uri));
          AppMethodBeat.o(77256);
          return;
        }
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(77256);
      }
      parama.R(new File(paramg));
      AppMethodBeat.o(77256);
    }
    
    public final void cancel() {}
    
    public final void cleanup() {}
    
    public final Class<File> nU()
    {
      return File.class;
    }
    
    public final a nV()
    {
      return a.aCP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.c.k
 * JD-Core Version:    0.7.0.1
 */