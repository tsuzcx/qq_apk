import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ForwardOperations;

public class dzn
  implements DialogInterface.OnClickListener
{
  public dzn(ForwardOperations paramForwardOperations) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ForwardOperations.a(this.a.jdField_a_of_type_AndroidAppActivity, false, "addToQQFavorites", this.a.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dzn
 * JD-Core Version:    0.7.0.1
 */