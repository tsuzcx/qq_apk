import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.RandomDrawableParam;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jdr
  implements Runnable
{
  public jdr(PngFrameManager paramPngFrameManager, PngFrameManager.RandomDrawableParam paramRandomDrawableParam) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(PngFrameManager.a(), 2, "func showPngFrame, zip NOT exist, download from Server.");
    }
    Object localObject3 = (EmoticonManager)PngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).getManager(13);
    Object localObject2 = ((EmoticonManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString;
    }
    ((EmoticonPackage)localObject1).rscType = 1;
    ((EmoticonManager)localObject3).a((EmoticonPackage)localObject1);
    String str = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.a.eId;
    localObject2 = EmosmUtils.getEmoticonEncrytUrl(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString, str, 1);
    localObject1 = EmosmUtils.getEmoticonEncryptPath(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString, str);
    localObject3 = EmosmUtils.getEmoticonAIOPreviewUrl(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString, str);
    str = EmosmUtils.getEmoticonAIOPreviewPath(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString, str);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    localArrayList.add(localObject2);
    localHashMap.put(localObject2, new File((String)localObject1));
    localArrayList.add(localObject3);
    localHashMap.put(localObject3, new File(str));
    localObject2 = new DownloadTask(localArrayList, localHashMap, "random_magicface_" + this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString);
    PngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).a((DownloadTask)localObject2, new jds(this, (String)localObject1), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jdr
 * JD-Core Version:    0.7.0.1
 */