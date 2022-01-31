package com.tencent.mm.booter.cache;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class CacheService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return a.diV;
  }
  
  public void onCreate()
  {
    super.onCreate();
    a.prepare();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.cache.CacheService
 * JD-Core Version:    0.7.0.1
 */