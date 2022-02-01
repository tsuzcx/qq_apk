import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cannon.Visitor;
import com.tencent.mobileqq.activity.MayKnowManActivity;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import java.util.List;

public class ekj
  extends FacePreloadBaseAdapter
{
  public ekj(MayKnowManActivity paramMayKnowManActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.a = String.valueOf(((Visitor)getItem(paramInt)).uin);
    return localFaceInfo;
  }
  
  public int getCount()
  {
    return this.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return (Visitor)this.a.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return ((Visitor)this.a.a.get(paramInt)).uin;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.a.getLayoutInflater().inflate(2130903372, null);
    }
    paramView = (eki)paramViewGroup.getTag();
    if (paramView == null)
    {
      paramView = new eki(this.a, null);
      paramView.d = ((ImageView)paramViewGroup.findViewById(2131297985));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131297987));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297986));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297988));
      paramViewGroup.setTag(paramView);
    }
    for (;;)
    {
      Visitor localVisitor = (Visitor)this.a.a.get(paramInt);
      paramView.jdField_b_of_type_JavaLangString = String.valueOf(localVisitor.uin);
      if ((localVisitor.name == null) || (localVisitor.name.length() == 0)) {
        localVisitor.name = String.valueOf(localVisitor.uin);
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localVisitor.name);
      String str = String.format(this.a.getString(2131367070), new Object[] { Integer.valueOf(localVisitor.weight) });
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      paramView.d.setImageBitmap(a(1, String.valueOf(localVisitor.uin)));
      paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ekk(this, localVisitor));
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ekj
 * JD-Core Version:    0.7.0.1
 */