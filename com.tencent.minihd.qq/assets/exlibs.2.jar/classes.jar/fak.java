import android.os.Bundle;
import com.tencent.mobileqq.activity.SigCommentListActivity;
import com.tencent.mobileqq.adapter.SigCommentSessionListAdapter;
import com.tencent.mobileqq.app.SignatureManager.SigComments;
import com.tencent.mobileqq.app.SignatureObserver;
import java.util.List;

public class fak
  extends SignatureObserver
{
  public fak(SigCommentListActivity paramSigCommentListActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    List localList;
    if (this.a.isResume())
    {
      SigCommentListActivity.a(this.a);
      if (!paramBoolean) {
        break label175;
      }
      if ((paramObject instanceof Bundle))
      {
        paramObject = (SignatureManager.SigComments)((Bundle)paramObject).getSerializable("data");
        paramBoolean = paramObject.isOver;
        paramObject = paramObject.mlist;
        localList = this.a.a.a();
        if (paramObject.size() <= 0) {
          break label128;
        }
        if (localList == null) {
          break label113;
        }
        localList.addAll(localList.size(), paramObject);
        this.a.a.a(localList, paramBoolean);
        this.a.a.notifyDataSetChanged();
      }
    }
    label113:
    do
    {
      return;
      this.a.a.a(paramObject, paramBoolean);
      break;
      if ((localList != null) && (localList.size() > 0)) {
        this.a.a.a(localList, paramBoolean);
      }
      for (;;)
      {
        this.a.a.notifyDataSetChanged();
        return;
        SigCommentListActivity.a(this.a, 3);
      }
      paramObject = this.a.a.a();
    } while ((paramObject != null) && (paramObject.size() > 0));
    label128:
    label175:
    SigCommentListActivity.a(this.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fak
 * JD-Core Version:    0.7.0.1
 */