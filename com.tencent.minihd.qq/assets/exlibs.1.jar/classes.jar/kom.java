import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewProvider;
import com.tencent.mobileqq.utils.StringUtil;

public class kom
  extends TroopFeedViewFactory.ViewProvider
{
  public kom(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    super(paramTroopFeedViewFactory);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2130903684, null);
    }
    paramView = (kon)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new kon(this);
      ((kon)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298829));
      ((kon)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297001));
      ((kon)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131299308));
      ((kon)localObject).b = ((TextView)localView.findViewById(2131299307));
      ((kon)localObject).c = ((TextView)localView.findViewById(2131299310));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((kon)localObject).jdField_a_of_type_Int = paramInt;
    ((kon)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((kon)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((kon)localObject).b.setText(paramTroopFeedItem.content);
    ((kon)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = "点击打开 " + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!StringUtil.b(paramTroopFeedItem.ex_1))
    {
      ((kon)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((kon)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839435);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " 两指向左横向滑动查看下一条通知";
      }
      localView.setContentDescription(paramTroopFeedItem);
      if (this.a.b)
      {
        localView.setOnLongClickListener(this.a.jdField_a_of_type_Koj);
        localView.setOnTouchListener(this.a.jdField_a_of_type_Koj);
      }
      return localView;
      ((kon)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kom
 * JD-Core Version:    0.7.0.1
 */