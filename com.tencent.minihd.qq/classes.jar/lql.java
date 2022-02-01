import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.AbsListView;

public class lql
  extends lqv
  implements Runnable
{
  private lql(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
  }
  
  public void run()
  {
    int i = this.a.W;
    View localView = this.a.getChildAt(i - this.a.ao);
    long l;
    if (localView != null)
    {
      i = this.a.W;
      l = this.a.a.getItemId(this.a.W);
      if ((!a()) || (this.a.q)) {
        break label126;
      }
    }
    label126:
    for (boolean bool = this.a.b(localView, i, l);; bool = false)
    {
      if (bool)
      {
        this.a.ab = -1;
        this.a.setPressed(false);
        localView.setPressed(false);
        return;
      }
      this.a.ab = 2;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     lql
 * JD-Core Version:    0.7.0.1
 */