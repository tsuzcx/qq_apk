package com.github.henryye.nativeiv;

import android.util.SparseArray;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.b;
import java.util.HashMap;
import java.util.Map;

public enum a
{
  public Map<BitmapType, com.github.henryye.nativeiv.bitmap.a> asg = new HashMap(2);
  public SparseArray<Map<BitmapType, com.github.henryye.nativeiv.bitmap.a>> ash = new SparseArray();
  
  private a()
  {
    this.asg.put(BitmapType.Native, new a.1(this));
    this.asg.put(BitmapType.Legacy, new a.2(this));
    this.asg.put(BitmapType.Undefined, new com.github.henryye.nativeiv.bitmap.a()
    {
      public final boolean a(b paramAnonymousb)
      {
        return true;
      }
      
      public final IBitmap km()
      {
        return new b.a();
      }
    });
  }
  
  public static IBitmap a(b paramb, Map<BitmapType, com.github.henryye.nativeiv.bitmap.a> paramMap)
  {
    if (((com.github.henryye.nativeiv.bitmap.a)paramMap.get(BitmapType.Native)).a(paramb)) {
      return ((com.github.henryye.nativeiv.bitmap.a)paramMap.get(BitmapType.Native)).km();
    }
    if (((com.github.henryye.nativeiv.bitmap.a)paramMap.get(BitmapType.Legacy)).a(paramb)) {
      return ((com.github.henryye.nativeiv.bitmap.a)paramMap.get(BitmapType.Legacy)).km();
    }
    return ((com.github.henryye.nativeiv.bitmap.a)paramMap.get(BitmapType.Undefined)).km();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.github.henryye.nativeiv.a
 * JD-Core Version:    0.7.0.1
 */