package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.pay.api.MidasAbilityResponse;
import com.pay.api.ability.MidasActivityAbility;
import com.pay.api.ability.MidasActivityAbility.AbsWXShare;
import com.pay.api.ability.MidasActivityAbility.WXMiniProgramShare;
import com.pay.api.ability.MidasActivityAbility.WXWebShare;
import com.tencent.midas.comm.APLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ue
{
  public ArrayList<Handler> a = new ArrayList(1);
  public Object b;
  
  public ue(Context paramContext)
  {
    try
    {
      Method localMethod = Class.forName(c.a("openapi.WXAPIFactory")).getMethod("createWXAPI", new Class[] { Context.class, String.class });
      localMethod.setAccessible(true);
      this.b = localMethod.invoke(null, new Object[] { paramContext, null });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static ue a(Context paramContext)
  {
    return b.a(paramContext.getApplicationContext());
  }
  
  public static boolean b(Context paramContext)
  {
    return a(paramContext).b();
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleIntent got called! intent = ");
    ((StringBuilder)localObject).append(paramIntent);
    APLog.d("APMidasWXPayHelper", ((StringBuilder)localObject).toString());
    if (this.b != null) {
      try
      {
        localObject = Class.forName(c.a("openapi.IWXAPIEventHandler"));
        ClassLoader localClassLoader = ((Class)localObject).getClassLoader();
        a locala = new a();
        localObject = Proxy.newProxyInstance(localClassLoader, new Class[] { localObject }, locala);
        c.a(this.b, "handleIntent", new Object[] { paramIntent, localObject });
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Object localObject1 = c.c("modelpay.PayReq");
    c.a(localObject1, "appId", paramBundle.getString("wxAppId"));
    c.a(localObject1, "partnerId", paramBundle.getString("partnerId"));
    c.a(localObject1, "prepayId", paramBundle.getString("prepayId"));
    c.a(localObject1, "nonceStr", paramBundle.getString("nonceStr"));
    c.a(localObject1, "timeStamp", paramBundle.getString("timeStamp"));
    c.a(localObject1, "packageValue", paramBundle.getString("package"));
    c.a(localObject1, "sign", paramBundle.getString("sign"));
    Object localObject2 = c.c("modelpay.PayReq$Options");
    c.a(localObject2, "callbackClassName", "com.tencent.midas.wx.APMidasWXPayActivity");
    c.a(localObject1, "options", localObject2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("sendReq params:");
    ((StringBuilder)localObject2).append(localObject1);
    APLog.i("APMidawxPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("appId:");
    ((StringBuilder)localObject2).append(paramBundle.getString("wxAppId"));
    APLog.i("APMidawxPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("partnerId:");
    ((StringBuilder)localObject2).append(paramBundle.getString("partnerId"));
    APLog.i("APMidawxPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("prepayId:");
    ((StringBuilder)localObject2).append(paramBundle.getString("prepayId"));
    APLog.i("APMidawxPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("nonceStr:");
    ((StringBuilder)localObject2).append(paramBundle.getString("nonceStr"));
    APLog.i("APMidawxPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("timeStamp:");
    ((StringBuilder)localObject2).append(paramBundle.getString("timeStamp"));
    APLog.i("APMidawxPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("packageValue:");
    ((StringBuilder)localObject2).append(paramBundle.getString("package"));
    APLog.i("APMidawxPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("sign:");
    ((StringBuilder)localObject2).append(paramBundle.getString("sign"));
    APLog.i("APMidawxPayHelper", ((StringBuilder)localObject2).toString());
    localObject2 = this.b;
    paramBundle = paramBundle.getString("wxAppId");
    c.a(localObject2, "registerApp", new Class[] { String.class }, new Object[] { paramBundle });
    c.a(this.b, "sendReq", new Class[] { localObject1.getClass().getSuperclass() }, new Object[] { localObject1 });
  }
  
  public void a(Handler paramHandler)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("addObserver observer:");
    ((StringBuilder)???).append(paramHandler);
    APLog.i("APMidawxPayHelper", ((StringBuilder)???).toString());
    synchronized (this.a)
    {
      if (!this.a.contains(paramHandler)) {
        this.a.add(paramHandler);
      }
      return;
    }
  }
  
  public void a(MidasActivityAbility paramMidasActivityAbility, MidasActivityAbility.WXMiniProgramShare paramWXMiniProgramShare, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = c.b("modelmsg.WXMiniProgramObject");
    if (paramString1 == null)
    {
      APLog.w("APMidasWXPayHelper", "shareWebPage() is not support");
      MidasAbilityResponse.onFailureLIB(paramMidasActivityAbility, -1, "shareWebPage() is not support", new Bundle());
      return;
    }
    c.a(paramString1.getClass(), paramString1, "webpageUrl", paramString4);
    c.a(paramString1.getClass(), paramString1, "miniprogramType", Integer.valueOf(paramWXMiniProgramShare.miniprogramType));
    c.a(paramString1.getClass(), paramString1, "userName", paramString2);
    c.a(paramString1.getClass(), paramString1, "path", paramString3);
    c.a(paramString1.getClass(), paramString1, "withShareTicket", Boolean.valueOf(paramWXMiniProgramShare.withShareTicket));
    paramString2 = c.b("modelmsg.WXMediaMessage");
    c.a(paramString2.getClass(), paramString2, "mediaObject", paramString1);
    c.a(paramString2.getClass(), paramString2, "title", paramWXMiniProgramShare.title);
    c.a(paramString2.getClass(), paramString2, "description", paramWXMiniProgramShare.description);
    c.a(paramString2.getClass(), paramString2, "thumbData", paramWXMiniProgramShare.thumbData);
    paramString1 = c.b("modelmsg.SendMessageToWX$Req");
    c.a(paramString1.getClass(), paramString1, "transaction", paramWXMiniProgramShare.transaction);
    c.a(paramString1.getClass(), paramString1, "message", paramString2);
    c.a(paramString1.getClass(), paramString1, "scene", Integer.valueOf(paramWXMiniProgramShare.scene));
    c.a(this.b.getClass(), this.b, "sendReq", new Class[] { paramString1.getClass().getSuperclass() }, new Object[] { paramString1 });
    MidasAbilityResponse.onSuccess(paramMidasActivityAbility, 0, new Bundle());
  }
  
  public void a(MidasActivityAbility paramMidasActivityAbility, MidasActivityAbility.WXWebShare paramWXWebShare, String paramString1, String paramString2)
  {
    paramString1 = c.b("modelmsg.WXWebpageObject");
    if (paramString1 == null)
    {
      APLog.w("APMidasWXPayHelper", "shareWebPage() is not support");
      MidasAbilityResponse.onFailureLIB(paramMidasActivityAbility, -1, "shareWebPage() is not support", new Bundle());
      return;
    }
    c.a(paramString1.getClass(), paramString1, "webpageUrl", paramString2);
    paramString2 = c.b("modelmsg.WXMediaMessage");
    c.a(paramString2.getClass(), paramString2, "mediaObject", paramString1);
    c.a(paramString2.getClass(), paramString2, "title", paramWXWebShare.title);
    c.a(paramString2.getClass(), paramString2, "description", paramWXWebShare.description);
    c.a(paramString2.getClass(), paramString2, "thumbData", paramWXWebShare.thumbData);
    paramString1 = c.b("modelmsg.SendMessageToWX$Req");
    c.a(paramString1.getClass(), paramString1, "transaction", paramWXWebShare.transaction);
    c.a(paramString1.getClass(), paramString1, "message", paramString2);
    c.a(paramString1.getClass(), paramString1, "scene", Integer.valueOf(paramWXWebShare.scene));
    c.a(paramString1.getClass(), paramString1, "userOpenId", paramWXWebShare.userOpenId);
    c.a(this.b.getClass(), this.b, "sendReq", new Class[] { paramString1.getClass().getSuperclass() }, new Object[] { paramString1 });
    MidasAbilityResponse.onSuccess(paramMidasActivityAbility, 0, new Bundle());
  }
  
  public void a(String paramString1, String paramString2)
  {
    APLog.i("APMidawxPayHelper", "addCardCoupons");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("cardId=");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(";wxsign=");
    ((StringBuilder)localObject1).append(paramString2);
    APLog.i("微信支付领取话费券", ((StringBuilder)localObject1).toString());
    APLog.i("微信支付领取话费券cardExtMsg", paramString2);
    localObject1 = new ArrayList();
    Object localObject2 = c.c("modelbiz.AddCardToWXCardPackage$WXCardItem");
    c.a(localObject2, "cardId", paramString1);
    c.a(localObject2, "cardExtMsg", paramString2);
    ((List)localObject1).add(localObject2);
    paramString1 = c.c("modelbiz.AddCardToWXCardPackage$Req");
    c.a(paramString1, "cardArrary", localObject1);
    c.a(paramString1, "transaction", "wechatAddCardToWXCardPackage");
    boolean bool = ((Boolean)c.a(this.b, "sendReq", new Class[] { paramString1.getClass().getSuperclass() }, new Object[] { paramString1 })).booleanValue();
    paramString1 = new StringBuilder();
    paramString1.append("sendMsg ret:");
    paramString1.append(bool);
    APLog.i("APMidawxPayHelper", paramString1.toString());
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = c.c("modelbiz.WXLaunchMiniProgram$Req");
    c.a(localObject, "userName", paramString1);
    c.a(localObject, "path", paramString2);
    c.a(localObject, "miniprogramType", Integer.valueOf(paramInt));
    c.a(this.b, "sendReq", new Class[] { localObject.getClass().getSuperclass() }, new Object[] { localObject });
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = c.c("modelbiz.WXOpenBusinessView$Req");
    c.a(localObject, "businessType", paramString1);
    c.a(localObject, "query", paramString2);
    c.a(localObject, "extInfo", paramString3);
    c.a(this.b, "sendReq", new Class[] { localObject.getClass().getSuperclass() }, new Object[] { localObject });
  }
  
  public boolean a()
  {
    return vd.b(c.a("modelbiz.WXLaunchMiniProgram$Req"));
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      Object localObject1 = c.a(this.b.getClass(), this.b, "getWXAppSupportAPI", null, null);
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isSupportWechatAPI() ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" => curResult==Null");
        APLog.i("APMidasWXPayHelper", ((StringBuilder)localObject1).toString());
        return false;
      }
      int i = ((Integer)localObject1).intValue();
      Object localObject2 = c.a(Class.forName(c.a("constants.Build")), null, paramString);
      if (localObject2 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("isSupportWechatAPI() ");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(" => ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" : targetResult==Null");
        APLog.w("APMidasWXPayHelper", ((StringBuilder)localObject2).toString());
        return false;
      }
      int j = ((Integer)localObject2).intValue();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportWechatAPI() ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" : ");
      localStringBuilder.append(localObject1);
      localStringBuilder.append(">=");
      localStringBuilder.append(localObject2);
      APLog.i("APMidasWXPayHelper", localStringBuilder.toString());
      if (i >= j) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      APLog.i("APMidasWXPayHelper", "isSupportWechatAPI() apiSDKName finally false");
    }
    return false;
  }
  
  public void b(Handler paramHandler)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("removeObserver observer:");
    ((StringBuilder)???).append(paramHandler);
    APLog.i("APMidawxPayHelper", ((StringBuilder)???).toString());
    synchronized (this.a)
    {
      if (this.a.contains(paramHandler)) {
        this.a.remove(paramHandler);
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = this.b;
    if (localObject != null) {
      c.a(localObject, "registerApp", new Object[] { paramString });
    }
  }
  
  public boolean b()
  {
    Object localObject = this.b;
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = c.a(localObject, "isWXAppInstalled", null);
    if (localObject != null) {
      bool = ((Boolean)localObject).booleanValue();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isWXinstalled:");
    ((StringBuilder)localObject).append(bool);
    APLog.i("APMidaWXPayHelper", ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public class a
    implements InvocationHandler
  {
    public a() {}
    
    public Object invoke(Object paramObject, Method arg2, Object[] paramArrayOfObject)
      throws Throwable
    {
      APLog.d("APMidasWXPayHelper", "handleIntent.IWXAPIEventHandler callback");
      if (???.getName().equals("onResp"))
      {
        int i = 0;
        ??? = paramArrayOfObject[0];
        paramObject = new StringBuilder();
        paramObject.append("openapi.IWXAPIEventHandler callback resp=");
        paramObject.append(???);
        APLog.d("handleIntent", paramObject.toString());
        paramObject = new Bundle();
        paramObject.putInt("type", ((Integer)ue.c.a(???, "getType", new Class[0], new Object[0])).intValue());
        paramArrayOfObject = ???.getClass().getFields();
        int j = paramArrayOfObject.length;
        Object localObject;
        while (i < j)
        {
          localObject = paramArrayOfObject[i];
          if (((Field)localObject).getType().isPrimitive()) {
            ue.c.a(paramObject, ???, (Field)localObject);
          } else if (((Field)localObject).getType() == String.class) {
            paramObject.putString(((Field)localObject).getName(), (String)((Field)localObject).get(???));
          } else if (((Field)localObject).getType().isArray()) {
            if (((Field)localObject).getType().getComponentType().isPrimitive()) {
              ue.c.b(paramObject, ???, (Field)localObject);
            } else if (((Field)localObject).getType().getComponentType() == String.class) {
              paramObject.putStringArray(((Field)localObject).getName(), (String[])((Field)localObject).get(???));
            }
          }
          i += 1;
        }
        ??? = new StringBuilder();
        ???.append("openapi.IWXAPIEventHandler callback, b = ");
        ???.append(paramObject);
        APLog.d("handleIntent", ???.toString());
        synchronized (ue.a(ue.this))
        {
          paramArrayOfObject = ue.a(ue.this).iterator();
          while (paramArrayOfObject.hasNext())
          {
            localObject = (Handler)paramArrayOfObject.next();
            Message localMessage = Message.obtain();
            localMessage.what = 10;
            localMessage.setData(new Bundle(paramObject));
            ((Handler)localObject).sendMessage(localMessage);
          }
        }
      }
      return null;
    }
  }
  
  public static class b
  {
    public static ue a;
    
    public static ue b(Context paramContext)
    {
      if (a == null) {
        a = new ue(paramContext, null);
      }
      return a;
    }
  }
  
  public static class c
  {
    public static String a = "com.tencent.mm.sdk";
    public static String b = "com.tencent.mm.opensdk";
    public static int c = -1;
    
    public static void a(Bundle paramBundle, Object paramObject, Field paramField)
    {
      try
      {
        if (paramField.getType() == Byte.TYPE)
        {
          paramBundle.putByte(paramField.getName(), paramField.getByte(paramObject));
          return;
        }
        if (paramField.getType() == Short.TYPE)
        {
          paramBundle.putShort(paramField.getName(), paramField.getShort(paramObject));
          return;
        }
        if (paramField.getType() == Integer.TYPE)
        {
          paramBundle.putInt(paramField.getName(), paramField.getInt(paramObject));
          return;
        }
        if (paramField.getType() == Long.TYPE)
        {
          paramBundle.putLong(paramField.getName(), paramField.getLong(paramObject));
          return;
        }
        if (paramField.getType() == Character.TYPE)
        {
          paramBundle.putChar(paramField.getName(), paramField.getChar(paramObject));
          return;
        }
        if (paramField.getType() == Float.TYPE)
        {
          paramBundle.putFloat(paramField.getName(), paramField.getFloat(paramObject));
          return;
        }
        if (paramField.getType() == Double.TYPE)
        {
          paramBundle.putDouble(paramField.getName(), paramField.getDouble(paramObject));
          return;
        }
        if (paramField.getType() == Boolean.TYPE)
        {
          paramBundle.putBoolean(paramField.getName(), paramField.getBoolean(paramObject));
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramObject = new StringBuilder();
        paramObject.append("setBundlePrimitive() e = ");
        paramObject.append(paramBundle.toString());
        APLog.e("APMidasWXPayHelper", paramObject.toString());
      }
    }
    
    public static Class<?>[] a(Object[] paramArrayOfObject)
    {
      if (paramArrayOfObject != null)
      {
        Class[] arrayOfClass = new Class[paramArrayOfObject.length];
        int i = 0;
        for (;;)
        {
          localObject = arrayOfClass;
          if (i >= arrayOfClass.length) {
            break;
          }
          if (paramArrayOfObject[i] != null)
          {
            localObject = paramArrayOfObject[i].getClass();
            if (Activity.class.isAssignableFrom((Class)localObject)) {
              arrayOfClass[i] = Activity.class;
            } else if (Proxy.isProxyClass((Class)localObject)) {
              arrayOfClass[i] = localObject.getInterfaces()[0];
            } else {
              arrayOfClass[i] = paramArrayOfObject[i].getClass();
            }
          }
          i += 1;
        }
      }
      Object localObject = null;
      return localObject;
    }
    
    public static Object b(Class<?> paramClass, Object paramObject, String paramString)
    {
      try
      {
        paramClass = paramClass.getField(paramString);
        paramClass.setAccessible(true);
        paramClass = paramClass.get(paramObject);
        return paramClass;
      }
      catch (Exception paramClass)
      {
        paramClass.printStackTrace();
      }
      return null;
    }
    
    public static Object b(Class<?> paramClass, Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        paramClass = paramClass.getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
        return paramClass;
      }
      catch (Exception paramClass)
      {
        paramClass.printStackTrace();
      }
      return null;
    }
    
    public static Object b(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        paramString = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
        paramString.setAccessible(true);
        paramObject = paramString.invoke(paramObject, paramArrayOfObject);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
      return null;
    }
    
    public static Object b(Object paramObject, String paramString, Object[] paramArrayOfObject)
    {
      return b(paramObject, paramString, a(paramArrayOfObject), paramArrayOfObject);
    }
    
    public static void b(Bundle paramBundle, Object paramObject, Field paramField)
    {
      try
      {
        if (paramField.getType().getComponentType() == Byte.TYPE)
        {
          paramBundle.putByteArray(paramField.getName(), (byte[])paramField.get(paramObject));
          return;
        }
        if (paramField.getType().getComponentType() == Short.TYPE)
        {
          paramBundle.putShortArray(paramField.getName(), (short[])paramField.get(paramObject));
          return;
        }
        if (paramField.getType().getComponentType() == Integer.TYPE)
        {
          paramBundle.putIntArray(paramField.getName(), (int[])paramField.get(paramObject));
          return;
        }
        if (paramField.getType().getComponentType() == Long.TYPE)
        {
          paramBundle.putLongArray(paramField.getName(), (long[])paramField.get(paramObject));
          return;
        }
        if (paramField.getType().getComponentType() == Character.TYPE)
        {
          paramBundle.putCharArray(paramField.getName(), (char[])paramField.get(paramObject));
          return;
        }
        if (paramField.getType().getComponentType() == Float.TYPE)
        {
          paramBundle.putFloatArray(paramField.getName(), (float[])paramField.get(paramObject));
          return;
        }
        if (paramField.getType().getComponentType() == Double.TYPE)
        {
          paramBundle.putDoubleArray(paramField.getName(), (double[])paramField.get(paramObject));
          return;
        }
        if (paramField.getType().getComponentType() == Boolean.TYPE)
        {
          paramBundle.putBooleanArray(paramField.getName(), (boolean[])paramField.get(paramObject));
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramObject = new StringBuilder();
        paramObject.append("setBundlePrimitive() e = ");
        paramObject.append(paramBundle.toString());
        APLog.e("APMidasWXPayHelper", paramObject.toString());
      }
    }
    
    public static boolean b(Class<?> paramClass, Object paramObject1, String paramString, Object paramObject2)
    {
      try
      {
        paramClass = paramClass.getField(paramString);
        paramClass.setAccessible(true);
        paramClass.set(paramObject1, paramObject2);
        return true;
      }
      catch (Exception paramClass)
      {
        paramClass.printStackTrace();
      }
      return false;
    }
    
    public static boolean b(Object paramObject1, String paramString, Object paramObject2)
    {
      try
      {
        paramString = paramObject1.getClass().getField(paramString);
        paramString.setAccessible(true);
        paramString.set(paramObject1, paramObject2);
        return true;
      }
      catch (Exception paramObject1)
      {
        paramObject1.printStackTrace();
      }
      return false;
    }
    
    public static String d(String paramString)
    {
      if (c < 0) {}
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(b);
        localStringBuilder.append(".openapi.IWXAPI");
        Class.forName(localStringBuilder.toString());
        c = 1;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        label45:
        break label45;
      }
      c = 0;
      if (c > 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(b);
        localStringBuilder.append(".");
        localStringBuilder.append(paramString);
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    
    public static Object e(String paramString)
    {
      try
      {
        paramString = d(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("packageClassName = ");
        localStringBuilder.append(paramString);
        APLog.d("newInstance", localStringBuilder.toString());
        paramString = Class.forName(paramString).newInstance();
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return null;
    }
    
    public static Object f(String paramString)
    {
      try
      {
        paramString = d(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("packageClassName = ");
        localStringBuilder.append(paramString);
        APLog.d("reflectInstance", localStringBuilder.toString());
        paramString = Class.forName(paramString).newInstance();
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ue
 * JD-Core Version:    0.7.0.1
 */