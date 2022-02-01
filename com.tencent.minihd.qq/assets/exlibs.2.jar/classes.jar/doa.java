import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQProgressDialog;

class doa
  extends AsyncTask
{
  doa(dnz paramdnz) {}
  
  protected Object a(MessageRecord... paramVarArgs)
  {
    this.a.a.app.a().a(paramVarArgs[0], true);
    return null;
  }
  
  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
    ChatHistoryForC2C.a(this.a.a).removeMessages(1);
    if ((this.a.a.a != null) && (this.a.a.a.isShowing())) {
      this.a.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     doa
 * JD-Core Version:    0.7.0.1
 */