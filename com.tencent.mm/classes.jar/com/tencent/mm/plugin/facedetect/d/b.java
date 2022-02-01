package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.h.a;
import com.tencent.mm.sdk.platformtools.Log;

public abstract interface b
{
  public abstract void a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2);
  
  public abstract boolean a(FaceCharacteristicsResult paramFaceCharacteristicsResult);
  
  public abstract boolean b(FaceCharacteristicsResult paramFaceCharacteristicsResult);
  
  public abstract boolean dPg();
  
  public abstract boolean dPh();
  
  public abstract void dPi();
  
  public abstract b dPj();
  
  public abstract a dPk();
  
  public abstract void setBusinessTip(String paramString);
  
  public static final class a
  {
    public String errMsg;
    public int zUa;
    public int zUb;
    
    a()
    {
      this.zUa = 1;
    }
    
    a(String paramString)
    {
      this.zUb = 7;
      this.errMsg = paramString;
    }
  }
  
  public static class b
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
        Log.i(TAG, "hy: is read number");
        parama = new d(parama.zTa);
        AppMethodBeat.o(103815);
        return parama;
      }
      Log.i(TAG, "hy: is normal");
      parama = new c(parama.qiK, parama.zSX);
      AppMethodBeat.o(103815);
      return parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.b
 * JD-Core Version:    0.7.0.1
 */