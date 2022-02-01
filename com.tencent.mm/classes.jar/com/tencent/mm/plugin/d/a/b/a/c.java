package com.tencent.mm.plugin.d.a.b.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static HashMap<String, Long> nWA;
  private static HashMap<String, Long> nXH;
  
  static
  {
    AppMethodBeat.i(22578);
    TAG = c.class.getName();
    nWA = new HashMap();
    HashMap localHashMap = new HashMap();
    nXH = localHashMap;
    localHashMap.put(h.nWP, Long.valueOf(1L));
    nXH.put(h.nWQ, Long.valueOf(1L));
    nXH.put(h.nWR, Long.valueOf(16L));
    nXH.put(h.nWS, Long.valueOf(16L));
    nXH.put(h.nWT, Long.valueOf(16L));
    nXH.put(h.nWU, Long.valueOf(16L));
    nWA.put(h.nWM, Long.valueOf(0L));
    nWA.put(h.nWV, Long.valueOf(2L));
    nWA.put(h.nWY, Long.valueOf(4L));
    nWA.put(h.nXc, Long.valueOf(8L));
    AppMethodBeat.o(22578);
  }
  
  public static long a(BluetoothGattService paramBluetoothGattService)
  {
    long l1 = 0L;
    AppMethodBeat.i(22575);
    if (paramBluetoothGattService == null)
    {
      ae.e(TAG, "service is null");
      AppMethodBeat.o(22575);
      return 0L;
    }
    Object localObject = paramBluetoothGattService.getUuid().toString();
    if ((((String)localObject).equalsIgnoreCase(h.nWM)) && (paramBluetoothGattService.getCharacteristic(UUID.fromString(h.nWP)) != null))
    {
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristics();
      l1 = 0L;
      int i = 0;
      if (i < paramBluetoothGattService.size())
      {
        localObject = ((BluetoothGattCharacteristic)paramBluetoothGattService.get(i)).getUuid().toString();
        localObject = (Long)nXH.get(localObject);
        if (localObject == null) {}
        for (long l2 = 0L;; l2 = ((Long)localObject).longValue())
        {
          i += 1;
          l1 = l2 | l1;
          break;
        }
      }
      ae.d(TAG, "wechat service, profileType = %d", new Object[] { Long.valueOf(l1) });
      AppMethodBeat.o(22575);
      return l1;
    }
    paramBluetoothGattService = (Long)nWA.get(localObject);
    if (paramBluetoothGattService == null) {}
    for (;;)
    {
      ae.d(TAG, "service uuid = %s, profileType = %d", new Object[] { localObject, Long.valueOf(l1) });
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
      ae.e(TAG, "characteristic or recvData is null");
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
      ae.d(TAG, "recv data. uuid = %s, data = %s", new Object[] { localObject1, com.tencent.mm.plugin.exdevice.k.b.bf(paramArrayOfByte) });
      if ((0L == (1L & l)) || ((!((String)localObject1).equalsIgnoreCase(f.nYj)) && (!((String)localObject1).equalsIgnoreCase(f.nYk)))) {
        break label504;
      }
      localObject2 = new f();
      if ((paramArrayOfByte.length > 0) && ((paramArrayOfByte[0] & 0x1) != 0)) {
        break label225;
      }
      ae.e(f.TAG, "pase step data error");
      i = 0;
      label151:
      if (i == 0) {
        break label491;
      }
      paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.cX(localObject2);
      ae.d(TAG, "step info. stepCount=%d, stepDistance=%d, stepColarie=%d", new Object[] { Integer.valueOf(((f)localObject2).nYl), Integer.valueOf(((f)localObject2).nYm), Integer.valueOf(((f)localObject2).nYn) });
    }
    for (;;)
    {
      AppMethodBeat.o(22577);
      return paramBluetoothGattCharacteristic;
      ae.e(TAG, "the characteristic has no parent service");
      break;
      label225:
      if ((localObject1 == null) || ((!((String)localObject1).equals(f.nYj)) && (!((String)localObject1).equals(f.nYk))))
      {
        ae.e(f.TAG, "uuid is not correct");
        i = 0;
        break label151;
      }
      ((f)localObject2).nXh = ((String)localObject1);
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
        ae.e(f.TAG, "data len is not enough");
        i = 0;
        break label151;
      }
      ((f)localObject2).nYl = 0;
      j = 0;
      i = 1;
      while (j < 3)
      {
        ((f)localObject2).nYl += ((paramArrayOfByte[i] & 0xFF) << j * 8);
        i += 1;
        j += 1;
      }
      j = i;
      if ((paramArrayOfByte[0] & 0x2) != 0)
      {
        ((f)localObject2).nYm = 0;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= 3) {
            break;
          }
          ((f)localObject2).nYm += ((paramArrayOfByte[i] & 0xFF) << k * 8);
          i += 1;
          k += 1;
        }
      }
      if ((paramArrayOfByte[0] & 0x4) != 0)
      {
        ((f)localObject2).nYn = 0;
        i = 0;
        while (i < 3)
        {
          ((f)localObject2).nYn += ((paramArrayOfByte[j] & 0xFF) << i * 8);
          j += 1;
          i += 1;
        }
      }
      i = 1;
      break label151;
      label491:
      ae.e(TAG, "parse step data error");
      paramBluetoothGattCharacteristic = null;
    }
    label504:
    boolean bool;
    if ((0L != (0x2 & l)) && ((((String)localObject1).equalsIgnoreCase(g.nWX)) || (((String)localObject1).equalsIgnoreCase(g.nWW))))
    {
      localObject2 = new g();
      if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
      {
        ae.e(g.TAG, "characteristicUuid or data is null or nil");
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
          paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.cX(localObject2);
          ae.d(TAG, "weight info. weight = %d", new Object[] { Integer.valueOf(((g)localObject2).nYr.Jw) });
          break;
          ((g)localObject2).nXh = ((String)localObject1);
          if (((g)localObject2).nXh.equalsIgnoreCase(g.nWW))
          {
            if (4 > paramArrayOfByte.length)
            {
              ae.e(g.TAG, "weight scale feature characteristic data is a 32bit value, but current value len is %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
              i = 0;
              continue;
            }
            ((g)localObject2).nYq = new g.c();
            paramBluetoothGattCharacteristic = ((g)localObject2).nYq;
            if ((paramArrayOfByte[0] & 0x1) != 0)
            {
              bool = true;
              paramBluetoothGattCharacteristic.nYv = bool;
              paramBluetoothGattCharacteristic = ((g)localObject2).nYq;
              if ((paramArrayOfByte[0] & 0x2) == 0) {
                break label909;
              }
              bool = true;
              paramBluetoothGattCharacteristic.nYw = bool;
              paramBluetoothGattCharacteristic = ((g)localObject2).nYq;
              if ((paramArrayOfByte[0] & 0x4) == 0) {
                break label915;
              }
              bool = true;
              paramBluetoothGattCharacteristic.nYx = bool;
              ((g)localObject2).nYq.nYy = ((byte)((paramArrayOfByte[0] & 0x78) >> 3));
              ((g)localObject2).nYq.nYz = ((byte)(((paramArrayOfByte[0] & 0x80) >> 7) + ((paramArrayOfByte[1] & 0x3) << 1)));
              str = g.TAG;
              if (!((g)localObject2).nYq.nYv) {
                break label921;
              }
              paramBluetoothGattCharacteristic = "true";
              if (!((g)localObject2).nYq.nYw) {
                break label928;
              }
              paramArrayOfByte = "true";
              if (!((g)localObject2).nYq.nYx) {
                break label935;
              }
              localObject1 = "true";
              ae.d(str, "timestampSupported = %s, multipleUsersSupported = %s, BMISupported = %s, weightResolution = %d, heightResolution = %d", new Object[] { paramBluetoothGattCharacteristic, paramArrayOfByte, localObject1, Byte.valueOf(((g)localObject2).nYq.nYy), Byte.valueOf(((g)localObject2).nYq.nYz) });
            }
          }
          while (!((g)localObject2).nXh.equalsIgnoreCase(g.nWX)) {
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
        ae.e(g.TAG, "data len is not enough for parse. current len = %d, needed len = %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(j) });
        i = 0;
        break label578;
      }
      ((g)localObject2).nYr = new g.b();
      paramBluetoothGattCharacteristic = ((g)localObject2).nYr;
      if ((k & 0x1) != 0)
      {
        bool = true;
        paramBluetoothGattCharacteristic.nYs = bool;
        ((g)localObject2).nYr.Jw = ((paramArrayOfByte[1] & 0xFF) + ((paramArrayOfByte[2] & 0xFF) << 8));
        if ((k & 0x2) == 0) {
          break label3914;
        }
        ((g)localObject2).nYr.nYt = new g.a();
        paramBluetoothGattCharacteristic = ((g)localObject2).nYr.nYt;
        localObject1 = g.TAG;
        if (paramArrayOfByte != null) {
          break label1420;
        }
        i = 0;
        label1140:
        ae.d((String)localObject1, "data size = %d, offset = %d, lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(3), Integer.valueOf(7) });
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 10)) {
          break label1426;
        }
        ae.e(g.TAG, "data input error");
      }
      for (i = 10;; i = 3)
      {
        j = i;
        if ((k & 0x4) != 0)
        {
          ((g)localObject2).nYr.nXx = (paramArrayOfByte[i] & 0xFF);
          j = i + 1;
        }
        if ((k & 0x8) != 0)
        {
          ((g)localObject2).nYr.nYu = ((paramArrayOfByte[j] & 0xFF) + ((paramArrayOfByte[(j + 1)] & 0xFF) << 8));
          i = j + 2;
          paramBluetoothGattCharacteristic = ((g)localObject2).nYr;
          j = paramArrayOfByte[i];
          paramBluetoothGattCharacteristic.mHeight = (((paramArrayOfByte[(i + 1)] & 0xFF) << 8) + (j & 0xFF));
        }
        localObject1 = g.TAG;
        if (((g)localObject2).nYr.nYs)
        {
          paramBluetoothGattCharacteristic = "lb&inch";
          i = ((g)localObject2).nYr.Jw;
          if (((g)localObject2).nYr.nYt != null) {
            break label1591;
          }
        }
        for (paramArrayOfByte = "null";; paramArrayOfByte = "object")
        {
          ae.d((String)localObject1, "WeightAndHeightUnit = %s, Weight = %d, TimeStamp = %s, UserId = %d, BMI = %d, Height = %d", new Object[] { paramBluetoothGattCharacteristic, Integer.valueOf(i), paramArrayOfByte, Integer.valueOf(((g)localObject2).nYr.nXx), Integer.valueOf(((g)localObject2).nYr.nYu), Integer.valueOf(((g)localObject2).nYr.mHeight) });
          break;
          bool = false;
          break label1066;
          i = paramArrayOfByte.length;
          break label1140;
          paramBluetoothGattCharacteristic.mYear = ((paramArrayOfByte[3] & 0xFF) + ((paramArrayOfByte[4] & 0xFF) << 8));
          paramBluetoothGattCharacteristic.mMonth = (paramArrayOfByte[5] & 0xFF);
          paramBluetoothGattCharacteristic.mDay = (paramArrayOfByte[6] & 0xFF);
          paramBluetoothGattCharacteristic.nXE = (paramArrayOfByte[7] & 0xFF);
          paramBluetoothGattCharacteristic.nXF = (paramArrayOfByte[8] & 0xFF);
          paramBluetoothGattCharacteristic.nXG = (paramArrayOfByte[9] & 0xFF);
          ae.d(g.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[] { Integer.valueOf(paramBluetoothGattCharacteristic.mYear), Integer.valueOf(paramBluetoothGattCharacteristic.mMonth), Integer.valueOf(paramBluetoothGattCharacteristic.mDay), Integer.valueOf(paramBluetoothGattCharacteristic.nXE), Integer.valueOf(paramBluetoothGattCharacteristic.nXF), Integer.valueOf(paramBluetoothGattCharacteristic.nXG) });
          break label1194;
          paramBluetoothGattCharacteristic = "kg&meter";
          break label1317;
        }
        ae.e(TAG, "parse weight scale data error");
        paramBluetoothGattCharacteristic = null;
        break;
        int m;
        if ((0L != (0x4 & l)) && ((((String)localObject1).equalsIgnoreCase(d.nXj)) || (((String)localObject1).equalsIgnoreCase(d.nXI)) || (((String)localObject1).equalsIgnoreCase(d.nXJ))))
        {
          paramBluetoothGattCharacteristic = new d();
          if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null)) {
            ae.e(d.TAG, "characteristicUuid or data is null");
          }
          for (;;)
          {
            if (i != 0)
            {
              paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.cX(paramBluetoothGattCharacteristic);
              break;
              paramBluetoothGattCharacteristic.nXh = ((String)localObject1);
              k = paramArrayOfByte.length;
              if (paramBluetoothGattCharacteristic.nXh.equalsIgnoreCase(d.nXj))
              {
                if (paramArrayOfByte.length < 2)
                {
                  ae.e(d.TAG, "Received data length is not right:".concat(String.valueOf(k)));
                  continue;
                }
                paramBluetoothGattCharacteristic.nXQ = new d.a(paramBluetoothGattCharacteristic);
                m = paramArrayOfByte[0];
                ae.d(d.TAG, "flag=".concat(String.valueOf(m)));
                if (((m & 0x1) == 1) && (k >= 3))
                {
                  ae.d(d.TAG, "Value Format = uint16");
                  i = paramArrayOfByte[2];
                  paramBluetoothGattCharacteristic.nXQ.nXR = ((i << 8 & 0xFF00 & 0xFF00) + (paramArrayOfByte[1] & 0xFF));
                  i = 3;
                  ae.v(d.TAG, "Data received from HR " + paramBluetoothGattCharacteristic.nXQ.nXR);
                  if ((m & 0x6) != 4) {
                    break label2153;
                  }
                  ae.d(d.TAG, "Sensor Contact feature is supported, but contact is not detected");
                  paramBluetoothGattCharacteristic.nXQ.nXS = 1;
                  j = i;
                  if ((m & 0x8) == 8)
                  {
                    j = i;
                    if (k >= i + 2)
                    {
                      ae.d(d.TAG, "Energy Expend Present");
                      j = paramArrayOfByte[(i + 1)] << 8 & 0xFF00;
                      paramBluetoothGattCharacteristic.nXQ.nXT = ((paramArrayOfByte[i] & 0xFF) + (j & 0xFF00));
                      ae.v("H7ConnectThread", "energyExp from HR energyExph " + j + " " + paramBluetoothGattCharacteristic.nXQ.nXT);
                      j = i + 2;
                    }
                  }
                  if (((m & 0x10) == 16) && (k >= j + 2))
                  {
                    ae.d(d.TAG, "RR Interval Present");
                    i = (paramArrayOfByte[(j + 1)] & 0xFF) << 8;
                    paramBluetoothGattCharacteristic.nXQ.nXU = ((paramArrayOfByte[j] & 0xFF) + (i & 0xFF00));
                    ae.v(d.TAG, "rrInterval from HR rrIntervalh" + i + " " + paramBluetoothGattCharacteristic.nXQ.nXU);
                  }
                }
              }
              label2153:
              while (!paramBluetoothGattCharacteristic.nXh.equalsIgnoreCase(d.nXI)) {
                for (;;)
                {
                  i = 1;
                  break;
                  if (k >= 2)
                  {
                    ae.d(d.TAG, "Value Format = uint8");
                    paramBluetoothGattCharacteristic.nXQ.nXR = (paramArrayOfByte[1] & 0xFF);
                    i = 2;
                  }
                  else
                  {
                    ae.d(d.TAG, "receive data error");
                    break;
                    if ((m & 0x6) == 6)
                    {
                      ae.d(d.TAG, "Sensor Contact feature is supported and contact is detected");
                      paramBluetoothGattCharacteristic.nXQ.nXS = 2;
                    }
                    else
                    {
                      ae.d(d.TAG, "Sensor Contact feature is not supported in the current connection");
                      paramBluetoothGattCharacteristic.nXQ.nXS = 0;
                    }
                  }
                }
              }
              switch (paramArrayOfByte[0])
              {
              default: 
                paramBluetoothGattCharacteristic.nXP = "Unknown";
              }
              for (;;)
              {
                ae.d(d.TAG, "position=" + paramBluetoothGattCharacteristic.nXP);
                break;
                paramBluetoothGattCharacteristic.nXP = "Other";
                continue;
                paramBluetoothGattCharacteristic.nXP = "Chest";
                continue;
                paramBluetoothGattCharacteristic.nXP = "Wrist";
                continue;
                paramBluetoothGattCharacteristic.nXP = "Finger";
                continue;
                paramBluetoothGattCharacteristic.nXP = "Hand";
                continue;
                paramBluetoothGattCharacteristic.nXP = "Ear Lobe";
                continue;
                paramBluetoothGattCharacteristic.nXP = "Foot";
              }
            }
          }
          ae.e(TAG, "parse heart rate data error");
          paramBluetoothGattCharacteristic = null;
          break;
        }
        if ((0L != (0x8 & l)) && ((((String)localObject1).equalsIgnoreCase(b.nXj)) || (((String)localObject1).equalsIgnoreCase(b.nXk)) || (((String)localObject1).equalsIgnoreCase(b.nXl))))
        {
          paramBluetoothGattCharacteristic = new b();
          if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null))
          {
            ae.e(b.TAG, "characteristicUuid or data is null");
            i = j;
          }
          for (;;)
          {
            if (i != 0)
            {
              paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.cX(paramBluetoothGattCharacteristic);
              break;
              paramBluetoothGattCharacteristic.nXh = ((String)localObject1);
              k = paramArrayOfByte.length;
              if (paramBluetoothGattCharacteristic.nXh.equalsIgnoreCase(b.nXj))
              {
                if (k < 7)
                {
                  ae.e(b.TAG, "data len is not right.");
                  i = j;
                  continue;
                }
                paramBluetoothGattCharacteristic.nXr = new b.b(paramBluetoothGattCharacteristic);
                m = paramArrayOfByte[0];
                ae.d(b.TAG, "flag=".concat(String.valueOf(m)));
                if ((m & 0x1) != 0)
                {
                  ae.d(b.TAG, "the value unit is kPa.");
                  paramBluetoothGattCharacteristic.nXr.nXu = true;
                  paramBluetoothGattCharacteristic.nXr.nXB = b.M(paramArrayOfByte, 1);
                  paramBluetoothGattCharacteristic.nXr.nXC = b.M(paramArrayOfByte, 3);
                  paramBluetoothGattCharacteristic.nXr.nXD = b.M(paramArrayOfByte, 5);
                  i = 7;
                  if (((m & 0x2) == 0) || (k < 14)) {
                    break label2893;
                  }
                  ae.d(b.TAG, "TimeStamp Present.");
                  paramBluetoothGattCharacteristic.nXr.nXz.N(paramArrayOfByte, 7);
                  i = 14;
                  label2653:
                  if (((m & 0x4) == 0) || (k < i + 2)) {
                    break label2905;
                  }
                  ae.d(b.TAG, "PulseRate Present.");
                  paramBluetoothGattCharacteristic.nXr.nXw = ((int)b.M(paramArrayOfByte, i));
                  i += 2;
                  ae.d(b.TAG, "PulseRate =" + paramBluetoothGattCharacteristic.nXr.nXw);
                  if ((m & 0x8) == 0) {
                    break label2917;
                  }
                  ae.d(b.TAG, "UserId Present.");
                  localObject1 = paramBluetoothGattCharacteristic.nXr;
                  j = i + 1;
                  ((b.b)localObject1).nXx = paramArrayOfByte[i];
                  ae.d(b.TAG, "UserId = " + paramBluetoothGattCharacteristic.nXr.nXx);
                  i = j;
                  label2789:
                  if ((m & 0x10) == 0) {
                    break label2929;
                  }
                  ae.d(b.TAG, "MeasurementStatus Present.");
                  j = paramArrayOfByte[(i + 1)];
                  paramBluetoothGattCharacteristic.nXr.nXy = ((paramArrayOfByte[i] & 0xFF) + (j << 8 & 0xFF00 & 0xFF00));
                  ae.d(b.TAG, "MeasurementStatus = " + paramBluetoothGattCharacteristic.nXr.nXy);
                }
              }
              for (;;)
              {
                i = 1;
                break;
                ae.d(b.TAG, "the value unit is mmHg.");
                paramBluetoothGattCharacteristic.nXr.nXu = false;
                break label2574;
                ae.d(b.TAG, "TimeStamp not Present.");
                break label2653;
                label2905:
                ae.d(b.TAG, "PulseRate not Present.");
                break label2723;
                label2917:
                ae.d(b.TAG, "UserId not Present.");
                break label2789;
                label2929:
                ae.d(b.TAG, "MeasurementStatus not Present.");
                continue;
                if (paramBluetoothGattCharacteristic.nXh.equalsIgnoreCase(b.nXk))
                {
                  if (k < 3)
                  {
                    ae.e(b.TAG, "data len is not right.");
                    i = j;
                    break;
                  }
                  paramBluetoothGattCharacteristic.nXs = new b.a(paramBluetoothGattCharacteristic);
                  m = paramArrayOfByte[0];
                  ae.d(b.TAG, "flag=".concat(String.valueOf(m)));
                  if ((m & 0x1) != 0)
                  {
                    ae.d(b.TAG, "the value unit is kPa.");
                    paramBluetoothGattCharacteristic.nXs.nXu = true;
                    label3032:
                    paramBluetoothGattCharacteristic.nXs.nXv = b.M(paramArrayOfByte, 1);
                    if (((m & 0x2) == 0) || (k < 10)) {
                      break label3321;
                    }
                    ae.d(b.TAG, "TimeStamp Present.");
                    paramBluetoothGattCharacteristic.nXs.nXz.N(paramArrayOfByte, 3);
                    i = 10;
                    if (((m & 0x4) == 0) || (k < i + 2)) {
                      break label3335;
                    }
                    ae.d(b.TAG, "PulseRate Present.");
                    paramBluetoothGattCharacteristic.nXs.nXw = ((int)b.M(paramArrayOfByte, i));
                    i += 2;
                    ae.d(b.TAG, "PulseRate =" + paramBluetoothGattCharacteristic.nXs.nXw);
                    label3153:
                    if ((m & 0x8) == 0) {
                      break label3347;
                    }
                    ae.d(b.TAG, "UserId Present.");
                    localObject1 = paramBluetoothGattCharacteristic.nXs;
                    j = i + 1;
                    ((b.a)localObject1).nXx = paramArrayOfByte[i];
                    ae.d(b.TAG, "UserId = " + paramBluetoothGattCharacteristic.nXs.nXx);
                    i = j;
                  }
                  for (;;)
                  {
                    if ((m & 0x10) == 0) {
                      break label3359;
                    }
                    ae.d(b.TAG, "MeasurementStatus Present.");
                    j = paramArrayOfByte[(i + 1)];
                    paramBluetoothGattCharacteristic.nXs.nXy = ((paramArrayOfByte[i] & 0xFF) + (j << 8 & 0xFF00 & 0xFF00));
                    ae.d(b.TAG, "MeasurementStatus = " + paramBluetoothGattCharacteristic.nXs.nXy);
                    break;
                    ae.d(b.TAG, "the value unit is mmHg.");
                    paramBluetoothGattCharacteristic.nXs.nXu = false;
                    break label3032;
                    label3321:
                    ae.d(b.TAG, "TimeStamp not Present.");
                    i = 3;
                    break label3083;
                    ae.d(b.TAG, "PulseRate not Present.");
                    break label3153;
                    ae.d(b.TAG, "UserId not Present.");
                  }
                  ae.d(b.TAG, "MeasurementStatus not Present.");
                  continue;
                }
                if (paramBluetoothGattCharacteristic.nXh.equalsIgnoreCase(b.nXl))
                {
                  ae.d(b.TAG, "Blood Pressure Feature Characteristic.");
                  if (k < 2)
                  {
                    ae.e(b.TAG, "data len is not right.");
                    i = j;
                    break;
                  }
                  paramBluetoothGattCharacteristic.nXt = ((paramArrayOfByte[1] << 8 & 0xFF00 & 0xFF00) + (paramArrayOfByte[0] & 0xFF));
                  ae.d(b.TAG, "bloodPressureFeatureParameters=" + paramBluetoothGattCharacteristic.nXt);
                }
              }
            }
          }
          ae.e(TAG, "parse blood pressure data error");
          paramBluetoothGattCharacteristic = null;
          break;
        }
        if ((0L != (l & 0x10)) && ((((String)localObject1).equalsIgnoreCase(e.nXW)) || (((String)localObject1).equalsIgnoreCase(e.nXX)) || (((String)localObject1).equalsIgnoreCase(e.nXY)) || (((String)localObject1).equalsIgnoreCase(e.nXZ))))
        {
          paramBluetoothGattCharacteristic = new e();
          if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null))
          {
            ae.e(e.TAG, "characteristicUuid or data is null");
            i = k;
          }
          for (;;)
          {
            if (i == 0) {
              break label3877;
            }
            paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.cX(paramBluetoothGattCharacteristic);
            break;
            paramBluetoothGattCharacteristic.nXh = ((String)localObject1);
            if (paramBluetoothGattCharacteristic.nXh.equalsIgnoreCase(e.nXW))
            {
              if (paramArrayOfByte.length != 3)
              {
                ae.e(e.TAG, "Data length incorrect");
                i = k;
              }
              else
              {
                paramBluetoothGattCharacteristic.nYa = paramArrayOfByte[0];
                paramBluetoothGattCharacteristic.nYb = paramArrayOfByte[1];
                paramBluetoothGattCharacteristic.nYc = paramArrayOfByte[2];
              }
            }
            else
            {
              for (;;)
              {
                i = 1;
                break;
                if (paramBluetoothGattCharacteristic.nXh.equalsIgnoreCase(e.nXX))
                {
                  if (paramArrayOfByte.length != 1)
                  {
                    ae.e(e.TAG, "Data length incorrect");
                    i = k;
                    break;
                  }
                  paramBluetoothGattCharacteristic.nYd = paramArrayOfByte[0];
                  continue;
                }
                if (paramBluetoothGattCharacteristic.nXh.equalsIgnoreCase(e.nXY))
                {
                  if (paramArrayOfByte.length < 2)
                  {
                    ae.e(e.TAG, "Data length incorrect");
                    i = k;
                    break;
                  }
                  paramBluetoothGattCharacteristic.nYe[0] = paramArrayOfByte[0];
                  paramBluetoothGattCharacteristic.nYe[1] = paramArrayOfByte[1];
                  continue;
                }
                if (!paramBluetoothGattCharacteristic.nXh.equalsIgnoreCase(e.nXZ)) {
                  break label3862;
                }
                if (paramArrayOfByte.length < 4)
                {
                  ae.e(e.TAG, "Data length incorrect");
                  i = k;
                  break;
                }
                paramBluetoothGattCharacteristic.nYf = ((paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8));
                paramBluetoothGattCharacteristic.nYh = paramArrayOfByte[2];
                paramBluetoothGattCharacteristic.nYg = paramArrayOfByte[3];
                if (paramArrayOfByte.length > 4)
                {
                  paramBluetoothGattCharacteristic.nYi = new byte[paramArrayOfByte.length - 4];
                  System.arraycopy(paramArrayOfByte, 4, paramBluetoothGattCharacteristic.nYi, 0, paramArrayOfByte.length - 4);
                }
                else
                {
                  paramBluetoothGattCharacteristic.nYi = null;
                }
              }
              ae.e(e.TAG, "characteristicUuid is incorrect");
              i = k;
            }
          }
          ae.e(TAG, "parse light data error");
          paramBluetoothGattCharacteristic = null;
          break;
        }
        ae.e(TAG, "unknown characteristic uuid = %s", new Object[] { localObject1 });
        paramBluetoothGattCharacteristic = null;
        break;
      }
    }
  }
  
  public static boolean aH(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22573);
    if (bu.cF(paramArrayOfByte))
    {
      ae.e(TAG, "parseBroadcastServiceUuid error. broadcast data is null or nil");
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
        ae.w(TAG, "broadcast data len is not enough. offset = %d, current len = %d, broadcast len = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(paramArrayOfByte.length) });
        AppMethodBeat.o(22573);
        return false;
      }
      if (i <= 0)
      {
        ae.w(TAG, "current part of data's len = %d.", new Object[] { Integer.valueOf(i) });
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
          ae.d(TAG, "find 16-bit broacast service = %s", new Object[] { localObject });
          if (nWA.containsKey(localObject))
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
            ae.d(TAG, "find 128-bit broacast service = %s", new Object[] { localObject });
            boolean bool = nWA.containsKey(localObject);
            if (!bool) {
              break;
            }
            return true;
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
          {
            ae.e("BlueToothDeviceFilter.parseUUID", localIndexOutOfBoundsException.toString());
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
      ae.i(TAG, "Manufacturer Specific Data size = %s", new Object[] { Integer.valueOf(m) });
      ae.i(TAG, "Manufacturer Specific Data = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.bf(Arrays.copyOfRange(paramArrayOfByte, j, j + m)) });
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
      ae.e(TAG, "service is null");
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
        ae.e(TAG, "service is null");
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.nWP));
      if (localBluetoothGattCharacteristic == null)
      {
        ae.e(TAG, "no step measurement characteristic found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      ae.d(TAG, "step measurement characteristic properties = %d", new Object[] { Integer.valueOf(i) });
      if (((i & 0x30) == 0) || ((i & 0x2) == 0))
      {
        ae.e(TAG, "step measurement characteristic has incorrect proterties(%d)", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(22576);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.nWQ));
      if (paramBluetoothGattService != null)
      {
        i = paramBluetoothGattService.getProperties();
        if (((i & 0x2) == 0) || ((i & 0x20) == 0))
        {
          ae.e(TAG, "step target characteristic has incorrect proterties(%d)", new Object[] { Integer.valueOf(i) });
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
        ae.e(TAG, "service is null");
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.nWW));
      if (localBluetoothGattCharacteristic == null)
      {
        ae.e(TAG, "weight scale feature characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x2) == 0)
      {
        ae.e(TAG, "weight scale feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        AppMethodBeat.o(22576);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.nWX));
      if (paramBluetoothGattService == null)
      {
        ae.e(TAG, "weight measurement characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = paramBluetoothGattService.getProperties();
      if ((i & 0x20) == 0)
      {
        ae.e(TAG, "weight measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
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
        ae.e(TAG, "service is null");
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.nWZ));
      if (localBluetoothGattCharacteristic == null)
      {
        ae.e(TAG, "heart rate measurement characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x10) == 0)
      {
        ae.e(TAG, "heart rate measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(16) });
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.nXa));
      if (localBluetoothGattCharacteristic != null)
      {
        i = localBluetoothGattCharacteristic.getProperties();
        if ((i & 0x2) == 0)
        {
          ae.e(TAG, "heart rate body sensor location characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
          AppMethodBeat.o(22576);
          return false;
        }
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.nXb));
      if (paramBluetoothGattService != null)
      {
        i = paramBluetoothGattService.getProperties();
        if ((i & 0x8) == 0)
        {
          ae.e(TAG, "heart rate control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(8) });
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
        ae.e(TAG, "service is null");
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.nXd));
      if (localBluetoothGattCharacteristic == null)
      {
        ae.e(TAG, "blood pressure measurement characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x20) == 0)
      {
        ae.e(TAG, "blood pressure measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.nXf));
      if (localBluetoothGattCharacteristic == null)
      {
        ae.e(TAG, "blood pressure feature characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x2) == 0)
      {
        ae.e(TAG, "blood pressure feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        AppMethodBeat.o(22576);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.nXe));
      if (paramBluetoothGattService != null)
      {
        i = paramBluetoothGattService.getProperties();
        if ((i & 0x10) == 0)
        {
          ae.e(TAG, "blood pressure intermediate cuff pressure characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(16) });
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
        ae.e(TAG, "service is null");
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.nWR));
      if (localBluetoothGattCharacteristic == null)
      {
        ae.e(TAG, "light color characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if (((i & 0x20) == 0) || ((i & 0x10) == 0) || ((i & 0x2) == 0) || ((i & 0x8) == 0))
      {
        ae.e(TAG, "light color characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.nWS));
      if (localBluetoothGattCharacteristic == null)
      {
        ae.e(TAG, "light work state characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if (((i & 0x20) == 0) || ((i & 0x2) == 0) || ((i & 0x8) == 0))
      {
        ae.e(TAG, "light work state characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.nWT));
      if (localBluetoothGattCharacteristic == null)
      {
        ae.e(TAG, "light state changed characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x20) == 0)
      {
        ae.e(TAG, "light state changed characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.nWU));
      if (paramBluetoothGattService == null)
      {
        ae.e(TAG, "control point characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = paramBluetoothGattService.getProperties();
      if (((i & 0x20) == 0) || ((i & 0x8) == 0))
      {
        ae.e(TAG, "control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      AppMethodBeat.o(22576);
      return true;
    }
    AppMethodBeat.o(22576);
    return false;
  }
  
  public static String tu(long paramLong)
  {
    AppMethodBeat.i(22574);
    Object localObject = nWA.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (((Long)nWA.get(str)).longValue() == paramLong)
      {
        AppMethodBeat.o(22574);
        return str;
      }
    }
    if (nXH.containsValue(Long.valueOf(paramLong)))
    {
      localObject = h.nWM;
      AppMethodBeat.o(22574);
      return localObject;
    }
    AppMethodBeat.o(22574);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */