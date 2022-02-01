import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class kvu
  implements Runnable
{
  kvu(kvs paramkvs) {}
  
  public void run()
  {
    DownloadTask localDownloadTask = kvs.a(this.a);
    if (localDownloadTask == null) {
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(-1);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(kvs.jdField_a_of_type_JavaLangString, 2, "doTask | run() downloadLimitCount=" + this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ",task=" + localDownloadTask);
      }
      DownloadListener localDownloadListener = localDownloadTask.a();
      if ((!localDownloadTask.c) || (!DownloaderFactory.a(localDownloadTask.jdField_a_of_type_JavaLangString))) {
        break;
      }
      if (localDownloadListener != null)
      {
        localDownloadTask.z = -101;
        localDownloadTask.a(-1);
        localDownloadListener.onDone(localDownloadTask);
      }
      this.a.a(localDownloadTask);
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(-1);
      this.a.c();
    } while (!QLog.isColorLevel());
    QLog.d(kvs.jdField_a_of_type_JavaLangString, 2, "doTask | run() task is limit of failTime, task=" + localDownloadTask);
    return;
    int i = DownloaderFactory.a(localDownloadTask, this.a.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d(kvs.jdField_a_of_type_JavaLangString, 2, "doTask | run() download task result=" + i + ",task=" + localDownloadTask);
    }
    this.a.a(localDownloadTask);
    this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(-1);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kvu
 * JD-Core Version:    0.7.0.1
 */