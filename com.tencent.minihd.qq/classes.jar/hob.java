import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class hob
  extends Thread
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = true;
  
  public hob(hny paramhny, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    setName("QQHeadDownloadThread" + this.jdField_a_of_type_Int);
    Process.setThreadPriority(10);
    int j = 0;
    for (;;)
    {
      int i;
      if (((j < hny.a(this.jdField_a_of_type_Hny)) || (hny.a(this.jdField_a_of_type_Hny).size() > 0)) && (this.jdField_a_of_type_Boolean)) {
        synchronized (hny.a(this.jdField_a_of_type_Hny))
        {
          i = hny.a(this.jdField_a_of_type_Hny).size();
          if (i == 0) {
            hny.b(this.jdField_a_of_type_Hny);
          }
        }
      }
      try
      {
        hny.a(this.jdField_a_of_type_Hny).wait(30000L);
        hny.c(this.jdField_a_of_type_Hny);
        i = j + 1;
        hoa localhoa = null;
        j = i;
        if (localhoa == null) {
          continue;
        }
        hny.a(this.jdField_a_of_type_Hny, localhoa);
        yield();
        j = i;
        continue;
        if (i > hny.d(this.jdField_a_of_type_Hny))
        {
          localhoa = (hoa)hny.a(this.jdField_a_of_type_Hny).remove(i - 1);
        }
        else
        {
          localhoa = (hoa)hny.a(this.jdField_a_of_type_Hny).remove(0);
          break label310;
          localObject = finally;
          throw localObject;
          if (QLog.isColorLevel()) {
            QLog.d("QQHeadDownloadHandler", 2, "QQHeadDownloadHandler thread exit. isRunning=" + this.jdField_a_of_type_Boolean + ", id=" + this.jdField_a_of_type_Int);
          }
          if ((this.jdField_a_of_type_Boolean) && (hny.a(this.jdField_a_of_type_Hny) != null) && (this.jdField_a_of_type_Int < hny.a(this.jdField_a_of_type_Hny).length)) {
            hny.a(this.jdField_a_of_type_Hny)[this.jdField_a_of_type_Int] = null;
          }
          hny.e(this.jdField_a_of_type_Hny);
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          continue;
          label310:
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hob
 * JD-Core Version:    0.7.0.1
 */