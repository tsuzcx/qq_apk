import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public final class jzg
  implements ActionSheet.OnButtonClickListener
{
  public jzg(String paramString, Context paramContext, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      continue;
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
      continue;
      AddFriendActivity.a(this.jdField_a_of_type_AndroidContentContext, false, this.jdField_a_of_type_JavaLangString, true);
      continue;
      AddFriendActivity.a(this.jdField_a_of_type_AndroidContentContext, true, this.jdField_a_of_type_JavaLangString, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jzg
 * JD-Core Version:    0.7.0.1
 */