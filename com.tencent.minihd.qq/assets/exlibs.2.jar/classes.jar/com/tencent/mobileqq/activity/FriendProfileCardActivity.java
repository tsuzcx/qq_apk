package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter.ShowExternalTroopCompator;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopCompator;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItemWithMask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileGameView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.profile.view.ProfilePhotoView;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipProfileSimpleView;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.unifiedname.MQQProfileNameTranslator;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.MotionEventInterceptor;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.CoverCacheData;
import eai;
import eaj;
import ean;
import eas;
import eat;
import eau;
import eav;
import eaw;
import eax;
import eay;
import eaz;
import eba;
import ebb;
import ebc;
import ebd;
import ebg;
import ebh;
import ebi;
import ebm;
import ebn;
import ebo;
import ebq;
import ebr;
import ebs;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class FriendProfileCardActivity
  extends ProfileActivity
  implements Handler.Callback, BounceScrollView.MotionEventInterceptor, Observer
{
  public static final float a = 16.0F;
  public static final int a = 30;
  public static long a = 0L;
  public static final String a = "Vip_SummaryCard";
  public static final float b = 0.125F;
  public static final int b = 5;
  private static final int bP = 1;
  private static final int bR = 0;
  private static final int bS = 1;
  private static final int bT = 2;
  private static final int bU = 3;
  private static final int bV = 4;
  private static final int bW = 5;
  private static final int bX = 6;
  private static final int bY = 7;
  private static final int bZ = 8;
  private static final int ca = 1;
  private static final int cb = 2;
  private static final int cc = 3;
  private static final int cd = 4;
  private static final int ce = 6;
  private static final int cf = 7;
  private static final int cg = 8;
  private static final int ch = 9;
  private static final int ci = 10;
  private static final int cj = 12;
  private static final int ck = 5;
  private static final int cm = 1;
  private static final int cn = 2;
  private static final int co = 4;
  private static final int cp = 5;
  private static final int cq = 6;
  private static final int cr = 7;
  private static final int cs = 8;
  private static final String dy = "FriendProfileCardActivity";
  public static final int f = 3;
  public static final int g = 11;
  public static final int h = 13;
  private long X = 0L;
  private long Y;
  private long Z;
  public Dialog a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ebm(this);
  public DialogInterface.OnClickListener a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Drawable a;
  public Uri a;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ean(this);
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new eaj(this);
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new eay(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ProfileActivity.CardContactInfo a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ebd(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ebh(this);
  protected TroopObserver a;
  public ProfileBusiEntry a;
  public ProfileCardInfo a;
  private ProfileCardTemplate jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
  public ProfileHeaderView a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new eaw(this);
  protected QQCustomDialog a;
  public TimeTraceUtil a;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
  public ProfileCardMoreInfoView a;
  protected QQProgressDialog a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  Runnable jdField_a_of_type_JavaLangRunnable = new eba(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList = null;
  public HashMap a;
  boolean jdField_a_of_type_Boolean = false;
  public int[] a;
  public String[] a;
  public long b;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  public DialogInterface.OnClickListener b;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public View b;
  private AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private CardObserver jdField_b_of_type_ComTencentMobileqqAppCardObserver = new ebg(this);
  public Runnable b;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  private int bQ = 0;
  protected int c;
  public long c;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  public boolean c;
  private int cl = 0;
  public int d;
  long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  public int e;
  long e;
  private boolean f = false;
  private boolean g = false;
  private boolean h;
  public int i;
  private boolean i;
  
  public FriendProfileCardActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = new ProfileCardInfo();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new eai(this);
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidOsHandler = new eau(this, Looper.getMainLooper());
    this.jdField_i_of_type_Int = 30000;
    this.jdField_b_of_type_JavaLangRunnable = new eaz(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ebb(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new ebc(this);
  }
  
  private void A()
  {
    int n = 3;
    int m = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName == null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName = new MQQProfileName();
    }
    int k = m;
    int j = n;
    switch (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      j = 0;
      k = m;
    }
    for (;;)
    {
      MQQProfileNameTranslator.a(j, k, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateProfileName profileName=" + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.toString());
      }
      return;
      j = 1;
      k = 2;
      continue;
      k = 2;
      j = 2;
      continue;
      k = 2;
      j = n;
      continue;
      j = 4;
      k = m;
      continue;
      k = 2;
      j = 6;
      continue;
      j = 6;
      k = m;
      continue;
      k = 2;
      j = 7;
      continue;
      j = 7;
      k = m;
      continue;
      j = 8;
      k = m;
      continue;
      j = 9;
      k = m;
      continue;
      j = 11;
      k = m;
      continue;
      j = 10;
      k = m;
      continue;
      j = 5;
      k = m;
    }
  }
  
  private void B()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int == 100) && (GesturePWDUtils.getJumpLock(getActivity(), this.app.a()))) {
      startUnlockActivity();
    }
  }
  
  private void C()
  {
    for (;;)
    {
      try
      {
        FrameLayout localFrameLayout = (FrameLayout)findViewById(16908290);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null) {
          break label301;
        }
        localFrameLayout.setForeground(null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundResource(0);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.b();
        if (Build.VERSION.SDK_INT >= 11)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.f) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable)))
          {
            localObject = ((BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
            ThreadManager.a().post(new eax(this, (Bitmap)localObject));
          }
        }
        else
        {
          localFrameLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          if (!ThemeUtil.isInNightMode(this.app)) {
            break label282;
          }
          if (this.jdField_b_of_type_AndroidViewView != null) {
            this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "update item style");
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a();
          return;
        }
        Object localObject = localFrameLayout.getChildAt(0);
        if ((localObject == null) || (((View)localObject).getBackground() == null)) {
          continue;
        }
        ((View)localObject).setBackgroundDrawable(null);
        continue;
        if (this.jdField_b_of_type_AndroidViewView == null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateTheme exception msg=" + localException.getMessage());
        }
        localException.printStackTrace();
        return;
      }
      label282:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      continue;
      label301:
      localException.setForeground(getResources().getDrawable(2130841809));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundResource(2130837687);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837687);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundResource(0);
    }
  }
  
  private void D()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable)))
    {
      BitmapDrawable localBitmapDrawable = (BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      Object localObject = ProfileCardUtil.b(this, this.jdField_b_of_type_JavaLangString);
      localObject = "profilecard:" + (String)localObject;
      localObject = (Pair)BaseApplicationImpl.a.get(localObject);
      if ((localObject != null) && (((Pair)localObject).first != null) && (localBitmapDrawable.getConstantState() != ((Pair)localObject).first))
      {
        localBitmapDrawable.getBitmap().recycle();
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      }
    }
  }
  
  private TroopInfo a()
  {
    new ArrayList();
    Object localObject = ((TroopManager)this.app.getManager(50)).b();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Entity localEntity = (Entity)((Iterator)localObject).next();
      int j = TroopListAdapter2.a(this.app.b(((TroopInfo)localEntity).troopuin));
      if ((((TroopInfo)localEntity).dwAdditionalFlag & 1L) == 1L) {
        localArrayList1.add(new TroopListAdapter2.TroopListItemWithMask(j, localEntity));
      } else if ((((TroopInfo)localEntity).dwCmdUinUinFlag & 1L) == 1L) {
        localArrayList2.add(new TroopListAdapter2.TroopListItemWithMask(j, localEntity));
      } else {
        localArrayList3.add(new TroopListAdapter2.TroopListItemWithMask(j, localEntity));
      }
    }
    localObject = new TroopListAdapter2.TroopCompator();
    Collections.sort(localArrayList1, (Comparator)localObject);
    Collections.sort(localArrayList2, (Comparator)localObject);
    Collections.sort(localArrayList3, (Comparator)localObject);
    if (localArrayList1.size() != 0) {
      return (TroopInfo)((TroopListAdapter2.TroopListItemWithMask)localArrayList1.get(0)).a;
    }
    if (localArrayList2.size() != 0) {
      return (TroopInfo)((TroopListAdapter2.TroopListItemWithMask)localArrayList2.get(0)).a;
    }
    if (localArrayList3.size() != 0) {
      return (TroopInfo)((TroopListAdapter2.TroopListItemWithMask)localArrayList3.get(0)).a;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    int j = 0;
    int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (paramInt == 0) {
        j = 8;
      }
      ((LinearLayout)localObject).setVisibility(j);
      while (paramInt < k)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        paramInt += 1;
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 9, 2131368233, 2130840480, 2131362003);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 23, 2131369023, 2130840884, 2131362045);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131368232, 2130840474, 2131362000);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 20, 2131368267, 2130840477, 2131362002);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131366330, 2130840484, 2131362001);
      paramInt = 5;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131368232, 2130840474, 2131362000);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131366330, 2130840484, 2131362001);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131368267, 2130840477, 2131362002);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131366330, 2130840484, 2131362001);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131368232, 2130840474, 2131362000);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 20, 2131368267, 2130840477, 2131362002);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131368232, 2130840474, 2131362000);
      paramInt = 1;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 8, 2131366330, 2130840484, 2131362001);
      paramInt = 1;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131368267, 2130840477, 2131362002);
      paramInt = 1;
      continue;
      paramInt = 0;
    }
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "requestUpdateCard() mHasTriedCount = " + this.cl);
    }
    if (this.cl > 5) {}
    CardHandler localCardHandler;
    do
    {
      return;
      localCardHandler = (CardHandler)this.app.a(2);
    } while (localCardHandler == null);
    this.cl += 1;
    byte[] arrayOfByte1;
    if (paramArrayOfByte1 == null)
    {
      arrayOfByte1 = new byte[1];
      arrayOfByte1[0] = 0;
    }
    for (;;)
    {
      byte[] arrayOfByte2;
      if (paramArrayOfByte2 == null)
      {
        arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = 0;
      }
      for (;;)
      {
        int j = 12;
        byte b1 = 0;
        long l3 = a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        long l2;
        long l1;
        switch (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
        {
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 23: 
        case 24: 
        case 28: 
        case 29: 
        case 33: 
        case 38: 
        case 39: 
        case 43: 
        case 44: 
        case 45: 
        case 48: 
        case 49: 
        case 53: 
        case 54: 
        case 59: 
        case 62: 
        case 63: 
        case 64: 
        case 65: 
        case 66: 
        case 67: 
        case 68: 
        case 69: 
        case 76: 
        default: 
          return;
        case 0: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 0, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 60: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 26, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 1: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 40: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 41: 
          j = 6;
          paramArrayOfByte1 = "";
          if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
          {
            j = 37;
            paramArrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.o;
          }
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, j, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, arrayOfByte2);
          return;
        case 42: 
        case 73: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 8, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 36: 
          localCardHandler.a(this.app.a(), "0", 32, paramLong, (byte)0, 0L, 0L, arrayOfByte1, a(), l3, 3014, arrayOfByte2);
          return;
        case 30: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 15, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 31: 
        case 32: 
        case 34: 
        case 50: 
        case 51: 
          j = 16;
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) {
            j = 17;
          }
          localCardHandler.a(this.app.a(), "0", j, paramLong, (byte)0, 0L, 0L, arrayOfByte1, a(), l3, 10004, null);
          return;
        case 46: 
        case 47: 
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString == null) {
            break;
          }
          l2 = 0L;
          try
          {
            l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString).longValue();
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
            {
              j = 4;
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, j, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
            }
          }
          catch (Exception paramArrayOfByte1)
          {
            for (;;)
            {
              l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.i("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                l1 = l2;
                continue;
                j = 14;
              }
            }
          }
        case 20: 
        case 21: 
        case 22: 
        case 58: 
          l1 = ProfileCardUtil.a(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20)
          {
            j = 2;
            b1 = 1;
          }
          for (;;)
          {
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, j, paramLong, b1, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
            return;
            if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
            {
              j = 5;
              b1 = 0;
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22)
            {
              j = 7;
              b1 = 0;
            }
          }
        case 3: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 21, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 2: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 74: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 35: 
        case 37: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 31, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3001, arrayOfByte2);
          return;
        case 75: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 38, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3017, arrayOfByte2);
          return;
        case 61: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 27, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 70: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 36, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 25: 
        case 26: 
        case 27: 
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 3004) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 2004)) {
            if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString)) {}
          }
        case 4: 
        case 77: 
        case 52: 
        case 19: 
        case 55: 
        case 56: 
        case 57: 
        case 72: 
        case 71: 
          label2050:
          label2058:
          for (paramArrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString;; paramArrayOfByte1 = "0")
          {
            paramArrayOfByte2 = paramArrayOfByte1;
            if (paramArrayOfByte1 == null) {}
            for (paramArrayOfByte2 = "0";; paramArrayOfByte2 = "0")
            {
              for (;;)
              {
                l2 = 0L;
                try
                {
                  l1 = Long.parseLong(paramArrayOfByte2);
                  j = 11;
                  if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27) {
                    j = 35;
                  }
                  localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, j, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int, arrayOfByte2);
                  return;
                  if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString)) {
                    break label2058;
                  }
                  paramArrayOfByte1 = (TroopInfo)this.app.a().createEntityManager().a(TroopInfo.class, "troopcode=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString });
                  if (paramArrayOfByte1 == null) {
                    break label2058;
                  }
                  paramArrayOfByte1 = paramArrayOfByte1.troopuin;
                  break;
                  if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 3005) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 2005)) {
                    break label2050;
                  }
                  paramArrayOfByte2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString;
                }
                catch (Exception paramArrayOfByte1)
                {
                  for (;;)
                  {
                    l1 = l2;
                    if (QLog.isColorLevel())
                    {
                      QLog.e("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                      l1 = l2;
                    }
                  }
                }
              }
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 24, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 28, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 29, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 30, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 34, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 33, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
            }
          }
          arrayOfByte2 = paramArrayOfByte2;
        }
      }
      arrayOfByte1 = paramArrayOfByte1;
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent.putExtra("qzone_uin", this.app.a());
    String str2 = this.app.c();
    String str1 = str2;
    if (StringUtil.b(str2)) {
      str1 = ContactUtils.g(this.app, this.app.a());
    }
    paramIntent.putExtra("nickname", str1);
    paramIntent.putExtra("sid", this.app.getSid());
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      paramMotionEvent = this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
      if ((paramMotionEvent != null) && (paramMotionEvent != this.jdField_b_of_type_AndroidWidgetTextView.getAnimation()))
      {
        paramMotionEvent.reset();
        this.jdField_b_of_type_AndroidWidgetTextView.startAnimation(paramMotionEvent);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130838414);
    }
    do
    {
      do
      {
        return;
      } while ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3));
      this.h = false;
      paramMotionEvent = this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
    } while ((paramMotionEvent == null) || (paramMotionEvent == this.jdField_b_of_type_AndroidWidgetTextView.getAnimation()));
    paramMotionEvent.reset();
    this.jdField_b_of_type_AndroidWidgetTextView.startAnimation(paramMotionEvent);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView != null)
    {
      DataTag localDataTag = new DataTag(paramInt1, null);
      paramView.setVisibility(0);
      paramView.setTag(localDataTag);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(getString(paramInt4));
      paramView = (TextView)paramView.findViewById(2131297022);
      paramView.setText(paramInt2);
      paramView.setContentDescription(getString(paramInt4));
      if ((!a(paramInt1)) || (this.jdField_i_of_type_Boolean)) {
        break label108;
      }
      paramView.setTextColor(getResources().getColor(2131427972));
    }
    for (;;)
    {
      paramView.setEnabled(this.jdField_i_of_type_Boolean);
      return;
      label108:
      paramView.setTextColor(getResources().getColor(2131427970));
    }
  }
  
  private void a(View paramView, long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (paramView != null))
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "changeProfileHeaderView success remove timeout msg");
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
      }
      Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300377);
      if (localObject != null) {}
      try
      {
        localObject = (Animatable)((ImageView)localObject).getDrawable();
        if ((localObject != null) && (((Animatable)localObject).isRunning())) {
          ((Animatable)localObject).stop();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int k;
          int j;
          localException.printStackTrace();
        }
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView);
        this.g = true;
        this.Y = paramLong1;
        this.Z = paramLong2;
      }
      k = this.jdField_a_of_type_AndroidViewViewGroup.getChildCount();
      j = 0;
      while (j < k)
      {
        localObject = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(j);
        if ((localObject instanceof ProfileHeaderView)) {
          ((ProfileHeaderView)localObject).d();
        }
        j += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
    if ((!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) && (this.jdField_c_of_type_AndroidViewView != null)) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("headerViewRender", "initContentViewStart", false);
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    this.jdField_d_of_type_AndroidViewView = null;
    getResources().getColor(2131427889);
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      this.jdField_d_of_type_AndroidViewView = View.inflate(this, 2130903986, null);
      Object localObject = new LinearLayout.LayoutParams(0, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      paramLinearLayout.addView(this.jdField_d_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        localObject = new View(this);
        ((View)localObject).setBackgroundColor(0);
        paramLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(1, -1));
        this.jdField_d_of_type_AndroidViewView = View.inflate(this, 2130904119, null);
        localObject = new LinearLayout.LayoutParams(0, -1);
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject).gravity = 17;
        paramLinearLayout.addView(this.jdField_d_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_d_of_type_AndroidViewView).d(30).a();
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
          v();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)
      {
        localObject = new View(this);
        ((View)localObject).setBackgroundColor(0);
        paramLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(1, -1));
        this.jdField_d_of_type_AndroidViewView = View.inflate(this, 2130903986, null);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        localObject = new LinearLayout.LayoutParams(0, -1);
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject).gravity = 17;
        paramLinearLayout.addView(this.jdField_d_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
        localObject = new View(this);
        ((View)localObject).setBackgroundColor(0);
        paramLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(1, -1));
        this.jdField_d_of_type_AndroidViewView = View.inflate(this, 2130903986, null);
        localObject = new LinearLayout.LayoutParams(0, -1);
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject).gravity = 17;
        paramLinearLayout.addView(this.jdField_d_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void a(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "initContentView start...");
    }
    b(paramProfileCardInfo);
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initProfileMoreViewStart", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initProfileMoreViewEnd", "initProfileMoreViewStart", false);
    u();
  }
  
  private void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("cSpecialFlag", getIntent().getExtras().getInt("cSpecialFlag"));
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("aio_msg_source", 3);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int != 0) {
      localIntent.putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1];
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.m;
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString)))
    {
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString);
      localIntent.addFlags(67108864);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString)) {
        break label760;
      }
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString)) {
        localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString);
      }
      if (paramInt == 1009) {
        localIntent.putExtra("rich_status_sig", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
      }
      if (paramInt == 1001)
      {
        localIntent.putExtra("rich_accost_sig", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        if (QLog.isDevelopLevel()) {
          QLog.d("fight_accost", 4, "资料卡accost_uin = " + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString + "accost_sig = " + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
      }
      paramString = (FriendManager)this.app.getManager(8);
      if (paramString != null)
      {
        paramString = paramString.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (paramString.cSpecialFlag == 1))
        {
          localIntent.setClass(getActivity(), ChatActivity.class);
          localIntent.putExtra("chat_subType", 1);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 70) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int != 101)) {
        break label798;
      }
      localIntent.putExtra("is_from_manage_stranger", true);
      startActivityForResult(localIntent, 1010);
      return;
      if (((paramInt == 1000) || (paramInt == 1020)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        localIntent.putExtra("uinname", (String)localObject);
        break;
      }
      if ((paramInt == 1021) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2])))
      {
        localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2]);
        break;
      }
      if (paramInt == 1004)
      {
        paramString = null;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString != null) {
          paramString = ContactUtils.b(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        }
        localObject = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
        }
        localIntent.putExtra("uinname", (String)localObject);
        break;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3];
      }
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
      }
      localIntent.putExtra("uinname", (String)localObject);
      break;
      label760:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString)) {
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
      }
    }
    label798:
    startActivity(localIntent);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initCardContactInfoList");
    }
    PhoneContactManager localPhoneContactManager;
    if ((ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        localPhoneContactManager = (PhoneContactManager)this.app.getManager(10);
        if (localPhoneContactManager != null) {
          break label200;
        }
      }
    }
    return;
    label200:
    PhoneContact localPhoneContact;
    Object localObject;
    if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      localPhoneContact = localPhoneContactManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      localObject = localPhoneContact;
      if (paramBoolean) {
        break label558;
      }
      localObject = (FriendListHandler)this.app.a(1);
      if ((!((FriendListHandler)localObject).a()) && (!((FriendListHandler)localObject).b())) {
        ((FriendListHandler)localObject).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      localObject = localPhoneContact;
    }
    label558:
    for (;;)
    {
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject).name, ((PhoneContact)localObject).mobileCode, ((PhoneContact)localObject).nationCode));
        return;
        localPhoneContact = localPhoneContactManager.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject = localPhoneContact;
        if (localPhoneContact == null)
        {
          localPhoneContact = localPhoneContactManager.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          localObject = localPhoneContact;
          if (localPhoneContact != null)
          {
            localObject = localPhoneContact;
            if (!TextUtils.isEmpty(localPhoneContact.mobileCode))
            {
              this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = (localPhoneContact.nationCode + localPhoneContact.mobileCode);
              localObject = localPhoneContact;
            }
          }
        }
      }
      else
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo("", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ""));
        return;
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if ((paramInt < 0) && (paramInt > 6)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = paramString;
    return true;
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateNameList by Card");
      }
      return false;
    }
    boolean bool2;
    if ((paramBoolean) || (!TextUtils.isEmpty(paramCard.strNick))) {
      if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0], paramCard.strNick))
      {
        bool2 = true;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0] = paramCard.strNick;
      }
    }
    for (;;)
    {
      if (!paramBoolean)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramCard.strReMark)) {}
      }
      else
      {
        if ((!bool2) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4], paramCard.strReMark))) {
          break label554;
        }
        bool1 = true;
        label114:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4] = paramCard.strReMark;
      }
      if (!paramBoolean)
      {
        bool2 = bool1;
        if (TextUtils.isEmpty(paramCard.strAutoRemark)) {}
      }
      else
      {
        if ((!bool1) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[6], paramCard.strAutoRemark))) {
          break label559;
        }
        bool2 = true;
        label171:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[6] = paramCard.strAutoRemark;
      }
      if (!paramBoolean)
      {
        paramBoolean = bool2;
        if (TextUtils.isEmpty(paramCard.strTroopNick)) {}
      }
      else
      {
        if ((!bool2) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1], paramCard.strTroopNick))) {
          break label565;
        }
        paramBoolean = true;
        label228:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1] = paramCard.strTroopNick;
      }
      boolean bool1 = paramBoolean;
      if (!TextUtils.isEmpty(paramCard.strContactName))
      {
        if ((paramBoolean) || (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3], paramCard.strContactName)))
        {
          bool1 = true;
          label278:
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3] = paramCard.strContactName;
        }
      }
      else
      {
        paramBoolean = bool1;
        if (!TextUtils.isEmpty(paramCard.strAutoRemark)) {
          if ((!bool1) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2], paramCard.strAutoRemark))) {
            break label575;
          }
        }
      }
      label554:
      label559:
      label565:
      label575:
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2] = paramCard.strAutoRemark;
        if (QLog.isColorLevel())
        {
          paramCard = new StringBuilder();
          paramCard.append("updateNameList()").append(", bRet = ").append(paramBoolean).append(", strNick = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0])).append(", strRemark = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4])).append(", strContactName = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3])).append(", strCircleName = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2])).append(", strRecommenName = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[5])).append(", strTroopNickName = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1])).append(", strAutoRemark = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[6]));
          QLog.d("Q.profilecard.FrdProfileCard", 2, paramCard.toString());
        }
        return paramBoolean;
        bool2 = false;
        break;
        bool1 = false;
        break label114;
        bool2 = false;
        break label171;
        paramBoolean = false;
        break label228;
        bool1 = false;
        break label278;
      }
      bool2 = false;
    }
  }
  
  private boolean a(ContactCard paramContactCard, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramContactCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateNameList by ContactCard");
      }
      return false;
    }
    if ((paramBoolean) || (!TextUtils.isEmpty(paramContactCard.nickName))) {
      if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0], paramContactCard.nickName))
      {
        paramBoolean = true;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0] = paramContactCard.nickName;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContactCard.strContactName))
      {
        if (!paramBoolean)
        {
          paramBoolean = bool;
          if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3], paramContactCard.strContactName)) {}
        }
        else
        {
          paramBoolean = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3] = paramContactCard.strContactName;
        return paramBoolean;
        paramBoolean = false;
        break;
      }
      return paramBoolean;
      paramBoolean = false;
    }
  }
  
  private boolean a(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "checkParamValidate() cardInfo.allinone = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    }
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {}
    while (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {}
    try
    {
      Long.parseLong(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 55)) {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "rich statuc profile, ricthStatus id = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int + ", entry = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g);
        }
      }
      for (;;)
      {
        return true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.profilecard.FrdProfileCard", 2, "通讯录陌生人： cardInfo.allinone.uin = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
        paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int = 0;
      }
      return false;
    }
    catch (NumberFormatException paramProfileCardInfo) {}
  }
  
  private void b(int paramInt) {}
  
  private void b(Intent paramIntent)
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int)
    {
    default: 
      return;
    case 1: 
      paramIntent.putExtra("refer", "mqqSetProfile");
      return;
    case 2: 
      paramIntent.putExtra("refer", "mqqAvatar");
      return;
    case 3: 
      paramIntent.putExtra("refer", "mqqQuanzi");
      return;
    case 4: 
      paramIntent.putExtra("refer", "mqqNearby");
      return;
    case 5: 
      paramIntent.putExtra("refer", "mqqChat");
      return;
    }
    paramIntent.putExtra("refer", "mqqQunSpace");
  }
  
  private void b(ProfileCardInfo paramProfileCardInfo)
  {
    for (;;)
    {
      boolean bool1;
      long l1;
      String str;
      long l2;
      Object localObject;
      try
      {
        bool1 = this.g;
        if (bool1 == true) {
          return;
        }
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "start initHeaderView downloadProfileResTimesMap=" + this.jdField_a_of_type_JavaUtilHashMap + ",initProfileConfigTimes=" + this.jdField_e_of_type_Int);
        }
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
          break label1078;
        }
        l1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
        int j = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
        str = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl;
        l2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initHeaderView user card lCurrentStyleId=" + l1 + ",templateRet=" + j + ",backgroundUrl=" + str + ",color=" + l2);
        }
        if ((l1 < 0L) && (NetworkUtil.f(this))) {
          continue;
        }
        localObject = ProfileCardUtil.a(this.app, l1, true);
        if ((localObject == null) || (TextUtils.isEmpty(str)) || (j != 0) || (b(str)) || (this.jdField_e_of_type_Int > 3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "initHeaderView cardTemplate is null reset headerView downloadProfileResTimesMap=" + this.jdField_a_of_type_JavaUtilHashMap + ",initProfileConfigTimes=" + this.jdField_e_of_type_Int);
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
          this.jdField_b_of_type_Long = 0L;
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
          paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_c_of_type_AndroidViewView);
          a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
          C();
          continue;
        }
        bool1 = ProfileCardUtil.a(this.app);
      }
      finally {}
      boolean bool2 = ProfileCardUtil.a(this.app.getApplication(), str);
      if ((bool1) && (bool2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "create headerView and cardTemplate=" + ((ProfileCardTemplate)localObject).toString());
        }
        for (;;)
        {
          try
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.h != ((ProfileCardTemplate)localObject).h) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_b_of_type_JavaUtilHashMap.size() <= 0) || (!str.equals(this.jdField_b_of_type_JavaLangString))) {
              break label928;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "create headerView start");
            }
            paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
            if ((l1 != ProfileCardTemplate.jdField_b_of_type_Long) && (l1 != ProfileCardTemplate.c) && (l1 != ProfileCardTemplate.jdField_d_of_type_Long)) {
              break label812;
            }
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileGameView(this, paramProfileCardInfo);
            this.jdField_a_of_type_JavaUtilArrayList = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray();
            if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)
            {
              str = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
              localObject = this.app.getPreferences().getString("profile_card_other_head_open_time", "");
              if (!((String)localObject).equals(str)) {
                ThreadManager.a(new ebq(this));
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.profilecard.FrdProfileCard", 2, "today = " + str + ", lastDay = " + (String)localObject);
              }
            }
            a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId);
            this.jdField_b_of_type_Long = l1;
            C();
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "create headerView Exception msg=" + localException.getMessage());
            }
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
            paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
            this.jdField_b_of_type_Long = 0L;
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_c_of_type_AndroidViewView);
            a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
            C();
          }
          break;
          label812:
          if (l1 == ProfileCardTemplate.jdField_e_of_type_Long)
          {
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfilePhotoView(this, paramProfileCardInfo);
          }
          else if (l1 == ProfileCardTemplate.f)
          {
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileTagView(this, paramProfileCardInfo);
          }
          else if (l1 == ProfileCardTemplate.g)
          {
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new VipProfileSimpleView(this, paramProfileCardInfo);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
            paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_c_of_type_AndroidViewView);
          }
        }
        label928:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = ((ProfileCardTemplate)localObject);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
        this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initTemplateConfig", true);
        this.jdField_e_of_type_Int += 1;
        ThreadManager.a(new ebs(this, localException, l2, l1));
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("downloadTemplateStart", true);
        if ((QLog.isColorLevel()) && (localObject != null)) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "request to downloadCardTemplate backgroundUrl=" + localException + ",cardTemplate= " + ((ProfileCardTemplate)localObject).toString());
        }
        if (a(localException, false))
        {
          ThreadManager.a(new ebr(this, (ProfileCardTemplate)localObject, localException));
          continue;
          label1078:
          if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "create headerView by contactCard");
            }
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
            paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
            this.jdField_b_of_type_Long = 0L;
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_c_of_type_AndroidViewView);
            a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
            C();
          }
          else if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
          {
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
            this.jdField_b_of_type_Long = 0L;
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
            paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_c_of_type_AndroidViewView);
            a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
            C();
          }
        }
      }
    }
  }
  
  private String c()
  {
    Object localObject = null;
    try
    {
      String str = ContactUtils.d(this.app, a());
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
    return localObject;
    return null;
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 7)
    {
      onBackPressed();
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.app.a();
    String str2 = this.app.c();
    String str1 = str2;
    if (StringUtil.b(str2)) {
      str1 = this.app.c();
    }
    localUserInfo.jdField_b_of_type_JavaLangString = str1;
    localUserInfo.jdField_c_of_type_JavaLangString = this.app.getSid();
    QZoneHelper.a(this, localUserInfo, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int, -1);
  }
  
  private void d(String paramString)
  {
    int k = 1;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131368195);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ebn(this));
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label122;
      }
      j = 0;
    }
    for (;;)
    {
      if (j == 0) {
        break label540;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramString = new DataTag(16, null);
      this.jdField_c_of_type_AndroidWidgetTextView.setTag(paramString);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(this.jdField_i_of_type_Boolean);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131368194);
      break;
      label122:
      j = k;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 72)
      {
        j = k;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 71)
        {
          j = k;
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 70)
          {
            j = k;
            if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
            {
              j = k;
              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 21)
              {
                j = k;
                if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 58)
                {
                  j = k;
                  if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 22)
                  {
                    j = k;
                    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 46)
                    {
                      j = k;
                      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 47)
                      {
                        j = k;
                        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 41)
                        {
                          j = k;
                          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 42)
                          {
                            j = k;
                            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56)
                            {
                              j = k;
                              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57) {
                                if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
                                {
                                  j = k;
                                  if (TextUtils.isEmpty(c())) {
                                    j = 0;
                                  }
                                }
                                else if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36)
                                {
                                  j = 0;
                                }
                                else if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
                                {
                                  j = k;
                                  if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int == 0) {
                                    j = 0;
                                  }
                                }
                                else
                                {
                                  j = k;
                                  if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 2)
                                  {
                                    j = k;
                                    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 74)
                                    {
                                      j = k;
                                      if (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
                                        j = 0;
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label540:
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.profilecard.FrdProfileCard", 2, "addOrRefreshJoinedTroopThirdPartAppEntrance");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.shouldShowJoinedTroop()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry == null) {
        break label71;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
    }
    label71:
    Object localObject1;
    label282:
    Object localObject2;
    label374:
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break;
        }
        localObject1 = (TroopManager)this.app.getManager(50);
        if (localObject1 != null)
        {
          localObject1 = ((TroopManager)localObject1).c();
          if ((localObject1 == null) || (((List)localObject1).size() == 0)) {
            break label282;
          }
          Collections.sort((List)localObject1, new ShowExternalTroopListAdapter.ShowExternalTroopCompator());
          localObject1 = (ShowExternalTroop)((List)localObject1).get(0);
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry = new ProfileBusiEntry();
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_Int = 1024;
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_b_of_type_JavaLangString = getString(2131363980);
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_JavaLangString = ((ShowExternalTroop)localObject1).strFaceUrl;
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_c_of_type_JavaLangString = ((ShowExternalTroop)localObject1).troopName;
        }
        for (this.jdField_c_of_type_JavaLangString = ((ShowExternalTroop)localObject1).troopUin;; this.jdField_c_of_type_JavaLangString = ((TroopInfo)localObject1).troopuin)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_c_of_type_JavaLangString == null)) {
            break label374;
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
          ReportController.b(this.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_c_of_type_JavaLangString, "1", "", "");
          return;
          localObject1 = a();
          if ((localObject1 == null) || (((TroopInfo)localObject1).troopuin == null)) {
            break;
          }
          localObject2 = AvatarTroopUtil.a(AvatarTroopUtil.a(null, ((TroopInfo)localObject1).troopuin, 0));
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry = new ProfileBusiEntry();
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_Int = 1024;
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_b_of_type_JavaLangString = getString(2131363980);
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_JavaLangString = ((String)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_c_of_type_JavaLangString = ((TroopInfo)localObject1).troopname;
        }
      }
      localObject2 = (TroopHandler)this.app.a(19);
    } while ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null));
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin != null) && (Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin) != 0L)) {
          break label470;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        ((TroopHandler)localObject2).a((String)localObject1, 0, 1);
        return;
      }
      catch (NumberFormatException localNumberFormatException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FriendProfileCardActivity", 2, "NumberFormatException");
      return;
      label470:
      String str = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
    }
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update buttons");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      a(1);
      return;
    }
    boolean bool1 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool2 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool3 = ProfileActivity.AllInOne.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if ((bool1) && (bool2) && (bool3))
    {
      a(2);
      return;
    }
    if ((bool1) && (bool2))
    {
      a(3);
      return;
    }
    if ((bool2) && (bool3))
    {
      a(4);
      return;
    }
    if ((bool1) && (bool3))
    {
      a(5);
      return;
    }
    if (bool1)
    {
      a(6);
      return;
    }
    if (bool2)
    {
      a(7);
      return;
    }
    if (bool3)
    {
      a(5);
      return;
    }
    a(0);
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = ((RedTouchManager)this.app.getManager(35)).a(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
  }
  
  private void w()
  {
    if ((this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0))
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
      if (localRedTouchManager != null) {
        localRedTouchManager.b(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
      }
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
    }
  }
  
  @TargetApi(11)
  private void x()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardLayoutStart", true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initInfoCardCommonLayout");
    }
    Object localObject1 = getResources();
    Object localObject2 = ((Resources)localObject1).getDisplayMetrics();
    int j = ((Resources)localObject1).getDimensionPixelSize(2131492923);
    this.jdField_c_of_type_Int = (((Resources)localObject1).getDimensionPixelSize(2131493118) - j - (int)(((DisplayMetrics)localObject2).density * 66.0F));
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    localObject1 = View.inflate(this, 2130904002, null);
    this.jdField_c_of_type_AndroidViewView = ((View)localObject1).findViewById(2131300429);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)((View)localObject1).findViewById(2131297158));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.jdField_h_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setMotionEventInterceptor(this);
    this.jdField_b_of_type_AndroidViewView = ((View)localObject1).findViewById(2131300431);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131297357));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131297360));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131297348));
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130903990, null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131300376));
    localObject2 = new DataTag(29, null);
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(localObject2);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300377);
    if (localObject2 != null) {}
    try
    {
      localObject2 = (Animatable)((ImageView)localObject2).getDrawable();
      if (!((Animatable)localObject2).isRunning()) {
        ((Animatable)localObject2).start();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = ((ProfileCardMoreInfoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300378));
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.app);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(4);
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.addOnLayoutChangeListener(new ebo(this));
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300379));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject1).findViewById(2131299934));
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33)
      {
        localObject2 = (FriendsManager)this.app.getManager(49);
        if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((FriendsManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false);
        }
      }
      else
      {
        A();
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "initContentView add timeout msg");
          }
          localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject2, 10000L);
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initContentViewStart", true);
        a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.addView(this.jdField_a_of_type_AndroidViewView);
        setContentView((View)localObject1);
        getWindow().setBackgroundDrawable(null);
        d(null);
        this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardLayoutEnd", "initCardLayoutStart", false);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard = localException.a(a());
        a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard, false);
      }
    }
  }
  
  private void y()
  {
    long l = System.currentTimeMillis();
    Object localObject;
    if (ProfileActivity.a(this.jdField_d_of_type_Long, l))
    {
      this.jdField_d_of_type_Long = l;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 40) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 41) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 58)) {
        break label268;
      }
      localObject = "mvip.pingtai.mobileqq.androidziliaoka.fromfujinderen";
      if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.a())) {
        break label358;
      }
      localObject = String.format("https://m.vip.qq.com/redirect/index.php?go=androidzhanghao&sid=%s&qq=%s&aid=%s&_wv=5123", new Object[] { this.app.getSid(), Integer.valueOf(0), localObject });
      label127:
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQVipWeb() url = " + (String)localObject);
      }
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.a());
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
      localObject = this.app;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label401;
      }
    }
    label268:
    label401:
    for (int j = 23;; j = 24)
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "vip", "logo_in", j, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21))
      {
        localObject = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
      {
        localObject = "mvip.pingtai.mobileqq.androidziliaoka.fromtaolunzu";
        break;
      }
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject = "mvip.pingtai.mobileqq.androidziliaoka.fromlinshihuihua";
        break;
      }
      localObject = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
      break;
      label358:
      localObject = String.format("https://m.vip.qq.com/redirect/index.php?go=androidzhanghao&sid=%s&qq=%s&aid=%s&_wv=5123", new Object[] { this.app.getSid(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localObject });
      break label127;
    }
  }
  
  /* Error */
  private void z()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: invokestatic 283	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +13 -> 19
    //   9: ldc_w 285
    //   12: iconst_2
    //   13: ldc_w 1647
    //   16: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   23: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   26: getfield 1026	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   29: astore 4
    //   31: aload_0
    //   32: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   35: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   38: getfield 961	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   41: astore_2
    //   42: aload_0
    //   43: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   46: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   49: getfield 964	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:m	Ljava/lang/String;
    //   52: astore 7
    //   54: aload_0
    //   55: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   58: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   61: getfield 1650	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:l	Ljava/lang/String;
    //   64: astore 13
    //   66: aload_0
    //   67: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   70: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   73: getfield 1653	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:n	Ljava/lang/String;
    //   76: astore 5
    //   78: aload_0
    //   79: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   82: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   85: getfield 1656	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:k	Ljava/lang/String;
    //   88: astore 6
    //   90: aload_0
    //   91: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   94: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   97: getfield 1658	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   100: astore 14
    //   102: aload 4
    //   104: astore 8
    //   106: aload 4
    //   108: astore 9
    //   110: aload_0
    //   111: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   114: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   117: invokestatic 1036	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   120: ifeq +709 -> 829
    //   123: aload 4
    //   125: astore 8
    //   127: aload 4
    //   129: astore 9
    //   131: aload_0
    //   132: getfield 313	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   135: bipush 8
    //   137: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   140: checkcast 999	com/tencent/mobileqq/model/FriendManager
    //   143: astore_3
    //   144: aload_3
    //   145: ifnonnull +655 -> 800
    //   148: aload 4
    //   150: astore 10
    //   152: aload 11
    //   154: ifnull +1207 -> 1361
    //   157: aload 4
    //   159: astore_3
    //   160: aload 4
    //   162: astore 8
    //   164: aload 4
    //   166: astore 9
    //   168: aload 11
    //   170: getfield 1659	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   173: invokestatic 640	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne +17 -> 193
    //   179: aload 4
    //   181: astore 8
    //   183: aload 4
    //   185: astore 9
    //   187: aload 11
    //   189: getfield 1659	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   192: astore_3
    //   193: aload_3
    //   194: astore 8
    //   196: aload_3
    //   197: astore 9
    //   199: aload_3
    //   200: astore 10
    //   202: aload 11
    //   204: getfield 1662	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   207: invokestatic 640	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   210: ifne +1151 -> 1361
    //   213: aload_3
    //   214: astore 8
    //   216: aload_3
    //   217: astore 9
    //   219: aload 11
    //   221: getfield 1662	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   224: astore 4
    //   226: aload_3
    //   227: astore_2
    //   228: aload 4
    //   230: astore_3
    //   231: aload 7
    //   233: astore 8
    //   235: aload 7
    //   237: astore 9
    //   239: aload_0
    //   240: getfield 313	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   243: bipush 8
    //   245: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   248: checkcast 1664	com/tencent/mobileqq/app/FriendsManagerImp
    //   251: astore 11
    //   253: aload 7
    //   255: astore 8
    //   257: aload 7
    //   259: astore 9
    //   261: aload_0
    //   262: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   265: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   268: getfield 672	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   271: astore 4
    //   273: aload 4
    //   275: astore 10
    //   277: aload 7
    //   279: astore 8
    //   281: aload 7
    //   283: astore 9
    //   285: aload 4
    //   287: invokestatic 640	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   290: ifeq +65 -> 355
    //   293: aload 4
    //   295: astore 10
    //   297: aload 7
    //   299: astore 8
    //   301: aload 7
    //   303: astore 9
    //   305: aload_0
    //   306: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   309: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   312: getfield 678	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   315: invokestatic 640	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   318: ifne +37 -> 355
    //   321: aload 4
    //   323: astore 10
    //   325: aload 11
    //   327: ifnull +28 -> 355
    //   330: aload 7
    //   332: astore 8
    //   334: aload 7
    //   336: astore 9
    //   338: aload 11
    //   340: aload_0
    //   341: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   344: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   347: getfield 678	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   350: invokevirtual 1666	com/tencent/mobileqq/app/FriendsManagerImp:f	(Ljava/lang/String;)Ljava/lang/String;
    //   353: astore 10
    //   355: aload 7
    //   357: astore 4
    //   359: aload 7
    //   361: astore 8
    //   363: aload 7
    //   365: astore 9
    //   367: aload 10
    //   369: invokestatic 640	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   372: ifne +39 -> 411
    //   375: aload 7
    //   377: astore 4
    //   379: aload 11
    //   381: ifnull +30 -> 411
    //   384: aload 7
    //   386: astore 8
    //   388: aload 7
    //   390: astore 9
    //   392: aload 11
    //   394: aload 10
    //   396: aload_0
    //   397: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   400: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   403: getfield 631	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   406: invokevirtual 1668	com/tencent/mobileqq/app/FriendsManagerImp:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   409: astore 4
    //   411: aload 4
    //   413: astore 8
    //   415: aload 4
    //   417: astore 9
    //   419: aload 6
    //   421: invokestatic 640	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   424: ifeq +923 -> 1347
    //   427: aload 4
    //   429: astore 8
    //   431: aload 4
    //   433: astore 9
    //   435: aload_0
    //   436: invokevirtual 1671	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	()Lcom/tencent/mobileqq/activity/ProfileActivity$CardContactInfo;
    //   439: astore 7
    //   441: aload 7
    //   443: ifnull +904 -> 1347
    //   446: aload 4
    //   448: astore 8
    //   450: aload 4
    //   452: astore 9
    //   454: aload 7
    //   456: getfield 1672	com/tencent/mobileqq/activity/ProfileActivity$CardContactInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   459: astore 7
    //   461: aload 7
    //   463: astore 6
    //   465: aload_0
    //   466: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   469: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   472: invokestatic 1674	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:j	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   475: ifeq +866 -> 1341
    //   478: aload 5
    //   480: invokestatic 640	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   483: ifeq +858 -> 1341
    //   486: aload_0
    //   487: getfield 313	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   490: bipush 34
    //   492: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   495: checkcast 1676	com/tencent/mobileqq/app/CircleManager
    //   498: astore 7
    //   500: aload 7
    //   502: ifnull +839 -> 1341
    //   505: aload 7
    //   507: aload_0
    //   508: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   511: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   514: getfield 631	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   517: invokevirtual 1679	com/tencent/mobileqq/app/CircleManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/CircleBuddy;
    //   520: astore 9
    //   522: aload 9
    //   524: ifnull +817 -> 1341
    //   527: aload 9
    //   529: getfield 1682	com/tencent/mobileqq/data/CircleBuddy:remark	Ljava/lang/String;
    //   532: astore 7
    //   534: aload 7
    //   536: astore 5
    //   538: aload_2
    //   539: astore 8
    //   541: aload 9
    //   543: getfield 1683	com/tencent/mobileqq/data/CircleBuddy:nickName	Ljava/lang/String;
    //   546: invokestatic 640	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   549: ifne +14 -> 563
    //   552: aload 9
    //   554: getfield 1683	com/tencent/mobileqq/data/CircleBuddy:nickName	Ljava/lang/String;
    //   557: astore 8
    //   559: aload 7
    //   561: astore 5
    //   563: aload_3
    //   564: astore 9
    //   566: aload 4
    //   568: astore 10
    //   570: aload 5
    //   572: astore 11
    //   574: aload 6
    //   576: astore 12
    //   578: aload_0
    //   579: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   582: bipush 7
    //   584: anewarray 644	java/lang/String
    //   587: putfield 272	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   590: aload_0
    //   591: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   594: getfield 272	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   597: iconst_0
    //   598: aload 8
    //   600: aastore
    //   601: aload_0
    //   602: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   605: getfield 272	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   608: iconst_4
    //   609: aload 9
    //   611: aastore
    //   612: aload_0
    //   613: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   616: getfield 272	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   619: iconst_3
    //   620: aload 12
    //   622: aastore
    //   623: aload_0
    //   624: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   627: getfield 272	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   630: iconst_2
    //   631: aload 11
    //   633: aastore
    //   634: aload_0
    //   635: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   638: getfield 272	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   641: iconst_5
    //   642: aload 13
    //   644: aastore
    //   645: aload_0
    //   646: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   649: getfield 272	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   652: iconst_1
    //   653: aload 10
    //   655: aastore
    //   656: aload_0
    //   657: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   660: getfield 272	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   663: bipush 6
    //   665: aload 14
    //   667: aastore
    //   668: invokestatic 283	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   671: ifeq +128 -> 799
    //   674: new 287	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   681: astore_2
    //   682: aload_2
    //   683: ldc_w 1685
    //   686: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: ldc_w 1107
    //   692: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: aload 8
    //   697: invokestatic 1110	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   700: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: ldc_w 1112
    //   706: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: aload 9
    //   711: invokestatic 1110	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   714: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: ldc_w 1114
    //   720: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: aload 12
    //   725: invokestatic 1110	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   728: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: ldc_w 1116
    //   734: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: aload 11
    //   739: invokestatic 1110	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   742: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: ldc_w 1118
    //   748: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: aload 13
    //   753: invokestatic 1110	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   756: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: ldc_w 1120
    //   762: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: aload 10
    //   767: invokestatic 1110	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   770: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: ldc_w 1122
    //   776: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: aload 13
    //   781: invokestatic 1110	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   784: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: ldc_w 285
    //   791: iconst_2
    //   792: aload_2
    //   793: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   796: invokestatic 666	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   799: return
    //   800: aload 4
    //   802: astore 8
    //   804: aload 4
    //   806: astore 9
    //   808: aload_3
    //   809: aload_0
    //   810: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   813: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   816: getfield 631	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   819: invokeinterface 1002 2 0
    //   824: astore 11
    //   826: goto -678 -> 148
    //   829: aload 4
    //   831: astore 8
    //   833: aload 4
    //   835: astore 9
    //   837: aload_0
    //   838: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   841: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   844: getfield 270	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   847: ifne +38 -> 885
    //   850: aload 4
    //   852: astore 8
    //   854: aload 4
    //   856: astore 9
    //   858: aload_0
    //   859: getfield 313	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   862: aload_0
    //   863: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   866: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   869: getfield 631	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   872: invokestatic 717	com/tencent/mobileqq/utils/ContactUtils:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   875: astore 4
    //   877: aload_2
    //   878: astore_3
    //   879: aload 4
    //   881: astore_2
    //   882: goto -651 -> 231
    //   885: aload 4
    //   887: astore 8
    //   889: aload 4
    //   891: astore 9
    //   893: aload 4
    //   895: astore_3
    //   896: aload 4
    //   898: invokestatic 640	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   901: ifeq +449 -> 1350
    //   904: aload 4
    //   906: astore 8
    //   908: aload 4
    //   910: astore 9
    //   912: aload 4
    //   914: astore_3
    //   915: aload_0
    //   916: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   919: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   922: invokestatic 1138	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:f	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   925: ifeq +425 -> 1350
    //   928: aload 4
    //   930: astore 8
    //   932: aload 4
    //   934: astore 9
    //   936: aload_0
    //   937: getfield 313	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   940: aload_0
    //   941: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   944: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   947: getfield 631	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   950: iconst_0
    //   951: invokestatic 1688	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   954: astore_3
    //   955: aload_3
    //   956: astore 8
    //   958: aload_3
    //   959: astore 9
    //   961: aload_3
    //   962: aload_0
    //   963: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   966: getfield 266	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   969: getfield 631	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   972: invokestatic 1086	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   975: istore_1
    //   976: iload_1
    //   977: ifeq +373 -> 1350
    //   980: aconst_null
    //   981: astore 4
    //   983: aload_2
    //   984: astore_3
    //   985: aload 4
    //   987: astore_2
    //   988: goto -757 -> 231
    //   991: astore 4
    //   993: aload 6
    //   995: astore 9
    //   997: aload 5
    //   999: astore_3
    //   1000: aload 8
    //   1002: astore 6
    //   1004: aload 7
    //   1006: astore 8
    //   1008: aload 4
    //   1010: astore 7
    //   1012: aload_2
    //   1013: astore 5
    //   1015: aload 8
    //   1017: astore 4
    //   1019: aload 9
    //   1021: astore_2
    //   1022: aload_2
    //   1023: astore 12
    //   1025: aload_3
    //   1026: astore 11
    //   1028: aload 4
    //   1030: astore 10
    //   1032: aload 5
    //   1034: astore 9
    //   1036: aload 6
    //   1038: astore 8
    //   1040: invokestatic 283	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1043: ifeq -465 -> 578
    //   1046: ldc_w 285
    //   1049: iconst_2
    //   1050: aload 7
    //   1052: invokevirtual 664	java/lang/Exception:toString	()Ljava/lang/String;
    //   1055: invokestatic 666	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1058: aload_2
    //   1059: astore 12
    //   1061: aload_3
    //   1062: astore 11
    //   1064: aload 4
    //   1066: astore 10
    //   1068: aload 5
    //   1070: astore 9
    //   1072: aload 6
    //   1074: astore 8
    //   1076: goto -498 -> 578
    //   1079: astore 4
    //   1081: aload 6
    //   1083: astore 8
    //   1085: aload 5
    //   1087: astore_3
    //   1088: aload 9
    //   1090: astore 6
    //   1092: aload 7
    //   1094: astore 9
    //   1096: aload 4
    //   1098: astore 7
    //   1100: aload_2
    //   1101: astore 5
    //   1103: aload 9
    //   1105: astore 4
    //   1107: aload 8
    //   1109: astore_2
    //   1110: aload_2
    //   1111: astore 12
    //   1113: aload_3
    //   1114: astore 11
    //   1116: aload 4
    //   1118: astore 10
    //   1120: aload 5
    //   1122: astore 9
    //   1124: aload 6
    //   1126: astore 8
    //   1128: invokestatic 283	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1131: ifeq -553 -> 578
    //   1134: ldc_w 285
    //   1137: iconst_2
    //   1138: aload 7
    //   1140: invokevirtual 1689	java/lang/Error:toString	()Ljava/lang/String;
    //   1143: invokestatic 666	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1146: aload_2
    //   1147: astore 12
    //   1149: aload_3
    //   1150: astore 11
    //   1152: aload 4
    //   1154: astore 10
    //   1156: aload 5
    //   1158: astore 9
    //   1160: aload 6
    //   1162: astore 8
    //   1164: goto -586 -> 578
    //   1167: astore 10
    //   1169: aload 8
    //   1171: astore 4
    //   1173: aload_2
    //   1174: astore 7
    //   1176: aload 5
    //   1178: astore 9
    //   1180: aload_3
    //   1181: astore 5
    //   1183: aload 10
    //   1185: astore 8
    //   1187: aload 6
    //   1189: astore_2
    //   1190: aload 9
    //   1192: astore_3
    //   1193: aload 7
    //   1195: astore 6
    //   1197: aload 8
    //   1199: astore 7
    //   1201: goto -91 -> 1110
    //   1204: astore 8
    //   1206: aload 6
    //   1208: astore 7
    //   1210: aload_2
    //   1211: astore 6
    //   1213: aload 5
    //   1215: astore 9
    //   1217: aload_3
    //   1218: astore 5
    //   1220: aload 7
    //   1222: astore_2
    //   1223: aload 9
    //   1225: astore_3
    //   1226: aload 8
    //   1228: astore 7
    //   1230: goto -120 -> 1110
    //   1233: astore 8
    //   1235: aload_3
    //   1236: astore 5
    //   1238: aload 6
    //   1240: astore_3
    //   1241: aload_2
    //   1242: astore 6
    //   1244: aload_3
    //   1245: astore_2
    //   1246: aload 7
    //   1248: astore_3
    //   1249: aload 8
    //   1251: astore 7
    //   1253: goto -143 -> 1110
    //   1256: astore 8
    //   1258: aload 9
    //   1260: astore 4
    //   1262: aload_2
    //   1263: astore 7
    //   1265: aload 5
    //   1267: astore 9
    //   1269: aload_3
    //   1270: astore 5
    //   1272: aload 6
    //   1274: astore_2
    //   1275: aload 9
    //   1277: astore_3
    //   1278: aload 7
    //   1280: astore 6
    //   1282: aload 8
    //   1284: astore 7
    //   1286: goto -264 -> 1022
    //   1289: astore 8
    //   1291: aload 6
    //   1293: astore 7
    //   1295: aload_2
    //   1296: astore 6
    //   1298: aload 5
    //   1300: astore 9
    //   1302: aload_3
    //   1303: astore 5
    //   1305: aload 7
    //   1307: astore_2
    //   1308: aload 9
    //   1310: astore_3
    //   1311: aload 8
    //   1313: astore 7
    //   1315: goto -293 -> 1022
    //   1318: astore 8
    //   1320: aload_3
    //   1321: astore 5
    //   1323: aload 6
    //   1325: astore_3
    //   1326: aload_2
    //   1327: astore 6
    //   1329: aload_3
    //   1330: astore_2
    //   1331: aload 7
    //   1333: astore_3
    //   1334: aload 8
    //   1336: astore 7
    //   1338: goto -316 -> 1022
    //   1341: aload_2
    //   1342: astore 8
    //   1344: goto -781 -> 563
    //   1347: goto -882 -> 465
    //   1350: aload_2
    //   1351: astore 4
    //   1353: aload_3
    //   1354: astore_2
    //   1355: aload 4
    //   1357: astore_3
    //   1358: goto -1127 -> 231
    //   1361: aload_2
    //   1362: astore_3
    //   1363: aload 10
    //   1365: astore_2
    //   1366: goto -1135 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1369	0	this	FriendProfileCardActivity
    //   975	2	1	bool	boolean
    //   41	1325	2	localObject1	Object
    //   143	1220	3	localObject2	Object
    //   29	957	4	localObject3	Object
    //   991	18	4	localException1	Exception
    //   1017	48	4	localObject4	Object
    //   1079	18	4	localError1	java.lang.Error
    //   1105	251	4	localObject5	Object
    //   76	1246	5	localObject6	Object
    //   88	1240	6	localObject7	Object
    //   52	1285	7	localObject8	Object
    //   104	1094	8	localObject9	Object
    //   1204	23	8	localError2	java.lang.Error
    //   1233	17	8	localError3	java.lang.Error
    //   1256	27	8	localException2	Exception
    //   1289	23	8	localException3	Exception
    //   1318	17	8	localException4	Exception
    //   1342	1	8	localObject10	Object
    //   108	1201	9	localObject11	Object
    //   150	1005	10	localObject12	Object
    //   1167	197	10	localError4	java.lang.Error
    //   1	1150	11	localObject13	Object
    //   576	572	12	localObject14	Object
    //   64	716	13	str1	String
    //   100	566	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   110	123	991	java/lang/Exception
    //   131	144	991	java/lang/Exception
    //   168	179	991	java/lang/Exception
    //   187	193	991	java/lang/Exception
    //   202	213	991	java/lang/Exception
    //   219	226	991	java/lang/Exception
    //   808	826	991	java/lang/Exception
    //   837	850	991	java/lang/Exception
    //   858	877	991	java/lang/Exception
    //   896	904	991	java/lang/Exception
    //   915	928	991	java/lang/Exception
    //   936	955	991	java/lang/Exception
    //   961	976	991	java/lang/Exception
    //   110	123	1079	java/lang/Error
    //   131	144	1079	java/lang/Error
    //   168	179	1079	java/lang/Error
    //   187	193	1079	java/lang/Error
    //   202	213	1079	java/lang/Error
    //   219	226	1079	java/lang/Error
    //   808	826	1079	java/lang/Error
    //   837	850	1079	java/lang/Error
    //   858	877	1079	java/lang/Error
    //   896	904	1079	java/lang/Error
    //   915	928	1079	java/lang/Error
    //   936	955	1079	java/lang/Error
    //   961	976	1079	java/lang/Error
    //   239	253	1167	java/lang/Error
    //   261	273	1167	java/lang/Error
    //   285	293	1167	java/lang/Error
    //   305	321	1167	java/lang/Error
    //   338	355	1167	java/lang/Error
    //   367	375	1167	java/lang/Error
    //   392	411	1167	java/lang/Error
    //   419	427	1167	java/lang/Error
    //   435	441	1167	java/lang/Error
    //   454	461	1167	java/lang/Error
    //   465	500	1204	java/lang/Error
    //   505	522	1204	java/lang/Error
    //   527	534	1204	java/lang/Error
    //   541	559	1233	java/lang/Error
    //   239	253	1256	java/lang/Exception
    //   261	273	1256	java/lang/Exception
    //   285	293	1256	java/lang/Exception
    //   305	321	1256	java/lang/Exception
    //   338	355	1256	java/lang/Exception
    //   367	375	1256	java/lang/Exception
    //   392	411	1256	java/lang/Exception
    //   419	427	1256	java/lang/Exception
    //   435	441	1256	java/lang/Exception
    //   454	461	1256	java/lang/Exception
    //   465	500	1289	java/lang/Exception
    //   505	522	1289	java/lang/Exception
    //   527	534	1289	java/lang/Exception
    //   541	559	1318	java/lang/Exception
  }
  
  protected ProfileActivity.CardContactInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    return localObject1;
  }
  
  public Card a(String paramString1, String paramString2)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(49);
    paramString2 = localFriendsManager.a(paramString2);
    if (paramString2 != null)
    {
      paramString1 = localFriendsManager.b(paramString1);
      paramString1.strContactName = paramString2.strContactName;
      paramString1.strMobile = paramString2.mobileNo;
      paramString1.age = paramString2.bAge;
      paramString1.shAge = ((short)paramString2.bAge);
      paramString1.shGender = ((short)paramString2.bSex);
      paramString1.strProvince = paramString2.strProvince;
      paramString1.strCity = paramString2.strCity;
      paramString1.strCountry = paramString2.strCountry;
      localFriendsManager.a(paramString1);
      return paramString1;
    }
    return null;
  }
  
  public String a()
  {
    Object localObject1 = a();
    if (localObject1 != null) {}
    for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).jdField_b_of_type_JavaLangString + ((ProfileActivity.CardContactInfo)localObject1).jdField_c_of_type_JavaLangString;; localObject1 = "")
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      return localObject2;
    }
  }
  
  public void a()
  {
    if (this.f) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "init");
    }
    this.f = true;
    Message localMessage = null;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) {}
    for (;;)
    {
      if ((localMessage != null) && (this.jdField_b_of_type_AndroidOsHandler != null)) {
        this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 71) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 71)) {
        break;
      }
      ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Network_circle_prof", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int), "", "");
      return;
      if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localMessage = Message.obtain();
        localMessage.what = 5;
        localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      else
      {
        localMessage = Message.obtain();
        localMessage.what = 6;
        localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
    ReportController.b(this.app, "CliOper", "", "", "P_prof", "Prof_in_client", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int), "", "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    q();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369057);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    ProfileCardUtil.a(this.app, paramLong1, paramLong2);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, this.jdField_i_of_type_Int);
  }
  
  public void a(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.jdField_c_of_type_JavaLangString;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label152;
      }
      Intent localIntent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramCardContactInfo));
      if ((!MobileIssueSettings.jdField_a_of_type_Boolean) && (KapalaiAdapterUtil.a().a())) {
        KapalaiAdapterUtil.a().a(localIntent);
      }
      startActivity(localIntent);
      this.app.a().b(paramCardContactInfo);
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "call", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = null;
      break;
      label152:
      a(2131368235, 1);
    }
  }
  
  public void a(Card paramCard)
  {
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.a())))
    {
      localObject1 = new Intent(this, VisitorsActivity.class);
      localObject2 = new Bundle();
      if (paramCard == null)
      {
        j = 0;
        ((Bundle)localObject2).putLong("toUin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue());
        ((Bundle)localObject2).putLong("totalVoters", j);
        ((Bundle)localObject2).putBoolean("isStartedByProfileCard", true);
        ((Bundle)localObject2).putBoolean("votersOnly", true);
        if (j <= 0) {
          break label222;
        }
      }
      label222:
      for (boolean bool = true;; bool = false)
      {
        ((Bundle)localObject2).putBoolean("hasVoters", bool);
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        startActivity((Intent)localObject1);
        ((FriendsManager)this.app.getManager(49)).c(this.app.a());
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
        {
          paramCard = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
          if ((paramCard instanceof VoteView)) {
            ((VoteView)paramCard).a(true, false, j, 0, null);
          }
        }
        return;
        j = (int)paramCard.lVoteCount;
        break;
      }
    }
    Object localObject1 = new HashMap();
    Object localObject2 = this.app.a();
    CardHandler localCardHandler = (CardHandler)this.app.a(2);
    if ((localCardHandler != null) && (NetworkUtil.e(BaseApplication.getContext())))
    {
      long l1 = 0L;
      localObject1 = null;
      j = 65535;
      if (paramCard != null)
      {
        localObject2 = paramCard.vCookies;
        paramCard.lVoteCount += 1L;
        paramCard.bVoted = 1;
        long l2 = paramCard.lVoteCount;
        int k = paramCard.favoriteSource;
        Message localMessage = Message.obtain();
        localMessage.what = 7;
        localMessage.obj = paramCard;
        l1 = l2;
        localObject1 = localObject2;
        j = k;
        if (this.jdField_b_of_type_AndroidOsHandler != null)
        {
          this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
          j = k;
          localObject1 = localObject2;
          l1 = l2;
        }
      }
      localCardHandler.a(Long.valueOf(this.app.a()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue(), (byte[])localObject1, j);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, l1);
      }
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "Prof_good", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
    }
    if (localCardHandler != null)
    {
      ((HashMap)localObject1).put("param_FailCode", "-203");
      StatisticCollector.a(this.app.a()).a((String)localObject2, "profileCardSendFavorite", true, 0L, 0L, (HashMap)localObject1, "", false);
      a(2131368236, 1);
      return;
    }
    ((HashMap)localObject1).put("param_FailCode", "-204");
    StatisticCollector.a(this.app.a()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
    a(2131368258, 1);
  }
  
  public void a(Card paramCard, String paramString)
  {
    Object localObject = null;
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onSwitchedToFriend, uin: " + paramString + ", card = " + paramCard);
    }
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_qzonecover"))) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramString, 1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) {
        ((ProfileBaseView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).b();
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = paramString;
      a(true);
      if (paramCard == null) {
        break label301;
      }
      l = paramCard.feedPreviewTime;
      paramString = paramCard.vSeed;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
      a(paramCard, false);
    }
    for (paramCard = paramString;; paramCard = null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56)
      {
        paramString = localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57) {}
      }
      else
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
      }
      a(l, paramCard, paramString);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_qzonecover"))) {
        break;
      }
      ProfileHeaderView localProfileHeaderView = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
      String str = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        j = 1;
      }
      localProfileHeaderView.a(str, j);
      break;
      label301:
      x();
      l = 0L;
    }
  }
  
  public void a(Card paramCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateInfo Card isNetRet = " + paramBoolean);
    }
    d(null);
    if (a(paramCard, paramBoolean)) {
      A();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(paramCard, paramBoolean);
    t();
    u();
    c();
  }
  
  public void a(ContactCard paramContactCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateInfo ContactCard card = " + paramContactCard + ", isNetRet = " + String.valueOf(paramBoolean));
    }
    if (a(paramContactCard, paramBoolean)) {
      A();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(null, paramBoolean);
    u();
    c();
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0);
    if (((localView instanceof ProfileHeaderView)) && (!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateHeaderView headerView update");
      }
      ((ProfileHeaderView)localView).a(paramProfileCardInfo, paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "updateHeaderView headerView is loading");
    }
    b(paramProfileCardInfo);
  }
  
  public void a(String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject;
    if (ProfileActivity.a(this.jdField_e_of_type_Long, l))
    {
      this.jdField_e_of_type_Long = l;
      String str = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        str = c();
      }
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = String.format("https://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017", new Object[] { str });
      }
      paramString = new Intent(this, MusicGeneQQBrowserActivity.class);
      paramString.putExtra("uin", this.app.a());
      paramString.putExtra("url", (String)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label265;
      }
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", true);
    }
    for (;;)
    {
      localObject = Calendar.getInstance();
      if ((localObject != null) && (QLog.isColorLevel()))
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(((Calendar)localObject).getTime());
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, "musicgene123 startactivity " + (String)localObject);
        }
      }
      startActivity(paramString);
      ReportController.b(this.app, "CliOper", "", "", "0X8004182 ", "0X8004182", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      label265:
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", false);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      String str1 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str1 = "https://gamecenter.qq.com/gamecenter/index/recent_play.html";
      }
      Intent localIntent = new Intent(this, GameCenterActivity.class);
      String str2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      paramString = str2;
      if (TextUtils.isEmpty(str2)) {
        paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
      }
      str2 = "";
      if (this.app != null) {
        str2 = this.app.getSid();
      }
      localIntent.putExtra("url", HtmlOffline.a(str1, "plat=qq&tt=1&_wv=3&qappid=" + AppSetting.jdField_a_of_type_Int + "&osv=" + Build.VERSION.RELEASE + "&sid=" + str2 + "&vuin=" + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString + "&vname=" + paramString + "&bn=" + paramBoolean));
      startActivity(localIntent);
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131230742);
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    int j = 0;
    if (j < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[j] == 16) {}
      for (;;)
      {
        j += 1;
        break;
        if ((paramArrayOfInt[j] >= 0) && (paramArrayOfInt[j] < this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
          localActionSheet.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[j]], 1);
        }
      }
    }
    localActionSheet.a(new ebi(this, localActionSheet));
    try
    {
      if (!isFinishing()) {
        localActionSheet.show();
      }
      return;
    }
    catch (Exception paramArrayOfInt)
    {
      paramArrayOfInt.printStackTrace();
    }
  }
  
  public boolean a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(49);
    Card localCard = localFriendsManager.a(this.app.a());
    if ((localCard != null) && (paramLong >= 0L))
    {
      localCard.lCurrentStyleId = paramLong;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      if (!localFriendsManager.a(localCard))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, "save card in db failed ");
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramView, paramMotionEvent);
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      Object localObject1;
      int j;
      int k;
      int m;
      int n;
      try
      {
        localObject1 = ProfileCardUtil.b(this, paramString);
        localObject2 = new File((String)localObject1);
        if ((!((File)localObject2).isFile()) || (!((File)localObject2).exists())) {
          break label543;
        }
        if (!ProfileCardUtil.b((String)localObject1))
        {
          ((File)localObject2).delete();
          return false;
        }
        str = "profilecard:" + (String)localObject1;
        localObject2 = (Pair)BaseApplicationImpl.a.get(str);
        if ((localObject2 != null) && (((Pair)localObject2).first != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "get background form sImageCache filePath=" + (String)localObject1);
          }
          localObject1 = ((Drawable.ConstantState)((Pair)localObject2).first).newDrawable();
          this.jdField_b_of_type_JavaLangString = paramString;
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject1);
          return true;
        }
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        localResources = this.app.a().getResources();
        BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
        j = ((BitmapFactory.Options)localObject2).outHeight;
        k = ((BitmapFactory.Options)localObject2).outWidth;
        localObject2 = getResources().getDisplayMetrics();
        m = Math.min(SizeMeasure.e(this), ((DisplayMetrics)localObject2).heightPixels);
        n = Math.max(SizeMeasure.e(this), ((DisplayMetrics)localObject2).heightPixels);
        float f1 = m / n;
        m = Math.min(k, (int)(j * f1 + 0.5F));
        n = (int)(m / f1);
        localObject1 = BitmapFactory.decodeFile((String)localObject1, new BitmapFactory.Options());
        if (!QLog.isColorLevel()) {
          break label545;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "background info imageWidth=" + m + ",imageHeight=" + n);
      }
      catch (Exception paramString)
      {
        Object localObject2;
        String str;
        Resources localResources;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground exception and msg=" + paramString.getMessage());
        paramString.printStackTrace();
      }
      if (localObject1 != null)
      {
        j = Utils.a((Bitmap)localObject1);
        localObject1 = new BitmapDrawable(localResources, (Bitmap)localObject1);
        ((BitmapDrawable)localObject1).setTargetDensity(localResources.getDisplayMetrics());
        BaseApplicationImpl.a.put(str, new Pair(((BitmapDrawable)localObject1).getConstantState(), Integer.valueOf(j)));
        this.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "background info url=" + paramString + ",backgroundDrawableSize=" + j);
        break;
        localObject2 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, m, n);
        ((Bitmap)localObject1).recycle();
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "Background size not match screen size, create a new one to resize");
        }
        localObject1 = localObject2;
      }
      else
      {
        label543:
        label545:
        while (localObject1 == null) {
          return false;
        }
        if ((k != m) || (j != n)) {}
      }
    }
    return true;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    String str = paramString;
    if (!paramBoolean) {
      str = paramString + "queue";
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.get(str) == null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(1));
      return true;
    }
    int j = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str)).intValue();
    if (j > 3) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(j + 1));
    return true;
  }
  
  public String b()
  {
    Object localObject = ((FriendsManager)this.app.getManager(49)).a(this.app.a());
    if (localObject == null) {
      return "-1";
    }
    if (((Card)localObject).lCurrentStyleId == ProfileCardTemplate.a)
    {
      localObject = (QZoneCover)this.app.a().createEntityManager().a(QZoneCover.class, this.app.a());
      if (localObject != null) {
        return ((QZoneCover)localObject).type;
      }
    }
    return "-1";
  }
  
  protected void b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.card.modify");
    localIntentFilter.addAction("com.tencent.mobileqq.view.self.album");
    localIntentFilter.setPriority(2147483647);
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
  }
  
  public void b(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.jdField_c_of_type_JavaLangString;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label128;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.SENDTO");
      localIntent.setData(Uri.parse("smsto:" + paramCardContactInfo));
      startActivity(localIntent);
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "send_sms", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = null;
      break;
      label128:
      a(2131368235, 1);
    }
  }
  
  @SuppressLint({"ServiceCast", "NewApi"})
  public void b(String paramString)
  {
    if (paramString != null)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        break label57;
      }
      ((android.text.ClipboardManager)getSystemService("clipboard")).setText(paramString);
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "personal_profile", "copy_uin", 0, 0, "", "", "", "");
      return;
      label57:
      ((android.content.ClipboardManager)getSystemService("clipboard")).setText(paramString);
    }
  }
  
  public boolean b(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) == null)) {
      return false;
    }
    return ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() > 3;
  }
  
  protected void broadcastRecieve(Intent paramIntent)
  {
    paramIntent.setClass(this, PhotoCropForPortraitActivity.class);
    startActivity(paramIntent);
  }
  
  public void c()
  {
    Object localObject = getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    int m = Math.max(SizeMeasure.e(this), localDisplayMetrics.heightPixels) - Utils.a(this, 25.0F);
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null)
    {
      j = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.getHeight();
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
        break label222;
      }
    }
    label222:
    for (int k = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.getHeight();; k = 0)
    {
      int n = ((Resources)localObject).getDimensionPixelSize(2131493124);
      int i1 = Math.min(Math.max(m - k - j, n), m / 3);
      localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131300380);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updatePlaceHolder mScreenHeight=" + m + ",moreInfoViewHeight=" + j + ",headerViewHeight=" + k + ",minHeight=" + n + ",placeHolderViewHeight=" + i1);
      }
      if (localObject != null)
      {
        ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, i1));
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {
          break label227;
        }
      }
      return;
      j = 0;
      break;
    }
    label227:
    ((View)localObject).setBackgroundColor(0);
  }
  
  public void c(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo == null)
    {
      paramCardContactInfo = null;
      if ((paramCardContactInfo != null) && (paramCardContactInfo.length() > 0))
      {
        if (!NetworkUtil.e(BaseApplication.getContext())) {
          break label183;
        }
        if (("".equals(paramCardContactInfo)) || (paramCardContactInfo.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString))) {
          break label172;
        }
        FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
        if (localFriendListHandler == null) {
          break label161;
        }
        localFriendListHandler.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramCardContactInfo, false);
        this.bQ |= 0x1;
        c(paramCardContactInfo);
      }
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "Edit_name", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = paramCardContactInfo.jdField_a_of_type_JavaLangString;
      break;
      label161:
      a(2131368252, 1);
      continue;
      label172:
      a(2131368251, 1);
      continue;
      label183:
      a(2131367135, 1);
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString = paramString;
    a(4, paramString);
    paramString = (MQQProfileName)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.clone();
    A();
    switch (paramString.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName))
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      }
    }
  }
  
  public boolean canDrag()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a() >= 2)) {
      return false;
    }
    return super.canDrag();
  }
  
  public void d()
  {
    long l = System.currentTimeMillis();
    if (ProfileActivity.a(this.jdField_e_of_type_Long, l))
    {
      this.jdField_e_of_type_Long = l;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label287;
      }
      localObject = (TicketManager)this.app.getManager(2);
      if (localObject != null) {
        break label71;
      }
      localObject = null;
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label88;
      }
      a(2131368266, 1);
    }
    label71:
    label88:
    do
    {
      return;
      localObject = ((TicketManager)localObject).getStweb(this.app.a());
      break;
      localObject = String.format("https://ptlogin2.qq.com/mlevel?clientuin=%s&clientkey=%s&keyindex=%s&sid=%s&ADTAG=LEVEL.MLEVEL.master_page.fromziliaoka", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localObject, "19", this.app.getSid() });
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQLevelWeb() url = " + (String)localObject);
      }
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.a());
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
      ReportController.b(this.app, "CliOper", "", "", "QQ_rank", "click_qrank_in", 23, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.i("Q.profilecard.FrdProfileCard", 2, "getClientKey() time = " + System.currentTimeMillis());
    return;
    label287:
    Object localObject = String.format("https://m.vip.qq.com/redirect/?go=androidqlevel&qq=%s&sid=%s&aid=mvip.pingtai.mobileqq.androidziliaoka.fromkerentaiQQlevelicon", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.getSid() });
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.app.a());
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("hide_more_button", true);
    startActivity(localIntent);
    ReportController.b(this.app, "CliOper", "", "", "QQ_rank", "click_qrank_in", 24, 0, "", "", "", "");
  }
  
  protected boolean dataEquals(Intent paramIntent)
  {
    paramIntent = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
    return (paramIntent != null) && (paramIntent.jdField_a_of_type_JavaLangString != null) && (paramIntent.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    if (paramInt1 == 5) {
      BaseActivity.sNotShowLockScreen = true;
    }
    Object localObject1;
    if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null))
    {
      if (!paramIntent.hasExtra("result")) {
        break label318;
      }
      localObject1 = paramIntent.getStringExtra("result");
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "onActivityResult, resultStr : " + (String)localObject1);
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    label194:
    label225:
    boolean bool;
    label318:
    label475:
    do
    {
      break label225;
      break label225;
      break label225;
      break label225;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((JSONObject)localObject1).get("payState");
          if ((localObject1 != null) && ("0".equals(String.valueOf(localObject1)))) {
            a(0L, null, null);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("FriendProfileCardActivity", 2, "onActivityResult, JSONException : " + localJSONException.getMessage());
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("FriendProfileCardActivity", 2, "onActivityResult, Exception : " + localException.getMessage());
          }
        }
      }
      if (paramInt1 == 1010) {
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int == 101) && (paramInt2 == -1)) {
          finish();
        }
      }
      for (;;)
      {
        return;
        if (QLog.isColorLevel())
        {
          QLog.e("FriendProfileCardActivity", 2, "onActivityResult, data contain no result key.");
          break label194;
          if (paramInt1 == 881)
          {
            if (paramInt2 != -1) {
              break;
            }
            AvatarPendantUtil.a(this.app, this);
            return;
          }
          if (paramInt1 != 1008) {
            break label678;
          }
          if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
            break label536;
          }
          bool = paramIntent.getExtras().getBoolean("photowall_updated");
          paramIntent = (CoverCacheData)paramIntent.getExtras().getParcelable("current_cover");
          if (((paramInt2 == -1) || (bool)) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a()) {
              break label475;
            }
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramIntent);
          }
          for (;;)
          {
            if (paramIntent == null) {
              break label534;
            }
            localObject2 = Message.obtain();
            ((Message)localObject2).what = 1;
            ((Message)localObject2).obj = paramIntent;
            if (this.jdField_b_of_type_AndroidOsHandler == null) {
              break;
            }
            this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
            return;
            this.g = false;
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = 0L;
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet = 0;
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl = "";
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor = 0L;
            b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
          }
          continue;
        }
        break label194;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
          break;
        }
        try
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a();
          if (localObject2 != null)
          {
            paramIntent = new CoverCacheData();
            paramIntent.local_url = ((CoverCacheData)localObject2).local_url;
            paramIntent.packageInfo = ((CoverCacheData)localObject2).packageInfo;
            paramIntent.photoWall = ((CoverCacheData)localObject2).photoWall;
            paramIntent.type = ((CoverCacheData)localObject2).type;
            paramIntent.uin = ((CoverCacheData)localObject2).uin;
            paramIntent.urls = ((CoverCacheData)localObject2).urls;
            paramIntent.isJigsawOpen = 0;
            paramIntent.isJigsawOpen = 0;
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramIntent);
            localObject2 = Message.obtain();
            ((Message)localObject2).what = 1;
            ((Message)localObject2).obj = paramIntent;
            if (this.jdField_b_of_type_AndroidOsHandler != null)
            {
              this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
              return;
            }
          }
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      }
      if (paramInt1 != 1007) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0);
    label534:
    label536:
    label678:
    Object localObject2 = (FriendsManager)this.app.getManager(49);
    Card localCard;
    if (localObject2 == null)
    {
      localCard = null;
      label720:
      if ((localCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = localCard;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString = localCard.strNick;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0] = localCard.strNick;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4] = "";
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(localCard);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(localCard.getRichStatus());
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("param_switches_changed", false)))
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)) {
            break label941;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
        }
      }
    }
    for (;;)
    {
      a(localCard.feedPreviewTime, localCard.vSeed, (byte[])localObject2);
      setResult(-1, paramIntent);
      return;
      localCard = ((FriendsManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break label720;
      label941:
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 35) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 37) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
        continue;
        if (paramInt2 != -1) {
          break;
        }
      }
      switch (paramInt1)
      {
      default: 
        return;
      case 5: 
        paramIntent = ImageUtil.c(this, this.jdField_a_of_type_AndroidNetUri);
        paramInt1 = Math.min(482, ProfileCardUtil.a(this));
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Business_Origin", 100);
        PhotoUtils.a((Intent)localObject2, this, FriendProfileCardActivity.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.b());
        return;
      case 1012: 
        if (paramIntent == null) {
          break;
        }
        if (paramIntent.getBooleanExtra("finchat", false))
        {
          finish();
          return;
        }
        paramIntent = paramIntent.getStringExtra("remark");
        if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString, paramIntent)) {
          break;
        }
        c(paramIntent);
        return;
      case 1000: 
        setResult(-1);
        finish();
        return;
      case 800: 
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          a(2131367136, 1);
          return;
        }
        if (paramIntent == null) {}
      case 1004: 
        for (bool = paramIntent.getBooleanExtra("avatar_changed", false);; bool = false)
        {
          if (!bool) {
            break label225;
          }
          paramIntent = paramIntent.getStringExtra("avatar_filepath");
          if (ProfileCardUtil.a(this.app, paramIntent))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
              break label225;
            }
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            return;
          }
          a(2131368371, 1);
          return;
          paramIntent = ((FriendsManager)this.app.getManager(49)).a(this.app.a());
          if ((paramIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = paramIntent;
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.m(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
          return;
        }
        localObject2 = null;
      }
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil = new TimeTraceUtil();
    if (QLog.isColorLevel()) {
      this.X = System.currentTimeMillis();
    }
    Intent localIntent = getIntent();
    super.doOnCreate(paramBundle);
    if ((TextUtils.isEmpty(this.app.getAccount())) || (localIntent == null))
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener = this.jdField_a_of_type_AndroidViewView$OnLongClickListener;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)localIntent.getParcelableExtra("AllInOne"));
    if (!a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo))
    {
      finish();
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0"))) {
      this.jdField_i_of_type_Boolean = false;
    }
    label513:
    label523:
    for (;;)
    {
      try
      {
        if (this.app.a().equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 0;
        }
        this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
        b();
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        paramBundle = (StatusManager)this.app.getManager(14);
        if (paramBundle != null) {
          paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 6) && (this.app.a() != null)) {
          this.app.a().addObserver(this);
        }
        long l;
        ReportController.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X8005135", "0X8005135", 0, 0, "", "", "", "");
      }
      catch (Exception paramBundle)
      {
        try
        {
          a(false);
          z();
          x();
          B();
          l = System.currentTimeMillis() - this.X;
          if ((QLog.isColorLevel()) && (l > 100L)) {
            QLog.i("Q.PerfTrace", 2, "FriendProfileCardActivity onCreate used:" + l);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label523;
          }
          ReportController.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X8005134", "0X8005134", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("doOnCreate", false);
          return true;
        }
        catch (Exception paramBundle)
        {
          if (!QLog.isColorLevel()) {
            break label513;
          }
          QLog.e("Q.profilecard.FrdProfileCard", 2, "doOnCreate exception msg=" + paramBundle.toString());
          paramBundle.printStackTrace();
          finish();
          return false;
        }
        paramBundle = paramBundle;
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, "qq_error|" + paramBundle.toString());
        }
        finish();
        return false;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    super.doOnDestroy();
    if (this.app != null) {
      this.app.a(getClass());
    }
    if (this.jdField_a_of_type_Boolean) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    Object localObject = (StatusManager)this.app.getManager(14);
    if (localObject != null) {
      ((StatusManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.d();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      int k = this.jdField_a_of_type_AndroidViewViewGroup.getChildCount();
      int j = 0;
      while (j < k)
      {
        localObject = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(j);
        if ((localObject instanceof ProfileHeaderView)) {
          ((ProfileHeaderView)localObject).d();
        }
        j += 1;
      }
    }
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    D();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
      return;
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (paramIntent != null) {
        if (ProfileCardUtil.a(this.app, paramIntent))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          }
        }
        else {
          a(2131368371, 1);
        }
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.c();
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil != null)) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "FriendProfileCardActivity time trace:" + this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.toString());
      }
      StatisticCollector.a(this.app.a()).a(this.app.a(), "profileCardTimeStat", true, 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a(), "", false);
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    v();
    if (this.X > 0L)
    {
      long l = System.currentTimeMillis() - this.X;
      if ((QLog.isColorLevel()) && (l > 500L)) {
        QLog.i("Q.PerfTrace", 2, "FriendProfileCardActivity Ui render used:" + l);
      }
      this.X = 0L;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 6) {
      l();
    }
    addObserver(this.jdField_b_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry = null;
    t();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.f)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public void e()
  {
    long l = System.currentTimeMillis();
    if (ProfileActivity.a(this.jdField_e_of_type_Long, l))
    {
      this.jdField_e_of_type_Long = l;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoXmanWeb() url = " + "https://ti.qq.com/xman/self.html?_wv=1027&adtag=card&_bid=297");
        }
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("uin", this.app.a());
        ((Intent)localObject).putExtra("url", "https://ti.qq.com/xman/self.html?_wv=1027&adtag=card&_bid=297");
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("reqType", 1);
        startActivity((Intent)localObject);
        ReportController.b(this.app, "CliOper", "", "", "0X8004880", "0X8004880", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    Object localObject = String.format("https://ti.qq.com/xman/view.html?_wv=1027&uin=%s&_bid=297", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString });
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("reqType", 1);
    localIntent.putExtra("uin", this.app.a());
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("hide_more_button", true);
    startActivity(localIntent);
    ReportController.b(this.app, "CliOper", "", "", "0X800489C", "0X800489C", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    long l = System.currentTimeMillis();
    if (ProfileActivity.a(this.jdField_e_of_type_Long, l))
    {
      this.jdField_e_of_type_Long = l;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lightalkNick != null))
      {
        String str = Base64Util.encodeToString(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lightalkNick.getBytes(), 0);
        str = String.format("https://ti.qq.com/lightalk/info.html?_wv=1027&uin=%s&nick=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lightalkId, str });
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoLightalkWeb() url = " + str);
        }
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("uin", this.app.a());
        localIntent.putExtra("url", str);
        localIntent.putExtra("hide_more_button", true);
        startActivity(localIntent);
        ReportController.b(this.app, "CliOper", "", "", "0X800510A", "0X800510A", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void g()
  {
    Intent localIntent = new Intent(this, QRDisplayActivity.class);
    String str = this.app.a();
    localIntent.putExtra("title", getString(2131363588));
    localIntent.putExtra("nick", ContactUtils.g(this.app, str));
    localIntent.putExtra("uin", str);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("reportFlag", 1);
    startActivity(localIntent);
  }
  
  public void h()
  {
    int n = 10004;
    int m = 0;
    int j = n;
    int k = m;
    switch (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      k = m;
      j = n;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 33: 
    case 38: 
    case 39: 
    case 40: 
    case 43: 
    case 44: 
    case 45: 
    case 48: 
    case 49: 
    case 53: 
    case 54: 
    case 55: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
    case 70: 
    case 73: 
    case 76: 
      if ((j == 3007) && (!LBSHandler.a(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        if (this.jdField_b_of_type_AndroidAppDialog == null) {
          this.jdField_b_of_type_AndroidAppDialog = LBSHandler.a(this, getString(2131369575), new eas(this), new eat(this));
        }
        if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!this.jdField_b_of_type_AndroidAppDialog.isShowing()) && (!isFinishing())) {
          this.jdField_b_of_type_AndroidAppDialog.show();
        }
      }
      break;
    }
    ProfileActivity.CardContactInfo localCardContactInfo;
    do
    {
      return;
      j = 3004;
      k = m;
      break;
      j = 3007;
      k = m;
      break;
      j = 3001;
      k = m;
      break;
      j = 3020;
      k = m;
      break;
      j = 3017;
      k = m;
      break;
      j = 3002;
      k = m;
      break;
      j = 3005;
      k = m;
      break;
      j = 3007;
      k = m;
      break;
      j = 3003;
      k = m;
      break;
      j = 3008;
      k = m;
      break;
      j = 3008;
      k = m;
      break;
      j = 3009;
      k = m;
      break;
      j = 3006;
      k = m;
      break;
      j = 3009;
      k = 1;
      break;
      j = 3006;
      k = 1;
      break;
      j = 3013;
      k = m;
      break;
      j = 3003;
      k = 1;
      break;
      j = 3014;
      k = m;
      break;
      j = 3003;
      k = 2;
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36)) {
        break label906;
      }
      localCardContactInfo = a();
    } while ((localCardContactInfo == null) || (localCardContactInfo.jdField_c_of_type_JavaLangString == null) || (localCardContactInfo.jdField_c_of_type_JavaLangString.length() <= 0));
    String str = localCardContactInfo.jdField_b_of_type_JavaLangString + localCardContactInfo.jdField_c_of_type_JavaLangString;
    Object localObject2 = localCardContactInfo.jdField_a_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty(localCardContactInfo.jdField_a_of_type_JavaLangString))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3])) {
        break label836;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3];
    }
    for (;;)
    {
      startActivity(AddFriendLogicActivity.a(this, 2, str, null, j, k, (String)localObject1, null, FriendProfileCardActivity.class.getName(), setLastActivityName()));
      return;
      label836:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0]))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      else
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString)) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString;
        }
      }
    }
    label906:
    localObject1 = null;
    localObject2 = localObject1;
    if (3004 == j)
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString != null)
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString.length() != 0) {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString;
        }
      }
    }
    localObject1 = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2];
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1150;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
    }
    label1150:
    for (;;)
    {
      if (getIntent().getStringExtra("param_return_addr") != null)
      {
        startActivity(AddFriendLogicActivity.a(this, 1, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, (String)localObject2, j, k, (String)localObject1, null, AddContactsActivity.class.getName(), setLastActivityName()));
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 77) {
          break;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[5];
        break;
      }
      startActivityForResult(AddFriendLogicActivity.a(this, 1, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, (String)localObject2, j, k, (String)localObject1, null, FriendProfileCardActivity.class.getName(), setLastActivityName()), 1000);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = (FriendsManager)this.app.getManager(49);
    Object localObject1;
    switch (paramMessage.what)
    {
    case 3: 
    case 4: 
    default: 
    case 6: 
    case 5: 
      do
      {
        do
        {
          return true;
          paramMessage = a();
        } while ((localObject2 == null) || (paramMessage == null) || (paramMessage.length() <= 0));
        paramMessage = ((FriendsManager)localObject2).b(paramMessage);
        localObject1 = a();
        if (localObject1 != null)
        {
          paramMessage.nationCode = ((ProfileActivity.CardContactInfo)localObject1).jdField_b_of_type_JavaLangString;
          paramMessage.mobileCode = ((ProfileActivity.CardContactInfo)localObject1).jdField_c_of_type_JavaLangString;
          paramMessage.strContactName = ((ProfileActivity.CardContactInfo)localObject1).jdField_a_of_type_JavaLangString;
        }
        if ((paramMessage.nickName == null) || (paramMessage.nickName.length() == 0)) {
          paramMessage.nickName = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
        }
        ((FriendsManager)localObject2).a(paramMessage);
        a(0L, null, null);
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 4;
        ((Message)localObject1).obj = paramMessage;
        ((Message)localObject1).arg1 = 0;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
        return true;
        paramMessage = (String)paramMessage.obj;
        localObject1 = ProfileCardUtil.a(this.app, paramMessage);
      } while ((localObject1 == null) || (localObject2 == null));
      if ((((FriendsManager)localObject2).b(((Card)localObject1).uin)) && (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.a())) && (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
      }
      paramMessage = Message.obtain();
      paramMessage.what = 4;
      paramMessage.obj = localObject1;
      paramMessage.arg1 = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
      localObject2 = ((Card)localObject1).vSeed;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57)) {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
      }
      break;
    }
    for (;;)
    {
      a(((Card)localObject1).feedPreviewTime, (byte[])localObject2, paramMessage);
      return true;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 35) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 37) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36))
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
        continue;
        localObject2 = (CoverCacheData)paramMessage.obj;
        EntityManager localEntityManager = this.app.a().createEntityManager();
        if (localEntityManager == null)
        {
          paramMessage = null;
          localObject1 = paramMessage;
          if (paramMessage == null)
          {
            localObject1 = new QZoneCover();
            ((QZoneCover)localObject1).uin = Long.toString(((CoverCacheData)localObject2).uin);
          }
          ((QZoneCover)localObject1).updateQzoneCover((CoverCacheData)localObject2);
          if (((QZoneCover)localObject1).getStatus() != 1000) {
            break label529;
          }
          localEntityManager.a((Entity)localObject1);
        }
        for (;;)
        {
          localEntityManager.a();
          return true;
          paramMessage = (QZoneCover)localEntityManager.a(QZoneCover.class, Long.toString(((CoverCacheData)localObject2).uin));
          break;
          label529:
          localEntityManager.a((Entity)localObject1);
        }
        if ((this.app == null) || (localObject2 == null)) {
          break;
        }
        paramMessage = ((FriendsManager)localObject2).a(this.app.a());
        if (paramMessage == null) {
          break;
        }
        a(paramMessage.feedPreviewTime, paramMessage.vSeed, null);
        return true;
        localObject1 = this.app.a().createEntityManager();
        ((EntityManager)localObject1).a((Card)paramMessage.obj);
        ((EntityManager)localObject1).a();
        return true;
        localObject1 = this.app.a().createEntityManager();
        ((EntityManager)localObject1).a((Card)paramMessage.obj);
        ((EntityManager)localObject1).a();
        return true;
      }
      paramMessage = null;
    }
  }
  
  public void i()
  {
    ThreadPriorityManager.a(true);
    int j = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString.length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("finchat", true);
      setResult(0, (Intent)localObject);
      finish();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
      localObject = a();
    }
    for (;;)
    {
      a((String)localObject, j);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3) {
        ReportController.b(this.app, "CliOper", "", "", "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
      } else if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int == 102) {
        ReportController.b(this.app, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_RandomConversation", 0, 0, "", "", "", "");
      } else if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int == 103) {
        ReportController.b(this.app, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_superConversation", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void j()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.app.a();
    String str2 = this.app.c();
    String str1 = str2;
    if (StringUtil.b(str2)) {
      str1 = this.app.c();
    }
    localUserInfo.jdField_b_of_type_JavaLangString = str1;
    localUserInfo.jdField_c_of_type_JavaLangString = this.app.getSid();
    QZoneHelper.a(this, localUserInfo, Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)), 1, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int, -1);
  }
  
  public void k()
  {
    int k = 0;
    Object localObject = (FriendManager)this.app.getManager(8);
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label146;
      }
      localObject = new Card();
    }
    label146:
    for (int j = 1;; j = 0)
    {
      ((Card)localObject).feedPreviewTime = System.currentTimeMillis();
      ((Card)localObject).strQzoneFeedsDesc = "";
      Message localMessage = Message.obtain();
      localMessage.obj = localObject;
      if (j != 0) {}
      for (localMessage.what = 8;; localMessage.what = 7)
      {
        if (this.jdField_b_of_type_AndroidOsHandler != null) {
          this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
        }
        j = k;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
          j = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g;
        }
        c(j);
        return;
        localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
      }
    }
  }
  
  public void l() {}
  
  public void m()
  {
    QQAppInterface localQQAppInterface = this.app;
    if ((ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)) {}
    for (String str = "listen_frd";; str = "listen_str")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Voice_profile", str, ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
    }
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheQuality(524288);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(8);
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.getDrawingCache();
      this.jdField_a_of_type_AndroidViewView.findViewById(2131300380).setVisibility(8);
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  public void o()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.destroyDrawingCache();
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131300380).setVisibility(0);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onPostThemeChanged()
  {
    if (ThemeUtil.isInNightMode(this.app)) {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    long l;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      localObject = (FriendsManager)this.app.getManager(49);
      if (!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label297;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
        break label315;
      }
      l = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
      label104:
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
        break label320;
      }
    }
    label297:
    label315:
    label320:
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl;; localObject = "")
    {
      if ((this.jdField_b_of_type_Long != l) || ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(this.jdField_b_of_type_JavaLangString))))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "onRestart  initContentView current templateId= " + this.jdField_b_of_type_Long + ", new templateId = " + l);
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        this.g = false;
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initContentViewStart", true);
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "initContentView add timeout msg");
          }
          localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 10000L);
        }
        if (this.jdField_a_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_JavaUtilHashMap.clear();
        }
        this.jdField_e_of_type_Int = 0;
        a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard = ((FriendsManager)localObject).a(a());
      break;
      l = 0L;
      break label104;
    }
  }
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.b(33);
  }
  
  /* Error */
  public void q()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1788	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   4: ifnull +25 -> 29
    //   7: aload_0
    //   8: getfield 1788	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   11: invokevirtual 2793	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   14: ifeq +15 -> 29
    //   17: aload_0
    //   18: getfield 1788	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   21: invokevirtual 2794	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 1788	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 1788	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 1788	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	FriendProfileCardActivity
    //   30	1	1	localException	Exception
    //   37	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	30	java/lang/Exception
    //   17	24	37	finally
  }
  
  public void r()
  {
    s();
    String str1;
    if (this.jdField_d_of_type_Int == 1) {
      str1 = getString(2131369033);
    }
    for (String str2 = "成为会员之后，即可使用该名片";; str2 = "成为超级会员之后，即可使用该名片")
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, str1, str2, 2131369041, 2131369042, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      str1 = getString(2131369031);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord)) {
      runOnUiThread(new eav(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */