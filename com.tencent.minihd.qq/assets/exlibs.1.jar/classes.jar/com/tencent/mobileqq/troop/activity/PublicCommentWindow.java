package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.HashMap;
import kfb;
import kfc;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicCommentWindow
  extends Dialog
  implements View.OnClickListener, EmoticonCallback, InputMethodRelativeLayout.onSizeChangedListenner
{
  protected static final String a = "PublicCommentPopupWindow";
  private static final String e = "draftID";
  private static final String f = "maxContentLength";
  private static final String g = "minContentLength";
  private static final String h = "contentPlaceholder";
  private static final String i = "CommentSendSuccess";
  private static final String j = "qbrowserCommentOnSend";
  private static final String k = "qbrowserCommentOnCreate";
  private static final String l = "qbrowserCommentOnClose";
  protected int a;
  protected long a;
  protected Handler a;
  public Button a;
  protected EditText a;
  protected FrameLayout a;
  public ImageView a;
  public BaseActivity a;
  public SystemAndEmojiEmoticonPanel a;
  protected InputMethodRelativeLayout a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = null;
  private kfc jdField_a_of_type_Kfc = null;
  protected JSONObject a;
  public boolean a;
  protected int b;
  protected String b;
  public boolean b;
  protected String c = null;
  public String d;
  
  public PublicCommentWindow(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_Boolean = false;
    requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    a(paramBundle);
  }
  
  public void a()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void a(Activity paramActivity)
  {
    long l1 = System.currentTimeMillis();
    paramActivity = LayoutInflater.from(paramActivity).inflate(2130903557, null);
    setContentView(paramActivity);
    a(paramActivity);
    a();
    super.show();
    paramActivity = getWindow().getAttributes();
    paramActivity.x = 0;
    paramActivity.y = 0;
    paramActivity.width = -1;
    paramActivity.windowAnimations = 16973824;
    paramActivity.gravity = 83;
    paramActivity.softInputMode = 21;
    getWindow().setBackgroundDrawable(new ColorDrawable());
    if (QLog.isColorLevel()) {
      QLog.d("PublicCommentPopupWindow", 2, "PublicCommentWindow show time = " + (System.currentTimeMillis() - l1));
    }
  }
  
  /* Error */
  protected void a(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 201
    //   3: invokevirtual 207	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_2
    //   7: aload_0
    //   8: aload_1
    //   9: ldc 209
    //   11: invokevirtual 207	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   14: putfield 211	com/tencent/mobileqq/troop/activity/PublicCommentWindow:d	Ljava/lang/String;
    //   17: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +28 -> 48
    //   23: ldc 14
    //   25: iconst_2
    //   26: new 178	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   33: ldc 213
    //   35: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: new 215	org/json/JSONObject
    //   52: dup
    //   53: aload_2
    //   54: invokespecial 218	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   57: putfield 64	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 64	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   65: ldc 17
    //   67: invokevirtual 221	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: putfield 66	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 64	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   78: ldc 20
    //   80: invokevirtual 225	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   83: putfield 68	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_Int	I
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 64	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   91: ldc 23
    //   93: invokevirtual 225	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   96: putfield 70	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_b_of_type_Int	I
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 64	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   104: ldc 26
    //   106: invokevirtual 221	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   109: putfield 72	com/tencent/mobileqq/troop/activity/PublicCommentWindow:c	Ljava/lang/String;
    //   112: aload_0
    //   113: new 227	java/util/ArrayList
    //   116: dup
    //   117: invokespecial 228	java/util/ArrayList:<init>	()V
    //   120: putfield 84	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   123: aload_0
    //   124: getfield 64	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   127: ldc 230
    //   129: invokevirtual 221	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokestatic 236	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   135: astore_1
    //   136: aload_0
    //   137: getfield 84	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   140: aload_1
    //   141: invokevirtual 239	android/net/Uri:getHost	()Ljava/lang/String;
    //   144: invokevirtual 243	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   147: pop
    //   148: aload_0
    //   149: new 245	kfc
    //   152: dup
    //   153: aload_0
    //   154: invokespecial 248	kfc:<init>	(Lcom/tencent/mobileqq/troop/activity/PublicCommentWindow;)V
    //   157: putfield 82	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_Kfc	Lkfc;
    //   160: new 250	android/content/IntentFilter
    //   163: dup
    //   164: ldc 252
    //   166: invokespecial 253	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   169: astore_1
    //   170: aload_0
    //   171: getfield 90	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   174: aload_0
    //   175: getfield 82	com/tencent/mobileqq/troop/activity/PublicCommentWindow:jdField_a_of_type_Kfc	Lkfc;
    //   178: aload_1
    //   179: invokevirtual 259	com/tencent/mobileqq/app/BaseActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   182: pop
    //   183: return
    //   184: astore_1
    //   185: aload_0
    //   186: invokevirtual 262	com/tencent/mobileqq/troop/activity/PublicCommentWindow:dismiss	()V
    //   189: return
    //   190: astore_1
    //   191: aload_0
    //   192: invokevirtual 262	com/tencent/mobileqq/troop/activity/PublicCommentWindow:dismiss	()V
    //   195: return
    //   196: astore_1
    //   197: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq -52 -> 148
    //   203: ldc 14
    //   205: iconst_2
    //   206: aload_1
    //   207: invokestatic 266	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   210: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: goto -65 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	PublicCommentWindow
    //   0	216	1	paramBundle	Bundle
    //   6	48	2	str	String
    // Exception table:
    //   from	to	target	type
    //   48	60	184	org/json/JSONException
    //   48	60	190	java/lang/NullPointerException
    //   123	148	196	java/lang/NullPointerException
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)paramView.findViewById(2131296742));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297032));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131297030));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131298135));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131298771));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramView.findViewById(2131298772).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = TroopBarPublishActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetEditText, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.c);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.a(null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetEditText, null);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  protected void a(String paramString)
  {
    try
    {
      EventApiPlugin.a("qbrowserCommentOnSend", new JSONObject(TroopBarPublishActivity.a(paramString, null, null, null, null)), this.jdField_a_of_type_JavaUtilArrayList, null);
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PublicCommentPopupWindow", 2, QLog.getStackTraceString(paramString));
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    CustomWebView localCustomWebView;
    if ((!android.text.TextUtils.isEmpty(paramString1)) && ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof QQBrowserActivity)))
    {
      localCustomWebView = ((QQBrowserActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a();
      if (localCustomWebView != null)
      {
        if (!paramBoolean) {
          break label78;
        }
        localCustomWebView.a(paramString1, new String[] { "{\"code\":0,\"data\":{\"retcode\":0,\"result\":" + paramString2 + "}}" });
      }
    }
    return;
    label78:
    localCustomWebView.a(paramString1, new String[] { "{\"code\":-1}" });
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel == null) {}
    do
    {
      return;
      if (paramBoolean)
      {
        EventApiPlugin.a("qbrowserCommentOnCreate", null, this.jdField_a_of_type_JavaUtilArrayList, null);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841082);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363925));
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() != 8) || (this.jdField_b_of_type_Boolean));
    dismiss();
  }
  
  protected boolean a()
  {
    String str = (String)TroopBarUtils.c.get(this.jdField_b_of_type_JavaLangString);
    TroopBarUtils.c.clear();
    if (!android.text.TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length());
      return true;
    }
    return false;
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void b()
  {
    String str = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
    if (!android.text.TextUtils.isEmpty(str)) {
      str = str.trim();
    }
    for (int m = str.length();; m = 0)
    {
      if (m == 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131363903, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (m < this.jdField_b_of_type_Int)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363904, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (m > this.jdField_a_of_type_Int)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363905, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (!HttpUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131365807, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      a(str);
      return;
    }
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void c() {}
  
  public void d() {}
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Kfc != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_Kfc);
      this.jdField_a_of_type_Kfc = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = null;
    }
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    if (!this.jdField_a_of_type_Boolean) {
      e();
    }
    EventApiPlugin.a("qbrowserCommentOnClose", null, this.jdField_a_of_type_JavaUtilArrayList, null);
    super.dismiss();
  }
  
  protected void e()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    if (!android.text.TextUtils.isEmpty(str)) {
      TroopBarUtils.c.put(this.jdField_b_of_type_JavaLangString, str);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131298772: 
    case 2131297032: 
      do
      {
        return;
        dismiss();
        return;
      } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
        InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841082);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363925));
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kfb(this), 200L);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.PublicCommentWindow
 * JD-Core Version:    0.7.0.1
 */