package com.tencent.mobileqq.activity.selectmember;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import gxh;
import gxi;
import gxj;
import gxk;
import gxl;
import gxm;
import gxn;
import gxo;
import gxq;
import gxr;
import gxs;
import gxv;
import gxw;
import gxx;
import gxy;
import gxz;
import gya;
import gyc;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class SelectMemberActivity
  extends BaseActivity
{
  private static final int A = 1000;
  public static final String A = "param_exit_animation";
  public static final String B = "param_back_button_side";
  public static final String C = "friend_team_id";
  private static final int D = 3;
  public static final String D = "group_uin";
  public static final String E = "group_name";
  public static final String J = "select_member";
  public static final String K = "select_clear_stack";
  private static final String L = "not_admin_invite_member_count";
  public static final int a = 0;
  static final String jdField_a_of_type_JavaLangString = "SelectMemberActivity";
  public static boolean a = false;
  public static final int b = 1;
  public static final String b = "param_type";
  public static final int c = 2;
  public static final String c = "param_subtype";
  public static final int d = 10;
  public static final String d = "param_is_troop_admin";
  static final int jdField_e_of_type_Int = 0;
  public static final String e = "param_from";
  static final int jdField_f_of_type_Int = 1;
  public static final String f = "param_entrance";
  static final int jdField_g_of_type_Int = 2;
  public static final String g = "param_groupcode";
  static final int jdField_h_of_type_Int = 3;
  public static final String h = "param_face_to_face_troop";
  static final int jdField_i_of_type_Int = 4;
  public static final String i = "param_uins_selected_default";
  static final int jdField_j_of_type_Int = 5;
  public static final String j = "param_uins_hide";
  static final int jdField_k_of_type_Int = 6;
  public static final String k = "param_max";
  static final int jdField_l_of_type_Int = 7;
  public static final String l = "multi_chat";
  public static final int m = 8;
  public static final String m = "param_min";
  public static final int n = 9;
  public static final String n = "param_show_myself";
  public static final int o = 10;
  public static final String o = "result_set";
  public static final String p = "param_donot_need_circle";
  public static final String q = "param_donot_need_contacts";
  public static final String r = "param_donot_need_troop";
  public static final String s = "param_donot_need_discussion";
  public static final String t = "param_only_friends";
  public static final String u = "param_only_troop_member";
  public static final String v = "param_only_discussion_member";
  static final int w = 0;
  public static final String w = "param_title";
  static final int x = 1;
  public static final String x = "param_done_button_wording";
  static final int y = 2;
  public static final String y = "param_done_button_highlight_wording";
  public static final String z = "param_add_passed_members_to_result_set";
  private int B;
  private int C;
  public String F;
  String G;
  String H;
  String I;
  float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long = 0L;
  ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  public Dialog a;
  public Intent a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new gxx(this);
  public final Handler a;
  public View a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  public InputMethodManager a;
  public EditText a;
  public GridView a;
  public HorizontalScrollView a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public InnerFrameManager a;
  private ContactsSearchResultAdapter jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter;
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  public FaceDecoder a;
  public QQProgressDialog a;
  QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public XListView a;
  private gya jdField_a_of_type_Gya;
  public ArrayList a;
  public Bitmap b;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  ArrayList jdField_b_of_type_JavaUtilArrayList;
  boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public ArrayList c;
  boolean jdField_c_of_type_Boolean;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  public ArrayList d;
  boolean jdField_d_of_type_Boolean;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean;
  boolean jdField_f_of_type_Boolean;
  boolean jdField_g_of_type_Boolean;
  boolean jdField_h_of_type_Boolean;
  boolean jdField_i_of_type_Boolean;
  boolean jdField_j_of_type_Boolean;
  boolean jdField_k_of_type_Boolean;
  boolean jdField_l_of_type_Boolean;
  public boolean m;
  private boolean n;
  public int p;
  public int q;
  int r;
  public int s;
  int t;
  int u;
  int v;
  int z = 0;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public SelectMemberActivity()
  {
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
    this.jdField_a_of_type_AndroidOsHandler = new gxo(this);
    this.jdField_d_of_type_JavaUtilArrayList = null;
  }
  
  private String a(String paramString)
  {
    FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
    if (localFriendManager != null)
    {
      paramString = localFriendManager.a(paramString);
      if (paramString != null) {
        return paramString.troopcode;
      }
    }
    return null;
  }
  
  private void a(byte paramByte)
  {
    String str = null;
    if (7 == paramByte) {
      str = getString(2131368405);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, str).sendToTarget();
      return;
      if (9 == paramByte) {
        str = getString(2131368406);
      }
    }
  }
  
  private void b(int paramInt)
  {
    c(getString(paramInt));
  }
  
  private void b(boolean paramBoolean)
  {
    int i1 = this.jdField_c_of_type_JavaUtilArrayList.size();
    if (i1 <= 1) {}
    for (String str = this.H;; str = MessageFormat.format(this.I, new Object[] { Integer.valueOf(i1) }))
    {
      this.z = i1;
      if (!paramBoolean) {
        break;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_e_of_type_AndroidWidgetTextView.setEnabled(false);
  }
  
  private void c(String paramString)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 2000)
    {
      QQToast.a(this, paramString, 2000).b(this.jdField_a_of_type_AndroidViewView.getHeight());
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  private boolean c()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!this.n)
    {
      bool1 = bool2;
      if (a() >= 3) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.B = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_type");
    this.C = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_subtype");
    this.p = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_from");
    this.q = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_entrance", 0);
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_selected_default");
    this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_hide");
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.F = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("param_groupcode");
    this.n = this.jdField_a_of_type_AndroidContentIntent.getExtras().getBoolean("param_is_troop_admin", true);
    this.u = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_max", 2147483647);
    this.v = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_min", 1);
    this.k = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_show_myself", false);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_circle", false);
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_contacts", false);
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_troop", false);
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_discussion", false);
    this.f = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_friends", false);
    this.g = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_troop_member", false);
    this.h = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_discussion_member", false);
    this.i = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_face_to_face_troop", false);
    this.G = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_title");
    if (this.G == null) {
      this.G = getString(2131368385);
    }
    this.H = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_done_button_wording");
    if (this.H == null) {
      this.H = getString(2131368389);
    }
    this.I = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_done_button_highlight_wording");
    if (this.I == null) {
      this.I = (this.H + "({0})");
    }
    this.j = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_add_passed_members_to_result_set", false);
    this.s = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_exit_animation", 0);
    this.t = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_back_button_side", 1);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296488);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297348));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297358));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297360));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131300436);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131298202));
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = ((InnerFrameManager)findViewById(2131302124));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131298204));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131298206));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299473));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new gyc(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new gxq(this));
  }
  
  private void j()
  {
    TextView localTextView1 = this.jdField_c_of_type_AndroidWidgetTextView;
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    a();
    if (isModeleWindow())
    {
      localTextView2 = this.jdField_c_of_type_AndroidWidgetTextView;
      if (this.t == 0) {}
      for (i1 = 2130842088;; i1 = 2130838413)
      {
        localTextView2.setBackgroundResource(i1);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.G);
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.G);
        localTextView1.setContentDescription(getString(2131365736));
        localTextView1.setOnClickListener(new gxr(this));
        this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new gxs(this));
        return;
      }
    }
    TextView localTextView2 = this.jdField_c_of_type_AndroidWidgetTextView;
    if (this.t == 0) {}
    for (int i1 = 2130842089;; i1 = 2130838414)
    {
      localTextView2.setBackgroundResource(i1);
      break;
    }
  }
  
  @SuppressLint({"NewApi"})
  private void k()
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
      this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_Gya = new gya(this, null);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Gya);
    this.jdField_a_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(new gxw(this));
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558902);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130904387);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296606));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131366988));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296605));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131301658));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new gxz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new gxi(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new gxj(this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public int a()
  {
    int i2 = 0;
    long l1 = Utils.a();
    Object localObject = this.app.a().getSharedPreferences(this.app.getAccount(), 0).getString("not_admin_invite_member_count", null);
    int i1 = i2;
    if (localObject != null) {}
    try
    {
      localObject = ((String)localObject).split(":");
      i1 = i2;
      if (Long.parseLong(localObject[0]) == l1) {
        i1 = Integer.parseInt(localObject[1]);
      }
      return i1;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public View a(ListView paramListView)
  {
    return Utils.a(this, paramListView);
  }
  
  public SelectMemberActivity.ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    SelectMemberActivity.ResultRecord localResultRecord = new SelectMemberActivity.ResultRecord();
    localResultRecord.jdField_a_of_type_JavaLangString = paramString1;
    localResultRecord.b = paramString2;
    localResultRecord.jdField_a_of_type_Int = paramInt;
    localResultRecord.c = paramString3;
    return localResultRecord;
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.v)
    {
      b(true);
      return;
    }
    b(false);
  }
  
  public void a(int paramInt)
  {
    long l1 = Utils.a();
    SharedPreferences.Editor localEditor = this.app.a().getSharedPreferences(this.app.getAccount(), 0).edit();
    localEditor.putString("not_admin_invite_member_count", l1 + ":" + paramInt);
    localEditor.commit();
  }
  
  public void a(String paramString)
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString)) {
        this.jdField_c_of_type_JavaUtilArrayList.remove(i1);
      }
      i1 += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(this.jdField_c_of_type_JavaUtilArrayList.size());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    int i1 = this.jdField_c_of_type_JavaUtilArrayList.size();
    i1 = (int)((16 * this.jdField_c_of_type_JavaUtilArrayList.size() + i1 * 31) * this.jdField_a_of_type_Float);
    localLayoutParams.width = i1;
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(localLayoutParams);
    if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setPadding((int)(14.0F * this.jdField_a_of_type_Float), this.jdField_a_of_type_AndroidWidgetEditText.getPaddingTop(), this.jdField_a_of_type_AndroidWidgetEditText.getPaddingRight(), this.jdField_a_of_type_AndroidWidgetEditText.getPaddingBottom());
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setPadding((int)(this.jdField_a_of_type_Float * 32.0F), 0, 0, 0);
      int i2 = this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getPaddingLeft();
      int i3 = this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getPaddingRight();
      int i4 = (int)(154.0F * this.jdField_a_of_type_Float + 0.5F);
      int i5 = this.jdField_b_of_type_AndroidViewView.getWidth();
      localLayoutParams = this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getLayoutParams();
      if (i5 >= i1 + i2 + i3 + i4) {
        break label303;
      }
      if (localLayoutParams.width >= 0) {}
    }
    label303:
    for (localLayoutParams.width = this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getWidth();; localLayoutParams.width = -2)
    {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setLayoutParams(localLayoutParams);
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 200L);
      }
      this.jdField_a_of_type_Gya.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setPadding((int)(this.jdField_a_of_type_Float * 32.0F), this.jdField_a_of_type_AndroidWidgetEditText.getPaddingTop(), this.jdField_a_of_type_AndroidWidgetEditText.getPaddingRight(), this.jdField_a_of_type_AndroidWidgetEditText.getPaddingBottom());
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setPadding(0, 0, 0, 0);
      break;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, ArrayList paramArrayList) {}
  
  void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    int i1;
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      if (isModeleWindow())
      {
        i1 = 2130842088;
        localTextView.setBackgroundResource(i1);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString1);
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new gxv(this));
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
        IphoneTitleBarActivity.setLayerType(this.jdField_c_of_type_AndroidWidgetTextView);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
      return;
      i1 = 2130842089;
      break;
      j();
    }
  }
  
  public boolean a()
  {
    return this.l;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        if (((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  boolean a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool = false;
    if (a(paramString1)) {
      a(paramString1);
    }
    for (;;)
    {
      a(bool);
      a();
      return bool;
      if (!b())
      {
        bool = true;
        this.jdField_c_of_type_JavaUtilArrayList.add(a(paramString1, paramString2, paramInt, paramString3));
      }
    }
  }
  
  public View b(ListView paramListView)
  {
    return Utils.b(this, paramListView);
  }
  
  public void b()
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i2;
    switch (this.B)
    {
    default: 
      this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_c_of_type_JavaUtilArrayList);
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      finish();
      return;
    case 3000: 
      if (this.j)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject3 = new SelectMemberActivity.ResultRecord();
          ((SelectMemberActivity.ResultRecord)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
          ((SelectMemberActivity.ResultRecord)localObject3).jdField_a_of_type_Int = 0;
          ((SelectMemberActivity.ResultRecord)localObject3).c = "-1";
          this.jdField_c_of_type_JavaUtilArrayList.add(localObject3);
        }
      }
      localObject1 = (FriendManager)this.app.getManager(8);
      i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
      localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (((SelectMemberActivity.ResultRecord)((Iterator)localObject2).next()).jdField_a_of_type_Int != 3);
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "0", "", "", "");
        if ((this.C != 0) || (i2 != 1) || (this.q == 10)) {
          break label593;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "start C2C conversation");
        }
        localObject2 = new Intent(this, ChatActivity.class);
        ((Intent)localObject2).putExtra("uin", ((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject3 = ((FriendManager)localObject1).c(((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
          if (!((FriendManager)localObject1).b(((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString)) {
            break label569;
          }
          ((Intent)localObject2).putExtra("uintype", 0);
          label393:
          if (localObject3 != null)
          {
            ((Intent)localObject2).putExtra("cSpecialFlag", ((Friends)localObject3).cSpecialFlag);
            if (((Friends)localObject3).cSpecialFlag == 1)
            {
              ((Intent)localObject2).setClass(this, ChatActivity.class);
              ((Intent)localObject2).putExtra("chat_subType", 1);
            }
          }
        }
        ((Intent)localObject2).putExtra("uinname", ((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).b);
        if (!isModeleWindow()) {
          break label584;
        }
        localObject1 = new Intent("Common_BroadcastReceiver");
        ((Intent)localObject1).putExtras(((Intent)localObject2).getExtras());
        ((Intent)localObject1).putExtra("select_member", true);
        ((Intent)localObject1).putExtra("select_clear_stack", isTabActivity(this.fromActivity));
        sendBroadcast((Intent)localObject1);
      }
      for (;;)
      {
        this.s = 2;
        finish();
        return;
        ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "1", "", "", "");
        break;
        label569:
        ((Intent)localObject2).putExtra("uintype", 1000);
        break label393;
        label584:
        startActivity((Intent)localObject2);
      }
      label593:
      if ((this.C == 0) && (i2 == 1) && (this.q == 10))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "start C2C audio");
        }
        if ((((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 0) && (((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int != 1)) {
          break label1158;
        }
        localObject1 = a(((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).c);
        i1 = 1000;
      }
      for (;;)
      {
        if (((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 2)
        {
          i1 = 1004;
          localObject1 = ((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).c;
        }
        for (;;)
        {
          if (((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 3) {
            i1 = 1021;
          }
          for (;;)
          {
            localObject2 = null;
            localObject3 = ((PhoneContactManager)this.app.getManager(10)).a(((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
            if (localObject3 != null) {
              localObject2 = ((PhoneContact)localObject3).nationCode + ((PhoneContact)localObject3).mobileCode;
            }
            if (!ChatActivityUtils.a(this.app, this, i1, ((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString, ((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).b, (String)localObject2, true, (String)localObject1, true, true, this.jdField_a_of_type_AndroidOsHandler$Callback, null)) {
              break;
            }
            this.s = 2;
            finish();
            return;
            if (((SelectMemberActivity.ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 4) {
              i1 = 1006;
            }
          }
          if (this.C == 0) {}
          for (i1 = 2131366616;; i1 = 2131366617)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131492923));
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(i1);
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
            localObject1 = new gxy(this, (FriendManager)localObject1);
            ((Thread)localObject1).setName("SelectMemberActivity_addDiscussion");
            ((Thread)localObject1).start();
            return;
          }
          localObject1 = new ArrayList();
          localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((ArrayList)localObject1).add(((SelectMemberActivity.ResultRecord)((Iterator)localObject2).next()).jdField_a_of_type_JavaLangString);
          }
          if ((((ArrayList)localObject1).size() > 0) && (this.F.length() > 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SelectMemberActivity", 2, "add troop member: troopCode: " + this.F + " member count: " + ((ArrayList)localObject1).size());
            }
            if (!c())
            {
              QQToast.a(this, 2131367802, 0).b(getTitleBarHeight());
              return;
            }
            ((TroopHandler)this.app.a(19)).a(this.F, (ArrayList)localObject1, "");
            l();
            this.jdField_a_of_type_AndroidAppDialog.show();
            return;
          }
          finish();
          return;
        }
        label1158:
        i1 = 0;
        localObject1 = null;
      }
    }
  }
  
  public void b(String paramString)
  {
    if (paramString.equals("")) {}
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      label26:
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.c();
      return;
      try
      {
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        label57:
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
        String str = paramString.trim();
        if ("".equals(str))
        {
          this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a(paramString, paramString);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a(str, paramString);
        return;
      }
      catch (Exception localException)
      {
        break label57;
      }
    }
    catch (Exception paramString)
    {
      break label26;
    }
  }
  
  public boolean b()
  {
    if (this.B == 3000)
    {
      if (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.u)
      {
        b(2131366637);
        return true;
      }
    }
    else if (this.B == 1)
    {
      if (this.C == 0)
      {
        if (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.u)
        {
          b(2131368037);
          return true;
        }
      }
      else if ((this.C == 1) && (!this.n) && (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.u))
      {
        b(2131368037);
        return true;
      }
    }
    else if (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.u)
    {
      c(String.format(getString(2131368407), new Object[] { Integer.valueOf(this.u) }));
      return true;
    }
    return false;
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.isShown()) {
      return;
    }
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      d();
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    new Thread(new gxk(this)).start();
    if (QLog.isColorLevel()) {
      QLog.d("Q.PerfTrace", 2, "selectmember search up anim time: " + (System.currentTimeMillis() - l1));
    }
    this.l = true;
    ReportController.b(this.app, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "6", "", "", "");
  }
  
  void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297285));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297286);
    Utils.a(this, this.jdField_a_of_type_ComTencentWidgetXListView);
    this.m = true;
    Utils.b(this, this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter = new ContactsSearchResultAdapter(this.app, this, this.jdField_a_of_type_ComTencentWidgetXListView, null, null, false);
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a(new gxl(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new gxm(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new gxn(this));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager != null) {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    h();
    super.doOnCreate(paramBundle);
    setContentView(2130904417);
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false) == true)
    {
      super.getWindow().addFlags(524288);
      setRequestedOrientation(4);
    }
    i();
    j();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(this);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setAppIntf(this.app);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setSwitchListener(new gxh(this));
    if (this.g) {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(8, this.jdField_a_of_type_AndroidContentIntent.getExtras());
    }
    for (;;)
    {
      k();
      m();
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
      ChnToSpell.a(this);
      this.jdField_b_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
      return true;
      if (this.h) {
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(9, this.jdField_a_of_type_AndroidContentIntent.getExtras());
      } else {
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.d();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.e();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.c();
  }
  
  void e()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setVisibility(0);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.l = false;
  }
  
  public void f()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838136);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public void finish()
  {
    super.finish();
    switch (this.s)
    {
    default: 
      overridePendingTransition(0, 2130968584);
    case 2: 
      return;
    }
    overridePendingTransition(2130968589, 2130968591);
  }
  
  public void g()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
    {
      e();
      return true;
    }
    switch (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a())
    {
    default: 
      return super.onBackEvent();
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      g();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
      return true;
    case 7: 
      g();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
      return true;
    case 8: 
      if (this.g)
      {
        finish();
        return true;
      }
      g();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
      return true;
    }
    if (this.h)
    {
      finish();
      return true;
    }
    g();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(4);
    return true;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity
 * JD-Core Version:    0.7.0.1
 */