package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import dzv;
import dzw;
import dzx;
import dzy;
import dzz;
import eaa;
import eab;
import eac;
import ead;
import eae;
import eaf;
import eag;
import eah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForwardRecentActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  protected static final int a = 50001;
  public static final String a = "com.tencent.mobileqq.activity.ForwardRecentActivity.ACTION_LIST_ITEM_ON_CLICK";
  public static final int b = 10;
  public static final String b = "share_type";
  public static final int c = 11;
  static final String jdField_c_of_type_JavaLangString = "ForwardRecentActivity";
  public static final int d = 20000;
  public static final String d = "com.tencent.intent.QQ_FORWARD";
  public static final int e = 20001;
  public static final String e = "-1010";
  public static final int f = 20002;
  public static final String f = "k_qzone";
  public static final int g = 20003;
  public static final String g = "k_dataline";
  public static final String h = "k_cancel_button";
  public static final String i = "k_favorites";
  public static final String j = "k_send";
  public static final String k = "acceptType";
  protected static final String l = "forward_type";
  protected static final String m = "forward_thumb";
  protected static final String n = "forward_text";
  protected static final String o = "key_jump_from_qzone_feed";
  protected static final String p = "key_jump_from_qzone_feed_left_title";
  public static final String t = "com.tencent.intent.QQ_FORWARD";
  public static final String v = "public_account";
  public static final String w = "web_share";
  public static final String x = "struct_msg_from_h5";
  public static final String y = "struct_favorite";
  protected String A;
  protected long a;
  public Dialog a;
  public Uri a;
  public Bundle a;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new eac(this);
  View jdField_a_of_type_AndroidViewView;
  public LinearLayout a;
  public RelativeLayout a;
  protected OpenIdObserver a;
  private ForwardOperations jdField_a_of_type_ComTencentMobileqqActivityForwardOperations;
  private ForwardRecentListAdapter jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter;
  private AutomatorObserver jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver = new dzx(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new eah(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dzw(this);
  protected QQCustomDialog a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  View b;
  public boolean b;
  View jdField_c_of_type_AndroidViewView;
  protected boolean c;
  View d;
  public boolean d;
  View jdField_e_of_type_AndroidViewView;
  boolean jdField_e_of_type_Boolean = false;
  View jdField_f_of_type_AndroidViewView;
  boolean jdField_f_of_type_Boolean = false;
  private View jdField_g_of_type_AndroidViewView;
  boolean jdField_g_of_type_Boolean = false;
  public int h;
  private View jdField_h_of_type_AndroidViewView;
  boolean jdField_h_of_type_Boolean = false;
  int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private boolean j;
  private boolean k = true;
  private boolean l = true;
  private boolean m = true;
  private boolean n = true;
  private boolean o = false;
  private boolean p = true;
  String jdField_q_of_type_JavaLangString;
  private boolean jdField_q_of_type_Boolean;
  String r;
  String s;
  String u;
  public String z;
  
  public ForwardRecentActivity()
  {
    this.jdField_d_of_type_Boolean = false;
    this.q = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new dzz(this);
  }
  
  private List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if ((this.jdField_h_of_type_Int == 1001) || (this.jdField_h_of_type_Int == -4))
    {
      if (this.jdField_i_of_type_Int == 13)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (RecentUser)paramList.next();
          if ((localObject != null) && (((RecentUser)localObject).type == 0) && (!Utils.a(((RecentUser)localObject).uin)) && (!Utils.b(((RecentUser)localObject).uin)) && (((RecentUser)localObject).type != 7000) && (a((RecentUser)localObject)) && (a(((RecentUser)localObject).uin))) {
            localArrayList.add(localObject);
          }
        }
      }
      if (("public_account".equals(this.u)) || ("web_share".equals(this.u)) || ("struct_msg_from_h5".equals(this.u)) || ("struct_favorite".equals(this.u))) {
        paramList = paramList.iterator();
      }
    }
    else
    {
      while (paramList.hasNext())
      {
        localObject = (RecentUser)paramList.next();
        if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && (((RecentUser)localObject).type != 1000) && (((RecentUser)localObject).type != 1020) && (((RecentUser)localObject).type != 1008) && (((RecentUser)localObject).type != 1005) && (((RecentUser)localObject).type != 1004) && (((RecentUser)localObject).type != 1009) && (((RecentUser)localObject).type != 1021) && (((RecentUser)localObject).type != 1001) && (((RecentUser)localObject).type != 1022) && (((RecentUser)localObject).type != 1024) && (((RecentUser)localObject).type != 1025) && ((((RecentUser)localObject).type != 1) || (!a(((RecentUser)localObject).uin))) && (((RecentUser)localObject).type != 7000) && (a((RecentUser)localObject)))
        {
          localArrayList.add(localObject);
          continue;
          if (this.jdField_h_of_type_Int == 0)
          {
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              localObject = (RecentUser)paramList.next();
              if ((localObject != null) && (a((RecentUser)localObject)) && (((RecentUser)localObject).type != 7000)) {
                if (this.jdField_g_of_type_Boolean)
                {
                  if ((((RecentUser)localObject).type == 1) || (((RecentUser)localObject).type == 0) || (((RecentUser)localObject).type == 3000)) {
                    localArrayList.add(localObject);
                  }
                }
                else if ((this.jdField_h_of_type_Boolean) || (this.jdField_g_of_type_Boolean))
                {
                  if ((((RecentUser)localObject).type == 0) || (((RecentUser)localObject).type == 1) || (((RecentUser)localObject).type == 3000) || (((RecentUser)localObject).type == 1006) || (((RecentUser)localObject).type == 1004) || (((RecentUser)localObject).type == 1000) || (((RecentUser)localObject).type == 1001)) {
                    localArrayList.add(localObject);
                  }
                }
                else if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && ((((RecentUser)localObject).type == 0) || (((RecentUser)localObject).type == 3000) || ((((RecentUser)localObject).type == 1) && (this.l) && (!a(((RecentUser)localObject).uin))) || (-1L != FileManagerUtil.a(((RecentUser)localObject).type)))) {
                  localArrayList.add(localObject);
                }
              }
            }
          }
          if (this.jdField_h_of_type_Int == -1)
          {
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              localObject = (RecentUser)paramList.next();
              if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && (((RecentUser)localObject).type != 1008) && (((RecentUser)localObject).type != 1021) && (((RecentUser)localObject).type != 7000) && (((RecentUser)localObject).type != 6002) && ((((RecentUser)localObject).type != 1) || (!a(((RecentUser)localObject).uin))) && (a((RecentUser)localObject))) {
                localArrayList.add(localObject);
              }
            }
          }
          if ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 12)) {
            paramList = paramList.iterator();
          }
          while (paramList.hasNext())
          {
            localObject = (RecentUser)paramList.next();
            if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && (((RecentUser)localObject).type != 1003) && (((RecentUser)localObject).type != 1025) && (((RecentUser)localObject).type != 1024) && (((RecentUser)localObject).type != 1008) && (((RecentUser)localObject).type != 1021) && ((((RecentUser)localObject).type != 1) || (!a(((RecentUser)localObject).uin))) && (((RecentUser)localObject).type != 7000) && (a((RecentUser)localObject)))
            {
              localArrayList.add(localObject);
              continue;
              if ((this.jdField_h_of_type_Int == 13) || (this.jdField_h_of_type_Int == 15))
              {
                localObject = (FriendsManagerImp)this.app.getManager(8);
                paramList = paramList.iterator();
              }
              while (paramList.hasNext())
              {
                RecentUser localRecentUser = (RecentUser)paramList.next();
                if ((localRecentUser != null) && (a(localRecentUser)) && (localRecentUser.type != 7000)) {
                  if ((localRecentUser.type == 0) && (!Utils.a(localRecentUser.uin)) && (!Utils.b(localRecentUser.uin)))
                  {
                    if ((localObject != null) && (((FriendsManagerImp)localObject).b(localRecentUser.uin))) {
                      localArrayList.add(localRecentUser);
                    }
                  }
                  else if ((localRecentUser.type == 1006) || (localRecentUser.type == 1004))
                  {
                    localArrayList.add(localRecentUser);
                    continue;
                    if ((this.jdField_h_of_type_Int == -2) || (this.jdField_h_of_type_Int == 11)) {
                      paramList = paramList.iterator();
                    }
                    while (paramList.hasNext())
                    {
                      localObject = (RecentUser)paramList.next();
                      if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && (((RecentUser)localObject).type != 1000) && (((RecentUser)localObject).type != 1020) && (((RecentUser)localObject).type != 1008) && (((RecentUser)localObject).type != 1005) && (((RecentUser)localObject).type != 1004) && (((RecentUser)localObject).type != 1009) && (((RecentUser)localObject).type != 1021) && (((RecentUser)localObject).type != 1001) && (((RecentUser)localObject).type != 1022) && (((RecentUser)localObject).type != 7000) && (((RecentUser)localObject).type != 1025) && (((RecentUser)localObject).type != 1024) && ((((RecentUser)localObject).type != 1) || (!a(((RecentUser)localObject).uin))) && (a((RecentUser)localObject)))
                      {
                        localArrayList.add(localObject);
                        continue;
                        if (this.jdField_h_of_type_Int == 16)
                        {
                          paramList = paramList.iterator();
                          while (paramList.hasNext())
                          {
                            localObject = (RecentUser)paramList.next();
                            if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && (((((RecentUser)localObject).type == 0) && (this.p)) || ((((RecentUser)localObject).type == 1) && (!a(((RecentUser)localObject).uin)) && (this.l)) || ((((RecentUser)localObject).type == 3000) && (this.m)))) {
                              localArrayList.add(localObject);
                            }
                          }
                        }
                        if (this.jdField_h_of_type_Int == 17)
                        {
                          paramList = paramList.iterator();
                          while (paramList.hasNext())
                          {
                            localObject = (RecentUser)paramList.next();
                            if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && ((((RecentUser)localObject).type == 0) || (((RecentUser)localObject).type == 1) || (((RecentUser)localObject).type == 3000))) {
                              localArrayList.add(localObject);
                            }
                          }
                        }
                        if ((this.jdField_h_of_type_Int == 18) || (this.jdField_h_of_type_Int == 19)) {
                          paramList = paramList.iterator();
                        }
                        while (paramList.hasNext())
                        {
                          localObject = (RecentUser)paramList.next();
                          if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && ((((RecentUser)localObject).type == 1) || (((RecentUser)localObject).type == 3000)))
                          {
                            localArrayList.add(localObject);
                            continue;
                            paramList = paramList.iterator();
                            while (paramList.hasNext())
                            {
                              localObject = (RecentUser)paramList.next();
                              if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && (((RecentUser)localObject).type != 1000) && (((RecentUser)localObject).type != 1020) && (((RecentUser)localObject).type != 1008) && (((RecentUser)localObject).type != 1005) && (((RecentUser)localObject).type != 1006) && (((RecentUser)localObject).type != 1004) && (((RecentUser)localObject).type != 1009) && (((RecentUser)localObject).type != 1021) && (((RecentUser)localObject).type != 1001) && (((RecentUser)localObject).type != 1022) && (((RecentUser)localObject).type != 7000) && (((RecentUser)localObject).type != 1025) && (((RecentUser)localObject).type != 1024) && ((((RecentUser)localObject).type != 1) || (!a(((RecentUser)localObject).uin))) && (a((RecentUser)localObject))) {
                                localArrayList.add(localObject);
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
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      return;
    }
    Contacts.a += 1;
    this.jdField_a_of_type_AndroidAppDialog = new ead(this, this, this.app, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations, 7);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    paramInt = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramInt);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -paramInt, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new eae(this));
    localTranslateAnimation2.setAnimationListener(new eaf(this, paramInt));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new eag(this, paramInt, localTranslateAnimation2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation1);
    ReportController.b(this.app, "CliOper", "", "", "0X8004049", "0X8004049", 0, 0, "", "", "", "");
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity, ForwardRecentActivity.class);
    localIntent.putExtra("forward_type", paramInt2).putExtra("forward_text", paramString1).putExtra("forward_thumb", paramString2).putExtra("k_qzone", paramBoolean1).putExtra("k_send", paramBoolean2);
    if (paramInt2 == 1) {
      localIntent.putExtra("forward_extra", paramString2);
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  private void a(View paramView)
  {
    Utils.a(this, paramView);
  }
  
  private void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296742));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297738));
    findViewById(2131297361).setVisibility(8);
    Object localObject = (TextView)findViewById(2131297348);
    ((TextView)localObject).setText("发送到");
    findViewById(2131297357).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297034));
    this.jdField_g_of_type_AndroidViewView = a(this.jdField_a_of_type_ComTencentWidgetXListView);
    paramTextView = LayoutInflater.from(this);
    View localView = paramTextView.inflate(2130904390, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    a(localView);
    localView.findViewById(2131299461).setVisibility(8);
    EditText localEditText = (EditText)localView.findViewById(2131299473);
    localEditText.setFocusable(false);
    localEditText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
    if (this.jdField_h_of_type_Int == 17)
    {
      localView = paramTextView.inflate(2130903329, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
      this.p = true;
      this.m = true;
      this.l = true;
      this.n = false;
      this.k = false;
      this.o = false;
    }
    if ((this.jdField_h_of_type_Int == 18) || (this.jdField_h_of_type_Int == 19))
    {
      ((TextView)localObject).setText("传递祝福到");
      localObject = paramTextView.inflate(2130903329, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentWidgetXListView.a((View)localObject);
      this.p = false;
      this.m = true;
      this.l = true;
      this.n = false;
      this.k = false;
      this.o = false;
    }
    this.jdField_h_of_type_AndroidViewView = paramTextView.inflate(2130903328, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_h_of_type_AndroidViewView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_h_of_type_AndroidViewView);
    paramTextView = paramTextView.inflate(2130903182, null);
    ((TextView)paramTextView.findViewById(2131297231)).setText(2131366028);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(paramTextView);
    this.jdField_a_of_type_AndroidViewView = this.jdField_h_of_type_AndroidViewView.findViewById(2131297729);
    this.jdField_b_of_type_AndroidViewView = this.jdField_h_of_type_AndroidViewView.findViewById(2131297733);
    this.jdField_c_of_type_AndroidViewView = this.jdField_h_of_type_AndroidViewView.findViewById(2131297275);
    this.jdField_d_of_type_AndroidViewView = this.jdField_h_of_type_AndroidViewView.findViewById(2131297727);
    this.jdField_e_of_type_AndroidViewView = this.jdField_h_of_type_AndroidViewView.findViewById(2131297731);
    this.jdField_f_of_type_AndroidViewView = this.jdField_h_of_type_AndroidViewView.findViewById(2131297735);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private boolean a(RecentUser paramRecentUser)
  {
    return paramRecentUser.type != 9501;
  }
  
  private void b()
  {
    if ((!this.p) && (!this.k) && (!this.l) && (!this.m))
    {
      this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_h_of_type_AndroidViewView.setVisibility(0);
    if (this.p) {}
    for (int i2 = 1;; i2 = 0)
    {
      int i1 = i2;
      if (this.k) {
        i1 = i2 + 1;
      }
      i2 = i1;
      if (this.l) {
        i2 = i1 + 1;
      }
      i1 = i2;
      if (this.m) {
        i1 = i2 + 1;
      }
      if (this.jdField_i_of_type_Boolean) {
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      }
      if (!this.p)
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        if (this.k) {
          break label185;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        label141:
        if (this.l) {
          break label246;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      for (;;)
      {
        if (this.m) {
          break label257;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
        label185:
        Object localObject = getPackageName();
        if ((this.s != null) && (!this.s.equals(localObject)))
        {
          localObject = (LinearLayout)this.jdField_a_of_type_AndroidViewView.getParent();
          ((LinearLayout)localObject).removeView(this.jdField_a_of_type_AndroidViewView);
          ((LinearLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        break label141;
        label246:
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      label257:
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
    }
  }
  
  private void c()
  {
    View localView = getLayoutInflater().inflate(2130904377, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((ImageView)localView.findViewById(2131296551)).setBackgroundResource(2130839616);
    TextView localTextView = (TextView)localView.findViewById(16908308);
    localTextView.setText("我的电脑");
    localTextView.setContentDescription("我的电脑");
    localView.setOnClickListener(new eaa(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
  }
  
  private void d()
  {
    if (this.app.e())
    {
      this.jdField_a_of_type_JavaUtilList = a(this.app.a().a().b());
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter != null) {
        break label120;
      }
      eab localeab = new eab(this);
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter = new ForwardRecentListAdapter(this, this.app, null, 2130904377, this.jdField_a_of_type_JavaUtilList, localeab, null);
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter.a(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter);
    }
    while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      this.jdField_g_of_type_AndroidViewView.setVisibility(4);
      return;
      label120:
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
    this.jdField_g_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void e()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = this.app.a();
    String str2 = this.app.c();
    String str1 = str2;
    if (StringUtil.b(str2)) {
      str1 = ContactUtils.g(this.app, this.app.a());
    }
    localUserInfo.b = str1;
    localUserInfo.c = this.app.getSid();
    QZoneHelper.a(this, localUserInfo, this.r, "写说说", null, 20000);
  }
  
  public View a(ListView paramListView)
  {
    return Utils.a(this, paramListView);
  }
  
  public void a()
  {
    StatisticCollector.a(BaseApplication.getContext()).a(this.app, this.app.getAccount(), "", "multi_account", "push_login_window", 0, 1, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131363611);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131363691);
    dzy localdzy = new dzy(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131365736, localdzy);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131363612, localdzy);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt -= this.jdField_a_of_type_ComTencentWidgetXListView.m();
    if (paramInt < 0) {}
    do
    {
      return;
      paramAdapterView = (TextView)paramView.findViewById(16908308);
    } while (paramAdapterView == null);
    if (paramAdapterView.getText() != null) {}
    for (paramAdapterView = paramAdapterView.getText().toString();; paramAdapterView = null)
    {
      paramView = (RecentUser)this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter.getItem(paramInt);
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(paramView.uin, paramView.type, paramView.troopUin, paramAdapterView);
      if (this.jdField_h_of_type_Int != 13) {
        break;
      }
      ReportController.b(this.app, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "2", "", "", "");
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004D9C", "0X8004D9C", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) && (!isFinishing()))
    {
      if (!paramBoolean) {
        break label65;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(0, "", "");
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_d_of_type_Boolean)) {
        ForwardOperations.a(this, true, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_Long);
      }
      return;
      label65:
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(-1, "未知错误!", "未知错误!");
    }
  }
  
  public boolean a(String paramString)
  {
    FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
    HotChatManager localHotChatManager = (HotChatManager)this.app.getManager(58);
    int i1;
    if ((localFriendManager != null) && (localFriendManager.f(paramString)))
    {
      i1 = 1;
      if ((localHotChatManager == null) || (!localHotChatManager.d(paramString))) {
        break label77;
      }
    }
    label77:
    for (int i2 = 1;; i2 = 0)
    {
      if ((i1 == 0) && (i2 == 0)) {
        break label82;
      }
      return true;
      i1 = 0;
      break;
    }
    label82:
    return false;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    while ((paramInt2 != 1) || (20000 != paramInt1))
    {
      String str;
      do
      {
        return;
        if (getIntent().getExtras().getBoolean("jump_to_mobileqq_share", false)) {
          setResult(10, paramIntent);
        }
        for (;;)
        {
          finish();
          return;
          setResult(-1, paramIntent);
        }
        setResult(-1, paramIntent);
        finish();
        return;
        str = paramIntent.getStringExtra("roomId");
      } while (StringUtil.b(str));
      d();
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(str, 3000, null, paramIntent.getStringExtra("discussName"));
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(paramIntent);
      return;
    }
    finish();
  }
  
  public void doOnBackPressed()
  {
    if ((!isFinishing()) && (this.jdField_h_of_type_Int == 11))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_d_of_type_Boolean) {
        ForwardOperations.a(this, false, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_Long);
      }
      com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_c_of_type_Boolean = false;
    }
    super.doOnBackPressed();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      ((SearchResultDialog)this.jdField_a_of_type_AndroidAppDialog).a(paramConfiguration);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Intent localIntent = getIntent();
    this.jdField_a_of_type_AndroidOsBundle = localIntent.getExtras();
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    int i1;
    boolean bool1;
    label277:
    label305:
    label1972:
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = new ForwardOperations(this, this.app, localIntent, this.jdField_a_of_type_AndroidOsBundle);
      if (isFinishing()) {
        return false;
      }
      this.jdField_a_of_type_AndroidNetUri = localIntent.getData();
      this.jdField_h_of_type_Int = localIntent.getIntExtra("forward_type", -1);
      this.jdField_i_of_type_Int = localIntent.getIntExtra("req_type", 2147483647);
      this.r = localIntent.getStringExtra("forward_thumb");
      this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("fromWebXman", false);
      this.u = this.jdField_a_of_type_AndroidOsBundle.getString("pluginName");
      this.s = localIntent.getStringExtra("pkg_name");
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
      setContentViewNoTitle(2130903331);
      localTextView = (TextView)findViewById(2131297348);
      a(localTextView);
      paramBundle = localIntent.getParcelableExtra("fileinfo");
      if (!(paramBundle instanceof ForwardFileInfo)) {
        break label1977;
      }
      localObject1 = (ForwardFileInfo)paramBundle;
    }
    catch (Exception paramBundle)
    {
      label311:
      label1977:
      label1983:
      label1989:
      for (;;)
      {
        TextView localTextView;
        Object localObject1;
        Object localObject2;
        int i2;
        ArrayList localArrayList;
        label851:
        finish();
        break;
        label1275:
        if (this.jdField_h_of_type_Int == 13)
        {
          localTextView.setText("选择联系人");
          this.l = false;
          this.m = false;
          this.o = false;
        }
        else if (this.jdField_h_of_type_Int == 15)
        {
          localObject2 = localIntent.getStringExtra("choose_friend_title");
          bool1 = localIntent.getBooleanExtra("choose_friend_is_qqfriends", true);
          bool2 = localIntent.getBooleanExtra("choose_friend_is_contacts", false);
          paramBundle = (Bundle)localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            paramBundle = "选择好友";
          }
          localTextView.setText(paramBundle);
          this.l = false;
          this.m = false;
          this.o = false;
          this.k = bool2;
          this.p = bool1;
        }
        else if ((this.jdField_h_of_type_Int == 1001) || (this.jdField_h_of_type_Int == -4) || (this.jdField_h_of_type_Int == 9) || (this.jdField_h_of_type_Int == -3) || (this.jdField_h_of_type_Int == 14) || (this.jdField_h_of_type_Int == 20))
        {
          this.o = false;
          this.n = false;
          this.k = false;
        }
        else if (this.jdField_h_of_type_Int == 11)
        {
          this.o = false;
          this.n = false;
        }
        else if (this.jdField_h_of_type_Int == 16)
        {
          i1 = localIntent.getIntExtra("acceptType", 13);
          if ((i1 & 0x1) == 0) {
            this.p = false;
          }
          if ((i1 & 0x4) == 0) {
            this.l = false;
          }
          if ((i1 & 0x8) == 0) {
            this.m = false;
          }
          this.k = false;
          this.n = false;
          this.o = false;
          continue;
          paramBundle = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
          i1 = 0;
          if (i1 < paramBundle.size())
          {
            localObject2 = ForwardOperations.a(this, (Uri)paramBundle.get(i1));
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).equals("/"))) {
              break label2021;
            }
            break label2021;
            if (localObject1 == null)
            {
              localObject2 = getIntent().getStringExtra("forward_filepath");
              paramBundle = (Bundle)localObject2;
              if (localObject2 != null) {}
            }
            for (paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath"); ((TextUtils.isEmpty(paramBundle)) || (paramBundle.equals("/"))) && (getIntent().getBooleanExtra("isFromShare", false)); paramBundle = ((ForwardFileInfo)localObject1).a())
            {
              this.jdField_f_of_type_Boolean = true;
              break;
            }
            if (this.j) {
              if ((this.jdField_h_of_type_Int == -1) || (this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 12)) {
                c();
              } else if (this.jdField_h_of_type_Int == 0) {
                if (localObject1 != null)
                {
                  if (DataLineHandler.a(this.app.a().a(((ForwardFileInfo)localObject1).b()))) {
                    c();
                  }
                }
                else
                {
                  c();
                  continue;
                  if (TextUtils.isEmpty(this.z)) {
                    break label2033;
                  }
                  paramBundle = this.app.a().a((String)localObject1);
                  if (paramBundle == null)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(2131363692);
                    this.jdField_a_of_type_AndroidOsHandler = new Handler();
                    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new dzv(this), 3000L);
                    this.app.a(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
                    this.app.a().d((String)localObject1);
                  }
                  else
                  {
                    if (this.z.equals(paramBundle.openID)) {
                      break label2028;
                    }
                    a();
                    continue;
                    Util.a(this.app, null, "pageview", this.jdField_a_of_type_Long, i1, "");
                    continue;
                    if (this.jdField_i_of_type_Int == 2)
                    {
                      paramBundle = "3";
                    }
                    else if (this.jdField_i_of_type_Int == 5)
                    {
                      paramBundle = "2";
                    }
                    else
                    {
                      paramBundle = "4";
                      continue;
                      i1 = 0;
                      continue;
                      localObject1 = null;
                      continue;
                      bool1 = true;
                      continue;
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (localObject1 != null)
    {
      i1 = ((ForwardFileInfo)localObject1).d();
      paramBundle = ((ForwardFileInfo)localObject1).a();
      if (TextUtils.isEmpty(paramBundle)) {
        break label1997;
      }
      bool1 = true;
      this.jdField_e_of_type_Boolean = bool1;
      if (i1 != 2) {
        break label2003;
      }
      bool1 = true;
      this.jdField_h_of_type_Boolean = bool1;
      if (!this.jdField_e_of_type_Boolean) {
        break label2009;
      }
      if (i1 == 3) {
        break label1983;
      }
      if (!FileUtils.a(paramBundle)) {
        break label2009;
      }
      break label1983;
      this.jdField_f_of_type_Boolean = bool1;
      if (this.jdField_h_of_type_Int != 0) {
        break label1275;
      }
      this.m = true;
      this.k = false;
      this.n = false;
      this.o = false;
      this.q = true;
      if (!this.jdField_f_of_type_Boolean) {
        this.l = false;
      }
      if ((localObject1 != null) && ((((ForwardFileInfo)localObject1).b() == 10006) || (((ForwardFileInfo)localObject1).b() == 10003) || (((ForwardFileInfo)localObject1).b() == 10002))) {
        this.l = true;
      }
      if ((localObject1 != null) && (((ForwardFileInfo)localObject1).b() == 10006))
      {
        this.jdField_g_of_type_Boolean = true;
        if ((this.jdField_e_of_type_Boolean) && (FileUtils.a(((ForwardFileInfo)localObject1).a()))) {}
        this.m = true;
        this.k = false;
        this.q = true;
        this.l = true;
        this.p = true;
      }
      if (((this.jdField_h_of_type_Int == 1001) || (this.jdField_h_of_type_Int == -4)) && (this.jdField_i_of_type_Int == 13))
      {
        this.m = false;
        this.k = false;
        this.l = false;
        this.n = false;
      }
      if (this.jdField_h_of_type_Int == 14) {
        ReportController.b(this.app, "CliOper", "", "", "ep_mall", "Clk_send_nonaio", 0, 0, "", "", "", localIntent.getIntExtra("FORWARD_EMOPGK_ID", -1) + "");
      }
      paramBundle = (PhoneContactManager)this.app.getManager(10);
      if ((paramBundle != null) && (!paramBundle.g())) {
        this.k = false;
      }
      localObject2 = (FriendManager)this.app.getManager(8);
      paramBundle = (ContactFacade)this.app.getManager(52);
      if ((localObject2 != null) && (paramBundle != null))
      {
        i2 = 0;
        localArrayList = paramBundle.a("-1004");
        i1 = i2;
        if (localArrayList != null)
        {
          i1 = i2;
          if (localArrayList.size() > 0) {
            i1 = 1;
          }
        }
        if (i1 == 0) {
          this.m = false;
        }
        i2 = 0;
        localArrayList = paramBundle.a("-1003");
        i1 = i2;
        if (localArrayList != null)
        {
          i1 = i2;
          if (localArrayList.size() > 0) {
            i1 = 1;
          }
        }
        if (i1 == 0) {
          this.l = false;
        }
        localObject2 = ((FriendManager)localObject2).c();
        if (localObject2 == null) {
          break label1972;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
      }
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localArrayList = paramBundle.a(String.valueOf(((Groups)((Iterator)localObject2).next()).group_id));
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            i1 = 1;
            if (i1 == 0) {
              this.p = false;
            }
            this.jdField_i_of_type_Boolean = localIntent.getBooleanExtra("k_qzone", false);
            if ("com.tencent.intent.QQ_FORWARD".equals(localIntent.getAction())) {
              break label1989;
            }
            if ((!this.jdField_i_of_type_Boolean) || (!localIntent.getBooleanExtra("k_send", true))) {
              break label2015;
            }
            break label1989;
            this.jdField_b_of_type_Boolean = bool1;
            if (localIntent.getBooleanExtra("sendMultiple", false)) {
              if (this.jdField_h_of_type_Int == 12)
              {
                this.j = localIntent.getBooleanExtra("k_dataline", true);
                if (this.jdField_h_of_type_Int != 11) {
                  break label1712;
                }
                c();
                if (this.app.a() == null) {
                  finish();
                }
                d();
                this.z = localIntent.getStringExtra("open_id");
                this.A = localIntent.getStringExtra("share_uin");
                this.jdField_a_of_type_Long = localIntent.getLongExtra("req_share_id", 0L);
                localObject1 = String.valueOf(this.jdField_a_of_type_Long);
                this.jdField_c_of_type_Boolean = "login".equals(localIntent.getStringExtra("jfrom"));
                i1 = 0;
                if (this.jdField_c_of_type_Boolean) {
                  break label2038;
                }
                if ((TextUtils.isEmpty(this.A)) || (this.A.equals(this.app.getAccount()))) {
                  break label1798;
                }
                a();
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i1 != 0) && (this.jdField_b_of_type_Boolean) && (this.jdField_h_of_type_Int == 11)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a("-1010", -1, "", getString(2131363525));
      }
      if (this.jdField_h_of_type_Int == 11)
      {
        localTextView.setText(2131368385);
        i1 = this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.b();
        if (this.jdField_i_of_type_Int == 5)
        {
          Util.a(this.app, null, "connect_sharepic", "pageview", this.jdField_a_of_type_Long, i1, "");
          StatisticCollector.a(BaseApplication.getContext()).a(this.app, "sha_pageview", 1, "", "", (String)localObject1);
          ReportController.b(this.app, "CliOper", "", "", "0X8006599", "0X8006599", 0, 0, "", "", "", "");
          if (this.jdField_i_of_type_Int != 1) {
            break label1935;
          }
          paramBundle = "1";
          ReportCenter.a().a(this.app.getAccount(), this.z, (String)localObject1, "10", "11", "0", paramBundle, "0", "0", false);
        }
      }
      else
      {
        b();
        break label1995;
        if (!getIntent().getBooleanExtra("isFromShare", false)) {
          break label311;
        }
        this.jdField_e_of_type_Boolean = true;
        this.jdField_f_of_type_Boolean = this.jdField_e_of_type_Boolean;
        break label311;
      }
      for (;;)
      {
        boolean bool2;
        label1712:
        label1995:
        return true;
        label1798:
        label1935:
        label1997:
        bool1 = false;
        break;
        label2003:
        bool1 = false;
        break label277;
        label2009:
        bool1 = false;
        break label305;
        label2015:
        bool1 = false;
        break label851;
        label2021:
        i1 += 1;
      }
      label2028:
      i1 = 1;
      continue;
      label2033:
      i1 = 1;
      continue;
      label2038:
      i1 = 1;
    }
  }
  
  protected void doOnDestroy()
  {
    this.app.c(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968583, 2130968584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity
 * JD-Core Version:    0.7.0.1
 */