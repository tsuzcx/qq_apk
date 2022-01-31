package android.support.v4.app;

import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class j
{
  public abstract Fragment G(String paramString);
  
  public abstract Fragment Z(int paramInt);
  
  public abstract void a(Bundle paramBundle, String paramString, Fragment paramFragment);
  
  public abstract void ab(int paramInt);
  
  public abstract o bP();
  
  public abstract Fragment d(Bundle paramBundle, String paramString);
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract Fragment.SavedState e(Fragment paramFragment);
  
  public abstract boolean executePendingTransactions();
  
  public abstract List<Fragment> getFragments();
  
  public abstract boolean isStateSaved();
  
  public abstract void popBackStack();
  
  public abstract boolean popBackStackImmediate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.j
 * JD-Core Version:    0.7.0.1
 */