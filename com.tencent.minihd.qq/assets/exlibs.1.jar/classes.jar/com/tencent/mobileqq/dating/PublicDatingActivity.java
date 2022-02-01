package com.tencent.mobileqq.dating;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.data.PublishDatingOption;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.remind.widget.IosTimepicker.OnTimePickerSelectListener;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import idv;
import idw;
import idx;
import idy;
import idz;
import iea;
import ieb;
import ief;
import ieg;
import ieh;
import iei;
import iej;
import iek;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class PublicDatingActivity
  extends DatingBaseActivity
  implements Handler.Callback, View.OnClickListener, RadioGroup.OnCheckedChangeListener
{
  public static final int a = -1;
  private static final long jdField_a_of_type_Long = 10000L;
  public static final String a = "userCenter";
  public static final int b = 0;
  private static final long jdField_b_of_type_Long = 86400000L;
  public static final String b = "guide";
  public static final int c = 1;
  public static final String c = "feed";
  private static final int jdField_d_of_type_Int = 0;
  public static final String d = "detail";
  private static final int e = 1;
  public static final String e = "web";
  private static final int f = -1;
  public static final String h = "new_id";
  private static final String jdField_i_of_type_JavaLangString = "https://web.p.qq.com/qqmpmobile/coupon/appointment.html";
  Dialog jdField_a_of_type_AndroidAppDialog = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new iei(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new CustomHandler(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new idz(this);
  private View jdField_a_of_type_AndroidViewView;
  private IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new iej(this);
  private PublishDatingOption jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption;
  private DatingObserver jdField_a_of_type_ComTencentMobileqqDatingDatingObserver = new idv(this);
  private PublishDatingHelper jdField_a_of_type_ComTencentMobileqqDatingPublishDatingHelper;
  private IosTimepicker.OnTimePickerSelectListener jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener = new idy(this);
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private IphonePickerView.IphonePickListener jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new iek(this);
  private boolean jdField_b_of_type_Boolean = true;
  private long jdField_c_of_type_Long = 0L;
  private IphonePickerView.IphonePickListener jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new idw(this);
  private long jdField_d_of_type_Long = 0L;
  private IphonePickerView.IphonePickListener jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new idx(this);
  private int g = 1;
  private int h = -1;
  private int jdField_i_of_type_Int;
  private int jdField_j_of_type_Int = -1;
  private String jdField_j_of_type_JavaLangString = "";
  private int jdField_k_of_type_Int = -1;
  private String jdField_k_of_type_JavaLangString = "";
  private int l = -1;
  private int m = -1;
  private int n = -1;
  
  public PublicDatingActivity()
  {
    this.i = -1;
  }
  
  private long a(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    localCalendar.set(5, localCalendar.get(5) + 1);
    switch (paramInt)
    {
    }
    for (;;)
    {
      long l1 = localCalendar.getTimeInMillis();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.dating", 4, "themeId:" + paramInt + "defaultTimeInMills:" + l1);
      }
      return l1;
      localCalendar.set(11, 18);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      continue;
      localCalendar.set(11, 23);
      localCalendar.set(12, 59);
      localCalendar.set(13, 0);
    }
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "0000000100";
    case 2: 
      return "0000000200";
    case 3: 
      return "0000000300";
    case 4: 
      return "0000000400";
    }
    return "0000000500";
  }
  
  private void a()
  {
    ThreadManager.a().post(new iea(this));
  }
  
  private boolean a(long paramLong)
  {
    long l1 = MessageCache.a() * 1000L;
    if (l1 >= paramLong)
    {
      a(this.jdField_k_of_type_JavaLangString);
      return false;
    }
    if (paramLong - l1 < this.jdField_c_of_type_Long * 1000L)
    {
      a(this.jdField_k_of_type_JavaLangString);
      return false;
    }
    if (paramLong - l1 > this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.maxTimeRequest * 86400000L)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.maxTimeReqErr);
      return false;
    }
    return true;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption = new PublishDatingOption();
    this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.themeId = 0;
    ThreadManager.c(new ieb(this));
  }
  
  private void c()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("isShowAd", false);
    String str1 = "";
    String str2 = "";
    StringBuffer localStringBuffer;
    switch (this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.themeId)
    {
    default: 
      localStringBuffer = new StringBuffer("https://web.p.qq.com/qqmpmobile/coupon/appointment.html");
      localStringBuffer.append("?");
      localStringBuffer.append("maplng=" + DatingManager.a);
      localStringBuffer.append("&maplat=" + DatingManager.b);
      localStringBuffer.append("&timestamp=" + DatingManager.jdField_c_of_type_Long);
      localStringBuffer.append("&category=" + str1);
      if (!TextUtils.isEmpty(str2)) {
        localStringBuffer.append("&subCategory=" + str2);
      }
      break;
    }
    for (;;)
    {
      localStringBuffer.append("&_bid=108");
      localStringBuffer.append("&_wv=5121");
      localStringBuffer.append("&stype=11004");
      str1 = localStringBuffer.toString();
      localIntent.putExtra("url", str1);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.dating", 2, "url = " + str1);
      }
      startActivity(localIntent);
      return;
      str1 = "美食";
      break;
      str1 = "娱乐";
      str2 = "KTV";
      break;
      str1 = "娱乐";
      str2 = "电影";
      break;
      str1 = "运动健身";
      break;
      localStringBuffer.append("&subCategory=");
    }
  }
  
  private void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.dating", 4, "request current loction|local state:" + this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.depLocalState);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.depLocalState == 0) || (this.g != 5) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.depLocalState = 0;
    SosoInterface.a(new ief(this, 3, true, 0L, true, false, "PublicDatingActivity"));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-1, 10000L);
  }
  
  private void g()
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.time))
    {
      if (NetworkUtil.e(getApplicationContext()))
      {
        a(0, 2131366988, 0);
        ThreadManager.c(new ieh(this));
      }
    }
    else {
      return;
    }
    a(2, getResources().getString(2131369793), 0);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903909);
    setTitle(2131369686);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131367064);
    this.rightViewText.setOnClickListener(this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    this.jdField_j_of_type_JavaLangString = getIntent().getStringExtra("fromWhere");
    if ((this.jdField_j_of_type_JavaLangString.equals("web")) || (this.jdField_j_of_type_JavaLangString.equals("guide")))
    {
      paramBundle = getIntent().getStringExtra("subject");
      if (!TextUtils.isEmpty(paramBundle)) {
        this.i = Integer.valueOf(paramBundle).intValue();
      }
      a();
    }
    if ((this.jdField_j_of_type_JavaLangString.equals("guide")) || (this.e)) {
      this.leftView.setText(2131369656);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131300045);
    this.jdField_a_of_type_ComTencentMobileqqDatingPublishDatingHelper = new PublishDatingHelper(this, this.jdField_a_of_type_AndroidViewView, this.rightViewText, this, this);
    b();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle, "com.tencent.msg.permission.pushnotify2", null);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (!this.jdField_a_of_type_Boolean) {
      b("0X800493F");
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    PublishDatingOption localPublishDatingOption = (PublishDatingOption)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(5));
    if ((localPublishDatingOption != null) && (localPublishDatingOption.depLocal != null)) {
      ((DatingManager)this.app.getManager(67)).a(localPublishDatingOption.depLocal);
    }
    super.doOnDestroy();
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqDatingPublishDatingHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingPublishDatingHelper.a();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == -1)
    {
      paramMessage = (PublishDatingOption)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(5));
      if ((paramMessage != null) && (paramMessage.depLocalState == 0))
      {
        paramMessage.depLocalState = -1;
        if (this.g == 5) {
          this.jdField_a_of_type_ComTencentMobileqqDatingPublishDatingHelper.b(paramMessage);
        }
        DatingUtil.a("local timeout fail", new Object[] { Integer.valueOf(this.g) });
      }
    }
    else
    {
      return false;
    }
    DatingUtil.a("local timeout suc", new Object[] { Integer.valueOf(this.g) });
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      Object localObject1 = paramIntent.getExtras().getString("others");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.introduce = ((String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.hasIntro = true;
      this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.introId = paramIntent.getExtras().getInt("item_id", 0);
      this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.introKey = paramIntent.getExtras().getString("item_key");
      this.jdField_a_of_type_ComTencentMobileqqDatingPublishDatingHelper.b(this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption);
      continue;
      this.jdField_a_of_type_ArrayOfByte = paramIntent.getExtras().getByteArray("dating_destination_result");
      this.h = paramIntent.getExtras().getInt("dating_destination_select_type");
      localObject1 = new appoint_define.LocaleInfo();
      try
      {
        ((appoint_define.LocaleInfo)localObject1).mergeFrom(this.jdField_a_of_type_ArrayOfByte);
        this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.desLocal = ((appoint_define.LocaleInfo)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.destType = this.h;
        this.jdField_a_of_type_ComTencentMobileqqDatingPublishDatingHelper.b(this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          Object localObject3 = null;
          this.h = -1;
          Object localObject2 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.dating", 2, "destlocal merge fail");
            localObject2 = localObject3;
          }
        }
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_j_of_type_JavaLangString.equals("guide")) {
      b("0X8005013");
    }
    if (this.e)
    {
      Intent localIntent = new Intent(this, DatingFeedActivity.class);
      localIntent.putExtra("abp_flag", this.e);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingPublishDatingHelper.a(paramInt);
      this.g = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption = ((PublishDatingOption)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt)));
      if (this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption != null)
      {
        if (this.g == 5) {
          d();
        }
        this.jdField_a_of_type_ComTencentMobileqqDatingPublishDatingHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption = new PublishDatingOption();
    this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.themeId = 0;
    DatingUtil.b("Q.dating", new Object[] { "publish dating onCheckedChanged method option is null" });
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131300017: 
    case 2131300053: 
    case 2131300020: 
    case 2131300024: 
    case 2131300066: 
    case 2131300027: 
    case 2131300030: 
    case 2131300072: 
    case 2131300059: 
    case 2131300063: 
    case 2131300069: 
    case 2131297360: 
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqDatingPublishDatingHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption, this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener, this.jdField_a_of_type_AndroidViewView$OnClickListener);
        return;
        c();
        return;
        this.jdField_a_of_type_ComTencentMobileqqDatingPublishDatingHelper.a(0, this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption, this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener);
        return;
        this.jdField_a_of_type_ComTencentMobileqqDatingPublishDatingHelper.a(1, this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption, this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener);
        return;
        paramView = new Intent(this, DatingOthersActivity.class);
        paramView.putExtra("curTheme", this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.themeId);
        paramView.putExtra("item_id", this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.introId);
        startActivityForResult(paramView, 0);
        overridePendingTransition(2130968586, 2130968592);
        return;
        paramView = new Intent(this, DatingDestinationActivity.class);
        if (this.jdField_a_of_type_ArrayOfByte != null) {
          paramView.putExtra("dating_destination_result", this.jdField_a_of_type_ArrayOfByte);
        }
        if (this.h != -1) {
          paramView.putExtra("dating_destination_select_type", this.h);
        }
        startActivityForResult(paramView, 1);
        return;
        this.jdField_a_of_type_ComTencentMobileqqDatingPublishDatingHelper.a(2, this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption, this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener);
        return;
        this.jdField_a_of_type_ComTencentMobileqqDatingPublishDatingHelper.a(3, this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption, this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption.themeId != 5) {
          break;
        }
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131369814), getString(2131369829), 0, 2131369830, new ieg(this), null);
      } while (this.jdField_a_of_type_AndroidAppDialog == null);
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      g();
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    d();
    this.jdField_a_of_type_ComTencentMobileqqDatingPublishDatingHelper.b(this.jdField_a_of_type_ComTencentMobileqqDataPublishDatingOption);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.PublicDatingActivity
 * JD-Core Version:    0.7.0.1
 */