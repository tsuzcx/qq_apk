import android.content.Context;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.contact.troop.DiscussionView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import java.util.ArrayList;
import java.util.List;

public class gjc
  extends SearchResultDialog
{
  public gjc(DiscussionView paramDiscussionView, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, ForwardOperations paramForwardOperations, int paramInt2)
  {
    super(paramContext, paramQQAppInterface, paramInt1, paramForwardOperations, paramInt2);
  }
  
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((FriendManager)paramQQAppInterface.getManager(8) == null) {
      return localArrayList;
    }
    return c(paramContext, paramQQAppInterface, 21474836480L, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gjc
 * JD-Core Version:    0.7.0.1
 */