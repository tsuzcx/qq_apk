package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.ArrayList;

public final class a
{
  private static final String jOP = o.aOC() + "/fdv_v_";
  public static final String jOU = h.getExternalStorageDirectory().getAbsolutePath() + "/temp_debug_raw.spx";
  private com.tencent.mm.f.b.c.a bCP = new a.2(this);
  com.tencent.mm.f.b.c bCc;
  private int eLJ = 0;
  int eLK = 0;
  com.tencent.mm.f.c.a eLP;
  com.tencent.mm.modelvoiceaddr.a.c eLY;
  private com.tencent.mm.modelvoiceaddr.a.c.a eLZ = new com.tencent.mm.modelvoiceaddr.a.c.a()
  {
    public final void TA()
    {
      y.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSpeakToSilent");
    }
    
    public final void TB()
    {
      y.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSilentToSpeak");
      if (a.e(a.this) != null) {
        a.e(a.this).aOI();
      }
    }
    
    public final void b(short[] paramAnonymousArrayOfShort, int paramAnonymousInt)
    {
      y.d("MicroMsg.FaceVoiceRecordLogic", "onFilteredSpeakVoice data %s size %d", new Object[] { paramAnonymousArrayOfShort, Integer.valueOf(paramAnonymousInt) });
    }
    
    public final void tW()
    {
      y.d("MicroMsg.FaceVoiceRecordLogic", "Silent enough to finish");
      if (a.e(a.this) != null) {
        a.e(a.this).onError(11);
      }
    }
  };
  boolean eMz = true;
  a.b jOQ = null;
  boolean jOR = false;
  String jOS = "";
  ArrayList<com.tencent.mm.f.b.c.a> jOT = new ArrayList(5);
  public com.tencent.mm.f.b.c.a jOV = new a.1(this);
  
  public final void a(com.tencent.mm.f.b.c.a parama)
  {
    this.jOT.add(parama);
  }
  
  public final void aOH()
  {
    e.deleteFile(this.jOS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.a
 * JD-Core Version:    0.7.0.1
 */