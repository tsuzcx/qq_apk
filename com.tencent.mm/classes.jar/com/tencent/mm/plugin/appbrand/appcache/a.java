package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;

public abstract class a
  implements n
{
  volatile String gTL;
  volatile String gTM;
  volatile String versionName;
  
  public final String avc()
  {
    String str2;
    String str3;
    String str1;
    if (TextUtils.isEmpty(this.versionName))
    {
      str2 = "";
      str3 = "";
      localObject4 = null;
      localObject2 = null;
      str1 = str3;
      localObject3 = str2;
    }
    try
    {
      InputStream localInputStream = openRead("WAVersion.json");
      localObject2 = localInputStream;
      str1 = str3;
      localObject3 = str2;
      localObject4 = localInputStream;
      String str4 = d.convertStreamToString(localInputStream);
      localObject2 = localInputStream;
      str1 = str3;
      localObject3 = str2;
      localObject4 = localInputStream;
      i locali = new i(str4);
      localObject2 = localInputStream;
      str1 = str3;
      localObject3 = str2;
      localObject4 = localInputStream;
      str2 = locali.getString("version");
      localObject2 = localInputStream;
      str1 = str3;
      localObject3 = str2;
      localObject4 = localInputStream;
      str3 = locali.getString("updateTime");
      localObject2 = localInputStream;
      str1 = str3;
      localObject3 = str2;
      localObject4 = localInputStream;
      ab.i("MicroMsg.AppBrand.AbsReader", "AbsReader version parsed version = [%s] raw = [%s]", new Object[] { str2, str4 });
      bo.b(localInputStream);
      localObject2 = str2;
      str1 = str3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject4 = localObject2;
        ab.printErrStackTrace("MicroMsg.AppBrand.AbsReader", localException, "get WAVersion.json failed.", new Object[0]);
        bo.b((Closeable)localObject2);
        localObject2 = localObject3;
      }
    }
    finally
    {
      bo.b(localObject4);
    }
    localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = "";
    }
    this.versionName = ((String)localObject3);
    this.gTL = str1;
    this.gTM = String.format(Locale.US, "%s (%s)", new Object[] { this.versionName, this.gTL });
    return this.versionName;
  }
  
  public final String avd()
  {
    return this.gTM;
  }
  
  public final String yl(String paramString)
  {
    Object localObject = openRead(paramString);
    if (localObject == null) {
      return null;
    }
    long l = bo.yB();
    localObject = d.convertStreamToString((InputStream)localObject);
    ab.v("MicroMsg.AppBrand.AbsReader", "readAsString(%s), cost %dms", new Object[] { paramString, Long.valueOf(bo.yB() - l) });
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.a
 * JD-Core Version:    0.7.0.1
 */