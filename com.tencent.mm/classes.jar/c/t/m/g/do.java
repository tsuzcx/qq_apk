package c.t.m.g;

import android.location.Location;
import android.os.Bundle;

public final class do
{
  public static final Location a = new Location("EMPTY");
  
  static
  {
    new Bundle();
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    boolean bool = de.a().d("https");
    StringBuilder localStringBuilder2 = new StringBuilder("http");
    if (bool) {}
    for (String str = "s";; str = "")
    {
      localStringBuilder1.append(str + "://lbs.map.qq.com/loc");
      localStringBuilder1.append("?");
      localStringBuilder1.append("c=1");
      localStringBuilder1.append("&mars=").append(paramInt1);
      localStringBuilder1.append("&obs=").append(paramInt2);
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     c.t.m.g.do
 * JD-Core Version:    0.7.0.1
 */