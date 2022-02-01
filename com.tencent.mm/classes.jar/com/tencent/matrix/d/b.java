package com.tencent.matrix.d;

import android.app.Application;
import com.tencent.matrix.e.d;
import com.tencent.matrix.report.g;
import com.tencent.matrix.report.h.a;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b
  implements com.tencent.matrix.b.a, h.a
{
  public static final int PLUGIN_CREATE = 0;
  public static final int PLUGIN_DESTROYED = 8;
  public static final int PLUGIN_INITED = 1;
  public static final int PLUGIN_STARTED = 2;
  public static final int PLUGIN_STOPPED = 4;
  private static final String TAG = "Matrix.Plugin";
  private Application application;
  private boolean isSupported = true;
  private c pluginListener;
  private int status = 0;
  
  public void destroy()
  {
    if (isPluginStarted()) {
      stop();
    }
    if (isPluginDestroyed()) {
      throw new RuntimeException("plugin destroy, but plugin has been already destroyed");
    }
    this.status = 8;
    if (this.pluginListener == null) {
      throw new RuntimeException("plugin destroy, plugin listener is null");
    }
    this.pluginListener.e(this);
  }
  
  public Application getApplication()
  {
    return this.application;
  }
  
  public JSONObject getJsonInfo()
  {
    return new JSONObject();
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getTag()
  {
    return getClass().getName();
  }
  
  public void init(Application paramApplication, c paramc)
  {
    if ((this.application != null) || (this.pluginListener != null)) {
      throw new RuntimeException("plugin duplicate init, application or plugin listener is not null");
    }
    this.status = 1;
    this.application = paramApplication;
    this.pluginListener = paramc;
    com.tencent.matrix.a.eLw.a(this);
  }
  
  public boolean isForeground()
  {
    return com.tencent.matrix.a.eLw.eLx;
  }
  
  public boolean isPluginDestroyed()
  {
    return this.status == 8;
  }
  
  public boolean isPluginStarted()
  {
    return this.status == 2;
  }
  
  public boolean isPluginStopped()
  {
    return this.status == 4;
  }
  
  public boolean isSupported()
  {
    return this.isSupported;
  }
  
  public void onDetectIssue(g paramg)
  {
    if (paramg.tag == null) {
      paramg.tag = getTag();
    }
    paramg.eYA = this;
    JSONObject localJSONObject = paramg.eYz;
    try
    {
      if (paramg.tag != null) {
        localJSONObject.put("tag", paramg.tag);
      }
      if (paramg.type != 0) {
        localJSONObject.put("type", paramg.type);
      }
      localJSONObject.put("process", d.getProcessName(this.application));
      localJSONObject.put("time", System.currentTimeMillis());
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        com.tencent.matrix.e.c.e("Matrix.Plugin", "json error", new Object[] { localJSONException });
      }
    }
    this.pluginListener.a(paramg);
  }
  
  public void onForeground(boolean paramBoolean) {}
  
  public void start()
  {
    if (isPluginDestroyed()) {
      throw new RuntimeException("plugin start, but plugin has been already destroyed");
    }
    if (isPluginStarted()) {
      throw new RuntimeException("plugin start, but plugin has been already started");
    }
    this.status = 2;
    if (this.pluginListener == null) {
      throw new RuntimeException("plugin start, plugin listener is null");
    }
    this.pluginListener.c(this);
  }
  
  public void stop()
  {
    if (isPluginDestroyed()) {
      throw new RuntimeException("plugin stop, but plugin has been already destroyed");
    }
    if (!isPluginStarted()) {
      throw new RuntimeException("plugin stop, but plugin is never started");
    }
    this.status = 4;
    if (this.pluginListener == null) {
      throw new RuntimeException("plugin stop, plugin listener is null");
    }
    this.pluginListener.d(this);
  }
  
  public void unSupportPlugin()
  {
    this.isSupported = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.d.b
 * JD-Core Version:    0.7.0.1
 */