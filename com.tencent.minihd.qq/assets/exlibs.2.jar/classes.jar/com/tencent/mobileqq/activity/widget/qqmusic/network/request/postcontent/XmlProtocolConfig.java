package com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.widget.qqmusic.QQMusicHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.business.session.SessionManager;
import com.tencent.mobileqq.activity.widget.qqmusic.data.Session;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MusicUtil;

public class XmlProtocolConfig
{
  public static final String a = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    localStringBuffer.append("<root>");
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuffer.append("<cid>");
      localStringBuffer.append(paramString2);
      localStringBuffer.append("</cid>");
    }
    paramString2 = SessionManager.a().a();
    if (paramString2 != null)
    {
      if (paramString2.b() != null)
      {
        localStringBuffer.append("<uid>");
        localStringBuffer.append(paramString2.b());
        localStringBuffer.append("</uid>");
      }
      if (paramString2.c() != null)
      {
        localStringBuffer.append("<sid>");
        localStringBuffer.append(paramString2.c());
        localStringBuffer.append("</sid>");
      }
      if (paramString2.d() != null)
      {
        localStringBuffer.append("<OpenUDID2>");
        localStringBuffer.append(paramString2.d());
        localStringBuffer.append("</OpenUDID2>");
      }
    }
    localStringBuffer.append("<udid>");
    localStringBuffer.append(MusicUtil.b(paramContext));
    localStringBuffer.append("</udid>");
    localStringBuffer.append("<OpenUDID>");
    localStringBuffer.append(MusicUtil.b(paramContext));
    localStringBuffer.append("</OpenUDID>");
    localStringBuffer.append("<v>");
    localStringBuffer.append(4070003);
    localStringBuffer.append("</v>");
    localStringBuffer.append("<cv>");
    localStringBuffer.append(4070003);
    localStringBuffer.append("</cv>");
    localStringBuffer.append("<ct>");
    localStringBuffer.append(3);
    localStringBuffer.append("</ct>");
    localStringBuffer.append("<os_ver>");
    localStringBuffer.append(Build.VERSION.RELEASE);
    localStringBuffer.append("</os_ver>");
    localStringBuffer.append("<phonetype>");
    localStringBuffer.append(MusicUtil.a(Build.MODEL));
    localStringBuffer.append("</phonetype>");
    localStringBuffer.append("<chid>");
    localStringBuffer.append("10014292");
    localStringBuffer.append("</chid>");
    localStringBuffer.append("<mcc>");
    paramString2 = MusicUtil.d(paramContext);
    if (paramString2 != null)
    {
      localStringBuffer.append(paramString2);
      localStringBuffer.append("</mcc>");
      localStringBuffer.append("<mnc>");
      paramContext = MusicUtil.e(paramContext);
      if (paramContext == null) {
        break label526;
      }
    }
    for (;;)
    {
      localStringBuffer.append(paramContext);
      localStringBuffer.append("</mnc>");
      long l = QQMusicHelper.a();
      paramContext = QQMusicHelper.a();
      if (l > 9999L)
      {
        localStringBuffer.append("<qq>");
        localStringBuffer.append(l);
        localStringBuffer.append("</qq>");
      }
      if (paramContext != null)
      {
        localStringBuffer.append("<authst>");
        localStringBuffer.append(paramContext);
        localStringBuffer.append("</authst>");
      }
      if (paramString1 != null) {
        localStringBuffer.append(paramString1);
      }
      localStringBuffer.append("</root>");
      return localStringBuffer.toString();
      paramString2 = "";
      break;
      label526:
      paramContext = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.XmlProtocolConfig
 * JD-Core Version:    0.7.0.1
 */