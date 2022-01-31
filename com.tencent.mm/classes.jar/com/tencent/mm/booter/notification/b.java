package com.tencent.mm.booter.notification;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.aa;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.al;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.y.1;
import com.tencent.mm.platformtools.y.2;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI;
import com.tencent.mm.plugin.messenger.foundation.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.LauncherUI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
  implements al, ao
{
  bi bWO;
  Context context = null;
  private String diX;
  private String diY;
  String diZ;
  Intent dja;
  private boolean djb;
  private int djc;
  private boolean djd;
  private long dje;
  f djf = f.a.wy();
  private com.tencent.mm.booter.notification.a.e djg;
  @SuppressLint({"HandlerLeak"})
  ah djh = new b.1(this, Looper.getMainLooper());
  private final com.tencent.mm.sdk.b.c dji = new b.2(this);
  private final com.tencent.mm.sdk.b.c djj = new b.3(this);
  String talker;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
    this.talker = "";
    this.diZ = "";
    this.diX = "";
    this.dje = 0L;
    this.djd = false;
    this.dja = null;
    this.djg = new com.tencent.mm.booter.notification.a.e();
    g.a(this);
    com.tencent.mm.modelvoice.e.a(this);
    com.tencent.mm.plugin.base.stub.b.a(this);
    com.tencent.mm.sdk.b.a.udP.c(this.djj);
    com.tencent.mm.sdk.b.a.udP.c(this.dji);
  }
  
  public static int b(bi parambi)
  {
    int j = 0;
    int i;
    if (s.hl(parambi.field_talker))
    {
      i = 0;
      if ((parambi.field_bizChatId == -1L) || (!com.tencent.mm.ai.f.eW(parambi.field_talker))) {
        break label71;
      }
      com.tencent.mm.ai.a.c localc = z.MA().aj(parambi.field_bizChatId);
      if ((localc.isGroup()) || (!localc.il(1))) {
        break label71;
      }
    }
    label71:
    do
    {
      do
      {
        return i;
        i = 3;
        break;
        parambi = parambi.czr;
      } while (bk.bl(parambi));
      parambi = bn.s(parambi, "msgsource");
    } while ((parambi == null) || (parambi.isEmpty()));
    for (;;)
    {
      int k;
      try
      {
        k = bk.getInt((String)parambi.get(".msgsource.tips"), i);
        if (((k & 0x1) == 0) && ((k & 0x2) != 0))
        {
          i = j;
          return i;
        }
      }
      catch (Exception parambi)
      {
        return i;
      }
      i = k;
    }
  }
  
  static Message b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    y.d("MicroMsg.MMNotification", "[wrapMessage] talker:%s msgType:%s stack:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), bk.csb().toString() });
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("notification.show.talker", paramString1);
    localBundle.putString("notification.show.message.content", paramString2);
    localBundle.putInt("notification.show.message.type", paramInt1);
    localBundle.putInt("notification.show.tipsflag", paramInt2);
    localMessage.setData(localBundle);
    localMessage.what = paramInt3;
    return localMessage;
  }
  
  private void cancel()
  {
    this.djd = false;
    e.cancel();
  }
  
  public final void C(List<bi> paramList)
  {
    String str = null;
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (paramList == null) {}
      for (i = -1;; i = paramList.size())
      {
        y.w("MicroMsg.MMNotification", "notifyOther newMsgList:%d :%s", new Object[] { Integer.valueOf(i), bk.csb() });
        return;
      }
    }
    int j = paramList.size() - 1;
    int i = 0;
    bi localbi;
    for (;;)
    {
      if (j < 0) {
        break label234;
      }
      localbi = (bi)paramList.get(j);
      i = b(localbi);
      if (f.a(localbi.field_talker, localbi, i, false)) {
        break;
      }
      j -= 1;
    }
    label234:
    for (paramList = localbi;; paramList = str)
    {
      if (paramList == null)
      {
        y.w("MicroMsg.MMNotification", "notifyOther msg == null");
        return;
      }
      this.diZ = "";
      this.talker = paramList.field_talker;
      str = paramList.field_content;
      j = paramList.getType();
      this.bWO = paramList;
      y.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(paramList.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), bk.aac(str) });
      this.djh.sendMessageDelayed(b(this.talker, str, j, i, 0), 200L);
      return;
    }
  }
  
  public final int a(Notification paramNotification, boolean paramBoolean)
  {
    return f.a.wy().a(new NotificationItem(paramNotification, paramBoolean));
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    return f.a.wy().djJ.djB.a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt2, String paramString4, PendingIntent paramPendingIntent2, int paramInt3, String paramString5, PendingIntent paramPendingIntent3, String paramString6)
  {
    return f.a.wy().djJ.djB.a(paramNotification, paramInt1, 1, paramPendingIntent1, paramString1, paramString2, paramString3, paramBitmap, paramInt2, paramString4, paramPendingIntent2, paramInt3, paramString5, paramPendingIntent3, paramString6);
  }
  
  public final Notification a(PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    return a(null, -1, 0, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
  }
  
  public final void a(int paramInt, Notification paramNotification, boolean paramBoolean)
  {
    f.a.wy().a(new NotificationItem(paramInt, paramNotification, paramBoolean));
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    com.tencent.mm.br.d.a("webview", new y.1(paramString3, paramString4, paramBundle, paramString1, paramString2, paramInt), new y.2());
  }
  
  public final void a(bi parambi)
  {
    if (parambi == null) {}
    do
    {
      return;
      if (parambi.field_isSend == 1)
      {
        y.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", new Object[] { Long.valueOf(parambi.field_msgSvrId) });
        return;
      }
      localObject = bd.iM(parambi.czr);
    } while ((localObject != null) && (((bd.b)localObject).scene == 1));
    int i = b(parambi);
    this.bWO = parambi;
    this.talker = parambi.field_talker;
    Object localObject = parambi.field_content;
    int j = parambi.getType();
    this.diZ = "";
    this.dja = null;
    y.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(parambi.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), bk.aac((String)localObject) });
    if (!f.a(this.talker, this.bWO, i, false))
    {
      y.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
      return;
    }
    this.djh.sendMessageDelayed(b(this.talker, (String)localObject, j, i, 0), 200L);
  }
  
  public final void bc(boolean paramBoolean)
  {
    y.i("MicroMsg.MMNotification", "set isMainUI: %s, stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bk.csb() });
    this.djb = paramBoolean;
  }
  
  public final void bd(boolean paramBoolean)
  {
    d.be(paramBoolean);
  }
  
  public final int c(Notification paramNotification)
  {
    return a(paramNotification, true);
  }
  
  public final void cancel(int paramInt)
  {
    f.a.wy();
    com.tencent.mm.booter.notification.queue.b.wz().cancel(paramInt);
  }
  
  public final void cancelNotification(String paramString)
  {
    int i = 1;
    y.v("MicroMsg.MMNotification", "cancel notification talker:" + paramString + " last talker:" + this.diY + "  curChattingTalker:" + this.diX + " talker count:" + this.djc);
    if (!this.djd) {}
    do
    {
      return;
      if ((this.diY != null) && (this.diY.equals(this.diX)) && (this.djc == 1)) {}
      while (i != 0)
      {
        cancel();
        return;
        i = 0;
      }
      au.Hx();
      paramString = com.tencent.mm.model.c.FB().abv(paramString);
      if ((paramString != null) && (paramString.field_unReadCount != 0))
      {
        cancel();
        return;
      }
    } while (t.ie(s.dUT) != 0);
    cancel();
  }
  
  public final void ew(String paramString)
  {
    this.diX = paramString;
  }
  
  public final void ex(String paramString)
  {
    Intent localIntent = new Intent(this.context, LauncherUI.class);
    localIntent.putExtra("Intro_Notify", true);
    localIntent.putExtra("Intro_Notify_User", this.talker);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    String str = paramString;
    if (!bk.bl(paramString))
    {
      str = paramString;
      if (paramString.startsWith("autoauth_errmsg_")) {
        str = paramString.substring(16);
      }
    }
    paramString = str;
    if (!bk.bl(str))
    {
      paramString = str;
      if (str.startsWith("<"))
      {
        Map localMap = bn.s(str, "e");
        paramString = str;
        if (localMap != null)
        {
          paramString = str;
          if (!bk.bl((String)localMap.get(".e.Content"))) {
            paramString = (String)localMap.get(".e.Content");
          }
        }
      }
    }
    paramString = new Notification.Builder(this.context).setContentTitle(paramString).setContentText(null).setContentIntent(PendingIntent.getActivity(this.context, 0, localIntent, 268435456)).getNotification();
    paramString.icon = com.tencent.mm.bq.a.bSL();
    paramString.flags = 16;
    a(paramString, true);
  }
  
  public final void fS(int paramInt)
  {
    Object localObject = new Intent(this.context, LauncherUI.class);
    ((Intent)localObject).addFlags(536870912);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("nofification_type", "update_nofification");
    ((Intent)localObject).putExtra("show_update_dialog", true);
    ((Intent)localObject).putExtra("update_type", paramInt);
    localObject = PendingIntent.getActivity(this.context, 0, (Intent)localObject, 0);
    localObject = new Notification.Builder(this.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.context.getString(R.l.app_update_package_notify)).setContentText(this.context.getString(R.l.app_recommend_update)).setContentIntent((PendingIntent)localObject).getNotification();
    ((Notification)localObject).flags |= 0x10;
    a(34, (Notification)localObject, false);
  }
  
  public final void fT(int paramInt)
  {
    d.fW(paramInt);
  }
  
  public final void fU(int paramInt)
  {
    f.a.wy();
    Object localObject;
    if (paramInt != 0)
    {
      localObject = com.tencent.mm.booter.notification.queue.b.wz().djQ.fX(paramInt);
      if (!((List)localObject).isEmpty()) {
        break label29;
      }
    }
    for (;;)
    {
      return;
      label29:
      aa localaa = aa.L(ae.getContext());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        com.tencent.mm.booter.notification.queue.b.wz().a(localaa, localInteger.intValue());
      }
    }
  }
  
  public final Looper getLooper()
  {
    return Looper.getMainLooper();
  }
  
  public final void k(int paramInt, String paramString)
  {
    f.a.wy();
    f.k(paramInt, paramString);
  }
  
  public final void notify(int paramInt, Notification paramNotification)
  {
    a(paramInt, paramNotification, true);
  }
  
  public final void t(String paramString, int paramInt)
  {
    d.u(paramString, paramInt);
  }
  
  public final void tn()
  {
    y.d("MicroMsg.MMNotification", "force cancelNotification");
    cancel();
  }
  
  public final String wo()
  {
    return this.diX;
  }
  
  public final void wp()
  {
    try
    {
      Object localObject = ae.getContext().getSharedPreferences("notify_newfriend_prep", 0).getString("notify_newfriend_prep", null);
      if (localObject != null)
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          int k = bk.ZR(localObject[i]);
          if (k > 0) {
            au.getNotification().cancel(k);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.MMNotification", localException, "try cancel notification fail: %s", new Object[] { localException.getMessage() });
    }
  }
  
  @TargetApi(16)
  public final boolean wq()
  {
    boolean bool = true;
    Object localObject = ((ActivityManager.RunningTaskInfo)((ActivityManager)this.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
    y.d("MicroMsg.MMNotification", "[oneliang][showMobileRegNoVerifyCodeNotification]:%s", new Object[] { ((ComponentName)localObject).getClassName() });
    if (!MobileVerifyUI.class.getName().equals(((ComponentName)localObject).getClassName())) {
      if (bool)
      {
        localObject = new Intent(this.context, MobileVerifyUI.class);
        ((Intent)localObject).addFlags(2);
        ((Intent)localObject).addFlags(536870912);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtra("nofification_type", "no_reg_notification");
        localObject = PendingIntent.getActivity(this.context, 36, (Intent)localObject, 1073741824);
        if (Build.VERSION.SDK_INT < 16) {
          break label251;
        }
        Notification.Builder localBuilder = new Notification.Builder(this.context);
        localBuilder.setContentTitle(this.context.getString(R.l.app_pushcontent_title));
        localBuilder.setSmallIcon(com.tencent.mm.bq.a.bSL());
        localBuilder.setWhen(System.currentTimeMillis());
        localBuilder.setContentIntent((PendingIntent)localObject);
        localObject = new Notification.BigTextStyle(localBuilder).bigText(this.context.getString(R.l.message_mobile_reg_no_verify_code)).build();
        ((Notification)localObject).defaults |= 0x1;
      }
    }
    for (((Notification)localObject).flags |= 0x10;; ((Notification)localObject).flags |= 0x10)
    {
      a(36, (Notification)localObject, false);
      return bool;
      bool = false;
      break;
      label251:
      localObject = new Notification.Builder(this.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.context.getString(R.l.app_pushcontent_title)).setContentText(this.context.getString(R.l.message_mobile_reg_no_verify_code)).setContentIntent((PendingIntent)localObject).getNotification();
      ((Notification)localObject).icon = com.tencent.mm.bq.a.bSL();
      ((Notification)localObject).defaults |= 0x1;
    }
  }
  
  public final void wr()
  {
    cancel(36);
  }
  
  public final void ws()
  {
    f.a.wy();
    c.ws();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.notification.b
 * JD-Core Version:    0.7.0.1
 */