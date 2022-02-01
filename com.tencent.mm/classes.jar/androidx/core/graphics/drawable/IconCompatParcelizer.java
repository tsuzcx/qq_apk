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
    AppMethodBeat.i(62496);
    IconCompat localIconCompat = new IconCompat();
    localIconCompat.mType = parama.aS(localIconCompat.mType, 1);
    localIconCompat.mData = parama.j(localIconCompat.mData);
    localIconCompat.Ho = parama.a(localIconCompat.Ho, 3);
    localIconCompat.Hp = parama.aS(localIconCompat.Hp, 4);
    localIconCompat.Hq = parama.aS(localIconCompat.Hq, 5);
    localIconCompat.Hr = ((ColorStateList)parama.a(localIconCompat.Hr, 6));
    localIconCompat.Hs = parama.L(localIconCompat.Hs);
    localIconCompat.vo = PorterDuff.Mode.valueOf(localIconCompat.Hs);
    switch (localIconCompat.mType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62496);
      return localIconCompat;
      if (localIconCompat.Ho != null)
      {
        localIconCompat.Hn = localIconCompat.Ho;
      }
      else
      {
        parama = new IllegalArgumentException("Invalid icon");
        AppMethodBeat.o(62496);
        throw parama;
        if (localIconCompat.Ho != null)
        {
          localIconCompat.Hn = localIconCompat.Ho;
        }
        else
        {
          localIconCompat.Hn = localIconCompat.mData;
          localIconCompat.mType = 3;
          localIconCompat.Hp = 0;
          localIconCompat.Hq = localIconCompat.mData.length;
          continue;
          localIconCompat.Hn = new String(localIconCompat.mData, Charset.forName("UTF-16"));
          continue;
          localIconCompat.Hn = localIconCompat.mData;
        }
      }
    }
  }
  
  public static void write(IconCompat paramIconCompat, a parama)
  {
    AppMethodBeat.i(62497);
    paramIconCompat.Hs = paramIconCompat.vo.name();
    switch (paramIconCompat.mType)
    {
    }
    for (;;)
    {
      parama.aR(paramIconCompat.mType, 1);
      parama.i(paramIconCompat.mData);
      parama.writeParcelable(paramIconCompat.Ho, 3);
      parama.aR(paramIconCompat.Hp, 4);
      parama.aR(paramIconCompat.Hq, 5);
      parama.writeParcelable(paramIconCompat.Hr, 6);
      parama.K(paramIconCompat.Hs);
      AppMethodBeat.o(62497);
      return;
      paramIconCompat.Ho = ((Parcelable)paramIconCompat.Hn);
      continue;
      paramIconCompat.Ho = ((Parcelable)paramIconCompat.Hn);
      continue;
      paramIconCompat.mData = paramIconCompat.Hn.toString().getBytes(Charset.forName("UTF-16"));
      continue;
      paramIconCompat.mData = ((String)paramIconCompat.Hn).getBytes(Charset.forName("UTF-16"));
      continue;
      paramIconCompat.mData = ((byte[])paramIconCompat.Hn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.graphics.drawable.IconCompatParcelizer
 * JD-Core Version:    0.7.0.1
 */