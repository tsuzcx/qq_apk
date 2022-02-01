package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.etrump.mixlayout.FontManager;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatchCallback;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatcherCallback;
import com.tencent.mobileqq.business.sougou.WordMatchManager.WordMatcher;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.AvatarPendantMarketActivity;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ContainerView.SelectableTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import fff;
import ffg;
import ffh;
import ffi;
import java.io.File;

@TargetApi(11)
public class TextPreviewActivity
  extends BaseActivity
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 16;
  public static long a = 0L;
  public static final String a = "uin_type";
  public static final boolean a = true;
  static final int jdField_b_of_type_Int = 17;
  public static final String b = "content";
  public static final String c = "uniseq";
  public static final String d = "peeruin";
  public static final String e = "senderuin";
  public static final String f = "bubbleId";
  public static final String g = "pendantId";
  public static final String h = "fontId";
  public static final String i = "scrollToBubble";
  public static final String j = "fromAIO";
  private static final String l = "我正在使用的装扮";
  private static final String m = "TA正在使用的装扮";
  Context jdField_a_of_type_AndroidContentContext = this;
  private Rect jdField_a_of_type_AndroidGraphicsRect = null;
  public Handler a;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FontManager jdField_a_of_type_ComEtrumpMixlayoutFontManager = null;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public WordMatchManager.MatchCallback a;
  WordMatchManager.MatcherCallback jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback = new ffh(this);
  public WordMatchManager.WordMatcher a;
  ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = null;
  public QQText a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new ffi(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  private ContainerView jdField_a_of_type_ComTencentMobileqqWidgetContainerView;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  public int c;
  private long jdField_c_of_type_Long = 0L;
  private View jdField_c_of_type_AndroidViewView;
  public int d;
  private View d;
  public int e;
  private View e;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private View g;
  public String k = null;
  private String n = null;
  private String o;
  
  public TextPreviewActivity()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTextQQText = null;
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchCallback = new ffg(this);
  }
  
  private void a()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    BubbleManager localBubbleManager = (BubbleManager)this.app.getManager(43);
    Object localObject2 = localBubbleManager.a(this.jdField_f_of_type_Int, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = BubbleUtils.a;
    }
    boolean bool;
    int i1;
    if (!this.n.equals(this.app.getAccount()))
    {
      bool = false;
      ((BubbleInfo)localObject1).a(this.app, bool, true, false, this.jdField_a_of_type_AndroidWidgetTextView);
      localObject2 = localBubbleManager.a(this.jdField_f_of_type_Int, true);
      i1 = Color.parseColor("#808080");
      localObject1 = new File(((BubbleInfo)localObject1).a);
      if ((localObject2 == null) || (!((File)localObject1).exists())) {
        break label510;
      }
      localObject1 = ((BubbleConfig)localObject2).m;
      i1 = ((BubbleConfig)localObject2).b;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i1);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.isPendantValid()))
      {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        localObject1 = (ImageView)findViewById(2131296751);
        localObject2 = ((AvatarPendantManager)this.app.getManager(45)).a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId);
        if (AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId))
        {
          ((PendantInfo)localObject2).a(this.jdField_a_of_type_ComTencentImageURLImageView, 2, PendantInfo.m);
          label238:
          ((ImageView)localObject1).setImageDrawable(FaceDrawable.a(this.app, 1, this.n));
          this.g.setVisibility(8);
          label263:
          this.jdField_a_of_type_ComEtrumpMixlayoutFontManager = ((FontManager)this.app.getManager(41));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296761));
          if (this.jdField_a_of_type_ComEtrumpMixlayoutFontManager == null) {
            break label505;
          }
        }
      }
      label505:
      for (bool = this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a;; bool = false)
      {
        if (!bool)
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.g.setVisibility(8);
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          localObject1 = AnimationUtils.loadAnimation(this, 2130968759);
          this.jdField_d_of_type_AndroidViewView.startAnimation((Animation)localObject1);
          return;
          bool = true;
          break;
          ((PendantInfo)localObject2).a(this.jdField_a_of_type_ComTencentImageURLImageView, 1, PendantInfo.m);
          break label238;
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          this.g.setVisibility(0);
          break label263;
        }
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) {
          this.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.uVipFont);
        }
        if (this.jdField_d_of_type_Int == 0) {}
        for (localObject1 = getResources().getDrawable(2130840707);; localObject1 = this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(this.jdField_d_of_type_Int))
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            a(this.jdField_d_of_type_Int);
            localObject2 = getResources().getDrawable(2130840707);
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          break;
        }
      }
      label510:
      localObject1 = "默认气泡";
    }
  }
  
  public static void a(String paramString1, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString2, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramString2 = paramQQAppInterface.a().a(paramString2, paramInt, paramLong);
    } while (paramString2 == null);
    if ((paramBoolean) && (((paramString2 instanceof MessageForMixedMsg)) || ((paramString2 instanceof MessageForLongMsg))))
    {
      QfavBuilder.b(paramString2).b(paramQQAppInterface, paramString2).b(paramActivity, paramQQAppInterface.getAccount());
      QfavReport.a(paramQQAppInterface, 66, 8);
      return;
    }
    QfavBuilder.a(null, paramString1).b(paramQQAppInterface, paramString2).b(paramActivity, paramQQAppInterface.getAccount());
    QfavReport.a(paramQQAppInterface, 66, 1);
  }
  
  void a(int paramInt)
  {
    Object localObject = new File(FontManager.b + File.separatorChar + paramInt + File.separatorChar + "fontname.png");
    String str = "https://imgcache.qq.com/qqshow/admindata/comdata/vipfont_" + Integer.toString(paramInt) + File.separatorChar + "aio.png";
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "getFontInfo fontId=" + paramInt + " will down ,file path=" + ((File)localObject).getAbsolutePath());
    }
    Bundle localBundle = new Bundle();
    localObject = new DownloadTask(str, (File)localObject);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
  }
  
  protected boolean a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    paramView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.jdField_a_of_type_AndroidGraphicsRect.left = arrayOfInt[0];
    this.jdField_a_of_type_AndroidGraphicsRect.top = arrayOfInt[1];
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    paramView.right += arrayOfInt[0];
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    int i1 = paramView.bottom;
    paramView.bottom = (arrayOfInt[1] + i1);
    return this.jdField_a_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (a(this.jdField_d_of_type_AndroidViewView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this))
    {
      if (paramMotionEvent.getAction() != 0) {
        break label90;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a()) {
        break label82;
      }
      this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      label82:
      this.jdField_a_of_type_AndroidViewMotionEvent = null;
      continue;
      label90:
      if ((this.jdField_a_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 1)) {
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this))
        {
          int i1 = (int)this.jdField_a_of_type_AndroidViewMotionEvent.getX() - (int)paramMotionEvent.getX();
          int i2 = (int)this.jdField_a_of_type_AndroidViewMotionEvent.getY() - (int)paramMotionEvent.getY();
          if ((i1 * i1 + i2 * i2 < 10000) && (paramMotionEvent.getEventTime() - this.jdField_a_of_type_AndroidViewMotionEvent.getEventTime() < 200L))
          {
            this.jdField_a_of_type_AndroidViewMotionEvent = null;
            finish();
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setLayerType(0, null);
      this.jdField_a_of_type_ComTencentWidgetScrollView.setLayerType(0, null);
    }
    WordMatchManager localWordMatchManager = (WordMatchManager)this.app.getManager(77);
    if (localWordMatchManager != null) {
      localWordMatchManager.a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher != null) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher.a(this.jdField_e_of_type_Int);
    }
  }
  
  public void finish()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_b_of_type_Long;
    if (this.o != null) {}
    for (int i1 = this.o.length();; i1 = 0)
    {
      ReportController.b(this.app, "CliOper", "", "", "long_msg", "long_msg_amount", 0, 0, String.valueOf(l1 - l2), String.valueOf(i1), "", "");
      super.finish();
      overridePendingTransition(0, 2130968598);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    int i1;
    boolean bool;
    if (l1 - this.jdField_c_of_type_Long > 500L)
    {
      this.jdField_c_of_type_Long = l1;
      i1 = paramView.getId();
      if (i1 != 2131296755) {
        break label497;
      }
      paramView = (GameCenterManagerImp)this.app.getManager(11);
      if (paramView == null) {
        break label1237;
      }
      if (paramView.a("100005.100003") == -1) {
        break label446;
      }
      bool = true;
    }
    for (;;)
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("updateFlag", bool);
      localIntent.putExtra("bubbleId", this.jdField_f_of_type_Int);
      localIntent.putExtra("scrollToBubble", true);
      localIntent.putExtra("fromAIO", true);
      localIntent.putExtra("individuation_url_type", 300);
      VasWebviewUtil.a(this, "https://imgcache.qq.com/club/themes/mobile/bubble/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&updateTime=[updateTime]&updateFlag=[updateFlag]&updateId=[updateId]&adtag=mvip.gexinghua.mobile.bubble.client_tab_store&_bid=122&_wv=1027", 64L, localIntent, false, -1);
      int i2;
      label166:
      int i3;
      label180:
      int i4;
      label194:
      int i5;
      label208:
      int i6;
      label222:
      int i7;
      if (bool)
      {
        if (paramView.a("100005.100001") == -1) {
          break label452;
        }
        i2 = 1;
        if (paramView.a("100005.100002") == -1) {
          break label457;
        }
        i3 = 1;
        if (paramView.a("100005.100006") == -1) {
          break label463;
        }
        i4 = 1;
        if (paramView.a("100005.100018") == -1) {
          break label469;
        }
        i5 = 1;
        if (paramView.a("100005.100020") == -1) {
          break label475;
        }
        i6 = 1;
        if (paramView.a("100005.100021") == -1) {
          break label481;
        }
        i7 = 1;
        label236:
        bool = ((FontManager)this.app.getManager(41)).a;
        i1 = 0;
        if (bool)
        {
          if (paramView.a("100005.100011") == -1) {
            break label487;
          }
          i1 = 1;
        }
        label273:
        if (((bool) && (i2 == 0) && (i3 == 0) && (i4 == 0) && (i1 == 0) && (i5 == 0) && (i6 == 0) && (i7 == 0)) || ((!bool) && (i2 == 0) && (i3 == 0) && (i4 == 0) && (i5 == 0) && (i6 == 0) && (i7 == 0))) {
          if (paramView.a("100005") == -1) {
            break label492;
          }
        }
      }
      label446:
      label452:
      label457:
      label463:
      label469:
      label475:
      label481:
      label487:
      label492:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != 0)
        {
          BusinessInfoCheckUpdateItem.a(this.app, "100005", false);
          ((RedTouchManager)this.app.getManager(35)).b("100005");
        }
        ((RedTouchManager)this.app.getManager(35)).b("100005.100003");
        ReportController.b(this.app, "CliOper", "", "", "BigTextPage", "bubble_enter", 0, 0, "", "", "", "");
        return;
        bool = false;
        break;
        i2 = 0;
        break label166;
        i3 = 0;
        break label180;
        i4 = 0;
        break label194;
        i5 = 0;
        break label208;
        i6 = 0;
        break label222;
        i7 = 0;
        break label236;
        i1 = 0;
        break label273;
      }
      label497:
      if (i1 == 2131296760)
      {
        paramView = (GameCenterManagerImp)this.app.getManager(11);
        if (paramView == null) {
          break label1231;
        }
        if (paramView.a("100005.100011") != -1) {
          bool = true;
        }
      }
      for (;;)
      {
        localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("updateFlag", bool);
        localIntent.putExtra("fontId", this.jdField_d_of_type_Int);
        localIntent.putExtra("fromAIO", true);
        localIntent.putExtra("individuation_url_type", 300);
        VasWebviewUtil.a(this, VasWebviewConstants.CHAT_FONT_MARKET_HOME_URL, 4096L, localIntent, false, -1);
        if (bool)
        {
          if (paramView.a("100005.100001") == -1) {
            break label790;
          }
          i1 = 1;
          label624:
          if (paramView.a("100005.100002") == -1) {
            break label795;
          }
          i2 = 1;
          label637:
          if (paramView.a("100005.100006") == -1) {
            break label800;
          }
          i3 = 1;
          label651:
          if (paramView.a("100005.100003") == -1) {
            break label806;
          }
          i4 = 1;
          label665:
          if ((i1 == 0) && (i2 == 0) && (i3 == 0) && (i4 == 0)) {
            if (paramView.a("100005") == -1) {
              break label812;
            }
          }
        }
        label790:
        label795:
        label800:
        label806:
        label812:
        for (i1 = 1;; i1 = 0)
        {
          if (i1 != 0)
          {
            BusinessInfoCheckUpdateItem.a(this.app, "100005", false);
            ((RedTouchManager)this.app.getManager(35)).b("100005");
          }
          ((RedTouchManager)this.app.getManager(35)).b("100005.100011");
          ReportController.b(this.app, "CliOper", "", "", "BigTextPage", "font_enter", 0, 0, "", "", "", "");
          return;
          bool = false;
          break;
          i1 = 0;
          break label624;
          i2 = 0;
          break label637;
          i3 = 0;
          break label651;
          i4 = 0;
          break label665;
        }
        if (i1 != 2131296750) {
          break;
        }
        paramView = (GameCenterManagerImp)this.app.getManager(11);
        if (paramView != null) {
          if (paramView.a("100005.100006") != -1) {
            i1 = 1;
          }
        }
        for (;;)
        {
          localIntent = new Intent(this, AvatarPendantMarketActivity.class);
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent.putExtra("hide_left_button", false);
          localIntent.putExtra("show_right_close_button", false);
          localIntent.putExtra("pendantId", this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId);
          localIntent.putExtra("fromAIO", true);
          localIntent.putExtra("url", VasWebviewConstants.AVATAR_PENDANT_URL);
          localIntent.putExtra("business", 512L);
          localIntent.putExtra("individuation_url_type", 300);
          VasWebviewUtil.a(512L, localIntent);
          localIntent.putExtra("isShowAd", false);
          startActivity(localIntent);
          ReportController.b(null, "CliOper", "", "", "PendantMarket", "AIOPreviewEntrance", 0, 0, "", "", "", "");
          if (i1 != 0)
          {
            if (paramView.a("100005.100001") == -1) {
              break label1199;
            }
            i1 = 1;
            label1034:
            if (paramView.a("100005.100002") == -1) {
              break label1204;
            }
            i2 = 1;
            label1047:
            if (paramView.a("100005.100006") == -1) {
              break label1209;
            }
            i3 = 1;
            label1061:
            if (paramView.a("100005.100003") == -1) {
              break label1215;
            }
            i4 = 1;
            label1075:
            if ((i1 == 0) && (i2 == 0) && (i3 == 0) && (i4 == 0)) {
              if (paramView.a("100005") == -1) {
                break label1221;
              }
            }
          }
          label1199:
          label1204:
          label1209:
          label1215:
          label1221:
          for (i1 = 1;; i1 = 0)
          {
            if (i1 != 0)
            {
              BusinessInfoCheckUpdateItem.a(this.app, "100005", false);
              ((RedTouchManager)this.app.getManager(35)).b("100005");
            }
            ((RedTouchManager)this.app.getManager(35)).b("100005.100011");
            ReportController.b(this.app, "CliOper", "", "", "BigTextPage", "pendant_enter", 0, 0, "", "", "", "");
            return;
            i1 = 0;
            break;
            i1 = 0;
            break label1034;
            i2 = 0;
            break label1047;
            i3 = 0;
            break label1061;
            i4 = 0;
            break label1075;
          }
          i1 = 0;
        }
        label1231:
        bool = false;
      }
      label1237:
      bool = false;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((this.app == null) && ((getAppRuntime() instanceof QQAppInterface))) {
      this.app = ((QQAppInterface)getAppRuntime());
    }
    if (this.app == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "TextPreviewActivity onCreate,  the app is null");
      }
      finish();
    }
    do
    {
      return;
      setContentView(2130903086);
      paramBundle = getIntent();
      this.k = paramBundle.getStringExtra("peeruin");
      this.n = paramBundle.getStringExtra("senderuin");
      this.jdField_c_of_type_Int = paramBundle.getIntExtra("uin_type", 0);
      this.jdField_f_of_type_Int = ((int)paramBundle.getLongExtra("bubbleId", 0L));
      this.o = paramBundle.getStringExtra("content");
      this.jdField_e_of_type_AndroidViewView = findViewById(2131296754);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131296759);
      this.g = findViewById(2131296763);
      long l1 = paramBundle.getLongExtra("uniseq", 0L);
      this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = ((FriendsManagerImp)this.app.getManager(8)).a(this.n);
      this.jdField_a_of_type_AndroidOsHandler = new fff(this, Looper.getMainLooper());
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)this.app.getManager(46));
      if (jdField_a_of_type_Long != l1)
      {
        ContainerView.jdField_a_of_type_Float = 0.0F;
        jdField_a_of_type_Long = l1;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView = ((ContainerView)findViewById(2131296744));
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setMsgHandler(this.jdField_a_of_type_AndroidOsHandler);
      this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)findViewById(2131296743));
      this.jdField_a_of_type_ComTencentWidgetScrollView.setOverScrollMode(2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setOutScrollView(this.jdField_a_of_type_ComTencentWidgetScrollView);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131296747);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131296750);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131296760);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131296755);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296756));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296758));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131296753));
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      paramBundle = (TextView)findViewById(2131296749);
    } while (TextUtils.isEmpty(this.n));
    if (!this.n.equals(this.app.getAccount())) {
      paramBundle.setText("TA正在使用的装扮");
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setLayerType(1, null);
        this.jdField_a_of_type_ComTencentWidgetScrollView.setLayerType(1, null);
      }
      paramBundle = new QQText(this.o, 13, 32, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramBundle = (WordMatchManager)this.app.getManager(77);
      if (paramBundle == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback);
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher == null) {
        break;
      }
      this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher.a(1, this.o, 3, this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchCallback);
      return;
      paramBundle.setText("我正在使用的装扮");
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    a();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity
 * JD-Core Version:    0.7.0.1
 */