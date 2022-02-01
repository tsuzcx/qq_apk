import com.tencent.component.network.module.cache.a;
import com.tencent.component.network.module.cache.a.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public final class cvd
  implements e.a
{
  public Collection a()
  {
    synchronized ()
    {
      if (a.a().size() <= 0)
      {
        localObject1 = null;
        return localObject1;
      }
      Object localObject1 = new ArrayList(a.a().values());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cvd
 * JD-Core Version:    0.7.0.1
 */