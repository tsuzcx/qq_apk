package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    y.e("GcmRegister", "onCreate~~~threadID:" + Thread.currentThread());
    a locala = a.baB();
    if (locala != null) {
      locala.baD();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gcm.modelgcm.a.1
 * JD-Core Version:    0.7.0.1
 */