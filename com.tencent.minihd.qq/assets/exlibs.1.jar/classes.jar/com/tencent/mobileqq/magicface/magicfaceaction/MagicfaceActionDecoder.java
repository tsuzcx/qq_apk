package com.tencent.mobileqq.magicface.magicfaceaction;

import android.text.TextUtils;
import android.util.Xml;
import com.tencent.mobileqq.magicface.model.MagicfacePlayRes;
import com.tencent.qphone.base.util.QLog;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class MagicfaceActionDecoder
{
  public static final String A = "video";
  public static final String B = "sound";
  public static final String C = "title";
  public static final String D = "subtitle";
  public static final String E = "feekbacktext";
  public static final String F = "repeat";
  public static final String G = "colorMask";
  public static final String H = "vibrator";
  public static final String I = "time";
  public static final String J = "swipeGesture";
  public static final String K = "tapGesture";
  public static final String L = "dbTapGesture";
  public static final String M = "direction";
  public static final String N = "up";
  public static final String O = "down";
  public static final String P = "left";
  public static final String Q = "right";
  public static final String R = "stopType";
  public static final String S = "willDo";
  public static final String T = "replacevalue";
  public static final String a = "MagicfaceActionDecoder";
  public static final String b = "magicface";
  public static final String c = "random";
  public static final String d = "useSensor";
  public static final String e = "record";
  public static final String f = "fullScreen";
  public static final String g = "minQVer";
  public static final String h = "isAutoPlay";
  public static final String i = "action";
  public static final String j = "ActionDef";
  public static final String k = "playResDef";
  public static final String l = "ready";
  public static final String m = "playRes";
  public static final String n = "timeout";
  public static final String o = "soundsrc";
  public static final String p = "stopcondition";
  public static final String q = "min";
  public static final String r = "max";
  public static final String s = "text";
  public static final String t = "name";
  public static final String u = "process";
  public static final String v = "type";
  public static final String w = "value";
  public static final String x = "gravity";
  public static final String y = "mic";
  public static final String z = "touch";
  private Action jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction;
  private ActionProcess jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
  private MagicfacePlayRes jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes;
  
  private void a(XmlPullParser paramXmlPullParser, Action paramAction)
  {
    paramAction.jdField_b_of_type_JavaLangString = paramXmlPullParser.getAttributeValue(null, "name");
    String str = paramXmlPullParser.getAttributeValue(null, "timeout");
    if (str != null) {
      paramAction.jdField_a_of_type_Int = Integer.parseInt(str);
    }
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "nextActionIfTimeout");
    if (paramXmlPullParser != null) {
      paramAction.jdField_a_of_type_Boolean = Boolean.parseBoolean(paramXmlPullParser);
    }
  }
  
  public int a(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = XmlPullParserFactory.newInstance();
        ((XmlPullParserFactory)localObject).setNamespaceAware(true);
        localObject = ((XmlPullParserFactory)localObject).newPullParser();
        ((XmlPullParser)localObject).setInput(new StringReader(paramString));
        i1 = ((XmlPullParser)localObject).getEventType();
      }
      catch (Exception paramString)
      {
        Object localObject;
        paramString.printStackTrace();
        return 0;
      }
      int i1 = ((XmlPullParser)localObject).next();
      if (((XmlPullParser)localObject).getName().equalsIgnoreCase("random"))
      {
        i1 = Integer.parseInt(((XmlPullParser)localObject).getAttributeValue(null, "value"));
        return i1;
        if (i1 != 1) {
          switch (i1)
          {
          }
        }
      }
    }
  }
  
  public ActionGlobalData a(String paramString)
  {
    try
    {
      localObject1 = XmlPullParserFactory.newInstance();
      ((XmlPullParserFactory)localObject1).setNamespaceAware(true);
      localXmlPullParser = ((XmlPullParserFactory)localObject1).newPullParser();
      localXmlPullParser.setInput(new StringReader(paramString));
      i1 = localXmlPullParser.getEventType();
      paramString = null;
    }
    catch (Exception localException3)
    {
      try
      {
        for (;;)
        {
          Object localObject1;
          int i1 = localXmlPullParser.next();
          continue;
          try
          {
            localObject1 = new ActionGlobalData();
            paramString = (String)localObject1;
          }
          catch (Exception localException1) {}
        }
        localException1.printStackTrace();
        localObject2 = paramString;
        return localObject2;
        localObject2 = localXmlPullParser.getName();
        if (!((String)localObject2).equalsIgnoreCase("magicface")) {
          break label335;
        }
        localObject2 = localXmlPullParser.getAttributeValue(null, "isAutoPlay");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label167;
        }
        paramString.jdField_c_of_type_Boolean = Boolean.parseBoolean((String)localObject2);
        label167:
        localObject2 = localXmlPullParser.getAttributeValue(null, "action");
        if (localObject2 == null) {
          break label201;
        }
        boolean bool = Boolean.parseBoolean((String)localObject2);
        if (bool) {
          break label201;
        }
        paramString.jdField_a_of_type_Boolean = bool;
        return paramString;
        label201:
        paramString.j = localXmlPullParser.getAttributeValue(null, "useSensor");
        localObject2 = localXmlPullParser.getAttributeValue(null, "fullScreen");
        if (localObject2 == null) {
          break label241;
        }
        paramString.b = Boolean.parseBoolean((String)localObject2);
        label241:
        localObject2 = localXmlPullParser.getAttributeValue(null, "minQVer");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label267;
        }
        paramString.i = ((String)localObject2);
        label267:
        paramString.h = localXmlPullParser.getAttributeValue(null, "type");
        str = localXmlPullParser.getAttributeValue(null, "colorMask");
        if (str == null) {
          break label332;
        }
        localObject2 = str;
        if (!str.contains("0x")) {
          break label320;
        }
        localObject2 = str.substring(2);
      }
      catch (Exception localException3)
      {
        try
        {
          for (;;)
          {
            XmlPullParser localXmlPullParser;
            Object localObject2;
            String str;
            label320:
            paramString.jdField_a_of_type_Int = ((int)Long.parseLong((String)localObject2, 16));
            label332:
            continue;
            label335:
            if (((String)localObject2).equalsIgnoreCase("title"))
            {
              paramString.l = localXmlPullParser.getAttributeValue(null, "text");
            }
            else
            {
              if (((String)localObject2).equalsIgnoreCase("feekbacktext"))
              {
                localObject2 = new MagicfacebackText();
                ((MagicfacebackText)localObject2).jdField_a_of_type_JavaLangString = localXmlPullParser.getAttributeValue(null, "type");
                str = localXmlPullParser.getAttributeValue(null, "timeout");
                ((MagicfacebackText)localObject2).jdField_b_of_type_JavaLangString = str;
                if (str != null) {
                  paramString.jdField_c_of_type_Int = Integer.parseInt(str);
                }
                ((MagicfacebackText)localObject2).jdField_c_of_type_JavaLangString = localXmlPullParser.getAttributeValue(null, "text");
                paramString.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText = ((MagicfacebackText)localObject2);
                return paramString;
              }
              if ("subtitle".equalsIgnoreCase((String)localObject2))
              {
                paramString.n = localXmlPullParser.getAttributeValue(null, "text");
                continue;
                localException2 = localException2;
                paramString = null;
              }
            }
          }
          localException3 = localException3;
        }
        catch (Exception localException4)
        {
          break label332;
        }
      }
    }
    localObject1 = paramString;
    if (i1 != 1) {
      switch (i1)
      {
      }
    }
  }
  
  public List a(String paramString)
  {
    localXmlPullParser = Xml.newPullParser();
    try
    {
      localXmlPullParser.setInput(new StringReader(paramString));
      i1 = localXmlPullParser.getEventType();
      paramString = null;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        try
        {
          int i1 = localXmlPullParser.next();
          continue;
          try
          {
            ArrayList localArrayList = new ArrayList();
            paramString = localArrayList;
          }
          catch (Exception localException1) {}
          String str = paramString;
          if (QLog.isColorLevel())
          {
            QLog.d("MagicfaceActionDecoder", 2, "e=" + localException1.getMessage());
            str = paramString;
          }
          return str;
          localObject = localXmlPullParser.getName();
          if ((((String)localObject).equalsIgnoreCase("action")) || (((String)localObject).equalsIgnoreCase("ActionDef")))
          {
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction = new Action();
            paramString.add(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction);
            a(localXmlPullParser, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction);
            localObject = localXmlPullParser.getAttributeValue(null, "willDo");
            if ((localObject != null) && ("send".equalsIgnoreCase(((String)localObject).trim()))) {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.jdField_c_of_type_Boolean = true;
            }
          }
          else
          {
            if (((String)localObject).equalsIgnoreCase("process"))
            {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess = new ActionProcess();
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.d = localXmlPullParser.getAttributeValue(null, "type");
              continue;
            }
            if (((String)localObject).equalsIgnoreCase("gravity"))
            {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.e = "gravity";
              localObject = localXmlPullParser.getAttributeValue(null, "value");
              if (localObject != null) {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "stopType");
              if (localObject == null) {
                break label1280;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.f = ((String)localObject);
              break label1280;
            }
            if ("mic".equalsIgnoreCase((String)localObject))
            {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.e = "mic";
              localObject = localXmlPullParser.getAttributeValue(null, "value");
              if (localObject != null) {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "replacevalue");
              if (localObject != null) {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "stopType");
              if (localObject == null) {
                break label1283;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.f = ((String)localObject);
              break label1283;
            }
            if ("touch".equalsIgnoreCase((String)localObject))
            {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.e = "touch";
              localObject = localXmlPullParser.getAttributeValue(null, "stopType");
              if (localObject == null) {
                break label1286;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.f = ((String)localObject);
              break label1286;
            }
            if (((String)localObject).equalsIgnoreCase("value"))
            {
              localObject = new RecordCondition();
              str = localXmlPullParser.getAttributeValue(null, "min");
              if (str != null) {
                ((RecordCondition)localObject).jdField_a_of_type_Int = Integer.parseInt(str);
              }
              str = localXmlPullParser.getAttributeValue(null, "max");
              if (str != null)
              {
                ((RecordCondition)localObject).jdField_b_of_type_Int = Integer.parseInt(str);
                if (((RecordCondition)localObject).jdField_b_of_type_Int == -1) {
                  ((RecordCondition)localObject).jdField_b_of_type_Int = 2147483647;
                }
              }
              str = localXmlPullParser.getAttributeValue(null, "sum");
              if (str != null) {
                ((RecordCondition)localObject).jdField_c_of_type_Int = Integer.parseInt(str);
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_JavaUtilList.add(localObject);
              continue;
            }
            if (((String)localObject).equalsIgnoreCase("text")) {
              continue;
            }
            if ((((String)localObject).equalsIgnoreCase("playRes")) || (((String)localObject).equalsIgnoreCase("playResDef")))
            {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes = new MagicfacePlayRes();
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes);
              localObject = localXmlPullParser.getAttributeValue(null, "min");
              if (localObject != null) {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_a_of_type_Int = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "max");
              if (localObject == null) {
                break label1289;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_b_of_type_Int = Integer.parseInt((String)localObject);
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_b_of_type_Int != -1) {
                break label1289;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_b_of_type_Int = 2147483647;
              break label1289;
            }
            if (((String)localObject).equalsIgnoreCase("video"))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes == null) {
                continue;
              }
              localObject = localXmlPullParser.getAttributeValue(null, "src");
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_a_of_type_JavaLangString = ((String)localObject);
              localObject = localXmlPullParser.getAttributeValue(null, "srcAlpha");
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_b_of_type_JavaLangString = ((String)localObject);
              localObject = localXmlPullParser.getAttributeValue(null, "duration");
              if (localObject != null) {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.f = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "fps");
              if (localObject != null) {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.g = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "repeat");
              if (localObject == null) {
                break label1292;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_Int = Integer.parseInt((String)localObject);
              break label1292;
            }
            if ("sound".equalsIgnoreCase((String)localObject))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes == null) {
                continue;
              }
              localObject = localXmlPullParser.getAttributeValue(null, "src");
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_JavaLangString = ((String)localObject);
              localObject = localXmlPullParser.getAttributeValue(null, "duration");
              if (localObject != null) {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.d = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "repeat");
              if (localObject == null) {
                break label1295;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.e = Integer.parseInt((String)localObject);
              break label1295;
            }
            if ("vibrator".equalsIgnoreCase((String)localObject))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes == null) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_a_of_type_Boolean = true;
              localObject = localXmlPullParser.getAttributeValue(null, "time");
              if (localObject == null) {}
            }
          }
        }
        catch (Exception localException3)
        {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.h = Integer.parseInt((String)localObject);
            continue;
            if ("swipeGesture".equalsIgnoreCase((String)localObject))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess == null) {
                continue;
              }
              localObject = localXmlPullParser.getAttributeValue(null, "direction");
              if ("up".equalsIgnoreCase((String)localObject))
              {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 2;
                break label1298;
              }
              if ("down".equalsIgnoreCase((String)localObject))
              {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 3;
                break label1298;
              }
              if ("left".equalsIgnoreCase((String)localObject))
              {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 0;
                break label1298;
              }
              if (!"right".equalsIgnoreCase((String)localObject)) {
                break label1298;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 1;
              break label1298;
            }
            if ("dbTapGesture".equalsIgnoreCase((String)localObject))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess == null) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 5;
              continue;
            }
            if ((!"tapGesture".equalsIgnoreCase((String)localObject)) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess == null)) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 4;
            continue;
            Object localObject = localXmlPullParser.getName();
            if (((String)localObject).equalsIgnoreCase("action"))
            {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction = null;
              continue;
            }
            if (((String)localObject).equalsIgnoreCase("process"))
            {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess = null;
              continue;
            }
            if (!((String)localObject).equalsIgnoreCase("playRes")) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes = null;
            continue;
            localException2 = localException2;
            paramString = null;
            continue;
            localException3 = localException3;
          }
          catch (Exception localException4)
          {
            continue;
          }
        }
        continue;
        continue;
        continue;
        continue;
        continue;
        continue;
        continue;
      }
    }
    str = paramString;
    if (i1 != 1) {
      switch (i1)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.MagicfaceActionDecoder
 * JD-Core Version:    0.7.0.1
 */