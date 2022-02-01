import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.qphone.base.util.QLog;

public class jlw
  implements Runnable
{
  public jlw(PicPreDownloader paramPicPreDownloader, MessageForPic paramMessageForPic, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productAysnc(): cannot predownload");
      }
      PicPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -1);
      return;
    }
    PicPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jlw
 * JD-Core Version:    0.7.0.1
 */