package com.tencent.mm.ch;

import android.os.Debug;
import android.os.Environment;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public final class d
  implements EventListener
{
  static ah dPi = new d.2();
  public static a uFS;
  public static d uFX;
  private static int uFY = 5242880;
  public static final String uGa = Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/tracedog/";
  private volatile boolean eAp;
  private volatile boolean uFZ;
  private LinkedBlockingQueue<d.a> uGb;
  ExecutorService uGc;
  public WeakReference<d.b> uGd;
  
  static
  {
    uFS = null;
  }
  
  private static void P(File paramFile)
  {
    if (paramFile.isFile()) {
      paramFile.delete();
    }
    while (!paramFile.isDirectory()) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile.delete();
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      P(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  private static String Q(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if (paramFile.isDirectory())
    {
      y.i("MicroMsg.TraceDebugManager", "TRACE currentPath is dir");
      paramFile = paramFile.listFiles();
      if (paramFile == null)
      {
        y.e("MicroMsg.TraceDebugManager", " get file list failed");
        return null;
      }
      i = 0;
      while (i < paramFile.length)
      {
        localArrayList.add(paramFile[i]);
        i += 1;
      }
    }
    localArrayList.add(paramFile);
    paramFile = new File(uGa + bk.UY() + ".zip");
    try
    {
      p.a(localArrayList, paramFile);
      i = 0;
      while (i < localArrayList.size())
      {
        ((File)localArrayList.get(i)).delete();
        i += 1;
      }
      if (paramFile.length() <= 3145728L) {
        break label211;
      }
    }
    catch (Exception paramFile)
    {
      y.e("MicroMsg.TraceDebugManager", "exception:%s", new Object[] { bk.j(paramFile) });
      y.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", new Object[] { paramFile.getMessage() });
      return null;
    }
    y.e("MicroMsg.TraceDebugManager", "trace file is too large:%d ", new Object[] { Long.valueOf(paramFile.length()) });
    return null;
    label211:
    return paramFile.getAbsolutePath();
  }
  
  private void a(d.a parama)
  {
    if (this.uFZ) {}
    label183:
    do
    {
      return;
      if (!c.zF())
      {
        y.i("MicroMsg.TraceDebugManager", "TRACE sdcard is invalid");
        return;
      }
      cxB();
      for (;;)
      {
        try
        {
          Object localObject = new File(uGa);
          if ((parama.cbH != 6) && (((File)localObject).exists()))
          {
            y.i("MicroMsg.TraceDebugManager", "TRACE delete all file ");
            P((File)localObject);
          }
          ((File)localObject).mkdirs();
          localObject = parama.savePath;
          if (parama.uGg > 0) {
            continue;
          }
          i = uFY;
          Debug.startMethodTracing((String)localObject, i);
          this.uFZ = true;
        }
        catch (IncompatibleClassChangeError parama)
        {
          int i;
          y.printErrStackTrace("MicroMsg.Crash", parama, "May cause dvmFindCatchBlock crash!", new Object[0]);
          throw ((IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(parama));
        }
        catch (Throwable localThrowable)
        {
          this.uFZ = false;
          y.printErrStackTrace("MicroMsg.TraceDebugManager", localThrowable, "TRACE startMethodTracing ERROR", new Object[0]);
          continue;
        }
        if (parama.cbH != 6) {
          break label183;
        }
        y.i("MicroMsg.TraceDebugManager", "TRACE startTrace uploadType is CLIENT ");
        return;
        i = parama.uGg;
        i = i * 1024 * 1024;
      }
    } while (!this.uFZ);
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = parama;
    if ((bk.bl(parama.className)) || (parama.cbH == 5))
    {
      dPi.sendMessageDelayed(localMessage, 15000L);
      return;
    }
    dPi.sendMessageDelayed(localMessage, 10000L);
  }
  
  public static d cxA()
  {
    if (uFX == null) {
      uFX = new d();
    }
    return uFX;
  }
  
  private static void cxB()
  {
    dPi.removeMessages(0);
    dPi.removeMessages(2);
    dPi.removeMessages(1);
  }
  
  final void acT(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.eAp = true;
    if (bk.bl(paramString)) {
      y.e("MicroMsg.TraceDebugManager", "TRACE error uploadPath %s ", new Object[] { paramString });
    }
    for (;;)
    {
      this.eAp = false;
      return;
      if (!c.zF())
      {
        y.e("MicroMsg.TraceDebugManager", "TRACE sdcard invalid.");
      }
      else
      {
        File localFile = new File(paramString);
        if (!localFile.exists())
        {
          y.e("MicroMsg.TraceDebugManager", "TRACE upload file is not exist");
        }
        else
        {
          if (localFile.isDirectory()) {
            paramString = Q(localFile);
          }
          if ((paramString != null) && (new File(paramString).length() >= 131072L)) {
            if (uFS == null)
            {
              y.e("MicroMsg.TraceDebugManager", "TRACE upload : no file upload impl set!");
            }
            else
            {
              boolean bool = uFS.KO(paramString);
              y.i("MicroMsg.TraceDebugManager", "TRACE upload : %b", new Object[] { Boolean.valueOf(bool) });
              if (bool) {
                e.k(new File(uGa));
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean b(d.a parama)
  {
    
    if ((!this.uFZ) || (this.eAp))
    {
      y.i("MicroMsg.TraceDebugManager", "TRACE stopTrace hasStartTrace : %b ,isUploading :%b  ", new Object[] { Boolean.valueOf(this.uFZ), Boolean.valueOf(this.eAp) });
      return false;
    }
    if (!c.zF())
    {
      y.i("MicroMsg.TraceDebugManager", "TRACE stopTrace sdcard invalid");
      return false;
    }
    this.uGc.execute(new d.1(this, parama));
    return true;
  }
  
  public final void c(d.a parama)
  {
    if (parama.cbH <= 0) {
      return;
    }
    if (this.uGc == null) {
      this.uGc = Executors.newSingleThreadExecutor();
    }
    if ((this.eAp) || (this.uFZ))
    {
      y.i("MicroMsg.TraceDebugManager", "TRACE isUloading or hasStartTrace %b %b", new Object[] { Boolean.valueOf(this.eAp), Boolean.valueOf(this.uFZ) });
      return;
    }
    dPi.removeMessages(0);
    if ((parama.uGh == 4) || (parama.uGh == 5))
    {
      int i = parama.uGh;
      this.uGc.execute(new d.3(this, i));
    }
    for (;;)
    {
      y.i("MicroMsg.TraceDebugManager", "TRACE PUSH : class : %s  code :%s type :%s", new Object[] { parama.className, Integer.valueOf(parama.cbH), Integer.valueOf(parama.uGh) });
      return;
      if ((parama.cbH == 6) || (parama.cbH == 5))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = parama;
        if (parama.cbH == 5) {
          dPi.sendMessage(localMessage);
        } else {
          dPi.sendMessageDelayed(localMessage, 500L);
        }
      }
      else
      {
        if (this.uGb == null) {
          this.uGb = new LinkedBlockingQueue();
        }
        this.uGb.clear();
        this.uGb.add(parama);
      }
    }
  }
  
  public final void dA(String paramString, int paramInt)
  {
    d.a locala;
    if ((this.uGb != null) && (this.uGb.size() > 0))
    {
      y.i("MicroMsg.TraceDebugManager", "TRACE gatherData : isUploading : %b  hasStart :%b currentClass : %s currentCode %d ", new Object[] { Boolean.valueOf(this.eAp), Boolean.valueOf(this.uFZ), paramString, Integer.valueOf(paramInt) });
      if ((!this.eAp) && (!this.uFZ))
      {
        Iterator localIterator = this.uGb.iterator();
        while (localIterator.hasNext())
        {
          locala = (d.a)localIterator.next();
          if (locala.className == null) {
            break label148;
          }
          if ((locala.className.equals(paramString)) && (locala.cbH == paramInt))
          {
            a(locala);
            this.uGb.remove(locala);
          }
        }
      }
    }
    return;
    label148:
    a(null);
    this.uGb.remove(locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ch.d
 * JD-Core Version:    0.7.0.1
 */