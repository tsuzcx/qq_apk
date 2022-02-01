package com.tencent.mm.plugin.g.a.b.a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.g.a.b.h;
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

public class c
{
  public static final String TAG;
  private static HashMap<String, Long> vvG;
  private static HashMap<String, Long> vwN;
  
  static
  {
    AppMethodBeat.i(22578);
    TAG = c.class.getName();
    vvG = new HashMap();
    HashMap localHashMap = new HashMap();
    vwN = localHashMap;
    localHashMap.put(h.vvV, Long.valueOf(1L));
    vwN.put(h.vvW, Long.valueOf(1L));
    vwN.put(h.vvX, Long.valueOf(16L));
    vwN.put(h.vvY, Long.valueOf(16L));
    vwN.put(h.vvZ, Long.valueOf(16L));
    vwN.put(h.vwa, Long.valueOf(16L));
    vvG.put(h.vvS, Long.valueOf(0L));
    vvG.put(h.vwb, Long.valueOf(2L));
    vvG.put(h.vwe, Long.valueOf(4L));
    vvG.put(h.vwi, Long.valueOf(8L));
    AppMethodBeat.o(22578);
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
    if ((((String)localObject).equalsIgnoreCase(h.vvS)) && (paramBluetoothGattService.getCharacteristic(UUID.fromString(h.vvV)) != null))
    {
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristics();
      l1 = 0L;
      int i = 0;
      if (i < paramBluetoothGattService.size())
      {
        localObject = ((BluetoothGattCharacteristic)paramBluetoothGattService.get(i)).getUuid().toString();
        localObject = (Long)vwN.get(localObject);
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
    paramBluetoothGattService = (Long)vvG.get(localObject);
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
      Log.d(TAG, "recv data. uuid = %s, data = %s", new Object[] { localObject1, com.tencent.mm.plugin.exdevice.k.b.bK(paramArrayOfByte) });
      if ((0L == (1L & l)) || ((!((String)localObject1).equalsIgnoreCase(f.vxp)) && (!((String)localObject1).equalsIgnoreCase(f.vxq)))) {
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
      paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.eZ(localObject2);
      Log.d(TAG, "step info. stepCount=%d, stepDistance=%d, stepColarie=%d", new Object[] { Integer.valueOf(((f)localObject2).vxr), Integer.valueOf(((f)localObject2).vxs), Integer.valueOf(((f)localObject2).vxt) });
    }
    for (;;)
    {
      AppMethodBeat.o(22577);
      return paramBluetoothGattCharacteristic;
      Log.e(TAG, "the characteristic has no parent service");
      break;
      label225:
      if ((localObject1 == null) || ((!((String)localObject1).equals(f.vxp)) && (!((String)localObject1).equals(f.vxq))))
      {
        Log.e(f.TAG, "uuid is not correct");
        i = 0;
        break label151;
      }
      ((f)localObject2).vwn = ((String)localObject1);
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
      ((f)localObject2).vxr = 0;
      j = 0;
      i = 1;
      while (j < 3)
      {
        ((f)localObject2).vxr += ((paramArrayOfByte[i] & 0xFF) << j * 8);
        i += 1;
        j += 1;
      }
      j = i;
      if ((paramArrayOfByte[0] & 0x2) != 0)
      {
        ((f)localObject2).vxs = 0;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= 3) {
            break;
          }
          ((f)localObject2).vxs += ((paramArrayOfByte[i] & 0xFF) << k * 8);
          i += 1;
          k += 1;
        }
      }
      if ((paramArrayOfByte[0] & 0x4) != 0)
      {
        ((f)localObject2).vxt = 0;
        i = 0;
        while (i < 3)
        {
          ((f)localObject2).vxt += ((paramArrayOfByte[j] & 0xFF) << i * 8);
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
    if ((0L != (0x2 & l)) && ((((String)localObject1).equalsIgnoreCase(g.vwd)) || (((String)localObject1).equalsIgnoreCase(g.vwc))))
    {
      localObject2 = new g();
      if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
      {
        Log.e(g.TAG, "characteristicUuid or data is null or nil");
        i = 0;
      }
      label909:
      label915:
      label921:
      label928:
      label935:
      for (;;)
      {
        label578:
        if (i != 0)
        {
          paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.eZ(localObject2);
          Log.d(TAG, "weight info. weight = %d", new Object[] { Integer.valueOf(((g)localObject2).vxx.bqg) });
          break;
          ((g)localObject2).vwn = ((String)localObject1);
          if (((g)localObject2).vwn.equalsIgnoreCase(g.vwc))
          {
            if (4 > paramArrayOfByte.length)
            {
              Log.e(g.TAG, "weight scale feature characteristic data is a 32bit value, but current value len is %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
              i = 0;
              continue;
            }
            ((g)localObject2).vxw = new g.c();
            paramBluetoothGattCharacteristic = ((g)localObject2).vxw;
            if ((paramArrayOfByte[0] & 0x1) != 0)
            {
              bool = true;
              paramBluetoothGattCharacteristic.vxB = bool;
              paramBluetoothGattCharacteristic = ((g)localObject2).vxw;
              if ((paramArrayOfByte[0] & 0x2) == 0) {
                break label909;
              }
              bool = true;
              paramBluetoothGattCharacteristic.vxC = bool;
              paramBluetoothGattCharacteristic = ((g)localObject2).vxw;
              if ((paramArrayOfByte[0] & 0x4) == 0) {
                break label915;
              }
              bool = true;
              paramBluetoothGattCharacteristic.vxD = bool;
              ((g)localObject2).vxw.vxE = ((byte)((paramArrayOfByte[0] & 0x78) >> 3));
              ((g)localObject2).vxw.vxF = ((byte)(((paramArrayOfByte[0] & 0x80) >> 7) + ((paramArrayOfByte[1] & 0x3) << 1)));
              str = g.TAG;
              if (!((g)localObject2).vxw.vxB) {
                break label921;
              }
              paramBluetoothGattCharacteristic = "true";
              if (!((g)localObject2).vxw.vxC) {
                break label928;
              }
              paramArrayOfByte = "true";
              if (!((g)localObject2).vxw.vxD) {
                break label935;
              }
              localObject1 = "true";
              Log.d(str, "timestampSupported = %s, multipleUsersSupported = %s, BMISupported = %s, weightResolution = %d, heightResolution = %d", new Object[] { paramBluetoothGattCharacteristic, paramArrayOfByte, localObject1, Byte.valueOf(((g)localObject2).vxw.vxE), Byte.valueOf(((g)localObject2).vxw.vxF) });
            }
          }
          while (!((g)localObject2).vwn.equalsIgnoreCase(g.vwd)) {
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
            break label3919;
          }
        }
      }
    }
    label1066:
    label1591:
    label2893:
    label3919:
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
        break label578;
      }
      ((g)localObject2).vxx = new g.b();
      paramBluetoothGattCharacteristic = ((g)localObject2).vxx;
      if ((k & 0x1) != 0)
      {
        bool = true;
        paramBluetoothGattCharacteristic.vxy = bool;
        ((g)localObject2).vxx.bqg = ((paramArrayOfByte[1] & 0xFF) + ((paramArrayOfByte[2] & 0xFF) << 8));
        if ((k & 0x2) == 0) {
          break label3914;
        }
        ((g)localObject2).vxx.vxz = new g.a();
        paramBluetoothGattCharacteristic = ((g)localObject2).vxx.vxz;
        localObject1 = g.TAG;
        if (paramArrayOfByte != null) {
          break label1420;
        }
        i = 0;
        label1140:
        Log.d((String)localObject1, "data size = %d, offset = %d, lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(3), Integer.valueOf(7) });
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 10)) {
          break label1426;
        }
        Log.e(g.TAG, "data input error");
      }
      for (i = 10;; i = 3)
      {
        j = i;
        if ((k & 0x4) != 0)
        {
          ((g)localObject2).vxx.vwD = (paramArrayOfByte[i] & 0xFF);
          j = i + 1;
        }
        if ((k & 0x8) != 0)
        {
          ((g)localObject2).vxx.vxA = ((paramArrayOfByte[j] & 0xFF) + ((paramArrayOfByte[(j + 1)] & 0xFF) << 8));
          i = j + 2;
          paramBluetoothGattCharacteristic = ((g)localObject2).vxx;
          j = paramArrayOfByte[i];
          paramBluetoothGattCharacteristic.mHeight = (((paramArrayOfByte[(i + 1)] & 0xFF) << 8) + (j & 0xFF));
        }
        localObject1 = g.TAG;
        if (((g)localObject2).vxx.vxy)
        {
          paramBluetoothGattCharacteristic = "lb&inch";
          i = ((g)localObject2).vxx.bqg;
          if (((g)localObject2).vxx.vxz != null) {
            break label1591;
          }
        }
        for (paramArrayOfByte = "null";; paramArrayOfByte = "object")
        {
          Log.d((String)localObject1, "WeightAndHeightUnit = %s, Weight = %d, TimeStamp = %s, UserId = %d, BMI = %d, Height = %d", new Object[] { paramBluetoothGattCharacteristic, Integer.valueOf(i), paramArrayOfByte, Integer.valueOf(((g)localObject2).vxx.vwD), Integer.valueOf(((g)localObject2).vxx.vxA), Integer.valueOf(((g)localObject2).vxx.mHeight) });
          break;
          bool = false;
          break label1066;
          i = paramArrayOfByte.length;
          break label1140;
          paramBluetoothGattCharacteristic.mYear = ((paramArrayOfByte[3] & 0xFF) + ((paramArrayOfByte[4] & 0xFF) << 8));
          paramBluetoothGattCharacteristic.mMonth = (paramArrayOfByte[5] & 0xFF);
          paramBluetoothGattCharacteristic.mDay = (paramArrayOfByte[6] & 0xFF);
          paramBluetoothGattCharacteristic.vwK = (paramArrayOfByte[7] & 0xFF);
          paramBluetoothGattCharacteristic.vwL = (paramArrayOfByte[8] & 0xFF);
          paramBluetoothGattCharacteristic.vwM = (paramArrayOfByte[9] & 0xFF);
          Log.d(g.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[] { Integer.valueOf(paramBluetoothGattCharacteristic.mYear), Integer.valueOf(paramBluetoothGattCharacteristic.mMonth), Integer.valueOf(paramBluetoothGattCharacteristic.mDay), Integer.valueOf(paramBluetoothGattCharacteristic.vwK), Integer.valueOf(paramBluetoothGattCharacteristic.vwL), Integer.valueOf(paramBluetoothGattCharacteristic.vwM) });
          break label1194;
          paramBluetoothGattCharacteristic = "kg&meter";
          break label1317;
        }
        Log.e(TAG, "parse weight scale data error");
        paramBluetoothGattCharacteristic = null;
        break;
        int m;
        if ((0L != (0x4 & l)) && ((((String)localObject1).equalsIgnoreCase(d.vwp)) || (((String)localObject1).equalsIgnoreCase(d.vwO)) || (((String)localObject1).equalsIgnoreCase(d.vwP))))
        {
          paramBluetoothGattCharacteristic = new d();
          if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null)) {
            Log.e(d.TAG, "characteristicUuid or data is null");
          }
          for (;;)
          {
            if (i != 0)
            {
              paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.eZ(paramBluetoothGattCharacteristic);
              break;
              paramBluetoothGattCharacteristic.vwn = ((String)localObject1);
              k = paramArrayOfByte.length;
              if (paramBluetoothGattCharacteristic.vwn.equalsIgnoreCase(d.vwp))
              {
                if (paramArrayOfByte.length < 2)
                {
                  Log.e(d.TAG, "Received data length is not right:".concat(String.valueOf(k)));
                  continue;
                }
                paramBluetoothGattCharacteristic.vwW = new d.a(paramBluetoothGattCharacteristic);
                m = paramArrayOfByte[0];
                Log.d(d.TAG, "flag=".concat(String.valueOf(m)));
                if (((m & 0x1) == 1) && (k >= 3))
                {
                  Log.d(d.TAG, "Value Format = uint16");
                  i = paramArrayOfByte[2];
                  paramBluetoothGattCharacteristic.vwW.vwX = ((i << 8 & 0xFF00 & 0xFF00) + (paramArrayOfByte[1] & 0xFF));
                  i = 3;
                  Log.v(d.TAG, "Data received from HR " + paramBluetoothGattCharacteristic.vwW.vwX);
                  if ((m & 0x6) != 4) {
                    break label2153;
                  }
                  Log.d(d.TAG, "Sensor Contact feature is supported, but contact is not detected");
                  paramBluetoothGattCharacteristic.vwW.vwY = 1;
                  j = i;
                  if ((m & 0x8) == 8)
                  {
                    j = i;
                    if (k >= i + 2)
                    {
                      Log.d(d.TAG, "Energy Expend Present");
                      j = paramArrayOfByte[(i + 1)] << 8 & 0xFF00;
                      paramBluetoothGattCharacteristic.vwW.vwZ = ((paramArrayOfByte[i] & 0xFF) + (j & 0xFF00));
                      Log.v("H7ConnectThread", "energyExp from HR energyExph " + j + " " + paramBluetoothGattCharacteristic.vwW.vwZ);
                      j = i + 2;
                    }
                  }
                  if (((m & 0x10) == 16) && (k >= j + 2))
                  {
                    Log.d(d.TAG, "RR Interval Present");
                    i = (paramArrayOfByte[(j + 1)] & 0xFF) << 8;
                    paramBluetoothGattCharacteristic.vwW.vxa = ((paramArrayOfByte[j] & 0xFF) + (i & 0xFF00));
                    Log.v(d.TAG, "rrInterval from HR rrIntervalh" + i + " " + paramBluetoothGattCharacteristic.vwW.vxa);
                  }
                }
              }
              label2153:
              while (!paramBluetoothGattCharacteristic.vwn.equalsIgnoreCase(d.vwO)) {
                for (;;)
                {
                  i = 1;
                  break;
                  if (k >= 2)
                  {
                    Log.d(d.TAG, "Value Format = uint8");
                    paramBluetoothGattCharacteristic.vwW.vwX = (paramArrayOfByte[1] & 0xFF);
                    i = 2;
                  }
                  else
                  {
                    Log.d(d.TAG, "receive data error");
                    break;
                    if ((m & 0x6) == 6)
                    {
                      Log.d(d.TAG, "Sensor Contact feature is supported and contact is detected");
                      paramBluetoothGattCharacteristic.vwW.vwY = 2;
                    }
                    else
                    {
                      Log.d(d.TAG, "Sensor Contact feature is not supported in the current connection");
                      paramBluetoothGattCharacteristic.vwW.vwY = 0;
                    }
                  }
                }
              }
              switch (paramArrayOfByte[0])
              {
              default: 
                paramBluetoothGattCharacteristic.vwV = "Unknown";
              }
              for (;;)
              {
                Log.d(d.TAG, "position=" + paramBluetoothGattCharacteristic.vwV);
                break;
                paramBluetoothGattCharacteristic.vwV = "Other";
                continue;
                paramBluetoothGattCharacteristic.vwV = "Chest";
                continue;
                paramBluetoothGattCharacteristic.vwV = "Wrist";
                continue;
                paramBluetoothGattCharacteristic.vwV = "Finger";
                continue;
                paramBluetoothGattCharacteristic.vwV = "Hand";
                continue;
                paramBluetoothGattCharacteristic.vwV = "Ear Lobe";
                continue;
                paramBluetoothGattCharacteristic.vwV = "Foot";
              }
            }
          }
          Log.e(TAG, "parse heart rate data error");
          paramBluetoothGattCharacteristic = null;
          break;
        }
        if ((0L != (0x8 & l)) && ((((String)localObject1).equalsIgnoreCase(b.vwp)) || (((String)localObject1).equalsIgnoreCase(b.vwq)) || (((String)localObject1).equalsIgnoreCase(b.vwr))))
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
              paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.eZ(paramBluetoothGattCharacteristic);
              break;
              paramBluetoothGattCharacteristic.vwn = ((String)localObject1);
              k = paramArrayOfByte.length;
              if (paramBluetoothGattCharacteristic.vwn.equalsIgnoreCase(b.vwp))
              {
                if (k < 7)
                {
                  Log.e(b.TAG, "data len is not right.");
                  i = j;
                  continue;
                }
                paramBluetoothGattCharacteristic.vwx = new b.b(paramBluetoothGattCharacteristic);
                m = paramArrayOfByte[0];
                Log.d(b.TAG, "flag=".concat(String.valueOf(m)));
                if ((m & 0x1) != 0)
                {
                  Log.d(b.TAG, "the value unit is kPa.");
                  paramBluetoothGattCharacteristic.vwx.vwA = true;
                  paramBluetoothGattCharacteristic.vwx.vwH = b.O(paramArrayOfByte, 1);
                  paramBluetoothGattCharacteristic.vwx.vwI = b.O(paramArrayOfByte, 3);
                  paramBluetoothGattCharacteristic.vwx.vwJ = b.O(paramArrayOfByte, 5);
                  i = 7;
                  if (((m & 0x2) == 0) || (k < 14)) {
                    break label2893;
                  }
                  Log.d(b.TAG, "TimeStamp Present.");
                  paramBluetoothGattCharacteristic.vwx.vwF.P(paramArrayOfByte, 7);
                  i = 14;
                  label2653:
                  if (((m & 0x4) == 0) || (k < i + 2)) {
                    break label2905;
                  }
                  Log.d(b.TAG, "PulseRate Present.");
                  paramBluetoothGattCharacteristic.vwx.vwC = ((int)b.O(paramArrayOfByte, i));
                  i += 2;
                  Log.d(b.TAG, "PulseRate =" + paramBluetoothGattCharacteristic.vwx.vwC);
                  if ((m & 0x8) == 0) {
                    break label2917;
                  }
                  Log.d(b.TAG, "UserId Present.");
                  localObject1 = paramBluetoothGattCharacteristic.vwx;
                  j = i + 1;
                  ((b.b)localObject1).vwD = paramArrayOfByte[i];
                  Log.d(b.TAG, "UserId = " + paramBluetoothGattCharacteristic.vwx.vwD);
                  i = j;
                  label2789:
                  if ((m & 0x10) == 0) {
                    break label2929;
                  }
                  Log.d(b.TAG, "MeasurementStatus Present.");
                  j = paramArrayOfByte[(i + 1)];
                  paramBluetoothGattCharacteristic.vwx.vwE = ((paramArrayOfByte[i] & 0xFF) + (j << 8 & 0xFF00 & 0xFF00));
                  Log.d(b.TAG, "MeasurementStatus = " + paramBluetoothGattCharacteristic.vwx.vwE);
                }
              }
              for (;;)
              {
                i = 1;
                break;
                Log.d(b.TAG, "the value unit is mmHg.");
                paramBluetoothGattCharacteristic.vwx.vwA = false;
                break label2574;
                Log.d(b.TAG, "TimeStamp not Present.");
                break label2653;
                label2905:
                Log.d(b.TAG, "PulseRate not Present.");
                break label2723;
                label2917:
                Log.d(b.TAG, "UserId not Present.");
                break label2789;
                label2929:
                Log.d(b.TAG, "MeasurementStatus not Present.");
                continue;
                if (paramBluetoothGattCharacteristic.vwn.equalsIgnoreCase(b.vwq))
                {
                  if (k < 3)
                  {
                    Log.e(b.TAG, "data len is not right.");
                    i = j;
                    break;
                  }
                  paramBluetoothGattCharacteristic.vwy = new b.a(paramBluetoothGattCharacteristic);
                  m = paramArrayOfByte[0];
                  Log.d(b.TAG, "flag=".concat(String.valueOf(m)));
                  if ((m & 0x1) != 0)
                  {
                    Log.d(b.TAG, "the value unit is kPa.");
                    paramBluetoothGattCharacteristic.vwy.vwA = true;
                    label3032:
                    paramBluetoothGattCharacteristic.vwy.vwB = b.O(paramArrayOfByte, 1);
                    if (((m & 0x2) == 0) || (k < 10)) {
                      break label3321;
                    }
                    Log.d(b.TAG, "TimeStamp Present.");
                    paramBluetoothGattCharacteristic.vwy.vwF.P(paramArrayOfByte, 3);
                    i = 10;
                    if (((m & 0x4) == 0) || (k < i + 2)) {
                      break label3335;
                    }
                    Log.d(b.TAG, "PulseRate Present.");
                    paramBluetoothGattCharacteristic.vwy.vwC = ((int)b.O(paramArrayOfByte, i));
                    i += 2;
                    Log.d(b.TAG, "PulseRate =" + paramBluetoothGattCharacteristic.vwy.vwC);
                    label3153:
                    if ((m & 0x8) == 0) {
                      break label3347;
                    }
                    Log.d(b.TAG, "UserId Present.");
                    localObject1 = paramBluetoothGattCharacteristic.vwy;
                    j = i + 1;
                    ((b.a)localObject1).vwD = paramArrayOfByte[i];
                    Log.d(b.TAG, "UserId = " + paramBluetoothGattCharacteristic.vwy.vwD);
                    i = j;
                  }
                  for (;;)
                  {
                    if ((m & 0x10) == 0) {
                      break label3359;
                    }
                    Log.d(b.TAG, "MeasurementStatus Present.");
                    j = paramArrayOfByte[(i + 1)];
                    paramBluetoothGattCharacteristic.vwy.vwE = ((paramArrayOfByte[i] & 0xFF) + (j << 8 & 0xFF00 & 0xFF00));
                    Log.d(b.TAG, "MeasurementStatus = " + paramBluetoothGattCharacteristic.vwy.vwE);
                    break;
                    Log.d(b.TAG, "the value unit is mmHg.");
                    paramBluetoothGattCharacteristic.vwy.vwA = false;
                    break label3032;
                    label3321:
                    Log.d(b.TAG, "TimeStamp not Present.");
                    i = 3;
                    break label3083;
                    Log.d(b.TAG, "PulseRate not Present.");
                    break label3153;
                    Log.d(b.TAG, "UserId not Present.");
                  }
                  Log.d(b.TAG, "MeasurementStatus not Present.");
                  continue;
                }
                if (paramBluetoothGattCharacteristic.vwn.equalsIgnoreCase(b.vwr))
                {
                  Log.d(b.TAG, "Blood Pressure Feature Characteristic.");
                  if (k < 2)
                  {
                    Log.e(b.TAG, "data len is not right.");
                    i = j;
                    break;
                  }
                  paramBluetoothGattCharacteristic.vwz = ((paramArrayOfByte[1] << 8 & 0xFF00 & 0xFF00) + (paramArrayOfByte[0] & 0xFF));
                  Log.d(b.TAG, "bloodPressureFeatureParameters=" + paramBluetoothGattCharacteristic.vwz);
                }
              }
            }
          }
          Log.e(TAG, "parse blood pressure data error");
          paramBluetoothGattCharacteristic = null;
          break;
        }
        if ((0L != (l & 0x10)) && ((((String)localObject1).equalsIgnoreCase(e.vxc)) || (((String)localObject1).equalsIgnoreCase(e.vxd)) || (((String)localObject1).equalsIgnoreCase(e.vxe)) || (((String)localObject1).equalsIgnoreCase(e.vxf))))
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
              break label3877;
            }
            paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.eZ(paramBluetoothGattCharacteristic);
            break;
            paramBluetoothGattCharacteristic.vwn = ((String)localObject1);
            if (paramBluetoothGattCharacteristic.vwn.equalsIgnoreCase(e.vxc))
            {
              if (paramArrayOfByte.length != 3)
              {
                Log.e(e.TAG, "Data length incorrect");
                i = k;
              }
              else
              {
                paramBluetoothGattCharacteristic.vxg = paramArrayOfByte[0];
                paramBluetoothGattCharacteristic.vxh = paramArrayOfByte[1];
                paramBluetoothGattCharacteristic.vxi = paramArrayOfByte[2];
              }
            }
            else
            {
              for (;;)
              {
                i = 1;
                break;
                if (paramBluetoothGattCharacteristic.vwn.equalsIgnoreCase(e.vxd))
                {
                  if (paramArrayOfByte.length != 1)
                  {
                    Log.e(e.TAG, "Data length incorrect");
                    i = k;
                    break;
                  }
                  paramBluetoothGattCharacteristic.vxj = paramArrayOfByte[0];
                  continue;
                }
                if (paramBluetoothGattCharacteristic.vwn.equalsIgnoreCase(e.vxe))
                {
                  if (paramArrayOfByte.length < 2)
                  {
                    Log.e(e.TAG, "Data length incorrect");
                    i = k;
                    break;
                  }
                  paramBluetoothGattCharacteristic.vxk[0] = paramArrayOfByte[0];
                  paramBluetoothGattCharacteristic.vxk[1] = paramArrayOfByte[1];
                  continue;
                }
                if (!paramBluetoothGattCharacteristic.vwn.equalsIgnoreCase(e.vxf)) {
                  break label3862;
                }
                if (paramArrayOfByte.length < 4)
                {
                  Log.e(e.TAG, "Data length incorrect");
                  i = k;
                  break;
                }
                paramBluetoothGattCharacteristic.vxl = ((paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8));
                paramBluetoothGattCharacteristic.vxn = paramArrayOfByte[2];
                paramBluetoothGattCharacteristic.vxm = paramArrayOfByte[3];
                if (paramArrayOfByte.length > 4)
                {
                  paramBluetoothGattCharacteristic.vxo = new byte[paramArrayOfByte.length - 4];
                  System.arraycopy(paramArrayOfByte, 4, paramBluetoothGattCharacteristic.vxo, 0, paramArrayOfByte.length - 4);
                }
                else
                {
                  paramBluetoothGattCharacteristic.vxo = null;
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
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.vvV));
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
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.vvW));
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
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.vwc));
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
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.vwd));
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
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.vwf));
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
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.vwg));
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
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.vwh));
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
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.vwj));
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
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.vwl));
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
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.vwk));
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
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.vvX));
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
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.vvY));
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
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.vvZ));
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
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.vwa));
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
  
  public static boolean bl(byte[] paramArrayOfByte)
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
          if (vvG.containsKey(localObject))
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
            boolean bool = vvG.containsKey(localObject);
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
      Log.i(TAG, "Manufacturer Specific Data = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.bK(Arrays.copyOfRange(paramArrayOfByte, j, j + m)) });
      break label204;
      AppMethodBeat.o(22573);
      return false;
      i = m;
    }
  }
  
  public static String ke(long paramLong)
  {
    AppMethodBeat.i(22574);
    Object localObject = vvG.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (((Long)vvG.get(str)).longValue() == paramLong)
      {
        AppMethodBeat.o(22574);
        return str;
      }
    }
    if (vwN.containsValue(Long.valueOf(paramLong)))
    {
      localObject = h.vvS;
      AppMethodBeat.o(22574);
      return localObject;
    }
    AppMethodBeat.o(22574);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */