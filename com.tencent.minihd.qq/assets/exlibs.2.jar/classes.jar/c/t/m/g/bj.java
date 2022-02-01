package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;

public final class bj
  extends be
{
  private SparseArray<Pair<Double, Double>> a = new SparseArray();
  
  public bj(String paramString)
  {
    super(paramString, "check cell");
  }
  
  public final void a()
  {
    super.a();
    this.a.clear();
  }
  
  protected final Object b(Bundle paramBundle)
  {
    int i = paramBundle.getInt("lac");
    int j = paramBundle.getInt("cid");
    paramBundle = (Location)paramBundle.getParcelable("location");
    if ((i == 0) || (j == 0)) {
      return "error";
    }
    int k = i << j + 16;
    Pair localPair = (Pair)this.a.get(k);
    if (this.a.size() > 50) {
      this.a.clear();
    }
    if (localPair == null) {
      this.a.put(k, Pair.create(Double.valueOf(paramBundle.getLatitude()), Double.valueOf(paramBundle.getLongitude())));
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label258;
      }
      return null;
      double d1 = paramBundle.getLatitude();
      double d2 = paramBundle.getLongitude();
      double d3 = ((Double)localPair.first).doubleValue();
      double d4 = ((Double)localPair.second).doubleValue();
      double d5 = b.a.a(d1, d2, d3, d4);
      cj.a("PluginCellCheck", String.format("isCellLocationOK: cell=(%d,%d), old_loc=(%.6f, %.6f), new_loc=(%.6f, %.6f), dist=%.2f", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d1), Double.valueOf(d2), Double.valueOf(d5) }));
      if (d5 <= 6000.0D) {
        break;
      }
    }
    label258:
    return "error";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.bj
 * JD-Core Version:    0.7.0.1
 */