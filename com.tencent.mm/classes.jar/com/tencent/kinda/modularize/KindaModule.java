package com.tencent.kinda.modularize;

import com.tencent.kinda.ConstructProxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public abstract class KindaModule
{
  private HashMap<String, Class> nativeModuleMap = new HashMap();
  private HashMap<String, Class> nativeViewMap = new HashMap();
  
  public abstract void configModule();
  
  void initModuleInner()
  {
    Iterator localIterator = this.nativeModuleMap.keySet().iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      ConstructProxy.proxyDefaultConstructor((Class)this.nativeModuleMap.get(str), str);
    }
    localIterator = this.nativeViewMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      ConstructProxy.proxyDefaultConstructor((Class)this.nativeViewMap.get(str), str);
    }
  }
  
  public abstract void onAppCreate();
  
  protected void registerNativeModule(String paramString, Class paramClass)
  {
    if ((paramString != null) && (paramClass != null)) {
      this.nativeModuleMap.put(paramString, paramClass);
    }
  }
  
  protected void registerView(String paramString, Class paramClass)
  {
    if ((paramString != null) && (paramClass != null)) {
      this.nativeViewMap.put(paramString, paramClass);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.modularize.KindaModule
 * JD-Core Version:    0.7.0.1
 */