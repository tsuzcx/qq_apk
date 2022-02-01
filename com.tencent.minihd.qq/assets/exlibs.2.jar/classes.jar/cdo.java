import android.content.Context;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public final class cdo
  implements AsyncBack
{
  public cdo(long paramLong, String paramString, AsyncBack paramAsyncBack, Context paramContext) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(paramInt);
  }
  
  public void a(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.i("HtmlCheckUpdate", 2, "js call downloadUpdate callback:" + paramInt + ", time:" + l);
    }
    if (paramInt == 0) {
      if (HtmlOffline.d(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(null, 0);
      }
    }
    for (;;)
    {
      HtmlOffline.b(this.jdField_a_of_type_JavaLangString);
      HtmlOffline.a(this.jdField_a_of_type_JavaLangString, paramInt, l, NetworkUtil.b(this.jdField_a_of_type_AndroidContentContext));
      return;
      this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(null, 6);
      continue;
      this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(null, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cdo
 * JD-Core Version:    0.7.0.1
 */