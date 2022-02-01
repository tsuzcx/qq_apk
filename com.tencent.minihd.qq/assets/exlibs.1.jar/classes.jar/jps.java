import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class jps
  extends BaseAdapter
{
  public List a;
  
  public jps(QCallDetailActivity paramQCallDetailActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  private int a(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord.isSender()) {
      return 2130840129;
    }
    return 2130840124;
  }
  
  private String a(QCallRecord paramQCallRecord)
  {
    String str = "";
    if (paramQCallRecord.uinType == 3000) {
      switch (paramQCallRecord.state)
      {
      default: 
        str = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131369253);
      }
    }
    do
    {
      return str;
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131369253);
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131369250);
      paramQCallRecord = paramQCallRecord.getTalkTimeMinute();
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131369251, new Object[] { paramQCallRecord });
      paramQCallRecord = paramQCallRecord.getTalkTimeMinute();
      str = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131369252);
    } while (TextUtils.isEmpty(paramQCallRecord));
    return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131369251, new Object[] { paramQCallRecord });
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    }
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
  
  public int getItemViewType(int paramInt)
  {
    if (((QCallRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt)).type == QCallRecord.TYPE_DATE) {
      return QCallRecord.TYPE_DATE;
    }
    return QCallRecord.TYPE_REALRECORD;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = getItemViewType(paramInt);
    paramViewGroup = paramView;
    QCallRecord localQCallRecord;
    int i;
    if (paramView == null)
    {
      paramViewGroup = new jpt();
      if (j == QCallRecord.TYPE_DATE)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).inflate(2130903839, null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299792));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298571));
        paramView.setTag(paramViewGroup);
        paramViewGroup = paramView;
      }
    }
    else
    {
      paramView = (jpt)paramViewGroup.getTag();
      localQCallRecord = (QCallRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (j != QCallRecord.TYPE_DATE) {
        break label270;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localQCallRecord.getDateString());
      i = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getResources().getColor(2131427889);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(i);
      label142:
      if (paramInt != getCount() - 1) {
        break label359;
      }
      i = 2130837955;
      label156:
      paramViewGroup.setBackgroundResource(i);
      i = AIOUtils.a(8.0F, paramViewGroup.getResources());
      if (j != QCallRecord.TYPE_DATE) {
        break label374;
      }
      if (paramInt != 0) {
        break label366;
      }
    }
    label270:
    label359:
    label366:
    for (paramInt = i * 4;; paramInt = i * 3)
    {
      paramViewGroup.setPadding(0, paramInt, 0, i);
      return paramViewGroup;
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).inflate(2130903845, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299202));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297441));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131299814));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131299815));
      break;
      String str = TimeManager.a().a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app.a(), localQCallRecord.time);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(a(localQCallRecord));
      paramView.c.setText(a(localQCallRecord));
      if (localQCallRecord.isVideo())
      {
        paramView.b.setVisibility(0);
        break label142;
      }
      paramView.b.setVisibility(8);
      break label142;
      i = 2130837952;
      break label156;
    }
    label374:
    if (paramInt == getCount() - 1) {}
    for (paramInt = i * 4;; paramInt = i)
    {
      paramViewGroup.setPadding(0, i, 0, paramInt);
      return paramViewGroup;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jps
 * JD-Core Version:    0.7.0.1
 */