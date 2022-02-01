import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ek
  implements Runnable
{
  public ek(FontManager paramFontManager) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Thread.sleep(1000L);
        this.a.jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstance();
        if (this.a.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null)
        {
          int j = ChatTextSizeSettingActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
          i = j * j * 240 * 10;
          if (i > 1048576)
          {
            this.a.jdField_a_of_type_ComEtrumpMixlayoutETEngine.initEngine(10, i);
            if (QLog.isColorLevel()) {
              QLog.d("FontManager", 2, "init font engine fontsize=" + j + ",num=" + 10 + ",cache=" + i);
            }
            Thread.sleep(1000L);
            this.a.a(FontManager.b);
            Thread.sleep(1000L);
            Object localObject = ((FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            if ((localObject != null) && (0L != ((ExtensionInfo)localObject).uVipFont))
            {
              localObject = this.a.a((int)((ExtensionInfo)localObject).uVipFont);
              if (localObject != null) {
                this.a.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(((FontInfo)localObject).jdField_a_of_type_JavaLangString, ((FontInfo)localObject).jdField_a_of_type_Int, true);
              }
            }
            this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          }
        }
        else
        {
          throw new Exception("create font engine Instance fail");
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FontManager", 2, "init font engine fail " + localThrowable.getMessage());
        }
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "load_font_fail", 0, 1, "-1", "", "", "");
        return;
      }
      int i = 1048576;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ek
 * JD-Core Version:    0.7.0.1
 */