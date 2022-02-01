package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecommendContactMsg;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import gfl;
import gfn;
import gfo;
import gfp;
import gfq;
import gfs;
import gft;
import gfv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class AddContactsView
  extends ContactBaseView
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 3;
  private static final String jdField_a_of_type_JavaLangString = AddContactsView.class.getSimpleName();
  private static short jdField_a_of_type_Short = 8;
  private static final int jdField_b_of_type_Int = 1;
  private static final int jdField_c_of_type_Int = 2;
  private static final int jdField_d_of_type_Int = 3;
  private static final String jdField_d_of_type_JavaLangString = "、";
  private static final int jdField_e_of_type_Int = 4;
  private static final String jdField_e_of_type_JavaLangString = "条件：";
  private static final int f = 5;
  private static final int h = 1;
  private static final int i = 2;
  private static final int j = 3;
  private static final int k = 4;
  private static final int l = 0;
  private static final int m = 1;
  private static final int n = 2;
  private AddContactsView.MayKnowAdapter jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$MayKnowAdapter;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new gfo(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new gfn(this);
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new gfp(this);
  private MayKnowRecommend jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  FormMutiItem jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private gfv jdField_a_of_type_Gfv = new gfv(this);
  private List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  public FormMutiItem b;
  private String jdField_b_of_type_JavaLangString = "PhoneContactRecommendNames";
  private List jdField_b_of_type_JavaUtilList = new ArrayList(3);
  public boolean b;
  FormMutiItem jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem;
  private final String jdField_c_of_type_JavaLangString = "sp_get_mayknow_timestamp";
  public boolean c;
  FormMutiItem jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem;
  private boolean jdField_d_of_type_Boolean = true;
  private int g = 2;
  
  public AddContactsView(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private String a(List paramList)
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    StringBuffer localStringBuffer = new StringBuffer(100);
    int i1 = 0;
    while (i1 < paramList.size())
    {
      PhoneContact localPhoneContact = localPhoneContactManager.b((String)paramList.get(i1));
      if (localPhoneContact != null)
      {
        localStringBuffer.append(localPhoneContact.name);
        localStringBuffer.append("、");
      }
      i1 += 1;
    }
    if (localStringBuffer.length() > 1) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    return localStringBuffer.toString();
  }
  
  private List a()
  {
    int i2 = 0;
    Object localObject1 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
    List localList = b();
    Object localObject2;
    int i1;
    if (localList.size() < 3)
    {
      localObject2 = ((PhoneContactManager)localObject1).c();
      if (localObject2 != null)
      {
        i1 = 0;
        while ((i1 < ((List)localObject2).size()) && (localList.size() < 3))
        {
          RecommendContactMsg localRecommendContactMsg = (RecommendContactMsg)((List)localObject2).get(i1);
          if ((localRecommendContactMsg.friendStatus != 2) && (localRecommendContactMsg.friendStatus != 1) && (!localList.contains(localRecommendContactMsg.mobileNo))) {
            localList.add(localRecommendContactMsg.mobileNo);
          }
          i1 += 1;
        }
      }
    }
    if (localList.size() < 3)
    {
      localObject1 = ((PhoneContactManager)localObject1).b();
      if ((localObject1 != null) && (((List)localObject1).size() > 1))
      {
        localObject1 = (List)((List)localObject1).get(0);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          i1 = i2;
          while ((i1 < ((List)localObject1).size()) && (localList.size() < 3))
          {
            localObject2 = (PhoneContact)((List)localObject1).get(i1);
            if ((localObject2 != null) && (((PhoneContact)localObject2).uin != null) && (((PhoneContact)localObject2).uin.equals("0")) && (!localFriendsManager.d(((PhoneContact)localObject2).nationCode + ((PhoneContact)localObject2).mobileCode)) && (!localList.contains(((PhoneContact)localObject2).mobileNo))) {
              localList.add(((PhoneContact)localObject2).mobileNo);
            }
            i1 += 1;
          }
        }
      }
    }
    return localList;
  }
  
  private List a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)paramList.next();
      if (!localFriendsManager.b(localMayKnowRecommend.uin))
      {
        if (localFriendsManager.d(localMayKnowRecommend.uin)) {}
        for (int i1 = 1;; i1 = 0)
        {
          localMayKnowRecommend.friendStatus = i1;
          localArrayList.add(localMayKnowRecommend);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, List paramList)
  {
    int i1;
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("fillMayKnowData force=").append(paramBoolean1).append(" isExpired=").append(paramBoolean2).append(" insize=");
      if (paramList == null)
      {
        i1 = 0;
        QLog.d(str, 2, i1);
      }
    }
    else
    {
      if (NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext)) {
        break label104;
      }
      this.g = 4;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$MayKnowAdapter.notifyDataSetChanged();
    }
    label104:
    long l1;
    do
    {
      return false;
      i1 = paramList.size();
      break;
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("sp_get_mayknow_timestamp", 0L);
    } while ((!paramBoolean1) && (Math.abs(l1 - System.currentTimeMillis()) < 3600000L));
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(jdField_a_of_type_Short, paramBoolean2, paramList);
    this.g = 2;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$MayKnowAdapter.notifyDataSetChanged();
    return true;
  }
  
  /* Error */
  private List b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 126	com/tencent/mobileqq/activity/contact/addcontact/AddContactsView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: bipush 10
    //   6: invokevirtual 132	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9: checkcast 134	com/tencent/mobileqq/model/PhoneContactManager
    //   12: astore 11
    //   14: aload_0
    //   15: getfield 126	com/tencent/mobileqq/activity/contact/addcontact/AddContactsView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   18: bipush 49
    //   20: invokevirtual 132	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   23: checkcast 174	com/tencent/mobileqq/app/FriendsManager
    //   26: astore 12
    //   28: new 105	java/util/ArrayList
    //   31: dup
    //   32: iconst_3
    //   33: invokespecial 108	java/util/ArrayList:<init>	(I)V
    //   36: astore 10
    //   38: aload_0
    //   39: getfield 126	com/tencent/mobileqq/activity/contact/addcontact/AddContactsView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: invokevirtual 323	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   45: invokevirtual 329	mqq/app/MobileQQ:getContentResolver	()Landroid/content/ContentResolver;
    //   48: getstatic 335	android/provider/CallLog$Calls:CONTENT_URI	Landroid/net/Uri;
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: ldc_w 337
    //   57: invokevirtual 343	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 7
    //   62: aload 7
    //   64: ifnull +362 -> 426
    //   67: aload 7
    //   69: astore 8
    //   71: aload 7
    //   73: invokeinterface 348 1 0
    //   78: ifeq +348 -> 426
    //   81: iconst_0
    //   82: istore_3
    //   83: iconst_0
    //   84: istore_2
    //   85: aload 7
    //   87: astore 8
    //   89: aload 7
    //   91: aload 7
    //   93: ldc_w 350
    //   96: invokeinterface 354 2 0
    //   101: invokeinterface 358 2 0
    //   106: astore 9
    //   108: aload 7
    //   110: astore 8
    //   112: invokestatic 257	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +35 -> 150
    //   118: aload 7
    //   120: astore 8
    //   122: ldc_w 360
    //   125: iconst_2
    //   126: new 204	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 362
    //   136: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 9
    //   141: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 272	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload 7
    //   152: astore 8
    //   154: aload 11
    //   156: aload 9
    //   158: invokeinterface 152 2 0
    //   163: astore 6
    //   165: aload 6
    //   167: ifnull +473 -> 640
    //   170: aload 7
    //   172: astore 8
    //   174: aload 6
    //   176: getfield 197	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   179: invokestatic 368	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   182: ifne +458 -> 640
    //   185: aload 7
    //   187: astore 8
    //   189: aload 6
    //   191: getfield 197	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   194: ldc 199
    //   196: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifeq +441 -> 640
    //   202: iconst_1
    //   203: istore_1
    //   204: iload_1
    //   205: ifne +432 -> 637
    //   208: aload 7
    //   210: astore 8
    //   212: aload 9
    //   214: ldc_w 370
    //   217: invokevirtual 373	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   220: ifeq +221 -> 441
    //   223: aload 7
    //   225: astore 8
    //   227: aload 11
    //   229: aload 9
    //   231: iconst_3
    //   232: invokevirtual 376	java/lang/String:substring	(I)Ljava/lang/String;
    //   235: invokeinterface 152 2 0
    //   240: astore 9
    //   242: aload 9
    //   244: astore 6
    //   246: aload 9
    //   248: ifnull +389 -> 637
    //   251: aload 7
    //   253: astore 8
    //   255: aload 9
    //   257: astore 6
    //   259: aload 9
    //   261: getfield 197	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   264: invokestatic 368	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   267: ifne +370 -> 637
    //   270: aload 7
    //   272: astore 8
    //   274: aload 9
    //   276: astore 6
    //   278: aload 9
    //   280: getfield 197	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   283: ldc 199
    //   285: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   288: ifeq +349 -> 637
    //   291: aload 9
    //   293: astore 6
    //   295: iconst_1
    //   296: istore_1
    //   297: iload_1
    //   298: istore 4
    //   300: iload_1
    //   301: ifeq +47 -> 348
    //   304: iload_1
    //   305: istore 4
    //   307: aload 7
    //   309: astore 8
    //   311: aload 12
    //   313: new 204	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   320: aload 6
    //   322: getfield 209	com/tencent/mobileqq/data/PhoneContact:nationCode	Ljava/lang/String;
    //   325: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload 6
    //   330: getfield 215	com/tencent/mobileqq/data/PhoneContact:mobileCode	Ljava/lang/String;
    //   333: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokevirtual 219	com/tencent/mobileqq/app/FriendsManager:d	(Ljava/lang/String;)Z
    //   342: ifeq +6 -> 348
    //   345: iconst_0
    //   346: istore 4
    //   348: iload_3
    //   349: istore_1
    //   350: iload 4
    //   352: ifeq +45 -> 397
    //   355: iload_3
    //   356: istore_1
    //   357: aload 7
    //   359: astore 8
    //   361: aload 10
    //   363: aload 6
    //   365: getfield 220	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   368: invokeinterface 190 2 0
    //   373: ifne +24 -> 397
    //   376: aload 7
    //   378: astore 8
    //   380: aload 10
    //   382: aload 6
    //   384: getfield 220	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   387: invokeinterface 193 2 0
    //   392: pop
    //   393: iload_3
    //   394: iconst_1
    //   395: iadd
    //   396: istore_1
    //   397: aload 7
    //   399: astore 8
    //   401: aload 7
    //   403: invokeinterface 379 1 0
    //   408: istore 5
    //   410: iload 5
    //   412: ifeq +14 -> 426
    //   415: iload_2
    //   416: bipush 100
    //   418: if_icmpge +8 -> 426
    //   421: iload_1
    //   422: iconst_3
    //   423: if_icmplt +205 -> 628
    //   426: aload 7
    //   428: ifnull +10 -> 438
    //   431: aload 7
    //   433: invokeinterface 382 1 0
    //   438: aload 10
    //   440: areturn
    //   441: aload 7
    //   443: astore 8
    //   445: aload 11
    //   447: new 204	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   454: aload 9
    //   456: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: ldc_w 370
    //   462: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokeinterface 152 2 0
    //   473: astore 9
    //   475: aload 9
    //   477: astore 6
    //   479: aload 9
    //   481: ifnull +156 -> 637
    //   484: aload 7
    //   486: astore 8
    //   488: aload 9
    //   490: astore 6
    //   492: aload 9
    //   494: getfield 197	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   497: invokestatic 368	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   500: ifne +137 -> 637
    //   503: aload 7
    //   505: astore 8
    //   507: aload 9
    //   509: getfield 197	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   512: ldc 199
    //   514: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   517: istore 5
    //   519: aload 9
    //   521: astore 6
    //   523: iload 5
    //   525: ifeq +112 -> 637
    //   528: aload 9
    //   530: astore 6
    //   532: iconst_1
    //   533: istore_1
    //   534: goto -237 -> 297
    //   537: astore 6
    //   539: aconst_null
    //   540: astore 7
    //   542: aload 7
    //   544: astore 8
    //   546: invokestatic 257	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   549: ifeq +19 -> 568
    //   552: aload 7
    //   554: astore 8
    //   556: ldc_w 360
    //   559: iconst_2
    //   560: ldc_w 384
    //   563: aload 6
    //   565: invokestatic 387	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   568: aload 7
    //   570: ifnull -132 -> 438
    //   573: aload 7
    //   575: invokeinterface 382 1 0
    //   580: aload 10
    //   582: areturn
    //   583: astore 6
    //   585: aload 10
    //   587: areturn
    //   588: astore 6
    //   590: aconst_null
    //   591: astore 8
    //   593: aload 8
    //   595: ifnull +10 -> 605
    //   598: aload 8
    //   600: invokeinterface 382 1 0
    //   605: aload 6
    //   607: athrow
    //   608: astore 6
    //   610: aload 10
    //   612: areturn
    //   613: astore 7
    //   615: goto -10 -> 605
    //   618: astore 6
    //   620: goto -27 -> 593
    //   623: astore 6
    //   625: goto -83 -> 542
    //   628: iload_2
    //   629: iconst_1
    //   630: iadd
    //   631: istore_2
    //   632: iload_1
    //   633: istore_3
    //   634: goto -549 -> 85
    //   637: goto -340 -> 297
    //   640: iconst_0
    //   641: istore_1
    //   642: goto -438 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	645	0	this	AddContactsView
    //   203	439	1	i1	int
    //   84	548	2	i2	int
    //   82	552	3	i3	int
    //   298	53	4	i4	int
    //   408	116	5	bool	boolean
    //   163	368	6	localObject1	Object
    //   537	27	6	localException1	Exception
    //   583	1	6	localException2	Exception
    //   588	18	6	localObject2	Object
    //   608	1	6	localException3	Exception
    //   618	1	6	localObject3	Object
    //   623	1	6	localException4	Exception
    //   60	514	7	localCursor1	android.database.Cursor
    //   613	1	7	localException5	Exception
    //   69	530	8	localCursor2	android.database.Cursor
    //   106	423	9	localObject4	Object
    //   36	575	10	localArrayList	ArrayList
    //   12	434	11	localPhoneContactManager	PhoneContactManager
    //   26	286	12	localFriendsManager	FriendsManager
    // Exception table:
    //   from	to	target	type
    //   38	62	537	java/lang/Exception
    //   573	580	583	java/lang/Exception
    //   38	62	588	finally
    //   431	438	608	java/lang/Exception
    //   598	605	613	java/lang/Exception
    //   71	81	618	finally
    //   89	108	618	finally
    //   112	118	618	finally
    //   122	150	618	finally
    //   154	165	618	finally
    //   174	185	618	finally
    //   189	202	618	finally
    //   212	223	618	finally
    //   227	242	618	finally
    //   259	270	618	finally
    //   278	291	618	finally
    //   311	345	618	finally
    //   361	376	618	finally
    //   380	393	618	finally
    //   401	410	618	finally
    //   445	475	618	finally
    //   492	503	618	finally
    //   507	519	618	finally
    //   546	552	618	finally
    //   556	568	618	finally
    //   71	81	623	java/lang/Exception
    //   89	108	623	java/lang/Exception
    //   112	118	623	java/lang/Exception
    //   122	150	623	java/lang/Exception
    //   154	165	623	java/lang/Exception
    //   174	185	623	java/lang/Exception
    //   189	202	623	java/lang/Exception
    //   212	223	623	java/lang/Exception
    //   227	242	623	java/lang/Exception
    //   259	270	623	java/lang/Exception
    //   278	291	623	java/lang/Exception
    //   311	345	623	java/lang/Exception
    //   361	376	623	java/lang/Exception
    //   380	393	623	java/lang/Exception
    //   401	410	623	java/lang/Exception
    //   445	475	623	java/lang/Exception
    //   492	503	623	java/lang/Exception
    //   507	519	623	java/lang/Exception
  }
  
  private void h()
  {
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    if (this.jdField_a_of_type_Boolean)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n()) || (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext))) {
        break label80;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      ((LBSHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3)).c();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
      return;
      label80:
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "-1", "-1", "-1", "-1" };
    }
  }
  
  private void i()
  {
    a(2130903065);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131296649));
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903066, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)((View)localObject).findViewById(2131296650));
    int i1 = getResources().getDimensionPixelSize(2131493297);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setPadding(i1, 0, i1 / 2, 0);
    Drawable localDrawable = getResources().getDrawable(2130841610);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCompoundDrawables(null, null, localDrawable, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription("搜索栏、QQ号、手机号、邮箱、群、生活服务、连按两次编辑");
    this.jdField_a_of_type_ComTencentWidgetXListView.a((View)localObject, null, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem = ((FormMutiItem)((View)localObject).findViewById(2131296652));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130840093));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(this.jdField_a_of_type_AndroidContentContext.getString(2131367974));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText("");
    if (((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57)).b()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setRightIcon(getResources().getDrawable(2130841955));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem = ((FormMutiItem)((View)localObject).findViewById(2131296653));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130839786));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131367991));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText("");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription("添加手机联系人，触摸两次进入");
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem = ((FormMutiItem)((View)localObject).findViewById(2131296654));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130839785));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText("查看附近的人");
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription("查看附近的人");
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("sp_firsttime_shownwe", true);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem = ((FormMutiItem)((View)localObject).findViewById(2131296651));
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setRightIcon(getResources().getDrawable(2130841955));
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130838331));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131369964));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText(getResources().getString(2131369965));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(true);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription("当面加好友，添加身边的人和群");
    localObject = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a());
    ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, Utils.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), 20.0F)));
    this.jdField_a_of_type_ComTencentWidgetXListView.b((View)localObject, null, false);
  }
  
  private void j()
  {
    h();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$MayKnowAdapter = new AddContactsView.MayKnowAdapter(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView);
    l();
    k();
  }
  
  private void k()
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Object localObject = localSharedPreferences.getString(this.jdField_b_of_type_JavaLangString, "");
    if (((String)localObject).length() > 0)
    {
      localObject = ((String)localObject).split(",");
      if (localObject.length > 0) {
        this.jdField_b_of_type_JavaUtilList = Arrays.asList((Object[])localObject);
      }
    }
    localObject = a(this.jdField_b_of_type_JavaUtilList);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText("");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
    }
    for (;;)
    {
      if (localPhoneContactManager != null)
      {
        if (!localPhoneContactManager.g()) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new gfq(this, (String)localObject, localSharedPreferences));
      }
      return;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText((CharSequence)localObject);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(true);
    }
    localSharedPreferences.edit().putString(this.jdField_b_of_type_JavaLangString, "").commit();
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new gfs(this));
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131493402);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57));
    i();
    j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend == null);
    paramIntent = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
    if (paramIntent.b(this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.uin))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.friendStatus = 2;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$MayKnowAdapter.notifyDataSetChanged();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = null;
      return;
      if (paramIntent.d(this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.uin))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.friendStatus = 1;
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$MayKnowAdapter.notifyDataSetChanged();
      }
    }
  }
  
  protected void b()
  {
    super.b();
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
  }
  
  protected void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().c(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$MayKnowAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$MayKnowAdapter.b();
    }
  }
  
  public void d()
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("fillSearchConditions | autoReqLocation = ").append(this.jdField_a_of_type_Boolean).append(" | code one = ");
      if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length == 4))
      {
        localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString[0];
        QLog.d((String)localObject2, 2, localObject1);
      }
    }
    else
    {
      localObject1 = new StringBuilder("条件：");
      int i1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
      if (i1 != 0) {
        ((StringBuilder)localObject1).append(ConditionSearchManager.jdField_a_of_type_ArrayOfJavaLangString[i1]).append("、");
      }
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c();
      if (i1 != 0) {
        ((StringBuilder)localObject1).append(ConditionSearchManager.b[i1]).append("、");
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label462;
      }
      if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_b_of_type_Boolean)) {
        if ("-1".equals(this.jdField_a_of_type_ArrayOfJavaLangString[0]))
        {
          localObject2 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if (localObject2 == null) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = ((Card)localObject2).strLocationCodes.split("-");
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "card.strLocationCodes = " + ((Card)localObject2).strLocationCodes);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          this.jdField_a_of_type_ArrayOfJavaLangString[3] = "0";
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.jdField_a_of_type_ArrayOfJavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ArrayOfJavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0, (String)localObject2);
          if (!"0".equals(this.jdField_a_of_type_ArrayOfJavaLangString[0])) {
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String)localObject2)).append("、");
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1);
          if (!((String)localObject2).startsWith("不限")) {
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String)localObject2));
          }
          localObject2 = ((StringBuilder)localObject1).toString();
          localObject1 = localObject2;
          if (((String)localObject2).endsWith("、")) {
            localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
          }
          if (((String)localObject1).equals("条件：")) {
            break label502;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(true);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText((CharSequence)localObject1);
          return;
          localObject1 = Integer.valueOf(-1000);
          break;
          localException1 = localException1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "spliteLocationString | exception: ", localException1);
          continue;
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "parseLocationDesc", localException2);
          continue;
        }
      }
      label462:
      String str = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0);
      if (!str.startsWith("不限")) {
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(str)).append("、");
      }
    }
    label502:
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
    case 2131296650: 
    case 2131296652: 
    case 2131296653: 
    case 2131296654: 
    case 2131296651: 
    case 2131296658: 
    case 2131296656: 
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a();
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 1, 0, "", "", "", "");
            return;
            ((FormSimpleItem)findViewById(2131296652)).setRightIcon(null);
            this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, ConditionSearchFriendActivity.class).putExtra("from", "addcontacts"));
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004240", "0X8004240", 0, 0, "", "", "", "");
            return;
            paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, PhoneFrameActivity.class);
            paramView.putExtra("key_reserved_mobile", (String[])this.jdField_b_of_type_JavaUtilList.toArray(new String[this.jdField_b_of_type_JavaUtilList.size()]));
            paramView.putExtra("key_req_type", 3);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474A", "0X800474A", 0, 0, "", "", "", "");
            return;
            paramView = (SplashActivity)SplashActivity.a();
            if (paramView.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
            {
              paramView.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.ACCESS_FINE_LOCATION", 500) }).request(new gfl(this, paramView));
              return;
            }
            paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyActivity.class);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
            ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FA1", "0X8004FA1", 0, 0, "", "", "", "");
            return;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("sp_firsttime_shownwe", false).commit();
            ((FormSimpleItem)findViewById(2131296651)).setRightIcon(null);
            paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, Face2FaceAddFriendActivity.class);
            paramView.putExtra("activity_from_type", 0);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050E8", "0X80050E8", 0, 0, "", "", "", "");
            return;
            localObject = (MayKnowRecommend)paramView.getTag();
          } while (localObject == null);
          paramView = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
          if ((!paramView.b(((MayKnowRecommend)localObject).uin)) && (!paramView.d(((MayKnowRecommend)localObject).uin)))
          {
            if (TextUtils.isEmpty(((MayKnowRecommend)localObject).remark)) {
              if (TextUtils.isEmpty(((MayKnowRecommend)localObject).nick)) {
                paramView = ((MayKnowRecommend)localObject).uin;
              }
            }
            for (;;)
            {
              paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((MayKnowRecommend)localObject).uin, null, 3003, 1, paramView, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131367735));
              this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = ((MayKnowRecommend)localObject);
              this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().startActivityForResult(paramView, 1);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004E40", "0X8004E40", 0, 0, "", "", "", "");
              return;
              paramView = ((MayKnowRecommend)localObject).nick;
              continue;
              paramView = ((MayKnowRecommend)localObject).remark;
            }
          }
          if (paramView.b(((MayKnowRecommend)localObject).uin))
          {
            ((MayKnowRecommend)localObject).friendStatus = 2;
            this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$MayKnowAdapter.notifyDataSetChanged();
            return;
          }
          ((MayKnowRecommend)localObject).friendStatus = 1;
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$MayKnowAdapter.notifyDataSetChanged();
          return;
          paramView = (gft)paramView.getTag();
        } while (paramView == null);
        paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
      } while (paramView == null);
      localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
      if ((localObject == null) || (!((FriendsManager)localObject).b(paramView.uin))) {
        break;
      }
    }
    for (int i1 = 1;; i1 = 77)
    {
      localObject = new ProfileActivity.AllInOne(paramView.uin, i1);
      if (!TextUtils.isEmpty(paramView.remark)) {
        ((ProfileActivity.AllInOne)localObject).l = paramView.remark;
      }
      if (!TextUtils.isEmpty(paramView.nick)) {
        ((ProfileActivity.AllInOne)localObject).h = paramView.nick;
      }
      ((ProfileActivity.AllInOne)localObject).g = 88;
      this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = paramView;
      ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), (ProfileActivity.AllInOne)localObject, 1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004E3F", "0X8004E3F", 0, 0, "", "", "", "");
      return;
      if ((this.g != 3) && (this.g != 4)) {
        break;
      }
      this.g = 5;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$MayKnowAdapter.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView
 * JD-Core Version:    0.7.0.1
 */