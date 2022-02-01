package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.adapter.FriendProfileImageAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import ebt;
import ebu;
import ebv;
import ebw;
import ebx;
import eby;
import eca;
import ecb;
import ecc;
import ecd;
import ece;
import ecf;
import ech;
import eci;
import ecj;
import eck;
import java.io.File;

public class FriendProfileImageActivity
  extends BaseActivity
  implements View.OnClickListener, FriendProfileImageModel.InfoUpdateListener, Runnable
{
  public static final String a = "curType";
  private static final long jdField_b_of_type_Long = 300L;
  public static final String b = "url";
  public static final String c = "_id";
  public static final String d = "friendUin";
  public static final String e = "requestTypeKey";
  public static final String f = "faceid";
  public static final String g = "index";
  public static final String h = "KEY_THUMBNAL_BOUND";
  public static final String i = "extra_pendant_id";
  public static final String j = "extra_action_source";
  public static final String k = "is_from_face2face_add_friend";
  public int a;
  long jdField_a_of_type_Long;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  AsyncTask jdField_a_of_type_AndroidOsAsyncTask;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new eby(this);
  public View a;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageButton a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public FriendProfileImageModel a;
  public FriendProfileImageAdapter a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public Gallery a;
  Runnable jdField_a_of_type_JavaLangRunnable = new ebv(this);
  public boolean a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  public AlphaAnimation b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public RelativeLayout b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  public RelativeLayout c;
  public boolean c;
  private int d;
  public boolean d;
  private boolean e;
  private boolean f = false;
  
  public FriendProfileImageActivity()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_d_of_type_Boolean = false;
  }
  
  private String a(String paramString1, String paramString2)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString1 != null)
    {
      int m = paramString1.lastIndexOf("/");
      str1 = str2;
      if (m >= 0)
      {
        str1 = str2;
        if (m < paramString1.length() - 1) {
          str1 = AppConstants.aK + paramString2 + paramString1.substring(m + 1);
        }
      }
    }
    return str1;
  }
  
  private void a(Rect paramRect1, Rect paramRect2)
  {
    this.jdField_d_of_type_Boolean = true;
    View localView = getActivity().findViewById(16908290);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    int i3;
    int i1;
    int i2;
    int m;
    int n;
    float f2;
    if ((paramRect2 != null) && (paramRect1 != null))
    {
      this.jdField_a_of_type_AndroidGraphicsRect = paramRect1;
      paramRect1.width();
      paramRect1.height();
      i3 = paramRect2.width();
      int i4 = paramRect2.height();
      i1 = localView.getWidth();
      i2 = localView.getHeight();
      if (i3 <= i1)
      {
        m = i4;
        n = i3;
        if (i4 <= i2) {}
      }
      else
      {
        float f1 = i1 / i3;
        f2 = i2 / i4;
        if (f1 >= f2) {
          break label240;
        }
        m = Math.round(i4 * f1);
        n = i1;
      }
    }
    for (;;)
    {
      AnimationUtils.a(n, m, i1, i2);
      this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Void[0]);
      this.jdField_d_of_type_Boolean = false;
      if (!this.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(new ebw(this), this.jdField_c_of_type_Long);
      paramRect1 = new AlphaAnimation(0.0F, 1.0F);
      paramRect1.setInterpolator(new DecelerateInterpolator());
      paramRect1.setDuration(this.jdField_c_of_type_Long);
      paramRect1.setFillAfter(true);
      this.jdField_b_of_type_AndroidViewView.startAnimation(paramRect1);
      return;
      label240:
      n = Math.round(i3 * f2);
      m = i2;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, ForwardHandlerActivity.class);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new eck(this, paramTextView));
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new ebu(this, paramTextView));
  }
  
  private void h()
  {
    if (isFinishing()) {}
    FriendProfileImageModel.ProfileImageInfo localProfileImageInfo;
    do
    {
      return;
      localProfileImageInfo = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
    } while ((localProfileImageInfo == null) || (localProfileImageInfo.h != 6));
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131368326, 1);
    localActionSheet.a(2131368331, 1);
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
      localActionSheet.a(2131368337, 3);
    }
    localActionSheet.e(2131365736);
    localActionSheet.a(new ech(this, localProfileImageInfo, localActionSheet));
    localActionSheet.show();
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131366673);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if (paramProfileImageInfo != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putString("forward_filepath", paramProfileImageInfo.d);
      localBundle.putString("forward_thumb", paramProfileImageInfo.c);
      paramProfileImageInfo = new Intent(this, ForwardRecentActivity.class);
      paramProfileImageInfo.putExtras(localBundle);
      startActivityForResult(paramProfileImageInfo, 21);
    }
  }
  
  public void a(AdapterView paramAdapterView, int paramInt)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      if (paramAdapterView.b() <= 1) {
        break label159;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + 1 + "/" + paramAdapterView.b());
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 4) {
        break label124;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      if (this.e)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        this.e = false;
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    return;
    label124:
    this.jdField_a_of_type_AndroidWidgetTextView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    return;
    label159:
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void a(String paramString1, String paramString2)
  {
    new File(AppConstants.aK).mkdirs();
    paramString2 = a(paramString1, paramString2);
    if (!new File(paramString2).exists()) {
      b(paramString1, paramString2);
    }
    for (;;)
    {
      sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + paramString2)));
      return;
      DialogUtil.a(this, 230).setTitle(getString(2131367116)).setMessage(getString(2131367118)).setPositiveButton(getString(2131367117), new ecj(this, paramString1, paramString2)).setNegativeButton(getString(2131365733), new eci(this)).show();
    }
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if (!NetworkUtil.e(this)) {
      QQToast.a(this, getString(2131367122), 0).a();
    }
    Card localCard;
    do
    {
      return;
      localCard = ((FriendManager)this.app.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b);
    } while (localCard == null);
    ((CardHandler)this.app.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b, localCard.uFaceTimeStamp, HexUtil.a(paramProfileImageInfo.jdField_a_of_type_JavaLangString));
    a();
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (FileUtils.c(paramString1, paramString2))
    {
      QQToast.a(this, getString(2131367112) + " " + AppConstants.aK, 0).a();
      return;
    }
    QQToast.a(this, getString(2131367113), 0).a();
  }
  
  public void c()
  {
    if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentWidgetGallery.a(false)))
    {
      d();
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void c(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if ((this.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_AndroidViewView == null) || (paramProfileImageInfo == null)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.PhotoWall", 2, "updateCurrentImage uin=" + paramProfileImageInfo.e + ", state=" + paramProfileImageInfo.h);
            }
            localObject = (String)this.jdField_a_of_type_AndroidViewView.getTag();
            if (paramProfileImageInfo.h != 6) {
              break;
            }
          } while ((localObject != null) && (((String)localObject).equals(paramProfileImageInfo.d)));
          this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.c(paramProfileImageInfo, this.jdField_a_of_type_AndroidViewView);
          return;
          if ((paramProfileImageInfo.h != 3) && (paramProfileImageInfo.h != 4)) {
            break;
          }
          if ((localObject == null) || (!((String)localObject).equals(paramProfileImageInfo.c))) {
            this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.b(paramProfileImageInfo, this.jdField_a_of_type_AndroidViewView);
          }
        } while ((!paramProfileImageInfo.jdField_a_of_type_Boolean) || (paramProfileImageInfo.h != 4));
        Object localObject = (ImageProgressCircle)this.jdField_a_of_type_AndroidViewView.findViewById(2131296299);
        if (localObject != null)
        {
          ((ImageProgressCircle)localObject).setProgress(paramProfileImageInfo.i);
          if (((ImageProgressCircle)localObject).getVisibility() != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a((ImageProgressCircle)localObject);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.PhotoWall", 2, "progressCircle = " + paramProfileImageInfo.i);
      return;
    } while ((paramProfileImageInfo.h != 5) && (paramProfileImageInfo.h != 2));
    this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a(paramProfileImageInfo, this.jdField_a_of_type_AndroidViewView);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(350L);
    localAlphaAnimation.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 2.0F, 1.0F, 2.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setDuration(350L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new ebx(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
  }
  
  public void d(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    c(paramProfileImageInfo);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void doOnBackPressed()
  {
    c();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    try
    {
      paramBundle = getWindow();
      paramBundle.addFlags(1024);
      if (Build.VERSION.SDK_INT >= 14) {
        paramBundle.getAttributes().systemUiVisibility = 1;
      }
      label34:
      getWindow().setBackgroundDrawableResource(2131427375);
      setContentView(2130903346);
      paramBundle = getIntent().getExtras();
      this.jdField_c_of_type_Boolean = paramBundle.getBoolean("is_from_face2face_add_friend", false);
      this.jdField_d_of_type_Int = paramBundle.getInt("curType", 0);
      this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131297712));
      this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296554));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296742));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131296573);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131297793));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297796));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297797));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131296568));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297795));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297800));
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new ebt(this));
      this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter = new FriendProfileImageAdapter(this);
      Object localObject;
      if (881 == paramBundle.getInt("requestType"))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel = new FriendProfileImageAvatar(this.app);
        if (this.jdField_d_of_type_Int == 1) {
          this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b = paramBundle.getString("friendUin");
        this.jdField_a_of_type_Long = paramBundle.getLong("extra_pendant_id", 0L);
        if (this.jdField_a_of_type_Long == 0L)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131369182);
          this.jdField_a_of_type_Long = 5L;
        }
        this.jdField_c_of_type_Int = paramBundle.getInt("extra_action_source", 0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b != null)
        {
          localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject).bottomMargin = getResources().getDimensionPixelSize(2131493189);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297798));
          ThreadManager.b(this);
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297799));
          if (((FriendsManagerImp)this.app.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b) != null)
          {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((AvatarPendantManager)this.app.getManager(45)).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 1, PendantInfo.j);
          }
        }
        if (!this.app.a().equals(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b)) {
          break label783;
        }
      }
      label783:
      for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
      {
        this.jdField_b_of_type_Int = paramBundle.getInt("index", -1);
        localObject = new FriendProfileImageModel.ProfileImageInfo();
        ((FriendProfileImageModel.ProfileImageInfo)localObject).e = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b;
        ((FriendProfileImageModel.ProfileImageInfo)localObject).jdField_a_of_type_JavaLangString = paramBundle.getString("filekey");
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this, (FriendProfileImageModel.ProfileImageInfo)localObject);
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b();
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b(this);
        this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel);
        this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter);
        this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b());
        this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131492982));
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new ecc(this));
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new ecd(this));
        a(this.jdField_a_of_type_AndroidWidgetTextView);
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new ece(this));
        this.jdField_a_of_type_AndroidOsAsyncTask = new ecf(this, (FriendProfileImageModel.ProfileImageInfo)localObject);
        return true;
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel = new FriendProfileImagePortraits(this.app);
        break;
      }
    }
    catch (Exception paramBundle)
    {
      break label34;
    }
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this);
    System.gc();
    this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a();
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    this.jdField_a_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(null);
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation != null) {
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(null);
    }
    if (this.jdField_a_of_type_ComTencentWidgetGallery != null) {}
    for (;;)
    {
      int m;
      try
      {
        int n = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
        m = 0;
        if (m < n)
        {
          View localView = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(m);
          if (localView == null) {
            break label152;
          }
          localView = localView.findViewById(2131296300);
          if (!(localView instanceof URLImageView)) {
            break label152;
          }
          ((URLImageView)localView).setImageDrawable(null);
          ((URLImageView)localView).setBackgroundDrawable(null);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label152:
      m += 1;
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      h();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    float f1;
    int m;
    Object localObject2;
    Rect localRect;
    Object localObject3;
    Object localObject1;
    if ((paramBoolean) && (!this.f))
    {
      f1 = getResources().getDisplayMetrics().density;
      m = getResources().getDisplayMetrics().densityDpi;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
      this.f = true;
      localRect = (Rect)getIntent().getExtras().getParcelable("KEY_THUMBNAL_BOUND");
      if (localObject2 == null) {
        break label256;
      }
      localObject3 = ((FriendProfileImageModel.ProfileImageInfo)localObject2).c;
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    }
    for (;;)
    {
      try
      {
        if (((FriendProfileImageModel.ProfileImageInfo)localObject2).h == 6)
        {
          BitmapFactory.decodeFile(((FriendProfileImageModel.ProfileImageInfo)localObject2).d, (BitmapFactory.Options)localObject1);
          n = ImageUtil.a(((BitmapFactory.Options)localObject1).outWidth, 160, m);
          m = ImageUtil.a(((BitmapFactory.Options)localObject1).outHeight, 160, m);
          localObject2 = new Rect(0, 0, n, m);
          localObject3 = ImageUtil.a((Rect)localObject2, (int)getResources().getDimension(2131492955), f1);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = localObject2;
          }
          a(localRect, (Rect)localObject1);
          return;
        }
        BitmapFactory.decodeFile((String)localObject3, (BitmapFactory.Options)localObject1);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("qqBaseActivity", 2, localOutOfMemoryError.toString());
        continue;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("qqBaseActivity", 2, localException.toString());
        continue;
      }
      label256:
      m = 0;
      int n = 0;
    }
  }
  
  public void e()
  {
    this.jdField_b_of_type_Int += 1;
  }
  
  public void e(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    c(paramProfileImageInfo);
    a(2131368341, 1);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "onDeleteSuccess()");
    }
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a() != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.notifyDataSetChanged();
      return;
    }
    finish();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "onDeleteFailed()");
    }
    b();
    this.jdField_a_of_type_ComTencentWidgetGallery.postDelayed(new ecb(this), 50L);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel == null);
    if (!Utils.e())
    {
      Toast.makeText(super.getApplicationContext(), getString(2131367289), 0).show();
      return;
    }
    setResult(-1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b.equals(this.app.a())) {
        break label127;
      }
      ReportController.b(this.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoBigheadClick", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      finish();
      return;
      label127:
      ReportController.b(this.app, "CliOper", "", "", "AvatarClick", "KerenInfoButtonClick", this.jdField_c_of_type_Int, 0, "", "", "", "");
    }
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b == null)) {
      return;
    }
    runOnUiThread(new eca(this, this.app.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity
 * JD-Core Version:    0.7.0.1
 */