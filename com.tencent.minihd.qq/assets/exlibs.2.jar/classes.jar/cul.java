import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.impl.a;
import com.tencent.component.network.downloader.impl.c;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.base.b;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.FutureListener;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class cul
  implements FutureListener
{
  public cul(c paramc, a parama) {}
  
  public void a(Future arg1)
  {
    c.b();
    for (;;)
    {
      synchronized (c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a()))
      {
        synchronized (c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC))
        {
          WeakReference localWeakReference1 = new WeakReference(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA);
          Object localObject4;
          if (localWeakReference1 != null)
          {
            localObject4 = (List)c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).get(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a());
            if (localObject4 == null)
            {
              localObject4 = new ArrayList();
              ((List)localObject4).add(localWeakReference1);
              c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).put(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a(), localObject4);
            }
          }
          else
          {
            return;
          }
          Iterator localIterator = ((List)localObject4).iterator();
          if (localIterator.hasNext())
          {
            WeakReference localWeakReference2 = (WeakReference)localIterator.next();
            if ((localWeakReference2 == null) || ((a)localWeakReference2.get() != this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA)) {
              continue;
            }
            i = 0;
            if (i == 0) {
              continue;
            }
            ((List)localObject4).add(localWeakReference1);
          }
        }
      }
      int i = 1;
    }
  }
  
  public void b(Future paramFuture)
  {
    if (b.a()) {
      b.a("Downloader", "download onFutureDone " + this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a());
    }
    c.c();
    Object localObject4 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.c();
    DownloadResult localDownloadResult;
    Object localObject3;
    synchronized (c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC))
    {
      c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).remove(localObject4);
      localDownloadResult = (DownloadResult)paramFuture.a();
      System.currentTimeMillis();
      localObject3 = c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a());
    }
    try
    {
      Object localObject6;
      Object localObject7;
      synchronized (c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC))
      {
        if (c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).containsKey(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a()))
        {
          localObject6 = (List)c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).get(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a());
          if (localObject6 != null)
          {
            localObject7 = ((List)localObject6).iterator();
            do
            {
              if (!((Iterator)localObject7).hasNext()) {
                break;
              }
              ??? = (WeakReference)((Iterator)localObject7).next();
            } while ((??? == null) || ((a)((WeakReference)???).get() != this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA));
            if (??? != null)
            {
              ((List)localObject6).remove(???);
              if (((List)localObject6).size() <= 0) {
                c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).remove(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a());
              }
            }
          }
        }
        if ((localDownloadResult != null) && (localDownloadResult.a().c()))
        {
          if (b.a()) {
            b.a("Downloader", "download result: " + this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a() + " isRetrying");
          }
          if (localDownloadResult != null) {}
          for (;;)
          {
            try
            {
              if (c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC) != null) {
                c.b(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).a(localDownloadResult.a(), localDownloadResult.a().a());
              }
              if (((localDownloadResult.a().a()) || (c.c(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC) == null)) && (!TextUtils.isEmpty(localDownloadResult.b()))) {
                FileUtils.a(new File(localDownloadResult.b()));
              }
            }
            catch (Throwable paramFuture)
            {
              c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a());
              continue;
            }
            finally
            {
              c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a());
            }
            try
            {
              c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a());
              return;
            }
            finally {}
          }
          paramFuture = finally;
          throw paramFuture;
        }
      }
      try
      {
        if (c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC) != null) {
          c.b(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).a(localDownloadResult.a(), localDownloadResult.a().a());
        }
        if (((localDownloadResult.a().a()) || (c.c(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC) == null)) && (!TextUtils.isEmpty(localDownloadResult.b()))) {
          FileUtils.a(new File(localDownloadResult.b()));
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a());
        }
      }
      finally
      {
        c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a());
      }
    }
    finally
    {
      if (localDownloadResult == null) {}
    }
    throw paramFuture;
    boolean bool = paramFuture.a();
    if ((!bool) || (localDownloadResult != null)) {}
    label725:
    label858:
    label895:
    int j;
    label917:
    label947:
    long l1;
    try
    {
      if (c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC) != null) {
        c.b(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).a(localDownloadResult.a(), localDownloadResult.a().a());
      }
      if (((localDownloadResult.a().a()) || (c.c(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC) == null)) && (!TextUtils.isEmpty(localDownloadResult.b()))) {
        FileUtils.a(new File(localDownloadResult.b()));
      }
    }
    catch (Throwable paramFuture)
    {
      for (;;)
      {
        c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a());
      }
    }
    finally
    {
      c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a());
    }
    return;
    paramFuture = c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC, (String)localObject4, true, null);
    if ((localDownloadResult == null) || (!localDownloadResult.a().a()))
    {
      c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC, paramFuture, localDownloadResult);
      if (localDownloadResult == null) {}
    }
    int k;
    try
    {
      if (c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC) != null) {
        c.b(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).a(localDownloadResult.a(), localDownloadResult.a().a());
      }
      if (((localDownloadResult.a().a()) || (c.c(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC) == null)) && (!TextUtils.isEmpty(localDownloadResult.b()))) {
        FileUtils.a(new File(localDownloadResult.b()));
      }
    }
    catch (Throwable paramFuture)
    {
      label1042:
      label1187:
      for (;;)
      {
        int i;
        label975:
        c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a());
      }
    }
    finally
    {
      c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC).a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a());
    }
    return;
    i = 0;
    long l2;
    if (paramFuture != null)
    {
      ??? = new ArrayList();
      localObject4 = paramFuture.iterator();
      i = 0;
      for (;;)
      {
        if (((Iterator)localObject4).hasNext())
        {
          ??? = (DownloadRequest)((Iterator)localObject4).next();
          if (??? != null) {
            if (((DownloadRequest)???).a())
            {
              i = 1;
              localObject6 = ((DownloadRequest)???).a();
              if (localObject6 != null)
              {
                int m = 0;
                int n = localObject6.length;
                j = 0;
                k = m;
                if (j >= n) {
                  break label1497;
                }
                if (!((List)???).contains(localObject6[j])) {
                  break label1505;
                }
                k = 1;
                break label1497;
                localObject7 = new File(localDownloadResult.b());
                l1 = ((File)localObject7).length();
                n = localObject6.length;
                j = 0;
                if (j >= n) {
                  break label1538;
                }
                CharSequence localCharSequence = localObject6[j];
                if ((TextUtils.isEmpty(localCharSequence)) || (c.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC, localDownloadResult, (DownloadRequest)???)) || (localDownloadResult.b() == null)) {
                  break label1512;
                }
                bool = ((List)???).contains(localCharSequence);
                if (bool) {
                  break label1512;
                }
                k = 0;
                m = 1;
                while ((m >= 0) && (k == 0))
                {
                  m -= 1;
                  try
                  {
                    localFile = new File(localCharSequence);
                    bool = FileUtils.a((File)localObject7, localFile);
                    l2 = localFile.length();
                    if (!b.b()) {
                      break label1519;
                    }
                    b.b("Downloader", "download copy from " + localDownloadResult.b() + " to:" + localCharSequence + " " + this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a() + " result:" + bool + " src-length:" + l1 + " dst-length:" + l2 + " retry:" + m);
                  }
                  catch (Throwable localThrowable2)
                  {
                    File localFile;
                    b.c("Downloader", "download ------- copy exception!!! " + this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a(), localThrowable2);
                    break label1512;
                  }
                  FileUtils.a(localFile);
                }
                if (k != 0)
                {
                  ((List)???).add(localThrowable2);
                  break label1538;
                }
                FileUtils.a(new File(localThrowable2));
                break label1512;
              }
              if (((DownloadRequest)???).a == null) {
                break label1538;
              }
              FileUtils.a(localDownloadResult.b(), ((DownloadRequest)???).a);
              break label1538;
            }
          }
        }
      }
    }
    for (;;)
    {
      c.b(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC, paramFuture, localDownloadResult);
      if (i == 0) {
        break label725;
      }
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplC.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderImplA.a(), localDownloadResult);
      break label725;
      break label895;
      Object localObject2 = null;
      break;
      label1497:
      if (k == 0) {
        break label947;
      }
      break label858;
      label1505:
      j += 1;
      break label917;
      label1512:
      j += 1;
      break label975;
      label1519:
      if ((!bool) || (l1 != l2)) {
        break label1187;
      }
      k = 1;
      break label1042;
      label1538:
      break label858;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cul
 * JD-Core Version:    0.7.0.1
 */