package cooperation.qwallet.plugin;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class QWalletPayProgressDialog
  extends Dialog
{
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private String jdField_a_of_type_JavaLangString = "请稍候...";
  
  public QWalletPayProgressDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public QWalletPayProgressDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131558904);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903117);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296945));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    super.setCancelable(false);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      super.cancel();
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPayProgressDialog
 * JD-Core Version:    0.7.0.1
 */