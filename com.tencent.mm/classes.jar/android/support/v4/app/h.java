package android.support.v4.app;

public final class h
{
  final i<?> mHost;
  
  h(i<?> parami)
  {
    this.mHost = parami;
  }
  
  public final boolean execPendingActions()
  {
    return this.mHost.mFragmentManager.execPendingActions();
  }
  
  public final Fragment findFragmentByWho(String paramString)
  {
    return this.mHost.mFragmentManager.findFragmentByWho(paramString);
  }
  
  public final void noteStateNotSaved()
  {
    this.mHost.mFragmentManager.noteStateNotSaved();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.h
 * JD-Core Version:    0.7.0.1
 */