import NearbyGroup.GroupInfo;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.adapter.WebFacePreloadBaseAdapter;
import com.tencent.mobileqq.data.NearbyRecommendTroop;
import com.tencent.mobileqq.troop.activity.NearbyRecommendView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.troop.data.NearbyTroops;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.List;

public class kcx
  extends WebFacePreloadBaseAdapter
{
  public long a;
  public Context a;
  
  public kcx(NearbyRecommendView paramNearbyRecommendView, Context paramContext, SlideDetectListView paramSlideDetectListView)
  {
    super(paramContext, paramSlideDetectListView, 4);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramNearbyRecommendView.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a());
      return;
    }
    catch (NumberFormatException paramNearbyRecommendView) {}
  }
  
  private void a(View paramView, NearbyRecommendTroop paramNearbyRecommendTroop)
  {
    GroupInfo localGroupInfo = new GroupInfo();
    localGroupInfo.lCode = Long.valueOf(paramNearbyRecommendTroop.uin).longValue();
    localGroupInfo.strName = paramNearbyRecommendTroop.name;
    localGroupInfo.strIntro = paramNearbyRecommendTroop.intro;
    localGroupInfo.iMemberCnt = paramNearbyRecommendTroop.memberNum;
    NearbyTroops.a(paramView, localGroupInfo, this.jdField_a_of_type_AndroidContentContext, true, this.jdField_a_of_type_Long);
    paramView = (NearbyTroops.CustomViewHolder)paramView.getTag();
    paramNearbyRecommendTroop = a(paramNearbyRecommendTroop.uin);
    paramView.a.setBackgroundDrawable(new BitmapDrawable(paramNearbyRecommendTroop));
  }
  
  public NearbyRecommendTroop a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount()) || (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyRecommendView.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyRecommendView.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return null;
    }
    return (NearbyRecommendTroop)this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyRecommendView.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyRecommendView.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyRecommendView.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = NearbyTroops.d(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
    }
    paramView = a(paramInt);
    if (paramView == null) {
      return localView;
    }
    localView.setOnClickListener(new kcy(this, paramView));
    if (paramView.isRead) {
      localView.setBackgroundResource(2130838123);
    }
    for (;;)
    {
      a(localView, paramView);
      return localView;
      localView.setBackgroundResource(2130838125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kcx
 * JD-Core Version:    0.7.0.1
 */