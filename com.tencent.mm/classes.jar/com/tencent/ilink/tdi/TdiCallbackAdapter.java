package com.tencent.ilink.tdi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class TdiCallbackAdapter
{
  private static HashMap<Long, m> m_callback_map;
  
  static
  {
    AppMethodBeat.i(214223);
    m_callback_map = new HashMap();
    AppMethodBeat.o(214223);
  }
  
  static m getCallback(long paramLong)
  {
    AppMethodBeat.i(213988);
    m localm = (m)m_callback_map.get(Long.valueOf(paramLong));
    AppMethodBeat.o(213988);
    return localm;
  }
  
  static void onAppSessionTimeout(long paramLong)
  {
    AppMethodBeat.i(214170);
    getCallback(paramLong);
    AppMethodBeat.o(214170);
  }
  
  static void onCancelOAuthComplete(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214094);
    getCallback(paramLong);
    AppMethodBeat.o(214094);
  }
  
  static void onCheckLoginQrCodeComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214063);
    if (getCallback(paramLong) != null) {
      try
      {
        b.d.M(paramArrayOfByte);
        AppMethodBeat.o(214063);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(214063);
  }
  
  static void onFaceExtVerifyComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214036);
    if (getCallback(paramLong) != null) {
      try
      {
        b.e.N(paramArrayOfByte);
        AppMethodBeat.o(214036);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(214036);
  }
  
  static void onFaceRecognizeComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214022);
    if (getCallback(paramLong) != null) {
      try
      {
        b.g.P(paramArrayOfByte);
        AppMethodBeat.o(214022);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(214022);
  }
  
  static void onFaceRecognizeConfigComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214009);
    if (getCallback(paramLong) != null) {
      try
      {
        b.f.O(paramArrayOfByte);
        AppMethodBeat.o(214009);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(214009);
  }
  
  static void onGetAppPushTokenComplete(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214189);
    if (getCallback(paramLong) != null) {
      try
      {
        b.b.K(paramArrayOfByte);
        AppMethodBeat.o(214189);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(214189);
  }
  
  static void onGetLoginQrCodeComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214048);
    if (getCallback(paramLong) != null) {
      try
      {
        b.h.Q(paramArrayOfByte);
        AppMethodBeat.o(214048);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(214048);
  }
  
  static void onGetOAuthCodeComplete(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214080);
    if (getCallback(paramLong) != null) {
      try
      {
        b.i.R(paramArrayOfByte);
        AppMethodBeat.o(214080);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(214080);
  }
  
  static void onLoginComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214111);
    if (getCallback(paramLong) != null) {
      try
      {
        b.j.S(paramArrayOfByte);
        AppMethodBeat.o(214111);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(214111);
  }
  
  static void onLogoutComplete(long paramLong, int paramInt)
  {
    AppMethodBeat.i(214123);
    getCallback(paramLong);
    AppMethodBeat.o(214123);
  }
  
  static void onReceiveAppMessage(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214153);
    if (getCallback(paramLong) != null) {
      try
      {
        b.a.J(paramArrayOfByte);
        AppMethodBeat.o(214153);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(214153);
  }
  
  static void onReceiveAppResponse(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214141);
    if (getCallback(paramLong) != null) {
      try
      {
        b.c.L(paramArrayOfByte);
        AppMethodBeat.o(214141);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(214141);
  }
  
  static void onRequestUploadLogfiles(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214205);
    getCallback(paramLong);
    AppMethodBeat.o(214205);
  }
  
  static void removeCallback(long paramLong)
  {
    AppMethodBeat.i(213999);
    m_callback_map.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(213999);
  }
  
  static void setCallback(long paramLong, m paramm)
  {
    AppMethodBeat.i(213978);
    m_callback_map.put(Long.valueOf(paramLong), paramm);
    AppMethodBeat.o(213978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.ilink.tdi.TdiCallbackAdapter
 * JD-Core Version:    0.7.0.1
 */