import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class ihw
  implements View.OnClickListener
{
  public ihw(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, MoveToGroupActivity.class).putExtra("friendUin", this.a.g).putExtra("mgid", (byte)this.a.J);
    paramView.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
    this.a.startActivityForResult(paramView, 100);
    ReportController.b(null, "CliOper", "", "", "0X80050F1", "0X80050F1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ihw
 * JD-Core Version:    0.7.0.1
 */