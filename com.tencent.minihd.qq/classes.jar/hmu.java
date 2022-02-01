import com.dataline.activities.LiteActivity;
import com.dataline.activities.PrinterActivity;
import com.dataline.util.PrinterSessionAdapter;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.PrinterHandler;

public class hmu
  extends DataLineObserver
{
  public hmu(PrinterHandler paramPrinterHandler) {}
  
  protected void a(Session paramSession)
  {
    this.a.a(3, paramSession, 0.0D, false);
    if (this.a.a != null)
    {
      this.a.a.b();
      this.a.a.notifyDataSetChanged();
      LiteActivity.a(this.a.a.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.a.a.a.jdField_a_of_type_ComTencentWidgetXListView);
      LiteActivity.a(this.a.a.a.jdField_a_of_type_ComTencentWidgetXListView);
    }
  }
  
  protected void a(Session paramSession, float paramFloat)
  {
    this.a.a(1, paramSession, paramFloat, false);
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void a(Session paramSession, boolean paramBoolean)
  {
    this.a.a(2, paramSession, 0.0D, paramBoolean);
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    this.a.a(paramLong, paramBoolean);
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void b(Session paramSession)
  {
    this.a.a(0, paramSession, 0.0D, false);
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hmu
 * JD-Core Version:    0.7.0.1
 */