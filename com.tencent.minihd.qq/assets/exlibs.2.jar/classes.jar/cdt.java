import com.tencent.biz.common.download.OfflineDownloader;
import java.util.HashMap;

class cdt
  implements Runnable
{
  cdt(cdq paramcdq) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Accept-Encoding", "gzip");
    OfflineDownloader.a(cdq.a(this.a), this.a.b, cdq.a(this.a), this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cdt
 * JD-Core Version:    0.7.0.1
 */