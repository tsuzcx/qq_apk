import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.Session;
import java.util.ArrayList;

public class dcb
  implements Runnable
{
  public dcb(LiteTransferWrapper paramLiteTransferWrapper, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.SetProxyToJni();
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.SendGroupToJNI(LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), (Session[])this.jdField_a_of_type_JavaUtilArrayList.toArray(new Session[this.jdField_a_of_type_JavaUtilArrayList.size()]), this.jdField_a_of_type_Boolean, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dcb
 * JD-Core Version:    0.7.0.1
 */