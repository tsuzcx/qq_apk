import android.app.Activity;
import android.os.AsyncTask;
import com.dataline.util.file.FileUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class fyl
  extends AsyncTask
{
  public fyl(File paramFile1, File paramFile2, Activity paramActivity) {}
  
  protected String a(Void... paramVarArgs)
  {
    paramVarArgs = this.jdField_a_of_type_JavaIoFile.getAbsolutePath();
    try
    {
      if (FileUtil.a(this.b, this.jdField_a_of_type_JavaIoFile))
      {
        ImageUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        return this.jdField_a_of_type_AndroidAppActivity.getString(2131367112) + " " + paramVarArgs;
      }
      paramVarArgs = this.jdField_a_of_type_AndroidAppActivity.getString(2131367113);
      return paramVarArgs;
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      paramVarArgs = this.jdField_a_of_type_AndroidAppActivity.getString(2131367113);
      if (QLog.isColorLevel()) {
        QLog.e("AIOGalleryUtils", 2, "savePhoto  OOM ");
      }
    }
    return paramVarArgs;
  }
  
  protected void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {}
    for (int i = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight();; i = 0)
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, paramString, 0).b(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fyl
 * JD-Core Version:    0.7.0.1
 */