import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.model.RecordVolume.RecordVolumeListener;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;

public class jeh
  implements RecordVolume.RecordVolumeListener
{
  public jeh(MagicfaceActionManager paramMagicfaceActionManager) {}
  
  public void a(int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.b(paramInt, MagicfaceActionManager.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jeh
 * JD-Core Version:    0.7.0.1
 */