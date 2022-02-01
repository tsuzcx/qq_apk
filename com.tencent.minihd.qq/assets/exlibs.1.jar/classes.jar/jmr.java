import com.tencent.mobileqq.profile.ProfileCardWebviewPlugin;
import com.tencent.mobileqq.profile.VipProfileCardDownLoadInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

class jmr
  extends DownloadListener
{
  jmr(jmq paramjmq) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    this.a.a.b.set(0);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardWebviewPlugin", 2, String.format("Resource progress task:", new Object[] { paramDownloadTask.toString() }));
    }
    try
    {
      ((VipProfileCardDownLoadInfo)this.a.a.jdField_a_of_type_JavaUtilList.get(this.a.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).f = Integer.valueOf(paramDownloadTask.z);
      if (((VipProfileCardDownLoadInfo)this.a.a.jdField_a_of_type_JavaUtilList.get(this.a.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g != VipProfileCardDownLoadInfo.d)
      {
        ((VipProfileCardDownLoadInfo)this.a.a.jdField_a_of_type_JavaUtilList.get(this.a.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = VipProfileCardDownLoadInfo.c;
        String str = ((VipProfileCardDownLoadInfo)this.a.a.jdField_a_of_type_JavaUtilList.get(this.a.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_b_of_type_JavaLangString;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("result", paramDownloadTask.z);
        localJSONObject.put("message", "onHttpEnd");
        this.a.a.a(str, localJSONObject.toString());
      }
      this.a.a.a();
      return;
    }
    catch (Exception paramDownloadTask)
    {
      paramDownloadTask.printStackTrace();
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    int i = (int)paramDownloadTask.a;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardWebviewPlugin", 2, String.format("Resource progress task:", new Object[] { paramDownloadTask.toString() }));
    }
    try
    {
      ((VipProfileCardDownLoadInfo)this.a.a.jdField_a_of_type_JavaUtilList.get(this.a.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).e = Integer.valueOf(i);
      if (((VipProfileCardDownLoadInfo)this.a.a.jdField_a_of_type_JavaUtilList.get(this.a.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g != VipProfileCardDownLoadInfo.d) {
        ((VipProfileCardDownLoadInfo)this.a.a.jdField_a_of_type_JavaUtilList.get(this.a.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = VipProfileCardDownLoadInfo.jdField_b_of_type_JavaLangInteger;
      }
      return;
    }
    catch (Exception paramDownloadTask)
    {
      paramDownloadTask.printStackTrace();
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardWebviewPlugin", 2, String.format("Resource start download task: %s", new Object[] { paramDownloadTask.toString() }));
    }
    if ((this.a.a.jdField_a_of_type_JavaUtilList.get(this.a.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) != null) && (((VipProfileCardDownLoadInfo)this.a.a.jdField_a_of_type_JavaUtilList.get(this.a.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g != VipProfileCardDownLoadInfo.d)) {
      ((VipProfileCardDownLoadInfo)this.a.a.jdField_a_of_type_JavaUtilList.get(this.a.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = VipProfileCardDownLoadInfo.jdField_b_of_type_JavaLangInteger;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jmr
 * JD-Core Version:    0.7.0.1
 */