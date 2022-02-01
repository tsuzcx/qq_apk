import android.media.ExifInterface;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class fye
  extends AsyncTask
{
  public fye(AIOGalleryScene paramAIOGalleryScene, File paramFile, int paramInt) {}
  
  protected Void a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = new ExifInterface(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
      if (this.jdField_a_of_type_Int == 0) {
        paramVarArgs.setAttribute("Orientation", String.valueOf(1));
      }
      for (;;)
      {
        paramVarArgs.saveAttributes();
        paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene;
        paramVarArgs.c += 1;
        break label138;
        if (this.jdField_a_of_type_Int != 1) {
          break;
        }
        paramVarArgs.setAttribute("Orientation", String.valueOf(6));
      }
    }
    catch (IOException paramVarArgs)
    {
      while (QLog.isColorLevel())
      {
        QLog.e("AIOGalleryScene", 2, "save exif error", paramVarArgs);
        break;
        if (this.jdField_a_of_type_Int == 2) {
          paramVarArgs.setAttribute("Orientation", String.valueOf(3));
        } else if (this.jdField_a_of_type_Int == 3) {
          paramVarArgs.setAttribute("Orientation", String.valueOf(8));
        }
      }
    }
    label138:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fye
 * JD-Core Version:    0.7.0.1
 */