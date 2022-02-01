package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQServiceEntry;
import com.tencent.mobileqq.app.QQServiceEntry.Tag;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.MotionViewSetter;
import hfl;
import hfm;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class ForwardRecentListAdapter
  extends BaseAdapter
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 80;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  private CircleManager jdField_a_of_type_ComTencentMobileqqAppCircleManager;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  public QQAppInterface a;
  private QQServiceEntry jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry;
  private FriendManager jdField_a_of_type_ComTencentMobileqqModelFriendManager;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private MotionViewSetter jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter = null;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable(3);
  private List jdField_a_of_type_JavaUtilList;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = null;
  private View.OnLongClickListener jdField_b_of_type_AndroidViewView$OnLongClickListener = new hfl(this);
  private String jdField_b_of_type_JavaLangString;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_c_of_type_JavaLangString;
  private Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_d_of_type_JavaLangString;
  private Drawable jdField_e_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_e_of_type_JavaLangString = "yyyy-MM-dd";
  private Drawable jdField_f_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_f_of_type_JavaLangString = "";
  private Drawable g;
  private Drawable h;
  private Drawable i;
  private Drawable j;
  private Drawable k;
  private Drawable l;
  
  public ForwardRecentListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, QQServiceEntry paramQQServiceEntry, int paramInt, List paramList, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry = paramQQServiceEntry;
    a(paramQQAppInterface);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)paramQQAppInterface.a(1));
    if (this.jdField_a_of_type_Float < 1.5D) {
      this.jdField_a_of_type_Int = 160;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    b();
    c();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130841977);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130841970);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130841982);
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = paramQQAppInterface.a(BitmapFactory.decodeResource(paramContext.getResources(), 2130838442));
    paramQQServiceEntry = BitmapFactory.decodeResource(paramContext.getResources(), 2130838437);
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable = paramQQAppInterface.a(paramQQServiceEntry);
    try
    {
      paramList = BitmapFactory.decodeResource(paramContext.getResources(), 2130838443);
      paramQQServiceEntry = paramList;
    }
    catch (OutOfMemoryError paramList)
    {
      label286:
      break label286;
    }
    this.jdField_f_of_type_AndroidGraphicsDrawableDrawable = paramQQAppInterface.a(paramQQServiceEntry);
    this.i = paramContext.getResources().getDrawable(2130841556);
    this.j = paramContext.getResources().getDrawable(2130841557);
    this.h = paramContext.getResources().getDrawable(2130841555);
    this.k = paramContext.getResources().getDrawable(2130841554);
    this.l = paramContext.getResources().getDrawable(2130841558);
    this.g = paramContext.getResources().getDrawable(2130838511);
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131368066);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(2131368067);
    this.jdField_c_of_type_JavaLangString = paramContext.getString(2131368068);
    this.jdField_d_of_type_JavaLangString = paramContext.getString(2131368069);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)paramQQAppInterface.a(2));
  }
  
  private String a(String paramString, long paramLong)
  {
    Object localObject = (HashMap)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    if ((localObject == null) || (!b()))
    {
      localObject = new HashMap();
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, localObject);
    }
    for (paramString = (String)localObject;; paramString = (String)localObject)
    {
      localObject = TimeFormatterUtils.a(1000L * paramLong, true, this.jdField_e_of_type_JavaLangString);
      paramString.put(paramLong + "", localObject);
      paramString = (String)localObject;
      String str;
      do
      {
        return paramString;
        str = (String)((HashMap)localObject).get(paramLong + "");
        paramString = str;
      } while (str != null);
      ((HashMap)localObject).clear();
    }
  }
  
  private boolean a(String paramString)
  {
    return ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramString);
  }
  
  private void b()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(10, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    this.jdField_a_of_type_Long = localCalendar.getTimeInMillis();
  }
  
  private boolean b()
  {
    if (System.currentTimeMillis() >= this.jdField_a_of_type_Long)
    {
      b();
      this.jdField_b_of_type_JavaUtilHashMap.clear();
      return false;
    }
    return true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
    Hashtable localHashtable;
    do
    {
      return;
      localHashtable = new Hashtable();
      int m = 0;
      while (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        int n = TimeFormatterUtils.a(((RecentUser)this.jdField_a_of_type_JavaUtilList.get(m)).lastmsgtime * 1000L, null);
        if (!localHashtable.containsValue(Integer.valueOf(n))) {
          localHashtable.put(Integer.valueOf(m), Integer.valueOf(n));
        }
        m += 1;
      }
    } while (localHashtable.isEmpty());
    this.jdField_a_of_type_JavaUtilHashtable = localHashtable;
  }
  
  public QQCustomDialog a(String paramString1, String paramString2)
  {
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (!"".equals(paramString1)) {}
    }
    else
    {
      str = paramString2;
    }
    return DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(str).setItems(2131230722, new hfm(this, paramString2));
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaUtilHashMap != null) {
      this.jdField_b_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)paramQQAppInterface.a(2));
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqModelFriendManager = ((FriendManager)paramQQAppInterface.getManager(8));
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager = ((CircleManager)paramQQAppInterface.getManager(34));
  }
  
  public void a(MotionViewSetter paramMotionViewSetter)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter = paramMotionViewSetter;
  }
  
  public void a(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131296551);
    paramView = (Object[])paramView.getTag(2131296567);
    if (paramView != null)
    {
      boolean bool = ((Boolean)paramView[0]).booleanValue();
      paramView = SkinUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, bool));
      paramString = paramView;
      if (bool) {
        paramString = ImageUtil.a(paramView);
      }
      localImageView.setBackgroundDrawable(new BitmapDrawable(paramString));
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    c();
    super.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(String paramString) {}
  
  public void c(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Int, null);
    }
    localView.setTag(-1, Integer.valueOf(paramInt));
    RecentUser localRecentUser = (RecentUser)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localView.setTag(2131297301, Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    TextView localTextView = (TextView)localView.findViewById(16908308);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131296551);
    if (localTextView != null)
    {
      localTextView.setMaxWidth(2147483647);
      localTextView.getLayoutParams().width = -1;
    }
    String str = localRecentUser.uin;
    int n = localRecentUser.type;
    Object localObject1 = null;
    paramView = "";
    Drawable localDrawable = null;
    QQServiceEntry.Tag localTag = (QQServiceEntry.Tag)localImageView1.getTag();
    if (localTag == null) {
      localTag = new QQServiceEntry.Tag();
    }
    for (;;)
    {
      localView.setTag(2131296567, null);
      localView.setTag(2131300513, Integer.valueOf(n));
      paramViewGroup = null;
      Object localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        if (n != 5000) {
          break label611;
        }
        localObject2 = TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localObject2 != null)
        {
          paramView = ((TroopAssistantData)localObject2).troopUin;
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((TroopAssistantData)localObject2).troopUin, 1);
        }
        localObject2 = paramViewGroup;
      }
      for (;;)
      {
        label300:
        label308:
        ImageView localImageView2;
        if (localObject2 != null)
        {
          if ((((QQMessageFacade.Message)localObject2).istroop == 3000) && (((QQMessageFacade.Message)localObject2).msg == null) && (((QQMessageFacade.Message)localObject2).time == 0L))
          {
            a(str, localRecentUser.lastmsgtime);
            if (n != 6002) {
              break label645;
            }
          }
        }
        else
        {
          localImageView2 = (ImageView)localView.findViewById(2131297281);
          switch (n)
          {
          default: 
            label484:
            paramView = null;
            paramViewGroup = localDrawable;
            label489:
            if (paramView != null)
            {
              localObject1 = paramView;
              if (!"".equals(paramView)) {}
            }
            else
            {
              localObject1 = str;
            }
            localTextView.setText((CharSequence)localObject1);
            localImageView1.setBackgroundDrawable(paramViewGroup);
          }
        }
        try
        {
          l1 = Long.valueOf(str).longValue();
          if ((l1 <= 10000L) && (1006 != localRecentUser.type)) {
            localImageView1.setImageDrawable(null);
          }
          localTag.jdField_a_of_type_JavaLangString = str;
          localTag.jdField_b_of_type_JavaLangString = ((String)localObject1);
          localTag.jdField_a_of_type_Int = n;
          localImageView1.setTag(localTag);
          if (this.jdField_a_of_type_Boolean)
          {
            float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
            return localView;
            label611:
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, n);
            continue;
            a(str, ((QQMessageFacade.Message)localObject2).time);
            break label300;
            label645:
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
            break label308;
            paramView = localRecentUser.displayName;
            paramViewGroup = new RecentFaceDecoder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(str, 104);
            break label489;
            paramView = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54)).a(str);
            if (paramView == null) {
              break label2166;
            }
            paramView = paramView.name;
            paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(str);
            break label489;
            paramView = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
            paramViewGroup = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c(str);
            if (paramViewGroup != null) {
              paramView = paramViewGroup.name;
            }
            for (;;)
            {
              paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str, (byte)3);
              break;
              if (paramView != null) {
                paramView = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, true);
              } else {
                paramView = str;
              }
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c(str);
            if ((localObject1 == null) || (((Friends)localObject1).uin == null) || (((Friends)localObject1).uin.length() <= 0)) {
              break label2161;
            }
            paramView = ContactUtils.a((Friends)localObject1);
            label904:
            int i1;
            label954:
            int m;
            if ((n == 1000) || (n == 1020))
            {
              paramView = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.g(localRecentUser.troopUin);
              paramView = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramView, localRecentUser.troopUin, true);
              if (paramView != null)
              {
                paramViewGroup = paramView;
                if (!"".equals(paramView)) {}
              }
              else
              {
                paramViewGroup = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);
              }
              i1 = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a(str);
              if (localObject1 == null) {
                break label1238;
              }
              paramInt = ((Friends)localObject1).detalStatusFlag;
              if (localObject1 == null) {
                break label1243;
              }
              m = ((Friends)localObject1).sqqOnLineState;
              label966:
              if (localImageView2 == null) {
                break label2155;
              }
              localImageView2.setVisibility(0);
              if (i1 != 10) {
                break label1309;
              }
              if ((paramInt != 30) && (paramInt != 31)) {
                break label1249;
              }
              localImageView2.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
              bool = false;
              label1008:
              if (localObject2 != null) {
                a(str, ((QQMessageFacade.Message)localObject2).time);
              }
              paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(str);
              if (!String.valueOf(AppConstants.ae).equals(str)) {
                break label1444;
              }
              paramViewGroup = BaseApplicationImpl.getContext().getString(2131367460);
              paramView = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
              label1064:
              if (!String.valueOf(AppConstants.af).equals(str)) {
                break label1508;
              }
              paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131366652);
              paramViewGroup = this.jdField_e_of_type_AndroidGraphicsDrawableDrawable;
              if (((QQMessageFacade.Message)localObject2).senderuin == null) {
                break label2138;
              }
              localObject2 = ((QQMessageFacade.Message)localObject2).senderuin;
              if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)) {
                break label1480;
              }
              localObject1 = (Friends)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
              label1135:
              if ((localObject1 != null) && (((Friends)localObject1).name != null) && (((Friends)localObject1).name.length() > 0)) {
                localObject1 = ((Friends)localObject1).name;
              }
              localObject1 = paramViewGroup;
              paramViewGroup = paramView;
              paramView = (View)localObject1;
            }
            for (;;)
            {
              localView.setTag(str);
              localView.setTag(2131296567, new Object[] { Boolean.valueOf(bool) });
              localObject1 = paramView;
              paramView = paramViewGroup;
              paramViewGroup = (ViewGroup)localObject1;
              break;
              if (n != 1004) {
                break label904;
              }
              paramView = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.troopUin, str);
              break label904;
              label1238:
              paramInt = 0;
              break label954;
              label1243:
              m = 0;
              break label966;
              label1249:
              if ((paramInt == 50) || (paramInt == 51))
              {
                localImageView2.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
                bool = false;
                break label1008;
              }
              if (paramInt == 60)
              {
                localImageView2.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
                bool = false;
                break label1008;
              }
              localImageView2.setImageDrawable(null);
              bool = false;
              break label1008;
              label1309:
              if (i1 == 11)
              {
                if ((paramInt == 30) || (paramInt == 31))
                {
                  localImageView2.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
                  bool = false;
                  break label1008;
                }
                if ((paramInt == 50) || (paramInt == 51))
                {
                  localImageView2.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
                  bool = false;
                  break label1008;
                }
                if (paramInt != 60) {
                  break label2155;
                }
                localImageView2.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
                bool = false;
                break label1008;
              }
              if ((i1 == 20) && (m == 1))
              {
                localImageView2.setImageDrawable(null);
                bool = false;
                break label1008;
              }
              localImageView2.setImageDrawable(null);
              if ((n != 1001) && (n != 1000)) {
                break label2149;
              }
              bool = false;
              break label1008;
              label1444:
              if (!String.valueOf(AppConstants.ag).equals(str)) {
                break label1064;
              }
              paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367458);
              paramView = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
              break label1064;
              label1480:
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c((String)localObject2);
              this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localObject1);
              break label1135;
              label1508:
              if (AppConstants.ac.equals(str))
              {
                paramViewGroup = ((Activity)this.jdField_a_of_type_AndroidContentContext).getResources().getString(2131367499);
                paramView = this.g;
              }
            }
            paramView = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(str);
            if (paramView == null) {
              break label2133;
            }
            paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramView);
            if (paramViewGroup != null)
            {
              paramView = paramViewGroup;
              if (!"".equals(paramViewGroup)) {}
            }
            else
            {
              paramView = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);
            }
            paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(str);
            localView.setTag(str);
            break label489;
            paramView = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a(str);
            paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if (this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(paramViewGroup, 0).getLong(paramViewGroup + str, 1L) == 0L)
            {
              if (localImageView2 != null)
              {
                localImageView2.setVisibility(0);
                localImageView2.setImageResource(2130841985);
              }
              label1691:
              localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str);
              if (paramView == null) {
                break label1795;
              }
              localObject1 = paramView.troopname;
              paramView = paramView.troopmemo;
              label1717:
              if ((localObject1 == null) || (((String)localObject1).trim().equals(""))) {
                break label1805;
              }
            }
            for (;;)
            {
              if (((QQMessageFacade.Message)localObject2).nickName != null)
              {
                paramView = (View)localObject1;
                paramViewGroup = localDrawable;
                if (!((QQMessageFacade.Message)localObject2).nickName.equals("")) {
                  break;
                }
              }
              ((QQMessageFacade.Message)localObject2).nickName = ((QQMessageFacade.Message)localObject2).senderuin;
              paramView = (View)localObject1;
              paramViewGroup = localDrawable;
              break;
              if (localImageView2 == null) {
                break label1691;
              }
              localImageView2.setImageDrawable(null);
              break label1691;
              label1795:
              localObject1 = localRecentUser.displayName;
              break label1717;
              label1805:
              localObject1 = str;
            }
            paramView = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a(str);
            if ((((QQMessageFacade.Message)localObject2).nickName == null) || (((QQMessageFacade.Message)localObject2).nickName.equals(""))) {
              ((QQMessageFacade.Message)localObject2).nickName = ((QQMessageFacade.Message)localObject2).senderuin;
            }
            if (localImageView2 != null) {
              localImageView2.setImageDrawable(null);
            }
            if (paramView == null) {}
            for (paramViewGroup = localRecentUser.displayName;; paramViewGroup = paramView.discussionName)
            {
              if (paramViewGroup != null)
              {
                paramView = paramViewGroup;
                if (paramViewGroup.length() != 0) {}
              }
              else
              {
                paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131366631);
              }
              paramViewGroup = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 101, str);
              break;
            }
            if (!String.valueOf(AppConstants.ab).equals(str)) {
              break label2125;
            }
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367736);
            paramViewGroup = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
            localObject1 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
            break label489;
            if (!String.valueOf(AppConstants.aa).equals(str)) {
              break label484;
            }
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367701);
            paramViewGroup = this.jdField_f_of_type_AndroidGraphicsDrawableDrawable;
            if (localObject2 != null)
            {
              if ((paramView != null) && (paramView.trim().length() != 0)) {
                break label2122;
              }
              paramView = ((QQMessageFacade.Message)localObject2).frienduin;
              paramView = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.e(paramView);
              if ((paramView == null) || (!paramView.trim().equals(""))) {}
            }
            TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            if (localRecentUser.lastmsgtime == 9223372036854775805L) {}
            paramView = (View)localObject1;
          }
        }
        catch (NumberFormatException paramView)
        {
          for (;;)
          {
            long l1 = 0L;
            continue;
            localImageView1.setClickable(false);
            localImageView1.setFocusable(false);
            localImageView1.setLongClickable(false);
            continue;
            label2122:
            continue;
            label2125:
            paramViewGroup = null;
            paramView = (View)localObject1;
            continue;
            label2133:
            paramViewGroup = null;
            continue;
            label2138:
            localObject1 = paramView;
            paramView = paramViewGroup;
            paramViewGroup = (ViewGroup)localObject1;
            continue;
            label2149:
            boolean bool = true;
            continue;
            label2155:
            bool = false;
            continue;
            label2161:
            paramView = null;
            continue;
            label2166:
            paramView = null;
          }
        }
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardRecentListAdapter
 * JD-Core Version:    0.7.0.1
 */