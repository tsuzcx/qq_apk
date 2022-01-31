package com.tencent.mm.plugin.f.a.a;

import com.tencent.mm.sdk.platformtools.y;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Vector;
import junit.framework.Assert;

public final class d
{
  private final HashMap<c, Vector<Integer>> cJ = new HashMap();
  private b hTg = null;
  
  public d(b paramb)
  {
    this.hTg = paramb;
  }
  
  private void a(Vector<Integer> paramVector, c paramc)
  {
    y.i("MicroMsg.exdevie.IBeaconManager", "calDistance");
    Object localObject = new int[paramVector.size()];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i] = ((Integer)paramVector.elementAt(i)).intValue();
      i += 1;
    }
    paramVector = new a((int[])localObject);
    if (1 == paramVector.hTc.length)
    {
      y.d("MicroMsg.exdevice.GaussianFilter", "data group length = 1, no need to filter, just return");
      paramVector = paramVector.hTc;
    }
    while ((paramVector == null) || (paramVector.length == 0))
    {
      throw new NullPointerException("null == ret || 0 == ret.length");
      localObject = new StringBuilder("");
      ((StringBuilder)localObject).append("Data Before GaussianFilter \r\n");
      i = 0;
      while (i < paramVector.hTc.length)
      {
        ((StringBuilder)localObject).append(" " + paramVector.hTc[i]);
        i += 1;
      }
      y.d("MicroMsg.exdevice.GaussianFilter", ((StringBuilder)localObject).toString());
      d1 = i.i(paramVector.hTc);
      d2 = i.j(paramVector.hTc);
      d3 = i.g(0.15D, d2).add(new BigDecimal(d1)).doubleValue();
      double d4 = i.g(3.09D, d2).add(new BigDecimal(d1)).doubleValue();
      y.d("MicroMsg.exdevice.GaussianFilter", "Mean = " + d1 + "SD = " + d2 + "LowerLimit = " + d3 + " UpperLimit = " + d4);
      i = 0;
      localObject = new int[paramVector.hTc.length];
      int j = 0;
      while (j < paramVector.hTc.length)
      {
        int k = i;
        if (paramVector.hTc[j] >= d3)
        {
          k = i;
          if (paramVector.hTc[j] <= d4)
          {
            localObject[i] = paramVector.hTc[j];
            k = i + 1;
          }
        }
        j += 1;
        i = k;
      }
      if (i != 0) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        paramVector = new int[i];
        j = 0;
        while (j < i)
        {
          paramVector[j] = localObject[j];
          j += 1;
        }
      }
      localObject = new StringBuilder("");
      ((StringBuilder)localObject).append("Data After GaussianFilter \r\n");
      i = 0;
      while (i < paramVector.length)
      {
        ((StringBuilder)localObject).append(" " + paramVector[i]);
        i += 1;
      }
      y.d("MicroMsg.exdevice.GaussianFilter", ((StringBuilder)localObject).toString());
    }
    double d2 = i.i(paramVector);
    paramc.hTf = new BigDecimal(d2).divide(new BigDecimal(1), 3, 4).doubleValue();
    double d3 = paramc.hTe.hTi.hTM;
    double d1 = 1.0D * d2 / d3;
    if (d1 < 1.0D) {}
    for (d1 = Math.pow(d1, 10.0D);; d1 = Math.pow(d1, 9.9476D) * 0.92093D + 0.54992D)
    {
      y.i("MicroMsg.exdevie.IBeaconManager", "txPower = %f , rssi = %f,distance = %f", new Object[] { Double.valueOf(d3), Double.valueOf(d2), Double.valueOf(d1) });
      this.hTg.a(d1, paramc);
      return;
    }
  }
  
  public final void a(int paramInt, String paramString, e parame)
  {
    y.i("MicroMsg.exdevie.IBeaconManager", "advertismentProcess, brand = %s, rssi = %d", new Object[] { null, Integer.valueOf(paramInt) });
    if (parame == null) {
      y.e("MicroMsg.exdevie.IBeaconManager", "null == aProtocal");
    }
    c localc;
    do
    {
      return;
      localc = new c();
      localc.hTd = null;
      localc.hTe = parame;
      localc.btt = paramString;
      if (!this.cJ.containsKey(localc))
      {
        paramString = new Vector();
        paramString.add(Integer.valueOf(paramInt));
        this.cJ.put(localc, paramString);
        return;
      }
      paramString = (Vector)this.cJ.get(localc);
      paramString.add(Integer.valueOf(paramInt));
    } while (1 > paramString.size());
    try
    {
      a(paramString, localc);
      return;
    }
    catch (Exception parame)
    {
      y.e("MicroMsg.exdevie.IBeaconManager", "calDistance failed!!!, %s", new Object[] { parame.getMessage() });
      return;
    }
    finally
    {
      paramString.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.a.d
 * JD-Core Version:    0.7.0.1
 */