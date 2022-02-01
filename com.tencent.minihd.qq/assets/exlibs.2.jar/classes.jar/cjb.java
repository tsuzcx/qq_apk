import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;

public class cjb
  implements DialogInterface.OnClickListener
{
  public cjb(CustomWebChromeClient paramCustomWebChromeClient, JsPromptResult paramJsPromptResult) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesJsPromptResult.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cjb
 * JD-Core Version:    0.7.0.1
 */