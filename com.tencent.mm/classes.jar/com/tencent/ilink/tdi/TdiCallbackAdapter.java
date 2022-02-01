package com.tencent.ilink.tdi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class TdiCallbackAdapter
{
  private static HashMap<Long, m> m_callback_map;
  
  static
  {
    AppMethodBeat.i(218320);
    m_callback_map = new HashMap();
    AppMethodBeat.o(218320);
  }
  
  static m getCallback(long paramLong)
  {
    AppMethodBeat.i(218301);
    m localm = (m)m_callback_map.get(Long.valueOf(paramLong));
    AppMethodBeat.o(218301);
    return localm;
  }
  
  static void onAppSessionTimeout(long paramLong)
  {
    AppMethodBeat.i(218317);
    getCallback(paramLong);
    AppMethodBeat.o(218317);
  }
  
  static void onCancelOAuthComplete(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218312);
    getCallback(paramLong);
    AppMethodBeat.o(218312);
  }
  
  static void onCheckLoginQrCodeComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218310);
    if (getCallback(paramLong) != null) {
      try
      {
        b.d.N(paramArrayOfByte);
        AppMethodBeat.o(218310);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(218310);
  }
  
  static void onFaceExtVerifyComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218308);
    if (getCallback(paramLong) != null) {
      try
      {
        b.e.O(paramArrayOfByte);
        AppMethodBeat.o(218308);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(218308);
  }
  
  static void onFaceRecognizeComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218307);
    if (getCallback(paramLong) != null) {
      try
      {
        b.g.Q(paramArrayOfByte);
        AppMethodBeat.o(218307);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(218307);
  }
  
  static void onFaceRecognizeConfigComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218305);
    if (getCallback(paramLong) != null) {
      try
      {
        b.f.P(paramArrayOfByte);
        AppMethodBeat.o(218305);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(218305);
  }
  
  static void onGetAppPushTokenComplete(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218318);
    if (getCallback(paramLong) != null) {
      try
      {
        b.b.L(paramArrayOfByte);
        AppMethodBeat.o(218318);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(218318);
  }
  
  static void onGetLoginQrCodeComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218309);
    if (getCallback(paramLong) != null) {
      try
      {
        b.h.R(paramArrayOfByte);
        AppMethodBeat.o(218309);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(218309);
  }
  
  static void onGetOAuthCodeComplete(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218311);
    if (getCallback(paramLong) != null) {
      try
      {
        b.i.S(paramArrayOfByte);
        AppMethodBeat.o(218311);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(218311);
  }
  
  static void onLoginComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218313);
    if (getCallback(paramLong) != null) {
      try
      {
        b.j.T(paramArrayOfByte);
        AppMethodBeat.o(218313);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(218313);
  }
  
  static void onLogoutComplete(long paramLong, int paramInt)
  {
    AppMethodBeat.i(218314);
    getCallback(paramLong);
    AppMethodBeat.o(218314);
  }
  
  static void onReceiveAppMessage(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218316);
    if (getCallback(paramLong) != null) {
      try
      {
        b.a.K(paramArrayOfByte);
        AppMethodBeat.o(218316);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(218316);
  }
  
  static void onReceiveAppResponse(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218315);
    if (getCallback(paramLong) != null) {
      try
      {
        b.c.M(paramArrayOfByte);
        AppMethodBeat.o(218315);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(218315);
  }
  
  static void onRequestUploadLogfiles(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218319);
    getCallback(paramLong);
    AppMethodBeat.o(218319);
  }
  
  static void removeCallback(long paramLong)
  {
    AppMethodBeat.i(218303);
    m_callback_map.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(218303);
  }
  
  static void setCallback(long paramLong, m paramm)
  {
    AppMethodBeat.i(218300);
    m_callback_map.put(Long.valueOf(paramLong), paramm);
    AppMethodBeat.o(218300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.ilink.tdi.TdiCallbackAdapter
 * JD-Core Version:    0.7.0.1
 */