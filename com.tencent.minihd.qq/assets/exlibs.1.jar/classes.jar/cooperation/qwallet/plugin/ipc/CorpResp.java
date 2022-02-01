package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;

public class CorpResp
  extends BaseResp
{
  public int a;
  public boolean a;
  public String b;
  public String c;
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putInt("_qwallet_ipc_CorpResp_corpReqType", this.jdField_a_of_type_Int);
    paramBundle.putString("_qwallet_ipc_CorpReq_faceFilePath", this.b);
    paramBundle.putBoolean("_qwallet_ipc_CorpReq_isFriend", this.jdField_a_of_type_Boolean);
    paramBundle.putString("_qwallet_ipc_CorpReq_userNick", this.c);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_Int = paramBundle.getInt("_qwallet_ipc_CorpResp_corpReqType");
    this.b = paramBundle.getString("_qwallet_ipc_CorpReq_faceFilePath");
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("_qwallet_ipc_CorpReq_isFriend");
    this.c = paramBundle.getString("_qwallet_ipc_CorpReq_userNick");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.CorpResp
 * JD-Core Version:    0.7.0.1
 */