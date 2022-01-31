package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

 enum JsApiLaunchMiniProgram$LaunchPreconditionTask$a
{
  public final String bHk;
  
  private JsApiLaunchMiniProgram$LaunchPreconditionTask$a(String paramString)
  {
    this.bHk = paramString;
  }
  
  public static a ly(int paramInt)
  {
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (paramInt == locala.ordinal()) {
        return locala;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram.LaunchPreconditionTask.a
 * JD-Core Version:    0.7.0.1
 */