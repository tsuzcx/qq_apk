package c.t.m.g;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.Pair;

@SuppressLint({"NewApi"})
final class dj
  extends di
{
  private LruCache<String, Pair<Double, Double>> a = new LruCache(100);
  
  public dj(String paramString)
  {
    super(paramString, "check cell");
  }
  
  public final void a()
  {
    super.a();
    this.a.evictAll();
  }
  
  protected final boolean b(Bundle paramBundle)
  {
    String str = paramBundle.getString("cellkey");
    paramBundle = (Location)paramBundle.getParcelable("location");
    if (paramBundle == null) {
      return true;
    }
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    Pair localPair = (Pair)this.a.get(str);
    if (localPair == null)
    {
      paramBundle = Pair.create(Double.valueOf(paramBundle.getLatitude()), Double.valueOf(paramBundle.getLongitude()));
      this.a.put(str, paramBundle);
      return true;
    }
    return j.a(paramBundle.getLatitude(), paramBundle.getLongitude(), ((Double)localPair.first).doubleValue(), ((Double)localPair.second).doubleValue()) < 6000.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     c.t.m.g.dj
 * JD-Core Version:    0.7.0.1
 */