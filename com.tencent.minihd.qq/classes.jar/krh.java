import android.app.Dialog;

public final class krh
  implements Runnable
{
  public krh(Dialog paramDialog) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     krh
 * JD-Core Version:    0.7.0.1
 */