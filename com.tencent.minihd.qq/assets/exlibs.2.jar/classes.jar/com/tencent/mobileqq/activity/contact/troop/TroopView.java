package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.OnTroopListClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItem;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import gki;
import gkj;
import gkk;
import gkl;
import gkm;

public class TroopView
  extends BaseTroopView
  implements View.OnClickListener, TroopListAdapter2.OnTroopListClickListener, SlideDetectListView.OnSlideListener, OverScrollViewListener
{
  private static final String jdField_a_of_type_JavaLangString = "TroopView";
  private static final String jdField_b_of_type_JavaLangString = "rec_last_troop_list_refresh_time";
  static final int c = 101;
  static final int d = 103;
  static final int jdField_e_of_type_Int = 1000;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public TroopListAdapter2 a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new gkj(this);
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public SlideDetectListView a;
  private gkk jdField_a_of_type_Gkk = new gkk(this, null);
  private gkl jdField_a_of_type_Gkl = new gkl(this, null);
  private gkm jdField_a_of_type_Gkm = new gkm(this, null);
  int jdField_b_of_type_Int;
  public boolean d = false;
  private View jdField_e_of_type_AndroidViewView = null;
  protected boolean e;
  
  public TroopView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  private long a()
  {
    return a().getSharedPreferences("rec_last_troop_list_refresh_time", 0).getLong("rec_last_troop_list_refresh_time", 0L);
  }
  
  private void a(View paramView)
  {
    Utils.a(a(), paramView);
  }
  
  private void c(int paramInt)
  {
    Object localObject2 = a();
    if ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 == null)) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getItem(paramInt - 1);
    } while (!(localObject1 instanceof TroopListAdapter2.TroopListItem));
    TroopListAdapter2.TroopListItem localTroopListItem = (TroopListAdapter2.TroopListItem)localObject1;
    Object localObject1 = null;
    switch (localTroopListItem.i)
    {
    default: 
      label108:
      if (paramInt < this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getCount())
      {
        localObject2 = (TroopListAdapter2.TroopListItem)this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getItem(paramInt);
        if ((((TroopListAdapter2.TroopListItem)localObject2).i != 6) && (((TroopListAdapter2.TroopListItem)localObject2).i != 4) && (((TroopListAdapter2.TroopListItem)localObject2).i != 2)) {
          break label358;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
        if (localObject2 != null)
        {
          paramInt = ((View)localObject2).getBottom();
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          if (paramInt >= this.b) {
            break label350;
          }
          ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - this.b);
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        }
      }
      label203:
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
      localObject1 = ((Activity)localObject2).getString(2131363418, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.g) });
      break label108;
      localObject1 = ((Activity)localObject2).getString(2131363421, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.f) });
      break label108;
      localObject1 = ((Activity)localObject2).getString(2131363419, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.d) });
      break label108;
      localObject1 = ((Activity)localObject2).getString(2131363420, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.e) });
      break label108;
      label350:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      break label203;
      label358:
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
    }
  }
  
  private boolean c()
  {
    if (NetworkUtil.f(a()))
    {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a();
      this.d = true;
      return true;
    }
    return false;
  }
  
  private void k()
  {
    this.b = getResources().getDimensionPixelSize(2131493322);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131299350));
    LayoutInflater localLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298649));
    Object localObject;
    if (this.jdField_e_of_type_Boolean)
    {
      localObject = localLayoutInflater.inflate(2130903709, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
      ((TextView)((View)localObject).findViewById(2131299373)).setText(a().getString(2131363975));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2130903418, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
      if (this.c) {
        break label305;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this);
      }
      return;
      if (this.c)
      {
        this.jdField_e_of_type_AndroidViewView = localLayoutInflater.inflate(2130904390, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
        a(this.jdField_e_of_type_AndroidViewView);
        this.jdField_e_of_type_AndroidViewView.findViewById(2131299461).setVisibility(8);
        localObject = (EditText)this.jdField_e_of_type_AndroidViewView.findViewById(2131299473);
        ((EditText)localObject).setFocusableInTouchMode(false);
        ((EditText)localObject).setOnClickListener(this);
        ((EditText)localObject).setCursorVisible(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(this.jdField_e_of_type_AndroidViewView);
        break;
      }
      localObject = new View(getContext());
      ((View)localObject).setBackgroundColor(getResources().getColor(2131427574));
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.a(16.0F, getResources())));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a((View)localObject, null, false);
      break;
      label305:
      Utils.a(a(), this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    }
  }
  
  private void m()
  {
    long l = System.currentTimeMillis();
    a().getSharedPreferences("rec_last_troop_list_refresh_time", 0).edit().putLong("rec_last_troop_list_refresh_time", l).commit();
  }
  
  protected Dialog a()
  {
    return new gki(this, a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(), 8);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    a(2130903699);
    l();
    k();
    a(this.jdField_a_of_type_Gkk);
    a(this.jdField_a_of_type_Gkl);
    a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    a(this.jdField_a_of_type_Gkm);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      this.jdField_a_of_type_Int = 6;
      return;
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(TroopInfo paramTroopInfo, int paramInt)
  {
    if (this.jdField_e_of_type_Boolean) {}
    while (paramTroopInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      ForwardOperations localForwardOperations = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a();
      if (localForwardOperations != null) {
        localForwardOperations.a(paramTroopInfo.troopuin, 1, paramTroopInfo.troopuin, paramTroopInfo.troopname);
      }
      switch (paramInt)
      {
      case 2: 
      case 4: 
      case 6: 
      default: 
        paramInt = 0;
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "turn", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(paramInt), "", "");
        return;
        paramInt = 0;
        continue;
        paramInt = 1;
        continue;
        paramInt = 2;
        continue;
        paramInt = 3;
      }
    }
    switch (paramInt)
    {
    case 2: 
    case 4: 
    case 6: 
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(paramInt), "", "");
      a(paramTroopInfo.troopuin, paramTroopInfo.troopname);
      return;
      paramInt = 0;
      continue;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
    }
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.jdField_e_of_type_Boolean) {}
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        do
        {
          return;
          localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.a(paramInt);
        } while (localTroopInfo == null);
        paramView = (ShaderAnimLayout)paramView.findViewById(2131298651);
      } while (paramView == null);
      localButton = (Button)paramView.findViewById(2131298652);
    } while (localButton == null);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramSlideDetectListView = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Activity localActivity = a();
    if (paramSlideDetectListView.h(localTroopInfo.troopuin)) {}
    for (paramInt = 2131363424;; paramInt = 2131363423)
    {
      paramSlideDetectListView = localActivity.getString(paramInt);
      localButton.setText(paramSlideDetectListView);
      localButton.setVisibility(0);
      localButton.setTag(localTroopInfo);
      localButton.setContentDescription(paramSlideDetectListView);
      paramView.a();
      return;
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    ThreadPriorityManager.a(true);
    Intent localIntent = new Intent(a(), ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    paramString1 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramString1);
    if ((paramString1 != null) && (paramString1.troopcode != null)) {
      localIntent.putExtra("troop_uin", paramString1.troopcode);
    }
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", paramString2);
    a(localIntent);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if (!c()) {
      a(103, 1000L);
    }
    return true;
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.B();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.B();
      b(2131366939);
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 == null) {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a()) {
        break label74;
      }
    }
    label74:
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 = new TroopListAdapter2(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, i, false, this.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2);
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.notifyDataSetChanged();
      return;
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.a(paramInt) == null) {}
    do
    {
      do
      {
        return;
        paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131298651);
      } while (paramSlideDetectListView == null);
      paramSlideDetectListView.d();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131298652);
    } while (paramSlideDetectListView == null);
    paramSlideDetectListView.setTag(null);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected void h()
  {
    super.h();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.b();
    }
    b(this.jdField_a_of_type_Gkk);
    b(this.jdField_a_of_type_Gkl);
    b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    b(this.jdField_a_of_type_Gkm);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.b();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView
 * JD-Core Version:    0.7.0.1
 */