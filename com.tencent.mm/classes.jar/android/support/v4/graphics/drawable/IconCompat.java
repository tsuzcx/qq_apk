package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IconCompat
  extends CustomVersionedParcelable
{
  static final PorterDuff.Mode nL = PorterDuff.Mode.SRC_IN;
  public Object AS;
  public Parcelable AT;
  public int AU;
  public int AV;
  public ColorStateList AW = null;
  public String AX;
  public byte[] mData;
  public int mType;
  public PorterDuff.Mode oM = nL;
  
  private static String a(Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramIcon.getResPackage();
    }
    try
    {
      paramIcon = (String)paramIcon.getClass().getMethod("getResPackage", new Class[0]).invoke(paramIcon, new Object[0]);
      return paramIcon;
    }
    catch (IllegalAccessException paramIcon)
    {
      return null;
    }
    catch (InvocationTargetException paramIcon)
    {
      return null;
    }
    catch (NoSuchMethodException paramIcon) {}
    return null;
  }
  
  private static int b(Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramIcon.getResId();
    }
    try
    {
      int i = ((Integer)paramIcon.getClass().getMethod("getResId", new Class[0]).invoke(paramIcon, new Object[0])).intValue();
      return i;
    }
    catch (IllegalAccessException paramIcon)
    {
      return 0;
    }
    catch (InvocationTargetException paramIcon)
    {
      return 0;
    }
    catch (NoSuchMethodException paramIcon) {}
    return 0;
  }
  
  public String toString()
  {
    if (this.mType == -1) {
      return String.valueOf(this.AS);
    }
    StringBuilder localStringBuilder1 = new StringBuilder("Icon(typ=");
    Object localObject;
    switch (this.mType)
    {
    default: 
      localObject = "UNKNOWN";
      localStringBuilder1 = localStringBuilder1.append((String)localObject);
      switch (this.mType)
      {
      }
      break;
    }
    for (;;)
    {
      if (this.AW != null)
      {
        localStringBuilder1.append(" tint=");
        localStringBuilder1.append(this.AW);
      }
      if (this.oM != nL) {
        localStringBuilder1.append(" mode=").append(this.oM);
      }
      localStringBuilder1.append(")");
      return localStringBuilder1.toString();
      localObject = "BITMAP";
      break;
      localObject = "BITMAP_MASKABLE";
      break;
      localObject = "DATA";
      break;
      localObject = "RESOURCE";
      break;
      localObject = "URI";
      break;
      localStringBuilder1.append(" size=").append(((Bitmap)this.AS).getWidth()).append("x").append(((Bitmap)this.AS).getHeight());
      continue;
      StringBuilder localStringBuilder2 = localStringBuilder1.append(" pkg=");
      if ((this.mType == -1) && (Build.VERSION.SDK_INT >= 23))
      {
        localObject = a((Icon)this.AS);
        label277:
        localObject = localStringBuilder2.append((String)localObject).append(" id=");
        if ((this.mType != -1) || (Build.VERSION.SDK_INT < 23)) {
          break label384;
        }
      }
      for (int i = b((Icon)this.AS);; i = this.AU)
      {
        ((StringBuilder)localObject).append(String.format("0x%08x", new Object[] { Integer.valueOf(i) }));
        break;
        if (this.mType != 2) {
          throw new IllegalStateException("called getResPackage() on ".concat(String.valueOf(this)));
        }
        localObject = ((String)this.AS).split(":", -1)[0];
        break label277;
        label384:
        if (this.mType != 2) {
          throw new IllegalStateException("called getResId() on ".concat(String.valueOf(this)));
        }
      }
      localStringBuilder1.append(" len=").append(this.AU);
      if (this.AV != 0)
      {
        localStringBuilder1.append(" off=").append(this.AV);
        continue;
        localStringBuilder1.append(" uri=").append(this.AS);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.graphics.drawable.IconCompat
 * JD-Core Version:    0.7.0.1
 */