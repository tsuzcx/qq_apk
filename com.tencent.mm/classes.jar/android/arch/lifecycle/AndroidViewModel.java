package android.arch.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;

public class AndroidViewModel
  extends ViewModel
{
  @SuppressLint({"StaticFieldLeak"})
  private Application bT;
  
  public AndroidViewModel(Application paramApplication)
  {
    this.bT = paramApplication;
  }
  
  public <T extends Application> T getApplication()
  {
    return this.bT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.AndroidViewModel
 * JD-Core Version:    0.7.0.1
 */