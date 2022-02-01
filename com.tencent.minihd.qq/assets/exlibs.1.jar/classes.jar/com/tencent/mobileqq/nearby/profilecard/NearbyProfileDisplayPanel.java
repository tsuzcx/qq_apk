package com.tencent.mobileqq.nearby.profilecard;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import appoint.define.appoint_define.AddressInfo;
import appoint.define.appoint_define.AppointContent;
import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.AppointInfo;
import appoint.define.appoint_define.TravelInfo;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter.ShowExternalTroopCompator;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopCompator;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItemWithMask;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.DatingDetailActivity;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.mobileqq.widget.HorizontalScrollLayout;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jip;
import jiq;
import jir;
import jis;
import jit;
import jiu;
import jiv;
import jiw;
import jix;
import jiy;
import jiz;
import jja;
import tencent.im.oidb.cmd0x7ce.AppintDetail;

public class NearbyProfileDisplayPanel
  implements View.OnClickListener, BounceScrollView.OnScrollChangedListener
{
  private static final float jdField_a_of_type_Float = 25.0F;
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new jis(this);
  private View jdField_a_of_type_AndroidViewView;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new jip(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private NewVoteAnimHelper jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper;
  private NearbyPeopleProfileActivity jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
  protected ProfileBusiEntry a;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private CustomHorizontalScrollView jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView;
  private HorizontalScrollLayout jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout;
  private VoteView jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
  private CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  protected String a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private View jdField_f_of_type_AndroidViewView;
  private LinearLayout jdField_f_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_g_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_h_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_i_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_j_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_k_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_l_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_m_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_n_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_n_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_o_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_o_of_type_AndroidWidgetTextView;
  private TextView p;
  private TextView q;
  private TextView r;
  
  public NearbyProfileDisplayPanel(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, View paramView)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels;
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float * 70.0F + 0.5D));
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float + 0.5D));
    f();
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() != 1)) {}
    }
    while (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList == null)
    {
      return 0;
      return this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  private View a(int paramInt)
  {
    View localView1 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2130903959, null);
    CustomImgView localCustomImgView = (CustomImgView)localView1.findViewById(2131298050);
    localCustomImgView.setBackground(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840157));
    NearbyPeopleProfileActivity.PicInfo localPicInfo = a(paramInt);
    localView2 = localView1.findViewById(2131299966);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840456);
    for (;;)
    {
      try
      {
        if ((localPicInfo.jdField_a_of_type_JavaLangString == null) || (localPicInfo.jdField_a_of_type_JavaLangString.length() <= 0)) {
          continue;
        }
        Object localObject2 = new LocalMediaInfo();
        ((LocalMediaInfo)localObject2).jdField_a_of_type_JavaLangString = localPicInfo.jdField_a_of_type_JavaLangString;
        ((LocalMediaInfo)localObject2).jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.p;
        ((LocalMediaInfo)localObject2).g = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.p;
        localObject2 = new URL("albumthumb", "", LocalMediaInfo.a((LocalMediaInfo)localObject2));
        if (localObject2 != null) {
          localCustomImgView.setImageDrawable(URLDrawable.getDrawable((URL)localObject2, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.p, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.p, (Drawable)localObject1, (Drawable)localObject1));
        }
        if (paramInt >= a() - 1) {
          continue;
        }
        localView2.setVisibility(0);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.nearby_people_card.", 2, "PicGallery.getView() new URL(). " + localMalformedURLException.getMessage(), localMalformedURLException);
        continue;
        if (paramInt != a() - 1) {
          continue;
        }
        localView2.setVisibility(8);
        continue;
      }
      localView1.setTag(localPicInfo);
      localView1.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localView1.setContentDescription("图片" + paramInt);
      return localView1;
      if (!StringUtil.b(localPicInfo.b))
      {
        localObject1 = URLDrawable.getDrawable(new URL(localPicInfo.b), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.p, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.p, (Drawable)localObject1, (Drawable)localObject1);
        ((URLDrawable)localObject1).setDownloadListener(new jir(this));
        localCustomImgView.setImageDrawable((Drawable)localObject1);
      }
    }
  }
  
  private TroopInfo a()
  {
    new ArrayList();
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(50)).b();
    if (localObject == null)
    {
      new ArrayList();
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Entity localEntity = (Entity)((Iterator)localObject).next();
      int i1 = TroopListAdapter2.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.b(((TroopInfo)localEntity).troopuin));
      if ((((TroopInfo)localEntity).dwAdditionalFlag & 1L) == 1L) {
        localArrayList1.add(new TroopListAdapter2.TroopListItemWithMask(i1, localEntity));
      } else if ((((TroopInfo)localEntity).dwCmdUinUinFlag & 1L) == 1L) {
        localArrayList2.add(new TroopListAdapter2.TroopListItemWithMask(i1, localEntity));
      } else {
        localArrayList3.add(new TroopListAdapter2.TroopListItemWithMask(i1, localEntity));
      }
    }
    localObject = new TroopListAdapter2.TroopCompator();
    Collections.sort(localArrayList1, (Comparator)localObject);
    Collections.sort(localArrayList2, (Comparator)localObject);
    Collections.sort(localArrayList3, (Comparator)localObject);
    if (localArrayList1.size() != 0) {
      return (TroopInfo)((TroopListAdapter2.TroopListItemWithMask)localArrayList1.get(0)).a;
    }
    if (localArrayList2.size() != 0) {
      return (TroopInfo)((TroopListAdapter2.TroopListItemWithMask)localArrayList2.get(0)).a;
    }
    if (localArrayList3.size() != 0) {
      return (TroopInfo)((TroopListAdapter2.TroopListItemWithMask)localArrayList3.get(0)).a;
    }
    return null;
  }
  
  private NearbyPeopleProfileActivity.PicInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f))
    {
      if ((paramInt + 1 >= 0) && (paramInt + 1 < this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size())) {
        return (NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt + 1);
      }
    }
    else if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.q == 5) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.u)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_c_of_type_Boolean))
    {
      localObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(67);
      if (localObject == null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131369832);
        AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, paramString, (String)localObject, 1010);
      }
    }
    else
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ChatActivity.class);
      ((Intent)localObject).putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
      ((Intent)localObject).putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
      ((Intent)localObject).putExtra("cSpecialFlag", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getIntent().getExtras().getInt("cSpecialFlag"));
      ((Intent)localObject).putExtra("uin", paramString);
      ((Intent)localObject).putExtra("uintype", paramInt);
      ((Intent)localObject).putExtra("aio_msg_source", 3);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i != 0) {
        ((Intent)localObject).putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i);
      }
      if (paramInt != 1001) {
        break label277;
      }
      ((Intent)localObject).putExtra("rich_accost_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h);
      ((Intent)localObject).addFlags(67108864);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
      return;
      localObject = ((DatingManager)localObject).b();
      break;
      label277:
      if (paramInt == 1010)
      {
        ((Intent)localObject).putExtra("rich_date_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        if (QLog.isColorLevel()) {
          QLog.i("Q.dating", 2, "enter chat, sig = " + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
      }
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    int i1 = 1;
    switch (paramArrayList.size())
    {
    }
    for (;;)
    {
      return;
      ((View)paramArrayList.get(0)).setBackgroundResource(2130838151);
      return;
      ((View)paramArrayList.get(0)).setBackgroundResource(2130838156);
      ((View)paramArrayList.get(1)).setBackgroundResource(2130838153);
      return;
      ((View)paramArrayList.get(0)).setBackgroundResource(2130838156);
      ((View)paramArrayList.get(paramArrayList.size() - 1)).setBackgroundResource(2130838153);
      while (i1 < paramArrayList.size() - 1)
      {
        ((View)paramArrayList.get(i1)).setBackgroundResource(2130838155);
        i1 += 1;
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    if (paramArrayOfByte != null)
    {
      RichStatus localRichStatus = RichStatus.a(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (localRichStatus != null) {
        paramArrayOfByte = localRichStatus.a(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131427405));
      }
      localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = new SpannableString("");
      }
      if ((localRichStatus != null) && (!TextUtils.isEmpty(localRichStatus.c)))
      {
        localObject = new SpannableStringBuilder((CharSequence)localObject);
        ((SpannableStringBuilder)localObject).insert(0, "[S] ");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {}
        for (paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localRichStatus.jdField_b_of_type_Int, 200);; paramArrayOfByte = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130841575))
        {
          paramArrayOfByte = new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
          int i1 = (int)(this.jdField_c_of_type_AndroidWidgetTextView.getTextSize() * 1.1F + 0.5F);
          paramArrayOfByte.setBounds(0, 0, i1, i1);
          paramArrayOfByte = new OffsetableImageSpan(paramArrayOfByte, 0);
          paramArrayOfByte.a(-0.1F);
          ((SpannableStringBuilder)localObject).setSpan(paramArrayOfByte, 0, "[S]".length(), 17);
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          return;
        }
      }
      paramArrayOfByte = StringUtil.e(((SpannableString)localObject).toString());
      if (TextUtils.isEmpty(paramArrayOfByte))
      {
        this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramArrayOfByte);
      this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void b(String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = String.format("https://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin });
    }
    paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, MusicGeneQQBrowserActivity.class);
    paramString.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a());
    paramString.putExtra("url", (String)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", true);
    }
    for (;;)
    {
      localObject = Calendar.getInstance();
      if ((localObject != null) && (QLog.isColorLevel()))
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(((Calendar)localObject).getTime());
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.nearby_people_card.", 4, "musicgene123 startactivity " + (String)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramString);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004182 ", "0X8004182", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", false);
    }
  }
  
  private void f()
  {
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300220));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300219));
    this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300216));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300208));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300224);
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300225));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300226));
    this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300227));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300217));
    this.jdField_g_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300228));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300229));
    this.jdField_h_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300230));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300231));
    this.jdField_i_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300233));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300234));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300235));
    this.jdField_j_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300236));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300237));
    this.jdField_k_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300238));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300239));
    this.jdField_l_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300240));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300241));
    this.jdField_m_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300243));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300244));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300245));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300246));
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout = ((HorizontalScrollLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300402));
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300248);
    this.p = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297348));
    this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297357));
    this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297360));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300210));
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300211));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300212));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300213));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300214));
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300247);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131296747));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300254));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131296544));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297656));
    this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300256));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView = ((CustomHorizontalScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300222));
    this.jdField_n_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300223));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300249));
    this.jdField_o_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300250));
    this.q = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300251));
    this.r = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300253));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300252));
    Object localObject = (LinearLayout.LayoutParams)((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300209)).getLayoutParams();
    if (localObject != null) {
      ((LinearLayout.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
    }
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    if (localObject != null) {
      ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setBackground(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840233));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131427889);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131300255).setBackgroundColor(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297963).setBackgroundColor(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297967).setBackgroundColor(0);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300232);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300242);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setNeedHorizontalGesture(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.h = 1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new AccelerateInterpolator());
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setInterpolator(new AccelerateInterpolator());
  }
  
  private void g()
  {
    Object localObject;
    Drawable localDrawable;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e)
    {
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localObject = (NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (localObject != null) {
          localDrawable = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130842237);
        }
      }
      try
      {
        if ((((NearbyPeopleProfileActivity.PicInfo)localObject).jdField_a_of_type_JavaLangString == null) || (((NearbyPeopleProfileActivity.PicInfo)localObject).jdField_a_of_type_JavaLangString.length() <= 0)) {
          break label195;
        }
        LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
        localLocalMediaInfo.jdField_a_of_type_JavaLangString = ((NearbyPeopleProfileActivity.PicInfo)localObject).jdField_a_of_type_JavaLangString;
        localLocalMediaInfo.jdField_f_of_type_Int = this.jdField_a_of_type_Int;
        localLocalMediaInfo.g = this.jdField_a_of_type_Int;
        localObject = new URL("albumthumb", "", LocalMediaInfo.a(localLocalMediaInfo));
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable((URL)localObject, localDrawable, localDrawable));
        }
        label174:
        this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby_people_card.", 2, "GridAdapter.getView() new URL(). " + localMalformedURLException.getMessage(), localMalformedURLException);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d();
    }
    label195:
    while ((!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) || ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_t_of_type_Int == 640) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.y))))
    {
      return;
      localObject = null;
      break;
      if (StringUtil.b(((NearbyPeopleProfileActivity.PicInfo)localObject).c)) {
        break label174;
      }
      localObject = URLDrawable.getDrawable(new URL(((NearbyPeopleProfileActivity.PicInfo)localObject).c), this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, localDrawable, localDrawable);
      ((URLDrawable)localObject).setDownloadListener(new jiv(this));
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      break label174;
    }
    p();
  }
  
  private void h()
  {
    this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130840415);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_n_of_type_AndroidWidgetTextView.setText(2131365114);
    this.jdField_n_of_type_AndroidWidgetTextView.setOnClickListener(new jiw(this));
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Boolean)
      {
        this.jdField_o_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_o_of_type_AndroidWidgetTextView.setText(2131367082);
        this.jdField_o_of_type_AndroidWidgetTextView.setOnClickListener(new jix(this));
      }
    }
    else {
      return;
    }
    this.jdField_o_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.feedPreviewTime = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(new jiy(this));
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a();
      String str2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.c();
      String str1 = str2;
      if (StringUtil.b(str2)) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.c();
      }
      localUserInfo.b = str1;
      localUserInfo.c = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getSid();
      QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, localUserInfo, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 0, -1, LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    }
  }
  
  private void j()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.c();
    String str1 = str2;
    if (StringUtil.b(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.c();
    }
    localUserInfo.b = str1;
    localUserInfo.c = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getSid();
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, localUserInfo, Long.valueOf(l1), 1, 0, -1);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
    }
    label174:
    label253:
    do
    {
      Object localObject;
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o != 2) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry = new ProfileBusiEntry();
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_Int = 1024;
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.b = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131363980);
            localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(50);
            if (localObject != null)
            {
              localObject = ((TroopManager)localObject).c();
              if ((localObject == null) || (((List)localObject).size() == 0)) {
                break label253;
              }
              Collections.sort((List)localObject, new ShowExternalTroopListAdapter.ShowExternalTroopCompator());
              localObject = (ShowExternalTroop)((List)localObject).get(0);
              this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_JavaLangString = ((ShowExternalTroop)localObject).strFaceUrl;
              this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.c = ((ShowExternalTroop)localObject).troopName;
            }
            for (this.jdField_a_of_type_JavaLangString = ((ShowExternalTroop)localObject).troopUin; (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.c != null); this.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject).troopuin)
            {
              this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_a_of_type_JavaLangString, "1", "", "");
              return;
              localObject = a();
              if ((localObject == null) || (((TroopInfo)localObject).troopuin == null)) {
                break label174;
              }
              String str = AvatarTroopUtil.a(AvatarTroopUtil.a(null, ((TroopInfo)localObject).troopuin, 0));
              this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_JavaLangString = str;
              this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.c = ((TroopInfo)localObject).troopname;
            }
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o != 3);
        localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(19);
      } while ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null));
      try
      {
        ((TroopHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 0, 1);
        return;
      }
      catch (NumberFormatException localNumberFormatException) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.nearby_people_card.", 2, "NumberFormatException");
  }
  
  private void l()
  {
    if ((this.jdField_g_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) && (this.jdField_h_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 8))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      if ((this.jdField_i_of_type_AndroidWidgetLinearLayout.getVisibility() != 8) || (this.jdField_j_of_type_AndroidWidgetLinearLayout.getVisibility() != 8) || (this.jdField_k_of_type_AndroidWidgetLinearLayout.getVisibility() != 8) || (this.jdField_l_of_type_AndroidWidgetLinearLayout.getVisibility() != 8)) {
        break label419;
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
        localArrayList.add(this.jdField_b_of_type_AndroidViewView);
      }
      if (this.jdField_g_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_g_of_type_AndroidWidgetLinearLayout);
      }
      if (this.jdField_h_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_h_of_type_AndroidWidgetLinearLayout);
      }
      a(localArrayList);
      localArrayList.clear();
      if (this.jdField_i_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_i_of_type_AndroidWidgetLinearLayout);
      }
      if (this.jdField_j_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_j_of_type_AndroidWidgetLinearLayout);
      }
      if (this.jdField_k_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_k_of_type_AndroidWidgetLinearLayout);
      }
      if (this.jdField_l_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_l_of_type_AndroidWidgetLinearLayout);
      }
      a(localArrayList);
      localArrayList.clear();
      if (this.jdField_m_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_m_of_type_AndroidWidgetLinearLayout);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      a(localArrayList);
      this.jdField_g_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, (int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float * 25.0F), 0);
      this.jdField_j_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, (int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float * 25.0F), 0);
      this.jdField_k_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, (int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float * 25.0F), 0);
      this.jdField_l_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, (int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float * 25.0F), 0);
      return;
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      break;
      label419:
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131369575), new jja(this), new jiq(this));
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 76)) {}
    for (int i1 = 3019;; i1 = 3007)
    {
      if ((i1 == 3007) && (!LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
      {
        m();
        return;
      }
      if ((i1 == 3019) && (!DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
      {
        m();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getIntent().getStringExtra("param_return_addr") != null)
      {
        localIntent = AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 1, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, null, i1, 0, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, null, AddContactsActivity.class.getName(), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131366374));
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(localIntent);
        return;
      }
      Intent localIntent = AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 1, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, null, i1, 0, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, null, FriendProfileCardActivity.class.getName(), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131366374));
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 1000);
      return;
    }
  }
  
  private void o()
  {
    ThreadPriorityManager.a(true);
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_Boolean)
    {
      i1 = 0;
      if (!a()) {
        break label71;
      }
      localIntent = new Intent();
      localIntent.putExtra("finchat", true);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.setResult(0, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    }
    label71:
    while ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
    {
      Intent localIntent;
      return;
      i1 = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      break;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, i1);
  }
  
  private void p()
  {
    boolean bool = true;
    this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131428001));
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840411));
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(null);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.c(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable((Drawable)localObject);
    int i1 = (int)(70.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float + 0.5D);
    int i2 = (int)(2.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float + 0.5D);
    localObject = new Paint();
    ((Paint)localObject).setColor(-1);
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    ((Paint)localObject).setStrokeWidth(i2);
    ((Paint)localObject).setAntiAlias(true);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i2 * 2 + i1, i2 * 2 + i1, Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawCircle(i1 / 2 + i2, i2 + i1 / 2, i1 / 2, (Paint)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      this.jdField_e_of_type_AndroidViewView.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131300215).setBackgroundDrawable(null);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o == 2)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130840414);
          this.jdField_a_of_type_ComTencentWidgetCustomImgView.setTag(Boolean.valueOf(bool));
          this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d();
          return;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("Q.nearby_people_card.", 2, "onHeadSizeIsSmall create bitmap oom.");
          continue;
          this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130840413);
          bool = false;
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o == 3)
          {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
          }
        }
      }
    }
  }
  
  public void a()
  {
    int i1 = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.setVisibility(8);
    }
    for (;;)
    {
      return;
      if (((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() <= 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.setVisibility(0);
      this.jdField_n_of_type_AndroidWidgetLinearLayout.removeAllViews();
      int i2 = a();
      while (i1 < i2)
      {
        View localView = a(i1);
        this.jdField_n_of_type_AndroidWidgetLinearLayout.addView(localView);
        i1 += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130842237);
        String str = ProfileCardUtil.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin));
        URL localURL = new URL("profile_img_big", null, str);
        if (paramInt2 == 1) {
          URLDrawable.removeMemoryCacheByUrl(localURL.toString());
        }
        localObject = URLDrawable.getDrawable(localURL, (Drawable)localObject, (Drawable)localObject);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        localObject = new NearbyPeopleProfileActivity.PicInfo();
        ((NearbyPeopleProfileActivity.PicInfo)localObject).jdField_a_of_type_JavaLangString = str;
        if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.add(0, localObject);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f = true;
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
          if (paramInt2 == 1) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d();
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.set(0, localObject);
          }
        }
        QLog.i("Q.nearby_people_card.", 2, localMalformedURLException.getMessage());
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
    } else if (paramInt2 != 1) {
      p();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramInt2 > paramInt4) && (paramInt2 >= this.jdField_a_of_type_Int) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8)) {
      localObject1 = this.jdField_a_of_type_AndroidViewAnimationAnimation;
    }
    for (;;)
    {
      if ((localObject1 != null) && (localObject1 != this.jdField_b_of_type_AndroidWidgetRelativeLayout.getAnimation()))
      {
        ((Animation)localObject1).reset();
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation((Animation)localObject1);
      }
      return;
      localObject1 = localObject2;
      if (paramInt2 < paramInt4)
      {
        localObject1 = localObject2;
        if (paramInt2 <= this.jdField_a_of_type_Int)
        {
          localObject1 = localObject2;
          if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
            localObject1 = this.jdField_b_of_type_AndroidViewAnimationAnimation;
          }
        }
      }
    }
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.setResult(-1);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {
      return;
    }
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo);
    }
    b();
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.dateInfo != null) {
      paramNearbyPeopleCard = new cmd0x7ce.AppintDetail();
    }
    label1410:
    label1540:
    label1927:
    for (;;)
    {
      Object localObject2;
      String str2;
      int i1;
      try
      {
        paramNearbyPeopleCard.mergeFrom(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.dateInfo);
        if (!paramNearbyPeopleCard.msg_appoints_info.has()) {
          break label1333;
        }
        paramNearbyPeopleCard = (appoint_define.AppointInfo)paramNearbyPeopleCard.msg_appoints_info.get();
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_t_of_type_JavaLangString = ((appoint_define.AppointID)paramNearbyPeopleCard.msg_appoint_id.get()).str_request_id.get();
        localObject2 = (appoint_define.AppointContent)paramNearbyPeopleCard.msg_appointment.get();
        int i3 = ((appoint_define.AppointContent)localObject2).uint32_appoint_subject.get();
        long l1 = ((appoint_define.AppointContent)localObject2).uint32_appoint_date.get();
        paramNearbyPeopleCard = (appoint_define.AddressInfo)((appoint_define.AppointContent)localObject2).msg_appoint_address.get();
        String str1 = paramNearbyPeopleCard.str_company_name.get();
        str2 = paramNearbyPeopleCard.str_company_zone.get();
        i1 = 0;
        switch (i3)
        {
        default: 
          paramNearbyPeopleCard = localResources.getString(2131369681);
          i2 = 2130840193;
          this.jdField_k_of_type_AndroidWidgetTextView.setText(paramNearbyPeopleCard);
          this.jdField_k_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
          paramNearbyPeopleCard = DatingUtil.a(l1, i3, false);
          this.jdField_l_of_type_AndroidWidgetTextView.setText(paramNearbyPeopleCard);
          this.jdField_l_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i1, 0, 0, 0);
          if (i3 == 5)
          {
            paramNearbyPeopleCard = DatingUtil.a((appoint_define.TravelInfo)((appoint_define.AppointContent)localObject2).msg_travel_info.get());
            paramNearbyPeopleCard = DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_m_of_type_AndroidWidgetTextView.getPaint(), 127, paramNearbyPeopleCard);
            this.jdField_m_of_type_AndroidWidgetTextView.setText(paramNearbyPeopleCard);
            this.jdField_m_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i1, 0, 0, 0);
            this.jdField_b_of_type_AndroidViewView.setVisibility(0);
            if (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAuthUser()) {
              break label1357;
            }
            this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject2 = new StringBuilder();
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
              break label1378;
            }
            ((StringBuilder)localObject2).append("男");
            ((StringBuilder)localObject2).append(" ");
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age > 0)
            {
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age);
              ((StringBuilder)localObject2).append("岁");
              ((StringBuilder)localObject2).append(" ");
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation != 0)
            {
              ((StringBuilder)localObject2).append(ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation));
              ((StringBuilder)localObject2).append(" ");
            }
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o != 2))
            {
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance);
              ((StringBuilder)localObject2).append(" ");
            }
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o != 2)) {
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff);
            }
            if (TextUtils.isEmpty(((StringBuilder)localObject2).toString())) {
              break label1410;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject2).toString());
            this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
            ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) {
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance);
            }
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff))
            {
              ((StringBuilder)localObject2).append(" ");
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff);
            }
            if (TextUtils.isEmpty(((StringBuilder)localObject2).toString())) {
              break label1453;
            }
            this.r.setVisibility(0);
            this.r.setText(((StringBuilder)localObject2).toString());
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o != 3) {
              break label1499;
            }
            if (this.r.getVisibility() != 0) {
              break label1465;
            }
            this.p.setVisibility(8);
            this.jdField_o_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            this.q.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
            a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
            if (!StringUtil.b(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1))) {
              break label1540;
            }
            this.jdField_h_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job <= 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job >= NearbyProfileUtil.d.length)) {
              break label1617;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job != NearbyProfileUtil.d.length - 1) {
              break label1570;
            }
            this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_f_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.d[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
            this.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company = StringUtil.e(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
            if (!StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company)) {
              break label1629;
            }
            this.jdField_j_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college = StringUtil.e(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
            if (!StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
              break label1664;
            }
            this.jdField_k_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            a(true);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchQzone) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowQzoneFeed())) {
              break label1699;
            }
            this.jdField_m_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchQzone) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowQzoneFeed()) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hasQzonePhotoUrl())) {
              break label1805;
            }
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            c();
            k();
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o != 3) {
              break label2088;
            }
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            this.jdField_f_of_type_AndroidViewView.setVisibility(0);
            d();
            l();
            if (!paramBoolean)
            {
              g();
              a();
            }
            ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
            ((StringBuilder)localObject2).append("图片1");
            ((StringBuilder)localObject2).append(this.jdField_b_of_type_AndroidWidgetTextView.getText());
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidWidgetTextView.getText());
            this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(((StringBuilder)localObject2).toString());
            return;
          }
          break;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        continue;
        paramNearbyPeopleCard = localResources.getString(2131369681);
        int i2 = 2130840248;
        i1 = 2130840193;
        continue;
        paramNearbyPeopleCard = localResources.getString(2131369684);
        i2 = 2130840254;
        i1 = 2130840195;
        continue;
        paramNearbyPeopleCard = localResources.getString(2131369682);
        i2 = 2130840251;
        i1 = 2130840194;
        continue;
        paramNearbyPeopleCard = localResources.getString(2131369683);
        i2 = 2130840257;
        i1 = 2130840197;
        continue;
        paramNearbyPeopleCard = localResources.getString(2131369685);
        i2 = 2130840260;
        i1 = 2130840198;
        continue;
      }
      label1333:
      label1357:
      label1378:
      Object localObject1;
      label1805:
      if (!TextUtils.isEmpty(str2))
      {
        paramNearbyPeopleCard = localInvalidProtocolBufferMicroException + " (" + str2 + ")";
        continue;
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        continue;
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        continue;
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        continue;
        label1453:
        label1465:
        label1617:
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1)
        {
          ((StringBuilder)localObject2).append("女");
          ((StringBuilder)localObject2).append(" ");
          continue;
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.findViewById(2131300218).getLayoutParams()).bottomMargin = ((int)(15.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float));
          continue;
          this.r.setVisibility(8);
          continue;
          this.jdField_o_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.p.setVisibility(0);
          this.p.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
          continue;
          label1499:
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o == 2)
          {
            this.jdField_o_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            this.p.setVisibility(0);
            this.p.setText("我的交友资料卡");
            continue;
            this.jdField_d_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1));
            this.jdField_h_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            continue;
            this.jdField_e_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.e[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
            this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(NearbyProfileUtil.a[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
            this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
            continue;
            this.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            continue;
            label1629:
            this.jdField_g_of_type_AndroidWidgetTextView.setText(new QQText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company, 1, 16));
            this.jdField_j_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            continue;
            this.jdField_h_of_type_AndroidWidgetTextView.setText(new QQText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college, 1, 16));
            this.jdField_k_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            continue;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.qzoneFeed;
            paramNearbyPeopleCard = (NearbyPeopleCard)localObject1;
            if (StringUtil.b((String)localObject1)) {
              paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.qzoneName;
            }
            localObject1 = paramNearbyPeopleCard;
            if (StringUtil.b(paramNearbyPeopleCard)) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname + localResources.getString(2131368259);
            }
            this.jdField_j_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
            this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener(new jit(this));
            this.jdField_m_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            continue;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getQZonePhotoList();
            str2 = MD5.toMD5("" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId);
            i1 = 0;
            if (i1 < 3)
            {
              ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300407 + i1);
              if ((localObject1 != null) && (((List)localObject1).size() > i1))
              {
                paramNearbyPeopleCard = (String)((List)localObject1).get(i1);
                label1896:
                if ((!TextUtils.isEmpty(paramNearbyPeopleCard)) || (localImageView == null)) {
                  break label1927;
                }
                localImageView.setVisibility(8);
              }
              for (;;)
              {
                i1 += 1;
                break;
                paramNearbyPeopleCard = null;
                break label1896;
                if (localImageView != null)
                {
                  String str3 = AppConstants.bV + str2 + "_" + MD5.toMD5(paramNearbyPeopleCard);
                  if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
                    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(localResources.getColor(2131427451));
                  }
                  try
                  {
                    paramNearbyPeopleCard = URLDrawable.getDrawable(new URL("profile_img_icon", paramNearbyPeopleCard, str3), this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
                    localImageView.setVisibility(0);
                    localImageView.setImageDrawable(paramNearbyPeopleCard);
                  }
                  catch (MalformedURLException paramNearbyPeopleCard)
                  {
                    localImageView.setVisibility(8);
                  }
                  if (QLog.isColorLevel()) {
                    QLog.e("Q.nearby_people_card.", 2, paramNearbyPeopleCard.toString());
                  }
                }
              }
            }
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new jiu(this));
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            continue;
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            this.jdField_f_of_type_AndroidViewView.setVisibility(8);
          }
        }
      }
      else
      {
        label1570:
        label1699:
        label2088:
        paramNearbyPeopleCard = (NearbyPeopleCard)localObject1;
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.c(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice;
      String str3 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity;
      String str4 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict;
      str1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(new String[] { str1, str2, str3, str4 });
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.nearby_people_card.", 4, "setHometownTextView hometownStr is: " + str1);
      }
      if ("不限".equals(str1)) {
        this.jdField_l_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        l();
      }
      return;
      this.jdField_i_of_type_AndroidWidgetTextView.setText(str1);
      if (this.jdField_l_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)
      {
        this.jdField_l_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        continue;
        this.jdField_l_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, List paramList)
  {
    if ((!paramBoolean) || (paramList == null) || (paramList.size() == 0) || (paramInt != 0)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.removeBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
      }
    }
    do
    {
      return;
      paramList = (ShowExternalTroop)paramList.get(0);
      this.jdField_a_of_type_JavaLangString = paramList.troopUin;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry = new ProfileBusiEntry();
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_Int = 1024;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.b = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131363980);
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.c = paramList.troopName;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_JavaLangString = paramList.strFaceUrl;
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.c == null));
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_a_of_type_JavaLangString, "0", "", "");
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "https://gamecenter.qq.com/gamecenter/index/recent_play.html";
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, GameCenterActivity.class);
      paramString = "";
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app != null) {
        paramString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getSid();
      }
      localIntent.putExtra("url", HtmlOffline.a(str, "plat=qq&tt=1&_wv=3&qappid=" + AppSetting.jdField_a_of_type_Int + "&osv=" + Build.VERSION.RELEASE + "&sid=" + paramString + "&vuin=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString + "&vname=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h + "&bn=" + paramBoolean));
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(localIntent);
    }
  }
  
  boolean a()
  {
    return (Utils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.e != 3000) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.e != 1) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.e != 2);
  }
  
  public void b()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowLikeBtn())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o == 2)
      {
        bool1 = true;
        if ((bool1) && (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper == null)) {
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper = new NewVoteAnimHelper(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 1);
        }
        VoteView localVoteView = this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted == 0) {
          break label135;
        }
        label82:
        localVoteView.a(bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper);
        this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setOnClickListener(this);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.jdField_b_of_type_Boolean = false;
      }
      return;
      bool1 = false;
      break;
      label135:
      bool2 = false;
      break label82;
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setVisibility(4);
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
      bool = this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.jdField_b_of_type_Boolean;
    }
    return bool;
  }
  
  public void c()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getBusiEntrys();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout.removeAllViews();
    int i3 = localList.size();
    if ((!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchHobby) || (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowHobby()) || (i3 == 0))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    int i1 = this.jdField_a_of_type_Int;
    if (i3 <= 4) {
      i1 /= 4;
    }
    Object localObject1;
    Object localObject2;
    LayoutInflater localLayoutInflater;
    ProfileBusiEntry localProfileBusiEntry;
    Object localObject4;
    for (;;)
    {
      localObject1 = null;
      localObject2 = null;
      localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      int i2 = 0;
      while (i2 < i3)
      {
        localProfileBusiEntry = (ProfileBusiEntry)localList.get(i2);
        if (localProfileBusiEntry != null) {
          break label172;
        }
        localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
        i2 += 1;
        localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
      }
      break;
      i1 = i1 * 146 / 640;
    }
    label172:
    View localView = localLayoutInflater.inflate(2130903988, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131299367);
    label216:
    String str2;
    String str1;
    if (localObject2 == null)
    {
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840501);
      localObject2 = localProfileBusiEntry.jdField_a_of_type_JavaLangString;
      str2 = localProfileBusiEntry.b;
      str1 = localProfileBusiEntry.c;
      if ((!StringUtil.b(str1)) && (5 < str1.length())) {
        str1 = str1.substring(0, 5) + "...";
      }
    }
    label874:
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject2 = new URL((String)localObject2);
        localObject2 = URLDrawable.getDrawable(new URL("third_part", ((URL)localObject2).getAuthority(), ((URL)localObject2).getFile()), (Drawable)localObject4, (Drawable)localObject4);
        if (localObject2 != null)
        {
          localImageView.setImageDrawable((Drawable)localObject2);
          ((TextView)localView.findViewById(2131299368)).setText(str2);
          ((TextView)localView.findViewById(2131299719)).setText(str1);
          localView.setContentDescription(str2 + str1);
          switch (localProfileBusiEntry.jdField_a_of_type_Int)
          {
          default: 
            localObject1 = new DataTag(27, localProfileBusiEntry);
            localView.setTag(localObject1);
            localView.setOnClickListener(this);
            localObject1 = new LinearLayout.LayoutParams(i1, -2);
            this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
            localObject1 = localObject4;
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        localObject3 = localObject1;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        localObject3 = null;
        continue;
        localImageView.setImageDrawable((Drawable)localObject4);
        continue;
        localDataTag = new DataTag(19, new Object[] { Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isOpenRecentPlayingGamesByNative()), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strProfileUrl, localProfileBusiEntry });
        if (this.jdField_c_of_type_Boolean) {
          break label874;
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004315 ", "0X8004315 ", 0, 0, "", "", "", "");
      this.jdField_c_of_type_Boolean = true;
      continue;
      DataTag localDataTag = new DataTag(22, localProfileBusiEntry);
      if (!this.jdField_d_of_type_Boolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004314", "0X8004314", 0, 0, "", "", "", "");
        this.jdField_d_of_type_Boolean = true;
        continue;
        localDataTag = new DataTag(21, localProfileBusiEntry);
        if (!this.jdField_b_of_type_Boolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004316", "0X8004316", 0, 0, "", "", "", "");
          this.jdField_b_of_type_Boolean = true;
          continue;
          localDataTag = new DataTag(28, localProfileBusiEntry);
          if (!this.jdField_a_of_type_Boolean)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004300", "0X8004300", 0, 0, "", "", "", "");
            this.jdField_a_of_type_Boolean = true;
            continue;
            localDataTag = new DataTag(30, localProfileBusiEntry);
            continue;
            localDataTag = new DataTag(33, localProfileBusiEntry);
            continue;
            continue;
            localObject4 = localObject3;
            break label216;
          }
          continue;
        }
        continue;
      }
    }
  }
  
  public void d()
  {
    View localView1;
    View localView2;
    View localView3;
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0))
    {
      localView1 = this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131300255);
      localView2 = this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297963);
      localView3 = this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297967);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        localView1.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        localView2.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        localView3.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    localView1.setVisibility(8);
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 75) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b == null) && (!a()))
    {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localView2.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localView3.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localView2.setVisibility(0);
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_t_of_type_Int == 640) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.y)))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_t_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.y, false);
      return;
    }
    p();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof DataTag)))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800482E", "0X800482E", 0, 0, "", "", "", "");
      paramView = (DataTag)localObject1;
      switch (paramView.J)
      {
      }
    }
    for (;;)
    {
      return;
      if ((paramView.a instanceof ProfileBusiEntry))
      {
        paramView = (ProfileBusiEntry)paramView.a;
        if (!StringUtil.b(paramView.d))
        {
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("portraitOnly", true);
          if (!StringUtil.b(paramView.d)) {
            break label280;
          }
          paramView = "";
          label204:
          ((Intent)localObject1).putExtra("url", paramView);
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CC", "0X80050CC", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        label280:
        paramView = paramView.d;
        break label204;
        if ((paramView.a instanceof Object[]))
        {
          paramView = (Object[])paramView.a;
          a(((Boolean)paramView[0]).booleanValue(), (String)paramView[1]);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CA", "0X80050CA ", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        if ((paramView.a instanceof ProfileBusiEntry))
        {
          paramView = (ProfileBusiEntry)paramView.a;
          if (!StringUtil.b(paramView.d)) {
            b(paramView.d);
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CB", "0X80050CB ", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        Object localObject2;
        if ((paramView.a instanceof ProfileBusiEntry))
        {
          localObject1 = (ProfileBusiEntry)paramView.a;
          if (!StringUtil.b(((ProfileBusiEntry)localObject1).d))
          {
            localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", ((ProfileBusiEntry)localObject1).d);
            ((Intent)localObject2).putExtra("hide_operation_bar", true);
            ((Intent)localObject2).putExtra("hide_more_button", true);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
          }
        }
        if (28 != paramView.J) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CD", "0X80050CD", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        if (!(paramView.a instanceof ProfileBusiEntry)) {
          continue;
        }
        paramView = (ProfileBusiEntry)paramView.a;
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ShowExternalTroopListActivity.class);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.putExtra("isHost", bool);
          paramView.putExtra("dest_uin_str", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o != 2) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_a_of_type_JavaLangString, "1", "", "");
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o != 3) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_a_of_type_JavaLangString, "0", "", "");
        return;
        if (!(paramView.a instanceof ProfileBusiEntry)) {
          continue;
        }
        paramView = (ProfileBusiEntry)paramView.a;
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView.d + "&_webviewtype=1");
        ((Intent)localObject1).putExtra("hide_operation_bar", true);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005102", "0X8005102", 0, 0, "", "", "", "");
        return;
        if (paramView == this.jdField_c_of_type_AndroidWidgetLinearLayout)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname;
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, paramView, (String)localObject1, null, true, null, true, true, null, null);
          return;
        }
        if (paramView == this.jdField_d_of_type_AndroidWidgetLinearLayout)
        {
          o();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004826", "0X8004826", 0, 0, "", "", "", "");
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 76))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004944", "0X8004944", 0, 0, "", "", "", "");
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 41) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int != 103)) {
            continue;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
          if (VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app)) {}
          for (paramView = "1";; paramView = "0")
          {
            VipUtils.a((QQAppInterface)localObject1, "Vip_MapRoam", "0X8004A35", "0X8004A35", 0, 0, new String[] { paramView });
            return;
          }
        }
        if (paramView == this.jdField_e_of_type_AndroidWidgetLinearLayout)
        {
          n();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004827", "0X8004827", 0, 0, "", "", "", "");
          return;
        }
        if (paramView == this.jdField_f_of_type_AndroidWidgetLinearLayout)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          paramView = (View)localObject1;
          if (StringUtil.b((String)localObject1))
          {
            paramView = (View)localObject1;
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
              paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
            }
          }
          if (StringUtil.b(paramView))
          {
            paramView = "0";
            long l1;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Long == 0L) {
              if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
              {
                l1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId;
                if ((!"0".equals(paramView)) || (l1 != 0L)) {
                  switch (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
                  {
                  }
                }
              }
            }
            for (;;)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004828", "0X8004828", 0, 0, "", "", "", "");
              return;
              l1 = 0L;
              break;
              l1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Long;
              break;
              ReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 403, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_t_of_type_JavaLangString, paramView, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(), String.valueOf(l1), "");
              continue;
              ReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 402, "", paramView, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(), String.valueOf(l1), "");
            }
          }
        }
        else
        {
          int i1;
          if (paramView == this.jdField_b_of_type_AndroidViewView)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800482B", "0X800482B", 0, 0, "", "", "", "");
            if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 76)) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004942", "0X8004942", 0, 0, "", "", "", "");
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 18) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_t_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.u)))
            {
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
              return;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o == 2) {}
            for (i1 = 1;; i1 = 2)
            {
              DatingDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_t_of_type_JavaLangString, i1, 1003, null, false, false);
              return;
            }
          }
          if (paramView == this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView)
          {
            if (2 == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o)
            {
              paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, VisitorsActivity.class);
              if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
              {
                i1 = 0;
                label1753:
                localObject1 = new Bundle();
                ((Bundle)localObject1).putLong("toUin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a()).longValue());
                ((Bundle)localObject1).putLong("totalVoters", i1);
                ((Bundle)localObject1).putBoolean("isStartedByProfileCard", true);
                ((Bundle)localObject1).putBoolean("votersOnly", true);
                if (i1 <= 0) {
                  break label1974;
                }
              }
              label1974:
              for (bool = true;; bool = false)
              {
                ((Bundle)localObject1).putBoolean("hasVoters", bool);
                paramView.putExtras((Bundle)localObject1);
                this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
                ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(49)).c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a());
                if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
                  this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc = 0;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
                  this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.jdField_b_of_type_Boolean = true;
                }
                if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getIntent() == null) || (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getIntent().getBooleanExtra("IS_NEARBY_REDDOT_INCOME", false))) {
                  break;
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005249", "0X8005249", 0, 0, "", "", "", "");
                return;
                i1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount;
                break label1753;
              }
            }
            if ((3 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted != 0)) {
              continue;
            }
            localObject1 = new HashMap();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a();
            paramView = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(2);
            if ((paramView != null) && (NetworkUtil.e(BaseApplication.getContext()))) {
              if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vCookies;
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
                ((NearbyPeopleCard)localObject2).likeCount += 1;
                this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted = 1;
                paramView.b(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue(), (byte[])localObject1, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.favoriteSource);
                b();
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "P_prof", "Prof_good", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
              }
            }
            for (;;)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004825", "0X8004825", 1, 0, "", "", "", "");
              return;
              if (paramView != null)
              {
                ((HashMap)localObject1).put("param_FailCode", "-203");
                StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a()).a((String)localObject2, "profileCardSendFavorite", true, 0L, 0L, (HashMap)localObject1, "", false);
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131368236, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
              }
              else
              {
                ((HashMap)localObject1).put("param_FailCode", "-204");
                StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131368258, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
              }
            }
          }
          if (paramView == this.jdField_a_of_type_ComTencentImageURLImageView)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() < 1)) {
              continue;
            }
            paramView = (NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(0);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.indexOf(paramView));
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
            return;
          }
          if (paramView != this.jdField_a_of_type_ComTencentWidgetCustomImgView) {
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o == 2)
          {
            paramView = (Boolean)paramView.getTag();
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(100L);
            if ((paramView != null) && (!paramView.booleanValue())) {
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new jiz(this), 300L);
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050C9", "0X80050C9", 0, 0, "", "", "", "");
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o != 3) {
            continue;
          }
          paramView = new NearbyPeopleProfileActivity.PicInfo();
          paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(1, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 0);
          if (QLog.isColorLevel()) {
            QLog.e("Q.nearby_people_card.", 2, "on mode guest small head clicked: uin is: " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin + " local path is: " + paramView.jdField_a_of_type_JavaLangString);
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(paramView);
          return;
        }
      }
      catch (SecurityException paramView)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel
 * JD-Core Version:    0.7.0.1
 */