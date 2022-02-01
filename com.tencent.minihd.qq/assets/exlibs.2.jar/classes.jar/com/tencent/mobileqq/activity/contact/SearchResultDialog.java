package com.tencent.mobileqq.activity.contact;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.adapter.CircleSearchResultAdapter;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.search.ContactSearchablePublicAccount;
import com.tencent.mobileqq.search.ContactSearchableSearchHistory;
import com.tencent.mobileqq.search.ContactSearchableTroop;
import com.tencent.mobileqq.search.ContactsSearchableCircleBuddy;
import com.tencent.mobileqq.search.ContactsSearchablePhoneContact;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.search.ConversationSearchAdapter;
import com.tencent.mobileqq.search.ConversationSearchAdapter.SearchResultCallBack;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.SearchAdapterInterface;
import com.tencent.mobileqq.search.SearchableDiscussionMember;
import com.tencent.mobileqq.search.SearchableTroopMember;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import gen;
import geo;
import gep;
import ger;
import ges;
import get;
import geu;
import gev;
import gex;
import gey;
import gez;
import gfa;
import gfb;
import gfc;
import gfd;
import gfe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import mqq.app.BasePadActivity;
import mqq.app.MobileQQ;

public class SearchResultDialog
  extends Dialog
  implements Handler.Callback, ConversationSearchAdapter.SearchResultCallBack
{
  private static final int jdField_a_of_type_Int = 555;
  public static final String a = "SearchResultDialog";
  public static final int b = 1;
  public static final String b = "search_keyword";
  public static final int c = 2;
  public static final String c = "circle_contacts_search_count";
  public static final int d = 3;
  public static final String d = "receiver_text";
  public static final int e = 4;
  public static final String e = "refresh_text";
  public static final int f = 5;
  public static final String f = "do_search_text";
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  private static final int l = 556;
  private static final int m = 1;
  private static final int n = 2;
  long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ForwardOperations jdField_a_of_type_ComTencentMobileqqActivityForwardOperations;
  private SearchContactsFragment jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment;
  private ContactsSearchResultAdapter jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter;
  private CircleManager jdField_a_of_type_ComTencentMobileqqAppCircleManager;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQMessageFacade jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
  private SearchAdapterInterface jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean = false;
  private AdapterView.OnItemClickListener jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new gev(this);
  private XListView jdField_b_of_type_ComTencentWidgetXListView;
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = false;
  private String g = null;
  private String h = null;
  private int o;
  private int p;
  
  public SearchResultDialog(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.p = paramInt2;
    com.tencent.mobileqq.activity.aio.AIOUtils.h = false;
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "SearchResultDialog() from = " + paramInt1);
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BasePadActivity)) {
      this.c = ((BasePadActivity)this.jdField_a_of_type_AndroidContentContext).isModeleWindow();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = paramQQAppInterface.a();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.o = paramInt1;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(49));
    }
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    getWindow().setBackgroundDrawable(new ColorDrawable(-419430401));
    setContentView(2130903193);
    findViewById(2131297283).setOnClickListener(new gen(this));
    a(null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297284));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297286));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297287));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter = new ContactsSearchResultAdapter(paramQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentWidgetXListView, null, new gex(this), false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new gey(this));
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297285));
    ContactsSearchableCircleBuddy.jdField_b_of_type_Boolean = false;
    ContactsSearchableCircleBuddy.jdField_a_of_type_Boolean = false;
    if ((4 == paramInt1) || (16 == paramInt1)) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface = new ConversationSearchAdapter(paramContext, paramQQAppInterface, this.jdField_b_of_type_ComTencentWidgetXListView, new gez(this), false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.a(this);
      if ((paramInt1 == 0) || (4 == paramInt1) || (16 == paramInt1))
      {
        this.jdField_b_of_type_JavaUtilList = c();
        Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        localMessage.what = 2;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
      }
      new Thread(new gfc(this)).start();
      b();
      h();
      i();
      a(paramContext, paramQQAppInterface);
      if ((paramInt1 == 0) || (4 == paramInt1) || (16 == paramInt1))
      {
        this.h = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!TextUtils.isEmpty(this.h))
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          paramContext = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903194, null);
          paramContext.setOnClickListener(new gfd(this, paramInt1));
          ((TextView)paramContext.findViewById(2131297289)).setText(this.h);
          this.jdField_a_of_type_ComTencentWidgetXListView.a(paramContext);
          if (this.jdField_b_of_type_JavaUtilList.size() > 0)
          {
            paramContext = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903181, null);
            ((TextView)paramContext.findViewById(2131297231)).setText("你可能想找");
            this.jdField_a_of_type_ComTencentWidgetXListView.a(paramContext);
          }
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter);
        }
      }
      return;
      if ((13 == paramInt1) || (14 == paramInt1))
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface = new CircleSearchResultAdapter(paramQQAppInterface, paramContext, this.jdField_b_of_type_ComTencentWidgetXListView, new gfa(this));
        ((EditText)findViewById(2131299473)).setHint(2131366040);
      }
      else
      {
        if (this.c)
        {
          this.jdField_a_of_type_AndroidViewView = findViewById(2131300436);
          a(this.jdField_a_of_type_AndroidViewView);
          this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundResource(2131427375);
          this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2131427375);
          findViewById(2131297283).setBackgroundResource(2131427574);
          Utils.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_ComTencentWidgetXListView);
          Utils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_ComTencentWidgetXListView);
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface = new ContactsSearchResultAdapter(paramQQAppInterface, paramContext, this.jdField_b_of_type_ComTencentWidgetXListView, null, new gfb(this), false);
      }
    }
  }
  
  public SearchResultDialog(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, ForwardOperations paramForwardOperations, int paramInt2)
  {
    this(paramContext, paramQQAppInterface, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = paramForwardOperations;
  }
  
  public SearchResultDialog(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, AdapterView.OnItemClickListener paramOnItemClickListener, int paramInt2)
  {
    this(paramContext, paramQQAppInterface, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private static long a(int paramInt)
  {
    return 0L;
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("search_keyword" + paramQQAppInterface.a(), "");
  }
  
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, String paramString, boolean paramBoolean, ArrayList paramArrayList)
  {
    Object localObject = ((DiscussionManager)paramQQAppInterface.getManager(51)).a(paramString);
    paramString = new ArrayList();
    if (localObject != null)
    {
      long l1 = a(paramInt);
      String str = paramQQAppInterface.a();
      paramQQAppInterface.a();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
        if ((localDiscussionMemberInfo != null) && ((!paramBoolean) || (!localDiscussionMemberInfo.memberUin.equals(str))) && ((paramArrayList == null) || (!paramArrayList.contains(localDiscussionMemberInfo.memberUin)))) {
          paramString.add(new SearchableDiscussionMember(paramContext, paramQQAppInterface, localDiscussionMemberInfo, l1, paramLong));
        }
      }
    }
    return paramString;
  }
  
  @Deprecated
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, ArrayList paramArrayList)
  {
    return a(paramContext, paramQQAppInterface, paramLong, paramInt, paramArrayList, (List)a(paramQQAppInterface)[1]);
  }
  
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, ArrayList paramArrayList, List paramList)
  {
    long l1 = System.currentTimeMillis();
    FriendManager localFriendManager = (FriendManager)paramQQAppInterface.getManager(8);
    ArrayList localArrayList = new ArrayList();
    if (localFriendManager != null)
    {
      long l2 = a(paramInt);
      String str = paramQQAppInterface.a();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Iterator localIterator = ((ArrayList)paramList.next()).iterator();
          while (localIterator.hasNext())
          {
            DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localIterator.next();
            if ((localDiscussionMemberInfo != null) && (localDiscussionMemberInfo.memberUin != null) && (!localDiscussionMemberInfo.memberUin.equals(str)))
            {
              Friends localFriends = localFriendManager.a(localDiscussionMemberInfo.memberUin);
              if (((localFriends == null) || (!localFriends.isFriend())) && (!a(localArrayList, localDiscussionMemberInfo)) && ((paramArrayList == null) || (!paramArrayList.contains(localDiscussionMemberInfo.memberUin)))) {
                localArrayList.add(new SearchableDiscussionMember(paramContext, paramQQAppInterface, localDiscussionMemberInfo, l2, paramLong));
              }
            }
          }
        }
      }
    }
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "getAllDiscussionMembersExcludeFriends() time cost = " + (paramLong - l1) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, List paramList, boolean paramBoolean, ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      long l1 = a(paramInt);
      String str = paramQQAppInterface.a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.next();
        if ((localTroopMemberInfo != null) && (!localTroopMemberInfo.memberuin.equals("0")) && ((!paramBoolean) || (!localTroopMemberInfo.memberuin.equals(str))) && ((paramArrayList == null) || (!paramArrayList.contains(localTroopMemberInfo.memberuin)))) {
          localArrayList.add(new SearchableTroopMember(paramContext, paramQQAppInterface, localTroopMemberInfo, l1, paramLong));
        }
      }
    }
    return localArrayList;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, boolean paramBoolean, ArrayList paramArrayList)
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
    ContactFacade localContactFacade = (ContactFacade)paramQQAppInterface.getManager(52);
    Object localObject2 = (FriendsManager)paramQQAppInterface.getManager(49);
    if ((localObject1 != null) && (localContactFacade != null) && (localObject2 != null))
    {
      localObject1 = ((FriendManager)localObject1).a();
      localObject2 = paramQQAppInterface.a();
      if (localObject1 != null)
      {
        long l2 = a(paramInt);
        Iterator localIterator1 = ((List)localObject1).iterator();
        while (localIterator1.hasNext())
        {
          Groups localGroups = (Groups)localIterator1.next();
          localObject1 = localContactFacade.a(String.valueOf(localGroups.group_id));
          if (localObject1 != null)
          {
            Iterator localIterator2 = ((List)localObject1).iterator();
            label152:
            Friends localFriends;
            while (localIterator2.hasNext())
            {
              localFriends = (Friends)localIterator2.next();
              if (((!paramBoolean) || (!localFriends.uin.equals(localObject2))) && ((paramArrayList == null) || (!paramArrayList.contains(localFriends.uin)))) {
                if (localFriends.gathtertype != 1) {
                  break label261;
                }
              }
            }
            label261:
            for (localObject1 = paramContext.getResources().getString(2131369869);; localObject1 = localGroups.group_name)
            {
              localArrayList.add(new ContactSearchableFriend(paramContext, paramQQAppInterface, localFriends, (String)localObject1, l2, paramLong));
              break label152;
              break;
            }
          }
        }
      }
    }
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "getFriends() time cost = " + (paramLong - l1) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (localObject1 != null)
    {
      localObject1 = ((PhoneContactManager)localObject1).b();
      Object localObject2 = (List)((List)localObject1).get(0);
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localArrayList.add(new ContactsSearchablePhoneContact(paramContext, paramQQAppInterface, (PhoneContact)((Iterator)localObject2).next(), 34359738368L));
        }
      }
      if (paramBoolean)
      {
        localObject1 = (List)((List)localObject1).get(1);
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            localArrayList.add(new ContactsSearchablePhoneContact(paramContext, paramQQAppInterface, (PhoneContact)((Iterator)localObject1).next(), 8589934592L));
          }
        }
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "getPhoneContacts() time cost = " + (l2 - l1) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramContext = (TextView)findViewById(2131297286);
    paramContext.setCompoundDrawables(null, null, null, null);
    paramContext.setText(2131366465);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter((BaseAdapter)this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new geu(this));
  }
  
  private void a(View paramView)
  {
    int i1 = Utils.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    int i2 = Utils.a(this.jdField_a_of_type_AndroidContentContext, 32.0F);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = Utils.a(this.jdField_a_of_type_AndroidContentContext, 52.0F);
    View localView = paramView.findViewById(2131299473);
    localView.setBackgroundResource(2130837951);
    localView.setPadding(i1 + i2, 0, i1, 0);
    paramView.setLayoutParams(localLayoutParams);
    paramView = (RelativeLayout.LayoutParams)paramView.findViewById(2131300437).getLayoutParams();
    paramView.getRules()[15] = 0;
    paramView.leftMargin = i2;
    paramView.topMargin = Utils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putString("search_keyword" + paramQQAppInterface.a(), paramString);
    localEditor.commit();
  }
  
  private static boolean a(List paramList, DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((DiscussionMemberInfo)((IContactSearchable)paramList.next()).a()).memberUin.equals(paramDiscussionMemberInfo.memberUin)) {
        return true;
      }
    }
    return false;
  }
  
  public static Object[] a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = null;
    DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(51);
    Object localObject2 = (ContactFacade)paramQQAppInterface.getManager(52);
    if ((localDiscussionManager != null) && (localObject2 != null))
    {
      paramQQAppInterface.a();
      paramQQAppInterface = ((ContactFacade)localObject2).a("-1004");
      localObject2 = new String[paramQQAppInterface.size()];
      paramQQAppInterface = paramQQAppInterface.iterator();
      int i1 = 0;
      while (paramQQAppInterface.hasNext())
      {
        localObject1 = (DiscussionInfo)paramQQAppInterface.next();
        if ((localObject1 == null) || (((DiscussionInfo)localObject1).uin == null) || (((DiscussionInfo)localObject1).uin.length() <= 0)) {
          break label193;
        }
        localObject2[i1] = ((DiscussionInfo)localObject1).uin;
        i1 += 1;
      }
      paramQQAppInterface = localDiscussionManager.a((String[])localObject2);
      localObject1 = new ArrayList();
      int i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        ((List)localObject1).add((ArrayList)paramQQAppInterface.get(localObject2[i1]));
        i1 += 1;
      }
    }
    for (;;)
    {
      return new Object[] { paramQQAppInterface, localObject1 };
      label193:
      break;
      paramQQAppInterface = null;
    }
  }
  
  public static List b(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, boolean paramBoolean, ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = (FriendsManager)paramQQAppInterface.getManager(49);
    Object localObject1 = (ContactFacade)paramQQAppInterface.getManager(52);
    if ((localObject2 != null) && (localObject1 != null))
    {
      Object localObject3 = ((FriendsManager)localObject2).a();
      localObject1 = paramQQAppInterface.a();
      if (localObject3 != null)
      {
        long l1 = a(paramInt);
        localObject2 = ((FriendsManager)localObject2).b();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Groups localGroups = (Groups)((Iterator)localObject3).next();
          Object localObject4 = (List)((ConcurrentHashMap)localObject2).get(String.valueOf(localGroups.group_id));
          if (localObject4 != null)
          {
            localObject4 = ((List)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              Friends localFriends = (Friends)((Iterator)localObject4).next();
              if (((!paramBoolean) || (!localFriends.uin.equals(localObject1))) && ((paramArrayList == null) || (!paramArrayList.contains(localFriends.uin))) && (localFriends.gathtertype == 1)) {
                localArrayList.add(new ContactSearchableFriend(paramContext, paramQQAppInterface, localFriends, localGroups.group_name, l1, paramLong));
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299473));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new gfe(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new geo(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new gep(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private List c()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject = (SearchHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((SearchHistoryManager)localObject).a().iterator();
    while (((Iterator)localObject).hasNext())
    {
      SearchHistory localSearchHistory = (SearchHistory)((Iterator)localObject).next();
      localArrayList.add(new ContactSearchableSearchHistory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSearchHistory));
    }
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      QLog.d("SearchResultDialog", 2, "initSearchHistoryData() time cost = " + (l2 - l1) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ger(this);
      IntentFilter localIntentFilter = new IntentFilter("receiver_text");
      localIntentFilter.addAction("refresh_text");
      localIntentFilter.addAction("do_search_text");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  public static List d(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(51);
    Object localObject1 = ((ContactFacade)paramQQAppInterface.getManager(52)).a("-1004");
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      long l1 = a(paramInt);
      paramQQAppInterface.a();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((DiscussionInfo)localObject2).uin != null) && (((DiscussionInfo)localObject2).uin.length() > 0))
        {
          localObject2 = localDiscussionManager.a(((DiscussionInfo)localObject2).uin);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject2).next();
              if ((localDiscussionMemberInfo != null) && (!a(localArrayList, localDiscussionMemberInfo))) {
                localArrayList.add(new SearchableDiscussionMember(paramContext, paramQQAppInterface, localDiscussionMemberInfo, l1, paramLong));
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      Intent localIntent = new Intent("hide_soft_panel");
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      Intent localIntent = new Intent("clear_text");
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    }
  }
  
  private void g()
  {
    e();
    d();
    ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  private void h()
  {
    ((ImageButton)findViewById(2131299465)).setOnClickListener(new ges(this));
  }
  
  private void i()
  {
    Button localButton = (Button)findViewById(2131299461);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new get(this));
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BasePadActivity)) {
      ((BasePadActivity)this.jdField_a_of_type_AndroidContentContext).rightPanelEmpty();
    }
  }
  
  private void k()
  {
    if (getContext().getResources().getConfiguration().orientation == 2) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(556, 0L);
    }
  }
  
  private void l()
  {
    if (isShowing())
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 0, 0.0F, 0.0F, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      localMotionEvent = MotionEvent.obtain(l1, l1, 1, 0.0F, 0.0F, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
    }
  }
  
  private void m()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap == null)
      {
        Object[] arrayOfObject = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_JavaUtilMap = ((Map)arrayOfObject[0]);
        this.jdField_a_of_type_JavaUtilList = ((List)arrayOfObject[1]);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment != null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.getView();
      if (localView.getParent() == null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localView, -1, -1);
      }
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment != null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.getView();
      if (localView.getParent() != null) {
        ((ViewGroup)localView.getParent()).removeView(localView);
      }
    }
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 999;
    case 0: 
      return 0;
    case 1006: 
      return 1;
    case 3000: 
      return 2;
    case 1: 
      return 3;
    case 1004: 
      return 4;
    case 3: 
      return 6;
    }
    return 7;
  }
  
  protected List a()
  {
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppCircleManager = ((CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34));
    }
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager != null) {
      localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a();
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SearchResultDialog", 2, "getCircleContacts() time cost = " + (l2 - l1) + " , size = " + localArrayList1.size());
      }
      return localArrayList1;
      localArrayList1 = localArrayList2;
      if (QLog.isColorLevel())
      {
        QLog.d("SearchResultDialog", 2, "getCircleContacts(), mApp.getManager return null");
        localArrayList1 = localArrayList2;
      }
    }
  }
  
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    long l2 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramQQAppInterface.a().a().b();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        l1 = 0L;
        switch (localRecentUser.type)
        {
        }
        for (;;)
        {
          localArrayList.add(new ContactsSearchableRecentUser(paramContext, paramQQAppInterface, localRecentUser, l1, a()));
          break;
          l1 = 42949672960L;
          continue;
          l1 = 17179869184L;
          continue;
          l1 = 25769803776L;
          continue;
          l1 = 25769803776L;
        }
      }
    }
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "getRecentUsers() time cost = " + (l1 - l2) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    if ((FriendManager)paramQQAppInterface.getManager(8) == null) {
      return localArrayList1;
    }
    ExecutorService localExecutorService = Executors.newFixedThreadPool(5);
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(localExecutorService.submit(new SearchResultDialog.CallableForSearchData(this, paramContext, paramQQAppInterface, 38654705664L, paramInt)));
    localArrayList2.add(localExecutorService.submit(new SearchResultDialog.CallableForSearchData(this, paramContext, paramQQAppInterface, 34359738368L, paramInt)));
    localArrayList2.add(localExecutorService.submit(new SearchResultDialog.CallableForSearchData(this, paramContext, paramQQAppInterface, 30064771072L, paramInt)));
    localArrayList2.add(localExecutorService.submit(new SearchResultDialog.CallableForSearchData(this, paramContext, paramQQAppInterface, 4294967296L, paramInt)));
    localArrayList2.add(localExecutorService.submit(new SearchResultDialog.CallableForSearchData(this, paramContext, paramQQAppInterface, 21474836480L, paramInt)));
    paramInt = 0;
    try
    {
      while (paramInt < localArrayList2.size())
      {
        paramContext = (List)((Future)localArrayList2.get(paramInt)).get();
        localArrayList1.addAll(paramContext);
        paramContext.clear();
        paramInt += 1;
      }
      localArrayList2.clear();
      localExecutorService.shutdown();
    }
    catch (InterruptedException paramContext)
    {
      for (;;)
      {
        long l2;
        paramContext.printStackTrace();
      }
    }
    catch (ExecutionException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    if (QLog.isColorLevel())
    {
      l2 = System.currentTimeMillis();
      QLog.d("SearchResultDialog", 2, "initSearchData() time cost = " + (l2 - l1) + " , size = " + localArrayList1.size());
    }
    return localArrayList1;
  }
  
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
    Object localObject2 = (ContactFacade)paramQQAppInterface.getManager(52);
    paramContext = new ArrayList();
    if ((localObject1 != null) && (localObject2 != null))
    {
      long l2 = a(paramInt);
      localObject1 = ((ContactFacade)localObject2).a(String.valueOf(-1006));
      if (localObject1 != null)
      {
        if (paramInt != 3)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            paramContext.add(new ContactSearchablePublicAccount(paramQQAppInterface, (PublicAccountInfo)((Iterator)localObject1).next(), paramQQAppInterface.getApplication().getString(2131367989), l2, paramLong));
          }
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PublicAccountInfo)((Iterator)localObject1).next();
          if (((PublicAccountInfo)localObject2).hasIvrAbility()) {
            paramContext.add(new ContactSearchablePublicAccount(paramQQAppInterface, (PublicAccountInfo)localObject2, paramQQAppInterface.getApplication().getString(2131367989), l2, 72057594037927936L));
          } else {
            paramContext.add(new ContactSearchablePublicAccount(paramQQAppInterface, (PublicAccountInfo)localObject2, paramQQAppInterface.getApplication().getString(2131367989), l2, paramLong));
          }
        }
      }
    }
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "getPublicAccount() time cost = " + (paramLong - l1) + " , size = " + paramContext.size());
    }
    return paramContext;
  }
  
  public Map a()
  {
    m();
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      f();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_b_of_type_Boolean = false;
    if (1 == paramInt)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.getCount() == 0) {
        if (((this.p == 2) || (this.p == 1)) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment != null))
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          n();
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.c(this.g);
          if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment != null)) {
            o();
          }
          if (QLog.isColorLevel())
          {
            QLog.d("SearchResultDialog", 2, "searchFinish() search finish state = " + paramInt);
            QLog.d("SearchResultDialog", 2, "searchFinish() search finish keyword = " + this.g);
            QLog.d("SearchResultDialog", 2, "refreshSearchResultList() search finish time = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
          }
          if (ContactsSearchableCircleBuddy.jdField_a_of_type_Boolean) {
            switch (this.o)
            {
            default: 
              paramInt = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Search_circle_exp", paramInt, 0, "", "", "", "");
      ContactsSearchableCircleBuddy.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366464);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      if (paramInt != 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("搜索中...");
      break;
      paramInt = 83;
      continue;
      paramInt = 81;
      continue;
      paramInt = 59;
    }
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    a(paramContext, paramQQAppInterface, paramString1, paramInt, paramString2, null);
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramContext, ChatActivity.class);
    if (paramInt == 1008) {
      localIntent.putExtra("chat_subType", PublicAccountManager.a(paramString1, paramQQAppInterface));
    }
    localIntent.putExtra("uin", paramString1);
    String str;
    if ((paramInt == 1) || (paramInt == 1004))
    {
      str = paramString2;
      if (paramString3 != null)
      {
        localIntent.putExtra("troop_uin", paramString3);
        str = paramString2;
      }
    }
    for (;;)
    {
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", str);
      localIntent.putExtra("aio_msg_source", 1);
      paramContext.startActivity(localIntent);
      dismiss();
      paramContext = paramString3;
      if (paramString3 == null) {
        paramContext = "";
      }
      a(str, paramString1, paramContext, paramInt);
      int i1 = b(this.o);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Search", "Search_into_AIO", i1, 0, String.valueOf(a(paramInt)), String.valueOf(i1), "", "");
      return;
      str = paramString2;
      if (paramInt == 0)
      {
        Object localObject = (FriendManager)paramQQAppInterface.getManager(8);
        str = paramString2;
        if (localObject != null)
        {
          localObject = ((FriendManager)localObject).c(String.valueOf(paramString1));
          str = paramString2;
          if (localObject != null)
          {
            paramString2 = ContactUtils.a((Friends)localObject);
            localIntent.putExtra("cSpecialFlag", ((Friends)localObject).cSpecialFlag);
            if (((Friends)localObject).cSpecialFlag == 1)
            {
              localIntent.setClass(paramContext, ChatActivity.class);
              localIntent.putExtra("chat_subType", 1);
            }
            str = paramString2;
            if (((Friends)localObject).gathtertype == 1)
            {
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004C58", "0X8004C58", 2, 0, "", "", "", "");
              str = paramString2;
            }
          }
        }
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (paramConfiguration == null) {}
    for (int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation;; i1 = paramConfiguration.orientation)
    {
      if ((paramConfiguration != null) && (!this.c)) {
        dismiss();
      }
      if (!this.c) {
        break;
      }
      if (i1 == 1)
      {
        localLayoutParams.x = 0;
        localLayoutParams.width = -1;
      }
      localLayoutParams.y = 0;
      localLayoutParams.height = -1;
      localLayoutParams.windowAnimations = 16973824;
      localLayoutParams.gravity = 51;
      if (!this.c) {
        localLayoutParams.dimAmount = 0.0F;
      }
      localLayoutParams.horizontalMargin = 0.0F;
      localLayoutParams.verticalMargin = 0.0F;
      getWindow().setAttributes(localLayoutParams);
      return;
    }
    localLayoutParams.x = SizeMeasure.a(this.jdField_a_of_type_AndroidContentContext);
    if ((this.p == 5) || (this.p == 8) || (this.p == 6) || (this.p == 7))
    {
      if (i1 == 2) {}
      for (i1 = SizeMeasure.b(this.jdField_a_of_type_AndroidContentContext);; i1 = 0)
      {
        localLayoutParams.x = (i1 + localLayoutParams.x);
        localLayoutParams.width = (this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - localLayoutParams.x);
        break;
      }
    }
    if (i1 == 2) {}
    for (i1 = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getLefPanelWidth();; i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - localLayoutParams.x)
    {
      localLayoutParams.width = i1;
      break;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "refreshSearchResultList() search start keyword = " + paramString1);
    }
    if (paramString1.equals(""))
    {
      if (TextUtils.isEmpty(this.h)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.a();
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.b();
        return;
        o();
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.a(paramString1, paramString2);
    this.g = paramString2;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    SearchHistory localSearchHistory = new SearchHistory();
    localSearchHistory.type = paramInt;
    localSearchHistory.uin = paramString2;
    localSearchHistory.troopUin = paramString3;
    localSearchHistory.displayName = paramString1;
    paramString1 = (SearchHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    if (paramString1 == null) {
      return;
    }
    paramString1.a(localSearchHistory);
  }
  
  public void a(List paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.a(paramList);
    }
  }
  
  public int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 999;
    case 0: 
      return 11;
    case 4: 
      return 0;
    case 2: 
      return 13;
    case 7: 
      return 8;
    case 8: 
      return 9;
    case 9: 
    case 11: 
      return 10;
    case 10: 
      return 6;
    case 6: 
      return 7;
    case 5: 
      return 14;
    case 3: 
      return 15;
    }
    return 12;
  }
  
  public List b()
  {
    m();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected List b(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = (ContactFacade)paramQQAppInterface.getManager(52);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((ContactFacade)localObject).a("-1003");
      if (localObject != null)
      {
        if (paramInt == 1) {}
        for (;;)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(new ContactSearchableTroop(paramContext, paramQQAppInterface, (TroopInfo)((Iterator)localObject).next(), 0L, paramLong));
          }
        }
      }
    }
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "getTroops() time cost = " + (paramLong - l1) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void b(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface != null) && ((QCallFacade)paramQQAppInterface.getManager(37) != null))
    {
      dismiss();
      paramQQAppInterface = new Intent(paramContext, QCallDetailActivity.class);
      paramQQAppInterface.putExtra("uin", paramString1);
      paramQQAppInterface.putExtra("troop_uin", paramString3);
      paramQQAppInterface.putExtra("uintype", paramInt);
      paramQQAppInterface.putExtra("uinname", paramString2);
      paramQQAppInterface.putExtra("entrance", "Call");
      paramContext.startActivity(paramQQAppInterface);
    }
    paramContext = paramString3;
    if (paramString3 == null) {
      paramContext = "";
    }
    a(paramString2, paramString1, paramContext, paramInt);
  }
  
  /* Error */
  protected List c(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 496	java/lang/System:currentTimeMillis	()J
    //   3: lstore 6
    //   5: new 1215	java/util/HashSet
    //   8: dup
    //   9: invokespecial 1216	java/util/HashSet:<init>	()V
    //   12: astore 10
    //   14: iconst_4
    //   15: iload 5
    //   17: if_icmpeq +10 -> 27
    //   20: bipush 16
    //   22: iload 5
    //   24: if_icmpne +68 -> 92
    //   27: aload_2
    //   28: invokevirtual 900	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   31: invokevirtual 905	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   34: invokevirtual 908	com/tencent/mobileqq/app/proxy/RecentUserProxy:b	()Ljava/util/List;
    //   37: astore 8
    //   39: aload 8
    //   41: ifnull +44 -> 85
    //   44: aload 8
    //   46: invokeinterface 450 1 0
    //   51: astore 9
    //   53: aload 9
    //   55: invokeinterface 455 1 0
    //   60: ifeq +25 -> 85
    //   63: aload 10
    //   65: aload 9
    //   67: invokeinterface 459 1 0
    //   72: checkcast 910	com/tencent/mobileqq/data/RecentUser
    //   75: getfield 1217	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   78: invokevirtual 1218	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   81: pop
    //   82: goto -29 -> 53
    //   85: aload 8
    //   87: invokeinterface 970 1 0
    //   92: new 443	java/util/ArrayList
    //   95: dup
    //   96: invokespecial 444	java/util/ArrayList:<init>	()V
    //   99: astore 11
    //   101: aload_2
    //   102: bipush 52
    //   104: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   107: checkcast 536	com/tencent/mobileqq/app/ContactFacade
    //   110: astore 8
    //   112: aload 8
    //   114: ifnull +335 -> 449
    //   117: aload 8
    //   119: ldc_w 676
    //   122: invokevirtual 551	com/tencent/mobileqq/app/ContactFacade:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   125: astore 13
    //   127: aload 13
    //   129: ifnull +320 -> 449
    //   132: iload 5
    //   134: iconst_2
    //   135: if_icmpne +270 -> 405
    //   138: new 1220	java/util/HashMap
    //   141: dup
    //   142: invokespecial 1221	java/util/HashMap:<init>	()V
    //   145: astore 12
    //   147: aconst_null
    //   148: astore 9
    //   150: aload_2
    //   151: invokevirtual 1224	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   154: new 106	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 1226
    //   164: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: new 461	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   170: dup
    //   171: invokespecial 1227	com/tencent/mobileqq/data/DiscussionMemberInfo:<init>	()V
    //   174: invokevirtual 1230	com/tencent/mobileqq/data/DiscussionMemberInfo:getTableName	()Ljava/lang/String;
    //   177: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 1232
    //   183: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: aconst_null
    //   190: invokevirtual 1237	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   193: astore 8
    //   195: aload 8
    //   197: astore 9
    //   199: aload 8
    //   201: invokeinterface 1242 1 0
    //   206: ifeq +210 -> 416
    //   209: aload 8
    //   211: astore 9
    //   213: aload 12
    //   215: aload 8
    //   217: iconst_0
    //   218: invokeinterface 1243 2 0
    //   223: aload 8
    //   225: iconst_1
    //   226: invokeinterface 1246 2 0
    //   231: invokestatic 1251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   234: invokevirtual 1255	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: pop
    //   238: goto -43 -> 195
    //   241: astore 8
    //   243: aload 9
    //   245: ifnull +10 -> 255
    //   248: aload 9
    //   250: invokeinterface 1258 1 0
    //   255: aload 13
    //   257: invokeinterface 450 1 0
    //   262: astore 13
    //   264: aload 13
    //   266: invokeinterface 455 1 0
    //   271: ifeq +178 -> 449
    //   274: aload 13
    //   276: invokeinterface 459 1 0
    //   281: checkcast 541	com/tencent/mobileqq/persistence/Entity
    //   284: checkcast 678	com/tencent/mobileqq/data/DiscussionInfo
    //   287: astore 14
    //   289: iconst_4
    //   290: iload 5
    //   292: if_icmpeq +10 -> 302
    //   295: bipush 16
    //   297: iload 5
    //   299: if_icmpne +16 -> 315
    //   302: aload 10
    //   304: aload 14
    //   306: getfield 679	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   309: invokevirtual 1259	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   312: ifne -48 -> 264
    //   315: aload 12
    //   317: aload 14
    //   319: getfield 679	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   322: invokevirtual 1260	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   325: checkcast 1248	java/lang/Integer
    //   328: astore 8
    //   330: aload 8
    //   332: ifnonnull +179 -> 511
    //   335: iconst_0
    //   336: invokestatic 1251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   339: astore 8
    //   341: aconst_null
    //   342: astore 9
    //   344: aload_0
    //   345: invokevirtual 918	com/tencent/mobileqq/activity/contact/SearchResultDialog:a	()Ljava/util/Map;
    //   348: astore 15
    //   350: aload 15
    //   352: ifnull +20 -> 372
    //   355: aload 15
    //   357: aload 14
    //   359: getfield 679	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   362: invokeinterface 690 2 0
    //   367: checkcast 336	java/util/List
    //   370: astore 9
    //   372: aload 11
    //   374: new 1262	com/tencent/mobileqq/search/ContactSearchableDiscussion
    //   377: dup
    //   378: aload_1
    //   379: aload_2
    //   380: aload 14
    //   382: aload 8
    //   384: invokevirtual 1265	java/lang/Integer:intValue	()I
    //   387: lconst_0
    //   388: lload_3
    //   389: iload 5
    //   391: aload 9
    //   393: invokespecial 1268	com/tencent/mobileqq/search/ContactSearchableDiscussion:<init>	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/DiscussionInfo;IJJILjava/util/List;)V
    //   396: invokeinterface 481 2 0
    //   401: pop
    //   402: goto -138 -> 264
    //   405: iload 5
    //   407: ifne +6 -> 413
    //   410: goto -272 -> 138
    //   413: goto -275 -> 138
    //   416: aload 8
    //   418: ifnull -163 -> 255
    //   421: aload 8
    //   423: invokeinterface 1258 1 0
    //   428: goto -173 -> 255
    //   431: astore_1
    //   432: aconst_null
    //   433: astore 8
    //   435: aload 8
    //   437: ifnull +10 -> 447
    //   440: aload 8
    //   442: invokeinterface 1258 1 0
    //   447: aload_1
    //   448: athrow
    //   449: invokestatic 496	java/lang/System:currentTimeMillis	()J
    //   452: lstore_3
    //   453: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +48 -> 504
    //   459: ldc 14
    //   461: iconst_2
    //   462: new 106	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   469: ldc_w 1270
    //   472: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: lload_3
    //   476: lload 6
    //   478: lsub
    //   479: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   482: ldc_w 517
    //   485: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload 11
    //   490: invokeinterface 340 1 0
    //   495: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   498: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: aload 11
    //   506: areturn
    //   507: astore_1
    //   508: goto -73 -> 435
    //   511: goto -170 -> 341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	SearchResultDialog
    //   0	514	1	paramContext	Context
    //   0	514	2	paramQQAppInterface	QQAppInterface
    //   0	514	3	paramLong	long
    //   0	514	5	paramInt	int
    //   3	474	6	l1	long
    //   37	187	8	localObject1	Object
    //   241	1	8	localException	Exception
    //   328	113	8	localInteger	java.lang.Integer
    //   51	341	9	localObject2	Object
    //   12	291	10	localHashSet	java.util.HashSet
    //   99	406	11	localArrayList	ArrayList
    //   145	171	12	localHashMap	java.util.HashMap
    //   125	150	13	localObject3	Object
    //   287	94	14	localDiscussionInfo	DiscussionInfo
    //   348	8	15	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   150	195	241	java/lang/Exception
    //   199	209	241	java/lang/Exception
    //   213	238	241	java/lang/Exception
    //   150	195	431	finally
    //   199	209	507	finally
    //   213	238	507	finally
  }
  
  public void dismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "dismiss() this = " + this);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(555);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(556);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
    g();
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.e();
    }
    try
    {
      super.dismiss();
      label106:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment != null)
      {
        o();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.k();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment = null;
      }
      return;
    }
    catch (Exception localException)
    {
      break label106;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (555 == paramMessage.what) {
      k();
    }
    do
    {
      do
      {
        return true;
        if (556 == paramMessage.what)
        {
          l();
          return true;
        }
        if (1 == paramMessage.what)
        {
          a((List)paramMessage.obj);
          return true;
        }
      } while (2 != paramMessage.what);
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.b(this.jdField_b_of_type_JavaUtilList);
      }
    } while (!QLog.isColorLevel());
    QLog.d("SearchResultDialog", 2, "load history data finish");
    return true;
  }
  
  public void show()
  {
    super.show();
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "show() this = " + this);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(555);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(556);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(555);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005021", "0X8005021", this.p, 0, "", "", "", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment == null) && ((this.p == 2) || (this.p == 1)) && ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))) {
      if (this.p != 1) {
        break label166;
      }
    }
    label166:
    for (int i1 = 3;; i1 = 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment = SearchContactsFragment.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this, i1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.SearchResultDialog
 * JD-Core Version:    0.7.0.1
 */