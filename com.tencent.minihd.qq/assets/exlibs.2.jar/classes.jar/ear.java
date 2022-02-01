import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.ProfileCardUtil;

class ear
  implements View.OnClickListener
{
  ear(ean paramean, String paramString) {}
  
  public void onClick(View paramView)
  {
    String str1 = "";
    Object localObject = this.jdField_a_of_type_Ean.a.b();
    paramView = str1;
    if (localObject != null)
    {
      paramView = str1;
      if (((String)localObject).equals("CustomCover")) {
        paramView = "oldCustom=1";
      }
    }
    localObject = this.jdField_a_of_type_Ean.a;
    String str2 = this.jdField_a_of_type_Ean.a.app.a();
    if (this.jdField_a_of_type_JavaLangString.equals("CLICK_HEADER_BG")) {}
    for (str1 = "inside.friendCardBackground";; str1 = "inside.blackBar")
    {
      ProfileCardUtil.a((Activity)localObject, str2, str1, this.jdField_a_of_type_Ean.a.app.getSid(), 1, 1, 1, paramView, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ear
 * JD-Core Version:    0.7.0.1
 */