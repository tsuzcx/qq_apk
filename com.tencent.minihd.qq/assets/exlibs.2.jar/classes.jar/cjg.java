import com.tencent.biz.pubaccount.CustomWebView;

public class cjg
  implements Runnable
{
  public cjg(CustomWebView paramCustomWebView, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.b) {
      return;
    }
    try
    {
      CustomWebView.a(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, "javascript:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cjg
 * JD-Core Version:    0.7.0.1
 */