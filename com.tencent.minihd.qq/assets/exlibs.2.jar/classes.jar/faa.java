import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity.TroopAdmin;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class faa
  implements View.OnClickListener
{
  public faa(SetTroopAdminsActivity paramSetTroopAdminsActivity) {}
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    Object localObject = paramView.getTag();
    if (j == 2131302310) {
      localObject = paramView.findViewById(2131302311).getTag();
    }
    if ((localObject != null) && ((localObject instanceof Integer))) {}
    for (int i = ((Integer)localObject).intValue();; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SetTroopAdminsActivity", 2, "mOnKickOutBtnClickListener:" + i);
      }
      if ((i < 0) || (i >= SetTroopAdminsActivity.a(this.a).size())) {}
      do
      {
        do
        {
          do
          {
            return;
            paramView = (SetTroopAdminsActivity.TroopAdmin)SetTroopAdminsActivity.a(this.a).get(i);
            if (j != 2131302311) {
              break;
            }
            localObject = this.a.a(paramView.a);
          } while (localObject == null);
          ((fae)localObject).a.a(true);
          this.a.a.add(paramView.a);
          return;
          if (j != 2131302310) {
            break;
          }
          localObject = this.a.a(paramView.a);
        } while (localObject == null);
        ((fae)localObject).a.b(true);
        this.a.a.remove(paramView.a);
        return;
      } while (j != 2131302314);
      SetTroopAdminsActivity.a(this.a, 2131365843);
      SetTroopAdminsActivity.a(this.a).put(paramView.a, paramView);
      ((TroopHandler)this.a.app.a(19)).a((byte)0, SetTroopAdminsActivity.a(this.a), paramView.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     faa
 * JD-Core Version:    0.7.0.1
 */