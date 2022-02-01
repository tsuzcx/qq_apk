package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public final class kc
{
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(224904);
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("TMS_".concat(String.valueOf(paramString)), 0);
      AppMethodBeat.o(224904);
      return paramContext;
    }
    AppMethodBeat.o(224904);
    return null;
  }
  
  public static a a(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(224917);
    paramSharedPreferences = new a(paramSharedPreferences.edit());
    AppMethodBeat.o(224917);
    return paramSharedPreferences;
  }
  
  public static final class a
  {
    private SharedPreferences.Editor a;
    
    public a(SharedPreferences.Editor paramEditor)
    {
      this.a = paramEditor;
    }
    
    private void a(String paramString, float paramFloat)
    {
      AppMethodBeat.i(225594);
      this.a.putFloat(paramString, paramFloat);
      this.a.commit();
      AppMethodBeat.o(225594);
    }
    
    private void a(String paramString, int paramInt)
    {
      AppMethodBeat.i(225580);
      this.a.putInt(paramString, paramInt);
      this.a.commit();
      AppMethodBeat.o(225580);
    }
    
    private void a(String paramString, long paramLong)
    {
      AppMethodBeat.i(225596);
      this.a.putLong(paramString, paramLong);
      this.a.commit();
      AppMethodBeat.o(225596);
    }
    
    private void a(String paramString, Set<String> paramSet)
    {
      AppMethodBeat.i(225604);
      this.a.putStringSet(paramString, paramSet);
      this.a.commit();
      AppMethodBeat.o(225604);
    }
    
    private void a(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(225589);
      this.a.putBoolean(paramString, paramBoolean);
      this.a.commit();
      AppMethodBeat.o(225589);
    }
    
    public final void a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(225611);
      this.a.putString(paramString1, paramString2);
      this.a.commit();
      AppMethodBeat.o(225611);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kc
 * JD-Core Version:    0.7.0.1
 */