import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.ItemViewHolder;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.MoreViewHolder;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class jtb
  extends BaseAdapter
{
  private jtb(StatusHistoryActivity paramStatusHistoryActivity) {}
  
  public int getCount()
  {
    int i = 1;
    int j = StatusHistoryActivity.a(this.a).size();
    if (j == 0) {
      return 1;
    }
    if (StatusHistoryActivity.a(this.a) != 0) {}
    for (;;)
    {
      return i + j;
      i = 0;
    }
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= StatusHistoryActivity.a(this.a).size()) {
      return null;
    }
    return StatusHistoryActivity.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return getItemViewType(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = StatusHistoryActivity.a(this.a).size();
    if (i == 0) {
      return 2;
    }
    if (paramInt < i) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i == 2)
    {
      StatusHistoryActivity.b(this.a).setLayoutParams(new AbsListView.LayoutParams(StatusHistoryActivity.a(this.a).getWidth(), StatusHistoryActivity.a(this.a).getHeight()));
      return StatusHistoryActivity.b(this.a);
    }
    if (i == 0)
    {
      View localView;
      if (paramView == null)
      {
        paramViewGroup = new StatusHistoryActivity.ItemViewHolder();
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(this.a).inflate(2130904443, null);
          localView.setFocusable(true);
          paramViewGroup.jdField_a_of_type_Jtc = new jtc(this.a, this.a);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131302208));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView = ((ClickableColorSpanTextView)localView.findViewById(2131302214));
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297108));
          paramViewGroup.jdField_b_of_type_AndroidViewView = localView.findViewById(2131302207);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView.setTag(paramViewGroup);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView.setSpanClickListener(this.a);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)localView.findViewById(2131296569));
          paramViewGroup.jdField_a_of_type_AndroidViewView = paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.findViewById(2131297628);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)localView.findViewById(2131302218));
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131302212));
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131302217));
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131302213));
          paramViewGroup.jdField_c_of_type_AndroidViewView = localView.findViewById(2131302215);
          localView.setTag(paramViewGroup);
          localView.setClickable(true);
        }
        paramViewGroup.jdField_b_of_type_Int = paramInt;
        paramView = (RichStatus)StatusHistoryActivity.a(this.a).get(paramInt);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramView;
        if (paramInt != StatusHistoryActivity.a(this.a).size() - 1) {
          break label806;
        }
        paramViewGroup.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130841987);
        label350:
        if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.f != null)
        {
          paramViewGroup.jdField_a_of_type_JavaUtilList = new ArrayList();
          if ((paramView.jdField_a_of_type_JavaUtilList != null) && (paramView.jdField_a_of_type_JavaUtilList.size() > 0)) {
            paramViewGroup.jdField_a_of_type_JavaUtilList.addAll(paramView.jdField_a_of_type_JavaUtilList);
          }
          StatusHistoryActivity.a(this.a, paramViewGroup);
          paramViewGroup.jdField_a_of_type_Int = 0;
          if (paramViewGroup.jdField_a_of_type_JavaUtilList.size() > 0)
          {
            localObject = paramViewGroup.jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext()) {
              if (((String)((Iterator)localObject).next()).equals(this.a.app.a())) {
                paramViewGroup.jdField_a_of_type_Int = 1;
              }
            }
          }
          paramInt = 7;
          if (1 == paramViewGroup.jdField_a_of_type_Int) {
            paramInt = 8;
          }
          Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.d, paramInt);
          if (localObject != null) {
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setTag(paramViewGroup);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.a.b);
          paramViewGroup.jdField_a_of_type_Jtc.a(paramViewGroup.jdField_b_of_type_JavaUtilList);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(paramViewGroup.jdField_a_of_type_Jtc);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setTag(paramViewGroup);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setOnItemClickListener(this.a.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, TimeFormatterUtils.a(this.a, 3, paramView.jdField_a_of_type_Long * 1000L) + "    "));
        StatusHistoryActivity.b(this.a, paramViewGroup);
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.a(Integer.toString(paramView.d));
        if (TextUtils.isEmpty(paramView.c)) {
          break label819;
        }
        paramViewGroup.jdField_c_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_JavaLangString = paramView.c;
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setEnabled(true);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewGroup);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        paramInt = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width;
        i = localView.getPaddingLeft();
        paramInt = Utils.a(this.a, 6.0F) + (paramInt + i);
        if (localView.getLayoutParams() != null) {
          break label839;
        }
        localView.setLayoutParams(new AbsListView.LayoutParams(paramInt, -2));
        return localView;
        paramViewGroup = (StatusHistoryActivity.ItemViewHolder)paramView.getTag();
        break;
        label806:
        paramViewGroup.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130841988);
        break label350;
        label819:
        paramViewGroup.jdField_c_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
      }
      label839:
      paramView = (AbsListView.LayoutParams)localView.getLayoutParams();
      paramView.width = paramInt;
      paramView.height = -2;
      return localView;
    }
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.a.getLayoutInflater().inflate(2130903377, null);
      paramViewGroup.setOnClickListener(this.a);
      paramView = new StatusHistoryActivity.MoreViewHolder();
      paramViewGroup.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131296735));
      paramViewGroup.findViewById(2131297996).setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297997));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131427405));
    }
    if (StatusHistoryActivity.a(this.a) == 1)
    {
      StatusHistoryActivity.a(this.a, 2);
      this.a.a(false, false);
    }
    paramView = (StatusHistoryActivity.MoreViewHolder)paramViewGroup.getTag();
    if (StatusHistoryActivity.a(this.a) == 3)
    {
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText("暂无更多，请重试。");
      return paramViewGroup;
    }
    paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText("加载更多中...");
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return 2 != getItemViewType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jtb
 * JD-Core Version:    0.7.0.1
 */