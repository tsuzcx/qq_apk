package com.tencent.mm.compatible.util;

import android.content.Context;
import com.tencent.mm.compatible.a.a;

public final class b
{
  b.b dzt = null;
  private final String dzu = "audio_lock";
  Context mContext = null;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    a.a(8, new b.1(this));
  }
  
  public final void a(b.a parama)
  {
    if (this.dzt != null) {
      this.dzt.a(parama);
    }
  }
  
  public final boolean requestFocus()
  {
    try
    {
      if (this.dzt == null) {
        return false;
      }
      boolean bool = this.dzt.requestFocus();
      return bool;
    }
    finally {}
  }
  
  public final boolean zE()
  {
    try
    {
      if (this.dzt == null) {
        return false;
      }
      boolean bool = this.dzt.zE();
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.util.b
 * JD-Core Version:    0.7.0.1
 */