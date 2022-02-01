import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.LoadedCallBack;
import java.util.ArrayList;

public final class cdm
  implements Runnable
{
  public cdm(Context paramContext, ArrayList paramArrayList, String paramString, LoadedCallBack paramLoadedCallBack) {}
  
  public void run()
  {
    String str = HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, 0);
    if (TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_ComTencentBizCommonUtilLoadedCallBack.a("{\"r\":-2}");
      return;
    }
    this.jdField_a_of_type_ComTencentBizCommonUtilLoadedCallBack.a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cdm
 * JD-Core Version:    0.7.0.1
 */