package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener;

public abstract interface m
  extends TXLivePusher.VideoCustomProcessListener
{
  public static final m cHf = new m()
  {
    public final void TG() {}
    
    public final void TH() {}
    
    public final void a(m.a paramAnonymousa, float paramAnonymousFloat) {}
    
    public final void a(m.b paramAnonymousb, String paramAnonymousString) {}
    
    public final void a(m.c paramAnonymousc, String paramAnonymousString) {}
    
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
  
  public abstract void TG();
  
  public abstract void TH();
  
  public abstract void a(a parama, float paramFloat);
  
  public abstract void a(b paramb, String paramString);
  
  public abstract void a(m.c paramc, String paramString);
  
  public abstract void b(String paramString, float paramFloat);
  
  public abstract void clearFilters();
  
  public abstract boolean isEnabled();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(224289);
      cHg = new a("SKIN_BRIGHT", 0);
      cHh = new a("SKIN_SMOOTH", 1);
      cHi = new a("FACE_THIN", 2);
      cHj = new a("EYE_BIGGER", 3);
      cHk = new a[] { cHg, cHh, cHi, cHj };
      AppMethodBeat.o(224289);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(224213);
      cHl = new b("MAKEUP_LIP_STICK", 0);
      cHm = new b("MAKEUP_EYE_SHADOW", 1);
      cHn = new b("MAKEUP_BLUSHER_STICK", 2);
      cHo = new b("MAKEUP_FACE_CONTOUR", 3);
      cHp = new b("MAKEUP_EYE_BROW", 4);
      cHq = new b[] { cHl, cHm, cHn, cHo, cHp };
      AppMethodBeat.o(224213);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m
 * JD-Core Version:    0.7.0.1
 */