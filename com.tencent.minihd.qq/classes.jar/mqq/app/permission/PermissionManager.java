package mqq.app.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(23)
public class PermissionManager
{
  private static final int GRANTED = 0;
  private static final int LOSTTIME = 172800000;
  private static final String m_str_key_x = "c_permission_sharepreference";
  private PermissionCallback callback;
  private Activity inActivity;
  private PermissionItem[] ps;
  private ConcurrentHashMap<Object, Object> tips = new ConcurrentHashMap();
  
  private PermissionManager(Activity paramActivity)
  {
    this.inActivity = paramActivity;
    if (this.tips.isEmpty())
    {
      this.tips.put("android.permission.CALL_PHONE", "拨号");
      this.tips.put("android.permission.RECORD_AUDIO", "麦克风");
      this.tips.put("android.permission.CAMERA", "摄像头");
      this.tips.put("android.permission.WRITE_EXTERNAL_STORAGE", "写存储");
      this.tips.put("android.permission.READ_EXTERNAL_STORAGE", "读存储");
      this.tips.put("android.permission.READ_PHONE_STATE", "电话权限");
      this.tips.put("android.permission.ACCESS_FINE_LOCATION", "位置");
    }
  }
  
  public static PermissionManager init(Activity paramActivity)
  {
    return new PermissionManager(paramActivity);
  }
  
  private static void save(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("c_permission_sharepreference", 0).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
  
  public boolean checkPermission(String paramString)
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (this.inActivity.checkSelfPermission(paramString) == 0) {
      return true;
    }
    return false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i;
    if (paramArrayOfString.length > 0)
    {
      i = 0;
      StringBuilder localStringBuilder = new StringBuilder();
      int k = 0;
      while (k < paramArrayOfInt.length)
      {
        int j = i;
        if (paramArrayOfInt[k] != 0)
        {
          j = i;
          if (i == 0) {
            j = -1;
          }
          if (localStringBuilder.indexOf((String)this.tips.get(paramArrayOfString[k])) < 0) {
            localStringBuilder.append(this.tips.get(paramArrayOfString[k])).append("、");
          }
          if (this.inActivity.shouldShowRequestPermissionRationale(paramArrayOfString[k])) {
            j = -2;
          }
        }
        k += 1;
        i = j;
      }
      if (i == 0) {
        this.callback.grant(paramInt, paramArrayOfString, paramArrayOfInt);
      }
    }
    else
    {
      return;
    }
    if (i == -1)
    {
      this.callback.deny(paramInt, paramArrayOfString, paramArrayOfInt);
      return;
    }
    this.callback.deny(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public boolean permissionHasRequest(PermissionItem[] paramArrayOfPermissionItem)
  {
    int j = paramArrayOfPermissionItem.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfPermissionItem[i];
      localObject = Long.valueOf(Long.valueOf(permission_sp_get(BaseApplication.getContext(), ((PermissionItem)localObject).getPermissionKey())).longValue());
      Log.e("permissionHasRequest", "time===" + localObject);
      if (System.currentTimeMillis() - ((Long)localObject).longValue() > 172800000L)
      {
        Log.e("permissionHasRequest", "System.currentTimeMillis()-lastTime" + (System.currentTimeMillis() - ((Long)localObject).longValue()));
        Log.e("permissionHasRequest", "false");
        return false;
      }
      i += 1;
    }
    Log.e("permissionHasRequest", "true");
    return true;
  }
  
  public void permission_deny()
  {
    Object localObject = new ArrayList();
    PermissionItem[] arrayOfPermissionItem = this.ps;
    int j = arrayOfPermissionItem.length;
    int i = 0;
    while (i < j)
    {
      ((List)localObject).add(arrayOfPermissionItem[i].getPermissionKey());
      i += 1;
    }
    localObject = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
    this.callback.deny(9999, (String[])localObject, null);
  }
  
  public String permission_sp_get(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("c_permission_sharepreference", 0);
      Log.e("permission_sp_get", paramContext.getString(paramString, "0"));
      return paramContext.getString(paramString, "0");
    }
    return "0";
  }
  
  public void permission_sp_set(PermissionItem[] paramArrayOfPermissionItem)
  {
    int j = paramArrayOfPermissionItem.length;
    int i = 0;
    while (i < j)
    {
      PermissionItem localPermissionItem = paramArrayOfPermissionItem[i];
      Log.e("permission_sp_set", localPermissionItem.getPermissionKey() + "lasttime " + String.valueOf(System.currentTimeMillis()));
      save(BaseApplication.getContext(), localPermissionItem.getPermissionKey(), String.valueOf(System.currentTimeMillis()));
      i += 1;
    }
  }
  
  @TargetApi(23)
  public PermissionManager permissions(PermissionItem... paramVarArgs)
  {
    this.ps = null;
    if ((Build.VERSION.SDK_INT >= 23) && (paramVarArgs.length > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        PermissionItem localPermissionItem = paramVarArgs[i];
        if (this.inActivity.checkSelfPermission(localPermissionItem.getPermissionKey()) != 0) {
          localArrayList.add(localPermissionItem);
        }
        i += 1;
      }
      this.ps = ((PermissionItem[])localArrayList.toArray(new PermissionItem[localArrayList.size()]));
    }
    return this;
  }
  
  public void request(PermissionCallback paramPermissionCallback)
  {
    if ((this.ps != null) && (this.ps.length > 0))
    {
      this.callback = paramPermissionCallback;
      if (!permissionHasRequest(this.ps)) {
        break label36;
      }
      permission_deny();
    }
    for (;;)
    {
      return;
      label36:
      paramPermissionCallback = this.ps;
      int j = paramPermissionCallback.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramPermissionCallback[i];
        Activity localActivity = this.inActivity;
        String str = localObject.getPermissionKey();
        int k = localObject.getRequestCode();
        localActivity.requestPermissions(new String[] { str }, k);
        permission_sp_set(this.ps);
        i += 1;
      }
    }
  }
  
  public void requests(PermissionCallback paramPermissionCallback)
  {
    int j;
    if ((this.ps != null) && (this.ps.length > 0))
    {
      this.callback = paramPermissionCallback;
      paramPermissionCallback = new ArrayList();
      j = 9999;
      if (permissionHasRequest(this.ps)) {
        permission_deny();
      }
    }
    else
    {
      return;
    }
    PermissionItem[] arrayOfPermissionItem = this.ps;
    int k = arrayOfPermissionItem.length;
    int i = 0;
    while (i < k)
    {
      PermissionItem localPermissionItem = arrayOfPermissionItem[i];
      paramPermissionCallback.add(localPermissionItem.getPermissionKey());
      j = localPermissionItem.getRequestCode();
      i += 1;
    }
    this.inActivity.requestPermissions((String[])paramPermissionCallback.toArray(new String[paramPermissionCallback.size()]), j);
    permission_sp_set(this.ps);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.permission.PermissionManager
 * JD-Core Version:    0.7.0.1
 */