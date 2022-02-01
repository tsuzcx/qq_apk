import android.os.Handler;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class cdr
  implements AsyncBack
{
  cdr(cdq paramcdq, long paramLong, String paramString, int paramInt) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    int i = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowserOffline", 2, "OfflineDownloader code:" + paramInt + ", time:" + i);
    }
    if (paramInt == 0)
    {
      if (2 == this.jdField_a_of_type_Cdq.jdField_a_of_type_Int)
      {
        if ((this.jdField_a_of_type_Cdq.jdField_b_of_type_Boolean) && (!HtmlOffline.c(cdq.a(this.jdField_a_of_type_Cdq))))
        {
          this.jdField_a_of_type_Cdq.jdField_b_of_type_Boolean = false;
          cdq.a(this.jdField_a_of_type_Cdq);
          this.jdField_a_of_type_Cdq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Cdq.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        }
        HtmlOffline.d(cdq.a(this.jdField_a_of_type_Cdq));
        paramString = this.jdField_a_of_type_Cdq.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, -1, i);
        this.jdField_a_of_type_Cdq.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      }
      for (;;)
      {
        HtmlOffline.a(cdq.a(this.jdField_a_of_type_Cdq), paramInt, i, NetworkUtil.b(cdq.a(this.jdField_a_of_type_Cdq)), "lixian_update", this.jdField_a_of_type_Cdq.c + "");
        return;
        paramString = this.jdField_a_of_type_Cdq.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 0, i);
        this.jdField_a_of_type_Cdq.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        if ((this.jdField_a_of_type_Cdq.jdField_b_of_type_Boolean) && (!HtmlOffline.c(cdq.a(this.jdField_a_of_type_Cdq))))
        {
          this.jdField_a_of_type_Cdq.jdField_b_of_type_Boolean = false;
          cdq.a(this.jdField_a_of_type_Cdq);
          this.jdField_a_of_type_Cdq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Cdq.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        }
        if (this.jdField_a_of_type_Cdq.jdField_a_of_type_Boolean) {
          HtmlOffline.d(cdq.a(this.jdField_a_of_type_Cdq));
        }
      }
    }
    cdq.a(this.jdField_a_of_type_Cdq);
    if (cdq.b(this.jdField_a_of_type_Cdq) < 3)
    {
      this.jdField_a_of_type_Cdq.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      new cds(this).start();
      return;
    }
    paramString = this.jdField_a_of_type_Cdq.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 2, i);
    this.jdField_a_of_type_Cdq.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    HtmlOffline.a(cdq.a(this.jdField_a_of_type_Cdq), paramInt, i, NetworkUtil.b(cdq.a(this.jdField_a_of_type_Cdq)), "lixian_update", this.jdField_a_of_type_Cdq.c + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cdr
 * JD-Core Version:    0.7.0.1
 */