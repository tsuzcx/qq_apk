import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RecommendedGatherListActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ewd
  extends FriendListObserver
{
  public ewd(RecommendedGatherListActivity paramRecommendedGatherListActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    int j;
    if (paramBoolean) {
      if ((paramObject != null) && (!TextUtils.isEmpty(String.valueOf(paramObject))))
      {
        Iterator localIterator1 = RecommendedGatherListActivity.a(this.a).values().iterator();
        int i = 0;
        j = i;
        if (!localIterator1.hasNext()) {
          break label121;
        }
        Iterator localIterator2 = ((ArrayList)localIterator1.next()).iterator();
        while (localIterator2.hasNext())
        {
          ewl localewl = (ewl)localIterator2.next();
          if ((localewl.a != null) && (String.valueOf(paramObject).equals(localewl.a.uin))) {
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      break;
      j = 0;
      label121:
      if (j != 0)
      {
        if (!RecommendedGatherListActivity.a(this.a).contains(String.valueOf(paramObject))) {
          break label262;
        }
        RecommendedGatherListActivity.a(this.a).remove(String.valueOf(paramObject));
      }
      for (;;)
      {
        RecommendedGatherListActivity.a(this.a, false);
        this.a.jdField_a_of_type_Ewn.notifyDataSetChanged();
        this.a.c.setVisibility(8);
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if ((RecommendedGatherListActivity.a(this.a) != null) && (RecommendedGatherListActivity.a(this.a).values().size() != 0)) {
          break;
        }
        this.a.b.setVisibility(0);
        RecommendedGatherListActivity.c(this.a);
        RecommendedGatherListActivity.a(this.a).setVisibility(4);
        return;
        label262:
        RecommendedGatherListActivity.a(this.a).remove(String.valueOf(paramObject));
      }
      this.a.b.setVisibility(8);
      RecommendedGatherListActivity.a(this.a).setVisibility(0);
      return;
    }
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    this.a.a();
    if (paramBoolean)
    {
      if ((RecommendedGatherListActivity.a(this.a).size() > 0) && (paramList != null)) {
        RecommendedGatherListActivity.a(this.a).clear();
      }
      RecommendedGatherListActivity.a(this.a, false);
      this.a.jdField_a_of_type_Ewn.notifyDataSetChanged();
      if ((RecommendedGatherListActivity.a(this.a) == null) || (RecommendedGatherListActivity.a(this.a).values().size() == 0))
      {
        this.a.c.setVisibility(8);
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.a.b.setVisibility(0);
        RecommendedGatherListActivity.c(this.a);
        RecommendedGatherListActivity.a(this.a).setVisibility(4);
      }
      paramList = this.a.app.a().getSharedPreferences(this.a.app.getAccount(), 0);
      if (!paramList.getBoolean("hasPopUpQzonePermDlg", false))
      {
        this.a.b();
        paramList.edit().putBoolean("hasPopUpQzonePermDlg", true).commit();
      }
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131369900), 0).b(this.a.getTitleBarHeight());
      RecommendedGatherListActivity.b(this.a, false);
      if (this.a.e.getVisibility() != 0) {
        this.a.e.setVisibility(0);
      }
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131369902), 0).b(this.a.getTitleBarHeight());
  }
  
  protected void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.app.a().getSharedPreferences(this.a.app.getAccount(), 0).edit().putBoolean("hasShownPermDlg", true).commit();
    }
  }
  
  protected void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.stopTitleProgress();
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if ((RecommendedGatherListActivity.a(this.a) == null) || (RecommendedGatherListActivity.a(this.a).values().size() == 0))
        {
          RecommendedGatherListActivity.a(this.a, true);
          RecommendedGatherListActivity.a(this.a);
          RecommendedGatherListActivity.b(this.a);
        }
      }
      else
      {
        if ((RecommendedGatherListActivity.a(this.a) != null) && (RecommendedGatherListActivity.a(this.a).values().size() != 0)) {
          break label180;
        }
        this.a.b.setVisibility(0);
        RecommendedGatherListActivity.c(this.a);
        RecommendedGatherListActivity.a(this.a).setVisibility(4);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Ewn.notifyDataSetChanged();
        this.a.c.setVisibility(8);
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.a.a(this.a);
        return;
        RecommendedGatherListActivity.a(this.a, false);
        break;
        label180:
        this.a.b.setVisibility(8);
        RecommendedGatherListActivity.a(this.a).setVisibility(0);
      }
    }
    this.a.c.setVisibility(8);
    this.a.b.setVisibility(8);
    if ((RecommendedGatherListActivity.a(this.a) == null) || (RecommendedGatherListActivity.a(this.a).values().size() == 0))
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      RecommendedGatherListActivity.a(this.a).setVisibility(4);
      QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131369899), 0).b(this.a.getTitleBarHeight());
      return;
    }
    RecommendedGatherListActivity.a(this.a).setVisibility(0);
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ewd
 * JD-Core Version:    0.7.0.1
 */