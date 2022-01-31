package com.tencent.mm.ak;

import com.tencent.mm.j.f;
import java.util.Map;
import java.util.Queue;

final class b$6
  implements Runnable
{
  b$6(b paramb, f paramf) {}
  
  public final void run()
  {
    this.eiN.eiG.add(this.eiP.field_mediaId);
    this.eiN.eiH.put(this.eiP.field_mediaId, this.eiP);
    this.eiN.bT(false);
  }
  
  public final String toString()
  {
    return super.toString() + "|addSendTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ak.b.6
 * JD-Core Version:    0.7.0.1
 */