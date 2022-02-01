package com.bumptech.glide.load.c;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.g;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.d.a;
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
    private static final String[] PROJECTION = { "_data" };
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
      Cursor localCursor = this.context.getContentResolver().query(this.uri, PROJECTION, null, null, null);
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
      parama.S(new File(paramg));
      AppMethodBeat.o(77256);
    }
    
    public final void cancel() {}
    
    public final void cleanup() {}
    
    public final Class<File> os()
    {
      return File.class;
    }
    
    public final a ot()
    {
      return a.aEG;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.k
 * JD-Core Version:    0.7.0.1
 */