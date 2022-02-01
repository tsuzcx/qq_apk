package com.tencent.mobileqq.magicface.view;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicfaceRenderListener;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import jem;
import jen;
import jeo;
import jep;
import jeq;
import jeu;
import jex;
import jey;

public class MagicfaceViewController
  implements View.OnClickListener
{
  public static final String a;
  public static boolean a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private Emoticon jdField_a_of_type_ComTencentMobileqqDataEmoticon;
  private ActionGlobalData jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
  private MagicfaceActionManager jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
  private IMagicFaceView jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView;
  private MagicfaceContainerView jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView;
  private MagicfaceViewController.OnMagicPlayEnd jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private IMagicFaceView jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView;
  private MagicfaceContainerView jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Button jdField_d_of_type_AndroidWidgetButton;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private Button e;
  private Button f;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaLangString = MagicfaceViewController.class.getSimpleName();
    String str1 = DeviceInfoUtil.f();
    if (str1 != null)
    {
      String str2 = str1.toLowerCase();
      if ((!str2.contains("marvell")) && (!str2.contains("armv5")) && (!str2.contains("armv6"))) {
        break label88;
      }
    }
    label88:
    for (jdField_a_of_type_Boolean = false;; jdField_a_of_type_Boolean = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "cpuType=" + str1);
      }
      return;
    }
  }
  
  public MagicfaceViewController(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    d();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func MagicfaceViewController[Constructor] ends.isUseHardDecode:" + this.jdField_b_of_type_Boolean);
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.type = 2002;
    localLayoutParams.flags = 131112;
    localLayoutParams.gravity = 51;
    localLayoutParams.x = 0;
    localLayoutParams.y = paramInt;
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localLayoutParams.format = 1;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getSystemService("window"));
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
      label93:
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
    }
    catch (Exception localException)
    {
      break label93;
    }
  }
  
  public static boolean a()
  {
    if ((DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.magicface_support.name())) && (jdField_a_of_type_Boolean) && (DecoderUtil.IS_LOAD_SUCESS))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "is_support_magic:TRUE");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "is_support_magic:FALSE");
    }
    return false;
  }
  
  private void d()
  {
    if (!DeviceInfoUtil.e())
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if (Math.min(DeviceInfoUtil.f(), DeviceInfoUtil.g()) >= 720L)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initMagicfaceView begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.S();
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "initMagicfaceView=======qvip_magicface_send");
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getLayoutInflater().inflate(2130904087, null);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView = ((IMagicFaceView)localView.findViewById(2131300792));
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131300791));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131300793));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131300794));
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131300798));
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131300795));
        this.jdField_d_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131300797));
        this.e = ((Button)localView.findViewById(2131300796));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.e.setOnClickListener(this);
      }
    }
    else if (this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label443;
      }
    }
    label443:
    for (View localView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getLayoutInflater().inflate(2130904086, null);; localView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getLayoutInflater().inflate(2130904088, null))
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getLayoutInflater().inflate(2130904090, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300799);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView = ((IMagicFaceView)localView.findViewById(2131300789));
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131300788));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300802));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131300790));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131300803));
      this.f = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131300800));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300801));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.f.setOnClickListener(this);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "initMagicfaceView ends");
      }
      return;
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getLayoutInflater().inflate(2130904089, null);
      break;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b())
    {
      this.e.setBackgroundResource(2130840784);
      return;
    }
    this.e.setBackgroundResource(2130840783);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c())
    {
      this.f.setBackgroundResource(2130840753);
      return;
    }
    this.f.setBackgroundResource(2130840781);
  }
  
  private void h()
  {
    PicEmoticonInfo localPicEmoticonInfo = (PicEmoticonInfo)this.jdField_d_of_type_AndroidWidgetButton.getTag();
    if ((localPicEmoticonInfo != null) && (localPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 2)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a() >= 0)) {
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a() != 0) {
          break label85;
        }
      }
    }
    label85:
    for (localPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue = "value=1";; localPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue = ("value=" + this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(localPicEmoticonInfo);
      b();
      a(localPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon, null);
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new jen(this));
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface, magicValue:" + paramEmoticon.magicValue);
    }
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView != null) && (((View)this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 1.");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.a();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView == null) || (((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).getVisibility() != 0)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 2.");
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd == null);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.a();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 3.");
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd == null);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.a();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
      return;
      if (paramInt != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = MagicfaceActionManager.a(paramEmoticon, paramInt);
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 4.");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd == null);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.a();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
    return;
    this.jdField_b_of_type_JavaLangString = paramEmoticon.epId;
    e();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager = new MagicfaceActionManager(this);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 5.");
      }
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView;
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
      localObject3 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView();
      ((ViewGroup)localObject3).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      ((ViewGroup)localObject3).addView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
    }
    for (;;)
    {
      ((View)localObject1).setVisibility(0);
      ((SurfaceView)localObject1).setZOrderOnTop(true);
      ((SurfaceView)localObject1).getHolder().setFormat(-2);
      localObject3 = new MagicfacePlayManager();
      ((MagicfacePlayManager)localObject3).a((MagicfaceDecoder.MagicfaceRenderListener)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a((MagicfacePlayManager)localObject3);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(new jeq(this, paramInt, (TextView)localObject2));
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(new jeu(this, l, paramInt));
      if (!((IMagicFaceView)localObject1).a()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 7.");
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(paramEmoticon, paramInt, paramString);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 6.");
      }
      localObject1 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView();
      ((ViewGroup)localObject1).removeView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      localObject2 = new Rect();
      ((ViewGroup)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
      int i = ((Rect)localObject2).top;
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      a(0);
      ((ViewGroup)localObject1).addView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.updateViewLayout((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView, (ViewGroup.LayoutParams)localObject2);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView.setIsFullScreen(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView;
      localObject2 = this.jdField_c_of_type_AndroidWidgetTextView;
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func playMaigcface ends, step 8.");
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new jex(this), 200L);
    ((IMagicFaceView)localObject1).setSurfaceCreatelistener(new jey(this, paramEmoticon, paramInt, paramString));
  }
  
  public void a(Emoticon paramEmoticon, MagicfaceViewController.OnMagicPlayEnd paramOnMagicPlayEnd)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func magicfaceAutoPlay, magicValue:" + paramEmoticon.magicValue);
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = paramOnMagicPlayEnd;
    if (!a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.a();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func magicfaceAutoPlay ends, not support.");
      }
    }
    do
    {
      return;
      paramOnMagicPlayEnd = new Emoticon();
      paramOnMagicPlayEnd.eId = paramEmoticon.eId;
      paramOnMagicPlayEnd.epId = paramEmoticon.epId;
      paramOnMagicPlayEnd.magicValue = paramEmoticon.magicValue;
      paramOnMagicPlayEnd.jobType = paramEmoticon.jobType;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = paramOnMagicPlayEnd;
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new jeo(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    this.jdField_d_of_type_AndroidWidgetButton.setTag(paramEmoticonInfo);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView.setSurfaceCreatelistener(null);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      ((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView.setSurfaceCreatelistener(null);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "removeView=======DecorView");
      }
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView();
      ((ViewGroup)localObject).removeView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidViewWindowManager != null) {
          this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label169:
      break label169;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
      ((MagicfaceActionManager)localObject).a(new jep(this, (MagicfaceActionManager)localObject));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.a();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.e();
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager != null) && ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8) || (this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8)))
    {
      b();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    b();
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    switch (paramView.getId())
    {
    case 2131300799: 
    case 2131300801: 
    case 2131300802: 
    default: 
    case 2131300795: 
    case 2131300803: 
    case 2131300798: 
      do
      {
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
        b();
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
        b();
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "CliOper", "", "", "MbFasong", "MbChongzuo", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager == null);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new jem(this), 300L);
      return;
    case 2131300797: 
      h();
      return;
    case 2131300796: 
      bool3 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b();
      paramView = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
      if (!bool3)
      {
        bool1 = true;
        label251:
        paramView.a(bool1);
        f();
        paramView = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
        if (bool3) {
          break label327;
        }
      }
      label327:
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.c(bool1);
        if (bool3) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "CliOper", "", "", "MbFasong", "MbKaiqiShengxiao", 0, 0, "", "", "", "");
        return;
        bool1 = false;
        break label251;
      }
    }
    bool2 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c();
    paramView = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
    if (!bool2)
    {
      bool1 = true;
      label351:
      paramView.b(bool1);
      g();
      paramView = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
      if (bool2) {
        break label426;
      }
    }
    label426:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      paramView.c(bool1);
      if (bool2) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "CliOper", "", "", "MbJieshou", "MbKaiqiShengxiao2", 0, 0, "", "", "", "");
      return;
      bool1 = false;
      break label351;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController
 * JD-Core Version:    0.7.0.1
 */