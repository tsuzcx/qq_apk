package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Parcelable;
import android.support.v4.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

public class IconCompatParcelizer
{
  public static IconCompat read(a parama)
  {
    AppMethodBeat.i(142954);
    IconCompat localIconCompat = new IconCompat();
    localIconCompat.mType = parama.aP(localIconCompat.mType, 1);
    localIconCompat.mData = parama.h(localIconCompat.mData);
    localIconCompat.AT = parama.a(localIconCompat.AT, 3);
    localIconCompat.AU = parama.aP(localIconCompat.AU, 4);
    localIconCompat.AV = parama.aP(localIconCompat.AV, 5);
    localIconCompat.AW = ((ColorStateList)parama.a(localIconCompat.AW, 6));
    localIconCompat.AX = parama.X(localIconCompat.AX);
    localIconCompat.oM = PorterDuff.Mode.valueOf(localIconCompat.AX);
    switch (localIconCompat.mType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(142954);
      return localIconCompat;
      if (localIconCompat.AT != null)
      {
        localIconCompat.AS = localIconCompat.AT;
      }
      else
      {
        parama = new IllegalArgumentException("Invalid icon");
        AppMethodBeat.o(142954);
        throw parama;
        if (localIconCompat.AT != null)
        {
          localIconCompat.AS = localIconCompat.AT;
        }
        else
        {
          localIconCompat.AS = localIconCompat.mData;
          localIconCompat.mType = 3;
          localIconCompat.AU = 0;
          localIconCompat.AV = localIconCompat.mData.length;
          continue;
          localIconCompat.AS = new String(localIconCompat.mData, Charset.forName("UTF-16"));
          continue;
          localIconCompat.AS = localIconCompat.mData;
        }
      }
    }
  }
  
  public static void write(IconCompat paramIconCompat, a parama)
  {
    AppMethodBeat.i(142955);
    paramIconCompat.AX = paramIconCompat.oM.name();
    switch (paramIconCompat.mType)
    {
    }
    for (;;)
    {
      parama.aO(paramIconCompat.mType, 1);
      parama.g(paramIconCompat.mData);
      parama.writeParcelable(paramIconCompat.AT, 3);
      parama.aO(paramIconCompat.AU, 4);
      parama.aO(paramIconCompat.AV, 5);
      parama.writeParcelable(paramIconCompat.AW, 6);
      parama.W(paramIconCompat.AX);
      AppMethodBeat.o(142955);
      return;
      paramIconCompat.AT = ((Parcelable)paramIconCompat.AS);
      continue;
      paramIconCompat.AT = ((Parcelable)paramIconCompat.AS);
      continue;
      paramIconCompat.mData = paramIconCompat.AS.toString().getBytes(Charset.forName("UTF-16"));
      continue;
      paramIconCompat.mData = ((String)paramIconCompat.AS).getBytes(Charset.forName("UTF-16"));
      continue;
      paramIconCompat.mData = ((byte[])paramIconCompat.AS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.core.graphics.drawable.IconCompatParcelizer
 * JD-Core Version:    0.7.0.1
 */