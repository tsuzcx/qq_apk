package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

class TagManager$3
  implements ComponentCallbacks2
{
  TagManager$3(TagManager paramTagManager) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {}
  
  public void onTrimMemory(int paramInt)
  {
    if (paramInt == 20) {
      this.zzbIz.dispatch();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.TagManager.3
 * JD-Core Version:    0.7.0.1
 */