package c.t.m.g;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dz
  implements Cloneable
{
  public long a;
  private int b;
  private int c;
  private String d;
  private int e;
  
  @SuppressLint({"NewApi"})
  public static dz a(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramBluetoothDevice == null) {
      return null;
    }
    int k = 0;
    int i = 2;
    for (;;)
    {
      int j = k;
      if (i <= 5)
      {
        if (((paramArrayOfByte[(i + 2)] & 0xFF) == 2) && ((paramArrayOfByte[(i + 3)] & 0xFF) == 21)) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        dz localdz = new dz();
        localdz.b = (((paramArrayOfByte[(i + 20)] & 0xFF) << 8) + (paramArrayOfByte[(i + 21)] & 0xFF));
        localdz.c = (((paramArrayOfByte[(i + 22)] & 0xFF) << 8) + (paramArrayOfByte[(i + 23)] & 0xFF));
        localdz.e = paramInt;
        localdz.d = paramBluetoothDevice.getAddress().toUpperCase();
        paramBluetoothDevice.getName();
        localdz.a = System.currentTimeMillis();
        return localdz;
      }
      i += 1;
    }
  }
  
  public static String a(List<dz> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "[]";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    for (;;)
    {
      dz localdz;
      JSONObject localJSONObject;
      if (paramList.hasNext())
      {
        localdz = (dz)paramList.next();
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("mac", localdz.d);
        localJSONObject.put("major", localdz.b);
        localJSONObject.put("minor", localdz.c);
        localJSONObject.put("rssi", localdz.e);
        localJSONObject.put("time", localdz.a / 1000L);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException) {}
      return localJSONArray.toString();
    }
  }
  
  public final Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public final String toString()
  {
    return "Beacon [major=" + this.b + ", minor=" + this.c + ", bluetoothAddress=" + this.d + ", rssi=" + this.e + ", time=" + this.a + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     c.t.m.g.dz
 * JD-Core Version:    0.7.0.1
 */