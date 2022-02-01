import android.view.animation.Interpolator;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim;

public class iiy
  implements Interpolator
{
  iiy(Face2FaceAddFriendAnim paramFace2FaceAddFriendAnim) {}
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat < 0.3636364F) {
      return 7.5625F * paramFloat * paramFloat;
    }
    if (paramFloat < 0.7272728F)
    {
      paramFloat -= 0.5454546F;
      return paramFloat * (7.5625F * paramFloat) + 0.75F;
    }
    if (paramFloat < 0.9090909F)
    {
      paramFloat -= 0.8181818F;
      return paramFloat * (7.5625F * paramFloat) + 0.9375F;
    }
    paramFloat -= 0.9545454F;
    return paramFloat * (7.5625F * paramFloat) + 0.984375F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iiy
 * JD-Core Version:    0.7.0.1
 */