import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.tencent.mobileqq.activity.EditTagActivity;
import com.tencent.mobileqq.widget.Workspace;
import java.util.ArrayList;

class dxh
  implements View.OnClickListener
{
  dxh(dxg paramdxg) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof dxi))
    {
      paramView = (dxi)paramView;
      if ((paramView.a >= 0) && (paramView.a < this.a.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramView.a);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a(this.a.jdField_a_of_type_JavaUtilArrayList.size());
        this.a.notifyDataSetChanged();
        int i = 0;
        while (i < this.a.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a.getChildCount())
        {
          ((BaseAdapter)((GridView)this.a.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a.getChildAt(i)).getAdapter()).notifyDataSetChanged();
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dxh
 * JD-Core Version:    0.7.0.1
 */