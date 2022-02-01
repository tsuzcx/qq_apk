package com.tencent.tencentmap.mapsdk.map;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public abstract class MapActivity
  extends Activity
{
  private List<h> a = new ArrayList();
  
  void a(h paramh)
  {
    this.a.add(paramh);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    int j = this.a.size();
    int i = 0;
    if (i < j)
    {
      h localh = (h)this.a.get(0);
      if (localh == null) {}
      for (;;)
      {
        i += 1;
        break;
        localh.onDestroy();
        this.a.remove(0);
      }
    }
    System.gc();
  }
  
  protected void onPause()
  {
    super.onPause();
    int j = this.a.size();
    int i = 0;
    if (i < j)
    {
      h localh = (h)this.a.get(i);
      if (localh == null) {}
      for (;;)
      {
        i += 1;
        break;
        localh.onPause();
      }
    }
  }
  
  protected void onRestart()
  {
    super.onPause();
    int j = this.a.size();
    int i = 0;
    if (i < j)
    {
      h localh = (h)this.a.get(i);
      if (localh == null) {}
      for (;;)
      {
        i += 1;
        break;
        localh.onRestart();
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    int j = this.a.size();
    int i = 0;
    if (i < j)
    {
      h localh = (h)this.a.get(i);
      if (localh == null) {}
      for (;;)
      {
        i += 1;
        break;
        localh.onResume();
      }
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    int j = this.a.size();
    int i = 0;
    if (i < j)
    {
      h localh = (h)this.a.get(i);
      if (localh == null) {}
      for (;;)
      {
        i += 1;
        break;
        localh.onStop();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.MapActivity
 * JD-Core Version:    0.7.0.1
 */