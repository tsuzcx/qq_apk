import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.StrangerManageActivity;
import com.tencent.mobileqq.activity.StrangerManageActivity.StrangeManagerListAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;

public class fck
  extends FriendListObserver
{
  public fck(StrangerManageActivity paramStrangerManageActivity) {}
  
  protected void a(String paramString)
  {
    if (this.a.app.a().equals(paramString)) {
      return;
    }
    int i = this.a.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    if (i >= 0)
    {
      if (TextUtils.equals(((Stranger)this.a.jdField_a_of_type_JavaUtilArrayList.get(i)).uin, paramString)) {
        this.a.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
    }
    else
    {
      EntityManager localEntityManager = this.a.app.a().createEntityManager();
      paramString = (Stranger)localEntityManager.a(Stranger.class, paramString);
      if (paramString != null) {
        localEntityManager.b(paramString);
      }
      paramString = StrangerManageActivity.c(this.a);
      if (this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label155;
      }
    }
    label155:
    for (boolean bool = true;; bool = false)
    {
      paramString.setEnabled(bool);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter.notifyDataSetChanged();
      return;
      i -= 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fck
 * JD-Core Version:    0.7.0.1
 */