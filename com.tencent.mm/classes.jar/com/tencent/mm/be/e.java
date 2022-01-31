package com.tencent.mm.be;

import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.mm.ah.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.j;

public final class e
{
  private static e eBt = null;
  private byte[] dIn = new byte[0];
  private String eBu;
  private f eBv = new e.3(this);
  public av elq = new av(1, "speex_worker");
  
  public static e Rk()
  {
    if (eBt == null) {
      eBt = new e();
    }
    return eBt;
  }
  
  private static com.tencent.mm.vfs.b bv(int paramInt1, int paramInt2)
  {
    Object localObject1 = new com.tencent.mm.vfs.b(b.Rb());
    if ((!((com.tencent.mm.vfs.b)localObject1).exists()) || (!((com.tencent.mm.vfs.b)localObject1).isDirectory())) {
      localObject1 = null;
    }
    com.tencent.mm.vfs.b[] arrayOfb;
    int i;
    label46:
    do
    {
      do
      {
        return localObject1;
        arrayOfb = ((com.tencent.mm.vfs.b)localObject1).cLt();
        i = 0;
        localObject2 = null;
        localObject1 = localObject2;
      } while (arrayOfb == null);
      localObject1 = localObject2;
    } while (i >= arrayOfb.length);
    Object localObject2 = arrayOfb[i];
    localObject1 = localObject2;
    String str;
    long l;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((com.tencent.mm.vfs.b)localObject2).isFile())
      {
        y.d("MicroMsg.SpeexUploadCore", "file " + j.n(((com.tencent.mm.vfs.b)localObject2).mUri));
        str = j.n(((com.tencent.mm.vfs.b)localObject2).mUri);
        l = ((com.tencent.mm.vfs.b)localObject2).length();
        if (((com.tencent.mm.vfs.b)localObject2).getName().endsWith(".spx")) {
          break label165;
        }
      }
    }
    for (localObject1 = null;; localObject1 = null)
    {
      i += 1;
      localObject2 = localObject1;
      break label46;
      label165:
      if (l >= paramInt1)
      {
        localObject1 = localObject2;
        if (l <= paramInt2) {
          break;
        }
      }
      y.d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", new Object[] { str, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      com.tencent.mm.vfs.e.deleteFile(str);
    }
  }
  
  public final void b(av.a parama)
  {
    y.d("MicroMsg.SpeexUploadCore", "pushWork");
    this.elq.c(parama);
  }
  
  public final void start()
  {
    if (!aq.isWifi(ae.getContext())) {
      return;
    }
    new ah(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public final void run()
      {
        Looper.myQueue().addIdleHandler(new e.2.1(this));
      }
    }, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.be.e
 * JD-Core Version:    0.7.0.1
 */