package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.h.a;
import com.tencent.mm.sdk.platformtools.ad;

public abstract interface b
{
  public abstract void a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2);
  
  public abstract boolean a(FaceCharacteristicsResult paramFaceCharacteristicsResult);
  
  public abstract boolean b(FaceCharacteristicsResult paramFaceCharacteristicsResult);
  
  public abstract boolean ctt();
  
  public abstract boolean ctu();
  
  public abstract void ctv();
  
  public abstract b ctw();
  
  public abstract a ctx();
  
  public abstract void setBusinessTip(String paramString);
  
  public static final class a
  {
    public String errMsg;
    public int riw;
    public int rix;
    
    a()
    {
      this.riw = 1;
    }
    
    a(String paramString)
    {
      this.rix = 7;
      this.errMsg = paramString;
    }
  }
  
  public static final class b
  {
    public int errCode;
    public String errMsg;
    
    public b(int paramInt, String paramString)
    {
      this.errCode = paramInt;
      this.errMsg = paramString;
    }
  }
  
  public static final class c
  {
    private static String TAG = "MicroMsg.IFaceMotion.Factory";
    
    public static b a(h.a parama)
    {
      AppMethodBeat.i(103815);
      if (parama == null)
      {
        AppMethodBeat.o(103815);
        return null;
      }
      if (parama.type == 4)
      {
        ad.i(TAG, "hy: is read number");
        parama = new d(parama.rhw);
        AppMethodBeat.o(103815);
        return parama;
      }
      ad.i(TAG, "hy: is normal");
      parama = new c(parama.jsG, parama.rht);
      AppMethodBeat.o(103815);
      return parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.b
 * JD-Core Version:    0.7.0.1
 */