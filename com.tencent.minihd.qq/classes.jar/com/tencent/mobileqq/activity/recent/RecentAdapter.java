package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.biz.pubaccount.troopbarassit.RecentItemTroopBar;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.IDragViewProvider;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistant;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopBarAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentPubAccountAssistantItem;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.widget.WidgetConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.XListView;
import guz;
import gva;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class RecentAdapter
  extends BaseAdapter
  implements View.OnClickListener, View.OnLongClickListener, DragFrameLayout.IDragViewProvider, DragFrameLayout.OnDragModeChangedListener, FaceDecoder.DecodeTaskCompletionListener, SwipListView.SwipListListener
{
  protected static final int a = 1;
  public static final int b = 99;
  private long jdField_a_of_type_Long = 0L;
  protected Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new gva(this);
  private OnRecentUserOpsListener jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = null;
  protected RecentBaseData a;
  protected RecentFaceDecoder a;
  protected RecentItemBuilderFactory a;
  protected DragFrameLayout a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected BubblePopupWindow a;
  protected XListView a;
  private String jdField_a_of_type_JavaLangString = null;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  protected List a;
  protected List b;
  public int c = -1;
  private int d;
  private int e;
  private int f = -1;
  
  public RecentAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, OnRecentUserOpsListener paramOnRecentUserOpsListener, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = paramOnRecentUserOpsListener;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(99);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory = new RecentItemBuilderFactory(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this);
    if (paramInt == 0) {
      this.d = 0;
    }
    for (;;)
    {
      this.e = paramInt;
      return;
      if (paramInt == 1) {
        this.d = 5;
      } else if (paramInt == 4) {
        this.d = 7;
      } else if (paramInt == 3) {
        this.d = 10;
      }
    }
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    paramLong1 = new Date(paramLong1).getTime() / 86400000;
    return new Date(paramLong2).getTime() / 86400000 - paramLong1;
  }
  
  private void c(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    long l3;
    long l1;
    Object localObject1;
    int i;
    Object localObject2;
    for (;;)
    {
      return;
      l3 = System.currentTimeMillis();
      l1 = -1L;
      localObject1 = "";
      i = 0;
      while (i < paramList.size())
      {
        localObject2 = paramList.get(i);
        if ((localObject2 instanceof RecentBaseData)) {
          break label63;
        }
        i += 1;
      }
    }
    label63:
    long l2;
    if ((localObject2 instanceof RecentItemTroopAssistant))
    {
      localObject2 = (RecentItemTroopAssistant)localObject2;
      l2 = ((RecentItemTroopAssistant)localObject2).a.lastmsgtime;
      if (l2 == 9223372036854775805L)
      {
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131369353);
        label111:
        if (a(1000L * l2, l3) != 0L) {
          break label263;
        }
        if ((l1 >= 0L) && (l1 - l2 <= 1800)) {
          break label334;
        }
        if ((i != 0) && ((i < 1) || ((paramList.get(i - 1) instanceof RecentAdapter.TimeLineDivider)))) {
          break label337;
        }
        paramList.add(i, new RecentAdapter.TimeLineDivider(this, (String)localObject2, 1000L * l2));
        i += 1;
      }
    }
    label263:
    label334:
    label337:
    for (;;)
    {
      l1 = l2;
      break;
      localObject2 = TimeManager.a().a(((RecentItemTroopAssistant)localObject2).a.uin, l2);
      break label111;
      localObject2 = (RecentBaseData)localObject2;
      l2 = ((RecentBaseData)localObject2).jdField_a_of_type_Long;
      if (((RecentBaseData)localObject2).b == null) {}
      for (localObject2 = "";; localObject2 = ((RecentBaseData)localObject2).b) {
        break;
      }
      if (!((String)localObject1).equals(localObject2))
      {
        if ((i == 0) || ((i >= 1) && (!(paramList.get(i - 1) instanceof RecentAdapter.TimeLineDivider))))
        {
          paramList.add(i, new RecentAdapter.TimeLineDivider(this, (String)localObject2, l2 * 1000L));
          i += 1;
        }
        for (;;)
        {
          localObject1 = localObject2;
          break;
        }
      }
      break;
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() == 1))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList.get(0);
      if (localObject != null)
      {
        if (localObject.equals("RECENT_BLANK_VIEW")) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
        if (localObject.equals(RecentItemBuilderFactory.a)) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
      }
    }
  }
  
  public RecentBaseData a(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag(-1) instanceof Integer)))
    {
      paramView = getItem(((Integer)paramView.getTag(-1)).intValue());
      if ((paramView instanceof RecentBaseData)) {
        return (RecentBaseData)paramView;
      }
    }
    return null;
  }
  
  public DragFrameLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      if (localView != null)
      {
        localView = localView.findViewById(2131301984);
        if ((localView != null) && ((localView instanceof DragTextView)))
        {
          DragTextView localDragTextView = (DragTextView)localView;
          if ((localView.getVisibility() == 0) && (localDragTextView.a() != -1)) {
            localArrayList.add(localView);
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(paramString))) {}
    long l;
    for (;;)
    {
      return;
      if ((paramBitmap != null) || (paramInt1 <= 0))
      {
        if (paramBitmap != null) {
          this.jdField_a_of_type_JavaUtilHashtable.put(paramInt2 + ":" + paramString, paramBitmap);
        }
        l = System.currentTimeMillis();
        if ((this.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > 300L)) {}
        for (paramInt2 = 1; (paramInt1 <= 0) || (paramInt2 != 0); paramInt2 = 0) {
          synchronized (this.jdField_a_of_type_JavaUtilHashtable)
          {
            if (this.jdField_a_of_type_JavaUtilHashtable.size() != 0) {
              break label135;
            }
            return;
          }
        }
      }
    }
    label135:
    boolean bool;
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_Long = 0L;
      bool = false;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        RecentBaseData localRecentBaseData = a(localView);
        if (localRecentBaseData == null)
        {
          break label531;
          this.jdField_a_of_type_Long = l;
          break;
        }
        int i = ((Integer)RecentFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentBaseData.a(), localRecentBaseData.a()).first).intValue();
        if (i == -2147483648) {
          break label531;
        }
        paramString = i + ":" + localRecentBaseData.a();
        paramString = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString);
        if (paramString == null) {
          break label531;
        }
        if (i == 103)
        {
          l = System.currentTimeMillis();
          paramBitmap = BaseApplication.getContext().getResources().getDrawable(2130838432);
          if ((paramBitmap instanceof SkinnableBitmapDrawable)) {
            ((SkinnableBitmapDrawable)paramBitmap).setGravity(81);
          }
          if ((paramBitmap instanceof BitmapDrawable)) {
            ((BitmapDrawable)paramBitmap).setGravity(81);
          }
          paramBitmap.setBounds(0, 0, paramBitmap.getIntrinsicWidth(), paramBitmap.getIntrinsicHeight());
          paramBitmap = new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), paramString), paramBitmap });
          paramString = paramBitmap;
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "onDecodeTaskCompleted, subaccount cost = " + (System.currentTimeMillis() - l));
          }
        }
        for (paramString = paramBitmap;; paramString = new BitmapDrawable(BaseApplication.getContext().getResources(), paramString))
        {
          a(localView, localRecentBaseData, paramString);
          bool = true;
          break;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "decodecomplete|faceCache size = " + this.jdField_a_of_type_JavaUtilHashtable.size() + ", isNeedUpdateAvatar=" + bool);
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      return;
      label531:
      paramInt1 += 1;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    int j = 0;
    if (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject = getItem(j);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        int i = ((RecentBaseData)localObject).a();
        if (((RecentBaseData)localObject).a() == 8)
        {
          int k = ((RecentBaseData)localObject).H;
          i = k;
          if (k != 0) {
            i = 1006;
          }
        }
        if ((paramInt != i) || (!((RecentBaseData)localObject).a().equals(paramString))) {
          break label129;
        }
        this.f = paramInt;
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentWidgetXListView.setItemChecked(this.jdField_a_of_type_ComTencentWidgetXListView.m() + j, true);
      }
      for (;;)
      {
        j += 1;
        break;
        label129:
        this.jdField_a_of_type_ComTencentWidgetXListView.setItemChecked(this.jdField_a_of_type_ComTencentWidgetXListView.m() + j, false);
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    RecentBaseData localRecentBaseData = (RecentBaseData)getItem(paramInt);
    if (Utils.a(paramString1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(RecentItemBaseBuilder.a[0])))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(localRecentBaseData, paramString2);
      }
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        if (paramInt >= 1)
        {
          paramString1 = getItem(paramInt - 1);
          if ((paramString1 != null) && ((paramString1 instanceof RecentAdapter.TimeLineDivider))) {
            this.jdField_a_of_type_JavaUtilList.remove(paramString1);
          }
        }
        this.jdField_a_of_type_JavaUtilList.remove(localRecentBaseData);
        d();
        notifyDataSetChanged();
      }
      switch (localRecentBaseData.a())
      {
      default: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "999", paramString2, "", "");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener == null)
    {
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "0", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "1", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "2", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "3", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "4", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "5", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "6", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "7", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "8", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "9", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050FC", "0X80050FC", 0, 0, "", "", "", "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050FE", "0X80050FE", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramString1, localRecentBaseData, paramString2);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData)
  {
    a(paramView, paramRecentBaseData, null);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {}
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = paramDrawable;
      if (paramDrawable == null) {
        localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(paramRecentBaseData.a(), paramRecentBaseData.a());
      }
      paramDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(paramRecentBaseData);
    } while (paramDrawable == null);
    paramDrawable.a(paramView, paramRecentBaseData, this.jdField_a_of_type_AndroidContentContext, localDrawable);
  }
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (paramRecentBaseData == null)) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    label22:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if (localRecentBaseData != null) {
        break label57;
      }
    }
    label57:
    while (!localRecentBaseData.equals(paramRecentBaseData))
    {
      i += 1;
      break label22;
      break;
    }
    a(localView, localRecentBaseData);
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.setDragViewProvider(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      b(null);
      this.b = null;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    label26:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if ((localRecentBaseData != null) && (localRecentBaseData.a() == paramInt)) {
        break label71;
      }
    }
    label71:
    while (!Utils.a(localRecentBaseData.a(), paramString))
    {
      i += 1;
      break label26;
      break;
    }
    a(localView, localRecentBaseData);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 1;
    label26:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if ((localRecentBaseData != null) && (Utils.a(paramString, localRecentBaseData.a()))) {
        break label74;
      }
    }
    label74:
    int k;
    do
    {
      i += 1;
      break label26;
      break;
      k = localRecentBaseData.a();
      if ((paramBoolean) && (k == 1))
      {
        a(localView, localRecentBaseData);
        return;
      }
    } while ((paramBoolean) || ((k != 0) && (k != 1000) && (k != 1020) && (k != 1003) && (k != 1025) && (k != 1005) && (k != 1004) && (k != 1008) && (k != 1001) && (k != 1009) && (k != 1023) && (k != 1024) && (k != 7000) && (k != 7100) && (k != 1010)));
    a(localView, localRecentBaseData);
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (this.b == null) {
        this.b = new ArrayList(4);
      }
      this.b.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        this.b.add(localObject);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.b();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    label76:
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localRecentBaseData = a(this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i));
      if (localRecentBaseData != null) {
        break label107;
      }
    }
    for (;;)
    {
      i += 1;
      break label76;
      break;
      label107:
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(localRecentBaseData.a(), localRecentBaseData.a(), false);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    Object localObject1;
    if (paramBoolean)
    {
      if (paramInt != 2) {
        break label270;
      }
      paramDragFrameLayout = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
      if (paramDragFrameLayout != null) {
        paramDragFrameLayout.l();
      }
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = ((Iterator)localObject1).next();
        if (((localObject3 instanceof RecentBaseData)) && ((localObject3 instanceof RecentUserBaseData)))
        {
          Object localObject2 = (RecentUserBaseData)localObject3;
          if (((RecentUserBaseData)localObject2).B > 0)
          {
            ((RecentUserBaseData)localObject2).c();
            localObject2 = ((RecentUserBaseData)localObject2).a();
            if ((localObject3 instanceof RecentItemTroopMsgData))
            {
              paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((RecentUser)localObject2).uin);
              if ((paramInt == 2) || (paramInt == 4))
              {
                RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject2, true);
              }
              else
              {
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                if (paramDragFrameLayout == null) {}
                for (paramBoolean = true;; paramBoolean = false)
                {
                  RecentUtil.a((QQAppInterface)localObject3, (RecentUser)localObject2, paramBoolean);
                  break;
                }
              }
            }
            else
            {
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramDragFrameLayout == null) {}
              for (paramBoolean = true;; paramBoolean = false)
              {
                RecentUtil.a((QQAppInterface)localObject3, (RecentUser)localObject2, paramBoolean);
                break;
              }
            }
          }
        }
      }
      if (this.e == 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800419D", "0X800419D", 0, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
      }
    }
    label270:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return;
                              paramDragFrameLayout = paramDragFrameLayout.a();
                            } while (paramDragFrameLayout == null);
                            paramDragFrameLayout = (Integer)paramDragFrameLayout.getTag();
                          } while (paramDragFrameLayout == null);
                          paramDragFrameLayout = getItem(paramDragFrameLayout.intValue());
                          if (QLog.isColorLevel()) {
                            QLog.d("Drag", 2, "onChange:" + paramDragFrameLayout);
                          }
                        } while (!(paramDragFrameLayout instanceof RecentBaseData));
                        if (!(paramDragFrameLayout instanceof RecentItemTroopBarAssitant)) {
                          break;
                        }
                        paramDragFrameLayout = (RecentItemTroopBarAssitant)paramDragFrameLayout;
                        paramDragFrameLayout.c();
                        RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                        paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1008);
                      } while (paramDragFrameLayout == null);
                      TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.time);
                      return;
                      if (!(paramDragFrameLayout instanceof RecentItemEcShopAssitant)) {
                        break;
                      }
                      paramDragFrameLayout = (RecentItemEcShopAssitant)paramDragFrameLayout;
                      paramDragFrameLayout.c();
                      RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                      paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1008);
                    } while (paramDragFrameLayout == null);
                    localObject1 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(83);
                  } while (localObject1 == null);
                  ((EcShopAssistantManager)localObject1).a(paramDragFrameLayout.time);
                  return;
                  if (!(paramDragFrameLayout instanceof RecentUserBaseData)) {
                    break;
                  }
                  paramDragFrameLayout = (RecentUserBaseData)paramDragFrameLayout;
                  paramDragFrameLayout.c();
                  paramDragFrameLayout = paramDragFrameLayout.a();
                  RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout, true);
                } while (this.e != 0);
                RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout);
                return;
                if (!(paramDragFrameLayout instanceof RecentTroopAssistantItem)) {
                  break;
                }
                paramDragFrameLayout = (RecentTroopAssistantItem)paramDragFrameLayout;
                paramDragFrameLayout.c();
                RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1);
              } while (paramDragFrameLayout == null);
              TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.time);
              return;
              if (!(paramDragFrameLayout instanceof RecentItemTroopBar)) {
                break;
              }
              paramDragFrameLayout = (RecentItemTroopBar)paramDragFrameLayout;
              paramDragFrameLayout.c();
              RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
              paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1008);
            } while (paramDragFrameLayout == null);
            TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.time);
            return;
            if (!(paramDragFrameLayout instanceof RecentItemEcShop)) {
              break;
            }
            paramDragFrameLayout = (RecentItemEcShop)paramDragFrameLayout;
            paramDragFrameLayout.c();
            RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
            paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1008);
          } while (paramDragFrameLayout == null);
          localObject1 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(83);
        } while (localObject1 == null);
        ((EcShopAssistantManager)localObject1).a(paramDragFrameLayout.time);
        return;
        if (!(paramDragFrameLayout instanceof RecentPubAccountAssistantItem)) {
          break;
        }
        paramDragFrameLayout = (RecentPubAccountAssistantItem)paramDragFrameLayout;
        paramDragFrameLayout.c();
        RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
        paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), paramDragFrameLayout.a());
      } while (paramDragFrameLayout == null);
      PubAccountAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.time);
      return;
    } while (!(paramDragFrameLayout instanceof RecentMsgBoxItem));
    paramDragFrameLayout = (RecentMsgBoxItem)paramDragFrameLayout;
    paramDragFrameLayout.c();
    RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetXListView instanceof SwipListView);
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.setDragViewProvider(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = null;
    }
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void b(List paramList)
  {
    Object localObject2 = null;
    a();
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentWidgetXListView instanceof SwipListView))
    {
      localObject3 = (SwipListView)this.jdField_a_of_type_ComTencentWidgetXListView;
      localObject1 = localObject2;
      if (this.c >= 0)
      {
        localObject1 = localObject2;
        if (this.c < this.jdField_a_of_type_JavaUtilList.size()) {
          localObject1 = this.jdField_a_of_type_JavaUtilList.get(this.c);
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "setDataList findsel, [" + this.c + "," + localObject1 + "]");
      }
      this.c = -1;
      localObject2 = localObject1;
    }
    for (Object localObject1 = localObject3;; localObject1 = null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a();
      int i;
      boolean bool;
      if (paramList != null)
      {
        localObject3 = paramList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)((Iterator)localObject3).next();
          if (localRecentBaseData != null)
          {
            Object localObject4;
            if (RecentCallItem.class.isInstance(localRecentBaseData))
            {
              localObject4 = (RecentCallItem)localRecentBaseData;
              i = ((RecentCallItem)localObject4).a();
              if ((i == 1024) && (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentCallItem)localObject4).a(), i))) {}
            }
            else
            {
              String str;
              do
              {
                do
                {
                  this.jdField_a_of_type_JavaUtilList.add(localRecentBaseData);
                  break;
                } while (!RecentUserBaseData.class.isInstance(localRecentBaseData));
                localObject4 = (RecentUserBaseData)localRecentBaseData;
                str = ((RecentUserBaseData)localObject4).a();
                i = ((RecentUserBaseData)localObject4).a();
                if ((i == 1024) && (CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, i))) {
                  ((RecentUserBaseData)localObject4).G |= 0x1000;
                }
              } while (!WidgetConstants.a(str, i));
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.i("Q.recent", 2, "setDataList, [item is null]");
          }
        }
        if (localObject1 != null)
        {
          if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
            break label575;
          }
          bool = false;
          localObject1.setDragEnable(bool);
        }
        if ((localObject2 instanceof RecentBaseData))
        {
          localObject2 = (RecentBaseData)localObject2;
          i = Math.max(localObject1.s(), 0);
          int k = Math.min(localObject1.t() + 1, this.jdField_a_of_type_JavaUtilList.size());
          label425:
          if (i < k)
          {
            if (!((RecentBaseData)localObject2).equals(this.jdField_a_of_type_JavaUtilList.get(i))) {
              break label581;
            }
            this.c = i;
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.recent", 4, "setDataList getsel, [" + i + "," + this.jdField_a_of_type_JavaUtilList.get(i) + "]");
            }
          }
        }
      }
      if ((paramList != null) && (paramList.size() > 0)) {
        switch (j)
        {
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && (this.c == -1)) {
          localObject1.b();
        }
        notifyDataSetChanged();
        return;
        label575:
        bool = true;
        break;
        label581:
        i += 1;
        break label425;
        this.jdField_a_of_type_JavaUtilList.add("RECENT_BLANK_VIEW");
        continue;
        this.jdField_a_of_type_JavaUtilList.add(RecentItemBuilderFactory.a);
        continue;
        if (4 == j)
        {
          this.jdField_a_of_type_JavaUtilList.add(RecentItemBuilderFactory.c);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F84", "0X8004F84", 0, 0, "", "", "", "");
        }
      }
      localObject2 = null;
    }
  }
  
  public boolean b()
  {
    return (c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0);
  }
  
  public void c()
  {
    this.f = -1;
    this.jdField_a_of_type_JavaLangString = null;
    notifyDataSetInvalidated();
  }
  
  protected boolean c()
  {
    return (this.d == 3) || (this.d == 8);
  }
  
  public int getCount()
  {
    if ((c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    try
    {
      if ((c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
        return Integer.valueOf(this.d);
      }
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
      {
        Object localObject = this.jdField_a_of_type_JavaUtilList.get(paramInt);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, localException.toString());
      }
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = getItem(paramInt);
    RecentItemBaseBuilder localRecentItemBaseBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject);
    RecentBaseData localRecentBaseData;
    int i;
    int j;
    if ((localObject instanceof RecentBaseData))
    {
      localRecentBaseData = (RecentBaseData)localObject;
      i = localRecentBaseData.a();
      localObject = localRecentBaseData.a();
      if (localRecentBaseData.a() != 8) {
        break label294;
      }
      j = localRecentBaseData.H;
      i = j;
      if (j == 0) {
        break label294;
      }
      i = 1006;
    }
    label294:
    for (;;)
    {
      paramView = localRecentItemBaseBuilder.a(paramInt, localRecentBaseData, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(i, (String)localObject), paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
      paramViewGroup = this.jdField_a_of_type_ComTencentWidgetXListView;
      j = this.jdField_a_of_type_ComTencentWidgetXListView.m();
      if ((i == this.f) && (((String)localObject).equals(this.jdField_a_of_type_JavaLangString))) {}
      for (boolean bool = true;; bool = false)
      {
        paramViewGroup.setItemChecked(j + paramInt, bool);
        return paramView;
      }
      if ((localObject instanceof Integer)) {
        return localRecentItemBaseBuilder.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
      }
      if ((localObject instanceof String)) {
        return localRecentItemBaseBuilder.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, null, null, null);
      }
      if ((localObject instanceof Long))
      {
        paramView = localRecentItemBaseBuilder.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
        if ((Long)localObject == RecentItemBuilderFactory.c) {
          return ((RecentCallHoldItemBuilder)localRecentItemBaseBuilder).a(paramView, this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      else
      {
        return localRecentItemBaseBuilder.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, null, null, null);
      }
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.b();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return !(getItem(paramInt) instanceof RecentAdapter.TimeLineDivider);
  }
  
  public void notifyDataSetChanged()
  {
    if (this.e == 0) {
      c(this.jdField_a_of_type_JavaUtilList);
    }
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v is null");
      }
    }
    label385:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (Utils.a("tag_recent_item_menu_item", paramView.getTag()))
          {
            localObject = paramView.getTag(-1);
            paramView = paramView.getTag(-2);
            if ((!(localObject instanceof Integer)) || (!(paramView instanceof Integer)))
            {
              if (!QLog.isDevelopLevel()) {
                continue;
              }
              QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
              return;
            }
            i = ((Integer)localObject).intValue();
            int j = ((Integer)paramView).intValue();
            localObject = null;
            try
            {
              paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(j);
              localObject = getItem(i);
              if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "onClick|obj = " + localObject + ", " + paramView);
              }
              if ((paramView != null) && ((localObject instanceof RecentBaseData)))
              {
                a(i, paramView, "2");
                return;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                paramView = (View)localObject;
                if (QLog.isDevelopLevel())
                {
                  QLog.i("Q.recent", 4, localException.toString());
                  paramView = (View)localObject;
                }
              }
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener == null) {
          break label385;
        }
        localObject = paramView.getTag(-1);
        if ((localObject instanceof Integer)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
      return;
      int i = ((Integer)localObject).intValue();
      Object localObject = getItem(i);
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "onClick|obj = " + localObject);
      }
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramView, (RecentBaseData)localObject, ((RecentBaseData)localObject).jdField_a_of_type_JavaLangString, true);
        this.f = ((RecentBaseData)localObject).a();
        this.jdField_a_of_type_JavaLangString = ((RecentBaseData)localObject).a();
        this.jdField_a_of_type_ComTencentWidgetXListView.setItemChecked(i + this.jdField_a_of_type_ComTencentWidgetXListView.m(), true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramView, localObject);
      return;
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "onClick|mRecentLis is null");
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(); ((i == 0) || (i == 4)) && (Conversation.c()); i = 0) {
      return false;
    }
    if (paramView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick v is null");
      }
      return false;
    }
    Object localObject1 = paramView.getTag(-1);
    if (!(localObject1 instanceof Integer))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick tag is not int");
      }
      return false;
    }
    int j = ((Integer)localObject1).intValue();
    localObject1 = getItem(j);
    if ((localObject1 instanceof RecentBaseData)) {}
    for (localObject1 = (RecentBaseData)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "RecentAdpater onLongClick item is null, pos = " + j);
        }
        return false;
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject1);
      if (((RecentBaseData)localObject1).a() == 1)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((RecentBaseData)localObject1).a());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "right", 0, 0, ((RecentBaseData)localObject1).a(), String.valueOf(i - 1), "", "");
      }
      paramView.setSelected(true);
      if (localObject2 != null) {}
      for (localObject1 = ((RecentItemBaseBuilder)localObject2).a((RecentBaseData)localObject1, this.jdField_a_of_type_AndroidContentContext);; localObject1 = null)
      {
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject2 = new QQCustomMenu();
          i = 0;
          while (i < ((List)localObject1).size())
          {
            ((QQCustomMenu)localObject2).a(j, (String)((List)localObject1).get(i));
            i += 1;
          }
          this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, (QQCustomMenu)localObject2, this.jdField_a_of_type_AndroidViewView$OnClickListener, new guz(this, paramView));
          return true;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "RecentAdpater onLongClick no menu, builder = " + localObject2);
        }
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter
 * JD-Core Version:    0.7.0.1
 */