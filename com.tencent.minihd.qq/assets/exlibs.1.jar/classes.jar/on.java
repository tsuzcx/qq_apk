import com.qqreader.ReaderPluginReport;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class on
  implements Runnable
{
  public on(ReaderPluginReport paramReaderPluginReport) {}
  
  public void run()
  {
    try
    {
      Object localObject = ReaderPluginReport.a() + 103;
      String str1 = ReaderPluginReport.b() + System.currentTimeMillis();
      String str2 = ReaderPluginReport.c() + ReaderPluginReport.a(this.a);
      String str3 = ReaderPluginReport.d() + "5.9.3.3468";
      localObject = new HttpGet(ReaderPluginReport.e() + (String)localObject + str1 + str2 + str3);
      int i = new DefaultHttpClient().execute((HttpUriRequest)localObject).getStatusLine().getStatusCode();
      if (i == 200) {}
      return;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      QLog.e(ReaderPluginReport.f(), 0, "reportDownLoadStart ClientProtocolException:", localClientProtocolException);
      return;
    }
    catch (IOException localIOException)
    {
      QLog.e(ReaderPluginReport.f(), 0, "reportDownLoadStart error:", localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     on
 * JD-Core Version:    0.7.0.1
 */