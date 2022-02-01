import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.PublicView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class ggd
  extends FacePreloadBaseAdapter
{
  public ggd(PublicView paramPublicView, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    paramXListView.setAdapter(this);
  }
  
  public PublicRecommendAccountInfo a(int paramInt)
  {
    if ((PublicView.a(this.a) != null) && (paramInt >= 0) && (paramInt < PublicView.a(this.a).size())) {
      return (PublicRecommendAccountInfo)PublicView.a(this.a).get(paramInt);
    }
    return null;
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    PublicRecommendAccountInfo localPublicRecommendAccountInfo = a(paramInt);
    if (localPublicRecommendAccountInfo.mSource == 1) {
      localFaceInfo.a = localPublicRecommendAccountInfo.mEqqNameAccount;
    }
    while (localPublicRecommendAccountInfo.mSource != 20) {
      return localFaceInfo;
    }
    localFaceInfo.a = String.valueOf(localPublicRecommendAccountInfo.mPublicuin);
    return localFaceInfo;
  }
  
  public int getCount()
  {
    if ((PublicView.a(this.a) != null) && (PublicView.a(this.a).size() > 0)) {
      return PublicView.a(this.a).size();
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.a).inflate(2130903812, paramViewGroup, false);
      paramViewGroup = new ggf();
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296657));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296660));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131299719));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299720));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296664));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.a);
      localObject = a(paramInt);
      if (((PublicRecommendAccountInfo)localObject).mSource != 1) {
        break label383;
      }
      paramViewGroup.jdField_b_of_type_JavaLangString = ((PublicRecommendAccountInfo)localObject).mEqqNameAccount;
      label133:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataPublicRecommendAccountInfo = ((PublicRecommendAccountInfo)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramViewGroup.c.setCompoundDrawablePadding(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(a(1, paramViewGroup.jdField_b_of_type_JavaLangString));
      if ((!((PublicRecommendAccountInfo)localObject).mIsVerified.equalsIgnoreCase("1")) || (((PublicRecommendAccountInfo)localObject).mSource != 20)) {
        break label408;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838652, 0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding((int)DisplayUtils.a(this.a.a, 6.0F));
      label253:
      if (((PublicRecommendAccountInfo)localObject).mSource != 1) {
        break label422;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PublicRecommendAccountInfo)localObject).mEqqCs);
      paramViewGroup.c.setText(((PublicRecommendAccountInfo)localObject).mEqqCategory);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((PublicRecommendAccountInfo)localObject).mEqqSi);
    }
    for (;;)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
      ((StringBuilder)localObject).append(paramViewGroup.c.getText().toString());
      ((StringBuilder)localObject).append(paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
      paramView.setContentDescription(((StringBuilder)localObject).toString());
      return paramView;
      paramViewGroup = (ggf)paramView.getTag();
      break;
      label383:
      if (((PublicRecommendAccountInfo)localObject).mSource != 20) {
        break label133;
      }
      paramViewGroup.jdField_b_of_type_JavaLangString = String.valueOf(((PublicRecommendAccountInfo)localObject).mPublicuin);
      break label133;
      label408:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label253;
      label422:
      if (((PublicRecommendAccountInfo)localObject).mSource == 20)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PublicRecommendAccountInfo)localObject).mPublicname);
        paramViewGroup.c.setText(2131363626);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((PublicRecommendAccountInfo)localObject).mPublicdesc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ggd
 * JD-Core Version:    0.7.0.1
 */