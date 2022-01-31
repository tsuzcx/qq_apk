package com.tencent.matrix.b;

import android.app.Application;
import com.tencent.matrix.c.c.a;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b
  implements c.a
{
  public Application application;
  private c bmp;
  public boolean boE = true;
  public int status = 0;
  
  private boolean rf()
  {
    return this.status == 8;
  }
  
  public void a(Application paramApplication, c paramc)
  {
    if ((this.application != null) || (this.bmp != null)) {
      throw new RuntimeException("plugin duplicate init, application or plugin listener is not null");
    }
    this.status = 1;
    this.application = paramApplication;
    this.bmp = paramc;
  }
  
  public final void a(com.tencent.matrix.c.b paramb)
  {
    if (paramb.tag == null) {
      paramb.tag = getTag();
    }
    paramb.boL = this;
    JSONObject localJSONObject = paramb.boK;
    try
    {
      if (paramb.tag != null) {
        localJSONObject.put("tag", paramb.tag);
      }
      if (paramb.boJ != null) {
        localJSONObject.put("type", paramb.boJ);
      }
      localJSONObject.put("process", com.tencent.matrix.d.c.ak(this.application));
      localJSONObject.put("time", System.currentTimeMillis());
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        com.tencent.matrix.d.b.e("Matrix.Plugin", "json error", new Object[] { localJSONException });
      }
    }
    this.bmp.b(paramb);
  }
  
  public String getTag()
  {
    return getClass().getName();
  }
  
  public final boolean re()
  {
    return this.status == 2;
  }
  
  public void start()
  {
    if (rf()) {
      throw new RuntimeException("plugin start, but plugin has been already destroyed");
    }
    if (re()) {
      throw new RuntimeException("plugin start, but plugin has been already started");
    }
    this.status = 2;
    if (this.bmp == null) {
      throw new RuntimeException("plugin start, plugin listener is null");
    }
    this.bmp.c(this);
  }
  
  public void stop()
  {
    if (rf()) {
      throw new RuntimeException("plugin stop, but plugin has been already destroyed");
    }
    if (!re()) {
      throw new RuntimeException("plugin stop, but plugin is never started");
    }
    this.status = 4;
    if (this.bmp == null) {
      throw new RuntimeException("plugin stop, plugin listener is null");
    }
    this.bmp.d(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.b.b
 * JD-Core Version:    0.7.0.1
 */