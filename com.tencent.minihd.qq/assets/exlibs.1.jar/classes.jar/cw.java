import com.dataline.util.DLRouterSessionInfoRequestTask;
import com.tencent.qphone.base.util.QLog;

class cw
  implements Runnable
{
  cw(cv paramcv) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("dataline.DLRouterSessionListAdapter", 4, "请求超时 : nCMD[" + this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask.i + "], nSendCookie[" + this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask.g + "], lastSendCookie[" + this.a.jdField_a_of_type_Int + "], uTaskCookie[" + this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask.jdField_a_of_type_Long + "], lastTaskCookie[" + this.a.jdField_a_of_type_Long + "], isRunning[" + this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask.jdField_a_of_type_Boolean);
    }
    if ((this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask.jdField_a_of_type_Boolean) && (DLRouterSessionInfoRequestTask.a(this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask) != null) && (this.a.jdField_a_of_type_Int == this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask.g) && (this.a.jdField_a_of_type_Long == this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask.jdField_a_of_type_Long)) {
      DLRouterSessionInfoRequestTask.a(this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cw
 * JD-Core Version:    0.7.0.1
 */