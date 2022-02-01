import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class jlx
  implements Runnable
{
  public jlx(PicPreDownloader paramPicPreDownloader, int paramInt) {}
  
  public void run()
  {
    int k = 0;
    int m = this.jdField_a_of_type_Int;
    for (;;)
    {
      int j;
      int i;
      PicReq localPicReq;
      synchronized (PicPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader))
      {
        Iterator localIterator = PicPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader).iterator();
        j = 0;
        i = 0;
        if (!localIterator.hasNext()) {
          break label201;
        }
        localPicReq = (PicReq)localIterator.next();
        switch (localPicReq.r)
        {
        case 4: 
          k += 1;
          PicPreDownloader.d(this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader).add(0, localPicReq);
          localPicReq.q = localPicReq.r;
          this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.a.put(localPicReq.a.g, Integer.valueOf(localPicReq.q));
        }
      }
      i += 1;
      PicPreDownloader.b(this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader).add(0, localPicReq);
      continue;
      j += 1;
      PicPreDownloader.c(this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader).add(0, localPicReq);
      continue;
      label201:
      PicPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader).clear();
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): totalCount=" + m + " countOfC2C=" + i + " countOfDiscussion=" + j + " countOfGroup=" + k);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jlx
 * JD-Core Version:    0.7.0.1
 */