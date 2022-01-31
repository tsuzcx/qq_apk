package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;

public final class a
{
  public LinkedList<a> hMI = new LinkedList();
  ah handler = new ah(Looper.getMainLooper());
  
  public final boolean f(int paramInt, Object paramObject)
  {
    this.handler.post(new a.1(this, paramInt, paramObject));
    return true;
  }
  
  public final class a
  {
    public Object obj;
    public int type;
    
    public a(int paramInt, Object paramObject)
    {
      this.type = paramInt;
      this.obj = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.a
 * JD-Core Version:    0.7.0.1
 */