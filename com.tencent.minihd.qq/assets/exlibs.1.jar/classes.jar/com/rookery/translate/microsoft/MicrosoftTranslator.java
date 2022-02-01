package com.rookery.translate.microsoft;

import android.content.Context;
import byk;
import byl;
import bym;
import byn;
import byo;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.asyncHttpClient.JsonHttpResponseHandler;
import com.rookery.translate.Translator;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.rookery.translate.type.TranslateWithTimeCallback;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class MicrosoftTranslator
  extends Translator
{
  private static MicrosoftTranslator jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator;
  private byo jdField_a_of_type_Byo = new byo(this, null);
  public DocumentBuilder a;
  DocumentBuilderFactory jdField_a_of_type_JavaxXmlParsersDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
  
  private MicrosoftTranslator()
  {
    try
    {
      this.jdField_a_of_type_JavaxXmlParsersDocumentBuilder = this.jdField_a_of_type_JavaxXmlParsersDocumentBuilderFactory.newDocumentBuilder();
      return;
    }
    catch (ParserConfigurationException localParserConfigurationException)
    {
      localParserConfigurationException.printStackTrace();
    }
  }
  
  public static MicrosoftTranslator a()
  {
    try
    {
      if (jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator == null) {
        jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator = new MicrosoftTranslator();
      }
      return jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, Long paramLong, JsonHttpResponseHandler paramJsonHttpResponseHandler)
  {
    paramLong = new HashMap();
    paramLong.put("client_id", paramString1);
    paramLong.put("client_secret", paramString2);
    paramLong.put("scope", "https://api.microsofttranslator.com");
    paramLong.put("grant_type", "client_credentials");
    try
    {
      byk.a(paramContext, null, paramLong, new byn(this, paramJsonHttpResponseHandler));
      return;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      paramJsonHttpResponseHandler.a(new TranslateError(paramContext), "UnsupportedEncodingException");
    }
  }
  
  private void a(Context paramContext, List paramList, Language paramLanguage, String paramString, Long paramLong, TranslateWithTimeCallback paramTranslateWithTimeCallback)
  {
    if (paramLanguage == null) {
      paramLanguage = Language.MS_CHINESE_SIMPLIFIED.toString();
    }
    for (;;)
    {
      paramString = new BasicHeader("Authorization", "Bearer " + paramString);
      try
      {
        localObject = new bym(this, paramList, paramTranslateWithTimeCallback, paramLong);
        byk.a(paramContext, new Header[] { paramString }, paramList, paramLanguage, (AsyncHttpResponseHandler)localObject);
        return;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        Object localObject;
        paramTranslateWithTimeCallback.a(new TranslateError(paramContext), paramLong);
        return;
      }
      catch (Exception paramContext)
      {
        paramTranslateWithTimeCallback.a(new TranslateError(paramContext), paramLong);
      }
      localObject = paramLanguage.toString();
      if (localObject != null)
      {
        paramLanguage = (Language)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        paramLanguage = Language.MS_CHINESE_SIMPLIFIED.toString();
      }
    }
  }
  
  public void a(Context paramContext, List paramList, Language paramLanguage, Long paramLong, String paramString1, String paramString2, TranslateWithTimeCallback paramTranslateWithTimeCallback)
  {
    if (System.currentTimeMillis() < this.jdField_a_of_type_Byo.jdField_a_of_type_Long)
    {
      a(paramContext, paramList, paramLanguage, this.jdField_a_of_type_Byo.jdField_a_of_type_JavaLangString, paramLong, paramTranslateWithTimeCallback);
      return;
    }
    a(paramContext, paramString1, paramString2, paramLong, new byl(this, paramLong, paramContext, paramList, paramLanguage, paramTranslateWithTimeCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.rookery.translate.microsoft.MicrosoftTranslator
 * JD-Core Version:    0.7.0.1
 */