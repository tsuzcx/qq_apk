import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.recent.LocalSearchBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

public class guy
  extends SearchResultDialog
{
  public guy(LocalSearchBar paramLocalSearchBar, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, AdapterView.OnItemClickListener paramOnItemClickListener, int paramInt2)
  {
    super(paramContext, paramQQAppInterface, paramInt1, paramOnItemClickListener, paramInt2);
  }
  
  @SuppressLint({"UseSparseArrays"})
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(a(paramContext, paramQQAppInterface));
    localArrayList.addAll(super.a(paramContext, paramQQAppInterface, paramInt));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     guy
 * JD-Core Version:    0.7.0.1
 */