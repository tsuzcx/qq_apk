package android.support.transition;

import android.graphics.Path;

final class Transition$1
  extends PathMotion
{
  public final Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Path localPath = new Path();
    localPath.moveTo(paramFloat1, paramFloat2);
    localPath.lineTo(paramFloat3, paramFloat4);
    return localPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.Transition.1
 * JD-Core Version:    0.7.0.1
 */