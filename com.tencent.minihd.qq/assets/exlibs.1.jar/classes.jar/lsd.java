import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.widget.HongbaoTextView;

public class lsd
  implements Runnable
{
  public lsd(HongbaoTextView paramHongbaoTextView, View paramView, CharSequence paramCharSequence, Context paramContext) {}
  
  public void run()
  {
    Object localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297370);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297371);
    ((TextView)localObject).performClick();
    localObject = new Intent("hongbao_money_get");
    ((Intent)localObject).putExtra("error_msg", this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lsd
 * JD-Core Version:    0.7.0.1
 */