import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.utils.NetworkUtil;

public class bo
  extends BaseAdapter
{
  private bp jdField_a_of_type_Bp;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131362067, 2130838012 };
  private final int[][] jdField_a_of_type_Array2dOfInt = { this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.d };
  private final int[] jdField_b_of_type_ArrayOfInt = { 2131366475, 2130838002 };
  private final int[][] jdField_b_of_type_Array2dOfInt = { this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.d, this.e };
  private final int[] jdField_c_of_type_ArrayOfInt = { 2131362068, 2130838019 };
  private int[][] jdField_c_of_type_Array2dOfInt = this.jdField_a_of_type_Array2dOfInt;
  private final int[] d = { 2131362069, 2130838016 };
  private final int[] e = { 2131362071, 2130838005 };
  
  private bo(LiteActivity paramLiteActivity) {}
  
  public int[][] a()
  {
    return this.jdField_c_of_type_Array2dOfInt;
  }
  
  public int getCount()
  {
    return this.jdField_c_of_type_Array2dOfInt.length;
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
      paramViewGroup = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getLayoutInflater().inflate(2130903238, null);
    }
    this.jdField_a_of_type_Bp = ((bp)paramViewGroup.getTag());
    if (this.jdField_a_of_type_Bp == null)
    {
      this.jdField_a_of_type_Bp = new bp(this, null);
      this.jdField_a_of_type_Bp.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297135));
      this.jdField_a_of_type_Bp.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297136));
    }
    this.jdField_a_of_type_Bp.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_Array2dOfInt[paramInt][0]);
    paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(this.jdField_c_of_type_Array2dOfInt[paramInt][1]);
    this.jdField_a_of_type_Bp.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
    paramViewGroup.setTag(this.jdField_a_of_type_Bp);
    return paramViewGroup;
  }
  
  public void notifyDataSetChanged()
  {
    if ((((RegisterProxySvcPackHandler)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(9)).a() != 0) && (NetworkUtil.g(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity))) {}
    for (this.jdField_c_of_type_Array2dOfInt = this.jdField_a_of_type_Array2dOfInt;; this.jdField_c_of_type_Array2dOfInt = this.jdField_a_of_type_Array2dOfInt)
    {
      super.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bo
 * JD-Core Version:    0.7.0.1
 */