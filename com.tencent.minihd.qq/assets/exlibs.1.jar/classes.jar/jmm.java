import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.PortalConfig;
import com.tencent.mobileqq.portal.PortalManager.RedPacketConfig;
import com.tencent.mobileqq.portal.RedPacketServlet;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class jmm
  extends BroadcastReceiver
{
  private jmm(PortalManager paramPortalManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int m = 0;
    int i = 0;
    int j = -1;
    int k = paramIntent.getIntExtra("portal_type_key", -1);
    int n = paramIntent.getIntExtra("bc_seq", -1);
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "PortalSwictherReceiver, " + paramIntent.getExtras());
    }
    long l;
    boolean bool;
    switch (k)
    {
    case 1003: 
    default: 
      return;
    case 1000: 
    case 1001: 
      l = 0L;
      if (k == 1000) {
        l = NetConnInfoCenter.getServerTimeMillis();
      }
      if (l != this.a.jdField_a_of_type_Long)
      {
        this.a.jdField_a_of_type_Long = l;
        this.a.a(false, 10, 1000L, null);
        this.a.b(null, 2);
      }
      PortalManager.a(this.a, k, "{result:0}", n);
      return;
    case 1002: 
      l = this.a.jdField_a_of_type_Long;
      if (this.a.jdField_a_of_type_AndroidContentSharedPreferences == null) {
        l = BaseApplicationImpl.a().getSharedPreferences(PortalManager.a(this.a).a() + "portal_swither", 0).getLong("key_portal_ct", 0L);
      }
      paramContext = this.a;
      paramIntent = new StringBuilder().append("{result:");
      if (l == 0L) {
        i = 1;
      }
      PortalManager.a(paramContext, 1002, i + "}", n);
      return;
    case 1004: 
      paramContext = paramIntent.getStringExtra("portal_agrs");
      if ((!TextUtils.isEmpty(paramContext)) && (paramContext.length() > 0)) {}
      for (;;)
      {
        try
        {
          paramContext = new JSONObject(paramContext).getString("activityId");
          bool = TextUtils.isEmpty(paramContext);
          if (bool)
          {
            i = -1;
            paramContext = this.a.a(i);
            i = j;
            if (paramContext != null)
            {
              i = j;
              if (!TextUtils.isEmpty(paramContext.hitWording))
              {
                if (paramContext.useFlag != 3) {
                  break label441;
                }
                i = 3;
              }
            }
            if (i == -2) {
              break;
            }
            PortalManager.a(this.a, 1004, String.valueOf(i), n);
            return;
          }
          i = Integer.valueOf(paramContext).intValue();
          continue;
          i = -1;
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PortalManager", 2, "", paramContext);
          }
        }
        continue;
        if (paramContext.useFlag == 2)
        {
          i = 2;
        }
        else if (paramContext.useFlag == 3)
        {
          i = 3;
        }
        else
        {
          i = -2;
          RedPacketServlet.a(PortalManager.a(this.a), paramContext.id, n);
        }
      }
    case 1005: 
      label441:
      paramContext = paramIntent.getStringExtra("portal_agrs");
      if ((TextUtils.isEmpty(paramContext)) || (paramContext.length() <= 0)) {
        break;
      }
    }
    for (;;)
    {
      Object localObject;
      try
      {
        paramContext = new JSONObject(paramContext);
        paramIntent = paramContext.getString("activityId");
        bool = TextUtils.isEmpty(paramIntent);
        if (bool) {
          i = -1;
        }
      }
      catch (Exception paramContext)
      {
        i = -1;
      }
      try
      {
        paramContext = paramContext.getString("fromId");
        k = m;
        j = i;
        if (!TextUtils.isEmpty(paramContext))
        {
          k = Integer.valueOf(paramContext).intValue();
          j = i;
        }
        paramContext = null;
        if (j == -1) {
          break label683;
        }
        paramContext = this.a.a(j);
        if (paramContext == null) {
          break label815;
        }
        paramIntent = this.a;
        localObject = paramContext.createJsonObj();
        if (PortalManager.b(this.a) != null) {
          break label809;
        }
        paramContext = "0";
        PortalManager.a(paramIntent, 1005, ((String)localObject).replace("$last$", paramContext), n);
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          continue;
          i = -1;
          j = -1;
        }
      }
      i = Integer.valueOf(paramIntent).intValue();
      continue;
      k = m;
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.e("PortalManager", 2, "", paramContext);
        k = m;
        j = i;
        continue;
        label683:
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
        if (localObject != null)
        {
          paramIntent = this.a.a(-1L);
          if (paramIntent != null)
          {
            paramContext = paramIntent;
            if (paramIntent.useFlag != 2)
            {
              paramContext = paramIntent;
              if (paramIntent.useFlag == 3) {}
            }
          }
          else if (((PortalManager.RedPacketConfig)localObject).webConfigType == 2)
          {
            paramContext = paramIntent;
            if (k != 1) {
              paramContext = PortalManager.a(this.a);
            }
          }
          else if (((PortalManager.RedPacketConfig)localObject).webConfigType == 3)
          {
            paramContext = paramIntent;
            if (k == 1) {
              paramContext = PortalManager.a(this.a);
            }
          }
          else
          {
            paramContext = paramIntent;
            if (((PortalManager.RedPacketConfig)localObject).webConfigType != 0)
            {
              paramContext = PortalManager.a(this.a);
              continue;
              label809:
              paramContext = "1";
              continue;
              label815:
              PortalManager.a(this.a, 1005, "{data:\"null\"}", n);
              return;
              paramContext = "";
              localObject = paramIntent.getStringExtra("portal_agrs");
              if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 0))
              {
                for (;;)
                {
                  try
                  {
                    paramContext = new JSONObject((String)localObject);
                    localObject = paramContext.getString("activityId");
                    bool = TextUtils.isEmpty((CharSequence)localObject);
                    if (bool) {
                      i = -1;
                    }
                  }
                  catch (Exception paramContext)
                  {
                    i = -1;
                    localObject = "";
                    if (QLog.isColorLevel()) {
                      QLog.e("PortalManager", 2, "", paramContext);
                    }
                    j = -1;
                    paramContext = (Context)localObject;
                    continue;
                  }
                  try
                  {
                    j = Integer.valueOf(paramContext.getString("f_hbType")).intValue();
                    paramContext = paramContext.getString("f_hbUin");
                    this.a.a(true, i, paramIntent.getIntExtra("bc_seq", -1), j, paramContext);
                    return;
                  }
                  catch (Exception paramContext)
                  {
                    continue;
                  }
                  i = Integer.valueOf((String)localObject).intValue();
                }
                RedPacketServlet.b(PortalManager.a(this.a), n, 1007);
                return;
              }
              j = -1;
              k = m;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jmm
 * JD-Core Version:    0.7.0.1
 */