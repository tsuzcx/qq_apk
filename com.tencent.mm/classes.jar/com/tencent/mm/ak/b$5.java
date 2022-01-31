package com.tencent.mm.ak;

import com.tencent.mm.j.f;
import java.util.Map;
import java.util.Queue;

final class b$5
  implements Runnable
{
  b$5(b paramb, int paramInt, f paramf) {}
  
  public final void run()
  {
    if (this.eiO != -1) {
      this.eiN.eiJ.put(this.eiP.field_mediaId, Integer.valueOf(this.eiO));
    }
    this.eiN.eiG.add(this.eiP.field_mediaId);
    this.eiN.eiH.put(this.eiP.field_mediaId, this.eiP);
    this.eiN.bT(false);
  }
  
  public final String toString()
  {
    return super.toString() + "|addRecvTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ak.b.5
 * JD-Core Version:    0.7.0.1
 */