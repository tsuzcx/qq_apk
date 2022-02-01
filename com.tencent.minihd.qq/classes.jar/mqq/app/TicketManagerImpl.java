package mqq.app;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtloginHelper;

public class TicketManagerImpl
  implements TicketManager
{
  private static final int FAIL_NOT_PSKEY_DOMAIN = -5;
  private static final int FAIL_SDK_EXCEPTION = -4;
  private static final int FAIL_TICKET_NULL = -2;
  private static final int FAIL_TICKET_SIG_NULL = -3;
  private static final int FAIL_UIN_NONE = -1;
  public static final String[] PSKEY_DOMAINS = { "game.qq.com" };
  private static final String TAG = "TicketManager";
  private HashMap<String, String> mAlterTicketsMap = new HashMap();
  private final AppRuntime mApp;
  private WtloginHelper mWtLoginHelper;
  
  public TicketManagerImpl(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mWtLoginHelper = new WtloginHelper(BaseApplication.getContext(), true);
    oicq.wlogin_sdk.tools.util.LOGCAT_OUT = false;
  }
  
  public static boolean isPskeyDomain(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (PSKEY_DOMAINS != null)
      {
        bool1 = bool2;
        if (PSKEY_DOMAINS.length > 0)
        {
          arrayOfString = PSKEY_DOMAINS;
          j = arrayOfString.length;
          i = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (paramString.equals(arrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void reportGetTicketResult(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("TicketType", paramString1);
    localHashMap.put("Uin", paramString2);
    localHashMap.put("FailReason", "" + paramInt);
    paramString1 = new RdmReq();
    paramString1.eventName = "dim.Msf.GetTicketResult_4";
    paramString1.elapse = 0L;
    paramString1.size = 0L;
    paramString1.isSucceed = paramBoolean;
    paramString1.isRealTime = false;
    paramString1.params = localHashMap;
    try
    {
      MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramString1).setTimeout(30000L);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public String getA2(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, 64);
        if (localObject == null) {
          continue;
        }
        localObject = ((Ticket)localObject)._sig;
        if (localObject != null)
        {
          reportGetTicketResult(true, "A2", paramString, 0);
          QLog.d("TicketManager", 1, "get ticket succ, a!");
          return HexUtil.bytes2HexStr((byte[])localObject);
        }
        QLog.d("TicketManager", 1, "get ticket failed, A2, sig is null");
        i = -3;
      }
      catch (Exception localException)
      {
        QLog.d("TicketManager", 1, "get ticket failed, A2, exception: " + localException.toString());
        int i = -4;
        continue;
        reportGetTicketResult(false, "A2", paramString, i);
      }
      if ((this.mApp == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.mApp.getAccount())) || (TextUtils.isEmpty((CharSequence)this.mAlterTicketsMap.get("A2")))) {
        continue;
      }
      reportGetTicketResult(true, "A2", paramString, i);
      return (String)this.mAlterTicketsMap.get("A2");
      QLog.d("TicketManager", 1, "get ticket failed, A2, ticket is null");
      i = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, A2, uin is empty!");
      i = -1;
    }
    return null;
  }
  
  public String getPskey(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString1, 16L, 1048576);
        if ((localObject == null) || (((Ticket)localObject)._pskey_map == null)) {
          continue;
        }
        localObject = (byte[])((Ticket)localObject)._pskey_map.get(paramString2);
        if (localObject != null)
        {
          reportGetTicketResult(true, "PSKEY", paramString1, 0);
          QLog.d("TicketManager", 1, "get ticket succ, ps!");
          return new String((byte[])localObject);
        }
        QLog.d("TicketManager", 1, "get ticket failed, PSKEY, sig is null");
        i = -3;
      }
      catch (Exception localException)
      {
        QLog.d("TicketManager", 1, "get ticket failed, PSKEY, exception: " + localException.toString());
        int i = -4;
        continue;
        reportGetTicketResult(false, "PSKEY", paramString1, i);
        return null;
      }
      if (!isPskeyDomain(paramString2)) {
        break label244;
      }
      if ((this.mApp == null) || (TextUtils.isEmpty(paramString1)) || (!paramString1.equals(this.mApp.getAccount())) || (TextUtils.isEmpty((CharSequence)this.mAlterTicketsMap.get("pskey")))) {
        continue;
      }
      reportGetTicketResult(true, "PSKEY", paramString1, i);
      return (String)this.mAlterTicketsMap.get("pskey");
      QLog.d("TicketManager", 1, "get ticket failed, PSKEY, ticket is null");
      i = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, PSKEY, uin is empty!");
      i = -1;
    }
    label244:
    reportGetTicketResult(true, "PSKEY", paramString1, -5);
    return null;
  }
  
  public String getSid(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, 524288);
        if (localObject == null) {
          continue;
        }
        localObject = ((Ticket)localObject)._sig;
        if (localObject != null)
        {
          reportGetTicketResult(true, "SID", paramString, 0);
          QLog.d("TicketManager", 1, "get ticket succ, s!");
          return new String((byte[])localObject);
        }
        QLog.d("TicketManager", 1, "get ticket failed, SID, sig is null");
        i = -3;
      }
      catch (Exception localException)
      {
        QLog.d("TicketManager", 1, "get ticket failed, SID, exception: " + localException.toString());
        int i = -4;
        continue;
        reportGetTicketResult(false, "SID", paramString, i);
      }
      if ((this.mApp == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.mApp.getAccount())) || (TextUtils.isEmpty((CharSequence)this.mAlterTicketsMap.get("sid")))) {
        continue;
      }
      reportGetTicketResult(true, "SID", paramString, i);
      return (String)this.mAlterTicketsMap.get("sid");
      QLog.d("TicketManager", 1, "get ticket failed, SID, ticket is null");
      i = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, SID, uin is empty!");
      i = -1;
    }
    return null;
  }
  
  public String getSkey(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, 4096);
        if (localObject == null) {
          continue;
        }
        localObject = ((Ticket)localObject)._sig;
        if (localObject != null)
        {
          reportGetTicketResult(true, "SKEY", paramString, 0);
          QLog.d("TicketManager", 1, "get ticket succ, sk!");
          return new String((byte[])localObject);
        }
        QLog.d("TicketManager", 1, "get ticket failed, SKEY, sig is null");
        i = -3;
      }
      catch (Exception localException)
      {
        QLog.d("TicketManager", 1, "get ticket failed, SKEY, exception: " + localException.toString());
        int i = -4;
        continue;
        reportGetTicketResult(false, "SKEY", paramString, i);
      }
      if ((this.mApp == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.mApp.getAccount())) || (TextUtils.isEmpty((CharSequence)this.mAlterTicketsMap.get("skey")))) {
        continue;
      }
      reportGetTicketResult(true, "SKEY", paramString, i);
      return (String)this.mAlterTicketsMap.get("skey");
      QLog.d("TicketManager", 1, "get ticket failed, SKEY, ticket is null");
      i = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, SKEY, uin is empty!");
      i = -1;
    }
    return null;
  }
  
  public String getStweb(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, 32);
        if (localObject == null) {
          continue;
        }
        localObject = ((Ticket)localObject)._sig;
        if (localObject != null)
        {
          reportGetTicketResult(true, "STWEB", paramString, 0);
          QLog.d("TicketManager", 1, "get ticket succ, st!");
          return HexUtil.bytes2HexStr((byte[])localObject);
        }
        QLog.d("TicketManager", 1, "get ticket failed, STWEB, sig is null");
        i = -3;
      }
      catch (Exception localException)
      {
        QLog.d("TicketManager", 1, "get ticket failed, STWEB, exception: " + localException.toString());
        int i = -4;
        continue;
        reportGetTicketResult(false, "STWEB", paramString, i);
      }
      if ((this.mApp == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.mApp.getAccount())) || (TextUtils.isEmpty((CharSequence)this.mAlterTicketsMap.get("stweb")))) {
        continue;
      }
      reportGetTicketResult(true, "STWEB", paramString, i);
      return (String)this.mAlterTicketsMap.get("stweb");
      QLog.d("TicketManager", 1, "get ticket failed, STWEB, ticket is null");
      i = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, STWEB, uin is empty!");
      i = -1;
    }
    return null;
  }
  
  public String getSuperkey(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, 1048576);
        if (localObject == null) {
          continue;
        }
        localObject = ((Ticket)localObject)._sig;
        if (localObject != null)
        {
          reportGetTicketResult(true, "SUPERKEY", paramString, 0);
          QLog.d("TicketManager", 1, "get ticket succ, su!");
          return new String((byte[])localObject);
        }
        QLog.d("TicketManager", 1, "get ticket failed, SUPERKEY, sig is null");
        i = -3;
      }
      catch (Exception localException)
      {
        QLog.d("TicketManager", 1, "get ticket failed, SUPERKEY, exception: " + localException.toString());
        int i = -4;
        continue;
        reportGetTicketResult(false, "SUPERKEY", paramString, i);
      }
      if ((this.mApp == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.mApp.getAccount())) || (TextUtils.isEmpty((CharSequence)this.mAlterTicketsMap.get("superkey")))) {
        continue;
      }
      reportGetTicketResult(true, "SUPERKEY", paramString, i);
      return (String)this.mAlterTicketsMap.get("superkey");
      QLog.d("TicketManager", 1, "get ticket failed, SUPERKEY, ticket is null");
      i = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, SUPERKEY, uin is empty!");
      i = -1;
    }
    return null;
  }
  
  public String getVkey(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, 131072);
        if (localObject == null) {
          continue;
        }
        localObject = ((Ticket)localObject)._sig;
        if (localObject != null)
        {
          reportGetTicketResult(true, "VKEY", paramString, 0);
          QLog.d("TicketManager", 1, "get ticket succ, v!");
          return new String((byte[])localObject);
        }
        QLog.d("TicketManager", 1, "get ticket failed, VKEY, sig is null");
        i = -3;
      }
      catch (Exception localException)
      {
        QLog.d("TicketManager", 1, "get ticket failed, VKEY, exception: " + localException.toString());
        int i = -4;
        continue;
        reportGetTicketResult(false, "VKEY", paramString, i);
      }
      if ((this.mApp == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.mApp.getAccount())) || (TextUtils.isEmpty((CharSequence)this.mAlterTicketsMap.get("vkey")))) {
        continue;
      }
      reportGetTicketResult(true, "VKEY", paramString, i);
      return (String)this.mAlterTicketsMap.get("vkey");
      QLog.d("TicketManager", 1, "get ticket failed, VKEY, ticket is null");
      i = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, VKEY, uin is empty!");
      i = -1;
    }
    return null;
  }
  
  public void notifyRelogin(String paramString)
  {
    NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(null);
    localNewIntent.putExtra("uin", paramString);
    localNewIntent.putExtra("action", 2123);
    this.mApp.getServletContainer().forward(this.mApp, localNewIntent);
  }
  
  public void onDestroy() {}
  
  public void reloadCache(Context paramContext)
  {
    QLog.d("TicketManager", 1, "reload ticket cache");
    if (this.mWtLoginHelper == null)
    {
      this.mWtLoginHelper = new WtloginHelper(paramContext, true);
      return;
    }
    this.mWtLoginHelper.RefreshMemorySig();
  }
  
  public void setAlterTicket(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap == null) || (this.mApp == null)) {}
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    do
    {
      return;
      QLog.d("TicketManager", 1, "set alter tickets for " + MsfSdkUtils.getShortUin(this.mApp.getAccount()));
      str1 = (String)paramHashMap.get("uin");
      str2 = (String)paramHashMap.get("A2");
      str3 = (String)paramHashMap.get("sid");
      str4 = (String)paramHashMap.get("vkey");
      str5 = (String)paramHashMap.get("skey");
      str6 = (String)paramHashMap.get("pskey");
      str7 = (String)paramHashMap.get("stweb");
      paramHashMap = (String)paramHashMap.get("superkey");
    } while ((this.mApp == null) || (this.mApp.getAccount() == null) || (!this.mApp.getAccount().equals(str1)));
    this.mAlterTicketsMap.put("A2", str2);
    this.mAlterTicketsMap.put("sid", str3);
    this.mAlterTicketsMap.put("vkey", str4);
    this.mAlterTicketsMap.put("skey", str5);
    this.mAlterTicketsMap.put("pskey", str6);
    this.mAlterTicketsMap.put("stweb", str7);
    this.mAlterTicketsMap.put("superkey", paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.TicketManagerImpl
 * JD-Core Version:    0.7.0.1
 */