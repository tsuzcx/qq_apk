package com.tencent.mobileqq.emoticon;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;

public class EPluginInstallTask
  implements TaskInterface
{
  public static final int a = 1000;
  public static final int b = 3000;
  private float jdField_a_of_type_Float;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private int c;
  
  public EPluginInstallTask(String paramString, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static PluginInfo a(QQAppInterface paramQQAppInterface, String paramString)
  {
    IPluginManager localIPluginManager = (IPluginManager)paramQQAppInterface.getManager(26);
    if (localIPluginManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoQFace", 2, "IPluginManager is null when query");
      }
      return null;
    }
    long l = System.currentTimeMillis();
    if (System.currentTimeMillis() - l < 3000L)
    {
      paramQQAppInterface = localIPluginManager.a(paramString);
      if (paramQQAppInterface != null)
      {
        if (!QLog.isColorLevel()) {
          break label138;
        }
        QLog.d("Q.emoji.EmoQFace", 2, "query pluginInfo state=" + paramQQAppInterface.mState + " name=" + paramQQAppInterface.mName);
      }
    }
    for (;;)
    {
      for (;;)
      {
        return paramQQAppInterface;
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoQFace", 2, "plugin is null whe query.");
        }
        try
        {
          Thread.sleep(500L);
        }
        catch (InterruptedException paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
        }
      }
      break;
      label138:
      continue;
      paramQQAppInterface = null;
    }
  }
  
  private void b()
  {
    try
    {
      Thread.sleep(1000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    IPluginManager localIPluginManager = (IPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(26);
    if (localIPluginManager == null) {
      this.c = 11027;
    }
    label398:
    label400:
    do
    {
      return;
      for (;;)
      {
        PluginInfo localPluginInfo = localIPluginManager.a(this.jdField_a_of_type_JavaLangString);
        if (localPluginInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoQFace", 2, "pluginInfo is null...");
          }
          if (System.currentTimeMillis() - l < 3000L) {
            b();
          }
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            break label398;
          }
          this.c = 11029;
          return;
          this.c = 11026;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.emoji.EmoQFace", 2, "pluginInfo is null. timeout.");
          return;
          this.jdField_a_of_type_Float = localPluginInfo.mDownloadProgress;
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoQFace", 2, "name=" + localPluginInfo.mName + " state=" + localPluginInfo.mState + " downloadProgress=" + localPluginInfo.mDownloadProgress + " curVer=" + localPluginInfo.mCurVersion + " requireInstall=" + this.jdField_a_of_type_Boolean);
          }
          if (localPluginInfo.mState == 4)
          {
            this.c = 0;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.emoji.EmoQFace", 2, "pluginInfo success.");
            return;
          }
          if (this.jdField_a_of_type_Boolean)
          {
            if (localPluginInfo.mState == -1)
            {
              this.c = 11028;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.emoji.EmoQFace", 2, "pluginInfo has been canceled.");
              return;
            }
            if ((localPluginInfo.mState == -2) || (localPluginInfo.mState == 0))
            {
              this.c = 11029;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.emoji.EmoQFace", 2, "pluginInfo is a error.plugin.state=" + localPluginInfo.mState + " resultCode=" + this.c);
              return;
            }
          }
          if (localPluginInfo.mState == 4) {
            break label400;
          }
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            localIPluginManager.a(localPluginInfo.mID);
            if (QLog.isColorLevel()) {
              QLog.d("Q.emoji.EmoQFace", 2, "qFace plugin is not installed, require to install.");
            }
          }
          b();
        }
      }
      this.c = 0;
    } while (!QLog.isColorLevel());
    QLog.d("Q.emoji.EmoQFace", 2, "qFace plugin has been installed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EPluginInstallTask
 * JD-Core Version:    0.7.0.1
 */