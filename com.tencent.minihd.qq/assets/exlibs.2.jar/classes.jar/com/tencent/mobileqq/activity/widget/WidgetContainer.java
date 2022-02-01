package com.tencent.mobileqq.activity.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.widget.doyen.WidgetDoyen;
import com.tencent.mobileqq.activity.widget.qqmusic.QQMusicHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.CircleProgressView;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QzoneMsgHandler;
import com.tencent.mobileqq.app.QzoneMsgObserver;
import com.tencent.mobileqq.app.message.MsgPool;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.QQDoyen;
import com.tencent.mobileqq.data.UserSettings;
import com.tencent.mobileqq.helpers.UserSettingsHelper;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.qphone.base.util.QLog;
import hbt;
import hbu;
import hbv;
import hbw;
import hbx;
import hby;
import hbz;
import hca;
import hcb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class WidgetContainer
  extends FrameLayout
{
  private final int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler;
  public Conversation a;
  private WidgetContainer.OnWidgetMoveListener jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer$OnWidgetMoveListener;
  private final WidgetObserver jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetObserver = new hca(this);
  private WidgetDoyen jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenWidgetDoyen;
  private QQMusicWidget jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiQQMusicWidget;
  private final QzoneMsgObserver jdField_a_of_type_ComTencentMobileqqAppQzoneMsgObserver = new hcb(this);
  QQDoyen jdField_a_of_type_ComTencentMobileqqDataQQDoyen = new QQDoyen();
  private String jdField_a_of_type_JavaLangString = "WidgetContainer";
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  private final int jdField_b_of_type_Int = 2;
  Handler jdField_b_of_type_AndroidOsHandler;
  private final int jdField_c_of_type_Int = 4;
  Handler jdField_c_of_type_AndroidOsHandler;
  private int d = 0;
  private int e = 0;
  
  public WidgetContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public WidgetContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WidgetContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 2130842178;
    }
    switch (paramInt1)
    {
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 2130842179;
    case 0: 
    case 1: 
    case 4: 
    case 9: 
      return 2130842179;
    }
    return 2130842176;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 2130842186;
    int i = -1;
    if (paramInt2 == 0) {
      paramInt2 = 2130842192;
    }
    do
    {
      return paramInt2;
      paramInt2 = j;
    } while (paramInt3 > 200);
    paramInt2 = i;
    switch (paramInt1)
    {
    default: 
      paramInt2 = i;
    }
    for (;;)
    {
      return paramInt2;
      paramInt2 = 2130842182;
      continue;
      paramInt2 = 2130842194;
      continue;
      paramInt2 = 2130842186;
    }
  }
  
  private Bitmap a(int paramInt1, int paramInt2)
  {
    String str = String.valueOf(paramInt1) + String.valueOf(paramInt2);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
      return (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    }
    Bitmap localBitmap1 = BitmapFactory.decodeResource(getResources(), 2130840994);
    Bitmap localBitmap2 = BitmapFactory.decodeResource(getResources(), 2130840995);
    int i = a(15);
    Bitmap localBitmap3 = Bitmap.createScaledBitmap(localBitmap1, i, i, true);
    Bitmap localBitmap4 = Bitmap.createScaledBitmap(localBitmap2, i, i, true);
    localBitmap1.recycle();
    localBitmap2.recycle();
    localBitmap1 = a(localBitmap3, paramInt1, localBitmap4, paramInt2);
    this.jdField_a_of_type_JavaUtilHashMap.put(str, localBitmap1);
    return localBitmap1;
  }
  
  private Bitmap a(Bitmap paramBitmap1, int paramInt1, Bitmap paramBitmap2, int paramInt2)
  {
    int n = 0;
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap1.getWidth() * paramInt1 + paramBitmap2.getWidth() * paramInt2, Math.max(paramBitmap1.getHeight(), paramBitmap2.getHeight()), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    int j = 0;
    int k;
    int m;
    for (int i = 0;; i = k + i)
    {
      k = n;
      m = i;
      if (j >= paramInt1) {
        break;
      }
      localCanvas.drawBitmap(paramBitmap1, i, 0.0F, null);
      k = paramBitmap1.getWidth();
      j += 1;
    }
    while (k < paramInt2)
    {
      localCanvas.drawBitmap(paramBitmap2, m, 0.0F, null);
      m += paramBitmap2.getWidth();
      k += 1;
    }
    return localBitmap;
  }
  
  private Drawable a(int paramInt)
  {
    int i = -1;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    while (paramInt < 0)
    {
      return null;
      paramInt = 2130842154;
      continue;
      paramInt = 2130842164;
      continue;
      paramInt = 2130842158;
      continue;
      paramInt = 2130842156;
      continue;
      paramInt = 2130842159;
      continue;
      paramInt = 2130842165;
      continue;
      paramInt = 2130842160;
      continue;
      paramInt = 2130842163;
      continue;
      paramInt = 2130842162;
      continue;
      paramInt = 2130842157;
      continue;
      paramInt = 2130842153;
      continue;
      paramInt = 2130842161;
    }
    return getResources().getDrawable(paramInt);
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return "晴";
    case 1: 
      return "多云";
    case 2: 
      return "阴";
    case 3: 
      return "雨";
    case 6: 
      return "雨夹雪";
    case 7: 
      return "雷阵雨";
    case 4: 
      return "雪";
    case 5: 
      return "雾";
    case 8: 
      return "沙";
    }
    return "风";
  }
  
  private void a(float paramFloat, View paramView)
  {
    a(paramFloat, paramView, true);
  }
  
  private void a(float paramFloat, View paramView, boolean paramBoolean)
  {
    paramView = paramView.getLayoutParams();
    if (paramView.width > 0)
    {
      paramView.width = ((int)(paramView.width * paramFloat));
      if ((paramBoolean) && (paramView.height > 0)) {
        paramView.height = ((int)(paramView.height * paramFloat));
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    this.d = paramBundle.getInt("iUpdateTime");
    ((TextView)findViewById(2131301284)).setText("PM2.5 " + paramBundle.getInt("iPM2p5"));
    ((TextView)findViewById(2131302459)).setText(paramBundle.getInt("iTempCurr") + "° " + a(paramBundle.getInt("iWeather")));
    Object localObject = (ImageView)findViewById(2131302458);
    int i = c(paramBundle.getInt("iWeather"), paramBundle.getInt("iDayTime"));
    if (i > 0) {
      ((ImageView)localObject).setImageResource(i);
    }
    localObject = (TextView)findViewById(2131301278);
    if (paramBundle.getString("strCityName") != null) {
      ((TextView)localObject).setText(paramBundle.getString("strCityName"));
    }
    localObject = (ImageView)findViewById(2131302457);
    i = b(paramBundle.getInt("iWeather"), paramBundle.getInt("iDayTime"));
    try
    {
      ((ImageView)localObject).setBackgroundResource(i);
      return;
    }
    catch (OutOfMemoryError paramBundle)
    {
      ((ImageView)localObject).setBackgroundColor(getResources().getColor(2131427404));
    }
  }
  
  private void a(UserSettings paramUserSettings, QQDoyen paramQQDoyen)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenWidgetDoyen.setDoyen(paramQQDoyen);
    paramUserSettings.mQQDoyen = paramQQDoyen;
    UserSettingsHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app, paramUserSettings);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "WidgetContainer: " + paramString);
    }
  }
  
  private boolean a(int paramInt)
  {
    localObject = null;
    try
    {
      Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(paramInt);
      localObject = localBundle;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      if (paramInt != 0) {
        break label117;
      }
      paramInt = localObject.getInt("iCacheTime");
      int j = localObject.getInt("iUpdateTime");
      a("WEATHER needUpdateWidget updateWeatherTime: " + this.d + "|lastUpdateTime: " + j + "|cacheTime: " + paramInt);
      int i = j;
      if (this.d >= j) {
        break label203;
      }
      return true;
      if (paramInt != 2) {
        break label199;
      }
      paramInt = localObject.getInt("cachetime");
      j = localObject.getInt("updatetime");
      a("CONSTELLATION needUpdateWidget updateWeatherTime: " + this.d + "|lastUpdateTime: " + j + "|cacheTime: " + paramInt);
      i = j;
      if (this.e >= j) {
        break label203;
      }
      return true;
      paramInt = 0;
      i = 0;
      if (paramInt <= 0) {
        break label251;
      }
      for (;;)
      {
        j = (int)(System.currentTimeMillis() / 1000L);
        a("needUpdateWidget now - lastUpdateTime: " + (j - i));
        if (j - i <= paramInt) {
          break;
        }
        return true;
        paramInt = 1800;
      }
    }
    return localObject == null;
  }
  
  private boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a().createEntityManager();
    paramString = (AccountDetail)((EntityManager)localObject).a(AccountDetail.class, paramString);
    ((EntityManager)localObject).a();
    if (paramString == null) {
      return true;
    }
    try
    {
      localObject = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
      ((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject).mergeFrom(paramString.accountData);
      paramString.newGroupInfoList = ((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject).config_group_info_new.get();
      label64:
      return paramString.followType == 1;
    }
    catch (Exception localException)
    {
      break label64;
    }
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    int i = 2130842202;
    if (paramInt2 == 0)
    {
      paramInt2 = 2130842191;
      return paramInt2;
    }
    paramInt2 = i;
    switch (paramInt1)
    {
    case 0: 
    case 1: 
    case 9: 
    default: 
      return 2130842202;
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
      return 2130842184;
    case 4: 
      return 2130842199;
    }
    return 2130842196;
  }
  
  private void b(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.e = paramBundle.getInt("updatetime");
    }
    Object localObject = (ImageView)findViewById(2131301215);
    Drawable localDrawable = a(paramBundle.getInt("constellationId"));
    if (localDrawable != null) {
      ((ImageView)localObject).setImageDrawable(localDrawable);
    }
    int j = paramBundle.getInt("lucky");
    Math.max(0, 5 - j);
    localObject = new ImageView[5];
    localObject[0] = ((ImageView)findViewById(2131302432));
    localObject[1] = ((ImageView)findViewById(2131302433));
    localObject[2] = ((ImageView)findViewById(2131302434));
    localObject[3] = ((ImageView)findViewById(2131302435));
    localObject[4] = ((ImageView)findViewById(2131302436));
    int i = 0;
    while ((i < j) && (i < localObject.length))
    {
      localObject[i].setImageResource(2130840994);
      i += 1;
    }
    i = j;
    while (i < localObject.length)
    {
      localObject[i].setImageResource(2130840995);
      i += 1;
    }
    ((TextView)findViewById(2131301254)).setText(paramBundle.getString("good"));
    ((TextView)findViewById(2131301256)).setText(paramBundle.getString("bad"));
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return -1;
    case 0: 
      if (paramInt2 == 0) {
        return 2130842187;
      }
      return 2130842200;
    case 1: 
      if (paramInt2 == 0) {
        return 2130842188;
      }
      return 2130842189;
    case 2: 
      return 2130842180;
    case 3: 
      return 2130842193;
    case 6: 
      return 2130842197;
    case 7: 
      return 2130842203;
    case 4: 
      return 2130842198;
    case 5: 
      return 2130842183;
    case 8: 
      return 2130842195;
    }
    return 2130842204;
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidOsHandler = new hbt(this);
    this.jdField_b_of_type_AndroidOsHandler = new hbu(this);
    this.jdField_c_of_type_AndroidOsHandler = new hbv(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(this.jdField_a_of_type_ComTencentMobileqqAppQzoneMsgObserver);
  }
  
  private void l()
  {
    findViewById(2131302449).setOnClickListener(new hbw(this));
    try
    {
      Bundle localBundle2 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(0);
      localBundle1 = localBundle2;
      if (localBundle2 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(0, this.jdField_a_of_type_AndroidOsHandler);
        localBundle1 = localBundle2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Bundle localBundle1;
        a("updateWidgetWeather Exception: " + localException.getMessage());
        localException.printStackTrace();
        Object localObject = null;
      }
    }
    if (localBundle1 != null) {
      a(localBundle1);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenWidgetDoyen != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenWidgetDoyen.setWidgetDoyenOnClickListner(new hbx(this));
    }
  }
  
  private void n()
  {
    if (SizeMeasure.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenWidgetDoyen.a() == null)
      {
        UserSettings localUserSettings = UserSettingsHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app);
        if ((localUserSettings != null) && (localUserSettings.mQQDoyen != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenWidgetDoyen.setDoyen(localUserSettings.mQQDoyen);
        }
      }
      i();
    }
  }
  
  private void o()
  {
    findViewById(2131302453).setOnClickListener(new hby(this));
    try
    {
      Bundle localBundle2 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(2);
      localBundle1 = localBundle2;
      if (localBundle2 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(2, this.jdField_b_of_type_AndroidOsHandler);
        localBundle1 = localBundle2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Bundle localBundle1;
        a("updateWidgetConstellation Exception: " + localException.getMessage());
        localException.printStackTrace();
        Object localObject = null;
      }
    }
    if (localBundle1 != null) {
      b(localBundle1);
    }
  }
  
  private void p()
  {
    try
    {
      Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(4);
      if (localBundle != null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(4, this.jdField_c_of_type_AndroidOsHandler);
          return;
        }
        catch (Exception localException2)
        {
          Object localObject;
          localException2.printStackTrace();
        }
        localException1 = localException1;
        localException1.printStackTrace();
        localObject = null;
      }
    }
  }
  
  private void q()
  {
    View localView = findViewById(2131302452);
    URLImageView localURLImageView = (URLImageView)findViewById(2131302454);
    TextView localTextView = (TextView)findViewById(2131302456);
    Object localObject2 = findViewById(2131302455);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a().a("2909288299", 1008, false);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = (ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1);
      ((View)localObject2).setVisibility(0);
      if ((localObject1 == null) || (!(localObject1 instanceof MessageForPubAccount))) {
        break label220;
      }
      ((ChatMessage)localObject1).parse();
      localObject1 = ((MessageForPubAccount)localObject1).mPAMessage;
      if ((localObject1 == null) || (((PAMessage)localObject1).items == null) || (((PAMessage)localObject1).items.size() <= 0)) {
        break label421;
      }
    }
    label421:
    for (localObject1 = (PAMessage.Item)((PAMessage)localObject1).items.get(0);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        if (((PAMessage.Item)localObject1).title != null) {
          localTextView.setText(Util.e(((PAMessage.Item)localObject1).title));
        }
        if (((PAMessage.Item)localObject1).cover != null) {
          localURLImageView.setImageDrawable(URLDrawable.getDrawable(((PAMessage.Item)localObject1).cover));
        }
      }
      for (;;)
      {
        localView.setOnClickListener(new hbz(this));
        return;
        ((View)localObject2).setVisibility(8);
        localObject1 = null;
        break;
        label220:
        if ((localObject1 != null) && ((localObject1 instanceof MessageForStructing)))
        {
          ((ChatMessage)localObject1).parse();
          localObject1 = (MessageForStructing)localObject1;
          if ((((MessageForStructing)localObject1).structingMsg != null) && ((((MessageForStructing)localObject1).structingMsg instanceof StructMsgForGeneralShare)))
          {
            localObject1 = (StructMsgForGeneralShare)((MessageForStructing)localObject1).structingMsg;
            if ((localObject1 != null) && (((StructMsgForGeneralShare)localObject1).getItemByIndex(0) != null) && ((((StructMsgForGeneralShare)localObject1).getItemByIndex(0) instanceof StructMsgItemLayout5)))
            {
              localObject1 = (StructMsgItemLayout5)((StructMsgForGeneralShare)localObject1).getItemByIndex(0);
              if ((((StructMsgItemLayout5)localObject1).a != null) && (((StructMsgItemLayout5)localObject1).a.size() > 0))
              {
                localObject1 = ((StructMsgItemLayout5)localObject1).a.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
                  String str = ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangString;
                  if (("picture".equals(str)) && ((localObject2 instanceof StructMsgItemCover))) {
                    localURLImageView.setImageDrawable(URLDrawable.getDrawable(((StructMsgItemCover)localObject2).j));
                  } else if (("title".equals(str)) && ((localObject2 instanceof StructMsgItemTitle))) {
                    localTextView.setText(((StructMsgItemTitle)localObject2).b());
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void r()
  {
    long l = System.currentTimeMillis();
    if (ProfileActivity.a(this.jdField_a_of_type_Long, l))
    {
      this.jdField_a_of_type_Long = l;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoXmanWeb() url = " + "https://ti.qq.com/xman/self.html?_wv=1027&adtag=card&_bid=297");
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityConversation, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a());
      localIntent.putExtra("url", "https://ti.qq.com/xman/self.html?_wv=1027&adtag=card&_bid=297");
      localIntent.putExtra("hide_more_button", true);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app, "CliOper", "", "", "0X8004880", "0X8004880", 0, 0, "", "", "", "");
    }
  }
  
  public int a(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = paramInt;
    return (int)(localDisplayMetrics.densityDpi / 160.0F * f);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenWidgetDoyen != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenWidgetDoyen.a();
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject1;
    int i;
    int j;
    boolean bool;
    float f2;
    float f1;
    if (SizeMeasure.b)
    {
      localObject1 = paramContext.getResources();
      i = ((Resources)localObject1).getDimensionPixelSize(2131493399);
      j = ((Resources)localObject1).getDimensionPixelSize(2131493483);
      int k = SizeMeasure.e(paramContext);
      Log.i("app2", "widgetPadding=" + i + " widgetTotalWidth=" + j + " rightWidth=" + k);
      if (i * 2 + j > k)
      {
        bool = SizeMeasure.a(paramContext);
        f2 = (k - i * 2) / j;
        findViewById(2131300176);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenWidgetDoyen == null)
        {
          i = -1;
          if (!bool) {
            break label218;
          }
          if (i <= 0) {
            break label484;
          }
          f1 = j / i * f2;
        }
      }
    }
    for (;;)
    {
      label157:
      paramContext = (LinearLayout)findViewById(2131302448);
      i = 0;
      for (;;)
      {
        if (i < paramContext.getChildCount())
        {
          a(f1, (ViewGroup)paramContext.getChildAt(i));
          i += 1;
          continue;
          i = this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenWidgetDoyen.getLayoutParams().width;
          break;
          label218:
          if (i <= 0) {
            break label484;
          }
          f1 = j / i * (f2 - 0.05F);
          break label157;
        }
      }
      paramContext = (ViewGroup)findViewById(2131302449);
      Object localObject2 = (ViewGroup)findViewById(2131302450);
      a(f1, paramContext);
      a(f1, (View)localObject2);
      paramContext = (ImageView)findViewById(2131300177);
      localObject2 = (CircleProgressView)findViewById(2131300178);
      i = ((CircleProgressView)localObject2).getLayoutParams().width;
      j = ((Resources)localObject1).getDimensionPixelSize(2131493795);
      if (i > 0) {
        if (bool) {
          f2 = (f2 - 0.05F) * (j / i);
        }
      }
      for (;;)
      {
        a(f2, paramContext);
        a(f2, (View)localObject2);
        ((CircleProgressView)localObject2).setRadius((int)((int)((CircleProgressView)localObject2).a() * f2));
        paramContext = (ViewGroup)findViewById(2131300176);
        if ((paramContext.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
        {
          paramContext = (ViewGroup.MarginLayoutParams)paramContext.getLayoutParams();
          if (paramContext.topMargin > 0) {
            paramContext.topMargin = ((int)(paramContext.topMargin * f1));
          }
        }
        paramContext = (ViewGroup)findViewById(2131302452);
        localObject1 = (ViewGroup)findViewById(2131302453);
        a(f1, paramContext, false);
        a(f1, (View)localObject1, false);
        return;
        f2 = (f2 - 0.1F) * (j / i);
        continue;
        f2 = f1 - 0.05F;
      }
      label484:
      f1 = f2;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    k();
    q();
    p();
    l();
    o();
    m();
    d();
  }
  
  public void b()
  {
    if (a(0)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(0, this.jdField_a_of_type_AndroidOsHandler);
      if (!a(2)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(2, this.jdField_b_of_type_AndroidOsHandler);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenWidgetDoyen != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenWidgetDoyen.b();
        }
        QQMusicHelper.a(getContext());
        if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiQQMusicWidget != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiQQMusicWidget.a();
        }
        n();
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public void c()
  {
    MsgPool.a().b().remove(MsgProxyUtils.a("2010741172", 1008));
    MsgPool.a().b().remove(MsgProxyUtils.a("2909288299", 1008));
    e();
    f();
    q();
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.c(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.c(this.jdField_a_of_type_ComTencentMobileqqAppQzoneMsgObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(this.jdField_a_of_type_ComTencentMobileqqAppQzoneMsgObserver);
  }
  
  public void d()
  {
    QQMusicHelper.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.getLongAccountUin());
  }
  
  public void e()
  {
    QQMusicHelper.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.getLongAccountUin());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiQQMusicWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiQQMusicWidget.b();
    }
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(2, this.jdField_b_of_type_AndroidOsHandler);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.c(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.c(this.jdField_a_of_type_ComTencentMobileqqAppQzoneMsgObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer$OnWidgetMoveListener = null;
  }
  
  public void h()
  {
    n();
    a(getContext());
  }
  
  public void i()
  {
    ((QzoneMsgHandler)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.a(61)).a();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenWidgetDoyen.a() == null)
    {
      UserSettings localUserSettings = UserSettingsHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app);
      if ((localUserSettings != null) && (localUserSettings.mQQDoyen != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenWidgetDoyen.setDoyen(localUserSettings.mQQDoyen);
      }
    }
    i();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenWidgetDoyen = ((WidgetDoyen)findViewById(2131302451));
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiQQMusicWidget = ((QQMusicWidget)findViewById(2131302450));
    a(getContext());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer$OnWidgetMoveListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer$OnWidgetMoveListener.a(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setWidgetMoveListener(WidgetContainer.OnWidgetMoveListener paramOnWidgetMoveListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer$OnWidgetMoveListener = paramOnWidgetMoveListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.WidgetContainer
 * JD-Core Version:    0.7.0.1
 */