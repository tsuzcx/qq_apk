package com.tencent.mobileqq.facetoface;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NearFieldTroopHandler;
import com.tencent.mobileqq.app.NearFieldTroopObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import iho;
import ihp;
import ihs;
import iht;
import ihu;
import ihv;
import ihw;
import ihx;
import ihy;
import ihz;
import iia;
import iib;
import iic;
import iie;
import iif;
import iig;
import iih;
import iii;
import iik;
import iil;
import iim;
import iin;
import iio;
import iis;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class Face2FaceAddFriendActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, Face2FaceAddFriendAnim.CompassAnimationEnd, Observer
{
  public static int A = 0;
  public static int B = 0;
  public static int C = 2000;
  public static final int F = 0;
  public static final int G = 100;
  public static int a = 0;
  public static long a = 0L;
  public static String a;
  private static Calendar jdField_a_of_type_JavaUtilCalendar;
  public static String b;
  public static final int c = 0;
  protected static final long c = 1200000L;
  public static String c;
  public static final int d = 2;
  protected static final long d = 10000L;
  public static final String d = "android.net.conn.CONNECTIVITY_CHANGE";
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  protected static final long i = 1000L;
  public static final int j = 8;
  protected static final int k = 9;
  protected static final int l = 10;
  protected static final int m = 11;
  protected static final int n = 12;
  protected static final int o = 13;
  protected static final int p = 14;
  protected static final int q = 15;
  protected static final int r = 16;
  protected static final int s = 17;
  public static final int v = 5;
  public static final int w = 5;
  public static final int x = 10;
  public int D = 0;
  public int E = 0;
  int H;
  int I;
  public int J = 0;
  int K = 0;
  int L = 0;
  public int M = 0;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new iig(this);
  public Point a;
  public View a;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  public EditText a;
  public FrameLayout a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public FriendListHandler a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new iio(this);
  public LBSHandler a;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new iim(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new iin(this);
  private NearFieldTroopObserver jdField_a_of_type_ComTencentMobileqqAppNearFieldTroopObserver = new ihp(this);
  public NewFriendManager a;
  public Face2FaceAddFriendAnim a;
  protected Face2FaceDetailBaseView.IFace2faceContext a;
  public Face2FaceFriendDetailView a;
  public Face2FaceTroopDetailView a;
  public Face2FaceTroopFriendListAdapter a;
  public SnowView a;
  public QQProgressDialog a;
  public XListView a;
  private iis jdField_a_of_type_Iis = new iis(this);
  public ArrayList a;
  public HashMap a;
  public List a;
  public CopyOnWriteArrayList a;
  public boolean a;
  public int b;
  public long b;
  protected View b;
  ImageView b;
  public LinearLayout b;
  public TextView b;
  public HashMap b;
  public List b;
  public boolean b;
  protected View c;
  protected TextView c;
  public HashMap c;
  public List c;
  public boolean c;
  protected View d;
  protected TextView d;
  public List d;
  public boolean d;
  protected long e;
  protected TextView e;
  public String e;
  public List e;
  public boolean e;
  long f;
  protected TextView f;
  public String f;
  public List f;
  public boolean f;
  long g;
  public String g;
  public boolean g;
  public long h;
  public String h;
  public boolean h;
  boolean i = false;
  boolean j = true;
  public boolean k = true;
  public boolean l = false;
  protected boolean m = false;
  public boolean n = false;
  private boolean o = false;
  private boolean p = false;
  public int t = 0;
  int u = 0;
  public int y = 0;
  public int z = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Face2FaceAddFriendActivity";
    jdField_b_of_type_JavaLangString = "Face2FaceAddFriendActivity.troop";
    jdField_c_of_type_JavaLangString = "Face2FaceAddFriendActivity.time";
    jdField_a_of_type_Int = 3021;
    A = 500;
    B = 300000;
    jdField_a_of_type_Long = 1000L;
  }
  
  public Face2FaceAddFriendActivity()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_e_of_type_JavaUtilList = new ArrayList();
    this.jdField_f_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_d_of_type_AndroidViewView = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_h_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext = new iie(this);
  }
  
  private int a(Face2FaceUserData paramFace2FaceUserData)
  {
    return this.jdField_d_of_type_JavaUtilList.indexOf(paramFace2FaceUserData);
  }
  
  private Face2FaceFriendBubbleView a(String paramString, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)localIterator.next();
      if ((paramString.equals(localFace2FaceFriendBubbleView.b())) && (localFace2FaceFriendBubbleView.a() == paramInt)) {
        return localFace2FaceFriendBubbleView;
      }
    }
    return null;
  }
  
  private Face2FaceUserData a()
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getHasShowFriendData正在查看详情Uin" + this.jdField_h_of_type_JavaLangString.substring(0, 4));
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    Face2FaceUserData localFace2FaceUserData;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localFace2FaceUserData = (Face2FaceUserData)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) && (localFace2FaceUserData.jdField_e_of_type_JavaLangString.equals(this.jdField_h_of_type_JavaLangString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "getHasShowFriendData需要替换但是正在查看详情");
          }
        }
        else if ((localFace2FaceUserData.jdField_a_of_type_Int == 1) && (b(localFace2FaceUserData.jdField_e_of_type_JavaLangString)))
        {
          localObject = localFace2FaceUserData;
          if (QLog.isColorLevel())
          {
            localObject = localFace2FaceUserData;
            if (!TextUtils.isEmpty(localFace2FaceUserData.jdField_e_of_type_JavaLangString)) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "getHasShowFriendData可替换好友" + localFace2FaceUserData.jdField_e_of_type_JavaLangString.substring(0, 4));
            }
          }
        }
      }
    }
    for (localObject = localFace2FaceUserData;; localObject = null)
    {
      if ((localObject == null) && (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getHasShowFriendData 没有可替换好友");
      }
      return localObject;
    }
  }
  
  private List a(List paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty()) || (paramInt < 1)) {
      return localArrayList;
    }
    Object localObject = paramList.iterator();
    do
    {
      Face2FaceUserData localFace2FaceUserData;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localFace2FaceUserData = (Face2FaceUserData)((Iterator)localObject).next();
      } while (a(localFace2FaceUserData.jdField_e_of_type_JavaLangString));
      localArrayList.add(localFace2FaceUserData);
    } while (localArrayList.size() != paramInt);
    if (localArrayList.size() < paramInt)
    {
      paramList = paramList.iterator();
      do
      {
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (Face2FaceUserData)paramList.next();
        } while (!a(((Face2FaceUserData)localObject).jdField_e_of_type_JavaLangString));
        localArrayList.add(localObject);
      } while (localArrayList.size() != paramInt);
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyNeedReplace ask replace type" + paramInt);
    }
    Face2FaceUserData localFace2FaceUserData2 = d();
    Face2FaceUserData localFace2FaceUserData1 = f();
    if (paramInt == 1) {
      if (localFace2FaceUserData2 != null)
      {
        localFace2FaceUserData1 = localFace2FaceUserData2;
        if (localFace2FaceUserData1 == null) {
          break label125;
        }
        e(localFace2FaceUserData1);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyNeedReplace replaceData type" + localFace2FaceUserData1.jdField_a_of_type_Int);
        }
      }
    }
    label125:
    while (!QLog.isColorLevel())
    {
      return;
      if (localFace2FaceUserData1 != null)
      {
        break;
        if (localFace2FaceUserData1 != null) {
          break;
        }
        localFace2FaceUserData1 = localFace2FaceUserData2;
        if (localFace2FaceUserData2 != null) {
          break;
        }
      }
      localFace2FaceUserData1 = null;
      break;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyNeedReplace no data can replace");
  }
  
  private void a(int paramInt, String paramString)
  {
    if (!paramString.equals(this.jdField_f_of_type_JavaLangString)) {}
    TextView localTextView;
    Button localButton;
    do
    {
      return;
      localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131297647);
      LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131297648);
      localButton = (Button)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131297656);
      if (paramInt == 3)
      {
        this.jdField_f_of_type_Boolean = true;
        a(localTextView, "请求添加你为好友");
        a(localButton, "同意并加为好友");
        localButton.setOnClickListener(new iia(this, paramString));
        return;
      }
      if (paramInt == 2)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          paramString = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          if (!TextUtils.isEmpty(paramString)) {
            ((TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131297646)).setText(paramString);
          }
        }
        a(localTextView, "已经是你的好友");
        localLinearLayout.setVisibility(8);
        return;
      }
    } while (paramInt != 4);
    a(localTextView, "等待好友确认");
    a(localButton, "加好友");
  }
  
  private void a(int paramInt, String paramString1, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, String paramString2, Bitmap paramBitmap)
  {
    this.jdField_f_of_type_JavaLangString = paramString1;
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131297648);
    a((TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131297646), paramString2);
    ((ImageView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131297644)).setImageBitmap(paramBitmap);
    paramBitmap = (TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131297647);
    Button localButton = (Button)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131297656);
    paramString2 = "";
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1)) {
      paramString2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString2);
    if (!TextUtils.isEmpty(paramString2)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramString2.length());
    }
    this.jdField_h_of_type_Boolean = true;
    if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString1)) {
      this.J = ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString1)).intValue();
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.J));
    this.jdField_g_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_g_of_type_JavaLangString, 3021, 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new ihw(this));
    localButton.setOnClickListener(new ihx(this, paramString1));
    if (paramInt == 2)
    {
      a(paramBitmap, "已经是你的好友");
      localLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      paramString2 = new ihz(this, paramString1);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, paramFace2FaceFriendBubbleView, paramString1, this.jdField_a_of_type_JavaUtilHashMap, paramString2);
      return;
      if ((paramInt == 4) || (paramInt == 1))
      {
        if (paramInt == 4) {
          a(paramBitmap, "等待好友确认中...");
        }
        for (;;)
        {
          a(localButton, "加好友");
          localLinearLayout.setVisibility(0);
          break;
          a(paramBitmap, "");
        }
      }
      if (paramInt == 3)
      {
        this.jdField_f_of_type_Boolean = true;
        a(paramBitmap, "请求添加你为好友");
        localLinearLayout.setVisibility(0);
        a(localButton, "同意并加为好友");
        localButton.setOnClickListener(new ihy(this, paramString1));
      }
    }
  }
  
  private void a(long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_Iis.obtainMessage(7);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendDelayAskRequest delaytime=" + paramLong);
    }
    this.jdField_a_of_type_Iis.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
    paramTextView.setContentDescription(paramString);
  }
  
  private void a(String paramString)
  {
    new ArrayList();
    Object localObject = this.app.a().a(AppConstants.aj, 0);
    structmsg.StructMsg localStructMsg = null;
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "systemMsgList is null");
      }
    }
    int i1;
    label139:
    long l1;
    long l2;
    int i2;
    int i3;
    int i4;
    int i5;
    do
    {
      do
      {
        return;
        if ((((List)localObject).size() <= 0) || ((((List)localObject).get(0) instanceof MessageForSystemMsg))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "systemMsgList error");
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "answerAddFriend systemMsgList size" + ((List)localObject).size());
      }
      i1 = ((List)localObject).size() - 1;
      if (i1 >= 0)
      {
        localStructMsg = ((MessageForSystemMsg)((List)localObject).get(i1)).getSystemMsg();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "answerAddFriend structMsg.req_uin =" + String.valueOf(localStructMsg.req_uin.get()) + "friendUin=" + paramString);
        }
        if (!paramString.equals(String.valueOf(localStructMsg.req_uin.get()))) {
          break;
        }
      }
      if ((localStructMsg == null) || (!paramString.equals(String.valueOf(localStructMsg.req_uin.get())))) {
        break label522;
      }
      i1 = localStructMsg.msg_type.get();
      l1 = localStructMsg.msg_seq.get();
      l2 = localStructMsg.req_uin.get();
      i2 = localStructMsg.msg.sub_type.get();
      i3 = localStructMsg.msg.src_id.get();
      i4 = localStructMsg.msg.sub_src_id.get();
      i5 = localStructMsg.msg.group_msg_type.get();
      localObject = localStructMsg.msg.actions.get();
    } while ((localObject == null) || (((List)localObject).size() >= 0));
    int i6 = this.J;
    paramString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get();
      ((structmsg.SystemMsgActionInfo)localObject).remark.set(paramString);
      ((structmsg.SystemMsgActionInfo)localObject).group_id.set(i6);
      this.app.a().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)localObject, 0, localStructMsg, false);
      a(localStructMsg, localStructMsg.msg_seq.get());
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "answerAddFriend  structMsg.req_uin:  " + String.valueOf(localStructMsg.req_uin.get()));
      return;
      i1 -= 1;
      break label139;
      label522:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "answerAddFriend  structMsg == null | , friendUin == structMsg.req_uin | ");
      return;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = a(paramString, 1);
    if (localFace2FaceFriendBubbleView != null)
    {
      localFace2FaceFriendBubbleView.setStatusWithAnimation(paramInt);
      if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        this.jdField_c_of_type_JavaUtilHashMap.remove(paramString);
        this.jdField_c_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
      }
    }
    else
    {
      return;
    }
    this.jdField_c_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l1 = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      FriendSystemMsgController.a().a(Long.valueOf(l1), (structmsg.StructMsg)paramStructMsg.get());
      FriendSystemMsgController.a().b(l1);
      FriendSystemMsgController.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "delayPushToUI mShowdataList.size()=" + this.jdField_d_of_type_JavaUtilList.size() + "ispush=" + paramBoolean1 + "changeIndex" + paramInt + "isReplash=" + paramBoolean2);
    }
    int i1 = this.t;
    if (paramBoolean1) {}
    for (;;)
    {
      if (paramInt < this.jdField_d_of_type_JavaUtilList.size())
      {
        Message localMessage = this.jdField_a_of_type_Iis.obtainMessage();
        localMessage.what = 4;
        Object localObject = new Bundle();
        ((Bundle)localObject).putBoolean("key_data _ispush", paramBoolean1);
        ((Bundle)localObject).putBoolean("key_data _hasfriend", paramBoolean2);
        localMessage.setData((Bundle)localObject);
        localMessage.arg1 = paramInt;
        localObject = (Face2FaceUserData)this.jdField_d_of_type_JavaUtilList.get(paramInt);
        localMessage.arg2 = ((Face2FaceUserData)localObject).jdField_a_of_type_Int;
        localMessage.obj = localObject;
        if (this.jdField_a_of_type_Iis.hasMessages(4)) {
          this.jdField_a_of_type_Iis.removeMessages(4);
        }
        this.jdField_a_of_type_Iis.sendMessageDelayed(localMessage, A);
      }
      return;
      paramInt = i1;
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if (paramString.equals(this.app.a()))
    {
      QQToast.a(this, 2131366963, 0).b(getTitleBarHeight());
      return false;
    }
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
        if (localFriendManager != null)
        {
          paramString = localFriendManager.c(paramString);
          if ((paramString == null) || (paramString.groupid < 0)) {
            break;
          }
          QQToast.a(this.app.getApplication(), 2131366964, 0).b(getTitleBarHeight());
          return false;
        }
      }
      catch (Throwable paramString)
      {
        return false;
      }
      paramString = null;
    }
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this.app.getApplication(), 2131367328, 0).b(getTitleBarHeight());
      return false;
    }
    return true;
  }
  
  private boolean a(Face2FaceUserData paramFace2FaceUserData)
  {
    if (paramFace2FaceUserData == null) {}
    while (((paramFace2FaceUserData.jdField_a_of_type_Int != 1) || (!b(paramFace2FaceUserData.jdField_e_of_type_JavaLangString))) && ((paramFace2FaceUserData.jdField_a_of_type_Int != 2) || (!a(paramFace2FaceUserData.jdField_e_of_type_JavaLangString)))) {
      return false;
    }
    return true;
  }
  
  private Face2FaceUserData b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)localIterator.next();
      if ((!this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a()) || (!this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a.equals(localFace2FaceUserData)))
      {
        if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localFace2FaceUserData))) {
          return localFace2FaceUserData;
        }
        if ((localFace2FaceUserData.jdField_a_of_type_Int == 2) && (a(localFace2FaceUserData.jdField_e_of_type_JavaLangString))) {
          return localFace2FaceUserData;
        }
      }
    }
    return null;
  }
  
  private List b(List paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty()) || (paramInt < 1)) {
      return localArrayList;
    }
    Object localObject = paramList.iterator();
    do
    {
      Face2FaceUserData localFace2FaceUserData;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localFace2FaceUserData = (Face2FaceUserData)((Iterator)localObject).next();
      } while (b(localFace2FaceUserData.jdField_e_of_type_JavaLangString));
      localArrayList.add(localFace2FaceUserData);
    } while (localArrayList.size() != paramInt);
    if (localArrayList.size() < paramInt)
    {
      paramList = paramList.iterator();
      do
      {
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (Face2FaceUserData)paramList.next();
        } while (!b(((Face2FaceUserData)localObject).jdField_e_of_type_JavaLangString));
        localArrayList.add(localObject);
      } while (localArrayList.size() != paramInt);
    }
    return localArrayList;
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(new ihs(paramQQAppInterface));
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "sendReadConfirm is end!");
    }
  }
  
  private boolean b()
  {
    if (this.jdField_b_of_type_Int == 1) {}
    for (String str = "sp_facetoface_showguide_for_troop";; str = "sp_facetoface_showguide")
    {
      localObject = this.app.a().getSharedPreferences(this.app.a(), 0);
      if (localObject != null) {
        break;
      }
      return false;
    }
    this.o = ((SharedPreferences)localObject).getBoolean(str, false);
    if (this.o) {
      return false;
    }
    Object localObject = LayoutInflater.from(getApplicationContext()).inflate(2130903186, null);
    Button localButton = (Button)((View)localObject).findViewById(2131297261);
    ((View)localObject).setBackgroundResource(2130838336);
    ((View)localObject).setOnClickListener(this);
    if (this.jdField_b_of_type_Int == 1) {
      ((TextView)((View)localObject).findViewById(2131297260)).setText(2131364173);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject, new LinearLayout.LayoutParams(-1, -1));
    localButton.setOnClickListener(new iii(this, str, (View)localObject));
    return true;
  }
  
  private boolean b(String paramString)
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.app.getManager(8);
    if ((localFriendsManagerImp != null) && (!TextUtils.isEmpty(paramString))) {
      return localFriendsManagerImp.b(paramString);
    }
    return false;
  }
  
  private Face2FaceUserData c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)localIterator.next();
      if ((localFace2FaceUserData != null) && (b(localFace2FaceUserData.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localFace2FaceUserData))) {
        return localFace2FaceUserData;
      }
    }
    return null;
  }
  
  private boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addFriend uin is null");
      }
    }
    do
    {
      return false;
      this.jdField_g_of_type_JavaLangString = paramString;
    } while (!a(1, paramString));
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString))) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addFriend uin" + paramString.substring(0, 4));
    }
    ((FriendListHandler)this.app.a(1)).a("OidbSvc.0x476_147", Long.parseLong(paramString), 147);
    return true;
  }
  
  private Face2FaceUserData d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)localIterator.next();
      if ((localFace2FaceUserData != null) && (!b(localFace2FaceUserData.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localFace2FaceUserData))) {
        return localFace2FaceUserData;
      }
    }
    return null;
  }
  
  private void d(Face2FaceUserData paramFace2FaceUserData)
  {
    if ((this.jdField_d_of_type_JavaUtilList == null) || (paramFace2FaceUserData == null)) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI mNeedShowList= nuull  pushData = null!");
    }
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
              QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI mShowdataList=" + this.jdField_d_of_type_JavaUtilList.size() + "currentFriendIndex=" + this.t + "showtype=pushData.type=" + paramFace2FaceUserData.jdField_a_of_type_Int + "mFriendDataList.size()" + this.jdField_a_of_type_JavaUtilList.size() + "troop size" + this.jdField_b_of_type_JavaUtilList.size());
            }
          } while (this.jdField_d_of_type_JavaUtilList.contains(paramFace2FaceUserData));
          if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI face2FaceAddFriendAnim has null");
        return;
        if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() <= 10) {
          break;
        }
      } while (a(paramFace2FaceUserData));
      if (this.jdField_b_of_type_Int == 0)
      {
        e(paramFace2FaceUserData);
        this.jdField_g_of_type_Boolean = true;
        return;
      }
      e(paramFace2FaceUserData);
      return;
      if ((this.jdField_d_of_type_JavaUtilList.size() == 0) && (!this.i))
      {
        this.jdField_d_of_type_JavaUtilList.add(paramFace2FaceUserData);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI mShowdataList=" + this.jdField_d_of_type_JavaUtilList.size() + "currentFriendIndex=" + this.t + "hasData" + this.i);
        }
        this.i = true;
        return;
      }
      this.jdField_d_of_type_JavaUtilList.add(paramFace2FaceUserData);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToUI mShowdataList=" + this.jdField_d_of_type_JavaUtilList.size() + "currentFriendIndex=" + this.t);
      }
    } while (this.jdField_d_of_type_JavaUtilList.size() != this.t + 1);
    a(true, this.t, false);
  }
  
  private Face2FaceUserData e()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)localIterator.next();
      if ((localFace2FaceUserData != null) && (a(localFace2FaceUserData.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localFace2FaceUserData))) {
        return localFace2FaceUserData;
      }
    }
    return null;
  }
  
  private void e(Face2FaceUserData paramFace2FaceUserData)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    int i2 = 0;
    int i1 = 0;
    if (((Iterator)localObject1).hasNext())
    {
      int i3;
      if (((Face2FaceUserData)((Iterator)localObject1).next()).jdField_a_of_type_Int == 1)
      {
        i3 = i2;
        i2 = i1 + 1;
      }
      for (i1 = i3;; i1 = i3)
      {
        i3 = i2;
        i2 = i1;
        i1 = i3;
        break;
        i3 = i2 + 1;
        i2 = i1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToReplace 显示列表 mfriendCount=" + i1 + "mtroopCount=" + i2);
    }
    localObject1 = a();
    Object localObject2 = b();
    if (paramFace2FaceUserData.jdField_a_of_type_Int == 1)
    {
      if (localObject1 != null) {}
      label264:
      for (;;)
      {
        label153:
        if (localObject1 != null)
        {
          localObject2 = ((Face2FaceUserData)localObject1).jdField_e_of_type_JavaLangString;
          if ((localObject1 instanceof Face2FaceGroupProfile)) {
            localObject2 = ((Face2FaceUserData)localObject1).jdField_e_of_type_JavaLangString + "_" + ((Face2FaceGroupProfile)localObject1).jdField_b_of_type_JavaLangString;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToReplace rRplaceData!=null && replace type=" + ((Face2FaceUserData)localObject1).jdField_a_of_type_Int);
          }
          this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a((String)localObject2);
          if (this.jdField_b_of_type_Int == 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a((Face2FaceUserData)localObject1, bool);
            i1 = a((Face2FaceUserData)localObject1);
            if ((i1 == -1) || (i1 >= this.jdField_d_of_type_JavaUtilList.size())) {
              break;
            }
            this.jdField_d_of_type_JavaUtilList.set(i1, paramFace2FaceUserData);
            a(true, i1, true);
            return;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              continue;
            }
            if ((i1 >= 5) || (i2 <= 5) || (this.jdField_b_of_type_Int != 0)) {
              break label549;
            }
            i1 = 0;
            localObject2 = null;
            label354:
            localObject1 = localObject2;
            if (i1 >= this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) {
              continue;
            }
            localObject1 = (Face2FaceUserData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i1);
            if ((localObject1 == null) || (((Face2FaceUserData)localObject1).jdField_a_of_type_Int != 2) || (a(((Face2FaceUserData)localObject1).jdField_e_of_type_JavaLangString))) {
              break label555;
            }
          }
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      localObject2 = localObject1;
      break label354;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        break label153;
      }
      if (localObject1 != null) {
        break label153;
      }
      if ((i1 > 5) && (i2 < 5))
      {
        i1 = 0;
        localObject2 = null;
        label454:
        localObject1 = localObject2;
        if (i1 >= this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) {
          break label153;
        }
        localObject1 = (Face2FaceUserData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i1);
        if ((localObject1 != null) && (((Face2FaceUserData)localObject1).jdField_a_of_type_Int == 1) && (!b(((Face2FaceUserData)localObject1).jdField_e_of_type_JavaLangString))) {}
        for (;;)
        {
          i1 += 1;
          localObject2 = localObject1;
          break label454;
          bool = true;
          break label264;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "pushDataToReplace rRplaceData=null 没有可以替换的数据");
          return;
          localObject1 = localObject2;
        }
      }
      label549:
      localObject1 = null;
      break label153;
      label555:
      localObject1 = localObject2;
    }
  }
  
  private Face2FaceUserData f()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)localIterator.next();
      if ((localFace2FaceUserData != null) && (!a(localFace2FaceUserData.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(localFace2FaceUserData))) {
        return localFace2FaceUserData;
      }
    }
    return null;
  }
  
  private void j()
  {
    this.n = true;
    g();
    this.jdField_a_of_type_Iis.sendEmptyMessageDelayed(3, 0L);
    a();
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendHeartRequest");
    }
    Message localMessage = this.jdField_a_of_type_Iis.obtainMessage(5);
    this.jdField_a_of_type_Iis.sendMessageDelayed(localMessage, B);
  }
  
  private void l()
  {
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297236));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297237));
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(1500L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    m();
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView = new SnowView(this);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView.setSnowView(this.jdField_a_of_type_AndroidGraphicsPoint);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView);
    localObject = getLayoutInflater();
    View localView = ((LayoutInflater)localObject).inflate(2130903309, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localView);
    localObject = ((LayoutInflater)localObject).inflate(2130903310, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView = ((Face2FaceTroopDetailView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131297657));
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView = ((Face2FaceFriendDetailView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131297642));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131297651));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131297654));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131297653));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131297650));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new iib(this));
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.setInfc(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.setInfc(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131297238);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297239));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297240));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(this);
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131366212);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void m()
  {
    View localView = LayoutInflater.from(getApplicationContext()).inflate(2130903185, null);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim = new Face2FaceAddFriendAnim(this.app, this);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(this.app, localView, this.jdField_b_of_type_Int, this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localView);
    this.jdField_d_of_type_AndroidViewView = localView;
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131297247);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297248));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297246));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131369991);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      localView.findViewById(2131297245).setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  private void n()
  {
    if (QLog.isColorLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList isFriendDataBack=" + this.jdField_b_of_type_Boolean + "isTroopDataBack=" + this.jdField_c_of_type_Boolean);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList isFriendBackSuccess=" + this.y + "isTroopBackSuccess=" + this.z);
    }
    if ((this.y == 0) || (this.z == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList return wait successStatus");
      }
    }
    int i1;
    int i2;
    do
    {
      do
      {
        do
        {
          return;
          if ((this.y != 1) || (this.z != 1) || ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList return");
        return;
        if (!this.jdField_d_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList return has merged");
      return;
      i1 = this.jdField_a_of_type_JavaUtilList.size();
      i2 = this.jdField_b_of_type_JavaUtilList.size();
      this.jdField_d_of_type_Boolean = true;
      this.D += i1;
      this.E += i2;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList mFriendSize=" + i1 + "mTroopSize=" + i2);
      }
    } while (i1 + i2 == 0);
    Object localObject;
    if (i1 + i2 > 10) {
      if ((i1 >= 5) && (i2 >= 5))
      {
        localObject = new ArrayList(b(this.jdField_a_of_type_JavaUtilList, 5));
        ArrayList localArrayList = new ArrayList(a(this.jdField_b_of_type_JavaUtilList, 5));
        a(this.jdField_d_of_type_JavaUtilList, (List)localObject);
        a(this.jdField_d_of_type_JavaUtilList, localArrayList);
        label360:
        localObject = this.jdField_d_of_type_JavaUtilList.iterator();
        i1 = 0;
        label372:
        if (!((Iterator)localObject).hasNext()) {
          break label508;
        }
        if (!a((Face2FaceUserData)((Iterator)localObject).next())) {
          break label620;
        }
        i1 += 1;
      }
    }
    label620:
    for (;;)
    {
      break label372;
      if (i1 < 5)
      {
        this.jdField_d_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
        localObject = new ArrayList(a(this.jdField_b_of_type_JavaUtilList, 10 - this.jdField_a_of_type_JavaUtilList.size()));
        a(this.jdField_d_of_type_JavaUtilList, (List)localObject);
        break label360;
      }
      if (i2 >= 5) {
        break label360;
      }
      localObject = new ArrayList(b(this.jdField_a_of_type_JavaUtilList, 10 - this.jdField_b_of_type_JavaUtilList.size()));
      a(this.jdField_d_of_type_JavaUtilList, (List)localObject);
      break label360;
      label508:
      i2 = 0;
      label510:
      if ((i2 >= i1) || (!a())) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeShowList size=" + this.jdField_d_of_type_JavaUtilList.size());
        }
        this.i = true;
        if (this.t <= 0) {
          break;
        }
        a(false, this.t, false);
        return;
        i2 += 1;
        break label510;
        a(this.jdField_d_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList);
        a(this.jdField_d_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      }
    }
  }
  
  private void o()
  {
    ((FriendListHandler)this.app.a(1)).a(this.jdField_g_of_type_JavaLangString, 3021, "");
  }
  
  private void p()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)this.app.getManager(33));
        this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.addObserver(this);
      }
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearFieldTroopObserver);
  }
  
  private void q()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.deleteObserver(this);
        this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = null;
      }
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearFieldTroopObserver);
  }
  
  private void r()
  {
    if ((!this.app.d()) && (!this.app.k()) && (!this.app.l()) && (this.app.m()) && (this.m)) {
      AudioUtil.b(2131165197, false);
    }
  }
  
  private void s()
  {
    ThreadManager.b(new iic(this));
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "findReplaceData ");
    }
    Face2FaceUserData localFace2FaceUserData2 = d();
    Face2FaceUserData localFace2FaceUserData3 = f();
    Face2FaceUserData localFace2FaceUserData1 = c();
    Face2FaceUserData localFace2FaceUserData4 = e();
    if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() < 10) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "findReplaceData friend count=" + this.jdField_a_of_type_JavaUtilList.size() + "troop count" + this.jdField_b_of_type_JavaUtilList.size());
      }
    }
    label198:
    for (;;)
    {
      return;
      if (localFace2FaceUserData3 != null) {
        localFace2FaceUserData1 = localFace2FaceUserData3;
      }
      for (;;)
      {
        if (localFace2FaceUserData1 == null) {
          break label198;
        }
        this.jdField_d_of_type_JavaUtilList.add(localFace2FaceUserData1);
        if (this.jdField_d_of_type_JavaUtilList.size() != this.t + 1) {
          break;
        }
        a(true, this.t, false);
        return;
        if (localFace2FaceUserData2 != null) {
          localFace2FaceUserData1 = localFace2FaceUserData2;
        } else if ((localFace2FaceUserData4 == null) && (localFace2FaceUserData1 == null)) {
          localFace2FaceUserData1 = null;
        }
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() < this.jdField_d_of_type_JavaUtilList.size()) {}
    for (int i1 = (this.jdField_d_of_type_JavaUtilList.size() - this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) * 500 + 2500;; i1 = 2000)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getReplaceDelay=" + i1);
      }
      return i1;
    }
  }
  
  public int a(long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    return jdField_a_of_type_JavaUtilCalendar.get(11);
  }
  
  public int a(long paramLong1, long paramLong2)
  {
    return (int)((paramLong1 - paramLong2) / 1000L / 60L);
  }
  
  public String a(int paramInt)
  {
    Groups localGroups = ((FriendManager)this.app.getManager(8)).a(paramInt + "");
    if (localGroups != null) {
      return localGroups.group_name;
    }
    return "";
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "openFace2FaceTroop, from_type=" + this.jdField_b_of_type_Int + ", fromTroopUin=" + this.jdField_e_of_type_JavaLangString);
    }
    NearFieldTroopHandler localNearFieldTroopHandler = (NearFieldTroopHandler)this.app.a(57);
    if ((localNearFieldTroopHandler == null) || (this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "openFace2FaceTroop, getBusinessHandler==null");
      }
      return;
    }
    if (!NetworkUtil.e(this))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "openFace2FaceTroop, NetworkUtil.isNetSupport==false");
      }
      QQToast.a(this.app.getApplication(), 2131367328, 0).b(getTitleBarHeight());
      return;
    }
    ThreadManager.a(new iho(this, localNearFieldTroopHandler));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.i)
    {
      if (this.j == true) {
        this.j = false;
      }
      this.i = false;
      a(false, this.t, false);
    }
    do
    {
      return;
      if ((paramInt == 1) && (this.j))
      {
        this.jdField_a_of_type_Iis.sendEmptyMessageDelayed(3, 0L);
        return;
      }
    } while (!paramBoolean);
    this.jdField_a_of_type_Iis.sendEmptyMessageDelayed(8, 0L);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    int i2 = a(paramLong1);
    int i3 = (int)((paramLong1 - paramLong2) / 1000L / 60L);
    int i1;
    if ((i2 >= 5) && (i2 < 11))
    {
      i1 = 4;
      if (i3 < 6) {
        break label300;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (i1)
      {
      default: 
        label84:
        this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
        this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new iif(this));
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "startBkAnim 本次进入时间点：" + i2 + "和上一次时间差" + i3 + "小时");
      }
      return;
      if ((i2 >= 11) && (i2 < 17))
      {
        i1 = 1;
        break;
      }
      if ((i2 >= 17) && (i2 < 23))
      {
        i1 = 2;
        break;
      }
      i1 = 3;
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838336);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838335);
      break label84;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838335);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838337);
      break label84;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838337);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838334);
      break label84;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838334);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838336);
      break label84;
      label300:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      switch (i1)
      {
      default: 
        break;
      case 1: 
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838335);
        break;
      case 2: 
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838337);
        break;
      case 3: 
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838334);
        break;
      case 4: 
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838336);
      }
    }
  }
  
  public void a(Face2FaceGroupProfile paramFace2FaceGroupProfile)
  {
    if (paramFace2FaceGroupProfile == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "deleteGroupData mhasShowList = " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramFace2FaceGroupProfile))
    {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(paramFace2FaceGroupProfile, true);
      String str = paramFace2FaceGroupProfile.jdField_e_of_type_JavaLangString + "_" + paramFace2FaceGroupProfile.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(str);
      this.jdField_d_of_type_JavaUtilList.remove(paramFace2FaceGroupProfile);
      this.jdField_b_of_type_JavaUtilList.remove(paramFace2FaceGroupProfile);
      if (this.t > 0) {
        this.t -= 1;
      }
      t();
      return;
    }
    this.jdField_b_of_type_JavaUtilList.remove(paramFace2FaceGroupProfile);
  }
  
  public void a(Face2FaceUserData paramFace2FaceUserData)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 14;
    localMessage.obj = paramFace2FaceUserData;
    this.jdField_a_of_type_Iis.sendMessageDelayed(localMessage, 2000L);
  }
  
  public void a(Face2FaceUserData paramFace2FaceUserData, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onADDShowData isPush" + paramBoolean1 + "currentFriendIndex=" + this.t + "isFilterShow=hasFriend=" + paramBoolean2);
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramFace2FaceUserData);
  }
  
  public void a(Face2FaceUserProfile paramFace2FaceUserProfile)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim == null) || (paramFace2FaceUserProfile == null)) {}
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(paramFace2FaceUserProfile.jdField_e_of_type_JavaLangString);
    } while (localObject1 == null);
    Object localObject2 = getResources().getDisplayMetrics();
    int i1 = ((DisplayMetrics)localObject2).widthPixels / 2;
    int i2 = ((View)localObject1).getLeft();
    int i3 = ((View)localObject1).getWidth() / 2;
    int i4 = ((DisplayMetrics)localObject2).heightPixels / 2;
    int i5 = ((View)localObject1).getTop();
    int i6 = ((View)localObject1).getHeight() / 2;
    localObject2 = new TranslateAnimation(0.0F, i1 - i2 - i3, 0.0F, i4 - i5 - i6);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F, 1, 0.5F, 1, 0.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.2F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setDuration(1000L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation((Animation)localObject2);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new iik(this, (View)localObject1));
    ((View)localObject1).setClickable(false);
    ((View)localObject1).startAnimation(localAnimationSet);
    Object localObject1 = Message.obtain();
    ((Message)localObject1).what = 15;
    ((Message)localObject1).obj = paramFace2FaceUserProfile;
    this.jdField_a_of_type_Iis.sendMessageDelayed((Message)localObject1, 1500L);
  }
  
  public void a(List paramList1, List paramList2)
  {
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      Face2FaceUserData localFace2FaceUserData = (Face2FaceUserData)paramList2.next();
      if (!paramList1.contains(localFace2FaceUserData)) {
        paramList1.add(localFace2FaceUserData);
      }
    }
  }
  
  public boolean a()
  {
    Face2FaceUserData localFace2FaceUserData2;
    int i1;
    label168:
    do
    {
      Face2FaceUserData localFace2FaceUserData1;
      do
      {
        Iterator localIterator1 = this.jdField_d_of_type_JavaUtilList.iterator();
        break label168;
        break label168;
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          do
          {
            do
            {
              if (!localIterator1.hasNext()) {
                break label247;
              }
              localFace2FaceUserData1 = (Face2FaceUserData)localIterator1.next();
              if ((localFace2FaceUserData1.jdField_a_of_type_Int != 1) || (!b(localFace2FaceUserData1.jdField_e_of_type_JavaLangString))) {
                break;
              }
              localIterator2 = this.jdField_b_of_type_JavaUtilList.iterator();
            } while (!localIterator2.hasNext());
            localFace2FaceUserData2 = (Face2FaceUserData)localIterator2.next();
            if ((this.jdField_d_of_type_JavaUtilList.contains(localFace2FaceUserData2)) || (a(localFace2FaceUserData2.jdField_e_of_type_JavaLangString))) {
              break;
            }
            i1 = this.jdField_d_of_type_JavaUtilList.indexOf(localFace2FaceUserData1);
            if (i1 == -1) {
              break;
            }
            this.jdField_d_of_type_JavaUtilList.set(i1, localFace2FaceUserData2);
            return true;
          } while ((localFace2FaceUserData1.jdField_a_of_type_Int != 2) || (!a(localFace2FaceUserData1.jdField_e_of_type_JavaLangString)));
          localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
        }
        localFace2FaceUserData2 = (Face2FaceUserData)localIterator2.next();
      } while ((this.jdField_d_of_type_JavaUtilList.contains(localFace2FaceUserData2)) || (b(localFace2FaceUserData2.jdField_e_of_type_JavaLangString)));
      i1 = this.jdField_d_of_type_JavaUtilList.indexOf(localFace2FaceUserData1);
    } while (i1 == -1);
    this.jdField_d_of_type_JavaUtilList.set(i1, localFace2FaceUserData2);
    return true;
    label247:
    return false;
  }
  
  public boolean a(Face2FaceUserData paramFace2FaceUserData, List paramList)
  {
    boolean bool = false;
    if (paramList.contains(paramFace2FaceUserData))
    {
      if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramFace2FaceUserData.jdField_e_of_type_JavaLangString))) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "datalist has contains data" + paramFace2FaceUserData.jdField_e_of_type_JavaLangString.substring(0, 4));
      }
      bool = true;
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
    if (localFriendManager != null) {}
    for (paramString = localFriendManager.a(paramString + "");; paramString = null)
    {
      if (paramString != null) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    if (this.app != null) {
      this.app.a(paramBusinessObserver);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "closeFace2faceTroop, from_type=" + this.jdField_b_of_type_Int + ", fromTroopUin=" + this.jdField_e_of_type_JavaLangString);
    }
    NearFieldTroopHandler localNearFieldTroopHandler = (NearFieldTroopHandler)this.app.a(57);
    if (localNearFieldTroopHandler == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "closeFace2faceTroop, getBusinessHandler==null");
      }
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Int != 1) {
        break;
      }
    } while (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString));
    localNearFieldTroopHandler.a(Long.valueOf(this.jdField_e_of_type_JavaLangString).longValue(), 1);
    return;
    localNearFieldTroopHandler.a(0L, 1);
  }
  
  public void b(Face2FaceUserData paramFace2FaceUserData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim == null) || (paramFace2FaceUserData == null) || (this.jdField_a_of_type_Iis == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_Iis.removeMessages(14, paramFace2FaceUserData);
      paramFace2FaceUserData = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(paramFace2FaceUserData.jdField_e_of_type_JavaLangString);
    } while (paramFace2FaceUserData == null);
    paramFace2FaceUserData.setAnimation(new AlphaAnimation(1.0F, 1.0F));
  }
  
  public void b(Face2FaceUserData paramFace2FaceUserData, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.t += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onInAnimEnd isPush" + paramBoolean1 + "currentFriendIndex=" + this.t + "isFilterShow=hasFriend=" + paramBoolean2);
    }
    a(paramBoolean1, this.t, false);
    if (this.jdField_b_of_type_Int == 1) {
      a(paramFace2FaceUserData);
    }
  }
  
  public void c()
  {
    this.l = true;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      localObject = LayoutInflater.from(getApplicationContext());
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2130903313, null);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297670));
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131297671);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(localView);
      localObject = ((LayoutInflater)localObject).inflate(2130903311, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131297666));
      this.jdField_a_of_type_ComTencentWidgetXListView.a((View)localObject);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297669);
      ((TextView)localObject).setOnClickListener(this);
      ((TextView)localObject).setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter = new Face2FaceTroopFriendListAdapter(this, this.jdField_a_of_type_ComTencentWidgetXListView);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter.getCount()));
      localObject = AnimationUtils.loadAnimation(this, 2130968586);
      this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void c(Face2FaceUserData paramFace2FaceUserData)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramFace2FaceUserData)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramFace2FaceUserData);
    }
  }
  
  public void d()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130968584);
    localAnimation.setAnimationListener(new iih(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
    e();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramInt1 = paramIntent.getByteExtra("result", (byte)0);
    this.J = paramInt1;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(paramInt1));
    this.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_f_of_type_JavaLangString, Integer.valueOf(this.J));
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView != null) && (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.b();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView != null) && (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.b();
      return;
    }
    if ((this.l) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      d();
      return;
    }
    if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_Boolean))
    {
      DialogUtil.a(this, 230, getString(2131367300), getString(2131364174), 2131365736, 2131366212, new iht(this), new ihu(this)).show();
      return;
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewNoTitle(2130903184);
    this.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_b_of_type_Int = getIntent().getIntExtra("activity_from_type", 0);
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("activity_troop_uin");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnCreate, from_type=" + this.jdField_b_of_type_Int + ", fromTroopUin=" + this.jdField_e_of_type_JavaLangString);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131296742));
    this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = ((LBSHandler)this.app.a(3));
    jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    l();
    p();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (FriendSystemMsgController.a().a(this.app) == 0) {}
    for (this.jdField_e_of_type_Boolean = true; b(); this.jdField_e_of_type_Boolean = false)
    {
      this.n = false;
      return true;
    }
    j();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    q();
    s();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Face2FaceAddFriendActivity doOnDestroy");
    }
    this.p = true;
    Face2FaceAddFriendConstants.c = System.currentTimeMillis();
    b();
    this.jdField_a_of_type_Iis.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Iis.removeMessages(5);
    this.jdField_a_of_type_Iis.removeMessages(7);
    this.jdField_a_of_type_Iis.removeMessages(9);
    this.jdField_a_of_type_Iis.removeMessages(4);
    this.jdField_a_of_type_Iis.removeMessages(11);
    if (this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.b(this.app.a());
    }
    for (;;)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a();
      if (this.jdField_g_of_type_Boolean) {
        ReportController.b(null, "CliOper", "", "", "0X80050F2", "0X80050F2", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter.b();
      }
      ReportController.b(null, "CliOper", "", "", "0X80050EC", "0X80050EC", 0, 0, String.valueOf(this.D), String.valueOf(this.E), "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnDestroy mLbsHandler is null");
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doOnPause!");
    }
    this.m = false;
    AudioUtil.a(this, false);
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doOnResume!");
    }
    super.doOnResume();
    this.m = true;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    AudioUtil.a(this, true);
    g();
    f();
    Face2FaceAddFriendConstants.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "face2face doOnStart inface2faceTime=" + a(Face2FaceAddFriendConstants.jdField_a_of_type_Long) + "showBkAnim=" + this.n);
    }
    if (this.n)
    {
      if (Face2FaceAddFriendConstants.jdField_a_of_type_Long >= Face2FaceAddFriendConstants.jdField_b_of_type_Long) {
        a(Face2FaceAddFriendConstants.jdField_a_of_type_Long, Face2FaceAddFriendConstants.jdField_b_of_type_Long);
      }
    }
    else {
      return;
    }
    a(Face2FaceAddFriendConstants.jdField_a_of_type_Long, 0L);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doOnStop!");
    }
    h();
    this.jdField_a_of_type_Iis.removeMessages(4);
    Face2FaceAddFriendConstants.jdField_b_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "face2face doOnStop outface2faceTime=" + a(Face2FaceAddFriendConstants.jdField_b_of_type_Long));
    }
  }
  
  public void e()
  {
    int i1 = this.jdField_a_of_type_JavaUtilList.size();
    if (i1 > 0)
    {
      if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() != 0)) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setText(String.valueOf(i1));
    }
  }
  
  public void f()
  {
    if (this.jdField_b_of_type_Int != 1) {
      return;
    }
    this.jdField_a_of_type_Iis.removeMessages(9);
    long l1 = SystemClock.elapsedRealtime() - this.jdField_e_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("time_tick", 2, "checkTroopShareValidity, durition=" + l1 + ", mInitTroopShareTimeStamp=" + this.jdField_e_of_type_Long);
    }
    if (l1 >= 1200000L)
    {
      DialogUtil.a(this, 230, getString(2131367300), "此次分享已满20分钟", 2131365736, 2131366212, new iil(this), null).show();
      return;
    }
    this.jdField_a_of_type_Iis.sendEmptyMessageDelayed(9, 10000L);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Iis.a(100L);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("snow", 2, "stopSnow");
    }
    this.jdField_a_of_type_Iis.removeMessages(0);
  }
  
  public void i()
  {
    this.jdField_a_of_type_Iis.sendEmptyMessageDelayed(8, 0L);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.a()) {}
    label15:
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView;
    Object localObject;
    label358:
    do
    {
      String str;
      do
      {
        do
        {
          do
          {
            do
            {
              break label15;
              break label15;
              break label15;
              break label15;
              do
              {
                return;
              } while (i1 == 2131297259);
              if (i1 == 2131297239)
              {
                doOnBackPressed();
                return;
              }
              if ((i1 != 2131297240) && (i1 != 2131297245) && (i1 != 2131297247) && (i1 != 2131297246)) {
                break;
              }
            } while (this.jdField_b_of_type_Int != 1);
            c();
            return;
            if (i1 != 2131297669) {
              break;
            }
          } while (this.jdField_b_of_type_Int != 1);
          d();
          return;
          localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)paramView;
          if (localFace2FaceFriendBubbleView.a() != 1) {
            break label358;
          }
          str = localFace2FaceFriendBubbleView.b();
          if (!TextUtils.isEmpty(str)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleview uin is null");
        return;
        this.jdField_h_of_type_JavaLangString = str;
        if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "showdetail 进入详情页mShowDetailUin=" + this.jdField_h_of_type_JavaLangString.substring(0, 4));
        }
        localObject = this.app.a(str, (byte)3, true);
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = ImageUtil.a();
        }
        localObject = (NearbyUser)localFace2FaceFriendBubbleView.a();
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleview nearbyUser is null");
      return;
      if (((NearbyUser)localObject).jdField_a_of_type_JavaLangString.equals("")) {}
      for (localObject = ((NearbyUser)localObject).jdField_b_of_type_JavaLangString;; localObject = ((NearbyUser)localObject).jdField_a_of_type_JavaLangString)
      {
        a(localFace2FaceFriendBubbleView.b(), str, localFace2FaceFriendBubbleView, (String)localObject, paramView);
        ReportController.b(null, "CliOper", "", "", "0X80050ED", "0X80050ED", 0, 0, "", "", "", "");
        if (this.jdField_b_of_type_Int != 1) {
          break;
        }
        ReportController.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_admin", "Clk_detail", 0, 0, this.jdField_e_of_type_JavaLangString, "", "", "");
        return;
      }
    } while (localFace2FaceFriendBubbleView.a() != 2);
    paramView = localFace2FaceFriendBubbleView.a();
    if (paramView != null)
    {
      this.jdField_g_of_type_JavaLangString = paramView.jdField_e_of_type_JavaLangString;
      this.jdField_h_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
      localObject = new ihv(this, paramView);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.setBindData(paramView, (View.OnClickListener)localObject);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a(this.jdField_a_of_type_AndroidWidgetFrameLayout, localFace2FaceFriendBubbleView);
      if (this.jdField_b_of_type_Int == 1) {
        b(paramView);
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X80050EE", "0X80050EE", 0, 0, "", "", "", "");
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return false;
      paramView = (TextView)paramView;
      if (paramMotionEvent.getAction() == 0) {
        paramView.setTextColor(getResources().getColor(2131427412));
      } else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
        paramView.setTextColor(getResources().getColor(2131427404));
      }
    }
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    if (this.app != null) {
      this.app.c(paramBusinessObserver);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof NewFriendMessage)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "new friend update~~~~~ ");
      }
      paramObservable = (NewFriendMessage)paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity
 * JD-Core Version:    0.7.0.1
 */