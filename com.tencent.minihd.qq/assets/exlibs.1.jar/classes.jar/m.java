import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.activities.DLRouterActivity;

public class m
  extends BaseAdapter
{
  private n jdField_a_of_type_N;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131362067, 2130838012 };
  private final int[][] jdField_a_of_type_Array2dOfInt = { this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.c, this.d, this.e };
  private final int[] jdField_b_of_type_ArrayOfInt = { 2131362069, 2130838016 };
  private final int[][] jdField_b_of_type_Array2dOfInt = this.jdField_a_of_type_Array2dOfInt;
  private final int[] c = { 2131362220, 2130838011 };
  private final int[] d = { 2131362221, 2130838003 };
  private final int[] e = { 2131362222, 2130838004 };
  
  private m(DLRouterActivity paramDLRouterActivity) {}
  
  public int[][] a()
  {
    return this.jdField_b_of_type_Array2dOfInt;
  }
  
  public int getCount()
  {
    return this.jdField_b_of_type_Array2dOfInt.length;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.getLayoutInflater().inflate(2130903238, null);
    }
    this.jdField_a_of_type_N = ((n)paramViewGroup.getTag());
    if (this.jdField_a_of_type_N == null)
    {
      this.jdField_a_of_type_N = new n(this, null);
      this.jdField_a_of_type_N.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297135));
      this.jdField_a_of_type_N.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297136));
    }
    this.jdField_a_of_type_N.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_Array2dOfInt[paramInt][0]);
    paramView = this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.getResources().getDrawable(this.jdField_b_of_type_Array2dOfInt[paramInt][1]);
    this.jdField_a_of_type_N.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
    paramViewGroup.setTag(this.jdField_a_of_type_N);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     m
 * JD-Core Version:    0.7.0.1
 */