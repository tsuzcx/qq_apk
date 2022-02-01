package cooperation.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import lxo;

public class PluginInstaller
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BuiltinPluginManager jdField_a_of_type_CooperationPluginBuiltinPluginManager;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  public PluginInstaller(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_CooperationPluginBuiltinPluginManager = BuiltinPluginManager.a(this.jdField_a_of_type_AndroidContentContext);
    a();
  }
  
  static File a(Context paramContext)
  {
    return PluginUtils.getPluginInstallDir(paramContext);
  }
  
  private void a(PluginInfo paramPluginInfo)
  {
    PluginInfoUtil.a(paramPluginInfo, a(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void a(String paramString)
  {
    PluginInfoUtil.a(paramString, a(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "verifyDownloadPath." + this.jdField_a_of_type_JavaLangString + ", " + bool);
      }
      return bool;
      if (new File(this.jdField_a_of_type_JavaLangString).exists()) {
        bool = true;
      }
    }
  }
  
  private boolean a(PluginInfo paramPluginInfo)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool1;
    if (paramPluginInfo != null)
    {
      bool2 = bool1;
      if (paramPluginInfo.mInstalledPath != null)
      {
        File localFile = new File(paramPluginInfo.mInstalledPath);
        bool1 = bool3;
        if (localFile != null)
        {
          bool1 = bool3;
          if (localFile.exists())
          {
            bool1 = bool3;
            if (localFile.isFile())
            {
              if (!PluginInfoUtil.a(paramPluginInfo, localFile)) {
                break label137;
              }
              bool1 = true;
              paramPluginInfo.mState = 4;
              paramPluginInfo.mInstalledPath = localFile.getAbsolutePath();
            }
          }
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("plugin_tag", 2, "verifyInstalledPlugin :" + paramPluginInfo.mID + "," + bool1);
        bool2 = bool1;
      }
      return bool2;
      label137:
      d(paramPluginInfo.mID);
      paramPluginInfo.mState = 0;
      bool1 = bool3;
    }
  }
  
  private void c(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    String str = paramPluginInfo.mID;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doSetupPlugin." + str);
    }
    if (PluginInfoUtil.a(paramPluginInfo, this.jdField_a_of_type_AndroidContentContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.e(str);
      }
      return;
    }
    if (!c(str)) {}
    for (int i = 1; i != 0; i = 0)
    {
      a(str, paramOnPluginSetupListener);
      return;
    }
    a(paramPluginInfo, paramOnPluginSetupListener);
  }
  
  private boolean c(String paramString)
  {
    if (!a()) {}
    do
    {
      return false;
      paramString = new File(this.jdField_a_of_type_JavaLangString).list(new lxo(this, paramString));
    } while ((paramString == null) || (paramString.length <= 0));
    return true;
  }
  
  private boolean d(String paramString)
  {
    PluginInfo localPluginInfo = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localPluginInfo != null) && (PluginInfoUtil.a(localPluginInfo, this.jdField_a_of_type_AndroidContentContext)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
      return false;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    a(paramString);
    if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
    {
      paramString = new File(localPluginInfo.mInstalledPath);
      if (paramString.exists()) {
        paramString.delete();
      }
    }
    return true;
  }
  
  public PluginInfo a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return null;
    }
    return (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    File localFile1 = a(this.jdField_a_of_type_AndroidContentContext);
    boolean bool = PluginInfoUtil.a(localFile1);
    File[] arrayOfFile = PluginInfoUtil.a(localFile1);
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile2 = arrayOfFile[i];
        if (localFile2.isFile())
        {
          PluginInfo localPluginInfo = PluginInfoUtil.a(localFile2);
          if (localPluginInfo == null) {
            break label95;
          }
          if (a(localPluginInfo)) {
            this.jdField_a_of_type_JavaUtilHashMap.put(localPluginInfo.mID, localPluginInfo);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label95:
          localFile2.delete();
        }
      }
    }
    if (bool) {
      PluginInfoUtil.a(localFile1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "load installed plugin info. size:" + this.jdField_a_of_type_JavaUtilHashMap.size());
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    paramPluginInfo = new Pair(paramPluginInfo, paramOnPluginSetupListener);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(66816, paramPluginInfo).sendToTarget();
  }
  
  public boolean a(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    if (paramPluginInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installDownLoadPlugin. info null.");
      }
      throw new NullPointerException("specified PluginInfo is null");
    }
    String str1 = paramPluginInfo.mID;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "installDownLoadPlugin." + str1);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.e(str1);
      }
      return false;
    }
    File localFile = new File(PluginUtils.getPluginInstallDir(this.jdField_a_of_type_AndroidContentContext), str1);
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str1);
    int i;
    if ((localObject != null) && (!paramPluginInfo.mMD5.equals(((PluginInfo)localObject).mMD5)))
    {
      i = 1;
      label141:
      if (!localFile.exists()) {
        break label491;
      }
    }
    label491:
    for (boolean bool = a((PluginInfo)localObject);; bool = false)
    {
      if ((bool) && (i == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "plugin installed.");
        }
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.e(str1);
        return false;
        i = 0;
        break label141;
      }
      if (!a())
      {
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.e(str1);
        return false;
      }
      localObject = new File(new File(this.jdField_a_of_type_JavaLangString), str1);
      if (!PluginInfoUtil.a(paramPluginInfo, (File)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install fail. download file invalid.");
        }
        ((File)localObject).delete();
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.e(str1);
        return false;
      }
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.f(str1);
      }
      paramPluginInfo.mState = 3;
      this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
      FileUtils.a((File)localObject, localFile);
      if (!PluginInfoUtil.a(paramPluginInfo, localFile))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install fail. copy file invalid.");
        }
        localFile.delete();
        if (paramOnPluginSetupListener == null) {
          break;
        }
        paramOnPluginSetupListener.b(false, str1);
        return false;
      }
      try
      {
        String str2 = PluginUtils.getPluginLibPath(this.jdField_a_of_type_AndroidContentContext, str1).getCanonicalPath();
        PluginUtils.extractLibs(localFile.getCanonicalPath(), str2);
        paramPluginInfo.mState = 4;
        paramPluginInfo.mInstalledPath = localFile.getAbsolutePath();
        this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramPluginInfo);
        a(paramPluginInfo);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "install finish.");
        }
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.b(true, str1);
        }
        return true;
      }
      catch (Exception paramPluginInfo)
      {
        paramPluginInfo.printStackTrace();
        localFile.delete();
      }
      if (paramOnPluginSetupListener == null) {
        break;
      }
      paramOnPluginSetupListener.b(false, str1);
      return false;
    }
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "not containsKey of :" + paramString);
      }
      b(paramString);
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "installBuiltinPlugin." + paramString);
    }
    if (!this.jdField_a_of_type_Boolean) {
      if (paramOnPluginSetupListener != null) {
        paramOnPluginSetupListener.e(paramString);
      }
    }
    do
    {
      return false;
      if (this.jdField_a_of_type_CooperationPluginBuiltinPluginManager.a(paramString)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "not built in plugin.");
      }
    } while (paramOnPluginSetupListener == null);
    paramOnPluginSetupListener.e(paramString);
    return false;
    Object localObject1 = new File(PluginUtils.getPluginInstallDir(this.jdField_a_of_type_AndroidContentContext), paramString);
    Object localObject4 = (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    Object localObject6 = this.jdField_a_of_type_CooperationPluginBuiltinPluginManager.a(paramString);
    int i;
    if ((localObject6 != null) && (localObject4 != null) && (!((PluginInfo)localObject6).mMD5.equals(((PluginInfo)localObject4).mMD5)))
    {
      i = 1;
      label159:
      if (!((File)localObject1).exists()) {
        break label584;
      }
    }
    label584:
    for (boolean bool = a((PluginInfo)localObject4);; bool = false) {
      for (;;)
      {
        if ((bool) && (i == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "plugin already installed.");
          }
          if (paramOnPluginSetupListener != null) {
            paramOnPluginSetupListener.b(true, paramString);
          }
          return true;
          i = 0;
          break label159;
        }
        if (paramOnPluginSetupListener != null) {
          paramOnPluginSetupListener.f(paramString);
        }
        PluginInfo localPluginInfo = ((PluginInfo)localObject6).a();
        localPluginInfo.mState = 3;
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localPluginInfo);
        localObject6 = "";
        try
        {
          String str = paramString.substring(0, paramString.indexOf(".apk"));
          localObject4 = SoLoadCore.getReleasedSoFilePath(this.jdField_a_of_type_AndroidContentContext, str);
          if (localObject4 == null)
          {
            localObject4 = SoLoadCore.releaseSo(this.jdField_a_of_type_AndroidContentContext, str);
            if (localObject4 != null) {
              localObject4 = new File((String)localObject4);
            }
          }
        }
        catch (Exception localException4)
        {
          for (;;)
          {
            try
            {
              localObject1 = localPluginInfo.mMD5;
              localObject6 = localPluginInfo.mMD5;
              if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "md5:" + (String)localObject6 + " vs " + (String)localObject1);
              }
              bool = ((String)localObject1).equals(localObject6);
              if ((0 != 0) || (!bool)) {
                continue;
              }
            }
            catch (Exception localException3)
            {
              Object localObject2;
              continue;
            }
            try
            {
              localObject6 = PluginUtils.getPluginLibPath(this.jdField_a_of_type_AndroidContentContext, paramString).getCanonicalPath();
              PluginUtils.extractLibs(((File)localObject4).getCanonicalPath(), (String)localObject6);
              localPluginInfo.mLength = ((File)localObject4).length();
              localPluginInfo.mState = 4;
              localPluginInfo.mInstalledPath = ((File)localObject4).getAbsolutePath();
              localPluginInfo.mMD5 = ((String)localObject1);
              this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localPluginInfo);
              a(localPluginInfo);
              if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "install finish");
              }
              if (paramOnPluginSetupListener != null) {
                paramOnPluginSetupListener.b(true, paramString);
              }
              return true;
              localException4 = localException4;
              localObject5 = localObject1;
            }
            catch (Exception localException1)
            {
              try
              {
                localObject1 = PluginUtils.extractPluginAndGetMd5Code(this.jdField_a_of_type_AndroidContentContext, paramString, (File)localObject5);
              }
              catch (Exception localException2)
              {
                localObject2 = localObject6;
              }
              localException1 = localException1;
              localException1.printStackTrace();
              ((File)localObject5).delete();
            }
            if (paramOnPluginSetupListener == null) {
              break;
            }
            paramOnPluginSetupListener.b(false, paramString);
            return false;
            if (paramOnPluginSetupListener == null) {
              break;
            }
            paramOnPluginSetupListener.b(false, paramString);
            return false;
            continue;
            Object localObject5 = localException3;
            Object localObject3 = localObject6;
          }
        }
      }
    }
  }
  
  public void b(PluginInfo paramPluginInfo, PluginInstaller.OnPluginSetupListener paramOnPluginSetupListener)
  {
    paramPluginInfo = new Pair(paramPluginInfo, paramOnPluginSetupListener);
    c((PluginInfo)paramPluginInfo.first, (PluginInstaller.OnPluginSetupListener)paramPluginInfo.second);
  }
  
  public boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "uninstallPlugin." + paramString);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return d(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    paramMessage = (Pair)paramMessage.obj;
    c((PluginInfo)paramMessage.first, (PluginInstaller.OnPluginSetupListener)paramMessage.second);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.plugin.PluginInstaller
 * JD-Core Version:    0.7.0.1
 */