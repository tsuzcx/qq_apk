import android.util.SparseArray;
import android.widget.ProgressBar;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;

public class kmy
  implements Runnable
{
  public kmy(AvatarWallAdapter paramAvatarWallAdapter, int paramInt) {}
  
  public void run()
  {
    ProgressBar localProgressBar = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a.get(this.jdField_a_of_type_Int);
    if (localProgressBar != null)
    {
      AvatarWallAdapter localAvatarWallAdapter = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter;
      int i = localAvatarWallAdapter.n + 1;
      localAvatarWallAdapter.n = i;
      localProgressBar.setProgress(100 - i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kmy
 * JD-Core Version:    0.7.0.1
 */