package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.data.EmoticonPackage;

public abstract class EmoticonPackageDownloadListener
{
  public void onCoverComplete(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
  
  public void onJsonComplete(EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void onPackageProgress(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
  
  public void onPackageStart(EmoticonPackage paramEmoticonPackage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener
 * JD-Core Version:    0.7.0.1
 */