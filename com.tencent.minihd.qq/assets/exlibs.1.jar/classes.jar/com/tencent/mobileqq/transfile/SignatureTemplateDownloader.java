package com.tencent.mobileqq.transfile;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import org.apache.http.Header;

public class SignatureTemplateDownloader
  extends AbsDownloader
{
  public static final String a = "sig_zip";
  public static final String b = "sig_cover";
  public static final String c = "my_uin";
  public static final String d = "img_filename";
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = paramDownloadParams.url.getFile();
    if (paramOutputStream.startsWith(File.separator)) {
      paramOutputStream = paramOutputStream.substring(1);
    }
    for (;;)
    {
      paramURLDrawableHandler = paramDownloadParams.url.getHost();
      Object localObject = paramDownloadParams.getHeader("my_uin");
      paramDownloadParams = null;
      if (localObject != null) {
        paramDownloadParams = ((Header)localObject).getValue();
      }
      paramDownloadParams = (SignatureManager)((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(paramDownloadParams)).getManager(56);
      localObject = new File(SignatureTemplateConfig.a(paramOutputStream, paramURLDrawableHandler));
      if (((File)localObject).exists()) {
        return localObject;
      }
      return paramDownloadParams.a(paramOutputStream, paramURLDrawableHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.SignatureTemplateDownloader
 * JD-Core Version:    0.7.0.1
 */