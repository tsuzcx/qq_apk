import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.vas.ColorRingPlayer;

public class kvh
  implements Runnable
{
  public kvh(ColorRingPlayer paramColorRingPlayer, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("subAction", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("actionName", this.b);
    localBundle.putInt("result", this.jdField_a_of_type_Int);
    localBundle = DataFactory.makeIPCRequestPacket("reportColorRing", "", this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.a.key, localBundle);
    this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.a(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kvh
 * JD-Core Version:    0.7.0.1
 */