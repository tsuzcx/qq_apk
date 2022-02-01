import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import java.util.LinkedHashMap;

public class gym
  extends Handler
{
  public gym(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    default: 
      return;
    }
    Object[] arrayOfObject = (Object[])paramMessage.obj;
    if (arrayOfObject.length == 3)
    {
      TroopMemberListInnerFrame.a(this.a).setVisibility(0);
      this.a.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)arrayOfObject[0]);
      this.a.jdField_a_of_type_ArrayOfInt = ((int[])arrayOfObject[1]);
      this.a.jdField_a_of_type_ArrayOfJavaLangString = ((String[])arrayOfObject[2]);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Gyr.notifyDataSetChanged();
      if ((paramMessage.what != 2) && ((paramMessage.what != 1) || (this.a.jdField_a_of_type_Boolean))) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g();
      return;
      TroopMemberListInnerFrame.a(this.a).setVisibility(4);
      this.a.jdField_a_of_type_ArrayOfInt = new int[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gym
 * JD-Core Version:    0.7.0.1
 */