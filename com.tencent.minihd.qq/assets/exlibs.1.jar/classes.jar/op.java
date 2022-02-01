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

public class op
  implements Runnable
{
  public op(ReaderPluginReport paramReaderPluginReport) {}
  
  public void run()
  {
    try
    {
      String str2 = ReaderPluginReport.a() + 2;
      String str3 = ReaderPluginReport.b() + System.currentTimeMillis();
      String str4 = ReaderPluginReport.c() + ReaderPluginReport.a(this.a);
      String str5 = ReaderPluginReport.d() + "5.9.3.3468";
      int i = ReaderPluginReport.a(this.a, ReaderPluginReport.a(this.a));
      String str1 = ReaderPluginReport.a(ReaderPluginReport.a(this.a)) + ";" + i;
      Object localObject = str1;
      if (str1.length() > 0) {
        localObject = ReaderPluginReport.g() + str1;
      }
      localObject = new HttpGet(ReaderPluginReport.e() + str2 + str3 + str4 + str5 + (String)localObject);
      if (new DefaultHttpClient().execute((HttpUriRequest)localObject).getStatusLine().getStatusCode() == 200) {}
      ReaderPluginReport.b(ReaderPluginReport.a(this.a), 2);
      ReaderPluginReport.b(this.a, false);
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
 * Qualified Name:     op
 * JD-Core Version:    0.7.0.1
 */