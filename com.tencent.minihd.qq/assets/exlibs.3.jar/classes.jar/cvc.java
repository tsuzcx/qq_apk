import android.content.Context;
import com.tencent.component.network.module.cache.a.e;
import com.tencent.component.network.module.cache.a.e.a;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;

public class cvc
  implements ThreadPool.Job
{
  public cvc(e parame, boolean paramBoolean, Context paramContext) {}
  
  public Object a(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.a(1);
    paramJobContext = e.a(this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAE).a();
    int i;
    int j;
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      i = 0;
      j = 0;
      while (paramJobContext.hasNext())
      {
        com.tencent.component.network.module.cache.a.b localb = (com.tencent.component.network.module.cache.a.b)paramJobContext.next();
        int k = localb.b(this.jdField_a_of_type_Boolean);
        int m = localb.a(this.jdField_a_of_type_Boolean);
        int n = e.a(this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAE, k, m);
        localb.a(this.jdField_a_of_type_Boolean, n);
        if (com.tencent.component.network.module.base.b.b()) {
          com.tencent.component.network.module.base.b.b("downloader", "clear cache service:" + localb + ": remain=" + n);
        }
        j += m;
        i += k;
      }
      if (i > 0) {
        break label186;
      }
    }
    label186:
    for (float f = 3.4028235E+38F;; f = j / i)
    {
      if (f < 0.1F) {
        e.a(this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAE, this.jdField_a_of_type_AndroidContentContext);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cvc
 * JD-Core Version:    0.7.0.1
 */