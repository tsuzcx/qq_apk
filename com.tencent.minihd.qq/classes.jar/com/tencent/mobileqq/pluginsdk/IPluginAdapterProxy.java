package com.tencent.mobileqq.pluginsdk;

public class IPluginAdapterProxy
{
  static IPluginAdapterProxy a;
  private IPluginAdapter b;
  
  private IPluginAdapterProxy(IPluginAdapter paramIPluginAdapter)
  {
    this.b = paramIPluginAdapter;
  }
  
  public static IPluginAdapterProxy getProxy()
  {
    return a;
  }
  
  public static void setProxy(IPluginAdapter paramIPluginAdapter)
  {
    a = new IPluginAdapterProxy(paramIPluginAdapter);
  }
  
  public boolean isNightMode()
  {
    IPluginAdapter localIPluginAdapter = this.b;
    if (localIPluginAdapter == null) {
      return false;
    }
    return ((Boolean)localIPluginAdapter.invoke(1, null)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy
 * JD-Core Version:    0.7.0.1
 */