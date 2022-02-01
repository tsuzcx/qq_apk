import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentFileBaseExpandableListAdapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class ipk
  implements View.OnClickListener
{
  public ipk(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)paramView.getTag();
    paramView = (FileManagerEntity)((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject).jdField_a_of_type_JavaLangObject;
    switch (((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject).jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.i();
      return;
      this.a.a.a().ad();
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        FMToastUtil.a(2131362551);
        return;
      }
      if ((FileManagerUtil.a()) && (paramView.fileSize > 5242880L))
      {
        FMDialogUtil.a(this.a.getContext(), 2131362469, 2131362468, new ipl(this, paramView));
      }
      else if (paramView.cloudType == 0)
      {
        QfileBaseRecentFileTabView.q(this.a).a().a(paramView.nSessionId);
      }
      else
      {
        ArrayList localArrayList;
        if (paramView.cloudType == 6)
        {
          localObject = (DataLineHandler)QfileBaseRecentFileTabView.r(this.a).a(8);
          localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(paramView.uniseq));
          if (!((DataLineHandler)localObject).a(localArrayList)) {
            FMToastUtil.a(2131362552);
          }
        }
        else
        {
          QfileBaseRecentFileTabView.s(this.a).a().b(paramView);
          continue;
          this.a.a.a().ac();
          this.a.c(paramView);
          continue;
          this.a.a.a().ae();
          if (paramView.cloudType == 0)
          {
            QfileBaseRecentFileTabView.t(this.a).a().a(paramView.nSessionId);
          }
          else if (paramView.cloudType == 6)
          {
            ((DataLineHandler)QfileBaseRecentFileTabView.u(this.a).a(8)).a(0, paramView.uniseq, false);
          }
          else
          {
            QfileBaseRecentFileTabView.v(this.a).a().a(paramView.nSessionId);
            continue;
            this.a.a.a().af();
            if (!NetworkUtil.e(BaseApplication.getContext()))
            {
              FMToastUtil.a(2131362551);
              return;
            }
            if ((FileManagerUtil.a()) && (paramView.fileSize > 5242880L))
            {
              localObject = this.a.getContext();
              if (paramView.nOpType == 0) {}
              for (int i = 2131362465;; i = 2131362466)
              {
                FMDialogUtil.a((Context)localObject, 2131362469, i, new ipm(this, paramView));
                break;
              }
            }
            if (paramView.cloudType == 0)
            {
              QfileBaseRecentFileTabView.z(this.a).a().b(paramView.nSessionId);
            }
            else if (paramView.cloudType == 6)
            {
              localObject = (DataLineHandler)QfileBaseRecentFileTabView.A(this.a).a(8);
              localArrayList = new ArrayList();
              localArrayList.add(Long.valueOf(paramView.uniseq));
              if (!((DataLineHandler)localObject).a(localArrayList)) {
                FMToastUtil.a(2131362552);
              }
            }
            else
            {
              QfileBaseRecentFileTabView.B(this.a).a().a(paramView.nSessionId);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ipk
 * JD-Core Version:    0.7.0.1
 */