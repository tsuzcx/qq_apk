import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileRecentImageExpandableListAdapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentFileBaseExpandableListAdapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class iph
  implements View.OnClickListener
{
  iph(ipg paramipg, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((paramView instanceof QfileRecentImageExpandableListAdapter.ImageHolder)) {}
    for (paramView = (FileManagerEntity)((QfileRecentImageExpandableListAdapter.ImageHolder)paramView).a;; paramView = (FileManagerEntity)((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)paramView).a)
    {
      if (QfileBaseRecentFileTabView.m(this.jdField_a_of_type_Ipg.a).a().b(paramView.nSessionId)) {}
      this.jdField_a_of_type_Ipg.a.a(paramView);
      QfileBaseRecentFileTabView.a(this.jdField_a_of_type_Ipg.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iph
 * JD-Core Version:    0.7.0.1
 */