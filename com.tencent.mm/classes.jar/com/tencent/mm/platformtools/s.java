package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface s
{
  public abstract Bitmap a(Bitmap paramBitmap, a parama, String paramString);
  
  public abstract void a(a parama);
  
  public abstract b bvp();
  
  public abstract String bvq();
  
  public abstract String bvr();
  
  public abstract String bvs();
  
  public abstract boolean bvt();
  
  public abstract Bitmap bvu();
  
  public abstract void bvv();
  
  public abstract void bvw();
  
  public abstract String getCacheKey();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(151381);
      mEp = new a("NET", 0);
      mEq = new a("DISK", 1);
      mEr = new a[] { mEp, mEq };
      AppMethodBeat.o(151381);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract Bitmap ZQ(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.s
 * JD-Core Version:    0.7.0.1
 */