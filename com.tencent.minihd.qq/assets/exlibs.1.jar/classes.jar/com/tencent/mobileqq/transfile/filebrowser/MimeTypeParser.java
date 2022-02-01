package com.tencent.mobileqq.transfile.filebrowser;

import android.content.res.XmlResourceParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class MimeTypeParser
{
  public static final String a = "MimeTypes";
  public static final String b = "type";
  public static final String c = "extension";
  public static final String d = "mimetype";
  private static final String e = "MimeTypeParser";
  private MimeTypes jdField_a_of_type_ComTencentMobileqqTransfileFilebrowserMimeTypes;
  private XmlPullParser jdField_a_of_type_OrgXmlpullV1XmlPullParser;
  
  private void a()
  {
    String str1 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(null, "extension");
    String str2 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(null, "mimetype");
    this.jdField_a_of_type_ComTencentMobileqqTransfileFilebrowserMimeTypes.a(str1, str2);
  }
  
  public MimeTypes a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFilebrowserMimeTypes = new MimeTypes();
    int i = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getEventType();
    if (i != 1)
    {
      String str = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName();
      if (i == 2) {
        if (!str.equals("MimeTypes")) {}
      }
      for (;;)
      {
        i = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.next();
        break;
        if (str.equals("type"))
        {
          a();
          continue;
          if ((i != 3) || (!str.equals("MimeTypes"))) {}
        }
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileFilebrowserMimeTypes;
  }
  
  public MimeTypes a(XmlResourceParser paramXmlResourceParser)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlPullParser = paramXmlResourceParser;
    return a();
  }
  
  public MimeTypes a(InputStream paramInputStream)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
    this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.setInput(new InputStreamReader(paramInputStream));
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser
 * JD-Core Version:    0.7.0.1
 */