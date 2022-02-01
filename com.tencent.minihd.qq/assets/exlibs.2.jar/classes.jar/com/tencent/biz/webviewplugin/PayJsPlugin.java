package com.tencent.biz.webviewplugin;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.JsWebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class PayJsPlugin
  extends JsWebViewPlugin
{
  public static final String a = "JsBridge.JsHandle.PayJsHandler";
  Activity jdField_a_of_type_AndroidAppActivity;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  
  protected String a()
  {
    return "pay";
  }
  
  public void buyGoods(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "buyGoods requet params json=" + paramJSONObject.toString());
    }
    long l = paramJsBridgeListener.a();
    PayBridgeActivity.tenpay(this.jdField_a_of_type_AndroidAppActivity, paramJSONObject.toString(), 7, String.valueOf(l));
  }
  
  public void call(String paramString, List paramList, JsBridgeListener paramJsBridgeListener)
  {
    Method[] arrayOfMethod = getClass().getDeclaredMethods();
    Object localObject2 = null;
    int j = arrayOfMethod.length;
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < j)
      {
        localObject1 = arrayOfMethod[i];
        if (!((Method)localObject1).getName().equals(paramString)) {}
      }
      else
      {
        if (localObject1 != null)
        {
          if (paramList != null) {}
          try
          {
            if (paramList.size() > 0)
            {
              localObject2 = URLDecoder.decode((String)paramList.get(0), "UTF-8");
              if ((localObject2 != null) && (((String)localObject2).length() > 0)) {}
              for (localObject2 = new JSONObject((String)localObject2);; localObject2 = new JSONObject())
              {
                ((Method)localObject1).invoke(this, new Object[] { localObject2, paramJsBridgeListener });
                return;
              }
            }
            paramJsBridgeListener.a(localException.getMessage());
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "args is not json string,class=" + getClass().getSimpleName() + ",methodName=" + paramString + ",args=" + paramList);
            }
            if (paramJsBridgeListener == null) {
              break label588;
            }
            paramJsBridgeListener.a("args is not json string");
            return;
            if (!QLog.isColorLevel()) {
              break label588;
            }
            QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "JsHandler call class=" + getClass().getSimpleName() + ",methodName=" + paramString + ",args=" + paramList.toString());
            return;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "Web Bridge call method IllegalAccessException:" + localIllegalAccessException.getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + paramString + ",args=" + paramList);
            }
            if (paramJsBridgeListener == null) {
              break label588;
            }
            paramJsBridgeListener.a(localIllegalAccessException.getMessage());
            return;
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "Web Bridge call method InvocationTargetException:" + localInvocationTargetException.getTargetException().getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + paramString + ",args=" + paramList);
            }
            if (paramJsBridgeListener == null) {
              break label588;
            }
            paramJsBridgeListener.a(localInvocationTargetException.getMessage());
            return;
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "Web Bridge call method Exception:" + localException.getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + paramString + ",args=" + paramList);
            }
            if (paramJsBridgeListener == null) {
              break label588;
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "not found method;class=" + getClass().getSimpleName() + ",methodName=" + paramString + ",args=" + paramList);
          }
          if (paramJsBridgeListener != null) {
            paramJsBridgeListener.a(paramString);
          }
        }
        label588:
        return;
      }
      i += 1;
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!a().equals(paramString2)) {
      return false;
    }
    paramString2 = getClass().getDeclaredMethods();
    int j = paramString2.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        paramString1 = paramString2[i];
        if (!paramString1.getName().equals(paramString3)) {}
      }
      else
      {
        while (paramString1 != null)
        {
          if (paramVarArgs != null) {}
          try
          {
            if (paramVarArgs.length > 0)
            {
              paramString2 = URLDecoder.decode(paramVarArgs[0], "UTF-8");
              if ((paramString2 != null) && (paramString2.length() > 0)) {}
              for (paramString2 = new JSONObject(paramString2);; paramString2 = new JSONObject())
              {
                paramString1.invoke(this, new Object[] { paramString2, paramJsBridgeListener });
                break;
              }
            }
            paramJsBridgeListener.a(paramString1.getMessage());
          }
          catch (JSONException paramString1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "args is not json string,class=" + getClass().getSimpleName() + ",methodName=" + paramString3 + ",args=" + paramVarArgs);
            }
            if (paramJsBridgeListener == null) {
              break label526;
            }
            paramJsBridgeListener.a("args is not json string");
            break label526;
            if (!QLog.isColorLevel()) {
              break label526;
            }
            QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "JsHandler call class=" + getClass().getSimpleName() + ",methodName=" + paramString3 + ",args=" + paramVarArgs.toString());
          }
          catch (IllegalAccessException paramString1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "Web Bridge call method IllegalAccessException:" + paramString1.getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + paramString3 + ",args=" + paramVarArgs);
            }
            if (paramJsBridgeListener == null) {
              break label526;
            }
            paramJsBridgeListener.a(paramString1.getMessage());
          }
          catch (InvocationTargetException paramString1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "Web Bridge call method InvocationTargetException:" + paramString1.getTargetException().getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + paramString3 + ",args=" + paramVarArgs);
            }
            if (paramJsBridgeListener == null) {
              break label526;
            }
            paramJsBridgeListener.a(paramString1.getMessage());
          }
          catch (Exception paramString1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "Web Bridge call method Exception:" + paramString1.getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + paramString3 + ",args=" + paramVarArgs);
            }
            if (paramJsBridgeListener == null) {
              break label526;
            }
          }
          break label526;
          paramString1 = null;
        }
        break;
        label526:
        return true;
      }
      i += 1;
    }
  }
  
  public void onCreate()
  {
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
  }
  
  public void openService(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "openService requet params json=" + paramJSONObject.toString());
    }
    long l = paramJsBridgeListener.a();
    PayBridgeActivity.tenpay(this.jdField_a_of_type_AndroidAppActivity, paramJSONObject.toString(), 4, String.valueOf(l));
  }
  
  public void openTenpayView(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "openTenpayView requet params json=" + paramJSONObject.toString());
    }
    long l = paramJsBridgeListener.a();
    PayBridgeActivity.tenpay(this.jdField_a_of_type_AndroidAppActivity, paramJSONObject.toString(), 5, String.valueOf(l));
  }
  
  public void pay(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "pay requet params json=" + paramJSONObject.toString());
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      long l = paramJsBridgeListener.a();
      PayBridgeActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramJSONObject.toString(), 9, String.valueOf(l), QWalletPayJsPlugin.getPayAppInfo());
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void rechargeGameCurrency(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "rechargeCurrency requet params json=" + paramJSONObject.toString());
    }
    long l = paramJsBridgeListener.a();
    PayBridgeActivity.tenpay(this.jdField_a_of_type_AndroidAppActivity, paramJSONObject.toString(), 6, String.valueOf(l));
  }
  
  public void rechargeQb(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "rechargeQb requet params json=" + paramJSONObject.toString());
    }
    long l = paramJsBridgeListener.a();
    PayBridgeActivity.tenpay(this.jdField_a_of_type_AndroidAppActivity, paramJSONObject.toString(), 8, String.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PayJsPlugin
 * JD-Core Version:    0.7.0.1
 */