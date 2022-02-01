import java.util.concurrent.ThreadFactory;

class kud
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    kuc.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + kuc.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kud
 * JD-Core Version:    0.7.0.1
 */