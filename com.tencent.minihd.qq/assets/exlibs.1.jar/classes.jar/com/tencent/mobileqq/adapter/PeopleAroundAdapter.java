package com.tencent.mobileqq.adapter;

import EncounterSvc.NeighborBanner;
import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RishState;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingBaseActivity;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.dating.NewVoteAnimHelper.NewVoteHolder;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.widget.CustomImgView;
import hfp;
import hfq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleAroundAdapter
  extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  private float jdField_a_of_type_Float;
  Context jdField_a_of_type_AndroidContentContext;
  BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public View.OnClickListener a;
  public View a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public NewVoteAnimHelper a;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  public FaceDecoder a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List a;
  public boolean a;
  private HashMap b = new HashMap();
  public boolean b;
  private boolean c = false;
  private int d;
  private int e = 0;
  
  public PeopleAroundAdapter(BaseActivity paramBaseActivity, FaceDecoder paramFaceDecoder, StatusManager paramStatusManager, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = paramStatusManager;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.d = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  }
  
  public static void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, TextView paramTextView)
  {
    paramImageView.setVisibility(8);
    paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131427967));
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if ((localVipOpenInfo == null) || (!localVipOpenInfo.bOpen)) {
        break label83;
      }
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130842003);
      paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131427999));
    }
    label83:
    do
    {
      return;
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
    } while ((paramVipBaseInfo == null) || (!paramVipBaseInfo.bOpen));
    paramImageView.setVisibility(0);
    paramImageView.setImageResource(2130842130);
    paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131427999));
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramInt, 200), false, false);
    if (this.e == 0) {
      this.e = ((int)(paramTextView.getTextSize() * 1.1F + 0.5F));
    }
    localStatableBitmapDrawable.setBounds(0, 0, this.e, this.e);
    paramTextView.setCompoundDrawables(localStatableBitmapDrawable, null, null, null);
  }
  
  private void a(PeopleAroundAdapter.ViewHolder paramViewHolder, RespEncounterInfo paramRespEncounterInfo)
  {
    TextView localTextView = paramViewHolder.jdField_b_of_type_AndroidWidgetTextView;
    RichStatus localRichStatus;
    if (paramRespEncounterInfo.richState != null)
    {
      localRichStatus = RichStatus.a(paramRespEncounterInfo.richState.vState);
      localRichStatus.a = paramRespEncounterInfo.richState.uModifyTime;
    }
    for (paramRespEncounterInfo = localRichStatus;; paramRespEncounterInfo = null)
    {
      if ((paramRespEncounterInfo != null) && (!paramRespEncounterInfo.a()))
      {
        if (!TextUtils.isEmpty(paramRespEncounterInfo.c)) {
          a(localTextView, paramRespEncounterInfo.jdField_b_of_type_Int);
        }
        for (;;)
        {
          paramViewHolder.jdField_b_of_type_Int = paramRespEncounterInfo.jdField_b_of_type_Int;
          localTextView.setText(paramRespEncounterInfo.a(null));
          localTextView.setVisibility(0);
          return;
          localTextView.setCompoundDrawables(null, null, null, null);
        }
      }
      paramViewHolder.jdField_b_of_type_Int = 0;
      localTextView.setVisibility(8);
      return;
    }
  }
  
  protected void a(int paramInt, PeopleAroundAdapter.ViewHolder paramViewHolder)
  {
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
    paramViewHolder.j.setVisibility(0);
    paramViewHolder.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(0);
    paramViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
    paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    NeighborBanner localNeighborBanner = (NeighborBanner)getItem(paramInt);
    paramViewHolder.j.setText(new String(localNeighborBanner.description));
    Object localObject = URLDrawable.getDrawable(new String(localNeighborBanner.pic_url));
    paramViewHolder.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable((Drawable)localObject);
    if ((localObject != null) && (((URLDrawable)localObject).getIntrinsicWidth() > 0) && (((URLDrawable)localObject).getIntrinsicHeight() > 0)) {}
    for (float f = ((URLDrawable)localObject).getIntrinsicHeight() / ((URLDrawable)localObject).getIntrinsicWidth();; f = 0.0F)
    {
      if (f > 0.0F)
      {
        localObject = (LinearLayout.LayoutParams)paramViewHolder.jdField_a_of_type_ComTencentWidgetCustomImgView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).height = ((int)(f * (this.d - 24.0F * this.jdField_a_of_type_Float)));
        paramViewHolder.jdField_a_of_type_ComTencentWidgetCustomImgView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      DatingBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80050D2");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(new String(localNeighborBanner.description));
      ((StringBuilder)localObject).append(" 连按两次查看详情");
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(((StringBuilder)localObject).toString());
      return;
    }
  }
  
  public void a(RespEncounterInfo paramRespEncounterInfo, ImageView paramImageView)
  {
    String str;
    Boolean localBoolean;
    try
    {
      if (paramRespEncounterInfo.tiny_id > 0L)
      {
        str = String.valueOf(paramRespEncounterInfo.tiny_id);
        if (this.c)
        {
          localBoolean = (Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramRespEncounterInfo.tiny_id));
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
          {
            this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramRespEncounterInfo.tiny_id), Boolean.valueOf(true));
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new hfp(this, str, paramRespEncounterInfo));
          }
        }
        paramRespEncounterInfo = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, str, 3001);
        if (paramRespEncounterInfo == null)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(str, 3001, true, false);
          }
          if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
          }
          paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          return;
        }
        paramImageView.setImageBitmap(paramRespEncounterInfo);
        return;
      }
    }
    catch (Throwable paramRespEncounterInfo)
    {
      paramRespEncounterInfo.printStackTrace();
      return;
    }
    if (paramRespEncounterInfo.lEctID > 0L)
    {
      str = String.valueOf(paramRespEncounterInfo.lEctID);
      if (this.c)
      {
        localBoolean = (Boolean)this.b.get(Long.valueOf(paramRespEncounterInfo.lEctID));
        if ((localBoolean == null) || (!localBoolean.booleanValue()))
        {
          this.b.put(Long.valueOf(paramRespEncounterInfo.lEctID), Boolean.valueOf(true));
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new hfq(this, str, paramRespEncounterInfo));
        }
      }
      paramRespEncounterInfo = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, str, 3000);
      if (paramRespEncounterInfo == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(str, 3000, true, false);
        if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
        }
        paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        return;
      }
      paramImageView.setImageBitmap(paramRespEncounterInfo);
    }
  }
  
  public void a(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_AndroidViewView = paramView;
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.c = paramBoolean;
  }
  
  protected void b(int paramInt, PeopleAroundAdapter.ViewHolder paramViewHolder)
  {
    int j = 1;
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
    paramViewHolder.j.setVisibility(8);
    paramViewHolder.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
    RespEncounterInfo localRespEncounterInfo;
    label108:
    Object localObject1;
    label140:
    label157:
    label234:
    Object localObject2;
    if (getItemViewType(paramInt + 1) == 2)
    {
      paramViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      localRespEncounterInfo = (RespEncounterInfo)getItem(paramInt);
      if (localRespEncounterInfo.tiny_id <= 0L) {
        break label603;
      }
      paramViewHolder.jdField_a_of_type_JavaLangString = String.valueOf(localRespEncounterInfo.tiny_id);
      paramViewHolder.jdField_a_of_type_Int = 32;
      if (TextUtils.isEmpty(localRespEncounterInfo.strNick)) {
        break label628;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localRespEncounterInfo.strNick.trim());
      if (localRespEncounterInfo.authFlag != 1) {
        break label641;
      }
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (getItemViewType(paramInt) != 0) {
        break label653;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper = new NewVoteAnimHelper(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      }
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838561, 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a(localRespEncounterInfo.iVoteNum, localRespEncounterInfo.iVoteIncrement, paramViewHolder.jdField_a_of_type_AndroidViewView, paramViewHolder.jdField_d_of_type_AndroidWidgetTextView, paramViewHolder.jdField_c_of_type_AndroidWidgetTextView);
      paramInt = this.d - (int)(189.0F * this.jdField_a_of_type_Float);
      localObject1 = (VipOpenInfo)localRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      localObject2 = (VipOpenInfo)localRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
      if ((localObject1 == null) || (!((VipOpenInfo)localObject1).bOpen)) {
        break label746;
      }
      paramInt -= (int)(this.jdField_a_of_type_Float * 5.0F) + 57;
    }
    label321:
    label465:
    label603:
    label1123:
    for (;;)
    {
      int i = paramInt;
      if (localRespEncounterInfo.authFlag == 1) {
        i = paramInt - (int)(20.0F * this.jdField_a_of_type_Float);
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(i);
      label492:
      if (localRespEncounterInfo.cAge != 0)
      {
        paramViewHolder.e.setText(String.valueOf(localRespEncounterInfo.cAge));
        paramInt = 1;
        label377:
        switch (localRespEncounterInfo.cSex)
        {
        default: 
          paramViewHolder.e.setBackgroundResource(2130840433);
          int k = 0;
          i = paramInt;
          paramInt = k;
          paramViewHolder.e.setCompoundDrawablesWithIntrinsicBounds(paramInt, 0, 0, 0);
          if (i != 0)
          {
            paramViewHolder.e.setVisibility(0);
            paramInt = j;
            if (localRespEncounterInfo.constellation != 0) {
              break label1000;
            }
            paramViewHolder.f.setVisibility(8);
            if ((localRespEncounterInfo.profession_id > 0) && (localRespEncounterInfo.profession_id < 14)) {
              break label1040;
            }
            paramViewHolder.g.setVisibility(8);
            if (localRespEncounterInfo.nFaceNum < 6) {
              break label1087;
            }
            paramInt += 1;
            paramViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
            if (localRespEncounterInfo.marriage != 2) {
              break label1099;
            }
            paramInt += 1;
            paramViewHolder.h.setVisibility(0);
            if (paramInt <= 0) {
              break label1111;
            }
            paramViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          }
          break;
        }
      }
      for (;;)
      {
        a(localRespEncounterInfo.vipBaseInfo, paramViewHolder.jdField_c_of_type_AndroidWidgetImageView, paramViewHolder.jdField_a_of_type_AndroidWidgetTextView);
        a(paramViewHolder, localRespEncounterInfo);
        a(localRespEncounterInfo, paramViewHolder.jdField_a_of_type_AndroidWidgetImageView);
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription("");
        return;
        paramViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
        break;
        if (localRespEncounterInfo.lEctID <= 0L) {
          break label108;
        }
        paramViewHolder.jdField_a_of_type_JavaLangString = String.valueOf(localRespEncounterInfo.lEctID);
        break label108;
        label628:
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
        break label140;
        paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label157;
        if ((this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a.a(paramViewHolder.jdField_a_of_type_AndroidViewView, paramViewHolder.jdField_d_of_type_AndroidWidgetTextView, paramViewHolder.jdField_c_of_type_AndroidWidgetTextView)))
        {
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.c();
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a.a();
        }
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(localRespEncounterInfo.strDescription);
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        break label234;
        label746:
        if ((localObject2 == null) || (!((VipOpenInfo)localObject2).bOpen)) {
          break label1123;
        }
        paramInt -= (int)(this.jdField_a_of_type_Float * 5.0F) + 47;
        break label321;
        paramViewHolder.e.setText("");
        paramInt = 0;
        break label377;
        paramViewHolder.e.setBackgroundResource(2130840433);
        localObject2 = paramViewHolder.e;
        StringBuilder localStringBuilder = new StringBuilder().append("男");
        if (localRespEncounterInfo.cAge > 0) {}
        for (localObject1 = localRespEncounterInfo.cAge + "岁";; localObject1 = "")
        {
          ((TextView)localObject2).setContentDescription((String)localObject1);
          paramInt = 2130838484;
          i = 1;
          break;
        }
        paramViewHolder.e.setBackgroundResource(2130840432);
        localObject2 = paramViewHolder.e;
        localStringBuilder = new StringBuilder().append("女");
        if (localRespEncounterInfo.cAge > 0) {}
        for (localObject1 = localRespEncounterInfo.cAge + "岁";; localObject1 = "")
        {
          ((TextView)localObject2).setContentDescription((String)localObject1);
          paramInt = 2130838479;
          i = 1;
          break;
        }
        paramViewHolder.e.setVisibility(8);
        paramInt = 0;
        break label448;
        label1000:
        paramInt += 1;
        paramViewHolder.f.setText(ProfileCardUtil.a(localRespEncounterInfo.constellation));
        paramViewHolder.f.setBackgroundResource(2130840447);
        paramViewHolder.f.setVisibility(0);
        break label465;
        paramInt += 1;
        paramViewHolder.g.setText(com.tencent.mobileqq.util.NearbyProfileUtil.e[localRespEncounterInfo.profession_id]);
        paramViewHolder.g.setBackgroundResource(com.tencent.mobileqq.util.NearbyProfileUtil.a[localRespEncounterInfo.profession_id]);
        paramViewHolder.g.setVisibility(0);
        break label492;
        paramViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        break label514;
        paramViewHolder.h.setVisibility(8);
        break label535;
        paramViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        i = j + 1;
      }
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    if (localObject == null) {
      return -1;
    }
    if ((localObject instanceof NeighborBanner)) {
      return 2;
    }
    if (String.valueOf(((RespEncounterInfo)localObject).lEctID).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() == 0) && (this.jdField_a_of_type_AndroidViewView != null)) {
      paramViewGroup = this.jdField_a_of_type_AndroidViewView;
    }
    PeopleAroundAdapter.ViewHolder localViewHolder2;
    int i;
    do
    {
      return paramViewGroup;
      if (paramView != null) {}
      for (PeopleAroundAdapter.ViewHolder localViewHolder1 = (PeopleAroundAdapter.ViewHolder)paramView.getTag();; localViewHolder1 = null)
      {
        localViewHolder2 = localViewHolder1;
        if (localViewHolder1 == null)
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903384, paramViewGroup, false);
          localViewHolder2 = new PeopleAroundAdapter.ViewHolder();
          paramView.setTag(localViewHolder2);
          localViewHolder2.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(16908294));
          localViewHolder2.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131298040));
          localViewHolder2.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131298044));
          localViewHolder2.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297264));
          localViewHolder2.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298045));
          localViewHolder2.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298046));
          localViewHolder2.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131298047));
          localViewHolder2.e = ((TextView)paramView.findViewById(2131298048));
          localViewHolder2.f = ((TextView)paramView.findViewById(2131297922));
          localViewHolder2.g = ((TextView)paramView.findViewById(2131298049));
          localViewHolder2.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298050));
          localViewHolder2.h = ((TextView)paramView.findViewById(2131296275));
          localViewHolder2.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297920));
          localViewHolder2.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297923));
          localViewHolder2.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131298051);
          localViewHolder2.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298052));
          localViewHolder2.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131298041);
          localViewHolder2.j = ((TextView)paramView.findViewById(2131298042));
          localViewHolder2.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)paramView.findViewById(2131298043));
          localViewHolder2.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131298053);
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        localViewHolder2.jdField_a_of_type_JavaLangObject = getItem(paramInt);
        i = getItemViewType(paramInt);
        if (i != 2) {
          break;
        }
        a(paramInt, localViewHolder2);
        return paramView;
      }
      if (i == 0) {
        break;
      }
      paramViewGroup = paramView;
    } while (i != 1);
    b(paramInt, localViewHolder2);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.PeopleAroundAdapter
 * JD-Core Version:    0.7.0.1
 */