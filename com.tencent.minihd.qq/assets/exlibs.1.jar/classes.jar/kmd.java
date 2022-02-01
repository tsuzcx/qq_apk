import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import java.lang.ref.WeakReference;

public final class kmd
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((TroopFileError.a != null) && (TroopFileError.a.get() != null))
    {
      TroopFileError.TroopFileErrorObserver localTroopFileErrorObserver = (TroopFileError.TroopFileErrorObserver)TroopFileError.a.get();
      if (localTroopFileErrorObserver != null) {
        localTroopFileErrorObserver.a = 0;
      }
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kmd
 * JD-Core Version:    0.7.0.1
 */