package c.t.m.g;

import android.location.Location;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import org.json.JSONException;

public final class em$a
{
  public String a;
  public em b;
  public int c;
  public String d = "network";
  private Location e;
  
  public final a a(Location paramLocation)
  {
    this.e = new Location(paramLocation);
    return this;
  }
  
  public final em a()
  {
    if (this.a != null) {}
    for (;;)
    {
      try
      {
        em localem1 = new em(this.a, (byte)0);
        em.a(em.b(em.b(localem1, this.c), this.d), this.e);
        TencentExtraKeys.setRawGps(localem1, this.e);
        return localem1;
      }
      catch (JSONException localJSONException)
      {
        j.a("TxLocation", "build: ", localJSONException);
        return em.a;
      }
      em localem2 = em.c(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     c.t.m.g.em.a
 * JD-Core Version:    0.7.0.1
 */