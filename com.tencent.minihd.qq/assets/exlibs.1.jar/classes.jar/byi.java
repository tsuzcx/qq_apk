import android.content.Context;
import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.translate.TranslateClient;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public abstract class byi
  extends TranslateClient
{
  private static final String a = "https://www.googleapis.com/language/translate/v2";
  
  public static void a(Context paramContext, Header[] paramArrayOfHeader, List paramList, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    a().a(paramContext, "https://www.googleapis.com/language/translate/v2", paramArrayOfHeader, paramList, paramAsyncHttpResponseHandler);
  }
  
  public static void a(Context paramContext, Header[] paramArrayOfHeader, HttpEntity paramHttpEntity, String paramString, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    a().a(paramContext, "https://www.googleapis.com/language/translate/v2", paramArrayOfHeader, paramHttpEntity, paramString, paramAsyncHttpResponseHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     byi
 * JD-Core Version:    0.7.0.1
 */