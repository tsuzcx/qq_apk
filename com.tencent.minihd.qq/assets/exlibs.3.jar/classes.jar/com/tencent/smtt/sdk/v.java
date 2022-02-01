package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m;
import java.util.Map;

class v
{
  private Context a = null;
  private Context b = null;
  private String c = null;
  private String[] d = null;
  private DexLoader e = null;
  private String f = "TbsDexOpt";
  private String g = null;
  
  public v(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
    throws Exception
  {
    TbsLog.i("TbsWizard", "construction start...");
    if ((paramContext1 == null) || ((paramContext2 == null) && (TbsShareManager.getHostCorePathAppDefined() == null)) || (TextUtils.isEmpty(paramString1)) || (paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      throw new Exception("TbsWizard paramter error:-1callerContext:" + paramContext1 + "hostcontext" + paramContext2 + "isEmpty" + TextUtils.isEmpty(paramString1) + "dexfileList" + paramArrayOfString);
    }
    this.a = paramContext1.getApplicationContext();
    if (paramContext2.getApplicationContext() != null) {}
    int i;
    for (this.b = paramContext2.getApplicationContext();; this.b = paramContext2)
    {
      this.c = paramString1;
      this.d = paramArrayOfString;
      this.f = paramString2;
      i = 0;
      while (i < this.d.length)
      {
        TbsLog.i("TbsWizard", "#2 mDexFileList[" + i + "]: " + this.d[i]);
        i += 1;
      }
    }
    TbsLog.i("TbsWizard", "new DexLoader #2 libraryPath is " + paramString3 + " mCallerAppContext is " + this.a + " dexOutPutDir is " + paramString2);
    this.e = new DexLoader(paramString3, this.a, this.d, paramString2, QbSdk.o);
    System.currentTimeMillis();
    a(paramContext1);
    libwebp.loadWepLibraryIfNeed(paramContext2, this.c);
    if ("com.nd.android.pandahome2".equals(this.a.getApplicationInfo().packageName))
    {
      paramContext2 = this.e;
      paramString1 = this.a;
      paramContext2.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[] { Context.class }, new Object[] { paramString1 });
    }
    if (QbSdk.o != null) {}
    boolean bool1;
    try
    {
      bool1 = TbsPVConfig.getInstance(this.a).getTbsCoreSandboxModeEnable();
      try
      {
        boolean bool2 = "true".equals(String.valueOf(QbSdk.o.get("use_sandbox")));
        if (!bool2) {
          break label567;
        }
        i = 1;
      }
      catch (Throwable paramContext2)
      {
        for (;;)
        {
          paramContext2.printStackTrace();
          i = 0;
          continue;
          bool1 = false;
        }
        TbsLog.i("TbsWizard", "construction end...");
      }
      paramContext2 = QbSdk.o;
      if ((bool1) && (i != 0))
      {
        bool1 = true;
        paramContext2.put("use_sandbox", Boolean.valueOf(bool1));
        paramContext2 = this.e;
        paramString1 = QbSdk.o;
        paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[] { Map.class }, new Object[] { paramString1 });
        i = b(paramContext1);
        if (i >= 0) {
          break label579;
        }
        throw new Exception("TbsWizard init error: " + i + "; msg: " + this.g);
      }
    }
    catch (Throwable paramContext2)
    {
      for (;;)
      {
        bool1 = false;
      }
    }
    label567:
    label579:
    return;
  }
  
  private int b(Context paramContext)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    String str1;
    String str2;
    String str3;
    int i;
    if ((this.b == null) && (TbsShareManager.getHostCorePathAppDefined() != null))
    {
      localObject1 = this.e;
      localObject2 = Integer.TYPE;
      localObject3 = this.b;
      localObject4 = this.e;
      str1 = this.c;
      str2 = this.f;
      str3 = QbSdk.a();
      String str4 = TbsShareManager.getHostCorePathAppDefined();
      localObject1 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject2, String.class, String.class }, new Object[] { paramContext, localObject3, localObject4, str1, str2, "4.3.0.185", Integer.valueOf(44085), str3, str4 });
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        c();
        d();
        localObject1 = this.e;
        localObject2 = this.b;
        localObject3 = this.e;
        localObject4 = this.c;
        str1 = this.f;
        localObject2 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class }, new Object[] { paramContext, localObject2, localObject3, localObject4, str1 });
      }
      if (localObject2 != null) {
        break label612;
      }
      i = -3;
    }
    for (;;)
    {
      if (i >= 0) {
        break label670;
      }
      paramContext = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
      if ((paramContext instanceof Throwable))
      {
        localObject1 = (Throwable)paramContext;
        this.g = ("#" + ((Throwable)localObject1).getMessage() + "; cause: " + ((Throwable)localObject1).getCause() + "; th: " + localObject1);
      }
      if ((paramContext instanceof String)) {
        this.g = ((String)paramContext);
      }
      return i;
      TbsLog.i("TbsWizard", "initTesRuntimeEnvironment callerContext is " + paramContext + " mHostContext is " + this.b + " mDexLoader is " + this.e + " mtbsInstallLocation is " + this.c + " mDexOptPath is " + this.f);
      localObject1 = this.e;
      localObject2 = Integer.TYPE;
      localObject3 = this.b;
      localObject4 = this.e;
      str1 = this.c;
      str2 = this.f;
      str3 = QbSdk.a();
      localObject1 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject2, String.class }, new Object[] { paramContext, localObject3, localObject4, str1, str2, "4.3.0.185", Integer.valueOf(44085), str3 });
      break;
      label612:
      if ((localObject2 instanceof Integer))
      {
        i = ((Integer)localObject2).intValue();
      }
      else if ((localObject2 instanceof Throwable))
      {
        TbsCoreLoadStat.getInstance().a(this.a, 328, (Throwable)localObject2);
        i = -5;
      }
      else
      {
        i = -4;
      }
    }
    label670:
    this.g = null;
    return i;
  }
  
  private void c()
  {
    this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[] { String.class }, new Object[] { "4.3.0.185" });
  }
  
  private void d()
  {
    this.e.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(44085));
  }
  
  public String a()
  {
    String str = null;
    Object localObject2 = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[] { Boolean.TYPE, String.class, String.class, [Ljava.lang.Class.class, [Ljava.lang.Object.class }, new Object[] { Boolean.valueOf(true), "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0] });
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
    }
    if (localObject1 != null)
    {
      str = String.valueOf(localObject1);
      str = str + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion;
    }
    localObject1 = str;
    if (str == null) {
      localObject1 = "X5 core get nothing...";
    }
    return localObject1;
  }
  
  void a(Context paramContext)
  {
    Object localObject = QbSdk.o;
    if (localObject != null)
    {
      localObject = ((Map)localObject).get("check_tbs_validity");
      if (!(localObject instanceof Boolean)) {}
    }
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = true)
    {
      if (bool) {
        m.b(paramContext);
      }
      return;
    }
  }
  
  public void a(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
    throws Exception
  {
    this.a = paramContext1.getApplicationContext();
    if (this.b.getApplicationContext() != null) {
      this.b = this.b.getApplicationContext();
    }
    this.c = paramString1;
    this.d = paramArrayOfString;
    this.f = paramString2;
    libwebp.loadWepLibraryIfNeed(paramContext2, this.c);
    if (QbSdk.o != null)
    {
      paramContext2 = this.e;
      paramString1 = QbSdk.o;
      paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[] { Map.class }, new Object[] { paramString1 });
    }
    int i = b(paramContext1);
    if (i < 0) {
      throw new Exception("continueInit init error: " + i + "; msg: " + this.g);
    }
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    paramContext = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[] { Context.class, String.class, String.class, Bundle.class }, new Object[] { paramContext, paramString1, paramString2, paramBundle });
    if (paramContext == null) {
      return false;
    }
    return ((Boolean)paramContext).booleanValue();
  }
  
  public DexLoader b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.v
 * JD-Core Version:    0.7.0.1
 */