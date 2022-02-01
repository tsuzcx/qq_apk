import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.HashSet;

public class lre
  implements View.OnClickListener
{
  public lre(ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((ActionSheet.a(this.a)) && ((ActionSheet.a(this.a) == null) || (!ActionSheet.a(this.a).contains(Integer.valueOf(i)))) && (ActionSheet.b(this.a) != -1) && (i != ActionSheet.b(this.a)))
    {
      ((View)ActionSheet.a(this.a).get(ActionSheet.b(this.a))).findViewById(2131296642).setVisibility(8);
      ((View)ActionSheet.a(this.a).get(i)).findViewById(2131296642).setVisibility(8);
      ActionSheet.a(this.a, i);
    }
    if (ActionSheet.a(this.a) != null) {
      ActionSheet.a(this.a).OnClick(paramView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lre
 * JD-Core Version:    0.7.0.1
 */