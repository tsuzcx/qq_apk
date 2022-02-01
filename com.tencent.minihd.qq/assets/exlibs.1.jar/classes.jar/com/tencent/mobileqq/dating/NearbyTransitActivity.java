package com.tencent.mobileqq.dating;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import idq;
import idr;
import ids;
import idt;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class NearbyTransitActivity
  extends BaseActivity
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, Handler.Callback
{
  public static final int a = 1;
  private static long jdField_a_of_type_Long = 0L;
  public static final String a = "NearbyTransitActivity";
  public static final String b = "加入热聊失败，请稍后再试。";
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new idr(this);
  public QQProgressNotifier a;
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  private boolean b;
  private String c;
  private String d;
  private int h;
  
  public NearbyTransitActivity()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a()
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "parseParams" });
    Intent localIntent = getIntent();
    this.c = localIntent.getExtras().getString("from");
    this.h = localIntent.getExtras().getInt("action");
    if (this.h == 1) {
      this.d = localIntent.getExtras().getString("hotnamecode");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131492923);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    long l = Math.abs(System.currentTimeMillis() - jdField_a_of_type_Long);
    if ((paramContext == null) || ((l >= 0L) && (l < 800L))) {
      return;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    Intent localIntent = new Intent(paramContext, NearbyTransitActivity.class);
    localIntent.putExtra("src_type", paramString1);
    localIntent.putExtra("from_type", paramString2);
    localIntent.putExtra("from", paramString3);
    localIntent.putExtra("version", paramString4);
    localIntent.putExtra("action", paramInt);
    localIntent.putExtra("hotnamecode", paramString5);
    paramContext.startActivity(localIntent);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("troop_uin", paramString2);
    localIntent.putExtra("uinname", paramString3);
    localIntent.addFlags(67108864);
    localIntent.putExtra("is_from_web", true);
    if ("10002".equals(this.c))
    {
      localIntent.putExtra("abp_flag", true);
      localIntent.addFlags(268435456);
    }
    startActivity(localIntent);
  }
  
  private void b()
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "doAction", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      Object localObject;
      if (NetworkUtil.e(BaseApplication.getContext())) {
        if (this.h == 1)
        {
          localObject = (HotChatHandler)this.app.a(37);
          if ((localObject != null) && (!TextUtils.isEmpty(this.d)))
          {
            this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver, true);
            ((HotChatHandler)localObject).a(this.d);
            localObject = null;
          }
        }
      }
      while (localObject != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 200L);
        return;
        localObject = Message.obtain();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = "加入热聊失败，请稍后再试。";
        continue;
        localObject = Message.obtain();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = "加入热聊失败，请稍后再试。";
        continue;
        localObject = Message.obtain();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = getString(2131369501);
      }
    }
  }
  
  protected Dialog a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Object localObject2 = getResources().getString(paramInt1);
    Object localObject1 = getResources().getString(paramInt2);
    String str2 = getResources().getString(paramInt3);
    String str1 = getResources().getString(paramInt4);
    Dialog localDialog = new Dialog(this, 2131558902);
    localDialog.setContentView(2130903211);
    TextView localTextView = (TextView)localDialog.findViewById(2131297367);
    if (localTextView != null)
    {
      localTextView.setText((CharSequence)localObject2);
      localTextView.setContentDescription((CharSequence)localObject2);
    }
    localObject2 = (TextView)localDialog.findViewById(2131296606);
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
    }
    localObject1 = (TextView)localDialog.findViewById(2131297370);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(str2);
      ((TextView)localObject1).setContentDescription(str2);
      ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
    }
    paramOnClickListener1 = (TextView)localDialog.findViewById(2131297371);
    if (paramOnClickListener1 != null)
    {
      paramOnClickListener1.setText(str1);
      paramOnClickListener1.setContentDescription(str1);
      paramOnClickListener1.setOnClickListener(paramOnClickListener2);
    }
    return localDialog;
  }
  
  protected void a(Common.WifiPOIInfo paramWifiPOIInfo)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog = a(2131369522, 2131369521, 2131365736, 2131365737, new ids(this), new idt(this, paramWifiPOIInfo));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(this);
    this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, getString(2131369502), 800, this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 30000L);
    ThreadManager.c(new idq(this));
    return false;
  }
  
  protected void doOnDestroy()
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "doOnDestroy" });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    super.doOnDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "handleMessage", Integer.valueOf(paramMessage.what) });
    switch (paramMessage.what)
    {
    }
    label173:
    do
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      }
      if ((paramMessage.what == 2) || ((paramMessage.obj instanceof String))) {
        if (paramMessage.what != 2) {
          break label173;
        }
      }
      for (String str = getString(2131369501);; str = "加入热聊失败，请稍后再试。")
      {
        if ((paramMessage.obj instanceof String)) {
          str = (String)paramMessage.obj;
        }
        QQToast.a(BaseApplication.getContext(), str, 0).b(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
        finish();
        return false;
      }
      paramMessage = (Object[])paramMessage.obj;
      a((String)paramMessage[0], (String)paramMessage[1], (String)paramMessage[2]);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      finish();
      return false;
      a((Common.WifiPOIInfo)paramMessage.obj);
      return false;
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, getString(2131369502), 200, this);
    return false;
  }
  
  protected boolean onBackEvent()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    return true;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyTransitActivity
 * JD-Core Version:    0.7.0.1
 */