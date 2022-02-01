package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener;

public abstract interface o
  extends TXLivePusher.VideoCustomProcessListener
{
  public static final o eAC = new o()
  {
    public final void a(o.a paramAnonymousa, float paramAnonymousFloat) {}
    
    public final void a(o.b paramAnonymousb, String paramAnonymousString) {}
    
    public final void a(o.c paramAnonymousc, String paramAnonymousString) {}
    
    public final void aul() {}
    
    public final void aum() {}
    
    public final void c(String paramAnonymousString, float paramAnonymousFloat) {}
    
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
  
  public abstract void a(a parama, float paramFloat);
  
  public abstract void a(b paramb, String paramString);
  
  public abstract void a(c paramc, String paramString);
  
  public abstract void aul();
  
  public abstract void aum();
  
  public abstract void c(String paramString, float paramFloat);
  
  public abstract void clearFilters();
  
  public abstract boolean isEnabled();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(220768);
      eAD = new a("SKIN_BRIGHT", 0);
      eAE = new a("SKIN_SMOOTH", 1);
      eAF = new a("FACE_THIN", 2);
      eAG = new a("EYE_BIGGER", 3);
      eAH = new a[] { eAD, eAE, eAF, eAG };
      AppMethodBeat.o(220768);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(220763);
      eAI = new b("MAKEUP_LIP_STICK", 0);
      eAJ = new b("MAKEUP_EYE_SHADOW", 1);
      eAK = new b("MAKEUP_BLUSHER_STICK", 2);
      eAL = new b("MAKEUP_FACE_CONTOUR", 3);
      eAM = new b("MAKEUP_EYE_BROW", 4);
      eAN = new b[] { eAI, eAJ, eAK, eAL, eAM };
      AppMethodBeat.o(220763);
    }
    
    private b() {}
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(220724);
      eAO = new c("STICKER_BACK", 0);
      eAP = new c("STICKER_FRONT", 1);
      eAQ = new c("STICKER_2D", 2);
      eAR = new c[] { eAO, eAP, eAQ };
      AppMethodBeat.o(220724);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o
 * JD-Core Version:    0.7.0.1
 */