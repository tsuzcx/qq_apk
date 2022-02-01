package com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.widget.qqmusic.QQMusicHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.XmlStringBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class FolderXmlBody
{
  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    XmlStringBuilder localXmlStringBuilder = new XmlStringBuilder();
    Object localObject1 = QQMusicHelper.a();
    if (BaseActivity.sTopActivity != null)
    {
      localObject2 = BaseActivity.sTopActivity.app.getSid();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "12345678913459784465487989";
      }
    }
    localXmlStringBuilder.a("cid", "114");
    localXmlStringBuilder.a("json", "1");
    if (!TextUtils.isEmpty(QQMusicHelper.b()))
    {
      localXmlStringBuilder.a("wtid", "1");
      localXmlStringBuilder.a("a2", QQMusicHelper.b());
    }
    if (localObject1 != null) {
      localXmlStringBuilder.a("auth", (String)localObject1);
    }
    Object localObject2 = new XmlStringBuilder();
    ((XmlStringBuilder)localObject2).a("auth", (String)localObject1);
    ((XmlStringBuilder)localObject2).a("reqtype", "4");
    ((XmlStringBuilder)localObject2).a("getSelfDirs", paramInt1 + "");
    ((XmlStringBuilder)localObject2).a("getOrderDirs", paramInt2 + "");
    ((XmlStringBuilder)localObject2).a("getOrderAlbums", paramInt3 + "");
    ((XmlStringBuilder)localObject2).a("qq", QQMusicHelper.a() + "");
    ((XmlStringBuilder)localObject2).a("dc", "0");
    localXmlStringBuilder.a("favor", ((XmlStringBuilder)localObject2).toString());
    if (paramString != null) {
      localXmlStringBuilder.a(paramString);
    }
    return XmlProtocolConfig.a(paramContext, localXmlStringBuilder.toString(), "114");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.FolderXmlBody
 * JD-Core Version:    0.7.0.1
 */