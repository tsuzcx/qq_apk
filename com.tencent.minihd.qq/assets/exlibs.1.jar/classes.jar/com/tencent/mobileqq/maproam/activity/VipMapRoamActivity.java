package com.tencent.mobileqq.maproam.activity;

import EncounterSvc.RespEncounterInfo;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter.ViewHolder;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.maproam.Utils;
import com.tencent.mobileqq.maproam.widget.RoamLocalSearchBar;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog.OnRoamResultObserver;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog.OnSearchResultItemClick;
import com.tencent.mobileqq.maproam.widget.RoamingMapView;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQMapView.QQMapViewObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import com.tencent.widget.XListView.MotionEventInterceptor;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import jff;
import jfg;
import jfh;
import jfi;
import jfj;
import jfk;
import jfl;
import jfm;
import jfo;
import jfp;
import jfq;
import jfr;

public class VipMapRoamActivity
  extends LbsBaseActivity
  implements View.OnClickListener, Animation.AnimationListener, FaceDecoder.DecodeTaskCompletionListener, QQMapView.QQMapViewObserver, AbsListView.OnScrollListener, XListView.MotionEventInterceptor
{
  public static final String a = "VipMapRoamActivity";
  public static final int b = 100;
  public static final String b = "Vip_MapRoam";
  public static final int c = 101;
  public static final String c = "lat";
  public static final int d = 200;
  public static final String d = "lon";
  public static final int e = 300;
  public static final int f = 400;
  public static final int g = 0;
  public static final String g = "abp_flag";
  public static final int h = 100500;
  public static final String h = "is_from_web";
  public static final int i = 100501;
  public static int j;
  public static int k = 3000;
  public static final int l = 0;
  public float a;
  public long a;
  public View a;
  public ViewGroup a;
  public Animation a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public NearPeopleFilterActivity.NearPeopleFilters a;
  public PeopleAroundAdapter a;
  public LBSHandler a;
  public LBSObserver a;
  public VipMapRoamActivity.UiHandler a;
  public RoamLocalSearchBar a;
  RoamSearchDialog.OnRoamResultObserver jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver = new jfg(this);
  RoamSearchDialog.OnSearchResultItemClick jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick = new jfr(this);
  public RoamingMapView a;
  public IIconListener a;
  public StatusManager a;
  public FaceDecoder a;
  public PullRefreshHeader a;
  public GeoPoint a;
  public MapController a;
  public OverScrollViewListener a;
  public XListView a;
  public Runnable a;
  public List a;
  public AtomicBoolean a;
  public boolean a;
  public float b;
  public long b;
  public View b;
  public Animation b;
  public ImageView b;
  public LinearLayout b;
  public RelativeLayout b;
  public TextView b;
  public RoamLocalSearchBar b;
  public GeoPoint b;
  public boolean b;
  public View c;
  public Animation c;
  public ImageView c;
  public TextView c;
  public GeoPoint c;
  public boolean c;
  public View d;
  public Animation d;
  public ImageView d;
  public TextView d;
  public boolean d;
  public ImageView e;
  public TextView e;
  public String e;
  public boolean e;
  public ImageView f;
  public TextView f;
  public String f;
  public boolean f;
  public TextView g;
  public boolean g;
  public boolean h = false;
  public boolean i = false;
  public boolean j;
  public int m = 0;
  public int n = 0;
  
  static
  {
    jdField_j_of_type_Int = 2000;
  }
  
  public VipMapRoamActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqMaproamActivityVipMapRoamActivity$UiHandler = new VipMapRoamActivity.UiHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new jfm(this);
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new jfo(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new jfp(this);
    this.jdField_a_of_type_JavaLangRunnable = new jfq(this);
    this.jdField_j_of_type_Boolean = false;
  }
  
  private void a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null)) {
      if (!TextUtils.isEmpty(paramSosoLbsInfo.a.jdField_e_of_type_JavaLangString)) {
        break label214;
      }
    }
    label214:
    for (String str = "";; str = paramSosoLbsInfo.a.jdField_e_of_type_JavaLangString)
    {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = new GeoPoint((int)(paramSosoLbsInfo.a.a * 1000000.0D), (int)(paramSosoLbsInfo.a.b * 1000000.0D));
      if ((!this.jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.Copy();
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setCenter(this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint);
      }
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.a(str);
      }
      a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint);
      if (!this.jdField_g_of_type_Boolean)
      {
        a(true, false);
        this.jdField_g_of_type_Boolean = true;
        this.jdField_d_of_type_Boolean = false;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler != null) && (this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint != null)) {
          this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(false, true, this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6(), this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipMapRoamActivity", 2, "onLocationFinish info city=" + str);
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i2 = 8;
    TextView localTextView = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131297997);
    ProgressBar localProgressBar = (ProgressBar)this.jdField_d_of_type_AndroidViewView.findViewById(2131296735);
    ImageView localImageView = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131297996);
    if (paramBoolean)
    {
      i1 = 2131368842;
      localTextView.setText(i1);
      if (!paramBoolean) {
        break label94;
      }
      i1 = 0;
      label68:
      localProgressBar.setVisibility(i1);
      if (!paramBoolean) {
        break label100;
      }
    }
    label94:
    label100:
    for (int i1 = i2;; i1 = 0)
    {
      localImageView.setVisibility(i1);
      return;
      i1 = 2131366569;
      break;
      i1 = 8;
      break label68;
    }
  }
  
  private void i()
  {
    SosoInterface.a(new jfk(this, 3, true, 0L, true, false, "VipMapRoamActivity"));
  }
  
  /* Error */
  public NearPeopleFilterActivity.NearPeopleFilters a(Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 330	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters
    //   5: dup
    //   6: invokespecial 331	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:<init>	()V
    //   9: pop
    //   10: aload_1
    //   11: ifnull +446 -> 457
    //   14: aload_1
    //   15: ldc_w 333
    //   18: invokevirtual 339	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore_1
    //   22: aload_1
    //   23: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +431 -> 457
    //   29: aload_1
    //   30: invokestatic 345	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   33: invokevirtual 348	java/lang/Integer:intValue	()I
    //   36: istore_2
    //   37: iload_2
    //   38: ifeq +360 -> 398
    //   41: aload_0
    //   42: invokevirtual 352	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:getIntent	()Landroid/content/Intent;
    //   45: ldc_w 354
    //   48: invokevirtual 339	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_1
    //   52: aload_0
    //   53: invokevirtual 352	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:getIntent	()Landroid/content/Intent;
    //   56: ldc_w 356
    //   59: invokevirtual 339	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore 6
    //   64: aload_0
    //   65: invokevirtual 352	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:getIntent	()Landroid/content/Intent;
    //   68: ldc_w 358
    //   71: invokevirtual 339	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 7
    //   76: aload_0
    //   77: invokevirtual 352	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:getIntent	()Landroid/content/Intent;
    //   80: ldc_w 360
    //   83: invokevirtual 339	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore 8
    //   88: aload_0
    //   89: invokevirtual 352	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:getIntent	()Landroid/content/Intent;
    //   92: ldc_w 362
    //   95: invokevirtual 339	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore 9
    //   100: aload_0
    //   101: invokevirtual 352	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:getIntent	()Landroid/content/Intent;
    //   104: ldc_w 364
    //   107: invokevirtual 339	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore 5
    //   112: new 330	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters
    //   115: dup
    //   116: invokespecial 331	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:<init>	()V
    //   119: astore 4
    //   121: aload_1
    //   122: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifeq +181 -> 306
    //   128: iconst_0
    //   129: istore_2
    //   130: aload 4
    //   132: iload_2
    //   133: putfield 366	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:i	I
    //   136: aload 6
    //   138: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   141: ifeq +176 -> 317
    //   144: iconst_3
    //   145: istore_2
    //   146: iload_2
    //   147: getstatic 369	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:jdField_a_of_type_ArrayOfInt	[I
    //   150: arraylength
    //   151: if_icmpge +178 -> 329
    //   154: getstatic 369	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:jdField_a_of_type_ArrayOfInt	[I
    //   157: iload_2
    //   158: iaload
    //   159: istore_2
    //   160: aload 4
    //   162: iload_2
    //   163: putfield 370	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:jdField_j_of_type_Int	I
    //   166: aload 7
    //   168: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   171: ifeq +163 -> 334
    //   174: iconst_0
    //   175: istore_2
    //   176: aload 4
    //   178: iload_2
    //   179: putfield 371	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:k	I
    //   182: aload 8
    //   184: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   187: ifeq +159 -> 346
    //   190: iconst_0
    //   191: istore_2
    //   192: aload 4
    //   194: iload_2
    //   195: putfield 373	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:l	I
    //   198: aload 9
    //   200: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   203: ifeq +155 -> 358
    //   206: iconst_0
    //   207: istore_2
    //   208: aload 4
    //   210: iload_2
    //   211: putfield 374	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:m	I
    //   214: iconst_5
    //   215: anewarray 376	java/lang/String
    //   218: astore_1
    //   219: aload_1
    //   220: iconst_0
    //   221: ldc_w 378
    //   224: aastore
    //   225: aload_1
    //   226: iconst_1
    //   227: ldc_w 378
    //   230: aastore
    //   231: aload_1
    //   232: iconst_2
    //   233: ldc_w 378
    //   236: aastore
    //   237: aload_1
    //   238: iconst_3
    //   239: ldc_w 378
    //   242: aastore
    //   243: aload_1
    //   244: iconst_4
    //   245: ldc_w 380
    //   248: aastore
    //   249: aload 5
    //   251: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   254: ifne +132 -> 386
    //   257: aload 5
    //   259: ldc_w 382
    //   262: invokevirtual 386	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   265: astore 5
    //   267: aload 5
    //   269: astore_1
    //   270: aload_1
    //   271: arraylength
    //   272: iconst_4
    //   273: if_icmplt +113 -> 386
    //   276: iload_3
    //   277: istore_2
    //   278: iload_2
    //   279: iconst_4
    //   280: if_icmpge +90 -> 370
    //   283: aload 4
    //   285: getfield 389	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:c	[Ljava/lang/String;
    //   288: iload_2
    //   289: aload_1
    //   290: iload_2
    //   291: aaload
    //   292: aastore
    //   293: iload_2
    //   294: iconst_1
    //   295: iadd
    //   296: istore_2
    //   297: goto -19 -> 278
    //   300: astore_1
    //   301: iconst_0
    //   302: istore_2
    //   303: goto -266 -> 37
    //   306: aload_1
    //   307: invokestatic 345	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   310: invokevirtual 348	java/lang/Integer:intValue	()I
    //   313: istore_2
    //   314: goto -184 -> 130
    //   317: aload 6
    //   319: invokestatic 345	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   322: invokevirtual 348	java/lang/Integer:intValue	()I
    //   325: istore_2
    //   326: goto -180 -> 146
    //   329: iconst_0
    //   330: istore_2
    //   331: goto -171 -> 160
    //   334: aload 7
    //   336: invokestatic 345	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   339: invokevirtual 348	java/lang/Integer:intValue	()I
    //   342: istore_2
    //   343: goto -167 -> 176
    //   346: aload 8
    //   348: invokestatic 345	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   351: invokevirtual 348	java/lang/Integer:intValue	()I
    //   354: istore_2
    //   355: goto -163 -> 192
    //   358: aload 9
    //   360: invokestatic 345	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   363: invokevirtual 348	java/lang/Integer:intValue	()I
    //   366: istore_2
    //   367: goto -159 -> 208
    //   370: aload_1
    //   371: arraylength
    //   372: iconst_5
    //   373: if_icmplt +18 -> 391
    //   376: aload_1
    //   377: iconst_4
    //   378: aaload
    //   379: astore_1
    //   380: aload 4
    //   382: aload_1
    //   383: putfield 391	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   386: aload 4
    //   388: astore_1
    //   389: aload_1
    //   390: areturn
    //   391: ldc_w 380
    //   394: astore_1
    //   395: goto -15 -> 380
    //   398: aload_0
    //   399: invokevirtual 395	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:getApplication	()Landroid/app/Application;
    //   402: aload_0
    //   403: getfield 399	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   406: invokevirtual 403	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   409: invokestatic 406	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters;
    //   412: astore 4
    //   414: aload 4
    //   416: astore_1
    //   417: aload 4
    //   419: ifnonnull -30 -> 389
    //   422: new 330	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters
    //   425: dup
    //   426: invokespecial 331	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:<init>	()V
    //   429: astore_1
    //   430: aload_1
    //   431: iconst_0
    //   432: putfield 371	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:k	I
    //   435: aload_1
    //   436: iconst_0
    //   437: putfield 373	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:l	I
    //   440: aload_1
    //   441: iconst_4
    //   442: putfield 370	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:jdField_j_of_type_Int	I
    //   445: aload_1
    //   446: iconst_0
    //   447: putfield 366	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:i	I
    //   450: aload_1
    //   451: areturn
    //   452: astore 5
    //   454: goto -184 -> 270
    //   457: iconst_0
    //   458: istore_2
    //   459: goto -422 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	VipMapRoamActivity
    //   0	462	1	paramIntent	Intent
    //   36	423	2	i1	int
    //   1	276	3	i2	int
    //   119	299	4	localNearPeopleFilters	NearPeopleFilterActivity.NearPeopleFilters
    //   110	158	5	localObject	Object
    //   452	1	5	localException	Exception
    //   62	256	6	str1	String
    //   74	261	7	str2	String
    //   86	261	8	str3	String
    //   98	261	9	str4	String
    // Exception table:
    //   from	to	target	type
    //   29	37	300	java/lang/Exception
    //   257	267	452	java/lang/Exception
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())) {}
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        if (localObject != null)
        {
          localObject = (PeopleAroundAdapter.ViewHolder)((View)localObject).getTag();
          if ((localObject != null) && (paramString.equals(((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString)))
          {
            ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(TextView paramTextView, int paramInt)
  {
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(getResources(), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramInt, 200), false, false);
    if (this.m == 0) {
      this.m = ((int)(paramTextView.getTextSize() * 1.1F + 0.5F));
    }
    localStatableBitmapDrawable.setBounds(0, 0, this.m, this.m);
    paramTextView.setCompoundDrawables(localStatableBitmapDrawable, null, null, null);
  }
  
  public void a(PeopleAroundAdapter.ViewHolder paramViewHolder)
  {
    Object localObject1;
    Object localObject2;
    if (paramViewHolder != null)
    {
      paramViewHolder = paramViewHolder.jdField_a_of_type_JavaLangObject;
      if (paramViewHolder != null)
      {
        paramViewHolder = (RespEncounterInfo)paramViewHolder;
        localObject1 = String.valueOf(paramViewHolder.lEctID);
        localObject2 = (FriendManager)this.app.getManager(8);
        if ((paramViewHolder.lEctID <= 0L) || (localObject2 == null)) {
          break label583;
        }
      }
    }
    label583:
    for (boolean bool = ((FriendManager)localObject2).b((String)localObject1);; bool = false)
    {
      if (((String)localObject1).equals(this.app.a()))
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 0);
        ((ProfileActivity.AllInOne)localObject1).h = paramViewHolder.strNick;
        ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_Int = paramViewHolder.cAge;
        ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Byte = paramViewHolder.cSex;
        ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Short = paramViewHolder.wFace;
        ((ProfileActivity.AllInOne)localObject1).f = 103;
        ((ProfileActivity.AllInOne)localObject1).g = 5;
        localObject2 = new Intent(this, NearbyPeopleProfileActivity.class);
        ((Intent)localObject2).putExtra("AllInOne", (Parcelable)localObject1);
        ((Intent)localObject2).putExtra("param_mode", 2);
        ((Intent)localObject2).putExtra("param_tiny_id", paramViewHolder.tiny_id);
        startActivityForResult((Intent)localObject2, k);
        localObject1 = this.app;
        if (VipUtils.a(this.app)) {}
        for (paramViewHolder = "1";; paramViewHolder = "0")
        {
          VipUtils.a((QQAppInterface)localObject1, "Vip_MapRoam", "0X8004A34", "0X8004A34", 0, 0, new String[] { paramViewHolder });
          return;
        }
      }
      if (bool)
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 40);
        ((ProfileActivity.AllInOne)localObject1).h = paramViewHolder.strNick;
        ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_Int = paramViewHolder.cAge;
        ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Byte = paramViewHolder.cSex;
        ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Short = paramViewHolder.wFace;
        ((ProfileActivity.AllInOne)localObject1).f = 103;
        ((ProfileActivity.AllInOne)localObject1).g = 5;
        ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject1);
        localObject1 = this.app;
        if (VipUtils.a(this.app)) {}
        for (paramViewHolder = "1";; paramViewHolder = "0")
        {
          VipUtils.a((QQAppInterface)localObject1, "Vip_MapRoam", "0X8004A34", "0X8004A34", 0, 0, new String[] { paramViewHolder });
          return;
        }
      }
      localObject1 = new ProfileActivity.AllInOne((String)localObject1, 41);
      ((ProfileActivity.AllInOne)localObject1).h = paramViewHolder.strNick;
      ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_Int = paramViewHolder.cAge;
      ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Byte = paramViewHolder.cSex;
      ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Short = paramViewHolder.wFace;
      ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_ArrayOfByte = paramViewHolder.sig;
      ((ProfileActivity.AllInOne)localObject1).o = paramViewHolder.enc_id;
      ((ProfileActivity.AllInOne)localObject1).p = paramViewHolder.uid;
      if (QLog.isDevelopLevel()) {
        QLog.d("fight_accost", 4, "附近人列表accost_uin = " + ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_JavaLangString + "accost_sig = " + ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_ArrayOfByte);
      }
      ((ProfileActivity.AllInOne)localObject1).f = 103;
      ((ProfileActivity.AllInOne)localObject1).g = 5;
      localObject2 = new Intent(this, NearbyPeopleProfileActivity.class);
      ((Intent)localObject2).putExtra("AllInOne", (Parcelable)localObject1);
      ((Intent)localObject2).addFlags(536870912);
      ((Intent)localObject2).putExtra("param_mode", 3);
      ((Intent)localObject2).putExtra("param_tiny_id", paramViewHolder.tiny_id);
      startActivity((Intent)localObject2);
      localObject1 = this.app;
      if (VipUtils.a(this.app)) {}
      for (paramViewHolder = "1";; paramViewHolder = "0")
      {
        VipUtils.a((QQAppInterface)localObject1, "Vip_MapRoam", "0X8004A34", "0X8004A34", 0, 0, new String[] { paramViewHolder });
        return;
      }
    }
  }
  
  protected void a(GeoPoint paramGeoPoint)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipMapRoamActivity", 2, "markCurrentPosition Lat=" + paramGeoPoint.getLatitudeE6() + ",Lng=" + paramGeoPoint.getLongitudeE6());
    }
    paramGeoPoint = new MapView.LayoutParams(-2, -2, paramGeoPoint, 17);
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130837678);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localRelativeLayout.addView(this.jdField_d_of_type_AndroidWidgetImageView);
    localObject = new ImageView(this);
    ((ImageView)localObject).setImageResource(2130837677);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    ((ImageView)localObject).setLayoutParams(localLayoutParams);
    localRelativeLayout.addView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.addView(localRelativeLayout, paramGeoPoint);
    this.jdField_d_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getApplication(), 17432576);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setDuration(800L);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setRepeatCount(-1);
    this.jdField_d_of_type_AndroidWidgetImageView.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimation);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
    } while (paramInt != 0);
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 < 1) {}
    do
    {
      do
      {
        return;
      } while (paramInt1 != 0);
      paramAbsListView = ((ListView)paramAbsListView).getChildAt(0);
    } while (paramAbsListView == null);
    paramInt1 = Math.abs(paramAbsListView.getTop());
    paramInt2 = getResources().getDimensionPixelOffset(2131493260) - getResources().getDimensionPixelOffset(2131493262);
    if (paramInt1 >= paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setBackgroundAlpha(1.0F);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    float f1 = paramInt1 * 1.0F / paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setBackgroundAlpha(f1);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipMapRoamActivity", 2, "showSecurityTips strSecurityTips=" + paramString1 + " strSecurityDetailUrl=" + paramString2);
      }
      QQCustomDialog localQQCustomDialog = DialogUtil.a(getApplication(), 230);
      localQQCustomDialog.setTitle("温馨提示");
      localQQCustomDialog.getMessageTextView().setVisibility(8);
      TextView localTextView = localQQCustomDialog.getMessageTextView_Plain_Text();
      localTextView.setVisibility(0);
      SpannableString localSpannableString = new SpannableString(paramString1 + "了解更多");
      localSpannableString.setSpan(new URLSpan(paramString2), paramString1.length(), localSpannableString.length(), 18);
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), paramString1.length(), localSpannableString.length(), 33);
      localTextView.setText(localSpannableString);
      localTextView.setMovementMethod(LinkMovementMethod.getInstance());
      localQQCustomDialog.setNegativeButton(2131365737, new jfh(this, localQQCustomDialog));
      localQQCustomDialog.show();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipMapRoamActivity", 2, "getMapRoamList last request is in process... return");
      }
      return;
    }
    if (!paramBoolean1) {
      a(true);
    }
    int i3 = c();
    byte b5 = (byte)this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.l;
    int i2 = 480;
    int i1;
    label68:
    byte b3;
    byte b4;
    byte b1;
    byte b2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_j_of_type_Int == 0)
    {
      i1 = 480;
      b3 = 0;
      b4 = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k != 0) {
        break label317;
      }
      b1 = 0;
      b2 = 0;
      label89:
      this.jdField_c_of_type_Boolean = true;
      if (!paramBoolean2) {
        break label456;
      }
    }
    label317:
    label456:
    for (i2 = 1;; i2 = 0)
    {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(i3, paramBoolean1, null, this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint, i2, b5, i1, b1, b2, this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.m, ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.c[0]), ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.c[1]), ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.c[2]), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint, null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VipMapRoamActivity", 2, "getMapRoamList mRequestId=" + this.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_j_of_type_Int == 1)
      {
        i1 = 30;
        break label68;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_j_of_type_Int == 2)
      {
        i1 = 60;
        break label68;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_j_of_type_Int == 3)
      {
        i1 = 240;
        break label68;
      }
      i1 = i2;
      if (!QLog.isColorLevel()) {
        break label68;
      }
      QLog.d("VipMapRoamActivity", 2, "getMapRoamList time is unknown mFilter.time=" + this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_j_of_type_Int);
      i1 = i2;
      break label68;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k == 1)
      {
        b1 = 18;
        b2 = 22;
        break label89;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k == 2)
      {
        b1 = 23;
        b2 = 26;
        break label89;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k == 3)
      {
        b1 = 27;
        b2 = 35;
        break label89;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k == 4)
      {
        b1 = 36;
        b2 = 127;
        break label89;
      }
      b1 = b3;
      b2 = b4;
      if (!QLog.isColorLevel()) {
        break label89;
      }
      QLog.d("VipMapRoamActivity", 2, "getMapRoamList agetype is unknown mFilter.age=" + this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k);
      b1 = b3;
      b2 = b4;
      break label89;
    }
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 1)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.dispatchTouchEvent(paramMotionEvent);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 0)
    {
      if (this.jdField_a_of_type_ComTencentWidgetXListView.getScrollY() >= 0) {
        break label83;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.getVisibility() != 0) {
        this.jdField_b_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setVisibility(8);
      }
    }
    for (;;)
    {
      return false;
      label83:
      if (this.jdField_b_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.getVisibility() != 8) {
        this.jdField_b_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.getVisibility() != 0) {
        this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setVisibility(0);
      }
    }
  }
  
  public void b(GeoPoint paramGeoPoint)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipMapRoamActivity", 2, "onMapScrollEnd to refresh bubble view");
    }
    this.jdField_f_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
    this.h = true;
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      if (paramBoolean2) {
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMaproamActivityVipMapRoamActivity$UiHandler;
    if (paramBoolean1) {}
    for (int i1 = 0;; i1 = 200)
    {
      localObject = ((VipMapRoamActivity.UiHandler)localObject).obtainMessage(100, i1, 0);
      this.jdField_a_of_type_ComTencentMobileqqMaproamActivityVipMapRoamActivity$UiHandler.sendMessageDelayed((Message)localObject, 1000L);
      return;
    }
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters != null)
    {
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.i)
      {
      case 0: 
      default: 
        return 0;
      case 1: 
        return 2;
      }
      return 1;
    }
    return -1;
  }
  
  public void c(GeoPoint paramGeoPoint) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == jdField_j_of_type_Int) {
      if (paramInt2 == -1)
      {
        localObject = new NearPeopleFilterActivity.NearPeopleFilters();
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).i = paramIntent.getIntExtra("gender", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).jdField_j_of_type_Int = paramIntent.getIntExtra("time", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).k = paramIntent.getIntExtra("age", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).l = paramIntent.getIntExtra("xingzuo", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).m = paramIntent.getIntExtra("key_career", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).c[0] = paramIntent.getStringExtra("key_hometown_country");
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).c[1] = paramIntent.getStringExtra("key_hometown_province");
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).c[2] = paramIntent.getStringExtra("key_hometown_city");
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("key_hometown_string");
        this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = ((NearPeopleFilterActivity.NearPeopleFilters)localObject);
        a(true, true);
      }
    }
    label152:
    byte b1;
    byte b2;
    byte b3;
    int i1;
    do
    {
      do
      {
        do
        {
          break label152;
          do
          {
            return;
          } while ((paramInt1 != k) || (paramInt2 != -1));
          localObject = paramIntent.getStringExtra("param_nickname");
          b1 = paramIntent.getByteExtra("param_gender", (byte)-1);
          paramInt1 = paramIntent.getIntExtra("param_age", 0);
          paramInt2 = paramIntent.getIntExtra("param_career", 0);
          b2 = paramIntent.getByteExtra("param_constellation", (byte)0);
          b3 = paramIntent.getByteExtra("param_marital_status", (byte)0);
          i1 = paramIntent.getIntExtra("param_photo_count", 0);
        } while ((this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.size() <= 0));
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.get(0);
      } while ((paramIntent == null) || (!(paramIntent instanceof RespEncounterInfo)));
      paramIntent = (RespEncounterInfo)paramIntent;
    } while ((paramIntent.lEctID <= 0L) || (!this.app.a().equals(String.valueOf(paramIntent.lEctID))));
    paramIntent.strNick = ((String)localObject);
    paramIntent.cSex = b1;
    paramIntent.cAge = ((byte)paramInt1);
    paramIntent.profession_id = paramInt2;
    paramIntent.constellation = b2;
    paramIntent.marriage = b3;
    paramIntent.nFaceNum = i1;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipMapRoamActivity", 2, "doOnCreate VipMapRoam");
    }
    super.doOnCreate(paramBundle);
    super.setContentViewNoTitle(2130904091);
    this.app.e(true);
    this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = ((LBSHandler)this.app.a(3));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    e();
    this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = a(getIntent());
    f();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler != null) && (NetworkUtil.e(getApplication())))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.d();
      QQAppInterface localQQAppInterface = this.app;
      if (!VipUtils.a(this.app)) {
        break label282;
      }
      paramBundle = "1";
      label173:
      VipUtils.a(localQQAppInterface, "Vip_MapRoam", "0X8004A2E", "0X8004A2E", 0, 0, new String[] { paramBundle });
      this.i = getIntent().getBooleanExtra("abp_flag", false);
      this.jdField_j_of_type_Boolean = getIntent().getBooleanExtra("is_from_web", false);
      if ((!this.jdField_j_of_type_Boolean) || (this.i)) {
        break label289;
      }
      setLeftViewName(2131365114);
    }
    label282:
    label289:
    while (!this.i)
    {
      return true;
      if (NetworkUtil.e(getApplication())) {
        break;
      }
      QQToast.a(getApplication(), getString(2131365730), 0).b(getTitleBarHeight());
      break;
      paramBundle = "0";
      break label173;
    }
    setLeftViewName(2131367588);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMaproamActivityVipMapRoamActivity$UiHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.destroy();
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.onDestroy();
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.onPause();
    }
    if ((this.jdField_d_of_type_AndroidViewAnimationAnimation != null) && (this.jdField_d_of_type_AndroidWidgetImageView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipMapRoamActivity", 2, "doOnPause clear mCurrentPositionAnim");
      }
      this.jdField_d_of_type_AndroidViewAnimationAnimation.cancel();
      this.jdField_d_of_type_AndroidWidgetImageView.clearAnimation();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.onResume();
    if ((this.jdField_d_of_type_AndroidViewAnimationAnimation != null) && (this.jdField_d_of_type_AndroidWidgetImageView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipMapRoamActivity", 2, "doOnResume restart mCurrentPositionAnim");
      }
      this.jdField_d_of_type_AndroidViewAnimationAnimation.reset();
      this.jdField_d_of_type_AndroidWidgetImageView.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.onStop();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getApplication(), 2130968642);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatCount(0);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getApplication(), 2130968644);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatCount(0);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getApplication(), 2130968643);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setRepeatCount(1);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar = ((RoamLocalSearchBar)findViewById(2131300806));
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.a(this.app, this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver, this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.findViewById(2131300822));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131300807));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131300817));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131300818));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131300819));
    this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131300820));
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131300805));
    this.jdField_a_of_type_ComTencentWidgetXListView.setMotionEventInterceptor(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2130903607, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131492896));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837687);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getLayoutInflater().inflate(2130904092, null));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300808));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300816));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300817));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300818));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300819));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300820));
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView = ((RoamingMapView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300809));
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setBuiltInZoomControls(false);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setMapMode(1);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setOnTouchListener(new jff(this));
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getController();
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getMaxZoomLevel() - 1);
    Object localObject = getIntent();
    if (localObject != null)
    {
      i1 = ((Intent)localObject).getIntExtra("lat", 0);
      i2 = ((Intent)localObject).getIntExtra("lon", 0);
      if ((-2147483648 != i1) && (-2147483648 != i2) && (i1 != 0) && (i2 != 0))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = new GeoPoint(i1, i2);
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setCenter(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint);
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar = ((RoamLocalSearchBar)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300810));
    this.jdField_b_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300811));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300812));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300813));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300815);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300814));
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_b_of_type_AndroidViewView = getLayoutInflater().inflate(2130903958, null);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131300205);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131300206);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter = new PeopleAroundAdapter(this, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, this);
    localObject = getLayoutInflater().inflate(2130903964, null);
    int i1 = getResources().getDimensionPixelOffset(2131493260);
    int i2 = getResources().getDimensionPixelOffset(2131493261);
    ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, getWindowManager().getDefaultDisplay().getHeight() - i2 - i1));
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_AndroidViewView = ((View)localObject);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter);
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.post(new jfj(this));
  }
  
  public void finish()
  {
    super.finish();
    if (this.i) {
      overridePendingTransition(2130968589, 2130968591);
    }
  }
  
  public void g()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("switchMapMode current mode=");
      if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 1)
      {
        localObject = "active mode";
        QLog.d("VipMapRoamActivity", 2, (String)localObject);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView == null) || (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() != 1)) {
        break label211;
      }
      localObject = new ValueAnimation(Integer.valueOf(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight()), Integer.valueOf(getResources().getDimensionPixelSize(2131493260)), null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setMapMode(0);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 8)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setBackgroundAlpha(0.0F);
      ((ValueAnimation)localObject).setDuration(300L);
      ((ValueAnimation)localObject).setAnimationListener(this);
      ((ValueAnimation)localObject).a(new jfi(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation((Animation)localObject);
      label211:
      do
      {
        return;
        localObject = "thumbnail mode";
        break;
        localObject = findViewById(16908290);
      } while (localObject == null);
      localObject = new ValueAnimation(Integer.valueOf(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight()), Integer.valueOf(((View)localObject).getHeight()), null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setMapMode(1);
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipMapRoamActivity", 2, "updateFilterBar");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.toString());
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.toString());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d("VipMapRoamActivity", 2, "updateFilterBar exception msg=" + localException.getMessage());
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onAnimationEnd mapview is ");
      if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 1)
      {
        str = "active mode";
        QLog.d("VipMapRoamActivity", 2, str);
      }
    }
    else
    {
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation != paramAnimation) {
        break label83;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
    label83:
    do
    {
      do
      {
        do
        {
          return;
          str = "thumbnail mode";
          break;
          if (this.jdField_b_of_type_AndroidViewAnimationAnimation == paramAnimation)
          {
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
            return;
          }
        } while (!(paramAnimation instanceof ValueAnimation));
        if (QLog.isColorLevel()) {
          QLog.d("VipMapRoamActivity", 2, "onAnimationEnd switch map mode end");
        }
        if (1 != this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a()) {
          break label152;
        }
      } while (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    } while (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0);
    label152:
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (((this.jdField_a_of_type_AndroidViewAnimationAnimation == paramAnimation) || (this.jdField_b_of_type_AndroidViewAnimationAnimation == paramAnimation)) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.i)
    {
      Intent localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("abp_flag", this.i);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof PeopleAroundAdapter.ViewHolder)))
    {
      a((PeopleAroundAdapter.ViewHolder)paramView.getTag());
      return;
    }
    QQAppInterface localQQAppInterface;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300206: 
      localQQAppInterface = this.app;
      if (!VipUtils.a(this.app)) {
        break;
      }
    case 2131300815: 
    case 2131300820: 
    case 2131300822: 
    case 2131300280: 
    case 2131300819: 
      for (paramView = "1";; paramView = "0")
      {
        VipUtils.a(localQQAppInterface, "Vip_MapRoam", "0X8004A36", "0X8004A36", 0, 0, new String[] { paramView });
        if (NetworkUtil.e(getApplication())) {
          break;
        }
        a(1, getString(2131367328));
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 1)
        {
          onBackEvent();
          return;
        }
        g();
        return;
        NearPeopleFilterActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters, jdField_j_of_type_Int);
        localQQAppInterface = this.app;
        if (VipUtils.a(this.app)) {}
        for (paramView = "1";; paramView = "0")
        {
          VipUtils.a(localQQAppInterface, "Vip_MapRoam", "0X8004A33", "0X8004A33", 0, 0, new String[] { paramView });
          return;
        }
      }
      a(false, true);
      return;
    }
    if (this.n == 100500)
    {
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
      {
        paramView = getResources().getString(2131369318);
        Utils.a(this, 2131365995, paramView, new jfl(this), null);
        localQQAppInterface = this.app;
        if (!VipUtils.a(this.app)) {
          break label362;
        }
      }
      label362:
      for (paramView = "1";; paramView = "0")
      {
        VipUtils.a(localQQAppInterface, "Vip_MapRoam", "0X8004A30", "0X8004A30", 0, 0, new String[] { paramView });
        return;
        paramView = this.jdField_e_of_type_JavaLangString;
        break;
      }
    }
    if (this.n == 100501)
    {
      QQToast.a(getApplication(), this.jdField_e_of_type_JavaLangString, 0).b(getTitleBarHeight());
      localQQAppInterface = this.app;
      if (VipUtils.a(this.app)) {}
      for (paramView = "1";; paramView = "0")
      {
        VipUtils.a(localQQAppInterface, "Vip_MapRoam", "0X8004A30", "0X8004A30", 0, 0, new String[] { paramView });
        return;
      }
    }
    if (!NetworkUtil.e(getApplication()))
    {
      QQToast.a(getApplication(), getString(2131365730), 0).b(getTitleBarHeight());
      return;
    }
    this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getMapCenter();
    if ((this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6() != 0) && (this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6() != 0))
    {
      a(true, true);
      localQQAppInterface = this.app;
      if (!VipUtils.a(this.app)) {
        break label617;
      }
    }
    label617:
    for (paramView = "1";; paramView = "0")
    {
      VipUtils.a(localQQAppInterface, "Vip_MapRoam", "0X8004A32", "0X8004A32", 0, 0, new String[] { paramView });
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VipMapRoamActivity", 2, "get roamPoint error mRoamPoint,lat=" + this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6() + ",lng=" + this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6());
      break;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView != null) && (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 0))
    {
      g();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.activity.VipMapRoamActivity
 * JD-Core Version:    0.7.0.1
 */