import android.content.Context;
import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.translate.TranslateClient;

public class byg
  extends TranslateClient
{
  private static final String a = "https://passport.imqq.com/App/MobileQQ/ChangeTrans.html";
  
  public static void a(Context paramContext, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    a().a(paramContext, "https://passport.imqq.com/App/MobileQQ/ChangeTrans.html", null, null, new byh(paramAsyncHttpResponseHandler));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     byg
 * JD-Core Version:    0.7.0.1
 */