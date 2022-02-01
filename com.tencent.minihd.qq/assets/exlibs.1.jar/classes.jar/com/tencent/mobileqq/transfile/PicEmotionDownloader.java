package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.VoiceGifImage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import org.apache.http.Header;

public class PicEmotionDownloader
  extends AbsDownloader
  implements EmotionConstants
{
  private static final String h = "PicEmotionDownloader";
  private BitmapFactory.Options a;
  protected BaseApplicationImpl a;
  
  public PicEmotionDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = paramBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inScreenDensity = paramBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    int i;
    if (paramDownloadParams != null) {
      if (QLog.isColorLevel())
      {
        paramOutputStream = new StringBuilder().append("downloadImage|useGifAnimation=").append(paramDownloadParams.useGifAnimation).append(" headers.len=");
        if (paramDownloadParams.headers == null)
        {
          i = 0;
          QLog.d("PicEmotionDownloader", 2, i + " urlStr=" + paramDownloadParams.urlStr + " url.toString=" + paramDownloadParams.url.toString() + " config.tag=" + String.valueOf(paramDownloadParams.tag));
        }
      }
      else
      {
        paramOutputStream = paramDownloadParams.getHeader("emo_tasks");
        if (paramOutputStream == null) {
          break label479;
        }
        i = 1;
        paramOutputStream = paramOutputStream.getValue();
      }
    }
    for (;;)
    {
      try
      {
        j = Integer.parseInt(paramOutputStream);
        if (!(paramDownloadParams.tag instanceof Emoticon)) {
          break label253;
        }
        paramOutputStream = (Emoticon)paramDownloadParams.tag;
        paramURLDrawableHandler = paramDownloadParams.getHeader("my_uin");
        if (paramURLDrawableHandler == null) {
          break label474;
        }
        paramURLDrawableHandler = paramURLDrawableHandler.getValue();
        if ((paramURLDrawableHandler != null) && (paramURLDrawableHandler.length() != 0)) {
          break label299;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "downloadImage|qq_error|get selfuin is null");
        }
        throw new FileDownloadFailedException(9302, 0L, "can't find myUin!", false, false);
      }
      catch (Exception paramOutputStream)
      {
        throw new FileDownloadFailedException(9302, 0L, "can't find emoticon tasks:" + paramOutputStream.toString(), false, false);
      }
      i = paramDownloadParams.headers.length;
      break;
      label253:
      throw new FileDownloadFailedException(9302, 0L, "can't find emoticon!", false, false);
      if (QLog.isColorLevel()) {
        QLog.d("PicEmotionDownloader", 2, "downloadImage|qq_error|config is null");
      }
      throw new FileDownloadFailedException(9302, 0L, "downloadImage config is null", false, false);
      label299:
      paramURLDrawableHandler = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(paramURLDrawableHandler);
      if (paramURLDrawableHandler == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "downloadImage|qq_error|app is null");
        }
        throw new FileDownloadFailedException(9301, 0L, "qqAppInterface is null", false, false);
      }
      paramURLDrawableHandler = (EmojiManager)paramURLDrawableHandler.getManager(42);
      int k = i;
      if (i != 0)
      {
        k = i;
        if (paramURLDrawableHandler.c(paramOutputStream, j)) {
          k = 0;
        }
      }
      if (k != 0)
      {
        boolean bool = paramURLDrawableHandler.b(paramOutputStream, j);
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "qq_error|downloadImage| emocontroller result=" + bool + " emo:" + String.valueOf(paramDownloadParams.tag));
        }
        if (!bool) {
          throw new FileDownloadFailedException(9301, 0L, "downloadImage fail", false, false);
        }
      }
      return new File(AppConstants.aG);
      label474:
      paramURLDrawableHandler = null;
      continue;
      label479:
      paramOutputStream = null;
      int j = -1;
      i = 0;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject = null;
    paramURLDrawableHandler = localObject;
    int i;
    String str;
    if (paramDownloadParams != null)
    {
      paramURLDrawableHandler = localObject;
      if ((paramDownloadParams.tag instanceof Emoticon))
      {
        paramFile = (Emoticon)paramDownloadParams.tag;
        i = paramFile.jobType;
        str = paramDownloadParams.url.getHost();
        if ((!"big_img".equals(str)) && (!"big_sound".equals(str))) {
          break label498;
        }
        if (i != 1) {
          break label151;
        }
        paramDownloadParams = EmosmUtils.getQFaceGifPath(paramFile.epId, paramFile.eId);
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "decodeFile host == STATIC,path=" + paramDownloadParams);
        }
        paramURLDrawableHandler = new NativeGifImage(new File(EmosmUtils.getQFaceGifPath(paramFile.epId, paramFile.eId)), false);
        paramURLDrawableHandler.setDensity(320);
      }
    }
    label151:
    do
    {
      return paramURLDrawableHandler;
      if (i == 2)
      {
        paramFile = new NativeGifImage(new File(EmosmUtils.getEmoticonEncryptPath(paramFile.epId, paramFile.eId)), true, true, 0, 0, 0.0F);
        paramFile.setDensity(320);
        return paramFile;
      }
      paramURLDrawableHandler = localObject;
    } while (i != 0);
    paramDownloadParams = EmosmUtils.getEmoticonEncryptPath(paramFile.epId, paramFile.eId);
    for (;;)
    {
      try
      {
        if (EmosmUtils.isGifFile(paramDownloadParams))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PicEmotionDownloader", 2, "decodeFile isGifFile,path=" + paramDownloadParams);
          }
          paramFile = new File(paramDownloadParams);
          if ("big_img".equals(str))
          {
            paramFile = new NativeGifImage(paramFile, true, true, 0, 0, 0.0F);
            if (paramFile == null) {
              return paramFile;
            }
            paramFile.setDensity(320);
            return paramFile;
          }
          if (!"big_sound".equals(str)) {
            break label640;
          }
          paramFile = new VoiceGifImage(paramFile, 0, true);
          continue;
        }
      }
      catch (FileNotFoundException paramFile)
      {
        paramURLDrawableHandler = localObject;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("PicEmotionDownloader", 2, "decode MARKET File", paramFile);
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "decodeFile getDecryptFileData,path=" + paramDownloadParams);
        }
        paramFile = EmosmUtils.getDecryptFileData(paramDownloadParams);
        paramURLDrawableHandler = localObject;
        if (paramFile == null) {
          break;
        }
      }
      catch (IOException paramFile)
      {
        try
        {
          paramFile = BitmapFactory.decodeByteArray(paramFile, 0, paramFile.length, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
          if (paramFile == null)
          {
            paramURLDrawableHandler = localObject;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("PicEmotionDownloader", 2, "decode MARKET File:file error" + paramDownloadParams);
            return null;
            paramFile = paramFile;
            paramURLDrawableHandler = localObject;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("PicEmotionDownloader", 2, "decode MARKET File", paramFile);
            return null;
          }
        }
        catch (OutOfMemoryError paramFile)
        {
          paramFile = null;
          continue;
        }
        return paramFile;
      }
      catch (Exception paramFile)
      {
        paramURLDrawableHandler = localObject;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("PicEmotionDownloader", 2, "decode MARKET File", paramFile);
      return null;
      label498:
      if ("aio_preview".equals(str)) {
        if (i == 1) {
          paramFile = EmosmUtils.getEmoticonPreviewPath(paramFile.epId, paramFile.eId);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "decodeFile host == STATIC,path=" + paramFile);
        }
        paramURLDrawableHandler = localObject;
        if (paramFile == null) {
          break;
        }
        paramURLDrawableHandler = localObject;
        if (paramFile.length() <= 0) {
          break;
        }
        try
        {
          paramFile = BitmapFactory.decodeFile(paramFile, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
          return paramFile;
          paramFile = EmosmUtils.getEmoticonAIOPreviewPath(paramFile.epId, paramFile.eId);
          continue;
          if ("panel_preview".equals(str)) {
            paramFile = EmosmUtils.getEmoticonPreviewPath(paramFile.epId, paramFile.eId);
          }
        }
        catch (OutOfMemoryError paramFile)
        {
          for (;;)
          {
            paramFile = null;
          }
          paramFile = "";
        }
      }
      label640:
      paramFile = null;
    }
    return paramFile;
  }
  
  public boolean gifHasDifferentState()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PicEmotionDownloader
 * JD-Core Version:    0.7.0.1
 */