import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import java.util.ArrayList;
import java.util.List;

public class jtc
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public jtc(StatusHistoryActivity paramStatusHistoryActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity).inflate(2130904135, null);
    }
    paramView = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131300975);
    if (paramView.equals(StatusHistoryActivity.a))
    {
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840903));
      return paramViewGroup;
    }
    localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity.app.b(paramView));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jtc
 * JD-Core Version:    0.7.0.1
 */