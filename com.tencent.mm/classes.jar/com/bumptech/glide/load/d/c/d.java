package com.bumptech.glide.load.d.c;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class d
  implements j<Uri, Drawable>
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
    AppMethodBeat.i(204481);
    if (paramString.equals(this.context.getPackageName()))
    {
      paramUri = this.context;
      AppMethodBeat.o(204481);
      return paramUri;
    }
    try
    {
      Context localContext = this.context.createPackageContext(paramString, 0);
      AppMethodBeat.o(204481);
      return localContext;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      if (paramString.contains(this.context.getPackageName()))
      {
        paramUri = this.context;
        AppMethodBeat.o(204481);
        return paramUri;
      }
      paramUri = new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: ".concat(String.valueOf(paramUri)), localNameNotFoundException);
      AppMethodBeat.o(204481);
      throw paramUri;
    }
  }
  
  private static int b(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(204482);
    List localList = paramUri.getPathSegments();
    int i;
    if (localList.size() == 2)
    {
      i = c(paramContext, paramUri);
      AppMethodBeat.o(204482);
      return i;
    }
    if (localList.size() == 1)
    {
      i = n(paramUri);
      AppMethodBeat.o(204482);
      return i;
    }
    paramContext = new IllegalArgumentException("Unrecognized Uri format: ".concat(String.valueOf(paramUri)));
    AppMethodBeat.o(204482);
    throw paramContext;
  }
  
  private static int c(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(204483);
    Object localObject = paramUri.getPathSegments();
    String str1 = paramUri.getAuthority();
    String str2 = (String)((List)localObject).get(0);
    localObject = (String)((List)localObject).get(1);
    int i = paramContext.getResources().getIdentifier((String)localObject, str2, str1);
    if (i == 0) {
      i = Resources.getSystem().getIdentifier((String)localObject, str2, "android");
    }
    for (;;)
    {
      if (i == 0)
      {
        paramContext = new IllegalArgumentException("Failed to find resource id for: ".concat(String.valueOf(paramUri)));
        AppMethodBeat.o(204483);
        throw paramContext;
      }
      AppMethodBeat.o(204483);
      return i;
    }
  }
  
  private static int n(Uri paramUri)
  {
    AppMethodBeat.i(204484);
    List localList = paramUri.getPathSegments();
    try
    {
      int i = Integer.parseInt((String)localList.get(0));
      AppMethodBeat.o(204484);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      paramUri = new IllegalArgumentException("Unrecognized Uri format: ".concat(String.valueOf(paramUri)), localNumberFormatException);
      AppMethodBeat.o(204484);
      throw paramUri;
    }
  }
  
  public final v<Drawable> m(Uri paramUri)
  {
    AppMethodBeat.i(77460);
    Context localContext = a(paramUri, paramUri.getAuthority());
    int i = b(localContext, paramUri);
    paramUri = c.u(a.b(this.context, localContext, i));
    AppMethodBeat.o(77460);
    return paramUri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.c.d
 * JD-Core Version:    0.7.0.1
 */