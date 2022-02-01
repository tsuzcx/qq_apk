import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.service.message.MessageCache;

public class hio
  extends MessageObserver
{
  public hio(DataLineHandler paramDataLineHandler) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.a.b()))
    {
      this.a.a(true);
      DataLineHandler.a(this.a, MessageCache.a());
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hio
 * JD-Core Version:    0.7.0.1
 */