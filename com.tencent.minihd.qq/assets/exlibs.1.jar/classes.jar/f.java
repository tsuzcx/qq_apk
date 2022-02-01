import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.util.DatalineFilesAdapter;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.util.ArrayList;
import java.util.Iterator;

public class f
  extends DataLineObserver
{
  public f(DLFilesViewerActivity paramDLFilesViewerActivity) {}
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    this.a.runOnUiThread(new g(this, paramLong, paramFloat));
  }
  
  protected void a(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
    DLFilesViewerActivity.b(this.a);
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    Iterator localIterator = DLFilesViewerActivity.a(this.a).values().iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      if (paramString.equals(localDataLineMsgRecord.strMoloKey))
      {
        localDataLineMsgRecord.nAppStatus = 1;
        DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
      }
    }
    DLFilesViewerActivity.b(this.a);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
    DLFilesViewerActivity.b(this.a);
  }
  
  protected void b(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.b(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
    DLFilesViewerActivity.b(this.a);
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
    DLFilesViewerActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     f
 * JD-Core Version:    0.7.0.1
 */