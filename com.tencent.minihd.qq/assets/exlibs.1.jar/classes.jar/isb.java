import com.tencent.mobileqq.filemanager.core.FileUploader;
import com.tencent.mobileqq.filemanager.core.FileUploader.IFlowControl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.wstt.SSCM.SSCM;
import com.tencent.wstt.SSCM.Utils;

public class isb
  implements FileUploader.IFlowControl
{
  private SSCM jdField_a_of_type_ComTencentWsttSSCMSSCM = new SSCM();
  
  public isb(FileUploader paramFileUploader)
  {
    this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
  }
  
  public int a(long paramLong1, long paramLong2)
  {
    int j = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), paramLong2, paramLong1, 1048576);
    int k = Utils.a(BaseApplication.getContext());
    int i;
    if (k != 1)
    {
      i = j;
      if (k != 2) {}
    }
    else
    {
      i = j;
      if (j > 16384) {
        i = 16384;
      }
    }
    return i;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWsttSSCMSSCM.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     isb
 * JD-Core Version:    0.7.0.1
 */