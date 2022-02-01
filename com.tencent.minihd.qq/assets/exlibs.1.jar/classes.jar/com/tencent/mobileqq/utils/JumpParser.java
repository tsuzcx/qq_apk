package com.tencent.mobileqq.utils;

import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;

public class JumpParser
{
  public static final String A = "mqqvoipivr://";
  public static final String B = "mqqapi://dating/";
  private static final String C = "JumpAction";
  private static final int a = 0;
  public static final String a = "https://clientui.3g.qq.com/mqqapi/";
  private static final int b = 1;
  public static final String b = "mqqapi://";
  private static final int c = 0;
  public static final String c = "mqqmdpass://";
  private static final int d = 1;
  public static final String d = "https://clientui.3g.qq.com/mqq/";
  public static final String e = "mqq://";
  public static final String f = "qapp://";
  public static final String g = "https://qm.qq.com/cgi-bin/";
  public static final String h = "mqqopensdkapi://bizAgent/";
  public static final String i = "mqqflyticket://";
  public static final String j = "mqqwpa://";
  public static final String k = "mqqwpaopenid://";
  public static final String l = "wtloginmqq://";
  public static final String m = "qqwifi://";
  public static final String n = "mqqapi://readingcenter";
  public static final String o = "mqqapi://qzone/groupalbum";
  public static final String p = "mqqapi://qzone/to_publish_queue";
  public static final String q = "mqqtribe://";
  public static final String r = "mqqapi://wallet/open";
  public static final String s = "mqqapi://im/chat";
  public static final String t = "mqqapi://wallet/open?src_type=web&viewtype=0&version=1";
  public static final String u = "mqqmdpass://wallet/modify_pass";
  public static final String v = "mqqapi://qqdataline/openqqdataline";
  public static final String w = "miniqqverifycode://";
  public static final String x = "mqqapi://qlink/openqlink";
  public static final String y = "mqqconnect://";
  public static final String z = "mqq://shop/";
  
  public static JumpAction a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    String str1 = paramString;
    if (paramString.contains("videochat"))
    {
      str1 = paramString;
      if (paramString.contains("uinType=21")) {
        str1 = URLDecoder.decode(paramString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "Jump input=" + str1);
    }
    if (str1 == null) {
      return null;
    }
    if (str1.startsWith("mqqapi://qzone/to_publish_queue"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.cI = str1;
      paramQQAppInterface.cJ = "qzone";
      paramQQAppInterface.cK = "to_publish_queue";
      return paramQQAppInterface;
    }
    int i1;
    if (str1.startsWith("mqqwpaopenid://"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.cJ = "wpa";
      paramQQAppInterface.cK = "openid_to_uin";
      paramQQAppInterface.cI = str1;
      paramContext = str1.split("\\?")[1].split("&");
      i1 = 0;
      while (i1 < paramContext.length)
      {
        paramString = paramContext[i1].split("=");
        if (paramString.length == 2) {
          paramQQAppInterface.a(paramString[0], a(paramString[1], false));
        }
        i1 += 1;
      }
      return paramQQAppInterface;
    }
    if (str1.startsWith("qapp://"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.cI = str1;
      paramQQAppInterface.cJ = "qapp";
      paramQQAppInterface.cK = Uri.parse(str1).getHost();
      return paramQQAppInterface;
    }
    if (str1.startsWith("mqqapi://wallet/open"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.cI = str1;
      paramQQAppInterface.cJ = "wallet";
      paramQQAppInterface.cK = "open";
      paramContext = str1.split("\\?");
      if (paramContext.length != 2) {
        return paramQQAppInterface;
      }
      paramContext = paramContext[1].split("&");
      if (paramContext != null)
      {
        i1 = 0;
        while (i1 < paramContext.length)
        {
          paramString = paramContext[i1].split("=");
          if ((paramString != null) && (paramString.length == 2)) {
            paramQQAppInterface.a(paramString[0], paramString[1]);
          }
          i1 += 1;
        }
      }
      return paramQQAppInterface;
    }
    if (str1.startsWith("mqqmdpass://wallet/modify_pass"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.cI = str1;
      paramQQAppInterface.cJ = "wallet";
      paramQQAppInterface.cK = "modify_pass";
      paramContext = str1.split("\\?");
      if (paramContext.length != 2) {
        return paramQQAppInterface;
      }
      paramContext = paramContext[1].split("&");
      if (paramContext != null)
      {
        i1 = 0;
        while (i1 < paramContext.length)
        {
          paramString = paramContext[i1].split("=");
          if ((paramString != null) && (paramString.length == 2)) {
            paramQQAppInterface.a(paramString[0], paramString[1]);
          }
          i1 += 1;
        }
      }
      return paramQQAppInterface;
    }
    if (str1.startsWith("qqwifi://"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.cI = str1;
      paramQQAppInterface.cJ = "qqwifi";
      paramQQAppInterface.cK = "outweb_start";
      paramContext = str1.split("\\?");
      if (paramContext.length != 2) {
        return paramQQAppInterface;
      }
      paramContext = paramContext[1].split("&");
      if (paramContext != null)
      {
        i1 = 0;
        while (i1 < paramContext.length)
        {
          paramString = paramContext[i1].split("=");
          if ((paramString != null) && (paramString.length == 2)) {
            paramQQAppInterface.a(paramString[0], paramString[1]);
          }
          i1 += 1;
        }
      }
      return paramQQAppInterface;
    }
    JumpAction localJumpAction;
    Object localObject1;
    if (str1.startsWith("mqqapi://qzone/groupalbum"))
    {
      paramString = str1.split("\\?");
      if (paramString.length != 2) {
        return null;
      }
      localJumpAction = paramString[0];
      localObject1 = paramString[1];
      paramString = "";
      paramContext = new JumpAction(paramQQAppInterface, paramContext);
      if (localJumpAction.startsWith("mqqopensdkapi://bizAgent/")) {
        paramQQAppInterface = localJumpAction.substring("mqqopensdkapi://bizAgent/".length());
      }
      for (;;)
      {
        paramQQAppInterface = paramQQAppInterface.split("/");
        if (paramQQAppInterface.length == 2) {
          break;
        }
        return null;
        if (localJumpAction.startsWith("https://qm.qq.com/cgi-bin/"))
        {
          paramQQAppInterface = localJumpAction.substring("https://qm.qq.com/cgi-bin/".length());
        }
        else if (localJumpAction.startsWith("https://clientui.3g.qq.com/mqqapi/"))
        {
          paramQQAppInterface = localJumpAction.substring("https://clientui.3g.qq.com/mqqapi/".length());
        }
        else if (localJumpAction.startsWith("mqqapi://"))
        {
          paramQQAppInterface = localJumpAction.substring("mqqapi://".length());
        }
        else if (localJumpAction.startsWith("mqq://"))
        {
          paramQQAppInterface = localJumpAction.substring("mqq://".length());
        }
        else if (localJumpAction.startsWith("https://clientui.3g.qq.com/mqq/"))
        {
          paramQQAppInterface = localJumpAction.substring("https://clientui.3g.qq.com/mqq/".length());
        }
        else if (localJumpAction.startsWith("mqqflyticket://"))
        {
          paramQQAppInterface = localJumpAction.substring("mqqflyticket://".length());
        }
        else if (localJumpAction.startsWith("mqqwpa://"))
        {
          paramQQAppInterface = localJumpAction.substring("mqqwpa://".length());
        }
        else if (localJumpAction.startsWith("wtloginmqq://"))
        {
          paramQQAppInterface = localJumpAction.substring("wtloginmqq://".length());
        }
        else if (localJumpAction.startsWith("mqqtribe://"))
        {
          paramQQAppInterface = localJumpAction.substring("mqqtribe://".length());
        }
        else if (localJumpAction.startsWith("mqqvoipivr://"))
        {
          paramQQAppInterface = localJumpAction.substring("mqqvoipivr://".length());
        }
        else
        {
          paramQQAppInterface = paramString;
          if (localJumpAction.startsWith("qapp://")) {
            paramQQAppInterface = localJumpAction.substring("qapp://".length());
          }
        }
      }
      paramContext.cI = str1;
      paramContext.cJ = paramQQAppInterface[0];
      paramContext.cK = paramQQAppInterface[1];
      paramQQAppInterface = ((String)localObject1).split("&");
      i1 = 0;
      for (;;)
      {
        if (i1 < paramQQAppInterface.length)
        {
          paramString = paramQQAppInterface[i1].split("=");
          if (paramString.length == 2) {}
          try
          {
            paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
            paramContext.a(paramString[0], paramString[1]);
            i1 += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "failed to decode param value,tmps[1] is:" + paramString[0] + ",tmps[1] is:" + paramString[1], localException);
              }
            }
          }
        }
      }
      return paramContext;
    }
    boolean bool2 = localException.startsWith("mqqapi://readingcenter");
    boolean bool3 = localException.startsWith("wtloginmqq://");
    boolean bool4 = localException.startsWith("mqqwpa://");
    boolean bool5 = localException.startsWith("mqqvoipivr://");
    boolean bool6 = localException.startsWith("mqqtribe://");
    boolean bool7 = localException.startsWith("miniqqverifycode://");
    int i2;
    if ((localException.startsWith("mqqapi://im/chat")) && (localException.contains("chat_type=crm")) && (localException.contains("kfnick=")))
    {
      i1 = 1;
      if ((localException.startsWith("mqqopensdkapi://bizAgent/")) || (bool2) || (bool3) || (bool4) || (bool6) || (bool5)) {
        break label1243;
      }
      i2 = 1;
      label1200:
      localObject1 = localException;
      if (i2 == 0) {
        break label1255;
      }
      if ((bool2) || (i1 != 0)) {
        break label1249;
      }
    }
    label1243:
    label1249:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramString = a(localException, bool1);
      localObject1 = paramString;
      if (paramString != null) {
        break label1255;
      }
      return null;
      i1 = 0;
      break;
      i2 = 0;
      break label1200;
    }
    label1255:
    if ((bool2) || (bool3) || (bool4) || (bool6) || (bool7) || (bool5)) {}
    for (paramString = a((String)localObject1, "?"); paramString.length != 2; paramString = ((String)localObject1).split("\\?")) {
      return null;
    }
    Object localObject2 = paramString[0];
    paramString = paramString[1];
    if (i2 != 0) {
      if ((!bool2) && (i1 == 0))
      {
        bool1 = true;
        paramString = a(paramString, bool1);
      }
    }
    for (;;)
    {
      String str2 = "";
      localJumpAction = new JumpAction(paramQQAppInterface, paramContext);
      if (localObject2.startsWith("mqqopensdkapi://bizAgent/")) {
        paramQQAppInterface = localObject2.substring("mqqopensdkapi://bizAgent/".length());
      }
      for (;;)
      {
        paramQQAppInterface = paramQQAppInterface.split("/");
        if (paramQQAppInterface.length == 2) {
          break label1693;
        }
        return null;
        bool1 = false;
        break;
        if (localObject2.startsWith("https://qm.qq.com/cgi-bin/"))
        {
          paramQQAppInterface = localObject2.substring("https://qm.qq.com/cgi-bin/".length());
        }
        else if (localObject2.startsWith("https://clientui.3g.qq.com/mqqapi/"))
        {
          paramQQAppInterface = localObject2.substring("https://clientui.3g.qq.com/mqqapi/".length());
        }
        else if (localObject2.startsWith("mqqapi://"))
        {
          paramQQAppInterface = localObject2.substring("mqqapi://".length());
        }
        else if (localObject2.startsWith("mqq://"))
        {
          paramQQAppInterface = localObject2.substring("mqq://".length());
        }
        else if (localObject2.startsWith("https://clientui.3g.qq.com/mqq/"))
        {
          paramQQAppInterface = localObject2.substring("https://clientui.3g.qq.com/mqq/".length());
        }
        else if (localObject2.startsWith("mqqflyticket://"))
        {
          paramQQAppInterface = localObject2.substring("mqqflyticket://".length());
        }
        else if (localObject2.startsWith("mqqwpa://"))
        {
          paramQQAppInterface = localObject2.substring("mqqwpa://".length());
        }
        else if (localObject2.startsWith("wtloginmqq://"))
        {
          paramQQAppInterface = localObject2.substring("wtloginmqq://".length());
        }
        else if (localObject2.startsWith("mqqtribe://"))
        {
          paramQQAppInterface = localObject2.substring("mqqtribe://".length());
        }
        else if (localObject2.startsWith("miniqqverifycode://"))
        {
          paramQQAppInterface = localObject2.substring("miniqqverifycode://".length());
        }
        else if (localObject2.startsWith("mqqvoipivr://"))
        {
          paramQQAppInterface = localObject2.substring("mqqvoipivr://".length());
        }
        else
        {
          paramQQAppInterface = str2;
          if (localObject2.startsWith("mqqconnect://")) {
            paramQQAppInterface = localObject2.substring("mqqconnect://".length());
          }
        }
      }
      label1693:
      localJumpAction.cI = ((String)localObject1);
      localJumpAction.cJ = paramQQAppInterface[0];
      localJumpAction.cK = paramQQAppInterface[1];
      if (bool3)
      {
        paramQQAppInterface = paramString.split("&");
        if ((paramQQAppInterface == null) || (paramQQAppInterface.length != 2)) {
          break label1992;
        }
        if ((paramQQAppInterface[1] != null) && (paramQQAppInterface[1].contains("schemacallback=")))
        {
          paramContext = paramQQAppInterface[1];
          paramQQAppInterface = paramQQAppInterface[0];
          paramString = paramQQAppInterface;
          if (paramContext.length() > 0)
          {
            if (bool2) {
              break label1898;
            }
            bool1 = true;
            label1780:
            paramContext = a(a(paramContext, bool1), "=");
            paramString = paramQQAppInterface;
            if (paramContext.length == 2)
            {
              localJumpAction.a(paramContext[0], paramContext[1]);
              paramString = paramQQAppInterface;
            }
          }
        }
      }
      label1967:
      label1984:
      label1992:
      for (;;)
      {
        if ((paramString != null) && (paramString.length() > 0)) {
          if (bool2) {
            break label1904;
          }
        }
        label1898:
        label1904:
        for (bool1 = true;; bool1 = false)
        {
          paramQQAppInterface = a(paramString, bool1);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = a(paramQQAppInterface, "=");
            if (paramQQAppInterface.length == 2) {
              localJumpAction.a(paramQQAppInterface[0], paramQQAppInterface[1]);
            }
          }
          return localJumpAction;
          if ((paramQQAppInterface[0] == null) || (!paramQQAppInterface[0].contains("schemacallback="))) {
            break label1984;
          }
          paramContext = paramQQAppInterface[0];
          paramQQAppInterface = paramQQAppInterface[1];
          break;
          bool1 = false;
          break label1780;
        }
        paramQQAppInterface = paramString.split("&");
        i1 = 0;
        if (i1 < paramQQAppInterface.length)
        {
          paramContext = a(paramQQAppInterface[i1], "=");
          if (paramContext.length == 2)
          {
            if (!bool4) {
              break label1967;
            }
            localJumpAction.a(paramContext[0], a(paramContext[1], false));
          }
          for (;;)
          {
            i1 += 1;
            break;
            localJumpAction.a(paramContext[0], paramContext[1]);
          }
        }
        return localJumpAction;
        paramQQAppInterface = paramString;
        paramContext = "";
        break;
      }
    }
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = null;
    try
    {
      String str2 = URLDecoder.decode(paramString);
      str1 = str2;
      if (paramBoolean)
      {
        localObject1 = str2;
        str1 = str2.replaceAll(" ", "+");
      }
    }
    catch (Exception localException)
    {
      do
      {
        String str1;
        Object localObject2 = localObject1;
      } while (!QLog.isColorLevel());
      QLog.d("JumpAction", 2, "JumpParser parser Exception =" + paramString);
    }
    return str1;
    return localObject1;
  }
  
  public static String[] a(String paramString1, String paramString2)
  {
    int i1 = paramString1.indexOf(paramString2);
    if (i1 == -1) {
      return new String[] { paramString1 };
    }
    return new String[] { paramString1.substring(0, i1), paramString1.substring(i1 + paramString2.length(), paramString1.length()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpParser
 * JD-Core Version:    0.7.0.1
 */