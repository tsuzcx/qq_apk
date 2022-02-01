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
  
  public abstract boolean div();
  
  public abstract boolean diw();
  
  public abstract void dix();
  
  public abstract b.b diy();
  
  public abstract b.a diz();
  
  public abstract void setBusinessTip(String paramString);
  
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
        parama = new d(parama.wwU);
        AppMethodBeat.o(103815);
        return parama;
      }
      Log.i(TAG, "hy: is normal");
      parama = new c(parama.nlB, parama.wwR);
      AppMethodBeat.o(103815);
      return parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.b
 * JD-Core Version:    0.7.0.1
 */