package com.tencent.mm.plugin.ad.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
  implements a.a
{
  public Map<String, List<b.a>> bV = new HashMap();
  public List<String> eqn = new LinkedList();
  public ah hcZ = new ah(Looper.getMainLooper());
  public Map<String, Set<Integer>> njZ = new HashMap();
  String nka;
  a nkb;
  
  public final int a(d paramd)
  {
    this.hcZ.post(new b.3(this, paramd));
    return 0;
  }
  
  public final void a(String paramString, b.a parama, Set<Integer> paramSet)
  {
    y.i("MicroMsg.FileScanQueueService", "startDecodeBlockLoop, fileUri: %s, callback: %x", new Object[] { paramString, Integer.valueOf(parama.hashCode()) });
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.FileScanQueueService", "start failed, uri is null or nil");
      return;
    }
    this.hcZ.post(new b.1(this, paramString, parama, paramSet));
  }
  
  final void buv()
  {
    if (this.nkb != null)
    {
      y.d("MicroMsg.FileScanQueueService", "it is scanning");
      return;
    }
    if (this.bV.isEmpty())
    {
      y.d("MicroMsg.FileScanQueueService", "queue is empty");
      return;
    }
    this.nka = ((String)this.eqn.get(0));
    this.eqn.remove(0);
    this.nkb = new a();
    this.nkb.bWG = ((Set)this.njZ.get(this.nka));
    a locala = this.nkb;
    String str = this.nka;
    y.i("MicroMsg.scanner.DecodeFile", "start decode file: " + str);
    locala.njW = this;
    ai.d(new a.1(locala, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ad.a.b
 * JD-Core Version:    0.7.0.1
 */