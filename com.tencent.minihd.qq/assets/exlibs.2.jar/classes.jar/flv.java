import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import java.util.List;

public class flv
  extends FriendListObserver
{
  public flv(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.a(2131365991, 2);
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if (paramBoolean)
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
      return;
    }
    this.a.a(2131369868, 1);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean3))
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    if (paramBoolean)
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     flv
 * JD-Core Version:    0.7.0.1
 */