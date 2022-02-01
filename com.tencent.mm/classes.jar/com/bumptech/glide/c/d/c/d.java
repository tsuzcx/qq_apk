package com.bumptech.glide.c.d.c;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class d
  implements k<Uri, Drawable>
{
  private final Context context;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(77459);
    this.context = paramContext.getApplicationContext();
    AppMethodBeat.o(77459);
  }
  
  private Context a(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(77461);
    try
    {
      paramString = this.context.createPackageContext(paramString, 0);
      AppMethodBeat.o(77461);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramUri = new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: ".concat(String.valueOf(paramUri)), paramString);
      AppMethodBeat.o(77461);
      throw paramUri;
    }
  }
  
  private int n(Uri paramUri)
  {
    AppMethodBeat.i(77462);
    Object localObject3 = paramUri.getPathSegments();
    String str;
    if (((List)localObject3).size() == 2)
    {
      localObject1 = paramUri.getAuthority();
      str = (String)((List)localObject3).get(0);
      localObject3 = (String)((List)localObject3).get(1);
    }
    Object localObject2;
    for (Object localObject1 = Integer.valueOf(this.context.getResources().getIdentifier((String)localObject3, str, (String)localObject1)); localObject1 == null; localObject2 = null) {
      for (;;)
      {
        paramUri = new IllegalArgumentException("Unrecognized Uri format: ".concat(String.valueOf(paramUri)));
        AppMethodBeat.o(77462);
        throw paramUri;
        if (((List)localObject3).size() == 1) {
          try
          {
            localObject1 = Integer.valueOf((String)((List)localObject3).get(0));
          }
          catch (NumberFormatException localNumberFormatException) {}
        }
      }
    }
    if (localObject2.intValue() == 0)
    {
      paramUri = new IllegalArgumentException("Failed to obtain resource id for: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(77462);
      throw paramUri;
    }
    int i = localObject2.intValue();
    AppMethodBeat.o(77462);
    return i;
  }
  
  public final u<Drawable> m(Uri paramUri)
  {
    AppMethodBeat.i(77460);
    int i = n(paramUri);
    String str = paramUri.getAuthority();
    if (str.equals(this.context.getPackageName())) {}
    for (paramUri = this.context;; paramUri = a(paramUri, str))
    {
      paramUri = c.u(a.b(this.context, paramUri, i));
      AppMethodBeat.o(77460);
      return paramUri;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.d.c.d
 * JD-Core Version:    0.7.0.1
 */