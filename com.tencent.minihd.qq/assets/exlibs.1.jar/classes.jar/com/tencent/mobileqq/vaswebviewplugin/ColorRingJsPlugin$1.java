package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import org.json.JSONException;
import org.json.JSONObject;

class ColorRingJsPlugin$1
  implements Runnable
{
  ColorRingJsPlugin$1(ColorRingJsPlugin paramColorRingJsPlugin, String paramString1, String paramString2) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject;
      ExtensionInfo localExtensionInfo;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (ColorRingJsPlugin.access$000(this.this$0) != null)
        {
          localObject = ColorRingJsPlugin.access$000(this.this$0).a(null).createEntityManager();
          localExtensionInfo = (ExtensionInfo)((EntityManager)localObject).a(ExtensionInfo.class, ColorRingJsPlugin.access$000(this.this$0).getAccount());
          ((EntityManager)localObject).a();
          localJSONObject.put("result", 0);
          localObject = new JSONObject();
          if (localExtensionInfo == null)
          {
            ((JSONObject)localObject).put("currentId", 0L);
            localJSONObject.put("data", localObject);
          }
        }
        else
        {
          ColorRingJsPlugin.access$100(this.this$0).runOnUiThread(new ColorRingJsPlugin.1.1(this, localJSONObject));
          return;
        }
        if (this.val$type.equals("colorring"))
        {
          ((JSONObject)localObject).put("currentId", localExtensionInfo.colorRingId);
          continue;
        }
        String str;
        if (!this.val$type.equals("comering")) {
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        str = localJSONException.getMessage();
        ColorRingJsPlugin.access$100(this.this$0).runOnUiThread(new ColorRingJsPlugin.1.2(this, str));
        return;
      }
      ((JSONObject)localObject).put("currentId", localExtensionInfo.commingRingId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */