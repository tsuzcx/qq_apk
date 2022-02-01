import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.RandomDrawableParam;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class jds
  extends DownloadListener
{
  jds(jdr paramjdr, String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d(PngFrameManager.a(), 2, "func onDone.【pngZip】");
    }
    if (paramDownloadTask.a() != 3)
    {
      PngFrameManager.a(this.jdField_a_of_type_Jdr.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).obtainMessage(226, this.jdField_a_of_type_Jdr.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
      return;
    }
    try
    {
      FileUtils.a(this.jdField_a_of_type_JavaLangString, EmosmUtils.getPngFramePath(this.jdField_a_of_type_Jdr.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString), false);
      new File(this.jdField_a_of_type_JavaLangString).delete();
      this.jdField_a_of_type_Jdr.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.b(this.jdField_a_of_type_Jdr.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.a.epId);
      PngFrameManager.a(this.jdField_a_of_type_Jdr.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).obtainMessage(225, this.jdField_a_of_type_Jdr.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
      return;
    }
    catch (IOException paramDownloadTask)
    {
      for (;;)
      {
        paramDownloadTask.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jds
 * JD-Core Version:    0.7.0.1
 */