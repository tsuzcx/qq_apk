package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.v.f;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

class a
  extends f<a.a>
  implements b
{
  private static final Map<String, a> gjC = new android.support.v4.f.a();
  private static final a gjD = new a.1();
  
  private a(i parami) {}
  
  public static a p(i parami)
  {
    if ((parami == null) || (parami.mFinished)) {
      return gjD;
    }
    synchronized (gjC)
    {
      a locala2 = (a)gjC.get(parami.mAppId);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a(parami);
        gjC.put(parami.mAppId, locala1);
      }
      return locala1;
    }
  }
  
  protected final void a(a.a parama)
  {
    y.d(this.mName, "about to executeTask %s", new Object[] { parama.toString() });
    parama.XJ();
  }
  
  public final void aib()
  {
    Ff(2);
  }
  
  protected boolean aic()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.a
 * JD-Core Version:    0.7.0.1
 */