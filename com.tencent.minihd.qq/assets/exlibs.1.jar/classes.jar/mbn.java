import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cooperation.qzone.UploadServerSetting.ConfigItem;
import java.util.ArrayList;

public final class mbn
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public mbn(Context paramContext, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904339, paramViewGroup, false);
    }
    paramView = (UploadServerSetting.ConfigItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramViewGroup = (TextView)localView.findViewById(2131301827);
    TextView localTextView = (TextView)localView.findViewById(2131301828);
    if (paramView.jdField_a_of_type_Boolean) {
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.setText(paramView.jdField_a_of_type_JavaLangString);
      return localView;
      localTextView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mbn
 * JD-Core Version:    0.7.0.1
 */