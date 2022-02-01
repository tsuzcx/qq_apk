import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.troop.activity.TroopBarUploadManagerActivity;
import org.json.JSONObject;

public class kgv
  extends BizTroopObserver
{
  public kgv(TroopBarUploadManagerActivity paramTroopBarUploadManagerActivity) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      Message localMessage = this.a.a.obtainMessage(1);
      localMessage.obj = paramJSONObject;
      this.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kgv
 * JD-Core Version:    0.7.0.1
 */