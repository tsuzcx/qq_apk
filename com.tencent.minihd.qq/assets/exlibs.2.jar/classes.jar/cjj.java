import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;

public class cjj
  implements Runnable
{
  public cjj(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface) {}
  
  public void run()
  {
    long l = PublicAccountJavascriptInterface.a();
    try
    {
      PublicAccountJavascriptInterface.a(l);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cjj
 * JD-Core Version:    0.7.0.1
 */