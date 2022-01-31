package android.support.v4.f;

import android.os.Build.VERSION;
import java.util.Objects;

public final class i
{
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return Objects.equals(paramObject1, paramObject2);
    }
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.f.i
 * JD-Core Version:    0.7.0.1
 */