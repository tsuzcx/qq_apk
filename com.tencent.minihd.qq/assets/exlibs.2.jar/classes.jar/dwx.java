import android.content.Intent;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import java.util.ArrayList;

public class dwx
  extends TroopObserver
{
  public dwx(EditInfoActivity paramEditInfoActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    EditInfoActivity.a(this.a, false);
    if (paramBoolean) {
      try
      {
        paramObject = (Object[])paramObject;
        long l = ((Long)paramObject[0]).longValue();
        ((Integer)paramObject[1]).intValue();
        paramObject = (TroopMemberCard)paramObject[2];
        if (l != Long.parseLong(this.a.c)) {
          return;
        }
        if ((paramObject != null) && (paramObject.memberUin == Long.parseLong(this.a.d)))
        {
          Object localObject = (TroopManager)this.a.app.getManager(50);
          if (localObject != null) {
            ((TroopManager)localObject).a(this.a.c, this.a.d, paramObject.card, -100, null, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D);
          }
          if (paramObject != null)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("nick", paramObject.card);
            this.a.setResult(-1, (Intent)localObject);
            EditInfoActivity.e(this.a);
            return;
          }
        }
      }
      catch (Exception paramObject) {}
    }
  }
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (this.a.a == null) {
      this.a.a = new QQProgressNotifier(this.a);
    }
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0))
    {
      this.a.a.a(2, 2131366339, 1000);
      return;
    }
    paramArrayList = (TroopHandler)this.a.app.a(19);
    try
    {
      paramArrayList.a(Long.parseLong(this.a.c), Long.parseLong(this.a.d));
      return;
    }
    catch (Exception paramArrayList) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dwx
 * JD-Core Version:    0.7.0.1
 */