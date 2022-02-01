package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ihe;
import ihf;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class PicEmoticonInfo
  extends EmoticonInfo
{
  static Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  public static final int b = 0;
  static Bitmap jdField_b_of_type_AndroidGraphicsBitmap = null;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  private static final String i = "PicEmoticonInfo";
  public int a;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  public Emoticon a;
  public boolean a;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  public boolean b;
  public int h = 0;
  public int i = 0;
  public int j;
  private String j;
  
  public PicEmoticonInfo(String paramString)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_j_of_type_JavaLangString = paramString;
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)) {}
    try
    {
      if ((jdField_a_of_type_AndroidGraphicsBitmap == null) || (jdField_b_of_type_AndroidGraphicsBitmap == null))
      {
        paramString = BaseApplication.getContext().getResources();
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = 1;
        localOptions.inDensity = 320;
        localOptions.inTargetDensity = 160;
        if (jdField_a_of_type_AndroidGraphicsBitmap == null) {
          jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramString, 2130840720, localOptions);
        }
        if (jdField_b_of_type_AndroidGraphicsBitmap == null) {
          jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramString, 2130840720, localOptions);
        }
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(jdField_b_of_type_AndroidGraphicsBitmap);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PicEmoticonInfo", 2, paramString.getMessage());
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PicEmoticonInfo", 2, paramString.getMessage());
    }
  }
  
  private Drawable a(Context paramContext)
  {
    paramContext = null;
    if (c()) {
      paramContext = a();
    }
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    }
    return localObject;
  }
  
  public static String a(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    return paramEmoticon.epId + "_" + paramEmoticon.eId;
  }
  
  public static void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      Object localObject = paramURLDrawable.getCurrDrawable();
      if ((localObject != null) && ((localObject instanceof GifDrawable)))
      {
        localObject = ((GifDrawable)localObject).getImage();
        if ((localObject != null) && ((localObject instanceof VoiceGifImage)))
        {
          ((VoiceGifImage)localObject).b();
          ((VoiceGifImage)localObject).a();
          paramURLDrawable.invalidateSelf();
          if (QLog.isColorLevel()) {
            QLog.d("PicEmoticonInfo", 2, "soundgif startSoundDrawablePlay start");
          }
        }
      }
    }
  }
  
  public static void b(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      if ((paramURLDrawable != null) && ((paramURLDrawable instanceof GifDrawable)))
      {
        paramURLDrawable = ((GifDrawable)paramURLDrawable).getImage();
        if ((paramURLDrawable != null) && ((paramURLDrawable instanceof VoiceGifImage)))
        {
          ((VoiceGifImage)paramURLDrawable).b();
          if (QLog.isColorLevel()) {
            QLog.d("PicEmoticonInfo", 2, "soundgif stopSoundDrawablePlay stop");
          }
        }
      }
    }
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
      try
      {
        paramContext = new URL("emotion_pic", "panel_preview", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        paramContext = URLDrawable.getDrawable(paramContext, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, false);
        paramContext.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        paramContext.addHeader("my_uin", this.jdField_j_of_type_JavaLangString);
        paramContext.addHeader("emo_tasks", Integer.toString(2));
        return paramContext;
      }
      catch (MalformedURLException paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PicEmoticonInfo", 2, "getDrawable ,", paramContext);
          }
          paramContext = null;
        }
      }
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public URLDrawable a()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
    for (;;)
    {
      return localObject1;
      String str = EmosmUtils.getEmoticonAIOPreviewPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      if (str == null) {
        continue;
      }
      try
      {
        localObject1 = new URL("emotion_pic", "aio_preview", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        URLDrawable localURLDrawable = URLDrawable.getDrawable((URL)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, false);
        localObject1 = localURLDrawable;
        if (localURLDrawable.getStatus() == 1) {
          continue;
        }
        localURLDrawable.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        localURLDrawable.addHeader("my_uin", this.jdField_j_of_type_JavaLangString);
        localObject1 = localURLDrawable;
        if (!FileUtil.a(str)) {
          continue;
        }
        try
        {
          localURLDrawable.downloadImediatly();
          return localURLDrawable;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Object localObject2 = localURLDrawable;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PicEmoticonInfo", 2, "getBigDrawable oom,drawableID=" + this.d);
        return localURLDrawable;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localMalformedURLException.printStackTrace();
          Object localObject3 = null;
        }
      }
    }
  }
  
  public URLDrawable a(Context paramContext, float paramFloat)
  {
    if (a()) {
      return b();
    }
    return a(true);
  }
  
  public URLDrawable a(boolean paramBoolean)
  {
    int k = 4;
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
      return null;
    }
    Object localObject3 = BaseApplication.getContext();
    int m = NetworkUtil.a((Context)localObject3);
    Object localObject1;
    if ((m == 1) || (m == 3) || (m == 4) || (this.jdField_j_of_type_Int == 2) || (paramBoolean))
    {
      localObject1 = "big_img";
      if (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound) {
        break label404;
      }
      k = 12;
      localObject1 = "big_sound";
    }
    label385:
    label401:
    label404:
    for (paramBoolean = false;; paramBoolean = true)
    {
      String str = Integer.toString(k);
      boolean bool1 = paramBoolean;
      try
      {
        for (;;)
        {
          localObject1 = new URL("emotion_pic", (String)localObject1, a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
          boolean bool3 = b();
          paramBoolean = bool2;
          if (c())
          {
            paramBoolean = bool2;
            if (!bool3) {
              paramBoolean = true;
            }
          }
          if (2 != this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType) {
            break label401;
          }
          paramBoolean = c();
          if (!paramBoolean) {
            break;
          }
          localDrawable = a((Context)localObject3);
          localObject3 = localDrawable;
          if ((this.h == 0) || (this.i == 0)) {
            break label385;
          }
          localObject1 = URLDrawable.getDrawable((URL)localObject1, this.h, this.i, (Drawable)localObject3, localDrawable, bool1);
          if (((URLDrawable)localObject1).getStatus() != 1)
          {
            ((URLDrawable)localObject1).setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
            ((URLDrawable)localObject1).addHeader("my_uin", this.jdField_j_of_type_JavaLangString);
            ((URLDrawable)localObject1).addHeader("emo_tasks", str);
            ((URLDrawable)localObject1).addHeader("image_dl_extra_info", Boolean.toString(paramBoolean));
            if (QLog.isColorLevel()) {
              QLog.d("PicEmoticonInfo", 2, "b.getStatus=" + ((URLDrawable)localObject1).getStatus() + " isBigImageExist=" + bool3 + " e.epId=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + " e.eId=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
            }
          }
          return localObject1;
          str = Integer.toString(1);
          localObject1 = "aio_preview";
          bool1 = true;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PicEmoticonInfo", 2, "getDrawable ,", localMalformedURLException);
          }
          Object localObject2 = null;
          continue;
          localObject3 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
          continue;
          localObject2 = URLDrawable.getDrawable((URL)localObject2, (Drawable)localObject3, localDrawable, bool1);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 2) || (!(paramContext instanceof ChatActivity))) {
        break label288;
      }
      paramEditText = ((EmoticonManager)paramQQAppInterface.getManager(13)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "MbFasong", "MbIDDianji", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, "", "", "");
      if (((paramEditText != null) && ((2 != paramEditText.status) || (!paramEditText.valid))) || (this.jdField_a_of_type_Boolean))
      {
        EmojiHomeUiPlugin.openEmojiDetailPage(((ChatActivity)paramContext).getActivity(), paramQQAppInterface.getAccount(), 8, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, paramQQAppInterface.getSid(), false);
        return;
      }
      localObject = (EmojiManager)paramQQAppInterface.getManager(42);
      if (!((EmojiManager)localObject).a()) {
        break label461;
      }
      if (((EmojiManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, Boolean.valueOf(false))) {
        break;
      }
      ChatActivityUtils.a(paramContext, 2131368648, 0);
      paramQQAppInterface = paramQQAppInterface.a(ChatActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.obtainMessage(10).sendToTarget();
    paramQQAppInterface.obtainMessage(21).sendToTarget();
    return;
    Object localObject = MagicfaceActionManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 0);
    if ((localObject != null) && (((ActionGlobalData)localObject).jdField_a_of_type_Boolean))
    {
      if (MagicfaceViewController.a())
      {
        ((ChatActivity)paramContext).a().a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 0, null, false);
        ((ChatActivity)paramContext).a().a().a(this);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue = "value=1";
      label288:
      ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      return;
    }
    int m = PngFrameUtil.a(MagicfaceActionManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 0));
    int k = 0;
    if (paramEditText != null) {
      k = paramEditText.rscType;
    }
    paramEditText = "rscType?" + k + ";value=" + m;
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue = paramEditText;
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "before play,magicvalue:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue);
    }
    if ((localObject != null) && (!((ActionGlobalData)localObject).c))
    {
      ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      return;
    }
    ((ChatActivity)paramContext).a().a().a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, new ihf(this, paramEditText, paramQQAppInterface, paramContext, paramSessionInfo));
    return;
    label461:
    ChatActivityUtils.a(paramContext, 2131368647);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 2) || (!paramBoolean) || (!(paramContext instanceof ChatActivity))) {
        break label337;
      }
      if (((EmojiManager)paramQQAppInterface.getManager(42)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, Boolean.valueOf(false))) {
        break;
      }
      ChatActivityUtils.a(paramContext, 2131368648, 0);
      paramQQAppInterface = paramQQAppInterface.a(ChatActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.obtainMessage(10).sendToTarget();
    paramQQAppInterface.obtainMessage(21).sendToTarget();
    return;
    int k = MagicfaceActionManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 0);
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "forward,【maxInt:】" + k);
    }
    k = PngFrameUtil.a(k);
    paramEditText = ((EmoticonManager)paramQQAppInterface.getManager(13)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
    int m = PngFrameUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue);
    if (-1 != m)
    {
      paramEditText.rscType = m;
      ((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramEditText);
    }
    paramEditText = "rscType?" + m + ";value=" + k;
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue = paramEditText;
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "before play,magicvalue:" + paramEditText);
    }
    if (!MagicfaceActionManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 0).c)
    {
      ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      return;
    }
    ((ChatActivity)paramContext).a().a().a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, new ihe(this, paramEditText, paramQQAppInterface, paramContext, paramSessionInfo));
    return;
    label337:
    ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound);
  }
  
  public URLDrawable b()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
    for (;;)
    {
      return localObject1;
      String str = Integer.toString(12);
      try
      {
        localObject1 = new URL("emotion_pic", "big_sound", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        URLDrawable localURLDrawable = URLDrawable.getDrawable((URL)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, true);
        localObject1 = localURLDrawable;
        if (localURLDrawable.getStatus() == 1) {
          continue;
        }
        localURLDrawable.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        localURLDrawable.addHeader("my_uin", this.jdField_j_of_type_JavaLangString);
        localURLDrawable.addHeader("emo_tasks", str);
        return localURLDrawable;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PicEmoticonInfo", 2, "getDrawable ,", localMalformedURLException);
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
      return false;
    }
    Object localObject;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 1)
    {
      localObject = EmosmUtils.getQFaceGifPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      if (localObject == null) {
        break label198;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {
        break label176;
      }
      bool1 = true;
    }
    for (;;)
    {
      label75:
      int k;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound) && (bool1))
      {
        localObject = EmosmUtils.getEmoticonSoundPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
        if (localObject == null) {
          break label193;
        }
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
          k = 1;
        }
      }
      for (;;)
      {
        label142:
        if ((bool1) && (k != 0)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          return bool1;
          localObject = EmosmUtils.getEmoticonEncryptPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
          break;
          label176:
          bool1 = false;
          break label75;
          k = 0;
          break label142;
        }
        return bool1;
        label193:
        k = 0;
      }
      label198:
      bool1 = false;
    }
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
      return false;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 1)
    {
      localObject = EmosmUtils.getEmoticonPreviewPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      label40:
      if (localObject == null) {
        break label88;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {
        break label90;
      }
    }
    for (;;)
    {
      return bool;
      localObject = EmosmUtils.getEmoticonAIOPreviewPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      break label40;
      label88:
      break;
      label90:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */