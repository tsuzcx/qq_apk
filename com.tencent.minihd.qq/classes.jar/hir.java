import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.DataLineHandler;

public class hir
  implements Runnable
{
  public hir(DataLineHandler paramDataLineHandler, Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo) {}
  
  public void run()
  {
    DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler, this.jdField_a_of_type_ComTencentLitetransfersdkSession, this.jdField_a_of_type_ComTencentLitetransfersdkNFCInfo, this.jdField_a_of_type_ComTencentLitetransfersdkFTNInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hir
 * JD-Core Version:    0.7.0.1
 */