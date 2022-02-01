import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollGroupFloatingListener;
import com.tencent.widget.AbsListView;

public class fll
  extends SlideDetectListView.OnScrollGroupFloatingListener
{
  public fll(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a != null) {
      UncommonlyUsedContactsActivity.a(this.a, paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fll
 * JD-Core Version:    0.7.0.1
 */