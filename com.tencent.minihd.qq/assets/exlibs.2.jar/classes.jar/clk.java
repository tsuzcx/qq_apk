import com.tencent.biz.qrcode.CodeMaskManager;
import com.tencent.biz.qrcode.CodeMaskManager.Callback;
import java.util.concurrent.atomic.AtomicBoolean;

public class clk
  implements Runnable
{
  public clk(CodeMaskManager paramCodeMaskManager, cll paramcll, CodeMaskManager.Callback paramCallback) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager.a) {}
    while (!this.jdField_a_of_type_Cll.a.compareAndSet(false, true)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager$Callback.a(CodeMaskManager.a(this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager));
    CodeMaskManager.a(this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     clk
 * JD-Core Version:    0.7.0.1
 */