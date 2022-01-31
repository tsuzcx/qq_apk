package com.tencent.mm.plugin.backup.h;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;

public final class a
{
  LinkedList<a.a> hMI = new LinkedList();
  public ah handler = new ah(Looper.getMainLooper());
  
  public final boolean f(int paramInt, Object paramObject)
  {
    this.handler.post(new a.1(this, paramInt, paramObject));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.a
 * JD-Core Version:    0.7.0.1
 */