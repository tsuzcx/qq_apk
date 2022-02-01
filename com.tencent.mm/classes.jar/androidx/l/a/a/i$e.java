package androidx.l.a.a;

import android.graphics.Path;
import androidx.core.graphics.d;
import androidx.core.graphics.d.b;

abstract class i$e
  extends i.d
{
  protected d.b[] ciY = null;
  String ciZ;
  int mChangingConfigurations;
  
  public i$e()
  {
    super((byte)0);
  }
  
  public i$e(e parame)
  {
    super((byte)0);
    this.ciZ = parame.ciZ;
    this.mChangingConfigurations = parame.mChangingConfigurations;
    this.ciY = d.a(parame.ciY);
  }
  
  public boolean Mg()
  {
    return false;
  }
  
  public final void c(Path paramPath)
  {
    paramPath.reset();
    if (this.ciY != null) {
      d.b.a(this.ciY, paramPath);
    }
  }
  
  public d.b[] getPathData()
  {
    return this.ciY;
  }
  
  public String getPathName()
  {
    return this.ciZ;
  }
  
  public void setPathData(d.b[] paramArrayOfb)
  {
    if (!d.a(this.ciY, paramArrayOfb))
    {
      this.ciY = d.a(paramArrayOfb);
      return;
    }
    d.b(this.ciY, paramArrayOfb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.l.a.a.i.e
 * JD-Core Version:    0.7.0.1
 */