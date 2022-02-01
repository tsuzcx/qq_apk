package com.tencent.mm.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;

public class Application
  extends TinkerApplication
{
  private static final String CLASSLOADER_INITIALIZER_CLASSNAME = "com.tencent.mm.plugin.expansions.ExpansionsClassLoaderInitializer";
  private static final String CLASSLOADER_INITIALIZER_METHODNAME = "initializeClassLoader";
  public static final boolean IS_OBB_ENABLED = false;
  private static final String TINKER_LOADER_ENTRY_CLASSNAME = "com.tencent.tinker.loader.TinkerLoader";
  private static final String WECHAT_APPLICATION_LIKE_CLASSNAME = "com.tencent.mm.app.MMApplicationLike";
  
  public Application()
  {
    super(7, "com.tencent.mm.app.MMApplicationLike", "com.tencent.tinker.loader.TinkerLoader", true, true);
  }
  
  @SuppressLint({"NewApi"})
  private void replaceAndInitAppClassLoader()
  {
    this.tinkerResultIntent = new Intent();
    ShareIntentUtil.setIntentReturnCode(this.tinkerResultIntent, -1);
  }
  
  public void onBaseContextAttached(Context paramContext, long paramLong1, long paramLong2)
  {
    super.onBaseContextAttached(paramContext, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.Application
 * JD-Core Version:    0.7.0.1
 */