import com.tencent.biz.bmqq.app.BmqqBusinessObserver;
import com.tencent.biz.bmqq.profile.BmqqProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;

public class cct
  extends BmqqBusinessObserver
{
  public cct(BmqqProfileCardActivity paramBmqqProfileCardActivity) {}
  
  protected void a(boolean paramBoolean, BmqqUserSimpleInfo paramBmqqUserSimpleInfo)
  {
    int j = 0;
    BmqqProfileCardActivity.a(this.a, false);
    BmqqProfileCardActivity.a(this.a);
    int i;
    if (paramBoolean) {
      if ((paramBmqqUserSimpleInfo != null) && (paramBmqqUserSimpleInfo.mBmqqUin.equals(BmqqProfileCardActivity.a(this.a).a)))
      {
        i = j;
        if (!paramBmqqUserSimpleInfo.equals(this.a.a))
        {
          this.a.a = paramBmqqUserSimpleInfo;
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i == 1) {
        BmqqProfileCardActivity.a(this.a, true);
      }
      BmqqProfileCardActivity.b(this.a);
      return;
      i = 1;
      continue;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cct
 * JD-Core Version:    0.7.0.1
 */