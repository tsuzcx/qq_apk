import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;

public class fjy
  implements Runnable
{
  public fjy(TroopMemberListActivity.ListAdapter paramListAdapter) {}
  
  public void run()
  {
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fjy
 * JD-Core Version:    0.7.0.1
 */