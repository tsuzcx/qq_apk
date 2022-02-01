package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTimer;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class TestStructMsg
{
  private static final String a = TestStructMsg.class.getSimpleName();
  
  public static AbsStructMsg a(int paramInt)
  {
    return a(1, true, paramInt);
  }
  
  public static AbsStructMsg a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    StructMsgForGeneralShare localStructMsgForGeneralShare = new StructMsgForGeneralShare();
    localStructMsgForGeneralShare.fwFlag = 0;
    localStructMsgForGeneralShare.mFlag = 3;
    localStructMsgForGeneralShare.mMsgTemplateID = 1;
    localStructMsgForGeneralShare.mMsgServiceID = paramInt1;
    localStructMsgForGeneralShare.mMsgBrief = " 的分享";
    localStructMsgForGeneralShare.mMsgAction = "web";
    localStructMsgForGeneralShare.mMsgActionData = "";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "https://gamecenter.qq.com/gcjump?appid=100692648&pf=invite&plat=qq";
    Object localObject;
    if (paramInt2 < 10)
    {
      localObject = StructMsgElementFactory.a(2, 3);
      ((AbsStructMsgItem)localObject).a(new StructMsgItemCover("https://url.cn/NAxhL2"));
      ((AbsStructMsgItem)localObject).a(new StructMsgItemTitle("天天酷跑1"));
      ((AbsStructMsgItem)localObject).a(new StructMsgItemTimer("后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入>>", "游戏已开始", MessageCache.a(), paramInt2, 0));
      ((AbsStructMsgItem)localObject).c = "web";
      ((AbsStructMsgItem)localObject).b = "https://www.qq.com";
      localStructMsgForGeneralShare.addItem((AbsStructMsgElement)localObject);
      localObject = StructMsgElementFactory.a(2, 3);
      ((AbsStructMsgItem)localObject).a(new StructMsgItemCover("https://url.cn/NAxhL2"));
      ((AbsStructMsgItem)localObject).a(new StructMsgItemTitle("天天酷跑2"));
      ((AbsStructMsgItem)localObject).a(new StructMsgItemTimer("后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入>>", "游戏已开始", MessageCache.a(), paramInt2, 0));
      ((AbsStructMsgItem)localObject).c = "web";
      ((AbsStructMsgItem)localObject).b = "http://www.google.com";
      localStructMsgForGeneralShare.addItem((AbsStructMsgElement)localObject);
      localObject = StructMsgElementFactory.a(2, 3);
      ((AbsStructMsgItem)localObject).a(new StructMsgItemCover("https://url.cn/NAxhL2"));
      ((AbsStructMsgItem)localObject).a(new StructMsgItemTitle("天天酷跑3"));
      ((AbsStructMsgItem)localObject).a(new StructMsgItemTimer("后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入>>", "游戏已开始", MessageCache.a(), paramInt2, 0));
      ((AbsStructMsgItem)localObject).c = "web";
      ((AbsStructMsgItem)localObject).b = "http://www.bing.com";
      localStructMsgForGeneralShare.addItem((AbsStructMsgElement)localObject);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localStructMsgForGeneralShare.mHasSource = paramBoolean;
        localStructMsgForGeneralShare.mSourceName = "天天酷跑天天酷跑天天酷跑天天酷跑天天酷跑天天酷跑天天酷跑天天酷跑";
        localStructMsgForGeneralShare.mSource_A_ActionData = "com.tencent.pao";
        localStructMsgForGeneralShare.mSource_I_ActionData = "tencent100692648://";
        localStructMsgForGeneralShare.mSourceAction = "app";
        localStructMsgForGeneralShare.mSourceAppid = 100692648L;
        localStructMsgForGeneralShare.mSourceUrl = "https://web.p.qq.com/qqmpmobile/aio/app.html?id=100692648";
        localStructMsgForGeneralShare.mSourceIcon = "https://qzonestyle.gtimg.cn/ac/qzone/applogo/64/648/100692648_64.gif";
        localStructMsgForGeneralShare.uniseq = 0L;
      }
      return localStructMsgForGeneralShare;
      localObject = new ArrayList();
      ((ArrayList)localObject).add(new StructMsgItemCover("https://url.cn/NAxhL2"));
      ((ArrayList)localObject).add(new StructMsgItemTitle("天天酷跑"));
      ((ArrayList)localObject).add(new StructMsgItemTimer("后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入>>", "游戏已开始", MessageCache.a(), paramInt2, 0));
      localStructMsgForGeneralShare.addItem(StructMsgElementFactory.a(2, (Collection)localObject));
    }
  }
  
  public static AbsStructMsg a(String paramString)
  {
    paramString = new ByteArrayInputStream(paramString.getBytes());
    StructMsgParserHandler localStructMsgParserHandler = new StructMsgParserHandler();
    SAXParserFactory localSAXParserFactory = SAXParserFactory.newInstance();
    try
    {
      localSAXParserFactory.newSAXParser().parse(paramString, localStructMsgParserHandler);
      paramString.close();
      paramString = localStructMsgParserHandler.a();
      return paramString;
    }
    catch (ParserConfigurationException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, "getStructMsgFromXmlBuffByStream", paramString);
      }
      return null;
    }
    catch (SAXException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 2, "getStructMsgFromXmlBuffByStream", paramString);
        }
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 2, "getStructMsgFromXmlBuffByStream", paramString);
        }
      }
    }
  }
  
  public static StructMsgForGeneralShare a(String paramString1, String paramString2)
  {
    StructMsgForGeneralShare localStructMsgForGeneralShare = new StructMsgForGeneralShare();
    localStructMsgForGeneralShare.fwFlag = 0;
    localStructMsgForGeneralShare.mFlag = 3;
    localStructMsgForGeneralShare.mMsgTemplateID = 1;
    localStructMsgForGeneralShare.mMsgServiceID = 1;
    localStructMsgForGeneralShare.mMsgBrief = " 的分享";
    localStructMsgForGeneralShare.mMsgAction = "web";
    localStructMsgForGeneralShare.mMsgActionData = "";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "https://www.baidu.com";
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2, 1);
    localAbsStructMsgItem.a(new StructMsgItemCover("https://url.cn/NAxhL2"));
    localAbsStructMsgItem.a(new StructMsgItemTitle(paramString1));
    localAbsStructMsgItem.a(new StructMsgItemSummary(paramString2));
    localAbsStructMsgItem.c = "web";
    localAbsStructMsgItem.b = "https://www.qq.com";
    localStructMsgForGeneralShare.addItem(localAbsStructMsgItem);
    return localStructMsgForGeneralShare;
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = new FileInputStream(paramString);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramString.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramString = new String(localByteArrayOutputStream.toByteArray(), "utf-8");
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return "";
    }
    return paramString;
  }
  
  public static List a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a("后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入>>"));
    localArrayList.add(a("后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏始游戏后开始游戏后开始游戏后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进3333333入萌的小泡泡，不捏它捏谁，点击进3333333入萌的小泡泡，不捏它捏谁，点击进3333333入>>"));
    localArrayList.add(a("后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入>>"));
    localArrayList.add(a("后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入又贱又萌的小泡泡，不捏它捏谁，点击进入又贱又萌的小泡泡，不捏它捏谁，点击进入又贱又萌的小泡泡，不捏它捏谁，点击进入又贱又萌的小泡泡，不捏它捏谁，点击进入>>"));
    localArrayList.add(a("后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入>>"));
    return localArrayList;
  }
  
  public static AbsStructMsg b(int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    StructMsgForGeneralShare localStructMsgForGeneralShare = new StructMsgForGeneralShare();
    localStructMsgForGeneralShare.fwFlag = 0;
    localStructMsgForGeneralShare.mMsgTemplateID = 1;
    localStructMsgForGeneralShare.mMsgServiceID = 1;
    localStructMsgForGeneralShare.mMsgBrief = "上传3张照片到《专辑封面》";
    localStructMsgForGeneralShare.mMsgAction = "plugin";
    localStructMsgForGeneralShare.mMsgActionData = "";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    if (paramInt == 1)
    {
      localAbsStructMsgItem1 = StructMsgElementFactory.a(2);
      localAbsStructMsgItem1.a(new StructMsgItemCover("https://url.cn/NAxhL2"));
      localAbsStructMsgItem1.a(new StructMsgItemTitle("上传1张照片到《专辑封面》"));
      localAbsStructMsgItem1.a(new StructMsgItemSummary("游览西冲"));
      localStructMsgForGeneralShare.addItem(localAbsStructMsgItem1);
      return localStructMsgForGeneralShare;
    }
    AbsStructMsgItem localAbsStructMsgItem1 = StructMsgElementFactory.a(3);
    if (paramInt == 2)
    {
      localAbsStructMsgItem1.a(new StructMsgItemCover("https://imgs.soufun.com/house/2013_06/17/sz/1371454628500_000.jpg"));
      localAbsStructMsgItem1.a(new StructMsgItemCover("https://imgs.soufun.com/house/2013_06/17/sz/1371453678695_000.jpg"));
    }
    for (;;)
    {
      AbsStructMsgItem localAbsStructMsgItem2 = StructMsgElementFactory.a(0);
      localAbsStructMsgItem2.a(new StructMsgItemTitle("上传3张照片到《专辑封面》"));
      localStructMsgForGeneralShare.addItem(localAbsStructMsgItem1);
      localStructMsgForGeneralShare.addItem(localAbsStructMsgItem2);
      return localStructMsgForGeneralShare;
      localAbsStructMsgItem1.a(new StructMsgItemCover("https://imgs.soufun.com/house/2012_07/04/sz/1341380854786_000.jpg"));
      localAbsStructMsgItem1.a(new StructMsgItemCover("https://imgs.soufun.com/house/2013_06/17/sz/1371454628500_000.jpg"));
      localAbsStructMsgItem1.a(new StructMsgItemCover("https://imgs.soufun.com/house/2013_06/17/sz/1371453678695_000.jpg"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.TestStructMsg
 * JD-Core Version:    0.7.0.1
 */