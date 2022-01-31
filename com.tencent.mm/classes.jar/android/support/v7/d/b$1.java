package android.support.v7.d;

final class b$1
  implements b.b
{
  public final boolean d(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat[2] >= 0.95F)
    {
      i = 1;
      if (i != 0) {
        break label80;
      }
      if (paramArrayOfFloat[2] > 0.05F) {
        break label70;
      }
      i = 1;
      label26:
      if (i != 0) {
        break label80;
      }
      if ((paramArrayOfFloat[0] < 10.0F) || (paramArrayOfFloat[0] > 37.0F) || (paramArrayOfFloat[1] > 0.82F)) {
        break label75;
      }
    }
    label70:
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label80;
      }
      return true;
      i = 0;
      break;
      i = 0;
      break label26;
    }
    label80:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.d.b.1
 * JD-Core Version:    0.7.0.1
 */