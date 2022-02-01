package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import epv;
import epw;
import epx;
import epy;
import epz;
import eqb;
import eqc;
import java.util.ArrayList;
import java.util.List;

public class ProfileCardMoreActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  private static final int l = 11;
  private static final int m = 1;
  private static final int n = 2;
  private static final int p = 0;
  private static final int q = 1;
  private static final int r = -1;
  long jdField_a_of_type_Long;
  public Intent a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ProfileActivity.AllInOne a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new eqb(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new epz(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new epx(this);
  private ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new epy(this);
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public QQProgressDialog a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem b;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  public FormSimpleItem c;
  private String c;
  FormSimpleItem d;
  FormSimpleItem e;
  FormSimpleItem f;
  FormSimpleItem g;
  private int o = 0;
  
  /* Error */
  private int a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: invokevirtual 98	java/lang/String:trim	()Ljava/lang/String;
    //   8: invokevirtual 102	java/lang/String:length	()I
    //   11: ifne +5 -> 16
    //   14: iconst_m1
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 106	com/tencent/mobileqq/activity/ProfileCardMoreActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 111	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   23: invokevirtual 117	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   26: astore 11
    //   28: aload 11
    //   30: ifnull +3227 -> 3257
    //   33: aload 11
    //   35: ldc 119
    //   37: aload_1
    //   38: invokevirtual 124	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   41: checkcast 119	com/tencent/mobileqq/data/BmqqUserSimpleInfo
    //   44: astore 15
    //   46: aload 11
    //   48: ifnull +8 -> 56
    //   51: aload 11
    //   53: invokevirtual 126	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   56: aload 15
    //   58: ifnonnull +5 -> 63
    //   61: iconst_m1
    //   62: ireturn
    //   63: aload_0
    //   64: getfield 128	com/tencent/mobileqq/activity/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   67: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   70: ifne +834 -> 904
    //   73: aload_0
    //   74: getfield 128	com/tencent/mobileqq/activity/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   77: astore 13
    //   79: iconst_0
    //   80: istore_2
    //   81: iconst_0
    //   82: istore_3
    //   83: aconst_null
    //   84: astore 12
    //   86: aload_0
    //   87: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   90: astore 11
    //   92: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   95: astore 14
    //   97: new 146	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   104: ldc 149
    //   106: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 13
    //   111: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 155
    //   116: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 16
    //   124: aload 11
    //   126: aload 14
    //   128: iconst_4
    //   129: anewarray 94	java/lang/String
    //   132: dup
    //   133: iconst_0
    //   134: ldc 160
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: ldc 162
    //   141: aastore
    //   142: dup
    //   143: iconst_2
    //   144: ldc 164
    //   146: aastore
    //   147: dup
    //   148: iconst_3
    //   149: ldc 166
    //   151: aastore
    //   152: aload 16
    //   154: aconst_null
    //   155: aconst_null
    //   156: invokevirtual 172	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   159: astore 11
    //   161: iconst_0
    //   162: istore 4
    //   164: lconst_0
    //   165: lstore 8
    //   167: iload_3
    //   168: istore_2
    //   169: iload 4
    //   171: istore_3
    //   172: aload 11
    //   174: invokeinterface 178 1 0
    //   179: istore 10
    //   181: iload 10
    //   183: ifeq +3061 -> 3244
    //   186: aload 11
    //   188: iconst_0
    //   189: invokeinterface 182 2 0
    //   194: lstore 6
    //   196: iload_2
    //   197: istore 4
    //   199: aload 15
    //   201: getfield 185	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   204: astore 12
    //   206: aload 12
    //   208: ifnull +839 -> 1047
    //   211: aconst_null
    //   212: astore 14
    //   214: aload_0
    //   215: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   218: astore 12
    //   220: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   223: astore 16
    //   225: new 146	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   232: ldc 187
    //   234: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: lload 6
    //   239: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   242: ldc 192
    //   244: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc 164
    //   249: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 194
    //   254: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc 196
    //   259: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc 198
    //   264: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 166
    //   269: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc 194
    //   274: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload 15
    //   279: getfield 185	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   282: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc 198
    //   287: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc 200
    //   292: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc 194
    //   297: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: iconst_2
    //   301: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: ldc 155
    //   306: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: astore 17
    //   314: aload 12
    //   316: aload 16
    //   318: iconst_5
    //   319: anewarray 94	java/lang/String
    //   322: dup
    //   323: iconst_0
    //   324: ldc 160
    //   326: aastore
    //   327: dup
    //   328: iconst_1
    //   329: ldc 162
    //   331: aastore
    //   332: dup
    //   333: iconst_2
    //   334: ldc 164
    //   336: aastore
    //   337: dup
    //   338: iconst_3
    //   339: ldc 166
    //   341: aastore
    //   342: dup
    //   343: iconst_4
    //   344: ldc 200
    //   346: aastore
    //   347: aload 17
    //   349: aconst_null
    //   350: aconst_null
    //   351: invokevirtual 172	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   354: astore 12
    //   356: aload 12
    //   358: invokeinterface 206 1 0
    //   363: istore 10
    //   365: iload 10
    //   367: ifeq +568 -> 935
    //   370: iconst_1
    //   371: istore_3
    //   372: iconst_1
    //   373: istore_2
    //   374: aload 12
    //   376: astore 14
    //   378: aload 12
    //   380: ifnull +13 -> 393
    //   383: aload 12
    //   385: invokeinterface 209 1 0
    //   390: aconst_null
    //   391: astore 14
    //   393: aload 14
    //   395: ifnull +2842 -> 3237
    //   398: aload 14
    //   400: invokeinterface 209 1 0
    //   405: iconst_1
    //   406: istore_2
    //   407: iconst_1
    //   408: istore_3
    //   409: iload_3
    //   410: istore 5
    //   412: lload 6
    //   414: lstore 8
    //   416: iload_2
    //   417: istore 4
    //   419: aload 11
    //   421: ifnull +2803 -> 3224
    //   424: aload 11
    //   426: invokeinterface 209 1 0
    //   431: iload_3
    //   432: ifne +641 -> 1073
    //   435: iconst_1
    //   436: istore_3
    //   437: iconst_0
    //   438: istore_2
    //   439: new 211	android/content/ContentValues
    //   442: dup
    //   443: invokespecial 212	android/content/ContentValues:<init>	()V
    //   446: astore 14
    //   448: iload_3
    //   449: iconst_1
    //   450: if_icmpne +641 -> 1091
    //   453: aload_0
    //   454: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   457: getstatic 215	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   460: aload 14
    //   462: invokevirtual 219	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   465: invokestatic 225	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   468: lstore 6
    //   470: aload 13
    //   472: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   475: ifne +51 -> 526
    //   478: aload 14
    //   480: invokevirtual 228	android/content/ContentValues:clear	()V
    //   483: aload 14
    //   485: ldc 160
    //   487: lload 6
    //   489: invokestatic 234	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   492: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   495: aload 14
    //   497: ldc 164
    //   499: ldc 240
    //   501: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   504: aload 14
    //   506: ldc 166
    //   508: aload 13
    //   510: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   513: aload_0
    //   514: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   517: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   520: aload 14
    //   522: invokevirtual 219	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   525: pop
    //   526: aload 15
    //   528: getfield 246	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   531: ifnonnull +11 -> 542
    //   534: aload 15
    //   536: getfield 249	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   539: ifnull +93 -> 632
    //   542: aload 14
    //   544: invokevirtual 228	android/content/ContentValues:clear	()V
    //   547: aload 14
    //   549: ldc 160
    //   551: lload 6
    //   553: invokestatic 234	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   556: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   559: aload 14
    //   561: ldc 164
    //   563: ldc 251
    //   565: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: aload 15
    //   570: getfield 249	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   573: ifnull +15 -> 588
    //   576: aload 14
    //   578: ldc 166
    //   580: aload 15
    //   582: getfield 249	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   585: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   588: aload 15
    //   590: getfield 246	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   593: ifnull +15 -> 608
    //   596: aload 14
    //   598: ldc 253
    //   600: aload 15
    //   602: getfield 246	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   605: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   608: aload 14
    //   610: ldc 200
    //   612: iconst_1
    //   613: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   616: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   619: aload_0
    //   620: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   623: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   626: aload 14
    //   628: invokevirtual 219	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   631: pop
    //   632: aload 15
    //   634: getfield 185	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   637: ifnull +65 -> 702
    //   640: aload 14
    //   642: invokevirtual 228	android/content/ContentValues:clear	()V
    //   645: aload 14
    //   647: ldc 160
    //   649: lload 6
    //   651: invokestatic 234	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   654: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   657: aload 14
    //   659: ldc 164
    //   661: ldc 196
    //   663: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   666: aload 14
    //   668: ldc 166
    //   670: aload 15
    //   672: getfield 185	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   675: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   678: aload 14
    //   680: ldc 200
    //   682: iconst_2
    //   683: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   686: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   689: aload_0
    //   690: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   693: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   696: aload 14
    //   698: invokevirtual 219	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   701: pop
    //   702: aload 15
    //   704: getfield 264	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   707: ifnull +65 -> 772
    //   710: aload 14
    //   712: invokevirtual 228	android/content/ContentValues:clear	()V
    //   715: aload 14
    //   717: ldc 160
    //   719: lload 6
    //   721: invokestatic 234	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   724: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   727: aload 14
    //   729: ldc 164
    //   731: ldc 196
    //   733: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   736: aload 14
    //   738: ldc 166
    //   740: aload 15
    //   742: getfield 264	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   745: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   748: aload 14
    //   750: ldc 200
    //   752: iconst_3
    //   753: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   756: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   759: aload_0
    //   760: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   763: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   766: aload 14
    //   768: invokevirtual 219	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   771: pop
    //   772: aload 15
    //   774: getfield 267	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   777: ifnull +66 -> 843
    //   780: aload 14
    //   782: invokevirtual 228	android/content/ContentValues:clear	()V
    //   785: aload 14
    //   787: ldc 160
    //   789: lload 6
    //   791: invokestatic 234	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   794: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   797: aload 14
    //   799: ldc 164
    //   801: ldc_w 269
    //   804: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   807: aload 14
    //   809: ldc 166
    //   811: aload 15
    //   813: getfield 267	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   816: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   819: aload 14
    //   821: ldc 200
    //   823: iconst_2
    //   824: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   827: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   830: aload_0
    //   831: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   834: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   837: aload 14
    //   839: invokevirtual 219	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   842: pop
    //   843: aload 14
    //   845: invokevirtual 228	android/content/ContentValues:clear	()V
    //   848: aload 14
    //   850: ldc 160
    //   852: lload 6
    //   854: invokestatic 234	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   857: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   860: aload 14
    //   862: ldc 164
    //   864: ldc_w 271
    //   867: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   870: aload 14
    //   872: ldc 166
    //   874: aload_1
    //   875: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   878: aload 14
    //   880: ldc 200
    //   882: iconst_2
    //   883: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   886: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   889: aload_0
    //   890: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   893: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   896: aload 14
    //   898: invokevirtual 219	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   901: pop
    //   902: iconst_0
    //   903: ireturn
    //   904: aload 15
    //   906: getfield 274	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   909: ifnull +13 -> 922
    //   912: aload 15
    //   914: getfield 274	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   917: astore 13
    //   919: goto -840 -> 79
    //   922: aload_1
    //   923: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   926: ifne +2325 -> 3251
    //   929: aload_1
    //   930: astore 13
    //   932: goto -853 -> 79
    //   935: iconst_0
    //   936: istore_2
    //   937: iconst_0
    //   938: istore 4
    //   940: iload_2
    //   941: istore_3
    //   942: aload 12
    //   944: ifnull +2319 -> 3263
    //   947: iload 4
    //   949: istore_3
    //   950: aload 12
    //   952: invokeinterface 209 1 0
    //   957: iload_2
    //   958: istore_3
    //   959: goto +2304 -> 3263
    //   962: iload_2
    //   963: istore_3
    //   964: aload 12
    //   966: ifnull +2297 -> 3263
    //   969: iload_2
    //   970: istore_3
    //   971: aload 12
    //   973: invokeinterface 209 1 0
    //   978: iload_2
    //   979: istore_3
    //   980: goto +2283 -> 3263
    //   983: astore 12
    //   985: iload_3
    //   986: istore_2
    //   987: iconst_1
    //   988: istore_3
    //   989: iload_3
    //   990: istore 5
    //   992: lload 6
    //   994: lstore 8
    //   996: iload_2
    //   997: istore 4
    //   999: aload 11
    //   1001: ifnull +2223 -> 3224
    //   1004: aload 11
    //   1006: invokeinterface 209 1 0
    //   1011: goto -580 -> 431
    //   1014: astore 12
    //   1016: aload 14
    //   1018: ifnull +13 -> 1031
    //   1021: iload_2
    //   1022: istore 4
    //   1024: aload 14
    //   1026: invokeinterface 209 1 0
    //   1031: iload_2
    //   1032: istore 4
    //   1034: aload 12
    //   1036: athrow
    //   1037: astore 12
    //   1039: iconst_1
    //   1040: istore_3
    //   1041: iload 4
    //   1043: istore_2
    //   1044: goto -55 -> 989
    //   1047: iconst_0
    //   1048: istore_2
    //   1049: iconst_1
    //   1050: istore_3
    //   1051: goto -642 -> 409
    //   1054: astore_1
    //   1055: aload 12
    //   1057: astore 11
    //   1059: aload 11
    //   1061: ifnull +10 -> 1071
    //   1064: aload 11
    //   1066: invokeinterface 209 1 0
    //   1071: aload_1
    //   1072: athrow
    //   1073: iload_2
    //   1074: ifne +10 -> 1084
    //   1077: iconst_1
    //   1078: istore_3
    //   1079: iconst_0
    //   1080: istore_2
    //   1081: goto -642 -> 439
    //   1084: iconst_1
    //   1085: istore_2
    //   1086: iconst_0
    //   1087: istore_3
    //   1088: goto -649 -> 439
    //   1091: iload_2
    //   1092: iconst_1
    //   1093: if_icmpne +1995 -> 3088
    //   1096: aload 15
    //   1098: getfield 185	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1101: ifnull +118 -> 1219
    //   1104: aload 14
    //   1106: invokevirtual 228	android/content/ContentValues:clear	()V
    //   1109: aload 14
    //   1111: ldc 164
    //   1113: ldc 196
    //   1115: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1118: aload 14
    //   1120: ldc 166
    //   1122: aload 15
    //   1124: getfield 185	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1127: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1130: aload 14
    //   1132: ldc 200
    //   1134: iconst_2
    //   1135: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1138: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1141: aload_0
    //   1142: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1145: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1148: aload 14
    //   1150: new 146	java/lang/StringBuilder
    //   1153: dup
    //   1154: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1157: ldc 187
    //   1159: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: lload 6
    //   1164: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1167: ldc 192
    //   1169: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: ldc 164
    //   1174: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: ldc 194
    //   1179: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: ldc 196
    //   1184: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: ldc 198
    //   1189: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: ldc 200
    //   1194: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: ldc 194
    //   1199: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: iconst_2
    //   1203: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1206: ldc 155
    //   1208: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1214: aconst_null
    //   1215: invokevirtual 278	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1218: pop
    //   1219: aload 15
    //   1221: getfield 246	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1224: ifnull +266 -> 1490
    //   1227: aconst_null
    //   1228: astore 11
    //   1230: aload_0
    //   1231: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1234: astore 12
    //   1236: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1239: astore 13
    //   1241: new 146	java/lang/StringBuilder
    //   1244: dup
    //   1245: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1248: ldc 187
    //   1250: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: lload 6
    //   1255: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1258: ldc 192
    //   1260: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: ldc 164
    //   1265: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: ldc 194
    //   1270: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: ldc 251
    //   1275: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: ldc 198
    //   1280: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: ldc 200
    //   1285: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: ldc 194
    //   1290: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: iconst_1
    //   1294: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1297: ldc 155
    //   1299: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1305: astore 16
    //   1307: aload 12
    //   1309: aload 13
    //   1311: iconst_5
    //   1312: anewarray 94	java/lang/String
    //   1315: dup
    //   1316: iconst_0
    //   1317: ldc 160
    //   1319: aastore
    //   1320: dup
    //   1321: iconst_1
    //   1322: ldc 162
    //   1324: aastore
    //   1325: dup
    //   1326: iconst_2
    //   1327: ldc 164
    //   1329: aastore
    //   1330: dup
    //   1331: iconst_3
    //   1332: ldc 253
    //   1334: aastore
    //   1335: dup
    //   1336: iconst_4
    //   1337: ldc 200
    //   1339: aastore
    //   1340: aload 16
    //   1342: aconst_null
    //   1343: aconst_null
    //   1344: invokevirtual 172	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1347: astore 12
    //   1349: aload 12
    //   1351: astore 11
    //   1353: aload 11
    //   1355: invokeinterface 206 1 0
    //   1360: ifeq +1246 -> 2606
    //   1363: aload 14
    //   1365: invokevirtual 228	android/content/ContentValues:clear	()V
    //   1368: aload 14
    //   1370: ldc 164
    //   1372: ldc 251
    //   1374: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1377: aload 14
    //   1379: ldc 253
    //   1381: aload 15
    //   1383: getfield 246	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1386: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1389: aload 14
    //   1391: ldc 200
    //   1393: iconst_1
    //   1394: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1397: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1400: aload_0
    //   1401: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1404: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1407: aload 14
    //   1409: new 146	java/lang/StringBuilder
    //   1412: dup
    //   1413: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1416: ldc 187
    //   1418: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: lload 6
    //   1423: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1426: ldc 192
    //   1428: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: ldc 164
    //   1433: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: ldc 194
    //   1438: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: ldc 251
    //   1443: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: ldc 198
    //   1448: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1451: ldc 200
    //   1453: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: ldc 194
    //   1458: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: iconst_1
    //   1462: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1465: ldc 155
    //   1467: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1470: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1473: aconst_null
    //   1474: invokevirtual 278	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1477: pop
    //   1478: aload 11
    //   1480: ifnull +10 -> 1490
    //   1483: aload 11
    //   1485: invokeinterface 209 1 0
    //   1490: aload 15
    //   1492: getfield 249	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1495: ifnull +266 -> 1761
    //   1498: aconst_null
    //   1499: astore 11
    //   1501: aload_0
    //   1502: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1505: astore 12
    //   1507: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1510: astore 13
    //   1512: new 146	java/lang/StringBuilder
    //   1515: dup
    //   1516: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1519: ldc 187
    //   1521: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1524: lload 6
    //   1526: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1529: ldc 192
    //   1531: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: ldc 164
    //   1536: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: ldc 194
    //   1541: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1544: ldc 251
    //   1546: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1549: ldc 198
    //   1551: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: ldc 200
    //   1556: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: ldc 194
    //   1561: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: iconst_1
    //   1565: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1568: ldc 155
    //   1570: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1576: astore 16
    //   1578: aload 12
    //   1580: aload 13
    //   1582: iconst_5
    //   1583: anewarray 94	java/lang/String
    //   1586: dup
    //   1587: iconst_0
    //   1588: ldc 160
    //   1590: aastore
    //   1591: dup
    //   1592: iconst_1
    //   1593: ldc 162
    //   1595: aastore
    //   1596: dup
    //   1597: iconst_2
    //   1598: ldc 164
    //   1600: aastore
    //   1601: dup
    //   1602: iconst_3
    //   1603: ldc 166
    //   1605: aastore
    //   1606: dup
    //   1607: iconst_4
    //   1608: ldc 200
    //   1610: aastore
    //   1611: aload 16
    //   1613: aconst_null
    //   1614: aconst_null
    //   1615: invokevirtual 172	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1618: astore 12
    //   1620: aload 12
    //   1622: astore 11
    //   1624: aload 11
    //   1626: invokeinterface 206 1 0
    //   1631: ifeq +1072 -> 2703
    //   1634: aload 14
    //   1636: invokevirtual 228	android/content/ContentValues:clear	()V
    //   1639: aload 14
    //   1641: ldc 164
    //   1643: ldc 251
    //   1645: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1648: aload 14
    //   1650: ldc 166
    //   1652: aload 15
    //   1654: getfield 249	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1657: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1660: aload 14
    //   1662: ldc 200
    //   1664: iconst_1
    //   1665: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1668: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1671: aload_0
    //   1672: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1675: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1678: aload 14
    //   1680: new 146	java/lang/StringBuilder
    //   1683: dup
    //   1684: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1687: ldc 187
    //   1689: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1692: lload 6
    //   1694: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1697: ldc 192
    //   1699: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1702: ldc 164
    //   1704: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: ldc 194
    //   1709: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1712: ldc 251
    //   1714: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1717: ldc 198
    //   1719: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1722: ldc 200
    //   1724: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1727: ldc 194
    //   1729: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: iconst_1
    //   1733: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1736: ldc 155
    //   1738: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1741: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1744: aconst_null
    //   1745: invokevirtual 278	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1748: pop
    //   1749: aload 11
    //   1751: ifnull +10 -> 1761
    //   1754: aload 11
    //   1756: invokeinterface 209 1 0
    //   1761: aload 15
    //   1763: getfield 264	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1766: ifnull +278 -> 2044
    //   1769: aconst_null
    //   1770: astore 11
    //   1772: aload_0
    //   1773: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1776: astore 12
    //   1778: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1781: astore 13
    //   1783: new 146	java/lang/StringBuilder
    //   1786: dup
    //   1787: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1790: ldc 187
    //   1792: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1795: lload 6
    //   1797: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1800: ldc 192
    //   1802: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: ldc 164
    //   1807: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1810: ldc 194
    //   1812: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1815: ldc 196
    //   1817: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1820: ldc 198
    //   1822: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1825: ldc 200
    //   1827: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1830: ldc 194
    //   1832: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1835: iconst_3
    //   1836: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1839: ldc 155
    //   1841: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1847: astore 16
    //   1849: aload 12
    //   1851: aload 13
    //   1853: iconst_5
    //   1854: anewarray 94	java/lang/String
    //   1857: dup
    //   1858: iconst_0
    //   1859: ldc 160
    //   1861: aastore
    //   1862: dup
    //   1863: iconst_1
    //   1864: ldc 162
    //   1866: aastore
    //   1867: dup
    //   1868: iconst_2
    //   1869: ldc 164
    //   1871: aastore
    //   1872: dup
    //   1873: iconst_3
    //   1874: ldc 166
    //   1876: aastore
    //   1877: dup
    //   1878: iconst_4
    //   1879: ldc 200
    //   1881: aastore
    //   1882: aload 16
    //   1884: aconst_null
    //   1885: aconst_null
    //   1886: invokevirtual 172	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1889: astore 12
    //   1891: aload 12
    //   1893: astore 11
    //   1895: aload 11
    //   1897: invokeinterface 206 1 0
    //   1902: ifeq +898 -> 2800
    //   1905: aload 14
    //   1907: invokevirtual 228	android/content/ContentValues:clear	()V
    //   1910: aload 14
    //   1912: ldc 160
    //   1914: lload 6
    //   1916: invokestatic 234	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1919: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1922: aload 14
    //   1924: ldc 164
    //   1926: ldc 196
    //   1928: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1931: aload 14
    //   1933: ldc 166
    //   1935: aload 15
    //   1937: getfield 264	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1940: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1943: aload 14
    //   1945: ldc 200
    //   1947: iconst_3
    //   1948: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1951: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1954: aload_0
    //   1955: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1958: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1961: aload 14
    //   1963: new 146	java/lang/StringBuilder
    //   1966: dup
    //   1967: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1970: ldc 187
    //   1972: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1975: lload 6
    //   1977: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1980: ldc 192
    //   1982: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1985: ldc 164
    //   1987: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1990: ldc 194
    //   1992: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1995: ldc 196
    //   1997: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2000: ldc 198
    //   2002: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2005: ldc 200
    //   2007: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2010: ldc 194
    //   2012: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2015: iconst_3
    //   2016: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2019: ldc 155
    //   2021: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2024: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2027: aconst_null
    //   2028: invokevirtual 278	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2031: pop
    //   2032: aload 11
    //   2034: ifnull +10 -> 2044
    //   2037: aload 11
    //   2039: invokeinterface 209 1 0
    //   2044: aload 15
    //   2046: getfield 267	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2049: ifnull +281 -> 2330
    //   2052: aconst_null
    //   2053: astore 11
    //   2055: aload_0
    //   2056: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2059: astore 12
    //   2061: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2064: astore 13
    //   2066: new 146	java/lang/StringBuilder
    //   2069: dup
    //   2070: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   2073: ldc 187
    //   2075: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2078: lload 6
    //   2080: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2083: ldc 192
    //   2085: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2088: ldc 164
    //   2090: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2093: ldc 194
    //   2095: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2098: ldc_w 269
    //   2101: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2104: ldc 198
    //   2106: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2109: ldc 200
    //   2111: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2114: ldc 194
    //   2116: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2119: iconst_2
    //   2120: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2123: ldc 155
    //   2125: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2128: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2131: astore 16
    //   2133: aload 12
    //   2135: aload 13
    //   2137: iconst_5
    //   2138: anewarray 94	java/lang/String
    //   2141: dup
    //   2142: iconst_0
    //   2143: ldc 160
    //   2145: aastore
    //   2146: dup
    //   2147: iconst_1
    //   2148: ldc 162
    //   2150: aastore
    //   2151: dup
    //   2152: iconst_2
    //   2153: ldc 164
    //   2155: aastore
    //   2156: dup
    //   2157: iconst_3
    //   2158: ldc 166
    //   2160: aastore
    //   2161: dup
    //   2162: iconst_4
    //   2163: ldc 200
    //   2165: aastore
    //   2166: aload 16
    //   2168: aconst_null
    //   2169: aconst_null
    //   2170: invokevirtual 172	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2173: astore 12
    //   2175: aload 12
    //   2177: astore 11
    //   2179: aload 11
    //   2181: invokeinterface 206 1 0
    //   2186: ifeq +711 -> 2897
    //   2189: aload 14
    //   2191: invokevirtual 228	android/content/ContentValues:clear	()V
    //   2194: aload 14
    //   2196: ldc 160
    //   2198: lload 6
    //   2200: invokestatic 234	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2203: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2206: aload 14
    //   2208: ldc 164
    //   2210: ldc_w 269
    //   2213: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2216: aload 14
    //   2218: ldc 166
    //   2220: aload 15
    //   2222: getfield 267	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2225: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2228: aload 14
    //   2230: ldc 200
    //   2232: iconst_2
    //   2233: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2236: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2239: aload_0
    //   2240: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2243: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2246: aload 14
    //   2248: new 146	java/lang/StringBuilder
    //   2251: dup
    //   2252: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   2255: ldc 187
    //   2257: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2260: lload 6
    //   2262: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2265: ldc 192
    //   2267: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2270: ldc 164
    //   2272: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2275: ldc 194
    //   2277: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2280: ldc_w 269
    //   2283: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2286: ldc 198
    //   2288: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2291: ldc 200
    //   2293: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2296: ldc 194
    //   2298: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2301: iconst_2
    //   2302: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2305: ldc 155
    //   2307: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2310: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2313: aconst_null
    //   2314: invokevirtual 278	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2317: pop
    //   2318: aload 11
    //   2320: ifnull +10 -> 2330
    //   2323: aload 11
    //   2325: invokeinterface 209 1 0
    //   2330: aconst_null
    //   2331: astore 11
    //   2333: aload_0
    //   2334: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2337: astore 12
    //   2339: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2342: astore 13
    //   2344: new 146	java/lang/StringBuilder
    //   2347: dup
    //   2348: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   2351: ldc 187
    //   2353: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2356: lload 6
    //   2358: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2361: ldc 192
    //   2363: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2366: ldc 164
    //   2368: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2371: ldc 194
    //   2373: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2376: ldc_w 271
    //   2379: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2382: ldc 198
    //   2384: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2387: ldc 200
    //   2389: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2392: ldc 194
    //   2394: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2397: iconst_2
    //   2398: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2401: ldc 155
    //   2403: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2406: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2409: astore 15
    //   2411: aload 12
    //   2413: aload 13
    //   2415: iconst_5
    //   2416: anewarray 94	java/lang/String
    //   2419: dup
    //   2420: iconst_0
    //   2421: ldc 160
    //   2423: aastore
    //   2424: dup
    //   2425: iconst_1
    //   2426: ldc 162
    //   2428: aastore
    //   2429: dup
    //   2430: iconst_2
    //   2431: ldc 164
    //   2433: aastore
    //   2434: dup
    //   2435: iconst_3
    //   2436: ldc 166
    //   2438: aastore
    //   2439: dup
    //   2440: iconst_4
    //   2441: ldc 200
    //   2443: aastore
    //   2444: aload 15
    //   2446: aconst_null
    //   2447: aconst_null
    //   2448: invokevirtual 172	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2451: astore 12
    //   2453: aload 12
    //   2455: astore 11
    //   2457: aload 11
    //   2459: invokeinterface 206 1 0
    //   2464: ifeq +531 -> 2995
    //   2467: aload 14
    //   2469: invokevirtual 228	android/content/ContentValues:clear	()V
    //   2472: aload 14
    //   2474: ldc 160
    //   2476: lload 6
    //   2478: invokestatic 234	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2481: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2484: aload 14
    //   2486: ldc 164
    //   2488: ldc_w 271
    //   2491: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2494: aload 14
    //   2496: ldc 166
    //   2498: aload_1
    //   2499: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2502: aload 14
    //   2504: ldc 200
    //   2506: iconst_2
    //   2507: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2510: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2513: aload_0
    //   2514: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2517: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2520: aload 14
    //   2522: new 146	java/lang/StringBuilder
    //   2525: dup
    //   2526: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   2529: ldc 187
    //   2531: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2534: lload 6
    //   2536: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2539: ldc 192
    //   2541: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2544: ldc 164
    //   2546: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2549: ldc 194
    //   2551: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2554: ldc_w 271
    //   2557: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2560: ldc 198
    //   2562: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2565: ldc 200
    //   2567: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2570: ldc 194
    //   2572: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2575: iconst_2
    //   2576: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2579: ldc 155
    //   2581: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2584: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2587: aconst_null
    //   2588: invokevirtual 278	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2591: pop
    //   2592: aload 11
    //   2594: ifnull +10 -> 2604
    //   2597: aload 11
    //   2599: invokeinterface 209 1 0
    //   2604: iconst_1
    //   2605: ireturn
    //   2606: aload 14
    //   2608: invokevirtual 228	android/content/ContentValues:clear	()V
    //   2611: aload 14
    //   2613: ldc 160
    //   2615: lload 6
    //   2617: invokestatic 234	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2620: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2623: aload 14
    //   2625: ldc 164
    //   2627: ldc 251
    //   2629: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2632: aload 14
    //   2634: ldc 253
    //   2636: aload 15
    //   2638: getfield 246	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   2641: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2644: aload 14
    //   2646: ldc 200
    //   2648: iconst_1
    //   2649: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2652: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2655: aload_0
    //   2656: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2659: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2662: aload 14
    //   2664: invokevirtual 219	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2667: pop
    //   2668: goto -1190 -> 1478
    //   2671: astore 12
    //   2673: aload 11
    //   2675: ifnull -1185 -> 1490
    //   2678: aload 11
    //   2680: invokeinterface 209 1 0
    //   2685: goto -1195 -> 1490
    //   2688: astore_1
    //   2689: aload 11
    //   2691: ifnull +10 -> 2701
    //   2694: aload 11
    //   2696: invokeinterface 209 1 0
    //   2701: aload_1
    //   2702: athrow
    //   2703: aload 14
    //   2705: invokevirtual 228	android/content/ContentValues:clear	()V
    //   2708: aload 14
    //   2710: ldc 160
    //   2712: lload 6
    //   2714: invokestatic 234	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2717: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2720: aload 14
    //   2722: ldc 164
    //   2724: ldc 251
    //   2726: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2729: aload 14
    //   2731: ldc 166
    //   2733: aload 15
    //   2735: getfield 249	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   2738: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2741: aload 14
    //   2743: ldc 200
    //   2745: iconst_1
    //   2746: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2749: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2752: aload_0
    //   2753: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2756: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2759: aload 14
    //   2761: invokevirtual 219	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2764: pop
    //   2765: goto -1016 -> 1749
    //   2768: astore 12
    //   2770: aload 11
    //   2772: ifnull -1011 -> 1761
    //   2775: aload 11
    //   2777: invokeinterface 209 1 0
    //   2782: goto -1021 -> 1761
    //   2785: astore_1
    //   2786: aload 11
    //   2788: ifnull +10 -> 2798
    //   2791: aload 11
    //   2793: invokeinterface 209 1 0
    //   2798: aload_1
    //   2799: athrow
    //   2800: aload 14
    //   2802: invokevirtual 228	android/content/ContentValues:clear	()V
    //   2805: aload 14
    //   2807: ldc 160
    //   2809: lload 6
    //   2811: invokestatic 234	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2814: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2817: aload 14
    //   2819: ldc 164
    //   2821: ldc 196
    //   2823: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2826: aload 14
    //   2828: ldc 166
    //   2830: aload 15
    //   2832: getfield 264	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   2835: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2838: aload 14
    //   2840: ldc 200
    //   2842: iconst_3
    //   2843: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2846: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2849: aload_0
    //   2850: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2853: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2856: aload 14
    //   2858: invokevirtual 219	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2861: pop
    //   2862: goto -830 -> 2032
    //   2865: astore 12
    //   2867: aload 11
    //   2869: ifnull -825 -> 2044
    //   2872: aload 11
    //   2874: invokeinterface 209 1 0
    //   2879: goto -835 -> 2044
    //   2882: astore_1
    //   2883: aload 11
    //   2885: ifnull +10 -> 2895
    //   2888: aload 11
    //   2890: invokeinterface 209 1 0
    //   2895: aload_1
    //   2896: athrow
    //   2897: aload 14
    //   2899: invokevirtual 228	android/content/ContentValues:clear	()V
    //   2902: aload 14
    //   2904: ldc 160
    //   2906: lload 6
    //   2908: invokestatic 234	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2911: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2914: aload 14
    //   2916: ldc 164
    //   2918: ldc_w 269
    //   2921: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2924: aload 14
    //   2926: ldc 166
    //   2928: aload 15
    //   2930: getfield 267	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2933: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2936: aload 14
    //   2938: ldc 200
    //   2940: iconst_2
    //   2941: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2944: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2947: aload_0
    //   2948: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2951: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2954: aload 14
    //   2956: invokevirtual 219	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2959: pop
    //   2960: goto -642 -> 2318
    //   2963: astore 12
    //   2965: aload 11
    //   2967: ifnull -637 -> 2330
    //   2970: aload 11
    //   2972: invokeinterface 209 1 0
    //   2977: goto -647 -> 2330
    //   2980: astore_1
    //   2981: aload 11
    //   2983: ifnull +10 -> 2993
    //   2986: aload 11
    //   2988: invokeinterface 209 1 0
    //   2993: aload_1
    //   2994: athrow
    //   2995: aload 14
    //   2997: invokevirtual 228	android/content/ContentValues:clear	()V
    //   3000: aload 14
    //   3002: ldc 160
    //   3004: lload 6
    //   3006: invokestatic 234	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3009: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3012: aload 14
    //   3014: ldc 164
    //   3016: ldc_w 271
    //   3019: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3022: aload 14
    //   3024: ldc 166
    //   3026: aload_1
    //   3027: invokevirtual 243	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3030: aload 14
    //   3032: ldc 200
    //   3034: iconst_2
    //   3035: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3038: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3041: aload_0
    //   3042: invokevirtual 138	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3045: getstatic 144	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3048: aload 14
    //   3050: invokevirtual 219	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3053: pop
    //   3054: goto -462 -> 2592
    //   3057: astore_1
    //   3058: aload 11
    //   3060: ifnull -456 -> 2604
    //   3063: aload 11
    //   3065: invokeinterface 209 1 0
    //   3070: goto -466 -> 2604
    //   3073: astore_1
    //   3074: aload 11
    //   3076: ifnull +10 -> 3086
    //   3079: aload 11
    //   3081: invokeinterface 209 1 0
    //   3086: aload_1
    //   3087: athrow
    //   3088: iconst_m1
    //   3089: ireturn
    //   3090: astore_1
    //   3091: goto -17 -> 3074
    //   3094: astore_1
    //   3095: aconst_null
    //   3096: astore 11
    //   3098: goto -40 -> 3058
    //   3101: astore_1
    //   3102: goto -121 -> 2981
    //   3105: astore 11
    //   3107: aconst_null
    //   3108: astore 11
    //   3110: goto -145 -> 2965
    //   3113: astore_1
    //   3114: goto -231 -> 2883
    //   3117: astore 11
    //   3119: aconst_null
    //   3120: astore 11
    //   3122: goto -255 -> 2867
    //   3125: astore_1
    //   3126: goto -340 -> 2786
    //   3129: astore 11
    //   3131: aconst_null
    //   3132: astore 11
    //   3134: goto -364 -> 2770
    //   3137: astore_1
    //   3138: goto -449 -> 2689
    //   3141: astore 11
    //   3143: aconst_null
    //   3144: astore 11
    //   3146: goto -473 -> 2673
    //   3149: astore_1
    //   3150: goto -2091 -> 1059
    //   3153: astore 11
    //   3155: aconst_null
    //   3156: astore 11
    //   3158: iconst_0
    //   3159: istore_3
    //   3160: lconst_0
    //   3161: lstore 6
    //   3163: goto -2174 -> 989
    //   3166: astore 12
    //   3168: lload 8
    //   3170: lstore 6
    //   3172: goto -2183 -> 989
    //   3175: astore 12
    //   3177: lload 8
    //   3179: lstore 6
    //   3181: iconst_1
    //   3182: istore_3
    //   3183: goto -2194 -> 989
    //   3186: astore 16
    //   3188: aload 12
    //   3190: astore 14
    //   3192: aload 16
    //   3194: astore 12
    //   3196: goto -2180 -> 1016
    //   3199: astore 16
    //   3201: aload 12
    //   3203: astore 14
    //   3205: iconst_1
    //   3206: istore_2
    //   3207: aload 16
    //   3209: astore 12
    //   3211: goto -2195 -> 1016
    //   3214: astore 14
    //   3216: goto -2254 -> 962
    //   3219: astore 14
    //   3221: goto -2259 -> 962
    //   3224: lload 8
    //   3226: lstore 6
    //   3228: iload 5
    //   3230: istore_3
    //   3231: iload 4
    //   3233: istore_2
    //   3234: goto -2803 -> 431
    //   3237: iconst_1
    //   3238: istore_2
    //   3239: iconst_1
    //   3240: istore_3
    //   3241: goto -2832 -> 409
    //   3244: lload 8
    //   3246: lstore 6
    //   3248: goto -2839 -> 409
    //   3251: aconst_null
    //   3252: astore 13
    //   3254: goto -3175 -> 79
    //   3257: aconst_null
    //   3258: astore 15
    //   3260: goto -3214 -> 46
    //   3263: iload_3
    //   3264: istore_2
    //   3265: iconst_1
    //   3266: istore_3
    //   3267: lload 6
    //   3269: lstore 8
    //   3271: goto -3099 -> 172
    //   3274: astore 12
    //   3276: aconst_null
    //   3277: astore 12
    //   3279: goto -2317 -> 962
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3282	0	this	ProfileCardMoreActivity
    //   0	3282	1	paramString	String
    //   80	3185	2	i1	int
    //   82	3185	3	i2	int
    //   162	3070	4	i3	int
    //   410	2819	5	i4	int
    //   194	3074	6	l1	long
    //   165	3105	8	l2	long
    //   179	187	10	bool	boolean
    //   26	3071	11	localObject1	Object
    //   3105	1	11	localException1	Exception
    //   3108	1	11	localObject2	Object
    //   3117	1	11	localException2	Exception
    //   3120	1	11	localObject3	Object
    //   3129	1	11	localException3	Exception
    //   3132	1	11	localObject4	Object
    //   3141	1	11	localException4	Exception
    //   3144	1	11	localObject5	Object
    //   3153	1	11	localException5	Exception
    //   3156	1	11	localObject6	Object
    //   84	888	12	localObject7	Object
    //   983	1	12	localException6	Exception
    //   1014	21	12	localObject8	Object
    //   1037	19	12	localException7	Exception
    //   1234	1220	12	localObject9	Object
    //   2671	1	12	localException8	Exception
    //   2768	1	12	localException9	Exception
    //   2865	1	12	localException10	Exception
    //   2963	1	12	localException11	Exception
    //   3166	1	12	localException12	Exception
    //   3175	14	12	localException13	Exception
    //   3194	16	12	localObject10	Object
    //   3274	1	12	localException14	Exception
    //   3277	1	12	localObject11	Object
    //   77	3176	13	localObject12	Object
    //   95	3109	14	localObject13	Object
    //   3214	1	14	localException15	Exception
    //   3219	1	14	localException16	Exception
    //   44	3215	15	localObject14	Object
    //   122	2045	16	localObject15	Object
    //   3186	7	16	localObject16	Object
    //   3199	9	16	localObject17	Object
    //   312	36	17	str	String
    // Exception table:
    //   from	to	target	type
    //   398	405	983	java/lang/Exception
    //   950	957	983	java/lang/Exception
    //   971	978	983	java/lang/Exception
    //   214	356	1014	finally
    //   199	206	1037	java/lang/Exception
    //   1024	1031	1037	java/lang/Exception
    //   1034	1037	1037	java/lang/Exception
    //   86	161	1054	finally
    //   1353	1478	2671	java/lang/Exception
    //   2606	2668	2671	java/lang/Exception
    //   1230	1349	2688	finally
    //   1624	1749	2768	java/lang/Exception
    //   2703	2765	2768	java/lang/Exception
    //   1501	1620	2785	finally
    //   1895	2032	2865	java/lang/Exception
    //   2800	2862	2865	java/lang/Exception
    //   1772	1891	2882	finally
    //   2179	2318	2963	java/lang/Exception
    //   2897	2960	2963	java/lang/Exception
    //   2055	2175	2980	finally
    //   2457	2592	3057	java/lang/Exception
    //   2995	3054	3057	java/lang/Exception
    //   2333	2453	3073	finally
    //   2457	2592	3090	finally
    //   2995	3054	3090	finally
    //   2333	2453	3094	java/lang/Exception
    //   2179	2318	3101	finally
    //   2897	2960	3101	finally
    //   2055	2175	3105	java/lang/Exception
    //   1895	2032	3113	finally
    //   2800	2862	3113	finally
    //   1772	1891	3117	java/lang/Exception
    //   1624	1749	3125	finally
    //   2703	2765	3125	finally
    //   1501	1620	3129	java/lang/Exception
    //   1353	1478	3137	finally
    //   2606	2668	3137	finally
    //   1230	1349	3141	java/lang/Exception
    //   172	181	3149	finally
    //   186	196	3149	finally
    //   199	206	3149	finally
    //   398	405	3149	finally
    //   950	957	3149	finally
    //   971	978	3149	finally
    //   1024	1031	3149	finally
    //   1034	1037	3149	finally
    //   86	161	3153	java/lang/Exception
    //   172	181	3166	java/lang/Exception
    //   186	196	3175	java/lang/Exception
    //   356	365	3186	finally
    //   383	390	3199	finally
    //   356	365	3214	java/lang/Exception
    //   383	390	3219	java/lang/Exception
    //   214	356	3274	java/lang/Exception
  }
  
  private String a()
  {
    Object localObject = null;
    try
    {
      String str = ContactUtils.d(this.app, this.jdField_a_of_type_JavaLangString);
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
  
  private void a(int paramInt1, FormSimpleItem paramFormSimpleItem, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.jdField_a_of_type_ArrayOfInt.length) || (paramFormSimpleItem == null)) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfInt[paramInt1] == 1)
    {
      paramFormSimpleItem.setVisibility(0);
      paramFormSimpleItem.setOnClickListener(this);
      return;
    }
    paramFormSimpleItem.setVisibility(8);
  }
  
  private boolean a()
  {
    ShieldMsgManger localShieldMsgManger = null;
    Object localObject = null;
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      localShieldMsgManger = (ShieldMsgManger)this.app.getManager(15);
      if (localShieldMsgManger == null) {
        break label152;
      }
      if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      return localShieldMsgManger.a((String)localObject);
      localObject = (FriendManager)this.app.getManager(8);
      if (localObject == null) {}
      for (localObject = localShieldMsgManger; (localObject != null) && (((Friends)localObject).groupid == -1002); localObject = ((FriendManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        return true;
      }
      return false;
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = a();
      }
    }
    label152:
    return false;
  }
  
  protected ProfileActivity.CardContactInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    return localObject1;
  }
  
  void a()
  {
    setContentViewB(2130903991);
    setTitle(2131369357);
    this.leftView.setText(2131366374);
    this.rightViewText.setVisibility(8);
    Object localObject1 = findViewById(2131297149);
    if (this.jdField_a_of_type_ArrayOfInt[9] == 1)
    {
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      localObject1 = findViewById(2131297159);
      if (this.jdField_a_of_type_ArrayOfInt[10] != 1) {
        break label199;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      label98:
      if (!BmqqSegmentUtil.a(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        break label209;
      }
    }
    int i1;
    int i5;
    int i2;
    int i3;
    label199:
    label209:
    for (int i4 = 3;; i4 = 2)
    {
      i1 = 0;
      i5 = -1;
      int i6;
      for (i2 = -1; i1 <= i4; i2 = i6)
      {
        int i7 = i5;
        i6 = i2;
        if (this.jdField_a_of_type_ArrayOfInt[i1] == 1)
        {
          i3 = i2;
          if (i2 < 0) {
            i3 = i1;
          }
          i7 = i5;
          i6 = i3;
          if (i5 < i1)
          {
            i7 = i1;
            i6 = i3;
          }
        }
        i1 += 1;
        i5 = i7;
      }
      ((View)localObject1).setVisibility(8);
      break;
      ((View)localObject1).setVisibility(8);
      break label98;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131300381));
    a(0, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, i2, i5);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131300382));
    a(1, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, i2, i5);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131300383));
    a(2, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, i2, i5);
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 8) && (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 8)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(0);
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 8) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(0);
    }
    this.e = ((FormSimpleItem)findViewById(2131300384));
    if (BmqqSegmentUtil.a(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      a(3, this.e, i2, i5);
      this.d = ((FormSimpleItem)findViewById(2131300385));
      this.d.setContentDescription("推荐该联系人");
      a(4, this.d, 4, 4);
      i1 = 5;
      i2 = -1;
      i3 = -1;
      label429:
      if (i1 > 8) {
        break label477;
      }
      if (this.jdField_a_of_type_ArrayOfInt[i1] != 1) {
        break label1131;
      }
      if (i3 >= 0) {
        break label1128;
      }
      i3 = i1;
      label451:
      if (i2 >= i1) {
        break label1125;
      }
      i2 = i1;
    }
    label477:
    label1125:
    label1128:
    label1131:
    for (;;)
    {
      i1 += 1;
      break label429;
      this.e.setVisibility(8);
      break;
      this.f = ((FormSimpleItem)findViewById(2131300387));
      a(5, this.f, i3, i2);
      this.g = ((FormSimpleItem)findViewById(2131297145));
      a(6, this.g, i3, i2);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300389));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131300388));
      label636:
      Object localObject2;
      if (this.jdField_a_of_type_ArrayOfInt[8] == 1)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131297146));
        if (this.jdField_a_of_type_ArrayOfInt[7] != 1) {
          break label1076;
        }
        if ((7 != i3) || (7 != i2)) {
          break label1031;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("屏蔽此人");
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        if ((this.f.getVisibility() == 8) && (this.g.getVisibility() == 8) && (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 8) && (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 8)) {
          findViewById(2131300386).setVisibility(8);
        }
        if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          localObject2 = (FriendManager)this.app.getManager(8);
          if (localObject2 != null) {
            break label1088;
          }
          localObject1 = null;
          label754:
          if (localObject1 != null)
          {
            this.jdField_b_of_type_JavaLangString = ((Friends)localObject1).remark;
            localObject2 = ((FriendManager)localObject2).a(String.valueOf(((Friends)localObject1).groupid));
            if ((localObject2 != null) && (!Utils.a(this.jdField_c_of_type_JavaLangString, ((Groups)localObject2).group_name))) {
              this.jdField_c_of_type_JavaLangString = ((Groups)localObject2).group_name;
            }
            if (((Friends)localObject1).gathtertype == 1)
            {
              this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
              this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
              this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
            }
          }
          if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
          {
            localObject2 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
            if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              break label1107;
            }
            localObject1 = "";
            label878:
            ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
          }
          if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
          {
            localObject2 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
            if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
              break label1116;
            }
          }
        }
      }
      for (localObject1 = "";; localObject1 = this.jdField_c_of_type_JavaLangString)
      {
        ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
        if (this.jdField_a_of_type_ArrayOfInt[7] == 1)
        {
          this.jdField_a_of_type_Boolean = a();
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("收起到不常联系好友 ");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
        if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          ((TextView)findViewById(2131300389)).setFocusable(true);
        }
        this.g.setContentDescription(getString(2131369132));
        return;
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        if (7 == i3)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(1);
          break label636;
        }
        if (7 == i2)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(3);
          break label636;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(2);
        break label636;
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        break label662;
        localObject1 = ((FriendManager)localObject2).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break label754;
        localObject1 = this.jdField_b_of_type_JavaLangString;
        break label878;
      }
      continue;
      break label451;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  void a(String paramString)
  {
    DialogUtil.a(this, 230).setTitle(getString(2131367048)).setMessage(getString(2131367057)).setPositiveButton(2131365959, new epw(this, paramString)).setNegativeButton(2131366375, new epv(this)).show();
  }
  
  void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.app.getManager(15);
      if (localShieldMsgManger != null) {}
      for (;;)
      {
        int i1;
        try
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            localObject = a();
          }
          long l1 = Long.parseLong((String)localObject);
          localObject = new ArrayList();
          ((List)localObject).add(Long.valueOf(l1));
          i1 = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (paramBoolean)
          {
            localShieldMsgManger.b(i1, (List)localObject);
            i1 = 1;
          }
          switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
          {
          default: 
            i2 = i1;
            if (i2 == 0) {
              break label302;
            }
            if (paramBoolean) {
              break label297;
            }
            paramBoolean = bool;
            this.jdField_a_of_type_Boolean = paramBoolean;
            this.o |= 0x2;
            e();
            return;
            localShieldMsgManger.a(i1, (List)localObject);
            continue;
            i1 = 0;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.profilecard.FrdProfileCard", 2, "shieldMsg() " + localNumberFormatException.toString());
          }
        }
        continue;
        int i2 = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString != null)
        {
          i2 = i1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.length() > 0)
          {
            if (paramBoolean) {
              this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            for (;;)
            {
              i2 = 1;
              break;
              this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            label297:
            paramBoolean = false;
          }
        }
      }
      label302:
      if (paramBoolean) {
        a(2131367041, 1);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
        return;
        a(2131367040, 1);
      }
    }
    a(2131365730, 1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    f();
    if ((this.o & 0x2) == 2)
    {
      if (!paramBoolean1) {
        break label72;
      }
      if (!paramBoolean2) {
        break label61;
      }
      a(2131367042, 2);
    }
    for (;;)
    {
      this.o &= 0xFFFFFFFD;
      this.jdField_a_of_type_Boolean = a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
      return;
      label61:
      a(2131367038, 2);
      continue;
      label72:
      if (paramBoolean2) {
        a(2131367041, 1);
      } else {
        a(2131367040, 1);
      }
    }
  }
  
  void b()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[11];
    int i1 = 0;
    while (i1 < 11)
    {
      this.jdField_a_of_type_ArrayOfInt[i1] = 0;
      i1 += 1;
    }
    if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_a_of_type_ArrayOfInt[0] = 1;
      this.jdField_a_of_type_ArrayOfInt[1] = 1;
      this.jdField_a_of_type_ArrayOfInt[2] = 1;
      if (BmqqSegmentUtil.a(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ArrayOfInt[3] = 1;
      }
      this.jdField_a_of_type_ArrayOfInt[4] = 1;
      this.jdField_a_of_type_ArrayOfInt[5] = 1;
      this.jdField_a_of_type_ArrayOfInt[6] = 1;
      this.jdField_a_of_type_ArrayOfInt[8] = 1;
      this.jdField_a_of_type_ArrayOfInt[9] = 1;
      this.jdField_a_of_type_ArrayOfInt[10] = 1;
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 47) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 74))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 1;
        this.jdField_a_of_type_ArrayOfInt[4] = 1;
        this.jdField_a_of_type_ArrayOfInt[7] = 1;
        this.jdField_a_of_type_ArrayOfInt[10] = 1;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
      {
        this.jdField_a_of_type_ArrayOfInt[4] = 1;
        this.jdField_a_of_type_ArrayOfInt[7] = 1;
        this.jdField_a_of_type_ArrayOfInt[10] = 1;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
      {
        this.jdField_a_of_type_ArrayOfInt[7] = 1;
        this.jdField_a_of_type_ArrayOfInt[10] = 1;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 1;
        this.jdField_a_of_type_ArrayOfInt[7] = 1;
        this.jdField_a_of_type_ArrayOfInt[10] = 1;
        return;
      }
    } while (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
    this.jdField_a_of_type_ArrayOfInt[0] = 1;
    this.jdField_a_of_type_ArrayOfInt[4] = 1;
    this.jdField_a_of_type_ArrayOfInt[10] = 1;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight() - (int)(localDisplayMetrics.density * 10.0F), 0, paramInt2);
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    FormSimpleItem localFormSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (paramString = "";; paramString = this.jdField_b_of_type_JavaLangString)
    {
      localFormSimpleItem.setRightText(paramString);
      if (this.jdField_a_of_type_AndroidContentIntent == null) {
        this.jdField_a_of_type_AndroidContentIntent = new Intent();
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("remark", this.jdField_b_of_type_JavaLangString);
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
  }
  
  void c()
  {
    Object localObject1 = (FriendManager)this.app.getManager(8);
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 == null) || (((Card)localObject1).strReMark == null) || (((Card)localObject1).strReMark.length() <= 0)) {
        break label180;
      }
    }
    label175:
    label180:
    for (Object localObject2 = ((Card)localObject1).strReMark;; localObject2 = null)
    {
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() > 0) {}
      }
      else
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 30)
        {
          localObject1 = a();
          if (localObject1 == null) {
            break label175;
          }
        }
      }
      for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).jdField_a_of_type_JavaLangString;; localObject1 = null)
      {
        localObject2 = new Intent(this, EditActivity.class);
        boolean bool = true;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          bool = false;
        }
        ((Intent)localObject2).putExtra("title", 2131366181).putExtra("limit", 96).putExtra("current", (String)localObject1).putExtra("canPostNull", bool).putExtra("multiLine", false);
        startActivityForResult((Intent)localObject2, 1003);
        return;
        localObject1 = ((FriendManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
      }
    }
  }
  
  void d()
  {
    Object localObject = (FriendManager)this.app.getManager(8);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((FriendManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (localObject != null) {
        startActivityForResult(new Intent(getActivity(), MoveToGroupActivity.class).putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)((Friends)localObject).groupid), 0);
      }
      return;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    Object localObject;
    if (paramInt2 == -1) {
      localObject = null;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 1003: 
      if (paramIntent != null) {
        localObject = paramIntent.getStringExtra("result");
      }
      if (localObject != null) {
        break;
      }
    }
    for (paramIntent = "";; paramIntent = (Intent)localObject)
    {
      if (NetworkUtil.e(BaseApplication.getContext()))
      {
        if (!paramIntent.equals(this.jdField_b_of_type_JavaLangString))
        {
          localObject = (FriendListHandler)this.app.a(1);
          if (localObject != null)
          {
            ((FriendListHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramIntent, false);
            this.o |= 0x1;
            b(paramIntent);
            return;
          }
          a(2131368252, 1);
          return;
        }
        a(2131368251, 0);
        return;
      }
      a(2131367135, 1);
      return;
      paramIntent.putExtra("selfSet_leftViewText", getString(2131366025));
      localObject = new Intent(this, ForwardHandlerActivity.class);
      ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
      startActivity((Intent)localObject);
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {}
    b();
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    f();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    SpecialCareInfo localSpecialCareInfo = ((FriendsManager)this.app.getManager(49)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if (this.g.getVisibility() == 0)
    {
      if ((localSpecialCareInfo == null) || (localSpecialCareInfo.globalSwitch == 0)) {
        this.g.setRightText(getString(2131368425));
      }
    }
    else {
      return;
    }
    this.g.setRightText(getString(2131368426));
  }
  
  void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131366988);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void f()
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
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if ((paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
    {
      if (paramCompoundButton != this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label62;
      }
      if (this.jdField_a_of_type_Boolean != paramBoolean) {
        break label47;
      }
    }
    label47:
    label62:
    while (paramCompoundButton != this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      return;
      bool1 = bool2;
      if (!paramBoolean) {
        bool1 = true;
      }
      a(bool1);
      return;
    }
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      paramCompoundButton = (FriendListHandler)this.app.a(1);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      paramCompoundButton.a((short)1, localArrayList, paramBoolean);
      if (paramBoolean)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004C5A", "0X8004C5A", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004C5B", "0X8004C5B", 0, 0, "", "", "", "");
      return;
    }
    a(2131365730, 1);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    paramCompoundButton = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (!paramBoolean) {}
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      paramCompoundButton.setChecked(paramBoolean);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = null;
    int i1;
    if (paramView == null) {
      i1 = 0;
    }
    switch (i1)
    {
    default: 
    case 2131300381: 
    case 2131300382: 
    case 2131300383: 
    case 2131300384: 
    case 2131300385: 
    case 2131297149: 
    case 2131297159: 
    case 2131300387: 
      label709:
      do
      {
        do
        {
          long l1;
          do
          {
            return;
            i1 = paramView.getId();
            break;
            l1 = System.currentTimeMillis();
          } while (!ProfileActivity.a(this.jdField_a_of_type_Long, l1));
          this.jdField_a_of_type_Long = l1;
          ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app, this);
          ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_more", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          c();
          ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_edit_name", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          d();
          ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_move", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
        } while (this.jdField_b_of_type_Boolean);
        this.jdField_b_of_type_Boolean = true;
        ThreadManager.a().post(new eqc(this));
        return;
        Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
        localObject1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h = ContactUtils.g(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        }
        paramView = getIntent().getStringExtra("SHARE_NICK_NAME");
        if (paramView == null)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
          localObject2 = ((AbsShareMsg.Builder)localObject2).c(14).a("推荐了" + paramView).a(2).a("plugin", "", (String)localObject1, (String)localObject1, (String)localObject1).d(getResources().getString(2131366433)).a();
          StructMsgItemLayout2 localStructMsgItemLayout2 = new StructMsgItemLayout2();
          localStructMsgItemLayout2.d(1);
          localStructMsgItemLayout2.a(new StructMsgItemCover((String)localObject1));
          localStructMsgItemLayout2.a(new StructMsgItemTitle(paramView));
          localStructMsgItemLayout2.a(new StructMsgItemSummary("帐号: " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          ((AbsShareMsg)localObject2).addItem(localStructMsgItemLayout2);
          paramView = new Bundle();
          paramView.putInt("forward_type", 20);
          paramView.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
          paramView.putBoolean("k_dataline", false);
          localObject1 = new Intent(this, ForwardRecentActivity.class);
          ((Intent)localObject1).putExtras(paramView);
          ((Intent)localObject1).putExtra("display_like_dialog", true);
          startActivityForResult((Intent)localObject1, 21);
          if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            break label709;
          }
        }
        for (i1 = 1;; i1 = 2)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X80050E7", "0X80050E7", i1, 0, "", "", "", "");
          return;
          break;
        }
        paramView = (View)localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        }
        a(paramView);
        return;
        if (((HotChatManager)this.app.getManager(58)).d(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString)) {
          ReportPlugin.a(this, 202, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.getAccount());
        }
        for (;;)
        {
          ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_report", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          ProfileCardUtil.a(this, Long.toString(ProfileCardUtil.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.getAccount(), false);
        }
        try
        {
          paramView = QZoneHelper.UserInfo.a();
          paramView.jdField_a_of_type_JavaLangString = this.app.a();
          paramView.jdField_b_of_type_JavaLangString = this.app.c();
          QZoneHelper.a(this, paramView, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue(), -1);
          ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_qzone", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
        }
        catch (Exception paramView) {}
      } while (!QLog.isColorLevel());
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramView.toString());
      return;
    }
    paramView = new Intent(this, QQSpecialCareSettingActivity.class);
    paramView.putExtra("key_friend_uin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    startActivity(paramView);
    ReportController.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileCardMoreActivity
 * JD-Core Version:    0.7.0.1
 */