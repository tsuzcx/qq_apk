import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

class fjn
  implements Runnable
{
  fjn(fjm paramfjm, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Fjm.a.b != null) && (this.jdField_a_of_type_Fjm.a.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_Fjm.a.jdField_c_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_Fjm.a.jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
      ((TextView)this.jdField_a_of_type_Fjm.a.b.findViewById(2131302369)).setCompoundDrawables(null, null, null, null);
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Fjm.a.h))) {}
    while ((this.jdField_a_of_type_Fjm.a.b == null) || (this.jdField_a_of_type_Fjm.a.b.getVisibility() == 8)) {
      return;
    }
    this.jdField_a_of_type_Fjm.a.b.setEnabled(true);
    ((TextView)this.jdField_a_of_type_Fjm.a.b.findViewById(2131297297)).setTextColor(this.jdField_a_of_type_Fjm.a.getResources().getColor(2131427934));
    this.jdField_a_of_type_Fjm.a.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Fjm.a.l = this.jdField_b_of_type_JavaLangString;
    ((TextView)this.jdField_a_of_type_Fjm.a.b.findViewById(2131302369)).setText(this.c);
    String str = "@全体成员";
    if (this.c != null) {
      str = "@全体成员" + "," + this.c;
    }
    this.jdField_a_of_type_Fjm.a.b.setContentDescription(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fjn
 * JD-Core Version:    0.7.0.1
 */