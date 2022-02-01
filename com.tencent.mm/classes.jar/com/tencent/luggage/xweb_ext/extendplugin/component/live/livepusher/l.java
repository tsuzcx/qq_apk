package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener;

public abstract interface l
  extends TXLivePusher.VideoCustomProcessListener
{
  public static final l cGz = new l()
  {
    public final void Qf() {}
    
    public final void Qg() {}
    
    public final void a(l.a paramAnonymousa, float paramAnonymousFloat) {}
    
    public final void a(l.b paramAnonymousb, String paramAnonymousString) {}
    
    public final void a(l.c paramAnonymousc, String paramAnonymousString) {}
    
    public final void b(String paramAnonymousString, float paramAnonymousFloat) {}
    
    public final void clearFilters() {}
    
    public final boolean isEnabled()
    {
      return false;
    }
    
    public final void onDetectFacePoints(float[] paramAnonymousArrayOfFloat) {}
    
    public final int onTextureCustomProcess(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      return 0;
    }
    
    public final void onTextureDestoryed() {}
  };
  
  public abstract void Qf();
  
  public abstract void Qg();
  
  public abstract void a(a parama, float paramFloat);
  
  public abstract void a(b paramb, String paramString);
  
  public abstract void a(c paramc, String paramString);
  
  public abstract void b(String paramString, float paramFloat);
  
  public abstract void clearFilters();
  
  public abstract boolean isEnabled();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(215628);
      cGA = new a("SKIN_BRIGHT", 0);
      cGB = new a("SKIN_SMOOTH", 1);
      cGC = new a("FACE_THIN", 2);
      cGD = new a("EYE_BIGGER", 3);
      cGE = new a[] { cGA, cGB, cGC, cGD };
      AppMethodBeat.o(215628);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(215631);
      cGF = new b("MAKEUP_LIP_STICK", 0);
      cGG = new b("MAKEUP_EYE_SHADOW", 1);
      cGH = new b("MAKEUP_BLUSHER_STICK", 2);
      cGI = new b("MAKEUP_FACE_CONTOUR", 3);
      cGJ = new b("MAKEUP_EYE_BROW", 4);
      cGK = new b[] { cGF, cGG, cGH, cGI, cGJ };
      AppMethodBeat.o(215631);
    }
    
    private b() {}
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(215634);
      cGL = new c("STICKER_BACK", 0);
      cGM = new c("STICKER_FRONT", 1);
      cGN = new c("STICKER_2D", 2);
      cGO = new c[] { cGL, cGM, cGN };
      AppMethodBeat.o(215634);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
 * JD-Core Version:    0.7.0.1
 */