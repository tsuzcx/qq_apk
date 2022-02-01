import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class ins
  implements Runnable
{
  public ins(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void run()
  {
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ins
 * JD-Core Version:    0.7.0.1
 */