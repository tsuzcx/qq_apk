import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class en
  implements Runnable
{
  public en(FontManager paramFontManager, FontInfo paramFontInfo, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (!this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a.native_loadFont(this.jdField_a_of_type_ComEtrumpMixlayoutFontInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComEtrumpMixlayoutFontInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean))
      {
        if (new File(this.jdField_a_of_type_ComEtrumpMixlayoutFontInfo.jdField_a_of_type_JavaLangString).exists()) {
          break label110;
        }
        this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(this.jdField_a_of_type_Int, null);
        if (QLog.isColorLevel()) {
          QLog.d("FontManager", 2, "load font fail file not exist font id=" + this.jdField_a_of_type_Int);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(false, this.jdField_a_of_type_Boolean);
        return;
        label110:
        if (QLog.isColorLevel()) {
          QLog.d("FontManager", 2, "load font fail font id=" + this.jdField_a_of_type_Int);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FontManager", 2, "load font fail" + localThrowable.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     en
 * JD-Core Version:    0.7.0.1
 */