package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.AddContactTroopHandler;
import com.tencent.biz.addContactTroopView.AddContactTroopHandler.IGetPopClassAndSearchCB;
import com.tencent.biz.addContactTroopView.AddContactTroopManage;
import com.tencent.biz.addContactTroopView.TroopCardBanner;
import com.tencent.biz.addContactTroopView.TroopCardPopClassfic;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import ggy;
import ggz;
import gha;
import ghb;
import ghc;
import ghd;
import java.util.List;
import mqq.app.AppActivity;
import tencent.im.troop_search_popclassifc.popclassifc.BannerCard;
import tencent.im.troop_search_popclassifc.popclassifc.PopCard;
import tencent.im.troop_search_searchtab.searchtab.RspBody;
import tencent.im.troop_view.troopviewInfo.RspBody;

public class TroopView
  extends ContactBaseView
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int jdField_b_of_type_Int = 1;
  private static final int jdField_c_of_type_Int = 2;
  private static final int jdField_d_of_type_Int = 3;
  private static final int jdField_e_of_type_Int = 4;
  private static final int jdField_f_of_type_Int = 5;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AddContactTroopHandler.IGetPopClassAndSearchCB jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB = new gha(this);
  private TroopCardBanner jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner;
  private TroopCardPopClassfic jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new ggz(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ghc jdField_a_of_type_Ghc;
  private ghd jdField_a_of_type_Ghd;
  private boolean jdField_a_of_type_Boolean = false;
  private AddContactTroopHandler.IGetPopClassAndSearchCB jdField_b_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB = new ghb(this);
  private boolean jdField_b_of_type_Boolean = false;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  
  public TroopView(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
    this.c = false;
    this.d = false;
    this.e = false;
    this.f = false;
  }
  
  private TopGestureLayout a()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    if (localView != null) {
      localViewGroup = (ViewGroup)localView;
    }
    if ((localViewGroup instanceof TopGestureLayout)) {
      return (TopGestureLayout)localViewGroup;
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (((AppActivity)this.jdField_a_of_type_AndroidContentContext).isResume()) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, paramInt1, getResources().getString(paramInt2), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
    }
  }
  
  private void a(List paramList)
  {
    this.jdField_a_of_type_Ghc = new ghc(this, null);
    this.jdField_a_of_type_Ghc.a(paramList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ghc);
  }
  
  private void a(popclassifc.BannerCard paramBannerCard) {}
  
  private void a(popclassifc.PopCard paramPopCard)
  {
    this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic = new TroopCardPopClassfic(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext);
    this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic.a();
    this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic.setData(paramPopCard);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.d = false;
    if (!NetworkUtil.f(getContext()))
    {
      r();
      return;
    }
    AddContactTroopHandler localAddContactTroopHandler = new AddContactTroopHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramBoolean)
    {
      if (!this.f) {
        this.jdField_a_of_type_Ghd.sendEmptyMessageDelayed(2, 5000L);
      }
      localAddContactTroopHandler.a(this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB, this.jdField_b_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB);
      return;
    }
    localAddContactTroopHandler.b(this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB, this.jdField_b_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB);
  }
  
  private boolean a()
  {
    AddContactTroopManage localAddContactTroopManage = (AddContactTroopManage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
    return (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner == null) && (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic == null) && (localAddContactTroopManage.a().searchRsb.rpt_card.size() <= 0);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner != null) {
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner.f();
    }
    if (this.jdField_a_of_type_Ghc != null) {
      this.jdField_a_of_type_Ghc.a();
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_Ghd = new ghd(this);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131296735));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298502));
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    View localView = ((LayoutInflater)localObject).inflate(2130903491, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298503));
    int i = getResources().getDimensionPixelSize(2131493297);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, 0, i / 2, 0);
    Drawable localDrawable = getResources().getDrawable(2130841610);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, localDrawable, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ggy(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localView, null, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)((LayoutInflater)localObject).inflate(2130903418, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    localObject = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a());
    ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, Utils.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), 20.0F)));
    this.jdField_a_of_type_ComTencentWidgetXListView.b((View)localObject, null, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a();
  }
  
  private void j()
  {
    this.e = true;
    this.jdField_a_of_type_Ghd.sendEmptyMessage(3);
  }
  
  private void k()
  {
    AddContactTroopManage localAddContactTroopManage = (AddContactTroopManage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
    if ((localAddContactTroopManage.a() != null) && (localAddContactTroopManage.a() != null) && (localAddContactTroopManage.a().rpt_banner_items.size() > 0) && (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner == null)) {
      a(localAddContactTroopManage.a());
    }
    if ((localAddContactTroopManage.a() != null) && (localAddContactTroopManage.a() != null) && (localAddContactTroopManage.a().rpt_pop_items.size() > 0) && (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic == null)) {
      a(localAddContactTroopManage.a());
    }
  }
  
  private void l()
  {
    a(((AddContactTroopManage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75)).a().searchRsb.rpt_card.get());
  }
  
  private void m()
  {
    if (a()) {
      s();
    }
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      p();
      q();
    }
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      q();
    }
  }
  
  private void p()
  {
    try
    {
      AddContactTroopManage localAddContactTroopManage = (AddContactTroopManage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
      k();
      if (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner != null) {
        this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner.setData(localAddContactTroopManage.a());
      }
      if (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic != null) {
        this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic.setData(localAddContactTroopManage.a());
      }
      if ((this.jdField_a_of_type_Ghc != null) && (localAddContactTroopManage.a() != null))
      {
        this.jdField_a_of_type_Ghc.a(localAddContactTroopManage.a().searchRsb.rpt_card.get());
        this.jdField_a_of_type_Ghc.notifyDataSetChanged();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void q()
  {
    this.f = true;
    t();
    if ((this.d) || (this.c))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.jdField_a_of_type_Ghd.sendEmptyMessageDelayed(0, 800L);
    }
    do
    {
      return;
      this.jdField_a_of_type_Ghd.sendEmptyMessageDelayed(0, 800L);
    } while (this.e);
    a(1, 2131366939);
  }
  
  private void r()
  {
    t();
    if (!this.e)
    {
      a(1, 2131367328);
      this.jdField_a_of_type_Ghd.sendEmptyMessageDelayed(1, 800L);
    }
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  protected void a()
  {
    super.a();
    a(2130903490);
    setBackgroundColor(getResources().getColor(2131427574));
    h();
    i();
    k();
    l();
    m();
    j();
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
    if (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner != null) {
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner.c();
    }
  }
  
  protected void c()
  {
    super.c();
    d();
  }
  
  protected void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
    if (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner != null) {
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner.d();
    }
  }
  
  protected void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner != null) {
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.TroopView
 * JD-Core Version:    0.7.0.1
 */