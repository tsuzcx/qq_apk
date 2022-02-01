package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemImage
  extends AbsStructMsgElement
{
  public MessageForPic a;
  public StructMsgForImageShare a;
  public URL a;
  public long c = 0L;
  public long d = 0L;
  public long e;
  public String j = null;
  public String k;
  public String l;
  
  public StructMsgItemImage()
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = null;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = null;
    this.jdField_a_of_type_JavaNetURL = null;
    this.jdField_a_of_type_JavaLangString = "image";
  }
  
  public StructMsgItemImage(String paramString)
  {
    this();
    this.j = paramString;
  }
  
  public View a(Context paramContext, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      localObject1 = URLDrawableHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 65537);
      if ((this.jdField_a_of_type_JavaNetURL != null) && (this.jdField_a_of_type_JavaNetURL.equals(localObject1))) {}
    }
    for (Object localObject1 = PicItemBuilder.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        MessageForPic localMessageForPic = new MessageForPic();
        localMessageForPic.path = this.j;
        localMessageForPic.uuid = this.k;
        localMessageForPic.md5 = this.l;
        localMessageForPic.istroop = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uinType;
        localMessageForPic.msgtype = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mMsgType;
        localMessageForPic.versionCode = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.messageVersion;
        localMessageForPic.uniseq = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mUniseq;
        localMessageForPic.issend = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend;
        localMessageForPic.selfuin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
        localMessageForPic.frienduin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
        localMessageForPic.groupFileID = this.c;
        localMessageForPic.busiType = 1030;
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend == 1)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
          localMessageForPic.senderuin = ((String)localObject1);
          localMessageForPic.size = this.d;
          localMessageForPic.time = this.e;
          localMessageForPic.subVersion = 5;
          localMessageForPic.fileSizeFlag = 0;
          localObject1 = AbsDownloader.a(URLDrawableHelper.a(localMessageForPic, 1, null).toString());
          if ((localObject1 != null) && (GifDrawable.isGifFile((File)localObject1))) {
            localMessageForPic.imageType = 3;
          }
          localObject2 = PicItemBuilder.a(paramContext, localMessageForPic);
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = localMessageForPic;
          this.jdField_a_of_type_JavaNetURL = ((URLDrawable)localObject2).getURL();
        }
      }
      else
      {
        if ((paramView == null) || (!(paramView instanceof ChatThumbView))) {
          break label343;
        }
      }
      for (paramContext = (ChatThumbView)paramView;; paramContext = paramView)
      {
        paramContext.setImageDrawable((Drawable)localObject2);
        return paramContext;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
        break;
        label343:
        paramView = new ChatThumbView(paramContext);
        paramView.setAdjustViewBounds(true);
        float f = paramContext.getResources().getDisplayMetrics().density;
        paramView.setMaxWidth((int)(URLDrawableHelper.f * f + 0.5F));
        paramView.setMaxHeight((int)(f * URLDrawableHelper.f + 0.5F));
      }
    }
  }
  
  public View a(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    return a(paramContext, paramView, null);
  }
  
  public MessageForPic a()
  {
    MessageForPic localMessageForPic = new MessageForPic();
    localMessageForPic.path = this.j;
    localMessageForPic.uuid = this.k;
    localMessageForPic.md5 = this.l;
    localMessageForPic.istroop = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uinType;
    localMessageForPic.msgtype = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mMsgType;
    localMessageForPic.versionCode = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.messageVersion;
    localMessageForPic.uniseq = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mUniseq;
    localMessageForPic.issend = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend;
    localMessageForPic.selfuin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
    localMessageForPic.frienduin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
    localMessageForPic.groupFileID = this.c;
    localMessageForPic.busiType = 1030;
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend == 1) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;; str = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin)
    {
      localMessageForPic.senderuin = str;
      localMessageForPic.size = this.d;
      localMessageForPic.time = this.e;
      localMessageForPic.subVersion = 5;
      localMessageForPic.fileSizeFlag = 0;
      return localMessageForPic;
    }
  }
  
  public String a()
  {
    return "Image";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.j = paramObjectInput.readUTF();
    this.k = paramObjectInput.readUTF();
    this.l = paramObjectInput.readUTF();
    this.c = paramObjectInput.readLong();
    this.d = paramObjectInput.readLong();
    this.e = paramObjectInput.readLong();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.j == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.k != null) {
        break label95;
      }
      str = "";
      label32:
      paramObjectOutput.writeUTF(str);
      if (this.l != null) {
        break label103;
      }
    }
    label95:
    label103:
    for (String str = "";; str = this.l)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.c);
      paramObjectOutput.writeLong(this.d);
      paramObjectOutput.writeLong(this.e);
      return;
      str = this.j;
      break;
      str = this.k;
      break label32;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "image");
    if (this.k == null)
    {
      str = "";
      paramXmlSerializer.attribute(null, "uuid", str);
      if (this.l != null) {
        break label129;
      }
      str = "";
      label41:
      paramXmlSerializer.attribute(null, "md5", str);
      paramXmlSerializer.attribute(null, "GroupFiledid", String.valueOf(this.c));
      paramXmlSerializer.attribute(null, "filesize", String.valueOf(this.d));
      if (this.j != null) {
        break label137;
      }
    }
    label129:
    label137:
    for (String str = "";; str = this.j)
    {
      paramXmlSerializer.attribute(null, "local_path", str);
      paramXmlSerializer.endTag(null, "image");
      return;
      str = this.k;
      break;
      str = this.l;
      break label41;
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    for (;;)
    {
      return true;
      String str3 = paramStructMsgNode.a("uuid");
      String str2 = paramStructMsgNode.a("md5");
      String str5 = paramStructMsgNode.a("md5");
      String str4 = paramStructMsgNode.a("filesize");
      String str1 = paramStructMsgNode.a("local_path");
      paramStructMsgNode = str3;
      if (str3 == null) {
        paramStructMsgNode = "";
      }
      this.k = paramStructMsgNode;
      if (str2 == null)
      {
        paramStructMsgNode = "";
        label69:
        this.l = paramStructMsgNode;
        if (str1 != null) {
          break label141;
        }
        paramStructMsgNode = "";
        this.j = paramStructMsgNode;
        if (str5 == null) {}
      }
      try
      {
        this.c = Long.parseLong(str5);
        if (str4 == null) {
          continue;
        }
        try
        {
          this.d = Long.parseLong(str4);
          return true;
        }
        catch (NumberFormatException paramStructMsgNode) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StructMsg", 2, paramStructMsgNode.getMessage());
        return true;
        paramStructMsgNode = str2;
        break label69;
        label141:
        paramStructMsgNode = str1;
      }
      catch (NumberFormatException paramStructMsgNode)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, paramStructMsgNode.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemImage
 * JD-Core Version:    0.7.0.1
 */