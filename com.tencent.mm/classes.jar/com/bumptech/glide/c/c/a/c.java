package com.bumptech.glide.c.c.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class c
  implements n<Uri, InputStream>
{
  private final Context context;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(77336);
    this.context = paramContext.getApplicationContext();
    AppMethodBeat.o(77336);
  }
  
  public static final class a
    implements o<Uri, InputStream>
  {
    private final Context context;
    
    public a(Context paramContext)
    {
      this.context = paramContext;
    }
    
    public final n<Uri, InputStream> a(r paramr)
    {
      AppMethodBeat.i(77335);
      paramr = new c(this.context);
      AppMethodBeat.o(77335);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.c.a.c
 * JD-Core Version:    0.7.0.1
 */