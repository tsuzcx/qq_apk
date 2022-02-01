import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;

public class dpw
  implements View.OnClickListener
{
  public dpw(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    ChatBackground.b(this.a, this.a.app.getAccount(), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, "null");
    QQToast.a(this.a, 2131367510, 0).a();
    ((TextView)this.a.jdField_a_of_type_ArrayOfAndroidViewView[26].findViewById(2131297125)).setText(2131370018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dpw
 * JD-Core Version:    0.7.0.1
 */