package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.appbrand.app.g;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class n$e
{
  public static int avt()
  {
    AppMethodBeat.i(129349);
    HashSet localHashSet = new HashSet();
    Object localObject = "select distinct appId from AppBrandWxaPkgManifestRecord where  ( appId not like '%%$%%' or appId like " + String.format(Locale.US, "'%%$%s'", new Object[] { "__APP__" }) + " )  and  ( pkgPath is not null  and pkgPath != ''  ) ";
    Cursor localCursor = g.auB().a((String)localObject, null, 2);
    if ((localCursor != null) && (!localCursor.isClosed()))
    {
      if (localCursor.moveToFirst()) {
        do
        {
          String str = localCursor.getString(0);
          i = str.indexOf('$');
          localObject = str;
          if (i > 0) {
            localObject = str.substring(0, i);
          }
          localHashSet.add(localObject);
        } while (localCursor.moveToNext());
      }
      localCursor.close();
    }
    localObject = g.auB().a("select distinct appId from PredownloadEncryptPkgInfo where pkgPath is not null  and pkgPath != '' ", null, 2);
    if ((localObject != null) && (!((Cursor)localObject).isClosed()))
    {
      if (((Cursor)localObject).moveToFirst()) {
        localHashSet.add(((Cursor)localObject).getString(0));
      }
      while (((Cursor)localObject).moveToNext()) {}
      ((Cursor)localObject).close();
    }
    int i = localHashSet.size();
    AppMethodBeat.o(129349);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.n.e
 * JD-Core Version:    0.7.0.1
 */