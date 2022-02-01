package com.tencent.map.tools.sheet;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.internal.c;
import com.tencent.map.tools.internal.d;
import com.tencent.map.tools.internal.e;
import com.tencent.map.tools.sheet.listener.ModuleUncaughtListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class SheetManager
  implements d
{
  private static final SheetManager ourInstance;
  private boolean mPluginExists;
  private c mSheetAdapter;
  private d mSheetProxy;
  
  static
  {
    AppMethodBeat.i(180964);
    ourInstance = new SheetManager();
    AppMethodBeat.o(180964);
  }
  
  public static SheetManager getInstance()
  {
    return ourInstance;
  }
  
  public Object callSheetMth(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(180961);
    if (this.mPluginExists)
    {
      paramObject = this.mSheetProxy.callSheetMth(paramObject, paramString, paramArrayOfClass, paramArrayOfObject);
      AppMethodBeat.o(180961);
      return paramObject;
    }
    paramObject = Util.invokeMethod(paramObject, paramString, paramArrayOfClass, paramArrayOfObject);
    AppMethodBeat.o(180961);
    return paramObject;
  }
  
  public Object callSheetMth(Object paramObject, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(180960);
    if (this.mPluginExists)
    {
      paramObject = this.mSheetProxy.callSheetMth(paramObject, paramString, paramVarArgs);
      AppMethodBeat.o(180960);
      return paramObject;
    }
    paramObject = Util.invokeMethod(paramObject, paramString, paramVarArgs);
    AppMethodBeat.o(180960);
    return paramObject;
  }
  
  public Object callSheetStaMth(Class paramClass, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(237035);
    if (this.mPluginExists)
    {
      paramClass = this.mSheetProxy.callSheetStaMth(paramClass, paramString, paramArrayOfClass, paramArrayOfObject);
      AppMethodBeat.o(237035);
      return paramClass;
    }
    paramClass = Util.invokeStaticMethod(paramClass, paramString, paramArrayOfClass, paramArrayOfObject);
    AppMethodBeat.o(237035);
    return paramClass;
  }
  
  public Class findSheet(String paramString)
  {
    AppMethodBeat.i(180955);
    if (this.mPluginExists)
    {
      paramString = this.mSheetProxy.findSheet(paramString);
      AppMethodBeat.o(180955);
      return paramString;
    }
    paramString = Util.findClass(paramString, getSheetLoader());
    AppMethodBeat.o(180955);
    return paramString;
  }
  
  public <T> Class<? extends T> findSheet(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(180956);
    if (this.mPluginExists)
    {
      paramString = this.mSheetProxy.findSheet(paramString, paramClass);
      AppMethodBeat.o(180956);
      return paramString;
    }
    paramString = Util.findClass(paramString, paramClass, getSheetLoader());
    AppMethodBeat.o(180956);
    return paramString;
  }
  
  public File getLogDir()
  {
    AppMethodBeat.i(180963);
    if (this.mSheetAdapter != null)
    {
      File localFile = this.mSheetAdapter.b();
      AppMethodBeat.o(180963);
      return localFile;
    }
    AppMethodBeat.o(180963);
    return null;
  }
  
  public ClassLoader getSheetLoader()
  {
    AppMethodBeat.i(180959);
    if (this.mPluginExists)
    {
      localClassLoader = this.mSheetProxy.getSheetLoader();
      AppMethodBeat.o(180959);
      return localClassLoader;
    }
    ClassLoader localClassLoader = getClass().getClassLoader();
    AppMethodBeat.o(180959);
    return localClassLoader;
  }
  
  public void init(Context paramContext, Options paramOptions)
  {
    AppMethodBeat.i(180954);
    switch (SheetManager.2.a[paramOptions.mAdapterType.ordinal()])
    {
    default: 
      if (this.mSheetAdapter.a())
      {
        this.mSheetProxy = this.mSheetAdapter.c();
        if (this.mSheetProxy.getSheetLoader() == null) {
          break label102;
        }
      }
      break;
    }
    label102:
    for (boolean bool = true;; bool = false)
    {
      this.mPluginExists = bool;
      AppMethodBeat.o(180954);
      return;
      this.mSheetAdapter = new e(paramContext, paramOptions);
      break;
    }
  }
  
  public void initAsync(Context paramContext, Options paramOptions, Callback<Void> paramCallback)
  {
    AppMethodBeat.i(180953);
    new Thread(new SheetManager.1(this, paramContext, paramOptions, new Handler(Looper.getMainLooper()), paramCallback), "tencentmap-sheetinit").start();
    AppMethodBeat.o(180953);
  }
  
  public int loadSheetGroups()
  {
    AppMethodBeat.i(180962);
    if (this.mPluginExists)
    {
      int i = this.mSheetProxy.loadSheetGroups();
      AppMethodBeat.o(180962);
      return i;
    }
    AppMethodBeat.o(180962);
    return 0;
  }
  
  public <T> T newSheetIns(Class<T> paramClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(180958);
    if (this.mPluginExists)
    {
      paramClass = this.mSheetProxy.newSheetIns(paramClass, paramVarArgs);
      AppMethodBeat.o(180958);
      return paramClass;
    }
    paramClass = Util.newInstance(paramClass, paramVarArgs);
    AppMethodBeat.o(180958);
    return paramClass;
  }
  
  public Object newSheetIns(String paramString)
  {
    AppMethodBeat.i(180957);
    if (this.mPluginExists)
    {
      paramString = this.mSheetProxy.newSheetIns(paramString);
      AppMethodBeat.o(180957);
      return paramString;
    }
    paramString = Util.newInstance(findSheet(paramString), new Object[0]);
    AppMethodBeat.o(180957);
    return paramString;
  }
  
  public static class Options
  {
    private SheetManager.Options.AdapterType mAdapterType = SheetManager.Options.AdapterType.LOC_SHEET;
    private File mCoreLogDir;
    private String mCoreLogReportUrl;
    private String mCoreLogToken;
    private boolean mIsCatchCrashEnable;
    private boolean mIsCoreLogOn;
    private boolean mIsSheetEnable;
    private String mPluginName;
    private String mPluginUpdateUrl;
    private String mSdkFlavor;
    private String mSdkMapKey;
    private String mSdkRepo;
    private String mSdkVersion;
    private String mSdkVersionCode;
    private String mSoLibName;
    private SheetManager.UncaughtListener mUncaughtListener;
    
    public SheetManager.Options.AdapterType getAdapterType()
    {
      return this.mAdapterType;
    }
    
    public File getCoreLogDir()
    {
      return this.mCoreLogDir;
    }
    
    public String getCoreLogReportUrl()
    {
      return this.mCoreLogReportUrl;
    }
    
    public String getCoreLogToken()
    {
      return this.mCoreLogToken;
    }
    
    public String getPluginName()
    {
      return this.mPluginName;
    }
    
    public String getPluginUpdateUrl()
    {
      return this.mPluginUpdateUrl;
    }
    
    public String getSdkFlavor()
    {
      return this.mSdkFlavor;
    }
    
    public String getSdkMapKey()
    {
      return this.mSdkMapKey;
    }
    
    public String getSdkRepo()
    {
      return this.mSdkRepo;
    }
    
    public String getSdkVersion()
    {
      return this.mSdkVersion;
    }
    
    public String getSdkVersionCode()
    {
      return this.mSdkVersionCode;
    }
    
    public String getSoLibName()
    {
      return this.mSoLibName;
    }
    
    public SheetManager.UncaughtListener getUncaughtListener()
    {
      return this.mUncaughtListener;
    }
    
    public boolean isCatchCrashEnable()
    {
      return this.mIsCatchCrashEnable;
    }
    
    public boolean isCoreLogOn()
    {
      return this.mIsCoreLogOn;
    }
    
    public boolean isSheetEnable()
    {
      return this.mIsSheetEnable;
    }
    
    public Options setAdapterType(SheetManager.Options.AdapterType paramAdapterType)
    {
      this.mAdapterType = paramAdapterType;
      return this;
    }
    
    public Options setAppKey(String paramString)
    {
      this.mSdkMapKey = paramString;
      return this;
    }
    
    public Options setCatchCrashEnable(boolean paramBoolean)
    {
      this.mIsCatchCrashEnable = paramBoolean;
      return this;
    }
    
    public void setCoreLogDir(File paramFile)
    {
      this.mCoreLogDir = paramFile;
    }
    
    public Options setCoreLogOn(boolean paramBoolean)
    {
      this.mIsCoreLogOn = paramBoolean;
      return this;
    }
    
    public Options setCoreLogReportUrl(String paramString)
    {
      this.mCoreLogReportUrl = paramString;
      return this;
    }
    
    public Options setCoreLogToken(String paramString)
    {
      this.mCoreLogToken = paramString;
      return this;
    }
    
    public Options setFlavor(String paramString)
    {
      this.mSdkFlavor = paramString;
      return this;
    }
    
    public Options setPluginUpdateUrl(String paramString)
    {
      this.mPluginUpdateUrl = paramString;
      return this;
    }
    
    public Options setSdkRepo(String paramString)
    {
      this.mSdkRepo = paramString;
      return this;
    }
    
    public Options setSheetEnable(boolean paramBoolean)
    {
      this.mIsSheetEnable = paramBoolean;
      return this;
    }
    
    public Options setSheetProjectName(String paramString)
    {
      this.mPluginName = paramString;
      return this;
    }
    
    public Options setSoLibName(String paramString)
    {
      this.mSoLibName = paramString;
      return this;
    }
    
    public Options setUncaughtListener(SheetManager.UncaughtListener paramUncaughtListener)
    {
      this.mUncaughtListener = paramUncaughtListener;
      return this;
    }
    
    public Options setVersion(String paramString)
    {
      this.mSdkVersion = paramString;
      return this;
    }
    
    public Options setVersionCode(String paramString)
    {
      this.mSdkVersionCode = paramString;
      return this;
    }
  }
  
  public static abstract class UncaughtListener
    extends ModuleUncaughtListener
  {
    public UncaughtListener(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.map.tools.sheet.SheetManager
 * JD-Core Version:    0.7.0.1
 */