package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecTroopBusinessItem;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.RecommendTroopInfo;
import com.tencent.mobileqq.data.RecommendTroopMsg;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsLocationActivity;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollToTopListener;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import gjm;
import gjn;
import gjo;
import gjq;
import gjr;
import gjs;
import gjt;
import gjv;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class RecommendTroopView
  extends BaseTroopView
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, SlideDetectListView.OnScrollToTopListener, SlideDetectListView.OnSlideListener, Observer
{
  static final int b = 104;
  public static final int c = 105;
  private static final int e = 3;
  private static final int f = 4;
  Button jdField_a_of_type_AndroidWidgetButton;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new gjm(this);
  public RecommendTroopInfo a;
  public FaceDecoder a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public SlideDetectListView a;
  public gjt a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List a;
  public RelativeLayout b;
  private int d;
  public boolean d;
  protected boolean e = true;
  protected boolean f = false;
  private boolean g = false;
  
  public RecommendTroopView(Context paramContext)
  {
    super(paramContext);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqDataRecommendTroopInfo = null;
    this.jdField_d_of_type_Int = 0;
  }
  
  private void a(RecTroopBusinessItem paramRecTroopBusinessItem)
  {
    if (paramRecTroopBusinessItem.jumpType == 3) {
      TroopQQBrowserHelper.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    do
    {
      return;
      if (paramRecTroopBusinessItem.jumpType == 2)
      {
        paramRecTroopBusinessItem = new Intent(a(), NearbyTroopsLocationActivity.class);
        paramRecTroopBusinessItem.putExtra("lat", 0);
        paramRecTroopBusinessItem.putExtra("lon", 0);
        paramRecTroopBusinessItem.putExtra("mode", 0);
        NearbyTroopsLocationActivity.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecTroopBusinessItem);
        return;
      }
    } while (paramRecTroopBusinessItem.jumpType != 1);
    TroopQQBrowserHelper.b(a(), paramRecTroopBusinessItem.jumpUrl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
  
  private void a(RecommendTroopInfo paramRecommendTroopInfo, String paramString1, String paramString2)
  {
    if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramRecommendTroopInfo.uin) != null)
    {
      b(2131366966);
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramString2 = paramRecommendTroopInfo.uin;
      if (!this.f) {
        break label124;
      }
    }
    label124:
    for (paramRecommendTroopInfo = "0";; paramRecommendTroopInfo = "1")
    {
      ReportController.b(paramString1, "CliOper", "", "", "Grp_recommend", "Direct_joingrp", 0, 0, paramString2, paramRecommendTroopInfo, "", "");
      return;
      if (paramRecommendTroopInfo.option == 3)
      {
        b(2131366967);
        break;
      }
      b(AddFriendLogicActivity.a(a(), paramRecommendTroopInfo.uin, paramRecommendTroopInfo.name, paramRecommendTroopInfo.option, 14, paramString1, paramString2, null, "群组"), 3);
      break;
    }
  }
  
  private void a(RecommendTroopInfo paramRecommendTroopInfo, boolean paramBoolean)
  {
    Object localObject;
    String str;
    if (paramRecommendTroopInfo != null)
    {
      localObject = TroopUtils.a(17, paramRecommendTroopInfo, 14);
      TroopUtils.a(a(), (Bundle)localObject, 2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str = paramRecommendTroopInfo.uin;
      if (!paramBoolean) {
        break label64;
      }
    }
    label64:
    for (paramRecommendTroopInfo = "0";; paramRecommendTroopInfo = "1")
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "Grp_recommend", "view_grpinfor", 0, 0, str, paramRecommendTroopInfo, "", "");
      return;
    }
  }
  
  private void a(XListView paramXListView, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_d_of_type_Int == 0)
    {
      int j = paramXListView.getChildCount();
      int i = 0;
      if (i < j)
      {
        gjv localgjv = (gjv)paramXListView.getChildAt(i).getTag();
        if (localgjv == null) {}
        while ((localgjv == null) || (!paramString.equals(localgjv.b)))
        {
          i += 1;
          break;
        }
        localgjv.d.setImageBitmap(paramBitmap);
      }
    }
  }
  
  private void a(List paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject1 = (RecommendTroopMsg)paramList.get(i);
      if (((RecommendTroopMsg)localObject1).isTroop())
      {
        RecommendTroopInfo localRecommendTroopInfo = ((RecommendTroopMsg)localObject1).troop;
        if ((!localRecommendTroopInfo.isSameCity) && (TextUtils.isEmpty(localRecommendTroopInfo.location)) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localRecommendTroopInfo.uin)))
        {
          String str = String.valueOf(localRecommendTroopInfo.classId);
          Object localObject2 = GroupCatalogTool.a(a()).a();
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (str.equals(((GroupCatalogBean)localObject2).b)) {}
          }
          else
          {
            localObject1 = GroupCatalogTool.a(a()).a(a(), str);
          }
          if (localObject1 != null)
          {
            localObject1 = ((GroupCatalogBean)localObject1).a();
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.jdField_a_of_type_JavaUtilHashMap.put(localRecommendTroopInfo.uin, localObject1);
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().obtainMessage();
              ((Message)localObject2).arg1 = Integer.valueOf(localRecommendTroopInfo.uin).intValue();
              ((Message)localObject2).obj = localObject1;
              ((Message)localObject2).what = 104;
              this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().sendMessage((Message)localObject2);
            }
          }
        }
      }
      i += 1;
    }
  }
  
  private boolean c()
  {
    a(2130903626);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298657));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298660));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131298658));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298659));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299001));
    this.jdField_a_of_type_Gjt = new gjt(this, a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    return true;
  }
  
  private void n()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      k();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(new gjn(this));
  }
  
  private void o()
  {
    if (((RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21) != null) && (!this.jdField_b_of_type_Boolean) && (RecommendTroopManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0))
    {
      a(1, true);
      return;
    }
    a(1, false);
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 3) || (paramInt1 == 4)) {
      n();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, paramString, paramBitmap);
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(RecommendTroopView.class, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a());
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if ((paramSlideDetectListView != this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_Gjt.getCount())) {}
    do
    {
      return;
      this.jdField_a_of_type_Gjt.a = paramInt;
      View localView = paramView.findViewById(2131298597);
      if (localView != null)
      {
        Button localButton = (Button)localView.findViewById(2131298755);
        localButton.setTag(Integer.valueOf(paramInt));
        localButton.setOnClickListener(this);
        ((ShaderAnimLayout)localView).a();
        paramSlideDetectListView.setDeleteAreaWidth(localView.getLayoutParams().width);
      }
      paramSlideDetectListView = paramView.findViewById(2131298753);
      if (paramSlideDetectListView != null) {
        paramSlideDetectListView.setVisibility(4);
      }
      paramSlideDetectListView = paramView.findViewById(2131298754);
    } while (paramSlideDetectListView == null);
    paramSlideDetectListView.setVisibility(4);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String)) && (this.jdField_a_of_type_Gjt != null))
      {
        this.jdField_a_of_type_Gjt.a(String.valueOf(paramMessage.arg1), String.valueOf(paramMessage.obj));
        continue;
        k();
      }
    }
  }
  
  public void b()
  {
    super.b();
    RecommendTroopManagerImp localRecommendTroopManagerImp = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
    int i = RecommendTroopManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.ap, 9000, 0 - i);
    if ((this.e) || (RecommendTroopManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0))
    {
      this.e = false;
      k();
    }
    localRecommendTroopManagerImp.a();
    o();
    if ((localRecommendTroopManagerImp != null) && (!this.jdField_b_of_type_Boolean) && (i > 0)) {}
    for (i = 1;; i = 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp_recommend", "Clk_grp_recom", 0, 0, "", i + "", "", "");
      return;
    }
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    Object localObject;
    if (paramSlideDetectListView == this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView)
    {
      this.jdField_a_of_type_Gjt.a = paramInt;
      this.jdField_a_of_type_Gjt.a = -1;
      paramSlideDetectListView = paramView.findViewById(2131298597);
      if (paramSlideDetectListView != null)
      {
        ((ShaderAnimLayout)paramSlideDetectListView).d();
        paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131298755);
        paramSlideDetectListView.setTag(null);
        paramSlideDetectListView.setOnClickListener(null);
      }
      paramSlideDetectListView = paramView.findViewById(2131298753);
      paramView = paramView.findViewById(2131298754);
      localObject = this.jdField_a_of_type_Gjt.a(paramInt);
      if (!((RecommendTroopMsg)localObject).isTroop()) {
        break label186;
      }
      localObject = ((RecommendTroopMsg)localObject).troop;
      localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localFriendManager != null)
      {
        if (localFriendManager.a(String.valueOf(((RecommendTroopInfo)localObject).uin)) == null) {
          break label164;
        }
        if (paramView == null) {}
      }
    }
    label164:
    label186:
    while ((!((RecommendTroopMsg)localObject).isBusiness()) || (paramSlideDetectListView == null))
    {
      FriendManager localFriendManager;
      paramView.postDelayed(new gjq(this, paramView), 300L);
      do
      {
        return;
      } while (paramSlideDetectListView == null);
      paramSlideDetectListView.postDelayed(new gjr(this, paramSlideDetectListView), 300L);
      return;
    }
    paramSlideDetectListView.postDelayed(new gjs(this, paramSlideDetectListView), 300L);
  }
  
  protected void e()
  {
    super.e();
    k();
  }
  
  protected void g()
  {
    super.g();
    RecommendTroopManagerImp localRecommendTroopManagerImp = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
    if (localRecommendTroopManagerImp != null) {
      localRecommendTroopManagerImp.a();
    }
  }
  
  protected void h()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    GroupCatalogTool.a(a()).a();
    if (this.jdField_a_of_type_Gjt != null) {
      this.jdField_a_of_type_Gjt.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  public void k()
  {
    if (this.g) {
      return;
    }
    this.g = true;
    Object localObject = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
    if (localObject != null) {}
    for (localObject = ((RecommendTroopManagerImp)localObject).a();; localObject = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(new gjo(this, (List)localObject));
      this.g = false;
      return;
    }
  }
  
  public void l()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), this.jdField_a_of_type_AndroidViewView.getHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131367583);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      RecommendTroopManagerImp.a(localException.toString());
    }
  }
  
  public void m()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      RecommendTroopManagerImp.a(localException.toString());
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramView = (RecommendTroopMsg)paramView.getTag();
          } while (paramView == null);
          if (!paramView.isTroop()) {
            break;
          }
          if (!NetworkUtil.e(a()))
          {
            b(2131365941);
            return;
          }
          localObject1 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
        } while (localObject1 == null);
        try
        {
          long l = Long.parseLong(paramView.troop.uin);
          l();
          this.f = paramView.isRead;
          this.jdField_a_of_type_ComTencentMobileqqDataRecommendTroopInfo = paramView.troop;
          ((TroopHandler)localObject1).a(l, 8388736);
          return;
        }
        catch (Exception paramView)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataRecommendTroopInfo = null;
          return;
        }
      } while (!paramView.isBusiness());
      a(paramView.rtbItem);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp_recommend", "recommend_more", 0, 0, "", "", "", "");
      return;
      paramView = new Intent(a(), NearbyTroopsActivity.class);
      paramView.putExtra("lat", 0);
      paramView.putExtra("lon", 0);
      paramView.putExtra("mode", 0);
      paramView.putExtra("from", 25);
      NearbyTroopsLocationActivity.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b();
      this.jdField_a_of_type_Gjt.a = -1;
      paramView = (Button)paramView;
    } while (paramView.getTag() == null);
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = this.jdField_a_of_type_Gjt.a(i);
    Object localObject2;
    if (paramView != null)
    {
      localObject1 = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
      if (localObject1 != null)
      {
        if (!paramView.isTroop()) {
          break label388;
        }
        localObject2 = paramView.troop;
        ((RecommendTroopManagerImp)localObject1).a(((RecommendTroopInfo)localObject2).uin, paramView.uniseq, paramView.msgtype);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp_recommend", "Grp_recom_dltgrp", 0, 0, ((RecommendTroopInfo)localObject2).code, "", "", "");
      }
    }
    for (;;)
    {
      n();
      return;
      label388:
      if (paramView.isBusiness())
      {
        localObject2 = paramView.rtbItem;
        ((RecommendTroopManagerImp)localObject1).a(paramView.uniseq, paramView.msgtype);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp_recommend", "Delete_grp_recommend", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = String.valueOf(AppConstants.ap);
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      if ((paramObservable.equals(paramObject.frienduin)) && ((paramObject.msgtype == -1039) || (paramObject.msgtype == -1040))) {
        n();
      }
    }
    while ((!(paramObject instanceof RecentUser)) || (!paramObservable.equals(((RecentUser)paramObject).uin))) {
      return;
    }
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.RecommendTroopView
 * JD-Core Version:    0.7.0.1
 */