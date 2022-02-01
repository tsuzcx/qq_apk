import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cannon.Visitor;
import com.tencent.mobileqq.activity.MayKnowManActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class eke
  implements Runnable
{
  eke(ekd paramekd, boolean paramBoolean, List paramList, int paramInt) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Visitor)((Iterator)localObject1).next();
        if (this.jdField_a_of_type_Ekd.a.jdField_a_of_type_JavaUtilList.size() > 30000) {
          this.jdField_a_of_type_Ekd.a.jdField_a_of_type_JavaUtilList.remove(0);
        }
        this.jdField_a_of_type_Ekd.a.jdField_a_of_type_JavaUtilList.add(localObject2);
      }
      if (this.jdField_a_of_type_Ekd.a.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        this.jdField_a_of_type_Ekd.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_a_of_type_Ekd.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_Ekd.a.setTitle(2131366593);
        localObject1 = (List)((ArrayList)this.jdField_a_of_type_Ekd.a.jdField_a_of_type_JavaUtilList).clone();
        this.jdField_a_of_type_Ekd.a.app.a(new ekf(this, (List)localObject1));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ekd.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131366569);
      this.jdField_a_of_type_Ekd.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_Ekd.a.b();
      localObject1 = (ProgressBar)this.jdField_a_of_type_Ekd.a.jdField_a_of_type_AndroidViewView.findViewById(2131296735);
      localObject2 = (ImageView)this.jdField_a_of_type_Ekd.a.jdField_a_of_type_AndroidViewView.findViewById(2131297996);
      ((ProgressBar)localObject1).setVisibility(8);
      ((ImageView)localObject2).setVisibility(0);
      return;
      this.jdField_a_of_type_Ekd.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_Ekd.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Ekd.a.setTitle(this.jdField_a_of_type_Ekd.a.getString(2131366593) + "(" + this.jdField_a_of_type_Int + ")");
      if (this.jdField_a_of_type_Ekd.a.jdField_a_of_type_Ekj == null)
      {
        this.jdField_a_of_type_Ekd.a.jdField_a_of_type_Ekj = new ekj(this.jdField_a_of_type_Ekd.a, this.jdField_a_of_type_Ekd.a, this.jdField_a_of_type_Ekd.a.app, this.jdField_a_of_type_Ekd.a.jdField_a_of_type_ComTencentWidgetXListView);
        this.jdField_a_of_type_Ekd.a.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ekd.a.jdField_a_of_type_Ekj);
      }
      while (this.jdField_a_of_type_Ekd.a.c * 10 >= this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Ekd.a.jdField_a_of_type_AndroidViewView.findViewById(2131296735).setVisibility(8);
        this.jdField_a_of_type_Ekd.a.jdField_a_of_type_AndroidViewView.findViewById(2131297996).setVisibility(8);
        localObject1 = (TextView)this.jdField_a_of_type_Ekd.a.jdField_a_of_type_AndroidViewView.findViewById(2131297997);
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(2131368006);
        this.jdField_a_of_type_Ekd.a.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Ekd.a.b();
        return;
        this.jdField_a_of_type_Ekd.a.jdField_a_of_type_Ekj.notifyDataSetChanged();
      }
      this.jdField_a_of_type_Ekd.a.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_Ekd.a.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Ekd.a.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_Ekd.a.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Ekd.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      break;
      if (this.jdField_a_of_type_Ekd.a.jdField_a_of_type_AndroidAppDialog != null)
      {
        this.jdField_a_of_type_Ekd.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_a_of_type_Ekd.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_Ekd.a.b.setText(2131368005);
        this.jdField_a_of_type_Ekd.a.b();
        return;
      }
      QQToast.a(this.jdField_a_of_type_Ekd.a, this.jdField_a_of_type_Ekd.a.getString(2131368002), 0).b(this.jdField_a_of_type_Ekd.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eke
 * JD-Core Version:    0.7.0.1
 */