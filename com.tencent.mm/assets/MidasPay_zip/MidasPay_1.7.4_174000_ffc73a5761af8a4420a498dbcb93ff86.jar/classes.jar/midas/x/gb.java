package midas.x;

import android.os.Environment;
import android.util.Xml;
import com.tencent.midas.comm.APLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlSerializer;

public class gb
{
  public static File a(String paramString1, String paramString2)
  {
    a(paramString1);
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      paramString1 = new File(localStringBuilder.toString());
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static void a(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      if (!paramString.exists()) {
        paramString.mkdir();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public String b(String paramString1, String paramString2)
  {
    try
    {
      XmlSerializer localXmlSerializer = Xml.newSerializer();
      StringWriter localStringWriter = new StringWriter();
      localXmlSerializer.setOutput(localStringWriter);
      localXmlSerializer.startDocument("utf-8", Boolean.valueOf(true));
      localXmlSerializer.startTag("", "games");
      localXmlSerializer.startTag("", paramString1);
      localXmlSerializer.text(paramString2);
      localXmlSerializer.endTag("", paramString1);
      localXmlSerializer.endTag("", "games");
      localXmlSerializer.endDocument();
      paramString1 = localStringWriter.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public String c(String paramString1, String paramString2)
  {
    try
    {
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        File localFile = Environment.getExternalStorageDirectory();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localFile.getCanonicalPath());
        localStringBuilder.append("/Tencent/");
        localStringBuilder.append(paramString1);
        paramString1 = new FileInputStream(localStringBuilder.toString());
        paramString1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(paramString1).getElementsByTagName("games");
        if (paramString1 != null)
        {
          paramString1 = ((Element)((Element)paramString1.item(0)).getElementsByTagName(paramString2).item(0)).getFirstChild().getNodeValue();
          return paramString1;
        }
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("readInfoFromXML() e=");
      paramString2.append(paramString1.toString());
      APLog.w("APIOXml", paramString2.toString());
    }
    return "";
  }
  
  public boolean d(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = Environment.getExternalStorageDirectory().toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/Tencent/");
      paramString2 = new FileOutputStream(a(localStringBuilder.toString(), paramString2));
      localObject = new OutputStreamWriter(paramString2);
      try
      {
        ((OutputStreamWriter)localObject).write(paramString1);
        ((OutputStreamWriter)localObject).close();
        paramString2.close();
        return true;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("writeToXml() write() e2=");
        paramString2.append(paramString1.toString());
        APLog.w("APIOXml", paramString2.toString());
        return false;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("writeToXml() e=");
      paramString2.append(paramString1.toString());
      APLog.w("APIOXml", paramString2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.gb
 * JD-Core Version:    0.7.0.1
 */