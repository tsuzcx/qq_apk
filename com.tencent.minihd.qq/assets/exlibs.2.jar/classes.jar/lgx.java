import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;

class lgx
  implements Runnable
{
  lgx(lgv paramlgv) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentOpenBaseTicketUtils.a();
    this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.c();
    if (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
    {
      if (this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a() <= 2) {
        ((TMAssistantCallYYB_V1)this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB).startToAuthorized(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = null;
        return;
        ((TMAssistantCallYYB_V2)this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB).startToAuthorized(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
      }
    }
    LogUtility.e("MyAppApi", "startToAuthorizedDirect->onGetA1Fail lastAuthorizeParam = null, needCarryQQIdentity = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lgx
 * JD-Core Version:    0.7.0.1
 */