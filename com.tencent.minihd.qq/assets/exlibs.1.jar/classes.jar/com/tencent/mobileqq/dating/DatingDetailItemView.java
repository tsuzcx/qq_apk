package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView.ViewProfileCardSpan;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;

public class DatingDetailItemView
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private DatingInfo jdField_a_of_type_ComTencentMobileqqDataDatingInfo;
  private DatingComment jdField_a_of_type_ComTencentMobileqqDatingDatingComment;
  private DatingDetailItemView.IDatingDetailItemViewCallback jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback;
  private DatingStranger jdField_a_of_type_ComTencentMobileqqDatingDatingStranger;
  private DatingCommentTextView jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  
  public DatingDetailItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public DatingDetailItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setVisibility(0);
      this.f.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427972));
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setVisibility(8);
      this.f.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427934));
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        return;
      }
    } while (this.jdField_a_of_type_Int != 0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903901, this);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)paramContext.findViewById(2131296751));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131296582));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131299792));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131298048));
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView = ((DatingCommentTextView)paramContext.findViewById(2131300013));
    this.c = ((TextView)paramContext.findViewById(2131299892));
    this.d = ((TextView)paramContext.findViewById(2131299893));
    this.e = ((TextView)paramContext.findViewById(2131299894));
    this.f = ((TextView)paramContext.findViewById(2131300010));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131299972));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131300012));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131300014);
    this.jdField_b_of_type_AndroidViewView = paramContext.findViewById(2131300015);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131299971));
    int i = getResources().getColor(2131427880);
    paramContext.findViewById(2131296480).setBackgroundColor(i);
    paramContext = getResources().getDrawable(2130840233);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setBackground(paramContext);
  }
  
  private void b(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null) {
      if (QLog.isColorLevel()) {
        QLog.i("datingDetail", 2, "datingDetailItemView bindData obj is null");
      }
    }
    int i;
    label345:
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Int != 1) {
            break label640;
          }
          if ((paramObject instanceof DatingComment)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("datingDetail", 2, "datingDetailItemView bindData obj is not instance of datingCommentInfo");
        return;
        localObject1 = (DatingComment)paramObject;
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment = ((DatingComment)localObject1);
        paramObject = ((DatingComment)localObject1).jdField_a_of_type_ComTencentMobileqqDatingDatingStranger;
        if (paramObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("datingDetail", 2, "datingDetailItemView bindData commentInfo.stranger is null");
      return;
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger = paramObject;
      Object localObject2 = DatingUtil.a(String.valueOf(paramObject.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, 3001);
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable((Drawable)localObject2);
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
      localObject2 = paramObject.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(" ");
        localObject2 = ((DatingComment)localObject1).e;
        if (!this.f.getText().equals(localObject2)) {
          this.f.setText((CharSequence)localObject2);
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        localObject2 = ((DatingComment)localObject1).jdField_c_of_type_JavaLangString;
        localObject1 = ((DatingComment)localObject1).b;
        localStringBuilder = new StringBuilder();
        if ((localObject1 == null) || (TextUtils.isEmpty(((DatingStranger)localObject1).jdField_a_of_type_JavaLangString))) {
          break label552;
        }
        localStringBuilder.append(String.format("回复 %s : ", new Object[] { ((DatingStranger)localObject1).jdField_a_of_type_JavaLangString }));
        localStringBuilder.append((String)localObject2);
        localObject2 = new QQText(localStringBuilder, 3, 16);
        i = ((DatingStranger)localObject1).jdField_a_of_type_JavaLangString.length();
        ((QQText)localObject2).setSpan(new DatingCommentTextView.ViewProfileCardSpan(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ((DatingStranger)localObject1).jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId), 3, i + 3, 33);
        this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setMovementMethod(LinkMovementMethod.getInstance());
        this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setText((CharSequence)localObject2);
        if (QLog.isDevelopLevel()) {
          QLog.d("datingDetail", 4, "datingDetailItemView commentView line count is: " + this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.getLineCount());
        }
        paramObject = paramObject.jdField_c_of_type_JavaLangString;
        if (!"svip".equalsIgnoreCase(paramObject)) {
          break label597;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842003);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        paramObject = new StringBuilder();
        paramObject.append("姓名,").append(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
        paramObject.append(",").append(this.f.getText().toString());
        paramObject.append(",").append(this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.getText().toString());
        paramObject.append(",连按两次展开评论，举报，删除功能");
        setContentDescription(paramObject.toString());
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("评论");
        setOnClickListener(this);
        return;
        if (this.jdField_a_of_type_AndroidWidgetTextView.getText().equals(localObject2)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        break;
        localStringBuilder.append((String)localObject2);
        localObject1 = new QQText(localStringBuilder.toString(), 3, 16);
        this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setMovementMethod(null);
        this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setText((CharSequence)localObject1);
        break label345;
        if ("vip".equalsIgnoreCase(paramObject))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842130);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      if ((paramObject instanceof DatingStranger)) {
        break;
      }
    } while (!QLog.isColorLevel());
    label552:
    label597:
    QLog.i("datingDetail", 2, "datingDetailItemView bindData obj is not instanceof datingStranger");
    label640:
    return;
    Object localObject1 = (DatingStranger)paramObject;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger = ((DatingStranger)localObject1);
    paramObject = DatingUtil.a(String.valueOf(((DatingStranger)localObject1).jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, 3001);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(paramObject);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
    paramObject = ((DatingStranger)localObject1).jdField_a_of_type_JavaLangString;
    if (!this.jdField_a_of_type_AndroidWidgetTextView.getText().equals(paramObject)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramObject);
    }
    if (((DatingStranger)localObject1).jdField_a_of_type_Int <= 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramObject = ((DatingStranger)localObject1).jdField_b_of_type_JavaLangString;
      if (!TextUtils.isEmpty(paramObject)) {
        break label1213;
      }
      this.e.setVisibility(8);
      label784:
      i = ((DatingStranger)localObject1).e - 1;
      if ((i <= 0) || (i >= NearbyProfileUtil.b.length)) {
        break label1246;
      }
      paramObject = NearbyProfileUtil.b[i];
      label810:
      if (!TextUtils.isEmpty(paramObject)) {
        break label1251;
      }
      this.c.setVisibility(8);
      label826:
      i = ((DatingStranger)localObject1).d;
      if ((i < 0) || (i >= NearbyProfileUtil.e.length)) {
        break label1284;
      }
      paramObject = NearbyProfileUtil.e[i];
      label850:
      if (!TextUtils.isEmpty(paramObject)) {
        break label1289;
      }
      this.d.setVisibility(8);
    }
    label900:
    label933:
    label1452:
    label1455:
    for (;;)
    {
      paramObject = ((DatingStranger)localObject1).jdField_c_of_type_JavaLangString;
      if ("svip".equalsIgnoreCase(paramObject))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842003);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_a_of_type_Int == 2)
        {
          i = ((DatingStranger)localObject1).jdField_c_of_type_Int;
          if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingStatus != 0) {
            break label1440;
          }
          if (i != 1) {
            break label1403;
          }
          paramObject = "已约";
          if (!paramObject.equals(this.jdField_a_of_type_AndroidWidgetButton.getText())) {
            this.jdField_a_of_type_AndroidWidgetButton.setText(paramObject);
          }
          paramObject = this.jdField_a_of_type_AndroidWidgetButton;
          if (i == 0) {
            bool = true;
          }
          paramObject.setEnabled(bool);
          this.jdField_a_of_type_AndroidWidgetButton.setTag(localObject1);
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        }
        label990:
        paramObject = new StringBuilder();
        paramObject.append("姓名,").append(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
        paramObject.append(",").append(this.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
        paramObject.append(",").append(this.c.getText().toString());
        paramObject.append(",").append(this.e.getText().toString());
        paramObject.append(",").append(this.d.getText().toString());
        setContentDescription(paramObject.toString());
        break;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramObject = String.valueOf(((DatingStranger)localObject1).jdField_a_of_type_Int);
        if (!paramObject.equals(this.jdField_b_of_type_AndroidWidgetTextView.getText())) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramObject);
        }
        if (((DatingStranger)localObject1).jdField_b_of_type_Int == 1) {
          i = 2130838479;
        }
        for (int j = 2130840432;; j = 2130840433)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(j);
          break;
          i = 2130838484;
        }
        label1213:
        this.e.setVisibility(0);
        if (this.e.getText().equals(paramObject)) {
          break label784;
        }
        this.e.setText(paramObject);
        break label784;
        label1246:
        paramObject = null;
        break label810;
        label1251:
        this.c.setVisibility(0);
        if (this.c.getText().equals(paramObject)) {
          break label826;
        }
        this.c.setText(paramObject);
        break label826;
        paramObject = null;
        break label850;
        this.d.setVisibility(0);
        if (this.d.getText().equals(paramObject)) {
          continue;
        }
        this.d.setText(paramObject);
        if ((i < 0) || (i >= NearbyProfileUtil.a.length)) {
          break label1452;
        }
        j = NearbyProfileUtil.a[i];
        i = j;
        if (j >= 0) {}
      }
      for (i = 0;; i = 0)
      {
        if (i <= 0) {
          break label1455;
        }
        this.d.setBackgroundResource(i);
        break;
        if ("vip".equalsIgnoreCase(paramObject))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842130);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          break label900;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label900;
        label1403:
        if (((DatingStranger)localObject1).jdField_b_of_type_Int == 1)
        {
          paramObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131369770);
          break label933;
        }
        paramObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131369769);
        break label933;
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        break label990;
      }
    }
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger == null) {
      return -1L;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger.jdField_a_of_type_Long;
  }
  
  public void a(long paramLong, Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (paramLong != this.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger.jdField_a_of_type_Long)) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(paramDrawable);
  }
  
  public void a(DatingInfo paramDatingInfo, BaseActivity paramBaseActivity, FaceDecoder paramFaceDecoder, int paramInt1, DatingDetailItemView.IDatingDetailItemViewCallback paramIDatingDetailItemViewCallback, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback = paramIDatingDetailItemViewCallback;
    this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo = paramDatingInfo;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
  }
  
  public void a(Object paramObject)
  {
    a();
    b(paramObject);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramView != this) {
              break;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback == null);
          this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment);
          return;
          if (paramView != this.jdField_a_of_type_AndroidWidgetButton) {
            break;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback == null);
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger);
        return;
        if (paramView != this.jdField_b_of_type_AndroidWidgetImageView) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback == null);
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment);
      return;
    } while ((paramView != this.jdField_a_of_type_ComTencentWidgetCustomImgView) || (this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback == null));
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingDetailItemView
 * JD-Core Version:    0.7.0.1
 */