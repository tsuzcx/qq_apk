package com.tencent.mm.plugin.d.a.b.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@TargetApi(18)
public class c
{
  public static final String TAG;
  private static HashMap<String, Long> phw;
  private static HashMap<String, Long> piF;
  
  static
  {
    AppMethodBeat.i(22578);
    TAG = c.class.getName();
    phw = new HashMap();
    HashMap localHashMap = new HashMap();
    piF = localHashMap;
    localHashMap.put(h.phL, Long.valueOf(1L));
    piF.put(h.phM, Long.valueOf(1L));
    piF.put(h.phN, Long.valueOf(16L));
    piF.put(h.phO, Long.valueOf(16L));
    piF.put(h.phP, Long.valueOf(16L));
    piF.put(h.phQ, Long.valueOf(16L));
    phw.put(h.phI, Long.valueOf(0L));
    phw.put(h.phR, Long.valueOf(2L));
    phw.put(h.phU, Long.valueOf(4L));
    phw.put(h.phY, Long.valueOf(8L));
    AppMethodBeat.o(22578);
  }
  
  public static String BA(long paramLong)
  {
    AppMethodBeat.i(22574);
    Object localObject = phw.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (((Long)phw.get(str)).longValue() == paramLong)
      {
        AppMethodBeat.o(22574);
        return str;
      }
    }
    if (piF.containsValue(Long.valueOf(paramLong)))
    {
      localObject = h.phI;
      AppMethodBeat.o(22574);
      return localObject;
    }
    AppMethodBeat.o(22574);
    return null;
  }
  
  public static long a(BluetoothGattService paramBluetoothGattService)
  {
    long l1 = 0L;
    AppMethodBeat.i(22575);
    if (paramBluetoothGattService == null)
    {
      Log.e(TAG, "service is null");
      AppMethodBeat.o(22575);
      return 0L;
    }
    Object localObject = paramBluetoothGattService.getUuid().toString();
    if ((((String)localObject).equalsIgnoreCase(h.phI)) && (paramBluetoothGattService.getCharacteristic(UUID.fromString(h.phL)) != null))
    {
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristics();
      l1 = 0L;
      int i = 0;
      if (i < paramBluetoothGattService.size())
      {
        localObject = ((BluetoothGattCharacteristic)paramBluetoothGattService.get(i)).getUuid().toString();
        localObject = (Long)piF.get(localObject);
        if (localObject == null) {}
        for (long l2 = 0L;; l2 = ((Long)localObject).longValue())
        {
          i += 1;
          l1 = l2 | l1;
          break;
        }
      }
      Log.d(TAG, "wechat service, profileType = %d", new Object[] { Long.valueOf(l1) });
      AppMethodBeat.o(22575);
      return l1;
    }
    paramBluetoothGattService = (Long)phw.get(localObject);
    if (paramBluetoothGattService == null) {}
    for (;;)
    {
      Log.d(TAG, "service uuid = %s, profileType = %d", new Object[] { localObject, Long.valueOf(l1) });
      AppMethodBeat.o(22575);
      return l1;
      l1 = paramBluetoothGattService.longValue();
    }
  }
  
  public static byte[] a(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, byte[] paramArrayOfByte)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    AppMethodBeat.i(22577);
    if ((paramBluetoothGattCharacteristic == null) || (paramArrayOfByte == null))
    {
      Log.e(TAG, "characteristic or recvData is null");
      AppMethodBeat.o(22577);
      return null;
    }
    long l = 0L;
    Object localObject1 = paramBluetoothGattCharacteristic.getUuid().toString();
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getService();
    Object localObject2;
    if (paramBluetoothGattCharacteristic != null)
    {
      l = a(paramBluetoothGattCharacteristic);
      Log.d(TAG, "recv data. uuid = %s, data = %s", new Object[] { localObject1, com.tencent.mm.plugin.exdevice.k.b.bw(paramArrayOfByte) });
      if ((0L == (1L & l)) || ((!((String)localObject1).equalsIgnoreCase(f.pjh)) && (!((String)localObject1).equalsIgnoreCase(f.pji)))) {
        break label504;
      }
      localObject2 = new f();
      if ((paramArrayOfByte.length > 0) && ((paramArrayOfByte[0] & 0x1) != 0)) {
        break label225;
      }
      Log.e(f.TAG, "pase step data error");
      i = 0;
      label151:
      if (i == 0) {
        break label491;
      }
      paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.de(localObject2);
      Log.d(TAG, "step info. stepCount=%d, stepDistance=%d, stepColarie=%d", new Object[] { Integer.valueOf(((f)localObject2).pjj), Integer.valueOf(((f)localObject2).pjk), Integer.valueOf(((f)localObject2).pjl) });
    }
    for (;;)
    {
      AppMethodBeat.o(22577);
      return paramBluetoothGattCharacteristic;
      Log.e(TAG, "the characteristic has no parent service");
      break;
      label225:
      if ((localObject1 == null) || ((!((String)localObject1).equals(f.pjh)) && (!((String)localObject1).equals(f.pji))))
      {
        Log.e(f.TAG, "uuid is not correct");
        i = 0;
        break label151;
      }
      ((f)localObject2).pie = ((String)localObject1);
      i = 4;
      if ((paramArrayOfByte[0] & 0x2) != 0) {
        i = 7;
      }
      j = i;
      if ((paramArrayOfByte[0] & 0x4) != 0) {
        j = i + 3;
      }
      if (j > paramArrayOfByte.length)
      {
        Log.e(f.TAG, "data len is not enough");
        i = 0;
        break label151;
      }
      ((f)localObject2).pjj = 0;
      j = 0;
      i = 1;
      while (j < 3)
      {
        ((f)localObject2).pjj += ((paramArrayOfByte[i] & 0xFF) << j * 8);
        i += 1;
        j += 1;
      }
      j = i;
      if ((paramArrayOfByte[0] & 0x2) != 0)
      {
        ((f)localObject2).pjk = 0;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= 3) {
            break;
          }
          ((f)localObject2).pjk += ((paramArrayOfByte[i] & 0xFF) << k * 8);
          i += 1;
          k += 1;
        }
      }
      if ((paramArrayOfByte[0] & 0x4) != 0)
      {
        ((f)localObject2).pjl = 0;
        i = 0;
        while (i < 3)
        {
          ((f)localObject2).pjl += ((paramArrayOfByte[j] & 0xFF) << i * 8);
          j += 1;
          i += 1;
        }
      }
      i = 1;
      break label151;
      label491:
      Log.e(TAG, "parse step data error");
      paramBluetoothGattCharacteristic = null;
    }
    label504:
    boolean bool;
    if ((0L != (0x2 & l)) && ((((String)localObject1).equalsIgnoreCase(g.phT)) || (((String)localObject1).equalsIgnoreCase(g.phS))))
    {
      localObject2 = new g();
      if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
      {
        Log.e(g.TAG, "characteristicUuid or data is null or nil");
        i = 0;
      }
      label912:
      label918:
      label924:
      label931:
      label938:
      for (;;)
      {
        label579:
        if (i != 0)
        {
          paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.de(localObject2);
          Log.d(TAG, "weight info. weight = %d", new Object[] { Integer.valueOf(((g)localObject2).pjp.JF) });
          break;
          ((g)localObject2).pie = ((String)localObject1);
          if (((g)localObject2).pie.equalsIgnoreCase(g.phS))
          {
            if (4 > paramArrayOfByte.length)
            {
              Log.e(g.TAG, "weight scale feature characteristic data is a 32bit value, but current value len is %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
              i = 0;
              continue;
            }
            ((g)localObject2).pjo = new g.c();
            paramBluetoothGattCharacteristic = ((g)localObject2).pjo;
            if ((paramArrayOfByte[0] & 0x1) != 0)
            {
              bool = true;
              paramBluetoothGattCharacteristic.pjt = bool;
              paramBluetoothGattCharacteristic = ((g)localObject2).pjo;
              if ((paramArrayOfByte[0] & 0x2) == 0) {
                break label912;
              }
              bool = true;
              paramBluetoothGattCharacteristic.pju = bool;
              paramBluetoothGattCharacteristic = ((g)localObject2).pjo;
              if ((paramArrayOfByte[0] & 0x4) == 0) {
                break label918;
              }
              bool = true;
              paramBluetoothGattCharacteristic.pjv = bool;
              ((g)localObject2).pjo.pjw = ((byte)((paramArrayOfByte[0] & 0x78) >> 3));
              ((g)localObject2).pjo.pjx = ((byte)(((paramArrayOfByte[0] & 0x80) >> 7) + ((paramArrayOfByte[1] & 0x3) << 1)));
              str = g.TAG;
              if (!((g)localObject2).pjo.pjt) {
                break label924;
              }
              paramBluetoothGattCharacteristic = "true";
              if (!((g)localObject2).pjo.pju) {
                break label931;
              }
              paramArrayOfByte = "true";
              if (!((g)localObject2).pjo.pjv) {
                break label938;
              }
              localObject1 = "true";
              Log.d(str, "timestampSupported = %s, multipleUsersSupported = %s, BMISupported = %s, weightResolution = %d, heightResolution = %d", new Object[] { paramBluetoothGattCharacteristic, paramArrayOfByte, localObject1, Byte.valueOf(((g)localObject2).pjo.pjw), Byte.valueOf(((g)localObject2).pjo.pjx) });
            }
          }
          while (!((g)localObject2).pie.equalsIgnoreCase(g.phT)) {
            for (;;)
            {
              String str;
              i = 1;
              break;
              bool = false;
              continue;
              bool = false;
              continue;
              bool = false;
              continue;
              paramBluetoothGattCharacteristic = "false";
              continue;
              paramArrayOfByte = "false";
              continue;
              localObject1 = "false";
            }
          }
          k = paramArrayOfByte[0];
          if ((k & 0x2) == 0) {
            break label3923;
          }
        }
      }
    }
    label1069:
    label1594:
    label2897:
    label3923:
    for (j = 10;; j = 3)
    {
      i = j;
      if ((k & 0x4) != 0) {
        i = j + 1;
      }
      j = i;
      if ((k & 0x8) != 0) {
        j = i + 4;
      }
      if (j > paramArrayOfByte.length)
      {
        Log.e(g.TAG, "data len is not enough for parse. current len = %d, needed len = %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(j) });
        i = 0;
        break label579;
      }
      ((g)localObject2).pjp = new g.b();
      paramBluetoothGattCharacteristic = ((g)localObject2).pjp;
      if ((k & 0x1) != 0)
      {
        bool = true;
        paramBluetoothGattCharacteristic.pjq = bool;
        ((g)localObject2).pjp.JF = ((paramArrayOfByte[1] & 0xFF) + ((paramArrayOfByte[2] & 0xFF) << 8));
        if ((k & 0x2) == 0) {
          break label3918;
        }
        ((g)localObject2).pjp.pjr = new g.a();
        paramBluetoothGattCharacteristic = ((g)localObject2).pjp.pjr;
        localObject1 = g.TAG;
        if (paramArrayOfByte != null) {
          break label1423;
        }
        i = 0;
        label1143:
        Log.d((String)localObject1, "data size = %d, offset = %d, lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(3), Integer.valueOf(7) });
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 10)) {
          break label1429;
        }
        Log.e(g.TAG, "data input error");
      }
      for (i = 10;; i = 3)
      {
        j = i;
        if ((k & 0x4) != 0)
        {
          ((g)localObject2).pjp.piv = (paramArrayOfByte[i] & 0xFF);
          j = i + 1;
        }
        if ((k & 0x8) != 0)
        {
          ((g)localObject2).pjp.pjs = ((paramArrayOfByte[j] & 0xFF) + ((paramArrayOfByte[(j + 1)] & 0xFF) << 8));
          i = j + 2;
          paramBluetoothGattCharacteristic = ((g)localObject2).pjp;
          j = paramArrayOfByte[i];
          paramBluetoothGattCharacteristic.mHeight = (((paramArrayOfByte[(i + 1)] & 0xFF) << 8) + (j & 0xFF));
        }
        localObject1 = g.TAG;
        if (((g)localObject2).pjp.pjq)
        {
          paramBluetoothGattCharacteristic = "lb&inch";
          i = ((g)localObject2).pjp.JF;
          if (((g)localObject2).pjp.pjr != null) {
            break label1594;
          }
        }
        for (paramArrayOfByte = "null";; paramArrayOfByte = "object")
        {
          Log.d((String)localObject1, "WeightAndHeightUnit = %s, Weight = %d, TimeStamp = %s, UserId = %d, BMI = %d, Height = %d", new Object[] { paramBluetoothGattCharacteristic, Integer.valueOf(i), paramArrayOfByte, Integer.valueOf(((g)localObject2).pjp.piv), Integer.valueOf(((g)localObject2).pjp.pjs), Integer.valueOf(((g)localObject2).pjp.mHeight) });
          break;
          bool = false;
          break label1069;
          i = paramArrayOfByte.length;
          break label1143;
          paramBluetoothGattCharacteristic.mYear = ((paramArrayOfByte[3] & 0xFF) + ((paramArrayOfByte[4] & 0xFF) << 8));
          paramBluetoothGattCharacteristic.mMonth = (paramArrayOfByte[5] & 0xFF);
          paramBluetoothGattCharacteristic.mDay = (paramArrayOfByte[6] & 0xFF);
          paramBluetoothGattCharacteristic.piC = (paramArrayOfByte[7] & 0xFF);
          paramBluetoothGattCharacteristic.piD = (paramArrayOfByte[8] & 0xFF);
          paramBluetoothGattCharacteristic.piE = (paramArrayOfByte[9] & 0xFF);
          Log.d(g.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[] { Integer.valueOf(paramBluetoothGattCharacteristic.mYear), Integer.valueOf(paramBluetoothGattCharacteristic.mMonth), Integer.valueOf(paramBluetoothGattCharacteristic.mDay), Integer.valueOf(paramBluetoothGattCharacteristic.piC), Integer.valueOf(paramBluetoothGattCharacteristic.piD), Integer.valueOf(paramBluetoothGattCharacteristic.piE) });
          break label1197;
          paramBluetoothGattCharacteristic = "kg&meter";
          break label1320;
        }
        Log.e(TAG, "parse weight scale data error");
        paramBluetoothGattCharacteristic = null;
        break;
        int m;
        if ((0L != (0x4 & l)) && ((((String)localObject1).equalsIgnoreCase(d.pig)) || (((String)localObject1).equalsIgnoreCase(d.piG)) || (((String)localObject1).equalsIgnoreCase(d.piH))))
        {
          paramBluetoothGattCharacteristic = new d();
          if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null)) {
            Log.e(d.TAG, "characteristicUuid or data is null");
          }
          for (;;)
          {
            if (i != 0)
            {
              paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.de(paramBluetoothGattCharacteristic);
              break;
              paramBluetoothGattCharacteristic.pie = ((String)localObject1);
              k = paramArrayOfByte.length;
              if (paramBluetoothGattCharacteristic.pie.equalsIgnoreCase(d.pig))
              {
                if (paramArrayOfByte.length < 2)
                {
                  Log.e(d.TAG, "Received data length is not right:".concat(String.valueOf(k)));
                  continue;
                }
                paramBluetoothGattCharacteristic.piO = new d.a(paramBluetoothGattCharacteristic);
                m = paramArrayOfByte[0];
                Log.d(d.TAG, "flag=".concat(String.valueOf(m)));
                if (((m & 0x1) == 1) && (k >= 3))
                {
                  Log.d(d.TAG, "Value Format = uint16");
                  i = paramArrayOfByte[2];
                  paramBluetoothGattCharacteristic.piO.piP = ((i << 8 & 0xFF00 & 0xFF00) + (paramArrayOfByte[1] & 0xFF));
                  i = 3;
                  Log.v(d.TAG, "Data received from HR " + paramBluetoothGattCharacteristic.piO.piP);
                  if ((m & 0x6) != 4) {
                    break label2156;
                  }
                  Log.d(d.TAG, "Sensor Contact feature is supported, but contact is not detected");
                  paramBluetoothGattCharacteristic.piO.piQ = 1;
                  j = i;
                  if ((m & 0x8) == 8)
                  {
                    j = i;
                    if (k >= i + 2)
                    {
                      Log.d(d.TAG, "Energy Expend Present");
                      j = paramArrayOfByte[(i + 1)] << 8 & 0xFF00;
                      paramBluetoothGattCharacteristic.piO.piR = ((paramArrayOfByte[i] & 0xFF) + (j & 0xFF00));
                      Log.v("H7ConnectThread", "energyExp from HR energyExph " + j + " " + paramBluetoothGattCharacteristic.piO.piR);
                      j = i + 2;
                    }
                  }
                  if (((m & 0x10) == 16) && (k >= j + 2))
                  {
                    Log.d(d.TAG, "RR Interval Present");
                    i = (paramArrayOfByte[(j + 1)] & 0xFF) << 8;
                    paramBluetoothGattCharacteristic.piO.piS = ((paramArrayOfByte[j] & 0xFF) + (i & 0xFF00));
                    Log.v(d.TAG, "rrInterval from HR rrIntervalh" + i + " " + paramBluetoothGattCharacteristic.piO.piS);
                  }
                }
              }
              label2156:
              while (!paramBluetoothGattCharacteristic.pie.equalsIgnoreCase(d.piG)) {
                for (;;)
                {
                  i = 1;
                  break;
                  if (k >= 2)
                  {
                    Log.d(d.TAG, "Value Format = uint8");
                    paramBluetoothGattCharacteristic.piO.piP = (paramArrayOfByte[1] & 0xFF);
                    i = 2;
                  }
                  else
                  {
                    Log.d(d.TAG, "receive data error");
                    break;
                    if ((m & 0x6) == 6)
                    {
                      Log.d(d.TAG, "Sensor Contact feature is supported and contact is detected");
                      paramBluetoothGattCharacteristic.piO.piQ = 2;
                    }
                    else
                    {
                      Log.d(d.TAG, "Sensor Contact feature is not supported in the current connection");
                      paramBluetoothGattCharacteristic.piO.piQ = 0;
                    }
                  }
                }
              }
              switch (paramArrayOfByte[0])
              {
              default: 
                paramBluetoothGattCharacteristic.piN = "Unknown";
              }
              for (;;)
              {
                Log.d(d.TAG, "position=" + paramBluetoothGattCharacteristic.piN);
                break;
                paramBluetoothGattCharacteristic.piN = "Other";
                continue;
                paramBluetoothGattCharacteristic.piN = "Chest";
                continue;
                paramBluetoothGattCharacteristic.piN = "Wrist";
                continue;
                paramBluetoothGattCharacteristic.piN = "Finger";
                continue;
                paramBluetoothGattCharacteristic.piN = "Hand";
                continue;
                paramBluetoothGattCharacteristic.piN = "Ear Lobe";
                continue;
                paramBluetoothGattCharacteristic.piN = "Foot";
              }
            }
          }
          Log.e(TAG, "parse heart rate data error");
          paramBluetoothGattCharacteristic = null;
          break;
        }
        if ((0L != (0x8 & l)) && ((((String)localObject1).equalsIgnoreCase(b.pig)) || (((String)localObject1).equalsIgnoreCase(b.pih)) || (((String)localObject1).equalsIgnoreCase(b.pii))))
        {
          paramBluetoothGattCharacteristic = new b();
          if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null))
          {
            Log.e(b.TAG, "characteristicUuid or data is null");
            i = j;
          }
          for (;;)
          {
            if (i != 0)
            {
              paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.de(paramBluetoothGattCharacteristic);
              break;
              paramBluetoothGattCharacteristic.pie = ((String)localObject1);
              k = paramArrayOfByte.length;
              if (paramBluetoothGattCharacteristic.pie.equalsIgnoreCase(b.pig))
              {
                if (k < 7)
                {
                  Log.e(b.TAG, "data len is not right.");
                  i = j;
                  continue;
                }
                paramBluetoothGattCharacteristic.pip = new b.b(paramBluetoothGattCharacteristic);
                m = paramArrayOfByte[0];
                Log.d(b.TAG, "flag=".concat(String.valueOf(m)));
                if ((m & 0x1) != 0)
                {
                  Log.d(b.TAG, "the value unit is kPa.");
                  paramBluetoothGattCharacteristic.pip.pis = true;
                  paramBluetoothGattCharacteristic.pip.piz = b.O(paramArrayOfByte, 1);
                  paramBluetoothGattCharacteristic.pip.piA = b.O(paramArrayOfByte, 3);
                  paramBluetoothGattCharacteristic.pip.piB = b.O(paramArrayOfByte, 5);
                  i = 7;
                  if (((m & 0x2) == 0) || (k < 14)) {
                    break label2897;
                  }
                  Log.d(b.TAG, "TimeStamp Present.");
                  paramBluetoothGattCharacteristic.pip.pix.P(paramArrayOfByte, 7);
                  i = 14;
                  label2657:
                  if (((m & 0x4) == 0) || (k < i + 2)) {
                    break label2909;
                  }
                  Log.d(b.TAG, "PulseRate Present.");
                  paramBluetoothGattCharacteristic.pip.piu = ((int)b.O(paramArrayOfByte, i));
                  i += 2;
                  Log.d(b.TAG, "PulseRate =" + paramBluetoothGattCharacteristic.pip.piu);
                  if ((m & 0x8) == 0) {
                    break label2921;
                  }
                  Log.d(b.TAG, "UserId Present.");
                  localObject1 = paramBluetoothGattCharacteristic.pip;
                  j = i + 1;
                  ((b.b)localObject1).piv = paramArrayOfByte[i];
                  Log.d(b.TAG, "UserId = " + paramBluetoothGattCharacteristic.pip.piv);
                  i = j;
                  label2793:
                  if ((m & 0x10) == 0) {
                    break label2933;
                  }
                  Log.d(b.TAG, "MeasurementStatus Present.");
                  j = paramArrayOfByte[(i + 1)];
                  paramBluetoothGattCharacteristic.pip.piw = ((paramArrayOfByte[i] & 0xFF) + (j << 8 & 0xFF00 & 0xFF00));
                  Log.d(b.TAG, "MeasurementStatus = " + paramBluetoothGattCharacteristic.pip.piw);
                }
              }
              for (;;)
              {
                i = 1;
                break;
                Log.d(b.TAG, "the value unit is mmHg.");
                paramBluetoothGattCharacteristic.pip.pis = false;
                break label2578;
                Log.d(b.TAG, "TimeStamp not Present.");
                break label2657;
                label2909:
                Log.d(b.TAG, "PulseRate not Present.");
                break label2727;
                label2921:
                Log.d(b.TAG, "UserId not Present.");
                break label2793;
                label2933:
                Log.d(b.TAG, "MeasurementStatus not Present.");
                continue;
                if (paramBluetoothGattCharacteristic.pie.equalsIgnoreCase(b.pih))
                {
                  if (k < 3)
                  {
                    Log.e(b.TAG, "data len is not right.");
                    i = j;
                    break;
                  }
                  paramBluetoothGattCharacteristic.piq = new b.a(paramBluetoothGattCharacteristic);
                  m = paramArrayOfByte[0];
                  Log.d(b.TAG, "flag=".concat(String.valueOf(m)));
                  if ((m & 0x1) != 0)
                  {
                    Log.d(b.TAG, "the value unit is kPa.");
                    paramBluetoothGattCharacteristic.piq.pis = true;
                    label3036:
                    paramBluetoothGattCharacteristic.piq.pit = b.O(paramArrayOfByte, 1);
                    if (((m & 0x2) == 0) || (k < 10)) {
                      break label3325;
                    }
                    Log.d(b.TAG, "TimeStamp Present.");
                    paramBluetoothGattCharacteristic.piq.pix.P(paramArrayOfByte, 3);
                    i = 10;
                    if (((m & 0x4) == 0) || (k < i + 2)) {
                      break label3339;
                    }
                    Log.d(b.TAG, "PulseRate Present.");
                    paramBluetoothGattCharacteristic.piq.piu = ((int)b.O(paramArrayOfByte, i));
                    i += 2;
                    Log.d(b.TAG, "PulseRate =" + paramBluetoothGattCharacteristic.piq.piu);
                    label3157:
                    if ((m & 0x8) == 0) {
                      break label3351;
                    }
                    Log.d(b.TAG, "UserId Present.");
                    localObject1 = paramBluetoothGattCharacteristic.piq;
                    j = i + 1;
                    ((b.a)localObject1).piv = paramArrayOfByte[i];
                    Log.d(b.TAG, "UserId = " + paramBluetoothGattCharacteristic.piq.piv);
                    i = j;
                  }
                  for (;;)
                  {
                    if ((m & 0x10) == 0) {
                      break label3363;
                    }
                    Log.d(b.TAG, "MeasurementStatus Present.");
                    j = paramArrayOfByte[(i + 1)];
                    paramBluetoothGattCharacteristic.piq.piw = ((paramArrayOfByte[i] & 0xFF) + (j << 8 & 0xFF00 & 0xFF00));
                    Log.d(b.TAG, "MeasurementStatus = " + paramBluetoothGattCharacteristic.piq.piw);
                    break;
                    Log.d(b.TAG, "the value unit is mmHg.");
                    paramBluetoothGattCharacteristic.piq.pis = false;
                    break label3036;
                    label3325:
                    Log.d(b.TAG, "TimeStamp not Present.");
                    i = 3;
                    break label3087;
                    Log.d(b.TAG, "PulseRate not Present.");
                    break label3157;
                    Log.d(b.TAG, "UserId not Present.");
                  }
                  Log.d(b.TAG, "MeasurementStatus not Present.");
                  continue;
                }
                if (paramBluetoothGattCharacteristic.pie.equalsIgnoreCase(b.pii))
                {
                  Log.d(b.TAG, "Blood Pressure Feature Characteristic.");
                  if (k < 2)
                  {
                    Log.e(b.TAG, "data len is not right.");
                    i = j;
                    break;
                  }
                  paramBluetoothGattCharacteristic.pir = ((paramArrayOfByte[1] << 8 & 0xFF00 & 0xFF00) + (paramArrayOfByte[0] & 0xFF));
                  Log.d(b.TAG, "bloodPressureFeatureParameters=" + paramBluetoothGattCharacteristic.pir);
                }
              }
            }
          }
          Log.e(TAG, "parse blood pressure data error");
          paramBluetoothGattCharacteristic = null;
          break;
        }
        if ((0L != (l & 0x10)) && ((((String)localObject1).equalsIgnoreCase(e.piU)) || (((String)localObject1).equalsIgnoreCase(e.piV)) || (((String)localObject1).equalsIgnoreCase(e.piW)) || (((String)localObject1).equalsIgnoreCase(e.piX))))
        {
          paramBluetoothGattCharacteristic = new e();
          if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null))
          {
            Log.e(e.TAG, "characteristicUuid or data is null");
            i = k;
          }
          for (;;)
          {
            if (i == 0) {
              break label3881;
            }
            paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.de(paramBluetoothGattCharacteristic);
            break;
            paramBluetoothGattCharacteristic.pie = ((String)localObject1);
            if (paramBluetoothGattCharacteristic.pie.equalsIgnoreCase(e.piU))
            {
              if (paramArrayOfByte.length != 3)
              {
                Log.e(e.TAG, "Data length incorrect");
                i = k;
              }
              else
              {
                paramBluetoothGattCharacteristic.piY = paramArrayOfByte[0];
                paramBluetoothGattCharacteristic.piZ = paramArrayOfByte[1];
                paramBluetoothGattCharacteristic.pja = paramArrayOfByte[2];
              }
            }
            else
            {
              for (;;)
              {
                i = 1;
                break;
                if (paramBluetoothGattCharacteristic.pie.equalsIgnoreCase(e.piV))
                {
                  if (paramArrayOfByte.length != 1)
                  {
                    Log.e(e.TAG, "Data length incorrect");
                    i = k;
                    break;
                  }
                  paramBluetoothGattCharacteristic.pjb = paramArrayOfByte[0];
                  continue;
                }
                if (paramBluetoothGattCharacteristic.pie.equalsIgnoreCase(e.piW))
                {
                  if (paramArrayOfByte.length < 2)
                  {
                    Log.e(e.TAG, "Data length incorrect");
                    i = k;
                    break;
                  }
                  paramBluetoothGattCharacteristic.pjc[0] = paramArrayOfByte[0];
                  paramBluetoothGattCharacteristic.pjc[1] = paramArrayOfByte[1];
                  continue;
                }
                if (!paramBluetoothGattCharacteristic.pie.equalsIgnoreCase(e.piX)) {
                  break label3866;
                }
                if (paramArrayOfByte.length < 4)
                {
                  Log.e(e.TAG, "Data length incorrect");
                  i = k;
                  break;
                }
                paramBluetoothGattCharacteristic.pjd = ((paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8));
                paramBluetoothGattCharacteristic.pjf = paramArrayOfByte[2];
                paramBluetoothGattCharacteristic.pje = paramArrayOfByte[3];
                if (paramArrayOfByte.length > 4)
                {
                  paramBluetoothGattCharacteristic.pjg = new byte[paramArrayOfByte.length - 4];
                  System.arraycopy(paramArrayOfByte, 4, paramBluetoothGattCharacteristic.pjg, 0, paramArrayOfByte.length - 4);
                }
                else
                {
                  paramBluetoothGattCharacteristic.pjg = null;
                }
              }
              Log.e(e.TAG, "characteristicUuid is incorrect");
              i = k;
            }
          }
          Log.e(TAG, "parse light data error");
          paramBluetoothGattCharacteristic = null;
          break;
        }
        Log.e(TAG, "unknown characteristic uuid = %s", new Object[] { localObject1 });
        paramBluetoothGattCharacteristic = null;
        break;
      }
    }
  }
  
  public static boolean aY(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22573);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e(TAG, "parseBroadcastServiceUuid error. broadcast data is null or nil");
      AppMethodBeat.o(22573);
      return false;
    }
    int i = 0;
    int j;
    int m;
    label204:
    Object localObject;
    while ((i >= 0) && (i < paramArrayOfByte.length))
    {
      int k = i + 1;
      i = paramArrayOfByte[i];
      if (k + i > paramArrayOfByte.length)
      {
        Log.w(TAG, "broadcast data len is not enough. offset = %d, current len = %d, broadcast len = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(paramArrayOfByte.length) });
        AppMethodBeat.o(22573);
        return false;
      }
      if (i <= 0)
      {
        Log.w(TAG, "current part of data's len = %d.", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(22573);
        return false;
      }
      j = k + 1;
      int n = paramArrayOfByte[k];
      m = i - 1;
      i = m;
      k = j;
      switch (n)
      {
      case 0: 
      case 1: 
      case 4: 
      case 5: 
      default: 
        i = m + j;
        break;
      case 2: 
      case 3: 
        while (2 <= i)
        {
          m = k + 1;
          j = paramArrayOfByte[k];
          k = m + 1;
          m = paramArrayOfByte[m];
          i -= 2;
          localObject = String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[] { Integer.valueOf((m & 0xFF) << 8 | j & 0xFF) });
          Log.d(TAG, "find 16-bit broacast service = %s", new Object[] { localObject });
          if (phw.containsKey(localObject))
          {
            AppMethodBeat.o(22573);
            return true;
          }
        }
        i += k;
        continue;
        j += 16;
        i -= 16;
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (16 <= i) {
          try
          {
            localObject = ByteBuffer.wrap(paramArrayOfByte, j, 16).order(ByteOrder.LITTLE_ENDIAN);
            long l = ((ByteBuffer)localObject).getLong();
            localObject = new UUID(((ByteBuffer)localObject).getLong(), l).toString();
            Log.d(TAG, "find 128-bit broacast service = %s", new Object[] { localObject });
            boolean bool = phw.containsKey(localObject);
            if (!bool) {
              break;
            }
            return true;
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
          {
            Log.e("BlueToothDeviceFilter.parseUUID", localIndexOutOfBoundsException.toString());
            j += 16;
            i -= 16;
          }
          finally
          {
            AppMethodBeat.o(22573);
          }
        }
      }
      i = j + i;
      break;
      Log.i(TAG, "Manufacturer Specific Data size = %s", new Object[] { Integer.valueOf(m) });
      Log.i(TAG, "Manufacturer Specific Data = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.bw(Arrays.copyOfRange(paramArrayOfByte, j, j + m)) });
      break label204;
      AppMethodBeat.o(22573);
      return false;
      i = m;
    }
  }
  
  public static boolean b(BluetoothGattService paramBluetoothGattService)
  {
    AppMethodBeat.i(22576);
    if (paramBluetoothGattService == null)
    {
      Log.e(TAG, "service is null");
      AppMethodBeat.o(22576);
      return false;
    }
    long l = a(paramBluetoothGattService);
    BluetoothGattCharacteristic localBluetoothGattCharacteristic;
    int i;
    if (0L != (1L & l))
    {
      if (paramBluetoothGattService == null)
      {
        Log.e(TAG, "service is null");
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.phL));
      if (localBluetoothGattCharacteristic == null)
      {
        Log.e(TAG, "no step measurement characteristic found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      Log.d(TAG, "step measurement characteristic properties = %d", new Object[] { Integer.valueOf(i) });
      if (((i & 0x30) == 0) || ((i & 0x2) == 0))
      {
        Log.e(TAG, "step measurement characteristic has incorrect proterties(%d)", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(22576);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.phM));
      if (paramBluetoothGattService != null)
      {
        i = paramBluetoothGattService.getProperties();
        if (((i & 0x2) == 0) || ((i & 0x20) == 0))
        {
          Log.e(TAG, "step target characteristic has incorrect proterties(%d)", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(22576);
          return false;
        }
      }
      AppMethodBeat.o(22576);
      return true;
    }
    if (0L != (0x2 & l))
    {
      if (paramBluetoothGattService == null)
      {
        Log.e(TAG, "service is null");
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.phS));
      if (localBluetoothGattCharacteristic == null)
      {
        Log.e(TAG, "weight scale feature characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x2) == 0)
      {
        Log.e(TAG, "weight scale feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        AppMethodBeat.o(22576);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.phT));
      if (paramBluetoothGattService == null)
      {
        Log.e(TAG, "weight measurement characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = paramBluetoothGattService.getProperties();
      if ((i & 0x20) == 0)
      {
        Log.e(TAG, "weight measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      AppMethodBeat.o(22576);
      return true;
    }
    if (0L != (0x4 & l))
    {
      if (paramBluetoothGattService == null)
      {
        Log.e(TAG, "service is null");
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.phV));
      if (localBluetoothGattCharacteristic == null)
      {
        Log.e(TAG, "heart rate measurement characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x10) == 0)
      {
        Log.e(TAG, "heart rate measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(16) });
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.phW));
      if (localBluetoothGattCharacteristic != null)
      {
        i = localBluetoothGattCharacteristic.getProperties();
        if ((i & 0x2) == 0)
        {
          Log.e(TAG, "heart rate body sensor location characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
          AppMethodBeat.o(22576);
          return false;
        }
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.phX));
      if (paramBluetoothGattService != null)
      {
        i = paramBluetoothGattService.getProperties();
        if ((i & 0x8) == 0)
        {
          Log.e(TAG, "heart rate control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(8) });
          AppMethodBeat.o(22576);
          return false;
        }
      }
      AppMethodBeat.o(22576);
      return true;
    }
    if (0L != (0x8 & l))
    {
      if (paramBluetoothGattService == null)
      {
        Log.e(TAG, "service is null");
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.phZ));
      if (localBluetoothGattCharacteristic == null)
      {
        Log.e(TAG, "blood pressure measurement characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x20) == 0)
      {
        Log.e(TAG, "blood pressure measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.pib));
      if (localBluetoothGattCharacteristic == null)
      {
        Log.e(TAG, "blood pressure feature characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x2) == 0)
      {
        Log.e(TAG, "blood pressure feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        AppMethodBeat.o(22576);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.pia));
      if (paramBluetoothGattService != null)
      {
        i = paramBluetoothGattService.getProperties();
        if ((i & 0x10) == 0)
        {
          Log.e(TAG, "blood pressure intermediate cuff pressure characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(16) });
          AppMethodBeat.o(22576);
          return false;
        }
      }
      AppMethodBeat.o(22576);
      return true;
    }
    if (0L != (l & 0x10))
    {
      if (paramBluetoothGattService == null)
      {
        Log.e(TAG, "service is null");
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.phN));
      if (localBluetoothGattCharacteristic == null)
      {
        Log.e(TAG, "light color characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if (((i & 0x20) == 0) || ((i & 0x10) == 0) || ((i & 0x2) == 0) || ((i & 0x8) == 0))
      {
        Log.e(TAG, "light color characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.phO));
      if (localBluetoothGattCharacteristic == null)
      {
        Log.e(TAG, "light work state characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if (((i & 0x20) == 0) || ((i & 0x2) == 0) || ((i & 0x8) == 0))
      {
        Log.e(TAG, "light work state characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.phP));
      if (localBluetoothGattCharacteristic == null)
      {
        Log.e(TAG, "light state changed characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x20) == 0)
      {
        Log.e(TAG, "light state changed characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.phQ));
      if (paramBluetoothGattService == null)
      {
        Log.e(TAG, "control point characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = paramBluetoothGattService.getProperties();
      if (((i & 0x20) == 0) || ((i & 0x8) == 0))
      {
        Log.e(TAG, "control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      AppMethodBeat.o(22576);
      return true;
    }
    AppMethodBeat.o(22576);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */