package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import hke;
import hkf;
import hkg;
import hkh;
import hki;
import hkj;
import hkk;
import hkl;
import hkm;
import hkn;

public class HotChatHelper
{
  public static QQCustomDialog a(Activity paramActivity, HotChatInfo paramHotChatInfo)
  {
    int i;
    if (paramHotChatInfo.isWifiHotChat)
    {
      i = 2131369493;
      if (!paramHotChatInfo.isWifiHotChat) {
        break label117;
      }
    }
    label117:
    for (int j = 2131369494;; j = 2131369496)
    {
      int k = paramActivity.getRequestedOrientation();
      paramActivity.setRequestedOrientation(1);
      paramHotChatInfo = DialogUtil.a(paramActivity, 0, 2130903212, paramActivity.getString(i), null, paramActivity.getString(2131367782), paramActivity.getString(2131367782), new hke(), null);
      paramHotChatInfo.setOnDismissListener(new hkg(paramActivity, k));
      paramHotChatInfo.setMessageCount(paramActivity.getString(j));
      paramHotChatInfo.setPreviewImage(paramActivity.getResources().getDrawable(2130839231), true, 1);
      paramHotChatInfo.show();
      return paramHotChatInfo;
      i = 2131369495;
      break;
    }
  }
  
  public static QQCustomDialog a(QQAppInterface paramQQAppInterface)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    int i = localBaseActivity.getRequestedOrientation();
    localBaseActivity.setRequestedOrientation(1);
    paramQQAppInterface = DialogUtil.a(localBaseActivity, 230, localBaseActivity.getString(2131369532), localBaseActivity.getString(2131369531), 2131365736, 2131367259, new hkk(paramQQAppInterface), new hkl());
    if (paramQQAppInterface != null)
    {
      TextView localTextView = (TextView)paramQQAppInterface.findViewById(2131296606);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localTextView.setLayoutParams(localLayoutParams);
    }
    paramQQAppInterface.setOnDismissListener(new hkm(localBaseActivity, i));
    paramQQAppInterface.show();
    return paramQQAppInterface;
  }
  
  public static QQCustomDialog a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    int i = paramActivity.getRequestedOrientation();
    paramActivity.setRequestedOrientation(1);
    paramQQAppInterface = DialogUtil.a(paramActivity, 0, 2130903589, paramActivity.getString(2131369529), null, paramActivity.getString(2131369873), paramActivity.getString(2131369872), new hkh(paramQQAppInterface), new hki(paramQQAppInterface));
    paramQQAppInterface.setOnDismissListener(new hkj(paramActivity, i));
    paramQQAppInterface.getBtnight().setTypeface(Typeface.DEFAULT_BOLD);
    paramQQAppInterface.setMessageCount(paramActivity.getString(2131369530));
    paramQQAppInterface.setPreviewImage(paramActivity.getResources().getDrawable(2130839234), true, 1);
    paramQQAppInterface.show();
    return paramQQAppInterface;
  }
  
  public static QQCustomDialog a(QQAppInterface paramQQAppInterface, HotChatInfo paramHotChatInfo, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramQQAppInterface = BaseActivity.sTopActivity;
    if ((paramHotChatInfo == null) || (paramQQAppInterface == null)) {
      return null;
    }
    int i = paramQQAppInterface.getRequestedOrientation();
    paramQQAppInterface.setRequestedOrientation(1);
    paramHotChatInfo = DialogUtil.a(paramQQAppInterface, 230, paramQQAppInterface.getString(2131369534), paramQQAppInterface.getString(2131369533), 2131365736, 2131366212, paramOnClickListener, new hkn());
    if (paramHotChatInfo != null)
    {
      paramOnClickListener = (TextView)paramHotChatInfo.findViewById(2131296606);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      paramOnClickListener.setLayoutParams(localLayoutParams);
    }
    paramHotChatInfo.setOnDismissListener(new hkf(paramQQAppInterface, i));
    paramHotChatInfo.show();
    return paramHotChatInfo;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    AddMessageHelper.a(paramQQAppInterface, paramSessionInfo.a, paramQQAppInterface.a().getString(2131369510, new Object[] { paramSessionInfo.d }), 1, false, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HotChatInfo paramHotChatInfo)
  {
    if (paramHotChatInfo == null) {}
    do
    {
      return;
      if (paramHotChatInfo.state == 1)
      {
        a(paramQQAppInterface, paramHotChatInfo, paramQQAppInterface.a().getString(2131369528), true);
        return;
      }
      if (paramHotChatInfo.state == 2)
      {
        a(paramQQAppInterface, paramHotChatInfo, paramQQAppInterface.a().getString(2131369514, new Object[] { paramHotChatInfo.name }), true);
        return;
      }
      a(paramQQAppInterface, paramHotChatInfo, paramQQAppInterface.a().getString(2131369515), true);
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
      RecentUser localRecentUser = localRecentUserProxy.a(paramHotChatInfo.troopUin, 1);
      if (localRecentUser != null) {
        localRecentUserProxy.b(localRecentUser);
      }
    } while (paramHotChatInfo.state != 0);
    paramHotChatInfo.state = 4;
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface.a(paramHotChatInfo);
    paramQQAppInterface.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HotChatInfo paramHotChatInfo, String paramString, boolean paramBoolean)
  {
    AddMessageHelper.a(paramQQAppInterface, paramHotChatInfo.troopUin, paramString, 1, paramBoolean, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatHelper
 * JD-Core Version:    0.7.0.1
 */