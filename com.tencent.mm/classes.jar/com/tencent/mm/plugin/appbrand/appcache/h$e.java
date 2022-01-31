package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.appbrand.app.e;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class h$e
{
  public static int abA()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = "select distinct appId from AppBrandWxaPkgManifestRecord where  ( appId not like '%%$%%' or appId like " + String.format(Locale.US, "'%%$%s'", new Object[] { "__APP__" }) + " )  and  ( pkgPath is not null  and pkgPath != ''  ) ";
    Cursor localCursor = e.aaO().a((String)localObject, null, 2);
    if ((localCursor != null) && (!localCursor.isClosed()))
    {
      if (localCursor.moveToFirst()) {
        do
        {
          String str = localCursor.getString(0);
          int i = str.indexOf('$');
          localObject = str;
          if (i > 0) {
            localObject = str.substring(0, i);
          }
          localHashSet.add(localObject);
        } while (localCursor.moveToNext());
      }
      localCursor.close();
    }
    localObject = e.aaO().a("select distinct appId from PredownloadEncryptPkgInfo where pkgPath is not null  and pkgPath != '' ", null, 2);
    if ((localObject != null) && (!((Cursor)localObject).isClosed()))
    {
      if (((Cursor)localObject).moveToFirst()) {
        localHashSet.add(((Cursor)localObject).getString(0));
      }
      while (((Cursor)localObject).moveToNext()) {}
      ((Cursor)localObject).close();
    }
    return localHashSet.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.h.e
 * JD-Core Version:    0.7.0.1
 */