import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.activities.PrinterSubOptionActivity;
import com.dataline.activities.PrinterSubOptionActivity.PrinterItemAdapter;

public class cp
  implements View.OnClickListener
{
  public cp(PrinterSubOptionActivity.PrinterItemAdapter paramPrinterItemAdapter) {}
  
  public void onClick(View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131296640);
    if (paramView != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("sPrinterName", paramView.getText());
      this.a.a.setResult(-1, localIntent);
      this.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cp
 * JD-Core Version:    0.7.0.1
 */