package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;

public class ReaderWizard
{
  private DexLoader a = null;
  private TbsReaderView.ReaderCallback b = null;
  
  public ReaderWizard(TbsReaderView.ReaderCallback paramReaderCallback)
  {
    this.b = paramReaderCallback;
  }
  
  private static DexLoader a()
  {
    v localv = g.a(true).c();
    DexLoader localDexLoader = null;
    if (localv != null) {
      localDexLoader = localv.b();
    }
    return localDexLoader;
  }
  
  public static Drawable getResDrawable(int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResDrawable", new Class[] { Integer.class }, new Object[] { Integer.valueOf(paramInt) });
      if ((localObject instanceof Drawable)) {
        return (Drawable)localObject;
      }
    }
    return null;
  }
  
  public static String getResString(int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResString", new Class[] { Integer.class }, new Object[] { Integer.valueOf(paramInt) });
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
    }
    return "";
  }
  
  public static boolean isSupportCurrentPlatform(Context paramContext)
  {
    DexLoader localDexLoader = a();
    if (localDexLoader != null)
    {
      paramContext = localDexLoader.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportCurrentPlatform", new Class[] { Context.class }, new Object[] { paramContext });
      if ((paramContext instanceof Boolean)) {
        return ((Boolean)paramContext).booleanValue();
      }
    }
    return false;
  }
  
  public static boolean isSupportExt(String paramString)
  {
    DexLoader localDexLoader = a();
    if (localDexLoader != null)
    {
      paramString = localDexLoader.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportExt", new Class[] { String.class }, new Object[] { paramString });
      if ((paramString instanceof Boolean)) {
        return ((Boolean)paramString).booleanValue();
      }
    }
    return false;
  }
  
  public boolean checkPlugin(Object paramObject, Context paramContext, String paramString, boolean paramBoolean)
  {
    if (this.a == null)
    {
      Log.e("ReaderWizard", "checkPlugin:Unexpect null object!");
      return false;
    }
    paramObject = this.a.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "checkPlugin", new Class[] { Context.class, String.class, Boolean.class }, new Object[] { paramContext, paramString, Boolean.valueOf(paramBoolean) });
    if (!(paramObject instanceof Boolean))
    {
      Log.e("ReaderWizard", "Unexpect return value type of call checkPlugin!");
      return false;
    }
    return ((Boolean)paramObject).booleanValue();
  }
  
  public void destroy(Object paramObject)
  {
    this.b = null;
    if ((this.a == null) || (paramObject == null))
    {
      Log.e("ReaderWizard", "destroy:Unexpect null object!");
      return;
    }
    this.a.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "destroy", new Class[0], new Object[0]);
  }
  
  public void doCommand(Object paramObject1, Integer paramInteger, Object paramObject2, Object paramObject3)
  {
    if (this.a == null)
    {
      Log.e("ReaderWizard", "doCommand:Unexpect null object!");
      return;
    }
    DexLoader localDexLoader = this.a;
    paramInteger = new Integer(paramInteger.intValue());
    localDexLoader.invokeMethod(paramObject1, "com.tencent.tbs.reader.TbsReader", "doCommand", new Class[] { Integer.class, Object.class, Object.class }, new Object[] { paramInteger, paramObject2, paramObject3 });
  }
  
  public Object getTbsReader()
  {
    return this.a.newInstance("com.tencent.tbs.reader.TbsReader", new Class[0], new Object[0]);
  }
  
  public boolean initTbsReader(Object paramObject, Context paramContext)
  {
    if ((this.a == null) || (paramObject == null))
    {
      Log.e("ReaderWizard", "initTbsReader:Unexpect null object!");
      return false;
    }
    DexLoader localDexLoader1 = this.a;
    DexLoader localDexLoader2 = this.a;
    paramObject = localDexLoader1.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "init", new Class[] { Context.class, DexLoader.class, Object.class }, new Object[] { paramContext, localDexLoader2, this });
    if (!(paramObject instanceof Boolean))
    {
      Log.e("ReaderWizard", "Unexpect return value type of call initTbsReader!");
      return false;
    }
    return ((Boolean)paramObject).booleanValue();
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    if (this.b != null) {
      this.b.onCallBackAction(paramInteger, paramObject1, paramObject2);
    }
  }
  
  public void onSizeChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    if (this.a == null)
    {
      Log.e("ReaderWizard", "onSizeChanged:Unexpect null object!");
      return;
    }
    DexLoader localDexLoader = this.a;
    Integer localInteger1 = new Integer(paramInt1);
    Integer localInteger2 = new Integer(paramInt2);
    localDexLoader.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "onSizeChanged", new Class[] { Integer.class, Integer.class }, new Object[] { localInteger1, localInteger2 });
  }
  
  public boolean openFile(Object paramObject, Context paramContext, Bundle paramBundle, FrameLayout paramFrameLayout)
  {
    if (this.a == null)
    {
      Log.e("ReaderWizard", "openFile:Unexpect null object!");
      return false;
    }
    paramObject = this.a.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "openFile", new Class[] { Context.class, Bundle.class, FrameLayout.class }, new Object[] { paramContext, paramBundle, paramFrameLayout });
    if (!(paramObject instanceof Boolean))
    {
      Log.e("ReaderWizard", "Unexpect return value type of call openFile!");
      return false;
    }
    return ((Boolean)paramObject).booleanValue();
  }
  
  public void userStatistics(Object paramObject, String paramString)
  {
    if (this.a == null)
    {
      Log.e("ReaderWizard", "userStatistics:Unexpect null object!");
      return;
    }
    this.a.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "userStatistics", new Class[] { String.class }, new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.ReaderWizard
 * JD-Core Version:    0.7.0.1
 */