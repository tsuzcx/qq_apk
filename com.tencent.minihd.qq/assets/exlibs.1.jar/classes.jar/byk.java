import android.content.Context;
import android.util.Xml;
import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.asyncHttpClient.JsonHttpResponseHandler;
import com.rookery.translate.TranslateClient;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.xmlpull.v1.XmlSerializer;

public abstract class byk
  extends TranslateClient
{
  private static final String a = "https://api.microsofttranslator.com/V2/Http.svc/TranslateArray";
  private static final String b = "https://datamarket.accesscontrol.windows.net/v2/OAuth2-13";
  private static final String c = "application/x-www-form-urlencoded";
  private static final String d = "application/xml";
  
  private static String a(List paramList, String paramString)
  {
    XmlSerializer localXmlSerializer;
    StringWriter localStringWriter;
    try
    {
      localXmlSerializer = Xml.newSerializer();
      localStringWriter = new StringWriter();
      localXmlSerializer.setOutput(localStringWriter);
      localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
      localXmlSerializer.startTag("", "TranslateArrayRequest");
      localXmlSerializer.startTag("", "AppId");
      localXmlSerializer.endTag("", "AppId");
      localXmlSerializer.startTag("", "Texts");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        localXmlSerializer.startTag("https://schemas.microsoft.com/2003/10/Serialization/Arrays", "string");
        localXmlSerializer.text(str);
        localXmlSerializer.endTag("https://schemas.microsoft.com/2003/10/Serialization/Arrays", "string");
      }
      localXmlSerializer.endTag("", "Texts");
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      return null;
    }
    localXmlSerializer.startTag("", "To");
    localXmlSerializer.text(paramString);
    localXmlSerializer.endTag("", "To");
    localXmlSerializer.endTag("", "TranslateArrayRequest");
    localXmlSerializer.endDocument();
    paramList = localStringWriter.toString();
    return paramList;
  }
  
  public static void a(Context paramContext, Header[] paramArrayOfHeader, List paramList, String paramString, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    paramList = new StringEntity(a(paramList, paramString), "UTF-8");
    a().a(paramContext, "https://api.microsofttranslator.com/V2/Http.svc/TranslateArray", paramArrayOfHeader, paramList, "application/xml", paramAsyncHttpResponseHandler);
  }
  
  public static void a(Context paramContext, Header[] paramArrayOfHeader, Map paramMap, JsonHttpResponseHandler paramJsonHttpResponseHandler)
  {
    ArrayList localArrayList = new ArrayList(4);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localArrayList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    paramMap = new UrlEncodedFormEntity(localArrayList);
    a().a(paramContext, "https://datamarket.accesscontrol.windows.net/v2/OAuth2-13", paramArrayOfHeader, paramMap, "application/x-www-form-urlencoded", paramJsonHttpResponseHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     byk
 * JD-Core Version:    0.7.0.1
 */